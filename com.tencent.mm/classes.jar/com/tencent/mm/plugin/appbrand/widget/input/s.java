package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

final class s
  extends q
{
  public s(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void arV()
  {
    ai.cs(this).restartInput(this);
  }
  
  public final View getInputPanel()
  {
    return v.cn(this);
  }
  
  public final void setPasswordMode(boolean paramBoolean)
  {
    aso();
    int i = getInputType() | 0x1;
    if (paramBoolean) {
      i |= 0x80;
    }
    for (;;)
    {
      setInputType(i);
      super.setPasswordMode(paramBoolean);
      asp();
      return;
      i &= 0xFFFFFF7F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.s
 * JD-Core Version:    0.7.0.1
 */