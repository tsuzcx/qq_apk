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
  b cFr;
  h cFs;
  a cFt;
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
      paramContext.gY(paramInt);
      paramContext.m(paramIntent);
      return;
    }
  }
  
  public static void a(Context paramContext, Class paramClass, int paramInt, Intent paramIntent)
  {
    a(paramContext, new ComponentName(paramContext, paramClass), paramInt, paramIntent);
  }
  
  final void Iw()
  {
    if (this.GA != null) {
      synchronized (this.GA)
      {
        this.cFt = null;
        if ((this.GA != null) && (!this.GA.isEmpty())) {
          bW(false);
        }
        while (this.mDestroyed) {
          return;
        }
        this.cFs.IB();
      }
    }
  }
  
  final e Ix()
  {
    ??? = null;
    if (this.cFr != null) {
      ??? = this.cFr.Ix();
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
    if (this.cFt == null)
    {
      this.cFt = new a();
      if ((this.cFs != null) && (paramBoolean)) {
        this.cFs.IA();
      }
      this.cFt.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
  }
  
  protected abstract void l(Intent paramIntent);
  
  public IBinder onBind(Intent paramIntent)
  {
    if (this.cFr != null) {
      return this.cFr.Iy();
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.cFr = new f(this);
      this.cFs = null;
      return;
    }
    this.cFr = null;
    this.cFs = a(this, new ComponentName(this, getClass()), false, 0);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.GA != null) {
      synchronized (this.GA)
      {
        this.mDestroyed = true;
        this.cFs.IB();
        return;
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (this.GA != null)
    {
      this.cFs.Iz();
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
    public abstract MatrixJobIntentService.e Ix();
    
    public abstract IBinder Iy();
  }
  
  static final class c
    extends MatrixJobIntentService.h
  {
    private final PowerManager.WakeLock cFv;
    private final PowerManager.WakeLock cFw;
    boolean cFx;
    boolean cFy;
    private final Context mContext;
    
    c(Context paramContext, ComponentName paramComponentName)
    {
      super();
      this.mContext = paramContext.getApplicationContext();
      if (this.mContext.checkPermission("android.permission.WAKE_LOCK", Process.myPid(), Process.myUid()) == 0)
      {
        paramContext = (PowerManager)paramContext.getSystemService("power");
        this.cFv = paramContext.newWakeLock(1, paramComponentName.getClassName() + ":launch");
        this.cFv.setReferenceCounted(false);
        this.cFw = paramContext.newWakeLock(1, paramComponentName.getClassName() + ":run");
        this.cFw.setReferenceCounted(false);
        return;
      }
      c.w("Matrix.JobIntentService", "it would be better to grant WAKE_LOCK permission to your app so that tinker can use WakeLock to keep system awake.", new Object[0]);
      this.cFw = null;
      this.cFv = null;
    }
    
    public final void IA()
    {
      try
      {
        if (!this.cFy)
        {
          this.cFy = true;
          if (this.cFw != null) {
            this.cFw.acquire(600000L);
          }
          if (this.cFv != null) {
            this.cFv.release();
          }
        }
        return;
      }
      finally {}
    }
    
    public final void IB()
    {
      try
      {
        if (this.cFy)
        {
          if ((this.cFx) && (this.cFv != null)) {
            this.cFv.acquire(60000L);
          }
          this.cFy = false;
          if (this.cFw != null) {
            this.cFw.release();
          }
        }
        return;
      }
      finally {}
    }
    
    public final void Iz()
    {
      try
      {
        this.cFx = false;
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
            if (!this.cFx)
            {
              this.cFx = true;
              if ((!this.cFy) && (this.cFv != null)) {
                this.cFv.acquire(60000L);
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
    final int cFz;
    final Intent mIntent;
    
    d(Intent paramIntent, int paramInt)
    {
      this.mIntent = paramIntent;
      this.cFz = paramInt;
    }
    
    public final void complete()
    {
      MatrixJobIntentService.this.stopSelf(this.cFz);
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
    final MatrixJobIntentService cFA;
    JobParameters cFB;
    final Object mLock = new Object();
    
    f(MatrixJobIntentService paramMatrixJobIntentService)
    {
      super();
      this.cFA = paramMatrixJobIntentService;
    }
    
    public final MatrixJobIntentService.e Ix()
    {
      synchronized (this.mLock)
      {
        if (this.cFB == null) {}
        for (;;)
        {
          return null;
          try
          {
            JobWorkItem localJobWorkItem = this.cFB.dequeueWork();
            if ((localJobWorkItem == null) || (localJobWorkItem.getIntent() == null)) {
              continue;
            }
            localJobWorkItem.getIntent().setExtrasClassLoader(this.cFA.getClassLoader());
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
    
    public final IBinder Iy()
    {
      return getBinder();
    }
    
    public final boolean onStartJob(JobParameters paramJobParameters)
    {
      synchronized (this.mLock)
      {
        this.cFB = paramJobParameters;
        this.cFA.bW(false);
        return true;
      }
    }
    
    public final boolean onStopJob(JobParameters arg1)
    {
      ??? = this.cFA;
      if (???.cFt != null) {
        ???.cFt.cancel(???.Gz);
      }
      ???.mStopped = true;
      synchronized (this.mLock)
      {
        this.cFB = null;
        return true;
      }
    }
    
    final class a
      implements MatrixJobIntentService.e
    {
      final JobWorkItem cFC;
      
      a(JobWorkItem paramJobWorkItem)
      {
        this.cFC = paramJobWorkItem;
      }
      
      public final void complete()
      {
        synchronized (MatrixJobIntentService.f.this.mLock)
        {
          if (MatrixJobIntentService.f.this.cFB != null) {
            MatrixJobIntentService.f.this.cFB.completeWork(this.cFC);
          }
          return;
        }
      }
      
      public final Intent getIntent()
      {
        return this.cFC.getIntent();
      }
    }
  }
  
  static final class g
    extends MatrixJobIntentService.h
  {
    private final JobInfo cFE;
    private final JobScheduler cFF;
    
    g(Context paramContext, ComponentName paramComponentName, int paramInt)
    {
      super();
      gY(paramInt);
      this.cFE = new JobInfo.Builder(paramInt, this.mComponentName).setOverrideDeadline(0L).build();
      this.cFF = ((JobScheduler)paramContext.getApplicationContext().getSystemService("jobscheduler"));
    }
    
    final void m(Intent paramIntent)
    {
      this.cFF.enqueue(this.cFE, new JobWorkItem(paramIntent));
    }
  }
  
  static abstract class h
  {
    boolean cFG;
    int cFH;
    final ComponentName mComponentName;
    
    h(ComponentName paramComponentName)
    {
      this.mComponentName = paramComponentName;
    }
    
    public void IA() {}
    
    public void IB() {}
    
    public void Iz() {}
    
    final void gY(int paramInt)
    {
      if (!this.cFG)
      {
        this.cFG = true;
        this.cFH = paramInt;
      }
      while (this.cFH == paramInt) {
        return;
      }
      throw new IllegalArgumentException("Given job ID " + paramInt + " is different than previous " + this.cFH);
    }
    
    abstract void m(Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.MatrixJobIntentService
 * JD-Core Version:    0.7.0.1
 */