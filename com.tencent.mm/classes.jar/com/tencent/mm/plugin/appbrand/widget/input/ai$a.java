package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.RelativeSizeSpan;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Method;

 enum ai$a
{
  static int a(EditText paramEditText, float paramFloat1, float paramFloat2)
  {
    if (paramEditText == null) {
      return -1;
    }
    int j = paramEditText.getPaddingTop();
    Layout localLayout = paramEditText.getLayout();
    if (localLayout == null) {
      return -1;
    }
    Editable localEditable = paramEditText.getEditableText();
    if (localEditable == null) {
      return -1;
    }
    paramEditText = paramEditText.getPaint();
    if (paramEditText == null) {
      return -1;
    }
    Rect localRect = new Rect();
    int i = 0;
    while (i < localLayout.getLineCount())
    {
      localLayout.getLineBounds(i, localRect);
      int k = j + localRect.height();
      if (k >= paramFloat2)
      {
        int m = localLayout.getLineStart(i);
        int n = localLayout.getLineEnd(i);
        Object localObject = (RelativeSizeSpan[])localEditable.getSpans(m, n, RelativeSizeSpan.class);
        float f2 = 1.0F;
        float f1 = f2;
        if (localObject != null)
        {
          int i1 = localObject.length;
          j = 0;
          f1 = f2;
          while (j < i1)
          {
            f1 = localObject[j].getSizeChange();
            j += 1;
          }
        }
        localObject = localEditable.subSequence(m, n).toString();
        float[] arrayOfFloat = new float[((String)localObject).length()];
        paramEditText.getTextWidths((String)localObject, arrayOfFloat);
        f2 = 0.0F;
        j = 0;
        while (j < ((String)localObject).length())
        {
          f2 += arrayOfFloat[j] * f1;
          if ((f2 >= paramFloat1) || (j == ((String)localObject).length() - 1)) {
            return m + j;
          }
          j += 1;
        }
      }
      i += 1;
      j = k;
    }
    return -1;
  }
  
  static void c(EditText paramEditText)
  {
    if (paramEditText == null) {
      return;
    }
    ai.cs(paramEditText).hideSoftInputFromInputMethod(paramEditText.getWindowToken(), 2);
  }
  
  static void setNoSystemInputOnEditText(EditText paramEditText)
  {
    if (paramEditText == null) {}
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramEditText.setShowSoftInputOnFocus(false);
        return;
      }
      try
      {
        Method localMethod1 = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[] { Boolean.TYPE });
        localMethod1.setAccessible(true);
        localMethod1.invoke(paramEditText, new Object[] { Boolean.valueOf(false) });
        localMethod1.setAccessible(false);
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        y.i("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        try
        {
          Method localMethod2 = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[] { Boolean.TYPE });
          localMethod2.setAccessible(true);
          localMethod2.invoke(paramEditText, new Object[] { Boolean.valueOf(false) });
          localMethod2.setAccessible(false);
          return;
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", new Object[] { bk.j(localException) });
        }
        if ((paramEditText.getContext() != null) && ((paramEditText.getContext() instanceof ac)))
        {
          ((ac)paramEditText.getContext()).hideVKB(paramEditText);
          return;
        }
      }
      catch (Exception paramEditText)
      {
        y.e("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", new Object[] { bk.j(paramEditText) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ai.a
 * JD-Core Version:    0.7.0.1
 */