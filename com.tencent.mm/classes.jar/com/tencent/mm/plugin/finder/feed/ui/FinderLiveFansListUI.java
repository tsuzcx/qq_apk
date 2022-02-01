package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.bj;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.asn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI$FinderLiveFansAdapter;", "listView", "Landroid/widget/ListView;", "liveId", "", "doGetFansScene", "", "getLayoutId", "", "initIntent", "initView", "merge", "contacts", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateTitle", "FinderLiveFansAdapter", "plugin-finder-live_release"})
public final class FinderLiveFansListUI
  extends MMFinderUI
  implements i
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private boolean hasMore;
  private TextView kGj;
  private long liveId;
  private ListView niO;
  private final ArrayList<asn> xMG;
  private final a xPl;
  private b xaw;
  
  public FinderLiveFansListUI()
  {
    AppMethodBeat.i(232942);
    this.TAG = "Finder.LiveFansListUI";
    this.xPl = new a();
    this.xMG = new ArrayList();
    AppMethodBeat.o(232942);
  }
  
  private final void dvp()
  {
    AppMethodBeat.i(232933);
    bj localbj = new bj(this.xaw, this.liveId, 1);
    h.aGY().b((com.tencent.mm.an.q)localbj);
    AppMethodBeat.o(232933);
  }
  
  private final void updateTitle()
  {
    AppMethodBeat.i(232931);
    int i = this.xMG.size();
    Log.i(this.TAG, "update title fans count %s", new Object[] { Integer.valueOf(i) });
    setMMTitle(getString(b.j.finder_live_add_fans, new Object[] { Integer.valueOf(this.xMG.size()) }));
    if (i == 0)
    {
      localTextView = this.kGj;
      if (localTextView == null) {
        p.bGy("emptyTip");
      }
      localTextView.setVisibility(0);
      localTextView = this.kGj;
      if (localTextView == null) {
        p.bGy("emptyTip");
      }
      localTextView.setText((CharSequence)getString(b.j.finder_live_add_fans_empty));
      AppMethodBeat.o(232931);
      return;
    }
    TextView localTextView = this.kGj;
    if (localTextView == null) {
      p.bGy("emptyTip");
    }
    localTextView.setVisibility(8);
    AppMethodBeat.o(232931);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(232951);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(232951);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(232948);
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
    AppMethodBeat.o(232948);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_contact_sort_list_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(232930);
    Object localObject = findViewById(b.f.contact_list);
    p.j(localObject, "findViewById<ListView>(R.id.contact_list)");
    this.niO = ((ListView)localObject);
    localObject = findViewById(b.f.empty_tip);
    p.j(localObject, "findViewById<TextView>(R.id.empty_tip)");
    this.kGj = ((TextView)localObject);
    updateTitle();
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    localObject = this.niO;
    if (localObject == null) {
      p.bGy("listView");
    }
    ((ListView)localObject).setAdapter((ListAdapter)this.xPl);
    localObject = this.niO;
    if (localObject == null) {
      p.bGy("listView");
    }
    ((ListView)localObject).setOnScrollListener((AbsListView.OnScrollListener)new c(this));
    AppMethodBeat.o(232930);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(232925);
    super.onCreate(paramBundle);
    h.aGY().a(3531, (i)this);
    this.liveId = getIntent().getLongExtra("PARAM_FINDER_LIVE_ID", 0L);
    Log.i(this.TAG, "init intent liveId:" + this.liveId);
    initView();
    dvp();
    AppMethodBeat.o(232925);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(232935);
    super.onDestroy();
    h.aGY().b(3531, (i)this);
    AppMethodBeat.o(232935);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(232940);
    Log.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFansList");
        AppMethodBeat.o(232940);
        throw paramString;
      }
      paramString = ((bj)paramq).dob();
      if ((p.h(this.xaw, paramString) ^ true))
      {
        Log.i(this.TAG, "not my buf, ignore!");
        AppMethodBeat.o(232940);
        return;
      }
      this.hasMore = ((bj)paramq).dod();
      this.xaw = ((bj)paramq).doa();
      com.tencent.mm.ae.d.uiThread((a)new d(this, paramq));
    }
    AppMethodBeat.o(232940);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI$FinderLiveFansAdapter;", "Landroid/widget/BaseAdapter;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "getCount", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "setContactList", "", "FansViewHolder", "plugin-finder-live_release"})
  public static final class a
    extends BaseAdapter
  {
    ArrayList<asn> mXB;
    
    public a()
    {
      AppMethodBeat.i(233257);
      this.mXB = new ArrayList();
      AppMethodBeat.o(233257);
    }
    
    private asn MK(int paramInt)
    {
      AppMethodBeat.i(233253);
      int i = this.mXB.size();
      if (paramInt < 0) {}
      while (i <= paramInt)
      {
        localObject = new asn();
        AppMethodBeat.o(233253);
        return localObject;
      }
      Object localObject = this.mXB.get(paramInt);
      p.j(localObject, "dataList[position]");
      localObject = (asn)localObject;
      AppMethodBeat.o(233253);
      return localObject;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(233256);
      int i = this.mXB.size();
      AppMethodBeat.o(233256);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject1 = null;
      AppMethodBeat.i(233252);
      p.k(paramViewGroup, "parent");
      View localView = paramView;
      if (paramView == null)
      {
        localView = View.inflate(paramViewGroup.getContext(), b.g.finder_live_fans_list_item, null);
        p.j(localView, "itemView");
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
        localObject2 = MK(paramInt);
        paramView = com.tencent.mm.plugin.finder.loader.t.ztT;
        localObject4 = com.tencent.mm.plugin.finder.loader.t.dJi();
        paramView = ((asn)localObject2).contact;
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
        paramView = new e(paramView);
        paramViewGroup = ((a)localObject3).mWb;
        com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
        ((com.tencent.mm.loader.d)localObject4).a(paramView, paramViewGroup, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztZ));
        localObject4 = ((a)localObject3).txD;
        localObject3 = ((a)localObject3).txD.getContext();
        paramView = aj.AGc;
        paramView = ((asn)localObject2).contact;
        if (paramView == null) {
          break label243;
        }
      }
      label243:
      for (paramView = paramView.username;; paramView = null)
      {
        localObject2 = ((asn)localObject2).contact;
        paramViewGroup = localObject1;
        if (localObject2 != null) {
          paramViewGroup = ((FinderContact)localObject2).nickname;
        }
        ((TextView)localObject4).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject3, (CharSequence)aj.ht(paramView, paramViewGroup)));
        AppMethodBeat.o(233252);
        return localView;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI$FinderLiveFansAdapter$FansViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI$FinderLiveFansAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "setAvatar", "(Landroid/widget/ImageView;)V", "nickName", "Landroid/widget/TextView;", "getNickName", "()Landroid/widget/TextView;", "setNickName", "(Landroid/widget/TextView;)V", "plugin-finder-live_release"})
    public final class a
      extends RecyclerView.v
    {
      ImageView mWb;
      TextView txD;
      
      public a()
      {
        super();
        AppMethodBeat.i(232507);
        this$1 = localObject.findViewById(b.f.avatar_iv);
        p.j(FinderLiveFansListUI.a.this, "itemView.findViewById<ImageView>(R.id.avatar_iv)");
        this.mWb = ((ImageView)FinderLiveFansListUI.a.this);
        this$1 = localObject.findViewById(b.f.nickname_tv);
        p.j(FinderLiveFansListUI.a.this, "itemView.findViewById<TextView>(R.id.nickname_tv)");
        this.txD = ((TextView)FinderLiveFansListUI.a.this);
        AppMethodBeat.o(232507);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderLiveFansListUI paramFinderLiveFansListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(233930);
      this.xPn.finish();
      AppMethodBeat.o(233930);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder-live_release"})
  public static final class c
    implements AbsListView.OnScrollListener
  {
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(232902);
      if ((paramInt == 0) && (paramAbsListView != null) && (!paramAbsListView.canScrollVertically(1)))
      {
        if (FinderLiveFansListUI.a(this.xPn))
        {
          FinderLiveFansListUI.b(this.xPn);
          AppMethodBeat.o(232902);
          return;
        }
        if (FinderLiveFansListUI.c(this.xPn).getFooterViewsCount() == 0) {
          FinderLiveFansListUI.c(this.xPn).addFooterView(View.inflate((Context)this.xPn, b.g.finder_load_no_more_footer, null));
        }
      }
      AppMethodBeat.o(232902);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements a<x>
  {
    d(FinderLiveFansListUI paramFinderLiveFansListUI, com.tencent.mm.an.q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveFansListUI
 * JD-Core Version:    0.7.0.1
 */