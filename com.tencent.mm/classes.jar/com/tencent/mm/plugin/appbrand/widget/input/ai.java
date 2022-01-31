package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public enum ai
{
  static final Class hwh;
  
  static
  {
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
        y.e("MicroMsg.AppBrand.InputUtil", "class for ComposingText e = %s", new Object[] { localClassNotFoundException });
      }
    }
    hwh = localObject;
  }
  
  static boolean be(Object paramObject)
  {
    return hwh.isInstance(paramObject);
  }
  
  static InputMethodManager cs(View paramView)
  {
    if (paramView != null)
    {
      Context localContext = paramView.getContext();
      paramView = localContext;
      if (localContext != null) {}
    }
    else
    {
      paramView = ae.getContext();
    }
    return (InputMethodManager)paramView.getSystemService("input_method");
  }
  
  static boolean f(Boolean paramBoolean)
  {
    return (paramBoolean != null) && (paramBoolean.booleanValue());
  }
  
  static Spannable r(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      paramCharSequence = "";
    }
    for (;;)
    {
      if ((paramCharSequence instanceof Spannable)) {
        return (Spannable)paramCharSequence;
      }
      return new SpannableStringBuilder(paramCharSequence);
    }
  }
  
  public static boolean s(CharSequence paramCharSequence)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramCharSequence instanceof Spanned))
    {
      paramCharSequence = (Spanned)paramCharSequence;
      paramCharSequence = paramCharSequence.getSpans(0, paramCharSequence.length(), hwh);
      bool1 = bool2;
      if (paramCharSequence != null)
      {
        bool1 = bool2;
        if (paramCharSequence.length > 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ai
 * JD-Core Version:    0.7.0.1
 */