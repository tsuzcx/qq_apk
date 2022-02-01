package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public abstract class a
{
  a mJk;
  
  protected void a(WeImageView paramWeImageView) {}
  
  public abstract void bAu();
  
  public abstract View bAv();
  
  protected final boolean bAw()
  {
    if (bAv() == null) {}
    while (bAv().getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  protected final void hL(boolean paramBoolean)
  {
    if (bAv() == null) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        if (bAv().getVisibility() != 0) {
          bAv().setVisibility(0);
        }
      }
      while (this.mJk != null)
      {
        this.mJk.a(this, bAv(), paramBoolean);
        return;
        if (bAv().getVisibility() != 8) {
          bAv().setVisibility(8);
        }
      }
    }
  }
  
  public abstract void onDetached();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void vA(int paramInt);
  
  public abstract void vB(int paramInt);
  
  static abstract interface a
  {
    public abstract void a(a parama, View paramView, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.a
 * JD-Core Version:    0.7.0.1
 */