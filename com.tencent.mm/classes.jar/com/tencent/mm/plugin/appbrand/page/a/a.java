package com.tencent.mm.plugin.appbrand.page.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.ui.statusbar.c;
import java.util.concurrent.atomic.AtomicReference;

@TargetApi(21)
public final class a
  extends b
{
  final q gVT;
  
  public a(q paramq)
  {
    this.gVT = paramq;
  }
  
  private void dy(boolean paramBoolean)
  {
    this.gVW.set(c.a.gVX);
    boolean bool = this.gVT.getRuntime().getAppConfig().fNB.adW();
    com.tencent.mm.ui.statusbar.a.w(this.gVT.getContentView(), bool);
    a.1 local1 = new a.1(this);
    this.gVT.getContentView().post(local1);
    Window localWindow;
    if ((this.gVT.mContext instanceof Activity))
    {
      localWindow = ((Activity)this.gVT.mContext).getWindow();
      if (localWindow != null) {
        break label93;
      }
    }
    label93:
    do
    {
      return;
      View localView = localWindow.getDecorView();
      localView.setOnSystemUiVisibilityChangeListener(new a.2(this));
      localWindow.clearFlags(1024);
      localView.setSystemUiVisibility(localView.getSystemUiVisibility() & 0xFFFFFFFB);
    } while (!paramBoolean);
    c.af((Activity)this.gVT.mContext).a((com.tencent.mm.ui.statusbar.c.a)com.tencent.mm.plugin.appbrand.u.i.aU(new a.3(this, local1)));
  }
  
  public final void agH()
  {
    switch (a.4.gcT[((c.a)this.gVW.get()).ordinal()])
    {
    default: 
      return;
    case 1: 
      dy(true);
      return;
    }
    ahh();
  }
  
  public final void ahg()
  {
    dy(false);
  }
  
  public final void ahh()
  {
    this.gVW.set(c.a.gVY);
    com.tencent.mm.ui.statusbar.a.w(this.gVT.getContentView(), true);
    this.gVT.gTC.dN(true);
    if ((this.gVT.mContext instanceof Activity))
    {
      localObject = ((Activity)this.gVT.mContext).getWindow();
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    ((Window)localObject).addFlags(1024);
    Object localObject = ((Window)localObject).getDecorView();
    ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() | 0x4 | 0x100);
  }
  
  public final void onOrientationChanged(int paramInt)
  {
    super.onOrientationChanged(paramInt);
    if (2 == paramInt)
    {
      ahh();
      return;
    }
    dy(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.a
 * JD-Core Version:    0.7.0.1
 */