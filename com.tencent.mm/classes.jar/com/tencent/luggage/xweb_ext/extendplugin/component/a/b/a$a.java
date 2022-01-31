package com.tencent.luggage.xweb_ext.extendplugin.component.a.b;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$a
  implements Runnable
{
  int bGN;
  int number = 0;
  
  a$a(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(139800);
    this.number += 1;
    int i = a.getRotationAngle();
    if (i == this.bGN)
    {
      this.bGK.fz(i);
      AppMethodBeat.o(139800);
      return;
    }
    if (this.number < 8) {
      this.bGK.mHandler.postDelayed(this, 250L);
    }
    AppMethodBeat.o(139800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */