package com.tencent.mm.plugin.appbrand.keepalive;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class a
{
  public static final a pOX;
  final HashMap<String, a> pOY;
  
  static
  {
    AppMethodBeat.i(47029);
    pOX = new a();
    AppMethodBeat.o(47029);
  }
  
  public a()
  {
    AppMethodBeat.i(47028);
    this.pOY = new HashMap();
    AppMethodBeat.o(47028);
  }
  
  static final class a
  {
    static final HashMap<String, Class<? extends AppBrandKeepAliveService>> pOZ;
    final String mProcessName;
    volatile int pPa;
    final ServiceConnection pPb;
    
    static
    {
      AppMethodBeat.i(275912);
      pOZ = new a.a.1();
      AppMethodBeat.o(275912);
    }
    
    public a(final String paramString)
    {
      AppMethodBeat.i(275911);
      this.pPa = 0;
      this.pPb = new ServiceConnection()
      {
        public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder) {}
        
        public final void onServiceDisconnected(ComponentName paramAnonymousComponentName) {}
      };
      this.mProcessName = paramString;
      j.b(paramString, new o()
      {
        public final void RQ()
        {
          AppMethodBeat.i(273546);
          Log.i("MicroMsg.AppBrandKeepAliveMMSavior.KeepAliveServiceConnector", "onProcessDied %s", new Object[] { paramString });
          synchronized (a.a.this)
          {
            a.a.a(a.a.this);
          }
        }
      });
      AppMethodBeat.o(275911);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keepalive.a
 * JD-Core Version:    0.7.0.1
 */