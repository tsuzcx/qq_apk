package com.tencent.mm.plugin.cdndownloader.d;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.plugin.cdndownloader.a.a.a;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Set;

final class a$2
  implements ServiceConnection
{
  a$2(a parama) {}
  
  public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    y.i("MicroMsg.CDNDownloadClient", "onServiceConnected");
    a.a(this.iAG, a.a.r(paramIBinder));
    a.f(this.iAG);
    a.g(this.iAG);
    try
    {
      synchronized (a.Tb())
      {
        a.Tb().notifyAll();
        return;
      }
      return;
    }
    catch (Exception ???) {}
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    y.i("MicroMsg.CDNDownloadClient", "onServiceDisconnected");
    if (a.c(this.iAG).size() != 0)
    {
      paramComponentName = a.c(this.iAG).iterator();
      while (paramComponentName.hasNext()) {
        ((CDNTaskInfo)paramComponentName.next()).iAN = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.d.a.2
 * JD-Core Version:    0.7.0.1
 */