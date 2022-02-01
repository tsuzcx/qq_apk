package com.tencent.mm.plugin.finder.live.viewmodel.state.visitor;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.ViewGroup;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.plugin.finder.live.component.statecomponent.d;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.aj;
import com.tencent.mm.plugin.finder.live.plugin.ci;
import com.tencent.mm.plugin.finder.live.plugin.o;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.g;
import com.tencent.mm.plugin.finder.live.widget.bh;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/VisitorTimerCallbackImpl;", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "pluginLayout", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC;", "tag", "", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "rPluginLayout", "Ljava/lang/ref/WeakReference;", "getTag", "()Ljava/lang/String;", "checkWatchTime", "", "stateComponent", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/FinderLiveVisitorStateComponent;", "onTimerExpired", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements MTimerHandler.CallBack
{
  private WeakReference<b> BxE;
  private final com.tencent.mm.plugin.finder.live.model.context.a CvU;
  private final String tag;
  
  public e(b paramb, String paramString, com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(357374);
    this.tag = paramString;
    this.CvU = parama;
    this.BxE = new WeakReference(paramb);
    AppMethodBeat.o(357374);
  }
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(357394);
    Object localObject1 = (b)this.BxE.get();
    if (localObject1 == null)
    {
      Log.i(this.tag, "VisitorTimerCallbackImpl onTimerExpired curPluginLayout is empty!");
      AppMethodBeat.o(357394);
      return false;
    }
    Object localObject3 = ((b)localObject1).EiR;
    Object localObject2 = ((b)localObject1).Eky;
    if ((localObject3 != null) && (((com.tencent.mm.live.b.a)localObject3).mJe.getVisibility() == 0))
    {
      i = 1;
      if (i == 0) {
        break label339;
      }
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdO) {
        break label136;
      }
      localObject4 = ((b)localObject1).EiQ;
      if ((localObject4 == null) || (((com.tencent.mm.live.b.a)localObject4).mJe.getVisibility() != 0)) {
        break label131;
      }
    }
    label131:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label136;
      }
      AppMethodBeat.o(357394);
      return true;
      i = 0;
      break;
    }
    label136:
    Object localObject4 = bj.GlQ;
    Object localObject5;
    long l;
    if (bj.y(((com.tencent.mm.plugin.finder.live.component.statecomponent.e)localObject1).buContext))
    {
      localObject4 = new LinkedList();
      ((LinkedList)localObject4).add(new kotlin.r(Integer.valueOf(5), null));
      localObject5 = MMApplicationContext.getContext().getResources();
      i = p.h.CpD;
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      ((LinkedList)localObject4).add(new kotlin.r(Integer.valueOf(2), ((Resources)localObject5).getString(i, new Object[] { com.tencent.mm.plugin.finder.live.utils.a.jp(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcL) })));
      localObject5 = (n.e)((n)((b)localObject1).business(n.class)).Ehd.getValue();
      if (localObject5 == null)
      {
        l = 0L;
        if (l > 0L)
        {
          localObject5 = MMApplicationContext.getContext().getResources();
          i = p.h.CpE;
          locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          ((LinkedList)localObject4).add(new kotlin.r(Integer.valueOf(3), ((Resources)localObject5).getString(i, new Object[] { com.tencent.mm.plugin.finder.live.utils.a.jp(l) })));
        }
        aj.a((aj)localObject3, (List)localObject4, false);
        label339:
        localObject3 = ((b)localObject1).Ejc;
        if ((localObject3 == null) || (((com.tencent.mm.live.b.a)localObject3).mJe.getVisibility() != 0)) {
          break label867;
        }
      }
    }
    label858:
    label867:
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject3 = ((b)localObject1).Ejc;
        if (localObject3 != null) {
          ((o)localObject3).oo(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcF);
        }
      }
      if ((localObject2 != null) && (((ci)localObject2).Dly.isVisible())) {
        ((ci)localObject2).Dly.pe(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((ci)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcF);
      }
      localObject1 = (d)localObject1;
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((d)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcZ > 0L)
      {
        l = SystemClock.elapsedRealtime() - ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((d)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcZ;
        localObject2 = g.Ebv;
        if ((l >= g.exY()) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((d)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).isLiveStarted()))
        {
          Log.i(this.tag, "visitor join time:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((d)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcZ + ",watch live duration:" + l + '!');
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((d)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).oW(9223372036854775807L);
          localObject2 = new if();
          ((if)localObject2).hJB.id = ((f)((d)localObject1).business(f.class)).liveInfo.liveId;
          ((if)localObject2).hJB.type = 21;
          ((if)localObject2).publish();
        }
      }
      AppMethodBeat.o(357394);
      return true;
      l = ((n.e)localObject5).EhH;
      break;
      localObject4 = new LinkedList();
      ((LinkedList)localObject4).add(new kotlin.r(Integer.valueOf(2), null));
      if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)((b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.r.class)).Eiv) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).DUe)) {
        ((LinkedList)localObject4).add(new kotlin.r(Integer.valueOf(3), null));
      }
      localObject5 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if ((com.tencent.mm.plugin.finder.live.utils.a.a((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class))) || ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edv) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyr()))) {
        if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)((b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.r.class)).Eiv)
        {
          localObject5 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          localObject5 = com.tencent.mm.plugin.finder.live.utils.a.a(((f)((b)localObject1).business(f.class)).liveInfo);
          if (localObject5 != null) {
            break label858;
          }
        }
      }
      for (l = 0L;; l = ((Long)localObject5).longValue())
      {
        if (l > 0L) {
          ((LinkedList)localObject4).add(new kotlin.r(Integer.valueOf(4), null));
        }
        aj.a((aj)localObject3, (List)localObject4, false);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.e
 * JD-Core Version:    0.7.0.1
 */