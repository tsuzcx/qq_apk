package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandNumberKeyboardView$2
  implements View.OnClickListener
{
  AppBrandNumberKeyboardView$2(AppBrandNumberKeyboardView paramAppBrandNumberKeyboardView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(123756);
    if (AppBrandNumberKeyboardView.a(this.jmX) == null)
    {
      AppMethodBeat.o(123756);
      return;
    }
    String str1 = null;
    String str2;
    if (paramView.getId() == AppBrandNumberKeyboardView.a(this.jmX, "tenpay_keyboard_x")) {
      switch (AppBrandNumberKeyboardView.b(this.jmX))
      {
      default: 
        AppMethodBeat.o(123756);
        return;
      case 1: 
        str2 = "X";
      }
    }
    int i;
    while (TextUtils.isEmpty(str2))
    {
      AppMethodBeat.o(123756);
      return;
      str2 = ".";
      continue;
      i = 0;
      str2 = str1;
      if (i < AppBrandNumberKeyboardView.c(this.jmX).size())
      {
        int j = AppBrandNumberKeyboardView.b(this.jmX, (String)AppBrandNumberKeyboardView.c(this.jmX).valueAt(i));
        if (paramView.getId() != j) {
          break label200;
        }
        str1 = String.valueOf(AppBrandNumberKeyboardView.c(this.jmX).keyAt(i));
      }
    }
    label200:
    for (;;)
    {
      i += 1;
      break;
      AppBrandNumberKeyboardView.a(this.jmX).commitText(str2, str2.length());
      AppMethodBeat.o(123756);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.AppBrandNumberKeyboardView.2
 * JD-Core Version:    0.7.0.1
 */