package com.qq.wx.voice.embed.recognizer;

import android.os.Handler;

final class e$a
  implements Runnable
{
  private e$a(e parame) {}
  
  public final void run()
  {
    if (this.aVp.aVw.begin() != 0)
    {
      this.aVp.aVx.a(-102);
      return;
    }
    if (this.aVp.aVw.recognize(this.aVp.c, this.aVp.c.length) != 0)
    {
      this.aVp.aVx.a(-103);
      return;
    }
    if (this.aVp.aVw.end() != 0)
    {
      this.aVp.aVx.a(-104);
      return;
    }
    a locala = new a();
    if (this.aVp.aVw.getResult(locala) != 0) {
      this.aVp.aVx.a(-105);
    }
    g localg = this.aVp.aVx;
    localg.b.sendMessage(localg.b.obtainMessage(200, locala));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.qq.wx.voice.embed.recognizer.e.a
 * JD-Core Version:    0.7.0.1
 */