package com.tencent.mm.plugin.finder.live.component;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bls;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/LuckyMoneyResultReceiev;", "Landroid/os/ResultReceiver;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubblePresenter;", "handler", "Landroid/os/Handler;", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubblePresenter;Landroid/os/Handler;)V", "rLuckyMoneyShowInfo", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubblePresenter$LuckyMoneyShowInfo;", "getRLuckyMoneyShowInfo", "()Ljava/lang/ref/WeakReference;", "setRLuckyMoneyShowInfo", "(Ljava/lang/ref/WeakReference;)V", "rPresenter", "getRPresenter", "setRPresenter", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "setLuckyMoneyShowInfo", "info", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LuckyMoneyResultReceiev
  extends ResultReceiver
{
  private WeakReference<aj> CBi;
  WeakReference<aj.b> CBj;
  
  public LuckyMoneyResultReceiev(aj paramaj, Handler paramHandler)
  {
    super(paramHandler);
    AppMethodBeat.i(352829);
    this.CBi = new WeakReference(paramaj);
    AppMethodBeat.o(352829);
  }
  
  protected final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(352840);
    super.onReceiveResult(paramInt, paramBundle);
    aj localaj = (aj)this.CBi.get();
    paramBundle = this.CBj;
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = (aj.b)paramBundle.get())
    {
      Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", "openLuckyMoney presenter:" + localaj + ",LuckyMoneyShowInfo:" + paramBundle + ", result:" + paramInt);
      if ((localaj != null) && (paramBundle != null)) {
        break;
      }
      AppMethodBeat.o(352840);
      return;
    }
    ap localap = localaj.CzZ;
    a locala = localaj.CvU;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(352840);
      return;
      if (localap != null) {
        localap.a(((f)locala.business(f.class)).liveInfo.liveId, ((f)locala.business(f.class)).hKN, ((f)locala.business(f.class)).nonceId, ((f)locala.business(f.class)).mZp, paramBundle.CAe.ZOX);
      }
      localaj.a(paramBundle);
      AppMethodBeat.o(352840);
      return;
      AppMethodBeat.o(352840);
      return;
      localaj.a(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.LuckyMoneyResultReceiev
 * JD-Core Version:    0.7.0.1
 */