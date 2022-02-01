package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class c
  implements d
{
  int qeA = 0;
  byte[] qeB;
  int qeC = 0;
  String qew = "audio/mp4a-latm";
  String qex = "audio/mpeg";
  d.a qey = null;
  int qez = 0;
  
  public final void Ca(int paramInt)
  {
    AppMethodBeat.i(146342);
    Log.i("MicroMsg.Record.AudioEncoder", "mMinBufferSize:%d", new Object[] { Integer.valueOf(this.qez) });
    this.qez = paramInt;
    AppMethodBeat.o(146342);
  }
  
  public final void a(d.a parama)
  {
    this.qey = parama;
  }
  
  public boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    return false;
  }
  
  public void close() {}
  
  public final void d(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146344);
    if (this.qey == null)
    {
      Log.e("MicroMsg.Record.AudioEncoder", "mEncodeListener is null, return");
      AppMethodBeat.o(146344);
      return;
    }
    if (this.qeA == 0.0D)
    {
      Log.e("MicroMsg.Record.AudioEncoder", "no frameSize, return");
      AppMethodBeat.o(146344);
      return;
    }
    if (paramInt > this.qeA) {
      Log.w("MicroMsg.Record.AudioEncoder", "buffSize:%d frameSize:%d, buffSize > frameSize ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.qeA) });
    }
    Log.d("MicroMsg.Record.AudioEncoder", "bufferedSize:%d, buffSize:%d", new Object[] { Integer.valueOf(this.qeC), Integer.valueOf(paramInt) });
    int i = this.qeC + paramInt;
    if ((i >= this.qeA) && (paramArrayOfByte != null))
    {
      Log.d("MicroMsg.Record.AudioEncoder", "flush all, currentBufferedSize:%d", new Object[] { Integer.valueOf(i) });
      if (i > this.qeB.length)
      {
        Log.i("MicroMsg.Record.AudioEncoder", "expand the end codeBuffer:%d", new Object[] { Integer.valueOf(i) });
        byte[] arrayOfByte = this.qeB;
        this.qeB = new byte[i];
        System.arraycopy(arrayOfByte, 0, this.qeB, 0, this.qeC);
      }
      System.arraycopy(paramArrayOfByte, 0, this.qeB, this.qeC, paramInt);
      this.qey.c(this.qeB, i, false);
      this.qeC = 0;
    }
    for (;;)
    {
      if (paramBoolean)
      {
        Log.i("MicroMsg.Record.AudioEncoder", "isEnd is true, flush the buffer, bufferedSize:%d", new Object[] { Integer.valueOf(this.qeC) });
        this.qey.c(this.qeB, this.qeC, paramBoolean);
        this.qeC = 0;
      }
      AppMethodBeat.o(146344);
      return;
      if (paramArrayOfByte != null)
      {
        System.arraycopy(paramArrayOfByte, 0, this.qeB, this.qeC, paramInt);
        this.qeC = i;
        Log.d("MicroMsg.Record.AudioEncoder", "append buff, currentBufferedSize:%d", new Object[] { Integer.valueOf(this.qeC) });
      }
    }
  }
  
  public void flush() {}
  
  public boolean j(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  public final void r(double paramDouble)
  {
    AppMethodBeat.i(146343);
    this.qeA = ((int)(1024.0D * paramDouble));
    Log.i("MicroMsg.Record.AudioEncoder", "setEncodeBuffFrameSize frameKbSize:%b frameByteSize:%d", new Object[] { Double.valueOf(paramDouble), Integer.valueOf(this.qeA) });
    this.qeB = new byte[this.qeA];
    AppMethodBeat.o(146343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.c
 * JD-Core Version:    0.7.0.1
 */