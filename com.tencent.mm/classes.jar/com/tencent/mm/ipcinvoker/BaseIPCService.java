package com.tencent.mm.ipcinvoker;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b.a.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class BaseIPCService
  extends Service
{
  private volatile boolean jYf;
  private volatile boolean jYg;
  private a.a jYh = new a.a()
  {
    public final void a(Bundle paramAnonymousBundle, final String paramAnonymousString, final com.tencent.mm.ipcinvoker.b.b paramAnonymousb)
    {
      AppMethodBeat.i(158708);
      if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
      {
        com.tencent.mm.ipcinvoker.h.c.e("IPC.BaseIPCService", "invokeAsync failed, class is null or nil.", new Object[0]);
        AppMethodBeat.o(158708);
        return;
      }
      if (paramAnonymousBundle == null)
      {
        com.tencent.mm.ipcinvoker.h.c.e("IPC.BaseIPCService", "invokeAsync failed, data is null.", new Object[0]);
        AppMethodBeat.o(158708);
        return;
      }
      paramAnonymousBundle.setClassLoader(BaseIPCService.class.getClassLoader());
      final Parcelable localParcelable = paramAnonymousBundle.getParcelable("__remote_task_data");
      paramAnonymousBundle = paramAnonymousBundle.getString("__command_tag");
      final d locald = (d)r.b(paramAnonymousString, d.class);
      if (locald == null)
      {
        com.tencent.mm.ipcinvoker.h.c.e("IPC.BaseIPCService", "invokeAsync failed, can not newInstance by class %s.", new Object[] { paramAnonymousString });
        AppMethodBeat.o(158708);
        return;
      }
      com.tencent.mm.ipcinvoker.h.c.i("IPC.BaseIPCService", "invokeAsync in target process, before ThreadPool.post, clazz=%s", new Object[] { paramAnonymousString });
      paramAnonymousString = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(158707);
          try
          {
            locald.invoke(localParcelable, new BaseIPCService.a(paramAnonymousb));
            AppMethodBeat.o(158707);
            return;
          }
          catch (NullPointerException localNullPointerException)
          {
            com.tencent.mm.ipcinvoker.h.c.e("IPC.BaseIPCService", "invoke task, clazz=%s, npe=%s", new Object[] { paramAnonymousString, localNullPointerException });
            AppMethodBeat.o(158707);
          }
        }
      };
      paramAnonymousb = i.jYL;
      if ((paramAnonymousBundle != null) && (!paramAnonymousBundle.isEmpty()) && (paramAnonymousb != null))
      {
        paramAnonymousb.b(paramAnonymousString, paramAnonymousBundle);
        AppMethodBeat.o(158708);
        return;
      }
      n.post(paramAnonymousString);
      AppMethodBeat.o(158708);
    }
    
    public final Bundle e(Bundle paramAnonymousBundle, String paramAnonymousString)
    {
      AppMethodBeat.i(158709);
      if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
      {
        com.tencent.mm.ipcinvoker.h.c.e("IPC.BaseIPCService", "invokeSync failed, class is null or nil.", new Object[0]);
        AppMethodBeat.o(158709);
        return null;
      }
      if (paramAnonymousBundle == null)
      {
        com.tencent.mm.ipcinvoker.h.c.e("IPC.BaseIPCService", "invokeSync failed, data is null.", new Object[0]);
        AppMethodBeat.o(158709);
        return null;
      }
      m localm = (m)r.b(paramAnonymousString, m.class);
      if (localm == null)
      {
        com.tencent.mm.ipcinvoker.h.c.e("IPC.BaseIPCService", "invokeSync failed, can not newInstance by class %s.", new Object[] { paramAnonymousString });
        AppMethodBeat.o(158709);
        return null;
      }
      paramAnonymousBundle.setClassLoader(BaseIPCService.class.getClassLoader());
      paramAnonymousBundle = paramAnonymousBundle.getParcelable("__remote_task_data");
      paramAnonymousString = new Bundle();
      paramAnonymousString.putParcelable("__remote_task_result_data", (Parcelable)localm.invoke(paramAnonymousBundle));
      AppMethodBeat.o(158709);
      return paramAnonymousString;
    }
  };
  
  public final void eM(boolean paramBoolean)
  {
    if ((this.jYg) && (!paramBoolean))
    {
      com.tencent.mm.ipcinvoker.h.c.i("IPC.BaseIPCService", "abort kill self(%s), the service was connected by other process.", new Object[] { getProcessName() });
      return;
    }
    com.tencent.mm.ipcinvoker.h.c.i("IPC.BaseIPCService", "kill self(%s)", new Object[] { getProcessName() });
    this.jYf = true;
    e.aFo().aFp();
    Object localObject1 = e.aFo();
    com.tencent.mm.ipcinvoker.h.c.i("IPC.IPCBridgeManager", "releaseAllIPCBridge", new Object[0]);
    if (!((e)localObject1).jYu.isEmpty()) {}
    synchronized (((e)localObject1).jYu)
    {
      if (((e)localObject1).jYu.isEmpty()) {}
      do
      {
        HashSet localHashSet;
        do
        {
          stopSelf();
          localObject1 = l.aFs();
          ??? = getProcessName();
          ((l)localObject1).jYT.remove(???);
          n.x(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(158710);
              com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
              Object localObject = new Object();
              com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/ipcinvoker/BaseIPCService$2", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
              Process.killProcess(((Integer)locala.sf(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ipcinvoker/BaseIPCService$2", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
              AppMethodBeat.o(158710);
            }
          });
          return;
          localHashSet = new HashSet(((e)localObject1).jYu.keySet());
        } while (localHashSet.isEmpty());
        ??? = localHashSet.iterator();
      } while (!((Iterator)???).hasNext());
      ((e)localObject1).Mn((String)((Iterator)???).next());
    }
  }
  
  public abstract String getProcessName();
  
  public IBinder onBind(Intent paramIntent)
  {
    com.tencent.mm.ipcinvoker.h.c.i("IPC.BaseIPCService", "onBind(%s), killSelf(%s)", new Object[] { paramIntent, Boolean.valueOf(this.jYf) });
    if (this.jYf)
    {
      com.tencent.mm.ipcinvoker.h.c.i("IPC.BaseIPCService", "need to kill self, return null Binder object.", new Object[0]);
      return null;
    }
    paramIntent = l.aFs();
    String str = i.aFr();
    if ((str == null) || (str.length() == 0)) {}
    for (;;)
    {
      this.jYg = true;
      return this.jYh;
      paramIntent.jYT.put(str, this);
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    com.tencent.mm.ipcinvoker.h.c.i("IPC.BaseIPCService", "onUnbind(%s)", new Object[] { paramIntent });
    boolean bool = super.onUnbind(paramIntent);
    this.jYg = false;
    return bool;
  }
  
  static final class a
    implements com.tencent.mm.ipcinvoker.e.a, f<Parcelable>
  {
    com.tencent.mm.ipcinvoker.b.b jYo;
    final List<com.tencent.mm.ipcinvoker.e.b> jYp;
    
    public a(final com.tencent.mm.ipcinvoker.b.b paramb)
    {
      AppMethodBeat.i(158713);
      this.jYp = new LinkedList();
      this.jYo = paramb;
      if (paramb != null)
      {
        com.tencent.mm.ipcinvoker.h.c.i("IPC.IPCInvokeCallbackProxy", "keep ref of callback(%s)", new Object[] { Integer.valueOf(paramb.hashCode()) });
        com.tencent.mm.ipcinvoker.f.b.br(paramb);
        paramb = new IBinder.DeathRecipient()
        {
          public final void binderDied()
          {
            AppMethodBeat.i(214727);
            try
            {
              com.tencent.mm.ipcinvoker.h.c.i("IPC.IPCInvokeCallbackProxy", "binderDied(%s)", new Object[] { Integer.valueOf(paramb.hashCode()) });
              AppMethodBeat.o(214727);
              return;
            }
            catch (Exception localException)
            {
              com.tencent.mm.ipcinvoker.h.c.i("IPC.IPCInvokeCallbackProxy", "DeathRecipient %s", new Object[] { localException.getMessage() });
              AppMethodBeat.o(214727);
            }
          }
        };
        try
        {
          this.jYo.asBinder().linkToDeath(paramb, 0);
          AppMethodBeat.o(158713);
          return;
        }
        catch (RemoteException paramb)
        {
          com.tencent.mm.ipcinvoker.h.c.i("IPC.IPCInvokeCallbackProxy", "%s", new Object[] { paramb.getMessage() });
        }
      }
      AppMethodBeat.o(158713);
    }
    
    public final void a(com.tencent.mm.ipcinvoker.e.b paramb)
    {
      AppMethodBeat.i(158715);
      if (paramb == null)
      {
        AppMethodBeat.o(158715);
        return;
      }
      synchronized (this.jYp)
      {
        if (this.jYp.contains(paramb))
        {
          AppMethodBeat.o(158715);
          return;
        }
        this.jYp.add(paramb);
        AppMethodBeat.o(158715);
        return;
      }
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(158714);
      try
      {
        com.tencent.mm.ipcinvoker.h.c.i("IPC.IPCInvokeCallbackProxy", "finalize(%s)", new Object[] { Integer.valueOf(hashCode()) });
        if (this.jYo != null)
        {
          com.tencent.mm.ipcinvoker.h.c.i("IPC.IPCInvokeCallbackProxy", "finalize, release callback(%s)", new Object[] { Integer.valueOf(this.jYo.hashCode()) });
          n.post(new a(this.jYo));
          this.jYo = null;
        }
        return;
      }
      finally
      {
        super.finalize();
        AppMethodBeat.o(158714);
      }
    }
    
    static final class a
      implements Runnable
    {
      private static final Bundle jYr;
      com.tencent.mm.ipcinvoker.b.b jYo;
      
      static
      {
        AppMethodBeat.i(158712);
        Bundle localBundle = new Bundle();
        jYr = localBundle;
        localBundle.putBoolean("__command_release_ref", true);
        AppMethodBeat.o(158712);
      }
      
      a(com.tencent.mm.ipcinvoker.b.b paramb)
      {
        this.jYo = paramb;
      }
      
      public final void run()
      {
        AppMethodBeat.i(158711);
        try
        {
          com.tencent.mm.ipcinvoker.h.c.i("IPC.IPCInvokeCallbackProxy", "notify release ref of callback(%s).", new Object[] { Integer.valueOf(this.jYo.hashCode()) });
          this.jYo.C(jYr);
          com.tencent.mm.ipcinvoker.f.b.bs(this.jYo);
          this.jYo = null;
          AppMethodBeat.o(158711);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          com.tencent.mm.ipcinvoker.h.c.e("IPC.IPCInvokeCallbackProxy", "notify release ref error, %s", new Object[] { Log.getStackTraceString(localRemoteException) });
          AppMethodBeat.o(158711);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.ipcinvoker.h.c.e("IPC.IPCInvokeCallbackProxy", "notify release ref error, %s\n %s", new Object[] { localException.getMessage(), Log.getStackTraceString(localException) });
          AppMethodBeat.o(158711);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.BaseIPCService
 * JD-Core Version:    0.7.0.1
 */