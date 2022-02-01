package com.tencent.mm.ipcinvoker.wx_extension;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n;
import com.tencent.mm.ipcinvoker.i.1;
import com.tencent.mm.ipcinvoker.i.2;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand0IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand1IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand2IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand3IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand4IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.vfs.q;
import java.io.File;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public class PluginIPC
  extends f
  implements n, b
{
  private static final long fZY;
  
  static
  {
    AppMethodBeat.i(146424);
    fZY = TimeUnit.DAYS.toMillis(1L);
    AppMethodBeat.o(146424);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(146422);
    ad.i("MicroMsg.PluginIPC", "execute(%s)", new Object[] { paramg.mProcessName });
    if (aj.cbe())
    {
      int i = 0;
      for (;;)
      {
        if (i <= 0)
        {
          paramg = new String[] { "MicroMsg.XIPC.MMProtoBufTransfer" }[i];
          try
          {
            com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(aj.getContext().getFilesDir().getAbsolutePath() + "/mmkv/" + paramg);
            if (locale.exists())
            {
              locale.delete();
              com.tencent.mm.vfs.i.deleteFile(q.B(locale.fhU()) + ".crc");
            }
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ad.e("MicroMsg.PluginIPC", "delete MMProtoBufTransfer dirty file[%s] e = %s", new Object[] { paramg, localException });
            }
          }
        }
      }
    }
    paramg = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).ca;
    com.tencent.mm.ipcinvoker.a.a local1 = new com.tencent.mm.ipcinvoker.a.a()
    {
      public final void a(com.tencent.mm.ipcinvoker.a.d paramAnonymousd)
      {
        AppMethodBeat.i(146416);
        super.a(paramAnonymousd);
        paramAnonymousd.a(PluginIPC.a.fZR);
        AppMethodBeat.o(146416);
      }
      
      public final void a(com.tencent.mm.ipcinvoker.a.e paramAnonymouse)
      {
        AppMethodBeat.i(146417);
        super.a(paramAnonymouse);
        ax.init();
        paramAnonymouse.a(new c());
        paramAnonymouse.a(new a());
        paramAnonymouse.a(new d());
        AppMethodBeat.o(146417);
      }
      
      public final void b(com.tencent.mm.ipcinvoker.a.d paramAnonymousd)
      {
        AppMethodBeat.i(146418);
        paramAnonymousd.a("com.tencent.mm", MainProcessIPCService.class);
        paramAnonymousd.a("com.tencent.mm:tools", ToolsProcessIPCService.class);
        paramAnonymousd.a("com.tencent.mm:toolsmp", ToolsMpProcessIPCService.class);
        paramAnonymousd.a("com.tencent.mm:support", SupportProcessIPCService.class);
        paramAnonymousd.a("com.tencent.mm:appbrand0", Appbrand0IPCService.class);
        paramAnonymousd.a("com.tencent.mm:appbrand1", Appbrand1IPCService.class);
        paramAnonymousd.a("com.tencent.mm:appbrand2", Appbrand2IPCService.class);
        paramAnonymousd.a("com.tencent.mm:appbrand3", Appbrand3IPCService.class);
        paramAnonymousd.a("com.tencent.mm:appbrand4", Appbrand4IPCService.class);
        AppMethodBeat.o(146418);
      }
    };
    Assert.assertNotNull(paramg);
    com.tencent.mm.ipcinvoker.g.sContext = paramg;
    i.1 local11 = new i.1(paramg);
    local1.a(local11);
    local1.a(new i.2());
    local1.b(local11);
    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokerBoot", "setup IPCInvoker(process : %s, application : %s)", new Object[] { com.tencent.mm.ipcinvoker.g.adv(), Integer.valueOf(paramg.hashCode()) });
    if ((aj.eFJ()) || (aj.eFK())) {
      com.tencent.mm.ipcinvoker.i.qq("com.tencent.mm");
    }
    AppMethodBeat.o(146422);
  }
  
  public void onAppBackground(String paramString)
  {
    AppMethodBeat.i(146423);
    if (aj.cbe()) {
      com.tencent.e.h.Iye.aP(new PluginIPC.2(this));
    }
    AppMethodBeat.o(146423);
  }
  
  public void onAppForeground(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.PluginIPC
 * JD-Core Version:    0.7.0.1
 */