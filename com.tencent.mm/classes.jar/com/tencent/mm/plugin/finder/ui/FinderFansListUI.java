package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.finder.cgi.cg;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderFansListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "FIRST_PAGE_FILE_NAME", "", "TAG", "addBlackListListener", "com/tencent/mm/plugin/finder/ui/FinderFansListUI$addBlackListListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderFansListUI$addBlackListListener$1;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "finderBottomSheet", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FansContactPage;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FansListAdapter;", "listView", "Landroid/widget/ListView;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "doGetFansScene", "", "getLayoutId", "", "initView", "merge", "contacts", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "fansId", "retCode", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showPopupMenu", "fansContact", "anchor", "Landroid/view/View;", "updateListAfterOp", "updateTitle", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFansListUI
  extends MMFinderUI
  implements com.tencent.mm.am.h, ck<bpp>
{
  private com.tencent.mm.bx.b AyB;
  private final ArrayList<axc> BmO;
  private final String EXP;
  private final a FOE;
  private final com.tencent.mm.plugin.finder.storage.data.b FQu;
  private final FinderFansListUI.addBlackListListener.1 FQv;
  private com.tencent.mm.plugin.finder.view.d FvQ;
  private final String TAG;
  private boolean hasMore;
  private TextView njh;
  private ListView qgc;
  private com.tencent.mm.ui.widget.b.a vEV;
  
  public FinderFansListUI()
  {
    AppMethodBeat.i(167257);
    this.TAG = "Finder.FinderFansListUI";
    this.FOE = new a((Activity)this);
    this.BmO = new ArrayList();
    this.EXP = "fansList.fp";
    this.FQu = new com.tencent.mm.plugin.finder.storage.data.b(this.EXP);
    this.FQv = new FinderFansListUI.addBlackListListener.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(167257);
  }
  
  private static final void a(FinderFansListUI paramFinderFansListUI, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(347479);
    kotlin.g.b.s.u(paramFinderFansListUI, "this$0");
    paramContextMenu.add(0, 1001, 0, (CharSequence)paramFinderFansListUI.getString(e.h.finder_del_fans));
    AppMethodBeat.o(347479);
  }
  
  private static final void a(axc paramaxc, FinderFansListUI paramFinderFansListUI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(347486);
    kotlin.g.b.s.u(paramaxc, "$fansContact");
    kotlin.g.b.s.u(paramFinderFansListUI, "this$0");
    if (paramMenuItem.getItemId() == 1001)
    {
      paramaxc = paramaxc.hJS;
      if (paramaxc != null)
      {
        paramMenuItem = z.FrZ;
        paramMenuItem = MMApplicationContext.getContext();
        kotlin.g.b.s.s(paramMenuItem, "getContext()");
        z.b(paramMenuItem, 8L, 3L);
        ((com.tencent.mm.plugin.finder.service.m)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.finder.service.m.class)).a(paramaxc, (ck)new FinderFansListUI.i(paramFinderFansListUI));
      }
    }
    AppMethodBeat.o(347486);
  }
  
  private static final boolean a(FinderFansListUI paramFinderFansListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(347467);
    kotlin.g.b.s.u(paramFinderFansListUI, "this$0");
    paramFinderFansListUI.finish();
    AppMethodBeat.o(347467);
    return true;
  }
  
  private final void aMl()
  {
    Object localObject = null;
    TextView localTextView1 = null;
    AppMethodBeat.i(167252);
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcP, 0);
    Log.i(this.TAG, "update title %s", new Object[] { Integer.valueOf(i) });
    setMMTitle(getString(e.h.finder_my_fans_contact_number, new Object[] { Integer.valueOf(i) }));
    if (i == 0)
    {
      TextView localTextView2 = this.njh;
      localObject = localTextView2;
      if (localTextView2 == null)
      {
        kotlin.g.b.s.bIx("emptyTip");
        localObject = null;
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.njh;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("emptyTip");
        localObject = localTextView1;
      }
      for (;;)
      {
        ((TextView)localObject).setText((CharSequence)getString(e.h.finder_fans_contact_empty_tip));
        AppMethodBeat.o(167252);
        return;
      }
    }
    localTextView1 = this.njh;
    if (localTextView1 == null) {
      kotlin.g.b.s.bIx("emptyTip");
    }
    for (;;)
    {
      ((TextView)localObject).setVisibility(8);
      addIconOptionMenu(0, e.g.icons_outlined_search, new FinderFansListUI..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(167252);
      return;
      localObject = localTextView1;
    }
  }
  
  private static final boolean b(FinderFansListUI paramFinderFansListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(347475);
    kotlin.g.b.s.u(paramFinderFansListUI, "this$0");
    paramMenuItem = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.aw((Context)paramFinderFansListUI, new Intent());
    AppMethodBeat.o(347475);
    return true;
  }
  
  private final void eR(final String paramString, int paramInt)
  {
    AppMethodBeat.i(347454);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(paramInt, this, paramString));
    AppMethodBeat.o(347454);
  }
  
  private final void efj()
  {
    AppMethodBeat.i(167254);
    cg localcg = new cg(this.AyB);
    com.tencent.mm.kernel.h.aZW().a((p)localcg, 0);
    AppMethodBeat.o(167254);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_contact_sort_list_ui;
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(167251);
    Object localObject1 = findViewById(e.e.contact_list);
    kotlin.g.b.s.s(localObject1, "findViewById<ListView>(R.id.contact_list)");
    this.qgc = ((ListView)localObject1);
    localObject1 = findViewById(e.e.empty_tip);
    kotlin.g.b.s.s(localObject1, "findViewById<TextView>(R.id.empty_tip)");
    this.njh = ((TextView)localObject1);
    aMl();
    setBackBtn(new FinderFansListUI..ExternalSyntheticLambda1(this));
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
      localObject1 = null;
      label130:
      ((ListView)localObject1).setSelector((Drawable)new ColorDrawable(0));
      localObject1 = this.qgc;
      if (localObject1 != null) {
        break label245;
      }
      kotlin.g.b.s.bIx("listView");
      localObject1 = localObject2;
    }
    label242:
    label245:
    for (;;)
    {
      ((ListView)localObject1).setOnScrollListener((AbsListView.OnScrollListener)new a(this));
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eTo().bmg()).intValue() > 0) {
        this.FOE.CyZ = ((kotlin.g.a.m)new b(this));
      }
      this.FOE.FNY = ((kotlin.g.a.m)new c(this));
      AppMethodBeat.o(167251);
      return;
      break;
      break label130;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167250);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(3531, (com.tencent.mm.am.h)this);
    initView();
    com.tencent.mm.ae.d.b(com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.bbX(), (kotlin.g.a.b)new d(this)), (kotlin.g.a.b)new e(this));
    efj();
    this.FQv.alive();
    AppMethodBeat.o(167250);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167255);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(3531, (com.tencent.mm.am.h)this);
    this.FQv.dead();
    AppMethodBeat.o(167255);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final p paramp)
  {
    AppMethodBeat.i(167256);
    Log.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFansList");
        AppMethodBeat.o(167256);
        throw paramString;
      }
      paramString = ((cg)paramp).dVL();
      if (!kotlin.g.b.s.p(this.AyB, paramString))
      {
        Log.i(this.TAG, "not my buf, ignore!");
        AppMethodBeat.o(167256);
        return;
      }
      this.hasMore = ((cg)paramp).dVN();
      if (this.AyB == null)
      {
        this.BmO.clear();
        com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.bbX(), (kotlin.g.a.b)new g(paramp, this));
      }
      this.AyB = ((cg)paramp).dVJ();
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(this, paramp));
    }
    AppMethodBeat.o(167256);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderFansListUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements AbsListView.OnScrollListener
  {
    a(FinderFansListUI paramFinderFansListUI) {}
    
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(167240);
      if ((paramInt == 0) && (paramAbsListView != null))
      {
        FinderFansListUI localFinderFansListUI = this.FQw;
        if (!paramAbsListView.canScrollVertically(1))
        {
          if (FinderFansListUI.e(localFinderFansListUI))
          {
            FinderFansListUI.f(localFinderFansListUI);
            AppMethodBeat.o(167240);
            return;
          }
          ListView localListView = FinderFansListUI.g(localFinderFansListUI);
          paramAbsListView = localListView;
          if (localListView == null)
          {
            kotlin.g.b.s.bIx("listView");
            paramAbsListView = null;
          }
          if (paramAbsListView.getFooterViewsCount() == 0)
          {
            localListView = FinderFansListUI.g(localFinderFansListUI);
            paramAbsListView = localListView;
            if (localListView == null)
            {
              kotlin.g.b.s.bIx("listView");
              paramAbsListView = null;
            }
            paramAbsListView.addFooterView(View.inflate((Context)localFinderFansListUI, e.f.finder_fans_no_more_footer, null));
          }
        }
      }
      AppMethodBeat.o(167240);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;", "position", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.m<View, Integer, ah>
  {
    b(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;", "position", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.m<View, Integer, ah>
  {
    c(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "it", "Ljava/lang/Void;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Void, LinkedList<axc>>
  {
    d(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<LinkedList<axc>, Object>
  {
    e(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(int paramInt, FinderFansListUI paramFinderFansListUI, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/Void;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<Void, ah>
  {
    g(p paramp, FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
    
    private ah fbb()
    {
      AppMethodBeat.i(347028);
      Object localObject = ((cg)this.nhm).dVM();
      if (localObject == null)
      {
        AppMethodBeat.o(347028);
        return null;
      }
      FinderFansListUI localFinderFansListUI = jdField_this;
      FinderFansListUI.a(localFinderFansListUI).bTu();
      FinderFansListUI.a(localFinderFansListUI).s((LinkedList)localObject);
      localObject = ah.aiuX;
      AppMethodBeat.o(347028);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(FinderFansListUI paramFinderFansListUI, p paramp)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    j(FinderFansListUI paramFinderFansListUI, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFansListUI
 * JD-Core Version:    0.7.0.1
 */