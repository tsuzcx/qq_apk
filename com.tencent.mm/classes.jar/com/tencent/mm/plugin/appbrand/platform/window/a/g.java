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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements c
{
  private static final SparseArray<g> qHb;
  private int mCurrentOrientation;
  public boolean mFinished;
  private b qHc;
  private b qHd;
  private WeakReference<Activity> qHe;
  private ContentObserver qHf;
  private e.b qHg;
  private h qHh;
  
  static
  {
    AppMethodBeat.i(176737);
    qHb = new SparseArray();
    AppMethodBeat.o(176737);
  }
  
  private g(Activity paramActivity)
  {
    AppMethodBeat.i(176719);
    this.mFinished = false;
    this.qHf = null;
    this.qHg = null;
    this.qHh = null;
    Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationHandler construct");
    this.mCurrentOrientation = paramActivity.getResources().getConfiguration().orientation;
    this.qHe = new WeakReference(paramActivity);
    a(paramActivity, jx(cgW()));
    AppMethodBeat.o(176719);
  }
  
  public static g E(Activity paramActivity)
  {
    AppMethodBeat.i(176718);
    synchronized (qHb)
    {
      g localg2 = (g)qHb.get(paramActivity.hashCode());
      g localg1 = localg2;
      if (localg2 == null)
      {
        localg1 = new g(paramActivity);
        qHb.put(paramActivity.hashCode(), localg1);
      }
      AppMethodBeat.o(176718);
      return localg1;
    }
  }
  
  private e.b S(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(176734);
    e.b localb;
    if (paramInt == 2)
    {
      Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == landscape ");
      if (paramBoolean)
      {
        Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: parseConfiguration configuration == landscape but screen locked");
        localb = e.b.qGy;
        AppMethodBeat.o(176734);
        return localb;
      }
      if (this.qHg == e.b.qGz)
      {
        localb = e.b.qGz;
        AppMethodBeat.o(176734);
        return localb;
      }
      if (this.qHg == e.b.qGA)
      {
        localb = e.b.qGA;
        AppMethodBeat.o(176734);
        return localb;
      }
      localb = e.b.qGx;
      AppMethodBeat.o(176734);
      return localb;
    }
    if (paramInt == 1)
    {
      Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == portrait ");
      localb = e.b.qGv;
      AppMethodBeat.o(176734);
      return localb;
    }
    Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(176734);
    return null;
  }
  
  private static void a(Activity paramActivity, e.b paramb)
  {
    AppMethodBeat.i(244413);
    paramActivity.setRequestedOrientation(paramb.qGB);
    AppMethodBeat.o(244413);
  }
  
  private void a(final b paramb)
  {
    AppMethodBeat.i(176724);
    Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.requestDeviceOrientationImpl setRequestOrientation [%s]", new Object[] { paramb });
    final Activity localActivity = (Activity)this.qHe.get();
    if (localActivity == null)
    {
      Log.w("MicroMsg.AppBrandDeviceOrientationHandler", "hy: ui already released!");
      if (paramb.qHk != null) {
        paramb.qHk.a(paramb.qHl, false);
      }
      AppMethodBeat.o(176724);
      return;
    }
    a(localActivity, paramb.qHl);
    if (b(paramb))
    {
      d(paramb.qHl);
      AppMethodBeat.o(176724);
      return;
    }
    if (this.qHh == null) {
      this.qHh = new h();
    }
    this.qHh.a(new h.a()
    {
      public final void cgY()
      {
        AppMethodBeat.i(176715);
        Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: trigger retry, request[%s]", new Object[] { paramb });
        if (!localActivity.isDestroyed()) {
          g.b(localActivity, paramb.qHl);
        }
        AppMethodBeat.o(176715);
      }
      
      public final void onTimeout()
      {
        AppMethodBeat.i(176714);
        Log.e("MicroMsg.AppBrandDeviceOrientationHandler", "hy: activity not turn to correct orientation for long time, request[%s]", new Object[] { paramb });
        if (paramb.qHk != null) {
          paramb.qHk.a(paramb.qHl, false);
        }
        AppMethodBeat.o(176714);
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
    if (paramb == this.qHd.qHl)
    {
      if (this.qHd.qHk != null) {
        paramList.add(new a(this.qHd.qHk, paramb, true, "PendingRequest.Listener orientation equal direct", (byte)0));
      }
      this.qHd = null;
      AppMethodBeat.o(176730);
      return;
    }
    if ((Activity)this.qHe.get() == null)
    {
      Log.e("MicroMsg.AppBrandDeviceOrientationHandler", "No Activity when handle pending request");
      if (this.qHd.qHk != null) {
        paramList.add(new a(this.qHd.qHk, paramb, false, "PendingRequest.Listener activity == null", (byte)0));
      }
      AppMethodBeat.o(176730);
      return;
    }
    this.qHc = this.qHd;
    this.qHd = null;
    a(this.qHc);
    AppMethodBeat.o(176730);
  }
  
  private boolean b(b paramb)
  {
    AppMethodBeat.i(176725);
    Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "current orientation=" + this.mCurrentOrientation + "  request orientation=" + paramb.qHl);
    if ((this.mCurrentOrientation == 2) && ((paramb.qHl.b(e.b.qGx)) || (paramb.qHl.b(e.b.qGz)) || (paramb.qHl.b(e.b.qGA))))
    {
      Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same landscape");
      AppMethodBeat.o(176725);
      return true;
    }
    if ((this.mCurrentOrientation == 1) && (paramb.qHl.b(e.b.qGv)))
    {
      Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same portrait");
      AppMethodBeat.o(176725);
      return true;
    }
    if (this.mCurrentOrientation == 0)
    {
      Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: former is undefined, always return immediately");
      AppMethodBeat.o(176725);
      return true;
    }
    if (paramb.qHl == e.b.qGw)
    {
      Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: request is UNSPECIFIED, return true");
      AppMethodBeat.o(176725);
      return true;
    }
    AppMethodBeat.o(176725);
    return false;
  }
  
  private static boolean cgW()
  {
    AppMethodBeat.i(176723);
    int i = Settings.System.getInt(MMApplicationContext.getContext().getContentResolver(), "accelerometer_rotation", 0);
    Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: systenm orientation %d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(176723);
      return false;
    }
    AppMethodBeat.o(176723);
    return true;
  }
  
  private void cgX()
  {
    AppMethodBeat.i(176726);
    if (this.qHh != null)
    {
      this.qHh.cgZ();
      this.qHh = null;
    }
    AppMethodBeat.o(176726);
  }
  
  private void d(e.b paramb)
  {
    boolean bool3 = false;
    AppMethodBeat.i(176728);
    Object localObject1 = (Activity)this.qHe.get();
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
        Log.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", (Throwable)localObject2, "onConfigurationChanged activity[isNull ? %b] newConfig[isNull ? %b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        localObject2 = new LinkedList();
      }
      try
      {
        if (this.mFinished)
        {
          Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "onConfigurationChanged Finished = true");
          return;
          label115:
          bool1 = false;
          continue;
          bool2 = false;
          break label52;
        }
        else
        {
          if (this.qHc == null)
          {
            Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "No current request..., dismiss");
            return;
          }
          if (paramb == null) {}
          for (localObject1 = "null";; localObject1 = paramb.name())
          {
            Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.onConfigurationChanged [%s]", new Object[] { localObject1 });
            if (this.qHc.qHk != null)
            {
              localObject1 = this.qHc.qHk;
              bool1 = bool3;
              if (paramb != null)
              {
                bool1 = bool3;
                if (paramb.b(this.qHc.qHl)) {
                  bool1 = true;
                }
              }
              ((List)localObject2).add(new a((e.a)localObject1, paramb, bool1, "CurrentRequest.listener result received", (byte)0));
            }
            this.qHc = null;
            if (this.qHd != null) {
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
  
  private e.b jx(boolean paramBoolean)
  {
    AppMethodBeat.i(176731);
    Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "getCurrentOrientation");
    e.b localb = S(this.mCurrentOrientation, paramBoolean);
    AppMethodBeat.o(176731);
    return localb;
  }
  
  public final void a(e.b paramb, e.a parama)
  {
    AppMethodBeat.i(176720);
    Object localObject = (Activity)this.qHe.get();
    e.b localb = jx(cgW());
    Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation reqOrientation = [%s], listener = [%s] currentOrientation = [%s], latestOrientation = [%s]", new Object[] { paramb, parama, localb, this.qHg });
    if (localObject == null)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", new RuntimeException(), "No Activity found when request device orientation", new Object[0]);
      a(parama, localb, false);
      this.qHg = paramb;
      AppMethodBeat.o(176720);
      return;
    }
    if (paramb == null)
    {
      Log.w("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation null");
      a(parama, localb, false);
      this.qHg = paramb;
      AppMethodBeat.o(176720);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 24) && (((Activity)localObject).isInMultiWindowMode()))
    {
      Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation, activity[%s] isInMultiWindowMode, req[%s], callback fail", new Object[] { ((Activity)localObject).getLocalClassName(), paramb });
      cgX();
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
    if ((paramb == localb) && (this.qHg != e.b.qGw))
    {
      Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation currentOrientation hit. [%s]", new Object[] { paramb });
      this.qHc = null;
      a(parama, paramb, true);
      this.qHg = paramb;
      cgX();
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
          Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation mFinished = true");
          this.qHg = paramb;
          return;
        }
        if (this.qHc == null)
        {
          this.qHc = new b(paramb, parama, (byte)0);
          a(this.qHc);
          localObject = null;
          if (localObject != null)
          {
            Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "dismissRequest not null");
            a(((b)localObject).qHk, localb, false);
          }
          this.qHg = paramb;
          AppMethodBeat.o(176720);
          return;
        }
        if (this.qHd != null)
        {
          localObject = this.qHd;
          this.qHd = new b(paramb, parama, (byte)0);
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
  
  public final e.b cgS()
  {
    AppMethodBeat.i(176732);
    e.b localb = jx(cgW());
    AppMethodBeat.o(176732);
    return localb;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(176727);
    cgX();
    this.mCurrentOrientation = paramConfiguration.orientation;
    Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "onConfigurationChanged  " + this.mCurrentOrientation);
    d(S(this.mCurrentOrientation, cgW()));
    AppMethodBeat.o(176727);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(176722);
    if (this.qHf != null) {
      try
      {
        MMApplicationContext.getContext().getContentResolver().unregisterContentObserver(this.qHf);
        AppMethodBeat.o(176722);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", localThrowable, "unregisterContentObserver", new Object[0]);
      }
    }
    AppMethodBeat.o(176722);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(176721);
    a(this.qHg, null);
    ContentResolver localContentResolver = MMApplicationContext.getContext().getApplicationContext().getContentResolver();
    Uri localUri = Settings.System.getUriFor("accelerometer_rotation");
    this.qHf = new ContentObserver(new Handler())
    {
      public final boolean deliverSelfNotifications()
      {
        return true;
      }
      
      public final void onChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(176713);
        super.onChange(paramAnonymousBoolean);
        Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: lock orientation settings changed! request now");
        if ((g.a(g.this) != null) && (g.b(g.this).get() != null))
        {
          Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: need change");
          g.this.a(g.e(g.a(g.this)), null);
          g.c(g.this);
        }
        AppMethodBeat.o(176713);
      }
    };
    try
    {
      localContentResolver.registerContentObserver(localUri, false, this.qHf);
      AppMethodBeat.o(176721);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", localThrowable, "registerContentObserver [Settings.System.ACCELEROMETER_ROTATION] ", new Object[0]);
      AppMethodBeat.o(176721);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(176729);
    Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "release");
    synchronized (qHb)
    {
      int i = qHb.indexOfValue(this);
      if (i >= 0) {
        qHb.removeAt(i);
      }
    }
    try
    {
      if ((this.qHc == null) && (this.qHd == null))
      {
        Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "Every request is executed well");
        return;
        localObject2 = finally;
        throw localObject2;
      }
      Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "Still has request not executed current[%s] pending[%s]", new Object[] { this.qHc, this.qHd });
      this.qHc = null;
      this.qHd = null;
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
    String name;
    e.a qHk;
    e.b qHl;
    boolean success;
    
    private a(e.a parama, e.b paramb, boolean paramBoolean, String paramString)
    {
      this.qHk = parama;
      this.qHl = paramb;
      this.success = paramBoolean;
      this.name = paramString;
    }
    
    final void execute()
    {
      AppMethodBeat.i(176716);
      Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "Notify Listener[%s]", new Object[] { this.name });
      if (this.qHk == null)
      {
        Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "PendingNotify: Listener is null when execute.");
        AppMethodBeat.o(176716);
        return;
      }
      this.qHk.a(this.qHl, this.success);
      AppMethodBeat.o(176716);
    }
  }
  
  static final class b
  {
    e.a qHk;
    e.b qHl;
    
    private b(e.b paramb, e.a parama)
    {
      this.qHl = paramb;
      this.qHk = parama;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(176717);
      String str = "Req{" + this.qHl + ", " + this.qHk + "}";
      AppMethodBeat.o(176717);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.g
 * JD-Core Version:    0.7.0.1
 */