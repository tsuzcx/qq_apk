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
  static final HashMap<ComponentName, h> GL = new HashMap();
  static final Object sLock = new Object();
  boolean GJ = false;
  final ArrayList<d> GK;
  a cWA;
  b cWy;
  h cWz;
  boolean mDestroyed = false;
  boolean mStopped = false;
  
  public MatrixJobIntentService()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.GK = null;
      return;
    }
    this.GK = new ArrayList();
  }
  
  private static h a(Context paramContext, ComponentName paramComponentName, boolean paramBoolean, int paramInt)
  {
    h localh = (h)GL.get(paramComponentName);
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
      GL.put(paramComponentName, paramContext);
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
      paramContext.it(paramInt);
      paramContext.m(paramIntent);
      return;
    }
  }
  
  public static void a(Context paramContext, Class paramClass, int paramInt, Intent paramIntent)
  {
    a(paramContext, new ComponentName(paramContext, paramClass), paramInt, paramIntent);
  }
  
  final void SS()
  {
    if (this.GK != null) {
      synchronized (this.GK)
      {
        this.cWA = null;
        if ((this.GK != null) && (!this.GK.isEmpty())) {
          cF(false);
        }
        while (this.mDestroyed) {
          return;
        }
        this.cWz.SX();
      }
    }
  }
  
  final e ST()
  {
    ??? = null;
    if (this.cWy != null) {
      ??? = this.cWy.ST();
    }
    while (this.GK == null) {
      return ???;
    }
    synchronized (this.GK)
    {
      if ((this.GK != null) && (!this.GK.isEmpty()))
      {
        e locale = (e)this.GK.remove(0);
        return locale;
      }
    }
    return null;
  }
  
  @TargetApi(11)
  final void cF(boolean paramBoolean)
  {
    if (this.cWA == null)
    {
      this.cWA = new a();
      if ((this.cWz != null) && (paramBoolean)) {
        this.cWz.SW();
      }
      this.cWA.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
  }
  
  protected abstract void l(Intent paramIntent);
  
  public IBinder onBind(Intent paramIntent)
  {
    if (this.cWy != null) {
      return this.cWy.SU();
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.cWy = new f(this);
      this.cWz = null;
      return;
    }
    this.cWy = null;
    this.cWz = a(this, new ComponentName(this, getClass()), false, 0);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.GK != null) {
      synchronized (this.GK)
      {
        this.mDestroyed = true;
        this.cWz.SX();
        return;
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (this.GK != null)
    {
      this.cWz.SV();
      synchronized (this.GK)
      {
        ArrayList localArrayList2 = this.GK;
        if (paramIntent != null)
        {
          localArrayList2.add(new d(paramIntent, paramInt2));
          cF(true);
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
    public abstract MatrixJobIntentService.e ST();
    
    public abstract IBinder SU();
  }
  
  static final class c
    extends MatrixJobIntentService.h
  {
    private final PowerManager.WakeLock cWC;
    private final PowerManager.WakeLock cWD;
    boolean cWE;
    boolean cWF;
    private final Context mContext;
    
    c(Context paramContext, ComponentName paramComponentName)
    {
      super();
      this.mContext = paramContext.getApplicationContext();
      if (this.mContext.checkPermission("android.permission.WAKE_LOCK", Process.myPid(), Process.myUid()) == 0)
      {
        paramContext = (PowerManager)paramContext.getSystemService("power");
        this.cWC = paramContext.newWakeLock(1, paramComponentName.getClassName() + ":launch");
        this.cWC.setReferenceCounted(false);
        this.cWD = paramContext.newWakeLock(1, paramComponentName.getClassName() + ":run");
        this.cWD.setReferenceCounted(false);
        return;
      }
      c.w("Matrix.JobIntentService", "it would be better to grant WAKE_LOCK permission to your app so that tinker can use WakeLock to keep system awake.", new Object[0]);
      this.cWD = null;
      this.cWC = null;
    }
    
    public final void SV()
    {
      try
      {
        this.cWE = false;
        return;
      }
      finally {}
    }
    
    public final void SW()
    {
      try
      {
        if (!this.cWF)
        {
          this.cWF = true;
          if (this.cWD != null) {
            this.cWD.acquire(600000L);
          }
          if (this.cWC != null) {
            this.cWC.release();
          }
        }
        return;
      }
      finally {}
    }
    
    public final void SX()
    {
      try
      {
        if (this.cWF)
        {
          if ((this.cWE) && (this.cWC != null)) {
            this.cWC.acquire(60000L);
          }
          this.cWF = false;
          if (this.cWD != null) {
            this.cWD.release();
          }
        }
        return;
      }
      finally {}
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
            if (!this.cWE)
            {
              this.cWE = true;
              if ((!this.cWF) && (this.cWC != null)) {
                this.cWC.acquire(60000L);
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
  }
  
  final class d
    implements MatrixJobIntentService.e
  {
    final int cWG;
    final Intent mIntent;
    
    d(Intent paramIntent, int paramInt)
    {
      this.mIntent = paramIntent;
      this.cWG = paramInt;
    }
    
    public final void complete()
    {
      MatrixJobIntentService.this.stopSelf(this.cWG);
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
    final MatrixJobIntentService cWH;
    JobParameters cWI;
    final Object mLock = new Object();
    
    f(MatrixJobIntentService paramMatrixJobIntentService)
    {
      super();
      this.cWH = paramMatrixJobIntentService;
    }
    
    public final MatrixJobIntentService.e ST()
    {
      synchronized (this.mLock)
      {
        if (this.cWI == null) {}
        for (;;)
        {
          return null;
          try
          {
            JobWorkItem localJobWorkItem = this.cWI.dequeueWork();
            if ((localJobWorkItem == null) || (localJobWorkItem.getIntent() == null)) {
              continue;
            }
            localJobWorkItem.getIntent().setExtrasClassLoader(this.cWH.getClassLoader());
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
    
    public final IBinder SU()
    {
      return getBinder();
    }
    
    public final boolean onStartJob(JobParameters paramJobParameters)
    {
      synchronized (this.mLock)
      {
        this.cWI = paramJobParameters;
        this.cWH.cF(false);
        return true;
      }
    }
    
    public final boolean onStopJob(JobParameters arg1)
    {
      ??? = this.cWH;
      if (???.cWA != null) {
        ???.cWA.cancel(???.GJ);
      }
      ???.mStopped = true;
      synchronized (this.mLock)
      {
        this.cWI = null;
        return true;
      }
    }
    
    final class a
      implements MatrixJobIntentService.e
    {
      final JobWorkItem cWJ;
      
      a(JobWorkItem paramJobWorkItem)
      {
        this.cWJ = paramJobWorkItem;
      }
      
      public final void complete()
      {
        synchronized (MatrixJobIntentService.f.this.mLock)
        {
          if (MatrixJobIntentService.f.this.cWI != null) {
            MatrixJobIntentService.f.this.cWI.completeWork(this.cWJ);
          }
          return;
        }
      }
      
      public final Intent getIntent()
      {
        return this.cWJ.getIntent();
      }
    }
  }
  
  static final class g
    extends MatrixJobIntentService.h
  {
    private final JobInfo cWL;
    private final JobScheduler cWM;
    
    g(Context paramContext, ComponentName paramComponentName, int paramInt)
    {
      super();
      it(paramInt);
      this.cWL = new JobInfo.Builder(paramInt, this.mComponentName).setOverrideDeadline(0L).build();
      this.cWM = ((JobScheduler)paramContext.getApplicationContext().getSystemService("jobscheduler"));
    }
    
    final void m(Intent paramIntent)
    {
      this.cWM.enqueue(this.cWL, new JobWorkItem(paramIntent));
    }
  }
  
  static abstract class h
  {
    boolean cWN;
    int cWO;
    final ComponentName mComponentName;
    
    h(ComponentName paramComponentName)
    {
      this.mComponentName = paramComponentName;
    }
    
    public void SV() {}
    
    public void SW() {}
    
    public void SX() {}
    
    final void it(int paramInt)
    {
      if (!this.cWN)
      {
        this.cWN = true;
        this.cWO = paramInt;
      }
      while (this.cWO == paramInt) {
        return;
      }
      throw new IllegalArgumentException("Given job ID " + paramInt + " is different than previous " + this.cWO);
    }
    
    abstract void m(Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.resource.MatrixJobIntentService
 * JD-Core Version:    0.7.0.1
 */