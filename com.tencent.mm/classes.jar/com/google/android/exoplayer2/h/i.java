package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class i
  extends InputStream
{
  private final g aBo;
  private final j aQI;
  private final byte[] aYv;
  long aYw;
  private boolean closed;
  private boolean opened;
  
  public i(g paramg, j paramj)
  {
    AppMethodBeat.i(95795);
    this.opened = false;
    this.closed = false;
    this.aBo = paramg;
    this.aQI = paramj;
    this.aYv = new byte[1];
    AppMethodBeat.o(95795);
  }
  
  public final void close()
  {
    AppMethodBeat.i(95799);
    if (!this.closed)
    {
      this.aBo.close();
      this.closed = true;
    }
    AppMethodBeat.o(95799);
  }
  
  final void qo()
  {
    AppMethodBeat.i(95800);
    if (!this.opened)
    {
      this.aBo.a(this.aQI);
      this.opened = true;
    }
    AppMethodBeat.o(95800);
  }
  
  public final int read()
  {
    AppMethodBeat.i(95796);
    if (read(this.aYv) == -1)
    {
      AppMethodBeat.o(95796);
      return -1;
    }
    int i = this.aYv[0];
    AppMethodBeat.o(95796);
    return i & 0xFF;
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95797);
    int i = read(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(95797);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95798);
    if (!this.closed) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      qo();
      paramInt1 = this.aBo.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 != -1) {
        break;
      }
      AppMethodBeat.o(95798);
      return -1;
    }
    this.aYw += paramInt1;
    AppMethodBeat.o(95798);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.h.i
 * JD-Core Version:    0.7.0.1
 */