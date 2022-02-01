package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbx;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$3$1$1", "Landroid/os/ResultReceiver;", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderLiveCommentPlugin$3$$special$$inlined$let$lambda$1
  extends ResultReceiver
{
  FinderLiveCommentPlugin$3$$special$$inlined$let$lambda$1(bbx parambbx1, Handler paramHandler, aq.3 param3, bbx parambbx2)
  {
    super(paramHandler);
  }
  
  protected final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(250164);
    Log.i("Finder.LiveCommentPlugin", "openLuckyMoney result:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(250164);
      return;
      paramBundle = aq.getFinderLiveAssistant();
      if (paramBundle != null) {
        paramBundle.a(((c)this.yoY.yoR.business(c.class)).liveInfo.liveId, ((c)this.yoY.yoR.business(c.class)).xbk, ((c)this.yoY.yoR.business(c.class)).nonceId, ((c)this.yoY.yoR.business(c.class)).kvN, this.yoX.SKs);
      }
      paramBundle = aq.g(this.yoY.yoR);
      b.c localc = b.c.kBl;
      Bundle localBundle = new Bundle();
      localBundle.putString("PARAM_FINDER_LIVE_LUCKY_MONEY_SEND_ID", this.yoX.SKs);
      paramBundle.statusChange(localc, localBundle);
      AppMethodBeat.o(250164);
      return;
      AppMethodBeat.o(250164);
      return;
      paramBundle = aq.g(this.yoY.yoR);
      localc = b.c.kBl;
      localBundle = new Bundle();
      localBundle.putString("PARAM_FINDER_LIVE_LUCKY_MONEY_SEND_ID", this.yoX.SKs);
      paramBundle.statusChange(localc, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.FinderLiveCommentPlugin.3..special..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */