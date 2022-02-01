package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class t
  extends r
{
  public t(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void bAq()
  {
    AppMethodBeat.i(136475);
    try
    {
      aj.dn(this).restartInput(this);
      AppMethodBeat.o(136475);
      return;
    }
    catch (RuntimeException localRuntimeException1)
    {
      ac.e("Luggage.Wxa.AppBrandInputWidgetSingleLineWithSoftKeyboard", "ensureInputConnection restartInput re=%s", new Object[] { localRuntimeException1 });
      try
      {
        aj.dn(this).showSoftInput(this, 0);
        AppMethodBeat.o(136475);
        return;
      }
      catch (RuntimeException localRuntimeException2)
      {
        ac.e("Luggage.Wxa.AppBrandInputWidgetSingleLineWithSoftKeyboard", "ensureInputConnection showSoftInput re=%s", new Object[] { localRuntimeException2 });
        AppMethodBeat.o(136475);
      }
    }
  }
  
  public final View getInputPanel()
  {
    AppMethodBeat.i(136473);
    w localw = w.di(this);
    AppMethodBeat.o(136473);
    return localw;
  }
  
  public final void setPasswordMode(boolean paramBoolean)
  {
    AppMethodBeat.i(136474);
    bAK();
    int i = getInputType() | 0x1;
    if (paramBoolean) {
      i |= 0x80;
    }
    for (;;)
    {
      setInputType(i);
      super.setPasswordMode(paramBoolean);
      bAL();
      AppMethodBeat.o(136474);
      return;
      i &= 0xFFFFFF7F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.t
 * JD-Core Version:    0.7.0.1
 */