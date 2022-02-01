package com.tencent.mm.game.report.d;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/game/report/service/GameChatReportWrapper;", "", "()V", "CMD_UNREAD_MSG", "", "KEY_CMD", "", "KEY_HAS_UNREAD_MSG", "TAG", "curSeq", "", "isBusy", "", "waitingList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/game/report/protobuf/ChatReportRequest;", "report", "", "data", "Landroid/os/Bundle;", "reportInMainProcess", "request", "reportUnreadState", "hasUnreadMsg", "tryDoScene", "IpcChatReportTask", "report-api_release"})
public final class a
{
  private static final LinkedList<com.tencent.mm.game.report.c.a> hhn;
  private static boolean hho;
  private static long his;
  public static final a hit;
  
  static
  {
    AppMethodBeat.i(190344);
    hit = new a();
    hhn = new LinkedList();
    AppMethodBeat.o(190344);
  }
  
  /* Error */
  private final void a(com.tencent.mm.game.report.c.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 71
    //   4: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 77	com/tencent/mm/kernel/g:aAf	()Lcom/tencent/mm/kernel/a;
    //   10: invokevirtual 83	com/tencent/mm/kernel/a:azp	()Z
    //   13: ifeq +9 -> 22
    //   16: invokestatic 86	com/tencent/mm/kernel/a:azj	()Z
    //   19: ifeq +18 -> 37
    //   22: ldc 88
    //   24: ldc 90
    //   26: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: ldc 71
    //   31: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: getstatic 64	com/tencent/mm/game/report/d/a:hhn	Ljava/util/LinkedList;
    //   40: aload_1
    //   41: invokevirtual 100	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   44: pop
    //   45: aload_0
    //   46: invokespecial 103	com/tencent/mm/game/report/d/a:axe	()V
    //   49: ldc 71
    //   51: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: goto -20 -> 34
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	a
    //   0	62	1	parama	com.tencent.mm.game.report.c.a
    // Exception table:
    //   from	to	target	type
    //   2	22	57	finally
    //   22	34	57	finally
    //   37	54	57	finally
  }
  
  private final void axe()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(190343);
        if (hho)
        {
          Log.i("MicroMsg.GameChatReport", "tryDoScene isBusy");
          AppMethodBeat.o(190343);
          return;
        }
        if (Util.isNullOrNil((List)hhn))
        {
          Log.i("MicroMsg.GameChatReport", "waitingList is null");
          AppMethodBeat.o(190343);
          continue;
        }
        localObject2 = (com.tencent.mm.game.report.c.a)hhn.remove(0);
      }
      finally {}
      Object localObject2;
      if (localObject2 != null)
      {
        hho = true;
        d.a locala = new d.a();
        locala.MB("/cgi-bin/mmgame-bin/gamegamelifeappsvr/chatreport");
        locala.sG(4352);
        locala.sI(0);
        locala.sJ(0);
        locala.c((com.tencent.mm.bw.a)localObject2);
        locala.d((com.tencent.mm.bw.a)new com.tencent.mm.game.report.c.b());
        if (aa.a(locala.aXF(), (aa.a)new b((com.tencent.mm.game.report.c.a)localObject2)) != null) {}
      }
      else
      {
        axe();
        localObject2 = x.SXb;
      }
      AppMethodBeat.o(190343);
    }
  }
  
  public static void ek(boolean paramBoolean)
  {
    AppMethodBeat.i(190340);
    Bundle localBundle = new Bundle();
    localBundle.putInt("cmd", 1);
    localBundle.putBoolean("has_unread_msg", paramBoolean);
    hit.u(localBundle);
    AppMethodBeat.o(190340);
  }
  
  private final void u(Bundle paramBundle)
  {
    for (;;)
    {
      com.tencent.mm.game.report.c.a locala;
      try
      {
        AppMethodBeat.i(190341);
        if (paramBundle == null) {
          break label216;
        }
        if (!MMApplicationContext.isMainProcess()) {
          break label194;
        }
        locala = new com.tencent.mm.game.report.c.a();
        switch (paramBundle.getInt("cmd", 0))
        {
        case 1: 
          AppMethodBeat.o(190341);
          return;
        }
      }
      finally {}
      if (his == 0L)
      {
        localObject = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NSE, Long.valueOf(1000L));
        if (localObject == null)
        {
          paramBundle = new t("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(190341);
          throw paramBundle;
        }
        his = Util.nullAsNil((Long)localObject);
      }
      Object localObject = new com.tencent.mm.game.report.c.g();
      long l = his + 1L;
      his = l;
      ((com.tencent.mm.game.report.c.g)localObject).seq = l;
      ((com.tencent.mm.game.report.c.g)localObject).hiq = com.tencent.mm.compatible.deviceinfo.q.aoJ();
      ((com.tencent.mm.game.report.c.g)localObject).hir = paramBundle.getBoolean("has_unread_msg", false);
      locala.hic = ((com.tencent.mm.game.report.c.g)localObject);
      hit.a(locala);
      AppMethodBeat.o(190341);
      continue;
      label194:
      h.a(MainProcessIPCService.dkO, (Parcelable)paramBundle, a.class, null);
      AppMethodBeat.o(190341);
      continue;
      label216:
      AppMethodBeat.o(190341);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/game/report/service/GameChatReportWrapper$IpcChatReportTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "report-api_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class b
    implements aa.a
  {
    b(com.tencent.mm.game.report.c.a parama) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, d paramd, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(190339);
      Log.i("MicroMsg.GameChatReport", "tryDoScene, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.hiu.hic;
        if (paramString != null)
        {
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSE, Long.valueOf(paramString.seq));
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSF, Boolean.valueOf(paramString.hir));
        }
      }
      paramString = a.hit;
      a.axf();
      a.a(a.hit);
      AppMethodBeat.o(190339);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.game.report.d.a
 * JD-Core Version:    0.7.0.1
 */