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
  static final HashMap<ComponentName, h> GB = new HashMap();
  static final Object sLock = new Object();
  final ArrayList<d> GA;
  boolean Gz = false;
  b cGa;
  h cGb;
  a cGc;
  boolean mDestroyed = false;
  boolean mStopped = false;
  
  public MatrixJobIntentService()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.GA = null;
      return;
    }
    this.GA = new ArrayList();
  }
  
  private static h a(Context paramContext, ComponentName paramComponentName, boolean paramBoolean, int paramInt)
  {
    h localh = (h)GB.get(paramComponentName);
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
      GB.put(paramComponentName, paramContext);
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
      paramContext.gZ(paramInt);
      paramContext.m(paramIntent);
      return;
    }
  }
  
  public static void a(Context paramContext, Class paramClass, int paramInt, Intent paramIntent)
  {
    a(paramContext, new ComponentName(paramContext, paramClass), paramInt, paramIntent);
  }
  
  final void IE()
  {
    if (this.GA != null) {
      synchronized (this.GA)
      {
        this.cGc = null;
        if ((this.GA != null) && (!this.GA.isEmpty())) {
          bW(false);
        }
        while (this.mDestroyed) {
          return;
        }
        this.cGb.IJ();
      }
    }
  }
  
  final e IF()
  {
    ??? = null;
    if (this.cGa != null) {
      ??? = this.cGa.IF();
    }
    while (this.GA == null) {
      return ???;
    }
    synchronized (this.GA)
    {
      if ((this.GA != null) && (!this.GA.isEmpty()))
      {
        e locale = (e)this.GA.remove(0);
        return locale;
      }
    }
    return null;
  }
  
  @TargetApi(11)
  final void bW(boolean paramBoolean)
  {
    if (this.cGc == null)
    {
      this.cGc = new a();
      if ((this.cGb != null) && (paramBoolean)) {
        this.cGb.II();
      }
      this.cGc.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
  }
  
  protected abstract void l(Intent paramIntent);
  
  public IBinder onBind(Intent paramIntent)
  {
    if (this.cGa != null) {
      return this.cGa.IG();
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.cGa = new f(this);
      this.cGb = null;
      return;
    }
    this.cGa = null;
    this.cGb = a(this, new ComponentName(this, getClass()), false, 0);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.GA != null) {
      synchronized (this.GA)
      {
        this.mDestroyed = true;
        this.cGb.IJ();
        return;
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (this.GA != null)
    {
      this.cGb.IH();
      synchronized (this.GA)
      {
        ArrayList localArrayList2 = this.GA;
        if (paramIntent != null)
        {
          localArrayList2.add(new d(paramIntent, paramInt2));
          bW(true);
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
    public abstract MatrixJobIntentService.e IF();
    
    public abstract IBinder IG();
  }
  
  static final class c
    extends MatrixJobIntentService.h
  {
    private final PowerManager.WakeLock cGe;
    private final PowerManager.WakeLock cGf;
    boolean cGg;
    boolean cGh;
    private final Context mContext;
    
    c(Context paramContext, ComponentName paramComponentName)
    {
      super();
      this.mContext = paramContext.getApplicationContext();
      if (this.mContext.checkPermission("android.permission.WAKE_LOCK", Process.myPid(), Process.myUid()) == 0)
      {
        paramContext = (PowerManager)paramContext.getSystemService("power");
        this.cGe = paramContext.newWakeLock(1, paramComponentName.getClassName() + ":launch");
        this.cGe.setReferenceCounted(false);
        this.cGf = paramContext.newWakeLock(1, paramComponentName.getClassName() + ":run");
        this.cGf.setReferenceCounted(false);
        return;
      }
      c.w("Matrix.JobIntentService", "it would be better to grant WAKE_LOCK permission to your app so that tinker can use WakeLock to keep system awake.", new Object[0]);
      this.cGf = null;
      this.cGe = null;
    }
    
    public final void IH()
    {
      try
      {
        this.cGg = false;
        return;
      }
      finally {}
    }
    
    public final void II()
    {
      try
      {
        if (!this.cGh)
        {
          this.cGh = true;
          if (this.cGf != null) {
            this.cGf.acquire(600000L);
          }
          if (this.cGe != null) {
            this.cGe.release();
          }
        }
        return;
      }
      finally {}
    }
    
    public final void IJ()
    {
      try
      {
        if (this.cGh)
        {
          if ((this.cGg) && (this.cGe != null)) {
            this.cGe.acquire(60000L);
          }
          this.cGh = false;
          if (this.cGf != null) {
            this.cGf.release();
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
            if (!this.cGg)
            {
              this.cGg = true;
              if ((!this.cGh) && (this.cGe != null)) {
                this.cGe.acquire(60000L);
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
    final int cGi;
    final Intent mIntent;
    
    d(Intent paramIntent, int paramInt)
    {
      this.mIntent = paramIntent;
      this.cGi = paramInt;
    }
    
    public final void complete()
    {
      MatrixJobIntentService.this.stopSelf(this.cGi);
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
    final MatrixJobIntentService cGj;
    JobParameters cGk;
    final Object mLock = new Object();
    
    f(MatrixJobIntentService paramMatrixJobIntentService)
    {
      super();
      this.cGj = paramMatrixJobIntentService;
    }
    
    public final MatrixJobIntentService.e IF()
    {
      synchronized (this.mLock)
      {
        if (this.cGk == null) {}
        for (;;)
        {
          return null;
          try
          {
            JobWorkItem localJobWorkItem = this.cGk.dequeueWork();
            if ((localJobWorkItem == null) || (localJobWorkItem.getIntent() == null)) {
              continue;
            }
            localJobWorkItem.getIntent().setExtrasClassLoader(this.cGj.getClassLoader());
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
    
    public final IBinder IG()
    {
      return getBinder();
    }
    
    public final boolean onStartJob(JobParameters paramJobParameters)
    {
      synchronized (this.mLock)
      {
        this.cGk = paramJobParameters;
        this.cGj.bW(false);
        return true;
      }
    }
    
    public final boolean onStopJob(JobParameters arg1)
    {
      ??? = this.cGj;
      if (???.cGc != null) {
        ???.cGc.cancel(???.Gz);
      }
      ???.mStopped = true;
      synchronized (this.mLock)
      {
        this.cGk = null;
        return true;
      }
    }
    
    final class a
      implements MatrixJobIntentService.e
    {
      final JobWorkItem cGl;
      
      a(JobWorkItem paramJobWorkItem)
      {
        this.cGl = paramJobWorkItem;
      }
      
      public final void complete()
      {
        synchronized (MatrixJobIntentService.f.this.mLock)
        {
          if (MatrixJobIntentService.f.this.cGk != null) {
            MatrixJobIntentService.f.this.cGk.completeWork(this.cGl);
          }
          return;
        }
      }
      
      public final Intent getIntent()
      {
        return this.cGl.getIntent();
      }
    }
  }
  
  static final class g
    extends MatrixJobIntentService.h
  {
    private final JobInfo cGn;
    private final JobScheduler cGo;
    
    g(Context paramContext, ComponentName paramComponentName, int paramInt)
    {
      super();
      gZ(paramInt);
      this.cGn = new JobInfo.Builder(paramInt, this.mComponentName).setOverrideDeadline(0L).build();
      this.cGo = ((JobScheduler)paramContext.getApplicationContext().getSystemService("jobscheduler"));
    }
    
    final void m(Intent paramIntent)
    {
      this.cGo.enqueue(this.cGn, new JobWorkItem(paramIntent));
    }
  }
  
  static abstract class h
  {
    boolean cGp;
    int cGq;
    final ComponentName mComponentName;
    
    h(ComponentName paramComponentName)
    {
      this.mComponentName = paramComponentName;
    }
    
    public void IH() {}
    
    public void II() {}
    
    public void IJ() {}
    
    final void gZ(int paramInt)
    {
      if (!this.cGp)
      {
        this.cGp = true;
        this.cGq = paramInt;
      }
      while (this.cGq == paramInt) {
        return;
      }
      throw new IllegalArgumentException("Given job ID " + paramInt + " is different than previous " + this.cGq);
    }
    
    abstract void m(Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.MatrixJobIntentService
 * JD-Core Version:    0.7.0.1
 */