package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Locale;
import org.a.a;

public enum aj
{
  static final Class ngF;
  
  static
  {
    AppMethodBeat.i(136598);
    ngG = new aj[0];
    Object localObject = null;
    try
    {
      Class localClass = Class.forName("android.view.inputmethod.ComposingText");
      localObject = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppBrand.InputUtil", "class for ComposingText e = %s", new Object[] { localClassNotFoundException });
      }
    }
    ngF = localObject;
    AppMethodBeat.o(136598);
  }
  
  static Spannable E(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(136590);
    if (paramCharSequence == null) {
      paramCharSequence = "";
    }
    for (;;)
    {
      if ((paramCharSequence instanceof Spannable))
      {
        paramCharSequence = (Spannable)paramCharSequence;
        AppMethodBeat.o(136590);
        return paramCharSequence;
      }
      paramCharSequence = new SpannableStringBuilder(paramCharSequence);
      AppMethodBeat.o(136590);
      return paramCharSequence;
    }
  }
  
  public static boolean F(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(136591);
    if ((paramCharSequence instanceof Spanned))
    {
      paramCharSequence = (Spanned)paramCharSequence;
      paramCharSequence = paramCharSequence.getSpans(0, paramCharSequence.length(), ngF);
      if ((paramCharSequence != null) && (paramCharSequence.length > 0))
      {
        AppMethodBeat.o(136591);
        return true;
      }
      AppMethodBeat.o(136591);
      return false;
    }
    AppMethodBeat.o(136591);
    return false;
  }
  
  static boolean cN(Object paramObject)
  {
    AppMethodBeat.i(136592);
    boolean bool = ngF.isInstance(paramObject);
    AppMethodBeat.o(136592);
    return bool;
  }
  
  public static InputMethodManager dp(View paramView)
  {
    AppMethodBeat.i(136593);
    if (paramView != null)
    {
      Context localContext = paramView.getContext();
      paramView = localContext;
      if (localContext != null) {}
    }
    else
    {
      paramView = com.tencent.mm.sdk.platformtools.aj.getContext();
    }
    paramView = (InputMethodManager)paramView.getSystemService("input_method");
    AppMethodBeat.o(136593);
    return paramView;
  }
  
  public static void dq(View paramView)
  {
    AppMethodBeat.i(136594);
    if (Build.VERSION.SDK_INT >= 30)
    {
      ad.w("MicroMsg.AppBrand.InputUtil", "dumpImmDebugInfo skip >=30");
      AppMethodBeat.o(136594);
      return;
    }
    Object localObject = dp(paramView);
    if (localObject == null) {
      paramView = "NULL Imm";
    }
    for (;;)
    {
      ad.i("MicroMsg.AppBrand.InputUtil", "dumpImmDebugInfo: %s", new Object[] { paramView });
      AppMethodBeat.o(136594);
      return;
      try
      {
        paramView = (View)a.gy(localObject).get("mServedView");
        localObject = (View)a.gy(localObject).get("mNextServedView");
        paramView = String.format(Locale.US, "mServedView=%s, mNextServedView=%s", new Object[] { paramView, localObject });
      }
      catch (Exception paramView)
      {
        ad.e("MicroMsg.AppBrand.InputUtil", "dumpImmDebugInfo reflect failed %s", new Object[] { paramView });
        AppMethodBeat.o(136594);
      }
    }
  }
  
  public static boolean h(View paramView1, View paramView2)
  {
    AppMethodBeat.i(136595);
    if ((paramView1 == null) || (paramView2 == null))
    {
      AppMethodBeat.o(136595);
      return false;
    }
    paramView2 = paramView2.getParent();
    ViewParent localViewParent;
    do
    {
      if (paramView1 == paramView2)
      {
        AppMethodBeat.o(136595);
        return true;
      }
      localViewParent = paramView2.getParent();
      paramView2 = localViewParent;
    } while (localViewParent != null);
    AppMethodBeat.o(136595);
    return false;
  }
  
  public static boolean i(Boolean paramBoolean)
  {
    AppMethodBeat.i(136596);
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      AppMethodBeat.o(136596);
      return true;
    }
    AppMethodBeat.o(136596);
    return false;
  }
  
  static int j(Integer paramInteger)
  {
    AppMethodBeat.i(136597);
    if (paramInteger != null)
    {
      int i = paramInteger.intValue();
      AppMethodBeat.o(136597);
      return i;
    }
    AppMethodBeat.o(136597);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.aj
 * JD-Core Version:    0.7.0.1
 */