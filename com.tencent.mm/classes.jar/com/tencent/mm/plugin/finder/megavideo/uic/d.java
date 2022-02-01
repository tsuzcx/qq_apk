package com.tencent.mm.plugin.finder.megavideo.uic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.NormalMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.plugin.finder.megavideo.ui.g;
import com.tencent.mm.plugin.finder.megavideo.ui.h.a;
import com.tencent.mm.plugin.finder.megavideo.ui.h.b;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.video.t;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC;", "Lcom/tencent/mm/plugin/finder/megavideo/uic/BaseMegaVideoTLUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "tipsLayout", "Landroid/view/View;", "viewCallback", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "getLayoutId", "", "getPresenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "showRetryTips", "ifShow", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a
{
  public static final a EBP;
  private h.b EAL;
  private View EBQ;
  private f Ezo;
  
  static
  {
    AppMethodBeat.i(342106);
    EBP = new a((byte)0);
    AppMethodBeat.o(342106);
  }
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(342073);
    AppMethodBeat.o(342073);
  }
  
  private static final void a(ah.f paramf, d paramd, View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(342082);
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, localb.aYj());
    s.u(paramf, "$view");
    s.u(paramd, "this$0");
    ((View)paramf.aqH).setVisibility(8);
    paramView = paramd.Ezo;
    paramf = paramView;
    if (paramView == null)
    {
      s.bIx("presenter");
      paramf = null;
    }
    paramf.dUL();
    paramf = paramd.Ezo;
    if (paramf == null)
    {
      s.bIx("presenter");
      paramf = localObject1;
    }
    for (;;)
    {
      paramf.requestRefresh();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(342082);
      return;
    }
  }
  
  public final h.a eDc()
  {
    AppMethodBeat.i(342144);
    f localf = this.Ezo;
    Object localObject = localf;
    if (localf == null)
    {
      s.bIx("presenter");
      localObject = null;
    }
    localObject = (h.a)localObject;
    AppMethodBeat.o(342144);
    return localObject;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_long_video_timeline_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(342134);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("finder_username");
    Object localObject2;
    boolean bool;
    label71:
    Object localObject3;
    if (paramBundle == null)
    {
      paramBundle = "";
      localObject2 = new f(getActivity(), (UIComponent)this);
      if ((!z.Iz(paramBundle)) || (!getActivity().getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false))) {
        break label391;
      }
      bool = true;
      ((f)localObject2).EAO = bool;
      paramBundle = ah.aiuX;
      this.Ezo = ((f)localObject2);
      localObject3 = getActivity();
      localObject2 = this.Ezo;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        s.bIx("presenter");
        paramBundle = null;
      }
      this.EAL = ((h.b)new g((AppCompatActivity)localObject3, (h.a)paramBundle, getRootView()));
      paramBundle = k.aeZF;
      localObject3 = new NormalMegaVideoLoader(((as)k.d(getActivity()).q(as.class)).fou(), (MMFragmentActivity)getActivity());
      ((NormalMegaVideoLoader)localObject3).Bgq = getIntent().getLongExtra("KEY_CACHE_OBJECT_ID", 0L);
      localObject2 = getIntent().getStringExtra("KEY_CACHE_OBJECT_NONCE_ID");
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null) {
        paramBundle = "";
      }
      s.u(paramBundle, "<set-?>");
      ((NormalMegaVideoLoader)localObject3).Bgr = paramBundle;
      ((NormalMegaVideoLoader)localObject3).EzU = eDa();
      paramBundle = eCZ();
      if (paramBundle != null) {
        break label396;
      }
      paramBundle = null;
      label249:
      if (paramBundle == null) {
        ((NormalMegaVideoLoader)localObject3).initFromCache(getIntent());
      }
      ((NormalMegaVideoLoader)localObject3).setInitDone((j)new b(this, (NormalMegaVideoLoader)localObject3));
      ((NormalMegaVideoLoader)localObject3).AUX = ((m)new c(this));
      ((NormalMegaVideoLoader)localObject3).AUY = ((kotlin.g.a.b)new d(this));
      paramBundle = getRootView().findViewById(e.e.feed_detail_tips_layout);
      s.s(paramBundle, "rootView.findViewById<Vi….feed_detail_tips_layout)");
      this.EBQ = paramBundle;
      paramBundle = this.Ezo;
      if (paramBundle != null) {
        break label409;
      }
      s.bIx("presenter");
      paramBundle = null;
      label351:
      localObject3 = (BaseMegaVideoLoader)localObject3;
      localObject2 = this.EAL;
      if (localObject2 != null) {
        break label412;
      }
      s.bIx("viewCallback");
    }
    for (;;)
    {
      paramBundle.a((BaseMegaVideoLoader)localObject3, (h.b)localObject1);
      AppMethodBeat.o(342134);
      return;
      break;
      label391:
      bool = false;
      break label71;
      label396:
      ((NormalMegaVideoLoader)localObject3).initFromCache(paramBundle);
      paramBundle = ah.aiuX;
      break label249;
      label409:
      break label351;
      label412:
      localObject1 = localObject2;
    }
  }
  
  public final void onCreateBefore(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(342140);
    super.onDestroy();
    f localf2 = this.Ezo;
    f localf1 = localf2;
    if (localf2 == null)
    {
      s.bIx("presenter");
      localf1 = null;
    }
    localf1.onDetach();
    AppMethodBeat.o(342140);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/uic/FinderMegaVideoNormalTLUIC$onCreate$feedLoader$1$3", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements j
  {
    b(d paramd, NormalMegaVideoLoader paramNormalMegaVideoLoader) {}
    
    private static final void a(FinderLinearLayoutManager paramFinderLinearLayoutManager, NormalMegaVideoLoader paramNormalMegaVideoLoader, final d paramd, final RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(342088);
      s.u(paramFinderLinearLayoutManager, "$layoutManager");
      s.u(paramNormalMegaVideoLoader, "$this_apply");
      s.u(paramd, "this$0");
      s.u(paramRecyclerView, "$it");
      paramFinderLinearLayoutManager.bo(paramNormalMegaVideoLoader.getInitPos(), 0);
      final long l = paramd.getIntent().getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", 0L);
      if (l > 0L) {
        com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new a(paramFinderLinearLayoutManager, paramRecyclerView, paramd, l));
      }
      AppMethodBeat.o(342088);
    }
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(342101);
      Object localObject2 = d.a(this.EBR);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((h.b)localObject1).getRecyclerView();
      if (localObject1 != null)
      {
        localObject2 = this.EBS;
        d locald = this.EBR;
        RecyclerView.LayoutManager localLayoutManager = ((RecyclerView)localObject1).getLayoutManager();
        if (localLayoutManager == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(342101);
          throw ((Throwable)localObject1);
        }
        ((RecyclerView)localObject1).post(new d.b..ExternalSyntheticLambda0((FinderLinearLayoutManager)localLayoutManager, (NormalMegaVideoLoader)localObject2, locald, (RecyclerView)localObject1));
      }
      AppMethodBeat.o(342101);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(FinderLinearLayoutManager paramFinderLinearLayoutManager, RecyclerView paramRecyclerView, d paramd, long paramLong)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errcode", "", "errMsg", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<Integer, String, ah>
  {
    c(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<ca, ah>
  {
    d(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.uic.d
 * JD-Core Version:    0.7.0.1
 */