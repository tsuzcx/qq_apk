package com.qq.wx.voice.embed.recognizer;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$a
  implements Runnable
{
  private e$a(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(123210);
    if (this.blX.bme.begin() != 0)
    {
      this.blX.bmf.a(-102);
      AppMethodBeat.o(123210);
      return;
    }
    if (this.blX.bme.recognize(this.blX.c, this.blX.c.length) != 0)
    {
      this.blX.bmf.a(-103);
      AppMethodBeat.o(123210);
      return;
    }
    if (this.blX.bme.end() != 0)
    {
      this.blX.bmf.a(-104);
      AppMethodBeat.o(123210);
      return;
    }
    a locala = new a();
    if (this.blX.bme.getResult(locala) != 0) {
      this.blX.bmf.a(-105);
    }
    g localg = this.blX.bmf;
    localg.b.sendMessage(localg.b.obtainMessage(200, locala));
    AppMethodBeat.o(123210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.qq.wx.voice.embed.recognizer.e.a
 * JD-Core Version:    0.7.0.1
 */