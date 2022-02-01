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
    this.arA.setInputMethodMode(2);
    paramContext = paramContext.getResources().getDrawable(2131230807);
    this.arA.setBackgroundDrawable(paramContext);
    this.arz = true;
    this.arA.setFocusable(false);
    this.ark = false;
    this.arl = true;
    this.arA.setAnimationStyle(2130772001);
    AppMethodBeat.o(136645);
  }
  
  public final void show()
  {
    AppMethodBeat.i(136646);
    super.show();
    AppMethodBeat.o(136646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.e
 * JD-Core Version:    0.7.0.1
 */