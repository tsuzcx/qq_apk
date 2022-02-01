package com.bumptech.glide.load.a;

import com.bumptech.glide.load.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public final class c
  extends OutputStream
{
  private b aCo;
  private byte[] buffer;
  private int index;
  private final OutputStream out;
  
  public c(OutputStream paramOutputStream, b paramb)
  {
    this(paramOutputStream, paramb, (byte)0);
  }
  
  private c(OutputStream paramOutputStream, b paramb, byte paramByte)
  {
    AppMethodBeat.i(76865);
    this.out = paramOutputStream;
    this.aCo = paramb;
    this.buffer = ((byte[])paramb.a(65536, [B.class));
    AppMethodBeat.o(76865);
  }
  
  private void flushBuffer()
  {
    AppMethodBeat.i(76870);
    if (this.index > 0)
    {
      this.out.write(this.buffer, 0, this.index);
      this.index = 0;
    }
    AppMethodBeat.o(76870);
  }
  
  private void ou()
  {
    AppMethodBeat.i(76871);
    if (this.index == this.buffer.length) {
      flushBuffer();
    }
    AppMethodBeat.o(76871);
  }
  
  public final void close()
  {
    AppMethodBeat.i(76872);
    try
    {
      flush();
      this.out.close();
      if (this.buffer != null)
      {
        this.aCo.put(this.buffer);
        this.buffer = null;
      }
      AppMethodBeat.o(76872);
      return;
    }
    finally
    {
      this.out.close();
      AppMethodBeat.o(76872);
    }
  }
  
  public final void flush()
  {
    AppMethodBeat.i(76869);
    flushBuffer();
    this.out.flush();
    AppMethodBeat.o(76869);
  }
  
  public final void write(int paramInt)
  {
    AppMethodBeat.i(76866);
    byte[] arrayOfByte = this.buffer;
    int i = this.index;
    this.index = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    ou();
    AppMethodBeat.o(76866);
  }
  
  public final void write(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(76867);
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(76867);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76868);
    int i = 0;
    int j;
    do
    {
      int k = paramInt2 - i;
      j = paramInt1 + i;
      if ((this.index == 0) && (k >= this.buffer.length))
      {
        this.out.write(paramArrayOfByte, j, k);
        AppMethodBeat.o(76868);
        return;
      }
      k = Math.min(k, this.buffer.length - this.index);
      System.arraycopy(paramArrayOfByte, j, this.buffer, this.index, k);
      this.index += k;
      j = i + k;
      ou();
      i = j;
    } while (j < paramInt2);
    AppMethodBeat.o(76868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.a.c
 * JD-Core Version:    0.7.0.1
 */