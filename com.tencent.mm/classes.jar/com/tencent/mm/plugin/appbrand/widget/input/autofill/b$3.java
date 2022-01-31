package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$3
  implements View.OnFocusChangeListener
{
  b$3(b paramb) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(123883);
    if (paramBoolean)
    {
      this.jpd.aRD();
      AppMethodBeat.o(123883);
      return;
    }
    paramView = this.jpd;
    if (paramView.joV.aht.isShowing())
    {
      g localg = (g)paramView.joV.jpo.getAdapter();
      paramView.joV.dismiss();
      localg.aRB();
    }
    AppMethodBeat.o(123883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.b.3
 * JD-Core Version:    0.7.0.1
 */