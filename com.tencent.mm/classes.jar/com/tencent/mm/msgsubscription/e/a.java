package com.tencent.mm.msgsubscription.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.msgsubscription.a.b.c;
import com.tencent.mm.msgsubscription.d.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "Lcom/tencent/mm/msgsubscription/task/ISubscribeMsgTask;", "bizUsername", "", "(Ljava/lang/String;)V", "async", "", "getAsync", "()Z", "setAsync", "(Z)V", "getBizUsername", "()Ljava/lang/String;", "setBizUsername", "cancelled", "getCancelled", "setCancelled", "replaced", "getReplaced", "setReplaced", "cancel", "", "getKey", "isAsync", "isCanReplacedByKey", "isCancelled", "runNetScene", "netScene", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "plugin-comm_release"})
public abstract class a
  implements f
{
  public boolean cancelled;
  String dVu;
  public boolean jzf;
  public boolean jzg;
  
  public a(String paramString)
  {
    this.dVu = paramString;
  }
  
  public void cancel()
  {
    this.cancelled = true;
  }
  
  public final void d(b paramb)
  {
    p.h(paramb, "netScene");
    paramb.jzo = ((b.c)new a(this, paramb.jzo));
    paramb.a((com.tencent.mm.msgsubscription.util.a.a)com.tencent.mm.msgsubscription.a.a.jzi);
  }
  
  public String getKey()
  {
    return String.valueOf(hashCode());
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask$runNetScene$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class a
    implements b.c
  {
    a(b.c paramc) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149663);
      p.h(paramString, "errMsg");
      Object localObject = d.jAR;
      d.a(this.jAV);
      localObject = this.jAW;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.e.a
 * JD-Core Version:    0.7.0.1
 */