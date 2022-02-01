package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.components.k;
import com.google.firebase.components.m;
import com.google.firebase.components.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;

public class a
{
  private static final List<String> bzF;
  private static final List<String> bzG;
  private static final List<String> bzH;
  private static final List<String> bzI;
  private static final Set<String> bzJ;
  @GuardedBy("sLock")
  static final Map<String, a> bzK;
  private static final Object sLock;
  private final Context bzL;
  private final b bzM;
  private final n bzN;
  private final AtomicBoolean bzO;
  private final AtomicBoolean bzP;
  private final List<Object> bzQ;
  private final List<Object> bzR;
  private a bzS;
  private final String mName;
  private final List<Object> zzm;
  
  static
  {
    AppMethodBeat.i(4062);
    bzF = Arrays.asList(new String[] { "com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId" });
    bzG = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    bzH = Arrays.asList(new String[] { "com.google.android.gms.measurement.AppMeasurement" });
    bzI = Arrays.asList(new String[0]);
    bzJ = Collections.emptySet();
    sLock = new Object();
    bzK = new android.support.v4.e.a();
    AppMethodBeat.o(4062);
  }
  
  private a(Context paramContext, String paramString, b paramb)
  {
    AppMethodBeat.i(4055);
    this.bzO = new AtomicBoolean(false);
    this.bzP = new AtomicBoolean();
    this.bzQ = new CopyOnWriteArrayList();
    this.zzm = new CopyOnWriteArrayList();
    this.bzR = new CopyOnWriteArrayList();
    this.bzL = ((Context)Preconditions.checkNotNull(paramContext));
    this.mName = Preconditions.checkNotEmpty(paramString);
    this.bzM = ((b)Preconditions.checkNotNull(paramb));
    this.bzS = new com.google.firebase.b.a();
    paramContext = new k(this.bzL);
    this.bzN = new n(k.z(paramContext.bAn.an(paramContext.mContext)), new com.google.firebase.components.a[] { com.google.firebase.components.a.a(Context.class, this.bzL), com.google.firebase.components.a.a(a.class, this), com.google.firebase.components.a.a(b.class, this.bzM) });
    AppMethodBeat.o(4055);
  }
  
  private static a a(Context arg0, b paramb, String paramString)
  {
    AppMethodBeat.i(4052);
    com.google.firebase.b.b.wS();
    if ((PlatformVersion.isAtLeastIceCreamSandwich()) && ((???.getApplicationContext() instanceof Application)))
    {
      BackgroundDetector.initialize((Application)???.getApplicationContext());
      BackgroundDetector.getInstance().addListener(new c());
    }
    String str = paramString.trim();
    paramString = ???;
    if (???.getApplicationContext() != null) {
      paramString = ???.getApplicationContext();
    }
    synchronized (sLock)
    {
      if (!bzK.containsKey(str))
      {
        bool = true;
        Preconditions.checkState(bool, String.valueOf(str).length() + 33 + "FirebaseApp name " + str + " already exists!");
        Preconditions.checkNotNull(paramString, "Application context cannot be null.");
        paramb = new a(paramString, str, paramb);
        bzK.put(str, paramb);
        com.google.firebase.b.b.wT();
        paramb.zzc();
        AppMethodBeat.o(4052);
        return paramb;
      }
      boolean bool = false;
    }
  }
  
  private static <T> void a(Class<T> paramClass, T paramT, Iterable<String> paramIterable, boolean paramBoolean)
  {
    AppMethodBeat.i(4060);
    Iterator localIterator = paramIterable.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label257;
      }
      paramIterable = (String)localIterator.next();
      if (paramBoolean) {}
      try
      {
        if (bzI.contains(paramIterable))
        {
          Method localMethod = Class.forName(paramIterable).getMethod("getInstance", new Class[] { paramClass });
          int i = localMethod.getModifiers();
          if ((Modifier.isPublic(i)) && (Modifier.isStatic(i))) {
            localMethod.invoke(null, new Object[] { paramT });
          }
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        if (bzJ.contains(paramIterable))
        {
          paramClass = new IllegalStateException(String.valueOf(paramIterable).concat(" is missing, but is required. Check if it has been removed by Proguard."));
          AppMethodBeat.o(4060);
          throw paramClass;
        }
        String.valueOf(paramIterable).concat(" is not linked. Skipping initialization.");
      }
      catch (NoSuchMethodException paramClass)
      {
        paramClass = new IllegalStateException(String.valueOf(paramIterable).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
        AppMethodBeat.o(4060);
        throw paramClass;
      }
      catch (InvocationTargetException paramIterable)
      {
        Log.wtf("FirebaseApp", "Firebase API initialization failure.", paramIterable);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        paramIterable = String.valueOf(paramIterable);
        if (paramIterable.length() == 0) {}
      }
    }
    for (paramIterable = "Failed to initialize ".concat(paramIterable);; paramIterable = new String("Failed to initialize "))
    {
      Log.wtf("FirebaseApp", paramIterable, localIllegalAccessException);
      break;
    }
    label257:
    AppMethodBeat.o(4060);
  }
  
  public static a aj(Context paramContext)
  {
    AppMethodBeat.i(4051);
    synchronized (sLock)
    {
      if (bzK.containsKey("[DEFAULT]"))
      {
        paramContext = wn();
        AppMethodBeat.o(4051);
        return paramContext;
      }
      b localb = b.al(paramContext);
      if (localb == null)
      {
        AppMethodBeat.o(4051);
        return null;
      }
      paramContext = a(paramContext, localb, "[DEFAULT]");
      AppMethodBeat.o(4051);
      return paramContext;
    }
  }
  
  private String getName()
  {
    AppMethodBeat.i(4045);
    zza();
    String str = this.mName;
    AppMethodBeat.o(4045);
    return str;
  }
  
  public static a wn()
  {
    AppMethodBeat.i(4050);
    synchronized (sLock)
    {
      Object localObject2 = (a)bzK.get("[DEFAULT]");
      if (localObject2 == null)
      {
        localObject2 = ProcessUtils.getMyProcessName();
        localObject2 = new IllegalStateException(String.valueOf(localObject2).length() + 116 + "Default FirebaseApp is not initialized in this process " + (String)localObject2 + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
        AppMethodBeat.o(4050);
        throw ((Throwable)localObject2);
      }
    }
    AppMethodBeat.o(4050);
    return locala;
  }
  
  @KeepForSdk
  public static void wo()
  {
    AppMethodBeat.i(4053);
    synchronized (sLock)
    {
      ArrayList localArrayList = (ArrayList)new ArrayList(bzK.values());
      int k = localArrayList.size();
      int i = 0;
      while (i < k)
      {
        Object localObject3 = localArrayList.get(i);
        int j = i + 1;
        localObject3 = (a)localObject3;
        i = j;
        if (((a)localObject3).bzO.get())
        {
          ((a)localObject3).wq();
          i = j;
        }
      }
    }
    AppMethodBeat.o(4053);
  }
  
  @KeepForSdk
  @VisibleForTesting
  private boolean wp()
  {
    AppMethodBeat.i(4057);
    boolean bool = "[DEFAULT]".equals(getName());
    AppMethodBeat.o(4057);
    return bool;
  }
  
  private final void wq()
  {
    AppMethodBeat.i(4058);
    Iterator localIterator = this.zzm.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(4058);
  }
  
  private final void zza()
  {
    AppMethodBeat.i(4056);
    if (!this.bzP.get()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "FirebaseApp was deleted");
      AppMethodBeat.o(4056);
      return;
    }
  }
  
  private final void zzc()
  {
    AppMethodBeat.i(4059);
    boolean bool = android.support.v4.content.b.T(this.bzL);
    if (bool) {
      b.ak(this.bzL);
    }
    for (;;)
    {
      a(a.class, this, bzF, bool);
      if (wp())
      {
        a(a.class, this, bzG, bool);
        a(Context.class, this.bzL, bzH, bool);
      }
      AppMethodBeat.o(4059);
      return;
      this.bzN.bd(wp());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(4047);
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(4047);
      return false;
    }
    boolean bool = this.mName.equals(((a)paramObject).getName());
    AppMethodBeat.o(4047);
    return bool;
  }
  
  public final Context getApplicationContext()
  {
    AppMethodBeat.i(4044);
    zza();
    Context localContext = this.bzL;
    AppMethodBeat.o(4044);
    return localContext;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(4048);
    int i = this.mName.hashCode();
    AppMethodBeat.o(4048);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(4049);
    String str = Objects.toStringHelper(this).add("name", this.mName).add("options", this.bzM).toString();
    AppMethodBeat.o(4049);
    return str;
  }
  
  @KeepForSdk
  public final <T> T w(Class<T> paramClass)
  {
    AppMethodBeat.i(4054);
    zza();
    paramClass = com.google.firebase.components.c.a(this.bzN, paramClass);
    AppMethodBeat.o(4054);
    return paramClass;
  }
  
  public final b wm()
  {
    AppMethodBeat.i(4046);
    zza();
    b localb = this.bzM;
    AppMethodBeat.o(4046);
    return localb;
  }
  
  @KeepForSdk
  public static abstract interface a {}
  
  @TargetApi(24)
  static final class b
    extends BroadcastReceiver
  {
    private static AtomicReference<b> bzT;
    private final Context bzL;
    
    static
    {
      AppMethodBeat.i(4043);
      bzT = new AtomicReference();
      AppMethodBeat.o(4043);
    }
    
    private b(Context paramContext)
    {
      this.bzL = paramContext;
    }
    
    public final void onReceive(Context arg1, Intent paramIntent)
    {
      AppMethodBeat.i(4041);
      synchronized (a.wr())
      {
        paramIntent = a.bzK.values().iterator();
        if (paramIntent.hasNext()) {
          a.a((a)paramIntent.next());
        }
      }
      this.bzL.unregisterReceiver(this);
      AppMethodBeat.o(4041);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.a
 * JD-Core Version:    0.7.0.1
 */