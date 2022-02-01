package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public abstract class a
{
  a miJ;
  
  protected void a(WeImageView paramWeImageView) {}
  
  public abstract void bwo();
  
  public abstract View bwp();
  
  protected final boolean bwq()
  {
    if (bwp() == null) {}
    while (bwp().getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  protected final void hB(boolean paramBoolean)
  {
    if (bwp() == null) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        if (bwp().getVisibility() != 0) {
          bwp().setVisibility(0);
        }
      }
      while (this.miJ != null)
      {
        this.miJ.a(this, bwp(), paramBoolean);
        return;
        if (bwp().getVisibility() != 8) {
          bwp().setVisibility(8);
        }
      }
    }
  }
  
  public abstract void onDetached();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void uV(int paramInt);
  
  public abstract void uW(int paramInt);
  
  static abstract interface a
  {
    public abstract void a(a parama, View paramView, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.a
 * JD-Core Version:    0.7.0.1
 */