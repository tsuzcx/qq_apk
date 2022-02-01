package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.RelativeSizeSpan;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Method;

 enum aj$a
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
    aj.dp(paramEditText).hideSoftInputFromInputMethod(paramEditText.getWindowToken(), 0);
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
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", new Object[] { bt.n(localException) });
        if ((paramEditText.getContext() != null) && ((paramEditText.getContext() instanceof ad))) {
          ((ad)paramEditText.getContext()).hideVKB(paramEditText);
        }
        AppMethodBeat.o(136586);
        return;
      }
    }
    catch (Exception paramEditText)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", new Object[] { bt.n(paramEditText) });
      AppMethodBeat.o(136586);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.aj.a
 * JD-Core Version:    0.7.0.1
 */