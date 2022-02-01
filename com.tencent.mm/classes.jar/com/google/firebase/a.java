package com.google.firebase;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
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

public class a
{
  private static final Set<String> dBA;
  static final Map<String, a> dBB;
  private static final List<String> dBw;
  private static final List<String> dBx;
  private static final List<String> dBy;
  private static final List<String> dBz;
  private static final Object sLock;
  private final Context dBC;
  private final b dBD;
  private final n dBE;
  private final AtomicBoolean dBF;
  private final AtomicBoolean dBG;
  private final List<Object> dBH;
  private final List<Object> dBI;
  private a dBJ;
  private final String mName;
  private final List<Object> zzm;
  
  static
  {
    AppMethodBeat.i(4062);
    dBw = Arrays.asList(new String[] { "com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId" });
    dBx = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    dBy = Arrays.asList(new String[] { "com.google.android.gms.measurement.AppMeasurement" });
    dBz = Arrays.asList(new String[0]);
    dBA = Collections.emptySet();
    sLock = new Object();
    dBB = new androidx.b.a();
    AppMethodBeat.o(4062);
  }
  
  private a(Context paramContext, String paramString, b paramb)
  {
    AppMethodBeat.i(4055);
    this.dBF = new AtomicBoolean(false);
    this.dBG = new AtomicBoolean();
    this.dBH = new CopyOnWriteArrayList();
    this.zzm = new CopyOnWriteArrayList();
    this.dBI = new CopyOnWriteArrayList();
    this.dBC = ((Context)Preconditions.checkNotNull(paramContext));
    this.mName = Preconditions.checkNotEmpty(paramString);
    this.dBD = ((b)Preconditions.checkNotNull(paramb));
    this.dBJ = new com.google.firebase.b.a();
    paramContext = new k(this.dBC);
    this.dBE = new n(k.aq(paramContext.dCe.aW(paramContext.mContext)), new com.google.firebase.components.a[] { com.google.firebase.components.a.a(Context.class, this.dBC), com.google.firebase.components.a.a(a.class, this), com.google.firebase.components.a.a(b.class, this.dBD) });
    AppMethodBeat.o(4055);
  }
  
  public static a XX()
  {
    AppMethodBeat.i(4050);
    synchronized (sLock)
    {
      Object localObject2 = (a)dBB.get("[DEFAULT]");
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
  
  public static void XY()
  {
    AppMethodBeat.i(4053);
    synchronized (sLock)
    {
      ArrayList localArrayList = (ArrayList)new ArrayList(dBB.values());
      int k = localArrayList.size();
      int i = 0;
      while (i < k)
      {
        Object localObject3 = localArrayList.get(i);
        int j = i + 1;
        localObject3 = (a)localObject3;
        i = j;
        if (((a)localObject3).dBF.get())
        {
          ((a)localObject3).Ya();
          i = j;
        }
      }
    }
    AppMethodBeat.o(4053);
  }
  
  private boolean XZ()
  {
    AppMethodBeat.i(4057);
    boolean bool = "[DEFAULT]".equals(getName());
    AppMethodBeat.o(4057);
    return bool;
  }
  
  private final void Ya()
  {
    AppMethodBeat.i(4058);
    Iterator localIterator = this.zzm.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(4058);
  }
  
  private static a a(Context arg0, b paramb, String paramString)
  {
    AppMethodBeat.i(4052);
    com.google.firebase.b.b.YC();
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
      if (!dBB.containsKey(str))
      {
        bool = true;
        Preconditions.checkState(bool, String.valueOf(str).length() + 33 + "FirebaseApp name " + str + " already exists!");
        Preconditions.checkNotNull(paramString, "Application context cannot be null.");
        paramb = new a(paramString, str, paramb);
        dBB.put(str, paramb);
        com.google.firebase.b.b.YD();
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
        if (dBz.contains(paramIterable))
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
        if (dBA.contains(paramIterable))
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
  
  public static a aS(Context paramContext)
  {
    AppMethodBeat.i(4051);
    synchronized (sLock)
    {
      if (dBB.containsKey("[DEFAULT]"))
      {
        paramContext = XX();
        AppMethodBeat.o(4051);
        return paramContext;
      }
      b localb = b.aU(paramContext);
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
  
  private final void zza()
  {
    AppMethodBeat.i(4056);
    if (!this.dBG.get()) {}
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
    boolean bool = androidx.core.content.a.ad(this.dBC);
    if (bool) {
      b.aT(this.dBC);
    }
    for (;;)
    {
      a(a.class, this, dBw, bool);
      if (XZ())
      {
        a(a.class, this, dBx, bool);
        a(Context.class, this.dBC, dBy, bool);
      }
      AppMethodBeat.o(4059);
      return;
      this.dBE.bU(XZ());
    }
  }
  
  public final b XW()
  {
    AppMethodBeat.i(4046);
    zza();
    b localb = this.dBD;
    AppMethodBeat.o(4046);
    return localb;
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
    Context localContext = this.dBC;
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
    String str = Objects.toStringHelper(this).add("name", this.mName).add("options", this.dBD).toString();
    AppMethodBeat.o(4049);
    return str;
  }
  
  public final <T> T v(Class<T> paramClass)
  {
    AppMethodBeat.i(4054);
    zza();
    paramClass = com.google.firebase.components.c.a(this.dBE, paramClass);
    AppMethodBeat.o(4054);
    return paramClass;
  }
  
  public static abstract interface a {}
  
  static final class b
    extends BroadcastReceiver
  {
    private static AtomicReference<b> dBK;
    private final Context dBC;
    
    static
    {
      AppMethodBeat.i(4043);
      dBK = new AtomicReference();
      AppMethodBeat.o(4043);
    }
    
    private b(Context paramContext)
    {
      this.dBC = paramContext;
    }
    
    public final void onReceive(Context arg1, Intent paramIntent)
    {
      AppMethodBeat.i(4041);
      synchronized (a.Yb())
      {
        paramIntent = a.dBB.values().iterator();
        if (paramIntent.hasNext()) {
          a.a((a)paramIntent.next());
        }
      }
      this.dBC.unregisterReceiver(this);
      AppMethodBeat.o(4041);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.a
 * JD-Core Version:    0.7.0.1
 */