package com.tencent.mm.game.report.d;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.game.report.c.b;
import com.tencent.mm.game.report.c.g;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/game/report/service/GameChatReportWrapper;", "", "()V", "CMD_UNREAD_MSG", "", "KEY_CMD", "", "KEY_HAS_UNREAD_MSG", "TAG", "curSeq", "", "isBusy", "", "waitingList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/game/report/protobuf/ChatReportRequest;", "report", "", "data", "Landroid/os/Bundle;", "reportInMainProcess", "request", "reportUnreadState", "hasUnreadMsg", "tryDoScene", "IpcChatReportTask", "report-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final LinkedList<com.tencent.mm.game.report.c.a> mtD;
  private static boolean mtE;
  public static final a muI;
  private static long muJ;
  
  static
  {
    AppMethodBeat.i(240803);
    muI = new a();
    mtD = new LinkedList();
    AppMethodBeat.o(240803);
  }
  
  private final void I(Bundle paramBundle)
  {
    com.tencent.mm.game.report.c.a locala;
    try
    {
      AppMethodBeat.i(240773);
      if (paramBundle == null) {
        break label199;
      }
      if (!MMApplicationContext.isMainProcess()) {
        break label185;
      }
      locala = new com.tencent.mm.game.report.c.a();
      if (paramBundle.getInt("cmd", 0) != 1) {
        break label177;
      }
      if (muJ != 0L) {
        break label109;
      }
      localObject = h.baE().ban().get(at.a.acHR, Long.valueOf(1000L));
      if (localObject == null)
      {
        paramBundle = new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        AppMethodBeat.o(240773);
        throw paramBundle;
      }
    }
    finally {}
    muJ = Util.nullAsNil(Long.valueOf(((Long)localObject).longValue()));
    label109:
    Object localObject = new g();
    long l = muJ + 1L;
    muJ = l;
    ((g)localObject).seq = l;
    ((g)localObject).muG = q.aPj();
    ((g)localObject).muH = paramBundle.getBoolean("has_unread_msg", false);
    locala.mus = ((g)localObject);
    muI.a(locala);
    AppMethodBeat.o(240773);
    for (;;)
    {
      return;
      label177:
      AppMethodBeat.o(240773);
      continue;
      label185:
      j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramBundle, a.class, null);
      label199:
      AppMethodBeat.o(240773);
    }
  }
  
  private static final int a(com.tencent.mm.game.report.c.a parama, int paramInt1, int paramInt2, String paramString, c paramc, p paramp)
  {
    AppMethodBeat.i(240792);
    s.u(parama, "$this_run");
    Log.i("MicroMsg.GameChatReport", "tryDoScene, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      parama = parama.mus;
      if (parama != null)
      {
        h.baE().ban().set(at.a.acHR, Long.valueOf(parama.seq));
        h.baE().ban().set(at.a.acHS, Boolean.valueOf(parama.muH));
      }
    }
    mtE = false;
    muI.aXF();
    AppMethodBeat.o(240792);
    return 0;
  }
  
  /* Error */
  private final void a(com.tencent.mm.game.report.c.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 231
    //   4: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 235	com/tencent/mm/kernel/h:baC	()Lcom/tencent/mm/kernel/b;
    //   10: invokevirtual 240	com/tencent/mm/kernel/b:aZN	()Z
    //   13: ifeq +9 -> 22
    //   16: invokestatic 243	com/tencent/mm/kernel/b:aZG	()Z
    //   19: ifeq +18 -> 37
    //   22: ldc 201
    //   24: ldc 245
    //   26: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: ldc 231
    //   31: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: getstatic 74	com/tencent/mm/game/report/d/a:mtD	Ljava/util/LinkedList;
    //   40: aload_1
    //   41: invokevirtual 253	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   44: pop
    //   45: aload_0
    //   46: invokespecial 230	com/tencent/mm/game/report/d/a:aXF	()V
    //   49: ldc 231
    //   51: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private final void aXF()
  {
    try
    {
      AppMethodBeat.i(240786);
      if (mtE)
      {
        Log.i("MicroMsg.GameChatReport", "tryDoScene isBusy");
        AppMethodBeat.o(240786);
      }
      for (;;)
      {
        return;
        if (!Util.isNullOrNil((List)mtD)) {
          break;
        }
        Log.i("MicroMsg.GameChatReport", "waitingList is null");
        AppMethodBeat.o(240786);
      }
      localObject2 = (com.tencent.mm.game.report.c.a)mtD.remove(0);
    }
    finally {}
    if (localObject2 == null) {}
    c.a locala;
    for (Object localObject2 = null;; localObject2 = z.a(locala.bEF(), new a..ExternalSyntheticLambda0((com.tencent.mm.game.report.c.a)localObject2)))
    {
      if (localObject2 == null) {
        aXF();
      }
      AppMethodBeat.o(240786);
      break;
      mtE = true;
      locala = new c.a();
      locala.uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/chatreport";
      locala.funcId = 4352;
      locala.otG = 0;
      locala.respCmdId = 0;
      locala.otE = ((com.tencent.mm.bx.a)localObject2);
      locala.otF = ((com.tencent.mm.bx.a)new b());
    }
  }
  
  public static void fs(boolean paramBoolean)
  {
    AppMethodBeat.i(240765);
    Bundle localBundle = new Bundle();
    localBundle.putInt("cmd", 1);
    localBundle.putBoolean("has_unread_msg", paramBoolean);
    muI.I(localBundle);
    AppMethodBeat.o(240765);
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/game/report/service/GameChatReportWrapper$IpcChatReportTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "report-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.game.report.d.a
 * JD-Core Version:    0.7.0.1
 */