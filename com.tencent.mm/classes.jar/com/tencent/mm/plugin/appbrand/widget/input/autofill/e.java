package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import android.content.res.Resources;
import android.widget.PopupWindow;
import com.tencent.luggage.wxa.b.a.a;
import com.tencent.luggage.wxa.b.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends AutoFillListPopupWindowBase
{
  private final Context mContext;
  
  e(Context paramContext)
  {
    super(paramContext, null, 0);
    AppMethodBeat.i(136645);
    this.mContext = paramContext;
    this.ty.setInputMethodMode(2);
    paramContext = paramContext.getResources().getDrawable(a.d.abc_popup_background_mtrl_mult);
    this.ty.setBackgroundDrawable(paramContext);
    cpv();
    cpx();
    cpw();
    int i = a.a.appbrand_autofill_dropdown;
    this.ty.setAnimationStyle(i);
    AppMethodBeat.o(136645);
  }
  
  public final void show()
  {
    AppMethodBeat.i(136646);
    super.show();
    AppMethodBeat.o(136646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.e
 * JD-Core Version:    0.7.0.1
 */