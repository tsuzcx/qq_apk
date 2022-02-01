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
  static final HashMap<ComponentName, h> EK = new HashMap();
  static final Object sLock = new Object();
  boolean EI = false;
  final ArrayList<d> EJ;
  b cuw;
  h cux;
  a cuy;
  boolean mDestroyed = false;
  boolean mStopped = false;
  
  public MatrixJobIntentService()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.EJ = null;
      return;
    }
    this.EJ = new ArrayList();
  }
  
  private static h a(Context paramContext, ComponentName paramComponentName, boolean paramBoolean, int paramInt)
  {
    h localh = (h)EK.get(paramComponentName);
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
      EK.put(paramComponentName, paramContext);
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
      paramContext.gT(paramInt);
      paramContext.m(paramIntent);
      return;
    }
  }
  
  public static void a(Context paramContext, Class paramClass, int paramInt, Intent paramIntent)
  {
    a(paramContext, new ComponentName(paramContext, paramClass), paramInt, paramIntent);
  }
  
  final void Hb()
  {
    if (this.EJ != null) {
      synchronized (this.EJ)
      {
        this.cuy = null;
        if ((this.EJ != null) && (!this.EJ.isEmpty())) {
          bU(false);
        }
        while (this.mDestroyed) {
          return;
        }
        this.cux.Hg();
      }
    }
  }
  
  final e Hc()
  {
    ??? = null;
    if (this.cuw != null) {
      ??? = this.cuw.Hc();
    }
    while (this.EJ == null) {
      return ???;
    }
    synchronized (this.EJ)
    {
      if ((this.EJ != null) && (!this.EJ.isEmpty()))
      {
        e locale = (e)this.EJ.remove(0);
        return locale;
      }
    }
    return null;
  }
  
  @TargetApi(11)
  final void bU(boolean paramBoolean)
  {
    if (this.cuy == null)
    {
      this.cuy = new a();
      if ((this.cux != null) && (paramBoolean)) {
        this.cux.Hf();
      }
      this.cuy.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
  }
  
  protected abstract void l(Intent paramIntent);
  
  public IBinder onBind(Intent paramIntent)
  {
    if (this.cuw != null) {
      return this.cuw.Hd();
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.cuw = new f(this);
      this.cux = null;
      return;
    }
    this.cuw = null;
    this.cux = a(this, new ComponentName(this, getClass()), false, 0);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.EJ != null) {
      synchronized (this.EJ)
      {
        this.mDestroyed = true;
        this.cux.Hg();
        return;
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (this.EJ != null)
    {
      this.cux.He();
      synchronized (this.EJ)
      {
        ArrayList localArrayList2 = this.EJ;
        if (paramIntent != null)
        {
          localArrayList2.add(new d(paramIntent, paramInt2));
          bU(true);
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
    public abstract MatrixJobIntentService.e Hc();
    
    public abstract IBinder Hd();
  }
  
  static final class c
    extends MatrixJobIntentService.h
  {
    private final PowerManager.WakeLock cuA;
    private final PowerManager.WakeLock cuB;
    boolean cuC;
    boolean cuD;
    private final Context mContext;
    
    c(Context paramContext, ComponentName paramComponentName)
    {
      super();
      this.mContext = paramContext.getApplicationContext();
      if (this.mContext.checkPermission("android.permission.WAKE_LOCK", Process.myPid(), Process.myUid()) == 0)
      {
        paramContext = (PowerManager)paramContext.getSystemService("power");
        this.cuA = paramContext.newWakeLock(1, paramComponentName.getClassName() + ":launch");
        this.cuA.setReferenceCounted(false);
        this.cuB = paramContext.newWakeLock(1, paramComponentName.getClassName() + ":run");
        this.cuB.setReferenceCounted(false);
        return;
      }
      c.w("Matrix.JobIntentService", "it would be better to grant WAKE_LOCK permission to your app so that tinker can use WakeLock to keep system awake.", new Object[0]);
      this.cuB = null;
      this.cuA = null;
    }
    
    public final void He()
    {
      try
      {
        this.cuC = false;
        return;
      }
      finally {}
    }
    
    public final void Hf()
    {
      try
      {
        if (!this.cuD)
        {
          this.cuD = true;
          if (this.cuB != null) {
            this.cuB.acquire(600000L);
          }
          if (this.cuA != null) {
            this.cuA.release();
          }
        }
        return;
      }
      finally {}
    }
    
    public final void Hg()
    {
      try
      {
        if (this.cuD)
        {
          if ((this.cuC) && (this.cuA != null)) {
            this.cuA.acquire(60000L);
          }
          this.cuD = false;
          if (this.cuB != null) {
            this.cuB.release();
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
            if (!this.cuC)
            {
              this.cuC = true;
              if ((!this.cuD) && (this.cuA != null)) {
                this.cuA.acquire(60000L);
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
    final int cuE;
    final Intent mIntent;
    
    d(Intent paramIntent, int paramInt)
    {
      this.mIntent = paramIntent;
      this.cuE = paramInt;
    }
    
    public final void complete()
    {
      MatrixJobIntentService.this.stopSelf(this.cuE);
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
    final MatrixJobIntentService cuF;
    JobParameters cuG;
    final Object mLock = new Object();
    
    f(MatrixJobIntentService paramMatrixJobIntentService)
    {
      super();
      this.cuF = paramMatrixJobIntentService;
    }
    
    public final MatrixJobIntentService.e Hc()
    {
      synchronized (this.mLock)
      {
        if (this.cuG == null) {}
        for (;;)
        {
          return null;
          try
          {
            JobWorkItem localJobWorkItem = this.cuG.dequeueWork();
            if ((localJobWorkItem == null) || (localJobWorkItem.getIntent() == null)) {
              continue;
            }
            localJobWorkItem.getIntent().setExtrasClassLoader(this.cuF.getClassLoader());
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
    
    public final IBinder Hd()
    {
      return getBinder();
    }
    
    public final boolean onStartJob(JobParameters paramJobParameters)
    {
      synchronized (this.mLock)
      {
        this.cuG = paramJobParameters;
        this.cuF.bU(false);
        return true;
      }
    }
    
    public final boolean onStopJob(JobParameters arg1)
    {
      ??? = this.cuF;
      if (???.cuy != null) {
        ???.cuy.cancel(???.EI);
      }
      ???.mStopped = true;
      synchronized (this.mLock)
      {
        this.cuG = null;
        return true;
      }
    }
    
    final class a
      implements MatrixJobIntentService.e
    {
      final JobWorkItem cuH;
      
      a(JobWorkItem paramJobWorkItem)
      {
        this.cuH = paramJobWorkItem;
      }
      
      public final void complete()
      {
        synchronized (MatrixJobIntentService.f.this.mLock)
        {
          if (MatrixJobIntentService.f.this.cuG != null) {
            MatrixJobIntentService.f.this.cuG.completeWork(this.cuH);
          }
          return;
        }
      }
      
      public final Intent getIntent()
      {
        return this.cuH.getIntent();
      }
    }
  }
  
  static final class g
    extends MatrixJobIntentService.h
  {
    private final JobInfo cuJ;
    private final JobScheduler cuK;
    
    g(Context paramContext, ComponentName paramComponentName, int paramInt)
    {
      super();
      gT(paramInt);
      this.cuJ = new JobInfo.Builder(paramInt, this.mComponentName).setOverrideDeadline(0L).build();
      this.cuK = ((JobScheduler)paramContext.getApplicationContext().getSystemService("jobscheduler"));
    }
    
    final void m(Intent paramIntent)
    {
      this.cuK.enqueue(this.cuJ, new JobWorkItem(paramIntent));
    }
  }
  
  static abstract class h
  {
    boolean cuL;
    int cuM;
    final ComponentName mComponentName;
    
    h(ComponentName paramComponentName)
    {
      this.mComponentName = paramComponentName;
    }
    
    public void He() {}
    
    public void Hf() {}
    
    public void Hg() {}
    
    final void gT(int paramInt)
    {
      if (!this.cuL)
      {
        this.cuL = true;
        this.cuM = paramInt;
      }
      while (this.cuM == paramInt) {
        return;
      }
      throw new IllegalArgumentException("Given job ID " + paramInt + " is different than previous " + this.cuM);
    }
    
    abstract void m(Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.MatrixJobIntentService
 * JD-Core Version:    0.7.0.1
 */