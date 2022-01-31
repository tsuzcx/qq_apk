package com.tencent.mm.plugin.appbrand.game.page.a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.mm.plugin.appbrand.config.a.a;
import com.tencent.mm.plugin.appbrand.game.page.f;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.a.c;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.ui.l;

public final class a
  implements c
{
  private final f gcR;
  private c.a gcS = null;
  
  public a(f paramf)
  {
    this.gcR = paramf;
  }
  
  private void cU(boolean paramBoolean)
  {
    if (!(this.gcR.mContext instanceof Activity)) {
      return;
    }
    Window localWindow = ((Activity)this.gcR.mContext).getWindow();
    if (paramBoolean)
    {
      l.c(localWindow, true);
      return;
    }
    l.c(localWindow, false);
  }
  
  public final void agH()
  {
    if (this.gcS == null) {
      if (!this.gcR.getRuntime().getAppConfig().fNF.fNL) {
        break label69;
      }
    }
    label69:
    for (c.a locala = c.a.gVX;; locala = c.a.gVY)
    {
      this.gcS = locala;
      switch (a.1.gcT[this.gcS.ordinal()])
      {
      default: 
        return;
      }
    }
    ahg();
    return;
    ahh();
  }
  
  public final void ahg()
  {
    this.gcS = c.a.gVX;
    cU(false);
    if ((Build.VERSION.SDK_INT >= 21) && ((this.gcR.mContext instanceof Activity)))
    {
      Window localWindow = ((Activity)this.gcR.mContext).getWindow();
      if (localWindow != null)
      {
        localWindow.addFlags(-2147483648);
        localWindow.setStatusBarColor(0);
        this.gcR.gTC.dN(false);
      }
    }
  }
  
  public final void ahh()
  {
    this.gcS = c.a.gVY;
    cU(true);
    this.gcR.gTC.dN(true);
  }
  
  public final c.a ahi()
  {
    return this.gcS;
  }
  
  public final void onOrientationChanged(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.page.a.a
 * JD-Core Version:    0.7.0.1
 */