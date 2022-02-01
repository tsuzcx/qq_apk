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
    AppMethodBeat.i(136645);
    this.mContext = paramContext;
    this.aoA.setInputMethodMode(2);
    paramContext = paramContext.getResources().getDrawable(2131230797);
    this.aoA.setBackgroundDrawable(paramContext);
    this.aoz = true;
    this.aoA.setFocusable(false);
    this.aol = false;
    this.aom = true;
    this.aoA.setAnimationStyle(2130771996);
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