package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class t
  extends r
{
  public t(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void btq()
  {
    AppMethodBeat.i(136475);
    try
    {
      aj.dl(this).restartInput(this);
      AppMethodBeat.o(136475);
      return;
    }
    catch (RuntimeException localRuntimeException1)
    {
      ad.e("Luggage.Wxa.AppBrandInputWidgetSingleLineWithSoftKeyboard", "ensureInputConnection restartInput re=%s", new Object[] { localRuntimeException1 });
      try
      {
        aj.dl(this).showSoftInput(this, 0);
        AppMethodBeat.o(136475);
        return;
      }
      catch (RuntimeException localRuntimeException2)
      {
        ad.e("Luggage.Wxa.AppBrandInputWidgetSingleLineWithSoftKeyboard", "ensureInputConnection showSoftInput re=%s", new Object[] { localRuntimeException2 });
        AppMethodBeat.o(136475);
      }
    }
  }
  
  public final View getInputPanel()
  {
    AppMethodBeat.i(136473);
    w localw = w.dg(this);
    AppMethodBeat.o(136473);
    return localw;
  }
  
  public final void setPasswordMode(boolean paramBoolean)
  {
    AppMethodBeat.i(136474);
    btL();
    int i = getInputType() | 0x1;
    if (paramBoolean) {
      i |= 0x80;
    }
    for (;;)
    {
      setInputType(i);
      super.setPasswordMode(paramBoolean);
      btM();
      AppMethodBeat.o(136474);
      return;
      i &= 0xFFFFFF7F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.t
 * JD-Core Version:    0.7.0.1
 */