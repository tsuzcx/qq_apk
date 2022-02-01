package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.v;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.bg;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aqr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI$FinderLiveFansAdapter;", "listView", "Landroid/widget/ListView;", "liveId", "", "doGetFansScene", "", "getLayoutId", "", "initIntent", "initView", "merge", "contacts", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateTitle", "FinderLiveFansAdapter", "plugin-finder_release"})
public final class FinderLiveFansListUI
  extends MMFinderUI
  implements i
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private TextView hRM;
  private boolean hasMore;
  private ListView krb;
  private long liveId;
  private b tsO;
  private final ArrayList<aqr> uae;
  private final a ubr;
  
  public FinderLiveFansListUI()
  {
    AppMethodBeat.i(245363);
    this.TAG = "Finder.LiveFansListUI";
    this.ubr = new a();
    this.uae = new ArrayList();
    AppMethodBeat.o(245363);
  }
  
  private final void dea()
  {
    AppMethodBeat.i(245360);
    bg localbg = new bg(this.tsO, this.liveId, 1);
    g.azz().b((com.tencent.mm.ak.q)localbg);
    AppMethodBeat.o(245360);
  }
  
  private final void updateTitle()
  {
    AppMethodBeat.i(245359);
    int i = this.uae.size();
    Log.i(this.TAG, "update title fans count %s", new Object[] { Integer.valueOf(i) });
    setMMTitle(getString(2131759856, new Object[] { Integer.valueOf(this.uae.size()) }));
    if (i == 0)
    {
      localTextView = this.hRM;
      if (localTextView == null) {
        p.btv("emptyTip");
      }
      localTextView.setVisibility(0);
      localTextView = this.hRM;
      if (localTextView == null) {
        p.btv("emptyTip");
      }
      localTextView.setText((CharSequence)getString(2131759857));
      AppMethodBeat.o(245359);
      return;
    }
    TextView localTextView = this.hRM;
    if (localTextView == null) {
      p.btv("emptyTip");
    }
    localTextView.setVisibility(8);
    AppMethodBeat.o(245359);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245368);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245368);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245367);
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
    AppMethodBeat.o(245367);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494228;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(245358);
    Object localObject = findViewById(2131299111);
    p.g(localObject, "findViewById<ListView>(R.id.contact_list)");
    this.krb = ((ListView)localObject);
    localObject = findViewById(2131300101);
    p.g(localObject, "findViewById<TextView>(R.id.empty_tip)");
    this.hRM = ((TextView)localObject);
    updateTitle();
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    localObject = this.krb;
    if (localObject == null) {
      p.btv("listView");
    }
    ((ListView)localObject).setAdapter((ListAdapter)this.ubr);
    localObject = this.krb;
    if (localObject == null) {
      p.btv("listView");
    }
    ((ListView)localObject).setOnScrollListener((AbsListView.OnScrollListener)new c(this));
    AppMethodBeat.o(245358);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245357);
    super.onCreate(paramBundle);
    g.azz().a(3531, (i)this);
    this.liveId = getIntent().getLongExtra("PARAM_FINDER_LIVE_ID", 0L);
    Log.i(this.TAG, "init intent liveId:" + this.liveId);
    initView();
    dea();
    AppMethodBeat.o(245357);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245361);
    super.onDestroy();
    g.azz().b(3531, (i)this);
    AppMethodBeat.o(245361);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(245362);
    Log.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFansList");
        AppMethodBeat.o(245362);
        throw paramString;
      }
      paramString = ((bg)paramq).cYn();
      if ((p.j(this.tsO, paramString) ^ true))
      {
        Log.i(this.TAG, "not my buf, ignore!");
        AppMethodBeat.o(245362);
        return;
      }
      this.hasMore = ((bg)paramq).cYp();
      this.tsO = ((bg)paramq).cYm();
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new d(this, paramq));
    }
    AppMethodBeat.o(245362);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI$FinderLiveFansAdapter;", "Landroid/widget/BaseAdapter;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "getCount", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "setContactList", "", "FansViewHolder", "plugin-finder_release"})
  public static final class a
    extends BaseAdapter
  {
    ArrayList<aqr> kgc;
    
    public a()
    {
      AppMethodBeat.i(245353);
      this.kgc = new ArrayList();
      AppMethodBeat.o(245353);
    }
    
    private aqr IR(int paramInt)
    {
      AppMethodBeat.i(245350);
      int i = this.kgc.size();
      if (paramInt < 0) {}
      while (i <= paramInt)
      {
        localObject = new aqr();
        AppMethodBeat.o(245350);
        return localObject;
      }
      Object localObject = this.kgc.get(paramInt);
      p.g(localObject, "dataList[position]");
      localObject = (aqr)localObject;
      AppMethodBeat.o(245350);
      return localObject;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(245352);
      int i = this.kgc.size();
      AppMethodBeat.o(245352);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject1 = null;
      AppMethodBeat.i(245349);
      p.h(paramViewGroup, "parent");
      View localView = paramView;
      if (paramView == null)
      {
        localView = View.inflate(paramViewGroup.getContext(), 2131494394, null);
        p.g(localView, "itemView");
        localView.setTag(new a(localView));
      }
      paramViewGroup = localView.getTag();
      paramView = paramViewGroup;
      if (!(paramViewGroup instanceof a)) {
        paramView = null;
      }
      Object localObject3 = (a)paramView;
      Object localObject2;
      Object localObject4;
      if (localObject3 != null)
      {
        localObject2 = IR(paramInt);
        paramView = m.uJa;
        localObject4 = m.dkb();
        paramView = ((aqr)localObject2).contact;
        if (paramView != null)
        {
          paramViewGroup = paramView.headUrl;
          paramView = paramViewGroup;
          if (paramViewGroup != null) {}
        }
        else
        {
          paramView = "";
        }
        paramView = new com.tencent.mm.plugin.finder.loader.a(paramView);
        paramViewGroup = ((a)localObject3).keC;
        m localm = m.uJa;
        ((com.tencent.mm.loader.d)localObject4).a(paramView, paramViewGroup, m.a(m.a.uJg));
        localObject4 = ((a)localObject3).qbF;
        localObject3 = ((a)localObject3).qbF.getContext();
        paramView = y.vXH;
        paramView = ((aqr)localObject2).contact;
        if (paramView == null) {
          break label242;
        }
      }
      label242:
      for (paramView = paramView.username;; paramView = null)
      {
        localObject2 = ((aqr)localObject2).contact;
        paramViewGroup = localObject1;
        if (localObject2 != null) {
          paramViewGroup = ((FinderContact)localObject2).nickname;
        }
        ((TextView)localObject4).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject3, (CharSequence)y.hf(paramView, paramViewGroup)));
        AppMethodBeat.o(245349);
        return localView;
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI$FinderLiveFansAdapter$FansViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI$FinderLiveFansAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "setAvatar", "(Landroid/widget/ImageView;)V", "nickName", "Landroid/widget/TextView;", "getNickName", "()Landroid/widget/TextView;", "setNickName", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
    public final class a
      extends RecyclerView.v
    {
      ImageView keC;
      TextView qbF;
      
      public a()
      {
        super();
        AppMethodBeat.i(245348);
        this$1 = localObject.findViewById(2131297134);
        p.g(FinderLiveFansListUI.a.this, "itemView.findViewById<ImageView>(R.id.avatar_iv)");
        this.keC = ((ImageView)FinderLiveFansListUI.a.this);
        this$1 = localObject.findViewById(2131305440);
        p.g(FinderLiveFansListUI.a.this, "itemView.findViewById<TextView>(R.id.nickname_tv)");
        this.qbF = ((TextView)FinderLiveFansListUI.a.this);
        AppMethodBeat.o(245348);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderLiveFansListUI paramFinderLiveFansListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(245354);
      this.ubt.finish();
      AppMethodBeat.o(245354);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
  public static final class c
    implements AbsListView.OnScrollListener
  {
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(245355);
      if ((paramInt == 0) && (paramAbsListView != null) && (!paramAbsListView.canScrollVertically(1)))
      {
        if (FinderLiveFansListUI.a(this.ubt))
        {
          FinderLiveFansListUI.b(this.ubt);
          AppMethodBeat.o(245355);
          return;
        }
        if (FinderLiveFansListUI.c(this.ubt).getFooterViewsCount() == 0) {
          FinderLiveFansListUI.c(this.ubt).addFooterView(View.inflate((Context)this.ubt, 2131494490, null));
        }
      }
      AppMethodBeat.o(245355);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(FinderLiveFansListUI paramFinderLiveFansListUI, com.tencent.mm.ak.q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveFansListUI
 * JD-Core Version:    0.7.0.1
 */