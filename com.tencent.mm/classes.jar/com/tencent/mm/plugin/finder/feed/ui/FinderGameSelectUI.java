package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.util.g;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.bne;
import com.tencent.mm.protocal.protobuf.bnw;
import com.tencent.mm.protocal.protobuf.ezl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.view.e.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.l;
import kotlin.t;

@com.tencent.mm.ui.base.a(32)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderGameSelectUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderGameLiveBaseUI;", "()V", "TAG", "", "gameList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/view/convert/GameSelectItem;", "Lkotlin/collections/ArrayList;", "getGameList", "()Ljava/util/ArrayList;", "root", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "setRoot", "(Landroid/view/View;)V", "rv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRv", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRv", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "searchEdit", "Landroid/widget/EditText;", "searchIcon", "Landroid/widget/ImageView;", "searchViewContainer", "Landroid/widget/RelativeLayout;", "selectedGame", "getSelectedGame", "()Lcom/tencent/mm/plugin/finder/live/view/convert/GameSelectItem;", "setSelectedGame", "(Lcom/tencent/mm/plugin/finder/live/view/convert/GameSelectItem;)V", "showSearchLayout", "", "getLayoutId", "", "goPostUI", "", "Lcom/tencent/mm/protocal/protobuf/GameUserInfo;", "goSearchUI", "initData", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "selectPosition", "position", "setWindowStyle", "plugin-finder_release"})
public final class FinderGameSelectUI
  extends FinderGameLiveBaseUI
{
  private final String TAG;
  private HashMap _$_findViewCache;
  public View jac;
  private final ArrayList<com.tencent.mm.plugin.finder.live.view.convert.d> xOc;
  com.tencent.mm.plugin.finder.live.view.convert.d xOd;
  public WxRecyclerView xOe;
  private ImageView xOf;
  private EditText xOg;
  private RelativeLayout xOh;
  private boolean xOi;
  
  public FinderGameSelectUI()
  {
    AppMethodBeat.i(277295);
    this.TAG = "Finder.FinderGameSelectUI";
    this.xOc = new ArrayList();
    AppMethodBeat.o(277295);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(277300);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(277300);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(277299);
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
    AppMethodBeat.o(277299);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_game_select_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(277294);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().clearFlags(67108864);
      paramBundle = getWindow();
      kotlin.g.b.p.j(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      kotlin.g.b.p.j(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(1792);
      getWindow().addFlags(-2147483648);
      paramBundle = getWindow();
      kotlin.g.b.p.j(paramBundle, "window");
      paramBundle.setStatusBarColor(0);
      paramBundle = getWindow();
      kotlin.g.b.p.j(paramBundle, "window");
      paramBundle.setNavigationBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(51);
    paramBundle = findViewById(b.f.game_select_root);
    Object localObject1 = com.tencent.mm.plugin.finder.utils.p.ADF;
    com.tencent.mm.plugin.finder.utils.p.eM(paramBundle);
    paramBundle = (com.tencent.mm.cd.a)new baa();
    localObject1 = getIntent().getByteArrayExtra("APP_LIST");
    try
    {
      paramBundle.parseFrom((byte[])localObject1);
      localObject1 = (baa)paramBundle;
      if (localObject1 != null)
      {
        paramBundle = this.xOc;
        localObject1 = ((baa)localObject1).SLB;
        kotlin.g.b.p.j(localObject1, "game_user_info_list");
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bnw)((Iterator)localObject2).next();
          kotlin.g.b.p.j(localObject3, "it");
          ((Collection)localObject1).add(new com.tencent.mm.plugin.finder.live.view.convert.d((bnw)localObject3));
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
        paramBundle = null;
      }
      paramBundle.addAll((Collection)localObject1);
      this.xOi = getIntent().getBooleanExtra("SHOW_SEARCH_LAYOUT", false);
      if (this.xOc.isEmpty())
      {
        Log.w(this.TAG, "gameList empty");
        finish();
      }
      paramBundle = ((Iterable)this.xOc).iterator();
      while (paramBundle.hasNext()) {
        ((com.tencent.mm.plugin.finder.live.view.convert.d)paramBundle.next()).xUg = false;
      }
      paramBundle = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(paramBundle, "MMKernel.storage()");
      Object localObject2 = paramBundle.aHp().a(ar.a.VCA, "");
      Object localObject3 = ((Iterable)this.xOc).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = ((Iterator)localObject3).next();
        paramBundle = ((com.tencent.mm.plugin.finder.live.view.convert.d)localObject1).zaG.SYT;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.app_id;
          label478:
          if (!kotlin.g.b.p.h(paramBundle, localObject2)) {
            break label1027;
          }
        }
      }
      for (paramBundle = (Bundle)localObject1;; paramBundle = null)
      {
        paramBundle = (com.tencent.mm.plugin.finder.live.view.convert.d)paramBundle;
        if (paramBundle != null)
        {
          paramBundle.xUg = true;
          this.xOd = paramBundle;
        }
        localObject1 = findViewById(b.f.game_select_top_close);
        paramBundle = findViewById(b.f.ok_btn);
        localObject2 = findViewById(b.f.game_select_root);
        kotlin.g.b.p.j(localObject2, "findViewById(R.id.game_select_root)");
        this.jac = ((View)localObject2);
        localObject2 = findViewById(b.f.game_rv);
        kotlin.g.b.p.j(localObject2, "findViewById(R.id.game_rv)");
        this.xOe = ((WxRecyclerView)localObject2);
        localObject2 = findViewById(b.f.finder_live_game_search_icon);
        kotlin.g.b.p.j(localObject2, "findViewById(R.id.finder_live_game_search_icon)");
        this.xOf = ((ImageView)localObject2);
        localObject2 = findViewById(b.f.finder_live_game_search_edit);
        kotlin.g.b.p.j(localObject2, "findViewById(R.id.finder_live_game_search_edit)");
        this.xOg = ((EditText)localObject2);
        localObject2 = findViewById(b.f.finder_live_game_search_group_root);
        kotlin.g.b.p.j(localObject2, "findViewById(R.id.finder…e_game_search_group_root)");
        this.xOh = ((RelativeLayout)localObject2);
        localObject2 = g.yPJ;
        localObject2 = z.bdh();
        localObject3 = this.jac;
        if (localObject3 == null) {
          kotlin.g.b.p.bGy("root");
        }
        g.a((String)localObject2, "", (View)localObject3);
        ((View)localObject1).post((Runnable)new b((View)localObject1));
        ((View)localObject1).setOnClickListener((View.OnClickListener)new c(this));
        localObject1 = this.xOe;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("rv");
        }
        ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
        localObject1 = this.xOe;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("rv");
        }
        localObject2 = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new d(this), this.xOc);
        ((com.tencent.mm.view.recyclerview.h)localObject2).YSn = ((h.c)new a(this));
        ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
        localObject1 = this.xOe;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("rv");
        }
        com.tencent.mm.view.f.a((RecyclerView)localObject1, (e.a)new e());
        paramBundle.setOnClickListener((View.OnClickListener)new f(this));
        if (!this.xOi) {
          break label1034;
        }
        paramBundle = this.xOf;
        if (paramBundle == null) {
          kotlin.g.b.p.bGy("searchIcon");
        }
        localObject1 = paramBundle.getLayoutParams();
        paramBundle = (Bundle)localObject1;
        if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
          paramBundle = null;
        }
        paramBundle = (RelativeLayout.LayoutParams)paramBundle;
        if (paramBundle != null) {
          paramBundle.setMarginStart((int)getResources().getDimension(b.d.Edge_13A));
        }
        paramBundle = this.xOg;
        if (paramBundle == null) {
          kotlin.g.b.p.bGy("searchEdit");
        }
        paramBundle.setOnClickListener((View.OnClickListener)new g(this));
        paramBundle = this.xOg;
        if (paramBundle == null) {
          kotlin.g.b.p.bGy("searchEdit");
        }
        paramBundle.setInputType(0);
        paramBundle = this.xOg;
        if (paramBundle == null) {
          kotlin.g.b.p.bGy("searchEdit");
        }
        paramBundle.setFocusable(false);
        paramBundle = this.xOg;
        if (paramBundle == null) {
          kotlin.g.b.p.bGy("searchEdit");
        }
        paramBundle.setFocusableInTouchMode(false);
        paramBundle = this.xOh;
        if (paramBundle == null) {
          kotlin.g.b.p.bGy("searchViewContainer");
        }
        paramBundle.setOnClickListener((View.OnClickListener)new h(this));
        AppMethodBeat.o(277294);
        return;
        paramBundle = null;
        break label478;
        label1027:
        break;
      }
      label1034:
      paramBundle = this.xOh;
      if (paramBundle == null) {
        kotlin.g.b.p.bGy("searchViewContainer");
      }
      paramBundle.setVisibility(8);
      AppMethodBeat.o(277294);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setRoot(View paramView)
  {
    AppMethodBeat.i(277293);
    kotlin.g.b.p.k(paramView, "<set-?>");
    this.jac = paramView;
    AppMethodBeat.o(277293);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderGameSelectUI$initViews$4$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class a
    implements h.c<i>
  {
    a(FinderGameSelectUI paramFinderGameSelectUI) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(290174);
      Object localObject1 = new Rect();
      this.xOk.getHitRect((Rect)localObject1);
      ((Rect)localObject1).inset(((Rect)localObject1).width() * -2, -((Rect)localObject1).width());
      Object localObject2 = this.xOk;
      kotlin.g.b.p.j(localObject2, "topBack");
      localObject2 = ((View)localObject2).getParent();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(290174);
        throw ((Throwable)localObject1);
      }
      ((View)localObject2).setTouchDelegate(new TouchDelegate((Rect)localObject1, this.xOk));
      AppMethodBeat.o(290174);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderGameSelectUI paramFinderGameSelectUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(288724);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderGameSelectUI$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.xOj.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderGameSelectUI$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(288724);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderGameSelectUI$initViews$3", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(272061);
      if (paramInt == com.tencent.mm.plugin.finder.live.view.convert.d.class.hashCode())
      {
        localObject = (e)new com.tencent.mm.plugin.finder.live.view.convert.c();
        AppMethodBeat.o(272061);
        return localObject;
      }
      Object localObject = aj.AGc;
      aj.em(FinderGameSelectUI.a(this.xOj), paramInt);
      localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
      AppMethodBeat.o(272061);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderGameSelectUI$initViews$5", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "exposedSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getExposedSet", "()Ljava/util/HashSet;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-finder_release"})
  public static final class e
    extends e.a
  {
    private final HashSet<String> xlV;
    
    e()
    {
      AppMethodBeat.i(279616);
      this.xlV = new HashSet();
      AppMethodBeat.o(279616);
    }
    
    public final void b(View paramView, List<? extends RecyclerView.v> paramList)
    {
      AppMethodBeat.i(279615);
      kotlin.g.b.p.k(paramView, "parent");
      kotlin.g.b.p.k(paramList, "exposedHolders");
      Iterator localIterator = ((Iterable)paramList).iterator();
      while (localIterator.hasNext())
      {
        paramList = (RecyclerView.v)localIterator.next();
        paramView = paramList;
        if (!(paramList instanceof i)) {
          paramView = null;
        }
        paramView = (i)paramView;
        if (paramView != null)
        {
          paramList = paramView.ihX();
          paramView = paramList;
          if (!(paramList instanceof com.tencent.mm.plugin.finder.live.view.convert.d)) {
            paramView = null;
          }
          paramView = (com.tencent.mm.plugin.finder.live.view.convert.d)paramView;
          if (paramView != null)
          {
            paramList = paramView.zaG.SYT;
            if ((paramList != null) && (paramList.SYi == 1))
            {
              paramView = paramView.zaG.SYT;
              if (paramView != null)
              {
                paramView = paramView.app_id;
                if (paramView != null)
                {
                  kotlin.g.b.p.j(paramView, "feed.gameInfo.app_info?.app_id ?: return@loop");
                  if (!this.xlV.contains(paramView))
                  {
                    this.xlV.add(paramView);
                    paramList = o.ADA;
                    o.bd(1, paramView);
                  }
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(279615);
    }
    
    public final boolean dpC()
    {
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderGameSelectUI paramFinderGameSelectUI) {}
    
    public final void onClick(View paramView)
    {
      String str = null;
      AppMethodBeat.i(283695);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderGameSelectUI$initViews$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      localObject1 = this.xOj.xOd;
      if (localObject1 != null)
      {
        paramView = ((com.tencent.mm.plugin.finder.live.view.convert.d)localObject1).zaG;
        if (paramView != null)
        {
          paramView = paramView.SYT;
          if ((paramView != null) && (paramView.SYi == 1))
          {
            paramView = o.ADA;
            paramView = ((com.tencent.mm.plugin.finder.live.view.convert.d)localObject1).zaG.SYT;
            if (paramView != null)
            {
              paramView = paramView.app_id;
              o.bd(2, paramView);
              label100:
              paramView = FinderGameSelectUI.a(this.xOj);
              Object localObject2 = new StringBuilder("Finder_Game_Select_Hardcode :");
              com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
              Log.i(paramView, ((Number)com.tencent.mm.plugin.finder.storage.d.dTL().aSr()).intValue());
              paramView = com.tencent.mm.plugin.finder.storage.d.AjH;
              switch (((Number)com.tencent.mm.plugin.finder.storage.d.dTL().aSr()).intValue())
              {
              default: 
                label188:
                if (localObject1 != null)
                {
                  localObject2 = ((com.tencent.mm.plugin.finder.live.view.convert.d)localObject1).zaG.SYT;
                  paramView = str;
                  if (localObject2 != null) {
                    paramView = ((bne)localObject2).app_id;
                  }
                  if ((!Util.isNullOrNil(paramView)) && (((com.tencent.mm.plugin.finder.live.view.convert.d)localObject1).zaG.SYT != null)) {
                    break;
                  }
                }
                else
                {
                  w.makeText((Context)this.xOj.getContext(), b.j.finder_live_game_select_title, 0).show();
                }
                break;
              }
            }
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderGameSelectUI$initViews$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(283695);
        return;
        paramView = null;
        break;
        paramView = o.ADA;
        if (o.ecW() != 18L) {
          break label100;
        }
        paramView = o.ADA;
        o.QJ(3);
        break label100;
        if (localObject1 == null) {
          break label188;
        }
        paramView = ((com.tencent.mm.plugin.finder.live.view.convert.d)localObject1).zaG;
        if (paramView == null) {
          break label188;
        }
        paramView = paramView.SYO;
        if (paramView == null) {
          break label188;
        }
        paramView.UzN = 1;
        break label188;
        if (localObject1 == null) {
          break label188;
        }
        paramView = ((com.tencent.mm.plugin.finder.live.view.convert.d)localObject1).zaG;
        if (paramView == null) {
          break label188;
        }
        paramView = paramView.SYO;
        if (paramView == null) {
          break label188;
        }
        paramView.TLD = 1;
        break label188;
        paramView = ((com.tencent.mm.plugin.finder.live.view.convert.d)localObject1).zaG.SYO;
        if ((paramView == null) || (paramView.UzN != 1))
        {
          paramView = ((com.tencent.mm.plugin.finder.live.view.convert.d)localObject1).zaG.SYO;
          if ((paramView == null) || (paramView.TLD != 1)) {}
        }
        else
        {
          paramView = ((com.tencent.mm.plugin.finder.live.view.convert.d)localObject1).zaG.SYO;
          if ((paramView != null) && (paramView.UzN == 1)) {}
          for (paramView = this.xOj.getContext().getString(b.j.wcfinder_gamelive_select_failed1);; paramView = this.xOj.getContext().getString(b.j.wcfinder_gamelive_select_failed2))
          {
            kotlin.g.b.p.j(paramView, "if (game.gameInfo.user_s…ailed2)\n                }");
            com.tencent.mm.ui.base.h.c((Context)this.xOj.getContext(), paramView, "", this.xOj.getContext().getString(b.j.app_ok), "", (DialogInterface.OnClickListener)1.xOl, (DialogInterface.OnClickListener)2.xOm);
            break;
          }
        }
        paramView = ((com.tencent.mm.plugin.finder.live.view.convert.d)localObject1).zaG.SYT;
        if (paramView != null)
        {
          str = paramView.app_id;
          paramView = str;
          if (str != null) {}
        }
        else
        {
          paramView = "";
        }
        new com.tencent.mm.plugin.finder.live.cgi.j(paramView, 0).e((Context)this.xOj, this.xOj.getResources().getString(b.j.finder_waiting), 500L).bhW().a((com.tencent.mm.vending.e.b)this.xOj).g((com.tencent.mm.vending.c.a)new com.tencent.mm.vending.c.a() {});
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(FinderGameSelectUI paramFinderGameSelectUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(272534);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderGameSelectUI$initViews$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = o.ADA;
      o.ecX();
      FinderGameSelectUI.b(this.xOj);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderGameSelectUI$initViews$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(272534);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(FinderGameSelectUI paramFinderGameSelectUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(246317);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderGameSelectUI$initViews$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      FinderGameSelectUI.b(this.xOj);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderGameSelectUI$initViews$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(246317);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderGameSelectUI
 * JD-Core Version:    0.7.0.1
 */