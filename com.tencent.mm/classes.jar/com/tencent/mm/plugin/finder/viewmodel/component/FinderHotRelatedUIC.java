package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gv;
import com.tencent.mm.plugin.finder.event.b.a;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.component.SimpleUIComponent;
import com.tencent.mm.ui.component.UIComponent;
import d.g;
import d.g.b.u;
import d.g.b.w;
import d.n.n;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "contactChangeListener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$contactChangeListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$contactChangeListener$1;", "observer", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1;", "timelineUIC", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "getTimelineUIC", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "timelineUIC$delegate", "Lkotlin/Lazy;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "doFetchRelatedFeed", "", "feedId", "", "maxUnreadCount", "", "source", "", "isPrefetch", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public final class FinderHotRelatedUIC
  extends UIComponent
{
  private static boolean Liw;
  public static final a Lix;
  private final c Lit;
  private final b Liu;
  final d.f Liv;
  private final ap gAC;
  
  static
  {
    AppMethodBeat.i(200431);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(FinderHotRelatedUIC.class), "timelineUIC", "getTimelineUIC()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;")) };
    Lix = new a((byte)0);
    Liw = true;
    AppMethodBeat.o(200431);
  }
  
  public FinderHotRelatedUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(200440);
    this.gAC = new ap(Looper.getMainLooper());
    this.Lit = new c(this);
    this.Liu = new b(this);
    this.Liv = g.E((d.g.a.a)new d(paramFragment));
    AppMethodBeat.o(200440);
  }
  
  private final void c(long paramLong, int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(200438);
    Fragment localFragment = this.fragment;
    if (localFragment != null)
    {
      if (!paramBoolean)
      {
        locali = com.tencent.mm.plugin.finder.storage.data.i.KXv;
        if (com.tencent.mm.plugin.finder.storage.data.i.BU(paramLong)) {}
      }
      else
      {
        if (!paramBoolean) {
          break label190;
        }
        locali = com.tencent.mm.plugin.finder.storage.data.i.KXv;
        if (!com.tencent.mm.plugin.finder.storage.data.i.BV(paramLong)) {
          break label190;
        }
        locali = com.tencent.mm.plugin.finder.storage.data.i.KXv;
        if (!com.tencent.mm.plugin.finder.storage.data.i.BU(paramLong)) {
          break label190;
        }
      }
      paramString = new StringBuilder("[doFetchRelatedFeed] ").append(com.tencent.mm.ad.c.ly(paramLong)).append(" maxUnreadCount=").append(paramInt).append(" isPrefetch=").append(paramBoolean).append(" source=").append(paramString).append(" config=");
      com.tencent.mm.plugin.finder.storage.data.i locali = com.tencent.mm.plugin.finder.storage.data.i.KXv;
      ad.i("Finder.HotRelatedUIC", com.tencent.mm.plugin.finder.storage.data.i.BT(paramLong));
      paramString = com.tencent.mm.ui.component.a.LCX;
      ((FinderTimelineUIC)com.tencent.mm.ui.component.a.of(localFragment).get(FinderTimelineUIC.class)).i(paramLong, paramInt, paramBoolean);
      if (!paramBoolean)
      {
        paramString = com.tencent.mm.plugin.finder.storage.data.i.KXv;
        com.tencent.mm.plugin.finder.storage.data.i.BW(paramLong);
        AppMethodBeat.o(200438);
        return;
      }
      paramString = com.tencent.mm.plugin.finder.storage.data.i.KXv;
      com.tencent.mm.plugin.finder.storage.data.i.BY(paramLong);
      label190:
      AppMethodBeat.o(200438);
      return;
    }
    AppMethodBeat.o(200438);
  }
  
  public final void fTo()
  {
    AppMethodBeat.i(200435);
    super.fTo();
    this.Liu.alive();
    AppMethodBeat.o(200435);
  }
  
  public final void fXn()
  {
    AppMethodBeat.i(200436);
    super.fXn();
    this.Liu.dead();
    this.gAC.removeCallbacksAndMessages(null);
    AppMethodBeat.o(200436);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(200432);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.ui.component.a.LCX;
    paramBundle = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(getActivity()).get(FinderReporterUIC.class)).ahZ(4);
    if (paramBundle == null) {
      ad.e("Finder.HotRelatedUIC", "[onCreate] eventDispatcher is null");
    }
    if (paramBundle != null)
    {
      paramBundle.a((com.tencent.mm.plugin.finder.event.base.f)this.Lit);
      AppMethodBeat.o(200432);
      return;
    }
    AppMethodBeat.o(200432);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(200437);
    super.onDestroy();
    this.Liu.dead();
    this.gAC.removeCallbacksAndMessages(null);
    AppMethodBeat.o(200437);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(200433);
    super.onPause();
    this.gAC.removeCallbacksAndMessages(null);
    AppMethodBeat.o(200433);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(200434);
    super.onResume();
    AppMethodBeat.o(200434);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$Companion;", "", "()V", "TAG", "", "isEnableAutoGetRelated", "", "()Z", "setEnableAutoGetRelated", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$contactChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.sdk.b.c<gv>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "lastCenterId", "", "isAsync", "", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.plugin.finder.event.base.f
  {
    private long Liz;
    
    public final void a(final com.tencent.mm.plugin.finder.event.base.c paramc)
    {
      AppMethodBeat.i(200429);
      d.g.b.k.h(paramc, "event");
      Object localObject;
      if ((paramc instanceof com.tencent.mm.plugin.finder.event.base.i))
      {
        localObject = FinderHotRelatedUIC.Lix;
        if (!FinderHotRelatedUIC.fXo())
        {
          AppMethodBeat.o(200429);
          return;
        }
        if (this.Liz != ((com.tencent.mm.plugin.finder.event.base.i)paramc).qsk)
        {
          FinderHotRelatedUIC.a(this.Liy).removeCallbacksAndMessages(null);
          localObject = ((com.tencent.mm.plugin.finder.event.base.i)paramc).qsl;
          if (localObject != null)
          {
            localObject = ((BaseFinderFeed)localObject).feedObject;
            if ((localObject != null) && (((FinderItem)localObject).getMediaType() == 2))
            {
              localObject = com.tencent.mm.plugin.finder.storage.data.i.KXv;
              localObject = com.tencent.mm.plugin.finder.storage.data.i.BT(((com.tencent.mm.plugin.finder.event.base.i)paramc).qsk);
              if (localObject != null)
              {
                if ((((FinderItem.c)localObject).KWE > 0) && (((FinderItem.c)localObject).KWE < ((FinderItem.c)localObject).FUF)) {
                  FinderHotRelatedUIC.a(this.Liy).postDelayed((Runnable)new a((FinderItem.c)localObject, this, paramc), ((FinderItem.c)localObject).KWE * 1000L);
                }
                if (((FinderItem.c)localObject).FUF > 0) {
                  FinderHotRelatedUIC.a(this.Liy).postDelayed((Runnable)new b((FinderItem.c)localObject, this, paramc), ((FinderItem.c)localObject).FUF * 1000L);
                }
              }
            }
          }
          this.Liz = ((com.tencent.mm.plugin.finder.event.base.i)paramc).qsk;
          AppMethodBeat.o(200429);
        }
      }
      else
      {
        int i;
        if ((paramc instanceof b.a))
        {
          localObject = FinderHotRelatedUIC.Lix;
          if (!FinderHotRelatedUIC.fXo())
          {
            AppMethodBeat.o(200429);
            return;
          }
          switch (((b.a)paramc).type)
          {
          }
          do
          {
            AppMethodBeat.o(200429);
            return;
            localObject = com.tencent.mm.plugin.finder.storage.data.i.KXv;
            localObject = com.tencent.mm.plugin.finder.storage.data.i.BT(((b.a)paramc).feedId);
          } while (localObject == null);
          int j = (int)(100.0F * ((b.a)paramc).offset / ((b.a)paramc).hlk);
          if ((((FinderItem.c)localObject).KWE > 0) && (((b.a)paramc).offset >= ((FinderItem.c)localObject).KWE) && (((FinderItem.c)localObject).KWE < ((FinderItem.c)localObject).FUF))
          {
            FinderHotRelatedUIC.b(this.Liy, ((b.a)paramc).feedId, ((FinderItem.c)localObject).KQu, "VideoShowTime#" + ((FinderItem.c)localObject).KWE);
            if (!n.f((CharSequence)((FinderItem.c)localObject).KWG, (CharSequence)"||"))
            {
              if (((CharSequence)((FinderItem.c)localObject).KWG).length() != 0) {
                break label600;
              }
              i = 1;
              label446:
              if (i == 0) {
                break label655;
              }
            }
            i = ((FinderItem.c)localObject).KWD;
            if (1 <= i) {
              break label605;
            }
          }
          label600:
          label605:
          while (j < i)
          {
            if ((((b.a)paramc).offset >= ((FinderItem.c)localObject).FUF) && (((FinderItem.c)localObject).FUF > 0)) {
              FinderHotRelatedUIC.a(this.Liy, ((b.a)paramc).feedId, ((FinderItem.c)localObject).KQu, "VideoShowTime#" + ((FinderItem.c)localObject).FUF);
            }
            AppMethodBeat.o(200429);
            return;
            i = ((FinderItem.c)localObject).KWF;
            if ((1 > i) || (j < i) || (((FinderItem.c)localObject).KWF >= ((FinderItem.c)localObject).KWD)) {
              break;
            }
            FinderHotRelatedUIC.b(this.Liy, ((b.a)paramc).feedId, ((FinderItem.c)localObject).KQu, "VideoShowPercentage#" + ((FinderItem.c)localObject).KWF);
            break;
            i = 0;
            break label446;
          }
          FinderHotRelatedUIC.a(this.Liy, ((b.a)paramc).feedId, ((FinderItem.c)localObject).KQu, "VideoShowPercentage#" + ((FinderItem.c)localObject).KWD);
          AppMethodBeat.o(200429);
          return;
          label655:
          if ((n.f((CharSequence)((FinderItem.c)localObject).KWG, (CharSequence)"&&")) && (j >= ((FinderItem.c)localObject).KWD) && (((b.a)paramc).offset >= ((FinderItem.c)localObject).FUF) && (((FinderItem.c)localObject).KWD > 0) && (((FinderItem.c)localObject).FUF > 0)) {
            FinderHotRelatedUIC.a(this.Liy, ((b.a)paramc).feedId, ((FinderItem.c)localObject).KQu, "VideoShowPercentage#" + ((FinderItem.c)localObject).KWD);
          }
          AppMethodBeat.o(200429);
          return;
        }
        if ((paramc instanceof c.a))
        {
          i = ((c.a)paramc).type;
          localObject = c.a.KLX;
          if (i == c.a.fSn())
          {
            localObject = com.tencent.mm.plugin.finder.storage.data.i.KXv;
            localObject = com.tencent.mm.plugin.finder.storage.data.i.BT(((c.a)paramc).feedId);
            if (localObject != null)
            {
              FinderHotRelatedUIC.a(this.Liy, ((c.a)paramc).feedId, ((FinderItem.c)localObject).KQu, "SHARE_TO_SNS");
              AppMethodBeat.o(200429);
              return;
            }
            AppMethodBeat.o(200429);
            return;
          }
          localObject = c.a.KLX;
          if (i == c.a.fSs())
          {
            localObject = com.tencent.mm.plugin.finder.storage.data.i.KXv;
            localObject = com.tencent.mm.plugin.finder.storage.data.i.BT(((c.a)paramc).feedId);
            if (localObject != null)
            {
              FinderHotRelatedUIC.a(this.Liy, ((c.a)paramc).feedId, ((FinderItem.c)localObject).KQu, "LIKE");
              AppMethodBeat.o(200429);
              return;
            }
            AppMethodBeat.o(200429);
            return;
          }
          localObject = c.a.KLX;
          if (i == c.a.fSv())
          {
            localObject = com.tencent.mm.plugin.finder.storage.data.i.KXv;
            localObject = com.tencent.mm.plugin.finder.storage.data.i.BT(((c.a)paramc).feedId);
            if (localObject != null)
            {
              FinderHotRelatedUIC.a(this.Liy, ((c.a)paramc).feedId, ((FinderItem.c)localObject).KQu, "FAV");
              AppMethodBeat.o(200429);
              return;
            }
            AppMethodBeat.o(200429);
            return;
          }
          localObject = c.a.KLX;
          if (i == c.a.fSm())
          {
            localObject = com.tencent.mm.plugin.finder.storage.data.i.KXv;
            localObject = com.tencent.mm.plugin.finder.storage.data.i.BT(((c.a)paramc).feedId);
            if (localObject != null)
            {
              FinderHotRelatedUIC.a(this.Liy, ((c.a)paramc).feedId, ((FinderItem.c)localObject).KQu, "SHARE_TO_CHAT");
              AppMethodBeat.o(200429);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(200429);
    }
    
    public final boolean clc()
    {
      return false;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1$onEventHappen$1$1"})
    static final class a
      implements Runnable
    {
      a(FinderItem.c paramc, FinderHotRelatedUIC.c paramc1, com.tencent.mm.plugin.finder.event.base.c paramc2) {}
      
      public final void run()
      {
        AppMethodBeat.i(200427);
        FinderHotRelatedUIC.b(jdField_this.Liy, ((com.tencent.mm.plugin.finder.event.base.i)paramc).qsk, this.LiA.KQu, "PhotoShowTime#" + this.LiA.FUF);
        AppMethodBeat.o(200427);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHotRelatedUIC$observer$1$onEventHappen$1$2"})
    static final class b
      implements Runnable
    {
      b(FinderItem.c paramc, FinderHotRelatedUIC.c paramc1, com.tencent.mm.plugin.finder.event.base.c paramc2) {}
      
      public final void run()
      {
        AppMethodBeat.i(200428);
        FinderHotRelatedUIC.a(jdField_this.Liy, ((com.tencent.mm.plugin.finder.event.base.i)paramc).qsk, this.LiA.KQu, "PhotoShowTime#" + this.LiA.FUF);
        AppMethodBeat.o(200428);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderHotRelatedUIC
 * JD-Core Version:    0.7.0.1
 */