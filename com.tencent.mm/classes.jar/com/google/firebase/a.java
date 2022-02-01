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
  private static final List<String> bJT;
  private static final List<String> bJU;
  private static final List<String> bJV;
  private static final List<String> bJW;
  private static final Set<String> bJX;
  @GuardedBy("sLock")
  static final Map<String, a> bJY;
  private static final Object sLock;
  private final Context bJZ;
  private final b bKa;
  private final n bKb;
  private final AtomicBoolean bKc;
  private final AtomicBoolean bKd;
  private final List<Object> bKe;
  private final List<Object> bKf;
  private a bKg;
  private final String mName;
  private final List<Object> zzm;
  
  static
  {
    AppMethodBeat.i(4062);
    bJT = Arrays.asList(new String[] { "com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId" });
    bJU = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    bJV = Arrays.asList(new String[] { "com.google.android.gms.measurement.AppMeasurement" });
    bJW = Arrays.asList(new String[0]);
    bJX = Collections.emptySet();
    sLock = new Object();
    bJY = new android.support.v4.e.a();
    AppMethodBeat.o(4062);
  }
  
  private a(Context paramContext, String paramString, b paramb)
  {
    AppMethodBeat.i(4055);
    this.bKc = new AtomicBoolean(false);
    this.bKd = new AtomicBoolean();
    this.bKe = new CopyOnWriteArrayList();
    this.zzm = new CopyOnWriteArrayList();
    this.bKf = new CopyOnWriteArrayList();
    this.bJZ = ((Context)Preconditions.checkNotNull(paramContext));
    this.mName = Preconditions.checkNotEmpty(paramString);
    this.bKa = ((b)Preconditions.checkNotNull(paramb));
    this.bKg = new com.google.firebase.b.a();
    paramContext = new k(this.bJZ);
    this.bKb = new n(k.z(paramContext.bKB.ao(paramContext.mContext)), new com.google.firebase.components.a[] { com.google.firebase.components.a.a(Context.class, this.bJZ), com.google.firebase.components.a.a(a.class, this), com.google.firebase.components.a.a(b.class, this.bKa) });
    AppMethodBeat.o(4055);
  }
  
  private static a a(Context arg0, b paramb, String paramString)
  {
    AppMethodBeat.i(4052);
    com.google.firebase.b.b.yp();
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
      if (!bJY.containsKey(str))
      {
        bool = true;
        Preconditions.checkState(bool, String.valueOf(str).length() + 33 + "FirebaseApp name " + str + " already exists!");
        Preconditions.checkNotNull(paramString, "Application context cannot be null.");
        paramb = new a(paramString, str, paramb);
        bJY.put(str, paramb);
        com.google.firebase.b.b.yq();
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
        if (bJW.contains(paramIterable))
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
        if (bJX.contains(paramIterable))
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
  
  public static a ak(Context paramContext)
  {
    AppMethodBeat.i(4051);
    synchronized (sLock)
    {
      if (bJY.containsKey("[DEFAULT]"))
      {
        paramContext = xK();
        AppMethodBeat.o(4051);
        return paramContext;
      }
      b localb = b.am(paramContext);
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
  
  public static a xK()
  {
    AppMethodBeat.i(4050);
    synchronized (sLock)
    {
      Object localObject2 = (a)bJY.get("[DEFAULT]");
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
  public static void xL()
  {
    AppMethodBeat.i(4053);
    synchronized (sLock)
    {
      ArrayList localArrayList = (ArrayList)new ArrayList(bJY.values());
      int k = localArrayList.size();
      int i = 0;
      while (i < k)
      {
        Object localObject3 = localArrayList.get(i);
        int j = i + 1;
        localObject3 = (a)localObject3;
        i = j;
        if (((a)localObject3).bKc.get())
        {
          ((a)localObject3).xN();
          i = j;
        }
      }
    }
    AppMethodBeat.o(4053);
  }
  
  @KeepForSdk
  @VisibleForTesting
  private boolean xM()
  {
    AppMethodBeat.i(4057);
    boolean bool = "[DEFAULT]".equals(getName());
    AppMethodBeat.o(4057);
    return bool;
  }
  
  private final void xN()
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
    if (!this.bKd.get()) {}
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
    boolean bool = android.support.v4.content.b.U(this.bJZ);
    if (bool) {
      b.al(this.bJZ);
    }
    for (;;)
    {
      a(a.class, this, bJT, bool);
      if (xM())
      {
        a(a.class, this, bJU, bool);
        a(Context.class, this.bJZ, bJV, bool);
      }
      AppMethodBeat.o(4059);
      return;
      this.bKb.be(xM());
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
    Context localContext = this.bJZ;
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
    String str = Objects.toStringHelper(this).add("name", this.mName).add("options", this.bKa).toString();
    AppMethodBeat.o(4049);
    return str;
  }
  
  @KeepForSdk
  public final <T> T w(Class<T> paramClass)
  {
    AppMethodBeat.i(4054);
    zza();
    paramClass = com.google.firebase.components.c.a(this.bKb, paramClass);
    AppMethodBeat.o(4054);
    return paramClass;
  }
  
  public final b xJ()
  {
    AppMethodBeat.i(4046);
    zza();
    b localb = this.bKa;
    AppMethodBeat.o(4046);
    return localb;
  }
  
  @KeepForSdk
  public static abstract interface a {}
  
  @TargetApi(24)
  static final class b
    extends BroadcastReceiver
  {
    private static AtomicReference<b> bKh;
    private final Context bJZ;
    
    static
    {
      AppMethodBeat.i(4043);
      bKh = new AtomicReference();
      AppMethodBeat.o(4043);
    }
    
    private b(Context paramContext)
    {
      this.bJZ = paramContext;
    }
    
    public final void onReceive(Context arg1, Intent paramIntent)
    {
      AppMethodBeat.i(4041);
      synchronized (a.xO())
      {
        paramIntent = a.bJY.values().iterator();
        if (paramIntent.hasNext()) {
          a.a((a)paramIntent.next());
        }
      }
      this.bJZ.unregisterReceiver(this);
      AppMethodBeat.o(4041);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.a
 * JD-Core Version:    0.7.0.1
 */