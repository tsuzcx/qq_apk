package com.tencent.mm.msgsubscription.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.msgsubscription.a.b.c;
import com.tencent.mm.msgsubscription.d.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "Lcom/tencent/mm/msgsubscription/task/ISubscribeMsgTask;", "bizUsername", "", "(Ljava/lang/String;)V", "async", "", "getAsync", "()Z", "setAsync", "(Z)V", "getBizUsername", "()Ljava/lang/String;", "setBizUsername", "cancelled", "getCancelled", "setCancelled", "replaced", "getReplaced", "setReplaced", "cancel", "", "getKey", "isAsync", "isCanReplacedByKey", "isCancelled", "runNetScene", "netScene", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements f
{
  public boolean cancelled;
  String hUQ;
  public boolean piC;
  public boolean piD;
  
  public a(String paramString)
  {
    this.hUQ = paramString;
  }
  
  public void cancel()
  {
    this.cancelled = true;
  }
  
  public final void d(b paramb)
  {
    s.u(paramb, "netScene");
    paramb.piJ = ((b.c)new a(this, paramb.piJ));
    paramb.a((com.tencent.mm.msgsubscription.util.a.a)com.tencent.mm.msgsubscription.a.a.piE);
  }
  
  public String getKey()
  {
    return String.valueOf(hashCode());
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask$runNetScene$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements b.c
  {
    a(a parama, b.c paramc) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149663);
      s.u(paramString, "errMsg");
      Object localObject = d.pkg;
      d.a(this.pki);
      localObject = this.pkj;
      if (localObject != null) {
        ((b.c)localObject).a(paramInt1, paramInt2, paramString, paramSubscribeMsgRequestResult);
      }
      AppMethodBeat.o(149663);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.e.a
 * JD-Core Version:    0.7.0.1
 */