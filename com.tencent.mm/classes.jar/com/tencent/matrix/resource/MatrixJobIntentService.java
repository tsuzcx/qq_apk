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
import com.tencent.matrix.g.c;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class MatrixJobIntentService
  extends Service
{
  static final Object sLock = new Object();
  static final HashMap<ComponentName, h> xt = new HashMap();
  b bOB;
  h bOC;
  a bOD;
  boolean mDestroyed = false;
  boolean mStopped = false;
  boolean xr = false;
  final ArrayList<d> xs;
  
  public MatrixJobIntentService()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.xs = null;
      return;
    }
    this.xs = new ArrayList();
  }
  
  private static h a(Context paramContext, ComponentName paramComponentName, boolean paramBoolean, int paramInt)
  {
    h localh = (h)xt.get(paramComponentName);
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
      xt.put(paramComponentName, paramContext);
      localObject = paramContext;
      return localObject;
    }
  }
  
  private static void a(Context paramContext, ComponentName paramComponentName, int paramInt, Intent paramIntent)
  {
    if (paramIntent == null) {
      throw new IllegalArgumentException("work must not be null");
    }
    synchronized (sLock)
    {
      paramContext = a(paramContext, paramComponentName, true, paramInt);
      paramContext.fO(paramInt);
      paramContext.m(paramIntent);
      return;
    }
  }
  
  public static void a(Context paramContext, Class paramClass, int paramInt, Intent paramIntent)
  {
    a(paramContext, new ComponentName(paramContext, paramClass), paramInt, paramIntent);
  }
  
  @TargetApi(11)
  final void bi(boolean paramBoolean)
  {
    if (this.bOD == null)
    {
      this.bOD = new a();
      if ((this.bOC != null) && (paramBoolean)) {
        this.bOC.zg();
      }
      this.bOD.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
  }
  
  protected abstract void l(Intent paramIntent);
  
  public IBinder onBind(Intent paramIntent)
  {
    if (this.bOB != null) {
      return this.bOB.ze();
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.bOB = new f(this);
      this.bOC = null;
      return;
    }
    this.bOB = null;
    this.bOC = a(this, new ComponentName(this, getClass()), false, 0);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.xs != null) {
      synchronized (this.xs)
      {
        this.mDestroyed = true;
        this.bOC.zh();
        return;
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (this.xs != null)
    {
      this.bOC.zf();
      synchronized (this.xs)
      {
        ArrayList localArrayList2 = this.xs;
        if (paramIntent != null)
        {
          localArrayList2.add(new d(paramIntent, paramInt2));
          bi(true);
          return 3;
        }
        paramIntent = new Intent();
      }
    }
    return 2;
  }
  
  final void zc()
  {
    if (this.xs != null) {
      synchronized (this.xs)
      {
        this.bOD = null;
        if ((this.xs != null) && (!this.xs.isEmpty())) {
          bi(false);
        }
        while (this.mDestroyed) {
          return;
        }
        this.bOC.zh();
      }
    }
  }
  
  final e zd()
  {
    ??? = null;
    if (this.bOB != null) {
      ??? = this.bOB.zd();
    }
    while (this.xs == null) {
      return ???;
    }
    synchronized (this.xs)
    {
      if ((this.xs != null) && (!this.xs.isEmpty()))
      {
        e locale = (e)this.xs.remove(0);
        return locale;
      }
    }
    return null;
  }
  
  final class a
    extends AsyncTask<Void, Void, Void>
  {
    a() {}
  }
  
  static abstract interface b
  {
    public abstract MatrixJobIntentService.e zd();
    
    public abstract IBinder ze();
  }
  
  static final class c
    extends MatrixJobIntentService.h
  {
    private final PowerManager.WakeLock bOF;
    private final PowerManager.WakeLock bOG;
    boolean bOH;
    boolean bOI;
    private final Context mContext;
    
    c(Context paramContext, ComponentName paramComponentName)
    {
      super();
      this.mContext = paramContext.getApplicationContext();
      if (this.mContext.checkPermission("android.permission.WAKE_LOCK", Process.myPid(), Process.myUid()) == 0)
      {
        paramContext = (PowerManager)paramContext.getSystemService("power");
        this.bOF = paramContext.newWakeLock(1, paramComponentName.getClassName() + ":launch");
        this.bOF.setReferenceCounted(false);
        this.bOG = paramContext.newWakeLock(1, paramComponentName.getClassName() + ":run");
        this.bOG.setReferenceCounted(false);
        return;
      }
      c.w("Matrix.JobIntentService", "it would be better to grant WAKE_LOCK permission to your app so that tinker can use WakeLock to keep system awake.", new Object[0]);
      this.bOG = null;
      this.bOF = null;
    }
    
    final void m(Intent paramIntent)
    {
      paramIntent = new Intent(paramIntent);
      paramIntent.setComponent(this.mComponentName);
      try
      {
        if (this.mContext.startService(paramIntent) != null) {
          try
          {
            if (!this.bOH)
            {
              this.bOH = true;
              if ((!this.bOI) && (this.bOF != null)) {
                this.bOF.acquire(60000L);
              }
            }
            return;
          }
          finally {}
        }
        return;
      }
      catch (Throwable paramIntent)
      {
        c.printErrStackTrace("Matrix.JobIntentService", paramIntent, "Exception occurred.", new Object[0]);
      }
    }
    
    public final void zf()
    {
      try
      {
        this.bOH = false;
        return;
      }
      finally {}
    }
    
    public final void zg()
    {
      try
      {
        if (!this.bOI)
        {
          this.bOI = true;
          if (this.bOG != null) {
            this.bOG.acquire(600000L);
          }
          if (this.bOF != null) {
            this.bOF.release();
          }
        }
        return;
      }
      finally {}
    }
    
    public final void zh()
    {
      try
      {
        if (this.bOI)
        {
          if ((this.bOH) && (this.bOF != null)) {
            this.bOF.acquire(60000L);
          }
          this.bOI = false;
          if (this.bOG != null) {
            this.bOG.release();
          }
        }
        return;
      }
      finally {}
    }
  }
  
  final class d
    implements MatrixJobIntentService.e
  {
    final int bOJ;
    final Intent mIntent;
    
    d(Intent paramIntent, int paramInt)
    {
      this.mIntent = paramIntent;
      this.bOJ = paramInt;
    }
    
    public final void complete()
    {
      MatrixJobIntentService.this.stopSelf(this.bOJ);
    }
    
    public final Intent getIntent()
    {
      return this.mIntent;
    }
  }
  
  static abstract interface e
  {
    public abstract void complete();
    
    public abstract Intent getIntent();
  }
  
  static final class f
    extends JobServiceEngine
    implements MatrixJobIntentService.b
  {
    final MatrixJobIntentService bOK;
    JobParameters bOL;
    final Object mLock = new Object();
    
    f(MatrixJobIntentService paramMatrixJobIntentService)
    {
      super();
      this.bOK = paramMatrixJobIntentService;
    }
    
    public final boolean onStartJob(JobParameters paramJobParameters)
    {
      synchronized (this.mLock)
      {
        this.bOL = paramJobParameters;
        this.bOK.bi(false);
        return true;
      }
    }
    
    public final boolean onStopJob(JobParameters arg1)
    {
      ??? = this.bOK;
      if (???.bOD != null) {
        ???.bOD.cancel(???.xr);
      }
      ???.mStopped = true;
      synchronized (this.mLock)
      {
        this.bOL = null;
        return true;
      }
    }
    
    public final MatrixJobIntentService.e zd()
    {
      synchronized (this.mLock)
      {
        if (this.bOL == null) {}
        for (;;)
        {
          return null;
          try
          {
            JobWorkItem localJobWorkItem = this.bOL.dequeueWork();
            if ((localJobWorkItem == null) || (localJobWorkItem.getIntent() == null)) {
              continue;
            }
            localJobWorkItem.getIntent().setExtrasClassLoader(this.bOK.getClassLoader());
            return new a(localJobWorkItem);
          }
          catch (Throwable localThrowable)
          {
            c.printErrStackTrace("JobServiceEngineImpl", localThrowable, "exception occurred.", new Object[0]);
            return null;
          }
        }
      }
    }
    
    public final IBinder ze()
    {
      return getBinder();
    }
    
    final class a
      implements MatrixJobIntentService.e
    {
      final JobWorkItem bOM;
      
      a(JobWorkItem paramJobWorkItem)
      {
        this.bOM = paramJobWorkItem;
      }
      
      public final void complete()
      {
        synchronized (MatrixJobIntentService.f.this.mLock)
        {
          if (MatrixJobIntentService.f.this.bOL != null) {
            MatrixJobIntentService.f.this.bOL.completeWork(this.bOM);
          }
          return;
        }
      }
      
      public final Intent getIntent()
      {
        return this.bOM.getIntent();
      }
    }
  }
  
  static final class g
    extends MatrixJobIntentService.h
  {
    private final JobInfo bOO;
    private final JobScheduler bOP;
    
    g(Context paramContext, ComponentName paramComponentName, int paramInt)
    {
      super();
      fO(paramInt);
      this.bOO = new JobInfo.Builder(paramInt, this.mComponentName).setOverrideDeadline(0L).build();
      this.bOP = ((JobScheduler)paramContext.getApplicationContext().getSystemService("jobscheduler"));
    }
    
    final void m(Intent paramIntent)
    {
      this.bOP.enqueue(this.bOO, new JobWorkItem(paramIntent));
    }
  }
  
  static abstract class h
  {
    boolean bOQ;
    int bOR;
    final ComponentName mComponentName;
    
    h(ComponentName paramComponentName)
    {
      this.mComponentName = paramComponentName;
    }
    
    final void fO(int paramInt)
    {
      if (!this.bOQ)
      {
        this.bOQ = true;
        this.bOR = paramInt;
      }
      while (this.bOR == paramInt) {
        return;
      }
      throw new IllegalArgumentException("Given job ID " + paramInt + " is different than previous " + this.bOR);
    }
    
    abstract void m(Intent paramIntent);
    
    public void zf() {}
    
    public void zg() {}
    
    public void zh() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.MatrixJobIntentService
 * JD-Core Version:    0.7.0.1
 */