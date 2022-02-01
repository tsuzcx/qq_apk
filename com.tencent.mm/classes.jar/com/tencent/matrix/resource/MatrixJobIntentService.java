package com.tencent.matrix.resource;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class MatrixJobIntentService
  extends Service
{
  static final HashMap<ComponentName, h> HX = new HashMap();
  static final Object sLock = new Object();
  boolean HV = false;
  final ArrayList<d> HW;
  a daA;
  b dax;
  h daz;
  boolean mDestroyed = false;
  boolean mStopped = false;
  
  public MatrixJobIntentService()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.HW = null;
      return;
    }
    this.HW = new ArrayList();
  }
  
  private static h a(Context paramContext, ComponentName paramComponentName, boolean paramBoolean, int paramInt)
  {
    h localh = (h)HX.get(paramComponentName);
    Object localObject = localh;
    if (localh == null)
    {
      if (Build.VERSION.SDK_INT < 26) {
        break label69;
      }
      if (!paramBoolean) {
        throw new IllegalArgumentException("Can't be here without a job id");
      }
    }
    label69:
    for (paramContext = new g(paramContext, paramComponentName, paramInt);; paramContext = new c(paramContext, paramComponentName))
    {
      HX.put(paramComponentName, paramContext);
      localObject = paramContext;
      return localObject;
    }
  }
  
  public static void a(Context paramContext, Class arg1, int paramInt, Intent paramIntent)
  {
    ComponentName localComponentName = new ComponentName(paramContext, ???);
    synchronized (sLock)
    {
      paramContext = a(paramContext, localComponentName, true, paramInt);
      paramContext.jE(paramInt);
      paramContext.o(paramIntent);
      return;
    }
  }
  
  final void Xv()
  {
    if (this.HW != null) {
      synchronized (this.HW)
      {
        this.daA = null;
        if ((this.HW != null) && (!this.HW.isEmpty())) {
          da(false);
        }
        while (this.mDestroyed) {
          return;
        }
        this.daz.XA();
      }
    }
  }
  
  final e Xw()
  {
    ??? = null;
    if (this.dax != null) {
      ??? = this.dax.Xw();
    }
    while (this.HW == null) {
      return ???;
    }
    synchronized (this.HW)
    {
      if ((this.HW != null) && (!this.HW.isEmpty()))
      {
        e locale = (e)this.HW.remove(0);
        return locale;
      }
    }
    return null;
  }
  
  @TargetApi(11)
  final void da(boolean paramBoolean)
  {
    if (this.daA == null)
    {
      this.daA = new a();
      if ((this.daz != null) && (paramBoolean)) {
        this.daz.Xz();
      }
      this.daA.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
  }
  
  protected abstract void n(Intent paramIntent);
  
  public IBinder onBind(Intent paramIntent)
  {
    if (this.dax != null) {
      return this.dax.Xx();
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.dax = new f(this);
      this.daz = null;
      return;
    }
    this.dax = null;
    this.daz = a(this, new ComponentName(this, getClass()), false, 0);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.HW != null) {}
    synchronized (this.HW)
    {
      this.mDestroyed = true;
      this.daz.XA();
      return;
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (this.HW != null)
    {
      this.daz.Xy();
      synchronized (this.HW)
      {
        ArrayList localArrayList2 = this.HW;
        if (paramIntent != null)
        {
          localArrayList2.add(new d(paramIntent, paramInt2));
          da(true);
          return 3;
        }
        paramIntent = new Intent();
      }
    }
    return 2;
  }
  
  final class a
    extends AsyncTask<Void, Void, Void>
  {
    a() {}
  }
  
  static abstract interface b
  {
    public abstract MatrixJobIntentService.e Xw();
    
    public abstract IBinder Xx();
  }
  
  static final class c
    extends MatrixJobIntentService.h
  {
    private final PowerManager.WakeLock daC;
    private final PowerManager.WakeLock daD;
    boolean daE;
    boolean daF;
    private final Context mContext;
    
    c(Context paramContext, ComponentName paramComponentName)
    {
      super();
      this.mContext = paramContext.getApplicationContext();
      if (this.mContext.checkPermission("android.permission.WAKE_LOCK", Process.myPid(), Process.myUid()) == 0)
      {
        paramContext = (PowerManager)paramContext.getSystemService("power");
        this.daC = paramContext.newWakeLock(1, paramComponentName.getClassName() + ":launch");
        this.daC.setReferenceCounted(false);
        this.daD = paramContext.newWakeLock(1, paramComponentName.getClassName() + ":run");
        this.daD.setReferenceCounted(false);
        return;
      }
      com.tencent.matrix.e.c.w("Matrix.JobIntentService", "it would be better to grant WAKE_LOCK permission to your app so that tinker can use WakeLock to keep system awake.", new Object[0]);
      this.daD = null;
      this.daC = null;
    }
    
    public final void XA()
    {
      try
      {
        if (this.daF)
        {
          PowerManager.WakeLock localWakeLock;
          if ((this.daE) && (this.daC != null))
          {
            localWakeLock = this.daC;
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(60000L, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, locala.aFh(), "com/tencent/matrix/resource/MatrixJobIntentService$CompatWorkEnqueuer", "serviceProcessingFinished", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "(J)V");
            long l = ((Long)com.tencent.mm.hellhoundlib.b.c.a(locala).sf(0)).longValue();
            com.tencent.mm.hellhoundlib.b.c.aFj();
            localWakeLock.acquire(l);
            com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/matrix/resource/MatrixJobIntentService$CompatWorkEnqueuer", "serviceProcessingFinished", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "(J)V");
          }
          this.daF = false;
          if (this.daD != null)
          {
            localWakeLock = this.daD;
            com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/matrix/resource/MatrixJobIntentService$CompatWorkEnqueuer", "serviceProcessingFinished", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
            localWakeLock.release();
            com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/matrix/resource/MatrixJobIntentService$CompatWorkEnqueuer", "serviceProcessingFinished", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
          }
        }
        return;
      }
      finally {}
    }
    
    public final void Xy()
    {
      try
      {
        this.daE = false;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final void Xz()
    {
      try
      {
        if (!this.daF)
        {
          this.daF = true;
          PowerManager.WakeLock localWakeLock;
          if (this.daD != null)
          {
            localWakeLock = this.daD;
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(600000L, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, locala.aFh(), "com/tencent/matrix/resource/MatrixJobIntentService$CompatWorkEnqueuer", "serviceProcessingStarted", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "(J)V");
            long l = ((Long)com.tencent.mm.hellhoundlib.b.c.a(locala).sf(0)).longValue();
            com.tencent.mm.hellhoundlib.b.c.aFj();
            localWakeLock.acquire(l);
            com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/matrix/resource/MatrixJobIntentService$CompatWorkEnqueuer", "serviceProcessingStarted", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "(J)V");
          }
          if (this.daC != null)
          {
            localWakeLock = this.daC;
            com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/matrix/resource/MatrixJobIntentService$CompatWorkEnqueuer", "serviceProcessingStarted", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
            localWakeLock.release();
            com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/matrix/resource/MatrixJobIntentService$CompatWorkEnqueuer", "serviceProcessingStarted", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
          }
        }
        return;
      }
      finally {}
    }
    
    final void o(Intent paramIntent)
    {
      paramIntent = new Intent(paramIntent);
      paramIntent.setComponent(this.mComponentName);
      try
      {
        if (this.mContext.startService(paramIntent) != null) {}
        try
        {
          if (!this.daE)
          {
            this.daE = true;
            if ((!this.daF) && (this.daC != null))
            {
              paramIntent = this.daC;
              com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(60000L, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.b(paramIntent, locala.aFh(), "com/tencent/matrix/resource/MatrixJobIntentService$CompatWorkEnqueuer", "enqueueWork", "(Landroid/content/Intent;)V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "(J)V");
              long l = ((Long)com.tencent.mm.hellhoundlib.b.c.a(locala).sf(0)).longValue();
              com.tencent.mm.hellhoundlib.b.c.aFj();
              paramIntent.acquire(l);
              com.tencent.mm.hellhoundlib.a.a.c(paramIntent, "com/tencent/matrix/resource/MatrixJobIntentService$CompatWorkEnqueuer", "enqueueWork", "(Landroid/content/Intent;)V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "(J)V");
            }
          }
          return;
        }
        finally {}
        return;
      }
      catch (Throwable paramIntent)
      {
        com.tencent.matrix.e.c.printErrStackTrace("Matrix.JobIntentService", paramIntent, "Exception occurred.", new Object[0]);
      }
    }
  }
  
  final class d
    implements MatrixJobIntentService.e
  {
    final int daG;
    final Intent mIntent;
    
    d(Intent paramIntent, int paramInt)
    {
      this.mIntent = paramIntent;
      this.daG = paramInt;
    }
    
    public final Intent getIntent()
    {
      return this.mIntent;
    }
    
    public final void ph()
    {
      MatrixJobIntentService.this.stopSelf(this.daG);
    }
  }
  
  static abstract interface e
  {
    public abstract Intent getIntent();
    
    public abstract void ph();
  }
  
  static final class f
    extends JobServiceEngine
    implements MatrixJobIntentService.b
  {
    final MatrixJobIntentService daH;
    JobParameters daI;
    final Object mLock = new Object();
    
    f(MatrixJobIntentService paramMatrixJobIntentService)
    {
      super();
      this.daH = paramMatrixJobIntentService;
    }
    
    public final MatrixJobIntentService.e Xw()
    {
      synchronized (this.mLock)
      {
        if (this.daI == null) {}
        for (;;)
        {
          return null;
          try
          {
            JobWorkItem localJobWorkItem = this.daI.dequeueWork();
            if ((localJobWorkItem == null) || (localJobWorkItem.getIntent() == null)) {
              continue;
            }
            localJobWorkItem.getIntent().setExtrasClassLoader(this.daH.getClassLoader());
            return new a(localJobWorkItem);
          }
          catch (Throwable localThrowable)
          {
            com.tencent.matrix.e.c.printErrStackTrace("JobServiceEngineImpl", localThrowable, "exception occurred.", new Object[0]);
            return null;
          }
        }
      }
    }
    
    public final IBinder Xx()
    {
      return getBinder();
    }
    
    public final boolean onStartJob(JobParameters paramJobParameters)
    {
      synchronized (this.mLock)
      {
        this.daI = paramJobParameters;
        this.daH.da(false);
        return true;
      }
    }
    
    public final boolean onStopJob(JobParameters arg1)
    {
      ??? = this.daH;
      if (???.daA != null) {
        ???.daA.cancel(???.HV);
      }
      ???.mStopped = true;
      synchronized (this.mLock)
      {
        this.daI = null;
        return true;
      }
    }
    
    final class a
      implements MatrixJobIntentService.e
    {
      final JobWorkItem daJ;
      
      a(JobWorkItem paramJobWorkItem)
      {
        this.daJ = paramJobWorkItem;
      }
      
      public final Intent getIntent()
      {
        return this.daJ.getIntent();
      }
      
      public final void ph()
      {
        synchronized (MatrixJobIntentService.f.this.mLock)
        {
          if (MatrixJobIntentService.f.this.daI != null) {
            MatrixJobIntentService.f.this.daI.completeWork(this.daJ);
          }
          return;
        }
      }
    }
  }
  
  static final class g
    extends MatrixJobIntentService.h
  {
    private final JobInfo daL;
    private final JobScheduler daM;
    
    g(Context paramContext, ComponentName paramComponentName, int paramInt)
    {
      super();
      jE(paramInt);
      this.daL = new JobInfo.Builder(paramInt, this.mComponentName).setOverrideDeadline(0L).build();
      this.daM = ((JobScheduler)paramContext.getApplicationContext().getSystemService("jobscheduler"));
    }
    
    final void o(Intent paramIntent)
    {
      this.daM.enqueue(this.daL, new JobWorkItem(paramIntent));
    }
  }
  
  static abstract class h
  {
    boolean daN;
    int daO;
    final ComponentName mComponentName;
    
    h(ComponentName paramComponentName)
    {
      this.mComponentName = paramComponentName;
    }
    
    public void XA() {}
    
    public void Xy() {}
    
    public void Xz() {}
    
    final void jE(int paramInt)
    {
      if (!this.daN)
      {
        this.daN = true;
        this.daO = paramInt;
      }
      while (this.daO == paramInt) {
        return;
      }
      throw new IllegalArgumentException("Given job ID " + paramInt + " is different than previous " + this.daO);
    }
    
    abstract void o(Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.MatrixJobIntentService
 * JD-Core Version:    0.7.0.1
 */