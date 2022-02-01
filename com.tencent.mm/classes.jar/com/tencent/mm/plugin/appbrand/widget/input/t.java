package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class t
  extends r
{
  public t(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void coJ()
  {
    AppMethodBeat.i(136475);
    try
    {
      an.dB(this).restartInput(this);
      AppMethodBeat.o(136475);
      return;
    }
    catch (RuntimeException localRuntimeException1)
    {
      Log.e("Luggage.Wxa.AppBrandInputWidgetSingleLineWithSoftKeyboard", "ensureInputConnection restartInput re=%s", new Object[] { localRuntimeException1 });
      try
      {
        an.dB(this).showSoftInput(this, 0);
        AppMethodBeat.o(136475);
        return;
      }
      catch (RuntimeException localRuntimeException2)
      {
        Log.e("Luggage.Wxa.AppBrandInputWidgetSingleLineWithSoftKeyboard", "ensureInputConnection showSoftInput re=%s", new Object[] { localRuntimeException2 });
        AppMethodBeat.o(136475);
      }
    }
  }
  
  public final View getInputPanel()
  {
    AppMethodBeat.i(136473);
    aa localaa = aa.dw(this);
    AppMethodBeat.o(136473);
    return localaa;
  }
  
  public final void setPasswordMode(boolean paramBoolean)
  {
    AppMethodBeat.i(136474);
    cpf();
    int i = getInputType() | 0x1;
    if (paramBoolean) {
      i |= 0x80;
    }
    for (;;)
    {
      setInputType(i);
      super.setPasswordMode(paramBoolean);
      cpg();
      AppMethodBeat.o(136474);
      return;
      i &= 0xFFFFFF7F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.t
 * JD-Core Version:    0.7.0.1
 */