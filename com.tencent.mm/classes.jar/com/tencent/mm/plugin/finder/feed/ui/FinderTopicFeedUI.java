package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.bb.b;
import com.tencent.mm.plugin.finder.feed.bb.c;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.e;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.q;
import com.tencent.mm.plugin.finder.live.report.c;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.ac.a;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.protocal.protobuf.dmp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "MENU_ID_COMPLAINT", "", "MENU_ID_MORE", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_TIMELINE", "TAB_TYPE", "TAG", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "firstRsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "onHellScroller", "com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "getCommentScene", "getFollowPatShareTitle", "getLayoutId", "getReportType", "goBack", "", "notShare", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "setIconMenu", "Companion", "plugin-finder_release"})
public final class FinderTopicFeedUI
  extends MMFinderUI
{
  private static ConcurrentHashMap<Long, FinderItem> xLE;
  public static final a xTd;
  private final String TAG;
  private HashMap _$_findViewCache;
  private final int wXe;
  private final int wXf;
  private final int wXg;
  private bb.b wXr;
  private bb.c wXs;
  private FinderTopicFeedLoader wXt;
  private int xEb;
  private final int xTa;
  private avy xTb;
  private final c xTc;
  private biv xcZ;
  
  static
  {
    AppMethodBeat.i(178306);
    xTd = new a((byte)0);
    xLE = new ConcurrentHashMap();
    AppMethodBeat.o(178306);
  }
  
  public FinderTopicFeedUI()
  {
    AppMethodBeat.i(291597);
    this.TAG = "Finder.FinderTopicFeedUI";
    this.wXe = 10001;
    this.wXf = 10002;
    this.wXg = 10003;
    this.xTa = 10004;
    this.xTc = new c();
    AppMethodBeat.o(291597);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(291602);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(291602);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(291601);
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
    AppMethodBeat.o(291601);
    return localView1;
  }
  
  public final int duR()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(291593);
    int i = getIntent().getIntExtra("key_topic_type", 1);
    if (i == 1)
    {
      AppMethodBeat.o(291593);
      return 22;
    }
    if (i == 4)
    {
      AppMethodBeat.o(291593);
      return 49;
    }
    if (i == 5)
    {
      AppMethodBeat.o(291593);
      return 64;
    }
    AppMethodBeat.o(291593);
    return 26;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_topic_feed_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(166276);
    super.onCreate(paramBundle);
    overridePendingTransition(b.a.slide_right_in, b.a.anim_not_change);
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    setActionbarColor(getResources().getColor(b.c.BG_2));
    xLE.clear();
    int i = getIntent().getIntExtra("key_topic_type", 1);
    String str = getIntent().getStringExtra("key_topic_title");
    Object localObject1 = getIntent().getStringExtra("KEY_FOLLOW_ID");
    getIntent().getStringExtra("KEY_MUSIC_INFO");
    long l = getIntent().getLongExtra("KEY_TOPIC_ID", 0L);
    Object localObject2 = getIntent().getStringExtra("KEY_TOPIC_NONCE_ID");
    this.xEb = getIntent().getIntExtra("KEY_TAB_TYPE", 0);
    Log.i(this.TAG, "type:" + i + ", topic:" + str);
    setMMTitle("");
    paramBundle = (com.tencent.mm.cd.a)new biv();
    Object localObject3 = getIntent().getByteArrayExtra("KEY_SECTION_INFO");
    try
    {
      paramBundle.parseFrom((byte[])localObject3);
      this.xcZ = ((biv)paramBundle);
      paramBundle = (com.tencent.mm.cd.a)new avy();
      localObject3 = getIntent().getByteArrayExtra("KEY_TOPIC_RSP");
    }
    catch (Exception paramBundle)
    {
      try
      {
        paramBundle.parseFrom((byte[])localObject3);
        this.xTb = ((avy)paramBundle);
        p.j(str, "topic");
        paramBundle = g.Xox;
        paramBundle = new FinderTopicFeedLoader(i, str, ((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY());
        localObject3 = getIntent();
        p.j(localObject3, "intent");
        paramBundle.initFromCache((Intent)localObject3);
        paramBundle.xEv = ((String)localObject1);
        this.wXt = paramBundle;
        paramBundle = (MMActivity)this;
        getCommentScene();
        localObject3 = this.wXt;
        if (localObject3 == null) {
          p.bGy("feedLoader");
        }
        paramBundle = new bb.b(paramBundle, (BaseFinderFeedLoader)localObject3);
        paramBundle.aBE(str);
        paramBundle.type = i;
        this.wXr = paramBundle;
        paramBundle = this.wXr;
        if (paramBundle == null) {
          p.bGy("presenter");
        }
        paramBundle.xEb = this.xEb;
        paramBundle = new bb.c((MMActivity)this, getCommentScene(), (byte)0);
        paramBundle.aBE(str);
        paramBundle.type = i;
        paramBundle.xEv = ((String)localObject1);
        paramBundle.xee = l;
        paramBundle.xef = ((String)localObject2);
        this.wXs = paramBundle;
        paramBundle = this.wXs;
        if (paramBundle == null) {
          p.bGy("viewCallback");
        }
        localObject1 = this.wXr;
        if (localObject1 == null) {
          p.bGy("presenter");
        }
        paramBundle.a((c.a)localObject1);
        paramBundle = this.wXs;
        if (paramBundle == null) {
          p.bGy("viewCallback");
        }
        if (this.xTb == null)
        {
          bool = true;
          paramBundle.xEz = bool;
          paramBundle = this.wXr;
          if (paramBundle == null) {
            p.bGy("presenter");
          }
          localObject1 = this.wXs;
          if (localObject1 == null) {
            p.bGy("viewCallback");
          }
          paramBundle.a((c.b)localObject1);
          if ((this.xTb == null) || (this.xTb == null)) {
            break label896;
          }
          localObject2 = this.wXr;
          if (localObject2 == null) {
            p.bGy("presenter");
          }
          localObject1 = this.xTb;
          if (localObject1 == null) {
            p.iCn();
          }
          localObject3 = this.xcZ;
          p.k(localObject1, "rsp");
          locale = new FinderTopicFeedLoader.e(0, 0, null, null);
          paramBundle = ((c.a)localObject2).xnX.getCache();
          if (paramBundle == null) {
            break label859;
          }
          paramBundle = paramBundle.lastBuffer;
          locale.setLastBuffer(paramBundle);
          locale.xEc = ((avy)localObject1).xEc;
          paramBundle = com.tencent.mm.plugin.finder.utils.aj.AGc;
          paramBundle = ((c.a)localObject2).xnX.getCache();
          if (paramBundle == null) {
            break label864;
          }
          paramBundle = paramBundle.mXB;
          if (paramBundle == null) {
            break label864;
          }
          paramBundle = (List)paramBundle;
          locale.setIncrementList(com.tencent.mm.plugin.finder.utils.aj.a(paramBundle, BaseFinderFeed.class));
          locale.setHasMore(true);
          locale.xJO = ((avy)localObject1).xEJ;
          locale.setPullType(1);
          paramBundle = ((avy)localObject1).SIq;
          if (paramBundle != null)
          {
            localObject1 = paramBundle.TTU;
            paramBundle = (Bundle)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            paramBundle = "";
          }
          locale.rsw = paramBundle;
          paramBundle = ((c.a)localObject2).xnX;
          if (paramBundle != null) {
            break label874;
          }
          paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader");
          AppMethodBeat.o(166276);
          throw paramBundle;
          paramBundle = paramBundle;
          Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
          paramBundle = null;
        }
      }
      catch (Exception paramBundle)
      {
        FinderTopicFeedLoader.e locale;
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
          paramBundle = null;
          continue;
          boolean bool = false;
          continue;
          label859:
          paramBundle = null;
          continue;
          label864:
          paramBundle = (List)v.aaAd;
        }
        label874:
        ((FinderTopicFeedLoader)paramBundle).xcZ = ((biv)localObject3);
        ((c.a)localObject2).xnX.onFetchDone((IResponse)locale);
        label896:
        paramBundle = new e((Context)this, 0, false);
        paramBundle.a((q.f)new d(this));
        paramBundle.a((q.g)new e(this));
        localObject1 = this.wXr;
        if (localObject1 == null) {
          p.bGy("presenter");
        }
        if (((bb.b)localObject1).type == 4)
        {
          paramBundle.b((q.f)new f(this));
          paramBundle.b((q.g)new g(this));
        }
        paramBundle.b((e.b)FinderTopicFeedUI.h.xTf);
        addIconOptionMenu(this.wXe, b.e.actionbar_icon_dark_more, (MenuItem.OnMenuItemClickListener)new FinderTopicFeedUI.i(paramBundle));
        int j = getIntent().getIntExtra("key_report_scene", 0);
        if (j != 0)
        {
          localObject1 = getIntent().getStringExtra("key_from_user");
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = "";
          }
          localObject1 = n.zWF;
          n.e(j, paramBundle, str, i);
          if (getIntent().getIntExtra("key_topic_type", 1) == 4)
          {
            localObject1 = n.zWF;
            n.a(getIntent().getLongExtra("key_ref_object_id", 0L), j, 4L, paramBundle, 0, 2);
          }
        }
        paramBundle = this.wXs;
        if (paramBundle == null) {
          p.bGy("viewCallback");
        }
        paramBundle.xvJ.getRecyclerView().a((RecyclerView.l)this.xTc);
        AppMethodBeat.o(166276);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166278);
    Object localObject = this.wXr;
    if (localObject == null) {
      p.bGy("presenter");
    }
    ((bb.b)localObject).onDetach();
    xLE.clear();
    localObject = this.wXs;
    if (localObject == null) {
      p.bGy("viewCallback");
    }
    ((c.b)localObject).xvJ.getRecyclerView().b((RecyclerView.l)this.xTc);
    super.onDestroy();
    AppMethodBeat.o(166278);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(291596);
    super.onPause();
    k localk = k.yBj;
    k.b(null, s.t.yGN, "26", c.yAj);
    AppMethodBeat.o(291596);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(291595);
    super.onResume();
    Object localObject = k.yBj;
    k.b(null, s.t.yGN, "26", c.yAi);
    localObject = this.wXr;
    if (localObject == null) {
      p.bGy("presenter");
    }
    ((bb.b)localObject).onUIResume();
    AppMethodBeat.o(291595);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$Companion;", "", "()V", "finderFeedCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderFeedCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setFinderFeedCacheMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderTopicFeedUI paramFinderTopicFeedUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166270);
      FinderTopicFeedUI.a(this.xTe);
      AppMethodBeat.o(166270);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(286215);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(286215);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(286213);
      Object localObject = new b();
      ((b)localObject).bn(paramRecyclerView);
      ((b)localObject).sg(paramInt1);
      ((b)localObject).sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = k.yBj;
      k.b(paramRecyclerView, s.t.yGN, "26", c.yAh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(286213);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class d
    implements q.f
  {
    d(FinderTopicFeedUI paramFinderTopicFeedUI) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(166272);
      p.j(paramo, "menu");
      Object localObject2;
      Object localObject1;
      boolean bool2;
      if (paramo.hJO())
      {
        localObject2 = this.xTe.getContext().getString(b.j.app_share_to_weixin);
        p.j(localObject2, "context.getString(R.string.app_share_to_weixin)");
        localObject1 = this.xTe.getContext().getString(b.j.finder_share_timeline);
        p.j(localObject1, "context.getString(R.string.finder_share_timeline)");
        if (!FinderTopicFeedUI.b(this.xTe)) {
          break label194;
        }
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        localObject2 = com.tencent.mm.plugin.finder.utils.aj.el("", b.j.finder_self_see_tips_forward);
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.el("", b.j.finder_self_see_tips_sns);
        bool2 = true;
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        int i = FinderTopicFeedUI.c(this.xTe);
        localObject2 = (CharSequence)localObject2;
        int j = b.i.finder_icons_filled_share;
        AppCompatActivity localAppCompatActivity = this.xTe.getContext();
        p.j(localAppCompatActivity, "context");
        paramo.a(i, (CharSequence)localObject2, j, localAppCompatActivity.getResources().getColor(b.c.Brand), bool1);
        paramo.a(FinderTopicFeedUI.d(this.xTe), (CharSequence)localObject1, b.i.bottomsheet_icon_moment, 0, bool2);
        AppMethodBeat.o(166272);
        return;
        label194:
        bool2 = false;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class e
    implements q.g
  {
    e(FinderTopicFeedUI paramFinderTopicFeedUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(166273);
      p.j(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == FinderTopicFeedUI.c(this.xTe))
      {
        if (FinderTopicFeedUI.b(this.xTe))
        {
          w.makeText((Context)this.xTe, b.j.finder_self_see_tips_forward, 0).show();
          AppMethodBeat.o(166273);
          return;
        }
        if (FinderTopicFeedUI.e(this.xTe).type == 4)
        {
          ac.a.a(ac.AEJ, (MMActivity)this.xTe, FinderTopicFeedUI.f(this.xTe), FinderTopicFeedUI.e(this.xTe).type, FinderTopicFeedUI.e(this.xTe).xEc, FinderTopicFeedUI.e(this.xTe).getIconUrl(), this.xTe.getString(b.j.finder_topic_suggest_tip, new Object[] { m.Nb(FinderTopicFeedUI.e(this.xTe).xEc) }), FinderTopicFeedUI.g(this.xTe).xJG, 49, FinderTopicFeedUI.h(this.xTe).xEv);
          AppMethodBeat.o(166273);
          return;
        }
        ac.a.a(ac.AEJ, (MMActivity)this.xTe, FinderTopicFeedUI.e(this.xTe).topic, FinderTopicFeedUI.e(this.xTe).type, FinderTopicFeedUI.e(this.xTe).xEc, FinderTopicFeedUI.e(this.xTe).getIconUrl(), this.xTe.getString(b.j.finder_topic_suggest_tip, new Object[] { m.Nb(FinderTopicFeedUI.e(this.xTe).xEc) }), FinderTopicFeedUI.g(this.xTe).xJG, 9, "");
        AppMethodBeat.o(166273);
        return;
      }
      if (paramInt == FinderTopicFeedUI.d(this.xTe))
      {
        if (FinderTopicFeedUI.b(this.xTe))
        {
          w.makeText((Context)this.xTe, b.j.finder_self_see_tips_sns, 0).show();
          AppMethodBeat.o(166273);
          return;
        }
        if (FinderTopicFeedUI.e(this.xTe).type == 4)
        {
          paramMenuItem = ac.AEJ;
          ac.a.a((MMActivity)this.xTe, FinderTopicFeedUI.f(this.xTe), FinderTopicFeedUI.e(this.xTe).type, FinderTopicFeedUI.e(this.xTe).xEc, FinderTopicFeedUI.e(this.xTe).getIconUrl(), this.xTe.getString(b.j.finder_topic_suggest_tip, new Object[] { m.Nb(FinderTopicFeedUI.e(this.xTe).xEc) }), FinderTopicFeedUI.g(this.xTe).xJG, 49, FinderTopicFeedUI.h(this.xTe).xEv);
          AppMethodBeat.o(166273);
          return;
        }
        paramMenuItem = ac.AEJ;
        ac.a.a((MMActivity)this.xTe, FinderTopicFeedUI.e(this.xTe).topic, FinderTopicFeedUI.e(this.xTe).type, FinderTopicFeedUI.e(this.xTe).xEc, FinderTopicFeedUI.e(this.xTe).getIconUrl(), this.xTe.getString(b.j.finder_topic_suggest_tip, new Object[] { m.Nb(FinderTopicFeedUI.e(this.xTe).xEc) }), FinderTopicFeedUI.g(this.xTe).xJG, 9, "");
      }
      AppMethodBeat.o(166273);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements q.f
  {
    f(FinderTopicFeedUI paramFinderTopicFeedUI) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(266037);
      p.j(paramo, "it");
      if (paramo.hJO()) {
        paramo.b(FinderTopicFeedUI.i(this.xTe), (CharSequence)this.xTe.getContext().getString(b.j.more_menu_back), b.i.icons_outlined_report_problem);
      }
      AppMethodBeat.o(266037);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements q.g
  {
    g(FinderTopicFeedUI paramFinderTopicFeedUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(287721);
      p.j(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == FinderTopicFeedUI.i(this.xTe))
      {
        paramMenuItem = FinderTopicFeedUI.h(this.xTe).xEv;
        if (paramMenuItem != null)
        {
          com.tencent.mm.plugin.finder.feed.logic.a locala = com.tencent.mm.plugin.finder.feed.logic.a.xFq;
          com.tencent.mm.plugin.finder.feed.logic.a.aB((Context)this.xTe, paramMenuItem);
          AppMethodBeat.o(287721);
          return;
        }
      }
      AppMethodBeat.o(287721);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI
 * JD-Core Version:    0.7.0.1
 */