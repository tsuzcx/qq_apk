package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.plugin.finder.event.a.a;
import com.tencent.mm.plugin.finder.event.b.a;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.h.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.b;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.dcw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.SimpleUIComponent;
import com.tencent.mm.ui.component.UIComponent;
import d.f;
import d.g.b.u;
import d.g.b.w;
import d.n.n;
import d.v;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "contactChangeListener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$contactChangeListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$contactChangeListener$1;", "observer", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1;", "timelineUIC", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "getTimelineUIC", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "timelineUIC$delegate", "Lkotlin/Lazy;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "doFetchRelatedFeed", "", "feedId", "", "maxUnreadCount", "", "source", "", "isPrefetch", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public final class FinderHotRelatedUIC
  extends UIComponent
{
  private static boolean sdZ;
  public static final FinderHotRelatedUIC.a sea;
  private final ao gox;
  private final c sdW;
  private final b sdX;
  final f sdY;
  
  static
  {
    AppMethodBeat.i(204557);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(FinderHotRelatedUIC.class), "timelineUIC", "getTimelineUIC()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;")) };
    sea = new FinderHotRelatedUIC.a((byte)0);
    sdZ = true;
    AppMethodBeat.o(204557);
  }
  
  public FinderHotRelatedUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(204566);
    this.gox = new ao(Looper.getMainLooper());
    this.sdW = new c(this);
    this.sdX = new b(this);
    this.sdY = d.g.K((d.g.a.a)new d(paramFragment));
    AppMethodBeat.o(204566);
  }
  
  private final void a(long paramLong, int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(204564);
    Fragment localFragment = this.fragment;
    if (localFragment != null)
    {
      if (!paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.data.g.rEP;
        if (com.tencent.mm.plugin.finder.storage.data.g.uW(paramLong)) {}
      }
      else
      {
        if (!paramBoolean) {
          break label882;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.data.g.rEP;
        if (!com.tencent.mm.plugin.finder.storage.data.g.uX(paramLong)) {
          break label882;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.data.g.rEP;
        if (!com.tencent.mm.plugin.finder.storage.data.g.uW(paramLong)) {
          break label882;
        }
      }
      ald localald = new ald();
      Object localObject1 = com.tencent.mm.ui.component.a.IrY;
      localObject1 = localFragment.getActivity();
      if (localObject1 == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(204564);
        throw paramString;
      }
      Object localObject2 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)localObject1).get(FinderReporterUIC.class)).Fe(4);
      if (localObject2 != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.g.rxy;
        com.tencent.mm.plugin.finder.report.h localh = com.tencent.mm.plugin.finder.report.g.cwW();
        if (localh == null) {
          break label849;
        }
        localObject1 = new com.tencent.mm.plugin.finder.report.h(localh.dig, localh.startTime, localh.feed, localh.rdF, localh.ryj, localh.rwW);
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxC = localh.rxC;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxD = localh.rxD;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).endTime = localh.endTime;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxE = localh.rxE;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxF = localh.rxF;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxG = localh.rxG;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxH = localh.rxH;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxI = localh.rxI;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxJ = localh.rxJ;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxK = localh.rxK;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxL = localh.rxL;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxM = localh.rxM;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).kLX = localh.kLX;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxN = localh.rxN;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxO = localh.rxO;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxP = localh.rxP;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxQ = localh.rxQ;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxR = localh.rxR;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxS = localh.rxS;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxT = localh.rxT;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxU = localh.rxU;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxV = localh.rxV;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxW = localh.rxW;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxX = localh.rxX;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxY = localh.rxY;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rxZ = localh.rxZ;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rya = localh.rya;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).ryb = localh.ryb;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).dpQ = localh.dpQ;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).ryc = localh.ryc;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).ryd = localh.ryd;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).rye = localh.rye;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).ryf = localh.ryf;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).ryg = localh.ryg;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).ryh = localh.ryh;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).ryi = localh.ryi;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).netType = localh.netType;
        ((com.tencent.mm.plugin.finder.report.h)localObject1).videoDuration = localh.videoDuration;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.finder.report.h)localObject1).a(((com.tencent.mm.plugin.finder.report.a)localObject2).rwW);
          localObject2 = com.tencent.mm.plugin.finder.report.h.ryk;
          localald.EES = h.a.b((com.tencent.mm.plugin.finder.report.h)localObject1);
          localObject1 = com.tencent.mm.plugin.finder.storage.data.g.rEP;
          localObject1 = com.tencent.mm.plugin.finder.storage.data.g.uV(paramLong);
          if (localObject1 == null) {
            break label855;
          }
          localObject1 = ((FinderItem.b)localObject1).kbW;
          label621:
          localald.EER = ((String)localObject1);
        }
      }
      localObject1 = localald.EES;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.report.h.ryk;
        h.a.a((dcw)localObject1, "Finder.HotRelatedUIC");
      }
      paramString = new StringBuilder("[doFetchRelatedFeed] ").append(com.tencent.mm.ac.c.pb(paramLong)).append(" maxUnreadCount=").append(paramInt).append(" isPrefetch=").append(paramBoolean).append(" source=").append(paramString).append(' ').append("config=");
      localObject1 = com.tencent.mm.plugin.finder.storage.data.g.rEP;
      localObject1 = paramString.append(com.tencent.mm.plugin.finder.storage.data.g.uV(paramLong)).append(", stats=");
      paramString = localald.EES;
      if (paramString != null)
      {
        paramString = Long.valueOf(paramString.qXP);
        label759:
        paramString = ((StringBuilder)localObject1).append(paramString).append(", pos_trigger_config=");
        if (localald.EER == null) {
          break label867;
        }
      }
      label849:
      label855:
      label867:
      for (boolean bool = true;; bool = false)
      {
        ac.i("Finder.HotRelatedUIC", bool);
        paramString = com.tencent.mm.ui.component.a.IrY;
        ((FinderTimelineUIC)com.tencent.mm.ui.component.a.of(localFragment).get(FinderTimelineUIC.class)).a(paramLong, paramInt, paramBoolean, localald);
        if (paramBoolean) {
          break label873;
        }
        paramString = com.tencent.mm.plugin.finder.storage.data.g.rEP;
        com.tencent.mm.plugin.finder.storage.data.g.uY(paramLong);
        AppMethodBeat.o(204564);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label621;
        paramString = null;
        break label759;
      }
      label873:
      paramString = com.tencent.mm.plugin.finder.storage.data.g.rEP;
      com.tencent.mm.plugin.finder.storage.data.g.va(paramLong);
      label882:
      AppMethodBeat.o(204564);
      return;
    }
    AppMethodBeat.o(204564);
  }
  
  public final void cFW()
  {
    AppMethodBeat.i(204562);
    super.cFW();
    this.sdX.dead();
    this.gox.removeCallbacksAndMessages(null);
    AppMethodBeat.o(204562);
  }
  
  public final void cvj()
  {
    AppMethodBeat.i(204561);
    super.cvj();
    this.sdX.alive();
    AppMethodBeat.o(204561);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204558);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.ui.component.a.IrY;
    paramBundle = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q(getActivity()).get(FinderReporterUIC.class)).Fi(4);
    if (paramBundle == null) {
      ac.e("Finder.HotRelatedUIC", "[onCreate] eventDispatcher is null");
    }
    if (paramBundle != null)
    {
      paramBundle.a((d)this.sdW);
      AppMethodBeat.o(204558);
      return;
    }
    AppMethodBeat.o(204558);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204563);
    super.onDestroy();
    this.sdX.dead();
    this.gox.removeCallbacksAndMessages(null);
    AppMethodBeat.o(204563);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(204559);
    super.onPause();
    this.gox.removeCallbacksAndMessages(null);
    AppMethodBeat.o(204559);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(204560);
    super.onResume();
    AppMethodBeat.o(204560);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$contactChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.sdk.b.c<gw>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "lastCenterId", "", "isAsync", "", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "plugin-finder_release"})
  public static final class c
    extends d
  {
    private long sec;
    
    public final void a(final b paramb)
    {
      AppMethodBeat.i(204555);
      d.g.b.k.h(paramb, "event");
      Object localObject;
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
      {
        localObject = FinderHotRelatedUIC.sea;
        if (!FinderHotRelatedUIC.cFX())
        {
          AppMethodBeat.o(204555);
          return;
        }
        if (this.sec != ((com.tencent.mm.plugin.finder.event.base.h)paramb).rdL)
        {
          FinderHotRelatedUIC.a(this.seb).removeCallbacksAndMessages(null);
          localObject = ((com.tencent.mm.plugin.finder.event.base.h)paramb).rde;
          if (localObject != null)
          {
            localObject = ((BaseFinderFeed)localObject).feedObject;
            if ((localObject != null) && (((FinderItem)localObject).getMediaType() == 2))
            {
              localObject = com.tencent.mm.plugin.finder.storage.data.g.rEP;
              localObject = com.tencent.mm.plugin.finder.storage.data.g.uV(((com.tencent.mm.plugin.finder.event.base.h)paramb).rdL);
              if (localObject != null)
              {
                if ((((FinderItem.b)localObject).rDD > 0) && (((FinderItem.b)localObject).rDD < ((FinderItem.b)localObject).rDB)) {
                  FinderHotRelatedUIC.a(this.seb).postDelayed((Runnable)new a((FinderItem.b)localObject, this, paramb), ((FinderItem.b)localObject).rDD * 1000L);
                }
                if (((FinderItem.b)localObject).rDB > 0) {
                  FinderHotRelatedUIC.a(this.seb).postDelayed((Runnable)new b((FinderItem.b)localObject, this, paramb), ((FinderItem.b)localObject).rDB * 1000L);
                }
              }
            }
          }
          this.sec = ((com.tencent.mm.plugin.finder.event.base.h)paramb).rdL;
          AppMethodBeat.o(204555);
        }
      }
      else
      {
        int i;
        if ((paramb instanceof b.a))
        {
          localObject = FinderHotRelatedUIC.sea;
          if (!FinderHotRelatedUIC.cFX())
          {
            AppMethodBeat.o(204555);
            return;
          }
          switch (((b.a)paramb).type)
          {
          }
          do
          {
            AppMethodBeat.o(204555);
            return;
            localObject = com.tencent.mm.plugin.finder.storage.data.g.rEP;
            localObject = com.tencent.mm.plugin.finder.storage.data.g.uV(((b.a)paramb).dig);
          } while (localObject == null);
          int j = (int)(100.0F * ((b.a)paramb).offset / ((b.a)paramb).hLN);
          if ((((FinderItem.b)localObject).rDD > 0) && (((b.a)paramb).offset >= ((FinderItem.b)localObject).rDD) && (((FinderItem.b)localObject).rDD < ((FinderItem.b)localObject).rDB))
          {
            FinderHotRelatedUIC.b(this.seb, ((b.a)paramb).dig, ((FinderItem.b)localObject).rnB, "VideoShowTime#" + ((FinderItem.b)localObject).rDD);
            if (!n.e((CharSequence)((FinderItem.b)localObject).rDF, (CharSequence)"||"))
            {
              if (((CharSequence)((FinderItem.b)localObject).rDF).length() != 0) {
                break label600;
              }
              i = 1;
              label446:
              if (i == 0) {
                break label655;
              }
            }
            i = ((FinderItem.b)localObject).rDC;
            if (1 <= i) {
              break label605;
            }
          }
          label600:
          label605:
          while (j < i)
          {
            if ((((b.a)paramb).offset >= ((FinderItem.b)localObject).rDB) && (((FinderItem.b)localObject).rDB > 0)) {
              FinderHotRelatedUIC.a(this.seb, ((b.a)paramb).dig, ((FinderItem.b)localObject).rnB, "VideoShowTime#" + ((FinderItem.b)localObject).rDB);
            }
            AppMethodBeat.o(204555);
            return;
            i = ((FinderItem.b)localObject).rDE;
            if ((1 > i) || (j < i) || (((FinderItem.b)localObject).rDE >= ((FinderItem.b)localObject).rDC)) {
              break;
            }
            FinderHotRelatedUIC.b(this.seb, ((b.a)paramb).dig, ((FinderItem.b)localObject).rnB, "VideoShowPercentage#" + ((FinderItem.b)localObject).rDE);
            break;
            i = 0;
            break label446;
          }
          FinderHotRelatedUIC.a(this.seb, ((b.a)paramb).dig, ((FinderItem.b)localObject).rnB, "VideoShowPercentage#" + ((FinderItem.b)localObject).rDC);
          AppMethodBeat.o(204555);
          return;
          label655:
          if ((n.e((CharSequence)((FinderItem.b)localObject).rDF, (CharSequence)"&&")) && (j >= ((FinderItem.b)localObject).rDC) && (((b.a)paramb).offset >= ((FinderItem.b)localObject).rDB) && (((FinderItem.b)localObject).rDC > 0) && (((FinderItem.b)localObject).rDB > 0)) {
            FinderHotRelatedUIC.a(this.seb, ((b.a)paramb).dig, ((FinderItem.b)localObject).rnB, "VideoShowPercentage#" + ((FinderItem.b)localObject).rDC);
          }
          AppMethodBeat.o(204555);
          return;
        }
        if ((paramb instanceof a.a))
        {
          i = ((a.a)paramb).type;
          localObject = a.a.rcW;
          if (i == a.a.ctd())
          {
            localObject = com.tencent.mm.plugin.finder.storage.data.g.rEP;
            localObject = com.tencent.mm.plugin.finder.storage.data.g.uV(((a.a)paramb).dig);
            if (localObject != null)
            {
              FinderHotRelatedUIC.a(this.seb, ((a.a)paramb).dig, ((FinderItem.b)localObject).rnB, "SHARE_TO_SNS");
              AppMethodBeat.o(204555);
              return;
            }
            AppMethodBeat.o(204555);
            return;
          }
          localObject = a.a.rcW;
          if (i == a.a.cti())
          {
            localObject = com.tencent.mm.plugin.finder.storage.data.g.rEP;
            localObject = com.tencent.mm.plugin.finder.storage.data.g.uV(((a.a)paramb).dig);
            if (localObject != null)
            {
              FinderHotRelatedUIC.a(this.seb, ((a.a)paramb).dig, ((FinderItem.b)localObject).rnB, "LIKE");
              AppMethodBeat.o(204555);
              return;
            }
            AppMethodBeat.o(204555);
            return;
          }
          localObject = a.a.rcW;
          if (i == a.a.ctl())
          {
            localObject = com.tencent.mm.plugin.finder.storage.data.g.rEP;
            localObject = com.tencent.mm.plugin.finder.storage.data.g.uV(((a.a)paramb).dig);
            if (localObject != null)
            {
              FinderHotRelatedUIC.a(this.seb, ((a.a)paramb).dig, ((FinderItem.b)localObject).rnB, "FAV");
              AppMethodBeat.o(204555);
              return;
            }
            AppMethodBeat.o(204555);
            return;
          }
          localObject = a.a.rcW;
          if (i == a.a.ctc())
          {
            localObject = com.tencent.mm.plugin.finder.storage.data.g.rEP;
            localObject = com.tencent.mm.plugin.finder.storage.data.g.uV(((a.a)paramb).dig);
            if (localObject != null)
            {
              FinderHotRelatedUIC.a(this.seb, ((a.a)paramb).dig, ((FinderItem.b)localObject).rnB, "SHARE_TO_CHAT");
              AppMethodBeat.o(204555);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(204555);
    }
    
    public final boolean csW()
    {
      return false;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1$onEventHappen$1$1"})
    static final class a
      implements Runnable
    {
      a(FinderItem.b paramb, FinderHotRelatedUIC.c paramc, b paramb1) {}
      
      public final void run()
      {
        AppMethodBeat.i(204553);
        FinderHotRelatedUIC.b(jdField_this.seb, ((com.tencent.mm.plugin.finder.event.base.h)paramb).rdL, this.sed.rnB, "PhotoShowTime#" + this.sed.rDB);
        AppMethodBeat.o(204553);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1$onEventHappen$1$2"})
    static final class b
      implements Runnable
    {
      b(FinderItem.b paramb, FinderHotRelatedUIC.c paramc, b paramb1) {}
      
      public final void run()
      {
        AppMethodBeat.i(204554);
        FinderHotRelatedUIC.a(jdField_this.seb, ((com.tencent.mm.plugin.finder.event.base.h)paramb).rdL, this.sed.rnB, "PhotoShowTime#" + this.sed.rDB);
        AppMethodBeat.o(204554);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<FinderTimelineUIC>
  {
    d(Fragment paramFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderHotRelatedUIC
 * JD-Core Version:    0.7.0.1
 */