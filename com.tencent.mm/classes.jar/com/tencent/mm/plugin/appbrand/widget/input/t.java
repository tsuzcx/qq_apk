package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class t
  extends r
{
  public t(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void aQZ()
  {
    AppMethodBeat.i(123740);
    try
    {
      aj.cV(this).restartInput(this);
      AppMethodBeat.o(123740);
      return;
    }
    catch (RuntimeException localRuntimeException1)
    {
      ab.e("Luggage.Wxa.AppBrandInputWidgetSingleLineWithSoftKeyboard", "ensureInputConnection restartInput re=%s", new Object[] { localRuntimeException1 });
      try
      {
        aj.cV(this).showSoftInput(this, 0);
        AppMethodBeat.o(123740);
        return;
      }
      catch (RuntimeException localRuntimeException2)
      {
        ab.e("Luggage.Wxa.AppBrandInputWidgetSingleLineWithSoftKeyboard", "ensureInputConnection showSoftInput re=%s", new Object[] { localRuntimeException2 });
        AppMethodBeat.o(123740);
      }
    }
  }
  
  public final View getInputPanel()
  {
    AppMethodBeat.i(123738);
    w localw = w.cQ(this);
    AppMethodBeat.o(123738);
    return localw;
  }
  
  public final void setPasswordMode(boolean paramBoolean)
  {
    AppMethodBeat.i(123739);
    aRu();
    int i = getInputType() | 0x1;
    if (paramBoolean) {
      i |= 0x80;
    }
    for (;;)
    {
      setInputType(i);
      super.setPasswordMode(paramBoolean);
      aRv();
      AppMethodBeat.o(123739);
      return;
      i &= 0xFFFFFF7F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.t
 * JD-Core Version:    0.7.0.1
 */