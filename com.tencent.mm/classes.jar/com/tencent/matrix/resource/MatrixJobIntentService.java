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
  static final HashMap<ComponentName, h> DM = new HashMap();
  static final Object sLock = new Object();
  boolean DK = false;
  final ArrayList<d> DL;
  b cxn;
  h cxo;
  a cxp;
  boolean mDestroyed = false;
  boolean mStopped = false;
  
  public MatrixJobIntentService()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.DL = null;
      return;
    }
    this.DL = new ArrayList();
  }
  
  private static h a(Context paramContext, ComponentName paramComponentName, boolean paramBoolean, int paramInt)
  {
    h localh = (h)DM.get(paramComponentName);
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
      DM.put(paramComponentName, paramContext);
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
      paramContext.hk(paramInt);
      paramContext.m(paramIntent);
      return;
    }
  }
  
  public static void a(Context paramContext, Class paramClass, int paramInt, Intent paramIntent)
  {
    a(paramContext, new ComponentName(paramContext, paramClass), paramInt, paramIntent);
  }
  
  final void Hq()
  {
    if (this.DL != null) {
      synchronized (this.DL)
      {
        this.cxp = null;
        if ((this.DL != null) && (!this.DL.isEmpty())) {
          bT(false);
        }
        while (this.mDestroyed) {
          return;
        }
        this.cxo.Hv();
      }
    }
  }
  
  final e Hr()
  {
    ??? = null;
    if (this.cxn != null) {
      ??? = this.cxn.Hr();
    }
    while (this.DL == null) {
      return ???;
    }
    synchronized (this.DL)
    {
      if ((this.DL != null) && (!this.DL.isEmpty()))
      {
        e locale = (e)this.DL.remove(0);
        return locale;
      }
    }
    return null;
  }
  
  @TargetApi(11)
  final void bT(boolean paramBoolean)
  {
    if (this.cxp == null)
    {
      this.cxp = new a();
      if ((this.cxo != null) && (paramBoolean)) {
        this.cxo.Hu();
      }
      this.cxp.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
  }
  
  protected abstract void l(Intent paramIntent);
  
  public IBinder onBind(Intent paramIntent)
  {
    if (this.cxn != null) {
      return this.cxn.Hs();
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.cxn = new f(this);
      this.cxo = null;
      return;
    }
    this.cxn = null;
    this.cxo = a(this, new ComponentName(this, getClass()), false, 0);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.DL != null) {
      synchronized (this.DL)
      {
        this.mDestroyed = true;
        this.cxo.Hv();
        return;
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (this.DL != null)
    {
      this.cxo.Ht();
      synchronized (this.DL)
      {
        ArrayList localArrayList2 = this.DL;
        if (paramIntent != null)
        {
          localArrayList2.add(new d(paramIntent, paramInt2));
          bT(true);
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
    public abstract MatrixJobIntentService.e Hr();
    
    public abstract IBinder Hs();
  }
  
  static final class c
    extends MatrixJobIntentService.h
  {
    private final PowerManager.WakeLock cxr;
    private final PowerManager.WakeLock cxs;
    boolean cxt;
    boolean cxu;
    private final Context mContext;
    
    c(Context paramContext, ComponentName paramComponentName)
    {
      super();
      this.mContext = paramContext.getApplicationContext();
      if (this.mContext.checkPermission("android.permission.WAKE_LOCK", Process.myPid(), Process.myUid()) == 0)
      {
        paramContext = (PowerManager)paramContext.getSystemService("power");
        this.cxr = paramContext.newWakeLock(1, paramComponentName.getClassName() + ":launch");
        this.cxr.setReferenceCounted(false);
        this.cxs = paramContext.newWakeLock(1, paramComponentName.getClassName() + ":run");
        this.cxs.setReferenceCounted(false);
        return;
      }
      c.w("Matrix.JobIntentService", "it would be better to grant WAKE_LOCK permission to your app so that tinker can use WakeLock to keep system awake.", new Object[0]);
      this.cxs = null;
      this.cxr = null;
    }
    
    public final void Ht()
    {
      try
      {
        this.cxt = false;
        return;
      }
      finally {}
    }
    
    public final void Hu()
    {
      try
      {
        if (!this.cxu)
        {
          this.cxu = true;
          if (this.cxs != null) {
            this.cxs.acquire(600000L);
          }
          if (this.cxr != null) {
            this.cxr.release();
          }
        }
        return;
      }
      finally {}
    }
    
    public final void Hv()
    {
      try
      {
        if (this.cxu)
        {
          if ((this.cxt) && (this.cxr != null)) {
            this.cxr.acquire(60000L);
          }
          this.cxu = false;
          if (this.cxs != null) {
            this.cxs.release();
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
            if (!this.cxt)
            {
              this.cxt = true;
              if ((!this.cxu) && (this.cxr != null)) {
                this.cxr.acquire(60000L);
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
    final int cxv;
    final Intent mIntent;
    
    d(Intent paramIntent, int paramInt)
    {
      this.mIntent = paramIntent;
      this.cxv = paramInt;
    }
    
    public final void complete()
    {
      MatrixJobIntentService.this.stopSelf(this.cxv);
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
    final MatrixJobIntentService cxw;
    JobParameters cxx;
    final Object mLock = new Object();
    
    f(MatrixJobIntentService paramMatrixJobIntentService)
    {
      super();
      this.cxw = paramMatrixJobIntentService;
    }
    
    public final MatrixJobIntentService.e Hr()
    {
      synchronized (this.mLock)
      {
        if (this.cxx == null) {}
        for (;;)
        {
          return null;
          try
          {
            JobWorkItem localJobWorkItem = this.cxx.dequeueWork();
            if ((localJobWorkItem == null) || (localJobWorkItem.getIntent() == null)) {
              continue;
            }
            localJobWorkItem.getIntent().setExtrasClassLoader(this.cxw.getClassLoader());
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
    
    public final IBinder Hs()
    {
      return getBinder();
    }
    
    public final boolean onStartJob(JobParameters paramJobParameters)
    {
      synchronized (this.mLock)
      {
        this.cxx = paramJobParameters;
        this.cxw.bT(false);
        return true;
      }
    }
    
    public final boolean onStopJob(JobParameters arg1)
    {
      ??? = this.cxw;
      if (???.cxp != null) {
        ???.cxp.cancel(???.DK);
      }
      ???.mStopped = true;
      synchronized (this.mLock)
      {
        this.cxx = null;
        return true;
      }
    }
    
    final class a
      implements MatrixJobIntentService.e
    {
      final JobWorkItem cxy;
      
      a(JobWorkItem paramJobWorkItem)
      {
        this.cxy = paramJobWorkItem;
      }
      
      public final void complete()
      {
        synchronized (MatrixJobIntentService.f.this.mLock)
        {
          if (MatrixJobIntentService.f.this.cxx != null) {
            MatrixJobIntentService.f.this.cxx.completeWork(this.cxy);
          }
          return;
        }
      }
      
      public final Intent getIntent()
      {
        return this.cxy.getIntent();
      }
    }
  }
  
  static final class g
    extends MatrixJobIntentService.h
  {
    private final JobInfo cxA;
    private final JobScheduler cxB;
    
    g(Context paramContext, ComponentName paramComponentName, int paramInt)
    {
      super();
      hk(paramInt);
      this.cxA = new JobInfo.Builder(paramInt, this.mComponentName).setOverrideDeadline(0L).build();
      this.cxB = ((JobScheduler)paramContext.getApplicationContext().getSystemService("jobscheduler"));
    }
    
    final void m(Intent paramIntent)
    {
      this.cxB.enqueue(this.cxA, new JobWorkItem(paramIntent));
    }
  }
  
  static abstract class h
  {
    boolean cxC;
    int cxD;
    final ComponentName mComponentName;
    
    h(ComponentName paramComponentName)
    {
      this.mComponentName = paramComponentName;
    }
    
    public void Ht() {}
    
    public void Hu() {}
    
    public void Hv() {}
    
    final void hk(int paramInt)
    {
      if (!this.cxC)
      {
        this.cxC = true;
        this.cxD = paramInt;
      }
      while (this.cxD == paramInt) {
        return;
      }
      throw new IllegalArgumentException("Given job ID " + paramInt + " is different than previous " + this.cxD);
    }
    
    abstract void m(Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.MatrixJobIntentService
 * JD-Core Version:    0.7.0.1
 */