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
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker.WrapperParcelable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class BaseIPCService
  extends Service
{
  private volatile boolean mxZ;
  private volatile boolean mya;
  private a.a myb = new a.a()
  {
    public final void a(final Bundle paramAnonymousBundle, final String paramAnonymousString, final com.tencent.mm.ipcinvoker.b.b paramAnonymousb)
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
      String str = paramAnonymousBundle.getString("__command_tag");
      paramAnonymousBundle = (d)r.f(paramAnonymousString, d.class);
      if (paramAnonymousBundle == null)
      {
        com.tencent.mm.ipcinvoker.h.c.e("IPC.BaseIPCService", "invokeAsync failed, can not newInstance by class %s.", new Object[] { paramAnonymousString });
        AppMethodBeat.o(158708);
        return;
      }
      com.tencent.mm.ipcinvoker.h.c.i("IPC.BaseIPCService", "invokeAsync in target process, before ThreadPool.post, clazz=%s", new Object[] { paramAnonymousString });
      paramAnonymousb = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(158707);
          try
          {
            paramAnonymousBundle.invoke(localParcelable, new BaseIPCService.a(paramAnonymousb));
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
      if (n.myU != null)
      {
        paramAnonymousString = "invokeAsync#".concat(String.valueOf(paramAnonymousString));
        paramAnonymousBundle = paramAnonymousString;
        if ((localParcelable instanceof XIPCInvoker.WrapperParcelable)) {
          paramAnonymousBundle = paramAnonymousString + "#" + ((XIPCInvoker.WrapperParcelable)localParcelable).mzq;
        }
        n.myU.e(paramAnonymousb, paramAnonymousBundle);
      }
      paramAnonymousBundle = i.myG;
      if ((str != null) && (!str.isEmpty()) && (paramAnonymousBundle != null))
      {
        paramAnonymousBundle.d(paramAnonymousb, str);
        AppMethodBeat.o(158708);
        return;
      }
      n.post(paramAnonymousb);
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
      m localm = (m)r.f(paramAnonymousString, m.class);
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
  
  public final void fw(boolean paramBoolean)
  {
    if ((this.mya) && (!paramBoolean))
    {
      com.tencent.mm.ipcinvoker.h.c.i("IPC.BaseIPCService", "abort kill self(%s), the service was connected by other process.", new Object[] { getProcessName() });
      return;
    }
    com.tencent.mm.ipcinvoker.h.c.i("IPC.BaseIPCService", "kill self(%s)", new Object[] { getProcessName() });
    this.mxZ = true;
    e.aYp().aYq();
    Object localObject1 = e.aYp();
    com.tencent.mm.ipcinvoker.h.c.i("IPC.IPCBridgeManager", "releaseAllIPCBridge", new Object[0]);
    if (!((e)localObject1).myo.isEmpty()) {}
    synchronized (((e)localObject1).myo)
    {
      if (((e)localObject1).myo.isEmpty()) {}
      do
      {
        HashSet localHashSet;
        do
        {
          stopSelf();
          localObject1 = l.aYt();
          ??? = getProcessName();
          ((l)localObject1).myQ.remove(???);
          n.C(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(158710);
              com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
              Object localObject = new Object();
              com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/ipcinvoker/BaseIPCService$2", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
              Process.killProcess(((Integer)locala.sb(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ipcinvoker/BaseIPCService$2", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
              AppMethodBeat.o(158710);
            }
          });
          return;
          localHashSet = new HashSet(((e)localObject1).myo.keySet());
        } while (localHashSet.isEmpty());
        ??? = localHashSet.iterator();
      } while (!((Iterator)???).hasNext());
      ((e)localObject1).EV((String)((Iterator)???).next());
    }
  }
  
  public abstract String getProcessName();
  
  public IBinder onBind(Intent paramIntent)
  {
    com.tencent.mm.ipcinvoker.h.c.i("IPC.BaseIPCService", "onBind(%s), killSelf(%s)", new Object[] { paramIntent, Boolean.valueOf(this.mxZ) });
    if (this.mxZ)
    {
      com.tencent.mm.ipcinvoker.h.c.i("IPC.BaseIPCService", "need to kill self, return null Binder object.", new Object[0]);
      return null;
    }
    paramIntent = l.aYt();
    String str = i.aYs();
    if ((str == null) || (str.length() == 0)) {}
    for (;;)
    {
      this.mya = true;
      return this.myb;
      paramIntent.myQ.put(str, this);
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    com.tencent.mm.ipcinvoker.h.c.i("IPC.BaseIPCService", "onUnbind(%s)", new Object[] { paramIntent });
    boolean bool = super.onUnbind(paramIntent);
    this.mya = false;
    return bool;
  }
  
  static final class a
    implements com.tencent.mm.ipcinvoker.e.a, f<Parcelable>
  {
    com.tencent.mm.ipcinvoker.b.b myi;
    final List<com.tencent.mm.ipcinvoker.e.b> myj;
    
    public a(final com.tencent.mm.ipcinvoker.b.b paramb)
    {
      AppMethodBeat.i(158713);
      this.myj = new LinkedList();
      this.myi = paramb;
      if (paramb != null)
      {
        com.tencent.mm.ipcinvoker.h.c.i("IPC.IPCInvokeCallbackProxy", "keep ref of callback(%s)", new Object[] { Integer.valueOf(paramb.hashCode()) });
        com.tencent.mm.ipcinvoker.f.b.cL(paramb);
        paramb = new IBinder.DeathRecipient()
        {
          public final void binderDied()
          {
            AppMethodBeat.i(235656);
            try
            {
              com.tencent.mm.ipcinvoker.h.c.i("IPC.IPCInvokeCallbackProxy", "binderDied(%s)", new Object[] { Integer.valueOf(paramb.hashCode()) });
              AppMethodBeat.o(235656);
              return;
            }
            catch (Exception localException)
            {
              com.tencent.mm.ipcinvoker.h.c.i("IPC.IPCInvokeCallbackProxy", "DeathRecipient %s", new Object[] { localException.getMessage() });
              AppMethodBeat.o(235656);
            }
          }
        };
        try
        {
          this.myi.asBinder().linkToDeath(paramb, 0);
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
      synchronized (this.myj)
      {
        if (this.myj.contains(paramb))
        {
          AppMethodBeat.o(158715);
          return;
        }
        this.myj.add(paramb);
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
        if (this.myi != null)
        {
          com.tencent.mm.ipcinvoker.h.c.i("IPC.IPCInvokeCallbackProxy", "finalize, release callback(%s)", new Object[] { Integer.valueOf(this.myi.hashCode()) });
          n.post(new a(this.myi));
          this.myi = null;
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
      private static final Bundle myl;
      com.tencent.mm.ipcinvoker.b.b myi;
      
      static
      {
        AppMethodBeat.i(158712);
        Bundle localBundle = new Bundle();
        myl = localBundle;
        localBundle.putBoolean("__command_release_ref", true);
        AppMethodBeat.o(158712);
      }
      
      a(com.tencent.mm.ipcinvoker.b.b paramb)
      {
        this.myi = paramb;
      }
      
      public final void run()
      {
        AppMethodBeat.i(158711);
        try
        {
          com.tencent.mm.ipcinvoker.h.c.i("IPC.IPCInvokeCallbackProxy", "notify release ref of callback(%s).", new Object[] { Integer.valueOf(this.myi.hashCode()) });
          this.myi.J(myl);
          com.tencent.mm.ipcinvoker.f.b.cM(this.myi);
          this.myi = null;
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