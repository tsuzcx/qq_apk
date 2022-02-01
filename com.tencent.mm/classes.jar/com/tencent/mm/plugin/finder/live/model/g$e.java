package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.wecoin.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant2$getWeCoinBalance$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "onFailed", "", "errorType", "", "errorCode", "msg", "", "onSuccess", "data", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g$e
  implements i<Long>
{
  g$e(long paramLong, m<? super Long, ? super Long, ah> paramm) {}
  
  public final void s(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(360345);
    Log.i("FinderLiveAssistant2", "[WeCoin] getWeCoinBalance onFailed,errorType:" + paramInt1 + ",errorCode:" + paramInt2 + ",msg:" + paramString + ", requestId:" + this.CEB);
    paramString = this.tGw;
    if (paramString != null) {
      paramString.invoke(Long.valueOf(-1L), Long.valueOf(this.CEB));
    }
    AppMethodBeat.o(360345);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.g.e
 * JD-Core Version:    0.7.0.1
 */