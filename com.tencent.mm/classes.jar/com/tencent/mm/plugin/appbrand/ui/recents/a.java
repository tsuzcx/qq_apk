package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public abstract class a
{
  a mOm;
  
  protected void a(WeImageView paramWeImageView) {}
  
  public abstract View bBp();
  
  protected final boolean bBq()
  {
    if (bBp() == null) {}
    while (bBp().getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  public abstract void bwp();
  
  protected final void hL(boolean paramBoolean)
  {
    if (bBp() == null) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        if (bBp().getVisibility() != 0) {
          bBp().setVisibility(0);
        }
      }
      while (this.mOm != null)
      {
        this.mOm.a(this, bBp(), paramBoolean);
        return;
        if (bBp().getVisibility() != 8) {
          bBp().setVisibility(8);
        }
      }
    }
  }
  
  public abstract void onDetached();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void vF(int paramInt);
  
  public abstract void vG(int paramInt);
  
  static abstract interface a
  {
    public abstract void a(a parama, View paramView, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.a
 * JD-Core Version:    0.7.0.1
 */