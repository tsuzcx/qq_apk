package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Looper;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.v;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI;
import com.tencent.mm.pluginsdk.model.v.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import java.util.Queue;

abstract class b
  extends MutableContextWrapper
{
  final Queue<Runnable> gMp = new LinkedList();
  private ai gMq;
  
  public b()
  {
    super(ae.getContext());
  }
  
  private void B(Runnable paramRunnable)
  {
    if ((getBaseContext() instanceof AppBrandLaunchProxyUI))
    {
      paramRunnable.run();
      return;
    }
    this.gMp.offer(paramRunnable);
  }
  
  protected final void a(LaunchParcel paramLaunchParcel)
  {
    ai localai = new ai("AppBrandLaunchProxyUI-PrepareThread");
    this.gMq = localai;
    localai.O(new b.3(this, paramLaunchParcel));
  }
  
  protected abstract String alZ();
  
  protected void ama()
  {
    B(new b.1(this));
  }
  
  protected final boolean amb()
  {
    return ((getBaseContext() instanceof AppBrandLaunchProxyUI)) && (((AppBrandLaunchProxyUI)getBaseContext()).isDestroyed());
  }
  
  protected boolean b(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    if ((paramAppBrandInitConfigWC.fPy) || (com.tencent.mm.plugin.appbrand.task.g.wr(paramAppBrandInitConfigWC.appId)) || (paramAppBrandInitConfigWC.ZH())) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  protected void d(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    if (paramAppBrandInitConfigWC != null) {
      k.a(getBaseContext(), paramAppBrandInitConfigWC, paramAppBrandStatObject);
    }
    ama();
    if (this.gMq != null) {
      this.gMq.O(new Runnable()
      {
        public final void run()
        {
          Looper.myLooper().quit();
        }
      });
    }
  }
  
  protected final void finish()
  {
    d(null, null);
  }
  
  protected final boolean isFinishing()
  {
    return ((getBaseContext() instanceof AppBrandLaunchProxyUI)) && (((AppBrandLaunchProxyUI)getBaseContext()).isFinishing());
  }
  
  public final void setBaseContext(Context paramContext)
  {
    super.setBaseContext(paramContext);
    if ((getBaseContext() instanceof AppBrandLaunchProxyUI)) {
      while (!this.gMp.isEmpty()) {
        ((Runnable)this.gMp.poll()).run();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.b
 * JD-Core Version:    0.7.0.1
 */