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
  final a.b cwC;
  Intent cwE;
  public final com.tencent.matrix.resource.b cxC;
  public final e cxD;
  final int cxE;
  private final long cxF;
  private final long cxG;
  private final d cxH;
  public final c cxI;
  final c.a cxJ;
  final ConcurrentLinkedQueue<DestroyedActivityInfo> cxK;
  public b cxL = null;
  public final Application.ActivityLifecycleCallbacks cxM = new a()
  {
    public final void onActivityDestroyed(Activity paramAnonymousActivity)
    {
      b localb = b.this;
      String str = paramAnonymousActivity.getClass().getName();
      if ((!localb.cxC.cuN.cwD) && (localb.cwC != a.b.cwJ) && (localb.cM(str)))
      {
        com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "activity leak with name %s had published, just ignore", new Object[] { str });
        return;
      }
      UUID localUUID = UUID.randomUUID();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MATRIX_RESCANARY_REFKEY_").append(str).append('_').append(Long.toHexString(localUUID.getMostSignificantBits())).append(Long.toHexString(localUUID.getLeastSignificantBits()));
      paramAnonymousActivity = new DestroyedActivityInfo(localStringBuilder.toString(), paramAnonymousActivity, str);
      localb.cxK.add(paramAnonymousActivity);
    }
  };
  public final e.a cxN = new e.a()
  {
    public final e.a.a Hq()
    {
      if (b.this.cxK.isEmpty())
      {
        com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "DestroyedActivityInfo isEmpty!", new Object[0]);
        return e.a.a.cyc;
      }
      if ((Debug.isDebuggerConnected()) && (!b.this.cxC.cuN.cwD))
      {
        com.tencent.matrix.g.c.w("Matrix.ActivityRefWatcher", "debugger is connected, to avoid fake result, detection was delayed.", new Object[0]);
        return e.a.a.cyc;
      }
      Object localObject1 = new WeakReference(new Object());
      com.tencent.matrix.g.c.v("Matrix.ActivityRefWatcher", "triggering gc...", new Object[0]);
      Runtime.getRuntime().gc();
      Runtime.getRuntime().runFinalization();
      com.tencent.matrix.g.c.v("Matrix.ActivityRefWatcher", "gc was triggered.", new Object[0]);
      if (((WeakReference)localObject1).get() != null)
      {
        com.tencent.matrix.g.c.d("Matrix.ActivityRefWatcher", "system ignore our gc request, wait for next detection.", new Object[0]);
        return e.a.a.cyc;
      }
      localObject1 = b.this.cxK.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (DestroyedActivityInfo)((Iterator)localObject1).next();
          if ((!b.this.cxC.cuN.cwD) && (b.this.cM(((DestroyedActivityInfo)localObject2).mActivityName)) && (b.this.cwC != a.b.cwJ))
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
          if ((((DestroyedActivityInfo)localObject2).mDetectedCount < b.this.cxE) && (!b.this.cxC.cuN.cwD))
          {
            com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "activity with key [%s] should be recycled but actually still \nexists in %s times, wait for next detection to confirm.", new Object[] { ((DestroyedActivityInfo)localObject2).mKey, Integer.valueOf(((DestroyedActivityInfo)localObject2).mDetectedCount) });
            continue;
          }
          com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "activity with key [%s] was suspected to be a leaked instance. mode[%s]", new Object[] { ((DestroyedActivityInfo)localObject2).mKey, b.this.cwC });
          if (b.this.cwC == a.b.cwJ)
          {
            if (!b.this.cM(((DestroyedActivityInfo)localObject2).mActivityName)) {
              localObject3 = new JSONObject();
            }
            try
            {
              ((JSONObject)localObject3).put("activity", ((DestroyedActivityInfo)localObject2).mActivityName);
              b.this.cL(((DestroyedActivityInfo)localObject2).mActivityName);
              b.this.cxC.onDetectIssue(new com.tencent.matrix.report.c((JSONObject)localObject3));
              if ((b.this.cxL == null) || (!b.this.cxL.F(((DestroyedActivityInfo)localObject2).mActivityName, ((DestroyedActivityInfo)localObject2).mKey))) {
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
          if (b.this.cwC == a.b.cwH)
          {
            localObject3 = b.this.cxI.Hr();
            if (localObject3 != null)
            {
              b.this.cL(((DestroyedActivityInfo)localObject2).mActivityName);
              localObject2 = new f((File)localObject3, ((DestroyedActivityInfo)localObject2).mKey, ((DestroyedActivityInfo)localObject2).mActivityName);
              b.this.cxJ.a((f)localObject2);
              ((Iterator)localObject1).remove();
              continue;
            }
            com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "heap dump for further analyzing activity with key [%s] was failed, just ignore.", new Object[] { ((DestroyedActivityInfo)localObject2).mKey });
            ((Iterator)localObject1).remove();
            continue;
          }
          if (b.this.cwC == a.b.cwI)
          {
            localObject3 = (NotificationManager)b.this.context.getSystemService("notification");
            Object localObject4 = b.this.context.getString(2131762556);
            Object localObject6 = ((DestroyedActivityInfo)localObject2).mActivityName;
            b.this.cwE.putExtra("activity", ((DestroyedActivityInfo)localObject2).mActivityName);
            b.this.cwE.putExtra("ref_key", ((DestroyedActivityInfo)localObject2).mKey);
            Object localObject5 = PendingIntent.getActivity(b.this.context, 0, b.this.cwE, 134217728);
            localObject6 = new s.c(b.this.context).f((CharSequence)localObject6);
            ((s.c)localObject6).Fu = ((PendingIntent)localObject5);
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
            b.this.cL(((DestroyedActivityInfo)localObject2).mActivityName);
            com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "show notification for notify activity leak. %s", new Object[] { ((DestroyedActivityInfo)localObject2).mActivityName });
            continue;
          }
          com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "lightweight mode, just report leaked activity name.", new Object[0]);
          b.this.cL(((DestroyedActivityInfo)localObject2).mActivityName);
          Object localObject3 = new JSONObject();
          try
          {
            ((JSONObject)localObject3).put("activity", ((DestroyedActivityInfo)localObject2).mActivityName);
            b.this.cxC.onDetectIssue(new com.tencent.matrix.report.c((JSONObject)localObject3));
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
      return e.a.a.cyc;
    }
  };
  
  public b(Application paramApplication, com.tencent.matrix.resource.b paramb)
  {
    this(paramApplication, paramb, new a());
  }
  
  private b(Application paramApplication, com.tencent.matrix.resource.b paramb, a parama)
  {
    super(paramApplication, paramb.getTag(), paramb);
    this.cxC = paramb;
    paramb = paramb.cuN;
    HandlerThread localHandlerThread = com.tencent.matrix.g.b.HY();
    this.cwC = paramb.cwC;
    this.cxF = paramb.cqF.get(a.a.JJo.name(), com.tencent.matrix.resource.b.a.cwA);
    this.cxG = paramb.Hk();
    this.cwE = paramb.cwE;
    this.cxD = new e(paramb.Hk(), localHandlerThread);
    this.cxE = paramb.cqF.get(a.a.JJp.name(), 10);
    this.cxH = new d(paramApplication);
    this.cxI = new c(paramApplication, this.cxH);
    this.cxJ = new b.a.1(parama, paramApplication);
    this.cxK = new ConcurrentLinkedQueue();
  }
  
  private void Hp()
  {
    this.cxD.Hv();
    this.cxK.clear();
  }
  
  public final void Ho()
  {
    Application localApplication = this.cxC.getApplication();
    if (localApplication != null)
    {
      localApplication.unregisterActivityLifecycleCallbacks(this.cxM);
      com.tencent.matrix.a.cqa.b(this);
      Hp();
    }
  }
  
  public final void onForeground(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "we are in foreground, modify scan time[%sms].", new Object[] { Long.valueOf(this.cxG) });
      this.cxD.Hv();
      this.cxD.cxX = this.cxG;
      this.cxD.a(this.cxN, 0);
      return;
    }
    com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "we are in background, modify scan time[%sms].", new Object[] { Long.valueOf(this.cxF) });
    this.cxD.cxX = this.cxF;
  }
  
  public static final class a {}
  
  public static abstract interface b
  {
    public abstract boolean F(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.e.b
 * JD-Core Version:    0.7.0.1
 */