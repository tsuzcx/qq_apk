package com.tencent.mm.plugin.finder.replay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bka;
import com.tencent.mm.protocal.protobuf.bkd;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.protocal.protobuf.ehg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/LiveRecordCountDownSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "DURATION_MAX", "", "getDURATION_MAX", "()J", "DURATION_MAX$delegate", "Lkotlin/Lazy;", "TAG", "", "WHAT_COUNT_DOWN", "", "countDownTagMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/replay/LiveRecordCountDownSlice$HasToast;", "Lkotlin/collections/HashMap;", "getCountDownTagMap", "()Ljava/util/HashMap;", "isCgiGo", "", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimerHandler", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timerHandler$delegate", "checkAndLaunch", "", "onCleared", "stopCountDown", "toastOnUiThread", "str", "HasToast", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends c<com.tencent.mm.plugin.finder.live.model.context.a>
{
  private final kotlin.j DOR;
  private final int FlG;
  public final HashMap<Long, p.b> FlH;
  private volatile boolean FlI;
  private final kotlin.j FlJ;
  private final String TAG;
  
  public p(final com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(332618);
    this.TAG = "LiveRecordCountDownSlick";
    this.FlG = 1000;
    this.DOR = k.cm((kotlin.g.a.a)a.FlK);
    this.FlH = new HashMap();
    this.FlJ = k.cm((kotlin.g.a.a)new d(this, parama));
    AppMethodBeat.o(332618);
  }
  
  private final MTimerHandler eLP()
  {
    AppMethodBeat.i(332629);
    MTimerHandler localMTimerHandler = (MTimerHandler)this.FlJ.getValue();
    AppMethodBeat.o(332629);
    return localMTimerHandler;
  }
  
  private final void exf()
  {
    AppMethodBeat.i(332638);
    this.FlH.clear();
    eLP().stopTimer();
    AppMethodBeat.o(332638);
  }
  
  public final void eLQ()
  {
    AppMethodBeat.i(332733);
    buh localbuh = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Ein;
    if ((localbuh != null) && (localbuh.ZTl == 2)) {}
    for (int i = 1; i != 0; i = 0)
    {
      exf();
      AppMethodBeat.o(332733);
      return;
    }
    d.B((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(332733);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(332747);
    super.onCleared();
    exf();
    AppMethodBeat.o(332747);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<Long>
  {
    public static final a FlK;
    
    static
    {
      AppMethodBeat.i(332523);
      FlK = new a();
      AppMethodBeat.o(332523);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(p paramp)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<MTimerHandler>
  {
    d(p paramp, com.tencent.mm.plugin.finder.live.model.context.a parama)
    {
      super();
    }
    
    private static final boolean a(p paramp, final com.tencent.mm.plugin.finder.live.model.context.a parama)
    {
      AppMethodBeat.i(332554);
      s.u(paramp, "this$0");
      s.u(parama, "$liveContext");
      final bzc localbzc;
      Object localObject2;
      ap localap;
      for (;;)
      {
        synchronized (Boolean.valueOf(p.a(paramp)))
        {
          Log.i(p.d(paramp), "count down looping");
          if (p.a(paramp))
          {
            Log.i(p.d(paramp), "cgi going,return ");
            AppMethodBeat.o(332554);
            return false;
          }
          localObject1 = aj.CGT;
          localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject1).Ein;
            if (localObject1 != null)
            {
              i = ((buh)localObject1).ZTm;
              if (i == 0)
              {
                i = 1;
                if (i == 0) {
                  continue;
                }
                AppMethodBeat.o(332554);
                return true;
              }
            }
          }
          int i = 0;
          continue;
          localbzc = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.p)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.p.class)).EhV;
          localObject1 = aw.Gjk;
          if (localbzc == null)
          {
            localObject1 = null;
            if ((localbzc == null) || (localObject1 == null)) {
              break label601;
            }
            l1 = p.e(paramp);
            l2 = cn.getSyncServerTimeSecond() - ((ehg)localObject1).ftu;
            MMApplicationContext.getContext();
            if (!paramp.FlH.containsKey(Long.valueOf(localbzc.DVk))) {
              ((Map)paramp.FlH).put(Long.valueOf(localbzc.DVk), new p.b());
            }
            localObject1 = paramp.FlH.get(Long.valueOf(localbzc.DVk));
            s.checkNotNull(localObject1);
            s.s(localObject1, "countDownTagMap[productInfo.product_id]!!");
            localObject1 = (p.b)localObject1;
            if (l1 - l2 > 0L) {
              break label591;
            }
            if (!((p.b)localObject1).FlM) {
              p.RU(p.h.CqT);
            }
            ((p.b)localObject1).FlM = true;
            com.tencent.mm.plugin.finder.live.report.j.a(com.tencent.mm.plugin.finder.live.report.j.Dob, 7, 0);
            p.a(paramp, true);
            localObject1 = aj.CGT;
            localObject2 = (f)aj.business(f.class);
            if (localObject2 == null) {
              break label557;
            }
            localObject1 = aj.CGT;
            localap = aj.getFinderLiveAssistant();
            if (localap == null) {
              break label557;
            }
            localObject1 = aj.CGT;
            localObject1 = aj.elk();
            if (localObject1 != null) {
              break label406;
            }
            localObject1 = null;
            if (localObject1 != null) {
              break;
            }
            paramp = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(332554);
            throw paramp;
          }
        }
        localObject1 = localbzc.aaij;
        continue;
        label406:
        localObject1 = ((com.tencent.mm.plugin.finder.live.view.a)localObject1).getContext();
      }
      MMActivity localMMActivity = (MMActivity)localObject1;
      long l1 = ((f)localObject2).liveInfo.liveId;
      long l2 = ((f)localObject2).hKN;
      Object localObject1 = aj.CGT;
      localObject1 = (e)aj.business(e.class);
      if (localObject1 == null) {
        localObject1 = "";
      }
      for (;;)
      {
        localObject2 = new auw();
        ((auw)localObject2).cmdId = 106;
        Object localObject3 = aw.Gjk;
        localObject3 = new bka();
        ((bka)localObject3).DVk = localbzc.DVk;
        ah localah = ah.aiuX;
        ((auw)localObject2).ZFn = aw.j((com.tencent.mm.bx.a)localObject3);
        localObject3 = ah.aiuX;
        localap.a(localMMActivity, l1, l2, (String)localObject1, (auw)localObject2, (kotlin.g.a.q)new a(paramp, localbzc, parama));
        label557:
        AppMethodBeat.o(332554);
        return false;
        localObject2 = ((e)localObject1).mIC;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      label591:
      AppMethodBeat.o(332554);
      return true;
      label601:
      AppMethodBeat.o(332554);
      return false;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopShelfResponse;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.q<Boolean, String, bkd, ah>
    {
      a(p paramp, bzc parambzc, com.tencent.mm.plugin.finder.live.model.context.a parama)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.p
 * JD-Core Version:    0.7.0.1
 */