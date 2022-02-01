package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import com.tencent.mm.plugin.card.ui.n;

public abstract class i
{
  n wJs;
  
  public final void a(n paramn)
  {
    this.wJs = paramn;
    initView();
  }
  
  public void destroy()
  {
    this.wJs = null;
  }
  
  public void doE() {}
  
  protected final View findViewById(int paramInt)
  {
    return this.wJs.findViewById(paramInt);
  }
  
  protected final String getString(int paramInt)
  {
    return this.wJs.getString(paramInt);
  }
  
  public abstract void initView();
  
  public void update() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.i
 * JD-Core Version:    0.7.0.1
 */