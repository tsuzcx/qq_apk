package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.plugin.finder.event.a.a;
import com.tencent.mm.plugin.finder.event.b.a;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.l.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.b;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.dij;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.SimpleUIComponent;
import com.tencent.mm.ui.component.UIComponent;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.n.n;
import d.v;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "contactChangeListener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$contactChangeListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$contactChangeListener$1;", "observer", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1;", "timelineUIC", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "getTimelineUIC", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "timelineUIC$delegate", "Lkotlin/Lazy;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "doFetchRelatedFeed", "", "feedId", "", "maxUnreadCount", "", "source", "", "isPrefetch", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public final class FinderHotRelatedUIC
  extends UIComponent
{
  private static boolean tbW;
  public static final a tbX;
  private final ap gIf;
  private final c tbT;
  private final b tbU;
  final f tbV;
  
  static
  {
    AppMethodBeat.i(205613);
    tbX = new a((byte)0);
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    tbW = ((Boolean)com.tencent.mm.plugin.finder.storage.b.cHD().value()).booleanValue();
    AppMethodBeat.o(205613);
  }
  
  public FinderHotRelatedUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(205612);
    this.gIf = new ap(Looper.getMainLooper());
    this.tbT = new c(this);
    this.tbU = new b(this);
    this.tbV = d.g.O((d.g.a.a)new d(paramFragment));
    AppMethodBeat.o(205612);
  }
  
  private final void a(long paramLong, int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(205610);
    Fragment localFragment = this.fragment;
    if (localFragment != null)
    {
      if (!paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.data.g.szT;
        if (com.tencent.mm.plugin.finder.storage.data.g.wY(paramLong)) {}
      }
      else
      {
        if (!paramBoolean) {
          break label887;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.data.g.szT;
        if (!com.tencent.mm.plugin.finder.storage.data.g.wZ(paramLong)) {
          break label887;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.data.g.szT;
        if (!com.tencent.mm.plugin.finder.storage.data.g.wY(paramLong)) {
          break label887;
        }
      }
      aoi localaoi = new aoi();
      Object localObject1 = com.tencent.mm.ui.component.a.KiD;
      localObject1 = localFragment.getActivity();
      if (localObject1 == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(205610);
        throw paramString;
      }
      Object localObject2 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)localObject1).get(FinderReporterUIC.class)).Gu(4);
      if (localObject2 != null)
      {
        localObject1 = k.soT;
        Object localObject3 = k.cDB();
        if (localObject3 == null) {
          break label854;
        }
        localObject1 = new com.tencent.mm.plugin.finder.report.l(((com.tencent.mm.plugin.finder.report.l)localObject3).dtq, ((com.tencent.mm.plugin.finder.report.l)localObject3).startTime, ((com.tencent.mm.plugin.finder.report.l)localObject3).feed, ((com.tencent.mm.plugin.finder.report.l)localObject3).rRb, ((com.tencent.mm.plugin.finder.report.l)localObject3).spF, ((com.tencent.mm.plugin.finder.report.l)localObject3).snM);
        ((com.tencent.mm.plugin.finder.report.l)localObject1).soX = ((com.tencent.mm.plugin.finder.report.l)localObject3).soX;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).soY = ((com.tencent.mm.plugin.finder.report.l)localObject3).soY;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).endTime = ((com.tencent.mm.plugin.finder.report.l)localObject3).endTime;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).soZ = ((com.tencent.mm.plugin.finder.report.l)localObject3).soZ;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spa = ((com.tencent.mm.plugin.finder.report.l)localObject3).spa;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spb = ((com.tencent.mm.plugin.finder.report.l)localObject3).spb;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spc = ((com.tencent.mm.plugin.finder.report.l)localObject3).spc;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spd = ((com.tencent.mm.plugin.finder.report.l)localObject3).spd;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spe = ((com.tencent.mm.plugin.finder.report.l)localObject3).spe;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spf = ((com.tencent.mm.plugin.finder.report.l)localObject3).spf;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spg = ((com.tencent.mm.plugin.finder.report.l)localObject3).spg;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).sph = ((com.tencent.mm.plugin.finder.report.l)localObject3).sph;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).liA = ((com.tencent.mm.plugin.finder.report.l)localObject3).liA;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spi = ((com.tencent.mm.plugin.finder.report.l)localObject3).spi;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spj = ((com.tencent.mm.plugin.finder.report.l)localObject3).spj;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spk = ((com.tencent.mm.plugin.finder.report.l)localObject3).spk;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spl = ((com.tencent.mm.plugin.finder.report.l)localObject3).spl;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spm = ((com.tencent.mm.plugin.finder.report.l)localObject3).spm;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spn = ((com.tencent.mm.plugin.finder.report.l)localObject3).spn;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spo = ((com.tencent.mm.plugin.finder.report.l)localObject3).spo;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spp = ((com.tencent.mm.plugin.finder.report.l)localObject3).spp;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spq = ((com.tencent.mm.plugin.finder.report.l)localObject3).spq;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spr = ((com.tencent.mm.plugin.finder.report.l)localObject3).spr;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).sps = ((com.tencent.mm.plugin.finder.report.l)localObject3).sps;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spt = ((com.tencent.mm.plugin.finder.report.l)localObject3).spt;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spu = ((com.tencent.mm.plugin.finder.report.l)localObject3).spu;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spv = ((com.tencent.mm.plugin.finder.report.l)localObject3).spv;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spw = ((com.tencent.mm.plugin.finder.report.l)localObject3).spw;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).dBD = ((com.tencent.mm.plugin.finder.report.l)localObject3).dBD;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spx = ((com.tencent.mm.plugin.finder.report.l)localObject3).spx;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spy = ((com.tencent.mm.plugin.finder.report.l)localObject3).spy;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spz = ((com.tencent.mm.plugin.finder.report.l)localObject3).spz;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spA = ((com.tencent.mm.plugin.finder.report.l)localObject3).spA;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spB = ((com.tencent.mm.plugin.finder.report.l)localObject3).spB;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spC = ((com.tencent.mm.plugin.finder.report.l)localObject3).spC;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).spD = ((com.tencent.mm.plugin.finder.report.l)localObject3).spD;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).netType = ((com.tencent.mm.plugin.finder.report.l)localObject3).netType;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).videoDuration = ((com.tencent.mm.plugin.finder.report.l)localObject3).videoDuration;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.finder.report.l)localObject1).a(((com.tencent.mm.plugin.finder.report.c)localObject2).snM);
          localObject3 = com.tencent.mm.plugin.finder.report.l.spI;
          localaoi.GmX = l.a.a((com.tencent.mm.plugin.finder.report.l)localObject1, ((com.tencent.mm.plugin.finder.report.c)localObject2).rIl);
          localObject1 = com.tencent.mm.plugin.finder.storage.data.g.szT;
          localObject1 = com.tencent.mm.plugin.finder.storage.data.g.wX(paramLong);
          if (localObject1 == null) {
            break label860;
          }
          localObject1 = ((FinderItem.b)localObject1).kwv;
          label626:
          localaoi.GmW = ((String)localObject1);
        }
      }
      localObject1 = localaoi.GmX;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.report.l.spI;
        l.a.a((dij)localObject1, "Finder.HotRelatedUIC");
      }
      paramString = new StringBuilder("[doFetchRelatedFeed] ").append(com.tencent.mm.ad.c.rc(paramLong)).append(" maxUnreadCount=").append(paramInt).append(" isPrefetch=").append(paramBoolean).append(" source=").append(paramString).append(' ').append("config=");
      localObject1 = com.tencent.mm.plugin.finder.storage.data.g.szT;
      localObject1 = paramString.append(com.tencent.mm.plugin.finder.storage.data.g.wX(paramLong)).append(", stats=");
      paramString = localaoi.GmX;
      if (paramString != null)
      {
        paramString = Long.valueOf(paramString.rIZ);
        label764:
        paramString = ((StringBuilder)localObject1).append(paramString).append(", pos_trigger_config=");
        if (localaoi.GmW == null) {
          break label872;
        }
      }
      label854:
      label860:
      label872:
      for (boolean bool = true;; bool = false)
      {
        ad.i("Finder.HotRelatedUIC", bool);
        paramString = com.tencent.mm.ui.component.a.KiD;
        ((FinderTimelineUIC)com.tencent.mm.ui.component.a.of(localFragment).get(FinderTimelineUIC.class)).a(paramLong, paramInt, paramBoolean, localaoi);
        if (paramBoolean) {
          break label878;
        }
        paramString = com.tencent.mm.plugin.finder.storage.data.g.szT;
        com.tencent.mm.plugin.finder.storage.data.g.xa(paramLong);
        AppMethodBeat.o(205610);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label626;
        paramString = null;
        break label764;
      }
      label878:
      paramString = com.tencent.mm.plugin.finder.storage.data.g.szT;
      com.tencent.mm.plugin.finder.storage.data.g.xc(paramLong);
      label887:
      AppMethodBeat.o(205610);
      return;
    }
    AppMethodBeat.o(205610);
  }
  
  public final void cBA()
  {
    AppMethodBeat.i(205607);
    super.cBA();
    this.tbU.alive();
    AppMethodBeat.o(205607);
  }
  
  public final void cKA()
  {
    AppMethodBeat.i(205608);
    super.cKA();
    this.tbU.dead();
    this.gIf.removeCallbacksAndMessages(null);
    AppMethodBeat.o(205608);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(205604);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.ui.component.a.KiD;
    paramBundle = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(getActivity()).get(FinderReporterUIC.class)).Gy(4);
    if (paramBundle == null) {
      ad.e("Finder.HotRelatedUIC", "[onCreate] eventDispatcher is null");
    }
    if (paramBundle != null)
    {
      paramBundle.a((d)this.tbT);
      AppMethodBeat.o(205604);
      return;
    }
    AppMethodBeat.o(205604);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(205609);
    super.onDestroy();
    this.tbU.dead();
    this.gIf.removeCallbacksAndMessages(null);
    AppMethodBeat.o(205609);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(205605);
    super.onPause();
    this.gIf.removeCallbacksAndMessages(null);
    AppMethodBeat.o(205605);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(205606);
    super.onResume();
    AppMethodBeat.o(205606);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$Companion;", "", "()V", "TAG", "", "isEnableAutoGetRelated", "", "()Z", "setEnableAutoGetRelated", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$contactChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.sdk.b.c<ha>
  {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "lastCenterId", "", "isAsync", "", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "plugin-finder_release"})
  public static final class c
    extends d
  {
    private long tbZ;
    
    public final void a(final com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(205602);
      p.h(paramb, "event");
      Object localObject;
      if ((paramb instanceof h))
      {
        localObject = FinderHotRelatedUIC.tbX;
        if (!FinderHotRelatedUIC.cOq())
        {
          AppMethodBeat.o(205602);
          return;
        }
        if (this.tbZ != ((h)paramb).rRj)
        {
          FinderHotRelatedUIC.a(this.tbY).removeCallbacksAndMessages(null);
          localObject = ((h)paramb).rRn;
          if (localObject != null)
          {
            localObject = ((BaseFinderFeed)localObject).feedObject;
            if ((localObject != null) && (((FinderItem)localObject).getMediaType() == 2))
            {
              localObject = com.tencent.mm.plugin.finder.storage.data.g.szT;
              localObject = com.tencent.mm.plugin.finder.storage.data.g.wX(((h)paramb).rRj);
              if (localObject != null)
              {
                if ((((FinderItem.b)localObject).syn > 0) && (((FinderItem.b)localObject).syn < ((FinderItem.b)localObject).syl)) {
                  FinderHotRelatedUIC.a(this.tbY).postDelayed((Runnable)new a((FinderItem.b)localObject, this, paramb), ((FinderItem.b)localObject).syn * 1000L);
                }
                if (((FinderItem.b)localObject).syl > 0) {
                  FinderHotRelatedUIC.a(this.tbY).postDelayed((Runnable)new b((FinderItem.b)localObject, this, paramb), ((FinderItem.b)localObject).syl * 1000L);
                }
              }
            }
          }
          this.tbZ = ((h)paramb).rRj;
          AppMethodBeat.o(205602);
        }
      }
      else
      {
        int i;
        if ((paramb instanceof b.a))
        {
          localObject = FinderHotRelatedUIC.tbX;
          if (!FinderHotRelatedUIC.cOq())
          {
            AppMethodBeat.o(205602);
            return;
          }
          switch (((b.a)paramb).type)
          {
          default: 
            AppMethodBeat.o(205602);
            return;
          }
          localObject = com.tencent.mm.plugin.finder.storage.data.g.szT;
          localObject = com.tencent.mm.plugin.finder.storage.data.g.wX(((b.a)paramb).dtq);
          if (localObject != null)
          {
            int j = (int)(100.0F * ((b.a)paramb).offset / ((b.a)paramb).ieH);
            if ((((FinderItem.b)localObject).syn > 0) && (((b.a)paramb).offset >= ((FinderItem.b)localObject).syn) && (((FinderItem.b)localObject).syn < ((FinderItem.b)localObject).syl))
            {
              FinderHotRelatedUIC.b(this.tbY, ((b.a)paramb).dtq, ((FinderItem.b)localObject).sbY, "VideoShowTime#" + ((FinderItem.b)localObject).syn);
              if (!n.e((CharSequence)((FinderItem.b)localObject).syp, (CharSequence)"||"))
              {
                if (((CharSequence)((FinderItem.b)localObject).syp).length() != 0) {
                  break label600;
                }
                i = 1;
                label446:
                if (i == 0) {
                  break label655;
                }
              }
              i = ((FinderItem.b)localObject).sym;
              if (1 <= i) {
                break label605;
              }
            }
            label600:
            label605:
            while (j < i)
            {
              if ((((b.a)paramb).offset >= ((FinderItem.b)localObject).syl) && (((FinderItem.b)localObject).syl > 0)) {
                FinderHotRelatedUIC.a(this.tbY, ((b.a)paramb).dtq, ((FinderItem.b)localObject).sbY, "VideoShowTime#" + ((FinderItem.b)localObject).syl);
              }
              AppMethodBeat.o(205602);
              return;
              i = ((FinderItem.b)localObject).syo;
              if ((1 > i) || (j < i) || (((FinderItem.b)localObject).syo >= ((FinderItem.b)localObject).sym)) {
                break;
              }
              FinderHotRelatedUIC.b(this.tbY, ((b.a)paramb).dtq, ((FinderItem.b)localObject).sbY, "VideoShowPercentage#" + ((FinderItem.b)localObject).syo);
              break;
              i = 0;
              break label446;
            }
            FinderHotRelatedUIC.a(this.tbY, ((b.a)paramb).dtq, ((FinderItem.b)localObject).sbY, "VideoShowPercentage#" + ((FinderItem.b)localObject).sym);
            AppMethodBeat.o(205602);
            return;
            label655:
            if ((n.e((CharSequence)((FinderItem.b)localObject).syp, (CharSequence)"&&")) && (j >= ((FinderItem.b)localObject).sym) && (((b.a)paramb).offset >= ((FinderItem.b)localObject).syl) && (((FinderItem.b)localObject).sym > 0) && (((FinderItem.b)localObject).syl > 0)) {
              FinderHotRelatedUIC.a(this.tbY, ((b.a)paramb).dtq, ((FinderItem.b)localObject).sbY, "VideoShowPercentage#" + ((FinderItem.b)localObject).sym);
            }
            AppMethodBeat.o(205602);
            return;
          }
          AppMethodBeat.o(205602);
          return;
        }
        if ((paramb instanceof a.a))
        {
          i = ((a.a)paramb).type;
          localObject = a.a.rQr;
          if (i == a.a.czg())
          {
            localObject = com.tencent.mm.plugin.finder.storage.data.g.szT;
            localObject = com.tencent.mm.plugin.finder.storage.data.g.wX(((a.a)paramb).dtq);
            if (localObject != null)
            {
              FinderHotRelatedUIC.a(this.tbY, ((a.a)paramb).dtq, ((FinderItem.b)localObject).sbY, "SHARE_TO_SNS");
              AppMethodBeat.o(205602);
              return;
            }
            AppMethodBeat.o(205602);
            return;
          }
          localObject = a.a.rQr;
          if (i == a.a.czl())
          {
            localObject = com.tencent.mm.plugin.finder.storage.data.g.szT;
            localObject = com.tencent.mm.plugin.finder.storage.data.g.wX(((a.a)paramb).dtq);
            if (localObject != null)
            {
              FinderHotRelatedUIC.a(this.tbY, ((a.a)paramb).dtq, ((FinderItem.b)localObject).sbY, "LIKE");
              AppMethodBeat.o(205602);
              return;
            }
            AppMethodBeat.o(205602);
            return;
          }
          localObject = a.a.rQr;
          if (i == a.a.czo())
          {
            localObject = com.tencent.mm.plugin.finder.storage.data.g.szT;
            localObject = com.tencent.mm.plugin.finder.storage.data.g.wX(((a.a)paramb).dtq);
            if (localObject != null)
            {
              FinderHotRelatedUIC.a(this.tbY, ((a.a)paramb).dtq, ((FinderItem.b)localObject).sbY, "FAV");
              AppMethodBeat.o(205602);
              return;
            }
            AppMethodBeat.o(205602);
            return;
          }
          localObject = a.a.rQr;
          if (i == a.a.czf())
          {
            localObject = com.tencent.mm.plugin.finder.storage.data.g.szT;
            localObject = com.tencent.mm.plugin.finder.storage.data.g.wX(((a.a)paramb).dtq);
            if (localObject != null)
            {
              FinderHotRelatedUIC.a(this.tbY, ((a.a)paramb).dtq, ((FinderItem.b)localObject).sbY, "SHARE_TO_CHAT");
              AppMethodBeat.o(205602);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(205602);
    }
    
    public final boolean cyW()
    {
      return false;
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1$onEventHappen$1$1"})
    static final class a
      implements Runnable
    {
      a(FinderItem.b paramb, FinderHotRelatedUIC.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb1) {}
      
      public final void run()
      {
        AppMethodBeat.i(205600);
        FinderHotRelatedUIC.b(jdField_this.tbY, ((h)paramb).rRj, this.tca.sbY, "PhotoShowTime#" + this.tca.syl);
        AppMethodBeat.o(205600);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1$onEventHappen$1$2"})
    static final class b
      implements Runnable
    {
      b(FinderItem.b paramb, FinderHotRelatedUIC.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb1) {}
      
      public final void run()
      {
        AppMethodBeat.i(205601);
        FinderHotRelatedUIC.a(jdField_this.tbY, ((h)paramb).rRj, this.tca.sbY, "PhotoShowTime#" + this.tca.syl);
        AppMethodBeat.o(205601);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<FinderTimelineUIC>
  {
    d(Fragment paramFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderHotRelatedUIC
 * JD-Core Version:    0.7.0.1
 */