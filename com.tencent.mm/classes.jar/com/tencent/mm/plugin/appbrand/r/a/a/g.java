package com.tencent.mm.plugin.appbrand.r.a.a;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.provider.Settings.System;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.a.e.a;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements c
{
  private static final SparseArray<g> mpg;
  private WeakReference<Activity> lVh;
  private int mCurrentOrientation;
  public boolean mFinished;
  private b mph;
  private b mpi;
  private ContentObserver mpj;
  private e.b mpk;
  private h mpl;
  
  static
  {
    AppMethodBeat.i(176737);
    mpg = new SparseArray();
    AppMethodBeat.o(176737);
  }
  
  private g(Activity paramActivity)
  {
    AppMethodBeat.i(176719);
    this.mFinished = false;
    this.mpj = null;
    this.mpk = null;
    this.mpl = null;
    ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationHandler construct");
    this.mCurrentOrientation = paramActivity.getResources().getConfiguration().orientation;
    this.lVh = new WeakReference(paramActivity);
    a(paramActivity, hx(bwN()));
    AppMethodBeat.o(176719);
  }
  
  public static g C(Activity paramActivity)
  {
    AppMethodBeat.i(176718);
    synchronized (mpg)
    {
      g localg2 = (g)mpg.get(paramActivity.hashCode());
      g localg1 = localg2;
      if (localg2 == null)
      {
        localg1 = new g(paramActivity);
        mpg.put(paramActivity.hashCode(), localg1);
      }
      AppMethodBeat.o(176718);
      return localg1;
    }
  }
  
  private e.b K(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(176734);
    e.b localb;
    if (paramInt == 2)
    {
      ad.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == landscape ");
      if (paramBoolean)
      {
        ad.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: parseConfiguration configuration == landscape but screen locked");
        localb = e.b.moJ;
        AppMethodBeat.o(176734);
        return localb;
      }
      if (this.mpk == e.b.moK)
      {
        localb = e.b.moK;
        AppMethodBeat.o(176734);
        return localb;
      }
      if (this.mpk == e.b.moL)
      {
        localb = e.b.moL;
        AppMethodBeat.o(176734);
        return localb;
      }
      localb = e.b.moI;
      AppMethodBeat.o(176734);
      return localb;
    }
    if (paramInt == 1)
    {
      ad.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == portrait ");
      localb = e.b.moG;
      AppMethodBeat.o(176734);
      return localb;
    }
    ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(176734);
    return null;
  }
  
  private static void a(Activity paramActivity, e.b paramb)
  {
    AppMethodBeat.i(197435);
    paramActivity.setRequestedOrientation(paramb.moM);
    AppMethodBeat.o(197435);
  }
  
  private void a(final b paramb)
  {
    AppMethodBeat.i(176724);
    ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.requestDeviceOrientationImpl setRequestOrientation [%s]", new Object[] { paramb });
    final Activity localActivity = (Activity)this.lVh.get();
    if (localActivity == null)
    {
      ad.w("MicroMsg.AppBrandDeviceOrientationHandler", "hy: ui already released!");
      if (paramb.mpo != null) {
        paramb.mpo.a(paramb.mpp, false);
      }
      AppMethodBeat.o(176724);
      return;
    }
    a(localActivity, paramb.mpp);
    if (b(paramb))
    {
      d(paramb.mpp);
      AppMethodBeat.o(176724);
      return;
    }
    if (this.mpl == null) {
      this.mpl = new h();
    }
    this.mpl.a(new h.a()
    {
      public final void bwP()
      {
        AppMethodBeat.i(176714);
        ad.e("MicroMsg.AppBrandDeviceOrientationHandler", "hy: activity not turn to correct orientation for long time, request[%s]", new Object[] { paramb });
        if (paramb.mpo != null) {
          paramb.mpo.a(paramb.mpp, false);
        }
        AppMethodBeat.o(176714);
      }
      
      public final void bwQ()
      {
        AppMethodBeat.i(176715);
        ad.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: trigger retry, request[%s]", new Object[] { paramb });
        if (!localActivity.isDestroyed()) {
          g.b(localActivity, paramb.mpp);
        }
        AppMethodBeat.o(176715);
      }
    });
    AppMethodBeat.o(176724);
  }
  
  private static void a(e.a parama, e.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(176733);
    if (parama == null)
    {
      AppMethodBeat.o(176733);
      return;
    }
    parama.a(paramb, paramBoolean);
    AppMethodBeat.o(176733);
  }
  
  private void a(e.b paramb, List<a> paramList)
  {
    AppMethodBeat.i(176730);
    if (paramb == this.mpi.mpp)
    {
      if (this.mpi.mpo != null) {
        paramList.add(new a(this.mpi.mpo, paramb, true, "PendingRequest.Listener orientation equal direct", (byte)0));
      }
      this.mpi = null;
      AppMethodBeat.o(176730);
      return;
    }
    if ((Activity)this.lVh.get() == null)
    {
      ad.e("MicroMsg.AppBrandDeviceOrientationHandler", "No Activity when handle pending request");
      if (this.mpi.mpo != null) {
        paramList.add(new a(this.mpi.mpo, paramb, false, "PendingRequest.Listener activity == null", (byte)0));
      }
      AppMethodBeat.o(176730);
      return;
    }
    this.mph = this.mpi;
    this.mpi = null;
    a(this.mph);
    AppMethodBeat.o(176730);
  }
  
  private boolean b(b paramb)
  {
    AppMethodBeat.i(176725);
    ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "current orientation=" + this.mCurrentOrientation + "  request orientation=" + paramb.mpp);
    if ((this.mCurrentOrientation == 2) && ((paramb.mpp.b(e.b.moI)) || (paramb.mpp.b(e.b.moK)) || (paramb.mpp.b(e.b.moL))))
    {
      ad.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same landscape");
      AppMethodBeat.o(176725);
      return true;
    }
    if ((this.mCurrentOrientation == 1) && (paramb.mpp.b(e.b.moG)))
    {
      ad.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same portrait");
      AppMethodBeat.o(176725);
      return true;
    }
    if (this.mCurrentOrientation == 0)
    {
      ad.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: former is undefined, always return immediately");
      AppMethodBeat.o(176725);
      return true;
    }
    if (paramb.mpp == e.b.moH)
    {
      ad.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: request is UNSPECIFIED, return true");
      AppMethodBeat.o(176725);
      return true;
    }
    AppMethodBeat.o(176725);
    return false;
  }
  
  private static boolean bwN()
  {
    AppMethodBeat.i(176723);
    int i = Settings.System.getInt(aj.getContext().getContentResolver(), "accelerometer_rotation", 0);
    ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: systenm orientation %d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(176723);
      return false;
    }
    AppMethodBeat.o(176723);
    return true;
  }
  
  private void bwO()
  {
    AppMethodBeat.i(176726);
    if (this.mpl != null)
    {
      this.mpl.bwR();
      this.mpl = null;
    }
    AppMethodBeat.o(176726);
  }
  
  private void d(e.b paramb)
  {
    boolean bool3 = false;
    AppMethodBeat.i(176728);
    Object localObject1 = (Activity)this.lVh.get();
    Object localObject2;
    boolean bool1;
    if ((localObject1 == null) || (paramb == null))
    {
      localObject2 = new RuntimeException();
      if (localObject1 != null) {
        break label115;
      }
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2;
      if (paramb == null)
      {
        bool2 = true;
        label52:
        ad.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", (Throwable)localObject2, "onConfigurationChanged activity[isNull ? %b] newConfig[isNull ? %b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        localObject2 = new LinkedList();
      }
      try
      {
        if (this.mFinished)
        {
          ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "onConfigurationChanged Finished = true");
          return;
          label115:
          bool1 = false;
          continue;
          bool2 = false;
          break label52;
        }
        else
        {
          if (this.mph == null)
          {
            ad.d("MicroMsg.AppBrandDeviceOrientationHandler", "No current request..., dismiss");
            return;
          }
          if (paramb == null) {}
          for (localObject1 = "null";; localObject1 = paramb.name())
          {
            ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.onConfigurationChanged [%s]", new Object[] { localObject1 });
            if (this.mph.mpo != null)
            {
              localObject1 = this.mph.mpo;
              bool1 = bool3;
              if (paramb != null)
              {
                bool1 = bool3;
                if (paramb.b(this.mph.mpp)) {
                  bool1 = true;
                }
              }
              ((List)localObject2).add(new a((e.a)localObject1, paramb, bool1, "CurrentRequest.listener result received", (byte)0));
            }
            this.mph = null;
            if (this.mpi != null) {
              a(paramb, (List)localObject2);
            }
            paramb = ((List)localObject2).iterator();
            while (paramb.hasNext()) {
              ((a)paramb.next()).execute();
            }
          }
          AppMethodBeat.o(176728);
        }
      }
      finally
      {
        AppMethodBeat.o(176728);
      }
    }
  }
  
  private e.b hx(boolean paramBoolean)
  {
    AppMethodBeat.i(176731);
    ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "getCurrentOrientation");
    e.b localb = K(this.mCurrentOrientation, paramBoolean);
    AppMethodBeat.o(176731);
    return localb;
  }
  
  public final void a(e.b paramb, e.a parama)
  {
    AppMethodBeat.i(176720);
    Object localObject = (Activity)this.lVh.get();
    e.b localb = hx(bwN());
    ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation reqOrientation = [%s], listener = [%s] currentOrientation = [%s], latestOrientation = [%s]", new Object[] { paramb, parama, localb, this.mpk });
    if (localObject == null)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", new RuntimeException(), "No Activity found when request device orientation", new Object[0]);
      a(parama, localb, false);
      this.mpk = paramb;
      AppMethodBeat.o(176720);
      return;
    }
    if (paramb == null)
    {
      ad.w("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation null");
      a(parama, localb, false);
      this.mpk = paramb;
      AppMethodBeat.o(176720);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 24) && (((Activity)localObject).isInMultiWindowMode()))
    {
      ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation, activity[%s] isInMultiWindowMode, req[%s], callback fail", new Object[] { ((Activity)localObject).getLocalClassName(), paramb });
      bwO();
      a((Activity)localObject, paramb);
      if (parama != null) {
        if (localb != paramb) {
          break label211;
        }
      }
      label211:
      for (boolean bool = true;; bool = false)
      {
        parama.a(localb, bool);
        AppMethodBeat.o(176720);
        return;
      }
    }
    if ((paramb == localb) && (this.mpk != e.b.moH))
    {
      ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation currentOrientation hit. [%s]", new Object[] { paramb });
      this.mph = null;
      a(parama, paramb, true);
      this.mpk = paramb;
      bwO();
      a((Activity)localObject, paramb);
      AppMethodBeat.o(176720);
      return;
    }
    for (;;)
    {
      try
      {
        if (this.mFinished)
        {
          ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation mFinished = true");
          this.mpk = paramb;
          return;
        }
        if (this.mph == null)
        {
          this.mph = new b(paramb, parama, (byte)0);
          a(this.mph);
          localObject = null;
          if (localObject != null)
          {
            ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "dismissRequest not null");
            a(((b)localObject).mpo, localb, false);
          }
          this.mpk = paramb;
          AppMethodBeat.o(176720);
          return;
        }
        if (this.mpi != null)
        {
          localObject = this.mpi;
          this.mpi = new b(paramb, parama, (byte)0);
        }
        else
        {
          localObject = null;
        }
      }
      finally
      {
        AppMethodBeat.o(176720);
      }
    }
  }
  
  public final e.b aXN()
  {
    AppMethodBeat.i(176732);
    e.b localb = hx(bwN());
    AppMethodBeat.o(176732);
    return localb;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(176727);
    bwO();
    this.mCurrentOrientation = paramConfiguration.orientation;
    ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "onConfigurationChanged  " + this.mCurrentOrientation);
    d(K(this.mCurrentOrientation, bwN()));
    AppMethodBeat.o(176727);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(176722);
    if (this.mpj != null) {
      try
      {
        aj.getContext().getContentResolver().unregisterContentObserver(this.mpj);
        AppMethodBeat.o(176722);
        return;
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", localThrowable, "unregisterContentObserver", new Object[0]);
      }
    }
    AppMethodBeat.o(176722);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(176721);
    a(this.mpk, null);
    ContentResolver localContentResolver = aj.getContext().getApplicationContext().getContentResolver();
    Uri localUri = Settings.System.getUriFor("accelerometer_rotation");
    this.mpj = new ContentObserver(new Handler())
    {
      public final boolean deliverSelfNotifications()
      {
        return true;
      }
      
      public final void onChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(176713);
        super.onChange(paramAnonymousBoolean);
        ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: lock orientation settings changed! request now");
        if ((g.a(g.this) != null) && (g.b(g.this).get() != null))
        {
          ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: need change");
          g.this.a(g.e(g.a(g.this)), null);
          g.c(g.this);
        }
        AppMethodBeat.o(176713);
      }
    };
    try
    {
      localContentResolver.registerContentObserver(localUri, false, this.mpj);
      AppMethodBeat.o(176721);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", localThrowable, "registerContentObserver [Settings.System.ACCELEROMETER_ROTATION] ", new Object[0]);
      AppMethodBeat.o(176721);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(176729);
    ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "release");
    synchronized (mpg)
    {
      int i = mpg.indexOfValue(this);
      if (i >= 0) {
        mpg.removeAt(i);
      }
    }
    try
    {
      if ((this.mph == null) && (this.mpi == null))
      {
        ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "Every request is executed well");
        return;
        localObject2 = finally;
        throw localObject2;
      }
      ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "Still has request not executed current[%s] pending[%s]", new Object[] { this.mph, this.mpi });
      this.mph = null;
      this.mpi = null;
      this.mFinished = true;
      return;
    }
    finally
    {
      AppMethodBeat.o(176729);
    }
  }
  
  static final class a
  {
    e.a mpo;
    e.b mpp;
    String name;
    boolean success;
    
    private a(e.a parama, e.b paramb, boolean paramBoolean, String paramString)
    {
      this.mpo = parama;
      this.mpp = paramb;
      this.success = paramBoolean;
      this.name = paramString;
    }
    
    final void execute()
    {
      AppMethodBeat.i(176716);
      ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "Notify Listener[%s]", new Object[] { this.name });
      if (this.mpo == null)
      {
        ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "PendingNotify: Listener is null when execute.");
        AppMethodBeat.o(176716);
        return;
      }
      this.mpo.a(this.mpp, this.success);
      AppMethodBeat.o(176716);
    }
  }
  
  static final class b
  {
    e.a mpo;
    e.b mpp;
    
    private b(e.b paramb, e.a parama)
    {
      this.mpp = paramb;
      this.mpo = parama;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(176717);
      String str = "Req{" + this.mpp + ", " + this.mpo + "}";
      AppMethodBeat.o(176717);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.a.g
 * JD-Core Version:    0.7.0.1
 */