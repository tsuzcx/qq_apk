package com.tencent.mm.api;

import android.content.Context;
import android.widget.FrameLayout;

public abstract class b
  extends FrameLayout
{
  p buI = new b.1(this);
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public p getSelectedFeatureListener()
  {
    return this.buI;
  }
  
  public abstract void setActionBarCallback(f paramf);
  
  public abstract void setActionBarVisible(boolean paramBoolean);
  
  public abstract void setAutoShowFooterAndBar(boolean paramBoolean);
  
  public abstract void setFooterVisible(boolean paramBoolean);
  
  public void setSelectedFeatureListener(p paramp)
  {
    this.buI = paramp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.api.b
 * JD-Core Version:    0.7.0.1
 */