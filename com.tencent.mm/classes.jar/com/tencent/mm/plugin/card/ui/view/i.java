package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import com.tencent.mm.plugin.card.ui.n;

public abstract class i
{
  n kBh;
  
  public final void a(n paramn)
  {
    this.kBh = paramn;
    initView();
  }
  
  public void bfq() {}
  
  public void destroy()
  {
    this.kBh = null;
  }
  
  protected final View findViewById(int paramInt)
  {
    return this.kBh.findViewById(paramInt);
  }
  
  protected final String getString(int paramInt)
  {
    return this.kBh.getString(paramInt);
  }
  
  public abstract void initView();
  
  public void update() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.i
 * JD-Core Version:    0.7.0.1
 */