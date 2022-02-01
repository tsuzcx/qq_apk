package com.qq.wx.voice.embed.recognizer;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  byte[] c;
  public Grammar cgs;
  g cgt;
  public boolean d;
  public boolean e;
  
  public e()
  {
    AppMethodBeat.i(76756);
    this.cgs = null;
    this.cgt = new g();
    this.c = null;
    this.d = false;
    this.e = false;
    this.cgs = new Grammar();
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
    this.cgt.cgu = paramc;
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
      if (e.this.cgs.begin() != 0)
      {
        e.this.cgt.a(-102);
        AppMethodBeat.o(76755);
        return;
      }
      if (e.this.cgs.recognize(e.this.c, e.this.c.length) != 0)
      {
        e.this.cgt.a(-103);
        AppMethodBeat.o(76755);
        return;
      }
      if (e.this.cgs.end() != 0)
      {
        e.this.cgt.a(-104);
        AppMethodBeat.o(76755);
        return;
      }
      a locala = new a();
      if (e.this.cgs.getResult(locala) != 0) {
        e.this.cgt.a(-105);
      }
      g localg = e.this.cgt;
      localg.b.sendMessage(localg.b.obtainMessage(200, locala));
      AppMethodBeat.o(76755);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.qq.wx.voice.embed.recognizer.e
 * JD-Core Version:    0.7.0.1
 */