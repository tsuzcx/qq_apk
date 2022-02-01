package com.tencent.mm.plugin.appbrand.keepalive;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

final class a$a
{
  static final HashMap<String, Class<? extends AppBrandKeepAliveService>> sTy;
  final String mProcessName;
  final ServiceConnection sTA;
  volatile int sTz;
  
  static
  {
    AppMethodBeat.i(321261);
    sTy = new HashMap() {};
    AppMethodBeat.o(321261);
  }
  
  public a$a(final String paramString)
  {
    AppMethodBeat.i(321256);
    this.sTz = 0;
    this.sTA = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder) {}
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName) {}
    };
    this.mProcessName = paramString;
    j.b(paramString, new o()
    {
      public final void onDied()
      {
        AppMethodBeat.i(321258);
        Log.i("MicroMsg.AppBrandKeepAliveMMSavior.KeepAliveServiceConnector", "onProcessDied %s", new Object[] { paramString });
        synchronized (a.a.this)
        {
          a.a.a(a.a.this);
        }
      }
    });
    AppMethodBeat.o(321256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keepalive.a.a
 * JD-Core Version:    0.7.0.1
 */