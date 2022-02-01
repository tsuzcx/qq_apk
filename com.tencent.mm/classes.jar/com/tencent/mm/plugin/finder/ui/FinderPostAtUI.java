package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.w;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.n;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.cgi.ak;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowListUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowListUIC.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bvd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.a.j;
import d.g.b.y.a;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "Lkotlin/collections/ArrayList;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "recentAtContactList", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "doGetFollowScene", "", "getLayoutId", "", "initContentView", "initData", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "firstPage", "dataList", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "Companion", "ContactViewHolder", "HeaderViewHolder", "SearchViewHolder", "SelectAtContactAdapter", "plugin-finder_release"})
public final class FinderPostAtUI
  extends MMFinderUI
  implements com.tencent.mm.al.f
{
  private static final String TAG = "Finder.FinderPostAtUI";
  public static final a sEw;
  private HashMap _$_findViewCache;
  private RecyclerView gmV;
  private boolean hasMore;
  private com.tencent.mm.bx.b rHF;
  private RefreshLoadMoreLayout rTF;
  private ArrayList<com.tencent.mm.plugin.finder.api.g> sEv;
  private ArrayList<com.tencent.mm.plugin.finder.api.g> sec;
  private final com.tencent.mm.plugin.finder.storage.data.f sma;
  
  static
  {
    AppMethodBeat.i(204076);
    sEw = new a((byte)0);
    TAG = "Finder.FinderPostAtUI";
    AppMethodBeat.o(204076);
  }
  
  public FinderPostAtUI()
  {
    AppMethodBeat.i(204075);
    this.sec = new ArrayList();
    this.sEv = new ArrayList();
    FinderFollowListUIC.a locala = FinderFollowListUIC.tby;
    this.sma = new com.tencent.mm.plugin.finder.storage.data.f(FinderFollowListUIC.cOo());
    this.hasMore = true;
    AppMethodBeat.o(204075);
  }
  
  private final void c(boolean paramBoolean, List<? extends FinderContact> paramList)
  {
    AppMethodBeat.i(204070);
    ad.i(TAG, "firstPage " + paramBoolean + ", get follow contact " + paramList.size());
    if (paramBoolean) {
      this.sec.clear();
    }
    ArrayList localArrayList = this.sec;
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FinderContact localFinderContact = (FinderContact)((Iterator)localObject).next();
      FinderFollowListUIC.a locala = FinderFollowListUIC.tby;
      paramList.add(FinderFollowListUIC.a.d(localFinderContact));
    }
    localArrayList.addAll((Collection)paramList);
    paramList = this.gmV;
    if (paramList == null) {
      d.g.b.p.bcb("recyclerView");
    }
    paramList = paramList.getAdapter();
    if (paramList == null)
    {
      paramList = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
      AppMethodBeat.o(204070);
      throw paramList;
    }
    ((e)paramList).notifyDataSetChanged();
    AppMethodBeat.o(204070);
  }
  
  private final void cKc()
  {
    AppMethodBeat.i(204069);
    ak localak = new ak(this.rHF);
    com.tencent.mm.kernel.g.aiU().b((n)localak);
    AppMethodBeat.o(204069);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204080);
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
    AppMethodBeat.o(204080);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496244;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(204074);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      AppMethodBeat.o(204074);
      return;
    } while ((paramIntent == null) || (paramInt2 != -1));
    getIntent().putExtra("key_select_contact", paramIntent.getByteArrayExtra("at_select_contact"));
    boolean bool = paramIntent.getBooleanExtra("is_follow", false);
    paramIntent = getIntent();
    if (bool) {}
    for (paramInt1 = 3;; paramInt1 = 4)
    {
      paramIntent.putExtra("key_source", paramInt1);
      setResult(-1, getIntent());
      finish();
      break;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204068);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aiU().a(713, (com.tencent.mm.al.f)this);
    paramBundle = com.tencent.mm.plugin.finder.utils.b.sKO;
    paramBundle = com.tencent.mm.plugin.finder.utils.b.cKZ();
    if (paramBundle != null)
    {
      Collections.sort((List)paramBundle, (Comparator)h.sEB);
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        localObject = (bvd)paramBundle.next();
        com.tencent.mm.plugin.finder.utils.b localb = com.tencent.mm.plugin.finder.utils.b.sKO;
        d.g.b.p.g(localObject, "contact");
        localObject = com.tencent.mm.plugin.finder.utils.b.a((bvd)localObject);
        this.sEv.add(localObject);
      }
    }
    c.b(c.a(c.akP(), (d.g.a.b)new i(this)), (d.g.a.b)new j(this));
    cKc();
    setResult(0, getIntent());
    setMMTitle(getResources().getString(2131766484));
    setBackBtn((MenuItem.OnMenuItemClickListener)new f(this));
    paramBundle = getContext().findViewById(2131304203);
    d.g.b.p.g(paramBundle, "context.findViewById(R.id.rl_layout)");
    this.rTF = ((RefreshLoadMoreLayout)paramBundle);
    paramBundle = this.rTF;
    if (paramBundle == null) {
      d.g.b.p.bcb("rlLayout");
    }
    this.gmV = paramBundle.getRecyclerView();
    paramBundle = new FinderLayoutManager((byte)0);
    Object localObject = this.gmV;
    if (localObject == null) {
      d.g.b.p.bcb("recyclerView");
    }
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)paramBundle);
    paramBundle = this.gmV;
    if (paramBundle == null) {
      d.g.b.p.bcb("recyclerView");
    }
    paramBundle.setAdapter((RecyclerView.a)new e());
    paramBundle = this.gmV;
    if (paramBundle == null) {
      d.g.b.p.bcb("recyclerView");
    }
    paramBundle.setHasFixedSize(true);
    paramBundle = this.gmV;
    if (paramBundle == null) {
      d.g.b.p.bcb("recyclerView");
    }
    paramBundle.setItemViewCacheSize(5);
    paramBundle = this.gmV;
    if (paramBundle == null) {
      d.g.b.p.bcb("recyclerView");
    }
    paramBundle = paramBundle.getAdapter();
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
      AppMethodBeat.o(204068);
      throw paramBundle;
    }
    ((e)paramBundle).notifyDataSetChanged();
    paramBundle = this.rTF;
    if (paramBundle == null) {
      d.g.b.p.bcb("rlLayout");
    }
    paramBundle.setEnablePullDownHeader(false);
    paramBundle = this.rTF;
    if (paramBundle == null) {
      d.g.b.p.bcb("rlLayout");
    }
    localObject = com.tencent.mm.ui.z.jO((Context)getContext()).inflate(2131494590, null);
    d.g.b.p.g(localObject, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramBundle.setLoadMoreFooter((View)localObject);
    paramBundle = this.rTF;
    if (paramBundle == null) {
      d.g.b.p.bcb("rlLayout");
    }
    paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    AppMethodBeat.o(204068);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204072);
    super.onDestroy();
    com.tencent.mm.kernel.g.aiU().b(713, (com.tencent.mm.al.f)this);
    AppMethodBeat.o(204072);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(204071);
    super.onResume();
    Object localObject = this.gmV;
    if (localObject == null) {
      d.g.b.p.bcb("recyclerView");
    }
    localObject = ((RecyclerView)localObject).getAdapter();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
      AppMethodBeat.o(204071);
      throw ((Throwable)localObject);
    }
    if (!((e)localObject).sEz)
    {
      localObject = this.gmV;
      if (localObject == null) {
        d.g.b.p.bcb("recyclerView");
      }
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
        AppMethodBeat.o(204071);
        throw ((Throwable)localObject);
      }
      ((e)localObject).sEz = true;
      localObject = this.gmV;
      if (localObject == null) {
        d.g.b.p.bcb("recyclerView");
      }
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
        AppMethodBeat.o(204071);
        throw ((Throwable)localObject);
      }
      ((e)localObject).ck(0);
      h.LTJ.q((Runnable)new k(this), 300L);
    }
    AppMethodBeat.o(204071);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final n paramn)
  {
    com.tencent.mm.bx.b localb = null;
    AppMethodBeat.i(204073);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene type ");
    if (paramn != null) {}
    for (paramString = Integer.valueOf(paramn.getType());; paramString = null)
    {
      ad.i(str, paramString);
      paramString = localb;
      if (paramn != null) {
        paramString = Integer.valueOf(paramn.getType());
      }
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(204073);
      return;
    }
    if ((paramString.intValue() == 713) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new y.a();
      paramString.MLQ = false;
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFollowList");
        AppMethodBeat.o(204073);
        throw paramString;
      }
      localb = ((ak)paramn).cym();
      if ((d.g.b.p.i(this.rHF, localb) ^ true))
      {
        ad.i(TAG, "not my buf, ignore!");
        AppMethodBeat.o(204073);
        return;
      }
      if (this.rHF == null)
      {
        paramString.MLQ = true;
        c.a(c.akP(), (d.g.a.b)new l(this, paramString, paramn));
      }
      this.hasMore = ((ak)paramn).cyj();
      this.rHF = ((ak)paramn).cyh();
      c(paramString.MLQ, (List)((ak)paramn).cyl());
    }
    AppMethodBeat.o(204073);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$Companion;", "", "()V", "REQUEST_CODE_SELECT_AT_CONTACT", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "followContactViewType", "followHeaderViewType", "recentAtContactViewType", "recentAtHeaderViewType", "searchViewType", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$ContactViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "authIcon", "Landroid/widget/ImageView;", "getAuthIcon", "()Landroid/widget/ImageView;", "setAuthIcon", "(Landroid/widget/ImageView;)V", "authJob", "Landroid/widget/TextView;", "getAuthJob", "()Landroid/widget/TextView;", "setAuthJob", "(Landroid/widget/TextView;)V", "avatarIv", "getAvatarIv", "setAvatarIv", "nicknameTv", "getNicknameTv", "setNicknameTv", "plugin-finder_release"})
  public final class b
    extends RecyclerView.w
  {
    ImageView fRd;
    TextView opA;
    TextView sEx;
    ImageView sgf;
    
    public b()
    {
      super();
      AppMethodBeat.i(204048);
      this$1 = localObject.findViewById(2131297008);
      d.g.b.p.g(FinderPostAtUI.this, "itemView.findViewById(R.id.avatar_iv)");
      this.fRd = ((ImageView)FinderPostAtUI.this);
      this$1 = localObject.findViewById(2131302867);
      d.g.b.p.g(FinderPostAtUI.this, "itemView.findViewById(R.id.nickname_tv)");
      this.opA = ((TextView)FinderPostAtUI.this);
      this$1 = localObject.findViewById(2131296977);
      d.g.b.p.g(FinderPostAtUI.this, "itemView.findViewById(R.id.auth_icon)");
      this.sgf = ((ImageView)FinderPostAtUI.this);
      this$1 = localObject.findViewById(2131296980);
      d.g.b.p.g(FinderPostAtUI.this, "itemView.findViewById(R.id.auth_job)");
      this.sEx = ((TextView)FinderPostAtUI.this);
      AppMethodBeat.o(204048);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$HeaderViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class c
    extends RecyclerView.w
  {
    TextView titleTv;
    
    public c()
    {
      super();
      AppMethodBeat.i(204049);
      this$1 = localObject.findViewById(2131305948);
      d.g.b.p.g(FinderPostAtUI.this, "itemView.findViewById(R.id.title_tv)");
      this.titleTv = ((TextView)FinderPostAtUI.this);
      AppMethodBeat.o(204049);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$SearchViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "plugin-finder_release"})
  public final class d
    extends RecyclerView.w
  {
    public d()
    {
      super();
      AppMethodBeat.i(204050);
      AppMethodBeat.o(204050);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;)V", "hasSearchView", "", "getHasSearchView", "()Z", "setHasSearchView", "(Z)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class e
    extends RecyclerView.a<RecyclerView.w>
  {
    boolean sEz = true;
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(204055);
      d.g.b.p.h(paramViewGroup, "parent");
      switch (paramInt)
      {
      case 3: 
      default: 
        localFinderPostAtUI = this.sEy;
        localAppCompatActivity = this.sEy.getContext();
        if (localAppCompatActivity == null) {
          d.g.b.p.gfZ();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131494016, paramViewGroup, false);
        d.g.b.p.g(paramViewGroup, "context!!.layoutInflater…list_item, parent, false)");
        paramViewGroup = (RecyclerView.w)new FinderPostAtUI.b(localFinderPostAtUI, paramViewGroup);
        AppMethodBeat.o(204055);
        return paramViewGroup;
      case 1: 
        localFinderPostAtUI = this.sEy;
        localAppCompatActivity = this.sEy.getContext();
        if (localAppCompatActivity == null) {
          d.g.b.p.gfZ();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131492869, paramViewGroup, false);
        d.g.b.p.g(paramViewGroup, "context!!.layoutInflater…arch_item, parent, false)");
        paramViewGroup = (RecyclerView.w)new FinderPostAtUI.d(localFinderPostAtUI, paramViewGroup);
        AppMethodBeat.o(204055);
        return paramViewGroup;
      case 2: 
        localFinderPostAtUI = this.sEy;
        localAppCompatActivity = this.sEy.getContext();
        if (localAppCompatActivity == null) {
          d.g.b.p.gfZ();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131496243, paramViewGroup, false);
        d.g.b.p.g(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
        paramViewGroup = (RecyclerView.w)new FinderPostAtUI.c(localFinderPostAtUI, paramViewGroup);
        AppMethodBeat.o(204055);
        return paramViewGroup;
      }
      FinderPostAtUI localFinderPostAtUI = this.sEy;
      AppCompatActivity localAppCompatActivity = this.sEy.getContext();
      if (localAppCompatActivity == null) {
        d.g.b.p.gfZ();
      }
      paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131496243, paramViewGroup, false);
      d.g.b.p.g(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
      paramViewGroup = (RecyclerView.w)new FinderPostAtUI.c(localFinderPostAtUI, paramViewGroup);
      AppMethodBeat.o(204055);
      return paramViewGroup;
    }
    
    public final void a(final RecyclerView.w paramw, final int paramInt)
    {
      AppMethodBeat.i(204056);
      d.g.b.p.h(paramw, "viewHolder");
      if ((paramw instanceof FinderPostAtUI.b))
      {
        com.tencent.mm.plugin.finder.api.g localg;
        Object localObject1;
        Object localObject2;
        int i;
        if (FinderPostAtUI.a(this.sEy).size() == 0)
        {
          localg = (com.tencent.mm.plugin.finder.api.g)FinderPostAtUI.b(this.sEy).get(paramInt - 2);
          d.g.b.p.g(localg, "if (recentAtContactList.…      }\n                }");
          localObject1 = com.tencent.mm.plugin.finder.loader.i.sja;
          localObject1 = com.tencent.mm.plugin.finder.loader.i.cCC();
          localObject2 = new com.tencent.mm.plugin.finder.loader.a(localg.cxL());
          ImageView localImageView = ((FinderPostAtUI.b)paramw).fRd;
          com.tencent.mm.plugin.finder.loader.i locali = com.tencent.mm.plugin.finder.loader.i.sja;
          ((d)localObject1).a(localObject2, localImageView, com.tencent.mm.plugin.finder.loader.i.a(i.a.sjd));
          ((FinderPostAtUI.b)paramw).opA.setText((CharSequence)k.c((Context)this.sEy.getContext(), (CharSequence)localg.VC()));
          localObject1 = localg.field_authInfo;
          if (localObject1 == null) {
            break label339;
          }
          i = ((FinderAuthInfo)localObject1).authIconType;
          label161:
          ((FinderPostAtUI.b)paramw).sEx.setVisibility(8);
          localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
          com.tencent.mm.plugin.finder.utils.p.a(((FinderPostAtUI.b)paramw).sgf, localg.field_authInfo);
          if (i <= 0) {
            break label430;
          }
          switch (i)
          {
          }
        }
        for (;;)
        {
          localObject1 = paramw.auu;
          d.g.b.p.g(localObject1, "viewHolder.itemView");
          ((View)localObject1).setTag(localg);
          paramw.auu.setOnClickListener((View.OnClickListener)new a(this, paramw, paramInt));
          AppMethodBeat.o(204056);
          return;
          if (paramInt < FinderPostAtUI.a(this.sEy).size() + 2)
          {
            localg = (com.tencent.mm.plugin.finder.api.g)FinderPostAtUI.a(this.sEy).get(paramInt - 2);
            break;
          }
          localg = (com.tencent.mm.plugin.finder.api.g)FinderPostAtUI.b(this.sEy).get(paramInt - FinderPostAtUI.a(this.sEy).size() - 3);
          break;
          label339:
          i = 0;
          break label161;
          ((FinderPostAtUI.b)paramw).sEx.setVisibility(0);
          localObject2 = ((FinderPostAtUI.b)paramw).sEx;
          localObject1 = localg.field_authInfo;
          if (localObject1 != null)
          {
            localObject1 = ((FinderAuthInfo)localObject1).authProfession;
            if (localObject1 == null) {}
          }
          for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
          {
            ((TextView)localObject2).setText((CharSequence)localObject1);
            break;
          }
          ((FinderPostAtUI.b)paramw).sEx.setVisibility(8);
          continue;
          label430:
          ((FinderPostAtUI.b)paramw).sEx.setVisibility(8);
        }
      }
      if ((paramw instanceof FinderPostAtUI.d))
      {
        paramw.auu.setOnClickListener((View.OnClickListener)new b(this));
        AppMethodBeat.o(204056);
        return;
      }
      if ((paramw instanceof FinderPostAtUI.c))
      {
        if (getItemViewType(paramInt) == 2)
        {
          ((FinderPostAtUI.c)paramw).titleTv.setText((CharSequence)this.sEy.getString(2131766483));
          AppMethodBeat.o(204056);
          return;
        }
        ((FinderPostAtUI.c)paramw).titleTv.setText((CharSequence)this.sEy.getString(2131766482));
      }
      AppMethodBeat.o(204056);
    }
    
    public final int getItemCount()
    {
      int k = 0;
      AppMethodBeat.i(204054);
      int i;
      int j;
      if (this.sEz)
      {
        i = 1;
        if (FinderPostAtUI.a(this.sEy).size() != 0) {
          break label62;
        }
        j = 0;
        label32:
        if (FinderPostAtUI.b(this.sEy).size() != 0) {
          break label78;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(204054);
        return i + j + k;
        i = 0;
        break;
        label62:
        j = FinderPostAtUI.a(this.sEy).size() + 1;
        break label32;
        label78:
        k = FinderPostAtUI.b(this.sEy).size() + 1;
      }
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(204053);
      int i = paramInt;
      if (!this.sEz) {
        i = paramInt + 1;
      }
      if (i == 0)
      {
        AppMethodBeat.o(204053);
        return 1;
      }
      if (FinderPostAtUI.a(this.sEy).size() > 0)
      {
        if (i == 1)
        {
          AppMethodBeat.o(204053);
          return 2;
        }
        if (i == FinderPostAtUI.a(this.sEy).size() + 2)
        {
          AppMethodBeat.o(204053);
          return 4;
        }
        if (i > FinderPostAtUI.a(this.sEy).size() + 2)
        {
          AppMethodBeat.o(204053);
          return 5;
        }
        AppMethodBeat.o(204053);
        return 3;
      }
      if (i == 1)
      {
        AppMethodBeat.o(204053);
        return 4;
      }
      AppMethodBeat.o(204053);
      return 5;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderPostAtUI.e parame, RecyclerView.w paramw, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(204051);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramView = com.tencent.mm.plugin.finder.utils.b.sKO;
        paramView = paramw.auu;
        d.g.b.p.g(paramView, "viewHolder.itemView");
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.api.LocalFinderContact");
          AppMethodBeat.o(204051);
          throw paramView;
        }
        paramView = com.tencent.mm.plugin.finder.utils.b.i((com.tencent.mm.plugin.finder.api.g)paramView);
        this.sEA.sEy.getIntent().putExtra("key_select_contact", paramView.toByteArray());
        if (this.sEA.getItemViewType(paramInt) == 5) {
          this.sEA.sEy.getIntent().putExtra("key_source", 2);
        }
        for (;;)
        {
          this.sEA.sEy.setResult(-1, this.sEA.sEy.getIntent());
          this.sEA.sEy.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(204051);
          return;
          this.sEA.sEy.getIntent().putExtra("key_source", 1);
        }
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(FinderPostAtUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(204052);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        this.sEA.sEy.getIntent().putExtra("from_at_contact", true);
        this.sEA.sEy.getIntent().putExtra("request_type", 3);
        this.sEA.sEy.getIntent().putExtra("need_history", false);
        paramView = com.tencent.mm.plugin.finder.utils.a.sKD;
        paramView = (MMActivity)this.sEA.sEy;
        localObject = this.sEA.sEy.getIntent();
        d.g.b.p.g(localObject, "intent");
        com.tencent.mm.plugin.finder.utils.a.a(paramView, (Intent)localObject);
        this.sEA.sEz = false;
        this.sEA.cl(0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204052);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(FinderPostAtUI paramFinderPostAtUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(204057);
      this.sEy.finish();
      AppMethodBeat.o(204057);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void AM(int paramInt)
    {
      AppMethodBeat.i(204059);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahq());
      super.AM(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(204059);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(204061);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(204061);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(204060);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(204060);
    }
    
    public final void bYl()
    {
      AppMethodBeat.i(204058);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Object localObject = FinderPostAtUI.sEw;
      ad.i(FinderPostAtUI.access$getTAG$cp(), "onLoadMoreBegin");
      if (FinderPostAtUI.e(this.sEy) != null)
      {
        if (!FinderPostAtUI.f(this.sEy)) {
          break label175;
        }
        FinderPostAtUI.g(this.sEy);
        localObject = FinderPostAtUI.h(this.sEy).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setText(2131759244);
          }
        }
        localObject = FinderPostAtUI.h(this.sEy).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
        localObject = FinderPostAtUI.h(this.sEy).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = ((View)localObject).findViewById(2131308147);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(204058);
        return;
        label175:
        localObject = FinderPostAtUI.h(this.sEy).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setText(2131759245);
          }
        }
        localObject = FinderPostAtUI.h(this.sEy).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(8);
          }
        }
        localObject = FinderPostAtUI.h(this.sEy).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = ((View)localObject).findViewById(2131308147);
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "o1", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "kotlin.jvm.PlatformType", "o2", "compare"})
  static final class h<T>
    implements Comparator<bvd>
  {
    public static final h sEB;
    
    static
    {
      AppMethodBeat.i(204063);
      sEB = new h();
      AppMethodBeat.o(204063);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "it", "Ljava/lang/Void;", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.b<Void, LinkedList<FinderContact>>
  {
    i(FinderPostAtUI paramFinderPostAtUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "invoke"})
  static final class j
    extends d.g.b.q
    implements d.g.a.b<LinkedList<FinderContact>, Object>
  {
    j(FinderPostAtUI paramFinderPostAtUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(FinderPostAtUI paramFinderPostAtUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(204066);
      Object localObject = FinderPostAtUI.e(this.sEy).getAdapter();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
        AppMethodBeat.o(204066);
        throw ((Throwable)localObject);
      }
      ((FinderPostAtUI.e)localObject).notifyDataSetChanged();
      AppMethodBeat.o(204066);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$onSceneEnd$1$1"})
  static final class l
    extends d.g.b.q
    implements d.g.a.b<Void, d.z>
  {
    l(FinderPostAtUI paramFinderPostAtUI, y.a parama, n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostAtUI
 * JD-Core Version:    0.7.0.1
 */