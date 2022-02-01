package com.tencent.mm.ipcinvoker.wx_extension;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.a.e;
import com.tencent.mm.ipcinvoker.i.1;
import com.tencent.mm.ipcinvoker.i.2;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand0IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand1IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand2IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand3IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand4IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.LiteAppIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.LiteAppIPCService.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public class PluginIPC
  extends f
  implements com.tencent.mm.app.o, b
{
  private static final long hnK;
  
  static
  {
    AppMethodBeat.i(146424);
    hnK = TimeUnit.DAYS.toMillis(1L);
    AppMethodBeat.o(146424);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
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
            com.tencent.mm.vfs.o localo = new com.tencent.mm.vfs.o(MMApplicationContext.getContext().getFilesDir().getAbsolutePath() + "/mmkv/" + paramg);
            if (localo.exists())
            {
              localo.delete();
              s.deleteFile(aa.z(localo.her()) + ".crc");
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
    paramg = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).ca;
    com.tencent.mm.ipcinvoker.a.a local1 = new com.tencent.mm.ipcinvoker.a.a()
    {
      public final void a(com.tencent.mm.ipcinvoker.a.d paramAnonymousd)
      {
        AppMethodBeat.i(146416);
        super.a(paramAnonymousd);
        paramAnonymousd.a(PluginIPC.a.hnD);
        AppMethodBeat.o(146416);
      }
      
      public final void a(e paramAnonymouse)
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
        paramAnonymousd.a(MainProcessIPCService.dkO, MainProcessIPCService.class);
        paramAnonymousd.a(ToolsProcessIPCService.dkO, ToolsProcessIPCService.class);
        paramAnonymousd.a(ToolsMpProcessIPCService.dkO, ToolsMpProcessIPCService.class);
        paramAnonymousd.a(SupportProcessIPCService.dkO, SupportProcessIPCService.class);
        paramAnonymousd.a(Appbrand0IPCService.dkO, Appbrand0IPCService.class);
        paramAnonymousd.a(Appbrand1IPCService.dkO, Appbrand1IPCService.class);
        paramAnonymousd.a(Appbrand2IPCService.dkO, Appbrand2IPCService.class);
        paramAnonymousd.a(Appbrand3IPCService.dkO, Appbrand3IPCService.class);
        paramAnonymousd.a(Appbrand4IPCService.dkO, Appbrand4IPCService.class);
        LiteAppIPCService.a locala = LiteAppIPCService.hnQ;
        paramAnonymousd.a(LiteAppIPCService.ays(), LiteAppIPCService.class);
        AppMethodBeat.o(146418);
      }
    };
    Assert.assertNotNull(paramg);
    com.tencent.mm.ipcinvoker.g.sContext = paramg;
    i.1 local11 = new i.1(paramg);
    local1.a(local11);
    local1.a(new i.2());
    local1.b(local11);
    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokerBoot", "setup IPCInvoker(process : %s, application : %s)", new Object[] { com.tencent.mm.ipcinvoker.g.axZ(), Integer.valueOf(paramg.hashCode()) });
    if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess())) {
      com.tencent.mm.ipcinvoker.i.Fq(MainProcessIPCService.dkO);
    }
    AppMethodBeat.o(146422);
  }
  
  public void onAppBackground(String paramString)
  {
    AppMethodBeat.i(146423);
    if (MMApplicationContext.isMainProcess()) {
      com.tencent.f.h.RTc.aX(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: iconst_1
          //   1: istore_1
          //   2: ldc 25
          //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   7: invokestatic 37	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
          //   10: invokevirtual 43	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
          //   13: getstatic 49	com/tencent/mm/storage/ar$a:NYS	Lcom/tencent/mm/storage/ar$a;
          //   16: lconst_0
          //   17: invokevirtual 55	com/tencent/mm/storage/ao:a	(Lcom/tencent/mm/storage/ar$a;J)J
          //   20: lstore_2
          //   21: invokestatic 59	com/tencent/mm/ipcinvoker/wx_extension/PluginIPC:access$000	()J
          //   24: lstore 4
          //   26: invokestatic 64	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
          //   29: lstore 6
          //   31: lload_2
          //   32: lload 4
          //   34: ladd
          //   35: lload 6
          //   37: lcmp
          //   38: ifgt +151 -> 189
          //   41: invokestatic 70	com/tencent/mm/ipcinvoker/wx_extension/c:VQ	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
          //   44: invokevirtual 75	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:totalSize	()J
          //   47: ldc2_w 76
          //   50: lcmp
          //   51: iflt +55 -> 106
          //   54: ldc 79
          //   56: ldc 81
          //   58: iconst_1
          //   59: anewarray 4	java/lang/Object
          //   62: dup
          //   63: iconst_0
          //   64: iload_1
          //   65: invokestatic 87	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   68: aastore
          //   69: invokestatic 92	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   72: iload_1
          //   73: ifeq +9 -> 82
          //   76: invokestatic 70	com/tencent/mm/ipcinvoker/wx_extension/c:VQ	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
          //   79: invokevirtual 95	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:clearAll	()V
          //   82: invokestatic 37	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
          //   85: invokevirtual 43	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
          //   88: getstatic 49	com/tencent/mm/storage/ar$a:NYS	Lcom/tencent/mm/storage/ar$a;
          //   91: invokestatic 64	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
          //   94: invokestatic 100	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   97: invokevirtual 104	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
          //   100: ldc 25
          //   102: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   105: return
          //   106: iconst_0
          //   107: istore_1
          //   108: goto -54 -> 54
          //   111: astore 8
          //   113: ldc 79
          //   115: ldc 109
          //   117: iconst_1
          //   118: anewarray 4	java/lang/Object
          //   121: dup
          //   122: iconst_0
          //   123: aload 8
          //   125: aastore
          //   126: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   129: invokestatic 37	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
          //   132: invokevirtual 43	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
          //   135: getstatic 49	com/tencent/mm/storage/ar$a:NYS	Lcom/tencent/mm/storage/ar$a;
          //   138: invokestatic 64	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
          //   141: invokestatic 100	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   144: invokevirtual 104	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
          //   147: ldc 25
          //   149: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   152: return
          //   153: astore 8
          //   155: ldc 25
          //   157: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   160: return
          //   161: astore 8
          //   163: invokestatic 37	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
          //   166: invokevirtual 43	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
          //   169: getstatic 49	com/tencent/mm/storage/ar$a:NYS	Lcom/tencent/mm/storage/ar$a;
          //   172: invokestatic 64	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
          //   175: invokestatic 100	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   178: invokevirtual 104	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
          //   181: ldc 25
          //   183: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   186: aload 8
          //   188: athrow
          //   189: ldc 25
          //   191: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   194: return
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	195	0	this	2
          //   1	107	1	bool	boolean
          //   20	12	2	l1	long
          //   24	9	4	l2	long
          //   29	7	6	l3	long
          //   111	13	8	localThrowable1	java.lang.Throwable
          //   153	1	8	localThrowable2	java.lang.Throwable
          //   161	26	8	localObject	Object
          // Exception table:
          //   from	to	target	type
          //   41	54	111	java/lang/Throwable
          //   54	72	111	java/lang/Throwable
          //   76	82	111	java/lang/Throwable
          //   7	31	153	java/lang/Throwable
          //   82	105	153	java/lang/Throwable
          //   129	152	153	java/lang/Throwable
          //   163	189	153	java/lang/Throwable
          //   41	54	161	finally
          //   54	72	161	finally
          //   76	82	161	finally
          //   113	129	161	finally
        }
      });
    }
    AppMethodBeat.o(146423);
  }
  
  public void onAppForeground(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.PluginIPC
 * JD-Core Version:    0.7.0.1
 */