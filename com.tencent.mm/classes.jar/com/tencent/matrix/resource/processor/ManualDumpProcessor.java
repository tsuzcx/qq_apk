package com.tencent.matrix.resource.processor;

import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.matrix.e.d;
import com.tencent.matrix.report.e;
import com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo;
import com.tencent.matrix.resource.b.a;
import com.tencent.matrix.resource.b.c;
import com.tencent.matrix.resource.b.a.b;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class ManualDumpProcessor
  extends b
{
  private final NotificationManager Jv;
  private final String dcF;
  private final List<DestroyedActivityInfo> ddR = new ArrayList();
  public boolean ddS;
  
  public ManualDumpProcessor(com.tencent.matrix.resource.f.b paramb, String paramString)
  {
    super(paramb);
    this.dcF = paramString;
    this.Jv = ((NotificationManager)paramb.mContext.getSystemService("notification"));
    ManualDumpProcessorHelper.a(paramb.mContext, this);
  }
  
  public final boolean a(DestroyedActivityInfo paramDestroyedActivityInfo)
  {
    Context localContext = this.daQ.mContext;
    com.tencent.matrix.resource.f.b.XT();
    if (paramDestroyedActivityInfo.mActivityRef.get() == null)
    {
      com.tencent.matrix.e.c.v("Matrix.LeakProcessor.ManualDump", "activity with key [%s] was already recycled.", new Object[] { paramDestroyedActivityInfo.mKey });
      return true;
    }
    this.ddR.add(paramDestroyedActivityInfo);
    com.tencent.matrix.e.c.i("Matrix.LeakProcessor.ManualDump", "show notification for activity leak. %s", new Object[] { paramDestroyedActivityInfo.mActivityName });
    if (this.ddS)
    {
      com.tencent.matrix.e.c.i("Matrix.LeakProcessor.ManualDump", "is muted, won't show notification util process reboot", new Object[0]);
      return true;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(this.daQ.mContext, this.dcF);
    ((Intent)localObject).putExtra("activity", paramDestroyedActivityInfo.mActivityName);
    ((Intent)localObject).putExtra("ref_key", paramDestroyedActivityInfo.mKey);
    ((Intent)localObject).putExtra("leak_process", d.getProcessName(localContext));
    PendingIntent localPendingIntent = PendingIntent.getActivity(localContext, 0, (Intent)localObject, 134217728);
    String str1 = localContext.getString(b.c.resource_canary_leak_tip);
    localObject = this.daQ.ded.daP;
    String str2 = String.format(Locale.getDefault(), "[%s] has leaked for [%s]min!!!", new Object[] { paramDestroyedActivityInfo.mActivityName, Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(((com.tencent.matrix.resource.b.a)localObject).XE() * ((com.tencent.matrix.resource.b.a)localObject).XG())) });
    if (Build.VERSION.SDK_INT >= 26) {
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject = (NotificationManager)localContext.getSystemService("notification");
        if (((NotificationManager)localObject).getNotificationChannel("com.tencent.matrix.resource.processor.ManualDumpProcessor") == null)
        {
          com.tencent.matrix.e.c.v("Matrix.LeakProcessor.ManualDump", "create channel", new Object[0]);
          ((NotificationManager)localObject).createNotificationChannel(new NotificationChannel("com.tencent.matrix.resource.processor.ManualDumpProcessor", "com.tencent.matrix.resource.processor.ManualDumpProcessor", 4));
        }
        localObject = "com.tencent.matrix.resource.processor.ManualDumpProcessor";
      }
    }
    for (localObject = new Notification.Builder(localContext, (String)localObject);; localObject = new Notification.Builder(localContext))
    {
      ((Notification.Builder)localObject).setContentTitle(str1).setPriority(0).setStyle(new Notification.BigTextStyle().bigText(str2)).setContentIntent(localPendingIntent).setAutoCancel(true).setSmallIcon(b.a.ic_launcher).setWhen(System.currentTimeMillis());
      localObject = ((Notification.Builder)localObject).build();
      this.Jv.notify(paramDestroyedActivityInfo.mKey.hashCode() + 272, (Notification)localObject);
      localObject = paramDestroyedActivityInfo.mActivityName;
      paramDestroyedActivityInfo = paramDestroyedActivityInfo.mKey;
      a(0, a.b.dcK, (String)localObject, paramDestroyedActivityInfo, "manual_dump", "0");
      com.tencent.matrix.e.c.i("Matrix.LeakProcessor.ManualDump", "shown notification!!!3", new Object[0]);
      return true;
      localObject = null;
      break;
    }
  }
  
  final b fJ(String paramString)
  {
    long l = System.currentTimeMillis();
    com.tencent.matrix.resource.f.b.XT();
    File localFile = XL().db(false);
    if ((localFile == null) || (localFile.length() <= 0L))
    {
      com.tencent.matrix.e.c.e("Matrix.LeakProcessor.ManualDump", "file is null!", new Object[0]);
      return null;
    }
    com.tencent.matrix.e.c.i("Matrix.LeakProcessor.ManualDump", String.format("dump cost=%sms refString=%s path=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString, localFile.getAbsolutePath() }), new Object[0]);
    l = System.currentTimeMillis();
    try
    {
      com.tencent.matrix.resource.analyzer.model.a locala = g(localFile, paramString);
      com.tencent.matrix.e.c.i("Matrix.LeakProcessor.ManualDump", String.format("analyze cost=%sms refString=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString }), new Object[0]);
      paramString = locala.toString();
      if (locala.daT)
      {
        com.tencent.matrix.e.c.i("Matrix.LeakProcessor.ManualDump", "leakFound,refcChain = %s", new Object[] { paramString });
        paramString = new b(localFile.getAbsolutePath(), paramString);
        return paramString;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      com.tencent.matrix.e.c.printErrStackTrace("Matrix.LeakProcessor.ManualDump", paramString.getCause(), "", new Object[0]);
      return null;
    }
    com.tencent.matrix.e.c.i("Matrix.LeakProcessor.ManualDump", "leak not found", new Object[0]);
    paramString = new b(localFile.getAbsolutePath(), null);
    return paramString;
  }
  
  public static class ManualDumpProcessorHelper
    extends BroadcastReceiver
  {
    private static boolean ddV;
    private static ManualDumpProcessor ddW;
    private static ManualDumpProcessor.a ddX;
    
    public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, ManualDumpProcessor.a parama)
    {
      if (!ddV) {
        throw new IllegalStateException("ManualDumpProcessorHelper was not installed yet!!! maybe your target activity is not running in right process.");
      }
      String str = d.getProcessName(paramContext);
      if (str.equalsIgnoreCase(paramString1))
      {
        paramContext = ddW.fJ(paramString3);
        if (paramContext == null)
        {
          parama.XN();
          return;
        }
        parama.R(paramContext.ddT, paramContext.ddU);
        return;
      }
      ddX = parama;
      com.tencent.matrix.e.c.v("Matrix.LeakProcessor.ManualDump", "[%s] send broadcast with permission: %s", new Object[] { str, paramContext.getPackageName() + ".manual.dump" });
      parama = new Intent("com.tencent.matrix.manual.dump");
      parama.putExtra("leak_process", paramString1);
      parama.putExtra("leak_activity", paramString2);
      parama.putExtra("leak_refkey", paramString3);
      parama.putExtra("result_process", str);
      paramContext.sendBroadcast(parama, paramContext.getPackageName() + ".manual.dump");
    }
    
    public void onReceive(final Context paramContext, final Intent paramIntent)
    {
      if (paramIntent == null)
      {
        com.tencent.matrix.e.c.e("Matrix.LeakProcessor.ManualDump", "intent is null", new Object[0]);
        return;
      }
      com.tencent.matrix.e.b.Yu().postAtFrontOfQueue(new Runnable()
      {
        public final void run()
        {
          if ("com.tencent.matrix.manual.dump".equals(paramIntent.getAction()))
          {
            localObject1 = paramIntent.getStringExtra("leak_process");
            localObject2 = d.getProcessName(paramContext);
            if (!((String)localObject2).equals(localObject1)) {
              com.tencent.matrix.e.c.v("Matrix.LeakProcessor.ManualDump", "ACTION_DUMP: current process [%s] is NOT leaked process [%s]", new Object[] { localObject2, localObject1 });
            }
          }
          while (!"com.tencent.matrix.manual.result".equals(paramIntent.getAction()))
          {
            return;
            com.tencent.matrix.e.c.v("Matrix.LeakProcessor.ManualDump", "ACTION_DUMP: current process [%s] is leaked process [%s]", new Object[] { localObject2, localObject1 });
            paramIntent.getStringExtra("leak_activity");
            localObject1 = paramIntent.getStringExtra("leak_refkey");
            localObject1 = ManualDumpProcessor.ManualDumpProcessorHelper.XO().fJ((String)localObject1);
            localObject2 = new Intent("com.tencent.matrix.manual.result");
            if (localObject1 != null)
            {
              ((Intent)localObject2).putExtra("hprof_path", ((ManualDumpProcessor.b)localObject1).ddT);
              ((Intent)localObject2).putExtra("ref_chain", ((ManualDumpProcessor.b)localObject1).ddU);
            }
            ((Intent)localObject2).putExtra("result_process", paramIntent.getStringExtra("result_process"));
            paramContext.sendBroadcast((Intent)localObject2, paramContext.getPackageName() + ".manual.dump");
            return;
          }
          Object localObject1 = paramIntent.getStringExtra("result_process");
          Object localObject2 = d.getProcessName(paramContext);
          if (!((String)localObject2).equals(localObject1))
          {
            com.tencent.matrix.e.c.v("Matrix.LeakProcessor.ManualDump", "ACTION_RESULT: current process [%s] is NOT result process [%s]", new Object[] { localObject2, localObject1 });
            return;
          }
          com.tencent.matrix.e.c.v("Matrix.LeakProcessor.ManualDump", "ACTION_RESULT: current process [%s] is result process [%s]", new Object[] { localObject2, localObject1 });
          if (ManualDumpProcessor.ManualDumpProcessorHelper.XP() == null) {
            throw new NullPointerException("result listener is null!!!");
          }
          localObject1 = paramIntent.getStringExtra("hprof_path");
          if (localObject1 == null)
          {
            ManualDumpProcessor.ManualDumpProcessorHelper.XP().XN();
            return;
          }
          localObject2 = paramIntent.getStringExtra("ref_chain");
          ManualDumpProcessor.ManualDumpProcessorHelper.XP().R((String)localObject1, (String)localObject2);
          ManualDumpProcessor.ManualDumpProcessorHelper.XQ();
        }
      });
    }
  }
  
  public static abstract interface a
  {
    public abstract void R(String paramString1, String paramString2);
    
    public abstract void XN();
  }
  
  public static final class b
  {
    public final String ddT;
    public final String ddU;
    
    public b(String paramString1, String paramString2)
    {
      this.ddT = paramString1;
      this.ddU = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.processor.ManualDumpProcessor
 * JD-Core Version:    0.7.0.1
 */