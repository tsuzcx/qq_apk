package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.Filter.FilterListener;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$5
  implements Filter.FilterListener
{
  b$5(b paramb) {}
  
  public final void onFilterComplete(int paramInt)
  {
    AppMethodBeat.i(123886);
    if (paramInt <= 0)
    {
      this.jpd.joV.dismiss();
      AppMethodBeat.o(123886);
      return;
    }
    if (this.jpd.joV.aht.isShowing()) {
      this.jpd.joV.show();
    }
    AppMethodBeat.o(123886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.b.5
 * JD-Core Version:    0.7.0.1
 */