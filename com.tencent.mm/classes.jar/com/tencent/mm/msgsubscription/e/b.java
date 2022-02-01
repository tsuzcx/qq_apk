package com.tencent.mm.msgsubscription.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.a.b.a.a;
import com.tencent.mm.msgsubscription.a.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/task/GetAllSubscribeListTask;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "username", "", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "(Ljava/lang/String;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "(Ljava/lang/String;)V", "mCallback", "getType", "", "run", "", "updateTimestamp", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Companion", "plugin-comm_release"})
public final class b
  extends a
{
  public static final b.a jAY;
  private com.tencent.mm.msgsubscription.api.a jAX;
  private com.tencent.mm.msgsubscription.d.a jzv;
  
  static
  {
    AppMethodBeat.i(223375);
    jAY = new b.a((byte)0);
    AppMethodBeat.o(223375);
  }
  
  private b(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(223373);
    AppMethodBeat.o(223373);
  }
  
  public b(String paramString, com.tencent.mm.msgsubscription.d.a parama, com.tencent.mm.msgsubscription.api.a parama1)
  {
    this(paramString);
    AppMethodBeat.i(223374);
    this.jzv = parama;
    this.jAX = parama1;
    AppMethodBeat.o(223374);
  }
  
  public final void run()
  {
    AppMethodBeat.i(223372);
    Log.i("MicroMsg.GetAllSubscribeListTask", "alvinluo getAllSubscribeStatus run");
    b.a.a locala = com.tencent.mm.msgsubscription.a.b.a.jzu;
    d(b.a.a.a(this.dVu, (b.c)new b(this)));
    AppMethodBeat.o(223372);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/task/GetAllSubscribeListTask$run$netScene$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class b
    implements b.c
  {
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(223371);
      p.h(paramString, "errMsg");
      Log.i("MicroMsg.GetAllSubscribeListTask", "alvinluo getSubscribeMsgListByUsername end errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (paramSubscribeMsgRequestResult == null) {
          break label142;
        }
      }
      label142:
      for (Object localObject = paramSubscribeMsgRequestResult.jyk;; localObject = null)
      {
        if (localObject != null)
        {
          b.aJ((List)paramSubscribeMsgRequestResult.jyk);
          localObject = b.a(this.jAZ);
          if (localObject != null) {
            ((com.tencent.mm.msgsubscription.d.a)localObject).a(this.jAZ.dVu, (List)paramSubscribeMsgRequestResult.jyk, paramSubscribeMsgRequestResult.jyo);
          }
        }
        MMHandlerThread.postToMainThread((Runnable)new a(this, paramInt1, paramInt2, paramSubscribeMsgRequestResult, paramString));
        AppMethodBeat.o(223371);
        return;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(b.b paramb, int paramInt1, int paramInt2, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, String paramString) {}
      
      public final void run()
      {
        AppMethodBeat.i(223370);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          locala = b.b(this.jBa.jAZ);
          if (locala != null)
          {
            String str = this.jBa.jAZ.dVu;
            SubscribeMsgRequestResult localSubscribeMsgRequestResult = paramSubscribeMsgRequestResult;
            if (localSubscribeMsgRequestResult == null) {
              p.hyc();
            }
            locala.a(str, localSubscribeMsgRequestResult);
            AppMethodBeat.o(223370);
            return;
          }
          AppMethodBeat.o(223370);
          return;
        }
        com.tencent.mm.msgsubscription.api.a locala = b.b(this.jBa.jAZ);
        if (locala != null)
        {
          locala.i(paramInt1, paramInt2, paramString);
          AppMethodBeat.o(223370);
          return;
        }
        AppMethodBeat.o(223370);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.e.b
 * JD-Core Version:    0.7.0.1
 */