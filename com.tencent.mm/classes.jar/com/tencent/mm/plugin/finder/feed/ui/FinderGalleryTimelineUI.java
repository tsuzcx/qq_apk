package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.gallery.FinderGalleryLoader;
import com.tencent.mm.plugin.finder.gallery.b.a;
import com.tencent.mm.plugin.finder.gallery.m.a;
import com.tencent.mm.plugin.finder.gallery.m.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.av;
import com.tencent.mm.plugin.finder.viewmodel.component.c;
import com.tencent.mm.plugin.findersdk.a.ab;
import com.tencent.mm.plugin.findersdk.a.af;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.component.l;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderGalleryTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryLoader;", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTimelineContract$Presenter;", "()V", "feedLoader", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryLoader;)V", "galleryConfig", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "getGalleryConfig", "()Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "setGalleryConfig", "(Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;)V", "isHideMoreVideo", "", "mOnHellScrollListener", "com/tencent/mm/plugin/finder/feed/ui/FinderGalleryTimelineUI$mOnHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderGalleryTimelineUI$mOnHellScrollListener$1;", "moreViewLayout", "Landroid/widget/LinearLayout;", "presenter", "selectTv", "Landroid/widget/TextView;", "tabType", "", "viewCallback", "finish", "", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initOnCreate", "onDestroy", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderGalleryTimelineUI
  extends FinderLoaderFeedUI<FinderGalleryLoader, m.b, m.a>
{
  public static final a BnF;
  private m.a BnG;
  private m.b BnH;
  private TextView BnI;
  private LinearLayout BnJ;
  public FinderGalleryLoader BnK;
  private boolean BnL;
  private final d BnM;
  public com.tencent.mm.plugin.finder.gallery.b Bnx;
  private int hJx;
  
  static
  {
    AppMethodBeat.i(364791);
    BnF = new a((byte)0);
    AppMethodBeat.o(364791);
  }
  
  public FinderGalleryTimelineUI()
  {
    AppMethodBeat.i(364737);
    this.BnM = new d(this);
    AppMethodBeat.o(364737);
  }
  
  private static final void a(FinderGalleryTimelineUI paramFinderGalleryTimelineUI, View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(364756);
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderGalleryTimelineUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/feed/ui/FinderGalleryTimelineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, localb.aYj());
    s.u(paramFinderGalleryTimelineUI, "this$0");
    localObject2 = paramFinderGalleryTimelineUI.BnH;
    paramView = (View)localObject2;
    if (localObject2 == null)
    {
      s.bIx("viewCallback");
      paramView = null;
    }
    if ((paramView.ATx.getRecyclerView().getLayoutManager() instanceof FinderLinearLayoutManager))
    {
      paramView = paramFinderGalleryTimelineUI.BnH;
      if (paramView == null)
      {
        s.bIx("viewCallback");
        paramView = localObject1;
      }
      for (;;)
      {
        paramView = paramView.ATx.getRecyclerView().getLayoutManager();
        if (paramView != null) {
          break;
        }
        paramFinderGalleryTimelineUI = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
        AppMethodBeat.o(364756);
        throw paramFinderGalleryTimelineUI;
      }
      int i = ((FinderLinearLayoutManager)paramView).Ju();
      paramView = new Intent();
      paramView.putExtra("SELECT_OBJECT", ((BaseFinderFeed)paramFinderGalleryTimelineUI.eeV().getDataList().get(i)).feedObject.getFeedObject().toByteArray());
      paramView.putExtra("TAB_TYPE", paramFinderGalleryTimelineUI.hJx);
      paramFinderGalleryTimelineUI.setResult(-1, paramView);
      paramFinderGalleryTimelineUI.finish();
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderGalleryTimelineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(364756);
  }
  
  private FinderGalleryLoader eeV()
  {
    AppMethodBeat.i(364743);
    FinderGalleryLoader localFinderGalleryLoader = this.BnK;
    if (localFinderGalleryLoader != null)
    {
      AppMethodBeat.o(364743);
      return localFinderGalleryLoader;
    }
    s.bIx("feedLoader");
    AppMethodBeat.o(364743);
    return null;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 2;
  }
  
  public final void finish()
  {
    Object localObject2 = null;
    AppMethodBeat.i(364822);
    m.b localb = this.BnH;
    Object localObject1 = localb;
    if (localb == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
    }
    if ((((b.b)localObject1).ATx.getRecyclerView().getLayoutManager() instanceof FinderLinearLayoutManager))
    {
      localObject1 = this.BnH;
      if (localObject1 == null)
      {
        s.bIx("viewCallback");
        localObject1 = localObject2;
      }
      for (;;)
      {
        localObject1 = ((b.b)localObject1).ATx.getRecyclerView().getLayoutManager();
        if (localObject1 != null) {
          break;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
        AppMethodBeat.o(364822);
        throw ((Throwable)localObject1);
      }
      int i = ((FinderLinearLayoutManager)localObject1).Ju();
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("SELECT_OBJECT", ((BaseFinderFeed)eeV().getDataList().get(i)).feedObject.getFeedObject().toByteArray());
      ((Intent)localObject1).putExtra("TAB_TYPE", this.hJx);
      setResult(-2, (Intent)localObject1);
    }
    super.finish();
    AppMethodBeat.o(364822);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_gallery_timeline_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(364829);
    Set localSet = ar.setOf(new Class[] { av.class, c.class });
    AppMethodBeat.o(364829);
    return localSet;
  }
  
  public final void initOnCreate()
  {
    Object localObject2 = null;
    AppMethodBeat.i(364816);
    this.BnL = h.baE().ban().getBoolean(at.a.adfj, false);
    Object localObject1 = findViewById(e.e.ll_more_video);
    s.s(localObject1, "findViewById(R.id.ll_more_video)");
    this.BnJ = ((LinearLayout)localObject1);
    Object localObject3;
    if (this.BnL)
    {
      localObject3 = this.BnJ;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("moreViewLayout");
        localObject1 = null;
      }
      ((LinearLayout)localObject1).setVisibility(8);
      localObject1 = com.tencent.mm.plugin.finder.gallery.b.Bus;
      localObject1 = getIntent();
      s.s(localObject1, "intent");
      localObject1 = b.a.au((Intent)localObject1);
      s.u(localObject1, "<set-?>");
      this.Bnx = ((com.tencent.mm.plugin.finder.gallery.b)localObject1);
      int i = getIntent().getIntExtra("BIZ_SCENE", 0);
      localObject1 = getIntent().getByteArrayExtra("EXT_BUFF");
      this.hJx = getIntent().getIntExtra("TAB_TYPE", 0);
      axz localaxz = new axz();
      localaxz.tab_type = this.hJx;
      localaxz.scene = i;
      if (localObject1 != null) {
        break label502;
      }
      localObject1 = null;
      label183:
      localaxz.ZEP = ((com.tencent.mm.bx.b)localObject1);
      this.BnG = new m.a((MMActivity)this, this.hJx);
      MMActivity localMMActivity = (MMActivity)this;
      localObject3 = this.BnG;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("presenter");
        localObject1 = null;
      }
      this.BnH = new m.b(localMMActivity, (m.a)localObject1);
      localObject1 = k.aeZF;
      localObject1 = new FinderGalleryLoader(localaxz, ((as)k.d((AppCompatActivity)this).q(as.class)).fou(), true);
      localObject3 = getIntent();
      s.s(localObject3, "intent");
      ((FinderGalleryLoader)localObject1).initFromCache((Intent)localObject3);
      ((FinderGalleryLoader)localObject1).setInitDone((j)new b(this, (FinderGalleryLoader)localObject1));
      ((FinderGalleryLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new c(this));
      localObject3 = kotlin.ah.aiuX;
      s.u(localObject1, "<set-?>");
      this.BnK = ((FinderGalleryLoader)localObject1);
      localObject3 = this.BnH;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("viewCallback");
        localObject1 = null;
      }
      ((b.b)localObject1).ATx.getRecyclerView().a((RecyclerView.l)this.BnM);
      ((WeImageView)findViewById(e.e.backBtnIv)).setIconColor(getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_5));
      localObject1 = findViewById(e.e.tv_select);
      s.s(localObject1, "findViewById<TextView>(R.id.tv_select)");
      this.BnI = ((TextView)localObject1);
      localObject1 = this.BnI;
      if (localObject1 != null) {
        break label510;
      }
      s.bIx("selectTv");
      localObject1 = localObject2;
    }
    label502:
    label510:
    for (;;)
    {
      ((TextView)localObject1).setOnClickListener(new FinderGalleryTimelineUI..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(364816);
      return;
      localObject3 = this.BnJ;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("moreViewLayout");
        localObject1 = null;
      }
      ((LinearLayout)localObject1).setVisibility(0);
      break;
      localObject1 = com.tencent.mm.bx.b.cX((byte[])localObject1);
      break label183;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(364848);
    m.b localb2 = this.BnH;
    m.b localb1 = localb2;
    if (localb2 == null)
    {
      s.bIx("viewCallback");
      localb1 = null;
    }
    localb1.ATx.getRecyclerView().b((RecyclerView.l)this.BnM);
    super.onDestroy();
    AppMethodBeat.o(364848);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(364803);
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.remove(l.a(kotlin.g.b.ai.cz(ab.class)));
    paramHashSet.remove(l.a(kotlin.g.b.ai.cz(af.class)));
    paramHashSet.remove(l.a(kotlin.g.b.ai.cz(com.tencent.mm.plugin.findersdk.a.cc.class)));
    paramHashSet.remove(l.a(kotlin.g.b.ai.cz(com.tencent.mm.plugin.findersdk.a.ai.class)));
    paramHashSet.remove(l.a(kotlin.g.b.ai.cz(com.tencent.mm.plugin.findersdk.a.ah.class)));
    AppMethodBeat.o(364803);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderGalleryTimelineUI$Companion;", "", "()V", "RESULT_BACK", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderGalleryTimelineUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements j
  {
    b(FinderGalleryTimelineUI paramFinderGalleryTimelineUI, FinderGalleryLoader paramFinderGalleryLoader) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(365229);
      Object localObject2 = FinderGalleryTimelineUI.a(this.BnN);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((b.b)localObject1).ATx.getRecyclerView().getLayoutManager();
      if (localObject1 != null)
      {
        localObject2 = this.BnO;
        ((FinderLinearLayoutManager)localObject1).bo(((FinderGalleryLoader)localObject2).getInitPos(), 0);
      }
      AppMethodBeat.o(365229);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<IResponse<com.tencent.mm.plugin.finder.model.cc>, kotlin.ah>
  {
    c(FinderGalleryTimelineUI paramFinderGalleryTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderGalleryTimelineUI$mOnHellScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.l
  {
    d(FinderGalleryTimelineUI paramFinderGalleryTimelineUI) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(365248);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt);
      a.c("com/tencent/mm/plugin/finder/feed/ui/FinderGalleryTimelineUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      paramRecyclerView = FinderGalleryTimelineUI.b(this.BnN);
      if (paramRecyclerView == null)
      {
        s.bIx("selectTv");
        paramRecyclerView = null;
        if (paramInt != 0) {
          break label172;
        }
      }
      label172:
      for (boolean bool = true;; bool = false)
      {
        paramRecyclerView.setClickable(bool);
        if ((paramInt == 0) && (!FinderGalleryTimelineUI.c(this.BnN)))
        {
          h.baE().ban().set(at.a.adfj, Boolean.TRUE);
          FinderGalleryTimelineUI.d(this.BnN);
          localObject = FinderGalleryTimelineUI.e(this.BnN);
          paramRecyclerView = (RecyclerView)localObject;
          if (localObject == null)
          {
            s.bIx("moreViewLayout");
            paramRecyclerView = null;
          }
          paramRecyclerView.setVisibility(8);
        }
        a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderGalleryTimelineUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(365248);
        return;
        break;
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(365251);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      a.c("com/tencent/mm/plugin/finder/feed/ui/FinderGalleryTimelineUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderGalleryTimelineUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(365251);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderGalleryTimelineUI
 * JD-Core Version:    0.7.0.1
 */