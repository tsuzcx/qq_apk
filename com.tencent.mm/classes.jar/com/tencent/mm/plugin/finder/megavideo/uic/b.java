package com.tencent.mm.plugin.finder.megavideo.uic;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderFavMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.e;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.plugin.finder.megavideo.ui.h.a;
import com.tencent.mm.plugin.finder.megavideo.ui.h.b;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoFavTLUIC;", "Lcom/tencent/mm/plugin/finder/megavideo/uic/BaseMegaVideoTLUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "getLayoutId", "", "getPresenter", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  public static final a EBJ;
  private h.b EAL;
  private h.a EBi;
  
  static
  {
    AppMethodBeat.i(342087);
    EBJ = new a((byte)0);
    AppMethodBeat.o(342087);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(342079);
    AppMethodBeat.o(342079);
  }
  
  public final h.a eDc()
  {
    AppMethodBeat.i(342117);
    h.a locala = this.EBi;
    if (locala == null)
    {
      s.bIx("presenter");
      AppMethodBeat.o(342117);
      return null;
    }
    AppMethodBeat.o(342117);
    return locala;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_long_video_timeline_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(342107);
    super.onCreate(paramBundle);
    this.EBi = ((h.a)new f(getActivity(), (UIComponent)this));
    Object localObject3 = getActivity();
    Object localObject2 = this.EBi;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      s.bIx("presenter");
      paramBundle = null;
    }
    this.EAL = ((h.b)new e((AppCompatActivity)localObject3, paramBundle, getRootView()));
    paramBundle = z.bAW();
    s.s(paramBundle, "getMyFinderUsername()");
    localObject2 = k.aeZF;
    localObject2 = new FinderFavMegaVideoLoader(paramBundle, ((as)k.d(getActivity()).q(as.class)).fou());
    ((FinderFavMegaVideoLoader)localObject2).initFromCache(getIntent());
    ((FinderFavMegaVideoLoader)localObject2).setInitDone((j)new b(this, (FinderFavMegaVideoLoader)localObject2));
    paramBundle = this.EBi;
    if (paramBundle == null)
    {
      s.bIx("presenter");
      paramBundle = null;
      localObject3 = (BaseMegaVideoLoader)localObject2;
      localObject2 = this.EAL;
      if (localObject2 != null) {
        break label198;
      }
      s.bIx("viewCallback");
    }
    for (;;)
    {
      paramBundle.a((BaseMegaVideoLoader)localObject3, (h.b)localObject1);
      AppMethodBeat.o(342107);
      return;
      break;
      label198:
      localObject1 = localObject2;
    }
  }
  
  public final void onCreateBefore(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(342115);
    super.onDestroy();
    h.a locala2 = this.EBi;
    h.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("presenter");
      locala1 = null;
    }
    locala1.onDetach();
    AppMethodBeat.o(342115);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoFavTLUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoFavTLUIC$onCreate$feedLoader$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements j
  {
    b(b paramb, FinderFavMegaVideoLoader paramFinderFavMegaVideoLoader) {}
    
    private static final void a(FinderLinearLayoutManager paramFinderLinearLayoutManager, FinderFavMegaVideoLoader paramFinderFavMegaVideoLoader, b paramb, final RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(342122);
      s.u(paramFinderLinearLayoutManager, "$layoutManager");
      s.u(paramFinderFavMegaVideoLoader, "$this_apply");
      s.u(paramb, "this$0");
      s.u(paramRecyclerView, "$it");
      paramFinderLinearLayoutManager.bo(paramFinderFavMegaVideoLoader.getInitPos(), 0);
      final long l = paramb.getIntent().getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", 0L);
      if (l > 0L) {
        d.a(0L, (kotlin.g.a.a)new a(paramFinderLinearLayoutManager, paramRecyclerView, l));
      }
      AppMethodBeat.o(342122);
    }
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(342132);
      Object localObject2 = b.a(this.EBK);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((h.b)localObject1).getRecyclerView();
      if (localObject1 != null)
      {
        localObject2 = this.EBL;
        b localb = this.EBK;
        RecyclerView.LayoutManager localLayoutManager = ((RecyclerView)localObject1).getLayoutManager();
        if (localLayoutManager == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(342132);
          throw ((Throwable)localObject1);
        }
        ((RecyclerView)localObject1).post(new b.b..ExternalSyntheticLambda0((FinderLinearLayoutManager)localLayoutManager, (FinderFavMegaVideoLoader)localObject2, localb, (RecyclerView)localObject1));
      }
      AppMethodBeat.o(342132);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(FinderLinearLayoutManager paramFinderLinearLayoutManager, RecyclerView paramRecyclerView, long paramLong)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.uic.b
 * JD-Core Version:    0.7.0.1
 */