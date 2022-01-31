package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.animation.TranslateAnimation;
import java.util.ArrayList;
import java.util.List;

final class c$a
  extends TranslateAnimation
{
  private List<View> lJr = new ArrayList();
  
  public c$a(c paramc, float paramFloat)
  {
    super(0.0F, 0.0F, 0.0F, paramFloat);
  }
  
  public final a beT()
  {
    setFillEnabled(true);
    setFillAfter(true);
    return this;
  }
  
  public final void beU()
  {
    int i = 0;
    while (i < this.lJr.size())
    {
      ((View)this.lJr.get(i)).startAnimation(this);
      i += 1;
    }
  }
  
  public final a cF(View paramView)
  {
    this.lJr.add(paramView);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.a
 * JD-Core Version:    0.7.0.1
 */