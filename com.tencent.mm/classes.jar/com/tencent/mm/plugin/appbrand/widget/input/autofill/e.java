package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import android.content.res.Resources;
import android.widget.PopupWindow;
import com.tencent.luggage.l.a.a.a;
import com.tencent.luggage.l.a.a.c;

public final class e
  extends AutoFillListPopupWindowBase
{
  private final Context mContext;
  
  e(Context paramContext)
  {
    super(paramContext, null, 0);
    this.mContext = paramContext;
    this.afe.setInputMethodMode(2);
    paramContext = paramContext.getResources().getDrawable(a.c.abc_popup_background_mtrl_mult);
    this.afe.setBackgroundDrawable(paramContext);
    this.afd = true;
    this.afe.setFocusable(false);
    this.aeP = false;
    this.aeQ = true;
    int i = a.a.appbrand_autofill_dropdown;
    this.afe.setAnimationStyle(i);
  }
  
  public final void show()
  {
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.e
 * JD-Core Version:    0.7.0.1
 */