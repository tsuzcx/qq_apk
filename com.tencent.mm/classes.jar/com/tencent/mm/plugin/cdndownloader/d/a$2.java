package com.tencent.mm.plugin.cdndownloader.d;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cdndownloader.a.a.a;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.Set;

final class a$2
  implements ServiceConnection
{
  a$2(a parama) {}
  
  public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    AppMethodBeat.i(892);
    ab.i("MicroMsg.CDNDownloadClient", "onServiceConnected");
    a.a(this.kDM, a.a.r(paramIBinder));
    a.f(this.kDM);
    a.g(this.kDM);
    try
    {
      synchronized (a.access$800())
      {
        a.access$800().notifyAll();
        AppMethodBeat.o(892);
        return;
      }
      return;
    }
    catch (Exception ???)
    {
      AppMethodBeat.o(892);
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(893);
    ab.i("MicroMsg.CDNDownloadClient", "onServiceDisconnected");
    if (a.c(this.kDM).size() != 0)
    {
      paramComponentName = a.c(this.kDM).iterator();
      while (paramComponentName.hasNext()) {
        ((CDNTaskInfo)paramComponentName.next()).kDT = true;
      }
    }
    AppMethodBeat.o(893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.d.a.2
 * JD-Core Version:    0.7.0.1
 */