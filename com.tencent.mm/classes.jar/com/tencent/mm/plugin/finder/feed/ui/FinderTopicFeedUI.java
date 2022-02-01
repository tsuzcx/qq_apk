package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.feed.av.a;
import com.tencent.mm.plugin.finder.feed.av.b;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.e;
import com.tencent.mm.plugin.finder.feed.model.h;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.live.c;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.s.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.atv;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.dcz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "MENU_ID_COMPLAINT", "", "MENU_ID_MORE", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_TIMELINE", "TAB_TYPE", "TAG", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "firstRsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "onHellScroller", "com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "getCommentScene", "getFollowPatShareTitle", "getLayoutId", "getReportType", "goBack", "", "notShare", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "setIconMenu", "Companion", "plugin-finder_release"})
public final class FinderTopicFeedUI
  extends MMFinderUI
{
  private static ConcurrentHashMap<Long, FinderItem> tZo;
  public static final a udw;
  private final String TAG;
  private HashMap _$_findViewCache;
  private final int pLU;
  private int tTm;
  private av.a tqH;
  private av.b tqI;
  private FinderTopicFeedLoader tqJ;
  private final int tqu;
  private final int tqv;
  private bcc tvs;
  private final int udt;
  private atv udu;
  private final c udv;
  
  static
  {
    AppMethodBeat.i(178306);
    udw = new a((byte)0);
    tZo = new ConcurrentHashMap();
    AppMethodBeat.o(178306);
  }
  
  public FinderTopicFeedUI()
  {
    AppMethodBeat.i(245589);
    this.TAG = "Finder.FinderTopicFeedUI";
    this.tqu = 10001;
    this.tqv = 10002;
    this.pLU = 10003;
    this.udt = 10004;
    this.udv = new c();
    AppMethodBeat.o(245589);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245594);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245594);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245593);
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
    AppMethodBeat.o(245593);
    return localView1;
  }
  
  public final int ddN()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(245586);
    int i = getIntent().getIntExtra("key_topic_type", 1);
    if (i == 1)
    {
      AppMethodBeat.o(245586);
      return 22;
    }
    if (i == 4)
    {
      AppMethodBeat.o(245586);
      return 49;
    }
    if (i == 5)
    {
      AppMethodBeat.o(245586);
      return 64;
    }
    AppMethodBeat.o(245586);
    return 26;
  }
  
  public final int getLayoutId()
  {
    return 2131494657;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(166276);
    super.onCreate(paramBundle);
    overridePendingTransition(2130772169, 2130771986);
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    setActionbarColor(getResources().getColor(2131099650));
    tZo.clear();
    int i = getIntent().getIntExtra("key_topic_type", 1);
    String str = getIntent().getStringExtra("key_topic_title");
    Object localObject1 = getIntent().getStringExtra("KEY_FOLLOW_ID");
    getIntent().getStringExtra("KEY_MUSIC_INFO");
    long l = getIntent().getLongExtra("KEY_TOPIC_ID", 0L);
    Object localObject2 = getIntent().getStringExtra("KEY_TOPIC_NONCE_ID");
    this.tTm = getIntent().getIntExtra("KEY_TAB_TYPE", 0);
    Log.i(this.TAG, "type:" + i + ", topic:" + str);
    setMMTitle("");
    paramBundle = (com.tencent.mm.bw.a)new bcc();
    Object localObject3 = getIntent().getByteArrayExtra("KEY_SECTION_INFO");
    try
    {
      paramBundle.parseFrom((byte[])localObject3);
      this.tvs = ((bcc)paramBundle);
      paramBundle = (com.tencent.mm.bw.a)new atv();
      localObject3 = getIntent().getByteArrayExtra("KEY_TOPIC_RSP");
    }
    catch (Exception paramBundle)
    {
      try
      {
        paramBundle.parseFrom((byte[])localObject3);
        this.udu = ((atv)paramBundle);
        p.g(str, "topic");
        paramBundle = com.tencent.mm.ui.component.a.PRN;
        paramBundle = new FinderTopicFeedLoader(i, str, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).dIx());
        localObject3 = getIntent();
        p.g(localObject3, "intent");
        paramBundle.initFromCache((Intent)localObject3);
        paramBundle.tTG = ((String)localObject1);
        this.tqJ = paramBundle;
        paramBundle = (MMActivity)this;
        getCommentScene();
        localObject3 = this.tqJ;
        if (localObject3 == null) {
          p.btv("feedLoader");
        }
        paramBundle = new av.a(paramBundle, (BaseFinderFeedLoader)localObject3);
        paramBundle.atn(str);
        paramBundle.type = i;
        this.tqH = paramBundle;
        paramBundle = this.tqH;
        if (paramBundle == null) {
          p.btv("presenter");
        }
        paramBundle.tTm = this.tTm;
        paramBundle = new av.b((MMActivity)this, getCommentScene(), (byte)0);
        paramBundle.atn(str);
        paramBundle.type = i;
        paramBundle.tTG = ((String)localObject1);
        paramBundle.twp = l;
        paramBundle.twq = ((String)localObject2);
        this.tqI = paramBundle;
        paramBundle = this.tqI;
        if (paramBundle == null) {
          p.btv("viewCallback");
        }
        localObject1 = this.tqH;
        if (localObject1 == null) {
          p.btv("presenter");
        }
        paramBundle.a((c.a)localObject1);
        paramBundle = this.tqI;
        if (paramBundle == null) {
          p.btv("viewCallback");
        }
        if (this.udu == null)
        {
          bool = true;
          paramBundle.tTJ = bool;
          paramBundle = this.tqH;
          if (paramBundle == null) {
            p.btv("presenter");
          }
          localObject1 = this.tqI;
          if (localObject1 == null) {
            p.btv("viewCallback");
          }
          paramBundle.a((c.b)localObject1);
          if ((this.udu == null) || (this.udu == null)) {
            break label896;
          }
          localObject2 = this.tqH;
          if (localObject2 == null) {
            p.btv("presenter");
          }
          localObject1 = this.udu;
          if (localObject1 == null) {
            p.hyc();
          }
          localObject3 = this.tvs;
          p.h(localObject1, "rsp");
          locale = new FinderTopicFeedLoader.e(0, 0, null, null);
          paramBundle = ((c.a)localObject2).tFM.getCache();
          if (paramBundle == null) {
            break label859;
          }
          paramBundle = paramBundle.lastBuffer;
          locale.setLastBuffer(paramBundle);
          locale.tTn = ((atv)localObject1).tTn;
          paramBundle = y.vXH;
          paramBundle = ((c.a)localObject2).tFM.getCache();
          if (paramBundle == null) {
            break label864;
          }
          paramBundle = paramBundle.kgc;
          if (paramBundle == null) {
            break label864;
          }
          paramBundle = (List)paramBundle;
          locale.setIncrementList(y.a(paramBundle, BaseFinderFeed.class));
          locale.setHasMore(true);
          locale.tXS = ((atv)localObject1).tTT;
          locale.setPullType(1);
          paramBundle = ((atv)localObject1).LEI;
          if (paramBundle != null)
          {
            localObject1 = paramBundle.MIg;
            paramBundle = (Bundle)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            paramBundle = "";
          }
          locale.oqZ = paramBundle;
          paramBundle = ((c.a)localObject2).tFM;
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
          paramBundle = (List)v.SXr;
        }
        label874:
        ((FinderTopicFeedLoader)paramBundle).tvs = ((bcc)localObject3);
        ((c.a)localObject2).tFM.onFetchDone((IResponse)locale);
        label896:
        paramBundle = new e((Context)this, 0, false);
        paramBundle.a((o.f)new d(this));
        paramBundle.a((o.g)new e(this));
        localObject1 = this.tqH;
        if (localObject1 == null) {
          p.btv("presenter");
        }
        if (((av.a)localObject1).type == 4)
        {
          paramBundle.b((o.f)new f(this));
          paramBundle.b((o.g)new g(this));
        }
        paramBundle.b((e.b)FinderTopicFeedUI.h.udy);
        addIconOptionMenu(this.tqu, 2131230858, (MenuItem.OnMenuItemClickListener)new i(paramBundle));
        int j = getIntent().getIntExtra("key_report_scene", 0);
        if (j != 0)
        {
          localObject1 = getIntent().getStringExtra("key_from_user");
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = "";
          }
          localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
          com.tencent.mm.plugin.finder.report.k.e(j, paramBundle, str, i);
          if (getIntent().getIntExtra("key_topic_type", 1) == 4)
          {
            localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a(getIntent().getLongExtra("key_ref_object_id", 0L), j, 4L, paramBundle, 0, 2);
          }
        }
        paramBundle = this.tqI;
        if (paramBundle == null) {
          p.btv("viewCallback");
        }
        paramBundle.tLS.getRecyclerView().a((RecyclerView.l)this.udv);
        AppMethodBeat.o(166276);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166278);
    Object localObject = this.tqH;
    if (localObject == null) {
      p.btv("presenter");
    }
    ((av.a)localObject).onDetach();
    tZo.clear();
    localObject = this.tqI;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    ((c.b)localObject).tLS.getRecyclerView().b((RecyclerView.l)this.udv);
    super.onDestroy();
    AppMethodBeat.o(166278);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(245588);
    super.onPause();
    com.tencent.mm.plugin.finder.report.live.k localk = com.tencent.mm.plugin.finder.report.live.k.vkd;
    com.tencent.mm.plugin.finder.report.live.k.b(null, s.p.voA, "26", c.vjg);
    AppMethodBeat.o(245588);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(245587);
    super.onResume();
    com.tencent.mm.plugin.finder.report.live.k localk = com.tencent.mm.plugin.finder.report.live.k.vkd;
    com.tencent.mm.plugin.finder.report.live.k.b(null, s.p.voA, "26", c.vjf);
    AppMethodBeat.o(245587);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$Companion;", "", "()V", "finderFeedCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderFeedCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setFinderFeedCacheMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderTopicFeedUI paramFinderTopicFeedUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166270);
      FinderTopicFeedUI.a(this.udx);
      AppMethodBeat.o(166270);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(245581);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(245581);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(245580);
      Object localObject = new b();
      ((b)localObject).bm(paramRecyclerView);
      ((b)localObject).pH(paramInt1);
      ((b)localObject).pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = com.tencent.mm.plugin.finder.report.live.k.vkd;
      com.tencent.mm.plugin.finder.report.live.k.b(paramRecyclerView, s.p.voA, "26", c.vje);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(245580);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class d
    implements o.f
  {
    d(FinderTopicFeedUI paramFinderTopicFeedUI) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(166272);
      p.g(paramm, "menu");
      Object localObject2;
      Object localObject1;
      boolean bool2;
      if (paramm.gKQ())
      {
        localObject2 = this.udx.getContext().getString(2131755985);
        p.g(localObject2, "context.getString(R.string.app_share_to_weixin)");
        localObject1 = this.udx.getContext().getString(2131760572);
        p.g(localObject1, "context.getString(R.string.finder_share_timeline)");
        if (!FinderTopicFeedUI.b(this.udx)) {
          break label183;
        }
        localObject1 = y.vXH;
        localObject2 = y.dP("", 2131760540);
        localObject1 = y.vXH;
        localObject1 = y.dP("", 2131760541);
        bool2 = true;
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        int i = FinderTopicFeedUI.c(this.udx);
        localObject2 = (CharSequence)localObject2;
        AppCompatActivity localAppCompatActivity = this.udx.getContext();
        p.g(localAppCompatActivity, "context");
        paramm.a(i, (CharSequence)localObject2, 2131690251, localAppCompatActivity.getResources().getColor(2131099710), bool1);
        paramm.a(FinderTopicFeedUI.d(this.udx), (CharSequence)localObject1, 2131689830, 0, bool2);
        AppMethodBeat.o(166272);
        return;
        label183:
        bool2 = false;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class e
    implements o.g
  {
    e(FinderTopicFeedUI paramFinderTopicFeedUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(166273);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == FinderTopicFeedUI.c(this.udx))
      {
        if (FinderTopicFeedUI.b(this.udx))
        {
          u.makeText((Context)this.udx, 2131760540, 0).show();
          AppMethodBeat.o(166273);
          return;
        }
        if (FinderTopicFeedUI.e(this.udx).type == 4)
        {
          s.a.a(s.vWt, (MMActivity)this.udx, FinderTopicFeedUI.f(this.udx), FinderTopicFeedUI.e(this.udx).type, FinderTopicFeedUI.e(this.udx).tTn, FinderTopicFeedUI.e(this.udx).getIconUrl(), this.udx.getString(2131760642, new Object[] { com.tencent.mm.plugin.finder.utils.k.Gb(FinderTopicFeedUI.e(this.udx).tTn) }), FinderTopicFeedUI.g(this.udx).tXM, 49, FinderTopicFeedUI.h(this.udx).tTG);
          AppMethodBeat.o(166273);
          return;
        }
        s.a.a(s.vWt, (MMActivity)this.udx, FinderTopicFeedUI.e(this.udx).dST, FinderTopicFeedUI.e(this.udx).type, FinderTopicFeedUI.e(this.udx).tTn, FinderTopicFeedUI.e(this.udx).getIconUrl(), this.udx.getString(2131760642, new Object[] { com.tencent.mm.plugin.finder.utils.k.Gb(FinderTopicFeedUI.e(this.udx).tTn) }), FinderTopicFeedUI.g(this.udx).tXM, 9, "");
        AppMethodBeat.o(166273);
        return;
      }
      if (paramInt == FinderTopicFeedUI.d(this.udx))
      {
        if (FinderTopicFeedUI.b(this.udx))
        {
          u.makeText((Context)this.udx, 2131760541, 0).show();
          AppMethodBeat.o(166273);
          return;
        }
        if (FinderTopicFeedUI.e(this.udx).type == 4)
        {
          paramMenuItem = s.vWt;
          s.a.a((MMActivity)this.udx, FinderTopicFeedUI.f(this.udx), FinderTopicFeedUI.e(this.udx).type, FinderTopicFeedUI.e(this.udx).tTn, FinderTopicFeedUI.e(this.udx).getIconUrl(), this.udx.getString(2131760642, new Object[] { com.tencent.mm.plugin.finder.utils.k.Gb(FinderTopicFeedUI.e(this.udx).tTn) }), FinderTopicFeedUI.g(this.udx).tXM, 49, FinderTopicFeedUI.h(this.udx).tTG);
          AppMethodBeat.o(166273);
          return;
        }
        paramMenuItem = s.vWt;
        s.a.a((MMActivity)this.udx, FinderTopicFeedUI.e(this.udx).dST, FinderTopicFeedUI.e(this.udx).type, FinderTopicFeedUI.e(this.udx).tTn, FinderTopicFeedUI.e(this.udx).getIconUrl(), this.udx.getString(2131760642, new Object[] { com.tencent.mm.plugin.finder.utils.k.Gb(FinderTopicFeedUI.e(this.udx).tTn) }), FinderTopicFeedUI.g(this.udx).tXM, 9, "");
      }
      AppMethodBeat.o(166273);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements o.f
  {
    f(FinderTopicFeedUI paramFinderTopicFeedUI) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(245582);
      p.g(paramm, "it");
      if (paramm.gKQ()) {
        paramm.b(FinderTopicFeedUI.i(this.udx), (CharSequence)this.udx.getContext().getString(2131763159), 2131690898);
      }
      AppMethodBeat.o(245582);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements o.g
  {
    g(FinderTopicFeedUI paramFinderTopicFeedUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(245583);
      p.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == FinderTopicFeedUI.i(this.udx))
      {
        paramMenuItem = FinderTopicFeedUI.h(this.udx).tTG;
        if (paramMenuItem != null)
        {
          com.tencent.mm.plugin.finder.feed.logic.a locala = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
          com.tencent.mm.plugin.finder.feed.logic.a.aC((Context)this.udx, paramMenuItem);
          AppMethodBeat.o(245583);
          return;
        }
      }
      AppMethodBeat.o(245583);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class i
    implements MenuItem.OnMenuItemClickListener
  {
    i(e parame) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(245585);
      this.nkZ.dGm();
      AppMethodBeat.o(245585);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI
 * JD-Core Version:    0.7.0.1
 */