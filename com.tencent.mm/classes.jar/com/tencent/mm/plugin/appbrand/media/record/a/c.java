package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class c
  implements d
{
  String nef = "audio/mp4a-latm";
  String neg = "audio/mpeg";
  d.a neh = null;
  int nei = 0;
  int nej = 0;
  byte[] nek;
  int nel = 0;
  
  public final void a(d.a parama)
  {
    this.neh = parama;
  }
  
  public boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    return false;
  }
  
  public void close() {}
  
  public final void d(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146344);
    if (this.neh == null)
    {
      Log.e("MicroMsg.Record.AudioEncoder", "mEncodeListener is null, return");
      AppMethodBeat.o(146344);
      return;
    }
    if (this.nej == 0.0D)
    {
      Log.e("MicroMsg.Record.AudioEncoder", "no frameSize, return");
      AppMethodBeat.o(146344);
      return;
    }
    if (paramInt > this.nej) {
      Log.w("MicroMsg.Record.AudioEncoder", "buffSize:%d frameSize:%d, buffSize > frameSize ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.nej) });
    }
    Log.d("MicroMsg.Record.AudioEncoder", "bufferedSize:%d, buffSize:%d", new Object[] { Integer.valueOf(this.nel), Integer.valueOf(paramInt) });
    int i = this.nel + paramInt;
    if ((i >= this.nej) && (paramArrayOfByte != null))
    {
      Log.d("MicroMsg.Record.AudioEncoder", "flush all, currentBufferedSize:%d", new Object[] { Integer.valueOf(i) });
      if (i > this.nek.length)
      {
        Log.i("MicroMsg.Record.AudioEncoder", "expand the end codeBuffer:%d", new Object[] { Integer.valueOf(i) });
        byte[] arrayOfByte = this.nek;
        this.nek = new byte[i];
        System.arraycopy(arrayOfByte, 0, this.nek, 0, this.nel);
      }
      System.arraycopy(paramArrayOfByte, 0, this.nek, this.nel, paramInt);
      this.neh.c(this.nek, i, false);
      this.nel = 0;
    }
    for (;;)
    {
      if (paramBoolean)
      {
        Log.i("MicroMsg.Record.AudioEncoder", "isEnd is true, flush the buffer, bufferedSize:%d", new Object[] { Integer.valueOf(this.nel) });
        this.neh.c(this.nek, this.nel, paramBoolean);
        this.nel = 0;
      }
      AppMethodBeat.o(146344);
      return;
      if (paramArrayOfByte != null)
      {
        System.arraycopy(paramArrayOfByte, 0, this.nek, this.nel, paramInt);
        this.nel = i;
        Log.d("MicroMsg.Record.AudioEncoder", "append buff, currentBufferedSize:%d", new Object[] { Integer.valueOf(this.nel) });
      }
    }
  }
  
  public void flush() {}
  
  public boolean i(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  public final void r(double paramDouble)
  {
    AppMethodBeat.i(146343);
    this.nej = ((int)(1024.0D * paramDouble));
    Log.i("MicroMsg.Record.AudioEncoder", "setEncodeBuffFrameSize frameKbSize:%b frameByteSize:%d", new Object[] { Double.valueOf(paramDouble), Integer.valueOf(this.nej) });
    this.nek = new byte[this.nej];
    AppMethodBeat.o(146343);
  }
  
  public final void yA(int paramInt)
  {
    AppMethodBeat.i(146342);
    Log.i("MicroMsg.Record.AudioEncoder", "mMinBufferSize:%d", new Object[] { Integer.valueOf(this.nei) });
    this.nei = paramInt;
    AppMethodBeat.o(146342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.c
 * JD-Core Version:    0.7.0.1
 */