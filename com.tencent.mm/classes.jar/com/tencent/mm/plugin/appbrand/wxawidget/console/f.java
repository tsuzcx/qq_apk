package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class f
{
  public static boolean da(View paramView)
  {
    AppMethodBeat.i(11172);
    if (paramView == null)
    {
      AppMethodBeat.o(11172);
      return false;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)paramView.getContext().getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(11172);
      return false;
    }
    paramView = paramView.getWindowToken();
    if (paramView == null)
    {
      AppMethodBeat.o(11172);
      return false;
    }
    try
    {
      bool = localInputMethodManager.hideSoftInputFromWindow(paramView, 0);
      AppMethodBeat.o(11172);
      return bool;
    }
    catch (IllegalArgumentException paramView)
    {
      for (;;)
      {
        ab.e("MicroMsg.InputMethodHelper", "hide VKB(View) exception %s", new Object[] { paramView });
        boolean bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.f
 * JD-Core Version:    0.7.0.1
 */