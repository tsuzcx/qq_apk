package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.plugin.finder.event.a.a;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.report.e;
import com.tencent.mm.plugin.finder.report.o;
import com.tencent.mm.plugin.finder.report.p.a;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem.b;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "contactChangeListener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$contactChangeListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$contactChangeListener$1;", "observer", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1;", "timelineUIC", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "getTimelineUIC", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "timelineUIC$delegate", "Lkotlin/Lazy;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "doFetchRelatedFeed", "", "feedId", "", "maxUnreadCount", "", "source", "", "isPrefetch", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public final class FinderHotRelatedUIC
  extends UIComponent
{
  private static boolean wxL;
  public static final a wxM;
  private final MMHandler hAk;
  private final c wxI;
  private final b wxJ;
  final f wxK;
  
  static
  {
    AppMethodBeat.i(255703);
    wxM = new a((byte)0);
    com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
    wxL = ((Boolean)com.tencent.mm.plugin.finder.storage.c.dtt().value()).booleanValue();
    AppMethodBeat.o(255703);
  }
  
  public FinderHotRelatedUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(255702);
    this.hAk = new MMHandler(Looper.getMainLooper());
    this.wxI = new c(this);
    this.wxJ = new b(this);
    this.wxK = g.ah((kotlin.g.a.a)new d(paramFragment));
    AppMethodBeat.o(255702);
  }
  
  private final void a(long paramLong, int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(255700);
    Fragment localFragment = getFragment();
    if (localFragment != null)
    {
      if (!paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.data.h.vGk;
        if (com.tencent.mm.plugin.finder.storage.data.h.FJ(paramLong)) {}
      }
      else
      {
        if (!paramBoolean) {
          break label911;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.data.h.vGk;
        if (!com.tencent.mm.plugin.finder.storage.data.h.FK(paramLong)) {
          break label911;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.data.h.vGk;
        if (!com.tencent.mm.plugin.finder.storage.data.h.FJ(paramLong)) {
          break label911;
        }
      }
      atn localatn = new atn();
      Object localObject1 = com.tencent.mm.ui.component.a.PRN;
      localObject1 = localFragment.getActivity();
      if (localObject1 == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(255700);
        throw paramString;
      }
      Object localObject2 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)localObject1).get(FinderReporterUIC.class)).MB(4);
      if (localObject2 != null)
      {
        localObject1 = o.vfN;
        Object localObject3 = o.doh();
        if (localObject3 == null) {
          break label878;
        }
        localObject1 = new com.tencent.mm.plugin.finder.report.p(((com.tencent.mm.plugin.finder.report.p)localObject3).feedId, ((com.tencent.mm.plugin.finder.report.p)localObject3).startTime, ((com.tencent.mm.plugin.finder.report.p)localObject3).tHo, ((com.tencent.mm.plugin.finder.report.p)localObject3).tIw, ((com.tencent.mm.plugin.finder.report.p)localObject3).vgz, ((com.tencent.mm.plugin.finder.report.p)localObject3).vdR, null, 64);
        ((com.tencent.mm.plugin.finder.report.p)localObject1).uOV = ((com.tencent.mm.plugin.finder.report.p)localObject3).uOV;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vfP = ((com.tencent.mm.plugin.finder.report.p)localObject3).vfP;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).endTime = ((com.tencent.mm.plugin.finder.report.p)localObject3).endTime;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vfQ = ((com.tencent.mm.plugin.finder.report.p)localObject3).vfQ;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vfR = ((com.tencent.mm.plugin.finder.report.p)localObject3).vfR;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vfS = ((com.tencent.mm.plugin.finder.report.p)localObject3).vfS;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vfT = ((com.tencent.mm.plugin.finder.report.p)localObject3).vfT;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vfU = ((com.tencent.mm.plugin.finder.report.p)localObject3).vfU;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vfV = ((com.tencent.mm.plugin.finder.report.p)localObject3).vfV;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vfW = ((com.tencent.mm.plugin.finder.report.p)localObject3).vfW;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vfX = ((com.tencent.mm.plugin.finder.report.p)localObject3).vfX;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vfY = ((com.tencent.mm.plugin.finder.report.p)localObject3).vfY;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).msj = ((com.tencent.mm.plugin.finder.report.p)localObject3).msj;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vfZ = ((com.tencent.mm.plugin.finder.report.p)localObject3).vfZ;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vga = ((com.tencent.mm.plugin.finder.report.p)localObject3).vga;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vgb = ((com.tencent.mm.plugin.finder.report.p)localObject3).vgb;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vgc = ((com.tencent.mm.plugin.finder.report.p)localObject3).vgc;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vgd = ((com.tencent.mm.plugin.finder.report.p)localObject3).vgd;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vge = ((com.tencent.mm.plugin.finder.report.p)localObject3).vge;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vgf = ((com.tencent.mm.plugin.finder.report.p)localObject3).vgf;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vgg = ((com.tencent.mm.plugin.finder.report.p)localObject3).vgg;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vgh = ((com.tencent.mm.plugin.finder.report.p)localObject3).vgh;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vgj = ((com.tencent.mm.plugin.finder.report.p)localObject3).vgj;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vgk = ((com.tencent.mm.plugin.finder.report.p)localObject3).vgk;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vgl = ((com.tencent.mm.plugin.finder.report.p)localObject3).vgl;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vgm = ((com.tencent.mm.plugin.finder.report.p)localObject3).vgm;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vgn = ((com.tencent.mm.plugin.finder.report.p)localObject3).vgn;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vgo = ((com.tencent.mm.plugin.finder.report.p)localObject3).vgo;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vgp = ((com.tencent.mm.plugin.finder.report.p)localObject3).vgp;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).dUy = ((com.tencent.mm.plugin.finder.report.p)localObject3).dUy;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vgq = ((com.tencent.mm.plugin.finder.report.p)localObject3).vgq;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vgr = ((com.tencent.mm.plugin.finder.report.p)localObject3).vgr;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vgs = ((com.tencent.mm.plugin.finder.report.p)localObject3).vgs;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vgt = ((com.tencent.mm.plugin.finder.report.p)localObject3).vgt;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vgu = ((com.tencent.mm.plugin.finder.report.p)localObject3).vgu;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vgv = ((com.tencent.mm.plugin.finder.report.p)localObject3).vgv;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).vgw = ((com.tencent.mm.plugin.finder.report.p)localObject3).vgw;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).netType = ((com.tencent.mm.plugin.finder.report.p)localObject3).netType;
        ((com.tencent.mm.plugin.finder.report.p)localObject1).videoDuration = ((com.tencent.mm.plugin.finder.report.p)localObject3).videoDuration;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.finder.report.p)localObject1).a(((e)localObject2).vdR);
          localObject3 = com.tencent.mm.plugin.finder.report.p.vgC;
          localatn.tVf = p.a.a((com.tencent.mm.plugin.finder.report.p)localObject1, ((e)localObject2).ttO);
          localObject1 = com.tencent.mm.plugin.finder.storage.data.h.vGk;
          localObject1 = com.tencent.mm.plugin.finder.storage.data.h.FI(paramLong);
          if (localObject1 == null) {
            break label884;
          }
          localObject1 = ((FinderItem.b)localObject1).lEd;
          label642:
          localatn.LEo = ((String)localObject1);
        }
      }
      localObject1 = localatn.tVf;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.report.p.vgC;
        kotlin.g.b.p.g(localObject1, "it");
        p.a.a((ecq)localObject1, "Finder.HotRelatedUIC");
      }
      paramString = new StringBuilder("[doFetchRelatedFeed] ").append(com.tencent.mm.ac.d.zs(paramLong)).append(" maxUnreadCount=").append(paramInt).append(" isPrefetch=").append(paramBoolean).append(" source=").append(paramString).append(' ').append("config=");
      localObject1 = com.tencent.mm.plugin.finder.storage.data.h.vGk;
      localObject1 = paramString.append(com.tencent.mm.plugin.finder.storage.data.h.FI(paramLong)).append(", stats=");
      paramString = localatn.tVf;
      if (paramString != null)
      {
        paramString = Long.valueOf(paramString.hFK);
        label788:
        paramString = ((StringBuilder)localObject1).append(paramString).append(", pos_trigger_config=");
        if (localatn.LEo == null) {
          break label896;
        }
      }
      label896:
      for (boolean bool = true;; bool = false)
      {
        Log.i("Finder.HotRelatedUIC", bool);
        paramString = com.tencent.mm.ui.component.a.PRN;
        ((FinderTimelineUIC)com.tencent.mm.ui.component.a.of(localFragment).get(FinderTimelineUIC.class)).a(paramLong, paramInt, paramBoolean, localatn);
        if (paramBoolean) {
          break label902;
        }
        paramString = com.tencent.mm.plugin.finder.storage.data.h.vGk;
        com.tencent.mm.plugin.finder.storage.data.h.FL(paramLong);
        AppMethodBeat.o(255700);
        return;
        label878:
        localObject1 = null;
        break;
        label884:
        localObject1 = null;
        break label642;
        paramString = null;
        break label788;
      }
      label902:
      paramString = com.tencent.mm.plugin.finder.storage.data.h.vGk;
      com.tencent.mm.plugin.finder.storage.data.h.FN(paramLong);
      label911:
      AppMethodBeat.o(255700);
      return;
    }
    AppMethodBeat.o(255700);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255694);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.ui.component.a.PRN;
    paramBundle = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).MF(4);
    if (paramBundle == null) {
      Log.e("Finder.HotRelatedUIC", "[onCreate] eventDispatcher is null");
    }
    if (paramBundle != null)
    {
      paramBundle.a((com.tencent.mm.plugin.finder.event.base.d)this.wxI);
      AppMethodBeat.o(255694);
      return;
    }
    AppMethodBeat.o(255694);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(255699);
    super.onDestroy();
    this.wxJ.dead();
    this.hAk.removeCallbacksAndMessages(null);
    AppMethodBeat.o(255699);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(255695);
    super.onPause();
    this.hAk.removeCallbacksAndMessages(null);
    AppMethodBeat.o(255695);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(255696);
    super.onResume();
    AppMethodBeat.o(255696);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(255697);
    super.onUserVisibleFocused();
    this.wxJ.alive();
    AppMethodBeat.o(255697);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(255698);
    super.onUserVisibleUnFocused();
    this.wxJ.dead();
    this.hAk.removeCallbacksAndMessages(null);
    AppMethodBeat.o(255698);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$Companion;", "", "()V", "TAG", "", "isEnableAutoGetRelated", "", "()Z", "setEnableAutoGetRelated", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$contactChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends IListener<hf>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "lastCenterId", "", "isAsync", "", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    private long wxO;
    
    public final void a(final b paramb)
    {
      AppMethodBeat.i(255692);
      kotlin.g.b.p.h(paramb, "event");
      Object localObject;
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
      {
        localObject = FinderHotRelatedUIC.wxM;
        if (!FinderHotRelatedUIC.dIj())
        {
          AppMethodBeat.o(255692);
          return;
        }
        if (this.wxO != ((com.tencent.mm.plugin.finder.event.base.h)paramb).tIC)
        {
          FinderHotRelatedUIC.a(this.wxN).removeCallbacksAndMessages(null);
          localObject = ((com.tencent.mm.plugin.finder.event.base.h)paramb).tIF;
          if ((localObject != null) && (((FeedData)localObject).getMediaType() == 2))
          {
            localObject = com.tencent.mm.plugin.finder.storage.data.h.vGk;
            localObject = com.tencent.mm.plugin.finder.storage.data.h.FI(((com.tencent.mm.plugin.finder.event.base.h)paramb).tIC);
            if (localObject != null)
            {
              if ((((FinderItem.b)localObject).vDQ > 0) && (((FinderItem.b)localObject).vDQ < ((FinderItem.b)localObject).vDO)) {
                FinderHotRelatedUIC.a(this.wxN).postDelayed((Runnable)new a((FinderItem.b)localObject, this, paramb), ((FinderItem.b)localObject).vDQ * 1000L);
              }
              if (((FinderItem.b)localObject).vDO > 0) {
                FinderHotRelatedUIC.a(this.wxN).postDelayed((Runnable)new b((FinderItem.b)localObject, this, paramb), ((FinderItem.b)localObject).vDO * 1000L);
              }
            }
          }
          this.wxO = ((com.tencent.mm.plugin.finder.event.base.h)paramb).tIC;
          AppMethodBeat.o(255692);
        }
      }
      else
      {
        int i;
        if ((paramb instanceof c.a))
        {
          localObject = FinderHotRelatedUIC.wxM;
          if (!FinderHotRelatedUIC.dIj())
          {
            AppMethodBeat.o(255692);
            return;
          }
          switch (((c.a)paramb).type)
          {
          default: 
            AppMethodBeat.o(255692);
            return;
          }
          localObject = com.tencent.mm.plugin.finder.storage.data.h.vGk;
          localObject = com.tencent.mm.plugin.finder.storage.data.h.FI(((c.a)paramb).feedId);
          if (localObject != null)
          {
            int j = (int)(100.0F * ((c.a)paramb).offset / ((c.a)paramb).jcu);
            if ((((FinderItem.b)localObject).vDQ > 0) && (((c.a)paramb).offset >= ((FinderItem.b)localObject).vDQ) && (((FinderItem.b)localObject).vDQ < ((FinderItem.b)localObject).vDO))
            {
              FinderHotRelatedUIC.b(this.wxN, ((c.a)paramb).feedId, ((FinderItem.b)localObject).tXx, "VideoShowTime#" + ((FinderItem.b)localObject).vDQ);
              if (!n.e((CharSequence)((FinderItem.b)localObject).vDS, (CharSequence)"||"))
              {
                if (((CharSequence)((FinderItem.b)localObject).vDS).length() != 0) {
                  break label588;
                }
                i = 1;
                label434:
                if (i == 0) {
                  break label643;
                }
              }
              i = ((FinderItem.b)localObject).vDP;
              if (1 <= i) {
                break label593;
              }
            }
            label588:
            label593:
            while (j < i)
            {
              if ((((c.a)paramb).offset >= ((FinderItem.b)localObject).vDO) && (((FinderItem.b)localObject).vDO > 0)) {
                FinderHotRelatedUIC.a(this.wxN, ((c.a)paramb).feedId, ((FinderItem.b)localObject).tXx, "VideoShowTime#" + ((FinderItem.b)localObject).vDO);
              }
              AppMethodBeat.o(255692);
              return;
              i = ((FinderItem.b)localObject).vDR;
              if ((1 > i) || (j < i) || (((FinderItem.b)localObject).vDR >= ((FinderItem.b)localObject).vDP)) {
                break;
              }
              FinderHotRelatedUIC.b(this.wxN, ((c.a)paramb).feedId, ((FinderItem.b)localObject).tXx, "VideoShowPercentage#" + ((FinderItem.b)localObject).vDR);
              break;
              i = 0;
              break label434;
            }
            FinderHotRelatedUIC.a(this.wxN, ((c.a)paramb).feedId, ((FinderItem.b)localObject).tXx, "VideoShowPercentage#" + ((FinderItem.b)localObject).vDP);
            AppMethodBeat.o(255692);
            return;
            label643:
            if ((n.e((CharSequence)((FinderItem.b)localObject).vDS, (CharSequence)"&&")) && (j >= ((FinderItem.b)localObject).vDP) && (((c.a)paramb).offset >= ((FinderItem.b)localObject).vDO) && (((FinderItem.b)localObject).vDP > 0) && (((FinderItem.b)localObject).vDO > 0)) {
              FinderHotRelatedUIC.a(this.wxN, ((c.a)paramb).feedId, ((FinderItem.b)localObject).tXx, "VideoShowPercentage#" + ((FinderItem.b)localObject).vDP);
            }
            AppMethodBeat.o(255692);
            return;
          }
          AppMethodBeat.o(255692);
          return;
        }
        if ((paramb instanceof a.a))
        {
          i = ((a.a)paramb).type;
          localObject = a.a.tHJ;
          if (i == a.a.cZT())
          {
            localObject = com.tencent.mm.plugin.finder.storage.data.h.vGk;
            localObject = com.tencent.mm.plugin.finder.storage.data.h.FI(((a.a)paramb).feedId);
            if (localObject != null)
            {
              FinderHotRelatedUIC.a(this.wxN, ((a.a)paramb).feedId, ((FinderItem.b)localObject).tXx, "SHARE_TO_SNS");
              AppMethodBeat.o(255692);
              return;
            }
            AppMethodBeat.o(255692);
            return;
          }
          localObject = a.a.tHJ;
          if (i == a.a.cZY())
          {
            localObject = com.tencent.mm.plugin.finder.storage.data.h.vGk;
            localObject = com.tencent.mm.plugin.finder.storage.data.h.FI(((a.a)paramb).feedId);
            if (localObject != null)
            {
              FinderHotRelatedUIC.a(this.wxN, ((a.a)paramb).feedId, ((FinderItem.b)localObject).tXx, "LIKE");
              AppMethodBeat.o(255692);
              return;
            }
            AppMethodBeat.o(255692);
            return;
          }
          localObject = a.a.tHJ;
          if (i == a.a.dab())
          {
            localObject = com.tencent.mm.plugin.finder.storage.data.h.vGk;
            localObject = com.tencent.mm.plugin.finder.storage.data.h.FI(((a.a)paramb).feedId);
            if (localObject != null)
            {
              FinderHotRelatedUIC.a(this.wxN, ((a.a)paramb).feedId, ((FinderItem.b)localObject).tXx, "FAV");
              AppMethodBeat.o(255692);
              return;
            }
            AppMethodBeat.o(255692);
            return;
          }
          localObject = a.a.tHJ;
          if (i == a.a.cZS())
          {
            localObject = com.tencent.mm.plugin.finder.storage.data.h.vGk;
            localObject = com.tencent.mm.plugin.finder.storage.data.h.FI(((a.a)paramb).feedId);
            if (localObject != null)
            {
              FinderHotRelatedUIC.a(this.wxN, ((a.a)paramb).feedId, ((FinderItem.b)localObject).tXx, "SHARE_TO_CHAT");
              AppMethodBeat.o(255692);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(255692);
    }
    
    public final boolean cZD()
    {
      return false;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1$onEventHappen$1$1"})
    static final class a
      implements Runnable
    {
      a(FinderItem.b paramb, FinderHotRelatedUIC.c paramc, b paramb1) {}
      
      public final void run()
      {
        AppMethodBeat.i(255690);
        FinderHotRelatedUIC.b(jdField_this.wxN, ((com.tencent.mm.plugin.finder.event.base.h)paramb).tIC, this.wxP.tXx, "PhotoShowTime#" + this.wxP.vDO);
        AppMethodBeat.o(255690);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1$onEventHappen$1$2"})
    static final class b
      implements Runnable
    {
      b(FinderItem.b paramb, FinderHotRelatedUIC.c paramc, b paramb1) {}
      
      public final void run()
      {
        AppMethodBeat.i(255691);
        FinderHotRelatedUIC.a(jdField_this.wxN, ((com.tencent.mm.plugin.finder.event.base.h)paramb).tIC, this.wxP.tXx, "PhotoShowTime#" + this.wxP.vDO);
        AppMethodBeat.o(255691);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<FinderTimelineUIC>
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