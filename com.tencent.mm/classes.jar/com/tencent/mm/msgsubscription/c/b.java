package com.tencent.mm.msgsubscription.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.a.b.a.a;
import com.tencent.mm.msgsubscription.a.b.c;
import com.tencent.mm.msgsubscription.storage.d;
import com.tencent.mm.msgsubscription.storage.e.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/task/GetAllSubscribeMsgListTask;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "username", "", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "(Ljava/lang/String;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;)V", "(Ljava/lang/String;)V", "mCallback", "getType", "", "run", "", "updateTimestamp", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Companion", "plugin-comm_release"})
public final class b
  extends a
{
  public static final a iiJ;
  private e.b iiH;
  private d iiI;
  
  static
  {
    AppMethodBeat.i(149669);
    iiJ = new a((byte)0);
    AppMethodBeat.o(149669);
  }
  
  private b(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(149667);
    AppMethodBeat.o(149667);
  }
  
  public b(String paramString, d paramd, e.b paramb)
  {
    this(paramString);
    AppMethodBeat.i(149668);
    this.iiI = paramd;
    this.iiH = paramb;
    AppMethodBeat.o(149668);
  }
  
  public final void run()
  {
    AppMethodBeat.i(149666);
    ac.i("MicroMsg.GetAllSubscribeMsgListTask", "alvinluo getAllSubscribeStatus run");
    b.a.a locala = com.tencent.mm.msgsubscription.a.b.a.ihC;
    b(b.a.a.a(this.dqK, (b.c)new b(this)));
    AppMethodBeat.o(149666);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/task/GetAllSubscribeMsgListTask$Companion;", "", "()V", "TAG", "", "plugin-comm_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/msgsubscription/task/GetAllSubscribeMsgListTask$run$netScene$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class b
    implements b.c
  {
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149665);
      k.h(paramString, "errMsg");
      ac.i("MicroMsg.GetAllSubscribeMsgListTask", "alvinluo getSubscribeMsgListByUsername end errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (paramSubscribeMsgRequestResult == null) {
          break label142;
        }
      }
      label142:
      for (Object localObject = paramSubscribeMsgRequestResult.igI;; localObject = null)
      {
        if (localObject != null)
        {
          b.aA((List)paramSubscribeMsgRequestResult.igI);
          localObject = b.a(this.iiK);
          if (localObject != null) {
            ((d)localObject).a(this.iiK.dqK, (List)paramSubscribeMsgRequestResult.igI, paramSubscribeMsgRequestResult.igL);
          }
        }
        ap.f((Runnable)new a(this, paramInt1, paramInt2, paramSubscribeMsgRequestResult, paramString));
        AppMethodBeat.o(149665);
        return;
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(b.b paramb, int paramInt1, int paramInt2, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, String paramString) {}
      
      public final void run()
      {
        AppMethodBeat.i(149664);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localb = b.b(this.iiL.iiK);
          if (localb != null)
          {
            String str = this.iiL.iiK.dqK;
            SubscribeMsgRequestResult localSubscribeMsgRequestResult = paramSubscribeMsgRequestResult;
            if (localSubscribeMsgRequestResult == null) {
              k.fOy();
            }
            localb.a(str, localSubscribeMsgRequestResult);
            AppMethodBeat.o(149664);
            return;
          }
          AppMethodBeat.o(149664);
          return;
        }
        e.b localb = b.b(this.iiL.iiK);
        if (localb != null)
        {
          localb.i(paramInt1, paramInt2, paramString);
          AppMethodBeat.o(149664);
          return;
        }
        AppMethodBeat.o(149664);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.c.b
 * JD-Core Version:    0.7.0.1
 */