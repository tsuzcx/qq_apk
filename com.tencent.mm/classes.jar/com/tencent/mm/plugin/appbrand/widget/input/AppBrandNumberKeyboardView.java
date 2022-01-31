package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.numberpad.BaseNumberKeyboardView;
import com.tencent.mm.plugin.appbrand.widget.input.numberpad.a;

final class AppBrandNumberKeyboardView
  extends BaseNumberKeyboardView
{
  private int jmT;
  private final SparseArray<String> jmU;
  InputConnection jmV;
  a jmW;
  
  AppBrandNumberKeyboardView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(123759);
    this.jmT = 0;
    this.jmU = new AppBrandNumberKeyboardView.1(this);
    init();
    AppMethodBeat.o(123759);
  }
  
  public AppBrandNumberKeyboardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(123760);
    this.jmT = 0;
    this.jmU = new AppBrandNumberKeyboardView.1(this);
    init();
    AppMethodBeat.o(123760);
  }
  
  private void init()
  {
    AppMethodBeat.i(123761);
    AppBrandNumberKeyboardView.2 local2 = new AppBrandNumberKeyboardView.2(this);
    int i = 0;
    while (i < this.jmU.size())
    {
      findViewById(getId((String)this.jmU.valueAt(i))).setOnClickListener(local2);
      i += 1;
    }
    findViewById(getId("tenpay_keyboard_x")).setOnClickListener(local2);
    findViewById(getId("tenpay_keyboard_d")).setOnClickListener(null);
    findViewById(getId("tenpay_keyboard_d")).setOnTouchListener(new AppBrandNumberKeyboardView.3(this));
    AppMethodBeat.o(123761);
  }
  
  public final void onDetachedFromWindow()
  {
    AppMethodBeat.i(123763);
    super.onDetachedFromWindow();
    setInputEditText(null);
    AppMethodBeat.o(123763);
  }
  
  public final void setXMode(int paramInt)
  {
    AppMethodBeat.i(123762);
    super.setXMode(paramInt);
    this.jmT = paramInt;
    AppMethodBeat.o(123762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.AppBrandNumberKeyboardView
 * JD-Core Version:    0.7.0.1
 */