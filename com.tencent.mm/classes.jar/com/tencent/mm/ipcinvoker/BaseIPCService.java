package com.tencent.mm.ipcinvoker;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
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
  private volatile boolean dGf;
  private volatile boolean dGg;
  private a.a dGh = new BaseIPCService.1(this);
  
  public final void bB(boolean paramBoolean)
  {
    if ((this.dGg) && (!paramBoolean))
    {
      com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "abort kill self(%s), the service was connected by other process.", new Object[] { getProcessName() });
      return;
    }
    com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "kill self(%s)", new Object[] { getProcessName() });
    this.dGf = true;
    b.BT().BU();
    Object localObject1 = b.BT();
    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "releaseAllIPCBridge", new Object[0]);
    if (!((b)localObject1).dGs.isEmpty()) {}
    synchronized (((b)localObject1).dGs)
    {
      if (((b)localObject1).dGs.isEmpty()) {}
      do
      {
        HashSet localHashSet;
        do
        {
          stopSelf();
          localObject1 = h.BW();
          ??? = getProcessName();
          ((h)localObject1).dGM.remove(???);
          m.o(new BaseIPCService.2(this));
          return;
          localHashSet = new HashSet(((b)localObject1).dGs.keySet());
        } while (localHashSet.isEmpty());
        ??? = localHashSet.iterator();
      } while (!((Iterator)???).hasNext());
      ((b)localObject1).fD((String)((Iterator)???).next());
    }
  }
  
  public abstract String getProcessName();
  
  public IBinder onBind(Intent paramIntent)
  {
    com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "onBind(%s), killSelf(%s)", new Object[] { paramIntent, Boolean.valueOf(this.dGf) });
    if (this.dGf)
    {
      com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "need to kill self, return null Binder object.", new Object[0]);
      return null;
    }
    paramIntent = h.BW();
    String str = e.BV();
    if ((str == null) || (str.length() == 0) || (this == null)) {}
    for (;;)
    {
      this.dGg = true;
      return this.dGh;
      paramIntent.dGM.put(str, this);
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "onUnbind(%s)", new Object[] { paramIntent });
    boolean bool = super.onUnbind(paramIntent);
    this.dGg = false;
    return bool;
  }
  
  private static final class a
    implements c<Parcelable>, a
  {
    com.tencent.mm.ipcinvoker.b.b dGn;
    final List<com.tencent.mm.ipcinvoker.e.b> dGo = new LinkedList();
    
    public a(com.tencent.mm.ipcinvoker.b.b paramb)
    {
      this.dGn = paramb;
      if (paramb != null)
      {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "keep ref of callback(%s)", new Object[] { Integer.valueOf(paramb.hashCode()) });
        com.tencent.mm.ipcinvoker.f.b.Z(paramb);
      }
    }
    
    public final void a(com.tencent.mm.ipcinvoker.e.b paramb)
    {
      if (paramb == null) {
        return;
      }
      synchronized (this.dGo)
      {
        if (this.dGo.contains(paramb)) {
          return;
        }
      }
      this.dGo.add(paramb);
    }
    
    protected final void finalize()
    {
      try
      {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "finalize(%s)", new Object[] { Integer.valueOf(hashCode()) });
        if (this.dGn != null)
        {
          com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "finalize, release callback(%s)", new Object[] { Integer.valueOf(this.dGn.hashCode()) });
          m.post(new a(this.dGn));
          this.dGn = null;
        }
        return;
      }
      finally
      {
        super.finalize();
      }
    }
    
    private static final class a
      implements Runnable
    {
      private static final Bundle dGp;
      com.tencent.mm.ipcinvoker.b.b dGn;
      
      static
      {
        Bundle localBundle = new Bundle();
        dGp = localBundle;
        localBundle.putBoolean("__command_release_ref", true);
      }
      
      a(com.tencent.mm.ipcinvoker.b.b paramb)
      {
        this.dGn = paramb;
      }
      
      public final void run()
      {
        try
        {
          com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "notify release ref of callback(%s).", new Object[] { Integer.valueOf(this.dGn.hashCode()) });
          this.dGn.g(dGp);
          com.tencent.mm.ipcinvoker.f.b.aa(this.dGn);
          this.dGn = null;
          return;
        }
        catch (RemoteException localRemoteException)
        {
          com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvokeCallbackProxy", "notify release ref error, %s", new Object[] { Log.getStackTraceString(localRemoteException) });
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvokeCallbackProxy", "notify release ref error, %s\n %s", new Object[] { localException.getMessage(), Log.getStackTraceString(localException) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.BaseIPCService
 * JD-Core Version:    0.7.0.1
 */