package com.tencent.mm.msgsubscription.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.msgsubscription.a.b.a;
import com.tencent.mm.msgsubscription.a.b.c;
import com.tencent.mm.msgsubscription.storage.d;
import com.tencent.mm.msgsubscription.storage.e.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/task/GetSubscribeMsgListForDialogTask;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "username", "", "subscribeUrl", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "getType", "", "run", "", "Companion", "plugin-comm_release"})
public final class c
  extends a
{
  public static final a iFa;
  private String iDL;
  private e.b iEU;
  private d iEV;
  
  static
  {
    AppMethodBeat.i(149676);
    iFa = new a((byte)0);
    AppMethodBeat.o(149676);
  }
  
  private c(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(149674);
    this.iDL = "";
    AppMethodBeat.o(149674);
  }
  
  public c(String paramString1, String paramString2, d paramd, e.b paramb)
  {
    this(paramString1);
    AppMethodBeat.i(149675);
    this.iEV = paramd;
    this.iEU = paramb;
    this.iDL = paramString2;
    AppMethodBeat.o(149675);
  }
  
  public final void run()
  {
    AppMethodBeat.i(149673);
    Object localObject1 = b.a.iDP;
    Object localObject2 = this.dDG;
    localObject1 = this.iDL;
    b.c localc = (b.c)new b(this);
    p.h(localObject2, "username");
    p.h(localObject1, "subscribeUrl");
    localObject2 = new b((String)localObject2, 2);
    b.a((b)localObject2, localc);
    b.a((b)localObject2, (String)localObject1);
    b((b)localObject2);
    AppMethodBeat.o(149673);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/task/GetSubscribeMsgListForDialogTask$Companion;", "", "()V", "TAG", "", "plugin-comm_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/msgsubscription/task/GetSubscribeMsgListForDialogTask$run$netScene$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class b
    implements b.c
  {
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149672);
      p.h(paramString, "errMsg");
      ae.i("MicroMsg.GetSubscribeMsgListForDialogTask", "alvinluo getSubscribeMsgListByUrl end errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      ar.f((Runnable)new a(this, paramInt1, paramInt2, paramSubscribeMsgRequestResult, paramString));
      AppMethodBeat.o(149672);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(c.b paramb, int paramInt1, int paramInt2, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, String paramString) {}
      
      public final void run()
      {
        AppMethodBeat.i(149671);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localb = c.a(this.iFc.iFb);
          if (localb != null)
          {
            String str = this.iFc.iFb.dDG;
            SubscribeMsgRequestResult localSubscribeMsgRequestResult = paramSubscribeMsgRequestResult;
            if (localSubscribeMsgRequestResult == null) {
              p.gkB();
            }
            localb.a(str, localSubscribeMsgRequestResult);
            AppMethodBeat.o(149671);
            return;
          }
          AppMethodBeat.o(149671);
          return;
        }
        e.b localb = c.a(this.iFc.iFb);
        if (localb != null)
        {
          localb.i(paramInt1, paramInt2, paramString);
          AppMethodBeat.o(149671);
          return;
        }
        AppMethodBeat.o(149671);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.c.c
 * JD-Core Version:    0.7.0.1
 */