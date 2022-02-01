package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public abstract class a
{
  a obo;
  
  protected void a(WeImageView paramWeImageView) {}
  
  public abstract void bSx();
  
  public abstract View bYp();
  
  protected final boolean getViewEnable()
  {
    if (bYp() == null) {}
    while (bYp().getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  public abstract void onDetached();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  protected final void setViewEnable(boolean paramBoolean)
  {
    if (bYp() == null) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        if (bYp().getVisibility() != 0) {
          bYp().setVisibility(0);
        }
      }
      while (this.obo != null)
      {
        this.obo.a(this, bYp(), paramBoolean);
        return;
        if (bYp().getVisibility() != 8) {
          bYp().setVisibility(8);
        }
      }
    }
  }
  
  public abstract void zu(int paramInt);
  
  public abstract void zv(int paramInt);
  
  static abstract interface a
  {
    public abstract void a(a parama, View paramView, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.a
 * JD-Core Version:    0.7.0.1
 */