package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class c
  implements d
{
  int rfg = 0;
  String tjl = "audio/mp4a-latm";
  String tjm = "audio/mpeg";
  d.a tjn = null;
  int tjo = 0;
  int tjp = 0;
  byte[] tjq;
  
  public final void Cp(int paramInt)
  {
    AppMethodBeat.i(146342);
    Log.i("MicroMsg.Record.AudioEncoder", "mMinBufferSize:%d", new Object[] { Integer.valueOf(this.tjo) });
    this.tjo = paramInt;
    AppMethodBeat.o(146342);
  }
  
  public final void I(double paramDouble)
  {
    AppMethodBeat.i(146343);
    this.tjp = ((int)(1024.0D * paramDouble));
    Log.i("MicroMsg.Record.AudioEncoder", "setEncodeBuffFrameSize frameKbSize:%b frameByteSize:%d", new Object[] { Double.valueOf(paramDouble), Integer.valueOf(this.tjp) });
    this.tjq = new byte[this.tjp];
    AppMethodBeat.o(146343);
  }
  
  public final void a(d.a parama)
  {
    this.tjn = parama;
  }
  
  public boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    return false;
  }
  
  public void close() {}
  
  public final void d(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146344);
    if (this.tjn == null)
    {
      Log.e("MicroMsg.Record.AudioEncoder", "mEncodeListener is null, return");
      AppMethodBeat.o(146344);
      return;
    }
    if (this.tjp == 0.0D)
    {
      Log.e("MicroMsg.Record.AudioEncoder", "no frameSize, return");
      AppMethodBeat.o(146344);
      return;
    }
    if (paramInt > this.tjp) {
      Log.w("MicroMsg.Record.AudioEncoder", "buffSize:%d frameSize:%d, buffSize > frameSize ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.tjp) });
    }
    Log.d("MicroMsg.Record.AudioEncoder", "bufferedSize:%d, buffSize:%d", new Object[] { Integer.valueOf(this.rfg), Integer.valueOf(paramInt) });
    int i = this.rfg + paramInt;
    if ((i >= this.tjp) && (paramArrayOfByte != null))
    {
      Log.d("MicroMsg.Record.AudioEncoder", "flush all, currentBufferedSize:%d", new Object[] { Integer.valueOf(i) });
      if (i > this.tjq.length)
      {
        Log.i("MicroMsg.Record.AudioEncoder", "expand the end codeBuffer:%d", new Object[] { Integer.valueOf(i) });
        byte[] arrayOfByte = this.tjq;
        this.tjq = new byte[i];
        System.arraycopy(arrayOfByte, 0, this.tjq, 0, this.rfg);
      }
      System.arraycopy(paramArrayOfByte, 0, this.tjq, this.rfg, paramInt);
      this.tjn.c(this.tjq, i, false);
      this.rfg = 0;
    }
    for (;;)
    {
      if (paramBoolean)
      {
        Log.i("MicroMsg.Record.AudioEncoder", "isEnd is true, flush the buffer, bufferedSize:%d", new Object[] { Integer.valueOf(this.rfg) });
        this.tjn.c(this.tjq, this.rfg, paramBoolean);
        this.rfg = 0;
      }
      AppMethodBeat.o(146344);
      return;
      if (paramArrayOfByte != null)
      {
        System.arraycopy(paramArrayOfByte, 0, this.tjq, this.rfg, paramInt);
        this.rfg = i;
        Log.d("MicroMsg.Record.AudioEncoder", "append buff, currentBufferedSize:%d", new Object[] { Integer.valueOf(this.rfg) });
      }
    }
  }
  
  public void flush() {}
  
  public boolean j(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.c
 * JD-Core Version:    0.7.0.1
 */