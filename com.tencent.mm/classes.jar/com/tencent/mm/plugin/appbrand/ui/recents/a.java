package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public abstract class a
{
  private a rcS;
  
  public abstract void CX(int paramInt);
  
  public abstract void CY(int paramInt);
  
  final void a(a parama)
  {
    this.rcS = parama;
  }
  
  protected void a(WeImageView paramWeImageView) {}
  
  public abstract void cfx();
  
  public abstract void cfy();
  
  public abstract View getItemView();
  
  protected final boolean getViewEnable()
  {
    if (getItemView() == null) {}
    while (getItemView().getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  protected final void setViewEnable(boolean paramBoolean)
  {
    if (getItemView() == null) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        if (getItemView().getVisibility() != 0) {
          getItemView().setVisibility(0);
        }
      }
      while (this.rcS != null)
      {
        this.rcS.a(this, getItemView(), paramBoolean);
        return;
        if (getItemView().getVisibility() != 8) {
          getItemView().setVisibility(8);
        }
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void a(a parama, View paramView, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.a
 * JD-Core Version:    0.7.0.1
 */