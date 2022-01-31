package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;

abstract class a
{
  a hgJ;
  
  public abstract void apJ();
  
  public abstract View apK();
  
  protected final boolean apL()
  {
    if (apK() == null) {}
    while (apK().getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  protected final void dF(boolean paramBoolean)
  {
    if (apK() == null) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        if (apK().getVisibility() != 0) {
          apK().setVisibility(0);
        }
      }
      while (this.hgJ != null)
      {
        this.hgJ.a(this, apK(), paramBoolean);
        return;
        if (apK().getVisibility() != 8) {
          apK().setVisibility(8);
        }
      }
    }
  }
  
  public abstract void onDetached();
  
  public abstract void onResume();
  
  static abstract interface a
  {
    public abstract void a(a parama, View paramView, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.a
 * JD-Core Version:    0.7.0.1
 */