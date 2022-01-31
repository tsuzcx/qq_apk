package com.tencent.mm.ipcinvoker;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.mm.ipcinvoker.b.a.a;
import com.tencent.mm.ipcinvoker.f.a;
import java.util.Map;

final class b$1
  implements ServiceConnection
{
  b$1(b paramb, b.a parama, Context paramContext, String paramString) {}
  
  public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    if (paramIBinder == null)
    {
      com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "onServiceConnected(%s), but service is null", new Object[] { Integer.valueOf(this.dGv.hashCode()) });
      this.val$context.unbindService(this.dGv.dGA);
      b.a(this.dGx).remove(this.dGw);
      this.dGv.dGA = null;
      this.dGv.dGz = null;
    }
    for (;;)
    {
      if (this.dGv.dGC != null) {
        b.b(this.dGx).removeCallbacks(this.dGv.dGC);
      }
      synchronized (this.dGv)
      {
        this.dGv.dGB = false;
        this.dGv.notifyAll();
        this.dGv.dGC = null;
        return;
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "onServiceConnected(%s)", new Object[] { Integer.valueOf(this.dGv.hashCode()) });
        this.dGv.dGz = a.a.j(paramIBinder);
        try
        {
          paramIBinder.linkToDeath(new a(this.dGw), 0);
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
    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "onServiceDisconnected(%s, tid : %s)", new Object[] { Integer.valueOf(this.dGv.hashCode()), Long.valueOf(Thread.currentThread().getId()) });
    this.dGx.fD(this.dGw);
    com.tencent.mm.ipcinvoker.f.b.fI(this.dGw);
    b.a(this.dGx, this.dGw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.b.1
 * JD-Core Version:    0.7.0.1
 */