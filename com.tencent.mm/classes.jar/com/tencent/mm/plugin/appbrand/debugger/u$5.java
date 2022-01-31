package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class u$5
  implements Runnable
{
  u$5(u paramu) {}
  
  public final void run()
  {
    AppMethodBeat.i(101920);
    if (u.e(this.hmM).ayX())
    {
      u.f(this.hmM).setImageResource(2130837771);
      u.g(this.hmM).setText(this.hmM.getContext().getString(2131296827));
    }
    for (;;)
    {
      u.h(this.hmM);
      AppMethodBeat.o(101920);
      return;
      if (u.e(this.hmM).isReady())
      {
        u.f(this.hmM).setImageResource(2130837771);
        u.g(this.hmM).setText(this.hmM.getContext().getString(2131296828));
      }
      else
      {
        u.f(this.hmM).setImageResource(2130837770);
        u.g(this.hmM).setText(this.hmM.getContext().getString(2131296826));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.u.5
 * JD-Core Version:    0.7.0.1
 */