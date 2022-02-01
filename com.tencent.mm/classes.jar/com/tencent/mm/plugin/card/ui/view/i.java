package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import com.tencent.mm.plugin.card.ui.n;

public abstract class i
{
  n nIg;
  
  public final void a(n paramn)
  {
    this.nIg = paramn;
    initView();
  }
  
  public void bMB() {}
  
  public void destroy()
  {
    this.nIg = null;
  }
  
  protected final View findViewById(int paramInt)
  {
    return this.nIg.findViewById(paramInt);
  }
  
  protected final String getString(int paramInt)
  {
    return this.nIg.getString(paramInt);
  }
  
  public abstract void initView();
  
  public void update() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.i
 * JD-Core Version:    0.7.0.1
 */