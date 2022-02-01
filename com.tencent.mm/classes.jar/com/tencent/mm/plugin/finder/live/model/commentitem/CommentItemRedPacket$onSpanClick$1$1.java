package com.tencent.mm.plugin.finder.live.model.commentitem;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bls;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/commentitem/CommentItemRedPacket$onSpanClick$1$1", "Landroid/os/ResultReceiver;", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CommentItemRedPacket$onSpanClick$1$1
  extends ResultReceiver
{
  CommentItemRedPacket$onSpanClick$1$1(r paramr, bls parambls, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(359957);
    Log.i("Finder.LiveCommentPlugin", s.X("openLuckyMoney result:", Integer.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(359957);
      return;
      paramBundle = aj.CGT;
      paramBundle = aj.getFinderLiveAssistant();
      if (paramBundle != null) {
        paramBundle.a(((f)this.CMd.CBK.business(f.class)).liveInfo.liveId, ((f)this.CMd.CBK.business(f.class)).hKN, ((f)this.CMd.CBK.business(f.class)).nonceId, ((f)this.CMd.CBK.business(f.class)).mZp, this.CMe.ZOX);
      }
      paramBundle = aj.CGT;
      paramBundle = aj.elk();
      if (paramBundle != null)
      {
        b.c localc = b.c.neL;
        Bundle localBundle = new Bundle();
        localBundle.putString("PARAM_FINDER_LIVE_LUCKY_MONEY_SEND_ID", this.CMe.ZOX);
        ah localah = ah.aiuX;
        paramBundle.statusChange(localc, localBundle);
        AppMethodBeat.o(359957);
        return;
        AppMethodBeat.o(359957);
        return;
        paramBundle = aj.CGT;
        paramBundle = aj.elk();
        if (paramBundle != null)
        {
          localc = b.c.neL;
          localBundle = new Bundle();
          localBundle.putString("PARAM_FINDER_LIVE_LUCKY_MONEY_SEND_ID", this.CMe.ZOX);
          localah = ah.aiuX;
          paramBundle.statusChange(localc, localBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.commentitem.CommentItemRedPacket.onSpanClick.1.1
 * JD-Core Version:    0.7.0.1
 */