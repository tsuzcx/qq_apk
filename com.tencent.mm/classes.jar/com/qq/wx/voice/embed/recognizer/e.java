package com.qq.wx.voice.embed.recognizer;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  byte[] c;
  public boolean d;
  public Grammar dYS;
  g dYT;
  public boolean e;
  
  public e()
  {
    AppMethodBeat.i(76756);
    this.dYS = null;
    this.dYT = new g();
    this.c = null;
    this.d = false;
    this.e = false;
    this.dYS = new Grammar();
    AppMethodBeat.o(76756);
  }
  
  public final int a(c paramc, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(76757);
    if (!this.d)
    {
      AppMethodBeat.o(76757);
      return -304;
    }
    if (!this.e)
    {
      AppMethodBeat.o(76757);
      return -302;
    }
    this.dYT.dYU = paramc;
    this.c = paramArrayOfByte;
    if (this.c == null)
    {
      AppMethodBeat.o(76757);
      return -301;
    }
    try
    {
      new Thread(new a((byte)0)).start();
      AppMethodBeat.o(76757);
      return 0;
    }
    catch (Exception paramc)
    {
      AppMethodBeat.o(76757);
    }
    return -302;
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(76755);
      if (e.this.dYS.begin() != 0)
      {
        e.this.dYT.a(-102);
        AppMethodBeat.o(76755);
        return;
      }
      if (e.this.dYS.recognize(e.this.c, e.this.c.length) != 0)
      {
        e.this.dYT.a(-103);
        AppMethodBeat.o(76755);
        return;
      }
      if (e.this.dYS.end() != 0)
      {
        e.this.dYT.a(-104);
        AppMethodBeat.o(76755);
        return;
      }
      a locala = new a();
      if (e.this.dYS.getResult(locala) != 0) {
        e.this.dYT.a(-105);
      }
      g localg = e.this.dYT;
      localg.b.sendMessage(localg.b.obtainMessage(200, locala));
      AppMethodBeat.o(76755);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.qq.wx.voice.embed.recognizer.e
 * JD-Core Version:    0.7.0.1
 */