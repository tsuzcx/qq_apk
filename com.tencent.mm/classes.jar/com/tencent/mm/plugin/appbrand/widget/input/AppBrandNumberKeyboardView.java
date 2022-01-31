package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.inputmethod.InputConnection;
import com.tencent.mm.plugin.appbrand.widget.input.numberpad.BaseNumberKeyboardView;
import com.tencent.mm.plugin.appbrand.widget.input.numberpad.a;

final class AppBrandNumberKeyboardView
  extends BaseNumberKeyboardView
{
  private int huJ = 0;
  private final SparseArray<String> huK = new AppBrandNumberKeyboardView.1(this);
  InputConnection huL;
  a huM;
  
  AppBrandNumberKeyboardView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public AppBrandNumberKeyboardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    AppBrandNumberKeyboardView.2 local2 = new AppBrandNumberKeyboardView.2(this);
    int i = 0;
    while (i < this.huK.size())
    {
      findViewById(getId((String)this.huK.valueAt(i))).setOnClickListener(local2);
      i += 1;
    }
    findViewById(getId("tenpay_keyboard_x")).setOnClickListener(local2);
    findViewById(getId("tenpay_keyboard_d")).setOnClickListener(null);
    findViewById(getId("tenpay_keyboard_d")).setOnTouchListener(new AppBrandNumberKeyboardView.3(this));
  }
  
  public final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    setInputEditText(null);
  }
  
  public final void setXMode(int paramInt)
  {
    super.setXMode(paramInt);
    this.huJ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.AppBrandNumberKeyboardView
 * JD-Core Version:    0.7.0.1
 */