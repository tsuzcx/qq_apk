package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import android.content.res.Resources;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends AutoFillListPopupWindowBase
{
  private final Context mContext;
  
  e(Context paramContext)
  {
    super(paramContext, null, 0);
    AppMethodBeat.i(123905);
    this.mContext = paramContext;
    this.aht.setInputMethodMode(2);
    paramContext = paramContext.getResources().getDrawable(2130837574);
    this.aht.setBackgroundDrawable(paramContext);
    this.ahs = true;
    this.aht.setFocusable(false);
    this.ahe = false;
    this.ahf = true;
    this.aht.setAnimationStyle(2131034136);
    AppMethodBeat.o(123905);
  }
  
  public final void show()
  {
    AppMethodBeat.i(123906);
    super.show();
    AppMethodBeat.o(123906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.e
 * JD-Core Version:    0.7.0.1
 */