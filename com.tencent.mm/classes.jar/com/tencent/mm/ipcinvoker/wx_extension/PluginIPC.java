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
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.io.File;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public class PluginIPC
  extends f
  implements com.tencent.mm.app.o, b
{
  private static final long gAV;
  
  static
  {
    AppMethodBeat.i(146424);
    gAV = TimeUnit.DAYS.toMillis(1L);
    AppMethodBeat.o(146424);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(146422);
    ae.i("MicroMsg.PluginIPC", "execute(%s)", new Object[] { paramg.mProcessName });
    if (ak.coh())
    {
      int i = 0;
      for (;;)
      {
        if (i <= 0)
        {
          paramg = new String[] { "MicroMsg.XIPC.MMProtoBufTransfer" }[i];
          try
          {
            k localk = new k(ak.getContext().getFilesDir().getAbsolutePath() + "/mmkv/" + paramg);
            if (localk.exists())
            {
              localk.delete();
              com.tencent.mm.vfs.o.deleteFile(w.B(localk.fTh()) + ".crc");
            }
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ae.e("MicroMsg.PluginIPC", "delete MMProtoBufTransfer dirty file[%s] e = %s", new Object[] { paramg, localException });
            }
          }
        }
      }
    }
    paramg = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).ca;
    com.tencent.mm.ipcinvoker.a.a local1 = new com.tencent.mm.ipcinvoker.a.a()
    {
      public final void a(com.tencent.mm.ipcinvoker.a.d paramAnonymousd)
      {
        AppMethodBeat.i(146416);
        super.a(paramAnonymousd);
        paramAnonymousd.a(PluginIPC.a.gAO);
        AppMethodBeat.o(146416);
      }
      
      public final void a(e paramAnonymouse)
      {
        AppMethodBeat.i(146417);
        super.a(paramAnonymouse);
        ay.init();
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
    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokerBoot", "setup IPCInvoker(process : %s, application : %s)", new Object[] { com.tencent.mm.ipcinvoker.g.ahM(), Integer.valueOf(paramg.hashCode()) });
    if ((ak.foC()) || (ak.foD())) {
      com.tencent.mm.ipcinvoker.i.xe("com.tencent.mm");
    }
    AppMethodBeat.o(146422);
  }
  
  public void onAppBackground(String paramString)
  {
    AppMethodBeat.i(146423);
    if (ak.coh()) {
      com.tencent.e.h.MqF.aO(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: iconst_1
          //   1: istore_1
          //   2: ldc 25
          //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   7: invokestatic 37	com/tencent/mm/kernel/g:ajR	()Lcom/tencent/mm/kernel/e;
          //   10: invokevirtual 43	com/tencent/mm/kernel/e:ajA	()Lcom/tencent/mm/storage/aj;
          //   13: getstatic 49	com/tencent/mm/storage/am$a:IQQ	Lcom/tencent/mm/storage/am$a;
          //   16: lconst_0
          //   17: invokevirtual 55	com/tencent/mm/storage/aj:a	(Lcom/tencent/mm/storage/am$a;J)J
          //   20: lstore_2
          //   21: invokestatic 59	com/tencent/mm/ipcinvoker/wx_extension/PluginIPC:access$000	()J
          //   24: lstore 4
          //   26: invokestatic 64	com/tencent/mm/sdk/platformtools/bu:fpO	()J
          //   29: lstore 6
          //   31: lload_2
          //   32: lload 4
          //   34: ladd
          //   35: lload 6
          //   37: lcmp
          //   38: ifgt +154 -> 192
          //   41: invokestatic 70	com/tencent/mm/ipcinvoker/wx_extension/c:LD	()Lcom/tencent/mm/sdk/platformtools/ay;
          //   44: getfield 76	com/tencent/mm/sdk/platformtools/ay:IyS	Lcom/tencent/mmkv/MMKV;
          //   47: invokevirtual 81	com/tencent/mmkv/MMKV:totalSize	()J
          //   50: ldc2_w 82
          //   53: lcmp
          //   54: iflt +55 -> 109
          //   57: ldc 85
          //   59: ldc 87
          //   61: iconst_1
          //   62: anewarray 4	java/lang/Object
          //   65: dup
          //   66: iconst_0
          //   67: iload_1
          //   68: invokestatic 93	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   71: aastore
          //   72: invokestatic 98	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   75: iload_1
          //   76: ifeq +9 -> 85
          //   79: invokestatic 70	com/tencent/mm/ipcinvoker/wx_extension/c:LD	()Lcom/tencent/mm/sdk/platformtools/ay;
          //   82: invokevirtual 101	com/tencent/mm/sdk/platformtools/ay:clearAll	()V
          //   85: invokestatic 37	com/tencent/mm/kernel/g:ajR	()Lcom/tencent/mm/kernel/e;
          //   88: invokevirtual 43	com/tencent/mm/kernel/e:ajA	()Lcom/tencent/mm/storage/aj;
          //   91: getstatic 49	com/tencent/mm/storage/am$a:IQQ	Lcom/tencent/mm/storage/am$a;
          //   94: invokestatic 64	com/tencent/mm/sdk/platformtools/bu:fpO	()J
          //   97: invokestatic 106	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   100: invokevirtual 110	com/tencent/mm/storage/aj:set	(Lcom/tencent/mm/storage/am$a;Ljava/lang/Object;)V
          //   103: ldc 25
          //   105: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   108: return
          //   109: iconst_0
          //   110: istore_1
          //   111: goto -54 -> 57
          //   114: astore 8
          //   116: ldc 85
          //   118: ldc 115
          //   120: iconst_1
          //   121: anewarray 4	java/lang/Object
          //   124: dup
          //   125: iconst_0
          //   126: aload 8
          //   128: aastore
          //   129: invokestatic 118	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   132: invokestatic 37	com/tencent/mm/kernel/g:ajR	()Lcom/tencent/mm/kernel/e;
          //   135: invokevirtual 43	com/tencent/mm/kernel/e:ajA	()Lcom/tencent/mm/storage/aj;
          //   138: getstatic 49	com/tencent/mm/storage/am$a:IQQ	Lcom/tencent/mm/storage/am$a;
          //   141: invokestatic 64	com/tencent/mm/sdk/platformtools/bu:fpO	()J
          //   144: invokestatic 106	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   147: invokevirtual 110	com/tencent/mm/storage/aj:set	(Lcom/tencent/mm/storage/am$a;Ljava/lang/Object;)V
          //   150: ldc 25
          //   152: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   155: return
          //   156: astore 8
          //   158: ldc 25
          //   160: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   163: return
          //   164: astore 8
          //   166: invokestatic 37	com/tencent/mm/kernel/g:ajR	()Lcom/tencent/mm/kernel/e;
          //   169: invokevirtual 43	com/tencent/mm/kernel/e:ajA	()Lcom/tencent/mm/storage/aj;
          //   172: getstatic 49	com/tencent/mm/storage/am$a:IQQ	Lcom/tencent/mm/storage/am$a;
          //   175: invokestatic 64	com/tencent/mm/sdk/platformtools/bu:fpO	()J
          //   178: invokestatic 106	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   181: invokevirtual 110	com/tencent/mm/storage/aj:set	(Lcom/tencent/mm/storage/am$a;Ljava/lang/Object;)V
          //   184: ldc 25
          //   186: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   189: aload 8
          //   191: athrow
          //   192: ldc 25
          //   194: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   197: return
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	198	0	this	2
          //   1	110	1	bool	boolean
          //   20	12	2	l1	long
          //   24	9	4	l2	long
          //   29	7	6	l3	long
          //   114	13	8	localThrowable1	java.lang.Throwable
          //   156	1	8	localThrowable2	java.lang.Throwable
          //   164	26	8	localObject	Object
          // Exception table:
          //   from	to	target	type
          //   41	57	114	java/lang/Throwable
          //   57	75	114	java/lang/Throwable
          //   79	85	114	java/lang/Throwable
          //   7	31	156	java/lang/Throwable
          //   85	108	156	java/lang/Throwable
          //   132	155	156	java/lang/Throwable
          //   166	192	156	java/lang/Throwable
          //   41	57	164	finally
          //   57	75	164	finally
          //   79	85	164	finally
          //   116	132	164	finally
        }
      });
    }
    AppMethodBeat.o(146423);
  }
  
  public void onAppForeground(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.PluginIPC
 * JD-Core Version:    0.7.0.1
 */