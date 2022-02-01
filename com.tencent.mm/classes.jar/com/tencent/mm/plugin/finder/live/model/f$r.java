package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.wecoin.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$initEngine$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "onFailed", "", "errorType", "", "errorCode", "msg", "", "onSuccess", "data", "(Ljava/lang/Boolean;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$r
  implements i<Boolean>
{
  f$r(f paramf) {}
  
  public final void s(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(359618);
    Log.i(this.CEm.TAG, "[WeCoin] initEngine onFailed");
    paramString = this.CED;
    if (paramString != null) {
      paramString.invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    }
    AppMethodBeat.o(359618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.f.r
 * JD-Core Version:    0.7.0.1
 */