package com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$a
  implements Runnable
{
  private e$a(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(139998);
    if (this.bIY.bIW != null) {
      this.bIY.bIW.ye();
    }
    if (this.bIY.bIT) {
      yg();
    }
    AppMethodBeat.o(139998);
  }
  
  final void yg()
  {
    AppMethodBeat.i(139999);
    this.bIY.bIV.postDelayed(this.bIY.bIX, this.bIY.bIU);
    AppMethodBeat.o(139999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a.e.a
 * JD-Core Version:    0.7.0.1
 */