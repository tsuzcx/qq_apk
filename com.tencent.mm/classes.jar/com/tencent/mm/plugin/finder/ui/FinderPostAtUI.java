package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.bm;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.storage.data.g;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.w;
import com.tencent.mm.plugin.finder.viewmodel.component.w.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
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
import kotlin.g.b.aa.a;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "Lkotlin/collections/ArrayList;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "fromType", "", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "recentAtContactList", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "doGetFollowScene", "", "getLayoutId", "initContentView", "initData", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "firstPage", "dataList", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "Companion", "ContactViewHolder", "HeaderViewHolder", "SearchViewHolder", "SelectAtContactAdapter", "plugin-finder_release"})
public final class FinderPostAtUI
  extends MMFinderUI
  implements com.tencent.mm.an.i
{
  public static final a Atv;
  private static final String TAG = "Finder.FinderPostAtUI";
  private ArrayList<com.tencent.mm.plugin.finder.api.i> Atu;
  private HashMap _$_findViewCache;
  private int fromType;
  private boolean hasMore;
  private RecyclerView jLl;
  private ArrayList<com.tencent.mm.plugin.finder.api.i> xMG;
  private com.tencent.mm.cd.b xaw;
  private RefreshLoadMoreLayout xvJ;
  private final g zMR;
  
  static
  {
    AppMethodBeat.i(291843);
    Atv = new a((byte)0);
    TAG = "Finder.FinderPostAtUI";
    AppMethodBeat.o(291843);
  }
  
  public FinderPostAtUI()
  {
    AppMethodBeat.i(291842);
    this.xMG = new ArrayList();
    this.Atu = new ArrayList();
    w.a locala = w.Bkt;
    this.zMR = new g(w.ekC());
    this.hasMore = true;
    AppMethodBeat.o(291842);
  }
  
  private final void d(boolean paramBoolean, List<? extends FinderContact> paramList)
  {
    AppMethodBeat.i(291837);
    Log.i(TAG, "firstPage " + paramBoolean + ", get follow contact " + paramList.size());
    if (paramBoolean) {
      this.xMG.clear();
    }
    ArrayList localArrayList = this.xMG;
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FinderContact localFinderContact = (FinderContact)((Iterator)localObject).next();
      w.a locala = w.Bkt;
      paramList.add(w.a.g(localFinderContact));
    }
    localArrayList.addAll((Collection)paramList);
    paramList = this.jLl;
    if (paramList == null) {
      p.bGy("recyclerView");
    }
    paramList = paramList.getAdapter();
    if (paramList == null)
    {
      paramList = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
      AppMethodBeat.o(291837);
      throw paramList;
    }
    ((e)paramList).notifyDataSetChanged();
    AppMethodBeat.o(291837);
  }
  
  private final void eaN()
  {
    AppMethodBeat.i(291836);
    bm localbm = new bm(this.xaw);
    com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)localbm);
    AppMethodBeat.o(291836);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(291848);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(291848);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(291847);
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
    AppMethodBeat.o(291847);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_post_at_ui;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(291841);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      AppMethodBeat.o(291841);
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
    AppMethodBeat.i(291835);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aGY().a(713, (com.tencent.mm.an.i)this);
    this.fromType = getIntent().getIntExtra("KEY_ENTER_SCENE", 0);
    paramBundle = com.tencent.mm.plugin.finder.utils.e.ACV;
    paramBundle = com.tencent.mm.plugin.finder.utils.e.ecL();
    if (paramBundle != null)
    {
      Collections.sort((List)paramBundle, (Comparator)h.AtB);
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        localObject = (cse)paramBundle.next();
        com.tencent.mm.plugin.finder.utils.e locale = com.tencent.mm.plugin.finder.utils.e.ACV;
        p.j(localObject, "contact");
        localObject = com.tencent.mm.plugin.finder.utils.e.a((cse)localObject);
        this.Atu.add(localObject);
      }
    }
    com.tencent.mm.ae.d.b(com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.aJa(), (kotlin.g.a.b)new i(this)), (kotlin.g.a.b)new j(this));
    eaN();
    setResult(0, getIntent());
    if (this.fromType == 1) {
      setMMTitle(getResources().getString(b.j.finder_post_at_select_at_contact2));
    }
    for (;;)
    {
      setBackBtn((MenuItem.OnMenuItemClickListener)new f(this));
      paramBundle = getContext().findViewById(b.f.rl_layout);
      p.j(paramBundle, "context.findViewById(R.id.rl_layout)");
      this.xvJ = ((RefreshLoadMoreLayout)paramBundle);
      paramBundle = this.xvJ;
      if (paramBundle == null) {
        p.bGy("rlLayout");
      }
      this.jLl = paramBundle.getRecyclerView();
      paramBundle = new FinderLinearLayoutManager((Context)this);
      localObject = this.jLl;
      if (localObject == null) {
        p.bGy("recyclerView");
      }
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)paramBundle);
      paramBundle = this.jLl;
      if (paramBundle == null) {
        p.bGy("recyclerView");
      }
      paramBundle.setAdapter((RecyclerView.a)new e());
      paramBundle = this.jLl;
      if (paramBundle == null) {
        p.bGy("recyclerView");
      }
      paramBundle.setHasFixedSize(true);
      paramBundle = this.jLl;
      if (paramBundle == null) {
        p.bGy("recyclerView");
      }
      paramBundle.setItemViewCacheSize(5);
      paramBundle = this.jLl;
      if (paramBundle == null) {
        p.bGy("recyclerView");
      }
      paramBundle = paramBundle.getAdapter();
      if (paramBundle != null) {
        break;
      }
      paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
      AppMethodBeat.o(291835);
      throw paramBundle;
      setMMTitle(getResources().getString(b.j.finder_post_at_select_at_contact));
    }
    ((e)paramBundle).notifyDataSetChanged();
    paramBundle = this.xvJ;
    if (paramBundle == null) {
      p.bGy("rlLayout");
    }
    paramBundle.setEnablePullDownHeader(false);
    paramBundle = this.xvJ;
    if (paramBundle == null) {
      p.bGy("rlLayout");
    }
    Object localObject = ad.kS((Context)getContext()).inflate(b.g.load_more_footer, null);
    p.j(localObject, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramBundle.setLoadMoreFooter((View)localObject);
    paramBundle = this.xvJ;
    if (paramBundle == null) {
      p.bGy("rlLayout");
    }
    paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    AppMethodBeat.o(291835);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(291839);
    super.onDestroy();
    com.tencent.mm.kernel.h.aGY().b(713, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(291839);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(291838);
    super.onResume();
    Object localObject = this.jLl;
    if (localObject == null) {
      p.bGy("recyclerView");
    }
    localObject = ((RecyclerView)localObject).getAdapter();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
      AppMethodBeat.o(291838);
      throw ((Throwable)localObject);
    }
    if (!((e)localObject).Atz)
    {
      localObject = this.jLl;
      if (localObject == null) {
        p.bGy("recyclerView");
      }
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
        AppMethodBeat.o(291838);
        throw ((Throwable)localObject);
      }
      ((e)localObject).Atz = true;
      localObject = this.jLl;
      if (localObject == null) {
        p.bGy("recyclerView");
      }
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
        AppMethodBeat.o(291838);
        throw ((Throwable)localObject);
      }
      ((e)localObject).cM(0);
      com.tencent.e.h.ZvG.n((Runnable)new k(this), 300L);
    }
    AppMethodBeat.o(291838);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.an.q paramq)
  {
    com.tencent.mm.cd.b localb = null;
    AppMethodBeat.i(291840);
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
      AppMethodBeat.o(291840);
      return;
    }
    if ((paramString.intValue() == 713) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new aa.a();
      paramString.aaBx = false;
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFollowList");
        AppMethodBeat.o(291840);
        throw paramString;
      }
      localb = ((bm)paramq).dob();
      if ((p.h(this.xaw, localb) ^ true))
      {
        Log.i(TAG, "not my buf, ignore!");
        AppMethodBeat.o(291840);
        return;
      }
      if (this.xaw == null)
      {
        paramString.aaBx = true;
        com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.aJa(), (kotlin.g.a.b)new l(this, paramString, paramq));
      }
      this.hasMore = ((bm)paramq).dod();
      this.xaw = ((bm)paramq).doa();
      d(paramString.aaBx, (List)((bm)paramq).doh());
    }
    AppMethodBeat.o(291840);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$Companion;", "", "()V", "ENTER_FROM_SIGNATURE", "", "REQUEST_CODE_SELECT_AT_CONTACT", "TAG", "", "getTAG", "()Ljava/lang/String;", "followContactViewType", "followHeaderViewType", "recentAtContactViewType", "recentAtHeaderViewType", "searchViewType", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$ContactViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "authIcon", "Landroid/widget/ImageView;", "getAuthIcon", "()Landroid/widget/ImageView;", "setAuthIcon", "(Landroid/widget/ImageView;)V", "authJob", "Landroid/widget/TextView;", "getAuthJob", "()Landroid/widget/TextView;", "setAuthJob", "(Landroid/widget/TextView;)V", "avatarIv", "getAvatarIv", "setAvatarIv", "nicknameTv", "getNicknameTv", "setNicknameTv", "plugin-finder_release"})
  public final class b
    extends RecyclerView.v
  {
    ImageView Atw;
    TextView Atx;
    ImageView jiu;
    TextView xoK;
    
    public b()
    {
      super();
      AppMethodBeat.i(269632);
      this$1 = localObject.findViewById(b.f.avatar_iv);
      p.j(FinderPostAtUI.this, "itemView.findViewById(R.id.avatar_iv)");
      this.jiu = ((ImageView)FinderPostAtUI.this);
      this$1 = localObject.findViewById(b.f.nickname_tv);
      p.j(FinderPostAtUI.this, "itemView.findViewById(R.id.nickname_tv)");
      this.xoK = ((TextView)FinderPostAtUI.this);
      this$1 = localObject.findViewById(b.f.auth_icon);
      p.j(FinderPostAtUI.this, "itemView.findViewById(R.id.auth_icon)");
      this.Atw = ((ImageView)FinderPostAtUI.this);
      this$1 = localObject.findViewById(b.f.auth_job);
      p.j(FinderPostAtUI.this, "itemView.findViewById(R.id.auth_job)");
      this.Atx = ((TextView)FinderPostAtUI.this);
      AppMethodBeat.o(269632);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class c
    extends RecyclerView.v
  {
    TextView titleTv;
    
    public c()
    {
      super();
      AppMethodBeat.i(276992);
      this$1 = localObject.findViewById(b.f.title_tv);
      p.j(FinderPostAtUI.this, "itemView.findViewById(R.id.title_tv)");
      this.titleTv = ((TextView)FinderPostAtUI.this);
      AppMethodBeat.o(276992);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$SearchViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "plugin-finder_release"})
  public final class d
    extends RecyclerView.v
  {
    public d()
    {
      super();
      AppMethodBeat.i(241597);
      AppMethodBeat.o(241597);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;)V", "hasSearchView", "", "getHasSearchView", "()Z", "setHasSearchView", "(Z)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class e
    extends RecyclerView.a<RecyclerView.v>
  {
    boolean Atz = true;
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(282876);
      p.k(paramViewGroup, "parent");
      switch (paramInt)
      {
      case 3: 
      default: 
        localFinderPostAtUI = this.Aty;
        localAppCompatActivity = this.Aty.getContext();
        if (localAppCompatActivity == null) {
          p.iCn();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(b.g.finder_contact_list_item, paramViewGroup, false);
        p.j(paramViewGroup, "context!!.layoutInflater…list_item, parent, false)");
        paramViewGroup = (RecyclerView.v)new FinderPostAtUI.b(localFinderPostAtUI, paramViewGroup);
        AppMethodBeat.o(282876);
        return paramViewGroup;
      case 1: 
        localFinderPostAtUI = this.Aty;
        localAppCompatActivity = this.Aty.getContext();
        if (localAppCompatActivity == null) {
          p.iCn();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(b.g._feed_header_search_item, paramViewGroup, false);
        p.j(paramViewGroup, "context!!.layoutInflater…arch_item, parent, false)");
        paramViewGroup = (RecyclerView.v)new FinderPostAtUI.d(localFinderPostAtUI, paramViewGroup);
        AppMethodBeat.o(282876);
        return paramViewGroup;
      case 2: 
        localFinderPostAtUI = this.Aty;
        localAppCompatActivity = this.Aty.getContext();
        if (localAppCompatActivity == null) {
          p.iCn();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(b.g.finder_post_at_header_item, paramViewGroup, false);
        p.j(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
        paramViewGroup = (RecyclerView.v)new FinderPostAtUI.c(localFinderPostAtUI, paramViewGroup);
        AppMethodBeat.o(282876);
        return paramViewGroup;
      }
      FinderPostAtUI localFinderPostAtUI = this.Aty;
      AppCompatActivity localAppCompatActivity = this.Aty.getContext();
      if (localAppCompatActivity == null) {
        p.iCn();
      }
      paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(b.g.finder_post_at_header_item, paramViewGroup, false);
      p.j(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
      paramViewGroup = (RecyclerView.v)new FinderPostAtUI.c(localFinderPostAtUI, paramViewGroup);
      AppMethodBeat.o(282876);
      return paramViewGroup;
    }
    
    public final void d(final RecyclerView.v paramv, final int paramInt)
    {
      int i = 2;
      AppMethodBeat.i(282877);
      p.k(paramv, "viewHolder");
      if ((paramv instanceof FinderPostAtUI.b))
      {
        com.tencent.mm.plugin.finder.api.i locali;
        label58:
        Object localObject1;
        Object localObject2;
        if (this.Atz)
        {
          if (FinderPostAtUI.a(this.Aty).size() != 0) {
            break label283;
          }
          locali = (com.tencent.mm.plugin.finder.api.i)FinderPostAtUI.b(this.Aty).get(paramInt - i);
          p.j(locali, "if (recentAtContactList.…      }\n                }");
          localObject1 = com.tencent.mm.plugin.finder.loader.t.ztT;
          localObject1 = com.tencent.mm.plugin.finder.loader.t.dJh();
          localObject2 = new com.tencent.mm.plugin.finder.loader.e(locali.Mm());
          ImageView localImageView = ((FinderPostAtUI.b)paramv).jiu;
          com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
          ((com.tencent.mm.loader.d)localObject1).a(localObject2, localImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
          ((FinderPostAtUI.b)paramv).xoK.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)this.Aty.getContext(), (CharSequence)locali.getNickname()));
          localObject1 = locali.field_authInfo;
          if (localObject1 == null) {
            break label354;
          }
          i = ((FinderAuthInfo)localObject1).authIconType;
          label170:
          ((FinderPostAtUI.b)paramv).Atx.setVisibility(8);
          localObject1 = aj.AGc;
          aj.a(((FinderPostAtUI.b)paramv).Atw, locali.field_authInfo);
          if (i <= 0) {
            break label446;
          }
          switch (i)
          {
          }
        }
        for (;;)
        {
          localObject1 = paramv.amk;
          p.j(localObject1, "viewHolder.itemView");
          ((View)localObject1).setTag(locali);
          paramv.amk.setOnClickListener((View.OnClickListener)new a(this, paramv, paramInt));
          AppMethodBeat.o(282877);
          return;
          i = 1;
          break;
          label283:
          if (paramInt < FinderPostAtUI.a(this.Aty).size() + i)
          {
            locali = (com.tencent.mm.plugin.finder.api.i)FinderPostAtUI.a(this.Aty).get(paramInt - i);
            break label58;
          }
          locali = (com.tencent.mm.plugin.finder.api.i)FinderPostAtUI.b(this.Aty).get(paramInt - FinderPostAtUI.a(this.Aty).size() - i - 1);
          break label58;
          label354:
          i = 0;
          break label170;
          ((FinderPostAtUI.b)paramv).Atx.setVisibility(0);
          localObject2 = ((FinderPostAtUI.b)paramv).Atx;
          localObject1 = locali.field_authInfo;
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
          ((FinderPostAtUI.b)paramv).Atx.setVisibility(8);
          continue;
          label446:
          ((FinderPostAtUI.b)paramv).Atx.setVisibility(8);
        }
      }
      if ((paramv instanceof FinderPostAtUI.d))
      {
        paramv.amk.setOnClickListener((View.OnClickListener)new b(this));
        AppMethodBeat.o(282877);
        return;
      }
      if ((paramv instanceof FinderPostAtUI.c))
      {
        if (getItemViewType(paramInt) == 2)
        {
          ((FinderPostAtUI.c)paramv).titleTv.setText((CharSequence)this.Aty.getString(b.j.finder_post_at_recent_at_contact_header));
          AppMethodBeat.o(282877);
          return;
        }
        ((FinderPostAtUI.c)paramv).titleTv.setText((CharSequence)this.Aty.getString(b.j.finder_post_at_follow_contact_header));
      }
      AppMethodBeat.o(282877);
    }
    
    public final int getItemCount()
    {
      int k = 0;
      AppMethodBeat.i(282875);
      int i;
      int j;
      if (this.Atz)
      {
        i = 1;
        if (FinderPostAtUI.a(this.Aty).size() != 0) {
          break label62;
        }
        j = 0;
        label32:
        if (FinderPostAtUI.b(this.Aty).size() != 0) {
          break label78;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(282875);
        return i + j + k;
        i = 0;
        break;
        label62:
        j = FinderPostAtUI.a(this.Aty).size() + 1;
        break label32;
        label78:
        k = FinderPostAtUI.b(this.Aty).size() + 1;
      }
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(282873);
      int i = paramInt;
      if (!this.Atz) {
        i = paramInt + 1;
      }
      if (i == 0)
      {
        AppMethodBeat.o(282873);
        return 1;
      }
      if (FinderPostAtUI.a(this.Aty).size() > 0)
      {
        if (i == 1)
        {
          AppMethodBeat.o(282873);
          return 2;
        }
        if (i == FinderPostAtUI.a(this.Aty).size() + 2)
        {
          AppMethodBeat.o(282873);
          return 4;
        }
        if (i > FinderPostAtUI.a(this.Aty).size() + 2)
        {
          AppMethodBeat.o(282873);
          return 5;
        }
        AppMethodBeat.o(282873);
        return 3;
      }
      if (i == 1)
      {
        AppMethodBeat.o(282873);
        return 4;
      }
      AppMethodBeat.o(282873);
      return 5;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderPostAtUI.e parame, RecyclerView.v paramv, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(274778);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramView = com.tencent.mm.plugin.finder.utils.e.ACV;
        paramView = paramv.amk;
        p.j(paramView, "viewHolder.itemView");
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.api.LocalFinderContact");
          AppMethodBeat.o(274778);
          throw paramView;
        }
        paramView = com.tencent.mm.plugin.finder.utils.e.i((com.tencent.mm.plugin.finder.api.i)paramView);
        this.AtA.Aty.getIntent().putExtra("key_select_contact", paramView.toByteArray());
        if (this.AtA.getItemViewType(paramInt) == 5) {
          this.AtA.Aty.getIntent().putExtra("key_source", 2);
        }
        for (;;)
        {
          this.AtA.Aty.setResult(-1, this.AtA.Aty.getIntent());
          this.AtA.Aty.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(274778);
          return;
          this.AtA.Aty.getIntent().putExtra("key_source", 1);
        }
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(FinderPostAtUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(280437);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        this.AtA.Aty.getIntent().putExtra("from_at_contact", true);
        this.AtA.Aty.getIntent().putExtra("request_type", 6);
        this.AtA.Aty.getIntent().putExtra("need_history", false);
        paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
        paramView = (MMActivity)this.AtA.Aty;
        localObject = this.AtA.Aty.getIntent();
        p.j(localObject, "intent");
        com.tencent.mm.plugin.finder.utils.a.a(paramView, (Intent)localObject);
        this.AtA.Atz = false;
        this.AtA.cN(0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(280437);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(FinderPostAtUI paramFinderPostAtUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(274773);
      this.Aty.finish();
      AppMethodBeat.o(274773);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(223060);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(223060);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(223063);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(223063);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(223058);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Object localObject = FinderPostAtUI.Atv;
      Log.i(FinderPostAtUI.access$getTAG$cp(), "onLoadMoreBegin");
      if (FinderPostAtUI.e(this.Aty) != null)
      {
        if (!FinderPostAtUI.f(this.Aty)) {
          break label179;
        }
        FinderPostAtUI.g(this.Aty);
        localObject = FinderPostAtUI.h(this.Aty).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setText(b.j.finder_load_more_footer_tip);
          }
        }
        localObject = FinderPostAtUI.h(this.Aty).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
        localObject = FinderPostAtUI.h(this.Aty).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = ((View)localObject).findViewById(b.f.load_more_footer_end_layout);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(223058);
        return;
        label179:
        localObject = FinderPostAtUI.h(this.Aty).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setText(b.j.finder_load_more_no_result_tip);
          }
        }
        localObject = FinderPostAtUI.h(this.Aty).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(8);
          }
        }
        localObject = FinderPostAtUI.h(this.Aty).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = ((View)localObject).findViewById(b.f.load_more_footer_end_layout);
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
        }
      }
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(223062);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(223062);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "o1", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "kotlin.jvm.PlatformType", "o2", "compare"})
  static final class h<T>
    implements Comparator<cse>
  {
    public static final h AtB;
    
    static
    {
      AppMethodBeat.i(286924);
      AtB = new h();
      AppMethodBeat.o(286924);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "it", "Ljava/lang/Void;", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Void, LinkedList<FinderContact>>
  {
    i(FinderPostAtUI paramFinderPostAtUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.b<LinkedList<FinderContact>, Object>
  {
    j(FinderPostAtUI paramFinderPostAtUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(FinderPostAtUI paramFinderPostAtUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(269135);
      Object localObject = FinderPostAtUI.e(this.Aty).getAdapter();
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
        AppMethodBeat.o(269135);
        throw ((Throwable)localObject);
      }
      ((FinderPostAtUI.e)localObject).notifyDataSetChanged();
      AppMethodBeat.o(269135);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$onSceneEnd$1$1"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Void, x>
  {
    l(FinderPostAtUI paramFinderPostAtUI, aa.a parama, com.tencent.mm.an.q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostAtUI
 * JD-Core Version:    0.7.0.1
 */