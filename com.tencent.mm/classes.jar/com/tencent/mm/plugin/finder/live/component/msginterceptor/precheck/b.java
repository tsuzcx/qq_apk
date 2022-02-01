package com.tencent.mm.plugin.finder.live.component.msginterceptor.precheck;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.a;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.i;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.al;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/precheck/LiveMsgRespErrCodeInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IPreCheckInterceptor;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "intercept", "", "cgiResp", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements i
{
  private final String TAG = "LiveMsgRespErrCodeInterceptor";
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(353248);
    s.u(parama, "cgiResp");
    if ((parama.errType == 4) && (parama.errCode == -100020))
    {
      parama = aj.CGT;
      aj.elG();
      AppMethodBeat.o(353248);
      return false;
    }
    if (parama.errCode == -200001)
    {
      parama = al.CHU;
      al.emd();
      AppMethodBeat.o(353248);
      return false;
    }
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      AppMethodBeat.o(353248);
      return true;
    }
    Log.i(this.TAG, s.X("doGetLiveMsg errCode:", Integer.valueOf(parama.errCode)));
    AppMethodBeat.o(353248);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.precheck.b
 * JD-Core Version:    0.7.0.1
 */