package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.cgi.cj;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.data.g;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.aa;
import com.tencent.mm.plugin.finder.viewmodel.component.aa.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<+Lcom.tencent.mm.protocal.protobuf.FinderContact;>;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "Lkotlin/collections/ArrayList;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "fromType", "", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "recentAtContactList", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "doGetFollowScene", "", "getLayoutId", "initContentView", "initData", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "firstPage", "dataList", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "Companion", "ContactViewHolder", "HeaderViewHolder", "SearchViewHolder", "SelectAtContactAdapter", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderPostAtUI
  extends MMFinderUI
  implements com.tencent.mm.am.h
{
  public static final a FSK;
  private static final String TAG;
  private RefreshLoadMoreLayout ATx;
  private com.tencent.mm.bx.b AyB;
  private ArrayList<m> BmO;
  private final g EXF;
  private ArrayList<m> FSL;
  private int fromType;
  private boolean hasMore;
  private RecyclerView mkw;
  
  static
  {
    AppMethodBeat.i(347351);
    FSK = new a((byte)0);
    TAG = "Finder.FinderPostAtUI";
    AppMethodBeat.o(347351);
  }
  
  public FinderPostAtUI()
  {
    AppMethodBeat.i(347255);
    this.BmO = new ArrayList();
    this.FSL = new ArrayList();
    aa.a locala = aa.GQm;
    this.EXF = new g(aa.fnH());
    this.hasMore = true;
    AppMethodBeat.o(347255);
  }
  
  private static final int a(djg paramdjg1, djg paramdjg2)
  {
    AppMethodBeat.i(347276);
    int i = Long.compare(paramdjg2.GlB, paramdjg1.GlB);
    AppMethodBeat.o(347276);
    return i;
  }
  
  private static final void a(FinderPostAtUI paramFinderPostAtUI)
  {
    AppMethodBeat.i(347296);
    kotlin.g.b.s.u(paramFinderPostAtUI, "this$0");
    RecyclerView localRecyclerView = paramFinderPostAtUI.mkw;
    paramFinderPostAtUI = localRecyclerView;
    if (localRecyclerView == null)
    {
      kotlin.g.b.s.bIx("recyclerView");
      paramFinderPostAtUI = null;
    }
    paramFinderPostAtUI = paramFinderPostAtUI.getAdapter();
    if (paramFinderPostAtUI == null)
    {
      paramFinderPostAtUI = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
      AppMethodBeat.o(347296);
      throw paramFinderPostAtUI;
    }
    ((e)paramFinderPostAtUI).bZE.notifyChanged();
    AppMethodBeat.o(347296);
  }
  
  private static final boolean a(FinderPostAtUI paramFinderPostAtUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(347285);
    kotlin.g.b.s.u(paramFinderPostAtUI, "this$0");
    paramFinderPostAtUI.finish();
    AppMethodBeat.o(347285);
    return true;
  }
  
  private final void f(boolean paramBoolean, List<? extends FinderContact> paramList)
  {
    AppMethodBeat.i(347270);
    Log.i(TAG, "firstPage " + paramBoolean + ", get follow contact " + paramList.size());
    if (paramBoolean) {
      this.BmO.clear();
    }
    Object localObject1 = this.BmO;
    Object localObject2 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      paramList.add(c.a((FinderContact)((Iterator)localObject2).next()));
    }
    ((ArrayList)localObject1).addAll((Collection)paramList);
    localObject1 = this.mkw;
    paramList = (List<? extends FinderContact>)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("recyclerView");
      paramList = null;
    }
    paramList = paramList.getAdapter();
    if (paramList == null)
    {
      paramList = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
      AppMethodBeat.o(347270);
      throw paramList;
    }
    ((e)paramList).bZE.notifyChanged();
    AppMethodBeat.o(347270);
  }
  
  private final void fbE()
  {
    AppMethodBeat.i(347261);
    cj localcj = new cj(this.AyB);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localcj, 0);
    AppMethodBeat.o(347261);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_post_at_ui;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(347413);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 20000) && (paramIntent != null) && (paramInt2 == -1))
    {
      getIntent().putExtra("key_select_contact", paramIntent.getByteArrayExtra("at_select_contact"));
      boolean bool = paramIntent.getBooleanExtra("is_follow", false);
      paramIntent = getIntent();
      if (!bool) {
        break label98;
      }
    }
    label98:
    for (paramInt1 = 3;; paramInt1 = 4)
    {
      paramIntent.putExtra("key_source", paramInt1);
      setResult(-1, getIntent());
      finish();
      AppMethodBeat.o(347413);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(347388);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(713, (com.tencent.mm.am.h)this);
    this.fromType = getIntent().getIntExtra("KEY_ENTER_SCENE", 0);
    paramBundle = com.tencent.mm.plugin.finder.utils.h.Gga;
    paramBundle = com.tencent.mm.plugin.finder.utils.h.feK();
    if (paramBundle != null)
    {
      Collections.sort((List)paramBundle, FinderPostAtUI..ExternalSyntheticLambda2.INSTANCE);
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        localObject2 = (djg)paramBundle.next();
        com.tencent.mm.plugin.finder.utils.h localh = com.tencent.mm.plugin.finder.utils.h.Gga;
        kotlin.g.b.s.s(localObject2, "contact");
        localObject2 = com.tencent.mm.plugin.finder.utils.h.a((djg)localObject2);
        if (localObject2 != null) {
          this.FSL.add(localObject2);
        }
      }
    }
    com.tencent.mm.ae.d.b(com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.bbX(), (kotlin.g.a.b)new g(this)), (kotlin.g.a.b)new h(this));
    fbE();
    setResult(0, getIntent());
    if (this.fromType == 1)
    {
      setMMTitle(getResources().getString(e.h.finder_post_at_select_at_contact2));
      setBackBtn(new FinderPostAtUI..ExternalSyntheticLambda0(this));
      paramBundle = getContext().findViewById(e.e.rl_layout);
      kotlin.g.b.s.s(paramBundle, "context.findViewById(R.id.rl_layout)");
      this.ATx = ((RefreshLoadMoreLayout)paramBundle);
      localObject2 = this.ATx;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        paramBundle = null;
      }
      this.mkw = paramBundle.getRecyclerView();
      localObject2 = new FinderLinearLayoutManager((Context)this);
      paramBundle = this.mkw;
      if (paramBundle != null) {
        break label427;
      }
      kotlin.g.b.s.bIx("recyclerView");
      paramBundle = null;
      label280:
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)localObject2);
      paramBundle = this.mkw;
      if (paramBundle != null) {
        break label430;
      }
      kotlin.g.b.s.bIx("recyclerView");
      paramBundle = null;
    }
    label427:
    label430:
    for (;;)
    {
      paramBundle.setAdapter((RecyclerView.a)new e());
      localObject2 = this.mkw;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      paramBundle.setHasFixedSize(true);
      localObject2 = this.mkw;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      paramBundle.setItemViewCacheSize(5);
      localObject2 = this.mkw;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      paramBundle = paramBundle.getAdapter();
      if (paramBundle != null) {
        break label433;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
      AppMethodBeat.o(347388);
      throw paramBundle;
      setMMTitle(getResources().getString(e.h.finder_post_at_select_at_contact));
      break;
      break label280;
    }
    label433:
    ((e)paramBundle).bZE.notifyChanged();
    Object localObject2 = this.ATx;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      paramBundle = null;
    }
    paramBundle.setEnablePullDownHeader(false);
    paramBundle = this.ATx;
    if (paramBundle == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      paramBundle = null;
      localObject2 = af.mU((Context)getContext()).inflate(e.f.load_more_footer, null);
      kotlin.g.b.s.s(localObject2, "getInflater(context).inf…t.load_more_footer, null)");
      paramBundle.setLoadMoreFooter((View)localObject2);
      paramBundle = this.ATx;
      if (paramBundle != null) {
        break label556;
      }
      kotlin.g.b.s.bIx("rlLayout");
      paramBundle = localObject1;
    }
    label556:
    for (;;)
    {
      paramBundle.setActionCallback((RefreshLoadMoreLayout.b)new f(this));
      AppMethodBeat.o(347388);
      return;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(347398);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(713, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(347398);
  }
  
  public final void onResume()
  {
    Object localObject2 = null;
    AppMethodBeat.i(347392);
    super.onResume();
    RecyclerView localRecyclerView = this.mkw;
    Object localObject1 = localRecyclerView;
    if (localRecyclerView == null)
    {
      kotlin.g.b.s.bIx("recyclerView");
      localObject1 = null;
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
      AppMethodBeat.o(347392);
      throw ((Throwable)localObject1);
    }
    if (!((e)localObject1).FSP)
    {
      localRecyclerView = this.mkw;
      localObject1 = localRecyclerView;
      if (localRecyclerView == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        localObject1 = null;
      }
      localObject1 = ((RecyclerView)localObject1).getAdapter();
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
        AppMethodBeat.o(347392);
        throw ((Throwable)localObject1);
      }
      ((e)localObject1).FSP = true;
      localObject1 = this.mkw;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        localObject1 = localObject2;
      }
      for (;;)
      {
        localObject1 = ((RecyclerView)localObject1).getAdapter();
        if (localObject1 != null) {
          break;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
        AppMethodBeat.o(347392);
        throw ((Throwable)localObject1);
      }
      ((e)localObject1).fW(0);
      com.tencent.threadpool.h.ahAA.o(new FinderPostAtUI..ExternalSyntheticLambda1(this), 300L);
    }
    AppMethodBeat.o(347392);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.am.p paramp)
  {
    Object localObject = null;
    AppMethodBeat.i(347407);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene type ");
    if (paramp == null)
    {
      paramString = null;
      Log.i(str, paramString);
      if (paramp != null) {
        break label108;
      }
    }
    label108:
    for (paramString = localObject;; paramString = Integer.valueOf(paramp.getType()))
    {
      if (paramString != null) {
        break label120;
      }
      AppMethodBeat.o(347407);
      return;
      paramString = Integer.valueOf(paramp.getType());
      break;
    }
    label120:
    if ((paramString.intValue() == 713) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      boolean bool = false;
      if (paramp == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFollowList");
        AppMethodBeat.o(347407);
        throw paramString;
      }
      paramString = ((cj)paramp).dVL();
      if (!kotlin.g.b.s.p(this.AyB, paramString))
      {
        Log.i(TAG, "not my buf, ignore!");
        AppMethodBeat.o(347407);
        return;
      }
      if (this.AyB == null)
      {
        bool = true;
        com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.bbX(), (kotlin.g.a.b)new i(this, paramp));
      }
      this.hasMore = ((cj)paramp).dVN();
      this.AyB = ((cj)paramp).dVJ();
      f(bool, (List)((cj)paramp).dVR());
    }
    AppMethodBeat.o(347407);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$Companion;", "", "()V", "ENTER_FROM_SIGNATURE", "", "REQUEST_CODE_SELECT_AT_CONTACT", "TAG", "", "getTAG", "()Ljava/lang/String;", "followContactViewType", "followHeaderViewType", "recentAtContactViewType", "recentAtHeaderViewType", "searchViewType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$ContactViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "authIcon", "Landroid/widget/ImageView;", "getAuthIcon", "()Landroid/widget/ImageView;", "setAuthIcon", "(Landroid/widget/ImageView;)V", "authJob", "Landroid/widget/TextView;", "getAuthJob", "()Landroid/widget/TextView;", "setAuthJob", "(Landroid/widget/TextView;)V", "avatarIv", "getAvatarIv", "setAvatarIv", "nicknameTv", "getNicknameTv", "setNicknameTv", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends RecyclerView.v
  {
    ImageView FSM;
    TextView FSN;
    ImageView lKK;
    TextView nicknameTv;
    
    public b()
    {
      super();
      AppMethodBeat.i(347616);
      this$1 = localObject.findViewById(e.e.avatar_iv);
      kotlin.g.b.s.s(FinderPostAtUI.this, "itemView.findViewById(R.id.avatar_iv)");
      this.lKK = ((ImageView)FinderPostAtUI.this);
      this$1 = localObject.findViewById(e.e.nickname_tv);
      kotlin.g.b.s.s(FinderPostAtUI.this, "itemView.findViewById(R.id.nickname_tv)");
      this.nicknameTv = ((TextView)FinderPostAtUI.this);
      this$1 = localObject.findViewById(e.e.auth_icon);
      kotlin.g.b.s.s(FinderPostAtUI.this, "itemView.findViewById(R.id.auth_icon)");
      this.FSM = ((ImageView)FinderPostAtUI.this);
      this$1 = localObject.findViewById(e.e.auth_job);
      kotlin.g.b.s.s(FinderPostAtUI.this, "itemView.findViewById(R.id.auth_job)");
      this.FSN = ((TextView)FinderPostAtUI.this);
      AppMethodBeat.o(347616);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends RecyclerView.v
  {
    TextView titleTv;
    
    public c()
    {
      super();
      AppMethodBeat.i(347608);
      this$1 = localObject.findViewById(e.e.title_tv);
      kotlin.g.b.s.s(FinderPostAtUI.this, "itemView.findViewById(R.id.title_tv)");
      this.titleTv = ((TextView)FinderPostAtUI.this);
      AppMethodBeat.o(347608);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$SearchViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends RecyclerView.v
  {
    public d()
    {
      super();
      AppMethodBeat.i(347623);
      AppMethodBeat.o(347623);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;)V", "hasSearchView", "", "getHasSearchView", "()Z", "setHasSearchView", "(Z)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class e
    extends RecyclerView.a<RecyclerView.v>
  {
    boolean FSP;
    
    public e()
    {
      AppMethodBeat.i(347628);
      this.FSP = true;
      AppMethodBeat.o(347628);
    }
    
    private static final void a(RecyclerView.v paramv, FinderPostAtUI paramFinderPostAtUI, e parame, int paramInt, View paramView)
    {
      AppMethodBeat.i(347641);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramv);
      localb.cH(paramFinderPostAtUI);
      localb.cH(parame);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramv, "$viewHolder");
      kotlin.g.b.s.u(paramFinderPostAtUI, "this$0");
      kotlin.g.b.s.u(parame, "this$1");
      paramView = com.tencent.mm.plugin.finder.utils.h.Gga;
      paramv = paramv.caK.getTag();
      if (paramv == null)
      {
        paramv = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.api.LocalFinderContact");
        AppMethodBeat.o(347641);
        throw paramv;
      }
      paramv = com.tencent.mm.plugin.finder.utils.h.m((m)paramv);
      paramView = paramFinderPostAtUI.getIntent();
      if (paramv == null)
      {
        paramv = null;
        paramView.putExtra("key_select_contact", paramv);
        if (parame.getItemViewType(paramInt) != 5) {
          break label218;
        }
        paramFinderPostAtUI.getIntent().putExtra("key_source", 2);
      }
      for (;;)
      {
        paramFinderPostAtUI.setResult(-1, paramFinderPostAtUI.getIntent());
        paramFinderPostAtUI.finish();
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(347641);
        return;
        paramv = paramv.toByteArray();
        break;
        label218:
        paramFinderPostAtUI.getIntent().putExtra("key_source", 1);
      }
    }
    
    private static final void a(FinderPostAtUI paramFinderPostAtUI, e parame, View paramView)
    {
      AppMethodBeat.i(347653);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramFinderPostAtUI);
      localb.cH(parame);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramFinderPostAtUI, "this$0");
      kotlin.g.b.s.u(parame, "this$1");
      paramFinderPostAtUI.getIntent().putExtra("from_at_contact", true);
      paramFinderPostAtUI.getIntent().putExtra("request_type", 6);
      paramFinderPostAtUI.getIntent().putExtra("need_history", false);
      paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramView = (MMActivity)paramFinderPostAtUI;
      paramFinderPostAtUI = paramFinderPostAtUI.getIntent();
      kotlin.g.b.s.s(paramFinderPostAtUI, "intent");
      com.tencent.mm.plugin.finder.utils.a.a(paramView, paramFinderPostAtUI);
      parame.FSP = false;
      parame.fX(0);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(347653);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(347710);
      kotlin.g.b.s.u(paramViewGroup, "parent");
      switch (paramInt)
      {
      case 3: 
      default: 
        localFinderPostAtUI = this.FSO;
        localAppCompatActivity = this.FSO.getContext();
        kotlin.g.b.s.checkNotNull(localAppCompatActivity);
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(e.f.finder_contact_list_item, paramViewGroup, false);
        kotlin.g.b.s.s(paramViewGroup, "context!!.layoutInflater…list_item, parent, false)");
        paramViewGroup = (RecyclerView.v)new FinderPostAtUI.b(localFinderPostAtUI, paramViewGroup);
        AppMethodBeat.o(347710);
        return paramViewGroup;
      case 1: 
        localFinderPostAtUI = this.FSO;
        localAppCompatActivity = this.FSO.getContext();
        kotlin.g.b.s.checkNotNull(localAppCompatActivity);
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(e.f._feed_header_search_item, paramViewGroup, false);
        kotlin.g.b.s.s(paramViewGroup, "context!!.layoutInflater…arch_item, parent, false)");
        paramViewGroup = (RecyclerView.v)new FinderPostAtUI.d(localFinderPostAtUI, paramViewGroup);
        AppMethodBeat.o(347710);
        return paramViewGroup;
      case 2: 
        localFinderPostAtUI = this.FSO;
        localAppCompatActivity = this.FSO.getContext();
        kotlin.g.b.s.checkNotNull(localAppCompatActivity);
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(e.f.finder_post_at_header_item, paramViewGroup, false);
        kotlin.g.b.s.s(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
        paramViewGroup = (RecyclerView.v)new FinderPostAtUI.c(localFinderPostAtUI, paramViewGroup);
        AppMethodBeat.o(347710);
        return paramViewGroup;
      }
      FinderPostAtUI localFinderPostAtUI = this.FSO;
      AppCompatActivity localAppCompatActivity = this.FSO.getContext();
      kotlin.g.b.s.checkNotNull(localAppCompatActivity);
      paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(e.f.finder_post_at_header_item, paramViewGroup, false);
      kotlin.g.b.s.s(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
      paramViewGroup = (RecyclerView.v)new FinderPostAtUI.c(localFinderPostAtUI, paramViewGroup);
      AppMethodBeat.o(347710);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      int i = 2;
      AppMethodBeat.i(347734);
      kotlin.g.b.s.u(paramv, "viewHolder");
      if ((paramv instanceof FinderPostAtUI.b))
      {
        m localm;
        label60:
        Object localObject1;
        Object localObject2;
        if (this.FSP)
        {
          if (FinderPostAtUI.i(this.FSO).size() != 0) {
            break label282;
          }
          localm = (m)FinderPostAtUI.d(this.FSO).get(paramInt - i);
          kotlin.g.b.s.s(localm, "if (recentAtContactList.…      }\n                }");
          localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
          localObject1 = com.tencent.mm.plugin.finder.loader.p.eCp();
          localObject2 = new com.tencent.mm.plugin.finder.loader.b(localm.amx());
          ImageView localImageView = ((FinderPostAtUI.b)paramv).lKK;
          com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((com.tencent.mm.loader.d)localObject1).a(localObject2, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
          ((FinderPostAtUI.b)paramv).nicknameTv.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)this.FSO.getContext(), (CharSequence)localm.getNickname()));
          localObject1 = localm.field_authInfo;
          if (localObject1 != null) {
            break label353;
          }
          i = 0;
          label169:
          ((FinderPostAtUI.b)paramv).FSN.setVisibility(8);
          localObject1 = av.GiL;
          av.a(((FinderPostAtUI.b)paramv).FSM, localm.field_authInfo, 0, c.a(localm, false), 4);
          if (i <= 0) {
            break label460;
          }
          switch (i)
          {
          }
        }
        for (;;)
        {
          paramv.caK.setTag(localm);
          paramv.caK.setOnClickListener(new FinderPostAtUI.e..ExternalSyntheticLambda0(paramv, this.FSO, this, paramInt));
          AppMethodBeat.o(347734);
          return;
          i = 1;
          break;
          label282:
          if (paramInt < FinderPostAtUI.i(this.FSO).size() + i)
          {
            localm = (m)FinderPostAtUI.i(this.FSO).get(paramInt - i);
            break label60;
          }
          localm = (m)FinderPostAtUI.d(this.FSO).get(paramInt - FinderPostAtUI.i(this.FSO).size() - i - 1);
          break label60;
          label353:
          i = ((FinderAuthInfo)localObject1).authIconType;
          break label169;
          ((FinderPostAtUI.b)paramv).FSN.setVisibility(0);
          localObject2 = ((FinderPostAtUI.b)paramv).FSN;
          localObject1 = localm.field_authInfo;
          if (localObject1 == null) {
            localObject1 = (CharSequence)"";
          }
          for (;;)
          {
            ((TextView)localObject2).setText((CharSequence)localObject1);
            break;
            localObject1 = ((FinderAuthInfo)localObject1).authProfession;
            if (localObject1 == null) {
              localObject1 = (CharSequence)"";
            } else {
              localObject1 = (CharSequence)localObject1;
            }
          }
          ((FinderPostAtUI.b)paramv).FSN.setVisibility(8);
          continue;
          label460:
          ((FinderPostAtUI.b)paramv).FSN.setVisibility(8);
        }
      }
      if ((paramv instanceof FinderPostAtUI.d))
      {
        paramv.caK.setOnClickListener(new FinderPostAtUI.e..ExternalSyntheticLambda1(this.FSO, this));
        AppMethodBeat.o(347734);
        return;
      }
      if ((paramv instanceof FinderPostAtUI.c))
      {
        if (getItemViewType(paramInt) == 2)
        {
          ((FinderPostAtUI.c)paramv).titleTv.setText((CharSequence)this.FSO.getString(e.h.finder_post_at_recent_at_contact_header));
          AppMethodBeat.o(347734);
          return;
        }
        ((FinderPostAtUI.c)paramv).titleTv.setText((CharSequence)this.FSO.getString(e.h.finder_post_at_follow_contact_header));
      }
      AppMethodBeat.o(347734);
    }
    
    public final int getItemCount()
    {
      int k = 0;
      AppMethodBeat.i(347694);
      int i;
      int j;
      if (this.FSP)
      {
        i = 1;
        if (FinderPostAtUI.i(this.FSO).size() != 0) {
          break label62;
        }
        j = 0;
        label32:
        if (FinderPostAtUI.d(this.FSO).size() != 0) {
          break label78;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(347694);
        return i + j + k;
        i = 0;
        break;
        label62:
        j = FinderPostAtUI.i(this.FSO).size() + 1;
        break label32;
        label78:
        k = FinderPostAtUI.d(this.FSO).size() + 1;
      }
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(347683);
      int i = paramInt;
      if (!this.FSP) {
        i = paramInt + 1;
      }
      if (i == 0)
      {
        AppMethodBeat.o(347683);
        return 1;
      }
      if (FinderPostAtUI.i(this.FSO).size() > 0)
      {
        if (i == 1)
        {
          AppMethodBeat.o(347683);
          return 2;
        }
        if (i == FinderPostAtUI.i(this.FSO).size() + 2)
        {
          AppMethodBeat.o(347683);
          return 4;
        }
        if (i > FinderPostAtUI.i(this.FSO).size() + 2)
        {
          AppMethodBeat.o(347683);
          return 5;
        }
        AppMethodBeat.o(347683);
        return 3;
      }
      if (i == 1)
      {
        AppMethodBeat.o(347683);
        return 4;
      }
      AppMethodBeat.o(347683);
      return 5;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends RefreshLoadMoreLayout.b
  {
    f(FinderPostAtUI paramFinderPostAtUI) {}
    
    public final void qI(int paramInt)
    {
      RefreshLoadMoreLayout localRefreshLoadMoreLayout2 = null;
      RefreshLoadMoreLayout localRefreshLoadMoreLayout1 = null;
      AppMethodBeat.i(347635);
      Object localObject = FinderPostAtUI.FSK;
      Log.i(FinderPostAtUI.access$getTAG$cp(), "onLoadMoreBegin");
      if (FinderPostAtUI.e(this.FSO) == null) {
        kotlin.g.b.s.bIx("recyclerView");
      }
      FinderPostAtUI localFinderPostAtUI = this.FSO;
      if (FinderPostAtUI.f(localFinderPostAtUI))
      {
        FinderPostAtUI.g(localFinderPostAtUI);
        localRefreshLoadMoreLayout2 = FinderPostAtUI.h(localFinderPostAtUI);
        localObject = localRefreshLoadMoreLayout2;
        if (localRefreshLoadMoreLayout2 == null)
        {
          kotlin.g.b.s.bIx("rlLayout");
          localObject = null;
        }
        localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(e.e.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setText(e.h.finder_load_more_footer_tip);
          }
        }
        localRefreshLoadMoreLayout2 = FinderPostAtUI.h(localFinderPostAtUI);
        localObject = localRefreshLoadMoreLayout2;
        if (localRefreshLoadMoreLayout2 == null)
        {
          kotlin.g.b.s.bIx("rlLayout");
          localObject = null;
        }
        localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
        if (localObject == null)
        {
          localObject = null;
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
          localRefreshLoadMoreLayout2 = FinderPostAtUI.h(localFinderPostAtUI);
          localObject = localRefreshLoadMoreLayout2;
          if (localRefreshLoadMoreLayout2 == null)
          {
            kotlin.g.b.s.bIx("rlLayout");
            localObject = null;
          }
          localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
          if (localObject != null) {
            break label214;
          }
        }
        label214:
        for (localObject = localRefreshLoadMoreLayout1;; localObject = ((View)localObject).findViewById(e.e.load_more_footer_end_layout))
        {
          if (localObject == null) {
            break label355;
          }
          ((View)localObject).setVisibility(8);
          AppMethodBeat.o(347635);
          return;
          localObject = (TextView)((View)localObject).findViewById(e.e.load_more_footer_tip_tv);
          break;
        }
      }
      localRefreshLoadMoreLayout1 = FinderPostAtUI.h(localFinderPostAtUI);
      localObject = localRefreshLoadMoreLayout1;
      if (localRefreshLoadMoreLayout1 == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        localObject = null;
      }
      localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
      if (localObject != null)
      {
        localObject = (TextView)((View)localObject).findViewById(e.e.load_more_footer_tip_tv);
        if (localObject != null) {
          ((TextView)localObject).setText(e.h.finder_load_more_no_result_tip);
        }
      }
      localRefreshLoadMoreLayout1 = FinderPostAtUI.h(localFinderPostAtUI);
      localObject = localRefreshLoadMoreLayout1;
      if (localRefreshLoadMoreLayout1 == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        localObject = null;
      }
      localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
      if (localObject == null)
      {
        localObject = null;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(8);
        }
        localRefreshLoadMoreLayout1 = FinderPostAtUI.h(localFinderPostAtUI);
        localObject = localRefreshLoadMoreLayout1;
        if (localRefreshLoadMoreLayout1 == null)
        {
          kotlin.g.b.s.bIx("rlLayout");
          localObject = null;
        }
        localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
        if (localObject != null) {
          break label375;
        }
      }
      label355:
      label375:
      for (localObject = localRefreshLoadMoreLayout2;; localObject = ((View)localObject).findViewById(e.e.load_more_footer_end_layout))
      {
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        AppMethodBeat.o(347635);
        return;
        localObject = (TextView)((View)localObject).findViewById(e.e.load_more_footer_tip_tv);
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "it", "Ljava/lang/Void;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<Void, LinkedList<FinderContact>>
  {
    g(FinderPostAtUI paramFinderPostAtUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.b<LinkedList<FinderContact>, Object>
  {
    h(FinderPostAtUI paramFinderPostAtUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/Void;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.b<Void, ah>
  {
    i(FinderPostAtUI paramFinderPostAtUI, com.tencent.mm.am.p paramp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostAtUI
 * JD-Core Version:    0.7.0.1
 */