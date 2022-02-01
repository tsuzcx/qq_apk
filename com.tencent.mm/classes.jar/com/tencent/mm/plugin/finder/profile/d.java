package com.tencent.mm.plugin.finder.profile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.search.k;
import com.tencent.mm.protocal.protobuf.bsg;
import com.tencent.mm.protocal.protobuf.eee;
import com.tencent.mm.protocal.protobuf.eel;
import com.tencent.mm.protocal.protobuf.fes;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView;
import com.tencent.mm.ui.search.FTSSearchView.c;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiListView;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapter", "Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiListView$PoiListAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiListView$PoiListAdapter;", "setAdapter", "(Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiListView$PoiListAdapter;)V", "header", "Landroid/view/View;", "getHeader", "()Landroid/view/View;", "setHeader", "(Landroid/view/View;)V", "lastQueryTime", "", "getLastQueryTime", "()J", "setLastQueryTime", "(J)V", "onItemClick", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/PoiBrief;", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "outTopView", "getOutTopView", "setOutTopView", "poiHandler", "Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiHandler;", "getPoiHandler", "()Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiHandler;", "setPoiHandler", "(Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiHandler;)V", "poiList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderPoiInfo;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "getSearchView", "()Lcom/tencent/mm/ui/search/FTSSearchView;", "setSearchView", "(Lcom/tencent/mm/ui/search/FTSSearchView;)V", "showSearch", "", "getShowSearch", "()Z", "setShowSearch", "(Z)V", "tempList", "userName", "", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "visibilityListener", "getVisibilityListener", "setVisibilityListener", "clearSearch", "clearSearchText", "doQuery", "getRefreshLayout", "hideVKB", "initPoiList", "list", "", "initSearch", "num", "", "notify", "updateHeight", "onClickClearTextBtn", "view", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onLoadMoreBegin", "onLoadMoreEnd", "onLoadSearch", "queryTime", "onSearchKeyDown", "onTagClick", "index", "tag", "setPoiNum", "setView", "refreshLayout", "Companion", "PoiItemViewHolder", "PoiListAdapter", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements FTSEditTextView.c
{
  public static final a Faq;
  public RefreshLoadMoreLayout ATx;
  MMProcessBar BaP;
  FTSSearchView Bny;
  View Fag;
  final LinkedList<bsg> Far;
  final LinkedList<bsg> Fas;
  public c Fat;
  kotlin.g.a.b<? super eee, ah> Fau;
  private kotlin.g.a.b<? super Boolean, ah> Fav;
  c Faw;
  long Fax;
  Context context;
  public RecyclerView mkw;
  String userName;
  
  static
  {
    AppMethodBeat.i(348268);
    Faq = new a((byte)0);
    AppMethodBeat.o(348268);
  }
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(348219);
    this.context = paramContext;
    this.Far = new LinkedList();
    this.Fas = new LinkedList();
    AppMethodBeat.o(348219);
  }
  
  private static final void a(LinearLayout paramLinearLayout, d paramd, View paramView)
  {
    AppMethodBeat.i(348247);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramLinearLayout);
    localb.cH(paramd);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/profile/FinderProfilePoiListView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramLinearLayout.setVisibility(8);
    paramLinearLayout = paramd.Bny;
    if (paramLinearLayout != null) {
      paramLinearLayout.setVisibility(0);
    }
    paramLinearLayout = paramd.Bny;
    if (paramLinearLayout != null)
    {
      paramLinearLayout = paramLinearLayout.getFtsEditText();
      if (paramLinearLayout != null) {
        paramLinearLayout.aWT();
      }
    }
    paramLinearLayout = paramd.Bny;
    if (paramLinearLayout != null)
    {
      paramLinearLayout = paramLinearLayout.getFtsEditText();
      if (paramLinearLayout != null) {
        paramLinearLayout.aWS();
      }
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/profile/FinderProfilePoiListView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(348247);
  }
  
  private final void eIA()
  {
    c localc = null;
    AppMethodBeat.i(348238);
    Object localObject1 = this.Bny;
    if (localObject1 == null) {
      localObject1 = localc;
    }
    for (;;)
    {
      localObject1 = String.valueOf(localObject1);
      localc = this.Faw;
      if (localc != null) {
        localc.l((String)localObject1, this.userName, System.currentTimeMillis());
      }
      AppMethodBeat.o(348238);
      return;
      Object localObject2 = ((FTSSearchView)localObject1).getFtsEditText();
      localObject1 = localc;
      if (localObject2 != null)
      {
        localObject2 = ((FTSEditTextView)localObject2).getEditText();
        localObject1 = localc;
        if (localObject2 != null) {
          localObject1 = ((EditText)localObject2).getText();
        }
      }
    }
  }
  
  public final void RD(int paramInt)
  {
    AppMethodBeat.i(348328);
    Object localObject = this.Fag;
    TextView localTextView;
    if (localObject != null)
    {
      localTextView = (TextView)((View)localObject).findViewById(e.e.drawer_header_tv);
      if (localTextView != null)
      {
        aw.a((Paint)localTextView.getPaint(), 0.8F);
        localObject = localTextView.getContext().getResources();
        if (localObject != null) {
          break label72;
        }
      }
    }
    label72:
    for (localObject = null;; localObject = ((Resources)localObject).getString(e.h.finder_poi_profile_poi_list_header_location, new Object[] { Integer.valueOf(paramInt) }))
    {
      localTextView.setText((CharSequence)localObject);
      AppMethodBeat.o(348328);
      return;
    }
  }
  
  public final void RE(int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = null;
    AppMethodBeat.i(348351);
    Object localObject1;
    if (paramInt >= 20)
    {
      localObject1 = this.Fag;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = this.Fag;
        if (localObject2 != null) {
          break label92;
        }
        localObject2 = null;
        label37:
        if (!(localObject2 instanceof LinearLayout.LayoutParams)) {
          break label128;
        }
        localObject2 = this.Fag;
        if (localObject2 != null) {
          break label100;
        }
      }
      label92:
      label100:
      for (localObject2 = null;; localObject2 = ((View)localObject2).getLayoutParams())
      {
        if (localObject2 != null) {
          break label108;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(348351);
        throw ((Throwable)localObject1);
        localObject1 = (LinearLayout)((View)localObject1).findViewById(e.e.drawer_top_search_layout);
        break;
        localObject2 = ((View)localObject2).getLayoutParams();
        break label37;
      }
      label108:
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = this.context.getResources().getDimensionPixelSize(e.c.Edge_1_5_A);
      label128:
      localObject2 = this.Fag;
      if (localObject2 != null) {
        break label335;
      }
    }
    label335:
    for (Object localObject2 = localLayoutParams;; localObject2 = (FTSSearchView)((View)localObject2).findViewById(e.e.drawer_header_search))
    {
      this.Bny = ((FTSSearchView)localObject2);
      localObject2 = this.Bny;
      if (localObject2 != null)
      {
        paramInt = e.d.finder_profile_poi_header_search_bg;
        ((FTSSearchView)localObject2).CxW.setVisibility(8);
        ((FTSSearchView)localObject2).afCs = ((TextView)((FTSSearchView)localObject2).findViewById(a.g.hot_search_hint_text));
        ((FTSSearchView)localObject2).afCo.setBackgroundResource(paramInt);
        ((FTSSearchView)localObject2).afCo.getLayoutParams().height = ((FTSSearchView)localObject2).getResources().getDimensionPixelSize(a.e.Edge_4_5_A);
        ((FTSSearchView)localObject2).Mhl.jBL();
        localLayoutParams = (LinearLayout.LayoutParams)((FTSSearchView)localObject2).Mhl.getLayoutParams();
        localLayoutParams.width = -2;
        localLayoutParams.setMarginEnd((int)((FTSSearchView)localObject2).getResources().getDimension(a.e.Edge_0_5_A));
        ((FTSSearchView)localObject2).Mhl.setLayoutParams(localLayoutParams);
      }
      localObject2 = this.Bny;
      if (localObject2 != null)
      {
        localObject2 = ((FTSSearchView)localObject2).getFtsEditText();
        if (localObject2 != null) {
          ((FTSEditTextView)localObject2).setFtsEditTextListener((FTSEditTextView.c)this);
        }
      }
      if (localObject1 != null) {
        ((LinearLayout)localObject1).setVisibility(0);
      }
      if (localObject1 != null) {
        ((LinearLayout)localObject1).setOnClickListener(new d..ExternalSyntheticLambda0((LinearLayout)localObject1, this));
      }
      this.Fav = ((kotlin.g.a.b)new d((LinearLayout)localObject1, this));
      AppMethodBeat.o(348351);
      return;
    }
  }
  
  public final boolean aWU()
  {
    AppMethodBeat.i(348388);
    eIA();
    Object localObject = this.Bny;
    if (localObject != null)
    {
      localObject = ((FTSSearchView)localObject).getFtsEditText();
      if (localObject != null) {
        ((FTSEditTextView)localObject).hideVKB();
      }
    }
    AppMethodBeat.o(348388);
    return true;
  }
  
  public final c eIy()
  {
    AppMethodBeat.i(348309);
    c localc = this.Fat;
    if (localc != null)
    {
      AppMethodBeat.o(348309);
      return localc;
    }
    s.bIx("adapter");
    AppMethodBeat.o(348309);
    return null;
  }
  
  public final void eIz()
  {
    AppMethodBeat.i(348313);
    this.Fax = System.currentTimeMillis();
    Log.i("Finder.FinderProfilePoiListView", s.X("[clearSearch] lastQueryTime=", Long.valueOf(this.Fax)));
    this.Far.clear();
    this.Far.addAll((Collection)this.Fas);
    hp((List)this.Far);
    AppMethodBeat.o(348313);
  }
  
  public final void eeU() {}
  
  public final void fq(boolean paramBoolean) {}
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(348297);
    RecyclerView localRecyclerView = this.mkw;
    if (localRecyclerView != null)
    {
      AppMethodBeat.o(348297);
      return localRecyclerView;
    }
    s.bIx("recyclerView");
    AppMethodBeat.o(348297);
    return null;
  }
  
  public final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(348291);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.ATx;
    if (localRefreshLoadMoreLayout != null)
    {
      AppMethodBeat.o(348291);
      return localRefreshLoadMoreLayout;
    }
    s.bIx("rlLayout");
    AppMethodBeat.o(348291);
    return null;
  }
  
  public final void hp(List<? extends bsg> paramList)
  {
    AppMethodBeat.i(348336);
    s.u(paramList, "list");
    RD(paramList.size());
    eIy().bZE.notifyChanged();
    AppMethodBeat.o(348336);
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(348382);
    eIz();
    AppMethodBeat.o(348382);
  }
  
  public final void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    AppMethodBeat.i(348361);
    paramString1 = (CharSequence)paramString1;
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      eIz();
      AppMethodBeat.o(348361);
      return;
    }
    eIA();
    AppMethodBeat.o(348361);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiListView$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiListView$PoiItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "divider", "getDivider", "()Landroid/view/View;", "poiAddress", "Landroid/widget/TextView;", "getPoiAddress", "()Landroid/widget/TextView;", "poiDistance", "getPoiDistance", "poiName", "getPoiName", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    extends RecyclerView.v
  {
    final TextView FaA;
    final TextView Fay;
    final TextView Faz;
    final View pKl;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(348263);
      View localView = paramView.findViewById(e.e.poi_name);
      s.s(localView, "itemView.findViewById(R.id.poi_name)");
      this.Fay = ((TextView)localView);
      localView = paramView.findViewById(e.e.poi_distance);
      s.s(localView, "itemView.findViewById(R.id.poi_distance)");
      this.Faz = ((TextView)localView);
      localView = paramView.findViewById(e.e.divider);
      s.s(localView, "itemView.findViewById(R.id.divider)");
      this.pKl = localView;
      paramView = paramView.findViewById(e.e.poi_address);
      s.s(paramView, "itemView.findViewById(R.id.poi_address)");
      this.FaA = ((TextView)paramView);
      AppMethodBeat.o(348263);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiListView$PoiListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiListView;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends RecyclerView.a<RecyclerView.v>
  {
    public c()
    {
      AppMethodBeat.i(348285);
      AppMethodBeat.o(348285);
    }
    
    private static final void a(d paramd, eee parameee, View paramView)
    {
      AppMethodBeat.i(348295);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramd);
      localb.cH(parameee);
      localb.cH(paramView);
      a.c("com/tencent/mm/plugin/finder/profile/FinderProfilePoiListView$PoiListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramd, "this$0");
      s.u(parameee, "$brief");
      paramd = paramd.Fau;
      if (paramd != null) {
        paramd.invoke(parameee);
      }
      a.a(new Object(), "com/tencent/mm/plugin/finder/profile/FinderProfilePoiListView$PoiListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(348295);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(348315);
      s.u(paramViewGroup, "parent");
      paramViewGroup = af.mU(d.a(this.FaB)).inflate(e.f.finder_profile_header_poi_list_item, paramViewGroup, false);
      s.s(paramViewGroup, "getInflater(context).inf…list_item, parent, false)");
      paramViewGroup = (RecyclerView.v)new d.b(paramViewGroup);
      AppMethodBeat.o(348315);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(348345);
      s.u(paramv, "holder");
      if (!(paramv instanceof d.b))
      {
        AppMethodBeat.o(348345);
        return;
      }
      Object localObject = d.b(this.FaB).get(paramInt);
      s.s(localObject, "poiList[position]");
      bsg localbsg = (bsg)localObject;
      localObject = localbsg.aaae;
      if (localObject == null) {
        localObject = null;
      }
      eee localeee;
      for (;;)
      {
        if (localObject == null)
        {
          ((d.b)paramv).Fay.setVisibility(8);
          ((d.b)paramv).Faz.setVisibility(8);
          ((d.b)paramv).FaA.setVisibility(8);
          ((d.b)paramv).pKl.setVisibility(8);
        }
        AppMethodBeat.o(348345);
        return;
        localObject = ((fes)localObject).abEh;
        if (localObject == null)
        {
          localObject = null;
        }
        else
        {
          localeee = ((eel)localObject).abjy;
          if (localeee != null) {
            break;
          }
          localObject = null;
        }
      }
      d locald = this.FaB;
      localObject = (CharSequence)localbsg.aaaf;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0))
      {
        paramInt = 1;
        label178:
        if (paramInt == 0) {
          break label340;
        }
        ((d.b)paramv).Fay.setText((CharSequence)localeee.IGU);
        label200:
        localObject = (CharSequence)localbsg.aaag;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label396;
        }
        paramInt = 1;
        label224:
        if (paramInt == 0) {
          break label401;
        }
        ((d.b)paramv).FaA.setText((CharSequence)localeee.abjg);
        label246:
        ((d.b)paramv).Faz.setText((CharSequence)localeee.abji);
        localObject = ((d.b)paramv).pKl;
        if ((!Util.isNullOrNil(localeee.abji)) && (!Util.isNullOrNil(((d.b)paramv).FaA.getText().toString()))) {
          break label457;
        }
      }
      label396:
      label401:
      label457:
      for (paramInt = 8;; paramInt = 0)
      {
        ((View)localObject).setVisibility(paramInt);
        paramv.caK.setOnClickListener(new d.c..ExternalSyntheticLambda0(locald, localeee));
        localObject = ah.aiuX;
        break;
        paramInt = 0;
        break label178;
        label340:
        TextView localTextView = ((d.b)paramv).Fay;
        localObject = k.FxZ;
        String str = localbsg.aaaf;
        localObject = str;
        if (str == null) {
          localObject = localeee.IGU;
        }
        s.s(localObject, "finderPoiInfo.highlight_name ?: brief.Name");
        localTextView.setText((CharSequence)k.aAh((String)localObject));
        break label200;
        paramInt = 0;
        break label224;
        localTextView = ((d.b)paramv).FaA;
        localObject = k.FxZ;
        str = localbsg.aaaf;
        localObject = str;
        if (str == null) {
          localObject = localeee.abjg;
        }
        s.s(localObject, "finderPoiInfo.highlight_name ?: brief.FullAddress");
        localTextView.setText((CharSequence)k.aAh((String)localObject));
        break label246;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(348325);
      int i = d.b(this.FaB).size();
      AppMethodBeat.o(348325);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    d(LinearLayout paramLinearLayout, d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.d
 * JD-Core Version:    0.7.0.1
 */