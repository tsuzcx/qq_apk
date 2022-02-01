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
import com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoProfileTLUIC;", "Lcom/tencent/mm/plugin/finder/megavideo/uic/BaseMegaVideoTLUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "getLayoutId", "", "getPresenter", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a
{
  public static final e.a EBU;
  private h.b EAL;
  private h.a EBi;
  
  static
  {
    AppMethodBeat.i(342077);
    EBU = new e.a((byte)0);
    AppMethodBeat.o(342077);
  }
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(342070);
    AppMethodBeat.o(342070);
  }
  
  public final h.a eDc()
  {
    AppMethodBeat.i(342108);
    h.a locala = this.EBi;
    if (locala == null)
    {
      s.bIx("presenter");
      AppMethodBeat.o(342108);
      return null;
    }
    AppMethodBeat.o(342108);
    return locala;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_long_video_timeline_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject2 = null;
    AppMethodBeat.i(342095);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("finder_username");
    Object localObject1;
    boolean bool;
    label71:
    Object localObject3;
    if (paramBundle == null)
    {
      paramBundle = "";
      localObject1 = new f(getActivity(), (UIComponent)this);
      if ((!z.Iz(paramBundle)) || (!getActivity().getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false))) {
        break label249;
      }
      bool = true;
      ((f)localObject1).EAO = bool;
      localObject3 = ah.aiuX;
      this.EBi = ((h.a)localObject1);
      AppCompatActivity localAppCompatActivity = getActivity();
      localObject3 = this.EBi;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("presenter");
        localObject1 = null;
      }
      this.EAL = ((h.b)new com.tencent.mm.plugin.finder.megavideo.ui.e(localAppCompatActivity, (h.a)localObject1, getRootView()));
      localObject1 = k.aeZF;
      localObject1 = new FinderMegaVideoProfileLoader(paramBundle, ((as)k.d(getActivity()).q(as.class)).fou());
      ((FinderMegaVideoProfileLoader)localObject1).initFromCache(getIntent());
      ((FinderMegaVideoProfileLoader)localObject1).setInitDone((j)new b(this, (FinderMegaVideoProfileLoader)localObject1));
      paramBundle = this.EBi;
      if (paramBundle != null) {
        break label254;
      }
      s.bIx("presenter");
      paramBundle = null;
      label208:
      localObject3 = (BaseMegaVideoLoader)localObject1;
      localObject1 = this.EAL;
      if (localObject1 != null) {
        break label257;
      }
      s.bIx("viewCallback");
      localObject1 = localObject2;
    }
    label257:
    for (;;)
    {
      paramBundle.a((BaseMegaVideoLoader)localObject3, (h.b)localObject1);
      AppMethodBeat.o(342095);
      return;
      break;
      label249:
      bool = false;
      break label71;
      label254:
      break label208;
    }
  }
  
  public final void onCreateBefore(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(342102);
    super.onDestroy();
    h.a locala2 = this.EBi;
    h.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("presenter");
      locala1 = null;
    }
    locala1.onDetach();
    AppMethodBeat.o(342102);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoProfileTLUIC$onCreate$feedLoader$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements j
  {
    b(e parame, FinderMegaVideoProfileLoader paramFinderMegaVideoProfileLoader) {}
    
    private static final void a(FinderLinearLayoutManager paramFinderLinearLayoutManager, FinderMegaVideoProfileLoader paramFinderMegaVideoProfileLoader, e parame, final RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(342131);
      s.u(paramFinderLinearLayoutManager, "$layoutManager");
      s.u(paramFinderMegaVideoProfileLoader, "$this_apply");
      s.u(parame, "this$0");
      s.u(paramRecyclerView, "$it");
      paramFinderLinearLayoutManager.bo(paramFinderMegaVideoProfileLoader.getInitPos() - paramFinderMegaVideoProfileLoader.EzO, 0);
      final long l = parame.getIntent().getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", 0L);
      if (l > 0L) {
        d.a(0L, (kotlin.g.a.a)new a(paramFinderLinearLayoutManager, paramRecyclerView, l));
      }
      AppMethodBeat.o(342131);
    }
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(342142);
      Object localObject2 = e.a(this.EBV);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((h.b)localObject1).getRecyclerView();
      if (localObject1 != null)
      {
        localObject2 = this.EBW;
        e locale = this.EBV;
        RecyclerView.LayoutManager localLayoutManager = ((RecyclerView)localObject1).getLayoutManager();
        if (localLayoutManager == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(342142);
          throw ((Throwable)localObject1);
        }
        ((RecyclerView)localObject1).post(new e.b..ExternalSyntheticLambda0((FinderLinearLayoutManager)localLayoutManager, (FinderMegaVideoProfileLoader)localObject2, locale, (RecyclerView)localObject1));
      }
      AppMethodBeat.o(342142);
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
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.uic.e
 * JD-Core Version:    0.7.0.1
 */