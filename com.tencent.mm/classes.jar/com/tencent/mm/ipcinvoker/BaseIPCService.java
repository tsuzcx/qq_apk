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
import com.tencent.mm.ipcinvoker.e.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class BaseIPCService
  extends Service
{
  private volatile boolean gdr;
  private volatile boolean gds;
  private a.a gdt = new a.a()
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
    
    public final Bundle f(Bundle paramAnonymousBundle, String paramAnonymousString)
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
      paramAnonymousString.putParcelable("__remote_task_result_data", (Parcelable)localk.ay(paramAnonymousBundle));
      AppMethodBeat.o(158709);
      return paramAnonymousString;
    }
  };
  
  public final void dv(boolean paramBoolean)
  {
    if ((this.gds) && (!paramBoolean))
    {
      com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "abort kill self(%s), the service was connected by other process.", new Object[] { getProcessName() });
      return;
    }
    com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "kill self(%s)", new Object[] { getProcessName() });
    this.gdr = true;
    c.aeI().aeJ();
    Object localObject1 = c.aeI();
    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "releaseAllIPCBridge", new Object[0]);
    if (!((c)localObject1).gdF.isEmpty()) {}
    synchronized (((c)localObject1).gdF)
    {
      if (((c)localObject1).gdF.isEmpty()) {}
      do
      {
        HashSet localHashSet;
        do
        {
          stopSelf();
          localObject1 = j.aeM();
          ??? = getProcessName();
          ((j)localObject1).gea.remove(???);
          l.y(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(158710);
              Process.killProcess(Process.myPid());
              AppMethodBeat.o(158710);
            }
          });
          return;
          localHashSet = new HashSet(((c)localObject1).gdF.keySet());
        } while (localHashSet.isEmpty());
        ??? = localHashSet.iterator();
      } while (!((Iterator)???).hasNext());
      ((c)localObject1).tD((String)((Iterator)???).next());
    }
  }
  
  public abstract String getProcessName();
  
  public IBinder onBind(Intent paramIntent)
  {
    com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "onBind(%s), killSelf(%s)", new Object[] { paramIntent, Boolean.valueOf(this.gdr) });
    if (this.gdr)
    {
      com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "need to kill self, return null Binder object.", new Object[0]);
      return null;
    }
    paramIntent = j.aeM();
    String str = g.aeL();
    if ((str == null) || (str.length() == 0)) {}
    for (;;)
    {
      this.gds = true;
      return this.gdt;
      paramIntent.gea.put(str, this);
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "onUnbind(%s)", new Object[] { paramIntent });
    boolean bool = super.onUnbind(paramIntent);
    this.gds = false;
    return bool;
  }
  
  static final class a
    implements d<Parcelable>, a
  {
    com.tencent.mm.ipcinvoker.b.b gdA;
    final List<com.tencent.mm.ipcinvoker.e.b> gdB;
    
    public a(com.tencent.mm.ipcinvoker.b.b paramb)
    {
      AppMethodBeat.i(158713);
      this.gdB = new LinkedList();
      this.gdA = paramb;
      if (paramb != null)
      {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "keep ref of callback(%s)", new Object[] { Integer.valueOf(paramb.hashCode()) });
        com.tencent.mm.ipcinvoker.f.b.bg(paramb);
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
      synchronized (this.gdB)
      {
        if (this.gdB.contains(paramb))
        {
          AppMethodBeat.o(158715);
          return;
        }
        this.gdB.add(paramb);
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
        if (this.gdA != null)
        {
          com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "finalize, release callback(%s)", new Object[] { Integer.valueOf(this.gdA.hashCode()) });
          l.post(new a(this.gdA));
          this.gdA = null;
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
      private static final Bundle gdC;
      com.tencent.mm.ipcinvoker.b.b gdA;
      
      static
      {
        AppMethodBeat.i(158712);
        Bundle localBundle = new Bundle();
        gdC = localBundle;
        localBundle.putBoolean("__command_release_ref", true);
        AppMethodBeat.o(158712);
      }
      
      a(com.tencent.mm.ipcinvoker.b.b paramb)
      {
        this.gdA = paramb;
      }
      
      public final void run()
      {
        AppMethodBeat.i(158711);
        try
        {
          com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "notify release ref of callback(%s).", new Object[] { Integer.valueOf(this.gdA.hashCode()) });
          this.gdA.q(gdC);
          com.tencent.mm.ipcinvoker.f.b.bh(this.gdA);
          this.gdA = null;
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