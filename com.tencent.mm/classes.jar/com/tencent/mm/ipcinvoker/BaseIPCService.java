package com.tencent.mm.ipcinvoker;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
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
  private volatile boolean gzI;
  private volatile boolean gzJ;
  private a.a gzK = new a.a()
  {
    public final void a(final Bundle paramAnonymousBundle, final String paramAnonymousString, final com.tencent.mm.ipcinvoker.b.b paramAnonymousb)
    {
      AppMethodBeat.i(158708);
      if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeAsync failed, class is null or nil.", new Object[0]);
        AppMethodBeat.o(158708);
        return;
      }
      if (paramAnonymousBundle == null)
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeAsync failed, data is null.", new Object[0]);
        AppMethodBeat.o(158708);
        return;
      }
      paramAnonymousBundle.setClassLoader(BaseIPCService.class.getClassLoader());
      paramAnonymousBundle = paramAnonymousBundle.getParcelable("__remote_task_data");
      final b localb = (b)o.b(paramAnonymousString, b.class);
      if (localb == null)
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeAsync failed, can not newInstance by class %s.", new Object[] { paramAnonymousString });
        AppMethodBeat.o(158708);
        return;
      }
      com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "invokeAsync in target process, before ThreadPool.post, clazz=%s", new Object[] { paramAnonymousString });
      l.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(158707);
          try
          {
            localb.invoke(paramAnonymousBundle, new BaseIPCService.a(paramAnonymousb));
            AppMethodBeat.o(158707);
            return;
          }
          catch (NullPointerException localNullPointerException)
          {
            com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invoke task, clazz=%s, npe=%s", new Object[] { paramAnonymousString, localNullPointerException });
            AppMethodBeat.o(158707);
          }
        }
      });
      AppMethodBeat.o(158708);
    }
    
    public final Bundle e(Bundle paramAnonymousBundle, String paramAnonymousString)
    {
      AppMethodBeat.i(158709);
      if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeSync failed, class is null or nil.", new Object[0]);
        AppMethodBeat.o(158709);
        return null;
      }
      if (paramAnonymousBundle == null)
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeSync failed, data is null.", new Object[0]);
        AppMethodBeat.o(158709);
        return null;
      }
      k localk = (k)o.b(paramAnonymousString, k.class);
      if (localk == null)
      {
        com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeSync failed, can not newInstance by class %s.", new Object[] { paramAnonymousString });
        AppMethodBeat.o(158709);
        return null;
      }
      paramAnonymousBundle.setClassLoader(BaseIPCService.class.getClassLoader());
      paramAnonymousBundle = paramAnonymousBundle.getParcelable("__remote_task_data");
      paramAnonymousString = new Bundle();
      paramAnonymousString.putParcelable("__remote_task_result_data", (Parcelable)localk.invoke(paramAnonymousBundle));
      AppMethodBeat.o(158709);
      return paramAnonymousString;
    }
  };
  
  public final void dy(boolean paramBoolean)
  {
    if ((this.gzJ) && (!paramBoolean))
    {
      com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "abort kill self(%s), the service was connected by other process.", new Object[] { getProcessName() });
      return;
    }
    com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "kill self(%s)", new Object[] { getProcessName() });
    this.gzI = true;
    c.ahJ().ahK();
    Object localObject1 = c.ahJ();
    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "releaseAllIPCBridge", new Object[0]);
    if (!((c)localObject1).gzW.isEmpty()) {}
    synchronized (((c)localObject1).gzW)
    {
      if (((c)localObject1).gzW.isEmpty()) {}
      do
      {
        HashSet localHashSet;
        do
        {
          stopSelf();
          localObject1 = j.ahN();
          ??? = getProcessName();
          ((j)localObject1).gAr.remove(???);
          l.w(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(158710);
              com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
              Object localObject = new Object();
              com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/ipcinvoker/BaseIPCService$2", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
              Process.killProcess(((Integer)locala.mt(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ipcinvoker/BaseIPCService$2", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
              AppMethodBeat.o(158710);
            }
          });
          return;
          localHashSet = new HashSet(((c)localObject1).gzW.keySet());
        } while (localHashSet.isEmpty());
        ??? = localHashSet.iterator();
      } while (!((Iterator)???).hasNext());
      ((c)localObject1).xc((String)((Iterator)???).next());
    }
  }
  
  public abstract String getProcessName();
  
  public IBinder onBind(Intent paramIntent)
  {
    com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "onBind(%s), killSelf(%s)", new Object[] { paramIntent, Boolean.valueOf(this.gzI) });
    if (this.gzI)
    {
      com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "need to kill self, return null Binder object.", new Object[0]);
      return null;
    }
    paramIntent = j.ahN();
    String str = g.ahM();
    if ((str == null) || (str.length() == 0)) {}
    for (;;)
    {
      this.gzJ = true;
      return this.gzK;
      paramIntent.gAr.put(str, this);
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "onUnbind(%s)", new Object[] { paramIntent });
    boolean bool = super.onUnbind(paramIntent);
    this.gzJ = false;
    return bool;
  }
  
  static final class a
    implements d<Parcelable>, com.tencent.mm.ipcinvoker.e.a
  {
    com.tencent.mm.ipcinvoker.b.b gzR;
    final List<com.tencent.mm.ipcinvoker.e.b> gzS;
    
    public a(com.tencent.mm.ipcinvoker.b.b paramb)
    {
      AppMethodBeat.i(158713);
      this.gzS = new LinkedList();
      this.gzR = paramb;
      if (paramb != null)
      {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "keep ref of callback(%s)", new Object[] { Integer.valueOf(paramb.hashCode()) });
        com.tencent.mm.ipcinvoker.f.b.bi(paramb);
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
      synchronized (this.gzS)
      {
        if (this.gzS.contains(paramb))
        {
          AppMethodBeat.o(158715);
          return;
        }
        this.gzS.add(paramb);
        AppMethodBeat.o(158715);
        return;
      }
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(158714);
      try
      {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "finalize(%s)", new Object[] { Integer.valueOf(hashCode()) });
        if (this.gzR != null)
        {
          com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "finalize, release callback(%s)", new Object[] { Integer.valueOf(this.gzR.hashCode()) });
          l.post(new a(this.gzR));
          this.gzR = null;
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
      private static final Bundle gzT;
      com.tencent.mm.ipcinvoker.b.b gzR;
      
      static
      {
        AppMethodBeat.i(158712);
        Bundle localBundle = new Bundle();
        gzT = localBundle;
        localBundle.putBoolean("__command_release_ref", true);
        AppMethodBeat.o(158712);
      }
      
      a(com.tencent.mm.ipcinvoker.b.b paramb)
      {
        this.gzR = paramb;
      }
      
      public final void run()
      {
        AppMethodBeat.i(158711);
        try
        {
          com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "notify release ref of callback(%s).", new Object[] { Integer.valueOf(this.gzR.hashCode()) });
          this.gzR.r(gzT);
          com.tencent.mm.ipcinvoker.f.b.bj(this.gzR);
          this.gzR = null;
          AppMethodBeat.o(158711);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvokeCallbackProxy", "notify release ref error, %s", new Object[] { Log.getStackTraceString(localRemoteException) });
          AppMethodBeat.o(158711);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvokeCallbackProxy", "notify release ref error, %s\n %s", new Object[] { localException.getMessage(), Log.getStackTraceString(localException) });
          AppMethodBeat.o(158711);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.BaseIPCService
 * JD-Core Version:    0.7.0.1
 */