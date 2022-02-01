package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.bj;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowListUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowListUIC.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z.a;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "Lkotlin/collections/ArrayList;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "fromType", "", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "recentAtContactList", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "doGetFollowScene", "", "getLayoutId", "initContentView", "initData", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "firstPage", "dataList", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "Companion", "ContactViewHolder", "HeaderViewHolder", "SearchViewHolder", "SelectAtContactAdapter", "plugin-finder_release"})
public final class FinderPostAtUI
  extends MMFinderUI
  implements com.tencent.mm.ak.i
{
  private static final String TAG = "Finder.FinderPostAtUI";
  public static final a vME;
  private HashMap _$_findViewCache;
  private int fromType;
  private RecyclerView hak;
  private boolean hasMore;
  private RefreshLoadMoreLayout tLS;
  private com.tencent.mm.bw.b tsO;
  private final com.tencent.mm.plugin.finder.storage.data.g uWD;
  private ArrayList<com.tencent.mm.plugin.finder.api.g> uae;
  private ArrayList<com.tencent.mm.plugin.finder.api.g> vMD;
  
  static
  {
    AppMethodBeat.i(252583);
    vME = new a((byte)0);
    TAG = "Finder.FinderPostAtUI";
    AppMethodBeat.o(252583);
  }
  
  public FinderPostAtUI()
  {
    AppMethodBeat.i(252582);
    this.uae = new ArrayList();
    this.vMD = new ArrayList();
    FinderFollowListUIC.a locala = FinderFollowListUIC.wwp;
    this.uWD = new com.tencent.mm.plugin.finder.storage.data.g(FinderFollowListUIC.dIb());
    this.hasMore = true;
    AppMethodBeat.o(252582);
  }
  
  private final void d(boolean paramBoolean, List<? extends FinderContact> paramList)
  {
    AppMethodBeat.i(252577);
    Log.i(TAG, "firstPage " + paramBoolean + ", get follow contact " + paramList.size());
    if (paramBoolean) {
      this.uae.clear();
    }
    ArrayList localArrayList = this.uae;
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FinderContact localFinderContact = (FinderContact)((Iterator)localObject).next();
      FinderFollowListUIC.a locala = FinderFollowListUIC.wwp;
      paramList.add(FinderFollowListUIC.a.f(localFinderContact));
    }
    localArrayList.addAll((Collection)paramList);
    paramList = this.hak;
    if (paramList == null) {
      p.btv("recyclerView");
    }
    paramList = paramList.getAdapter();
    if (paramList == null)
    {
      paramList = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
      AppMethodBeat.o(252577);
      throw paramList;
    }
    ((e)paramList).notifyDataSetChanged();
    AppMethodBeat.o(252577);
  }
  
  private final void dzW()
  {
    AppMethodBeat.i(252576);
    bj localbj = new bj(this.tsO);
    com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)localbj);
    AppMethodBeat.o(252576);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252588);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252588);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252587);
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
    AppMethodBeat.o(252587);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494565;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(252581);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      AppMethodBeat.o(252581);
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
    AppMethodBeat.i(252575);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.azz().a(713, (com.tencent.mm.ak.i)this);
    this.fromType = getIntent().getIntExtra("KEY_ENTER_SCENE", 0);
    paramBundle = com.tencent.mm.plugin.finder.utils.d.vVg;
    paramBundle = com.tencent.mm.plugin.finder.utils.d.dBy();
    if (paramBundle != null)
    {
      Collections.sort((List)paramBundle, (Comparator)h.vMK);
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        localObject = (cjj)paramBundle.next();
        com.tencent.mm.plugin.finder.utils.d locald = com.tencent.mm.plugin.finder.utils.d.vVg;
        p.g(localObject, "contact");
        localObject = com.tencent.mm.plugin.finder.utils.d.a((cjj)localObject);
        this.vMD.add(localObject);
      }
    }
    com.tencent.mm.ac.d.b(com.tencent.mm.ac.d.a(com.tencent.mm.ac.d.aBx(), (kotlin.g.a.b)new i(this)), (kotlin.g.a.b)new j(this));
    dzW();
    setResult(0, getIntent());
    if (this.fromType == 1) {
      setMMTitle(getResources().getString(2131760410));
    }
    for (;;)
    {
      setBackBtn((MenuItem.OnMenuItemClickListener)new f(this));
      paramBundle = getContext().findViewById(2131307118);
      p.g(paramBundle, "context.findViewById(R.id.rl_layout)");
      this.tLS = ((RefreshLoadMoreLayout)paramBundle);
      paramBundle = this.tLS;
      if (paramBundle == null) {
        p.btv("rlLayout");
      }
      this.hak = paramBundle.getRecyclerView();
      paramBundle = new FinderLinearLayoutManager((Context)this);
      localObject = this.hak;
      if (localObject == null) {
        p.btv("recyclerView");
      }
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)paramBundle);
      paramBundle = this.hak;
      if (paramBundle == null) {
        p.btv("recyclerView");
      }
      paramBundle.setAdapter((RecyclerView.a)new e());
      paramBundle = this.hak;
      if (paramBundle == null) {
        p.btv("recyclerView");
      }
      paramBundle.setHasFixedSize(true);
      paramBundle = this.hak;
      if (paramBundle == null) {
        p.btv("recyclerView");
      }
      paramBundle.setItemViewCacheSize(5);
      paramBundle = this.hak;
      if (paramBundle == null) {
        p.btv("recyclerView");
      }
      paramBundle = paramBundle.getAdapter();
      if (paramBundle != null) {
        break;
      }
      paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
      AppMethodBeat.o(252575);
      throw paramBundle;
      setMMTitle(getResources().getString(2131760409));
    }
    ((e)paramBundle).notifyDataSetChanged();
    paramBundle = this.tLS;
    if (paramBundle == null) {
      p.btv("rlLayout");
    }
    paramBundle.setEnablePullDownHeader(false);
    paramBundle = this.tLS;
    if (paramBundle == null) {
      p.btv("rlLayout");
    }
    Object localObject = aa.jQ((Context)getContext()).inflate(2131495297, null);
    p.g(localObject, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramBundle.setLoadMoreFooter((View)localObject);
    paramBundle = this.tLS;
    if (paramBundle == null) {
      p.btv("rlLayout");
    }
    paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    AppMethodBeat.o(252575);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(252579);
    super.onDestroy();
    com.tencent.mm.kernel.g.azz().b(713, (com.tencent.mm.ak.i)this);
    AppMethodBeat.o(252579);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(252578);
    super.onResume();
    Object localObject = this.hak;
    if (localObject == null) {
      p.btv("recyclerView");
    }
    localObject = ((RecyclerView)localObject).getAdapter();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
      AppMethodBeat.o(252578);
      throw ((Throwable)localObject);
    }
    if (!((e)localObject).vMI)
    {
      localObject = this.hak;
      if (localObject == null) {
        p.btv("recyclerView");
      }
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
        AppMethodBeat.o(252578);
        throw ((Throwable)localObject);
      }
      ((e)localObject).vMI = true;
      localObject = this.hak;
      if (localObject == null) {
        p.btv("recyclerView");
      }
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
        AppMethodBeat.o(252578);
        throw ((Throwable)localObject);
      }
      ((e)localObject).cj(0);
      h.RTc.n((Runnable)new k(this), 300L);
    }
    AppMethodBeat.o(252578);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.ak.q paramq)
  {
    com.tencent.mm.bw.b localb = null;
    AppMethodBeat.i(252580);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene type ");
    if (paramq != null) {}
    for (paramString = Integer.valueOf(paramq.getType());; paramString = null)
    {
      Log.i(str, paramString);
      paramString = localb;
      if (paramq != null) {
        paramString = Integer.valueOf(paramq.getType());
      }
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(252580);
      return;
    }
    if ((paramString.intValue() == 713) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new z.a();
      paramString.SYB = false;
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFollowList");
        AppMethodBeat.o(252580);
        throw paramString;
      }
      localb = ((bj)paramq).cYn();
      if ((p.j(this.tsO, localb) ^ true))
      {
        Log.i(TAG, "not my buf, ignore!");
        AppMethodBeat.o(252580);
        return;
      }
      if (this.tsO == null)
      {
        paramString.SYB = true;
        com.tencent.mm.ac.d.a(com.tencent.mm.ac.d.aBx(), (kotlin.g.a.b)new l(this, paramString, paramq));
      }
      this.hasMore = ((bj)paramq).cYp();
      this.tsO = ((bj)paramq).cYm();
      d(paramString.SYB, (List)((bj)paramq).cYt());
    }
    AppMethodBeat.o(252580);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$Companion;", "", "()V", "ENTER_FROM_SIGNATURE", "", "REQUEST_CODE_SELECT_AT_CONTACT", "TAG", "", "getTAG", "()Ljava/lang/String;", "followContactViewType", "followHeaderViewType", "recentAtContactViewType", "recentAtHeaderViewType", "searchViewType", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$ContactViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "authIcon", "Landroid/widget/ImageView;", "getAuthIcon", "()Landroid/widget/ImageView;", "setAuthIcon", "(Landroid/widget/ImageView;)V", "authJob", "Landroid/widget/TextView;", "getAuthJob", "()Landroid/widget/TextView;", "setAuthJob", "(Landroid/widget/TextView;)V", "avatarIv", "getAvatarIv", "setAvatarIv", "nicknameTv", "getNicknameTv", "setNicknameTv", "plugin-finder_release"})
  public final class b
    extends RecyclerView.v
  {
    ImageView gyr;
    TextView pIN;
    ImageView vMF;
    TextView vMG;
    
    public b()
    {
      super();
      AppMethodBeat.i(252555);
      this$1 = localObject.findViewById(2131297134);
      p.g(FinderPostAtUI.this, "itemView.findViewById(R.id.avatar_iv)");
      this.gyr = ((ImageView)FinderPostAtUI.this);
      this$1 = localObject.findViewById(2131305440);
      p.g(FinderPostAtUI.this, "itemView.findViewById(R.id.nickname_tv)");
      this.pIN = ((TextView)FinderPostAtUI.this);
      this$1 = localObject.findViewById(2131297096);
      p.g(FinderPostAtUI.this, "itemView.findViewById(R.id.auth_icon)");
      this.vMF = ((ImageView)FinderPostAtUI.this);
      this$1 = localObject.findViewById(2131297098);
      p.g(FinderPostAtUI.this, "itemView.findViewById(R.id.auth_job)");
      this.vMG = ((TextView)FinderPostAtUI.this);
      AppMethodBeat.o(252555);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$HeaderViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class c
    extends RecyclerView.v
  {
    TextView titleTv;
    
    public c()
    {
      super();
      AppMethodBeat.i(252556);
      this$1 = localObject.findViewById(2131309249);
      p.g(FinderPostAtUI.this, "itemView.findViewById(R.id.title_tv)");
      this.titleTv = ((TextView)FinderPostAtUI.this);
      AppMethodBeat.o(252556);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$SearchViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "plugin-finder_release"})
  public final class d
    extends RecyclerView.v
  {
    public d()
    {
      super();
      AppMethodBeat.i(252557);
      AppMethodBeat.o(252557);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;)V", "hasSearchView", "", "getHasSearchView", "()Z", "setHasSearchView", "(Z)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class e
    extends RecyclerView.a<RecyclerView.v>
  {
    boolean vMI = true;
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(252562);
      p.h(paramViewGroup, "parent");
      switch (paramInt)
      {
      case 3: 
      default: 
        localFinderPostAtUI = this.vMH;
        localAppCompatActivity = this.vMH.getContext();
        if (localAppCompatActivity == null) {
          p.hyc();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131494221, paramViewGroup, false);
        p.g(paramViewGroup, "context!!.layoutInflater…list_item, parent, false)");
        paramViewGroup = (RecyclerView.v)new FinderPostAtUI.b(localFinderPostAtUI, paramViewGroup);
        AppMethodBeat.o(252562);
        return paramViewGroup;
      case 1: 
        localFinderPostAtUI = this.vMH;
        localAppCompatActivity = this.vMH.getContext();
        if (localAppCompatActivity == null) {
          p.hyc();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131492875, paramViewGroup, false);
        p.g(paramViewGroup, "context!!.layoutInflater…arch_item, parent, false)");
        paramViewGroup = (RecyclerView.v)new FinderPostAtUI.d(localFinderPostAtUI, paramViewGroup);
        AppMethodBeat.o(252562);
        return paramViewGroup;
      case 2: 
        localFinderPostAtUI = this.vMH;
        localAppCompatActivity = this.vMH.getContext();
        if (localAppCompatActivity == null) {
          p.hyc();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131494564, paramViewGroup, false);
        p.g(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
        paramViewGroup = (RecyclerView.v)new FinderPostAtUI.c(localFinderPostAtUI, paramViewGroup);
        AppMethodBeat.o(252562);
        return paramViewGroup;
      }
      FinderPostAtUI localFinderPostAtUI = this.vMH;
      AppCompatActivity localAppCompatActivity = this.vMH.getContext();
      if (localAppCompatActivity == null) {
        p.hyc();
      }
      paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131494564, paramViewGroup, false);
      p.g(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
      paramViewGroup = (RecyclerView.v)new FinderPostAtUI.c(localFinderPostAtUI, paramViewGroup);
      AppMethodBeat.o(252562);
      return paramViewGroup;
    }
    
    public final void a(final RecyclerView.v paramv, final int paramInt)
    {
      int i = 2;
      AppMethodBeat.i(252563);
      p.h(paramv, "viewHolder");
      if ((paramv instanceof FinderPostAtUI.b))
      {
        com.tencent.mm.plugin.finder.api.g localg;
        label58:
        Object localObject1;
        Object localObject2;
        if (this.vMI)
        {
          if (FinderPostAtUI.a(this.vMH).size() != 0) {
            break label283;
          }
          localg = (com.tencent.mm.plugin.finder.api.g)FinderPostAtUI.b(this.vMH).get(paramInt - i);
          p.g(localg, "if (recentAtContactList.…      }\n                }");
          localObject1 = m.uJa;
          localObject1 = m.dka();
          localObject2 = new com.tencent.mm.plugin.finder.loader.a(localg.cXH());
          ImageView localImageView = ((FinderPostAtUI.b)paramv).gyr;
          m localm = m.uJa;
          ((com.tencent.mm.loader.d)localObject1).a(localObject2, localImageView, m.a(m.a.uJe));
          ((FinderPostAtUI.b)paramv).pIN.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)this.vMH.getContext(), (CharSequence)localg.getNickname()));
          localObject1 = localg.field_authInfo;
          if (localObject1 == null) {
            break label354;
          }
          i = ((FinderAuthInfo)localObject1).authIconType;
          label170:
          ((FinderPostAtUI.b)paramv).vMG.setVisibility(8);
          localObject1 = y.vXH;
          y.a(((FinderPostAtUI.b)paramv).vMF, localg.field_authInfo);
          if (i <= 0) {
            break label445;
          }
          switch (i)
          {
          }
        }
        for (;;)
        {
          localObject1 = paramv.aus;
          p.g(localObject1, "viewHolder.itemView");
          ((View)localObject1).setTag(localg);
          paramv.aus.setOnClickListener((View.OnClickListener)new a(this, paramv, paramInt));
          AppMethodBeat.o(252563);
          return;
          i = 1;
          break;
          label283:
          if (paramInt < FinderPostAtUI.a(this.vMH).size() + i)
          {
            localg = (com.tencent.mm.plugin.finder.api.g)FinderPostAtUI.a(this.vMH).get(paramInt - i);
            break label58;
          }
          localg = (com.tencent.mm.plugin.finder.api.g)FinderPostAtUI.b(this.vMH).get(paramInt - FinderPostAtUI.a(this.vMH).size() - i - 1);
          break label58;
          label354:
          i = 0;
          break label170;
          ((FinderPostAtUI.b)paramv).vMG.setVisibility(0);
          localObject2 = ((FinderPostAtUI.b)paramv).vMG;
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
          ((FinderPostAtUI.b)paramv).vMG.setVisibility(8);
          continue;
          label445:
          ((FinderPostAtUI.b)paramv).vMG.setVisibility(8);
        }
      }
      if ((paramv instanceof FinderPostAtUI.d))
      {
        paramv.aus.setOnClickListener((View.OnClickListener)new b(this));
        AppMethodBeat.o(252563);
        return;
      }
      if ((paramv instanceof FinderPostAtUI.c))
      {
        if (getItemViewType(paramInt) == 2)
        {
          ((FinderPostAtUI.c)paramv).titleTv.setText((CharSequence)this.vMH.getString(2131760408));
          AppMethodBeat.o(252563);
          return;
        }
        ((FinderPostAtUI.c)paramv).titleTv.setText((CharSequence)this.vMH.getString(2131760407));
      }
      AppMethodBeat.o(252563);
    }
    
    public final int getItemCount()
    {
      int k = 0;
      AppMethodBeat.i(252561);
      int i;
      int j;
      if (this.vMI)
      {
        i = 1;
        if (FinderPostAtUI.a(this.vMH).size() != 0) {
          break label62;
        }
        j = 0;
        label32:
        if (FinderPostAtUI.b(this.vMH).size() != 0) {
          break label78;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(252561);
        return i + j + k;
        i = 0;
        break;
        label62:
        j = FinderPostAtUI.a(this.vMH).size() + 1;
        break label32;
        label78:
        k = FinderPostAtUI.b(this.vMH).size() + 1;
      }
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(252560);
      int i = paramInt;
      if (!this.vMI) {
        i = paramInt + 1;
      }
      if (i == 0)
      {
        AppMethodBeat.o(252560);
        return 1;
      }
      if (FinderPostAtUI.a(this.vMH).size() > 0)
      {
        if (i == 1)
        {
          AppMethodBeat.o(252560);
          return 2;
        }
        if (i == FinderPostAtUI.a(this.vMH).size() + 2)
        {
          AppMethodBeat.o(252560);
          return 4;
        }
        if (i > FinderPostAtUI.a(this.vMH).size() + 2)
        {
          AppMethodBeat.o(252560);
          return 5;
        }
        AppMethodBeat.o(252560);
        return 3;
      }
      if (i == 1)
      {
        AppMethodBeat.o(252560);
        return 4;
      }
      AppMethodBeat.o(252560);
      return 5;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderPostAtUI.e parame, RecyclerView.v paramv, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(252558);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramView = com.tencent.mm.plugin.finder.utils.d.vVg;
        paramView = paramv.aus;
        p.g(paramView, "viewHolder.itemView");
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.api.LocalFinderContact");
          AppMethodBeat.o(252558);
          throw paramView;
        }
        paramView = com.tencent.mm.plugin.finder.utils.d.h((com.tencent.mm.plugin.finder.api.g)paramView);
        this.vMJ.vMH.getIntent().putExtra("key_select_contact", paramView.toByteArray());
        if (this.vMJ.getItemViewType(paramInt) == 5) {
          this.vMJ.vMH.getIntent().putExtra("key_source", 2);
        }
        for (;;)
        {
          this.vMJ.vMH.setResult(-1, this.vMJ.vMH.getIntent());
          this.vMJ.vMH.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(252558);
          return;
          this.vMJ.vMH.getIntent().putExtra("key_source", 1);
        }
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(FinderPostAtUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(252559);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        this.vMJ.vMH.getIntent().putExtra("from_at_contact", true);
        this.vMJ.vMH.getIntent().putExtra("request_type", 6);
        this.vMJ.vMH.getIntent().putExtra("need_history", false);
        paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
        paramView = (MMActivity)this.vMJ.vMH;
        localObject = this.vMJ.vMH.getIntent();
        p.g(localObject, "intent");
        com.tencent.mm.plugin.finder.utils.a.a(paramView, (Intent)localObject);
        this.vMJ.vMI = false;
        this.vMJ.ck(0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(252559);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(FinderPostAtUI paramFinderPostAtUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(252564);
      this.vMH.finish();
      AppMethodBeat.o(252564);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(252566);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(252566);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(252568);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(252568);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(252565);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Object localObject = FinderPostAtUI.vME;
      Log.i(FinderPostAtUI.access$getTAG$cp(), "onLoadMoreBegin");
      if (FinderPostAtUI.e(this.vMH) != null)
      {
        if (!FinderPostAtUI.f(this.vMH)) {
          break label175;
        }
        FinderPostAtUI.g(this.vMH);
        localObject = FinderPostAtUI.h(this.vMH).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131303685);
          if (localObject != null) {
            ((TextView)localObject).setText(2131760234);
          }
        }
        localObject = FinderPostAtUI.h(this.vMH).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131303685);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
        localObject = FinderPostAtUI.h(this.vMH).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = ((View)localObject).findViewById(2131303684);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(252565);
        return;
        label175:
        localObject = FinderPostAtUI.h(this.vMH).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131303685);
          if (localObject != null) {
            ((TextView)localObject).setText(2131760235);
          }
        }
        localObject = FinderPostAtUI.h(this.vMH).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131303685);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(8);
          }
        }
        localObject = FinderPostAtUI.h(this.vMH).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = ((View)localObject).findViewById(2131303684);
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
        }
      }
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(252567);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(252567);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "o1", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "kotlin.jvm.PlatformType", "o2", "compare"})
  static final class h<T>
    implements Comparator<cjj>
  {
    public static final h vMK;
    
    static
    {
      AppMethodBeat.i(252570);
      vMK = new h();
      AppMethodBeat.o(252570);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "it", "Ljava/lang/Void;", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Void, LinkedList<FinderContact>>
  {
    i(FinderPostAtUI paramFinderPostAtUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.b<LinkedList<FinderContact>, Object>
  {
    j(FinderPostAtUI paramFinderPostAtUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(FinderPostAtUI paramFinderPostAtUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(252573);
      Object localObject = FinderPostAtUI.e(this.vMH).getAdapter();
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
        AppMethodBeat.o(252573);
        throw ((Throwable)localObject);
      }
      ((FinderPostAtUI.e)localObject).notifyDataSetChanged();
      AppMethodBeat.o(252573);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$onSceneEnd$1$1"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Void, x>
  {
    l(FinderPostAtUI paramFinderPostAtUI, z.a parama, com.tencent.mm.ak.q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostAtUI
 * JD-Core Version:    0.7.0.1
 */