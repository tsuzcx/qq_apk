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
  private static final long beT;
  static p beU;
  @VisibleForTesting
  @GuardedBy("FirebaseInstanceId.class")
  private static ScheduledThreadPoolExecutor beV;
  final a beW;
  final f beX;
  final ae beY;
  final i beZ;
  @GuardedBy("this")
  private boolean bfa;
  @GuardedBy("this")
  private boolean bfb;
  
  static
  {
    AppMethodBeat.i(108706);
    beT = TimeUnit.HOURS.toSeconds(8L);
    AppMethodBeat.o(108706);
  }
  
  FirebaseInstanceId(a parama)
  {
    this(parama, new f(parama.getApplicationContext()));
    AppMethodBeat.i(108690);
    AppMethodBeat.o(108690);
  }
  
  private FirebaseInstanceId(a parama, f paramf)
  {
    AppMethodBeat.i(108691);
    this.beZ = new i();
    this.bfa = false;
    if (f.b(parama) == null)
    {
      parama = new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
      AppMethodBeat.o(108691);
      throw parama;
    }
    try
    {
      if (beU == null) {
        beU = new p(parama.getApplicationContext());
      }
      this.beW = parama;
      this.beX = paramf;
      this.beY = new ab(parama, this, paramf);
      this.bfb = rR();
      if (rT()) {
        rM();
      }
      AppMethodBeat.o(108691);
      return;
    }
    finally
    {
      AppMethodBeat.o(108691);
    }
  }
  
  static <T> T a(Task<T> paramTask)
  {
    AppMethodBeat.i(108699);
    try
    {
      paramTask = Tasks.await(paramTask);
      AppMethodBeat.o(108699);
      return paramTask;
    }
    catch (ExecutionException paramTask)
    {
      Throwable localThrowable = paramTask.getCause();
      if ((localThrowable instanceof IOException))
      {
        paramTask = (IOException)localThrowable;
        AppMethodBeat.o(108699);
        throw paramTask;
      }
      if ((localThrowable instanceof RuntimeException))
      {
        paramTask = new IOException(localThrowable);
        AppMethodBeat.o(108699);
        throw paramTask;
      }
      paramTask = new IOException(paramTask);
      AppMethodBeat.o(108699);
      throw paramTask;
    }
    catch (InterruptedException paramTask)
    {
      paramTask = new IOException("SERVICE_NOT_AVAILABLE");
      AppMethodBeat.o(108699);
      throw paramTask;
    }
  }
  
  static void c(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(108695);
    try
    {
      if (beV == null) {
        beV = new ScheduledThreadPoolExecutor(1);
      }
      beV.schedule(paramRunnable, paramLong, TimeUnit.SECONDS);
      return;
    }
    finally
    {
      AppMethodBeat.o(108695);
    }
  }
  
  @Keep
  public static FirebaseInstanceId getInstance(a parama)
  {
    try
    {
      AppMethodBeat.i(108689);
      parama = (FirebaseInstanceId)parama.m(FirebaseInstanceId.class);
      AppMethodBeat.o(108689);
      return parama;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static FirebaseInstanceId rL()
  {
    AppMethodBeat.i(108688);
    FirebaseInstanceId localFirebaseInstanceId = getInstance(a.rB());
    AppMethodBeat.o(108688);
    return localFirebaseInstanceId;
  }
  
  static p rO()
  {
    return beU;
  }
  
  static boolean rP()
  {
    AppMethodBeat.i(108701);
    if ((Log.isLoggable("FirebaseInstanceId", 3)) || ((Build.VERSION.SDK_INT == 23) && (Log.isLoggable("FirebaseInstanceId", 3))))
    {
      AppMethodBeat.o(108701);
      return true;
    }
    AppMethodBeat.o(108701);
    return false;
  }
  
  private final boolean rR()
  {
    AppMethodBeat.i(108703);
    Object localObject1 = this.beW.getApplicationContext();
    Object localObject2 = ((Context)localObject1).getSharedPreferences("com.google.firebase.messaging", 0);
    boolean bool;
    if (((SharedPreferences)localObject2).contains("auto_init"))
    {
      bool = ((SharedPreferences)localObject2).getBoolean("auto_init", true);
      AppMethodBeat.o(108703);
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
          AppMethodBeat.o(108703);
          return bool;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      bool = rS();
      AppMethodBeat.o(108703);
    }
    return bool;
  }
  
  private final boolean rS()
  {
    AppMethodBeat.i(108704);
    try
    {
      Class.forName("com.google.firebase.messaging.a");
      AppMethodBeat.o(108704);
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Object localObject = this.beW.getApplicationContext();
      Intent localIntent = new Intent("com.google.firebase.MESSAGING_EVENT");
      localIntent.setPackage(((Context)localObject).getPackageName());
      localObject = ((Context)localObject).getPackageManager().resolveService(localIntent, 0);
      if ((localObject != null) && (((ResolveInfo)localObject).serviceInfo != null))
      {
        AppMethodBeat.o(108704);
        return true;
      }
      AppMethodBeat.o(108704);
    }
    return false;
  }
  
  @VisibleForTesting
  private boolean rT()
  {
    try
    {
      boolean bool = this.bfb;
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
    AppMethodBeat.i(108696);
    String str = f.a(beU.aY("").bgr);
    AppMethodBeat.o(108696);
    return str;
  }
  
  final String b(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(108700);
    ab localab = (ab)this.beY;
    localab.c(paramString1, paramString2, paramBundle);
    paramString1 = localab.h(localab.bgm.f(paramBundle));
    AppMethodBeat.o(108700);
    return paramString1;
  }
  
  public final String getToken()
  {
    AppMethodBeat.i(108697);
    Object localObject = rN();
    if ((localObject == null) || (((q)localObject).bb(this.beX.rW()))) {
      startSync();
    }
    if (localObject != null)
    {
      localObject = ((q)localObject).bfJ;
      AppMethodBeat.o(108697);
      return localObject;
    }
    AppMethodBeat.o(108697);
    return null;
  }
  
  public final void rM()
  {
    AppMethodBeat.i(108692);
    q localq = rN();
    if ((localq == null) || (localq.bb(this.beX.rW())) || (beU.sb() != null)) {
      startSync();
    }
    AppMethodBeat.o(108692);
  }
  
  final q rN()
  {
    AppMethodBeat.i(108698);
    q localq = beU.d("", f.b(this.beW), "*");
    AppMethodBeat.o(108698);
    return localq;
  }
  
  final void rQ()
  {
    try
    {
      AppMethodBeat.i(108702);
      beU.zzag();
      if (rT()) {
        startSync();
      }
      AppMethodBeat.o(108702);
      return;
    }
    finally {}
  }
  
  @VisibleForTesting
  public final void rU()
  {
    try
    {
      AppMethodBeat.i(108705);
      SharedPreferences.Editor localEditor = this.beW.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
      localEditor.putBoolean("auto_init", true);
      localEditor.apply();
      if (!this.bfb) {
        rM();
      }
      this.bfb = true;
      AppMethodBeat.o(108705);
      return;
    }
    finally {}
  }
  
  final void startSync()
  {
    try
    {
      AppMethodBeat.i(108693);
      if (!this.bfa) {
        zza(0L);
      }
      AppMethodBeat.o(108693);
      return;
    }
    finally {}
  }
  
  final void zza(long paramLong)
  {
    try
    {
      AppMethodBeat.i(108694);
      long l = Math.min(Math.max(30L, paramLong << 1), beT);
      c(new r(this, this.beX, l), paramLong);
      this.bfa = true;
      AppMethodBeat.o(108694);
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
      this.bfa = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.firebase.iid.FirebaseInstanceId
 * JD-Core Version:    0.7.0.1
 */