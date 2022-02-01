package com.tencent.mm.msgsubscription.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.a.b.a.a;
import com.tencent.mm.msgsubscription.a.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/task/GetAllSubscribeListTask;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "username", "", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "(Ljava/lang/String;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "(Ljava/lang/String;)V", "mCallback", "getType", "", "run", "", "updateTimestamp", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  public static final b.a pkk;
  private com.tencent.mm.msgsubscription.d.a piQ;
  private com.tencent.mm.msgsubscription.api.a pkl;
  
  static
  {
    AppMethodBeat.i(236416);
    pkk = new b.a((byte)0);
    AppMethodBeat.o(236416);
  }
  
  private b(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(236382);
    AppMethodBeat.o(236382);
  }
  
  public b(String paramString, com.tencent.mm.msgsubscription.d.a parama, com.tencent.mm.msgsubscription.api.a parama1)
  {
    this(paramString);
    AppMethodBeat.i(236390);
    this.piQ = parama;
    this.pkl = parama1;
    AppMethodBeat.o(236390);
  }
  
  public final void run()
  {
    AppMethodBeat.i(236422);
    Log.i("MicroMsg.GetAllSubscribeListTask", "alvinluo getAllSubscribeStatus run");
    b.a.a locala = com.tencent.mm.msgsubscription.a.b.a.piO;
    d(b.a.a.a(this.hUQ, (b.c)new b(this)));
    AppMethodBeat.o(236422);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/task/GetAllSubscribeListTask$run$netScene$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements b.c
  {
    b(b paramb) {}
    
    private static final void a(int paramInt1, int paramInt2, b paramb, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, String paramString)
    {
      AppMethodBeat.i(236449);
      s.u(paramb, "this$0");
      s.u(paramString, "$errMsg");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = b.b(paramb);
        if (paramString != null)
        {
          paramb = paramb.hUQ;
          s.checkNotNull(paramSubscribeMsgRequestResult);
          paramString.a(paramb, paramSubscribeMsgRequestResult);
          AppMethodBeat.o(236449);
        }
      }
      else
      {
        paramb = b.b(paramb);
        if (paramb != null) {
          paramb.j(paramInt1, paramInt2, paramString);
        }
      }
      AppMethodBeat.o(236449);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(236465);
      s.u(paramString, "errMsg");
      Log.i("MicroMsg.GetAllSubscribeListTask", "alvinluo getSubscribeMsgListByUsername end errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (paramSubscribeMsgRequestResult != null) {
          break label138;
        }
      }
      label138:
      for (Object localObject = null;; localObject = paramSubscribeMsgRequestResult.phC)
      {
        if (localObject != null)
        {
          b.cm((List)paramSubscribeMsgRequestResult.phC);
          localObject = b.a(this.pkm);
          if (localObject != null) {
            ((com.tencent.mm.msgsubscription.d.a)localObject).a(this.pkm.hUQ, (List)paramSubscribeMsgRequestResult.phC, paramSubscribeMsgRequestResult.phG);
          }
        }
        MMHandlerThread.postToMainThread(new b.b..ExternalSyntheticLambda0(paramInt1, paramInt2, this.pkm, paramSubscribeMsgRequestResult, paramString));
        AppMethodBeat.o(236465);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.e.b
 * JD-Core Version:    0.7.0.1
 */