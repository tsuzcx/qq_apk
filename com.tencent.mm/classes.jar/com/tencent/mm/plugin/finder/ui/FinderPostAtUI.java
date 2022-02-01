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
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ebc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.a.j;
import d.g.b.v.a;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "Lkotlin/collections/ArrayList;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "recentAtContactList", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "doGetFollowScene", "", "getLayoutId", "", "initContentView", "initData", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "firstPage", "dataList", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "Companion", "ContactViewHolder", "HeaderViewHolder", "SearchViewHolder", "SelectAtContactAdapter", "plugin-finder_release"})
public final class FinderPostAtUI
  extends MMFinderUI
  implements com.tencent.mm.al.g
{
  public static final a KYJ;
  private static final String TAG = "Finder.FinderPostAtUI";
  private ArrayList<f> KYI;
  private HashMap _$_findViewCache;
  private RecyclerView fPw;
  private boolean hasMore;
  private ArrayList<f> qHA;
  private com.tencent.mm.bx.b qKW;
  private final com.tencent.mm.plugin.finder.storage.data.d qMr;
  private RefreshLoadMoreLayout quj;
  
  static
  {
    AppMethodBeat.i(199307);
    KYJ = new a((byte)0);
    TAG = "Finder.FinderPostAtUI";
    AppMethodBeat.o(199307);
  }
  
  public FinderPostAtUI()
  {
    AppMethodBeat.i(199306);
    this.qHA = new ArrayList();
    this.KYI = new ArrayList();
    FinderFollowListUI.l locall = FinderFollowListUI.KYt;
    this.qMr = new com.tencent.mm.plugin.finder.storage.data.d(FinderFollowListUI.fVs());
    this.hasMore = true;
    AppMethodBeat.o(199306);
  }
  
  private final void c(boolean paramBoolean, List<? extends FinderContact> paramList)
  {
    AppMethodBeat.i(199301);
    ad.i(TAG, "firstPage " + paramBoolean + ", get follow contact " + paramList.size());
    if (paramBoolean) {
      this.qHA.clear();
    }
    ArrayList localArrayList = this.qHA;
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FinderContact localFinderContact = (FinderContact)((Iterator)localObject).next();
      FinderFollowListUI.l locall = FinderFollowListUI.KYt;
      paramList.add(FinderFollowListUI.l.c(localFinderContact));
    }
    localArrayList.addAll((Collection)paramList);
    paramList = this.fPw;
    if (paramList == null) {
      d.g.b.k.aPZ("recyclerView");
    }
    paramList = paramList.getAdapter();
    if (paramList == null)
    {
      paramList = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
      AppMethodBeat.o(199301);
      throw paramList;
    }
    ((e)paramList).notifyDataSetChanged();
    AppMethodBeat.o(199301);
  }
  
  private final void crb()
  {
    AppMethodBeat.i(199300);
    com.tencent.mm.plugin.finder.cgi.q localq = new com.tencent.mm.plugin.finder.cgi.q(this.qKW);
    com.tencent.mm.kernel.g.aeS().b((com.tencent.mm.al.n)localq);
    AppMethodBeat.o(199300);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(199311);
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
    AppMethodBeat.o(199311);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496243;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(199305);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      AppMethodBeat.o(199305);
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
    AppMethodBeat.i(199299);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aeS().a(713, (com.tencent.mm.al.g)this);
    paramBundle = com.tencent.mm.plugin.finder.utils.n.LaC;
    paramBundle = com.tencent.mm.plugin.finder.utils.n.fVO();
    if (paramBundle != null)
    {
      Collections.sort((List)paramBundle, (Comparator)h.KYN);
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        localObject = (ebc)paramBundle.next();
        com.tencent.mm.plugin.finder.utils.n localn = com.tencent.mm.plugin.finder.utils.n.LaC;
        d.g.b.k.g(localObject, "contact");
        localObject = com.tencent.mm.plugin.finder.utils.n.a((ebc)localObject);
        this.KYI.add(localObject);
      }
    }
    c.b(c.a(c.agM(), (d.g.a.b)new i(this)), (d.g.a.b)new j(this));
    crb();
    setResult(0, getIntent());
    setMMTitle(getResources().getString(2131766470));
    setBackBtn((MenuItem.OnMenuItemClickListener)new f(this));
    paramBundle = getContext().findViewById(2131304203);
    d.g.b.k.g(paramBundle, "context.findViewById(R.id.rl_layout)");
    this.quj = ((RefreshLoadMoreLayout)paramBundle);
    paramBundle = this.quj;
    if (paramBundle == null) {
      d.g.b.k.aPZ("rlLayout");
    }
    this.fPw = paramBundle.getRecyclerView();
    paramBundle = new FinderLayoutManager((byte)0);
    Object localObject = this.fPw;
    if (localObject == null) {
      d.g.b.k.aPZ("recyclerView");
    }
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)paramBundle);
    paramBundle = this.fPw;
    if (paramBundle == null) {
      d.g.b.k.aPZ("recyclerView");
    }
    paramBundle.setAdapter((RecyclerView.a)new e());
    paramBundle = this.fPw;
    if (paramBundle == null) {
      d.g.b.k.aPZ("recyclerView");
    }
    paramBundle.setHasFixedSize(true);
    paramBundle = this.fPw;
    if (paramBundle == null) {
      d.g.b.k.aPZ("recyclerView");
    }
    paramBundle.setItemViewCacheSize(5);
    paramBundle = this.fPw;
    if (paramBundle == null) {
      d.g.b.k.aPZ("recyclerView");
    }
    paramBundle = paramBundle.getAdapter();
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
      AppMethodBeat.o(199299);
      throw paramBundle;
    }
    ((e)paramBundle).notifyDataSetChanged();
    paramBundle = this.quj;
    if (paramBundle == null) {
      d.g.b.k.aPZ("rlLayout");
    }
    paramBundle.setEnablePullDownHeader(false);
    paramBundle = this.quj;
    if (paramBundle == null) {
      d.g.b.k.aPZ("rlLayout");
    }
    localObject = com.tencent.mm.ui.y.js((Context)getContext()).inflate(2131494590, null);
    d.g.b.k.g(localObject, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramBundle.setLoadMoreFooter((View)localObject);
    paramBundle = this.quj;
    if (paramBundle == null) {
      d.g.b.k.aPZ("rlLayout");
    }
    paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    AppMethodBeat.o(199299);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(199303);
    super.onDestroy();
    com.tencent.mm.kernel.g.aeS().b(713, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(199303);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(199302);
    super.onResume();
    Object localObject = this.fPw;
    if (localObject == null) {
      d.g.b.k.aPZ("recyclerView");
    }
    localObject = ((RecyclerView)localObject).getAdapter();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
      AppMethodBeat.o(199302);
      throw ((Throwable)localObject);
    }
    if (!((e)localObject).KYL)
    {
      localObject = this.fPw;
      if (localObject == null) {
        d.g.b.k.aPZ("recyclerView");
      }
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
        AppMethodBeat.o(199302);
        throw ((Throwable)localObject);
      }
      ((e)localObject).KYL = true;
      localObject = this.fPw;
      if (localObject == null) {
        d.g.b.k.aPZ("recyclerView");
      }
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
        AppMethodBeat.o(199302);
        throw ((Throwable)localObject);
      }
      ((e)localObject).cl(0);
      com.tencent.e.h.Iye.p((Runnable)new k(this), 300L);
    }
    AppMethodBeat.o(199302);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.al.n paramn)
  {
    com.tencent.mm.bx.b localb = null;
    AppMethodBeat.i(199304);
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
      AppMethodBeat.o(199304);
      return;
    }
    if ((paramString.intValue() == 713) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new v.a();
      paramString.Jhs = false;
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFollowList");
        AppMethodBeat.o(199304);
        throw paramString;
      }
      localb = ((com.tencent.mm.plugin.finder.cgi.q)paramn).fRY();
      if ((d.g.b.k.g(this.qKW, localb) ^ true))
      {
        ad.i(TAG, "not my buf, ignore!");
        AppMethodBeat.o(199304);
        return;
      }
      if (this.qKW == null)
      {
        paramString.Jhs = true;
        c.a(c.agM(), (d.g.a.b)new l(this, paramString, paramn));
      }
      this.hasMore = ((com.tencent.mm.plugin.finder.cgi.q)paramn).fRW();
      this.qKW = ((com.tencent.mm.plugin.finder.cgi.q)paramn).ckJ();
      c(paramString.Jhs, (List)((com.tencent.mm.plugin.finder.cgi.q)paramn).ckI());
    }
    AppMethodBeat.o(199304);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$Companion;", "", "()V", "REQUEST_CODE_SELECT_AT_CONTACT", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "followContactViewType", "followHeaderViewType", "recentAtContactViewType", "recentAtHeaderViewType", "searchViewType", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$ContactViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "authIcon", "Landroid/widget/ImageView;", "getAuthIcon", "()Landroid/widget/ImageView;", "setAuthIcon", "(Landroid/widget/ImageView;)V", "authJob", "Landroid/widget/TextView;", "getAuthJob", "()Landroid/widget/TextView;", "setAuthJob", "(Landroid/widget/TextView;)V", "avatarIv", "getAvatarIv", "setAvatarIv", "nicknameTv", "getNicknameTv", "setNicknameTv", "plugin-finder_release"})
  public final class b
    extends RecyclerView.v
  {
    ImageView fuj;
    TextView nkb;
    ImageView qAi;
    TextView qKL;
    
    public b()
    {
      super();
      AppMethodBeat.i(199279);
      this$1 = localObject.findViewById(2131297008);
      d.g.b.k.g(FinderPostAtUI.this, "itemView.findViewById(R.id.avatar_iv)");
      this.fuj = ((ImageView)FinderPostAtUI.this);
      this$1 = localObject.findViewById(2131302867);
      d.g.b.k.g(FinderPostAtUI.this, "itemView.findViewById(R.id.nickname_tv)");
      this.nkb = ((TextView)FinderPostAtUI.this);
      this$1 = localObject.findViewById(2131296977);
      d.g.b.k.g(FinderPostAtUI.this, "itemView.findViewById(R.id.auth_icon)");
      this.qAi = ((ImageView)FinderPostAtUI.this);
      this$1 = localObject.findViewById(2131296980);
      d.g.b.k.g(FinderPostAtUI.this, "itemView.findViewById(R.id.auth_job)");
      this.qKL = ((TextView)FinderPostAtUI.this);
      AppMethodBeat.o(199279);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$HeaderViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class c
    extends RecyclerView.v
  {
    TextView titleTv;
    
    public c()
    {
      super();
      AppMethodBeat.i(199280);
      this$1 = localObject.findViewById(2131305948);
      d.g.b.k.g(FinderPostAtUI.this, "itemView.findViewById(R.id.title_tv)");
      this.titleTv = ((TextView)FinderPostAtUI.this);
      AppMethodBeat.o(199280);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$SearchViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "plugin-finder_release"})
  public final class d
    extends RecyclerView.v
  {
    public d()
    {
      super();
      AppMethodBeat.i(199281);
      AppMethodBeat.o(199281);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;)V", "hasSearchView", "", "getHasSearchView", "()Z", "setHasSearchView", "(Z)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class e
    extends RecyclerView.a<RecyclerView.v>
  {
    boolean KYL = true;
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(199286);
      d.g.b.k.h(paramViewGroup, "parent");
      switch (paramInt)
      {
      case 3: 
      default: 
        localFinderPostAtUI = this.KYK;
        localAppCompatActivity = this.KYK.getContext();
        if (localAppCompatActivity == null) {
          d.g.b.k.fvU();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131494016, paramViewGroup, false);
        d.g.b.k.g(paramViewGroup, "context!!.layoutInflater…list_item, parent, false)");
        paramViewGroup = (RecyclerView.v)new FinderPostAtUI.b(localFinderPostAtUI, paramViewGroup);
        AppMethodBeat.o(199286);
        return paramViewGroup;
      case 1: 
        localFinderPostAtUI = this.KYK;
        localAppCompatActivity = this.KYK.getContext();
        if (localAppCompatActivity == null) {
          d.g.b.k.fvU();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131492869, paramViewGroup, false);
        d.g.b.k.g(paramViewGroup, "context!!.layoutInflater…arch_item, parent, false)");
        paramViewGroup = (RecyclerView.v)new FinderPostAtUI.d(localFinderPostAtUI, paramViewGroup);
        AppMethodBeat.o(199286);
        return paramViewGroup;
      case 2: 
        localFinderPostAtUI = this.KYK;
        localAppCompatActivity = this.KYK.getContext();
        if (localAppCompatActivity == null) {
          d.g.b.k.fvU();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131496242, paramViewGroup, false);
        d.g.b.k.g(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
        paramViewGroup = (RecyclerView.v)new FinderPostAtUI.c(localFinderPostAtUI, paramViewGroup);
        AppMethodBeat.o(199286);
        return paramViewGroup;
      }
      FinderPostAtUI localFinderPostAtUI = this.KYK;
      AppCompatActivity localAppCompatActivity = this.KYK.getContext();
      if (localAppCompatActivity == null) {
        d.g.b.k.fvU();
      }
      paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131496242, paramViewGroup, false);
      d.g.b.k.g(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
      paramViewGroup = (RecyclerView.v)new FinderPostAtUI.c(localFinderPostAtUI, paramViewGroup);
      AppMethodBeat.o(199286);
      return paramViewGroup;
    }
    
    public final void a(final RecyclerView.v paramv, final int paramInt)
    {
      AppMethodBeat.i(199287);
      d.g.b.k.h(paramv, "viewHolder");
      if ((paramv instanceof FinderPostAtUI.b))
      {
        f localf;
        Object localObject1;
        Object localObject2;
        Object localObject3;
        int i;
        if (FinderPostAtUI.a(this.KYK).size() == 0)
        {
          localf = (f)FinderPostAtUI.b(this.KYK).get(paramInt - 2);
          d.g.b.k.g(localf, "if (recentAtContactList.…      }\n                }");
          localObject1 = com.tencent.mm.plugin.finder.loader.h.qCF;
          localObject1 = com.tencent.mm.plugin.finder.loader.h.cmV();
          localObject2 = new com.tencent.mm.plugin.finder.loader.a(localf.cks());
          localObject3 = ((FinderPostAtUI.b)paramv).fuj;
          com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.qCF;
          ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCI));
          ((FinderPostAtUI.b)paramv).nkb.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)this.KYK.getContext(), (CharSequence)localf.Su()));
          localObject1 = localf.field_authInfo;
          if (localObject1 == null) {
            break label327;
          }
          i = ((FinderAuthInfo)localObject1).authIconType;
          label161:
          ((FinderPostAtUI.b)paramv).qKL.setVisibility(8);
          if (i <= 0) {
            break label575;
          }
          switch (i)
          {
          }
        }
        for (;;)
        {
          localObject1 = paramv.arI;
          d.g.b.k.g(localObject1, "viewHolder.itemView");
          ((View)localObject1).setTag(localf);
          paramv.arI.setOnClickListener((View.OnClickListener)new a(this, paramv, paramInt));
          AppMethodBeat.o(199287);
          return;
          if (paramInt < FinderPostAtUI.a(this.KYK).size() + 2)
          {
            localf = (f)FinderPostAtUI.a(this.KYK).get(paramInt - 2);
            break;
          }
          localf = (f)FinderPostAtUI.b(this.KYK).get(paramInt - FinderPostAtUI.a(this.KYK).size() - 3);
          break;
          label327:
          i = 0;
          break label161;
          ((FinderPostAtUI.b)paramv).qAi.setVisibility(0);
          ((FinderPostAtUI.b)paramv).qKL.setVisibility(0);
          localObject1 = ((FinderPostAtUI.b)paramv).qAi;
          localObject2 = (Context)this.KYK.getContext();
          localObject3 = this.KYK.getContext();
          d.g.b.k.g(localObject3, "context");
          ((ImageView)localObject1).setImageDrawable(am.i((Context)localObject2, 2131690481, ((AppCompatActivity)localObject3).getResources().getColor(2131099777)));
          localObject2 = ((FinderPostAtUI.b)paramv).qKL;
          localObject1 = localf.field_authInfo;
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
          ((FinderPostAtUI.b)paramv).qAi.setVisibility(0);
          localObject1 = ((FinderPostAtUI.b)paramv).qAi;
          localObject2 = (Context)this.KYK.getContext();
          localObject3 = this.KYK.getContext();
          d.g.b.k.g(localObject3, "context");
          ((ImageView)localObject1).setImageDrawable(am.i((Context)localObject2, 2131690481, ((AppCompatActivity)localObject3).getResources().getColor(2131099748)));
          continue;
          ((FinderPostAtUI.b)paramv).qAi.setVisibility(8);
          ((FinderPostAtUI.b)paramv).qKL.setVisibility(8);
          continue;
          label575:
          ((FinderPostAtUI.b)paramv).qAi.setVisibility(8);
          ((FinderPostAtUI.b)paramv).qKL.setVisibility(8);
        }
      }
      if ((paramv instanceof FinderPostAtUI.d))
      {
        paramv.arI.setOnClickListener((View.OnClickListener)new b(this));
        AppMethodBeat.o(199287);
        return;
      }
      if ((paramv instanceof FinderPostAtUI.c))
      {
        if (getItemViewType(paramInt) == 2)
        {
          ((FinderPostAtUI.c)paramv).titleTv.setText((CharSequence)this.KYK.getString(2131766469));
          AppMethodBeat.o(199287);
          return;
        }
        ((FinderPostAtUI.c)paramv).titleTv.setText((CharSequence)this.KYK.getString(2131766468));
      }
      AppMethodBeat.o(199287);
    }
    
    public final int getItemCount()
    {
      int k = 0;
      AppMethodBeat.i(199285);
      int i;
      int j;
      if (this.KYL)
      {
        i = 1;
        if (FinderPostAtUI.a(this.KYK).size() != 0) {
          break label62;
        }
        j = 0;
        label32:
        if (FinderPostAtUI.b(this.KYK).size() != 0) {
          break label78;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(199285);
        return i + j + k;
        i = 0;
        break;
        label62:
        j = FinderPostAtUI.a(this.KYK).size() + 1;
        break label32;
        label78:
        k = FinderPostAtUI.b(this.KYK).size() + 1;
      }
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(199284);
      int i = paramInt;
      if (!this.KYL) {
        i = paramInt + 1;
      }
      if (i == 0)
      {
        AppMethodBeat.o(199284);
        return 1;
      }
      if (FinderPostAtUI.a(this.KYK).size() > 0)
      {
        if (i == 1)
        {
          AppMethodBeat.o(199284);
          return 2;
        }
        if (i == FinderPostAtUI.a(this.KYK).size() + 2)
        {
          AppMethodBeat.o(199284);
          return 4;
        }
        if (i > FinderPostAtUI.a(this.KYK).size() + 2)
        {
          AppMethodBeat.o(199284);
          return 5;
        }
        AppMethodBeat.o(199284);
        return 3;
      }
      if (i == 1)
      {
        AppMethodBeat.o(199284);
        return 4;
      }
      AppMethodBeat.o(199284);
      return 5;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderPostAtUI.e parame, RecyclerView.v paramv, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(199282);
        paramView = com.tencent.mm.plugin.finder.utils.n.LaC;
        paramView = paramv.arI;
        d.g.b.k.g(paramView, "viewHolder.itemView");
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.api.LocalFinderContact");
          AppMethodBeat.o(199282);
          throw paramView;
        }
        paramView = com.tencent.mm.plugin.finder.utils.n.d((f)paramView);
        this.KYM.KYK.getIntent().putExtra("key_select_contact", paramView.toByteArray());
        if (this.KYM.getItemViewType(paramInt) == 5) {
          this.KYM.KYK.getIntent().putExtra("key_source", 2);
        }
        for (;;)
        {
          this.KYM.KYK.setResult(-1, this.KYM.KYK.getIntent());
          this.KYM.KYK.finish();
          AppMethodBeat.o(199282);
          return;
          this.KYM.KYK.getIntent().putExtra("key_source", 1);
        }
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(FinderPostAtUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(199283);
        this.KYM.KYK.getIntent().putExtra("from_at_contact", true);
        this.KYM.KYK.getIntent().putExtra("request_type", 3);
        this.KYM.KYK.getIntent().putExtra("need_history", false);
        paramView = com.tencent.mm.plugin.finder.utils.a.qSb;
        paramView = (MMActivity)this.KYM.KYK;
        Intent localIntent = this.KYM.KYK.getIntent();
        d.g.b.k.g(localIntent, "intent");
        com.tencent.mm.plugin.finder.utils.a.a(paramView, localIntent);
        this.KYM.KYL = false;
        this.KYM.cm(0);
        AppMethodBeat.o(199283);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(FinderPostAtUI paramFinderPostAtUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(199288);
      this.KYK.finish();
      AppMethodBeat.o(199288);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(199292);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(199292);
    }
    
    public final void agP(int paramInt)
    {
      AppMethodBeat.i(199290);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ado());
      super.agP(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(199290);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(199291);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(199291);
    }
    
    public final void bMu()
    {
      AppMethodBeat.i(199289);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Object localObject = FinderPostAtUI.KYJ;
      ad.i(FinderPostAtUI.access$getTAG$cp(), "onLoadMoreBegin");
      if (FinderPostAtUI.e(this.KYK) != null)
      {
        if (!FinderPostAtUI.f(this.KYK)) {
          break label109;
        }
        FinderPostAtUI.g(this.KYK);
        localObject = FinderPostAtUI.h(this.KYK).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setText(2131759244);
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(199289);
        return;
        label109:
        localObject = FinderPostAtUI.h(this.KYK).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setText(2131759245);
          }
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "o1", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "kotlin.jvm.PlatformType", "o2", "compare"})
  static final class h<T>
    implements Comparator<ebc>
  {
    public static final h KYN;
    
    static
    {
      AppMethodBeat.i(199294);
      KYN = new h();
      AppMethodBeat.o(199294);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "it", "Ljava/lang/Void;", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.b<Void, LinkedList<FinderContact>>
  {
    i(FinderPostAtUI paramFinderPostAtUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.b<LinkedList<FinderContact>, Object>
  {
    j(FinderPostAtUI paramFinderPostAtUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(FinderPostAtUI paramFinderPostAtUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(199297);
      Object localObject = FinderPostAtUI.e(this.KYK).getAdapter();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
        AppMethodBeat.o(199297);
        throw ((Throwable)localObject);
      }
      ((FinderPostAtUI.e)localObject).notifyDataSetChanged();
      AppMethodBeat.o(199297);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$onSceneEnd$1$1"})
  static final class l
    extends d.g.b.l
    implements d.g.a.b<Void, d.y>
  {
    l(FinderPostAtUI paramFinderPostAtUI, v.a parama, com.tencent.mm.al.n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostAtUI
 * JD-Core Version:    0.7.0.1
 */