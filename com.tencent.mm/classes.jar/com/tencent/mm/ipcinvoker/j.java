package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b.b.a;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class j
{
  public static boolean Mp(String paramString)
  {
    AppMethodBeat.i(214820);
    if (i.Mo(paramString))
    {
      AppMethodBeat.o(214820);
      return true;
    }
    boolean bool = e.aFo().Mm(paramString);
    AppMethodBeat.o(214820);
    return bool;
  }
  
  private static Bundle a(Parcelable paramParcelable, String paramString)
  {
    AppMethodBeat.i(214823);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("__remote_task_data", paramParcelable);
    if (paramString != null) {
      localBundle.putString("__command_tag", paramString);
    }
    AppMethodBeat.o(214823);
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
    if (i.Mo(paramString))
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
    com.tencent.mm.ipcinvoker.b.a locala = e.aFo().Mk(paramString);
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
  
  public static <T extends d<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(String paramString, InputType paramInputType, Class<T> paramClass, f<ResultType> paramf)
  {
    AppMethodBeat.i(158740);
    boolean bool = a(paramString, paramInputType, paramClass, paramf, null);
    AppMethodBeat.o(158740);
    return bool;
  }
  
  public static <T extends d<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(String paramString1, final InputType paramInputType, final Class<T> paramClass, final f<ResultType> paramf, final String paramString2)
  {
    AppMethodBeat.i(214809);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      com.tencent.mm.ipcinvoker.h.c.e("IPC.IPCInvoker", "invokeAsync failed, process is null or nil.", new Object[0]);
      AppMethodBeat.o(214809);
      return false;
    }
    if (paramClass == null)
    {
      com.tencent.mm.ipcinvoker.h.c.e("IPC.IPCInvoker", "invokeAsync failed, taskClass is null(process : %s).", new Object[] { paramString1 });
      AppMethodBeat.o(214809);
      return false;
    }
    paramString1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(158735);
        Object localObject;
        if (i.Mo(this.jYz))
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
        com.tencent.mm.ipcinvoker.b.a locala = e.aFo().Mk(this.jYz);
        if (locala == null)
        {
          com.tencent.mm.ipcinvoker.h.c.e("IPC.IPCInvoker", "invokeAsync failed, get bridge is null by process(%s).", new Object[] { this.jYz });
          if ((paramf instanceof g)) {
            ((g)paramf).aFq();
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
                localObject = new j.a(this.jYz, paramf, bool);
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
              ((g)paramf).g(localException2);
              AppMethodBeat.o(158735);
            }
            localException1 = localException1;
            bool = false;
          }
        }
      }
    };
    paramInputType = i.jYL;
    if ((paramString2 != null) && (!paramString2.isEmpty()) && (paramInputType != null))
    {
      paramInputType.b(paramString1, paramString2);
      AppMethodBeat.o(214809);
      return true;
    }
    boolean bool = s.A(paramString1);
    AppMethodBeat.o(214809);
    return bool;
  }
  
  public static boolean a(String paramString, o paramo)
  {
    AppMethodBeat.i(214819);
    boolean bool = e.aFo().a(paramString, paramo);
    AppMethodBeat.o(214819);
    return bool;
  }
  
  public static void b(String paramString, o paramo)
  {
    AppMethodBeat.i(214816);
    e locale = e.aFo();
    if (paramo == null)
    {
      AppMethodBeat.o(214816);
      return;
    }
    synchronized (locale.jYy)
    {
      Set localSet = (Set)locale.jYy.get(paramString);
      Object localObject = localSet;
      if (localSet == null) {
        localObject = new HashSet();
      }
      ((Set)localObject).add(paramo);
      locale.jYy.put(paramString, localObject);
      AppMethodBeat.o(214816);
      return;
    }
  }
  
  public static void b(String paramString, p paramp)
  {
    AppMethodBeat.i(158741);
    e locale = e.aFo();
    if (paramp == null)
    {
      AppMethodBeat.o(158741);
      return;
    }
    synchronized (locale.jYw)
    {
      Set localSet = (Set)locale.jYw.get(paramString);
      Object localObject = localSet;
      if (localSet == null) {
        localObject = new HashSet();
      }
      ((Set)localObject).add(paramp);
      locale.jYw.put(paramString, localObject);
      AppMethodBeat.o(158741);
      return;
    }
  }
  
  public static void b(String paramString, q paramq)
  {
    AppMethodBeat.i(214810);
    e locale = e.aFo();
    if (paramq == null)
    {
      AppMethodBeat.o(214810);
      return;
    }
    synchronized (locale.jYx)
    {
      Set localSet = (Set)locale.jYx.get(paramString);
      Object localObject = localSet;
      if (localSet == null) {
        localObject = new HashSet();
      }
      ((Set)localObject).add(paramq);
      locale.jYx.put(paramString, localObject);
      AppMethodBeat.o(214810);
      return;
    }
  }
  
  public static void c(String paramString, p paramp)
  {
    AppMethodBeat.i(214813);
    e.aFo().a(paramString, paramp);
    AppMethodBeat.o(214813);
  }
  
  public static void c(String paramString, q paramq)
  {
    AppMethodBeat.i(214812);
    e.aFo().a(paramString, paramq);
    AppMethodBeat.o(214812);
  }
  
  static final class a
    extends b.a
    implements com.tencent.mm.ipcinvoker.f.c
  {
    String jYH;
    f jYP;
    boolean jYQ;
    
    a(String paramString, f paramf, boolean paramBoolean)
    {
      AppMethodBeat.i(214596);
      this.jYP = paramf;
      this.jYH = paramString;
      this.jYQ = paramBoolean;
      com.tencent.mm.ipcinvoker.f.b.a(paramString, this);
      com.tencent.mm.ipcinvoker.h.c.i("IPC.IPCInvokeCallbackWrapper", "keep ref of callback(%s)", new Object[] { Integer.valueOf(paramf.hashCode()) });
      AppMethodBeat.o(214596);
    }
    
    public final void C(Bundle paramBundle)
    {
      AppMethodBeat.i(158737);
      f localf = this.jYP;
      if (localf == null)
      {
        com.tencent.mm.ipcinvoker.h.c.w("IPC.IPCInvokeCallbackWrapper", "callback failed, ref has been release", new Object[0]);
        AppMethodBeat.o(158737);
        return;
      }
      if (paramBundle == null)
      {
        localf.aH(null);
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
        localf.aH(paramBundle.getParcelable("__remote_task_result_data"));
        return;
      }
      finally
      {
        if (this.jYQ) {
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
      this.jYP = null;
      com.tencent.mm.ipcinvoker.f.b.b(this.jYH, this);
      AppMethodBeat.o(158738);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.j
 * JD-Core Version:    0.7.0.1
 */