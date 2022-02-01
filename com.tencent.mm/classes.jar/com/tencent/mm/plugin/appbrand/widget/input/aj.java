package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Method;
import java.util.Locale;
import org.a.a;

public enum aj
{
  static final Class mei;
  
  static
  {
    AppMethodBeat.i(136598);
    mej = new aj[0];
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
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrand.InputUtil", "class for ComposingText e = %s", new Object[] { localClassNotFoundException });
      }
    }
    mei = localObject;
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
      paramCharSequence = paramCharSequence.getSpans(0, paramCharSequence.length(), mei);
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
  
  static boolean cM(Object paramObject)
  {
    AppMethodBeat.i(136592);
    boolean bool = mei.isInstance(paramObject);
    AppMethodBeat.o(136592);
    return bool;
  }
  
  public static InputMethodManager dl(View paramView)
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
  
  public static void dm(View paramView)
  {
    AppMethodBeat.i(136594);
    if (Build.VERSION.SDK_INT >= 30)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.InputUtil", "dumpImmDebugInfo skip >=30");
      AppMethodBeat.o(136594);
      return;
    }
    Object localObject = dl(paramView);
    if (localObject == null) {
      paramView = "NULL Imm";
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.InputUtil", "dumpImmDebugInfo: %s", new Object[] { paramView });
      AppMethodBeat.o(136594);
      return;
      try
      {
        paramView = (View)a.fU(localObject).get("mServedView");
        localObject = (View)a.fU(localObject).get("mNextServedView");
        paramView = String.format(Locale.US, "mServedView=%s, mNextServedView=%s", new Object[] { paramView, localObject });
      }
      catch (Exception paramView)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrand.InputUtil", "dumpImmDebugInfo reflect failed %s", new Object[] { paramView });
        AppMethodBeat.o(136594);
      }
    }
  }
  
  public static boolean g(Boolean paramBoolean)
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
  
  static enum a
  {
    static int a(EditText paramEditText, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(136587);
      int j = paramEditText.getPaddingTop();
      Layout localLayout = paramEditText.getLayout();
      if (localLayout == null)
      {
        AppMethodBeat.o(136587);
        return -1;
      }
      Editable localEditable = paramEditText.getEditableText();
      if (localEditable == null)
      {
        AppMethodBeat.o(136587);
        return -1;
      }
      paramEditText = paramEditText.getPaint();
      if (paramEditText == null)
      {
        AppMethodBeat.o(136587);
        return -1;
      }
      Rect localRect = new Rect();
      int i = 0;
      int m;
      int n;
      if (i < localLayout.getLineCount())
      {
        localLayout.getLineBounds(i, localRect);
        m = j + localRect.height();
        if (m >= paramFloat2)
        {
          n = localLayout.getLineStart(i);
          j = localLayout.getLineEnd(i);
          if (i == localLayout.getLineCount() - 1) {
            break label394;
          }
          j = Math.max(j - 1, n);
        }
      }
      label394:
      for (;;)
      {
        if (n == j)
        {
          AppMethodBeat.o(136587);
          return n;
        }
        Object localObject = (RelativeSizeSpan[])localEditable.getSpans(n, j, RelativeSizeSpan.class);
        float f2 = 1.0F;
        float f1 = f2;
        if (localObject != null)
        {
          int i1 = localObject.length;
          int k = 0;
          f1 = f2;
          while (k < i1)
          {
            f1 = localObject[k].getSizeChange();
            k += 1;
          }
        }
        localObject = localEditable.subSequence(n, j).toString();
        float[] arrayOfFloat = new float[((String)localObject).length()];
        paramEditText.getTextWidths((String)localObject, arrayOfFloat);
        f2 = 0.0F;
        j = 0;
        while (j < ((String)localObject).length())
        {
          f2 += arrayOfFloat[j] * f1;
          if ((j == ((String)localObject).length() - 1) && (paramFloat1 >= f2))
          {
            i = ((String)localObject).length();
            AppMethodBeat.o(136587);
            return i + n;
          }
          if ((f2 >= paramFloat1) || (j == ((String)localObject).length() - 1))
          {
            AppMethodBeat.o(136587);
            return n + j;
          }
          j += 1;
        }
        i += 1;
        j = m;
        break;
        AppMethodBeat.o(136587);
        return -1;
      }
    }
    
    static void c(EditText paramEditText)
    {
      AppMethodBeat.i(136585);
      if (paramEditText == null)
      {
        AppMethodBeat.o(136585);
        return;
      }
      aj.dl(paramEditText).hideSoftInputFromInputMethod(paramEditText.getWindowToken(), 0);
      AppMethodBeat.o(136585);
    }
    
    static void setNoSystemInputOnEditText(EditText paramEditText)
    {
      AppMethodBeat.i(136586);
      if (paramEditText == null)
      {
        AppMethodBeat.o(136586);
        return;
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramEditText.setShowSoftInputOnFocus(false);
        AppMethodBeat.o(136586);
        return;
      }
      try
      {
        Method localMethod1 = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[] { Boolean.TYPE });
        localMethod1.setAccessible(true);
        localMethod1.invoke(paramEditText, new Object[] { Boolean.FALSE });
        localMethod1.setAccessible(false);
        AppMethodBeat.o(136586);
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        try
        {
          Method localMethod2 = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[] { Boolean.TYPE });
          localMethod2.setAccessible(true);
          localMethod2.invoke(paramEditText, new Object[] { Boolean.FALSE });
          localMethod2.setAccessible(false);
          AppMethodBeat.o(136586);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", new Object[] { bt.m(localException) });
          if ((paramEditText.getContext() != null) && ((paramEditText.getContext() instanceof ad))) {
            ((ad)paramEditText.getContext()).hideVKB(paramEditText);
          }
          AppMethodBeat.o(136586);
          return;
        }
      }
      catch (Exception paramEditText)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", new Object[] { bt.m(paramEditText) });
        AppMethodBeat.o(136586);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.aj
 * JD-Core Version:    0.7.0.1
 */