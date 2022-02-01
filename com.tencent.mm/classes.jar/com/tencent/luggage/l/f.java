package com.tencent.luggage.l;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public final class f
{
  public static boolean bv(Context paramContext)
  {
    AppMethodBeat.i(140517);
    if (paramContext == null)
    {
      AppMethodBeat.o(140517);
      return false;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(140517);
      return false;
    }
    paramContext = AndroidContextUtil.castActivityOrNull(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(140517);
      return false;
    }
    paramContext = paramContext.getCurrentFocus();
    if (paramContext == null)
    {
      AppMethodBeat.o(140517);
      return false;
    }
    paramContext = paramContext.getWindowToken();
    if (paramContext == null)
    {
      AppMethodBeat.o(140517);
      return false;
    }
    try
    {
      bool = localInputMethodManager.hideSoftInputFromWindow(paramContext, 0);
      AppMethodBeat.o(140517);
      return bool;
    }
    catch (IllegalArgumentException paramContext)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.l.f
 * JD-Core Version:    0.7.0.1
 */