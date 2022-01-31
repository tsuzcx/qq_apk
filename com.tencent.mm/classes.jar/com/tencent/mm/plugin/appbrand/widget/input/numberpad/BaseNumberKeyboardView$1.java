package com.tencent.mm.plugin.appbrand.widget.input.numberpad;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

final class BaseNumberKeyboardView$1
  implements View.OnClickListener
{
  BaseNumberKeyboardView$1(BaseNumberKeyboardView paramBaseNumberKeyboardView) {}
  
  public final void onClick(View paramView)
  {
    if (BaseNumberKeyboardView.a(this.hxy) == null) {
      return;
    }
    if (paramView.getId() == this.hxy.getId("tenpay_keyboard_x"))
    {
      switch (BaseNumberKeyboardView.b(this.hxy))
      {
      case 0: 
      default: 
        return;
      case 1: 
        BaseNumberKeyboardView.a(this.hxy).dispatchKeyEvent(new KeyEvent(0, 59));
        BaseNumberKeyboardView.a(this.hxy).dispatchKeyEvent(new KeyEvent(0, 52));
        BaseNumberKeyboardView.a(this.hxy).dispatchKeyEvent(new KeyEvent(1, 59));
        return;
      }
      BaseNumberKeyboardView.a(this.hxy).dispatchKeyEvent(new KeyEvent(0, 56));
      return;
    }
    int i;
    if (paramView.getId() == this.hxy.getId("tenpay_keyboard_1")) {
      i = 8;
    }
    for (;;)
    {
      BaseNumberKeyboardView.a(this.hxy).dispatchKeyEvent(new KeyEvent(0, i));
      BaseNumberKeyboardView.a(this.hxy).dispatchKeyEvent(new KeyEvent(1, i));
      return;
      if (paramView.getId() == this.hxy.getId("tenpay_keyboard_2")) {
        i = 9;
      } else if (paramView.getId() == this.hxy.getId("tenpay_keyboard_3")) {
        i = 10;
      } else if (paramView.getId() == this.hxy.getId("tenpay_keyboard_4")) {
        i = 11;
      } else if (paramView.getId() == this.hxy.getId("tenpay_keyboard_5")) {
        i = 12;
      } else if (paramView.getId() == this.hxy.getId("tenpay_keyboard_6")) {
        i = 13;
      } else if (paramView.getId() == this.hxy.getId("tenpay_keyboard_7")) {
        i = 14;
      } else if (paramView.getId() == this.hxy.getId("tenpay_keyboard_8")) {
        i = 15;
      } else if (paramView.getId() == this.hxy.getId("tenpay_keyboard_9")) {
        i = 16;
      } else if (paramView.getId() == this.hxy.getId("tenpay_keyboard_0")) {
        i = 7;
      } else if (paramView.getId() == this.hxy.getId("tenpay_keyboard_d")) {
        i = 67;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.numberpad.BaseNumberKeyboardView.1
 * JD-Core Version:    0.7.0.1
 */