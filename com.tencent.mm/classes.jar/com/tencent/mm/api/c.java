package com.tencent.mm.api;

import android.content.Context;
import android.widget.FrameLayout;

public abstract class c
  extends FrameLayout
{
  r bVT = new c.1(this);
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public r getSelectedFeatureListener()
  {
    return this.bVT;
  }
  
  public abstract void setActionBarCallback(g paramg);
  
  public abstract void setActionBarVisible(boolean paramBoolean);
  
  public abstract void setAutoShowFooterAndBar(boolean paramBoolean);
  
  public abstract void setFooterVisible(boolean paramBoolean);
  
  public void setSelectedFeatureListener(r paramr)
  {
    this.bVT = paramr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.api.c
 * JD-Core Version:    0.7.0.1
 */