package com.tencent.mm.plugin.finder.profile;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.a.a;
import com.tencent.mm.plugin.finder.megavideo.ui.a.b;
import com.tencent.mm.plugin.finder.megavideo.ui.d.a;
import com.tencent.mm.plugin.finder.megavideo.ui.d.b;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/FinderProfileMegaVideoFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseMegaVideoFeedFragment;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter;", "()V", "feedLoader", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;)V", "presenter", "targetUsername", "", "getTargetUsername", "()Ljava/lang/String;", "targetUsername$delegate", "Lkotlin/Lazy;", "viewCallback", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initOnCreate", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderProfileMegaVideoFragment
  extends FinderBaseMegaVideoFeedFragment<FinderMegaVideoProfileLoader, d.b, d.a>
{
  public static final a EZX;
  private d.b EZY;
  public FinderMegaVideoProfileLoader EZZ;
  private d.a Ezx;
  private final kotlin.j Faa;
  
  static
  {
    AppMethodBeat.i(348318);
    EZX = new a((byte)0);
    AppMethodBeat.o(348318);
  }
  
  public FinderProfileMegaVideoFragment()
  {
    AppMethodBeat.i(348270);
    this.Faa = kotlin.k.cm((a)new d(this));
    this.hJx = 105;
    AppMethodBeat.o(348270);
  }
  
  private final String eeN()
  {
    AppMethodBeat.i(348290);
    String str = (String)this.Faa.getValue();
    AppMethodBeat.o(348290);
    return str;
  }
  
  public final FinderMegaVideoProfileLoader eIq()
  {
    AppMethodBeat.i(348337);
    FinderMegaVideoProfileLoader localFinderMegaVideoProfileLoader = this.EZZ;
    if (localFinderMegaVideoProfileLoader != null)
    {
      AppMethodBeat.o(348337);
      return localFinderMegaVideoProfileLoader;
    }
    s.bIx("feedLoader");
    AppMethodBeat.o(348337);
    return null;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_mega_video_profile_feed_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(348374);
    Object localObject1 = eeN();
    s.checkNotNull(localObject1);
    s.s(localObject1, "targetUsername!!");
    Object localObject2 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = new FinderMegaVideoProfileLoader((String)localObject1, ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)fcO()).q(as.class)).fou());
    ((FinderMegaVideoProfileLoader)localObject1).EzN = true;
    ((FinderMegaVideoProfileLoader)localObject1).setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.j)new b(this));
    ((BaseMegaVideoLoader)localObject1).fetchEndCallback = ((b)new c(this));
    localObject2 = ah.aiuX;
    s.u(localObject1, "<set-?>");
    this.EZZ = ((FinderMegaVideoProfileLoader)localObject1);
    this.Ezx = new d.a((MMActivity)fcO(), eIq());
    localObject1 = (MMActivity)fcO();
    localObject2 = getView();
    s.checkNotNull(localObject2);
    s.s(localObject2, "view!!");
    Object localObject3 = eeN();
    s.checkNotNull(localObject3);
    s.s(localObject3, "targetUsername!!");
    this.EZY = new d.b((MMActivity)localObject1, (View)localObject2, (String)localObject3);
    localObject1 = this.EZY;
    if (localObject1 == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
    }
    for (;;)
    {
      localObject3 = this.Ezx;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("presenter");
        localObject2 = null;
      }
      ((d.b)localObject1).a((a.a)localObject2);
      AppMethodBeat.o(348374);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/FinderProfileMegaVideoFragment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/FinderProfileMegaVideoFragment$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    b(FinderProfileMegaVideoFragment paramFinderProfileMegaVideoFragment) {}
    
    public final void call(int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(348421);
      Object localObject3 = FinderProfileMegaVideoFragment.a(this.Fab);
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((d.b)localObject1).getEmptyView();
      if (localObject1 != null)
      {
        localObject3 = this.Fab;
        ((View)localObject1).setVisibility(8);
        localObject1 = FinderProfileMegaVideoFragment.a((FinderProfileMegaVideoFragment)localObject3);
        if (localObject1 != null) {
          break label103;
        }
        s.bIx("viewCallback");
        localObject1 = localObject2;
      }
      label103:
      for (;;)
      {
        localObject1 = ((a.b)localObject1).ATx.getRecyclerView();
        if (localObject1 != null) {
          ((RecyclerView)localObject1).setVisibility(0);
        }
        new if().publish();
        AppMethodBeat.o(348421);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<IResponse<cc>, ah>
  {
    c(FinderProfileMegaVideoFragment paramFinderProfileMegaVideoFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
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