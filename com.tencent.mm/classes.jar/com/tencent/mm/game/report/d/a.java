package com.tencent.mm.game.report.d;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.l;
import d.v;
import d.z;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/game/report/service/GameChatReportWrapper;", "", "()V", "CMD_UNREAD_MSG", "", "KEY_CMD", "", "KEY_HAS_UNREAD_MSG", "TAG", "curSeq", "", "isBusy", "", "waitingList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/game/report/protobuf/ChatReportRequest;", "report", "", "data", "Landroid/os/Bundle;", "reportInMainProcess", "request", "reportUnreadState", "hasUnreadMsg", "tryDoScene", "IpcChatReportTask", "report-api_release"})
public final class a
{
  private static final LinkedList<com.tencent.mm.game.report.c.a> guy;
  private static boolean guz;
  private static long gvD;
  public static final a gvE;
  
  static
  {
    AppMethodBeat.i(214288);
    gvE = new a();
    guy = new LinkedList();
    AppMethodBeat.o(214288);
  }
  
  /* Error */
  private final void a(com.tencent.mm.game.report.c.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 71
    //   4: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 77	com/tencent/mm/kernel/g:ajP	()Lcom/tencent/mm/kernel/a;
    //   10: invokevirtual 83	com/tencent/mm/kernel/a:aiZ	()Z
    //   13: ifeq +9 -> 22
    //   16: invokestatic 86	com/tencent/mm/kernel/a:aiT	()Z
    //   19: ifeq +18 -> 37
    //   22: ldc 88
    //   24: ldc 90
    //   26: invokestatic 96	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: ldc 71
    //   31: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: getstatic 64	com/tencent/mm/game/report/d/a:guy	Ljava/util/LinkedList;
    //   40: aload_1
    //   41: invokevirtual 100	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   44: pop
    //   45: aload_0
    //   46: invokespecial 103	com/tencent/mm/game/report/d/a:agS	()V
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
  
  private final void agS()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(214287);
        if (guz)
        {
          ae.i("MicroMsg.GameChatReport", "tryDoScene isBusy");
          AppMethodBeat.o(214287);
          return;
        }
        if (bu.ht((List)guy))
        {
          ae.i("MicroMsg.GameChatReport", "waitingList is null");
          AppMethodBeat.o(214287);
          continue;
        }
        localObject2 = (com.tencent.mm.game.report.c.a)guy.remove(0);
      }
      finally {}
      Object localObject2;
      if (localObject2 != null)
      {
        guz = true;
        b.a locala = new b.a();
        locala.DN("/cgi-bin/mmgame-bin/gamegamelifeappsvr/chatreport");
        locala.oS(4352);
        locala.oU(0);
        locala.oV(0);
        locala.c((com.tencent.mm.bw.a)localObject2);
        locala.d((com.tencent.mm.bw.a)new com.tencent.mm.game.report.c.b());
        if (x.a(locala.aDS(), (x.a)new b((com.tencent.mm.game.report.c.a)localObject2)) != null) {}
      }
      else
      {
        agS();
        localObject2 = z.Nhr;
      }
      AppMethodBeat.o(214287);
    }
  }
  
  public static void du(boolean paramBoolean)
  {
    AppMethodBeat.i(214284);
    Bundle localBundle = new Bundle();
    localBundle.putInt("cmd", 1);
    localBundle.putBoolean("has_unread_msg", paramBoolean);
    gvE.q(localBundle);
    AppMethodBeat.o(214284);
  }
  
  private final void q(Bundle paramBundle)
  {
    for (;;)
    {
      com.tencent.mm.game.report.c.a locala;
      try
      {
        AppMethodBeat.i(214285);
        if (paramBundle == null) {
          break label216;
        }
        if (!ak.coh()) {
          break label194;
        }
        locala = new com.tencent.mm.game.report.c.a();
        switch (paramBundle.getInt("cmd", 0))
        {
        case 1: 
          AppMethodBeat.o(214285);
          return;
        }
      }
      finally {}
      if (gvD == 0L)
      {
        localObject = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IKG, Long.valueOf(1000L));
        if (localObject == null)
        {
          paramBundle = new v("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(214285);
          throw paramBundle;
        }
        gvD = bu.i((Long)localObject);
      }
      Object localObject = new com.tencent.mm.game.report.c.g();
      long l = gvD + 1L;
      gvD = l;
      ((com.tencent.mm.game.report.c.g)localObject).seq = l;
      ((com.tencent.mm.game.report.c.g)localObject).gvB = q.aaK();
      ((com.tencent.mm.game.report.c.g)localObject).gvC = paramBundle.getBoolean("has_unread_msg", false);
      locala.gvn = ((com.tencent.mm.game.report.c.g)localObject);
      gvE.a(locala);
      AppMethodBeat.o(214285);
      continue;
      label194:
      h.a("com.tencent.mm", (Parcelable)paramBundle, a.class, null);
      AppMethodBeat.o(214285);
      continue;
      label216:
      AppMethodBeat.o(214285);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/game/report/service/GameChatReportWrapper$IpcChatReportTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "report-api_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class b
    implements x.a
  {
    b(com.tencent.mm.game.report.c.a parama) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb, n paramn)
    {
      AppMethodBeat.i(214283);
      ae.i("MicroMsg.GameChatReport", "tryDoScene, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.gvF.gvn;
        if (paramString != null)
        {
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKG, Long.valueOf(paramString.seq));
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKH, Boolean.valueOf(paramString.gvC));
        }
      }
      paramString = a.gvE;
      a.agT();
      a.a(a.gvE);
      AppMethodBeat.o(214283);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.game.report.d.a
 * JD-Core Version:    0.7.0.1
 */