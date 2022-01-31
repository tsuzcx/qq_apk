package com.google.firebase;

import android.app.Application;
import android.content.Context;
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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

public class a
{
  private static final List<String> bdX;
  private static final List<String> bdY;
  private static final List<String> bdZ;
  private static final List<String> bea;
  private static final Set<String> beb;
  @GuardedBy("sLock")
  static final Map<String, a> bec;
  private static final Object sLock;
  private final Context bed;
  private final b bee;
  private final n bef;
  private final AtomicBoolean beg;
  private final AtomicBoolean beh;
  private final List<Object> bei;
  private final List<Object> bej;
  private a.a bek;
  private final String mName;
  private final List<Object> zzm;
  
  static
  {
    AppMethodBeat.i(10595);
    bdX = Arrays.asList(new String[] { "com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId" });
    bdY = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    bdZ = Arrays.asList(new String[] { "com.google.android.gms.measurement.AppMeasurement" });
    bea = Arrays.asList(new String[0]);
    beb = Collections.emptySet();
    sLock = new Object();
    bec = new android.support.v4.e.a();
    AppMethodBeat.o(10595);
  }
  
  private a(Context paramContext, String paramString, b paramb)
  {
    AppMethodBeat.i(10588);
    this.beg = new AtomicBoolean(false);
    this.beh = new AtomicBoolean();
    this.bei = new CopyOnWriteArrayList();
    this.zzm = new CopyOnWriteArrayList();
    this.bej = new CopyOnWriteArrayList();
    this.bed = ((Context)Preconditions.checkNotNull(paramContext));
    this.mName = Preconditions.checkNotEmpty(paramString);
    this.bee = ((b)Preconditions.checkNotNull(paramb));
    this.bek = new com.google.firebase.b.a();
    paramContext = new k(this.bed);
    this.bef = new n(k.y(paramContext.beF.ag(paramContext.mContext)), new com.google.firebase.components.a[] { com.google.firebase.components.a.a(Context.class, this.bed), com.google.firebase.components.a.a(a.class, this), com.google.firebase.components.a.a(b.class, this.bee) });
    AppMethodBeat.o(10588);
  }
  
  private static a a(Context arg0, b paramb, String paramString)
  {
    AppMethodBeat.i(10585);
    com.google.firebase.b.b.sg();
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
      if (!bec.containsKey(str))
      {
        bool = true;
        Preconditions.checkState(bool, String.valueOf(str).length() + 33 + "FirebaseApp name " + str + " already exists!");
        Preconditions.checkNotNull(paramString, "Application context cannot be null.");
        paramb = new a(paramString, str, paramb);
        bec.put(str, paramb);
        com.google.firebase.b.b.sh();
        paramb.zzc();
        AppMethodBeat.o(10585);
        return paramb;
      }
      boolean bool = false;
    }
  }
  
  private static <T> void a(Class<T> paramClass, T paramT, Iterable<String> paramIterable, boolean paramBoolean)
  {
    AppMethodBeat.i(10593);
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
        if (bea.contains(paramIterable))
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
        if (beb.contains(paramIterable))
        {
          paramClass = new IllegalStateException(String.valueOf(paramIterable).concat(" is missing, but is required. Check if it has been removed by Proguard."));
          AppMethodBeat.o(10593);
          throw paramClass;
        }
        String.valueOf(paramIterable).concat(" is not linked. Skipping initialization.");
      }
      catch (NoSuchMethodException paramClass)
      {
        paramClass = new IllegalStateException(String.valueOf(paramIterable).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
        AppMethodBeat.o(10593);
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
    AppMethodBeat.o(10593);
  }
  
  public static a ac(Context paramContext)
  {
    AppMethodBeat.i(10584);
    synchronized (sLock)
    {
      if (bec.containsKey("[DEFAULT]"))
      {
        paramContext = rB();
        AppMethodBeat.o(10584);
        return paramContext;
      }
      b localb = b.ae(paramContext);
      if (localb == null)
      {
        AppMethodBeat.o(10584);
        return null;
      }
      paramContext = a(paramContext, localb, "[DEFAULT]");
      AppMethodBeat.o(10584);
      return paramContext;
    }
  }
  
  private String getName()
  {
    AppMethodBeat.i(10578);
    zza();
    String str = this.mName;
    AppMethodBeat.o(10578);
    return str;
  }
  
  public static a rB()
  {
    AppMethodBeat.i(10583);
    synchronized (sLock)
    {
      Object localObject2 = (a)bec.get("[DEFAULT]");
      if (localObject2 == null)
      {
        localObject2 = ProcessUtils.getMyProcessName();
        localObject2 = new IllegalStateException(String.valueOf(localObject2).length() + 116 + "Default FirebaseApp is not initialized in this process " + (String)localObject2 + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
        AppMethodBeat.o(10583);
        throw ((Throwable)localObject2);
      }
    }
    AppMethodBeat.o(10583);
    return locala;
  }
  
  @KeepForSdk
  public static void rC()
  {
    AppMethodBeat.i(10586);
    synchronized (sLock)
    {
      ArrayList localArrayList = (ArrayList)new ArrayList(bec.values());
      int k = localArrayList.size();
      int i = 0;
      while (i < k)
      {
        Object localObject3 = localArrayList.get(i);
        int j = i + 1;
        localObject3 = (a)localObject3;
        i = j;
        if (((a)localObject3).beg.get())
        {
          ((a)localObject3).rE();
          i = j;
        }
      }
    }
    AppMethodBeat.o(10586);
  }
  
  @KeepForSdk
  @VisibleForTesting
  private boolean rD()
  {
    AppMethodBeat.i(10590);
    boolean bool = "[DEFAULT]".equals(getName());
    AppMethodBeat.o(10590);
    return bool;
  }
  
  private final void rE()
  {
    AppMethodBeat.i(10591);
    Iterator localIterator = this.zzm.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(10591);
  }
  
  private final void zza()
  {
    AppMethodBeat.i(10589);
    if (!this.beh.get()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "FirebaseApp was deleted");
      AppMethodBeat.o(10589);
      return;
    }
  }
  
  private final void zzc()
  {
    AppMethodBeat.i(10592);
    boolean bool = android.support.v4.content.b.Q(this.bed);
    if (bool) {
      a.b.ad(this.bed);
    }
    for (;;)
    {
      a(a.class, this, bdX, bool);
      if (rD())
      {
        a(a.class, this, bdY, bool);
        a(Context.class, this.bed, bdZ, bool);
      }
      AppMethodBeat.o(10592);
      return;
      this.bef.aR(rD());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(10580);
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(10580);
      return false;
    }
    boolean bool = this.mName.equals(((a)paramObject).getName());
    AppMethodBeat.o(10580);
    return bool;
  }
  
  public final Context getApplicationContext()
  {
    AppMethodBeat.i(10577);
    zza();
    Context localContext = this.bed;
    AppMethodBeat.o(10577);
    return localContext;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(10581);
    int i = this.mName.hashCode();
    AppMethodBeat.o(10581);
    return i;
  }
  
  @KeepForSdk
  public final <T> T m(Class<T> paramClass)
  {
    AppMethodBeat.i(10587);
    zza();
    paramClass = com.google.firebase.components.c.a(this.bef, paramClass);
    AppMethodBeat.o(10587);
    return paramClass;
  }
  
  public final b rA()
  {
    AppMethodBeat.i(10579);
    zza();
    b localb = this.bee;
    AppMethodBeat.o(10579);
    return localb;
  }
  
  public String toString()
  {
    AppMethodBeat.i(10582);
    String str = Objects.toStringHelper(this).add("name", this.mName).add("options", this.bee).toString();
    AppMethodBeat.o(10582);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.firebase.a
 * JD-Core Version:    0.7.0.1
 */