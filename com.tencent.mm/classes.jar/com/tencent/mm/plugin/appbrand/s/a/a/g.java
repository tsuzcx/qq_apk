package com.tencent.mm.plugin.appbrand.s.a.a;

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
import com.tencent.mm.plugin.appbrand.s.a.e.a;
import com.tencent.mm.plugin.appbrand.s.a.e.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements c
{
  private static final SparseArray<g> lnq;
  private WeakReference<Activity> kUk;
  private b lnr;
  private b lns;
  private ContentObserver lnt;
  private e.b lnu;
  private h lnv;
  private int mCurrentOrientation;
  public boolean mFinished;
  
  static
  {
    AppMethodBeat.i(176737);
    lnq = new SparseArray();
    AppMethodBeat.o(176737);
  }
  
  private g(Activity paramActivity)
  {
    AppMethodBeat.i(176719);
    this.mFinished = false;
    this.lnt = null;
    this.lnu = null;
    this.lnv = null;
    ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationHandler construct");
    this.mCurrentOrientation = paramActivity.getResources().getConfiguration().orientation;
    this.kUk = new WeakReference(paramActivity);
    a(paramActivity, gT(blN()));
    AppMethodBeat.o(176719);
  }
  
  public static g C(Activity paramActivity)
  {
    AppMethodBeat.i(176718);
    synchronized (lnq)
    {
      g localg2 = (g)lnq.get(paramActivity.hashCode());
      g localg1 = localg2;
      if (localg2 == null)
      {
        localg1 = new g(paramActivity);
        lnq.put(paramActivity.hashCode(), localg1);
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
        localb = e.b.lmR;
        AppMethodBeat.o(176734);
        return localb;
      }
      if (this.lnu == e.b.lmS)
      {
        localb = e.b.lmS;
        AppMethodBeat.o(176734);
        return localb;
      }
      if (this.lnu == e.b.lmT)
      {
        localb = e.b.lmT;
        AppMethodBeat.o(176734);
        return localb;
      }
      localb = e.b.lmQ;
      AppMethodBeat.o(176734);
      return localb;
    }
    if (paramInt == 1)
    {
      ad.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == portrait ");
      localb = e.b.lmO;
      AppMethodBeat.o(176734);
      return localb;
    }
    ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(176734);
    return null;
  }
  
  private static void a(Activity paramActivity, e.b paramb)
  {
    AppMethodBeat.i(194525);
    paramActivity.setRequestedOrientation(paramb.lmU);
    AppMethodBeat.o(194525);
  }
  
  private void a(final b paramb)
  {
    AppMethodBeat.i(176724);
    ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.requestDeviceOrientationImpl setRequestOrientation [%s]", new Object[] { paramb });
    final Activity localActivity = (Activity)this.kUk.get();
    if (localActivity == null)
    {
      ad.w("MicroMsg.AppBrandDeviceOrientationHandler", "hy: ui already released!");
      if (paramb.lny != null) {
        paramb.lny.a(paramb.lnz, false);
      }
      AppMethodBeat.o(176724);
      return;
    }
    a(localActivity, paramb.lnz);
    if (b(paramb))
    {
      d(paramb.lnz);
      AppMethodBeat.o(176724);
      return;
    }
    if (this.lnv == null) {
      this.lnv = new h();
    }
    this.lnv.a(new h.a()
    {
      public final void blP()
      {
        AppMethodBeat.i(176714);
        ad.e("MicroMsg.AppBrandDeviceOrientationHandler", "hy: activity not turn to correct orientation for long time, request[%s]", new Object[] { paramb });
        if (paramb.lny != null) {
          paramb.lny.a(paramb.lnz, false);
        }
        AppMethodBeat.o(176714);
      }
      
      public final void blQ()
      {
        AppMethodBeat.i(176715);
        ad.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: trigger retry, request[%s]", new Object[] { paramb });
        if (!localActivity.isDestroyed()) {
          g.b(localActivity, paramb.lnz);
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
    if (paramb == this.lns.lnz)
    {
      if (this.lns.lny != null) {
        paramList.add(new a(this.lns.lny, paramb, true, "PendingRequest.Listener orientation equal direct", (byte)0));
      }
      this.lns = null;
      AppMethodBeat.o(176730);
      return;
    }
    if ((Activity)this.kUk.get() == null)
    {
      ad.e("MicroMsg.AppBrandDeviceOrientationHandler", "No Activity when handle pending request");
      if (this.lns.lny != null) {
        paramList.add(new a(this.lns.lny, paramb, false, "PendingRequest.Listener activity == null", (byte)0));
      }
      AppMethodBeat.o(176730);
      return;
    }
    this.lnr = this.lns;
    this.lns = null;
    a(this.lnr);
    AppMethodBeat.o(176730);
  }
  
  private boolean b(b paramb)
  {
    AppMethodBeat.i(176725);
    ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "current orientation=" + this.mCurrentOrientation + "  request orientation=" + paramb.lnz);
    if ((this.mCurrentOrientation == 2) && ((paramb.lnz.b(e.b.lmQ)) || (paramb.lnz.b(e.b.lmS)) || (paramb.lnz.b(e.b.lmT))))
    {
      ad.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same landscape");
      AppMethodBeat.o(176725);
      return true;
    }
    if ((this.mCurrentOrientation == 1) && (paramb.lnz.b(e.b.lmO)))
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
    if (paramb.lnz == e.b.lmP)
    {
      ad.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: request is UNSPECIFIED, return true");
      AppMethodBeat.o(176725);
      return true;
    }
    AppMethodBeat.o(176725);
    return false;
  }
  
  private static boolean blN()
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
  
  private void blO()
  {
    AppMethodBeat.i(176726);
    if (this.lnv != null)
    {
      this.lnv.blR();
      this.lnv = null;
    }
    AppMethodBeat.o(176726);
  }
  
  private void d(e.b paramb)
  {
    boolean bool3 = false;
    AppMethodBeat.i(176728);
    Object localObject1 = (Activity)this.kUk.get();
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
          if (this.lnr == null)
          {
            ad.d("MicroMsg.AppBrandDeviceOrientationHandler", "No current request..., dismiss");
            return;
          }
          if (paramb == null) {}
          for (localObject1 = "null";; localObject1 = paramb.name())
          {
            ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.onConfigurationChanged [%s]", new Object[] { localObject1 });
            if (this.lnr.lny != null)
            {
              localObject1 = this.lnr.lny;
              bool1 = bool3;
              if (paramb != null)
              {
                bool1 = bool3;
                if (paramb.b(this.lnr.lnz)) {
                  bool1 = true;
                }
              }
              ((List)localObject2).add(new a((e.a)localObject1, paramb, bool1, "CurrentRequest.listener result received", (byte)0));
            }
            this.lnr = null;
            if (this.lns != null) {
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
  
  private e.b gT(boolean paramBoolean)
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
    Object localObject = (Activity)this.kUk.get();
    e.b localb = gT(blN());
    ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation reqOrientation = [%s], listener = [%s] currentOrientation = [%s], latestOrientation = [%s]", new Object[] { paramb, parama, localb, this.lnu });
    if (localObject == null)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", new RuntimeException(), "No Activity found when request device orientation", new Object[0]);
      a(parama, localb, false);
      this.lnu = paramb;
      AppMethodBeat.o(176720);
      return;
    }
    if (paramb == null)
    {
      ad.w("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation null");
      a(parama, localb, false);
      this.lnu = paramb;
      AppMethodBeat.o(176720);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 24) && (((Activity)localObject).isInMultiWindowMode()))
    {
      ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation, activity[%s] isInMultiWindowMode, req[%s], callback fail", new Object[] { ((Activity)localObject).getLocalClassName(), paramb });
      blO();
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
    if ((paramb == localb) && (this.lnu != e.b.lmP))
    {
      ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation currentOrientation hit. [%s]", new Object[] { paramb });
      this.lnr = null;
      a(parama, paramb, true);
      this.lnu = paramb;
      blO();
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
          this.lnu = paramb;
          return;
        }
        if (this.lnr == null)
        {
          this.lnr = new b(paramb, parama, (byte)0);
          a(this.lnr);
          localObject = null;
          if (localObject != null)
          {
            ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "dismissRequest not null");
            a(((b)localObject).lny, localb, false);
          }
          this.lnu = paramb;
          AppMethodBeat.o(176720);
          return;
        }
        if (this.lns != null)
        {
          localObject = this.lns;
          this.lns = new b(paramb, parama, (byte)0);
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
  
  public final e.b aNL()
  {
    AppMethodBeat.i(176732);
    e.b localb = gT(blN());
    AppMethodBeat.o(176732);
    return localb;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(176727);
    blO();
    this.mCurrentOrientation = paramConfiguration.orientation;
    ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "onConfigurationChanged  " + this.mCurrentOrientation);
    d(K(this.mCurrentOrientation, blN()));
    AppMethodBeat.o(176727);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(176722);
    if (this.lnt != null) {
      try
      {
        aj.getContext().getContentResolver().unregisterContentObserver(this.lnt);
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
    a(this.lnu, null);
    ContentResolver localContentResolver = aj.getContext().getApplicationContext().getContentResolver();
    Uri localUri = Settings.System.getUriFor("accelerometer_rotation");
    this.lnt = new ContentObserver(new Handler())
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
      localContentResolver.registerContentObserver(localUri, false, this.lnt);
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
    synchronized (lnq)
    {
      int i = lnq.indexOfValue(this);
      if (i >= 0) {
        lnq.removeAt(i);
      }
    }
    try
    {
      if ((this.lnr == null) && (this.lns == null))
      {
        ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "Every request is executed well");
        return;
        localObject2 = finally;
        throw localObject2;
      }
      ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "Still has request not executed current[%s] pending[%s]", new Object[] { this.lnr, this.lns });
      this.lnr = null;
      this.lns = null;
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
    e.a lny;
    e.b lnz;
    String name;
    boolean success;
    
    private a(e.a parama, e.b paramb, boolean paramBoolean, String paramString)
    {
      this.lny = parama;
      this.lnz = paramb;
      this.success = paramBoolean;
      this.name = paramString;
    }
    
    final void execute()
    {
      AppMethodBeat.i(176716);
      ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "Notify Listener[%s]", new Object[] { this.name });
      if (this.lny == null)
      {
        ad.i("MicroMsg.AppBrandDeviceOrientationHandler", "PendingNotify: Listener is null when execute.");
        AppMethodBeat.o(176716);
        return;
      }
      this.lny.a(this.lnz, this.success);
      AppMethodBeat.o(176716);
    }
  }
  
  static final class b
  {
    e.a lny;
    e.b lnz;
    
    private b(e.b paramb, e.a parama)
    {
      this.lnz = paramb;
      this.lny = parama;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(176717);
      String str = "Req{" + this.lnz + ", " + this.lny + "}";
      AppMethodBeat.o(176717);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.a.a.g
 * JD-Core Version:    0.7.0.1
 */