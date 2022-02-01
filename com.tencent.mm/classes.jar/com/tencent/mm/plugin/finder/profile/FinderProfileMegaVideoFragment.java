package com.tencent.mm.plugin.finder.profile;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hu;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.a.a;
import com.tencent.mm.plugin.finder.megavideo.ui.a.b;
import com.tencent.mm.plugin.finder.megavideo.ui.d.a;
import com.tencent.mm.plugin.finder.megavideo.ui.d.b;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/FinderProfileMegaVideoFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseMegaVideoFeedFragment;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter;", "()V", "feedLoader", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;)V", "presenter", "targetUsername", "", "kotlin.jvm.PlatformType", "getTargetUsername", "()Ljava/lang/String;", "targetUsername$delegate", "Lkotlin/Lazy;", "viewCallback", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initOnCreate", "", "Companion", "plugin-finder_release"})
public final class FinderProfileMegaVideoFragment
  extends FinderBaseMegaVideoFeedFragment<FinderMegaVideoProfileLoader, d.b, d.a>
{
  public static final a zPF;
  private HashMap _$_findViewCache;
  private d.b zPC;
  public FinderMegaVideoProfileLoader zPD;
  private final f zPE;
  private d.a zwi;
  
  static
  {
    AppMethodBeat.i(280403);
    zPF = new a((byte)0);
    AppMethodBeat.o(280403);
  }
  
  public FinderProfileMegaVideoFragment()
  {
    AppMethodBeat.i(280402);
    this.zPE = kotlin.g.ar((a)new d(this));
    this.fEH = 105;
    AppMethodBeat.o(280402);
  }
  
  private final String dNe()
  {
    AppMethodBeat.i(280398);
    String str = (String)this.zPE.getValue();
    AppMethodBeat.o(280398);
    return str;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(280405);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(280405);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_mega_video_profile_feed_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(280399);
    Object localObject1 = dNe();
    p.j(localObject1, "targetUsername");
    Object localObject2 = com.tencent.mm.ui.component.g.Xox;
    localObject1 = new FinderMegaVideoProfileLoader((String)localObject1, ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)ebI()).i(aj.class)).ekY());
    ((FinderMegaVideoProfileLoader)localObject1).zwH = true;
    ((FinderMegaVideoProfileLoader)localObject1).setInitDone((j)new b(this));
    ((BaseMegaVideoLoader)localObject1).fetchEndCallback = ((b)new c(this));
    this.zPD = ((FinderMegaVideoProfileLoader)localObject1);
    localObject1 = (MMActivity)ebI();
    localObject2 = this.zPD;
    if (localObject2 == null) {
      p.bGy("feedLoader");
    }
    this.zwi = new d.a((MMActivity)localObject1, (FinderMegaVideoProfileLoader)localObject2);
    localObject1 = (MMActivity)ebI();
    localObject2 = getView();
    if (localObject2 == null) {
      p.iCn();
    }
    p.j(localObject2, "view!!");
    String str = dNe();
    p.j(str, "targetUsername");
    this.zPC = new d.b((MMActivity)localObject1, (View)localObject2, str);
    localObject1 = this.zPC;
    if (localObject1 == null) {
      p.bGy("viewCallback");
    }
    localObject2 = this.zwi;
    if (localObject2 == null) {
      p.bGy("presenter");
    }
    ((d.b)localObject1).a((a.a)localObject2);
    AppMethodBeat.o(280399);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/FinderProfileMegaVideoFragment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/FinderProfileMegaVideoFragment$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class b
    implements j
  {
    b(FinderProfileMegaVideoFragment paramFinderProfileMegaVideoFragment) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(279050);
      Object localObject = FinderProfileMegaVideoFragment.a(this.zPG);
      if (localObject != null)
      {
        localObject = ((d.b)localObject).getEmptyView();
        if (localObject != null)
        {
          ((View)localObject).setVisibility(8);
          localObject = FinderProfileMegaVideoFragment.a(this.zPG);
          if (localObject != null)
          {
            localObject = ((a.b)localObject).xvJ.getRecyclerView();
            if (localObject != null) {
              ((RecyclerView)localObject).setVisibility(0);
            }
          }
          EventCenter.instance.publish((IEvent)new hu());
          AppMethodBeat.o(279050);
          return;
        }
      }
      AppMethodBeat.o(279050);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/profile/FinderProfileMegaVideoFragment$initOnCreate$1$2"})
  static final class c
    extends q
    implements b<IResponse<bu>, x>
  {
    c(FinderProfileMegaVideoFragment paramFinderProfileMegaVideoFragment)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements a<String>
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