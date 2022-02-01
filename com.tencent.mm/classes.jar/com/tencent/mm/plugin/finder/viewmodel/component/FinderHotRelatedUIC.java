package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.plugin.finder.event.a.a;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.m;
import com.tencent.mm.plugin.finder.report.m.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.b;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.dje;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.SimpleUIComponent;
import com.tencent.mm.ui.component.UIComponent;
import d.f;
import d.g.b.p;
import d.n.n;
import d.v;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "contactChangeListener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$contactChangeListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$contactChangeListener$1;", "observer", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1;", "timelineUIC", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "getTimelineUIC", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "timelineUIC$delegate", "Lkotlin/Lazy;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "doFetchRelatedFeed", "", "feedId", "", "maxUnreadCount", "", "source", "", "isPrefetch", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public final class FinderHotRelatedUIC
  extends UIComponent
{
  private static boolean tmQ;
  public static final FinderHotRelatedUIC.a tmR;
  private final aq gKO;
  private final c tmN;
  private final b tmO;
  final f tmP;
  
  static
  {
    AppMethodBeat.i(206240);
    tmR = new FinderHotRelatedUIC.a((byte)0);
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    tmQ = ((Boolean)com.tencent.mm.plugin.finder.storage.b.cJC().value()).booleanValue();
    AppMethodBeat.o(206240);
  }
  
  public FinderHotRelatedUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(206239);
    this.gKO = new aq(Looper.getMainLooper());
    this.tmN = new c(this);
    this.tmO = new b(this);
    this.tmP = d.g.O((d.g.a.a)new FinderHotRelatedUIC.d(paramFragment));
    AppMethodBeat.o(206239);
  }
  
  private final void a(long paramLong, int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(206237);
    Fragment localFragment = this.fragment;
    if (localFragment != null)
    {
      if (!paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.data.g.sKQ;
        if (com.tencent.mm.plugin.finder.storage.data.g.xp(paramLong)) {}
      }
      else
      {
        if (!paramBoolean) {
          break label895;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.data.g.sKQ;
        if (!com.tencent.mm.plugin.finder.storage.data.g.xq(paramLong)) {
          break label895;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.data.g.sKQ;
        if (!com.tencent.mm.plugin.finder.storage.data.g.xp(paramLong)) {
          break label895;
        }
      }
      aov localaov = new aov();
      Object localObject1 = com.tencent.mm.ui.component.a.KEX;
      localObject1 = localFragment.getActivity();
      if (localObject1 == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(206237);
        throw paramString;
      }
      Object localObject2 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)localObject1).get(FinderReporterUIC.class)).GR(4);
      if (localObject2 != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.l.szc;
        Object localObject3 = com.tencent.mm.plugin.finder.report.l.cFx();
        if (localObject3 == null) {
          break label862;
        }
        localObject1 = new m(((m)localObject3).duw, ((m)localObject3).startTime, ((m)localObject3).feed, ((m)localObject3).rZD, ((m)localObject3).szQ, ((m)localObject3).sxD);
        ((m)localObject1).szi = ((m)localObject3).szi;
        ((m)localObject1).szj = ((m)localObject3).szj;
        ((m)localObject1).endTime = ((m)localObject3).endTime;
        ((m)localObject1).szk = ((m)localObject3).szk;
        ((m)localObject1).szl = ((m)localObject3).szl;
        ((m)localObject1).szm = ((m)localObject3).szm;
        ((m)localObject1).szn = ((m)localObject3).szn;
        ((m)localObject1).szo = ((m)localObject3).szo;
        ((m)localObject1).szp = ((m)localObject3).szp;
        ((m)localObject1).szq = ((m)localObject3).szq;
        ((m)localObject1).szr = ((m)localObject3).szr;
        ((m)localObject1).szs = ((m)localObject3).szs;
        ((m)localObject1).lmm = ((m)localObject3).lmm;
        ((m)localObject1).szt = ((m)localObject3).szt;
        ((m)localObject1).szu = ((m)localObject3).szu;
        ((m)localObject1).szv = ((m)localObject3).szv;
        ((m)localObject1).szw = ((m)localObject3).szw;
        ((m)localObject1).szx = ((m)localObject3).szx;
        ((m)localObject1).szy = ((m)localObject3).szy;
        ((m)localObject1).szz = ((m)localObject3).szz;
        ((m)localObject1).szA = ((m)localObject3).szA;
        ((m)localObject1).szB = ((m)localObject3).szB;
        ((m)localObject1).szC = ((m)localObject3).szC;
        ((m)localObject1).szD = ((m)localObject3).szD;
        ((m)localObject1).szE = ((m)localObject3).szE;
        ((m)localObject1).szF = ((m)localObject3).szF;
        ((m)localObject1).szG = ((m)localObject3).szG;
        ((m)localObject1).szH = ((m)localObject3).szH;
        ((m)localObject1).dCI = ((m)localObject3).dCI;
        ((m)localObject1).szI = ((m)localObject3).szI;
        ((m)localObject1).szJ = ((m)localObject3).szJ;
        ((m)localObject1).szK = ((m)localObject3).szK;
        ((m)localObject1).szL = ((m)localObject3).szL;
        ((m)localObject1).szM = ((m)localObject3).szM;
        ((m)localObject1).szN = ((m)localObject3).szN;
        ((m)localObject1).szO = ((m)localObject3).szO;
        ((m)localObject1).netType = ((m)localObject3).netType;
        ((m)localObject1).videoDuration = ((m)localObject3).videoDuration;
        if (localObject1 != null)
        {
          ((m)localObject1).a(((com.tencent.mm.plugin.finder.report.c)localObject2).sxD);
          localObject3 = m.szT;
          localaov.GGe = m.a.a((m)localObject1, ((com.tencent.mm.plugin.finder.report.c)localObject2).rQw);
          localObject1 = com.tencent.mm.plugin.finder.storage.data.g.sKQ;
          localObject1 = com.tencent.mm.plugin.finder.storage.data.g.xo(paramLong);
          if (localObject1 == null) {
            break label868;
          }
          localObject1 = ((FinderItem.b)localObject1).kzK;
          label626:
          localaov.GGd = ((String)localObject1);
        }
      }
      localObject1 = localaov.GGe;
      if (localObject1 != null)
      {
        localObject2 = m.szT;
        p.g(localObject1, "it");
        m.a.a((dje)localObject1, "Finder.HotRelatedUIC");
      }
      paramString = new StringBuilder("[doFetchRelatedFeed] ").append(com.tencent.mm.ac.c.rp(paramLong)).append(" maxUnreadCount=").append(paramInt).append(" isPrefetch=").append(paramBoolean).append(" source=").append(paramString).append(' ').append("config=");
      localObject1 = com.tencent.mm.plugin.finder.storage.data.g.sKQ;
      localObject1 = paramString.append(com.tencent.mm.plugin.finder.storage.data.g.xo(paramLong)).append(", stats=");
      paramString = localaov.GGe;
      if (paramString != null)
      {
        paramString = Long.valueOf(paramString.rRn);
        label772:
        paramString = ((StringBuilder)localObject1).append(paramString).append(", pos_trigger_config=");
        if (localaov.GGd == null) {
          break label880;
        }
      }
      label862:
      label868:
      label880:
      for (boolean bool = true;; bool = false)
      {
        ae.i("Finder.HotRelatedUIC", bool);
        paramString = com.tencent.mm.ui.component.a.KEX;
        ((FinderTimelineUIC)com.tencent.mm.ui.component.a.of(localFragment).get(FinderTimelineUIC.class)).a(paramLong, paramInt, paramBoolean, localaov);
        if (paramBoolean) {
          break label886;
        }
        paramString = com.tencent.mm.plugin.finder.storage.data.g.sKQ;
        com.tencent.mm.plugin.finder.storage.data.g.xr(paramLong);
        AppMethodBeat.o(206237);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label626;
        paramString = null;
        break label772;
      }
      label886:
      paramString = com.tencent.mm.plugin.finder.storage.data.g.sKQ;
      com.tencent.mm.plugin.finder.storage.data.g.xt(paramLong);
      label895:
      AppMethodBeat.o(206237);
      return;
    }
    AppMethodBeat.o(206237);
  }
  
  public final void cDm()
  {
    AppMethodBeat.i(206234);
    super.cDm();
    this.tmO.alive();
    AppMethodBeat.o(206234);
  }
  
  public final void cNe()
  {
    AppMethodBeat.i(206235);
    super.cNe();
    this.tmO.dead();
    this.gKO.removeCallbacksAndMessages(null);
    AppMethodBeat.o(206235);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(206231);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.ui.component.a.KEX;
    paramBundle = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(getActivity()).get(FinderReporterUIC.class)).GV(4);
    if (paramBundle == null) {
      ae.e("Finder.HotRelatedUIC", "[onCreate] eventDispatcher is null");
    }
    if (paramBundle != null)
    {
      paramBundle.a((d)this.tmN);
      AppMethodBeat.o(206231);
      return;
    }
    AppMethodBeat.o(206231);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(206236);
    super.onDestroy();
    this.tmO.dead();
    this.gKO.removeCallbacksAndMessages(null);
    AppMethodBeat.o(206236);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(206232);
    super.onPause();
    this.gKO.removeCallbacksAndMessages(null);
    AppMethodBeat.o(206232);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(206233);
    super.onResume();
    AppMethodBeat.o(206233);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$contactChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.sdk.b.c<hb>
  {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "lastCenterId", "", "isAsync", "", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "plugin-finder_release"})
  public static final class c
    extends d
  {
    private long tmT;
    
    public final void a(final com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(206229);
      p.h(paramb, "event");
      Object localObject;
      if ((paramb instanceof h))
      {
        localObject = FinderHotRelatedUIC.tmR;
        if (!FinderHotRelatedUIC.cQV())
        {
          AppMethodBeat.o(206229);
          return;
        }
        if (this.tmT != ((h)paramb).rZL)
        {
          FinderHotRelatedUIC.a(this.tmS).removeCallbacksAndMessages(null);
          localObject = ((h)paramb).rZP;
          if (localObject != null)
          {
            localObject = ((BaseFinderFeed)localObject).feedObject;
            if ((localObject != null) && (((FinderItem)localObject).getMediaType() == 2))
            {
              localObject = com.tencent.mm.plugin.finder.storage.data.g.sKQ;
              localObject = com.tencent.mm.plugin.finder.storage.data.g.xo(((h)paramb).rZL);
              if (localObject != null)
              {
                if ((((FinderItem.b)localObject).sJe > 0) && (((FinderItem.b)localObject).sJe < ((FinderItem.b)localObject).sJc)) {
                  FinderHotRelatedUIC.a(this.tmS).postDelayed((Runnable)new a((FinderItem.b)localObject, this, paramb), ((FinderItem.b)localObject).sJe * 1000L);
                }
                if (((FinderItem.b)localObject).sJc > 0) {
                  FinderHotRelatedUIC.a(this.tmS).postDelayed((Runnable)new b((FinderItem.b)localObject, this, paramb), ((FinderItem.b)localObject).sJc * 1000L);
                }
              }
            }
          }
          this.tmT = ((h)paramb).rZL;
          AppMethodBeat.o(206229);
        }
      }
      else
      {
        int i;
        if ((paramb instanceof c.a))
        {
          localObject = FinderHotRelatedUIC.tmR;
          if (!FinderHotRelatedUIC.cQV())
          {
            AppMethodBeat.o(206229);
            return;
          }
          switch (((c.a)paramb).type)
          {
          default: 
            AppMethodBeat.o(206229);
            return;
          }
          localObject = com.tencent.mm.plugin.finder.storage.data.g.sKQ;
          localObject = com.tencent.mm.plugin.finder.storage.data.g.xo(((c.a)paramb).duw);
          if (localObject != null)
          {
            int j = (int)(100.0F * ((c.a)paramb).offset / ((c.a)paramb).ihz);
            if ((((FinderItem.b)localObject).sJe > 0) && (((c.a)paramb).offset >= ((FinderItem.b)localObject).sJe) && (((FinderItem.b)localObject).sJe < ((FinderItem.b)localObject).sJc))
            {
              FinderHotRelatedUIC.b(this.tmS, ((c.a)paramb).duw, ((FinderItem.b)localObject).skP, "VideoShowTime#" + ((FinderItem.b)localObject).sJe);
              if (!n.f((CharSequence)((FinderItem.b)localObject).sJg, (CharSequence)"||"))
              {
                if (((CharSequence)((FinderItem.b)localObject).sJg).length() != 0) {
                  break label600;
                }
                i = 1;
                label446:
                if (i == 0) {
                  break label655;
                }
              }
              i = ((FinderItem.b)localObject).sJd;
              if (1 <= i) {
                break label605;
              }
            }
            label600:
            label605:
            while (j < i)
            {
              if ((((c.a)paramb).offset >= ((FinderItem.b)localObject).sJc) && (((FinderItem.b)localObject).sJc > 0)) {
                FinderHotRelatedUIC.a(this.tmS, ((c.a)paramb).duw, ((FinderItem.b)localObject).skP, "VideoShowTime#" + ((FinderItem.b)localObject).sJc);
              }
              AppMethodBeat.o(206229);
              return;
              i = ((FinderItem.b)localObject).sJf;
              if ((1 > i) || (j < i) || (((FinderItem.b)localObject).sJf >= ((FinderItem.b)localObject).sJd)) {
                break;
              }
              FinderHotRelatedUIC.b(this.tmS, ((c.a)paramb).duw, ((FinderItem.b)localObject).skP, "VideoShowPercentage#" + ((FinderItem.b)localObject).sJf);
              break;
              i = 0;
              break label446;
            }
            FinderHotRelatedUIC.a(this.tmS, ((c.a)paramb).duw, ((FinderItem.b)localObject).skP, "VideoShowPercentage#" + ((FinderItem.b)localObject).sJd);
            AppMethodBeat.o(206229);
            return;
            label655:
            if ((n.f((CharSequence)((FinderItem.b)localObject).sJg, (CharSequence)"&&")) && (j >= ((FinderItem.b)localObject).sJd) && (((c.a)paramb).offset >= ((FinderItem.b)localObject).sJc) && (((FinderItem.b)localObject).sJd > 0) && (((FinderItem.b)localObject).sJc > 0)) {
              FinderHotRelatedUIC.a(this.tmS, ((c.a)paramb).duw, ((FinderItem.b)localObject).skP, "VideoShowPercentage#" + ((FinderItem.b)localObject).sJd);
            }
            AppMethodBeat.o(206229);
            return;
          }
          AppMethodBeat.o(206229);
          return;
        }
        if ((paramb instanceof a.a))
        {
          i = ((a.a)paramb).type;
          localObject = a.a.rYT;
          if (i == a.a.cAK())
          {
            localObject = com.tencent.mm.plugin.finder.storage.data.g.sKQ;
            localObject = com.tencent.mm.plugin.finder.storage.data.g.xo(((a.a)paramb).duw);
            if (localObject != null)
            {
              FinderHotRelatedUIC.a(this.tmS, ((a.a)paramb).duw, ((FinderItem.b)localObject).skP, "SHARE_TO_SNS");
              AppMethodBeat.o(206229);
              return;
            }
            AppMethodBeat.o(206229);
            return;
          }
          localObject = a.a.rYT;
          if (i == a.a.cAP())
          {
            localObject = com.tencent.mm.plugin.finder.storage.data.g.sKQ;
            localObject = com.tencent.mm.plugin.finder.storage.data.g.xo(((a.a)paramb).duw);
            if (localObject != null)
            {
              FinderHotRelatedUIC.a(this.tmS, ((a.a)paramb).duw, ((FinderItem.b)localObject).skP, "LIKE");
              AppMethodBeat.o(206229);
              return;
            }
            AppMethodBeat.o(206229);
            return;
          }
          localObject = a.a.rYT;
          if (i == a.a.cAS())
          {
            localObject = com.tencent.mm.plugin.finder.storage.data.g.sKQ;
            localObject = com.tencent.mm.plugin.finder.storage.data.g.xo(((a.a)paramb).duw);
            if (localObject != null)
            {
              FinderHotRelatedUIC.a(this.tmS, ((a.a)paramb).duw, ((FinderItem.b)localObject).skP, "FAV");
              AppMethodBeat.o(206229);
              return;
            }
            AppMethodBeat.o(206229);
            return;
          }
          localObject = a.a.rYT;
          if (i == a.a.cAJ())
          {
            localObject = com.tencent.mm.plugin.finder.storage.data.g.sKQ;
            localObject = com.tencent.mm.plugin.finder.storage.data.g.xo(((a.a)paramb).duw);
            if (localObject != null)
            {
              FinderHotRelatedUIC.a(this.tmS, ((a.a)paramb).duw, ((FinderItem.b)localObject).skP, "SHARE_TO_CHAT");
              AppMethodBeat.o(206229);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(206229);
    }
    
    public final boolean cAA()
    {
      return false;
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1$onEventHappen$1$1"})
    static final class a
      implements Runnable
    {
      a(FinderItem.b paramb, FinderHotRelatedUIC.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb1) {}
      
      public final void run()
      {
        AppMethodBeat.i(206227);
        FinderHotRelatedUIC.b(jdField_this.tmS, ((h)paramb).rZL, this.tmU.skP, "PhotoShowTime#" + this.tmU.sJc);
        AppMethodBeat.o(206227);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1$onEventHappen$1$2"})
    static final class b
      implements Runnable
    {
      b(FinderItem.b paramb, FinderHotRelatedUIC.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb1) {}
      
      public final void run()
      {
        AppMethodBeat.i(206228);
        FinderHotRelatedUIC.a(jdField_this.tmS, ((h)paramb).rZL, this.tmU.skP, "PhotoShowTime#" + this.tmU.sJc);
        AppMethodBeat.o(206228);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderHotRelatedUIC
 * JD-Core Version:    0.7.0.1
 */