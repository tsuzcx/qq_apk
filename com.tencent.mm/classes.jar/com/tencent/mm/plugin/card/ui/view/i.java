package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import com.tencent.mm.plugin.card.ui.n;

public abstract class i
{
  n tFT;
  
  public final void a(n paramn)
  {
    this.tFT = paramn;
    initView();
  }
  
  public void cKY() {}
  
  public void destroy()
  {
    this.tFT = null;
  }
  
  protected final View findViewById(int paramInt)
  {
    return this.tFT.findViewById(paramInt);
  }
  
  protected final String getString(int paramInt)
  {
    return this.tFT.getString(paramInt);
  }
  
  public abstract void initView();
  
  public void update() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.i
 * JD-Core Version:    0.7.0.1
 */