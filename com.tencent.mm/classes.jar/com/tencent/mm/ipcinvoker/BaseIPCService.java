package com.tencent.mm.ipcinvoker;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
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
  private volatile boolean fYL;
  private volatile boolean fYM;
  private a.a fYN = new a.a()
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
      paramAnonymousString.putParcelable("__remote_task_result_data", (Parcelable)localk.aA(paramAnonymousBundle));
      AppMethodBeat.o(158709);
      return paramAnonymousString;
    }
  };
  
  public final void dv(boolean paramBoolean)
  {
    if ((this.fYM) && (!paramBoolean))
    {
      com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "abort kill self(%s), the service was connected by other process.", new Object[] { getProcessName() });
      return;
    }
    com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "kill self(%s)", new Object[] { getProcessName() });
    this.fYL = true;
    c.ads().adt();
    Object localObject1 = c.ads();
    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "releaseAllIPCBridge", new Object[0]);
    if (!((c)localObject1).fYZ.isEmpty()) {}
    synchronized (((c)localObject1).fYZ)
    {
      if (((c)localObject1).fYZ.isEmpty()) {}
      do
      {
        HashSet localHashSet;
        do
        {
          stopSelf();
          localObject1 = j.adw();
          ??? = getProcessName();
          ((j)localObject1).fZu.remove(???);
          l.x(new BaseIPCService.2(this));
          return;
          localHashSet = new HashSet(((c)localObject1).fYZ.keySet());
        } while (localHashSet.isEmpty());
        ??? = localHashSet.iterator();
      } while (!((Iterator)???).hasNext());
      ((c)localObject1).qo((String)((Iterator)???).next());
    }
  }
  
  public abstract String getProcessName();
  
  public IBinder onBind(Intent paramIntent)
  {
    com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "onBind(%s), killSelf(%s)", new Object[] { paramIntent, Boolean.valueOf(this.fYL) });
    if (this.fYL)
    {
      com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "need to kill self, return null Binder object.", new Object[0]);
      return null;
    }
    paramIntent = j.adw();
    String str = g.adv();
    if ((str == null) || (str.length() == 0)) {}
    for (;;)
    {
      this.fYM = true;
      return this.fYN;
      paramIntent.fZu.put(str, this);
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "onUnbind(%s)", new Object[] { paramIntent });
    boolean bool = super.onUnbind(paramIntent);
    this.fYM = false;
    return bool;
  }
  
  static final class a
    implements d<Parcelable>, a
  {
    com.tencent.mm.ipcinvoker.b.b fYU;
    final List<com.tencent.mm.ipcinvoker.e.b> fYV;
    
    public a(com.tencent.mm.ipcinvoker.b.b paramb)
    {
      AppMethodBeat.i(158713);
      this.fYV = new LinkedList();
      this.fYU = paramb;
      if (paramb != null)
      {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "keep ref of callback(%s)", new Object[] { Integer.valueOf(paramb.hashCode()) });
        com.tencent.mm.ipcinvoker.f.b.bj(paramb);
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
      synchronized (this.fYV)
      {
        if (this.fYV.contains(paramb))
        {
          AppMethodBeat.o(158715);
          return;
        }
        this.fYV.add(paramb);
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
        if (this.fYU != null)
        {
          com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "finalize, release callback(%s)", new Object[] { Integer.valueOf(this.fYU.hashCode()) });
          l.post(new a(this.fYU));
          this.fYU = null;
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
      private static final Bundle fYW;
      com.tencent.mm.ipcinvoker.b.b fYU;
      
      static
      {
        AppMethodBeat.i(158712);
        Bundle localBundle = new Bundle();
        fYW = localBundle;
        localBundle.putBoolean("__command_release_ref", true);
        AppMethodBeat.o(158712);
      }
      
      a(com.tencent.mm.ipcinvoker.b.b paramb)
      {
        this.fYU = paramb;
      }
      
      public final void run()
      {
        AppMethodBeat.i(158711);
        try
        {
          com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "notify release ref of callback(%s).", new Object[] { Integer.valueOf(this.fYU.hashCode()) });
          this.fYU.q(fYW);
          com.tencent.mm.ipcinvoker.f.b.bk(this.fYU);
          this.fYU = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.BaseIPCService
 * JD-Core Version:    0.7.0.1
 */