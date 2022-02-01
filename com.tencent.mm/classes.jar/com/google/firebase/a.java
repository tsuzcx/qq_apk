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
  private static final List<String> bHO;
  private static final List<String> bHP;
  private static final List<String> bHQ;
  private static final List<String> bHR;
  private static final Set<String> bHS;
  @GuardedBy("sLock")
  static final Map<String, a> bHT;
  private static final Object sLock;
  private final Context bHU;
  private final b bHV;
  private final n bHW;
  private final AtomicBoolean bHX;
  private final AtomicBoolean bHY;
  private final List<Object> bHZ;
  private final List<Object> bIa;
  private a bIb;
  private final String mName;
  private final List<Object> zzm;
  
  static
  {
    AppMethodBeat.i(4062);
    bHO = Arrays.asList(new String[] { "com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId" });
    bHP = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    bHQ = Arrays.asList(new String[] { "com.google.android.gms.measurement.AppMeasurement" });
    bHR = Arrays.asList(new String[0]);
    bHS = Collections.emptySet();
    sLock = new Object();
    bHT = new androidx.b.a();
    AppMethodBeat.o(4062);
  }
  
  private a(Context paramContext, String paramString, b paramb)
  {
    AppMethodBeat.i(4055);
    this.bHX = new AtomicBoolean(false);
    this.bHY = new AtomicBoolean();
    this.bHZ = new CopyOnWriteArrayList();
    this.zzm = new CopyOnWriteArrayList();
    this.bIa = new CopyOnWriteArrayList();
    this.bHU = ((Context)Preconditions.checkNotNull(paramContext));
    this.mName = Preconditions.checkNotEmpty(paramString);
    this.bHV = ((b)Preconditions.checkNotNull(paramb));
    this.bIb = new com.google.firebase.b.a();
    paramContext = new k(this.bHU);
    this.bHW = new n(k.x(paramContext.bIw.al(paramContext.mContext)), new com.google.firebase.components.a[] { com.google.firebase.components.a.a(Context.class, this.bHU), com.google.firebase.components.a.a(a.class, this), com.google.firebase.components.a.a(b.class, this.bHV) });
    AppMethodBeat.o(4055);
  }
  
  private static a a(Context arg0, b paramb, String paramString)
  {
    AppMethodBeat.i(4052);
    com.google.firebase.b.b.yR();
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
      if (!bHT.containsKey(str))
      {
        bool = true;
        Preconditions.checkState(bool, String.valueOf(str).length() + 33 + "FirebaseApp name " + str + " already exists!");
        Preconditions.checkNotNull(paramString, "Application context cannot be null.");
        paramb = new a(paramString, str, paramb);
        bHT.put(str, paramb);
        com.google.firebase.b.b.yS();
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
        if (bHR.contains(paramIterable))
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
        if (bHS.contains(paramIterable))
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
  
  public static a ah(Context paramContext)
  {
    AppMethodBeat.i(4051);
    synchronized (sLock)
    {
      if (bHT.containsKey("[DEFAULT]"))
      {
        paramContext = ym();
        AppMethodBeat.o(4051);
        return paramContext;
      }
      b localb = b.aj(paramContext);
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
  
  public static a ym()
  {
    AppMethodBeat.i(4050);
    synchronized (sLock)
    {
      Object localObject2 = (a)bHT.get("[DEFAULT]");
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
  public static void yn()
  {
    AppMethodBeat.i(4053);
    synchronized (sLock)
    {
      ArrayList localArrayList = (ArrayList)new ArrayList(bHT.values());
      int k = localArrayList.size();
      int i = 0;
      while (i < k)
      {
        Object localObject3 = localArrayList.get(i);
        int j = i + 1;
        localObject3 = (a)localObject3;
        i = j;
        if (((a)localObject3).bHX.get())
        {
          ((a)localObject3).yp();
          i = j;
        }
      }
    }
    AppMethodBeat.o(4053);
  }
  
  @KeepForSdk
  @VisibleForTesting
  private boolean yo()
  {
    AppMethodBeat.i(4057);
    boolean bool = "[DEFAULT]".equals(getName());
    AppMethodBeat.o(4057);
    return bool;
  }
  
  private final void yp()
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
    if (!this.bHY.get()) {}
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
    boolean bool = androidx.core.content.a.S(this.bHU);
    if (bool) {
      b.ai(this.bHU);
    }
    for (;;)
    {
      a(a.class, this, bHO, bool);
      if (yo())
      {
        a(a.class, this, bHP, bool);
        a(Context.class, this.bHU, bHQ, bool);
      }
      AppMethodBeat.o(4059);
      return;
      this.bHW.bn(yo());
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
    Context localContext = this.bHU;
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
  
  @KeepForSdk
  public final <T> T m(Class<T> paramClass)
  {
    AppMethodBeat.i(4054);
    zza();
    paramClass = com.google.firebase.components.c.a(this.bHW, paramClass);
    AppMethodBeat.o(4054);
    return paramClass;
  }
  
  public String toString()
  {
    AppMethodBeat.i(4049);
    String str = Objects.toStringHelper(this).add("name", this.mName).add("options", this.bHV).toString();
    AppMethodBeat.o(4049);
    return str;
  }
  
  public final b yl()
  {
    AppMethodBeat.i(4046);
    zza();
    b localb = this.bHV;
    AppMethodBeat.o(4046);
    return localb;
  }
  
  @KeepForSdk
  public static abstract interface a {}
  
  @TargetApi(24)
  static final class b
    extends BroadcastReceiver
  {
    private static AtomicReference<b> bIc;
    private final Context bHU;
    
    static
    {
      AppMethodBeat.i(4043);
      bIc = new AtomicReference();
      AppMethodBeat.o(4043);
    }
    
    private b(Context paramContext)
    {
      this.bHU = paramContext;
    }
    
    public final void onReceive(Context arg1, Intent paramIntent)
    {
      AppMethodBeat.i(4041);
      synchronized (a.yq())
      {
        paramIntent = a.bHT.values().iterator();
        if (paramIntent.hasNext()) {
          a.a((a)paramIntent.next());
        }
      }
      this.bHU.unregisterReceiver(this);
      AppMethodBeat.o(4041);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.a
 * JD-Core Version:    0.7.0.1
 */