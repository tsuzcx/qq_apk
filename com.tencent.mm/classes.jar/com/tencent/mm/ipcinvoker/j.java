package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b.b.a;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker.WrapperParcelable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class j
{
  public static boolean EX(String paramString)
  {
    AppMethodBeat.i(235685);
    if (i.EW(paramString))
    {
      AppMethodBeat.o(235685);
      return true;
    }
    boolean bool = e.aYp().EU(paramString);
    AppMethodBeat.o(235685);
    return bool;
  }
  
  private static Bundle a(Parcelable paramParcelable, String paramString)
  {
    AppMethodBeat.i(235686);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("__remote_task_data", paramParcelable);
    if (paramString != null) {
      localBundle.putString("__command_tag", paramString);
    }
    AppMethodBeat.o(235686);
    return localBundle;
  }
  
  public static <T extends m<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> ResultType a(String paramString, InputType paramInputType, Class<T> paramClass)
  {
    AppMethodBeat.i(158742);
    if ((paramString == null) || (paramString.length() == 0))
    {
      com.tencent.mm.ipcinvoker.h.c.e("IPC.IPCInvoker", "invokeSync failed, process is null or nil.", new Object[0]);
      AppMethodBeat.o(158742);
      return null;
    }
    if (paramClass == null)
    {
      com.tencent.mm.ipcinvoker.h.c.e("IPC.IPCInvoker", "invokeSync failed, taskClass is null(process : %s).", new Object[] { paramString });
      AppMethodBeat.o(158742);
      return null;
    }
    if (i.EW(paramString))
    {
      paramString = ((m)r.c(paramClass, m.class)).invoke(paramInputType);
      if (paramString == null)
      {
        AppMethodBeat.o(158742);
        return null;
      }
      paramString = (Parcelable)paramString;
      AppMethodBeat.o(158742);
      return paramString;
    }
    com.tencent.mm.ipcinvoker.b.a locala = e.aYp().ES(paramString);
    if (locala == null)
    {
      com.tencent.mm.ipcinvoker.h.c.e("IPC.IPCInvoker", "invokeSync failed, get bridge is null by process(%s).", new Object[] { paramString });
      AppMethodBeat.o(158742);
      return null;
    }
    try
    {
      paramString = locala.e(a(paramInputType, null), paramClass.getName());
      if (paramString == null)
      {
        AppMethodBeat.o(158742);
        return null;
      }
      paramString.setClassLoader(j.class.getClassLoader());
      paramString = paramString.getParcelable("__remote_task_result_data");
      AppMethodBeat.o(158742);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      com.tencent.mm.ipcinvoker.h.c.d("IPC.IPCInvoker", "invokeSync failed, ipc invoke error : %s", new Object[] { paramString });
      AppMethodBeat.o(158742);
    }
    return null;
  }
  
  public static void a(f<?> paramf)
  {
    AppMethodBeat.i(235688);
    if (paramf == null)
    {
      AppMethodBeat.o(235688);
      return;
    }
    synchronized (a.aCw())
    {
      Object localObject = (WeakReference)a.aCw().get(paramf);
      if (localObject == null)
      {
        localObject = null;
        if (localObject != null) {
          ((a)localObject).recycle();
        }
        com.tencent.mm.ipcinvoker.f.b.cM(paramf);
        AppMethodBeat.o(235688);
        return;
      }
      localObject = (a)((WeakReference)localObject).get();
    }
  }
  
  public static void a(b paramb)
  {
    n.myU = paramb;
  }
  
  public static <T extends d<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(String paramString, InputType paramInputType, Class<? extends T> paramClass, f<ResultType> paramf)
  {
    AppMethodBeat.i(158740);
    boolean bool = a(paramString, paramInputType, paramClass, paramf, null);
    AppMethodBeat.o(158740);
    return bool;
  }
  
  public static <T extends d<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(String paramString1, final InputType paramInputType, final Class<T> paramClass, final f<ResultType> paramf, final String paramString2)
  {
    AppMethodBeat.i(235667);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      com.tencent.mm.ipcinvoker.h.c.e("IPC.IPCInvoker", "invokeAsync failed, process is null or nil.", new Object[0]);
      AppMethodBeat.o(235667);
      return false;
    }
    if (paramClass == null)
    {
      com.tencent.mm.ipcinvoker.h.c.e("IPC.IPCInvoker", "invokeAsync failed, taskClass is null(process : %s).", new Object[] { paramString1 });
      AppMethodBeat.o(235667);
      return false;
    }
    paramf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(158735);
        Object localObject;
        if (i.EW(j.this))
        {
          localObject = (d)r.c(paramClass, d.class);
          if (localObject == null)
          {
            com.tencent.mm.ipcinvoker.h.c.e("IPC.IPCInvoker", "invokeAsync failed, newInstance(%s) return null.", new Object[] { paramClass });
            AppMethodBeat.o(158735);
            return;
          }
          ((d)localObject).invoke(paramInputType, paramf);
          AppMethodBeat.o(158735);
          return;
        }
        com.tencent.mm.ipcinvoker.b.a locala = e.aYp().ES(j.this);
        if (locala == null)
        {
          com.tencent.mm.ipcinvoker.h.c.e("IPC.IPCInvoker", "invokeAsync failed, get bridge is null by process(%s).", new Object[] { j.this });
          if ((paramf instanceof g)) {
            ((g)paramf).aYr();
          }
          AppMethodBeat.o(158735);
          return;
        }
        try
        {
          bool = com.tencent.mm.ipcinvoker.h.a.e(paramClass, com.tencent.mm.ipcinvoker.c.a.class);
          localObject = null;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            try
            {
              if (paramf != null) {
                localObject = new j.a(j.this, paramf, bool);
              }
              locala.a(j.b(paramInputType, paramString2), paramClass.getName(), (com.tencent.mm.ipcinvoker.b.b)localObject);
              AppMethodBeat.o(158735);
              return;
            }
            catch (Exception localException2)
            {
              boolean bool;
              com.tencent.mm.ipcinvoker.h.c.d("IPC.IPCInvoker", "invokeAsync failed, ipc invoke error : %s", new Object[] { localException2 });
              if (!(paramf instanceof g)) {
                continue;
              }
              ((g)paramf).h(localException2);
              AppMethodBeat.o(158735);
            }
            localException1 = localException1;
            bool = false;
          }
        }
      }
    };
    if (n.myU != null)
    {
      paramClass = "IPCInvoker.invokeAsync#" + paramClass.getName();
      paramString1 = paramClass;
      if ((paramInputType instanceof XIPCInvoker.WrapperParcelable)) {
        paramString1 = paramClass + "#" + ((XIPCInvoker.WrapperParcelable)paramInputType).mzq;
      }
      n.myU.e(paramf, paramString1);
    }
    paramString1 = i.myG;
    if ((paramString2 != null) && (!paramString2.isEmpty()) && (paramString1 != null))
    {
      paramString1.d(paramf, paramString2);
      AppMethodBeat.o(235667);
      return true;
    }
    boolean bool = s.F(paramf);
    AppMethodBeat.o(235667);
    return bool;
  }
  
  public static boolean a(String paramString, o paramo)
  {
    AppMethodBeat.i(235683);
    boolean bool = e.aYp().a(paramString, paramo);
    AppMethodBeat.o(235683);
    return bool;
  }
  
  public static void b(String paramString, o paramo)
  {
    AppMethodBeat.i(235682);
    e locale = e.aYp();
    if (paramo == null)
    {
      AppMethodBeat.o(235682);
      return;
    }
    synchronized (locale.mys)
    {
      Set localSet = (Set)locale.mys.get(paramString);
      Object localObject = localSet;
      if (localSet == null) {
        localObject = new HashSet();
      }
      ((Set)localObject).add(paramo);
      locale.mys.put(paramString, localObject);
      AppMethodBeat.o(235682);
      return;
    }
  }
  
  public static void b(String paramString, p paramp)
  {
    AppMethodBeat.i(158741);
    e locale = e.aYp();
    if (paramp == null)
    {
      AppMethodBeat.o(158741);
      return;
    }
    synchronized (locale.myq)
    {
      Set localSet = (Set)locale.myq.get(paramString);
      Object localObject = localSet;
      if (localSet == null) {
        localObject = new HashSet();
      }
      ((Set)localObject).add(paramp);
      locale.myq.put(paramString, localObject);
      AppMethodBeat.o(158741);
      return;
    }
  }
  
  public static void b(String paramString, q paramq)
  {
    AppMethodBeat.i(235672);
    e locale = e.aYp();
    if (paramq == null)
    {
      AppMethodBeat.o(235672);
      return;
    }
    synchronized (locale.myr)
    {
      Set localSet = (Set)locale.myr.get(paramString);
      Object localObject = localSet;
      if (localSet == null) {
        localObject = new HashSet();
      }
      ((Set)localObject).add(paramq);
      locale.myr.put(paramString, localObject);
      AppMethodBeat.o(235672);
      return;
    }
  }
  
  public static void c(String paramString, p paramp)
  {
    AppMethodBeat.i(235679);
    e.aYp().a(paramString, paramp);
    AppMethodBeat.o(235679);
  }
  
  public static void c(String paramString, q paramq)
  {
    AppMethodBeat.i(235677);
    e.aYp().a(paramString, paramq);
    AppMethodBeat.o(235677);
  }
  
  static final class a
    extends b.a
    implements com.tencent.mm.ipcinvoker.f.c
  {
    private static final Map<f<?>, WeakReference<a>> myK;
    String myC;
    f myL;
    boolean myM;
    
    static
    {
      AppMethodBeat.i(235665);
      myK = new WeakHashMap();
      AppMethodBeat.o(235665);
    }
    
    a(String arg1, f paramf, boolean paramBoolean)
    {
      AppMethodBeat.i(235663);
      this.myL = paramf;
      this.myC = ???;
      this.myM = paramBoolean;
      com.tencent.mm.ipcinvoker.f.b.a(???, this);
      com.tencent.mm.ipcinvoker.h.c.i("IPC.IPCInvokeCallbackWrapper", "keep ref of callback(%s)", new Object[] { Integer.valueOf(paramf.hashCode()) });
      synchronized (myK)
      {
        myK.put(paramf, new WeakReference(this));
        AppMethodBeat.o(235663);
        return;
      }
    }
    
    public final void J(Bundle paramBundle)
    {
      AppMethodBeat.i(158737);
      f localf = this.myL;
      if (localf == null)
      {
        com.tencent.mm.ipcinvoker.h.c.w("IPC.IPCInvokeCallbackWrapper", "callback failed, ref has been release", new Object[0]);
        AppMethodBeat.o(158737);
        return;
      }
      if (paramBundle == null)
      {
        localf.onCallback(null);
        AppMethodBeat.o(158737);
        return;
      }
      paramBundle.setClassLoader(j.class.getClassLoader());
      if (paramBundle.getBoolean("__command_release_ref"))
      {
        com.tencent.mm.ipcinvoker.h.c.i("IPC.IPCInvokeCallbackWrapper", "release ref of callback(%s)", new Object[] { Integer.valueOf(localf.hashCode()) });
        recycle();
        AppMethodBeat.o(158737);
        return;
      }
      try
      {
        localf.onCallback(paramBundle.getParcelable("__remote_task_result_data"));
        return;
      }
      finally
      {
        if (this.myM) {
          recycle();
        }
        AppMethodBeat.o(158737);
      }
      AppMethodBeat.o(158737);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(158739);
      recycle();
      com.tencent.mm.ipcinvoker.h.c.i("IPC.IPCInvokeCallbackWrapper", "finalize(%s)", new Object[] { Integer.valueOf(hashCode()) });
      super.finalize();
      AppMethodBeat.o(158739);
    }
    
    public final void recycle()
    {
      AppMethodBeat.i(158738);
      f localf = this.myL;
      if (localf != null) {}
      synchronized (myK)
      {
        myK.remove(localf);
        this.myL = null;
        com.tencent.mm.ipcinvoker.f.b.b(this.myC, this);
        AppMethodBeat.o(158738);
        return;
      }
    }
  }
  
  public static abstract class b
  {
    final Map<Integer, String> myN = new HashMap();
    
    public final String A(Runnable paramRunnable)
    {
      if (this.myN.containsKey(Integer.valueOf(paramRunnable.hashCode()))) {
        return (String)this.myN.get(Integer.valueOf(paramRunnable.hashCode()));
      }
      return paramRunnable.getClass().getName();
    }
    
    public final void B(Runnable paramRunnable)
    {
      this.myN.remove(Integer.valueOf(paramRunnable.hashCode()));
    }
    
    public abstract void b(Runnable paramRunnable, String paramString);
    
    public abstract void c(Runnable paramRunnable, String paramString);
    
    public final void e(Runnable paramRunnable, String paramString)
    {
      if (this.myN.size() >= 1024) {
        this.myN.clear();
      }
      this.myN.put(Integer.valueOf(paramRunnable.hashCode()), paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.j
 * JD-Core Version:    0.7.0.1
 */