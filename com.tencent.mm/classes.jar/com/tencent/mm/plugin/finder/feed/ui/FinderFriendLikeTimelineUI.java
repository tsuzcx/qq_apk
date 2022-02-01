package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFriendLikeLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.feed.u.a;
import com.tencent.mm.plugin.finder.feed.u.b;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.e.b;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$Presenter;", "()V", "TAG", "", "commentScene", "", "feedLoader", "presenter", "scene", "targetNickname", "targetWxUsername", "viewCallback", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "jumpFinderHome", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onMoreClick", "plugin-finder_release"})
public final class FinderFriendLikeTimelineUI
  extends FinderLoaderFeedUI<FinderFriendLikeLoader, u.b, u.a>
{
  private final String TAG = "Finder.FinderFriendLikeTimelineUI";
  private HashMap _$_findViewCache;
  private final int scene = 2;
  private String xNf = "";
  private u.a xNi;
  private u.b xNj;
  private FinderFriendLikeLoader xNk;
  private String xNl = "";
  private int xkX = 79;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(278501);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(278501);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(278499);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(278499);
    return localView1;
  }
  
  public final int duR()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return this.xkX;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_friend_like_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(278491);
    Object localObject2 = getIntent().getStringExtra("KEY_USERNAME");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.xNl = ((String)localObject1);
    localObject2 = getIntent().getStringExtra("KEY_NICKNAME");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.xNf = ((String)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
    this.xNf = com.tencent.mm.plugin.finder.utils.aj.ht(this.xNl, this.xNf);
    setMMTitle((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)getContext(), (CharSequence)getContext().getString(b.j.finder_recent_like_list, new Object[] { this.xNf })));
    this.xNi = new u.a((MMActivity)this, this.scene);
    localObject1 = (MMActivity)this;
    localObject2 = this.xNi;
    if (localObject2 == null) {
      p.bGy("presenter");
    }
    this.xNj = new u.b((MMActivity)localObject1, (u.a)localObject2, this.scene, this.xkX);
    localObject1 = this.xNl;
    localObject2 = g.Xox;
    localObject2 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY();
    ((bid)localObject2).xkX = this.xkX;
    localObject1 = new FinderFriendLikeLoader((String)localObject1, (bid)localObject2);
    localObject2 = getIntent();
    p.j(localObject2, "intent");
    ((FinderFriendLikeLoader)localObject1).initFromCache((Intent)localObject2);
    ((FinderFriendLikeLoader)localObject1).setInitDone((j)new a((FinderFriendLikeLoader)localObject1, this));
    ((FinderFriendLikeLoader)localObject1).xHr = ((kotlin.g.a.b)new b(this));
    ((FinderFriendLikeLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new c(this));
    this.xNk = ((FinderFriendLikeLoader)localObject1);
    if (p.h(this.xNl, z.bcZ()))
    {
      addIconOptionMenu(0, b.i.icons_outlined_more, (MenuItem.OnMenuItemClickListener)new d(this));
      localObject1 = findViewById(b.f.more_button);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = findViewById(b.f.more_button);
      if (localObject1 != null)
      {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new e(this));
        AppMethodBeat.o(278491);
        return;
      }
    }
    AppMethodBeat.o(278491);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278490);
    this.xkX = getIntent().getIntExtra("KEY_COMMENT_SCENE", 79);
    super.onCreate(paramBundle);
    AppMethodBeat.o(278490);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$2$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements j
  {
    a(FinderFriendLikeLoader paramFinderFriendLikeLoader, FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(280358);
      Object localObject = FinderFriendLikeTimelineUI.a(jdField_this).xvJ.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(280358);
          throw ((Throwable)localObject);
        }
        ((FinderLinearLayoutManager)localObject).au(this.xNg.getInitPos(), 0);
      }
      if (paramInt > 0)
      {
        localObject = jdField_this.findViewById(b.f.loading_layout);
        if (localObject != null)
        {
          ((View)localObject).setVisibility(8);
          AppMethodBeat.o(280358);
          return;
        }
      }
      AppMethodBeat.o(280358);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$2$2"})
  static final class b
    extends q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    b(FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$2$3"})
  static final class c
    extends q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    c(FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(264982);
      FinderFriendLikeTimelineUI.d(this.xNm);
      AppMethodBeat.o(264982);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(221139);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      FinderFriendLikeTimelineUI.d(this.xNm);
      a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(221139);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements q.g
  {
    g(FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(280532);
      p.j(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(280532);
        return;
        c.b((Context)this.xNm, "setting", ".ui.setting.SettingsPrivacyUI", this.xNm.getIntent());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendLikeTimelineUI
 * JD-Core Version:    0.7.0.1
 */