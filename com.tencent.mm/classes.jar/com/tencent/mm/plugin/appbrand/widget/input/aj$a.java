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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Method;

 enum aj$a
{
  static int a(EditText paramEditText, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(123847);
    int j = paramEditText.getPaddingTop();
    Layout localLayout = paramEditText.getLayout();
    if (localLayout == null)
    {
      AppMethodBeat.o(123847);
      return -1;
    }
    Editable localEditable = paramEditText.getEditableText();
    if (localEditable == null)
    {
      AppMethodBeat.o(123847);
      return -1;
    }
    paramEditText = paramEditText.getPaint();
    if (paramEditText == null)
    {
      AppMethodBeat.o(123847);
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
        AppMethodBeat.o(123847);
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
          AppMethodBeat.o(123847);
          return i + n;
        }
        if ((f2 >= paramFloat1) || (j == ((String)localObject).length() - 1))
        {
          AppMethodBeat.o(123847);
          return n + j;
        }
        j += 1;
      }
      i += 1;
      j = m;
      break;
      AppMethodBeat.o(123847);
      return -1;
    }
  }
  
  static void c(EditText paramEditText)
  {
    AppMethodBeat.i(123845);
    if (paramEditText == null)
    {
      AppMethodBeat.o(123845);
      return;
    }
    aj.cV(paramEditText).hideSoftInputFromInputMethod(paramEditText.getWindowToken(), 2);
    AppMethodBeat.o(123845);
  }
  
  static void setNoSystemInputOnEditText(EditText paramEditText)
  {
    AppMethodBeat.i(123846);
    if (paramEditText == null)
    {
      AppMethodBeat.o(123846);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramEditText.setShowSoftInputOnFocus(false);
      AppMethodBeat.o(123846);
      return;
    }
    try
    {
      Method localMethod1 = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[] { Boolean.TYPE });
      localMethod1.setAccessible(true);
      localMethod1.invoke(paramEditText, new Object[] { Boolean.FALSE });
      localMethod1.setAccessible(false);
      AppMethodBeat.o(123846);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      ab.i("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      try
      {
        Method localMethod2 = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[] { Boolean.TYPE });
        localMethod2.setAccessible(true);
        localMethod2.invoke(paramEditText, new Object[] { Boolean.FALSE });
        localMethod2.setAccessible(false);
        AppMethodBeat.o(123846);
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", new Object[] { bo.l(localException) });
        if ((paramEditText.getContext() != null) && ((paramEditText.getContext() instanceof ad))) {
          ((ad)paramEditText.getContext()).hideVKB(paramEditText);
        }
        AppMethodBeat.o(123846);
        return;
      }
    }
    catch (Exception paramEditText)
    {
      ab.e("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", new Object[] { bo.l(paramEditText) });
      AppMethodBeat.o(123846);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.aj.a
 * JD-Core Version:    0.7.0.1
 */