package com.tencent.mm.ipcinvoker;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b.a.a;
import com.tencent.mm.ipcinvoker.f.a;
import java.util.Map;

final class b$1
  implements ServiceConnection
{
  b$1(b paramb, b.a parama, Context paramContext, String paramString) {}
  
  public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    AppMethodBeat.i(114007);
    if (paramIBinder == null)
    {
      com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "onServiceConnected(%s), but service is null", new Object[] { Integer.valueOf(this.eDY.hashCode()) });
      this.val$context.unbindService(this.eDY.serviceConnection);
      b.a(this.eEa).remove(this.eDZ);
      this.eDY.serviceConnection = null;
      this.eDY.eEc = null;
    }
    for (;;)
    {
      if (this.eDY.eEe != null) {
        b.b(this.eEa).removeCallbacks(this.eDY.eEe);
      }
      synchronized (this.eDY)
      {
        this.eDY.eEd = false;
        this.eDY.notifyAll();
        this.eDY.eEe = null;
        AppMethodBeat.o(114007);
        return;
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "onServiceConnected(%s)", new Object[] { Integer.valueOf(this.eDY.hashCode()) });
        this.eDY.eEc = a.a.k(paramIBinder);
        try
        {
          paramIBinder.linkToDeath(new a(this.eDZ), 0);
        }
        catch (RemoteException ???)
        {
          com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCBridgeManager", "binder register linkToDeath listener error, %s", new Object[] { Log.getStackTraceString(???) });
        }
      }
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(114008);
    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "onServiceDisconnected(%s, tid : %s)", new Object[] { Integer.valueOf(this.eDY.hashCode()), Long.valueOf(Thread.currentThread().getId()) });
    this.eEa.lY(this.eDZ);
    com.tencent.mm.ipcinvoker.f.b.md(this.eDZ);
    b.a(this.eEa, this.eDZ);
    AppMethodBeat.o(114008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.b.1
 * JD-Core Version:    0.7.0.1
 */