package com.tencent.mm.plugin.appbrand.config;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.provider.Settings.System;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
{
  public static final SparseArray<e> fOh = new SparseArray();
  public d fOi;
  public d fOj;
  private WeakReference<Activity> fOk;
  public ContentObserver fOl = null;
  public e.b fOm = null;
  private boolean fOn;
  public int fOo;
  public boolean mFinished = false;
  
  private e(Activity paramActivity)
  {
    y.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationHandler construct");
    this.fOo = paramActivity.getResources().getConfiguration().orientation;
    this.fOk = new WeakReference(paramActivity);
    this.fOn = adY();
    paramActivity.setRequestedOrientation(cM(this.fOn).fOu);
  }
  
  public static e.b C(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 2)
    {
      y.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == landscape ");
      if (paramBoolean)
      {
        y.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: parseConfiguration configuration == landscape but screen locked");
        return e.b.fOt;
      }
      return e.b.fOs;
    }
    if (paramInt == 1)
    {
      y.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == portrait ");
      return e.b.fOq;
    }
    y.i("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public static e.b a(AppBrandInitConfig paramAppBrandInitConfig, a parama, a.d paramd)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (parama != null)
    {
      localObject1 = localObject2;
      if (paramAppBrandInitConfig.ZH())
      {
        y.i("MicroMsg.AppBrandDeviceOrientationHandler", "[alex]AppBrandAppConfig has deviceOrientation field [%s]", new Object[] { parama.fNF.fNK });
        localObject1 = sg(parama.fNF.fNK);
      }
    }
    parama = (a)localObject1;
    if (localObject1 == null) {
      if (!paramAppBrandInitConfig.ZH()) {
        if (paramd == null) {
          paramAppBrandInitConfig = e.b.fOq;
        }
      }
    }
    do
    {
      return paramAppBrandInitConfig;
      return a.d.sg(paramd.fOf);
      y.i("MicroMsg.AppBrandDeviceOrientationHandler", "[alex]AppBrandInitConfig has orientation field [%s]", new Object[] { paramAppBrandInitConfig.fNK });
      parama = sg(paramAppBrandInitConfig.fNK);
      paramAppBrandInitConfig = parama;
    } while (parama != null);
    return e.b.fOq;
  }
  
  private static void a(e.a parama, e.b paramb, boolean paramBoolean)
  {
    if (parama == null) {
      return;
    }
    parama.a(paramb, paramBoolean);
  }
  
  private void a(d paramd)
  {
    y.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.requestDeviceOrientationImpl setRequestOrientation [%s]", new Object[] { paramd });
    Activity localActivity = (Activity)this.fOk.get();
    if (localActivity == null)
    {
      y.w("MicroMsg.AppBrandDeviceOrientationHandler", "hy: ui already released!");
      if (paramd.fOw != null) {
        paramd.fOw.a(paramd.fOx, false);
      }
    }
    for (;;)
    {
      return;
      localActivity.setRequestedOrientation(paramd.fOx.fOu);
      this.fOn = adY();
      y.i("MicroMsg.AppBrandDeviceOrientationHandler", "current orientation=" + this.fOo + "  request orientation=" + paramd.fOx);
      int i;
      if ((this.fOo == 2) && (paramd.fOx.c(e.b.fOs)))
      {
        y.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same landscape");
        i = 1;
      }
      while (i != 0)
      {
        a(paramd.fOx);
        return;
        if ((this.fOo == 1) && (paramd.fOx.c(e.b.fOq)))
        {
          y.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same portrait");
          i = 1;
        }
        else if (this.fOo == 0)
        {
          y.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: former is undefined, always return immediately");
          i = 1;
        }
        else if (paramd.fOx == e.b.fOr)
        {
          y.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: request is UNSPECIFIED, return true");
          i = 1;
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  public static boolean adY()
  {
    int i = Settings.System.getInt(ae.getContext().getContentResolver(), "accelerometer_rotation", 0);
    y.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: systenm orientation %d", new Object[] { Integer.valueOf(i) });
    return i != 1;
  }
  
  public static e.b d(AppBrandInitConfig paramAppBrandInitConfig)
  {
    return a(paramAppBrandInitConfig, null, null);
  }
  
  public static boolean o(i parami)
  {
    boolean bool1;
    switch (((WindowManager)ae.getContext().getSystemService("window")).getDefaultDisplay().getRotation())
    {
    default: 
      bool1 = true;
      if (a(parami.ZA(), parami.getAppConfig(), null) != e.b.fOq) {
        break;
      }
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      y.i("MicroMsg.AppBrandDeviceOrientationHandler", "[alex] isCurrentPortrait %b, isGameShouldPortrait %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (bool1 != bool2) {
        break label132;
      }
      return true;
      bool1 = true;
      break;
      bool1 = false;
      break;
      bool1 = true;
      break;
      bool1 = false;
      break;
    }
    label132:
    return false;
  }
  
  public static e r(Activity paramActivity)
  {
    synchronized (fOh)
    {
      e locale2 = (e)fOh.get(paramActivity.hashCode());
      e locale1 = locale2;
      if (locale2 == null)
      {
        locale1 = new e(paramActivity);
        fOh.put(paramActivity.hashCode(), locale1);
      }
      return locale1;
    }
  }
  
  public static e.b sg(String paramString)
  {
    if ("landscape".equals(paramString)) {
      return e.b.fOs;
    }
    if ("portrait".equals(paramString)) {
      return e.b.fOq;
    }
    return null;
  }
  
  public final void a(e.b paramb)
  {
    Object localObject1 = (Activity)this.fOk.get();
    Object localObject2;
    boolean bool2;
    if ((localObject1 == null) || (paramb == null))
    {
      localObject2 = new RuntimeException();
      if (localObject1 == null)
      {
        bool1 = true;
        if (paramb != null) {
          break label470;
        }
        bool2 = true;
        label43:
        y.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", (Throwable)localObject2, "onConfigurationChanged activity[isNull ? %b] newConfig[isNull ? %b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      }
    }
    else
    {
      localObject2 = new LinkedList();
      try
      {
        if (this.mFinished)
        {
          y.i("MicroMsg.AppBrandDeviceOrientationHandler", "onConfigurationChanged Finished = true");
          return;
        }
        if (this.fOi == null)
        {
          y.d("MicroMsg.AppBrandDeviceOrientationHandler", "No current request..., dismiss");
          return;
        }
      }
      finally {}
      if (paramb == null)
      {
        localObject1 = "null";
        y.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.onConfigurationChanged [%s]", new Object[] { localObject1 });
        if (this.fOi.fOw != null)
        {
          localObject1 = this.fOi.fOw;
          if ((paramb == null) || (!paramb.c(this.fOi.fOx))) {
            break label475;
          }
        }
      }
    }
    label277:
    label464:
    label470:
    label475:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((List)localObject2).add(new e.c((e.a)localObject1, paramb, bool1, "CurrentRequest.listener result received", (byte)0));
      this.fOi = null;
      if (this.fOj != null)
      {
        if (paramb == this.fOj.fOx)
        {
          if (this.fOj.fOw != null) {
            ((List)localObject2).add(new e.c(this.fOj.fOw, paramb, true, "PendingRequest.Listener orientation equal direct", (byte)0));
          }
          this.fOj = null;
        }
      }
      else {
        paramb = ((List)localObject2).iterator();
      }
      for (;;)
      {
        if (!paramb.hasNext()) {
          break label464;
        }
        localObject1 = (e.c)paramb.next();
        y.i("MicroMsg.AppBrandDeviceOrientationHandler", "Notify Listener[%s]", new Object[] { ((e.c)localObject1).name });
        if (((e.c)localObject1).fOw == null)
        {
          y.i("MicroMsg.AppBrandDeviceOrientationHandler", "PendingNotify: Listener is null when execute.");
          continue;
          localObject1 = paramb.name();
          break;
          if ((Activity)this.fOk.get() == null)
          {
            y.e("MicroMsg.AppBrandDeviceOrientationHandler", "No Activity when handle pending request");
            if (this.fOj.fOw == null) {
              break label277;
            }
            ((List)localObject2).add(new e.c(this.fOj.fOw, paramb, false, "PendingRequest.Listener activity == null", (byte)0));
            break label277;
          }
          this.fOi = this.fOj;
          this.fOj = null;
          a(this.fOi);
          break label277;
        }
        ((e.c)localObject1).fOw.a(((e.c)localObject1).fOx, ((e.c)localObject1).success);
      }
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label43;
    }
  }
  
  public final void a(e.b paramb, e.a parama)
  {
    Object localObject1 = (Activity)this.fOk.get();
    e.b localb = cM(this.fOn);
    y.l("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation reqOrientation = [%s], listener = [%s] currentOrientation = [%s], latestOrientation = [%s]", new Object[] { paramb, parama, localb, this.fOm });
    if (localObject1 == null)
    {
      y.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", new RuntimeException(), "No Activity found when request device orientation", new Object[0]);
      a(parama, localb, false);
      this.fOm = paramb;
      return;
    }
    if (paramb == null)
    {
      y.w("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation null");
      a(parama, localb, false);
      this.fOm = paramb;
      return;
    }
    if ((paramb == localb) && (this.fOm != e.b.fOr))
    {
      y.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation currentOrientation hit. [%s]", new Object[] { paramb });
      a(parama, paramb, true);
      this.fOm = paramb;
      return;
    }
    Object localObject2 = null;
    localObject1 = null;
    try
    {
      if (this.mFinished)
      {
        y.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation mFinished = true");
        this.fOm = paramb;
        return;
      }
    }
    finally {}
    if (this.fOi == null)
    {
      this.fOi = new d(paramb, parama, (byte)0);
      a(this.fOi);
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        y.i("MicroMsg.AppBrandDeviceOrientationHandler", "dismissRequest not null");
        a(((d)localObject1).fOw, localb, false);
      }
      this.fOm = paramb;
      return;
      localObject1 = localObject2;
      if (this.fOj != null) {
        localObject1 = this.fOj;
      }
      this.fOj = new d(paramb, parama, (byte)0);
    }
  }
  
  public final e.b cM(boolean paramBoolean)
  {
    y.i("MicroMsg.AppBrandDeviceOrientationHandler", "getCurrentOrientation");
    return C(this.fOo, paramBoolean);
  }
  
  private final class d
  {
    e.a fOw;
    e.b fOx;
    
    private d(e.b paramb, e.a parama)
    {
      this.fOx = paramb;
      this.fOw = parama;
    }
    
    public final String toString()
    {
      return "Req{" + this.fOx + ", " + this.fOw + "}";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.e
 * JD-Core Version:    0.7.0.1
 */