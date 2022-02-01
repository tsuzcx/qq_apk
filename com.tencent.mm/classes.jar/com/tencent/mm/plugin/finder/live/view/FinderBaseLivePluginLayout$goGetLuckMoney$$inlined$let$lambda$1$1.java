package com.tencent.mm.plugin.finder.live.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$goGetLuckMoney$1$1$onCgiBack$2$1", "Landroid/os/ResultReceiver;", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "plugin-finder_release", "com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$goGetLuckMoney$1$1$onCgiBack$$inlined$let$lambda$1"})
public final class FinderBaseLivePluginLayout$goGetLuckMoney$$inlined$let$lambda$1$1
  extends ResultReceiver
{
  FinderBaseLivePluginLayout$goGetLuckMoney$$inlined$let$lambda$1$1(LinkedList paramLinkedList, Handler paramHandler, a.e parame)
  {
    super(paramHandler);
  }
  
  protected final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    paramBundle = null;
    a locala = null;
    AppMethodBeat.i(284347);
    Log.i(a.access$getTAG$p(this.ySs.ySq), "openLuckyMoney result:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(284347);
      return;
      Object localObject1 = this.ySs.ySq.getFinderLiveAssistant();
      long l1;
      long l2;
      if (localObject1 != null)
      {
        l1 = ((c)this.ySs.ySq.business(c.class)).liveInfo.liveId;
        l2 = ((c)this.ySs.ySq.business(c.class)).xbk;
        localObject2 = ((c)this.ySs.ySq.business(c.class)).nonceId;
        localObject3 = ((c)this.ySs.ySq.business(c.class)).kvN;
        paramBundle = (bbx)this.ySr.get(0);
        if (paramBundle == null) {
          break label274;
        }
      }
      label274:
      for (paramBundle = paramBundle.SKs;; paramBundle = null)
      {
        ((an)localObject1).a(l1, l2, (String)localObject2, (byte[])localObject3, paramBundle);
        localObject1 = this.ySs.ySq;
        localObject2 = b.c.kBl;
        localObject3 = new Bundle();
        bbx localbbx = (bbx)this.ySr.get(0);
        paramBundle = locala;
        if (localbbx != null) {
          paramBundle = localbbx.SKs;
        }
        ((Bundle)localObject3).putString("PARAM_FINDER_LIVE_LUCKY_MONEY_SEND_ID", paramBundle);
        ((a)localObject1).statusChange((b.c)localObject2, (Bundle)localObject3);
        AppMethodBeat.o(284347);
        return;
      }
      AppMethodBeat.o(284347);
      return;
      locala = this.ySs.ySq;
      localObject1 = b.c.kBl;
      Object localObject2 = new Bundle();
      Object localObject3 = (bbx)this.ySr.get(0);
      if (localObject3 != null) {
        paramBundle = ((bbx)localObject3).SKs;
      }
      ((Bundle)localObject2).putString("PARAM_FINDER_LIVE_LUCKY_MONEY_SEND_ID", paramBundle);
      locala.statusChange((b.c)localObject1, (Bundle)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout.goGetLuckMoney..inlined.let.lambda.1.1
 * JD-Core Version:    0.7.0.1
 */