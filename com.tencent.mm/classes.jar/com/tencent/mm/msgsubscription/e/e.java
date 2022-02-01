package com.tencent.mm.msgsubscription.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.msgsubscription.a.b.a;
import com.tencent.mm.msgsubscription.a.b.c;
import com.tencent.mm.protocal.protobuf.fkc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/task/GetSubscribeStatusTask;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "username", "", "templateIds", "", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "templateIdList", "getType", "", "run", "", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a
{
  public static final e.a pkq;
  private com.tencent.mm.msgsubscription.d.a piQ;
  private com.tencent.mm.msgsubscription.api.a pkl;
  private List<String> pkr;
  
  static
  {
    AppMethodBeat.i(236415);
    pkq = new e.a((byte)0);
    AppMethodBeat.o(236415);
  }
  
  private e(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(236391);
    this.pkr = ((List)new ArrayList());
    AppMethodBeat.o(236391);
  }
  
  public e(String paramString, List<String> paramList, com.tencent.mm.msgsubscription.d.a parama, com.tencent.mm.msgsubscription.api.a parama1)
  {
    this(paramString);
    AppMethodBeat.i(236397);
    this.piQ = parama;
    this.pkl = parama1;
    this.pkr.addAll((Collection)paramList);
    AppMethodBeat.o(236397);
  }
  
  public final void run()
  {
    AppMethodBeat.i(236424);
    Object localObject1 = b.a.piO;
    localObject1 = this.hUQ;
    Object localObject2 = this.pkr;
    Object localObject3 = (b.c)new b(this);
    s.u(localObject1, "username");
    s.u(localObject2, "templateIds");
    b localb = new b((String)localObject1, 5);
    b.a(localb, (b.c)localObject3);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject4 = (String)((Iterator)localObject2).next();
      localObject3 = b.a(localb);
      fkc localfkc = new fkc();
      localfkc.YRs = ((String)localObject1);
      localfkc.aaQP = ((String)localObject4);
      localObject4 = ah.aiuX;
      ((List)localObject3).add(localfkc);
    }
    d(localb);
    AppMethodBeat.o(236424);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/task/GetSubscribeStatusTask$run$netScene$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements b.c
  {
    b(e parame) {}
    
    private static final void a(int paramInt1, int paramInt2, e parame, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, String paramString)
    {
      AppMethodBeat.i(236434);
      s.u(parame, "this$0");
      s.u(paramString, "$errMsg");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = e.a(parame);
        if (paramString != null)
        {
          parame = parame.hUQ;
          s.checkNotNull(paramSubscribeMsgRequestResult);
          paramString.a(parame, paramSubscribeMsgRequestResult);
          AppMethodBeat.o(236434);
        }
      }
      else
      {
        parame = e.a(parame);
        if (parame != null) {
          parame.j(paramInt1, paramInt2, paramString);
        }
      }
      AppMethodBeat.o(236434);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(236445);
      s.u(paramString, "errMsg");
      Log.i("MicroMsg.GetSubscribeMsgUIStatusTask", "alvinluo getSubscribeStatus end errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      MMHandlerThread.postToMainThread(new e.b..ExternalSyntheticLambda0(paramInt1, paramInt2, this.pks, paramSubscribeMsgRequestResult, paramString));
      AppMethodBeat.o(236445);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.e.e
 * JD-Core Version:    0.7.0.1
 */