package com.tencent.mm.game.report.d;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.game.report.c.b;
import com.tencent.mm.game.report.c.g;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/game/report/service/GameChatReportWrapper;", "", "()V", "CMD_UNREAD_MSG", "", "KEY_CMD", "", "KEY_HAS_UNREAD_MSG", "TAG", "curSeq", "", "isBusy", "", "waitingList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/game/report/protobuf/ChatReportRequest;", "report", "", "data", "Landroid/os/Bundle;", "reportInMainProcess", "request", "reportUnreadState", "hasUnreadMsg", "tryDoScene", "IpcChatReportTask", "report-api_release"})
public final class a
{
  private static final LinkedList<com.tencent.mm.game.report.c.a> jTl;
  private static boolean jTm;
  private static long jUq;
  public static final a jUr;
  
  static
  {
    AppMethodBeat.i(198976);
    jUr = new a();
    jTl = new LinkedList();
    AppMethodBeat.o(198976);
  }
  
  private final void B(Bundle paramBundle)
  {
    for (;;)
    {
      com.tencent.mm.game.report.c.a locala;
      try
      {
        AppMethodBeat.i(198965);
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
          AppMethodBeat.o(198965);
          return;
        }
      }
      finally {}
      if (jUq == 0L)
      {
        localObject = h.aHG().aHp().get(ar.a.VgC, Long.valueOf(1000L));
        if (localObject == null)
        {
          paramBundle = new t("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(198965);
          throw paramBundle;
        }
        jUq = Util.nullAsNil((Long)localObject);
      }
      Object localObject = new g();
      long l = jUq + 1L;
      jUq = l;
      ((g)localObject).seq = l;
      ((g)localObject).jUo = com.tencent.mm.compatible.deviceinfo.q.auP();
      ((g)localObject).jUp = paramBundle.getBoolean("has_unread_msg", false);
      locala.jUa = ((g)localObject);
      jUr.a(locala);
      AppMethodBeat.o(198965);
      continue;
      label194:
      j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramBundle, a.class, null);
      AppMethodBeat.o(198965);
      continue;
      label216:
      AppMethodBeat.o(198965);
    }
  }
  
  /* Error */
  private final void a(com.tencent.mm.game.report.c.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 181
    //   4: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 185	com/tencent/mm/kernel/h:aHE	()Lcom/tencent/mm/kernel/b;
    //   10: invokevirtual 190	com/tencent/mm/kernel/b:aGM	()Z
    //   13: ifeq +9 -> 22
    //   16: invokestatic 193	com/tencent/mm/kernel/b:aGE	()Z
    //   19: ifeq +18 -> 37
    //   22: ldc 195
    //   24: ldc 197
    //   26: invokestatic 203	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: ldc 181
    //   31: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: getstatic 64	com/tencent/mm/game/report/d/a:jTl	Ljava/util/LinkedList;
    //   40: aload_1
    //   41: invokevirtual 207	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   44: pop
    //   45: aload_0
    //   46: invokespecial 210	com/tencent/mm/game/report/d/a:aEB	()V
    //   49: ldc 181
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
  
  private final void aEB()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(198972);
        if (jTm)
        {
          Log.i("MicroMsg.GameChatReport", "tryDoScene isBusy");
          AppMethodBeat.o(198972);
          return;
        }
        if (Util.isNullOrNil((List)jTl))
        {
          Log.i("MicroMsg.GameChatReport", "waitingList is null");
          AppMethodBeat.o(198972);
          continue;
        }
        localObject2 = (com.tencent.mm.game.report.c.a)jTl.remove(0);
      }
      finally {}
      Object localObject2;
      if (localObject2 != null)
      {
        jTm = true;
        d.a locala = new d.a();
        locala.TW("/cgi-bin/mmgame-bin/gamegamelifeappsvr/chatreport");
        locala.vD(4352);
        locala.vF(0);
        locala.vG(0);
        locala.c((com.tencent.mm.cd.a)localObject2);
        locala.d((com.tencent.mm.cd.a)new b());
        if (aa.a(locala.bgN(), (aa.a)new b((com.tencent.mm.game.report.c.a)localObject2)) != null) {}
      }
      else
      {
        aEB();
        localObject2 = x.aazN;
      }
      AppMethodBeat.o(198972);
    }
  }
  
  public static void eI(boolean paramBoolean)
  {
    AppMethodBeat.i(198959);
    Bundle localBundle = new Bundle();
    localBundle.putInt("cmd", 1);
    localBundle.putBoolean("has_unread_msg", paramBoolean);
    jUr.B(localBundle);
    AppMethodBeat.o(198959);
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/game/report/service/GameChatReportWrapper$IpcChatReportTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "report-api_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class b
    implements aa.a
  {
    b(com.tencent.mm.game.report.c.a parama) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(198990);
      Log.i("MicroMsg.GameChatReport", "tryDoScene, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.jUs.jUa;
        if (paramString != null)
        {
          h.aHG().aHp().set(ar.a.VgC, Long.valueOf(paramString.seq));
          h.aHG().aHp().set(ar.a.VgD, Boolean.valueOf(paramString.jUp));
        }
      }
      paramString = a.jUr;
      a.aEC();
      a.a(a.jUr);
      AppMethodBeat.o(198990);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.game.report.d.a
 * JD-Core Version:    0.7.0.1
 */