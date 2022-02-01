package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.plugin.finder.convert.cy;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.flow.FlowLayoutManager;
import com.tencent.mm.plugin.finder.feed.model.n;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.upload.action.e;
import com.tencent.mm.plugin.finder.upload.action.o;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.tp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlin.k;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderWordingLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currMode", "Lcom/tencent/mm/plugin/finder/view/FinderWordingLayout$Mode;", "getCurrMode", "()Lcom/tencent/mm/plugin/finder/view/FinderWordingLayout$Mode;", "setCurrMode", "(Lcom/tencent/mm/plugin/finder/view/FinderWordingLayout$Mode;)V", "data", "Lcom/tencent/mm/protocal/protobuf/BuzzwordInfo;", "getData", "()Lcom/tencent/mm/protocal/protobuf/BuzzwordInfo;", "setData", "(Lcom/tencent/mm/protocal/protobuf/BuzzwordInfo;)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderWordingItem;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "itemRemoveListener", "Lkotlin/Function1;", "", "getItemRemoveListener", "()Lkotlin/jvm/functions/Function1;", "setItemRemoveListener", "(Lkotlin/jvm/functions/Function1;)V", "manageBtn", "Landroid/view/View;", "getManageBtn", "()Landroid/view/View;", "manageBtn$delegate", "Lkotlin/Lazy;", "manageBtnText", "Landroid/widget/TextView;", "getManageBtnText", "()Landroid/widget/TextView;", "manageBtnText$delegate", "onModeChangeListener", "Lkotlin/Function2;", "getOnModeChangeListener", "()Lkotlin/jvm/functions/Function2;", "setOnModeChangeListener", "(Lkotlin/jvm/functions/Function2;)V", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "recyclerView$delegate", "selfFlag", "", "getSelfFlag", "()Z", "setSelfFlag", "(Z)V", "sizeChangeListener", "Lkotlin/Function0;", "getSizeChangeListener", "()Lkotlin/jvm/functions/Function0;", "setSizeChangeListener", "(Lkotlin/jvm/functions/Function0;)V", "titleTv", "getTitleTv", "titleTv$delegate", "bindData", "item", "buzzword", "itemClickListener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "changeWordingData", "feedId", "", "buzzwordId", "likeOp", "checkSelf", "createRemoveItemMenu", "removeItem", "deleteWordingItem", "disableClick", "manageMode", "normalMode", "cancelManage", "notifyDataSetChanged", "onModeChange", "fromMode", "toMode", "refreshWordingItem", "setItemClickListener", "listener", "setWordingList", "list", "", "updateItem", "Companion", "Mode", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderWordingLayout
  extends FrameLayout
{
  public static final a GDO;
  public BaseFinderFeed AUZ;
  public boolean AXX;
  private final kotlin.j CNQ;
  private final kotlin.j GDP;
  private final kotlin.j GDQ;
  private kotlin.g.a.a<ah> GDR;
  private m<? super b, ? super b, ah> GDS;
  private kotlin.g.a.b<? super n, ah> GDT;
  private b GDU;
  public tp GDV;
  public final ArrayList<n> pUj;
  private final kotlin.j vOl;
  
  static
  {
    AppMethodBeat.i(345892);
    GDO = new a((byte)0);
    AppMethodBeat.o(345892);
  }
  
  public FinderWordingLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(345746);
    this.CNQ = k.cm((kotlin.g.a.a)new g(this));
    this.GDP = k.cm((kotlin.g.a.a)new e(this));
    this.GDQ = k.cm((kotlin.g.a.a)new f(this));
    this.vOl = k.cm((kotlin.g.a.a)new i(this));
    this.pUj = new ArrayList();
    this.GDU = b.GDW;
    LayoutInflater.from(getContext()).inflate(e.f.finder_wording_view, (ViewGroup)this, true);
    paramContext = getRecyclerView();
    paramAttributeSet = new FlowLayoutManager();
    paramAttributeSet.BcM = new FinderWordingLayout..ExternalSyntheticLambda1(this);
    paramAttributeSet.BcN = new FinderWordingLayout..ExternalSyntheticLambda2(this);
    ah localah = ah.aiuX;
    paramContext.setLayoutManager((RecyclerView.LayoutManager)paramAttributeSet);
    paramContext = new WxRecyclerAdapter(dUK(), this.pUj, false);
    getRecyclerView().setAdapter((RecyclerView.a)paramContext);
    int i = getResources().getDimensionPixelOffset(e.c.Edge_A);
    getRecyclerView().a((RecyclerView.h)new com.tencent.mm.plugin.finder.feed.flow.f(i, i));
    getManageBtn().setOnClickListener(new FinderWordingLayout..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(345746);
  }
  
  public FinderWordingLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(345756);
    this.CNQ = k.cm((kotlin.g.a.a)new g(this));
    this.GDP = k.cm((kotlin.g.a.a)new e(this));
    this.GDQ = k.cm((kotlin.g.a.a)new f(this));
    this.vOl = k.cm((kotlin.g.a.a)new i(this));
    this.pUj = new ArrayList();
    this.GDU = b.GDW;
    LayoutInflater.from(getContext()).inflate(e.f.finder_wording_view, (ViewGroup)this, true);
    paramContext = getRecyclerView();
    paramAttributeSet = new FlowLayoutManager();
    paramAttributeSet.BcM = new FinderWordingLayout..ExternalSyntheticLambda1(this);
    paramAttributeSet.BcN = new FinderWordingLayout..ExternalSyntheticLambda2(this);
    ah localah = ah.aiuX;
    paramContext.setLayoutManager((RecyclerView.LayoutManager)paramAttributeSet);
    paramContext = new WxRecyclerAdapter(dUK(), this.pUj, false);
    getRecyclerView().setAdapter((RecyclerView.a)paramContext);
    paramInt = getResources().getDimensionPixelOffset(e.c.Edge_A);
    getRecyclerView().a((RecyclerView.h)new com.tencent.mm.plugin.finder.feed.flow.f(paramInt, paramInt));
    getManageBtn().setOnClickListener(new FinderWordingLayout..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(345756);
  }
  
  private static final int a(FinderWordingLayout paramFinderWordingLayout, View paramView, int paramInt)
  {
    AppMethodBeat.i(345825);
    kotlin.g.b.s.u(paramFinderWordingLayout, "this$0");
    paramView = (TextView)paramView.findViewById(e.e.finder_wording_count);
    if (paramView == null)
    {
      AppMethodBeat.o(345825);
      return 0;
    }
    if ((paramView.getVisibility() == 0) || (paramView.getVisibility() == 4))
    {
      AppMethodBeat.o(345825);
      return 0;
    }
    paramInt = (int)paramView.getPaint().measureText(paramView.getText().toString());
    int i = paramFinderWordingLayout.getContext().getResources().getDimensionPixelSize(e.c.Edge_A);
    AppMethodBeat.o(345825);
    return paramInt + i;
  }
  
  private final void a(b paramb1, b paramb2)
  {
    AppMethodBeat.i(345806);
    Log.i("Finder.FinderWordingView", "onModeChange from: " + paramb1 + " to: " + paramb2);
    m localm = this.GDS;
    if (localm != null) {
      localm.invoke(paramb1, paramb2);
    }
    AppMethodBeat.o(345806);
  }
  
  private static final void a(FinderWordingLayout paramFinderWordingLayout, int paramInt)
  {
    AppMethodBeat.i(345836);
    kotlin.g.b.s.u(paramFinderWordingLayout, "this$0");
    paramFinderWordingLayout = paramFinderWordingLayout.getSizeChangeListener();
    if (paramFinderWordingLayout != null) {
      paramFinderWordingLayout.invoke();
    }
    AppMethodBeat.o(345836);
  }
  
  private static final void a(FinderWordingLayout paramFinderWordingLayout, View paramView)
  {
    AppMethodBeat.i(345852);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFinderWordingLayout);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderWordingLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramFinderWordingLayout, "this$0");
    paramView = paramFinderWordingLayout.getCurrMode();
    if (c.$EnumSwitchMapping$0[paramView.ordinal()] == 1) {
      a(paramFinderWordingLayout);
    }
    while (paramFinderWordingLayout.AUZ == null)
    {
      paramFinderWordingLayout.notifyDataSetChanged();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderWordingLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(345852);
      return;
    }
    int i;
    if (paramFinderWordingLayout.AXX)
    {
      paramView = av.GiL;
      paramView = paramFinderWordingLayout.AUZ;
      kotlin.g.b.s.checkNotNull(paramView);
      if (av.e(paramView))
      {
        i = 1;
        label153:
        if (i == 0) {
          break label302;
        }
        localObject1 = paramFinderWordingLayout.GDU;
        localObject2 = paramFinderWordingLayout.getTitleTv();
        paramView = paramFinderWordingLayout.GDV;
        if (paramView != null) {
          break label304;
        }
        paramView = null;
        label179:
        if (Util.isNullOrNil(paramView)) {
          break label320;
        }
        paramView = paramFinderWordingLayout.GDV;
        if (paramView != null) {
          break label312;
        }
        paramView = null;
      }
    }
    label197:
    for (paramView = (CharSequence)paramView;; paramView = (CharSequence)paramFinderWordingLayout.getContext().getString(e.h.finder_wording_attribute_manage_title))
    {
      ((TextView)localObject2).setText(paramView);
      paramFinderWordingLayout.getManageBtn().setBackgroundResource(e.d.wording_manage_btn_bg_highlight);
      paramFinderWordingLayout.getManageBtnText().setText(e.h.finder_complete);
      paramFinderWordingLayout.getManageBtnText().setTextColor(paramFinderWordingLayout.getContext().getResources().getColor(e.b.UN_BW_0_Alpha_0_9));
      paramFinderWordingLayout.GDU = b.GDY;
      paramView = o.Gds;
      paramView = o.fel();
      localObject2 = paramFinderWordingLayout.AUZ;
      kotlin.g.b.s.checkNotNull(localObject2);
      paramView.a(((BaseFinderFeed)localObject2).bZA(), paramFinderWordingLayout.GDU);
      paramFinderWordingLayout.a((b)localObject1, paramFinderWordingLayout.GDU);
      break;
      i = 0;
      break label153;
      break;
      paramView = paramView.YZh;
      break label179;
      paramView = paramView.YZh;
      break label197;
    }
  }
  
  private static final void a(FinderWordingLayout paramFinderWordingLayout, n paramn, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(345874);
    kotlin.g.b.s.u(paramFinderWordingLayout, "this$0");
    kotlin.g.b.s.u(paramn, "$removeItem");
    if (paramMenuItem.getItemId() == 1)
    {
      paramMenuItem = (List)new ArrayList();
      Object localObject1 = ((Iterable)paramFinderWordingLayout.getDataList()).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (n)((Iterator)localObject1).next();
        if ((((n)localObject2).YZe == paramn.YZe) && (((n)localObject2).feedId == paramn.feedId)) {
          paramMenuItem.add(localObject2);
        }
      }
      paramMenuItem = ((Iterable)paramMenuItem).iterator();
      if (paramMenuItem.hasNext())
      {
        paramn = (n)paramMenuItem.next();
        localObject1 = o.Gds;
        localObject1 = o.fel();
        kotlin.g.b.s.u(paramn, "wordingItem");
        localObject2 = new com.tencent.mm.plugin.finder.upload.action.r(paramn);
        ((Map)((o)localObject1).Gdx).put(o.b(paramn), Boolean.TRUE);
        ((o)localObject1).a((e)localObject2);
        localObject1 = new if();
        ((if)localObject1).hJB.id = paramn.feedId;
        ((if)localObject1).hJB.hJI = paramn.YZe;
        ((if)localObject1).hJB.type = 26;
        ((if)localObject1).publish();
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("feedid", com.tencent.mm.plugin.expt.hellhound.core.b.hF(paramn.feedId));
        ((JSONObject)localObject1).put("buzz_word", paramn.wording + '|' + paramn.YZf);
        paramn = as.GSQ;
        paramn = paramFinderWordingLayout.getContext();
        kotlin.g.b.s.s(paramn, "context");
        paramn = as.a.hu(paramn);
        if (paramn == null) {}
        for (paramn = null;; paramn = paramn.fou())
        {
          localObject2 = bb.FuK;
          bb.a(paramn, "buzz_bar_del", true, (JSONObject)localObject1);
          break;
        }
      }
    }
    AppMethodBeat.o(345874);
  }
  
  private static final void a(FinderWordingLayout paramFinderWordingLayout, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(345858);
    kotlin.g.b.s.u(paramFinderWordingLayout, "this$0");
    if (params.jmw()) {
      params.a(1, paramFinderWordingLayout.getContext().getResources().getColor(e.b.red_text_color), (CharSequence)paramFinderWordingLayout.getContext().getString(e.h.app_delete));
    }
    AppMethodBeat.o(345858);
  }
  
  private final g dUK()
  {
    AppMethodBeat.i(345814);
    g localg = (g)new d(this);
    AppMethodBeat.o(345814);
    return localg;
  }
  
  private final TextView getManageBtnText()
  {
    AppMethodBeat.i(345763);
    Object localObject = this.GDQ.getValue();
    kotlin.g.b.s.s(localObject, "<get-manageBtnText>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(345763);
    return localObject;
  }
  
  private final TextView getTitleTv()
  {
    AppMethodBeat.i(345774);
    Object localObject = this.vOl.getValue();
    kotlin.g.b.s.s(localObject, "<get-titleTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(345774);
    return localObject;
  }
  
  public final b getCurrMode()
  {
    return this.GDU;
  }
  
  public final tp getData()
  {
    return this.GDV;
  }
  
  public final ArrayList<n> getDataList()
  {
    return this.pUj;
  }
  
  public final BaseFinderFeed getFeed()
  {
    return this.AUZ;
  }
  
  public final kotlin.g.a.b<n, ah> getItemRemoveListener()
  {
    return this.GDT;
  }
  
  public final View getManageBtn()
  {
    AppMethodBeat.i(345938);
    Object localObject = this.GDP.getValue();
    kotlin.g.b.s.s(localObject, "<get-manageBtn>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(345938);
    return localObject;
  }
  
  public final m<b, b, ah> getOnModeChangeListener()
  {
    return this.GDS;
  }
  
  public final WxRecyclerView getRecyclerView()
  {
    AppMethodBeat.i(345934);
    Object localObject = this.CNQ.getValue();
    kotlin.g.b.s.s(localObject, "<get-recyclerView>(...)");
    localObject = (WxRecyclerView)localObject;
    AppMethodBeat.o(345934);
    return localObject;
  }
  
  public final boolean getSelfFlag()
  {
    return this.AXX;
  }
  
  public final kotlin.g.a.a<ah> getSizeChangeListener()
  {
    return this.GDR;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(346037);
    RecyclerView.a locala = getRecyclerView().getAdapter();
    if (locala != null) {
      locala.bZE.notifyChanged();
    }
    AppMethodBeat.o(346037);
  }
  
  public final void setCurrMode(b paramb)
  {
    AppMethodBeat.i(345993);
    kotlin.g.b.s.u(paramb, "<set-?>");
    this.GDU = paramb;
    AppMethodBeat.o(345993);
  }
  
  public final void setData(tp paramtp)
  {
    this.GDV = paramtp;
  }
  
  public final void setFeed(BaseFinderFeed paramBaseFinderFeed)
  {
    this.AUZ = paramBaseFinderFeed;
  }
  
  public final void setItemClickListener(final i.c<com.tencent.mm.view.recyclerview.j> paramc)
  {
    AppMethodBeat.i(346042);
    RecyclerView.a locala = getRecyclerView().getAdapter();
    if ((locala != null) && ((locala instanceof WxRecyclerAdapter))) {
      ((WxRecyclerAdapter)locala).agOe = ((i.c)new h(this, paramc));
    }
    AppMethodBeat.o(346042);
  }
  
  public final void setItemRemoveListener(kotlin.g.a.b<? super n, ah> paramb)
  {
    this.GDT = paramb;
  }
  
  public final void setOnModeChangeListener(m<? super b, ? super b, ah> paramm)
  {
    this.GDS = paramm;
  }
  
  public final void setSelfFlag(boolean paramBoolean)
  {
    this.AXX = paramBoolean;
  }
  
  public final void setSizeChangeListener(kotlin.g.a.a<ah> parama)
  {
    this.GDR = parama;
  }
  
  public final void setWordingList(List<n> paramList)
  {
    int k = 0;
    AppMethodBeat.i(346034);
    kotlin.g.b.s.u(paramList, "list");
    this.pUj.clear();
    Object localObject1 = this.pUj;
    Object localObject2 = o.Gds;
    localObject2 = o.fel();
    kotlin.g.b.s.u(paramList, "list");
    List localList1 = (List)new ArrayList();
    List localList2 = (List)new ArrayList();
    Iterator localIterator = ((Iterable)paramList).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject3 = localIterator.next();
      int j = i + 1;
      if (i < 0) {
        p.kkW();
      }
      localObject3 = (n)localObject3;
      kotlin.g.b.s.u(localObject3, "wordingItem");
      Object localObject4 = o.b((n)localObject3);
      localObject4 = (Boolean)((o)localObject2).Gdx.get(localObject4);
      if (localObject4 == null) {}
      for (boolean bool = false;; bool = ((Boolean)localObject4).booleanValue())
      {
        if (bool) {
          break label188;
        }
        localList1.add(localObject3);
        i = j;
        break;
      }
      label188:
      localList2.add(Integer.valueOf(i));
      i = j;
    }
    ((ArrayList)localObject1).addAll((Collection)v.Y(localList1, localList2).bsC);
    localObject2 = ((Iterable)this.pUj).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (((n)localObject1).hJr == 1)
      {
        i = 1;
        label271:
        if (i == 0) {
          break label345;
        }
        label275:
        i = k;
        if (localObject1 != null) {
          i = 1;
        }
        if (i != 0)
        {
          paramList = (n)p.oL(paramList);
          if (paramList != null) {
            break label353;
          }
        }
      }
    }
    label345:
    label353:
    for (long l = 0L;; l = paramList.feedId)
    {
      paramList = o.Gds;
      o.fel().qD(l);
      paramList = getRecyclerView().getAdapter();
      if (paramList != null) {
        paramList.bZE.notifyChanged();
      }
      AppMethodBeat.o(346034);
      return;
      i = 0;
      break label271;
      break;
      localObject1 = null;
      break label275;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderWordingLayout$Companion;", "", "()V", "MENU_DELETE_ITEM", "", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderWordingLayout$Mode;", "", "(Ljava/lang/String;I)V", "NORMAL", "LIKE_ONLY", "MANAGE", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    static
    {
      AppMethodBeat.i(345612);
      GDW = new b("NORMAL", 0);
      GDX = new b("LIKE_ONLY", 1);
      GDY = new b("MANAGE", 2);
      GDZ = new b[] { GDW, GDX, GDY };
      AppMethodBeat.o(345612);
    }
    
    private b() {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderWordingLayout$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements g
  {
    d(FinderWordingLayout paramFinderWordingLayout) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(345533);
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new cy((kotlin.g.a.b)new a(this.GEa));
      AppMethodBeat.o(345533);
      return localf;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/FinderWordingItem;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<n, ah>
    {
      a(FinderWordingLayout paramFinderWordingLayout)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<View>
  {
    e(FinderWordingLayout paramFinderWordingLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<TextView>
  {
    f(FinderWordingLayout paramFinderWordingLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<WxRecyclerView>
  {
    g(FinderWordingLayout paramFinderWordingLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderWordingLayout$setItemClickListener$1$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements i.c<com.tencent.mm.view.recyclerview.j>
  {
    h(FinderWordingLayout paramFinderWordingLayout, i.c<com.tencent.mm.view.recyclerview.j> paramc) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<TextView>
  {
    i(FinderWordingLayout paramFinderWordingLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderWordingLayout
 * JD-Core Version:    0.7.0.1
 */