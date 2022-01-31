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
  private volatile boolean eDH;
  private volatile boolean eDI;
  private a.a eDJ = new BaseIPCService.1(this);
  
  public final void cr(boolean paramBoolean)
  {
    if ((this.eDI) && (!paramBoolean))
    {
      com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "abort kill self(%s), the service was connected by other process.", new Object[] { getProcessName() });
      return;
    }
    com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "kill self(%s)", new Object[] { getProcessName() });
    this.eDH = true;
    b.PK().PL();
    Object localObject1 = b.PK();
    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "releaseAllIPCBridge", new Object[0]);
    if (!((b)localObject1).eDV.isEmpty()) {}
    synchronized (((b)localObject1).eDV)
    {
      if (((b)localObject1).eDV.isEmpty()) {}
      do
      {
        HashSet localHashSet;
        do
        {
          stopSelf();
          localObject1 = h.PN();
          ??? = getProcessName();
          ((h)localObject1).eEp.remove(???);
          m.s(new BaseIPCService.2(this));
          return;
          localHashSet = new HashSet(((b)localObject1).eDV.keySet());
        } while (localHashSet.isEmpty());
        ??? = localHashSet.iterator();
      } while (!((Iterator)???).hasNext());
      ((b)localObject1).lY((String)((Iterator)???).next());
    }
  }
  
  public abstract String getProcessName();
  
  public IBinder onBind(Intent paramIntent)
  {
    com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "onBind(%s), killSelf(%s)", new Object[] { paramIntent, Boolean.valueOf(this.eDH) });
    if (this.eDH)
    {
      com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "need to kill self, return null Binder object.", new Object[0]);
      return null;
    }
    paramIntent = h.PN();
    String str = e.PM();
    if ((str == null) || (str.length() == 0)) {}
    for (;;)
    {
      this.eDI = true;
      return this.eDJ;
      paramIntent.eEp.put(str, this);
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    com.tencent.mm.ipcinvoker.h.b.i("IPC.BaseIPCService", "onUnbind(%s)", new Object[] { paramIntent });
    boolean bool = super.onUnbind(paramIntent);
    this.eDI = false;
    return bool;
  }
  
  static final class a
    implements c<Parcelable>, a
  {
    com.tencent.mm.ipcinvoker.b.b eDQ;
    final List<com.tencent.mm.ipcinvoker.e.b> eDR;
    
    public a(com.tencent.mm.ipcinvoker.b.b paramb)
    {
      AppMethodBeat.i(114003);
      this.eDR = new LinkedList();
      this.eDQ = paramb;
      if (paramb != null)
      {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "keep ref of callback(%s)", new Object[] { Integer.valueOf(paramb.hashCode()) });
        com.tencent.mm.ipcinvoker.f.b.ah(paramb);
      }
      AppMethodBeat.o(114003);
    }
    
    public final void a(com.tencent.mm.ipcinvoker.e.b paramb)
    {
      AppMethodBeat.i(114005);
      if (paramb == null)
      {
        AppMethodBeat.o(114005);
        return;
      }
      synchronized (this.eDR)
      {
        if (this.eDR.contains(paramb))
        {
          AppMethodBeat.o(114005);
          return;
        }
        this.eDR.add(paramb);
        AppMethodBeat.o(114005);
        return;
      }
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(114004);
      try
      {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "finalize(%s)", new Object[] { Integer.valueOf(hashCode()) });
        if (this.eDQ != null)
        {
          com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "finalize, release callback(%s)", new Object[] { Integer.valueOf(this.eDQ.hashCode()) });
          m.post(new a(this.eDQ));
          this.eDQ = null;
        }
        return;
      }
      finally
      {
        super.finalize();
        AppMethodBeat.o(114004);
      }
    }
    
    static final class a
      implements Runnable
    {
      private static final Bundle eDS;
      com.tencent.mm.ipcinvoker.b.b eDQ;
      
      static
      {
        AppMethodBeat.i(114002);
        Bundle localBundle = new Bundle();
        eDS = localBundle;
        localBundle.putBoolean("__command_release_ref", true);
        AppMethodBeat.o(114002);
      }
      
      a(com.tencent.mm.ipcinvoker.b.b paramb)
      {
        this.eDQ = paramb;
      }
      
      public final void run()
      {
        AppMethodBeat.i(114001);
        try
        {
          com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackProxy", "notify release ref of callback(%s).", new Object[] { Integer.valueOf(this.eDQ.hashCode()) });
          this.eDQ.o(eDS);
          com.tencent.mm.ipcinvoker.f.b.ai(this.eDQ);
          this.eDQ = null;
          AppMethodBeat.o(114001);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvokeCallbackProxy", "notify release ref error, %s", new Object[] { Log.getStackTraceString(localRemoteException) });
          AppMethodBeat.o(114001);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvokeCallbackProxy", "notify release ref error, %s\n %s", new Object[] { localException.getMessage(), Log.getStackTraceString(localException) });
          AppMethodBeat.o(114001);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.BaseIPCService
 * JD-Core Version:    0.7.0.1
 */