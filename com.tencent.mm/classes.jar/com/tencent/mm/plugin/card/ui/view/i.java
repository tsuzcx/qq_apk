package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import com.tencent.mm.plugin.card.ui.n;

public abstract class i
{
  n oVd;
  
  public final void a(n paramn)
  {
    this.oVd = paramn;
    initView();
  }
  
  public void bZG() {}
  
  public void destroy()
  {
    this.oVd = null;
  }
  
  protected final View findViewById(int paramInt)
  {
    return this.oVd.findViewById(paramInt);
  }
  
  protected final String getString(int paramInt)
  {
    return this.oVd.getString(paramInt);
  }
  
  public abstract void initView();
  
  public void update() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.i
 * JD-Core Version:    0.7.0.1
 */