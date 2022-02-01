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
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.cgi.ad;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.z;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.a.j;
import d.g.b.v.a;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "Lkotlin/collections/ArrayList;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "recentAtContactList", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "doGetFollowScene", "", "getLayoutId", "", "initContentView", "initData", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "firstPage", "dataList", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "Companion", "ContactViewHolder", "HeaderViewHolder", "SearchViewHolder", "SelectAtContactAdapter", "plugin-finder_release"})
public final class FinderPostAtUI
  extends MMFinderUI
  implements com.tencent.mm.ak.g
{
  private static final String TAG = "Finder.FinderPostAtUI";
  public static final FinderPostAtUI.a rJx;
  private HashMap _$_findViewCache;
  private RecyclerView fTr;
  private boolean hasMore;
  private final com.tencent.mm.plugin.finder.storage.data.f rHD;
  private ArrayList<com.tencent.mm.plugin.finder.api.f> rJw;
  private RefreshLoadMoreLayout rfT;
  private com.tencent.mm.bw.b rpX;
  private ArrayList<com.tencent.mm.plugin.finder.api.f> rpr;
  
  static
  {
    AppMethodBeat.i(203278);
    rJx = new FinderPostAtUI.a((byte)0);
    TAG = "Finder.FinderPostAtUI";
    AppMethodBeat.o(203278);
  }
  
  public FinderPostAtUI()
  {
    AppMethodBeat.i(203277);
    this.rpr = new ArrayList();
    this.rJw = new ArrayList();
    FinderFollowListUI.a locala = FinderFollowListUI.rHE;
    this.rHD = new com.tencent.mm.plugin.finder.storage.data.f(FinderFollowListUI.cBK());
    this.hasMore = true;
    AppMethodBeat.o(203277);
  }
  
  private final void c(boolean paramBoolean, List<? extends FinderContact> paramList)
  {
    AppMethodBeat.i(203272);
    ac.i(TAG, "firstPage " + paramBoolean + ", get follow contact " + paramList.size());
    if (paramBoolean) {
      this.rpr.clear();
    }
    ArrayList localArrayList = this.rpr;
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FinderContact localFinderContact = (FinderContact)((Iterator)localObject).next();
      FinderFollowListUI.a locala = FinderFollowListUI.rHE;
      paramList.add(FinderFollowListUI.a.c(localFinderContact));
    }
    localArrayList.addAll((Collection)paramList);
    paramList = this.fTr;
    if (paramList == null) {
      d.g.b.k.aVY("recyclerView");
    }
    paramList = paramList.getAdapter();
    if (paramList == null)
    {
      paramList = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
      AppMethodBeat.o(203272);
      throw paramList;
    }
    ((e)paramList).notifyDataSetChanged();
    AppMethodBeat.o(203272);
  }
  
  private final void cBJ()
  {
    AppMethodBeat.i(203271);
    ad localad = new ad(this.rpX);
    com.tencent.mm.kernel.g.agi().b((n)localad);
    AppMethodBeat.o(203271);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203282);
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
    AppMethodBeat.o(203282);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496244;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(203276);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      AppMethodBeat.o(203276);
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
    AppMethodBeat.i(203270);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.agi().a(713, (com.tencent.mm.ak.g)this);
    paramBundle = com.tencent.mm.plugin.finder.utils.b.rOw;
    paramBundle = com.tencent.mm.plugin.finder.utils.b.cCL();
    if (paramBundle != null)
    {
      Collections.sort((List)paramBundle, (Comparator)h.rJB);
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        localObject = (bqq)paramBundle.next();
        com.tencent.mm.plugin.finder.utils.b localb = com.tencent.mm.plugin.finder.utils.b.rOw;
        d.g.b.k.g(localObject, "contact");
        localObject = com.tencent.mm.plugin.finder.utils.b.a((bqq)localObject);
        this.rJw.add(localObject);
      }
    }
    c.b(c.a(c.aid(), (d.g.a.b)new i(this)), (d.g.a.b)new j(this));
    cBJ();
    setResult(0, getIntent());
    setMMTitle(getResources().getString(2131766484));
    setBackBtn((MenuItem.OnMenuItemClickListener)new FinderPostAtUI.f(this));
    paramBundle = getContext().findViewById(2131304203);
    d.g.b.k.g(paramBundle, "context.findViewById(R.id.rl_layout)");
    this.rfT = ((RefreshLoadMoreLayout)paramBundle);
    paramBundle = this.rfT;
    if (paramBundle == null) {
      d.g.b.k.aVY("rlLayout");
    }
    this.fTr = paramBundle.getRecyclerView();
    paramBundle = new FinderLayoutManager((byte)0);
    Object localObject = this.fTr;
    if (localObject == null) {
      d.g.b.k.aVY("recyclerView");
    }
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)paramBundle);
    paramBundle = this.fTr;
    if (paramBundle == null) {
      d.g.b.k.aVY("recyclerView");
    }
    paramBundle.setAdapter((RecyclerView.a)new e());
    paramBundle = this.fTr;
    if (paramBundle == null) {
      d.g.b.k.aVY("recyclerView");
    }
    paramBundle.setHasFixedSize(true);
    paramBundle = this.fTr;
    if (paramBundle == null) {
      d.g.b.k.aVY("recyclerView");
    }
    paramBundle.setItemViewCacheSize(5);
    paramBundle = this.fTr;
    if (paramBundle == null) {
      d.g.b.k.aVY("recyclerView");
    }
    paramBundle = paramBundle.getAdapter();
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
      AppMethodBeat.o(203270);
      throw paramBundle;
    }
    ((e)paramBundle).notifyDataSetChanged();
    paramBundle = this.rfT;
    if (paramBundle == null) {
      d.g.b.k.aVY("rlLayout");
    }
    paramBundle.setEnablePullDownHeader(false);
    paramBundle = this.rfT;
    if (paramBundle == null) {
      d.g.b.k.aVY("rlLayout");
    }
    localObject = z.jD((Context)getContext()).inflate(2131494590, null);
    d.g.b.k.g(localObject, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramBundle.setLoadMoreFooter((View)localObject);
    paramBundle = this.rfT;
    if (paramBundle == null) {
      d.g.b.k.aVY("rlLayout");
    }
    paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    AppMethodBeat.o(203270);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203274);
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(713, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(203274);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(203273);
    super.onResume();
    Object localObject = this.fTr;
    if (localObject == null) {
      d.g.b.k.aVY("recyclerView");
    }
    localObject = ((RecyclerView)localObject).getAdapter();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
      AppMethodBeat.o(203273);
      throw ((Throwable)localObject);
    }
    if (!((e)localObject).rJz)
    {
      localObject = this.fTr;
      if (localObject == null) {
        d.g.b.k.aVY("recyclerView");
      }
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
        AppMethodBeat.o(203273);
        throw ((Throwable)localObject);
      }
      ((e)localObject).rJz = true;
      localObject = this.fTr;
      if (localObject == null) {
        d.g.b.k.aVY("recyclerView");
      }
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
        AppMethodBeat.o(203273);
        throw ((Throwable)localObject);
      }
      ((e)localObject).ck(0);
      com.tencent.e.h.JZN.p((Runnable)new k(this), 300L);
    }
    AppMethodBeat.o(203273);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final n paramn)
  {
    com.tencent.mm.bw.b localb = null;
    AppMethodBeat.i(203275);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene type ");
    if (paramn != null) {}
    for (paramString = Integer.valueOf(paramn.getType());; paramString = null)
    {
      ac.i(str, paramString);
      paramString = localb;
      if (paramn != null) {
        paramString = Integer.valueOf(paramn.getType());
      }
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(203275);
      return;
    }
    if ((paramString.intValue() == 713) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new v.a();
      paramString.KUL = false;
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFollowList");
        AppMethodBeat.o(203275);
        throw paramString;
      }
      localb = ((ad)paramn).csv();
      if ((d.g.b.k.g(this.rpX, localb) ^ true))
      {
        ac.i(TAG, "not my buf, ignore!");
        AppMethodBeat.o(203275);
        return;
      }
      if (this.rpX == null)
      {
        paramString.KUL = true;
        c.a(c.aid(), (d.g.a.b)new l(this, paramString, paramn));
      }
      this.hasMore = ((ad)paramn).css();
      this.rpX = ((ad)paramn).csq();
      c(paramString.KUL, (List)((ad)paramn).csu());
    }
    AppMethodBeat.o(203275);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$ContactViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "authIcon", "Landroid/widget/ImageView;", "getAuthIcon", "()Landroid/widget/ImageView;", "setAuthIcon", "(Landroid/widget/ImageView;)V", "authJob", "Landroid/widget/TextView;", "getAuthJob", "()Landroid/widget/TextView;", "setAuthJob", "(Landroid/widget/TextView;)V", "avatarIv", "getAvatarIv", "setAvatarIv", "nicknameTv", "getNicknameTv", "setNicknameTv", "plugin-finder_release"})
  public final class b
    extends RecyclerView.w
  {
    ImageView fxQ;
    TextView nMU;
    TextView rFt;
    ImageView rqZ;
    
    public b()
    {
      super();
      AppMethodBeat.i(203250);
      this$1 = localObject.findViewById(2131297008);
      d.g.b.k.g(FinderPostAtUI.this, "itemView.findViewById(R.id.avatar_iv)");
      this.fxQ = ((ImageView)FinderPostAtUI.this);
      this$1 = localObject.findViewById(2131302867);
      d.g.b.k.g(FinderPostAtUI.this, "itemView.findViewById(R.id.nickname_tv)");
      this.nMU = ((TextView)FinderPostAtUI.this);
      this$1 = localObject.findViewById(2131296977);
      d.g.b.k.g(FinderPostAtUI.this, "itemView.findViewById(R.id.auth_icon)");
      this.rqZ = ((ImageView)FinderPostAtUI.this);
      this$1 = localObject.findViewById(2131296980);
      d.g.b.k.g(FinderPostAtUI.this, "itemView.findViewById(R.id.auth_job)");
      this.rFt = ((TextView)FinderPostAtUI.this);
      AppMethodBeat.o(203250);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;)V", "hasSearchView", "", "getHasSearchView", "()Z", "setHasSearchView", "(Z)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class e
    extends RecyclerView.a<RecyclerView.w>
  {
    boolean rJz = true;
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(203257);
      d.g.b.k.h(paramViewGroup, "parent");
      switch (paramInt)
      {
      case 3: 
      default: 
        localFinderPostAtUI = this.rJy;
        localAppCompatActivity = this.rJy.getContext();
        if (localAppCompatActivity == null) {
          d.g.b.k.fOy();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131494016, paramViewGroup, false);
        d.g.b.k.g(paramViewGroup, "context!!.layoutInflater…list_item, parent, false)");
        paramViewGroup = (RecyclerView.w)new FinderPostAtUI.b(localFinderPostAtUI, paramViewGroup);
        AppMethodBeat.o(203257);
        return paramViewGroup;
      case 1: 
        localFinderPostAtUI = this.rJy;
        localAppCompatActivity = this.rJy.getContext();
        if (localAppCompatActivity == null) {
          d.g.b.k.fOy();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131492869, paramViewGroup, false);
        d.g.b.k.g(paramViewGroup, "context!!.layoutInflater…arch_item, parent, false)");
        paramViewGroup = (RecyclerView.w)new FinderPostAtUI.d(localFinderPostAtUI, paramViewGroup);
        AppMethodBeat.o(203257);
        return paramViewGroup;
      case 2: 
        localFinderPostAtUI = this.rJy;
        localAppCompatActivity = this.rJy.getContext();
        if (localAppCompatActivity == null) {
          d.g.b.k.fOy();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131496243, paramViewGroup, false);
        d.g.b.k.g(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
        paramViewGroup = (RecyclerView.w)new FinderPostAtUI.c(localFinderPostAtUI, paramViewGroup);
        AppMethodBeat.o(203257);
        return paramViewGroup;
      }
      FinderPostAtUI localFinderPostAtUI = this.rJy;
      AppCompatActivity localAppCompatActivity = this.rJy.getContext();
      if (localAppCompatActivity == null) {
        d.g.b.k.fOy();
      }
      paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131496243, paramViewGroup, false);
      d.g.b.k.g(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
      paramViewGroup = (RecyclerView.w)new FinderPostAtUI.c(localFinderPostAtUI, paramViewGroup);
      AppMethodBeat.o(203257);
      return paramViewGroup;
    }
    
    public final void a(final RecyclerView.w paramw, final int paramInt)
    {
      AppMethodBeat.i(203258);
      d.g.b.k.h(paramw, "viewHolder");
      if ((paramw instanceof FinderPostAtUI.b))
      {
        com.tencent.mm.plugin.finder.api.f localf;
        Object localObject1;
        Object localObject2;
        Object localObject3;
        int i;
        if (FinderPostAtUI.a(this.rJy).size() == 0)
        {
          localf = (com.tencent.mm.plugin.finder.api.f)FinderPostAtUI.b(this.rJy).get(paramInt - 2);
          d.g.b.k.g(localf, "if (recentAtContactList.…      }\n                }");
          localObject1 = com.tencent.mm.plugin.finder.loader.h.rtK;
          localObject1 = com.tencent.mm.plugin.finder.loader.h.cwo();
          localObject2 = new com.tencent.mm.plugin.finder.loader.a(localf.crZ());
          localObject3 = ((FinderPostAtUI.b)paramw).fxQ;
          com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.rtK;
          ((d)localObject1).a(localObject2, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.h.a(h.a.rtN));
          ((FinderPostAtUI.b)paramw).nMU.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)this.rJy.getContext(), (CharSequence)localf.Tn()));
          localObject1 = localf.field_authInfo;
          if (localObject1 == null) {
            break label327;
          }
          i = ((FinderAuthInfo)localObject1).authIconType;
          label161:
          ((FinderPostAtUI.b)paramw).rFt.setVisibility(8);
          if (i <= 0) {
            break label575;
          }
          switch (i)
          {
          }
        }
        for (;;)
        {
          localObject1 = paramw.asD;
          d.g.b.k.g(localObject1, "viewHolder.itemView");
          ((View)localObject1).setTag(localf);
          paramw.asD.setOnClickListener((View.OnClickListener)new a(this, paramw, paramInt));
          AppMethodBeat.o(203258);
          return;
          if (paramInt < FinderPostAtUI.a(this.rJy).size() + 2)
          {
            localf = (com.tencent.mm.plugin.finder.api.f)FinderPostAtUI.a(this.rJy).get(paramInt - 2);
            break;
          }
          localf = (com.tencent.mm.plugin.finder.api.f)FinderPostAtUI.b(this.rJy).get(paramInt - FinderPostAtUI.a(this.rJy).size() - 3);
          break;
          label327:
          i = 0;
          break label161;
          ((FinderPostAtUI.b)paramw).rqZ.setVisibility(0);
          ((FinderPostAtUI.b)paramw).rFt.setVisibility(0);
          localObject1 = ((FinderPostAtUI.b)paramw).rqZ;
          localObject2 = (Context)this.rJy.getContext();
          localObject3 = this.rJy.getContext();
          d.g.b.k.g(localObject3, "context");
          ((ImageView)localObject1).setImageDrawable(am.k((Context)localObject2, 2131690481, ((AppCompatActivity)localObject3).getResources().getColor(2131099777)));
          localObject2 = ((FinderPostAtUI.b)paramw).rFt;
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
          ((FinderPostAtUI.b)paramw).rqZ.setVisibility(0);
          localObject1 = ((FinderPostAtUI.b)paramw).rqZ;
          localObject2 = (Context)this.rJy.getContext();
          localObject3 = this.rJy.getContext();
          d.g.b.k.g(localObject3, "context");
          ((ImageView)localObject1).setImageDrawable(am.k((Context)localObject2, 2131690481, ((AppCompatActivity)localObject3).getResources().getColor(2131099748)));
          continue;
          ((FinderPostAtUI.b)paramw).rqZ.setVisibility(8);
          ((FinderPostAtUI.b)paramw).rFt.setVisibility(8);
          continue;
          label575:
          ((FinderPostAtUI.b)paramw).rqZ.setVisibility(8);
          ((FinderPostAtUI.b)paramw).rFt.setVisibility(8);
        }
      }
      if ((paramw instanceof FinderPostAtUI.d))
      {
        paramw.asD.setOnClickListener((View.OnClickListener)new b(this));
        AppMethodBeat.o(203258);
        return;
      }
      if ((paramw instanceof FinderPostAtUI.c))
      {
        if (getItemViewType(paramInt) == 2)
        {
          ((FinderPostAtUI.c)paramw).titleTv.setText((CharSequence)this.rJy.getString(2131766483));
          AppMethodBeat.o(203258);
          return;
        }
        ((FinderPostAtUI.c)paramw).titleTv.setText((CharSequence)this.rJy.getString(2131766482));
      }
      AppMethodBeat.o(203258);
    }
    
    public final int getItemCount()
    {
      int k = 0;
      AppMethodBeat.i(203256);
      int i;
      int j;
      if (this.rJz)
      {
        i = 1;
        if (FinderPostAtUI.a(this.rJy).size() != 0) {
          break label62;
        }
        j = 0;
        label32:
        if (FinderPostAtUI.b(this.rJy).size() != 0) {
          break label78;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(203256);
        return i + j + k;
        i = 0;
        break;
        label62:
        j = FinderPostAtUI.a(this.rJy).size() + 1;
        break label32;
        label78:
        k = FinderPostAtUI.b(this.rJy).size() + 1;
      }
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(203255);
      int i = paramInt;
      if (!this.rJz) {
        i = paramInt + 1;
      }
      if (i == 0)
      {
        AppMethodBeat.o(203255);
        return 1;
      }
      if (FinderPostAtUI.a(this.rJy).size() > 0)
      {
        if (i == 1)
        {
          AppMethodBeat.o(203255);
          return 2;
        }
        if (i == FinderPostAtUI.a(this.rJy).size() + 2)
        {
          AppMethodBeat.o(203255);
          return 4;
        }
        if (i > FinderPostAtUI.a(this.rJy).size() + 2)
        {
          AppMethodBeat.o(203255);
          return 5;
        }
        AppMethodBeat.o(203255);
        return 3;
      }
      if (i == 1)
      {
        AppMethodBeat.o(203255);
        return 4;
      }
      AppMethodBeat.o(203255);
      return 5;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderPostAtUI.e parame, RecyclerView.w paramw, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(203253);
        paramView = com.tencent.mm.plugin.finder.utils.b.rOw;
        paramView = paramw.asD;
        d.g.b.k.g(paramView, "viewHolder.itemView");
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.api.LocalFinderContact");
          AppMethodBeat.o(203253);
          throw paramView;
        }
        paramView = com.tencent.mm.plugin.finder.utils.b.d((com.tencent.mm.plugin.finder.api.f)paramView);
        this.rJA.rJy.getIntent().putExtra("key_select_contact", paramView.toByteArray());
        if (this.rJA.getItemViewType(paramInt) == 5) {
          this.rJA.rJy.getIntent().putExtra("key_source", 2);
        }
        for (;;)
        {
          this.rJA.rJy.setResult(-1, this.rJA.rJy.getIntent());
          this.rJA.rJy.finish();
          AppMethodBeat.o(203253);
          return;
          this.rJA.rJy.getIntent().putExtra("key_source", 1);
        }
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(FinderPostAtUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(203254);
        this.rJA.rJy.getIntent().putExtra("from_at_contact", true);
        this.rJA.rJy.getIntent().putExtra("request_type", 3);
        this.rJA.rJy.getIntent().putExtra("need_history", false);
        paramView = com.tencent.mm.plugin.finder.utils.a.rOv;
        paramView = (MMActivity)this.rJA.rJy;
        Intent localIntent = this.rJA.rJy.getIntent();
        d.g.b.k.g(localIntent, "intent");
        com.tencent.mm.plugin.finder.utils.a.a(paramView, localIntent);
        this.rJA.rJz = false;
        this.rJA.cl(0);
        AppMethodBeat.o(203254);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void Ad(int paramInt)
    {
      AppMethodBeat.i(203261);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aeE());
      super.Ad(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(203261);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(203263);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(203263);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(203262);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(203262);
    }
    
    public final void bTG()
    {
      AppMethodBeat.i(203260);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Object localObject = FinderPostAtUI.rJx;
      ac.i(FinderPostAtUI.access$getTAG$cp(), "onLoadMoreBegin");
      if (FinderPostAtUI.e(this.rJy) != null)
      {
        if (!FinderPostAtUI.f(this.rJy)) {
          break label109;
        }
        FinderPostAtUI.g(this.rJy);
        localObject = FinderPostAtUI.h(this.rJy).getLoadMoreFooter();
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
        AppMethodBeat.o(203260);
        return;
        label109:
        localObject = FinderPostAtUI.h(this.rJy).getLoadMoreFooter();
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "o1", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "kotlin.jvm.PlatformType", "o2", "compare"})
  static final class h<T>
    implements Comparator<bqq>
  {
    public static final h rJB;
    
    static
    {
      AppMethodBeat.i(203265);
      rJB = new h();
      AppMethodBeat.o(203265);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "it", "Ljava/lang/Void;", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.b<Void, LinkedList<FinderContact>>
  {
    i(FinderPostAtUI paramFinderPostAtUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.b<LinkedList<FinderContact>, Object>
  {
    j(FinderPostAtUI paramFinderPostAtUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(FinderPostAtUI paramFinderPostAtUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(203268);
      Object localObject = FinderPostAtUI.e(this.rJy).getAdapter();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
        AppMethodBeat.o(203268);
        throw ((Throwable)localObject);
      }
      ((FinderPostAtUI.e)localObject).notifyDataSetChanged();
      AppMethodBeat.o(203268);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$onSceneEnd$1$1"})
  static final class l
    extends d.g.b.l
    implements d.g.a.b<Void, y>
  {
    l(FinderPostAtUI paramFinderPostAtUI, v.a parama, n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostAtUI
 * JD-Core Version:    0.7.0.1
 */