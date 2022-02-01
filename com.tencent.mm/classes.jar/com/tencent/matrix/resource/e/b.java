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
  implements com.tencent.matrix.b.c
{
  final a.b cYD;
  Intent cYF;
  public final com.tencent.matrix.resource.b cZD;
  public final e cZE;
  final int cZF;
  private final long cZG;
  private final long cZH;
  private final d cZI;
  public final c cZJ;
  final c.a cZK;
  final ConcurrentLinkedQueue<DestroyedActivityInfo> cZL;
  public b cZM = null;
  public final Application.ActivityLifecycleCallbacks cZN = new a()
  {
    public final void onActivityDestroyed(Activity paramAnonymousActivity)
    {
      b localb = b.this;
      String str = paramAnonymousActivity.getClass().getName();
      if ((!localb.cZD.cWP.cYE) && (localb.cYD != a.b.cYK) && (localb.eC(str)))
      {
        com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "activity leak with name %s had published, just ignore", new Object[] { str });
        return;
      }
      UUID localUUID = UUID.randomUUID();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MATRIX_RESCANARY_REFKEY_").append(str).append('_').append(Long.toHexString(localUUID.getMostSignificantBits())).append(Long.toHexString(localUUID.getLeastSignificantBits()));
      paramAnonymousActivity = new DestroyedActivityInfo(localStringBuilder.toString(), paramAnonymousActivity, str);
      localb.cZL.add(paramAnonymousActivity);
    }
  };
  public final e.a cZO = new e.a()
  {
    public final e.a.a Th()
    {
      if (b.this.cZL.isEmpty())
      {
        com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "DestroyedActivityInfo isEmpty!", new Object[0]);
        return e.a.a.dad;
      }
      if ((Debug.isDebuggerConnected()) && (!b.this.cZD.cWP.cYE))
      {
        com.tencent.matrix.g.c.w("Matrix.ActivityRefWatcher", "debugger is connected, to avoid fake result, detection was delayed.", new Object[0]);
        return e.a.a.dad;
      }
      Object localObject1 = new WeakReference(new Object());
      com.tencent.matrix.g.c.v("Matrix.ActivityRefWatcher", "triggering gc...", new Object[0]);
      Runtime.getRuntime().gc();
      Runtime.getRuntime().runFinalization();
      com.tencent.matrix.g.c.v("Matrix.ActivityRefWatcher", "gc was triggered.", new Object[0]);
      if (((WeakReference)localObject1).get() != null)
      {
        com.tencent.matrix.g.c.d("Matrix.ActivityRefWatcher", "system ignore our gc request, wait for next detection.", new Object[0]);
        return e.a.a.dad;
      }
      localObject1 = b.this.cZL.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (DestroyedActivityInfo)((Iterator)localObject1).next();
          if ((!b.this.cZD.cWP.cYE) && (b.this.eC(((DestroyedActivityInfo)localObject2).mActivityName)) && (b.this.cYD != a.b.cYK))
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
          if ((((DestroyedActivityInfo)localObject2).mDetectedCount < b.this.cZF) && (!b.this.cZD.cWP.cYE))
          {
            com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "activity with key [%s] should be recycled but actually still \nexists in %s times, wait for next detection to confirm.", new Object[] { ((DestroyedActivityInfo)localObject2).mKey, Integer.valueOf(((DestroyedActivityInfo)localObject2).mDetectedCount) });
            continue;
          }
          com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "activity with key [%s] was suspected to be a leaked instance. mode[%s]", new Object[] { ((DestroyedActivityInfo)localObject2).mKey, b.this.cYD });
          if (b.this.cYD == a.b.cYK)
          {
            if (!b.this.eC(((DestroyedActivityInfo)localObject2).mActivityName)) {
              localObject3 = new JSONObject();
            }
            try
            {
              ((JSONObject)localObject3).put("activity", ((DestroyedActivityInfo)localObject2).mActivityName);
              b.this.eB(((DestroyedActivityInfo)localObject2).mActivityName);
              b.this.cZD.onDetectIssue(new com.tencent.matrix.report.c((JSONObject)localObject3));
              if ((b.this.cZM == null) || (!b.this.cZM.G(((DestroyedActivityInfo)localObject2).mActivityName, ((DestroyedActivityInfo)localObject2).mKey))) {
                continue;
              }
              com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "activity [%s] with key [%s] has been dumped. stop polling", new Object[] { ((DestroyedActivityInfo)localObject2).mActivityName, ((DestroyedActivityInfo)localObject2).mKey });
              ((Iterator)localObject1).remove();
            }
            catch (JSONException localJSONException1)
            {
              for (;;)
              {
                com.tencent.matrix.g.c.printErrStackTrace("Matrix.ActivityRefWatcher", localJSONException1, "unexpected exception.", new Object[0]);
              }
            }
          }
          if (b.this.cYD == a.b.cYI)
          {
            localObject3 = b.this.cZJ.Ti();
            if (localObject3 != null)
            {
              b.this.eB(((DestroyedActivityInfo)localObject2).mActivityName);
              localObject2 = new f((File)localObject3, ((DestroyedActivityInfo)localObject2).mKey, ((DestroyedActivityInfo)localObject2).mActivityName);
              b.this.cZK.a((f)localObject2);
              ((Iterator)localObject1).remove();
              continue;
            }
            com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "heap dump for further analyzing activity with key [%s] was failed, just ignore.", new Object[] { ((DestroyedActivityInfo)localObject2).mKey });
            ((Iterator)localObject1).remove();
            continue;
          }
          if (b.this.cYD == a.b.cYJ)
          {
            localObject3 = (NotificationManager)b.this.context.getSystemService("notification");
            Object localObject4 = b.this.context.getString(2131764625);
            Object localObject6 = ((DestroyedActivityInfo)localObject2).mActivityName;
            b.this.cYF.putExtra("activity", ((DestroyedActivityInfo)localObject2).mActivityName);
            b.this.cYF.putExtra("ref_key", ((DestroyedActivityInfo)localObject2).mKey);
            Object localObject5 = PendingIntent.getActivity(b.this.context, 0, b.this.cYF, 134217728);
            localObject6 = new s.c(b.this.context).f((CharSequence)localObject6);
            ((s.c)localObject6).Hv = ((PendingIntent)localObject5);
            localObject4 = ((s.c)localObject6).g((CharSequence)localObject4);
            localObject6 = b.this.context;
            ((s.c)localObject4).as(2131233059).i(System.currentTimeMillis());
            if (Build.VERSION.SDK_INT >= 26)
            {
              localObject5 = ((Context)localObject6).getString(2131755908);
              localObject6 = (NotificationManager)((Context)localObject6).getSystemService("notification");
              if (((NotificationManager)localObject6).getNotificationChannel((String)localObject5) == null) {
                ((NotificationManager)localObject6).createNotificationChannel(new NotificationChannel((String)localObject5, (CharSequence)localObject5, 3));
              }
              ((s.c)localObject4).mChannelId = ((String)localObject5);
            }
            ((NotificationManager)localObject3).notify(272, ((s.c)localObject4).build());
            ((Iterator)localObject1).remove();
            b.this.eB(((DestroyedActivityInfo)localObject2).mActivityName);
            com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "show notification for notify activity leak. %s", new Object[] { ((DestroyedActivityInfo)localObject2).mActivityName });
            continue;
          }
          com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "lightweight mode, just report leaked activity name.", new Object[0]);
          b.this.eB(((DestroyedActivityInfo)localObject2).mActivityName);
          Object localObject3 = new JSONObject();
          try
          {
            ((JSONObject)localObject3).put("activity", ((DestroyedActivityInfo)localObject2).mActivityName);
            b.this.cZD.onDetectIssue(new com.tencent.matrix.report.c((JSONObject)localObject3));
            if (b.this.cZM != null) {
              b.this.cZM.H(((DestroyedActivityInfo)localObject2).mActivityName, ((DestroyedActivityInfo)localObject2).mKey);
            }
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              com.tencent.matrix.g.c.printErrStackTrace("Matrix.ActivityRefWatcher", localJSONException2, "unexpected exception.", new Object[0]);
            }
          }
        }
      }
      return e.a.a.dad;
    }
  };
  
  public b(Application paramApplication, com.tencent.matrix.resource.b paramb)
  {
    this(paramApplication, paramb, new a());
  }
  
  private b(Application paramApplication, com.tencent.matrix.resource.b paramb, a parama)
  {
    super(paramApplication, paramb.getTag(), paramb);
    this.cZD = paramb;
    paramb = paramb.cWP;
    HandlerThread localHandlerThread = com.tencent.matrix.g.b.TP();
    this.cYD = paramb.cYD;
    this.cZG = paramb.cQF.get(a.a.RAt.name(), com.tencent.matrix.resource.b.a.cYB);
    this.cZH = paramb.Tb();
    this.cYF = paramb.cYF;
    this.cZE = new e(paramb.Tb(), localHandlerThread);
    this.cZF = paramb.cQF.get(a.a.RAu.name(), 10);
    this.cZI = new d(paramApplication);
    this.cZJ = new c(paramApplication, this.cZI);
    this.cZK = new b.a.1(parama, paramApplication);
    this.cZL = new ConcurrentLinkedQueue();
  }
  
  private void Tg()
  {
    this.cZE.Tm();
    this.cZL.clear();
  }
  
  public final void Tf()
  {
    Application localApplication = this.cZD.getApplication();
    if (localApplication != null)
    {
      localApplication.unregisterActivityLifecycleCallbacks(this.cZN);
      com.tencent.matrix.a.cPA.b(this);
      Tg();
    }
  }
  
  public final void onForeground(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "we are in foreground, modify scan time[%sms].", new Object[] { Long.valueOf(this.cZH) });
      this.cZE.Tm();
      this.cZE.cZY = this.cZH;
      this.cZE.a(this.cZO, 0);
      return;
    }
    com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "we are in background, modify scan time[%sms].", new Object[] { Long.valueOf(this.cZG) });
    this.cZE.cZY = this.cZG;
  }
  
  public static final class a {}
  
  public static abstract interface b
  {
    public abstract boolean G(String paramString1, String paramString2);
    
    public abstract boolean H(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.resource.e.b
 * JD-Core Version:    0.7.0.1
 */