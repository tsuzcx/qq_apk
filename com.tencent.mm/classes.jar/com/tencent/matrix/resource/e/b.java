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
import com.tencent.matrix.resource.CanaryWorkerService;
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
  final a.b cIg;
  Intent cIi;
  public final com.tencent.matrix.resource.b cJg;
  public final e cJh;
  final int cJi;
  private final long cJj;
  private final long cJk;
  private final d cJl;
  public final c cJm;
  final c.a cJn;
  final ConcurrentLinkedQueue<DestroyedActivityInfo> cJo;
  public b cJp = null;
  public final Application.ActivityLifecycleCallbacks cJq = new a()
  {
    public final void onActivityDestroyed(Activity paramAnonymousActivity)
    {
      b localb = b.this;
      String str = paramAnonymousActivity.getClass().getName();
      if ((!localb.cJg.cGr.cIh) && (localb.cIg != a.b.cIn) && (localb.dS(str)))
      {
        com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "activity leak with name %s had published, just ignore", new Object[] { str });
        return;
      }
      UUID localUUID = UUID.randomUUID();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MATRIX_RESCANARY_REFKEY_").append(str).append('_').append(Long.toHexString(localUUID.getMostSignificantBits())).append(Long.toHexString(localUUID.getLeastSignificantBits()));
      paramAnonymousActivity = new DestroyedActivityInfo(localStringBuilder.toString(), paramAnonymousActivity, str);
      localb.cJo.add(paramAnonymousActivity);
    }
  };
  public final e.a cJr = new e.a()
  {
    public final e.a.a IT()
    {
      if (b.this.cJo.isEmpty())
      {
        com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "DestroyedActivityInfo isEmpty!", new Object[0]);
        return e.a.a.cJG;
      }
      if ((Debug.isDebuggerConnected()) && (!b.this.cJg.cGr.cIh))
      {
        com.tencent.matrix.g.c.w("Matrix.ActivityRefWatcher", "debugger is connected, to avoid fake result, detection was delayed.", new Object[0]);
        return e.a.a.cJG;
      }
      Object localObject1 = new WeakReference(new Object());
      com.tencent.matrix.g.c.v("Matrix.ActivityRefWatcher", "triggering gc...", new Object[0]);
      Runtime.getRuntime().gc();
      Runtime.getRuntime().runFinalization();
      com.tencent.matrix.g.c.v("Matrix.ActivityRefWatcher", "gc was triggered.", new Object[0]);
      if (((WeakReference)localObject1).get() != null)
      {
        com.tencent.matrix.g.c.d("Matrix.ActivityRefWatcher", "system ignore our gc request, wait for next detection.", new Object[0]);
        return e.a.a.cJG;
      }
      localObject1 = b.this.cJo.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (DestroyedActivityInfo)((Iterator)localObject1).next();
          if ((!b.this.cJg.cGr.cIh) && (b.this.dS(((DestroyedActivityInfo)localObject2).mActivityName)) && (b.this.cIg != a.b.cIn))
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
          if ((((DestroyedActivityInfo)localObject2).mDetectedCount < b.this.cJi) && (!b.this.cJg.cGr.cIh))
          {
            com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "activity with key [%s] should be recycled but actually still \nexists in %s times, wait for next detection to confirm.", new Object[] { ((DestroyedActivityInfo)localObject2).mKey, Integer.valueOf(((DestroyedActivityInfo)localObject2).mDetectedCount) });
            continue;
          }
          com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "activity with key [%s] was suspected to be a leaked instance. mode[%s]", new Object[] { ((DestroyedActivityInfo)localObject2).mKey, b.this.cIg });
          if (b.this.cIg == a.b.cIn)
          {
            if (!b.this.dS(((DestroyedActivityInfo)localObject2).mActivityName)) {
              localObject3 = new JSONObject();
            }
            try
            {
              ((JSONObject)localObject3).put("activity", ((DestroyedActivityInfo)localObject2).mActivityName);
              b.this.dR(((DestroyedActivityInfo)localObject2).mActivityName);
              b.this.cJg.onDetectIssue(new com.tencent.matrix.report.c((JSONObject)localObject3));
              if ((b.this.cJp == null) || (!b.this.cJp.G(((DestroyedActivityInfo)localObject2).mActivityName, ((DestroyedActivityInfo)localObject2).mKey))) {
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
          if (b.this.cIg == a.b.cIl)
          {
            localObject3 = b.this.cJm.IU();
            if (localObject3 != null)
            {
              b.this.dR(((DestroyedActivityInfo)localObject2).mActivityName);
              localObject2 = new f((File)localObject3, ((DestroyedActivityInfo)localObject2).mKey, ((DestroyedActivityInfo)localObject2).mActivityName);
              b.this.cJn.a((f)localObject2);
              ((Iterator)localObject1).remove();
              continue;
            }
            com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "heap dump for further analyzing activity with key [%s] was failed, just ignore.", new Object[] { ((DestroyedActivityInfo)localObject2).mKey });
            ((Iterator)localObject1).remove();
            continue;
          }
          if (b.this.cIg == a.b.cIm)
          {
            localObject3 = (NotificationManager)b.this.context.getSystemService("notification");
            Object localObject4 = b.this.context.getString(2131762556);
            Object localObject6 = ((DestroyedActivityInfo)localObject2).mActivityName;
            b.this.cIi.putExtra("activity", ((DestroyedActivityInfo)localObject2).mActivityName);
            b.this.cIi.putExtra("ref_key", ((DestroyedActivityInfo)localObject2).mKey);
            Object localObject5 = PendingIntent.getActivity(b.this.context, 0, b.this.cIi, 134217728);
            localObject6 = new s.c(b.this.context).f((CharSequence)localObject6);
            ((s.c)localObject6).Hl = ((PendingIntent)localObject5);
            localObject4 = ((s.c)localObject6).g((CharSequence)localObject4);
            localObject6 = b.this.context;
            ((s.c)localObject4).as(2131232651).i(System.currentTimeMillis());
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
            b.this.dR(((DestroyedActivityInfo)localObject2).mActivityName);
            com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "show notification for notify activity leak. %s", new Object[] { ((DestroyedActivityInfo)localObject2).mActivityName });
            continue;
          }
          com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "lightweight mode, just report leaked activity name.", new Object[0]);
          b.this.dR(((DestroyedActivityInfo)localObject2).mActivityName);
          Object localObject3 = new JSONObject();
          try
          {
            ((JSONObject)localObject3).put("activity", ((DestroyedActivityInfo)localObject2).mActivityName);
            b.this.cJg.onDetectIssue(new com.tencent.matrix.report.c((JSONObject)localObject3));
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
      return e.a.a.cJG;
    }
  };
  
  public b(Application paramApplication, com.tencent.matrix.resource.b paramb)
  {
    this(paramApplication, paramb, new a());
  }
  
  private b(Application paramApplication, com.tencent.matrix.resource.b paramb, a parama)
  {
    super(paramApplication, paramb.getTag(), paramb);
    this.cJg = paramb;
    paramb = paramb.cGr;
    HandlerThread localHandlerThread = com.tencent.matrix.g.b.JB();
    this.cIg = paramb.cIg;
    this.cJj = paramb.cCj.get(a.a.Mab.name(), com.tencent.matrix.resource.b.a.cIe);
    this.cJk = paramb.IN();
    this.cIi = paramb.cIi;
    this.cJh = new e(paramb.IN(), localHandlerThread);
    this.cJi = paramb.cCj.get(a.a.Mac.name(), 10);
    this.cJl = new d(paramApplication);
    this.cJm = new c(paramApplication, this.cJl);
    this.cJn = new b.a.1(parama, paramApplication);
    this.cJo = new ConcurrentLinkedQueue();
  }
  
  private void IS()
  {
    this.cJh.IY();
    this.cJo.clear();
  }
  
  public final void IR()
  {
    Application localApplication = this.cJg.getApplication();
    if (localApplication != null)
    {
      localApplication.unregisterActivityLifecycleCallbacks(this.cJq);
      com.tencent.matrix.a.cBz.b(this);
      IS();
    }
  }
  
  public final void onForeground(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "we are in foreground, modify scan time[%sms].", new Object[] { Long.valueOf(this.cJk) });
      this.cJh.IY();
      this.cJh.cJB = this.cJk;
      this.cJh.a(this.cJr, 0);
      return;
    }
    com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "we are in background, modify scan time[%sms].", new Object[] { Long.valueOf(this.cJj) });
    this.cJh.cJB = this.cJj;
  }
  
  public static final class a {}
  
  public static abstract interface b
  {
    public abstract boolean G(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.e.b
 * JD-Core Version:    0.7.0.1
 */