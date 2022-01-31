package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;

public abstract class a
  implements l
{
  a.a iSl;
  
  public abstract void aNd();
  
  public abstract View aNe();
  
  protected final boolean aNf()
  {
    if (aNe() == null) {}
    while (aNe().getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  protected final void eR(boolean paramBoolean)
  {
    if (aNe() == null) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        if (aNe().getVisibility() != 0) {
          aNe().setVisibility(0);
        }
      }
      while (this.iSl != null)
      {
        this.iSl.a(this, aNe(), paramBoolean);
        return;
        if (aNe().getVisibility() != 8) {
          aNe().setVisibility(8);
        }
      }
    }
  }
  
  public abstract void onDetached();
  
  public abstract void onResume();
  
  public abstract void pF(int paramInt);
  
  public abstract void pG(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.a
 * JD-Core Version:    0.7.0.1
 */