package com.tencent.mm.msgsubscription.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.msgsubscription.a.b.c;
import com.tencent.mm.msgsubscription.storage.g;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "Lcom/tencent/mm/msgsubscription/task/ISubscribeMsgTask;", "bizUsername", "", "(Ljava/lang/String;)V", "async", "", "getAsync", "()Z", "setAsync", "(Z)V", "getBizUsername", "()Ljava/lang/String;", "cancelled", "getCancelled", "setCancelled", "replaced", "getReplaced", "setReplaced", "cancel", "", "getKey", "isAsync", "isCanReplacedByKey", "isCancelled", "runNetScene", "netScene", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "plugin-comm_release"})
public abstract class a
  implements e
{
  public boolean cancelled;
  final String dqK;
  public boolean iiD;
  public boolean iiE;
  
  public a(String paramString)
  {
    this.dqK = paramString;
  }
  
  public final void b(b paramb)
  {
    k.h(paramb, "netScene");
    paramb.ihx = ((b.c)new a(this, paramb.ihx));
    paramb.a((com.tencent.mm.msgsubscription.util.a.a)com.tencent.mm.msgsubscription.a.a.ihr);
  }
  
  public void cancel()
  {
    this.cancelled = true;
  }
  
  public String getKey()
  {
    return String.valueOf(hashCode());
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask$runNetScene$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class a
    implements b.c
  {
    a(b.c paramc) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149663);
      k.h(paramString, "errMsg");
      Object localObject = g.iiz;
      g.a(this.iiF);
      localObject = this.iiG;
      if (localObject != null)
      {
        ((b.c)localObject).a(paramInt1, paramInt2, paramString, paramSubscribeMsgRequestResult);
        AppMethodBeat.o(149663);
        return;
      }
      AppMethodBeat.o(149663);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.c.a
 * JD-Core Version:    0.7.0.1
 */