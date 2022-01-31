package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import com.tencent.mm.plugin.card.ui.n;

public abstract class i
{
  n iya;
  
  public final void a(n paramn)
  {
    this.iya = paramn;
    initView();
  }
  
  public void aCU() {}
  
  public void destroy()
  {
    this.iya = null;
  }
  
  protected final View findViewById(int paramInt)
  {
    return this.iya.findViewById(paramInt);
  }
  
  protected final String getString(int paramInt)
  {
    return this.iya.getString(paramInt);
  }
  
  public abstract void initView();
  
  public void update() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.i
 * JD-Core Version:    0.7.0.1
 */