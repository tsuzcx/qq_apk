package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.View;

public abstract class a
{
  Context mHB;
  protected c mHC;
  int mHD = 0;
  
  public abstract int bAV();
  
  public abstract int bAW();
  
  public abstract int bAX();
  
  public abstract int getPageCount();
  
  public abstract int getRowCount();
  
  public abstract int getRowSpacing();
  
  public final void setPanelManager(c paramc)
  {
    this.mHC = paramc;
  }
  
  public abstract View vX(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.a
 * JD-Core Version:    0.7.0.1
 */