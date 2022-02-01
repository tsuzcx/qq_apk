package com.tencent.mm.plugin.finder.profile;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.a.a;
import com.tencent.mm.plugin.finder.megavideo.ui.a.b;
import com.tencent.mm.plugin.finder.megavideo.ui.d.a;
import com.tencent.mm.plugin.finder.megavideo.ui.d.b;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/FinderProfileMegaVideoFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseMegaVideoFeedFragment;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter;", "()V", "feedLoader", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;)V", "presenter", "targetUsername", "", "kotlin.jvm.PlatformType", "getTargetUsername", "()Ljava/lang/String;", "targetUsername$delegate", "Lkotlin/Lazy;", "viewCallback", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initOnCreate", "", "Companion", "plugin-finder_release"})
public final class FinderProfileMegaVideoFragment
  extends FinderBaseMegaVideoFeedFragment<FinderMegaVideoProfileLoader, d.b, d.a>
{
  public static final a uZl;
  private HashMap _$_findViewCache;
  private d.a uKA;
  private d.b uZi;
  public FinderMegaVideoProfileLoader uZj;
  private final f uZk;
  
  static
  {
    AppMethodBeat.i(249988);
    uZl = new a((byte)0);
    AppMethodBeat.o(249988);
  }
  
  public FinderProfileMegaVideoFragment()
  {
    AppMethodBeat.i(249987);
    this.uZk = g.ah((kotlin.g.a.a)new d(this));
    this.dLS = 105;
    AppMethodBeat.o(249987);
  }
  
  private final String dlZ()
  {
    AppMethodBeat.i(249983);
    String str = (String)this.uZk.getValue();
    AppMethodBeat.o(249983);
    return str;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(249990);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(249990);
  }
  
  public final int getLayoutId()
  {
    return 2131494509;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(249984);
    Object localObject1 = dlZ();
    p.g(localObject1, "targetUsername");
    Object localObject2 = com.tencent.mm.ui.component.a.PRN;
    localObject1 = new FinderMegaVideoProfileLoader((String)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)dAq()).get(FinderReporterUIC.class)).dIx());
    ((FinderMegaVideoProfileLoader)localObject1).uKQ = true;
    ((FinderMegaVideoProfileLoader)localObject1).setInitDone((h)new b(this));
    ((BaseMegaVideoLoader)localObject1).fetchEndCallback = ((b)new c(this));
    this.uZj = ((FinderMegaVideoProfileLoader)localObject1);
    localObject1 = (MMActivity)dAq();
    localObject2 = this.uZj;
    if (localObject2 == null) {
      p.btv("feedLoader");
    }
    this.uKA = new d.a((MMActivity)localObject1, (FinderMegaVideoProfileLoader)localObject2);
    localObject1 = (MMActivity)dAq();
    localObject2 = getView();
    if (localObject2 == null) {
      p.hyc();
    }
    p.g(localObject2, "view!!");
    String str = dlZ();
    p.g(str, "targetUsername");
    this.uZi = new d.b((MMActivity)localObject1, (View)localObject2, str);
    localObject1 = this.uZi;
    if (localObject1 == null) {
      p.btv("viewCallback");
    }
    localObject2 = this.uKA;
    if (localObject2 == null) {
      p.btv("presenter");
    }
    ((d.b)localObject1).a((a.a)localObject2);
    AppMethodBeat.o(249984);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/FinderProfileMegaVideoFragment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/FinderProfileMegaVideoFragment$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class b
    implements h
  {
    b(FinderProfileMegaVideoFragment paramFinderProfileMegaVideoFragment) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(249980);
      Object localObject = FinderProfileMegaVideoFragment.a(this.uZm);
      if (localObject != null)
      {
        localObject = ((d.b)localObject).getEmptyView();
        if (localObject != null)
        {
          ((View)localObject).setVisibility(8);
          localObject = FinderProfileMegaVideoFragment.a(this.uZm);
          if (localObject != null)
          {
            localObject = ((a.b)localObject).tLS.getRecyclerView();
            if (localObject != null) {
              ((RecyclerView)localObject).setVisibility(0);
            }
          }
          EventCenter.instance.publish((IEvent)new hn());
          AppMethodBeat.o(249980);
          return;
        }
      }
      AppMethodBeat.o(249980);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/profile/FinderProfileMegaVideoFragment$initOnCreate$1$2"})
  static final class c
    extends q
    implements b<IResponse<bo>, x>
  {
    c(FinderProfileMegaVideoFragment paramFinderProfileMegaVideoFragment)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<String>
  {
    d(FinderProfileMegaVideoFragment paramFinderProfileMegaVideoFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.FinderProfileMegaVideoFragment
 * JD-Core Version:    0.7.0.1
 */