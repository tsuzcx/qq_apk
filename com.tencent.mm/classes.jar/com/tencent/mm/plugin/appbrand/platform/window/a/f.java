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
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.e.a;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  implements c
{
  private static final SparseArray<f> tLK;
  private int mCurrentOrientation;
  public boolean mFinished;
  private j tLL;
  private b tLM;
  private b tLN;
  private WeakReference<Activity> tLO;
  private ContentObserver tLP;
  private e.b tLQ;
  private g tLR;
  
  static
  {
    AppMethodBeat.i(176737);
    tLK = new SparseArray();
    AppMethodBeat.o(176737);
  }
  
  private f(Activity paramActivity)
  {
    AppMethodBeat.i(176719);
    this.mFinished = false;
    this.tLP = null;
    this.tLQ = null;
    this.tLR = null;
    Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationHandler construct");
    this.mCurrentOrientation = paramActivity.getResources().getConfiguration().orientation;
    this.tLO = new WeakReference(paramActivity);
    a(paramActivity, kK(cHT()));
    AppMethodBeat.o(176719);
  }
  
  public static f K(Activity paramActivity)
  {
    AppMethodBeat.i(176718);
    synchronized (tLK)
    {
      f localf2 = (f)tLK.get(paramActivity.hashCode());
      f localf1 = localf2;
      if (localf2 == null)
      {
        localf1 = new f(paramActivity);
        tLK.put(paramActivity.hashCode(), localf1);
      }
      AppMethodBeat.o(176718);
      return localf1;
    }
  }
  
  private static void a(Activity paramActivity, e.b paramb)
  {
    AppMethodBeat.i(317535);
    paramActivity.setRequestedOrientation(paramb.tLn);
    AppMethodBeat.o(317535);
  }
  
  private void a(final b paramb)
  {
    AppMethodBeat.i(176724);
    Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.requestDeviceOrientationImpl setRequestOrientation [%s]", new Object[] { paramb });
    final Activity localActivity = (Activity)this.tLO.get();
    if (localActivity == null)
    {
      Log.w("MicroMsg.AppBrandDeviceOrientationHandler", "hy: ui already released!");
      if (paramb.tLU != null) {
        paramb.tLU.onOrientationChanged(paramb.tLV, false);
      }
      AppMethodBeat.o(176724);
      return;
    }
    a(localActivity, paramb.tLV);
    if (b(paramb))
    {
      d(paramb.tLV);
      AppMethodBeat.o(176724);
      return;
    }
    if (this.tLR == null) {
      this.tLR = new g();
    }
    this.tLR.a(new g.a()
    {
      public final void cHV()
      {
        AppMethodBeat.i(176715);
        Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: trigger retry, request[%s]", new Object[] { paramb });
        if (!localActivity.isDestroyed()) {
          f.b(localActivity, paramb.tLV);
        }
        AppMethodBeat.o(176715);
      }
      
      public final void onTimeout()
      {
        AppMethodBeat.i(176714);
        Log.e("MicroMsg.AppBrandDeviceOrientationHandler", "hy: activity not turn to correct orientation for long time, request[%s]", new Object[] { paramb });
        if (paramb.tLU != null) {
          paramb.tLU.onOrientationChanged(paramb.tLV, false);
        }
        if (f.d(f.this) == null)
        {
          f.a(f.this, (j)e.T(j.class));
          if (f.d(f.this) != null) {
            f.d(f.this).a(f.this.kK(f.cHT()), paramb.tLV);
          }
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
    parama.onOrientationChanged(paramb, paramBoolean);
    AppMethodBeat.o(176733);
  }
  
  private void a(e.b paramb, List<a> paramList)
  {
    AppMethodBeat.i(176730);
    if (paramb == this.tLN.tLV)
    {
      if (this.tLN.tLU != null) {
        paramList.add(new a(this.tLN.tLU, paramb, true, "PendingRequest.Listener orientation equal direct", (byte)0));
      }
      this.tLN = null;
      AppMethodBeat.o(176730);
      return;
    }
    if ((Activity)this.tLO.get() == null)
    {
      Log.e("MicroMsg.AppBrandDeviceOrientationHandler", "No Activity when handle pending request");
      if (this.tLN.tLU != null) {
        paramList.add(new a(this.tLN.tLU, paramb, false, "PendingRequest.Listener activity == null", (byte)0));
      }
      AppMethodBeat.o(176730);
      return;
    }
    this.tLM = this.tLN;
    this.tLN = null;
    a(this.tLM);
    AppMethodBeat.o(176730);
  }
  
  private e.b ai(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(176734);
    e.b localb;
    if (paramInt == 2)
    {
      Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == landscape ");
      if (paramBoolean)
      {
        Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: parseConfiguration configuration == landscape but screen locked");
        localb = e.b.tLk;
        AppMethodBeat.o(176734);
        return localb;
      }
      if (this.tLQ == e.b.tLl)
      {
        localb = e.b.tLl;
        AppMethodBeat.o(176734);
        return localb;
      }
      if (this.tLQ == e.b.tLm)
      {
        localb = e.b.tLm;
        AppMethodBeat.o(176734);
        return localb;
      }
      localb = e.b.tLj;
      AppMethodBeat.o(176734);
      return localb;
    }
    if (paramInt == 1)
    {
      Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == portrait ");
      localb = e.b.tLh;
      AppMethodBeat.o(176734);
      return localb;
    }
    Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(176734);
    return null;
  }
  
  private boolean b(b paramb)
  {
    AppMethodBeat.i(176725);
    Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "current orientation=" + this.mCurrentOrientation + "  request orientation=" + paramb.tLV);
    if ((this.mCurrentOrientation == 2) && ((paramb.tLV.b(e.b.tLj)) || (paramb.tLV.b(e.b.tLl)) || (paramb.tLV.b(e.b.tLm))))
    {
      Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same landscape");
      AppMethodBeat.o(176725);
      return true;
    }
    if ((this.mCurrentOrientation == 1) && (paramb.tLV.b(e.b.tLh)))
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
    if (paramb.tLV == e.b.tLi)
    {
      Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: request is UNSPECIFIED, return true");
      AppMethodBeat.o(176725);
      return true;
    }
    AppMethodBeat.o(176725);
    return false;
  }
  
  static boolean cHT()
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
  
  private void cHU()
  {
    AppMethodBeat.i(176726);
    if (this.tLR != null)
    {
      this.tLR.cHW();
      this.tLR = null;
    }
    AppMethodBeat.o(176726);
  }
  
  private void d(e.b paramb)
  {
    boolean bool3 = false;
    AppMethodBeat.i(176728);
    Object localObject1 = (Activity)this.tLO.get();
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
          if (this.tLM == null)
          {
            Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "No current request..., dismiss");
            return;
          }
          if (paramb == null) {}
          for (localObject1 = "null";; localObject1 = paramb.name())
          {
            Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.onConfigurationChanged [%s]", new Object[] { localObject1 });
            if (this.tLM.tLU != null)
            {
              localObject1 = this.tLM.tLU;
              bool1 = bool3;
              if (paramb != null)
              {
                bool1 = bool3;
                if (paramb.b(this.tLM.tLV)) {
                  bool1 = true;
                }
              }
              ((List)localObject2).add(new a((e.a)localObject1, paramb, bool1, "CurrentRequest.listener result received", (byte)0));
            }
            this.tLM = null;
            if (this.tLN != null) {
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
  
  public final void a(e.b paramb, e.a parama)
  {
    AppMethodBeat.i(176720);
    Object localObject = (Activity)this.tLO.get();
    e.b localb = kK(cHT());
    Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation reqOrientation = [%s], listener = [%s] currentOrientation = [%s], latestOrientation = [%s]", new Object[] { paramb, parama, localb, this.tLQ });
    if (localObject == null)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", new RuntimeException(), "No Activity found when request device orientation", new Object[0]);
      a(parama, localb, false);
      this.tLQ = paramb;
      AppMethodBeat.o(176720);
      return;
    }
    if (paramb == null)
    {
      Log.w("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation null");
      a(parama, localb, false);
      this.tLQ = paramb;
      AppMethodBeat.o(176720);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 24) && (((Activity)localObject).isInMultiWindowMode()))
    {
      Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation, activity[%s] isInMultiWindowMode, req[%s], callback fail", new Object[] { ((Activity)localObject).getLocalClassName(), paramb });
      cHU();
      a((Activity)localObject, paramb);
      if (parama != null) {
        if (localb != paramb) {
          break label211;
        }
      }
      label211:
      for (boolean bool = true;; bool = false)
      {
        parama.onOrientationChanged(localb, bool);
        AppMethodBeat.o(176720);
        return;
      }
    }
    if ((paramb == localb) && (this.tLQ != e.b.tLi))
    {
      Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation currentOrientation hit. [%s]", new Object[] { paramb });
      this.tLM = null;
      a(parama, paramb, true);
      this.tLQ = paramb;
      cHU();
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
          this.tLQ = paramb;
          return;
        }
        if (this.tLM == null)
        {
          this.tLM = new b(paramb, parama, (byte)0);
          a(this.tLM);
          localObject = null;
          if (localObject != null)
          {
            Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "dismissRequest not null");
            a(((b)localObject).tLU, localb, false);
          }
          this.tLQ = paramb;
          AppMethodBeat.o(176720);
          return;
        }
        if (this.tLN != null)
        {
          localObject = this.tLN;
          this.tLN = new b(paramb, parama, (byte)0);
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
  
  public final e.b cHQ()
  {
    AppMethodBeat.i(176732);
    e.b localb = kK(cHT());
    AppMethodBeat.o(176732);
    return localb;
  }
  
  final e.b kK(boolean paramBoolean)
  {
    AppMethodBeat.i(176731);
    Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "getCurrentOrientation");
    e.b localb = ai(this.mCurrentOrientation, paramBoolean);
    AppMethodBeat.o(176731);
    return localb;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(176727);
    cHU();
    this.mCurrentOrientation = paramConfiguration.orientation;
    Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "onConfigurationChanged  " + this.mCurrentOrientation);
    d(ai(this.mCurrentOrientation, cHT()));
    AppMethodBeat.o(176727);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(176722);
    if (this.tLP != null) {
      try
      {
        MMApplicationContext.getContext().getContentResolver().unregisterContentObserver(this.tLP);
        AppMethodBeat.o(176722);
        return;
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", localThrowable, "unregisterContentObserver", new Object[0]);
      }
    }
    AppMethodBeat.o(176722);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(176721);
    a(this.tLQ, null);
    ContentResolver localContentResolver = MMApplicationContext.getContext().getApplicationContext().getContentResolver();
    Uri localUri = Settings.System.getUriFor("accelerometer_rotation");
    this.tLP = new ContentObserver(new Handler())
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
        if ((f.a(f.this) != null) && (f.b(f.this).get() != null))
        {
          Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: need change");
          f.this.a(f.e(f.a(f.this)), null);
          f.c(f.this);
        }
        AppMethodBeat.o(176713);
      }
    };
    try
    {
      localContentResolver.registerContentObserver(localUri, false, this.tLP);
      AppMethodBeat.o(176721);
      return;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", localThrowable, "registerContentObserver [Settings.System.ACCELEROMETER_ROTATION] ", new Object[0]);
      AppMethodBeat.o(176721);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(176729);
    Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "release");
    synchronized (tLK)
    {
      int i = tLK.indexOfValue(this);
      if (i >= 0) {
        tLK.removeAt(i);
      }
    }
    try
    {
      if ((this.tLM == null) && (this.tLN == null))
      {
        Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "Every request is executed well");
        return;
        localObject2 = finally;
        throw localObject2;
      }
      Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "Still has request not executed current[%s] pending[%s]", new Object[] { this.tLM, this.tLN });
      this.tLM = null;
      this.tLN = null;
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
    boolean success;
    e.a tLU;
    e.b tLV;
    
    private a(e.a parama, e.b paramb, boolean paramBoolean, String paramString)
    {
      this.tLU = parama;
      this.tLV = paramb;
      this.success = paramBoolean;
      this.name = paramString;
    }
    
    final void execute()
    {
      AppMethodBeat.i(176716);
      Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "Notify Listener[%s]", new Object[] { this.name });
      if (this.tLU == null)
      {
        Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "PendingNotify: Listener is null when execute.");
        AppMethodBeat.o(176716);
        return;
      }
      this.tLU.onOrientationChanged(this.tLV, this.success);
      AppMethodBeat.o(176716);
    }
  }
  
  static final class b
  {
    e.a tLU;
    e.b tLV;
    
    private b(e.b paramb, e.a parama)
    {
      this.tLV = paramb;
      this.tLU = parama;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(176717);
      String str = "Req{" + this.tLV + ", " + this.tLU + "}";
      AppMethodBeat.o(176717);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.f
 * JD-Core Version:    0.7.0.1
 */