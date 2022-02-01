package com.tencent.mm.plugin.appbrand.platform.window.a;

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
import com.tencent.mm.plugin.appbrand.platform.window.e.a;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements c
{
  private static final SparseArray<g> muh;
  private WeakReference<Activity> lZK;
  private int mCurrentOrientation;
  public boolean mFinished;
  private b mui;
  private b muj;
  private ContentObserver muk;
  private e.b mul;
  private h mum;
  
  static
  {
    AppMethodBeat.i(176737);
    muh = new SparseArray();
    AppMethodBeat.o(176737);
  }
  
  private g(Activity paramActivity)
  {
    AppMethodBeat.i(176719);
    this.mFinished = false;
    this.muk = null;
    this.mul = null;
    this.mum = null;
    ae.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationHandler construct");
    this.mCurrentOrientation = paramActivity.getResources().getConfiguration().orientation;
    this.lZK = new WeakReference(paramActivity);
    a(paramActivity, hy(bxF()));
    AppMethodBeat.o(176719);
  }
  
  public static g D(Activity paramActivity)
  {
    AppMethodBeat.i(176718);
    synchronized (muh)
    {
      g localg2 = (g)muh.get(paramActivity.hashCode());
      g localg1 = localg2;
      if (localg2 == null)
      {
        localg1 = new g(paramActivity);
        muh.put(paramActivity.hashCode(), localg1);
      }
      AppMethodBeat.o(176718);
      return localg1;
    }
  }
  
  private e.b L(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(176734);
    e.b localb;
    if (paramInt == 2)
    {
      ae.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == landscape ");
      if (paramBoolean)
      {
        ae.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: parseConfiguration configuration == landscape but screen locked");
        localb = e.b.mtG;
        AppMethodBeat.o(176734);
        return localb;
      }
      if (this.mul == e.b.mtH)
      {
        localb = e.b.mtH;
        AppMethodBeat.o(176734);
        return localb;
      }
      if (this.mul == e.b.mtI)
      {
        localb = e.b.mtI;
        AppMethodBeat.o(176734);
        return localb;
      }
      localb = e.b.mtF;
      AppMethodBeat.o(176734);
      return localb;
    }
    if (paramInt == 1)
    {
      ae.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == portrait ");
      localb = e.b.mtD;
      AppMethodBeat.o(176734);
      return localb;
    }
    ae.i("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(176734);
    return null;
  }
  
  private static void a(Activity paramActivity, e.b paramb)
  {
    AppMethodBeat.i(207976);
    paramActivity.setRequestedOrientation(paramb.mtJ);
    AppMethodBeat.o(207976);
  }
  
  private void a(final b paramb)
  {
    AppMethodBeat.i(176724);
    ae.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.requestDeviceOrientationImpl setRequestOrientation [%s]", new Object[] { paramb });
    final Activity localActivity = (Activity)this.lZK.get();
    if (localActivity == null)
    {
      ae.w("MicroMsg.AppBrandDeviceOrientationHandler", "hy: ui already released!");
      if (paramb.mup != null) {
        paramb.mup.a(paramb.muq, false);
      }
      AppMethodBeat.o(176724);
      return;
    }
    a(localActivity, paramb.muq);
    if (b(paramb))
    {
      d(paramb.muq);
      AppMethodBeat.o(176724);
      return;
    }
    if (this.mum == null) {
      this.mum = new h();
    }
    this.mum.a(new h.a()
    {
      public final void bxH()
      {
        AppMethodBeat.i(176714);
        ae.e("MicroMsg.AppBrandDeviceOrientationHandler", "hy: activity not turn to correct orientation for long time, request[%s]", new Object[] { paramb });
        if (paramb.mup != null) {
          paramb.mup.a(paramb.muq, false);
        }
        AppMethodBeat.o(176714);
      }
      
      public final void bxI()
      {
        AppMethodBeat.i(176715);
        ae.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: trigger retry, request[%s]", new Object[] { paramb });
        if (!localActivity.isDestroyed()) {
          g.b(localActivity, paramb.muq);
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
    if (paramb == this.muj.muq)
    {
      if (this.muj.mup != null) {
        paramList.add(new a(this.muj.mup, paramb, true, "PendingRequest.Listener orientation equal direct", (byte)0));
      }
      this.muj = null;
      AppMethodBeat.o(176730);
      return;
    }
    if ((Activity)this.lZK.get() == null)
    {
      ae.e("MicroMsg.AppBrandDeviceOrientationHandler", "No Activity when handle pending request");
      if (this.muj.mup != null) {
        paramList.add(new a(this.muj.mup, paramb, false, "PendingRequest.Listener activity == null", (byte)0));
      }
      AppMethodBeat.o(176730);
      return;
    }
    this.mui = this.muj;
    this.muj = null;
    a(this.mui);
    AppMethodBeat.o(176730);
  }
  
  private boolean b(b paramb)
  {
    AppMethodBeat.i(176725);
    ae.i("MicroMsg.AppBrandDeviceOrientationHandler", "current orientation=" + this.mCurrentOrientation + "  request orientation=" + paramb.muq);
    if ((this.mCurrentOrientation == 2) && ((paramb.muq.b(e.b.mtF)) || (paramb.muq.b(e.b.mtH)) || (paramb.muq.b(e.b.mtI))))
    {
      ae.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same landscape");
      AppMethodBeat.o(176725);
      return true;
    }
    if ((this.mCurrentOrientation == 1) && (paramb.muq.b(e.b.mtD)))
    {
      ae.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same portrait");
      AppMethodBeat.o(176725);
      return true;
    }
    if (this.mCurrentOrientation == 0)
    {
      ae.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: former is undefined, always return immediately");
      AppMethodBeat.o(176725);
      return true;
    }
    if (paramb.muq == e.b.mtE)
    {
      ae.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: request is UNSPECIFIED, return true");
      AppMethodBeat.o(176725);
      return true;
    }
    AppMethodBeat.o(176725);
    return false;
  }
  
  private static boolean bxF()
  {
    AppMethodBeat.i(176723);
    int i = Settings.System.getInt(ak.getContext().getContentResolver(), "accelerometer_rotation", 0);
    ae.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: systenm orientation %d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(176723);
      return false;
    }
    AppMethodBeat.o(176723);
    return true;
  }
  
  private void bxG()
  {
    AppMethodBeat.i(176726);
    if (this.mum != null)
    {
      this.mum.bxJ();
      this.mum = null;
    }
    AppMethodBeat.o(176726);
  }
  
  private void d(e.b paramb)
  {
    boolean bool3 = false;
    AppMethodBeat.i(176728);
    Object localObject1 = (Activity)this.lZK.get();
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
        ae.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", (Throwable)localObject2, "onConfigurationChanged activity[isNull ? %b] newConfig[isNull ? %b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        localObject2 = new LinkedList();
      }
      try
      {
        if (this.mFinished)
        {
          ae.i("MicroMsg.AppBrandDeviceOrientationHandler", "onConfigurationChanged Finished = true");
          return;
          label115:
          bool1 = false;
          continue;
          bool2 = false;
          break label52;
        }
        else
        {
          if (this.mui == null)
          {
            ae.d("MicroMsg.AppBrandDeviceOrientationHandler", "No current request..., dismiss");
            return;
          }
          if (paramb == null) {}
          for (localObject1 = "null";; localObject1 = paramb.name())
          {
            ae.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.onConfigurationChanged [%s]", new Object[] { localObject1 });
            if (this.mui.mup != null)
            {
              localObject1 = this.mui.mup;
              bool1 = bool3;
              if (paramb != null)
              {
                bool1 = bool3;
                if (paramb.b(this.mui.muq)) {
                  bool1 = true;
                }
              }
              ((List)localObject2).add(new a((e.a)localObject1, paramb, bool1, "CurrentRequest.listener result received", (byte)0));
            }
            this.mui = null;
            if (this.muj != null) {
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
  
  private e.b hy(boolean paramBoolean)
  {
    AppMethodBeat.i(176731);
    ae.i("MicroMsg.AppBrandDeviceOrientationHandler", "getCurrentOrientation");
    e.b localb = L(this.mCurrentOrientation, paramBoolean);
    AppMethodBeat.o(176731);
    return localb;
  }
  
  public final void a(e.b paramb, e.a parama)
  {
    AppMethodBeat.i(176720);
    Object localObject = (Activity)this.lZK.get();
    e.b localb = hy(bxF());
    ae.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation reqOrientation = [%s], listener = [%s] currentOrientation = [%s], latestOrientation = [%s]", new Object[] { paramb, parama, localb, this.mul });
    if (localObject == null)
    {
      ae.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", new RuntimeException(), "No Activity found when request device orientation", new Object[0]);
      a(parama, localb, false);
      this.mul = paramb;
      AppMethodBeat.o(176720);
      return;
    }
    if (paramb == null)
    {
      ae.w("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation null");
      a(parama, localb, false);
      this.mul = paramb;
      AppMethodBeat.o(176720);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 24) && (((Activity)localObject).isInMultiWindowMode()))
    {
      ae.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation, activity[%s] isInMultiWindowMode, req[%s], callback fail", new Object[] { ((Activity)localObject).getLocalClassName(), paramb });
      bxG();
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
    if ((paramb == localb) && (this.mul != e.b.mtE))
    {
      ae.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation currentOrientation hit. [%s]", new Object[] { paramb });
      this.mui = null;
      a(parama, paramb, true);
      this.mul = paramb;
      bxG();
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
          ae.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation mFinished = true");
          this.mul = paramb;
          return;
        }
        if (this.mui == null)
        {
          this.mui = new b(paramb, parama, (byte)0);
          a(this.mui);
          localObject = null;
          if (localObject != null)
          {
            ae.i("MicroMsg.AppBrandDeviceOrientationHandler", "dismissRequest not null");
            a(((b)localObject).mup, localb, false);
          }
          this.mul = paramb;
          AppMethodBeat.o(176720);
          return;
        }
        if (this.muj != null)
        {
          localObject = this.muj;
          this.muj = new b(paramb, parama, (byte)0);
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
  
  public final e.b aYg()
  {
    AppMethodBeat.i(176732);
    e.b localb = hy(bxF());
    AppMethodBeat.o(176732);
    return localb;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(176727);
    bxG();
    this.mCurrentOrientation = paramConfiguration.orientation;
    ae.i("MicroMsg.AppBrandDeviceOrientationHandler", "onConfigurationChanged  " + this.mCurrentOrientation);
    d(L(this.mCurrentOrientation, bxF()));
    AppMethodBeat.o(176727);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(176722);
    if (this.muk != null) {
      try
      {
        ak.getContext().getContentResolver().unregisterContentObserver(this.muk);
        AppMethodBeat.o(176722);
        return;
      }
      catch (Throwable localThrowable)
      {
        ae.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", localThrowable, "unregisterContentObserver", new Object[0]);
      }
    }
    AppMethodBeat.o(176722);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(176721);
    a(this.mul, null);
    ContentResolver localContentResolver = ak.getContext().getApplicationContext().getContentResolver();
    Uri localUri = Settings.System.getUriFor("accelerometer_rotation");
    this.muk = new ContentObserver(new Handler())
    {
      public final boolean deliverSelfNotifications()
      {
        return true;
      }
      
      public final void onChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(176713);
        super.onChange(paramAnonymousBoolean);
        ae.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: lock orientation settings changed! request now");
        if ((g.a(g.this) != null) && (g.b(g.this).get() != null))
        {
          ae.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: need change");
          g.this.a(g.e(g.a(g.this)), null);
          g.c(g.this);
        }
        AppMethodBeat.o(176713);
      }
    };
    try
    {
      localContentResolver.registerContentObserver(localUri, false, this.muk);
      AppMethodBeat.o(176721);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", localThrowable, "registerContentObserver [Settings.System.ACCELEROMETER_ROTATION] ", new Object[0]);
      AppMethodBeat.o(176721);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(176729);
    ae.i("MicroMsg.AppBrandDeviceOrientationHandler", "release");
    synchronized (muh)
    {
      int i = muh.indexOfValue(this);
      if (i >= 0) {
        muh.removeAt(i);
      }
    }
    try
    {
      if ((this.mui == null) && (this.muj == null))
      {
        ae.i("MicroMsg.AppBrandDeviceOrientationHandler", "Every request is executed well");
        return;
        localObject2 = finally;
        throw localObject2;
      }
      ae.i("MicroMsg.AppBrandDeviceOrientationHandler", "Still has request not executed current[%s] pending[%s]", new Object[] { this.mui, this.muj });
      this.mui = null;
      this.muj = null;
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
    e.a mup;
    e.b muq;
    String name;
    boolean success;
    
    private a(e.a parama, e.b paramb, boolean paramBoolean, String paramString)
    {
      this.mup = parama;
      this.muq = paramb;
      this.success = paramBoolean;
      this.name = paramString;
    }
    
    final void execute()
    {
      AppMethodBeat.i(176716);
      ae.i("MicroMsg.AppBrandDeviceOrientationHandler", "Notify Listener[%s]", new Object[] { this.name });
      if (this.mup == null)
      {
        ae.i("MicroMsg.AppBrandDeviceOrientationHandler", "PendingNotify: Listener is null when execute.");
        AppMethodBeat.o(176716);
        return;
      }
      this.mup.a(this.muq, this.success);
      AppMethodBeat.o(176716);
    }
  }
  
  static final class b
  {
    e.a mup;
    e.b muq;
    
    private b(e.b paramb, e.a parama)
    {
      this.muq = paramb;
      this.mup = parama;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(176717);
      String str = "Req{" + this.muq + ", " + this.mup + "}";
      AppMethodBeat.o(176717);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.g
 * JD-Core Version:    0.7.0.1
 */