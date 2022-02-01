package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.plugin.finder.cgi.ce;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.ayf;
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderBlackListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "delayLoadingRunnable", "Ljava/lang/Runnable;", "emptyTip", "Landroid/widget/TextView;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FansListAdapter;", "listView", "Landroid/widget/ListView;", "loadingView", "Landroid/view/View;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "retryView", "dismissLoadingView", "", "doGetBlackListScene", "getLayoutId", "", "initView", "merge", "contacts", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestRefresh", "showPopupMenu", "fansContact", "anchor", "update", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderBlackListUI
  extends MMFinderUI
  implements com.tencent.mm.am.h, ck<bpp>
{
  public static final FinderBlackListUI.a FOD;
  private com.tencent.mm.bx.b AyB;
  private final ArrayList<axc> BmO;
  private View BsS;
  private final a FOE;
  private Runnable FOF;
  private boolean hasMore;
  private View njN;
  private TextView njh;
  private ListView qgc;
  private com.tencent.mm.ui.widget.b.a vEV;
  
  static
  {
    AppMethodBeat.i(347369);
    FOD = new FinderBlackListUI.a((byte)0);
    AppMethodBeat.o(347369);
  }
  
  public FinderBlackListUI()
  {
    AppMethodBeat.i(167154);
    this.FOE = new a((Activity)this);
    this.BmO = new ArrayList();
    this.FOF = new FinderBlackListUI..ExternalSyntheticLambda4(this);
    AppMethodBeat.o(167154);
  }
  
  private static final void a(FinderBlackListUI paramFinderBlackListUI)
  {
    AppMethodBeat.i(347277);
    kotlin.g.b.s.u(paramFinderBlackListUI, "this$0");
    paramFinderBlackListUI = paramFinderBlackListUI.njN;
    if (paramFinderBlackListUI != null) {
      paramFinderBlackListUI.setVisibility(0);
    }
    AppMethodBeat.o(347277);
  }
  
  private static final void a(FinderBlackListUI paramFinderBlackListUI, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(347306);
    kotlin.g.b.s.u(paramFinderBlackListUI, "this$0");
    paramContextMenu.add(0, 1001, 0, (CharSequence)paramFinderBlackListUI.getString(e.h.contact_info_moveout_blacklist));
    AppMethodBeat.o(347306);
  }
  
  private static final void a(FinderBlackListUI paramFinderBlackListUI, View paramView)
  {
    AppMethodBeat.i(347297);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderBlackListUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderBlackListUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderBlackListUI, "this$0");
    paramView = paramFinderBlackListUI.njN;
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    localObject = paramFinderBlackListUI.qgc;
    paramView = (View)localObject;
    if (localObject == null)
    {
      kotlin.g.b.s.bIx("listView");
      paramView = null;
    }
    paramView.setVisibility(4);
    paramView = paramFinderBlackListUI.BsS;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    paramFinderBlackListUI.faK();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderBlackListUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347297);
  }
  
  private static final void a(axc paramaxc, FinderBlackListUI paramFinderBlackListUI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(347313);
    kotlin.g.b.s.u(paramaxc, "$fansContact");
    kotlin.g.b.s.u(paramFinderBlackListUI, "this$0");
    if (paramMenuItem.getItemId() == 1001)
    {
      com.tencent.mm.plugin.finder.service.p localp = (com.tencent.mm.plugin.finder.service.p)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.finder.service.p.class);
      paramMenuItem = paramaxc.hJS;
      paramaxc = paramMenuItem;
      if (paramMenuItem == null) {
        paramaxc = "";
      }
      localp.b(paramaxc, false, (ck)paramFinderBlackListUI);
    }
    AppMethodBeat.o(347313);
  }
  
  private static final boolean a(FinderBlackListUI paramFinderBlackListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(347286);
    kotlin.g.b.s.u(paramFinderBlackListUI, "this$0");
    paramFinderBlackListUI.finish();
    AppMethodBeat.o(347286);
    return true;
  }
  
  private final void faJ()
  {
    AppMethodBeat.i(347266);
    View localView = this.njN;
    if (localView != null) {
      localView.removeCallbacks(this.FOF);
    }
    localView = this.njN;
    if (localView != null) {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(347266);
  }
  
  private final void faK()
  {
    AppMethodBeat.i(167151);
    ce localce = new ce(this.AyB);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localce, 0);
    AppMethodBeat.o(167151);
  }
  
  private final void update()
  {
    TextView localTextView = null;
    ListView localListView = null;
    AppMethodBeat.i(167149);
    faJ();
    Object localObject = this.BsS;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    if (this.BmO.isEmpty())
    {
      localTextView = this.njh;
      localObject = localTextView;
      if (localTextView == null)
      {
        kotlin.g.b.s.bIx("emptyTip");
        localObject = null;
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.njh;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("emptyTip");
        localObject = localListView;
      }
      for (;;)
      {
        ((TextView)localObject).setText((CharSequence)getString(e.h.finder_blacklist_empty_hint));
        AppMethodBeat.o(167149);
        return;
      }
    }
    localListView = this.qgc;
    localObject = localListView;
    if (localListView == null)
    {
      kotlin.g.b.s.bIx("listView");
      localObject = null;
    }
    ((ListView)localObject).setVisibility(0);
    localObject = this.njh;
    if (localObject == null)
    {
      kotlin.g.b.s.bIx("emptyTip");
      localObject = localTextView;
    }
    for (;;)
    {
      ((TextView)localObject).setVisibility(8);
      AppMethodBeat.o(167149);
      return;
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_contact_sort_list_ui;
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(167148);
    setMMTitle(getString(e.h.finder_my_blacklist));
    Object localObject1 = findViewById(e.e.contact_list);
    kotlin.g.b.s.s(localObject1, "findViewById<ListView>(R.id.contact_list)");
    this.qgc = ((ListView)localObject1);
    localObject1 = findViewById(e.e.empty_tip);
    kotlin.g.b.s.s(localObject1, "findViewById<TextView>(R.id.empty_tip)");
    this.njh = ((TextView)localObject1);
    setBackBtn(new FinderBlackListUI..ExternalSyntheticLambda0(this));
    this.vEV = new com.tencent.mm.ui.widget.b.a((Context)this);
    localObject1 = this.qgc;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("listView");
      localObject1 = null;
      ((ListView)localObject1).setAdapter((ListAdapter)this.FOE);
      localObject1 = this.qgc;
      if (localObject1 != null) {
        break label242;
      }
      kotlin.g.b.s.bIx("listView");
      localObject1 = localObject2;
    }
    label242:
    for (;;)
    {
      ((ListView)localObject1).setOnScrollListener((AbsListView.OnScrollListener)new b(this));
      this.FOE.FNY = ((m)new c(this));
      this.njN = findViewById(e.e.tips_loading);
      localObject1 = this.njN;
      if (localObject1 != null) {
        ((View)localObject1).postDelayed(this.FOF, 400L);
      }
      this.BsS = findViewById(e.e.tips_retry);
      localObject1 = this.BsS;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new FinderBlackListUI..ExternalSyntheticLambda1(this));
      }
      AppMethodBeat.o(167148);
      return;
      break;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167147);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(3717, (com.tencent.mm.am.h)this);
    initView();
    faK();
    AppMethodBeat.o(167147);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167152);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(3717, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(167152);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(167153);
    Log.i("Finder.FinderBlackListUI", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetBlackList");
        AppMethodBeat.o(167153);
        throw paramString;
      }
      paramString = c.c.b(((ce)paramp).rr.otC);
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetBlackListResponse");
        AppMethodBeat.o(167153);
        throw paramString;
      }
      if (((ayf)paramString).continueFlag != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.hasMore = bool;
        paramString = c.c.b(((ce)paramp).rr.otC);
        if (paramString != null) {
          break;
        }
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetBlackListResponse");
        AppMethodBeat.o(167153);
        throw paramString;
      }
      this.AyB = ((ayf)paramString).BgS;
      d.uiThread((kotlin.g.a.a)new FinderBlackListUI.e(this, paramp));
      AppMethodBeat.o(167153);
      return;
    }
    faJ();
    if (this.BmO.isEmpty())
    {
      paramString = this.BsS;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
    }
    AppMethodBeat.o(167153);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderBlackListUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements AbsListView.OnScrollListener
  {
    b(FinderBlackListUI paramFinderBlackListUI) {}
    
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(167141);
      if ((paramInt == 0) && (paramAbsListView != null))
      {
        FinderBlackListUI localFinderBlackListUI = this.FOG;
        if (!paramAbsListView.canScrollVertically(1))
        {
          if (FinderBlackListUI.b(localFinderBlackListUI))
          {
            FinderBlackListUI.c(localFinderBlackListUI);
            AppMethodBeat.o(167141);
            return;
          }
          ListView localListView = FinderBlackListUI.d(localFinderBlackListUI);
          paramAbsListView = localListView;
          if (localListView == null)
          {
            kotlin.g.b.s.bIx("listView");
            paramAbsListView = null;
          }
          if (paramAbsListView.getFooterViewsCount() == 0)
          {
            localListView = FinderBlackListUI.d(localFinderBlackListUI);
            paramAbsListView = localListView;
            if (localListView == null)
            {
              kotlin.g.b.s.bIx("listView");
              paramAbsListView = null;
            }
            paramAbsListView.addFooterView(View.inflate((Context)localFinderBlackListUI, e.f.finder_load_no_more_footer, null));
          }
        }
      }
      AppMethodBeat.o(167141);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;", "position", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<View, Integer, ah>
  {
    c(FinderBlackListUI paramFinderBlackListUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(aux paramaux, FinderBlackListUI paramFinderBlackListUI, bpp parambpp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderBlackListUI
 * JD-Core Version:    0.7.0.1
 */