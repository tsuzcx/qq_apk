package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public class FirebaseInstanceId
{
  private static final long bCT;
  static p bCU;
  @VisibleForTesting
  @GuardedBy("FirebaseInstanceId.class")
  private static ScheduledThreadPoolExecutor bCV;
  final a bCW;
  final f bCX;
  final ae bCY;
  final i bCZ;
  @GuardedBy("this")
  private boolean bDa;
  @GuardedBy("this")
  private boolean bDb;
  
  static
  {
    AppMethodBeat.i(4142);
    bCT = TimeUnit.HOURS.toSeconds(8L);
    AppMethodBeat.o(4142);
  }
  
  FirebaseInstanceId(a parama)
  {
    this(parama, new f(parama.getApplicationContext()));
    AppMethodBeat.i(4126);
    AppMethodBeat.o(4126);
  }
  
  private FirebaseInstanceId(a parama, f paramf)
  {
    AppMethodBeat.i(4127);
    this.bCZ = new i();
    this.bDa = false;
    if (f.b(parama) == null)
    {
      parama = new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
      AppMethodBeat.o(4127);
      throw parama;
    }
    try
    {
      if (bCU == null) {
        bCU = new p(parama.getApplicationContext());
      }
      this.bCW = parama;
      this.bCX = paramf;
      this.bCY = new ab(parama, this, paramf);
      this.bDb = wQ();
      if (wS()) {
        wL();
      }
      AppMethodBeat.o(4127);
      return;
    }
    finally
    {
      AppMethodBeat.o(4127);
    }
  }
  
  static <T> T a(Task<T> paramTask)
  {
    AppMethodBeat.i(4135);
    try
    {
      paramTask = Tasks.await(paramTask);
      AppMethodBeat.o(4135);
      return paramTask;
    }
    catch (ExecutionException paramTask)
    {
      Throwable localThrowable = paramTask.getCause();
      if ((localThrowable instanceof IOException))
      {
        paramTask = (IOException)localThrowable;
        AppMethodBeat.o(4135);
        throw paramTask;
      }
      if ((localThrowable instanceof RuntimeException))
      {
        paramTask = new IOException(localThrowable);
        AppMethodBeat.o(4135);
        throw paramTask;
      }
      paramTask = new IOException(paramTask);
      AppMethodBeat.o(4135);
      throw paramTask;
    }
    catch (InterruptedException paramTask)
    {
      paramTask = new IOException("SERVICE_NOT_AVAILABLE");
      AppMethodBeat.o(4135);
      throw paramTask;
    }
  }
  
  static void b(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(4131);
    try
    {
      if (bCV == null) {
        bCV = new ScheduledThreadPoolExecutor(1);
      }
      bCV.schedule(paramRunnable, paramLong, TimeUnit.SECONDS);
      return;
    }
    finally
    {
      AppMethodBeat.o(4131);
    }
  }
  
  @Keep
  public static FirebaseInstanceId getInstance(a parama)
  {
    try
    {
      AppMethodBeat.i(4125);
      parama = (FirebaseInstanceId)parama.w(FirebaseInstanceId.class);
      AppMethodBeat.o(4125);
      return parama;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static FirebaseInstanceId wK()
  {
    AppMethodBeat.i(4124);
    FirebaseInstanceId localFirebaseInstanceId = getInstance(a.wA());
    AppMethodBeat.o(4124);
    return localFirebaseInstanceId;
  }
  
  static p wN()
  {
    return bCU;
  }
  
  static boolean wO()
  {
    AppMethodBeat.i(4137);
    if ((Log.isLoggable("FirebaseInstanceId", 3)) || ((Build.VERSION.SDK_INT == 23) && (Log.isLoggable("FirebaseInstanceId", 3))))
    {
      AppMethodBeat.o(4137);
      return true;
    }
    AppMethodBeat.o(4137);
    return false;
  }
  
  private final boolean wQ()
  {
    AppMethodBeat.i(4139);
    Object localObject1 = this.bCW.getApplicationContext();
    Object localObject2 = ((Context)localObject1).getSharedPreferences("com.google.firebase.messaging", 0);
    boolean bool;
    if (((SharedPreferences)localObject2).contains("auto_init"))
    {
      bool = ((SharedPreferences)localObject2).getBoolean("auto_init", true);
      AppMethodBeat.o(4139);
      return bool;
    }
    try
    {
      localObject2 = ((Context)localObject1).getPackageManager();
      if (localObject2 != null)
      {
        localObject1 = ((PackageManager)localObject2).getApplicationInfo(((Context)localObject1).getPackageName(), 128);
        if ((localObject1 != null) && (((ApplicationInfo)localObject1).metaData != null) && (((ApplicationInfo)localObject1).metaData.containsKey("firebase_messaging_auto_init_enabled")))
        {
          bool = ((ApplicationInfo)localObject1).metaData.getBoolean("firebase_messaging_auto_init_enabled");
          AppMethodBeat.o(4139);
          return bool;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      bool = wR();
      AppMethodBeat.o(4139);
    }
    return bool;
  }
  
  private final boolean wR()
  {
    AppMethodBeat.i(4140);
    try
    {
      Class.forName("com.google.firebase.messaging.a");
      AppMethodBeat.o(4140);
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Object localObject = this.bCW.getApplicationContext();
      Intent localIntent = new Intent("com.google.firebase.MESSAGING_EVENT");
      localIntent.setPackage(((Context)localObject).getPackageName());
      localObject = ((Context)localObject).getPackageManager().resolveService(localIntent, 0);
      if ((localObject != null) && (((ResolveInfo)localObject).serviceInfo != null))
      {
        AppMethodBeat.o(4140);
        return true;
      }
      AppMethodBeat.o(4140);
    }
    return false;
  }
  
  @VisibleForTesting
  private boolean wS()
  {
    try
    {
      boolean bool = this.bDb;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String zzf()
  {
    AppMethodBeat.i(4132);
    String str = f.a(bCU.bf("").bEq);
    AppMethodBeat.o(4132);
    return str;
  }
  
  final String b(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(4136);
    ab localab = (ab)this.bCY;
    localab.c(paramString1, paramString2, paramBundle);
    paramString1 = localab.j(localab.bEl.h(paramBundle));
    AppMethodBeat.o(4136);
    return paramString1;
  }
  
  public final String getToken()
  {
    AppMethodBeat.i(4133);
    Object localObject = wM();
    if ((localObject == null) || (((q)localObject).bi(this.bCX.wV()))) {
      startSync();
    }
    if (localObject != null)
    {
      localObject = ((q)localObject).bDI;
      AppMethodBeat.o(4133);
      return localObject;
    }
    AppMethodBeat.o(4133);
    return null;
  }
  
  final void startSync()
  {
    try
    {
      AppMethodBeat.i(4129);
      if (!this.bDa) {
        zza(0L);
      }
      AppMethodBeat.o(4129);
      return;
    }
    finally {}
  }
  
  public final void wL()
  {
    AppMethodBeat.i(4128);
    q localq = wM();
    if ((localq == null) || (localq.bi(this.bCX.wV())) || (bCU.xa() != null)) {
      startSync();
    }
    AppMethodBeat.o(4128);
  }
  
  final q wM()
  {
    AppMethodBeat.i(4134);
    q localq = bCU.c("", f.b(this.bCW), "*");
    AppMethodBeat.o(4134);
    return localq;
  }
  
  final void wP()
  {
    try
    {
      AppMethodBeat.i(4138);
      bCU.zzag();
      if (wS()) {
        startSync();
      }
      AppMethodBeat.o(4138);
      return;
    }
    finally {}
  }
  
  @VisibleForTesting
  public final void wT()
  {
    try
    {
      AppMethodBeat.i(4141);
      SharedPreferences.Editor localEditor = this.bCW.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
      localEditor.putBoolean("auto_init", true);
      localEditor.apply();
      if (!this.bDb) {
        wL();
      }
      this.bDb = true;
      AppMethodBeat.o(4141);
      return;
    }
    finally {}
  }
  
  final void zza(long paramLong)
  {
    try
    {
      AppMethodBeat.i(4130);
      long l = Math.min(Math.max(30L, paramLong << 1), bCT);
      b(new r(this, this.bCX, l), paramLong);
      this.bDa = true;
      AppMethodBeat.o(4130);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void zza(boolean paramBoolean)
  {
    try
    {
      this.bDa = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.iid.FirebaseInstanceId
 * JD-Core Version:    0.7.0.1
 */