package com.tencent.matrix.resource;

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
  static final HashMap<ComponentName, h> boa = new HashMap();
  static final Object sLock = new Object();
  boolean bnY = false;
  final ArrayList<d> bnZ;
  b eYY;
  h eYZ;
  a eZa;
  boolean mDestroyed = false;
  boolean mStopped = false;
  
  public MatrixJobIntentService()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.bnZ = null;
      return;
    }
    this.bnZ = new ArrayList();
  }
  
  private static h a(Context paramContext, ComponentName paramComponentName, boolean paramBoolean, int paramInt)
  {
    h localh = (h)boa.get(paramComponentName);
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
      boa.put(paramComponentName, paramContext);
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
      paramContext.nt(paramInt);
      paramContext.p(paramIntent);
      return;
    }
  }
  
  final void aza()
  {
    if (this.bnZ != null) {
      synchronized (this.bnZ)
      {
        this.eZa = null;
        if ((this.bnZ != null) && (!this.bnZ.isEmpty())) {
          dJ(false);
        }
        while (this.mDestroyed) {
          return;
        }
        this.eYZ.azf();
      }
    }
  }
  
  final e azb()
  {
    ??? = null;
    if (this.eYY != null) {
      ??? = this.eYY.azb();
    }
    while (this.bnZ == null) {
      return ???;
    }
    synchronized (this.bnZ)
    {
      if ((this.bnZ != null) && (!this.bnZ.isEmpty()))
      {
        e locale = (e)this.bnZ.remove(0);
        return locale;
      }
    }
    return null;
  }
  
  final void dJ(boolean paramBoolean)
  {
    if (this.eZa == null)
    {
      this.eZa = new a();
      if ((this.eYZ != null) && (paramBoolean)) {
        this.eYZ.aze();
      }
      this.eZa.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
  }
  
  protected abstract void o(Intent paramIntent);
  
  public IBinder onBind(Intent paramIntent)
  {
    if (this.eYY != null) {
      return this.eYY.azc();
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.eYY = new f(this);
      this.eYZ = null;
      return;
    }
    this.eYY = null;
    this.eYZ = a(this, new ComponentName(this, getClass()), false, 0);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.bnZ != null) {}
    synchronized (this.bnZ)
    {
      this.mDestroyed = true;
      this.eYZ.azf();
      return;
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (this.bnZ != null)
    {
      this.eYZ.azd();
      synchronized (this.bnZ)
      {
        ArrayList localArrayList2 = this.bnZ;
        if (paramIntent != null)
        {
          localArrayList2.add(new d(paramIntent, paramInt2));
          dJ(true);
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
    public abstract MatrixJobIntentService.e azb();
    
    public abstract IBinder azc();
  }
  
  static final class c
    extends MatrixJobIntentService.h
  {
    private final PowerManager.WakeLock eZc;
    private final PowerManager.WakeLock eZd;
    boolean eZe;
    boolean eZf;
    private final Context mContext;
    
    c(Context paramContext, ComponentName paramComponentName)
    {
      super();
      this.mContext = paramContext.getApplicationContext();
      if (this.mContext.checkPermission("android.permission.WAKE_LOCK", Process.myPid(), Process.myUid()) == 0)
      {
        paramContext = (PowerManager)paramContext.getSystemService("power");
        this.eZc = paramContext.newWakeLock(1, paramComponentName.getClassName() + ":launch");
        this.eZc.setReferenceCounted(false);
        this.eZd = paramContext.newWakeLock(1, paramComponentName.getClassName() + ":run");
        this.eZd.setReferenceCounted(false);
        return;
      }
      com.tencent.matrix.e.c.w("Matrix.JobIntentService", "it would be better to grant WAKE_LOCK permission to your app so that tinker can use WakeLock to keep system awake.", new Object[0]);
      this.eZd = null;
      this.eZc = null;
    }
    
    public final void azd()
    {
      try
      {
        this.eZe = false;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final void aze()
    {
      try
      {
        if (!this.eZf)
        {
          this.eZf = true;
          PowerManager.WakeLock localWakeLock;
          if (this.eZd != null)
          {
            localWakeLock = this.eZd;
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(600000L, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, locala.aYi(), "com/tencent/matrix/resource/MatrixJobIntentService$CompatWorkEnqueuer", "serviceProcessingStarted", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "(J)V");
            long l = ((Long)com.tencent.mm.hellhoundlib.b.c.a(locala).sb(0)).longValue();
            com.tencent.mm.hellhoundlib.b.c.aYk();
            localWakeLock.acquire(l);
            com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/matrix/resource/MatrixJobIntentService$CompatWorkEnqueuer", "serviceProcessingStarted", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "(J)V");
          }
          if (this.eZc != null)
          {
            localWakeLock = this.eZc;
            com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/matrix/resource/MatrixJobIntentService$CompatWorkEnqueuer", "serviceProcessingStarted", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
            localWakeLock.release();
            com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/matrix/resource/MatrixJobIntentService$CompatWorkEnqueuer", "serviceProcessingStarted", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
          }
        }
        return;
      }
      finally {}
    }
    
    public final void azf()
    {
      try
      {
        if (this.eZf)
        {
          PowerManager.WakeLock localWakeLock;
          if ((this.eZe) && (this.eZc != null))
          {
            localWakeLock = this.eZc;
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(60000L, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, locala.aYi(), "com/tencent/matrix/resource/MatrixJobIntentService$CompatWorkEnqueuer", "serviceProcessingFinished", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "(J)V");
            long l = ((Long)com.tencent.mm.hellhoundlib.b.c.a(locala).sb(0)).longValue();
            com.tencent.mm.hellhoundlib.b.c.aYk();
            localWakeLock.acquire(l);
            com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/matrix/resource/MatrixJobIntentService$CompatWorkEnqueuer", "serviceProcessingFinished", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "(J)V");
          }
          this.eZf = false;
          if (this.eZd != null)
          {
            localWakeLock = this.eZd;
            com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/matrix/resource/MatrixJobIntentService$CompatWorkEnqueuer", "serviceProcessingFinished", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
            localWakeLock.release();
            com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/matrix/resource/MatrixJobIntentService$CompatWorkEnqueuer", "serviceProcessingFinished", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
          }
        }
        return;
      }
      finally {}
    }
    
    final void p(Intent paramIntent)
    {
      paramIntent = new Intent(paramIntent);
      paramIntent.setComponent(this.mComponentName);
      try
      {
        if (this.mContext.startService(paramIntent) != null) {}
        try
        {
          if (!this.eZe)
          {
            this.eZe = true;
            if ((!this.eZf) && (this.eZc != null))
            {
              paramIntent = this.eZc;
              com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(60000L, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.b(paramIntent, locala.aYi(), "com/tencent/matrix/resource/MatrixJobIntentService$CompatWorkEnqueuer", "enqueueWork", "(Landroid/content/Intent;)V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "(J)V");
              long l = ((Long)com.tencent.mm.hellhoundlib.b.c.a(locala).sb(0)).longValue();
              com.tencent.mm.hellhoundlib.b.c.aYk();
              paramIntent.acquire(l);
              com.tencent.mm.hellhoundlib.a.a.c(paramIntent, "com/tencent/matrix/resource/MatrixJobIntentService$CompatWorkEnqueuer", "enqueueWork", "(Landroid/content/Intent;)V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "(J)V");
            }
          }
          return;
        }
        finally {}
        return;
      }
      finally
      {
        com.tencent.matrix.e.c.printErrStackTrace("Matrix.JobIntentService", paramIntent, "Exception occurred.", new Object[0]);
      }
    }
  }
  
  final class d
    implements MatrixJobIntentService.e
  {
    final int eZg;
    final Intent mIntent;
    
    d(Intent paramIntent, int paramInt)
    {
      this.mIntent = paramIntent;
      this.eZg = paramInt;
    }
    
    public final void GK()
    {
      MatrixJobIntentService.this.stopSelf(this.eZg);
    }
    
    public final Intent getIntent()
    {
      return this.mIntent;
    }
  }
  
  static abstract interface e
  {
    public abstract void GK();
    
    public abstract Intent getIntent();
  }
  
  static final class f
    extends JobServiceEngine
    implements MatrixJobIntentService.b
  {
    final MatrixJobIntentService eZh;
    JobParameters eZi;
    final Object mLock = new Object();
    
    f(MatrixJobIntentService paramMatrixJobIntentService)
    {
      super();
      this.eZh = paramMatrixJobIntentService;
    }
    
    public final MatrixJobIntentService.e azb()
    {
      synchronized (this.mLock)
      {
        if (this.eZi == null) {}
        for (;;)
        {
          return null;
          try
          {
            JobWorkItem localJobWorkItem = this.eZi.dequeueWork();
            if ((localJobWorkItem == null) || (localJobWorkItem.getIntent() == null)) {
              continue;
            }
            localJobWorkItem.getIntent().setExtrasClassLoader(this.eZh.getClassLoader());
            return new a(localJobWorkItem);
          }
          finally
          {
            com.tencent.matrix.e.c.printErrStackTrace("JobServiceEngineImpl", localThrowable, "exception occurred.", new Object[0]);
            return null;
          }
        }
      }
    }
    
    public final IBinder azc()
    {
      return getBinder();
    }
    
    public final boolean onStartJob(JobParameters paramJobParameters)
    {
      synchronized (this.mLock)
      {
        this.eZi = paramJobParameters;
        this.eZh.dJ(false);
        return true;
      }
    }
    
    public final boolean onStopJob(JobParameters arg1)
    {
      ??? = this.eZh;
      if (???.eZa != null) {
        ???.eZa.cancel(???.bnY);
      }
      ???.mStopped = true;
      synchronized (this.mLock)
      {
        this.eZi = null;
        return true;
      }
    }
    
    final class a
      implements MatrixJobIntentService.e
    {
      final JobWorkItem eZj;
      
      a(JobWorkItem paramJobWorkItem)
      {
        this.eZj = paramJobWorkItem;
      }
      
      public final void GK()
      {
        synchronized (MatrixJobIntentService.f.this.mLock)
        {
          if (MatrixJobIntentService.f.this.eZi != null) {
            MatrixJobIntentService.f.this.eZi.completeWork(this.eZj);
          }
          return;
        }
      }
      
      public final Intent getIntent()
      {
        return this.eZj.getIntent();
      }
    }
  }
  
  static final class g
    extends MatrixJobIntentService.h
  {
    private final JobInfo eZl;
    private final JobScheduler eZm;
    
    g(Context paramContext, ComponentName paramComponentName, int paramInt)
    {
      super();
      nt(paramInt);
      this.eZl = new JobInfo.Builder(paramInt, this.mComponentName).setOverrideDeadline(0L).build();
      this.eZm = ((JobScheduler)paramContext.getApplicationContext().getSystemService("jobscheduler"));
    }
    
    final void p(Intent paramIntent)
    {
      this.eZm.enqueue(this.eZl, new JobWorkItem(paramIntent));
    }
  }
  
  static abstract class h
  {
    boolean eZn;
    int eZo;
    final ComponentName mComponentName;
    
    h(ComponentName paramComponentName)
    {
      this.mComponentName = paramComponentName;
    }
    
    public void azd() {}
    
    public void aze() {}
    
    public void azf() {}
    
    final void nt(int paramInt)
    {
      if (!this.eZn)
      {
        this.eZn = true;
        this.eZo = paramInt;
      }
      while (this.eZo == paramInt) {
        return;
      }
      throw new IllegalArgumentException("Given job ID " + paramInt + " is different than previous " + this.eZo);
    }
    
    abstract void p(Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.resource.MatrixJobIntentService
 * JD-Core Version:    0.7.0.1
 */