package com.tencent.mm.plugin.appbrand.debugger;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class u$3
  implements View.OnClickListener
{
  u$3(u paramu) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(101918);
    u localu = this.hmM;
    if (paramView.getId() == 2131821376)
    {
      localu.hmJ = true;
      localu.show();
      paramView = localu.hmx;
      paramView.postDelayed(new RemoteDebugMoveView.3(paramView), 50L);
      AppMethodBeat.o(101918);
      return;
    }
    if (paramView.getId() == 2131821385)
    {
      localu.hmJ = false;
      localu.show();
      AppMethodBeat.o(101918);
      return;
    }
    if (paramView.getId() == 2131821384) {
      localu.azt();
    }
    AppMethodBeat.o(101918);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.u.3
 * JD-Core Version:    0.7.0.1
 */