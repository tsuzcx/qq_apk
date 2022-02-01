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
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.cgi.al;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowListUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowListUIC.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bvx;
import com.tencent.mm.sdk.platformtools.ae;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "Lkotlin/collections/ArrayList;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "recentAtContactList", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "doGetFollowScene", "", "getLayoutId", "", "initContentView", "initData", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "firstPage", "dataList", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "Companion", "ContactViewHolder", "HeaderViewHolder", "SearchViewHolder", "SelectAtContactAdapter", "plugin-finder_release"})
public final class FinderPostAtUI
  extends MMFinderUI
  implements com.tencent.mm.ak.f
{
  private static final String TAG = "Finder.FinderPostAtUI";
  public static final FinderPostAtUI.a sPv;
  private HashMap _$_findViewCache;
  private RecyclerView gpr;
  private boolean hasMore;
  private com.tencent.mm.bw.b rPQ;
  private ArrayList<com.tencent.mm.plugin.finder.api.g> sPu;
  private RefreshLoadMoreLayout scj;
  private ArrayList<com.tencent.mm.plugin.finder.api.g> smS;
  private final com.tencent.mm.plugin.finder.storage.data.f svR;
  
  static
  {
    AppMethodBeat.i(204672);
    sPv = new FinderPostAtUI.a((byte)0);
    TAG = "Finder.FinderPostAtUI";
    AppMethodBeat.o(204672);
  }
  
  public FinderPostAtUI()
  {
    AppMethodBeat.i(204671);
    this.smS = new ArrayList();
    this.sPu = new ArrayList();
    FinderFollowListUIC.a locala = FinderFollowListUIC.tmn;
    this.svR = new com.tencent.mm.plugin.finder.storage.data.f(FinderFollowListUIC.cQT());
    this.hasMore = true;
    AppMethodBeat.o(204671);
  }
  
  private final void c(boolean paramBoolean, List<? extends FinderContact> paramList)
  {
    AppMethodBeat.i(204666);
    ae.i(TAG, "firstPage " + paramBoolean + ", get follow contact " + paramList.size());
    if (paramBoolean) {
      this.smS.clear();
    }
    ArrayList localArrayList = this.smS;
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FinderContact localFinderContact = (FinderContact)((Iterator)localObject).next();
      FinderFollowListUIC.a locala = FinderFollowListUIC.tmn;
      paramList.add(FinderFollowListUIC.a.f(localFinderContact));
    }
    localArrayList.addAll((Collection)paramList);
    paramList = this.gpr;
    if (paramList == null) {
      d.g.b.p.bdF("recyclerView");
    }
    paramList = paramList.getAdapter();
    if (paramList == null)
    {
      paramList = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
      AppMethodBeat.o(204666);
      throw paramList;
    }
    ((e)paramList).notifyDataSetChanged();
    AppMethodBeat.o(204666);
  }
  
  private final void cMF()
  {
    AppMethodBeat.i(204665);
    al localal = new al(this.rPQ);
    com.tencent.mm.kernel.g.ajj().b((n)localal);
    AppMethodBeat.o(204665);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204676);
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
    AppMethodBeat.o(204676);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496244;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(204670);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      AppMethodBeat.o(204670);
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
    AppMethodBeat.i(204664);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.ajj().a(713, (com.tencent.mm.ak.f)this);
    paramBundle = com.tencent.mm.plugin.finder.utils.b.sWa;
    paramBundle = com.tencent.mm.plugin.finder.utils.b.cND();
    if (paramBundle != null)
    {
      Collections.sort((List)paramBundle, (Comparator)h.sPA);
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        localObject = (bvx)paramBundle.next();
        com.tencent.mm.plugin.finder.utils.b localb = com.tencent.mm.plugin.finder.utils.b.sWa;
        d.g.b.p.g(localObject, "contact");
        localObject = com.tencent.mm.plugin.finder.utils.b.a((bvx)localObject);
        this.sPu.add(localObject);
      }
    }
    c.b(c.a(c.ale(), (d.g.a.b)new i(this)), (d.g.a.b)new j(this));
    cMF();
    setResult(0, getIntent());
    setMMTitle(getResources().getString(2131766484));
    setBackBtn((MenuItem.OnMenuItemClickListener)new f(this));
    paramBundle = getContext().findViewById(2131304203);
    d.g.b.p.g(paramBundle, "context.findViewById(R.id.rl_layout)");
    this.scj = ((RefreshLoadMoreLayout)paramBundle);
    paramBundle = this.scj;
    if (paramBundle == null) {
      d.g.b.p.bdF("rlLayout");
    }
    this.gpr = paramBundle.getRecyclerView();
    paramBundle = new FinderLayoutManager((byte)0);
    Object localObject = this.gpr;
    if (localObject == null) {
      d.g.b.p.bdF("recyclerView");
    }
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)paramBundle);
    paramBundle = this.gpr;
    if (paramBundle == null) {
      d.g.b.p.bdF("recyclerView");
    }
    paramBundle.setAdapter((RecyclerView.a)new e());
    paramBundle = this.gpr;
    if (paramBundle == null) {
      d.g.b.p.bdF("recyclerView");
    }
    paramBundle.setHasFixedSize(true);
    paramBundle = this.gpr;
    if (paramBundle == null) {
      d.g.b.p.bdF("recyclerView");
    }
    paramBundle.setItemViewCacheSize(5);
    paramBundle = this.gpr;
    if (paramBundle == null) {
      d.g.b.p.bdF("recyclerView");
    }
    paramBundle = paramBundle.getAdapter();
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
      AppMethodBeat.o(204664);
      throw paramBundle;
    }
    ((e)paramBundle).notifyDataSetChanged();
    paramBundle = this.scj;
    if (paramBundle == null) {
      d.g.b.p.bdF("rlLayout");
    }
    paramBundle.setEnablePullDownHeader(false);
    paramBundle = this.scj;
    if (paramBundle == null) {
      d.g.b.p.bdF("rlLayout");
    }
    localObject = com.tencent.mm.ui.z.jV((Context)getContext()).inflate(2131494590, null);
    d.g.b.p.g(localObject, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramBundle.setLoadMoreFooter((View)localObject);
    paramBundle = this.scj;
    if (paramBundle == null) {
      d.g.b.p.bdF("rlLayout");
    }
    paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    AppMethodBeat.o(204664);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204668);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajj().b(713, (com.tencent.mm.ak.f)this);
    AppMethodBeat.o(204668);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(204667);
    super.onResume();
    Object localObject = this.gpr;
    if (localObject == null) {
      d.g.b.p.bdF("recyclerView");
    }
    localObject = ((RecyclerView)localObject).getAdapter();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
      AppMethodBeat.o(204667);
      throw ((Throwable)localObject);
    }
    if (!((e)localObject).sPy)
    {
      localObject = this.gpr;
      if (localObject == null) {
        d.g.b.p.bdF("recyclerView");
      }
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
        AppMethodBeat.o(204667);
        throw ((Throwable)localObject);
      }
      ((e)localObject).sPy = true;
      localObject = this.gpr;
      if (localObject == null) {
        d.g.b.p.bdF("recyclerView");
      }
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
        AppMethodBeat.o(204667);
        throw ((Throwable)localObject);
      }
      ((e)localObject).ck(0);
      h.MqF.q((Runnable)new k(this), 300L);
    }
    AppMethodBeat.o(204667);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final n paramn)
  {
    com.tencent.mm.bw.b localb = null;
    AppMethodBeat.i(204669);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene type ");
    if (paramn != null) {}
    for (paramString = Integer.valueOf(paramn.getType());; paramString = null)
    {
      ae.i(str, paramString);
      paramString = localb;
      if (paramn != null) {
        paramString = Integer.valueOf(paramn.getType());
      }
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(204669);
      return;
    }
    if ((paramString.intValue() == 713) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new y.a();
      paramString.NiT = false;
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFollowList");
        AppMethodBeat.o(204669);
        throw paramString;
      }
      localb = ((al)paramn).czN();
      if ((d.g.b.p.i(this.rPQ, localb) ^ true))
      {
        ae.i(TAG, "not my buf, ignore!");
        AppMethodBeat.o(204669);
        return;
      }
      if (this.rPQ == null)
      {
        paramString.NiT = true;
        c.a(c.ale(), (d.g.a.b)new l(this, paramString, paramn));
      }
      this.hasMore = ((al)paramn).czK();
      this.rPQ = ((al)paramn).czI();
      c(paramString.NiT, (List)((al)paramn).czM());
    }
    AppMethodBeat.o(204669);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$ContactViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "authIcon", "Landroid/widget/ImageView;", "getAuthIcon", "()Landroid/widget/ImageView;", "setAuthIcon", "(Landroid/widget/ImageView;)V", "authJob", "Landroid/widget/TextView;", "getAuthJob", "()Landroid/widget/TextView;", "setAuthJob", "(Landroid/widget/TextView;)V", "avatarIv", "getAvatarIv", "setAvatarIv", "nicknameTv", "getNicknameTv", "setNicknameTv", "plugin-finder_release"})
  public final class b
    extends RecyclerView.w
  {
    ImageView fTj;
    TextView ovs;
    TextView sPw;
    ImageView soY;
    
    public b()
    {
      super();
      AppMethodBeat.i(204644);
      this$1 = localObject.findViewById(2131297008);
      d.g.b.p.g(FinderPostAtUI.this, "itemView.findViewById(R.id.avatar_iv)");
      this.fTj = ((ImageView)FinderPostAtUI.this);
      this$1 = localObject.findViewById(2131302867);
      d.g.b.p.g(FinderPostAtUI.this, "itemView.findViewById(R.id.nickname_tv)");
      this.ovs = ((TextView)FinderPostAtUI.this);
      this$1 = localObject.findViewById(2131296977);
      d.g.b.p.g(FinderPostAtUI.this, "itemView.findViewById(R.id.auth_icon)");
      this.soY = ((ImageView)FinderPostAtUI.this);
      this$1 = localObject.findViewById(2131296980);
      d.g.b.p.g(FinderPostAtUI.this, "itemView.findViewById(R.id.auth_job)");
      this.sPw = ((TextView)FinderPostAtUI.this);
      AppMethodBeat.o(204644);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$HeaderViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class c
    extends RecyclerView.w
  {
    TextView titleTv;
    
    public c()
    {
      super();
      AppMethodBeat.i(204645);
      this$1 = localObject.findViewById(2131305948);
      d.g.b.p.g(FinderPostAtUI.this, "itemView.findViewById(R.id.title_tv)");
      this.titleTv = ((TextView)FinderPostAtUI.this);
      AppMethodBeat.o(204645);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$SearchViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "plugin-finder_release"})
  public final class d
    extends RecyclerView.w
  {
    public d()
    {
      super();
      AppMethodBeat.i(204646);
      AppMethodBeat.o(204646);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;)V", "hasSearchView", "", "getHasSearchView", "()Z", "setHasSearchView", "(Z)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class e
    extends RecyclerView.a<RecyclerView.w>
  {
    boolean sPy = true;
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(204651);
      d.g.b.p.h(paramViewGroup, "parent");
      switch (paramInt)
      {
      case 3: 
      default: 
        localFinderPostAtUI = this.sPx;
        localAppCompatActivity = this.sPx.getContext();
        if (localAppCompatActivity == null) {
          d.g.b.p.gkB();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131494016, paramViewGroup, false);
        d.g.b.p.g(paramViewGroup, "context!!.layoutInflater…list_item, parent, false)");
        paramViewGroup = (RecyclerView.w)new FinderPostAtUI.b(localFinderPostAtUI, paramViewGroup);
        AppMethodBeat.o(204651);
        return paramViewGroup;
      case 1: 
        localFinderPostAtUI = this.sPx;
        localAppCompatActivity = this.sPx.getContext();
        if (localAppCompatActivity == null) {
          d.g.b.p.gkB();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131492869, paramViewGroup, false);
        d.g.b.p.g(paramViewGroup, "context!!.layoutInflater…arch_item, parent, false)");
        paramViewGroup = (RecyclerView.w)new FinderPostAtUI.d(localFinderPostAtUI, paramViewGroup);
        AppMethodBeat.o(204651);
        return paramViewGroup;
      case 2: 
        localFinderPostAtUI = this.sPx;
        localAppCompatActivity = this.sPx.getContext();
        if (localAppCompatActivity == null) {
          d.g.b.p.gkB();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131496243, paramViewGroup, false);
        d.g.b.p.g(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
        paramViewGroup = (RecyclerView.w)new FinderPostAtUI.c(localFinderPostAtUI, paramViewGroup);
        AppMethodBeat.o(204651);
        return paramViewGroup;
      }
      FinderPostAtUI localFinderPostAtUI = this.sPx;
      AppCompatActivity localAppCompatActivity = this.sPx.getContext();
      if (localAppCompatActivity == null) {
        d.g.b.p.gkB();
      }
      paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131496243, paramViewGroup, false);
      d.g.b.p.g(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
      paramViewGroup = (RecyclerView.w)new FinderPostAtUI.c(localFinderPostAtUI, paramViewGroup);
      AppMethodBeat.o(204651);
      return paramViewGroup;
    }
    
    public final void a(final RecyclerView.w paramw, final int paramInt)
    {
      AppMethodBeat.i(204652);
      d.g.b.p.h(paramw, "viewHolder");
      if ((paramw instanceof FinderPostAtUI.b))
      {
        com.tencent.mm.plugin.finder.api.g localg;
        Object localObject1;
        Object localObject2;
        int i;
        if (FinderPostAtUI.a(this.sPx).size() == 0)
        {
          localg = (com.tencent.mm.plugin.finder.api.g)FinderPostAtUI.b(this.sPx).get(paramInt - 2);
          d.g.b.p.g(localg, "if (recentAtContactList.…      }\n                }");
          localObject1 = com.tencent.mm.plugin.finder.loader.i.srW;
          localObject1 = com.tencent.mm.plugin.finder.loader.i.cEo();
          localObject2 = new com.tencent.mm.plugin.finder.loader.a(localg.czm());
          ImageView localImageView = ((FinderPostAtUI.b)paramw).fTj;
          com.tencent.mm.plugin.finder.loader.i locali = com.tencent.mm.plugin.finder.loader.i.srW;
          ((d)localObject1).a(localObject2, localImageView, com.tencent.mm.plugin.finder.loader.i.a(i.a.srZ));
          ((FinderPostAtUI.b)paramw).ovs.setText((CharSequence)k.c((Context)this.sPx.getContext(), (CharSequence)localg.VK()));
          localObject1 = localg.field_authInfo;
          if (localObject1 == null) {
            break label339;
          }
          i = ((FinderAuthInfo)localObject1).authIconType;
          label161:
          ((FinderPostAtUI.b)paramw).sPw.setVisibility(8);
          localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
          com.tencent.mm.plugin.finder.utils.p.a(((FinderPostAtUI.b)paramw).soY, localg.field_authInfo);
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
          AppMethodBeat.o(204652);
          return;
          if (paramInt < FinderPostAtUI.a(this.sPx).size() + 2)
          {
            localg = (com.tencent.mm.plugin.finder.api.g)FinderPostAtUI.a(this.sPx).get(paramInt - 2);
            break;
          }
          localg = (com.tencent.mm.plugin.finder.api.g)FinderPostAtUI.b(this.sPx).get(paramInt - FinderPostAtUI.a(this.sPx).size() - 3);
          break;
          label339:
          i = 0;
          break label161;
          ((FinderPostAtUI.b)paramw).sPw.setVisibility(0);
          localObject2 = ((FinderPostAtUI.b)paramw).sPw;
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
          ((FinderPostAtUI.b)paramw).sPw.setVisibility(8);
          continue;
          label430:
          ((FinderPostAtUI.b)paramw).sPw.setVisibility(8);
        }
      }
      if ((paramw instanceof FinderPostAtUI.d))
      {
        paramw.auu.setOnClickListener((View.OnClickListener)new b(this));
        AppMethodBeat.o(204652);
        return;
      }
      if ((paramw instanceof FinderPostAtUI.c))
      {
        if (getItemViewType(paramInt) == 2)
        {
          ((FinderPostAtUI.c)paramw).titleTv.setText((CharSequence)this.sPx.getString(2131766483));
          AppMethodBeat.o(204652);
          return;
        }
        ((FinderPostAtUI.c)paramw).titleTv.setText((CharSequence)this.sPx.getString(2131766482));
      }
      AppMethodBeat.o(204652);
    }
    
    public final int getItemCount()
    {
      int k = 0;
      AppMethodBeat.i(204650);
      int i;
      int j;
      if (this.sPy)
      {
        i = 1;
        if (FinderPostAtUI.a(this.sPx).size() != 0) {
          break label62;
        }
        j = 0;
        label32:
        if (FinderPostAtUI.b(this.sPx).size() != 0) {
          break label78;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(204650);
        return i + j + k;
        i = 0;
        break;
        label62:
        j = FinderPostAtUI.a(this.sPx).size() + 1;
        break label32;
        label78:
        k = FinderPostAtUI.b(this.sPx).size() + 1;
      }
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(204649);
      int i = paramInt;
      if (!this.sPy) {
        i = paramInt + 1;
      }
      if (i == 0)
      {
        AppMethodBeat.o(204649);
        return 1;
      }
      if (FinderPostAtUI.a(this.sPx).size() > 0)
      {
        if (i == 1)
        {
          AppMethodBeat.o(204649);
          return 2;
        }
        if (i == FinderPostAtUI.a(this.sPx).size() + 2)
        {
          AppMethodBeat.o(204649);
          return 4;
        }
        if (i > FinderPostAtUI.a(this.sPx).size() + 2)
        {
          AppMethodBeat.o(204649);
          return 5;
        }
        AppMethodBeat.o(204649);
        return 3;
      }
      if (i == 1)
      {
        AppMethodBeat.o(204649);
        return 4;
      }
      AppMethodBeat.o(204649);
      return 5;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderPostAtUI.e parame, RecyclerView.w paramw, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(204647);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramView = com.tencent.mm.plugin.finder.utils.b.sWa;
        paramView = paramw.auu;
        d.g.b.p.g(paramView, "viewHolder.itemView");
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.api.LocalFinderContact");
          AppMethodBeat.o(204647);
          throw paramView;
        }
        paramView = com.tencent.mm.plugin.finder.utils.b.i((com.tencent.mm.plugin.finder.api.g)paramView);
        this.sPz.sPx.getIntent().putExtra("key_select_contact", paramView.toByteArray());
        if (this.sPz.getItemViewType(paramInt) == 5) {
          this.sPz.sPx.getIntent().putExtra("key_source", 2);
        }
        for (;;)
        {
          this.sPz.sPx.setResult(-1, this.sPz.sPx.getIntent());
          this.sPz.sPx.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(204647);
          return;
          this.sPz.sPx.getIntent().putExtra("key_source", 1);
        }
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(FinderPostAtUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(204648);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        this.sPz.sPx.getIntent().putExtra("from_at_contact", true);
        this.sPz.sPx.getIntent().putExtra("request_type", 3);
        this.sPz.sPx.getIntent().putExtra("need_history", false);
        paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
        paramView = (MMActivity)this.sPz.sPx;
        localObject = this.sPz.sPx.getIntent();
        d.g.b.p.g(localObject, "intent");
        com.tencent.mm.plugin.finder.utils.a.a(paramView, (Intent)localObject);
        this.sPz.sPy = false;
        this.sPz.cl(0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204648);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(FinderPostAtUI paramFinderPostAtUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(204653);
      this.sPx.finish();
      AppMethodBeat.o(204653);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void AY(int paramInt)
    {
      AppMethodBeat.i(204655);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahF());
      super.AY(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(204655);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(204657);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(204657);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(204656);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(204656);
    }
    
    public final void bZA()
    {
      AppMethodBeat.i(204654);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Object localObject = FinderPostAtUI.sPv;
      ae.i(FinderPostAtUI.access$getTAG$cp(), "onLoadMoreBegin");
      if (FinderPostAtUI.e(this.sPx) != null)
      {
        if (!FinderPostAtUI.f(this.sPx)) {
          break label175;
        }
        FinderPostAtUI.g(this.sPx);
        localObject = FinderPostAtUI.h(this.sPx).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setText(2131759244);
          }
        }
        localObject = FinderPostAtUI.h(this.sPx).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
        localObject = FinderPostAtUI.h(this.sPx).getLoadMoreFooter();
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
        AppMethodBeat.o(204654);
        return;
        label175:
        localObject = FinderPostAtUI.h(this.sPx).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setText(2131759245);
          }
        }
        localObject = FinderPostAtUI.h(this.sPx).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(8);
          }
        }
        localObject = FinderPostAtUI.h(this.sPx).getLoadMoreFooter();
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "o1", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "kotlin.jvm.PlatformType", "o2", "compare"})
  static final class h<T>
    implements Comparator<bvx>
  {
    public static final h sPA;
    
    static
    {
      AppMethodBeat.i(204659);
      sPA = new h();
      AppMethodBeat.o(204659);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "it", "Ljava/lang/Void;", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.b<Void, LinkedList<FinderContact>>
  {
    i(FinderPostAtUI paramFinderPostAtUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "invoke"})
  static final class j
    extends d.g.b.q
    implements d.g.a.b<LinkedList<FinderContact>, Object>
  {
    j(FinderPostAtUI paramFinderPostAtUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(FinderPostAtUI paramFinderPostAtUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(204662);
      Object localObject = FinderPostAtUI.e(this.sPx).getAdapter();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
        AppMethodBeat.o(204662);
        throw ((Throwable)localObject);
      }
      ((FinderPostAtUI.e)localObject).notifyDataSetChanged();
      AppMethodBeat.o(204662);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$onSceneEnd$1$1"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostAtUI
 * JD-Core Version:    0.7.0.1
 */