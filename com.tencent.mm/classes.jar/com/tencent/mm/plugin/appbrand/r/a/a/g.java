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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements c
{
  private static final SparseArray<g> lPr;
  private b lPs;
  private b lPt;
  private ContentObserver lPu;
  private e.b lPv;
  private h lPw;
  private WeakReference<Activity> lvU;
  private int mCurrentOrientation;
  public boolean mFinished;
  
  static
  {
    AppMethodBeat.i(176737);
    lPr = new SparseArray();
    AppMethodBeat.o(176737);
  }
  
  private g(Activity paramActivity)
  {
    AppMethodBeat.i(176719);
    this.mFinished = false;
    this.lPu = null;
    this.lPv = null;
    this.lPw = null;
    ac.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationHandler construct");
    this.mCurrentOrientation = paramActivity.getResources().getConfiguration().orientation;
    this.lvU = new WeakReference(paramActivity);
    a(paramActivity, hq(bsJ()));
    AppMethodBeat.o(176719);
  }
  
  public static g C(Activity paramActivity)
  {
    AppMethodBeat.i(176718);
    synchronized (lPr)
    {
      g localg2 = (g)lPr.get(paramActivity.hashCode());
      g localg1 = localg2;
      if (localg2 == null)
      {
        localg1 = new g(paramActivity);
        lPr.put(paramActivity.hashCode(), localg1);
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
      ac.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == landscape ");
      if (paramBoolean)
      {
        ac.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: parseConfiguration configuration == landscape but screen locked");
        localb = e.b.lOT;
        AppMethodBeat.o(176734);
        return localb;
      }
      if (this.lPv == e.b.lOU)
      {
        localb = e.b.lOU;
        AppMethodBeat.o(176734);
        return localb;
      }
      if (this.lPv == e.b.lOV)
      {
        localb = e.b.lOV;
        AppMethodBeat.o(176734);
        return localb;
      }
      localb = e.b.lOS;
      AppMethodBeat.o(176734);
      return localb;
    }
    if (paramInt == 1)
    {
      ac.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == portrait ");
      localb = e.b.lOQ;
      AppMethodBeat.o(176734);
      return localb;
    }
    ac.i("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(176734);
    return null;
  }
  
  private static void a(Activity paramActivity, e.b paramb)
  {
    AppMethodBeat.i(193515);
    paramActivity.setRequestedOrientation(paramb.lOW);
    AppMethodBeat.o(193515);
  }
  
  private void a(final b paramb)
  {
    AppMethodBeat.i(176724);
    ac.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.requestDeviceOrientationImpl setRequestOrientation [%s]", new Object[] { paramb });
    final Activity localActivity = (Activity)this.lvU.get();
    if (localActivity == null)
    {
      ac.w("MicroMsg.AppBrandDeviceOrientationHandler", "hy: ui already released!");
      if (paramb.lPz != null) {
        paramb.lPz.a(paramb.lPA, false);
      }
      AppMethodBeat.o(176724);
      return;
    }
    a(localActivity, paramb.lPA);
    if (b(paramb))
    {
      d(paramb.lPA);
      AppMethodBeat.o(176724);
      return;
    }
    if (this.lPw == null) {
      this.lPw = new h();
    }
    this.lPw.a(new h.a()
    {
      public final void bsL()
      {
        AppMethodBeat.i(176714);
        ac.e("MicroMsg.AppBrandDeviceOrientationHandler", "hy: activity not turn to correct orientation for long time, request[%s]", new Object[] { paramb });
        if (paramb.lPz != null) {
          paramb.lPz.a(paramb.lPA, false);
        }
        AppMethodBeat.o(176714);
      }
      
      public final void bsM()
      {
        AppMethodBeat.i(176715);
        ac.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: trigger retry, request[%s]", new Object[] { paramb });
        if (!localActivity.isDestroyed()) {
          g.b(localActivity, paramb.lPA);
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
    if (paramb == this.lPt.lPA)
    {
      if (this.lPt.lPz != null) {
        paramList.add(new a(this.lPt.lPz, paramb, true, "PendingRequest.Listener orientation equal direct", (byte)0));
      }
      this.lPt = null;
      AppMethodBeat.o(176730);
      return;
    }
    if ((Activity)this.lvU.get() == null)
    {
      ac.e("MicroMsg.AppBrandDeviceOrientationHandler", "No Activity when handle pending request");
      if (this.lPt.lPz != null) {
        paramList.add(new a(this.lPt.lPz, paramb, false, "PendingRequest.Listener activity == null", (byte)0));
      }
      AppMethodBeat.o(176730);
      return;
    }
    this.lPs = this.lPt;
    this.lPt = null;
    a(this.lPs);
    AppMethodBeat.o(176730);
  }
  
  private boolean b(b paramb)
  {
    AppMethodBeat.i(176725);
    ac.i("MicroMsg.AppBrandDeviceOrientationHandler", "current orientation=" + this.mCurrentOrientation + "  request orientation=" + paramb.lPA);
    if ((this.mCurrentOrientation == 2) && ((paramb.lPA.b(e.b.lOS)) || (paramb.lPA.b(e.b.lOU)) || (paramb.lPA.b(e.b.lOV))))
    {
      ac.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same landscape");
      AppMethodBeat.o(176725);
      return true;
    }
    if ((this.mCurrentOrientation == 1) && (paramb.lPA.b(e.b.lOQ)))
    {
      ac.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same portrait");
      AppMethodBeat.o(176725);
      return true;
    }
    if (this.mCurrentOrientation == 0)
    {
      ac.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: former is undefined, always return immediately");
      AppMethodBeat.o(176725);
      return true;
    }
    if (paramb.lPA == e.b.lOR)
    {
      ac.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: request is UNSPECIFIED, return true");
      AppMethodBeat.o(176725);
      return true;
    }
    AppMethodBeat.o(176725);
    return false;
  }
  
  private static boolean bsJ()
  {
    AppMethodBeat.i(176723);
    int i = Settings.System.getInt(ai.getContext().getContentResolver(), "accelerometer_rotation", 0);
    ac.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: systenm orientation %d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(176723);
      return false;
    }
    AppMethodBeat.o(176723);
    return true;
  }
  
  private void bsK()
  {
    AppMethodBeat.i(176726);
    if (this.lPw != null)
    {
      this.lPw.bsN();
      this.lPw = null;
    }
    AppMethodBeat.o(176726);
  }
  
  private void d(e.b paramb)
  {
    boolean bool3 = false;
    AppMethodBeat.i(176728);
    Object localObject1 = (Activity)this.lvU.get();
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
        ac.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", (Throwable)localObject2, "onConfigurationChanged activity[isNull ? %b] newConfig[isNull ? %b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        localObject2 = new LinkedList();
      }
      try
      {
        if (this.mFinished)
        {
          ac.i("MicroMsg.AppBrandDeviceOrientationHandler", "onConfigurationChanged Finished = true");
          return;
          label115:
          bool1 = false;
          continue;
          bool2 = false;
          break label52;
        }
        else
        {
          if (this.lPs == null)
          {
            ac.d("MicroMsg.AppBrandDeviceOrientationHandler", "No current request..., dismiss");
            return;
          }
          if (paramb == null) {}
          for (localObject1 = "null";; localObject1 = paramb.name())
          {
            ac.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.onConfigurationChanged [%s]", new Object[] { localObject1 });
            if (this.lPs.lPz != null)
            {
              localObject1 = this.lPs.lPz;
              bool1 = bool3;
              if (paramb != null)
              {
                bool1 = bool3;
                if (paramb.b(this.lPs.lPA)) {
                  bool1 = true;
                }
              }
              ((List)localObject2).add(new a((e.a)localObject1, paramb, bool1, "CurrentRequest.listener result received", (byte)0));
            }
            this.lPs = null;
            if (this.lPt != null) {
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
  
  private e.b hq(boolean paramBoolean)
  {
    AppMethodBeat.i(176731);
    ac.i("MicroMsg.AppBrandDeviceOrientationHandler", "getCurrentOrientation");
    e.b localb = K(this.mCurrentOrientation, paramBoolean);
    AppMethodBeat.o(176731);
    return localb;
  }
  
  public final void a(e.b paramb, e.a parama)
  {
    AppMethodBeat.i(176720);
    Object localObject = (Activity)this.lvU.get();
    e.b localb = hq(bsJ());
    ac.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation reqOrientation = [%s], listener = [%s] currentOrientation = [%s], latestOrientation = [%s]", new Object[] { paramb, parama, localb, this.lPv });
    if (localObject == null)
    {
      ac.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", new RuntimeException(), "No Activity found when request device orientation", new Object[0]);
      a(parama, localb, false);
      this.lPv = paramb;
      AppMethodBeat.o(176720);
      return;
    }
    if (paramb == null)
    {
      ac.w("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation null");
      a(parama, localb, false);
      this.lPv = paramb;
      AppMethodBeat.o(176720);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 24) && (((Activity)localObject).isInMultiWindowMode()))
    {
      ac.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation, activity[%s] isInMultiWindowMode, req[%s], callback fail", new Object[] { ((Activity)localObject).getLocalClassName(), paramb });
      bsK();
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
    if ((paramb == localb) && (this.lPv != e.b.lOR))
    {
      ac.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation currentOrientation hit. [%s]", new Object[] { paramb });
      this.lPs = null;
      a(parama, paramb, true);
      this.lPv = paramb;
      bsK();
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
          ac.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation mFinished = true");
          this.lPv = paramb;
          return;
        }
        if (this.lPs == null)
        {
          this.lPs = new b(paramb, parama, (byte)0);
          a(this.lPs);
          localObject = null;
          if (localObject != null)
          {
            ac.i("MicroMsg.AppBrandDeviceOrientationHandler", "dismissRequest not null");
            a(((b)localObject).lPz, localb, false);
          }
          this.lPv = paramb;
          AppMethodBeat.o(176720);
          return;
        }
        if (this.lPt != null)
        {
          localObject = this.lPt;
          this.lPt = new b(paramb, parama, (byte)0);
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
  
  public final e.b aUB()
  {
    AppMethodBeat.i(176732);
    e.b localb = hq(bsJ());
    AppMethodBeat.o(176732);
    return localb;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(176727);
    bsK();
    this.mCurrentOrientation = paramConfiguration.orientation;
    ac.i("MicroMsg.AppBrandDeviceOrientationHandler", "onConfigurationChanged  " + this.mCurrentOrientation);
    d(K(this.mCurrentOrientation, bsJ()));
    AppMethodBeat.o(176727);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(176722);
    if (this.lPu != null) {
      try
      {
        ai.getContext().getContentResolver().unregisterContentObserver(this.lPu);
        AppMethodBeat.o(176722);
        return;
      }
      catch (Throwable localThrowable)
      {
        ac.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", localThrowable, "unregisterContentObserver", new Object[0]);
      }
    }
    AppMethodBeat.o(176722);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(176721);
    a(this.lPv, null);
    ContentResolver localContentResolver = ai.getContext().getApplicationContext().getContentResolver();
    Uri localUri = Settings.System.getUriFor("accelerometer_rotation");
    this.lPu = new ContentObserver(new Handler())
    {
      public final boolean deliverSelfNotifications()
      {
        return true;
      }
      
      public final void onChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(176713);
        super.onChange(paramAnonymousBoolean);
        ac.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: lock orientation settings changed! request now");
        if ((g.a(g.this) != null) && (g.b(g.this).get() != null))
        {
          ac.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: need change");
          g.this.a(g.e(g.a(g.this)), null);
          g.c(g.this);
        }
        AppMethodBeat.o(176713);
      }
    };
    try
    {
      localContentResolver.registerContentObserver(localUri, false, this.lPu);
      AppMethodBeat.o(176721);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", localThrowable, "registerContentObserver [Settings.System.ACCELEROMETER_ROTATION] ", new Object[0]);
      AppMethodBeat.o(176721);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(176729);
    ac.i("MicroMsg.AppBrandDeviceOrientationHandler", "release");
    synchronized (lPr)
    {
      int i = lPr.indexOfValue(this);
      if (i >= 0) {
        lPr.removeAt(i);
      }
    }
    try
    {
      if ((this.lPs == null) && (this.lPt == null))
      {
        ac.i("MicroMsg.AppBrandDeviceOrientationHandler", "Every request is executed well");
        return;
        localObject2 = finally;
        throw localObject2;
      }
      ac.i("MicroMsg.AppBrandDeviceOrientationHandler", "Still has request not executed current[%s] pending[%s]", new Object[] { this.lPs, this.lPt });
      this.lPs = null;
      this.lPt = null;
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
    e.b lPA;
    e.a lPz;
    String name;
    boolean success;
    
    private a(e.a parama, e.b paramb, boolean paramBoolean, String paramString)
    {
      this.lPz = parama;
      this.lPA = paramb;
      this.success = paramBoolean;
      this.name = paramString;
    }
    
    final void execute()
    {
      AppMethodBeat.i(176716);
      ac.i("MicroMsg.AppBrandDeviceOrientationHandler", "Notify Listener[%s]", new Object[] { this.name });
      if (this.lPz == null)
      {
        ac.i("MicroMsg.AppBrandDeviceOrientationHandler", "PendingNotify: Listener is null when execute.");
        AppMethodBeat.o(176716);
        return;
      }
      this.lPz.a(this.lPA, this.success);
      AppMethodBeat.o(176716);
    }
  }
  
  static final class b
  {
    e.b lPA;
    e.a lPz;
    
    private b(e.b paramb, e.a parama)
    {
      this.lPA = paramb;
      this.lPz = parama;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(176717);
      String str = "Req{" + this.lPA + ", " + this.lPz + "}";
      AppMethodBeat.o(176717);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.a.g
 * JD-Core Version:    0.7.0.1
 */