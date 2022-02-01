package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b.a;
import com.tencent.mm.ipcinvoker.b.b.a;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class h
{
  public static <T extends k<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> ResultType a(String paramString, InputType paramInputType, Class<T> paramClass)
  {
    AppMethodBeat.i(158742);
    if ((paramString == null) || (paramString.length() == 0))
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeSync failed, process is null or nil.", new Object[0]);
      AppMethodBeat.o(158742);
      return null;
    }
    if (g.wu(paramString))
    {
      paramString = ((k)o.i(paramClass, k.class)).invoke(paramInputType);
      if (paramString == null)
      {
        AppMethodBeat.o(158742);
        return null;
      }
      paramString = (Parcelable)paramString;
      AppMethodBeat.o(158742);
      return paramString;
    }
    a locala = c.ahu().wq(paramString);
    if (locala == null)
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeSync failed, get bridge is null by process(%s).", new Object[] { paramString });
      AppMethodBeat.o(158742);
      return null;
    }
    try
    {
      paramString = locala.e(c(paramInputType), paramClass.getName());
      if (paramString == null)
      {
        AppMethodBeat.o(158742);
        return null;
      }
      paramString.setClassLoader(h.class.getClassLoader());
      paramString = paramString.getParcelable("__remote_task_result_data");
      AppMethodBeat.o(158742);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      com.tencent.mm.ipcinvoker.h.b.d("IPC.IPCInvoker", "invokeSync failed, ipc invoke error : %s", new Object[] { paramString });
      AppMethodBeat.o(158742);
    }
    return null;
  }
  
  public static void a(String paramString, m paramm)
  {
    AppMethodBeat.i(186712);
    c.ahu().a(paramString, paramm);
    AppMethodBeat.o(186712);
  }
  
  public static void a(String paramString, n paramn)
  {
    AppMethodBeat.i(158741);
    c localc = c.ahu();
    Set localSet = (Set)localc.gxr.get(paramString);
    Object localObject = localSet;
    if (localSet == null) {
      localObject = new HashSet();
    }
    ((Set)localObject).add(paramn);
    localc.gxr.put(paramString, localObject);
    AppMethodBeat.o(158741);
  }
  
  public static <T extends b<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(String paramString, final InputType paramInputType, final Class<T> paramClass, final d<ResultType> paramd)
  {
    AppMethodBeat.i(158740);
    if ((paramString == null) || (paramString.length() == 0))
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeAsync failed, process is null or nil.", new Object[0]);
      AppMethodBeat.o(158740);
      return false;
    }
    if (paramClass == null)
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeAsync failed, taskClass is null(process : %s).", new Object[] { paramString });
      AppMethodBeat.o(158740);
      return false;
    }
    boolean bool = p.A(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(158735);
        if (g.wu(this.gxu))
        {
          localObject = (b)o.i(paramClass, b.class);
          if (localObject == null)
          {
            com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeAsync failed, newInstance(%s) return null.", new Object[] { paramClass });
            AppMethodBeat.o(158735);
            return;
          }
          ((b)localObject).invoke(paramInputType, paramd);
          AppMethodBeat.o(158735);
          return;
        }
        a locala = c.ahu().wq(this.gxu);
        if (locala == null)
        {
          com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeAsync failed, get bridge is null by process(%s).", new Object[] { this.gxu });
          if ((paramd instanceof e)) {
            ((e)paramd).ahw();
          }
          AppMethodBeat.o(158735);
          return;
        }
        Object localObject = null;
        try
        {
          if (paramd != null) {
            localObject = new h.a(this.gxu, paramd);
          }
          locala.a(h.d(paramInputType), paramClass.getName(), (com.tencent.mm.ipcinvoker.b.b)localObject);
          AppMethodBeat.o(158735);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          com.tencent.mm.ipcinvoker.h.b.d("IPC.IPCInvoker", "invokeAsync failed, ipc invoke error : %s", new Object[] { localRemoteException });
          AppMethodBeat.o(158735);
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          com.tencent.mm.ipcinvoker.h.b.d("IPC.IPCInvoker", "invokeAsync failed, ipc invoke error : %s", new Object[] { localIllegalArgumentException });
          AppMethodBeat.o(158735);
        }
      }
    });
    AppMethodBeat.o(158740);
    return bool;
  }
  
  public static boolean b(String paramString, m paramm)
  {
    AppMethodBeat.i(186713);
    boolean bool = c.ahu().b(paramString, paramm);
    AppMethodBeat.o(186713);
    return bool;
  }
  
  private static Bundle c(Parcelable paramParcelable)
  {
    AppMethodBeat.i(158743);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("__remote_task_data", paramParcelable);
    AppMethodBeat.o(158743);
    return localBundle;
  }
  
  static final class a
    extends b.a
    implements com.tencent.mm.ipcinvoker.f.c
  {
    String gxB;
    d gxH;
    
    a(String paramString, d paramd)
    {
      AppMethodBeat.i(158736);
      this.gxH = paramd;
      this.gxB = paramString;
      com.tencent.mm.ipcinvoker.f.b.a(paramString, this);
      com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackWrapper", "keep ref of callback(%s)", new Object[] { Integer.valueOf(paramd.hashCode()) });
      AppMethodBeat.o(158736);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(158739);
      recycle();
      com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackWrapper", "finalize(%s)", new Object[] { Integer.valueOf(hashCode()) });
      super.finalize();
      AppMethodBeat.o(158739);
    }
    
    public final void q(Bundle paramBundle)
    {
      AppMethodBeat.i(158737);
      d locald = this.gxH;
      if (locald == null)
      {
        com.tencent.mm.ipcinvoker.h.b.w("IPC.IPCInvokeCallbackWrapper", "callback failed, ref has been release", new Object[0]);
        AppMethodBeat.o(158737);
        return;
      }
      if (paramBundle == null)
      {
        locald.be(null);
        AppMethodBeat.o(158737);
        return;
      }
      paramBundle.setClassLoader(h.class.getClassLoader());
      if (paramBundle.getBoolean("__command_release_ref"))
      {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackWrapper", "release ref of callback(%s)", new Object[] { Integer.valueOf(locald.hashCode()) });
        recycle();
        AppMethodBeat.o(158737);
        return;
      }
      locald.be(paramBundle.getParcelable("__remote_task_result_data"));
      AppMethodBeat.o(158737);
    }
    
    public final void recycle()
    {
      AppMethodBeat.i(158738);
      this.gxH = null;
      com.tencent.mm.ipcinvoker.f.b.b(this.gxB, this);
      AppMethodBeat.o(158738);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.h
 * JD-Core Version:    0.7.0.1
 */