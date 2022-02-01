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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.asv;
import com.tencent.mm.protocal.protobuf.ctu;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.g.b.y.d;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "allAddViews", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "getAllAddViews", "()Ljava/util/ArrayList;", "setAllAddViews", "(Ljava/util/ArrayList;)V", "value", "Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;", "config", "getConfig", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;", "setConfig", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;)V", "expandListener", "Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;", "getExpandListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;", "setExpandListener", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;)V", "flodListener", "Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;", "getFlodListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;", "setFlodListener", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;)V", "foldedView", "getFoldedView", "setFoldedView", "hasExpandBtn", "", "getHasExpandBtn", "()I", "setHasExpandBtn", "(I)V", "isClickExpand", "setClickExpand", "isFolded", "", "()Z", "setFolded", "(Z)V", "onExpandListener", "Lkotlin/Function0;", "", "getOnExpandListener", "()Lkotlin/jvm/functions/Function0;", "setOnExpandListener", "(Lkotlin/jvm/functions/Function0;)V", "onFlodListener", "getOnFlodListener", "setOnFlodListener", "opBtn", "getOpBtn", "()Landroid/view/View;", "setOpBtn", "(Landroid/view/View;)V", "root", "getRoot", "setRoot", "selectedIndex", "getSelectedIndex", "setSelectedIndex", "tagClickMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getTagClickMap", "()Ljava/util/HashMap;", "setTagClickMap", "(Ljava/util/HashMap;)V", "tagData", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTagData", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setTagData", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "tagLayout", "Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;", "getTagLayout", "()Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;", "setTagLayout", "(Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;)V", "addDummyTag", "tags", "addTags", "expandTags", "flodTags", "genItemView", "tag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "index", "init", "notiftyTagClick", "refreshOpBtn", "setTagState", "selected", "view", "showOrDimissOpBtn", "show", "Companion", "Config", "expandOnClickListener", "flodOnClickListener", "plugin-finder_release"})
public final class FinderTagView
  extends RelativeLayout
{
  private static final int thf = -1;
  private static final int thg = -2;
  private static final int thh;
  public static final long thi = -1L;
  public static final FinderTagView.a thj;
  private int bxN;
  public View fQH;
  public FinderTagFlowLayout tgR;
  public View tgS;
  ArrayList<View> tgT;
  public ArrayList<View> tgU;
  public HashMap<Long, Integer> tgV;
  public ctu tgW;
  boolean tgX;
  private d.g.a.a<d.z> tgY;
  d.g.a.a<d.z> tgZ;
  private int tha;
  public int thb;
  private b thc;
  private c thd;
  private d the;
  
  static
  {
    AppMethodBeat.i(205851);
    thj = new FinderTagView.a((byte)0);
    thf = -1;
    thg = -2;
    thh = 2131307398;
    thi = -1L;
    AppMethodBeat.o(205851);
  }
  
  public FinderTagView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(205849);
    this.tgT = new ArrayList();
    this.tgU = new ArrayList();
    this.bxN = -1;
    this.tgV = new HashMap();
    this.thc = new b();
    this.thd = new c(this);
    this.the = new d(this);
    init(paramContext);
    AppMethodBeat.o(205849);
  }
  
  public FinderTagView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205850);
    this.tgT = new ArrayList();
    this.tgU = new ArrayList();
    this.bxN = -1;
    this.tgV = new HashMap();
    this.thc = new b();
    this.thd = new c(this);
    this.the = new d(this);
    init(paramContext);
    AppMethodBeat.o(205850);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(205844);
    View localView = com.tencent.mm.ui.z.jV(paramContext).inflate(2131496228, (ViewGroup)this);
    p.g(localView, "MMLayoutInflater.getInfl…chinetab_tag_layout,this)");
    this.fQH = localView;
    localView = this.fQH;
    if (localView == null) {
      p.bdF("root");
    }
    localView = localView.findViewById(2131307409);
    p.g(localView, "root.findViewById(R.id.finder_machine_tag_layout)");
    this.tgR = ((FinderTagFlowLayout)localView);
    localView = this.fQH;
    if (localView == null) {
      p.bdF("root");
    }
    localView = localView.findViewById(2131307411);
    p.g(localView, "root.findViewById(R.id.finder_machine_tag_op_icon)");
    this.tgS = localView;
    if (paramContext == null) {
      p.gkB();
    }
    setBackgroundColor(paramContext.getResources().getColor(this.thc.bg));
    AppMethodBeat.o(205844);
  }
  
  public final void a(boolean paramBoolean, View paramView, int paramInt)
  {
    AppMethodBeat.i(205848);
    if (paramInt >= 0) {
      paramView.setTag(thg, Integer.valueOf(paramInt));
    }
    paramView.setTag(thf, Boolean.valueOf(paramBoolean));
    paramView = (TextView)paramView.findViewById(2131307407);
    if (paramBoolean)
    {
      localObject = this.fQH;
      if (localObject == null) {
        p.bdF("root");
      }
      localObject = ((View)localObject).getContext();
      p.g(localObject, "root.context");
      paramView.setTextColor(((Context)localObject).getResources().getColor(this.thc.thn));
      paramView.setBackgroundResource(this.thc.thl);
      AppMethodBeat.o(205848);
      return;
    }
    Object localObject = this.fQH;
    if (localObject == null) {
      p.bdF("root");
    }
    localObject = ((View)localObject).getContext();
    p.g(localObject, "root.context");
    paramView.setTextColor(((Context)localObject).getResources().getColor(this.thc.thm));
    paramView.setBackgroundResource(this.thc.thk);
    AppMethodBeat.o(205848);
  }
  
  public final void cQh()
  {
    AppMethodBeat.i(205845);
    FinderTagFlowLayout localFinderTagFlowLayout = this.tgR;
    if (localFinderTagFlowLayout == null) {
      p.bdF("tagLayout");
    }
    localFinderTagFlowLayout.post((Runnable)new g(this));
    AppMethodBeat.o(205845);
  }
  
  public final void cQi()
  {
    AppMethodBeat.i(205847);
    FinderTagFlowLayout localFinderTagFlowLayout = this.tgR;
    if (localFinderTagFlowLayout == null) {
      p.bdF("tagLayout");
    }
    localFinderTagFlowLayout.post((Runnable)new e(this));
    AppMethodBeat.o(205847);
  }
  
  public final ArrayList<View> getAllAddViews()
  {
    return this.tgU;
  }
  
  public final b getConfig()
  {
    return this.thc;
  }
  
  public final c getExpandListener()
  {
    return this.thd;
  }
  
  public final d getFlodListener()
  {
    return this.the;
  }
  
  public final ArrayList<View> getFoldedView()
  {
    return this.tgT;
  }
  
  public final int getHasExpandBtn()
  {
    return this.tha;
  }
  
  public final d.g.a.a<d.z> getOnExpandListener()
  {
    return this.tgZ;
  }
  
  public final d.g.a.a<d.z> getOnFlodListener()
  {
    return this.tgY;
  }
  
  public final View getOpBtn()
  {
    AppMethodBeat.i(205832);
    View localView = this.tgS;
    if (localView == null) {
      p.bdF("opBtn");
    }
    AppMethodBeat.o(205832);
    return localView;
  }
  
  public final View getRoot()
  {
    AppMethodBeat.i(205839);
    View localView = this.fQH;
    if (localView == null) {
      p.bdF("root");
    }
    AppMethodBeat.o(205839);
    return localView;
  }
  
  public final int getSelectedIndex()
  {
    return this.bxN;
  }
  
  public final HashMap<Long, Integer> getTagClickMap()
  {
    return this.tgV;
  }
  
  public final ctu getTagData()
  {
    AppMethodBeat.i(205837);
    ctu localctu = this.tgW;
    if (localctu == null) {
      p.bdF("tagData");
    }
    AppMethodBeat.o(205837);
    return localctu;
  }
  
  public final FinderTagFlowLayout getTagLayout()
  {
    AppMethodBeat.i(205830);
    FinderTagFlowLayout localFinderTagFlowLayout = this.tgR;
    if (localFinderTagFlowLayout == null) {
      p.bdF("tagLayout");
    }
    AppMethodBeat.o(205830);
    return localFinderTagFlowLayout;
  }
  
  public final void mx(boolean paramBoolean)
  {
    AppMethodBeat.i(205846);
    if (paramBoolean)
    {
      this.tha = 1;
      localView = this.tgS;
      if (localView == null) {
        p.bdF("opBtn");
      }
      localView.setVisibility(0);
      localView = findViewById(2131307410);
      p.g(localView, "findViewById<View>(R.id.finder_machine_tag_op_bg)");
      localView.setVisibility(0);
      localView = findViewById(2131307408);
      p.g(localView, "findViewById<View>(R.id.finder_machine_op_layout)");
      localView.setVisibility(0);
      AppMethodBeat.o(205846);
      return;
    }
    View localView = this.tgS;
    if (localView == null) {
      p.bdF("opBtn");
    }
    localView.setOnClickListener(null);
    localView = this.tgS;
    if (localView == null) {
      p.bdF("opBtn");
    }
    localView.setVisibility(8);
    localView = findViewById(2131307410);
    p.g(localView, "findViewById<View>(R.id.finder_machine_tag_op_bg)");
    localView.setVisibility(8);
    localView = findViewById(2131307408);
    p.g(localView, "findViewById<View>(R.id.finder_machine_op_layout)");
    localView.setVisibility(8);
    AppMethodBeat.o(205846);
  }
  
  public final void setAllAddViews(ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(205835);
    p.h(paramArrayList, "<set-?>");
    this.tgU = paramArrayList;
    AppMethodBeat.o(205835);
  }
  
  public final void setClickExpand(int paramInt)
  {
    this.thb = paramInt;
  }
  
  public final void setConfig(b paramb)
  {
    AppMethodBeat.i(205841);
    p.h(paramb, "value");
    Context localContext = getContext();
    if (localContext == null) {
      p.gkB();
    }
    setBackgroundColor(localContext.getResources().getColor(paramb.bg));
    AppMethodBeat.o(205841);
  }
  
  public final void setExpandListener(c paramc)
  {
    AppMethodBeat.i(205842);
    p.h(paramc, "<set-?>");
    this.thd = paramc;
    AppMethodBeat.o(205842);
  }
  
  public final void setFlodListener(d paramd)
  {
    AppMethodBeat.i(205843);
    p.h(paramd, "<set-?>");
    this.the = paramd;
    AppMethodBeat.o(205843);
  }
  
  public final void setFolded(boolean paramBoolean)
  {
    this.tgX = paramBoolean;
  }
  
  public final void setFoldedView(ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(205834);
    p.h(paramArrayList, "<set-?>");
    this.tgT = paramArrayList;
    AppMethodBeat.o(205834);
  }
  
  public final void setHasExpandBtn(int paramInt)
  {
    this.tha = paramInt;
  }
  
  public final void setOnExpandListener(d.g.a.a<d.z> parama)
  {
    this.tgZ = parama;
  }
  
  public final void setOnFlodListener(d.g.a.a<d.z> parama)
  {
    this.tgY = parama;
  }
  
  public final void setOpBtn(View paramView)
  {
    AppMethodBeat.i(205833);
    p.h(paramView, "<set-?>");
    this.tgS = paramView;
    AppMethodBeat.o(205833);
  }
  
  public final void setRoot(View paramView)
  {
    AppMethodBeat.i(205840);
    p.h(paramView, "<set-?>");
    this.fQH = paramView;
    AppMethodBeat.o(205840);
  }
  
  public final void setSelectedIndex(int paramInt)
  {
    this.bxN = paramInt;
  }
  
  public final void setTagClickMap(HashMap<Long, Integer> paramHashMap)
  {
    AppMethodBeat.i(205836);
    p.h(paramHashMap, "<set-?>");
    this.tgV = paramHashMap;
    AppMethodBeat.o(205836);
  }
  
  public final void setTagData(ctu paramctu)
  {
    AppMethodBeat.i(205838);
    p.h(paramctu, "<set-?>");
    this.tgW = paramctu;
    AppMethodBeat.o(205838);
  }
  
  public final void setTagLayout(FinderTagFlowLayout paramFinderTagFlowLayout)
  {
    AppMethodBeat.i(205831);
    p.h(paramFinderTagFlowLayout, "<set-?>");
    this.tgR = paramFinderTagFlowLayout;
    AppMethodBeat.o(205831);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;", "", "()V", "bg", "", "getBg", "()I", "setBg", "(I)V", "canFoldAfterExpand", "", "getCanFoldAfterExpand", "()Z", "setCanFoldAfterExpand", "(Z)V", "itemNormalBg", "getItemNormalBg", "setItemNormalBg", "itemSelectedBg", "getItemSelectedBg", "setItemSelectedBg", "itemTextNormalColor", "getItemTextNormalColor", "setItemTextNormalColor", "itemTextSelectedColor", "getItemTextSelectedColor", "setItemTextSelectedColor", "plugin-finder_release"})
  public static final class b
  {
    int bg = 2131099650;
    int thk = 2131234879;
    int thl = 2131234880;
    int thm = 2131100711;
    int thn = 2131101182;
    boolean tho = true;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;", "Landroid/view/View$OnClickListener;", "tagView", "Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView;Lcom/tencent/mm/plugin/finder/view/FinderTagView;)V", "getTagView", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public final class c
    implements View.OnClickListener
  {
    private final FinderTagView thp;
    
    public c()
    {
      AppMethodBeat.i(205823);
      this.thp = localObject;
      AppMethodBeat.o(205823);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205822);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      paramView = this.thp;
      if (paramView.tgX)
      {
        localObject = ((Iterable)paramView.tgT).iterator();
        while (((Iterator)localObject).hasNext())
        {
          View localView = (View)((Iterator)localObject).next();
          FinderTagFlowLayout localFinderTagFlowLayout = paramView.tgR;
          if (localFinderTagFlowLayout == null) {
            p.bdF("tagLayout");
          }
          localFinderTagFlowLayout.addView(localView);
        }
        paramView.tgT.clear();
        paramView.tgX = false;
        paramView.cQh();
        paramView = paramView.tgZ;
        if (paramView != null) {
          paramView.invoke();
        }
      }
      FinderTagView.this.setClickExpand(1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(205822);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;", "Landroid/view/View$OnClickListener;", "tagView", "Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView;)V", "getTagView", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class d
    implements View.OnClickListener
  {
    private final FinderTagView thp;
    
    public d(FinderTagView paramFinderTagView)
    {
      AppMethodBeat.i(205825);
      this.thp = paramFinderTagView;
      AppMethodBeat.o(205825);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205824);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.thp.cQi();
      this.thp.cQh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(205824);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(FinderTagView paramFinderTagView) {}
    
    public final void run()
    {
      AppMethodBeat.i(205826);
      if (!this.thq.tgX)
      {
        int j = this.thq.getTagLayout().tgN.size();
        this.thq.getFoldedView().clear();
        int i = 1;
        View localView;
        while (i < j)
        {
          localObject = this.thq.getTagLayout().tgN.get(i);
          p.g(localObject, "tagLayout.mAllViews[i]");
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localView = (View)((Iterator)localObject).next();
            this.thq.getFoldedView().add(localView);
          }
          i += 1;
        }
        Object localObject = ((Iterable)this.thq.getFoldedView()).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localView = (View)((Iterator)localObject).next();
          this.thq.getTagLayout().removeView(localView);
        }
        this.thq.setFolded(true);
        this.thq.cQh();
        localObject = this.thq.getOnFlodListener();
        if (localObject != null)
        {
          ((d.g.a.a)localObject).invoke();
          AppMethodBeat.o(205826);
          return;
        }
      }
      AppMethodBeat.o(205826);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class f
    implements View.OnClickListener
  {
    public f(FinderTagView paramFinderTagView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205828);
      Object localObject1 = new b();
      ((b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderTagView$genItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).ahF());
      localObject1 = FinderTagView.thj;
      localObject1 = paramView.getTag(FinderTagView.cQj());
      if (localObject1 == null)
      {
        paramView = new v("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(205828);
        throw paramView;
      }
      boolean bool = ((Boolean)localObject1).booleanValue();
      localObject1 = new y.d();
      Object localObject2 = FinderTagView.thj;
      paramView = paramView.getTag(FinderTagView.cQk());
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(205828);
        throw paramView;
      }
      ((y.d)localObject1).NiW = ((Integer)paramView).intValue();
      int j = this.thq.getAllAddViews().size();
      int i = 0;
      if (i < j)
      {
        if (i == ((y.d)localObject1).NiW)
        {
          paramView = this.thq;
          localObject2 = this.thq.getAllAddViews().get(i);
          p.g(localObject2, "allAddViews[i]");
          FinderTagView.a(paramView, true, (View)localObject2);
        }
        for (;;)
        {
          i += 1;
          break;
          paramView = this.thq;
          localObject2 = this.thq.getAllAddViews().get(i);
          p.g(localObject2, "allAddViews[i]");
          FinderTagView.a(paramView, false, (View)localObject2);
        }
      }
      if (!bool) {
        new aq().postUI((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(205827);
            FinderTagView localFinderTagView = this.thr.thq;
            Object localObject = this.thr.thq.getTagData().HEO.get(this.ths.NiW);
            p.g(localObject, "tagData.topic_list[indexClick]");
            FinderTagView.a(localFinderTagView, (asv)localObject);
            AppMethodBeat.o(205827);
          }
        });
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderTagView$genItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(205828);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(FinderTagView paramFinderTagView) {}
    
    public final void run()
    {
      AppMethodBeat.i(205829);
      if ((this.thq.getTagLayout().tgN.size() <= 1) && (this.thq.getFoldedView().isEmpty()))
      {
        this.thq.mx(false);
        AppMethodBeat.o(205829);
        return;
      }
      if (!this.thq.tgX)
      {
        if (this.thq.getConfig().tho)
        {
          this.thq.getOpBtn().setRotation(-90.0F);
          this.thq.getOpBtn().setOnClickListener((View.OnClickListener)this.thq.getFlodListener());
          this.thq.mx(true);
          AppMethodBeat.o(205829);
          return;
        }
        this.thq.mx(false);
        AppMethodBeat.o(205829);
        return;
      }
      this.thq.mx(true);
      this.thq.getOpBtn().setRotation(90.0F);
      this.thq.getOpBtn().setOnClickListener((View.OnClickListener)this.thq.getExpandListener());
      AppMethodBeat.o(205829);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderTagView
 * JD-Core Version:    0.7.0.1
 */