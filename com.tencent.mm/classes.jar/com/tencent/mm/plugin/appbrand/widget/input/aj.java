package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Locale;
import org.a.a;

public enum aj
{
  static final Class jot;
  
  static
  {
    AppMethodBeat.i(123857);
    jou = new aj[0];
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
        ab.e("MicroMsg.AppBrand.InputUtil", "class for ComposingText e = %s", new Object[] { localClassNotFoundException });
      }
    }
    jot = localObject;
    AppMethodBeat.o(123857);
  }
  
  static Spannable A(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(123850);
    if (paramCharSequence == null) {
      paramCharSequence = "";
    }
    for (;;)
    {
      if ((paramCharSequence instanceof Spannable))
      {
        paramCharSequence = (Spannable)paramCharSequence;
        AppMethodBeat.o(123850);
        return paramCharSequence;
      }
      paramCharSequence = new SpannableStringBuilder(paramCharSequence);
      AppMethodBeat.o(123850);
      return paramCharSequence;
    }
  }
  
  public static boolean B(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(123851);
    if ((paramCharSequence instanceof Spanned))
    {
      paramCharSequence = (Spanned)paramCharSequence;
      paramCharSequence = paramCharSequence.getSpans(0, paramCharSequence.length(), jot);
      if ((paramCharSequence != null) && (paramCharSequence.length > 0))
      {
        AppMethodBeat.o(123851);
        return true;
      }
      AppMethodBeat.o(123851);
      return false;
    }
    AppMethodBeat.o(123851);
    return false;
  }
  
  static boolean bB(Object paramObject)
  {
    AppMethodBeat.i(123852);
    boolean bool = jot.isInstance(paramObject);
    AppMethodBeat.o(123852);
    return bool;
  }
  
  public static InputMethodManager cV(View paramView)
  {
    AppMethodBeat.i(123853);
    if (paramView != null)
    {
      Context localContext = paramView.getContext();
      paramView = localContext;
      if (localContext != null) {}
    }
    else
    {
      paramView = ah.getContext();
    }
    paramView = (InputMethodManager)paramView.getSystemService("input_method");
    AppMethodBeat.o(123853);
    return paramView;
  }
  
  public static void cW(View paramView)
  {
    AppMethodBeat.i(123854);
    Object localObject = cV(paramView);
    if (localObject == null) {}
    for (paramView = "NULL Imm";; paramView = String.format(Locale.US, "mServedView=%s, mNextServedView=%s", new Object[] { paramView, localObject }))
    {
      ab.i("MicroMsg.AppBrand.InputUtil", "dumpImmDebugInfo: %s", new Object[] { paramView });
      AppMethodBeat.o(123854);
      return;
      paramView = (View)a.ep(localObject).get("mServedView");
      localObject = (View)a.ep(localObject).get("mNextServedView");
    }
  }
  
  public static boolean f(View paramView1, View paramView2)
  {
    AppMethodBeat.i(123855);
    if ((paramView1 == null) || (paramView2 == null))
    {
      AppMethodBeat.o(123855);
      return false;
    }
    paramView2 = paramView2.getParent();
    ViewParent localViewParent;
    do
    {
      if (paramView1 == paramView2)
      {
        AppMethodBeat.o(123855);
        return true;
      }
      localViewParent = paramView2.getParent();
      paramView2 = localViewParent;
    } while (localViewParent != null);
    AppMethodBeat.o(123855);
    return false;
  }
  
  public static boolean g(Boolean paramBoolean)
  {
    AppMethodBeat.i(123856);
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      AppMethodBeat.o(123856);
      return true;
    }
    AppMethodBeat.o(123856);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.aj
 * JD-Core Version:    0.7.0.1
 */