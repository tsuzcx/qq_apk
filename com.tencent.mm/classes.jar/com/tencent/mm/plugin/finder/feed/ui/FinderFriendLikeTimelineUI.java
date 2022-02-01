package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFriendLikeLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.feed.t.a;
import com.tencent.mm.plugin.finder.feed.t.b;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.e.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$Presenter;", "()V", "TAG", "", "commentScene", "", "feedLoader", "presenter", "scene", "targetNickname", "targetWxUsername", "viewCallback", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "jumpFinderHome", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onMoreClick", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFriendLikeTimelineUI
  extends FinderLoaderFeedUI<FinderFriendLikeLoader, t.b, t.a>
{
  private int AJo = 79;
  private String Bnf = "";
  private t.a Bni;
  private t.b Bnj;
  private FinderFriendLikeLoader Bnk;
  private String Bnl = "";
  private final String TAG = "Finder.FinderFriendLikeTimelineUI";
  private final int scene = 2;
  
  private static final void a(FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(364565);
    kotlin.g.b.s.u(paramFinderFriendLikeTimelineUI, "this$0");
    if (paramMenuItem.getItemId() == 0) {
      c.b((Context)paramFinderFriendLikeTimelineUI, "setting", ".ui.setting.SettingsPrivacyUI", paramFinderFriendLikeTimelineUI.getIntent());
    }
    AppMethodBeat.o(364565);
  }
  
  private static final void a(FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI, View paramView)
  {
    AppMethodBeat.i(364552);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderFriendLikeTimelineUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderFriendLikeTimelineUI, "this$0");
    paramFinderFriendLikeTimelineUI.eeP();
    a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(364552);
  }
  
  private static final boolean a(FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364543);
    kotlin.g.b.s.u(paramFinderFriendLikeTimelineUI, "this$0");
    paramFinderFriendLikeTimelineUI.eeP();
    AppMethodBeat.o(364543);
    return true;
  }
  
  private static final void d(com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(364560);
    params.oh(0, e.h.finder_recent_like_setting_tips);
    AppMethodBeat.o(364560);
  }
  
  private final void eeP()
  {
    AppMethodBeat.i(364533);
    f localf = new f((Context)this, 1, false);
    localf.Vtg = FinderFriendLikeTimelineUI..ExternalSyntheticLambda2.INSTANCE;
    localf.GAC = new FinderFriendLikeTimelineUI..ExternalSyntheticLambda3(this);
    localf.dDn();
    AppMethodBeat.o(364533);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return this.AJo;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_friend_like_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(364655);
    Object localObject2 = getIntent().getStringExtra("KEY_USERNAME");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.Bnl = ((String)localObject1);
    localObject2 = getIntent().getStringExtra("KEY_NICKNAME");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.Bnf = ((String)localObject1);
    localObject1 = av.GiL;
    this.Bnf = av.ip(this.Bnl, this.Bnf);
    setMMTitle((CharSequence)p.b((Context)getContext(), (CharSequence)getContext().getString(e.h.finder_recent_like_list, new Object[] { this.Bnf })));
    this.Bni = new t.a((MMActivity)this, this.scene);
    Object localObject3 = (MMActivity)this;
    localObject2 = this.Bni;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("presenter");
      localObject1 = null;
    }
    this.Bnj = new t.b((MMActivity)localObject3, (t.a)localObject1, this.scene, this.AJo);
    localObject1 = this.Bnl;
    localObject2 = k.aeZF;
    localObject2 = ((as)k.d((AppCompatActivity)this).q(as.class)).fou();
    ((bui)localObject2).AJo = this.AJo;
    localObject3 = ah.aiuX;
    localObject1 = new FinderFriendLikeLoader((String)localObject1, (bui)localObject2);
    localObject2 = getIntent();
    kotlin.g.b.s.s(localObject2, "intent");
    ((FinderFriendLikeLoader)localObject1).initFromCache((Intent)localObject2);
    ((FinderFriendLikeLoader)localObject1).setInitDone((j)new a(this, (FinderFriendLikeLoader)localObject1));
    ((FinderFriendLikeLoader)localObject1).Bgv = ((kotlin.g.a.b)new b(this));
    ((FinderFriendLikeLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new c(this));
    localObject2 = ah.aiuX;
    this.Bnk = ((FinderFriendLikeLoader)localObject1);
    if (kotlin.g.b.s.p(this.Bnl, z.bAM()))
    {
      addIconOptionMenu(0, e.g.icons_outlined_more, new FinderFriendLikeTimelineUI..ExternalSyntheticLambda0(this));
      localObject1 = findViewById(e.e.more_button);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = findViewById(e.e.more_button);
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new FinderFriendLikeTimelineUI..ExternalSyntheticLambda1(this));
      }
    }
    AppMethodBeat.o(364655);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364636);
    this.AJo = getIntent().getIntExtra("KEY_COMMENT_SCENE", 79);
    super.onCreate(paramBundle);
    AppMethodBeat.o(364636);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$2$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements j
  {
    a(FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI, FinderFriendLikeLoader paramFinderFriendLikeLoader) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(365644);
      Object localObject2 = FinderFriendLikeTimelineUI.a(this.Bnm);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((b.b)localObject1).ATx.getRecyclerView().getLayoutManager();
      if (localObject1 != null)
      {
        localObject2 = this.Bng;
        ((FinderLinearLayoutManager)localObject1).bo(((FinderFriendLikeLoader)localObject2).getInitPos(), 0);
      }
      if (paramInt > 0)
      {
        localObject1 = this.Bnm.findViewById(e.e.loading_layout);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
      }
      AppMethodBeat.o(365644);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    b(FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI)
    {
      super();
    }
    
    private static final void b(FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI, View paramView)
    {
      AppMethodBeat.i(365657);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramFinderFriendLikeTimelineUI);
      localb.cH(paramView);
      a.c("com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramFinderFriendLikeTimelineUI, "this$0");
      FinderFriendLikeTimelineUI.b(paramFinderFriendLikeTimelineUI);
      a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(365657);
    }
    
    private static final void c(FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI, View paramView)
    {
      AppMethodBeat.i(365665);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramFinderFriendLikeTimelineUI);
      localb.cH(paramView);
      a.c("com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramFinderFriendLikeTimelineUI, "this$0");
      FinderFriendLikeTimelineUI.b(paramFinderFriendLikeTimelineUI);
      a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(365665);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    c(FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI)
    {
      super();
    }
    
    private static final void d(FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI, View paramView)
    {
      AppMethodBeat.i(365563);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramFinderFriendLikeTimelineUI);
      localb.cH(paramView);
      a.c("com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramFinderFriendLikeTimelineUI, "this$0");
      FinderFriendLikeTimelineUI.b(paramFinderFriendLikeTimelineUI);
      a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(365563);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$2$3$1$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends e.b
    {
      a(FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI) {}
      
      public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
      {
        AppMethodBeat.i(365185);
        kotlin.g.b.s.u(paramView, "view");
        h.OAn.b(22010, new Object[] { FinderFriendLikeTimelineUI.c(this.Bnm), Integer.valueOf(1) });
        AppMethodBeat.o(365185);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendLikeTimelineUI
 * JD-Core Version:    0.7.0.1
 */