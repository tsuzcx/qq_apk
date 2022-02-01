package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.bh;
import com.tencent.mm.plugin.finder.service.k;
import com.tencent.mm.plugin.findersdk.a.aj;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.protocal.protobuf.asn;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.beo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.q.g;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderBlackListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "delayLoadingRunnable", "Ljava/lang/Runnable;", "emptyTip", "Landroid/widget/TextView;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FansListAdapter;", "listView", "Landroid/widget/ListView;", "loadingView", "Landroid/view/View;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "retryView", "dismissLoadingView", "", "doGetBlackListScene", "getLayoutId", "", "initView", "merge", "contacts", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestRefresh", "showPopupMenu", "fansContact", "anchor", "update", "Companion", "plugin-finder_release"})
public final class FinderBlackListUI
  extends MMFinderUI
  implements i, aj<beo>
{
  public static final a Aon;
  private final a Aok;
  private View Aol;
  private Runnable Aom;
  private HashMap _$_findViewCache;
  private boolean hasMore;
  private View kGT;
  private TextView kGj;
  private ListView niO;
  private com.tencent.mm.ui.widget.b.a szq;
  private final ArrayList<asn> xMG;
  private com.tencent.mm.cd.b xaw;
  
  static
  {
    AppMethodBeat.i(229342);
    Aon = new a((byte)0);
    AppMethodBeat.o(229342);
  }
  
  public FinderBlackListUI()
  {
    AppMethodBeat.i(167154);
    this.Aok = new a((Activity)this);
    this.xMG = new ArrayList();
    this.Aom = ((Runnable)new b(this));
    AppMethodBeat.o(167154);
  }
  
  private final void dZL()
  {
    AppMethodBeat.i(229329);
    View localView = this.kGT;
    if (localView != null) {
      localView.removeCallbacks(this.Aom);
    }
    localView = this.kGT;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(229329);
      return;
    }
    AppMethodBeat.o(229329);
  }
  
  private final void dZM()
  {
    AppMethodBeat.i(167151);
    bh localbh = new bh(this.xaw);
    h.aGY().b((com.tencent.mm.an.q)localbh);
    AppMethodBeat.o(167151);
  }
  
  private final void update()
  {
    AppMethodBeat.i(167149);
    dZL();
    Object localObject = this.Aol;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    if (this.xMG.isEmpty())
    {
      localObject = this.kGj;
      if (localObject == null) {
        p.bGy("emptyTip");
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.kGj;
      if (localObject == null) {
        p.bGy("emptyTip");
      }
      ((TextView)localObject).setText((CharSequence)getString(b.j.finder_blacklist_empty_hint));
      AppMethodBeat.o(167149);
      return;
    }
    localObject = this.niO;
    if (localObject == null) {
      p.bGy("listView");
    }
    ((ListView)localObject).setVisibility(0);
    localObject = this.kGj;
    if (localObject == null) {
      p.bGy("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    AppMethodBeat.o(167149);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(229361);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(229361);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(229358);
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
    AppMethodBeat.o(229358);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_contact_sort_list_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167148);
    setMMTitle(getString(b.j.finder_my_blacklist));
    Object localObject = findViewById(b.f.contact_list);
    p.j(localObject, "findViewById<ListView>(R.id.contact_list)");
    this.niO = ((ListView)localObject);
    localObject = findViewById(b.f.empty_tip);
    p.j(localObject, "findViewById<TextView>(R.id.empty_tip)");
    this.kGj = ((TextView)localObject);
    setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
    this.szq = new com.tencent.mm.ui.widget.b.a((Context)this);
    localObject = this.niO;
    if (localObject == null) {
      p.bGy("listView");
    }
    ((ListView)localObject).setAdapter((ListAdapter)this.Aok);
    localObject = this.niO;
    if (localObject == null) {
      p.bGy("listView");
    }
    ((ListView)localObject).setOnScrollListener((AbsListView.OnScrollListener)new d(this));
    this.Aok.yWG = ((m)new e(this));
    this.kGT = findViewById(b.f.tips_loading);
    localObject = this.kGT;
    if (localObject != null) {
      ((View)localObject).postDelayed(this.Aom, 400L);
    }
    this.Aol = findViewById(b.f.tips_retry);
    localObject = this.Aol;
    if (localObject != null)
    {
      ((View)localObject).setOnClickListener((View.OnClickListener)new f(this));
      AppMethodBeat.o(167148);
      return;
    }
    AppMethodBeat.o(167148);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167147);
    super.onCreate(paramBundle);
    h.aGY().a(3717, (i)this);
    initView();
    dZM();
    AppMethodBeat.o(167147);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167152);
    super.onDestroy();
    h.aGY().b(3717, (i)this);
    AppMethodBeat.o(167152);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(167153);
    Log.i("Finder.FinderBlackListUI", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetBlackList");
        AppMethodBeat.o(167153);
        throw paramString;
      }
      paramString = ((bh)paramq).rr.bhY();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetBlackListResponse");
        AppMethodBeat.o(167153);
        throw paramString;
      }
      if (((atp)paramString).continueFlag != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.hasMore = bool;
        paramString = ((bh)paramq).rr.bhY();
        if (paramString != null) {
          break;
        }
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetBlackListResponse");
        AppMethodBeat.o(167153);
        throw paramString;
      }
      this.xaw = ((atp)paramString).xHE;
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(this, paramq));
      AppMethodBeat.o(167153);
      return;
    }
    dZL();
    if (this.xMG.isEmpty())
    {
      paramString = this.Aol;
      if (paramString != null)
      {
        paramString.setVisibility(0);
        AppMethodBeat.o(167153);
        return;
      }
    }
    AppMethodBeat.o(167153);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderBlackListUI$Companion;", "", "()V", "DELAY_LOADING_TIME", "", "MENU_ID_UNSET_BLACK_LIST", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderBlackListUI paramFinderBlackListUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(291076);
      View localView = FinderBlackListUI.h(this.Aoo);
      if (localView != null)
      {
        localView.setVisibility(0);
        AppMethodBeat.o(291076);
        return;
      }
      AppMethodBeat.o(291076);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderBlackListUI paramFinderBlackListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167140);
      this.Aoo.finish();
      AppMethodBeat.o(167140);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderBlackListUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
  public static final class d
    implements AbsListView.OnScrollListener
  {
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(167141);
      if ((paramInt == 0) && (paramAbsListView != null) && (!paramAbsListView.canScrollVertically(1)))
      {
        if (FinderBlackListUI.a(this.Aoo))
        {
          FinderBlackListUI.b(this.Aoo);
          AppMethodBeat.o(167141);
          return;
        }
        if (FinderBlackListUI.c(this.Aoo).getFooterViewsCount() == 0) {
          FinderBlackListUI.c(this.Aoo).addFooterView(View.inflate((Context)this.Aoo, b.g.finder_load_no_more_footer, null));
        }
      }
      AppMethodBeat.o(167141);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "position", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements m<View, Integer, x>
  {
    e(FinderBlackListUI paramFinderBlackListUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderBlackListUI paramFinderBlackListUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(289280);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderBlackListUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      FinderBlackListUI.e(this.Aoo);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderBlackListUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(289280);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    g(FinderBlackListUI paramFinderBlackListUI, aqu paramaqu, beo parambeo)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    h(FinderBlackListUI paramFinderBlackListUI, com.tencent.mm.an.q paramq)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class i
    implements View.OnCreateContextMenuListener
  {
    i(FinderBlackListUI paramFinderBlackListUI) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(167145);
      paramContextMenu.add(0, 1001, 0, (CharSequence)this.Aoo.getString(b.j.contact_info_moveout_blacklist));
      AppMethodBeat.o(167145);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class j
    implements q.g
  {
    j(FinderBlackListUI paramFinderBlackListUI, asn paramasn) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(167146);
      p.j(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(167146);
        return;
      }
      k localk = (k)h.ae(k.class);
      paramMenuItem = this.Aop.fFa;
      if (paramMenuItem == null) {
        paramMenuItem = "";
      }
      for (;;)
      {
        localk.b(paramMenuItem, false, (aj)this.Aoo);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderBlackListUI
 * JD-Core Version:    0.7.0.1
 */