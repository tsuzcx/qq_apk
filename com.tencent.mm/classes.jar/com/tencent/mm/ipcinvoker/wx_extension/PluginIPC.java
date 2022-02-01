package com.tencent.mm.ipcinvoker.wx_extension;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.k.1;
import com.tencent.mm.ipcinvoker.k.2;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand0IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand1IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand2IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand3IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand4IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.LiteAppIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.LiteAppIPCService.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.PushProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.File;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public class PluginIPC
  extends com.tencent.mm.kernel.b.f
  implements q, b
{
  private static final long mzF;
  
  static
  {
    AppMethodBeat.i(146424);
    mzF = TimeUnit.DAYS.toMillis(1L);
    AppMethodBeat.o(146424);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(146422);
    Log.i("MicroMsg.PluginIPC", "execute(%s)", new Object[] { paramg.mProcessName });
    if (MMApplicationContext.isMainProcess())
    {
      int i = 0;
      for (;;)
      {
        if (i <= 0)
        {
          paramg = new String[] { "MicroMsg.XIPC.MMProtoBufTransfer" }[i];
          try
          {
            u localu = new u(MMApplicationContext.getContext().getFilesDir().getAbsolutePath() + "/mmkv/" + paramg);
            if (localu.jKS())
            {
              localu.diJ();
              y.deleteFile(ah.v(localu.jKT()) + ".crc");
            }
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.e("MicroMsg.PluginIPC", "delete MMProtoBufTransfer dirty file[%s] e = %s", new Object[] { paramg, localException });
            }
          }
        }
      }
    }
    paramg = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bGP;
    com.tencent.mm.ipcinvoker.a.a local1 = new com.tencent.mm.ipcinvoker.a.a()
    {
      public final void a(com.tencent.mm.ipcinvoker.a.d paramAnonymousd)
      {
        AppMethodBeat.i(146416);
        super.a(paramAnonymousd);
        paramAnonymousd.a(PluginIPC.a.mzt);
        AppMethodBeat.o(146416);
      }
      
      public final void a(com.tencent.mm.ipcinvoker.a.e paramAnonymouse)
      {
        AppMethodBeat.i(146417);
        super.a(paramAnonymouse);
        MultiProcessMMKV.init();
        paramAnonymouse.a(new c());
        paramAnonymouse.a(new a());
        paramAnonymouse.a(new d());
        AppMethodBeat.o(146417);
      }
      
      public final void b(com.tencent.mm.ipcinvoker.a.d paramAnonymousd)
      {
        AppMethodBeat.i(146418);
        paramAnonymousd.e(MainProcessIPCService.PROCESS_NAME, MainProcessIPCService.class);
        paramAnonymousd.e(ToolsProcessIPCService.PROCESS_NAME, ToolsProcessIPCService.class);
        paramAnonymousd.e(ToolsMpProcessIPCService.PROCESS_NAME, ToolsMpProcessIPCService.class);
        paramAnonymousd.e(SupportProcessIPCService.PROCESS_NAME, SupportProcessIPCService.class);
        paramAnonymousd.e(Appbrand0IPCService.PROCESS_NAME, Appbrand0IPCService.class);
        paramAnonymousd.e(Appbrand1IPCService.PROCESS_NAME, Appbrand1IPCService.class);
        paramAnonymousd.e(Appbrand2IPCService.PROCESS_NAME, Appbrand2IPCService.class);
        paramAnonymousd.e(Appbrand3IPCService.PROCESS_NAME, Appbrand3IPCService.class);
        paramAnonymousd.e(Appbrand4IPCService.PROCESS_NAME, Appbrand4IPCService.class);
        LiteAppIPCService.a locala = LiteAppIPCService.mzL;
        paramAnonymousd.e(LiteAppIPCService.aYL(), LiteAppIPCService.class);
        paramAnonymousd.e(PushProcessIPCService.PROCESS_NAME, PushProcessIPCService.class);
        AppMethodBeat.o(146418);
      }
    };
    Assert.assertNotNull(paramg);
    com.tencent.mm.ipcinvoker.i.sContext = paramg;
    k.1 local11 = new k.1(paramg);
    local1.a(local11);
    local1.a(new k.2());
    local1.b(local11);
    com.tencent.mm.ipcinvoker.h.c.i("IPC.IPCInvokerBoot", "setup IPCInvoker(process : %s, application : %s)", new Object[] { com.tencent.mm.ipcinvoker.i.aYs(), Integer.valueOf(paramg.hashCode()) });
    if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isImeProcess())) {
      k.EY(MainProcessIPCService.PROCESS_NAME);
    }
    AppMethodBeat.o(146422);
  }
  
  public void onAppBackground(String paramString)
  {
    AppMethodBeat.i(146423);
    if (MMApplicationContext.isMainProcess()) {
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          boolean bool = true;
          AppMethodBeat.i(146419);
          try
          {
            long l1 = com.tencent.mm.kernel.h.baE().ban().a(at.a.acOn, 0L);
            long l2 = PluginIPC.mzF;
            long l3 = Util.nowMilliSecond();
            if (l1 + l2 <= l3) {
              try
              {
                if (c.aBP().totalSize() >= 20971520L) {}
                for (;;)
                {
                  Log.i("MicroMsg.PluginIPC", "do check MMProtoBuf mmkv file too large, needClear[%b]", new Object[] { Boolean.valueOf(bool) });
                  if (bool) {
                    c.aBP().clearAll();
                  }
                  com.tencent.mm.kernel.h.baE().ban().set(at.a.acOn, Long.valueOf(Util.nowMilliSecond()));
                  AppMethodBeat.o(146419);
                  return;
                  bool = false;
                }
                try
                {
                  Log.e("MicroMsg.PluginIPC", "do check MMProtoBuf mmkv file too large, exception = %s", new Object[] { localObject1 });
                  return;
                }
                finally
                {
                  com.tencent.mm.kernel.h.baE().ban().set(at.a.acOn, Long.valueOf(Util.nowMilliSecond()));
                  AppMethodBeat.o(146419);
                }
              }
              finally {}
            }
            AppMethodBeat.o(146419);
          }
          finally
          {
            AppMethodBeat.o(146419);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(146423);
  }
  
  public void onAppForeground(String paramString) {}
  
  static final class a
    implements com.tencent.mm.ipcinvoker.h.a.a
  {
    static final com.tencent.mm.ipcinvoker.h.a.a mzt;
    
    static
    {
      AppMethodBeat.i(146421);
      mzt = new a();
      AppMethodBeat.o(146421);
    }
    
    public final void printLog(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(146420);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(146420);
        return;
        Log.v(paramString1, paramString2, paramVarArgs);
        AppMethodBeat.o(146420);
        return;
        Log.d(paramString1, paramString2, paramVarArgs);
        AppMethodBeat.o(146420);
        return;
        Log.i(paramString1, paramString2, paramVarArgs);
        AppMethodBeat.o(146420);
        return;
        Log.w(paramString1, paramString2, paramVarArgs);
        AppMethodBeat.o(146420);
        return;
        Log.e(paramString1, paramString2, paramVarArgs);
        AppMethodBeat.o(146420);
        return;
        Log.e(paramString1, paramString2, paramVarArgs);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.PluginIPC
 * JD-Core Version:    0.7.0.1
 */