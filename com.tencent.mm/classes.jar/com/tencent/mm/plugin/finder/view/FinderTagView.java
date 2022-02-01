package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.js;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.protocal.protobuf.epc;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.af;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "allAddViews", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "getAllAddViews", "()Ljava/util/ArrayList;", "setAllAddViews", "(Ljava/util/ArrayList;)V", "value", "Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;", "config", "getConfig", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;", "setConfig", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;)V", "expandListener", "Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;", "getExpandListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;", "setExpandListener", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;)V", "flodListener", "Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;", "getFlodListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;", "setFlodListener", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;)V", "foldedView", "getFoldedView", "setFoldedView", "hasExpandBtn", "", "getHasExpandBtn", "()I", "setHasExpandBtn", "(I)V", "isClickExpand", "setClickExpand", "isFolded", "", "()Z", "setFolded", "(Z)V", "onExpandListener", "Lkotlin/Function0;", "", "getOnExpandListener", "()Lkotlin/jvm/functions/Function0;", "setOnExpandListener", "(Lkotlin/jvm/functions/Function0;)V", "onFlodListener", "getOnFlodListener", "setOnFlodListener", "opBtn", "getOpBtn", "()Landroid/view/View;", "setOpBtn", "(Landroid/view/View;)V", "root", "getRoot", "setRoot", "selectedIndex", "getSelectedIndex", "setSelectedIndex", "tagClickMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getTagClickMap", "()Ljava/util/HashMap;", "setTagClickMap", "(Ljava/util/HashMap;)V", "tagData", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTagData", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setTagData", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "tagLayout", "Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;", "getTagLayout", "()Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;", "setTagLayout", "(Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;)V", "addDummyTag", "tags", "addTags", "expandTags", "flodTags", "genItemView", "tag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "index", "init", "notiftyTagClick", "refreshOpBtn", "setTagState", "selected", "view", "showOrDimissOpBtn", "show", "Companion", "Config", "expandOnClickListener", "flodOnClickListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderTagView
  extends RelativeLayout
{
  public static final a GCE;
  private static final int GCU;
  private static final int GCV;
  private static final int GCW;
  public static final long GCX;
  public FinderTagFlowLayout GCF;
  public View GCG;
  private ArrayList<View> GCH;
  public ArrayList<View> GCI;
  private HashMap<Long, Integer> GCJ;
  public epc GCK;
  private boolean GCL;
  private kotlin.g.a.a<ah> GCN;
  private kotlin.g.a.a<ah> GCO;
  private int GCP;
  public int GCQ;
  private b GCR;
  private c GCS;
  private d GCT;
  private int dbk;
  public View lBX;
  
  static
  {
    AppMethodBeat.i(345346);
    GCE = new a((byte)0);
    GCU = -1;
    GCV = -2;
    GCW = e.e.finder_feed_tag_float_view;
    GCX = -1L;
    AppMethodBeat.o(345346);
  }
  
  public FinderTagView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(345162);
    this.GCH = new ArrayList();
    this.GCI = new ArrayList();
    this.dbk = -1;
    this.GCJ = new HashMap();
    this.GCR = new b();
    this.GCS = new c(this);
    this.GCT = new d(this);
    init(paramContext);
    AppMethodBeat.o(345162);
  }
  
  public FinderTagView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(345178);
    this.GCH = new ArrayList();
    this.GCI = new ArrayList();
    this.dbk = -1;
    this.GCJ = new HashMap();
    this.GCR = new b();
    this.GCS = new c(this);
    this.GCT = new d(this);
    init(paramContext);
    AppMethodBeat.o(345178);
  }
  
  private static final void a(FinderTagView paramFinderTagView)
  {
    AppMethodBeat.i(345254);
    s.u(paramFinderTagView, "this$0");
    if ((paramFinderTagView.getTagLayout().GCA.size() <= 1) && (paramFinderTagView.getFoldedView().isEmpty()))
    {
      paramFinderTagView.va(false);
      AppMethodBeat.o(345254);
      return;
    }
    if (!paramFinderTagView.GCL)
    {
      if (paramFinderTagView.getConfig().GDc)
      {
        paramFinderTagView.getOpBtn().setRotation(-90.0F);
        paramFinderTagView.getOpBtn().setOnClickListener((View.OnClickListener)paramFinderTagView.getFlodListener());
        paramFinderTagView.va(true);
        AppMethodBeat.o(345254);
        return;
      }
      paramFinderTagView.va(false);
      AppMethodBeat.o(345254);
      return;
    }
    paramFinderTagView.va(true);
    paramFinderTagView.getOpBtn().setRotation(90.0F);
    paramFinderTagView.getOpBtn().setOnClickListener((View.OnClickListener)paramFinderTagView.getExpandListener());
    AppMethodBeat.o(345254);
  }
  
  private static final void a(FinderTagView paramFinderTagView, View paramView)
  {
    AppMethodBeat.i(345304);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderTagView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderTagView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderTagView, "this$0");
    localObject = paramView.getTag(GCU);
    if (localObject == null)
    {
      paramFinderTagView = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(345304);
      throw paramFinderTagView;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    localObject = new ah.d();
    paramView = paramView.getTag(GCV);
    if (paramView == null)
    {
      paramFinderTagView = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(345304);
      throw paramFinderTagView;
    }
    ((ah.d)localObject).aixb = ((Integer)paramView).intValue();
    int k = paramFinderTagView.getAllAddViews().size();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (i == ((ah.d)localObject).aixb)
      {
        paramView = paramFinderTagView.getAllAddViews().get(i);
        s.s(paramView, "allAddViews[i]");
        paramFinderTagView.a(true, (View)paramView, -1);
      }
      while (j >= k)
      {
        if (!bool) {
          new MMHandler().postUI(new FinderTagView..ExternalSyntheticLambda3(paramFinderTagView, (ah.d)localObject));
        }
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderTagView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(345304);
        return;
        paramView = paramFinderTagView.getAllAddViews().get(i);
        s.s(paramView, "allAddViews[i]");
        paramFinderTagView.a(false, (View)paramView, -1);
      }
    }
  }
  
  private static final void a(FinderTagView paramFinderTagView, ah.d paramd)
  {
    AppMethodBeat.i(345278);
    s.u(paramFinderTagView, "this$0");
    s.u(paramd, "$indexClick");
    paramd = paramFinderTagView.getTagData().abtn.get(paramd.aixb);
    s.s(paramd, "tagData.topic_list[indexClick]");
    paramd = (bxv)paramd;
    ((Map)paramFinderTagView.GCJ).put(Long.valueOf(paramd.ADo), Integer.valueOf(1));
    paramFinderTagView = new js();
    paramFinderTagView.hLo.hLp = paramd;
    paramFinderTagView.publish();
    AppMethodBeat.o(345278);
  }
  
  private final void a(boolean paramBoolean, View paramView, int paramInt)
  {
    AppMethodBeat.i(345245);
    if (paramInt >= 0) {
      paramView.setTag(GCV, Integer.valueOf(paramInt));
    }
    paramView.setTag(GCU, Boolean.valueOf(paramBoolean));
    paramView = (TextView)paramView.findViewById(e.e.finder_machine_item_tv);
    if (paramBoolean)
    {
      paramView.setTextColor(getRoot().getContext().getResources().getColor(this.GCR.GDb));
      paramView.setBackgroundResource(this.GCR.GCZ);
      AppMethodBeat.o(345245);
      return;
    }
    paramView.setTextColor(getRoot().getContext().getResources().getColor(this.GCR.GDa));
    paramView.setBackgroundResource(this.GCR.GCY);
    AppMethodBeat.o(345245);
  }
  
  private static final void b(FinderTagView paramFinderTagView)
  {
    AppMethodBeat.i(345266);
    s.u(paramFinderTagView, "this$0");
    int k;
    if (!paramFinderTagView.GCL)
    {
      k = paramFinderTagView.getTagLayout().GCA.size();
      paramFinderTagView.getFoldedView().clear();
      if (1 >= k) {}
    }
    int j;
    for (int i = 1;; i = j)
    {
      j = i + 1;
      Object localObject = paramFinderTagView.getTagLayout().GCA.get(i);
      s.s(localObject, "tagLayout.mAllViews[i]");
      localObject = ((Iterable)localObject).iterator();
      View localView;
      while (((Iterator)localObject).hasNext())
      {
        localView = (View)((Iterator)localObject).next();
        paramFinderTagView.getFoldedView().add(localView);
      }
      if (j >= k)
      {
        localObject = ((Iterable)paramFinderTagView.getFoldedView()).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localView = (View)((Iterator)localObject).next();
          paramFinderTagView.getTagLayout().removeView(localView);
        }
        paramFinderTagView.setFolded(true);
        paramFinderTagView.fll();
        paramFinderTagView = paramFinderTagView.getOnFlodListener();
        if (paramFinderTagView != null) {
          paramFinderTagView.invoke();
        }
        AppMethodBeat.o(345266);
        return;
      }
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(345199);
    View localView = af.mU(paramContext).inflate(e.f.finder_machinetab_tag_layout, (ViewGroup)this);
    s.s(localView, "getInflater(context).inf…chinetab_tag_layout,this)");
    setRoot(localView);
    localView = getRoot().findViewById(e.e.finder_machine_tag_layout);
    s.s(localView, "root.findViewById(R.id.finder_machine_tag_layout)");
    setTagLayout((FinderTagFlowLayout)localView);
    localView = getRoot().findViewById(e.e.finder_machine_tag_op_icon);
    s.s(localView, "root.findViewById(R.id.finder_machine_tag_op_icon)");
    setOpBtn(localView);
    s.checkNotNull(paramContext);
    setBackgroundColor(paramContext.getResources().getColor(this.GCR.bg));
    AppMethodBeat.o(345199);
  }
  
  private void va(boolean paramBoolean)
  {
    AppMethodBeat.i(345234);
    if (paramBoolean)
    {
      this.GCP = 1;
      getOpBtn().setVisibility(0);
      findViewById(e.e.finder_machine_tag_op_bg).setVisibility(0);
      findViewById(e.e.finder_machine_op_layout).setVisibility(0);
      AppMethodBeat.o(345234);
      return;
    }
    getOpBtn().setOnClickListener(null);
    getOpBtn().setVisibility(8);
    findViewById(e.e.finder_machine_tag_op_bg).setVisibility(8);
    findViewById(e.e.finder_machine_op_layout).setVisibility(8);
    AppMethodBeat.o(345234);
  }
  
  public final View a(bxv parambxv, int paramInt)
  {
    AppMethodBeat.i(345712);
    View localView1 = af.mU(getRoot().getContext()).inflate(e.f.finder_machinetab_tag_item_layout, null);
    View localView2 = localView1.findViewById(e.e.finder_machine_item_tv);
    s.s(localView2, "view.findViewById<TextVi…d.finder_machine_item_tv)");
    ((TextView)localView2).setText((CharSequence)parambxv.topic);
    if (parambxv.ADo == -1L)
    {
      s.s(localView1, "view");
      a(true, localView1, paramInt);
    }
    for (;;)
    {
      localView1.setOnClickListener(new FinderTagView..ExternalSyntheticLambda0(this));
      s.s(localView1, "view");
      AppMethodBeat.o(345712);
      return localView1;
      s.s(localView1, "view");
      a(false, localView1, paramInt);
    }
  }
  
  public final void fll()
  {
    AppMethodBeat.i(345685);
    getTagLayout().post(new FinderTagView..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(345685);
  }
  
  public final void flm()
  {
    AppMethodBeat.i(345692);
    getTagLayout().post(new FinderTagView..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(345692);
  }
  
  public final void fln()
  {
    AppMethodBeat.i(345700);
    if (this.GCL)
    {
      Object localObject = ((Iterable)this.GCH).iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = (View)((Iterator)localObject).next();
        getTagLayout().addView(localView);
      }
      this.GCH.clear();
      this.GCL = false;
      fll();
      localObject = this.GCO;
      if (localObject != null) {
        ((kotlin.g.a.a)localObject).invoke();
      }
    }
    AppMethodBeat.o(345700);
  }
  
  public final ArrayList<View> getAllAddViews()
  {
    return this.GCI;
  }
  
  public final b getConfig()
  {
    return this.GCR;
  }
  
  public final c getExpandListener()
  {
    return this.GCS;
  }
  
  public final d getFlodListener()
  {
    return this.GCT;
  }
  
  public final ArrayList<View> getFoldedView()
  {
    return this.GCH;
  }
  
  public final int getHasExpandBtn()
  {
    return this.GCP;
  }
  
  public final kotlin.g.a.a<ah> getOnExpandListener()
  {
    return this.GCO;
  }
  
  public final kotlin.g.a.a<ah> getOnFlodListener()
  {
    return this.GCN;
  }
  
  public final View getOpBtn()
  {
    AppMethodBeat.i(345416);
    View localView = this.GCG;
    if (localView != null)
    {
      AppMethodBeat.o(345416);
      return localView;
    }
    s.bIx("opBtn");
    AppMethodBeat.o(345416);
    return null;
  }
  
  public final View getRoot()
  {
    AppMethodBeat.i(345604);
    View localView = this.lBX;
    if (localView != null)
    {
      AppMethodBeat.o(345604);
      return localView;
    }
    s.bIx("root");
    AppMethodBeat.o(345604);
    return null;
  }
  
  public final int getSelectedIndex()
  {
    return this.dbk;
  }
  
  public final HashMap<Long, Integer> getTagClickMap()
  {
    return this.GCJ;
  }
  
  public final epc getTagData()
  {
    AppMethodBeat.i(345505);
    epc localepc = this.GCK;
    if (localepc != null)
    {
      AppMethodBeat.o(345505);
      return localepc;
    }
    s.bIx("tagData");
    AppMethodBeat.o(345505);
    return null;
  }
  
  public final FinderTagFlowLayout getTagLayout()
  {
    AppMethodBeat.i(345392);
    FinderTagFlowLayout localFinderTagFlowLayout = this.GCF;
    if (localFinderTagFlowLayout != null)
    {
      AppMethodBeat.o(345392);
      return localFinderTagFlowLayout;
    }
    s.bIx("tagLayout");
    AppMethodBeat.o(345392);
    return null;
  }
  
  public final void setAllAddViews(ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(345459);
    s.u(paramArrayList, "<set-?>");
    this.GCI = paramArrayList;
    AppMethodBeat.o(345459);
  }
  
  public final void setClickExpand(int paramInt)
  {
    this.GCQ = paramInt;
  }
  
  public final void setConfig(b paramb)
  {
    AppMethodBeat.i(345637);
    s.u(paramb, "value");
    Context localContext = getContext();
    s.checkNotNull(localContext);
    setBackgroundColor(localContext.getResources().getColor(paramb.bg));
    AppMethodBeat.o(345637);
  }
  
  public final void setExpandListener(c paramc)
  {
    AppMethodBeat.i(345657);
    s.u(paramc, "<set-?>");
    this.GCS = paramc;
    AppMethodBeat.o(345657);
  }
  
  public final void setFlodListener(d paramd)
  {
    AppMethodBeat.i(345678);
    s.u(paramd, "<set-?>");
    this.GCT = paramd;
    AppMethodBeat.o(345678);
  }
  
  public final void setFolded(boolean paramBoolean)
  {
    this.GCL = paramBoolean;
  }
  
  public final void setFoldedView(ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(345450);
    s.u(paramArrayList, "<set-?>");
    this.GCH = paramArrayList;
    AppMethodBeat.o(345450);
  }
  
  public final void setHasExpandBtn(int paramInt)
  {
    this.GCP = paramInt;
  }
  
  public final void setOnExpandListener(kotlin.g.a.a<ah> parama)
  {
    this.GCO = parama;
  }
  
  public final void setOnFlodListener(kotlin.g.a.a<ah> parama)
  {
    this.GCN = parama;
  }
  
  public final void setOpBtn(View paramView)
  {
    AppMethodBeat.i(345431);
    s.u(paramView, "<set-?>");
    this.GCG = paramView;
    AppMethodBeat.o(345431);
  }
  
  public final void setRoot(View paramView)
  {
    AppMethodBeat.i(345614);
    s.u(paramView, "<set-?>");
    this.lBX = paramView;
    AppMethodBeat.o(345614);
  }
  
  public final void setSelectedIndex(int paramInt)
  {
    this.dbk = paramInt;
  }
  
  public final void setTagClickMap(HashMap<Long, Integer> paramHashMap)
  {
    AppMethodBeat.i(345491);
    s.u(paramHashMap, "<set-?>");
    this.GCJ = paramHashMap;
    AppMethodBeat.o(345491);
  }
  
  public final void setTagData(epc paramepc)
  {
    AppMethodBeat.i(345514);
    s.u(paramepc, "<set-?>");
    this.GCK = paramepc;
    AppMethodBeat.o(345514);
  }
  
  public final void setTagLayout(FinderTagFlowLayout paramFinderTagFlowLayout)
  {
    AppMethodBeat.i(345405);
    s.u(paramFinderTagFlowLayout, "<set-?>");
    this.GCF = paramFinderTagFlowLayout;
    AppMethodBeat.o(345405);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$Companion;", "", "()V", "FLOAT_VIEW_ID", "", "getFLOAT_VIEW_ID", "()I", "TAG", "", "TAG_ALL_TOPIC_ID", "", "getTAG_ALL_TOPIC_ID", "()J", "TAG_VIEW_INDEX", "getTAG_VIEW_INDEX", "TAG_VIEW_SELECTED_STATE", "getTAG_VIEW_SELECTED_STATE", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;", "", "()V", "bg", "", "getBg", "()I", "setBg", "(I)V", "canFoldAfterExpand", "", "getCanFoldAfterExpand", "()Z", "setCanFoldAfterExpand", "(Z)V", "itemNormalBg", "getItemNormalBg", "setItemNormalBg", "itemSelectedBg", "getItemSelectedBg", "setItemSelectedBg", "itemTextNormalColor", "getItemTextNormalColor", "setItemTextNormalColor", "itemTextSelectedColor", "getItemTextSelectedColor", "setItemTextSelectedColor", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    int GCY = e.d.finder_machine_tag_bg_shape_normal;
    int GCZ = e.d.finder_machine_tag_bg_shape_selected;
    int GDa = e.b.normal_text_color;
    int GDb = e.b.white_text_color;
    boolean GDc = true;
    int bg = e.b.BG_2;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;", "Landroid/view/View$OnClickListener;", "tagView", "Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView;Lcom/tencent/mm/plugin/finder/view/FinderTagView;)V", "getTagView", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    implements View.OnClickListener
  {
    private final FinderTagView GDd;
    
    public c()
    {
      AppMethodBeat.i(345666);
      this.GDd = localObject;
      AppMethodBeat.o(345666);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(345674);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      this.GDd.fln();
      FinderTagView.this.setClickExpand(1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(345674);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;", "Landroid/view/View$OnClickListener;", "tagView", "Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView;)V", "getTagView", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements View.OnClickListener
  {
    private final FinderTagView GDd;
    
    public d(FinderTagView paramFinderTagView)
    {
      AppMethodBeat.i(345650);
      this.GDd = paramFinderTagView;
      AppMethodBeat.o(345650);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(345658);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      this.GDd.flm();
      this.GDd.fll();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(345658);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderTagView
 * JD-Core Version:    0.7.0.1
 */