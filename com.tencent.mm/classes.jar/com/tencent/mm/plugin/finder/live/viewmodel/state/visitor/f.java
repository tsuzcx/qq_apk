package com.tencent.mm.plugin.finder.live.viewmodel.state.visitor;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.plugin.at;
import com.tencent.mm.plugin.finder.live.plugin.cx;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.b;
import com.tencent.mm.plugin.finder.live.widget.aq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.lang.ref.WeakReference;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/VisitorTimerCallbackImpl;", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "pluginLayout", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC;", "tag", "", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "rPluginLayout", "Ljava/lang/ref/WeakReference;", "getTag", "()Ljava/lang/String;", "onTimerExpired", "", "plugin-finder_release"})
public final class f
  implements MTimerHandler.CallBack
{
  private final String tag;
  private WeakReference<c> xWM;
  private final com.tencent.mm.plugin.finder.live.model.context.a xYp;
  
  public f(c paramc, String paramString, com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(281264);
    this.tag = paramString;
    this.xYp = parama;
    this.xWM = new WeakReference(paramc);
    AppMethodBeat.o(281264);
  }
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(281263);
    Object localObject = (c)this.xWM.get();
    if (localObject == null)
    {
      Log.i(this.tag, "VisitorTimerCallbackImpl onTimerExpired curPluginLayout is empty!");
      AppMethodBeat.o(281263);
      return false;
    }
    at localat = ((c)localObject).zje;
    cx localcx = ((c)localObject).zkE;
    if ((localat != null) && (localat.kiF.getVisibility() == 0))
    {
      if (((b)((c)localObject).business(b.class)).zfY)
      {
        localObject = ((c)localObject).zjd;
        if ((localObject == null) || (((com.tencent.mm.live.c.a)localObject).kiF.getVisibility() != 0))
        {
          AppMethodBeat.o(281263);
          return true;
        }
      }
      localat.dBo();
    }
    if ((localcx != null) && (localcx.yyN.isVisible())) {
      localcx.yyN.LW(((b)localcx.business(b.class)).zfk);
    }
    AppMethodBeat.o(281263);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.f
 * JD-Core Version:    0.7.0.1
 */