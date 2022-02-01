package com.tencent.mm.plugin.finder.live.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.bf;
import com.tencent.mm.plugin.finder.live.view.adapter.c;
import com.tencent.mm.plugin.finder.live.view.adapter.c.a;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.protocal.protobuf.fit;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.e.a;
import com.tencent.mm.view.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Landroid/view/View$OnClickListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "cancelTv", "Landroid/view/View;", "clearIcon", "closeIcon", "editText", "Landroid/widget/EditText;", "emptyTv", "Landroid/widget/TextView;", "gameSearchList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/GameSearchUserInfo;", "Lkotlin/collections/ArrayList;", "hasNext", "", "loadingView", "netSceneSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGameSearch;", "offset", "", "query", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "root", "searchAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveSearchAdapter;", "clearSearchList", "", "configRecentPlayContainer", "show", "getLayoutId", "", "getQuery", "gotoPostUI", "gameSearchItem", "Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;", "initView", "loadSearchData", "onClick", "v", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class g
  extends UIComponent
  implements View.OnClickListener, i
{
  public static final a zcd;
  EditText bGw;
  private RecyclerView jLl;
  private View jac;
  private TextView jkI;
  private View kGT;
  private String query;
  private RefreshLoadMoreLayout xvJ;
  private bf zbR;
  private View zbW;
  private View zbX;
  private View zbY;
  private String zbZ;
  private boolean zca;
  private final ArrayList<bnu> zcb;
  private final c zcc;
  
  static
  {
    AppMethodBeat.i(281701);
    zcd = new a((byte)0);
    AppMethodBeat.o(281701);
  }
  
  public g(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(281699);
    this.query = "";
    this.zbZ = "";
    this.zcb = new ArrayList();
    this.zcc = new c();
    AppMethodBeat.o(281699);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.view.convert.b paramb)
  {
    AppMethodBeat.i(281692);
    kotlin.g.b.p.k(paramb, "gameSearchItem");
    Intent localIntent = new Intent();
    localIntent.putExtra("TICKET", "");
    Object localObject = paramb.zaE.SYP;
    if (localObject != null)
    {
      String str = ((bnt)localObject).appid;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localIntent.putExtra("APPID", (String)localObject);
    paramb = paramb.zaE.SYP;
    if (paramb != null)
    {
      paramb = paramb.SYj;
      if (paramb == null) {}
    }
    for (int i = paramb.RYL;; i = 0)
    {
      localIntent.putExtra("VERSION_TYPE", i);
      localIntent.putExtra("POST_FROM_SCENE", 0);
      paramb = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.af((Context)getContext(), localIntent);
      AppMethodBeat.o(281692);
      return;
    }
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_game_search_ui;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(281697);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = b.f.finder_live_game_search_clear_icon;
      if (paramView != null) {
        break label87;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(281697);
      return;
      paramView = null;
      break;
      label87:
      if (paramView.intValue() == i)
      {
        paramView = this.bGw;
        if (paramView == null) {
          kotlin.g.b.p.bGy("editText");
        }
        paramView.setText((CharSequence)"");
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(281690);
    super.onCreate(paramBundle);
    paramBundle = getActivity().findViewById(b.f.game_search_root);
    kotlin.g.b.p.j(paramBundle, "activity.findViewById(R.id.game_search_root)");
    this.jac = paramBundle;
    paramBundle = getActivity().findViewById(b.f.game_select_top_close);
    kotlin.g.b.p.j(paramBundle, "activity.findViewById(R.id.game_select_top_close)");
    this.zbW = paramBundle;
    paramBundle = getActivity().findViewById(b.f.rl_layout);
    kotlin.g.b.p.j(paramBundle, "activity.findViewById(R.id.rl_layout)");
    this.xvJ = ((RefreshLoadMoreLayout)paramBundle);
    paramBundle = getActivity().findViewById(b.f.finder_live_game_search_rl_view);
    kotlin.g.b.p.j(paramBundle, "activity.findViewById(R.…live_game_search_rl_view)");
    this.jLl = ((RecyclerView)paramBundle);
    paramBundle = getActivity().findViewById(b.f.finder_live_game_search_cancel_tv);
    kotlin.g.b.p.j(paramBundle, "activity.findViewById(R.…ve_game_search_cancel_tv)");
    this.zbX = paramBundle;
    paramBundle = getActivity().findViewById(b.f.finder_live_game_search_clear_icon);
    kotlin.g.b.p.j(paramBundle, "activity.findViewById(R.…e_game_search_clear_icon)");
    this.zbY = paramBundle;
    paramBundle = getActivity().findViewById(b.f.finder_live_game_search_edit);
    kotlin.g.b.p.j(paramBundle, "activity.findViewById(R.…er_live_game_search_edit)");
    this.bGw = ((EditText)paramBundle);
    paramBundle = getActivity().findViewById(b.f.finder_live_game_search_empty_tv);
    kotlin.g.b.p.j(paramBundle, "activity.findViewById(R.…ive_game_search_empty_tv)");
    this.jkI = ((TextView)paramBundle);
    paramBundle = getActivity().findViewById(b.f.finder_live_game_search_loading);
    kotlin.g.b.p.j(paramBundle, "activity.findViewById(R.…live_game_search_loading)");
    this.kGT = paramBundle;
    paramBundle = com.tencent.mm.plugin.finder.live.util.g.yPJ;
    paramBundle = z.bdh();
    Object localObject1 = this.jac;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("root");
    }
    com.tencent.mm.plugin.finder.live.util.g.a(paramBundle, "", (View)localObject1);
    paramBundle = com.tencent.mm.plugin.finder.utils.p.ADF;
    paramBundle = this.jac;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("root");
    }
    com.tencent.mm.plugin.finder.utils.p.eM(paramBundle);
    paramBundle = this.zbW;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("closeIcon");
    }
    paramBundle.post((Runnable)new b(this));
    paramBundle = this.zbW;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("closeIcon");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    paramBundle = this.xvJ;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("rlLayout");
    }
    paramBundle.setEnablePullDownHeader(false);
    paramBundle = this.jac;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("root");
    }
    paramBundle = ad.kS(paramBundle.getContext()).inflate(b.g.load_more_footer, null);
    localObject1 = (TextView)paramBundle.findViewById(b.f.load_more_footer_tip_tv);
    if (localObject1 != null)
    {
      Object localObject2 = this.jac;
      if (localObject2 == null) {
        kotlin.g.b.p.bGy("root");
      }
      localObject2 = ((View)localObject2).getContext();
      kotlin.g.b.p.j(localObject2, "root.context");
      ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(b.c.half_alpha_white));
    }
    localObject1 = this.xvJ;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("rlLayout");
    }
    kotlin.g.b.p.j(paramBundle, "footer");
    ((RefreshLoadMoreLayout)localObject1).setLoadMoreFooter(paramBundle);
    paramBundle = this.xvJ;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("rlLayout");
    }
    paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new d(this));
    paramBundle = this.jLl;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("recyclerView");
    }
    getContext();
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramBundle = this.jLl;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("recyclerView");
    }
    paramBundle.setAdapter((RecyclerView.a)this.zcc);
    paramBundle = this.jLl;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("recyclerView");
    }
    f.a(paramBundle, (e.a)new e());
    paramBundle = this.bGw;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("editText");
    }
    paramBundle.addTextChangedListener((TextWatcher)new f(this));
    paramBundle = this.bGw;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("editText");
    }
    paramBundle.setOnEditorActionListener((TextView.OnEditorActionListener)new g(this));
    paramBundle = this.bGw;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("editText");
    }
    paramBundle.postDelayed((Runnable)new h(this), 128L);
    paramBundle = this.zbX;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("cancelTv");
    }
    paramBundle.setOnClickListener((View.OnClickListener)this);
    paramBundle = this.zbY;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("clearIcon");
    }
    paramBundle.setOnClickListener((View.OnClickListener)this);
    this.zcc.yVM = ((kotlin.g.a.b)new i(this));
    AppMethodBeat.o(281690);
  }
  
  public final void onSceneEnd(final int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(281695);
    h.aGY().b(4140, (i)this);
    final int i = this.zcb.size();
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramq instanceof bf)) {
        break label206;
      }
    }
    label206:
    for (paramString = null;; paramString = paramq)
    {
      paramString = (bf)paramString;
      if (paramString != null)
      {
        bcj localbcj = paramString.xcM;
        if (localbcj != null)
        {
          this.zcb.addAll((Collection)localbcj.SNN);
          paramq = localbcj.SNM;
          paramString = paramq;
          if (paramq == null) {
            paramString = "";
          }
          this.zbZ = paramString;
          this.zca = localbcj.has_next;
        }
      }
      paramInt1 = this.zcb.size();
      Log.i("Finder.FinderGameLiveSearchUIC", "originSize:" + i + ", currentSize:" + paramInt1 + ", offset:" + this.zbZ + ", hasNext:" + this.zca);
      d.uiThread((kotlin.g.a.a)new j(this, i, paramInt1));
      AppMethodBeat.o(281695);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(277586);
      Object localObject = new Rect();
      g.a(this.zce).getHitRect((Rect)localObject);
      ((Rect)localObject).inset(((Rect)localObject).width() * -2, -((Rect)localObject).width());
      ViewParent localViewParent = g.a(this.zce).getParent();
      if (localViewParent == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(277586);
        throw ((Throwable)localObject);
      }
      ((View)localViewParent).setTouchDelegate(new TouchDelegate((Rect)localObject, g.a(this.zce)));
      AppMethodBeat.o(277586);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(285432);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.zce.getActivity().finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(285432);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC$initView$3", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class d
    extends RefreshLoadMoreLayout.a
  {
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(291613);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(291613);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(291615);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(291615);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(291612);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Log.i("Finder.FinderGameLiveSearchUIC", "loadMoreSearchData query:" + g.b(this.zce));
      Object localObject = g.b(this.zce);
      if (g.c(this.zce))
      {
        g.a(this.zce, new bf((String)localObject, g.e(this.zce), (byte)0));
        h.aGY().b((com.tencent.mm.an.q)g.d(this.zce));
        h.aGY().a(4140, (i)this.zce);
        localObject = g.f(this.zce).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setText(b.j.finder_load_more_footer_tip);
          }
        }
        localObject = g.f(this.zce).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
        localObject = g.f(this.zce).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = ((View)localObject).findViewById(b.f.load_more_footer_end_layout);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(291612);
        return;
        localObject = g.f(this.zce).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setText(b.j.finder_load_more_no_result_tip);
          }
        }
        localObject = g.f(this.zce).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(8);
          }
        }
        localObject = g.f(this.zce).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = ((View)localObject).findViewById(b.f.load_more_footer_end_layout);
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
        }
      }
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(291614);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(291614);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC$initView$4", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "exposedSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getExposedSet", "()Ljava/util/HashSet;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-finder_release"})
  public static final class e
    extends e.a
  {
    private final HashSet<String> xlV;
    
    e()
    {
      AppMethodBeat.i(264273);
      this.xlV = new HashSet();
      AppMethodBeat.o(264273);
    }
    
    public final void b(View paramView, List<? extends RecyclerView.v> paramList)
    {
      AppMethodBeat.i(264270);
      kotlin.g.b.p.k(paramView, "parent");
      kotlin.g.b.p.k(paramList, "exposedHolders");
      Iterator localIterator = ((Iterable)paramList).iterator();
      while (localIterator.hasNext())
      {
        paramList = (RecyclerView.v)localIterator.next();
        paramView = paramList;
        if (!(paramList instanceof c.a)) {
          paramView = null;
        }
        paramView = (c.a)paramView;
        if (paramView != null)
        {
          paramView = paramView.yVO;
          if (paramView != null)
          {
            paramList = paramView.zaE.SYP;
            if ((paramList != null) && (paramList.SYi == 1))
            {
              paramView = paramView.zaE.SYP;
              if (paramView != null)
              {
                paramView = paramView.appid;
                if ((paramView != null) && (!this.xlV.contains(paramView)))
                {
                  this.xlV.add(paramView);
                  paramList = o.ADA;
                  o.bd(7, paramView);
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(264270);
    }
    
    public final boolean dpC()
    {
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveSearchUIC$initView$5", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class f
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(225008);
      paramEditable = g.g(this.zce).getText();
      Object localObject;
      int i;
      if (paramEditable != null)
      {
        paramEditable = paramEditable.toString();
        localObject = (CharSequence)paramEditable;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label108;
        }
        i = 1;
        label45:
        if (i == 0) {
          break label113;
        }
        g.h(this.zce).setVisibility(8);
        g.i(this.zce);
        g.a(this.zce, true);
      }
      for (;;)
      {
        g localg = this.zce;
        localObject = paramEditable;
        if (paramEditable == null) {
          localObject = "";
        }
        g.a(localg, (String)localObject);
        AppMethodBeat.o(225008);
        return;
        paramEditable = null;
        break;
        label108:
        i = 0;
        break label45;
        label113:
        g.h(this.zce).setVisibility(0);
        g.a(this.zce, false);
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "keyEvent", "Landroid/view/KeyEvent;", "onEditorAction"})
  static final class g
    implements TextView.OnEditorActionListener
  {
    g(g paramg) {}
    
    public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(267600);
      if (3 != paramInt)
      {
        kotlin.g.b.p.j(paramKeyEvent, "keyEvent");
        if (paramKeyEvent.getAction() != 66) {}
      }
      else
      {
        g.j(this.zce);
        Util.hideVKB((View)g.g(this.zce));
      }
      AppMethodBeat.o(267600);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(291510);
      g.g(this.zce).requestFocus();
      AppCompatActivity localAppCompatActivity = this.zce.getActivity();
      Object localObject = localAppCompatActivity;
      if (!(localAppCompatActivity instanceof MMActivity)) {
        localObject = null;
      }
      localObject = (MMActivity)localObject;
      if (localObject != null)
      {
        ((MMActivity)localObject).showVKB();
        AppMethodBeat.o(291510);
        return;
      }
      AppMethodBeat.o(291510);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.view.convert.b, x>
  {
    i(g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    j(g paramg, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.g
 * JD-Core Version:    0.7.0.1
 */