package com.tencent.mm.plugin.finder.live.component;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbx;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/LuckyMoneyResultReceiev;", "Landroid/os/ResultReceiver;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubblePresenter;", "handler", "Landroid/os/Handler;", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubblePresenter;Landroid/os/Handler;)V", "rLuckyMoneyShowInfo", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubblePresenter$LuckyMoneyShowInfo;", "getRLuckyMoneyShowInfo", "()Ljava/lang/ref/WeakReference;", "setRLuckyMoneyShowInfo", "(Ljava/lang/ref/WeakReference;)V", "rPresenter", "getRPresenter", "setRPresenter", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "setLuckyMoneyShowInfo", "info", "plugin-finder_release"})
public final class LuckyMoneyResultReceiev
  extends ResultReceiver
{
  private WeakReference<u> ycR;
  WeakReference<u.b> ycS;
  
  public LuckyMoneyResultReceiev(u paramu, Handler paramHandler)
  {
    super(paramHandler);
    AppMethodBeat.i(238181);
    this.ycR = new WeakReference(paramu);
    AppMethodBeat.o(238181);
  }
  
  protected final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(238179);
    super.onReceiveResult(paramInt, paramBundle);
    u localu = (u)this.ycR.get();
    paramBundle = this.ycS;
    if (paramBundle != null) {}
    for (paramBundle = (u.b)paramBundle.get();; paramBundle = null)
    {
      Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", "openLuckyMoney presenter:" + localu + ",LuckyMoneyShowInfo:" + paramBundle + ", result:" + paramInt);
      if ((localu != null) && (paramBundle != null)) {
        break;
      }
      AppMethodBeat.o(238179);
      return;
    }
    an localan = localu.ybM;
    a locala = localu.xYp;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(238179);
      return;
      if (localan != null) {
        localan.a(((c)locala.business(c.class)).liveInfo.liveId, ((c)locala.business(c.class)).xbk, ((c)locala.business(c.class)).nonceId, ((c)locala.business(c.class)).kvN, paramBundle.ybR.SKs);
      }
      localu.a(paramBundle);
      AppMethodBeat.o(238179);
      return;
      AppMethodBeat.o(238179);
      return;
      localu.a(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.LuckyMoneyResultReceiev
 * JD-Core Version:    0.7.0.1
 */