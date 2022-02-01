package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public abstract class a
{
  a lGO;
  
  protected void a(WeImageView paramWeImageView) {}
  
  public abstract void bpt();
  
  public abstract View bpu();
  
  protected final boolean bpv()
  {
    if (bpu() == null) {}
    while (bpu().getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  protected final void he(boolean paramBoolean)
  {
    if (bpu() == null) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        if (bpu().getVisibility() != 0) {
          bpu().setVisibility(0);
        }
      }
      while (this.lGO != null)
      {
        this.lGO.a(this, bpu(), paramBoolean);
        return;
        if (bpu().getVisibility() != 8) {
          bpu().setVisibility(8);
        }
      }
    }
  }
  
  public abstract void onDetached();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void ud(int paramInt);
  
  public abstract void ue(int paramInt);
  
  static abstract interface a
  {
    public abstract void a(a parama, View paramView, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.a
 * JD-Core Version:    0.7.0.1
 */