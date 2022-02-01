package com.tencent.matrix.resource.e;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.HandlerThread;
import android.support.v4.app.s.c;
import com.tencent.c.a.a.a;
import com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo;
import com.tencent.matrix.resource.analyzer.model.f;
import com.tencent.matrix.resource.b.a.b;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends com.tencent.matrix.report.b
  implements com.tencent.matrix.b.b
{
  final c.a cAA;
  final ConcurrentLinkedQueue<DestroyedActivityInfo> cAB;
  public b cAC = null;
  public final Application.ActivityLifecycleCallbacks cAD = new a()
  {
    public final void onActivityDestroyed(Activity paramAnonymousActivity)
    {
      b localb = b.this;
      String str = paramAnonymousActivity.getClass().getName();
      if ((!localb.cAt.cxE.czu) && (localb.czt != a.b.czA) && (localb.cX(str)))
      {
        com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "activity leak with name %s had published, just ignore", new Object[] { str });
        return;
      }
      UUID localUUID = UUID.randomUUID();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MATRIX_RESCANARY_REFKEY_").append(str).append('_').append(Long.toHexString(localUUID.getMostSignificantBits())).append(Long.toHexString(localUUID.getLeastSignificantBits()));
      paramAnonymousActivity = new DestroyedActivityInfo(localStringBuilder.toString(), paramAnonymousActivity, str);
      localb.cAB.add(paramAnonymousActivity);
    }
  };
  public final e.a cAE = new e.a()
  {
    public final e.a.a HF()
    {
      if (b.this.cAB.isEmpty())
      {
        com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "DestroyedActivityInfo isEmpty!", new Object[0]);
        return e.a.a.cAT;
      }
      if ((Debug.isDebuggerConnected()) && (!b.this.cAt.cxE.czu))
      {
        com.tencent.matrix.g.c.w("Matrix.ActivityRefWatcher", "debugger is connected, to avoid fake result, detection was delayed.", new Object[0]);
        return e.a.a.cAT;
      }
      Object localObject1 = new WeakReference(new Object());
      com.tencent.matrix.g.c.v("Matrix.ActivityRefWatcher", "triggering gc...", new Object[0]);
      Runtime.getRuntime().gc();
      Runtime.getRuntime().runFinalization();
      com.tencent.matrix.g.c.v("Matrix.ActivityRefWatcher", "gc was triggered.", new Object[0]);
      if (((WeakReference)localObject1).get() != null)
      {
        com.tencent.matrix.g.c.d("Matrix.ActivityRefWatcher", "system ignore our gc request, wait for next detection.", new Object[0]);
        return e.a.a.cAT;
      }
      localObject1 = b.this.cAB.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (DestroyedActivityInfo)((Iterator)localObject1).next();
          if ((!b.this.cAt.cxE.czu) && (b.this.cX(((DestroyedActivityInfo)localObject2).mActivityName)) && (b.this.czt != a.b.czA))
          {
            com.tencent.matrix.g.c.v("Matrix.ActivityRefWatcher", "activity with key [%s] was already published.", new Object[] { ((DestroyedActivityInfo)localObject2).mActivityName });
            ((Iterator)localObject1).remove();
            continue;
          }
          if (((DestroyedActivityInfo)localObject2).mActivityRef.get() == null)
          {
            com.tencent.matrix.g.c.v("Matrix.ActivityRefWatcher", "activity with key [%s] was already recycled.", new Object[] { ((DestroyedActivityInfo)localObject2).mKey });
            ((Iterator)localObject1).remove();
            continue;
          }
          ((DestroyedActivityInfo)localObject2).mDetectedCount += 1;
          if ((((DestroyedActivityInfo)localObject2).mDetectedCount < b.this.cAv) && (!b.this.cAt.cxE.czu))
          {
            com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "activity with key [%s] should be recycled but actually still \nexists in %s times, wait for next detection to confirm.", new Object[] { ((DestroyedActivityInfo)localObject2).mKey, Integer.valueOf(((DestroyedActivityInfo)localObject2).mDetectedCount) });
            continue;
          }
          com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "activity with key [%s] was suspected to be a leaked instance. mode[%s]", new Object[] { ((DestroyedActivityInfo)localObject2).mKey, b.this.czt });
          if (b.this.czt == a.b.czA)
          {
            if (!b.this.cX(((DestroyedActivityInfo)localObject2).mActivityName)) {
              localObject3 = new JSONObject();
            }
            try
            {
              ((JSONObject)localObject3).put("activity", ((DestroyedActivityInfo)localObject2).mActivityName);
              b.this.cW(((DestroyedActivityInfo)localObject2).mActivityName);
              b.this.cAt.onDetectIssue(new com.tencent.matrix.report.c((JSONObject)localObject3));
              if ((b.this.cAC == null) || (!b.this.cAC.C(((DestroyedActivityInfo)localObject2).mActivityName, ((DestroyedActivityInfo)localObject2).mKey))) {
                continue;
              }
              com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "activity [%s] with key [%s] has been dumped. stop polling", new Object[] { ((DestroyedActivityInfo)localObject2).mActivityName, ((DestroyedActivityInfo)localObject2).mKey });
              ((Iterator)localObject1).remove();
            }
            catch (JSONException localJSONException2)
            {
              for (;;)
              {
                com.tencent.matrix.g.c.printErrStackTrace("Matrix.ActivityRefWatcher", localJSONException2, "unexpected exception.", new Object[0]);
              }
            }
          }
          if (b.this.czt == a.b.czy)
          {
            localObject3 = b.this.cAz.HG();
            if (localObject3 != null)
            {
              b.this.cW(((DestroyedActivityInfo)localObject2).mActivityName);
              localObject2 = new f((File)localObject3, ((DestroyedActivityInfo)localObject2).mKey, ((DestroyedActivityInfo)localObject2).mActivityName);
              b.this.cAA.a((f)localObject2);
              ((Iterator)localObject1).remove();
              continue;
            }
            com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "heap dump for further analyzing activity with key [%s] was failed, just ignore.", new Object[] { ((DestroyedActivityInfo)localObject2).mKey });
            ((Iterator)localObject1).remove();
            continue;
          }
          if (b.this.czt == a.b.czz)
          {
            localObject3 = (NotificationManager)b.this.context.getSystemService("notification");
            Object localObject4 = b.this.context.getString(2131762556);
            Object localObject6 = ((DestroyedActivityInfo)localObject2).mActivityName;
            b.this.czv.putExtra("activity", ((DestroyedActivityInfo)localObject2).mActivityName);
            b.this.czv.putExtra("ref_key", ((DestroyedActivityInfo)localObject2).mKey);
            Object localObject5 = PendingIntent.getActivity(b.this.context, 0, b.this.czv, 134217728);
            localObject6 = new s.c(b.this.context).f((CharSequence)localObject6);
            ((s.c)localObject6).Ew = ((PendingIntent)localObject5);
            localObject4 = ((s.c)localObject6).g((CharSequence)localObject4);
            localObject6 = b.this.context;
            ((s.c)localObject4).as(2131232651).g(System.currentTimeMillis());
            if (Build.VERSION.SDK_INT >= 26)
            {
              localObject5 = ((Context)localObject6).getString(2131755822);
              localObject6 = (NotificationManager)((Context)localObject6).getSystemService("notification");
              if (((NotificationManager)localObject6).getNotificationChannel((String)localObject5) == null) {
                ((NotificationManager)localObject6).createNotificationChannel(new NotificationChannel((String)localObject5, (CharSequence)localObject5, 3));
              }
              ((s.c)localObject4).mChannelId = ((String)localObject5);
            }
            ((NotificationManager)localObject3).notify(272, ((s.c)localObject4).build());
            ((Iterator)localObject1).remove();
            b.this.cW(((DestroyedActivityInfo)localObject2).mActivityName);
            com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "show notification for notify activity leak. %s", new Object[] { ((DestroyedActivityInfo)localObject2).mActivityName });
            continue;
          }
          com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "lightweight mode, just report leaked activity name.", new Object[0]);
          b.this.cW(((DestroyedActivityInfo)localObject2).mActivityName);
          Object localObject3 = new JSONObject();
          try
          {
            ((JSONObject)localObject3).put("activity", ((DestroyedActivityInfo)localObject2).mActivityName);
            b.this.cAt.onDetectIssue(new com.tencent.matrix.report.c((JSONObject)localObject3));
          }
          catch (JSONException localJSONException1)
          {
            for (;;)
            {
              com.tencent.matrix.g.c.printErrStackTrace("Matrix.ActivityRefWatcher", localJSONException1, "unexpected exception.", new Object[0]);
            }
          }
        }
      }
      return e.a.a.cAT;
    }
  };
  public final com.tencent.matrix.resource.b cAt;
  public final e cAu;
  final int cAv;
  private final long cAw;
  private final long cAx;
  private final d cAy;
  public final c cAz;
  final a.b czt;
  Intent czv;
  
  public b(Application paramApplication, com.tencent.matrix.resource.b paramb)
  {
    this(paramApplication, paramb, new b.a());
  }
  
  private b(Application paramApplication, com.tencent.matrix.resource.b paramb, b.a parama)
  {
    super(paramApplication, paramb.getTag(), paramb);
    this.cAt = paramb;
    paramb = paramb.cxE;
    HandlerThread localHandlerThread = com.tencent.matrix.g.b.Ip();
    this.czt = paramb.czt;
    this.cAw = paramb.cty.get(a.a.IhG.name(), com.tencent.matrix.resource.b.a.czr);
    this.cAx = paramb.Hz();
    this.czv = paramb.czv;
    this.cAu = new e(paramb.Hz(), localHandlerThread);
    this.cAv = paramb.cty.get(a.a.IhH.name(), 10);
    this.cAy = new d(paramApplication);
    this.cAz = new c(paramApplication, this.cAy);
    this.cAA = new b.a.1(parama, paramApplication);
    this.cAB = new ConcurrentLinkedQueue();
  }
  
  private void HE()
  {
    this.cAu.HK();
    this.cAB.clear();
  }
  
  public final void HD()
  {
    Application localApplication = this.cAt.getApplication();
    if (localApplication != null)
    {
      localApplication.unregisterActivityLifecycleCallbacks(this.cAD);
      com.tencent.matrix.a.csS.b(this);
      HE();
    }
  }
  
  public final void onForeground(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "we are in foreground, modify scan time[%sms].", new Object[] { Long.valueOf(this.cAx) });
      this.cAu.HK();
      this.cAu.cAO = this.cAx;
      this.cAu.a(this.cAE, 0);
      return;
    }
    com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "we are in background, modify scan time[%sms].", new Object[] { Long.valueOf(this.cAw) });
    this.cAu.cAO = this.cAw;
  }
  
  public static abstract interface b
  {
    public abstract boolean C(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.resource.e.b
 * JD-Core Version:    0.7.0.1
 */