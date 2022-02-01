package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFriendLikeLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.q.a;
import com.tencent.mm.plugin.finder.feed.q.b;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.e.b;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$Presenter;", "()V", "TAG", "", "commentScene", "", "feedLoader", "presenter", "scene", "targetNickname", "targetWxUsername", "viewCallback", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "jumpFinderHome", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onMoreClick", "plugin-finder_release"})
public final class FinderFriendLikeTimelineUI
  extends FinderLoaderFeedUI<FinderFriendLikeLoader, q.b, q.a>
{
  private final String TAG = "Finder.FinderFriendLikeTimelineUI";
  private HashMap _$_findViewCache;
  private final int scene = 2;
  private int tCE = 79;
  private String uaD = "";
  private q.a uaG;
  private q.b uaH;
  private FinderFriendLikeLoader uaI;
  private String uaJ = "";
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245261);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245261);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245260);
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
    AppMethodBeat.o(245260);
    return localView1;
  }
  
  public final int ddN()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return this.tCE;
  }
  
  public final int getLayoutId()
  {
    return 2131494327;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(245253);
    Object localObject2 = getIntent().getStringExtra("KEY_USERNAME");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.uaJ = ((String)localObject1);
    localObject2 = getIntent().getStringExtra("KEY_NICKNAME");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.uaD = ((String)localObject1);
    localObject1 = y.vXH;
    this.uaD = y.hf(this.uaJ, this.uaD);
    setMMTitle((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)getContext(), (CharSequence)getContext().getString(2131760505, new Object[] { this.uaD })));
    this.uaG = new q.a((MMActivity)this, this.scene);
    localObject1 = (MMActivity)this;
    localObject2 = this.uaG;
    if (localObject2 == null) {
      p.btv("presenter");
    }
    this.uaH = new q.b((MMActivity)localObject1, (q.a)localObject2, this.scene, this.tCE);
    localObject1 = this.uaJ;
    localObject2 = com.tencent.mm.ui.component.a.PRN;
    localObject2 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).dIx();
    ((bbn)localObject2).tCE = this.tCE;
    localObject1 = new FinderFriendLikeLoader((String)localObject1, (bbn)localObject2);
    localObject2 = getIntent();
    p.g(localObject2, "intent");
    ((FinderFriendLikeLoader)localObject1).initFromCache((Intent)localObject2);
    ((FinderFriendLikeLoader)localObject1).setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.h)new a((FinderFriendLikeLoader)localObject1, this));
    ((FinderFriendLikeLoader)localObject1).tVz = ((kotlin.g.a.b)new b(this));
    ((FinderFriendLikeLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new c(this));
    this.uaI = ((FinderFriendLikeLoader)localObject1);
    if (p.j(this.uaJ, z.aTY()))
    {
      addIconOptionMenu(0, 2131690843, (MenuItem.OnMenuItemClickListener)new d(this));
      localObject1 = findViewById(2131304867);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = findViewById(2131304867);
      if (localObject1 != null)
      {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new e(this));
        AppMethodBeat.o(245253);
        return;
      }
    }
    AppMethodBeat.o(245253);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245252);
    this.tCE = getIntent().getIntExtra("KEY_COMMENT_SCENE", 79);
    super.onCreate(paramBundle);
    AppMethodBeat.o(245252);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$2$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.plugin.finder.feed.model.internal.h
  {
    a(FinderFriendLikeLoader paramFinderFriendLikeLoader, FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(245238);
      Object localObject = FinderFriendLikeTimelineUI.a(jdField_this).tLS.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(245238);
          throw ((Throwable)localObject);
        }
        ((FinderLinearLayoutManager)localObject).ah(this.uaE.getInitPos(), 0);
      }
      if (paramInt > 0)
      {
        localObject = jdField_this.findViewById(2131303706);
        if (localObject != null)
        {
          ((View)localObject).setVisibility(8);
          AppMethodBeat.o(245238);
          return;
        }
      }
      AppMethodBeat.o(245238);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$2$2"})
  static final class b
    extends q
    implements kotlin.g.a.b<IResponse<bo>, x>
  {
    b(FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$2$3"})
  static final class c
    extends q
    implements kotlin.g.a.b<IResponse<bo>, x>
  {
    c(FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(245247);
      FinderFriendLikeTimelineUI.d(this.uaK);
      AppMethodBeat.o(245247);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245248);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderFriendLikeTimelineUI.d(this.uaK);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245248);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements o.f
  {
    public static final f uaN;
    
    static
    {
      AppMethodBeat.i(245250);
      uaN = new f();
      AppMethodBeat.o(245250);
    }
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(245249);
      paramm.kV(0, 2131760507);
      AppMethodBeat.o(245249);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements o.g
  {
    g(FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(245251);
      p.g(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(245251);
        return;
        c.b((Context)this.uaK, "setting", ".ui.setting.SettingsPrivacyUI", this.uaK.getIntent());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendLikeTimelineUI
 * JD-Core Version:    0.7.0.1
 */