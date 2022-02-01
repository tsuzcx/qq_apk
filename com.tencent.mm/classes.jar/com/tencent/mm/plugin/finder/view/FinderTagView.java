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
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.p;
import d.g.b.y.d;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "allAddViews", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "getAllAddViews", "()Ljava/util/ArrayList;", "setAllAddViews", "(Ljava/util/ArrayList;)V", "value", "Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;", "config", "getConfig", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;", "setConfig", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;)V", "expandListener", "Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;", "getExpandListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;", "setExpandListener", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;)V", "flodListener", "Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;", "getFlodListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;", "setFlodListener", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;)V", "foldedView", "getFoldedView", "setFoldedView", "hasExpandBtn", "", "getHasExpandBtn", "()I", "setHasExpandBtn", "(I)V", "isClickExpand", "setClickExpand", "isFolded", "", "()Z", "setFolded", "(Z)V", "onExpandListener", "Lkotlin/Function0;", "", "getOnExpandListener", "()Lkotlin/jvm/functions/Function0;", "setOnExpandListener", "(Lkotlin/jvm/functions/Function0;)V", "onFlodListener", "getOnFlodListener", "setOnFlodListener", "opBtn", "getOpBtn", "()Landroid/view/View;", "setOpBtn", "(Landroid/view/View;)V", "root", "getRoot", "setRoot", "selectedIndex", "getSelectedIndex", "setSelectedIndex", "tagClickMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getTagClickMap", "()Ljava/util/HashMap;", "setTagClickMap", "(Ljava/util/HashMap;)V", "tagData", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTagData", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setTagData", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "tagLayout", "Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;", "getTagLayout", "()Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;", "setTagLayout", "(Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;)V", "addDummyTag", "tags", "addTags", "expandTags", "flodTags", "genItemView", "tag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "index", "init", "notiftyTagClick", "refreshOpBtn", "setTagState", "selected", "view", "showOrDimissOpBtn", "show", "Companion", "Config", "expandOnClickListener", "flodOnClickListener", "plugin-finder_release"})
public final class FinderTagView
  extends RelativeLayout
{
  private static final int sVO = -1;
  private static final int sVP = -2;
  private static final int sVQ;
  public static final long sVR = -1L;
  public static final FinderTagView.a sVS;
  private int bxN;
  public View fOB;
  public FinderTagFlowLayout sVA;
  public View sVB;
  ArrayList<View> sVC;
  public ArrayList<View> sVD;
  public HashMap<Long, Integer> sVE;
  public cta sVF;
  boolean sVG;
  private d.g.a.a<d.z> sVH;
  d.g.a.a<d.z> sVI;
  private int sVJ;
  public int sVK;
  private b sVL;
  private c sVM;
  private d sVN;
  
  static
  {
    AppMethodBeat.i(205209);
    sVS = new FinderTagView.a((byte)0);
    sVO = -1;
    sVP = -2;
    sVQ = 2131307398;
    sVR = -1L;
    AppMethodBeat.o(205209);
  }
  
  public FinderTagView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(205207);
    this.sVC = new ArrayList();
    this.sVD = new ArrayList();
    this.bxN = -1;
    this.sVE = new HashMap();
    this.sVL = new b();
    this.sVM = new c(this);
    this.sVN = new d(this);
    init(paramContext);
    AppMethodBeat.o(205207);
  }
  
  public FinderTagView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205208);
    this.sVC = new ArrayList();
    this.sVD = new ArrayList();
    this.bxN = -1;
    this.sVE = new HashMap();
    this.sVL = new b();
    this.sVM = new c(this);
    this.sVN = new d(this);
    init(paramContext);
    AppMethodBeat.o(205208);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(205202);
    View localView = com.tencent.mm.ui.z.jO(paramContext).inflate(2131496228, (ViewGroup)this);
    p.g(localView, "MMLayoutInflater.getInfl…chinetab_tag_layout,this)");
    this.fOB = localView;
    localView = this.fOB;
    if (localView == null) {
      p.bcb("root");
    }
    localView = localView.findViewById(2131307409);
    p.g(localView, "root.findViewById(R.id.finder_machine_tag_layout)");
    this.sVA = ((FinderTagFlowLayout)localView);
    localView = this.fOB;
    if (localView == null) {
      p.bcb("root");
    }
    localView = localView.findViewById(2131307411);
    p.g(localView, "root.findViewById(R.id.finder_machine_tag_op_icon)");
    this.sVB = localView;
    if (paramContext == null) {
      p.gfZ();
    }
    setBackgroundColor(paramContext.getResources().getColor(this.sVL.bg));
    AppMethodBeat.o(205202);
  }
  
  public final void a(boolean paramBoolean, View paramView, int paramInt)
  {
    AppMethodBeat.i(205206);
    if (paramInt >= 0) {
      paramView.setTag(sVP, Integer.valueOf(paramInt));
    }
    paramView.setTag(sVO, Boolean.valueOf(paramBoolean));
    paramView = (TextView)paramView.findViewById(2131307407);
    if (paramBoolean)
    {
      localObject = this.fOB;
      if (localObject == null) {
        p.bcb("root");
      }
      localObject = ((View)localObject).getContext();
      p.g(localObject, "root.context");
      paramView.setTextColor(((Context)localObject).getResources().getColor(this.sVL.sVW));
      paramView.setBackgroundResource(this.sVL.sVU);
      AppMethodBeat.o(205206);
      return;
    }
    Object localObject = this.fOB;
    if (localObject == null) {
      p.bcb("root");
    }
    localObject = ((View)localObject).getContext();
    p.g(localObject, "root.context");
    paramView.setTextColor(((Context)localObject).getResources().getColor(this.sVL.sVV));
    paramView.setBackgroundResource(this.sVL.sVT);
    AppMethodBeat.o(205206);
  }
  
  public final void cNx()
  {
    AppMethodBeat.i(205203);
    FinderTagFlowLayout localFinderTagFlowLayout = this.sVA;
    if (localFinderTagFlowLayout == null) {
      p.bcb("tagLayout");
    }
    localFinderTagFlowLayout.post((Runnable)new g(this));
    AppMethodBeat.o(205203);
  }
  
  public final void cNy()
  {
    AppMethodBeat.i(205205);
    FinderTagFlowLayout localFinderTagFlowLayout = this.sVA;
    if (localFinderTagFlowLayout == null) {
      p.bcb("tagLayout");
    }
    localFinderTagFlowLayout.post((Runnable)new e(this));
    AppMethodBeat.o(205205);
  }
  
  public final ArrayList<View> getAllAddViews()
  {
    return this.sVD;
  }
  
  public final b getConfig()
  {
    return this.sVL;
  }
  
  public final c getExpandListener()
  {
    return this.sVM;
  }
  
  public final d getFlodListener()
  {
    return this.sVN;
  }
  
  public final ArrayList<View> getFoldedView()
  {
    return this.sVC;
  }
  
  public final int getHasExpandBtn()
  {
    return this.sVJ;
  }
  
  public final d.g.a.a<d.z> getOnExpandListener()
  {
    return this.sVI;
  }
  
  public final d.g.a.a<d.z> getOnFlodListener()
  {
    return this.sVH;
  }
  
  public final View getOpBtn()
  {
    AppMethodBeat.i(205190);
    View localView = this.sVB;
    if (localView == null) {
      p.bcb("opBtn");
    }
    AppMethodBeat.o(205190);
    return localView;
  }
  
  public final View getRoot()
  {
    AppMethodBeat.i(205197);
    View localView = this.fOB;
    if (localView == null) {
      p.bcb("root");
    }
    AppMethodBeat.o(205197);
    return localView;
  }
  
  public final int getSelectedIndex()
  {
    return this.bxN;
  }
  
  public final HashMap<Long, Integer> getTagClickMap()
  {
    return this.sVE;
  }
  
  public final cta getTagData()
  {
    AppMethodBeat.i(205195);
    cta localcta = this.sVF;
    if (localcta == null) {
      p.bcb("tagData");
    }
    AppMethodBeat.o(205195);
    return localcta;
  }
  
  public final FinderTagFlowLayout getTagLayout()
  {
    AppMethodBeat.i(205188);
    FinderTagFlowLayout localFinderTagFlowLayout = this.sVA;
    if (localFinderTagFlowLayout == null) {
      p.bcb("tagLayout");
    }
    AppMethodBeat.o(205188);
    return localFinderTagFlowLayout;
  }
  
  public final void ms(boolean paramBoolean)
  {
    AppMethodBeat.i(205204);
    if (paramBoolean)
    {
      this.sVJ = 1;
      localView = this.sVB;
      if (localView == null) {
        p.bcb("opBtn");
      }
      localView.setVisibility(0);
      localView = findViewById(2131307410);
      p.g(localView, "findViewById<View>(R.id.finder_machine_tag_op_bg)");
      localView.setVisibility(0);
      localView = findViewById(2131307408);
      p.g(localView, "findViewById<View>(R.id.finder_machine_op_layout)");
      localView.setVisibility(0);
      AppMethodBeat.o(205204);
      return;
    }
    View localView = this.sVB;
    if (localView == null) {
      p.bcb("opBtn");
    }
    localView.setOnClickListener(null);
    localView = this.sVB;
    if (localView == null) {
      p.bcb("opBtn");
    }
    localView.setVisibility(8);
    localView = findViewById(2131307410);
    p.g(localView, "findViewById<View>(R.id.finder_machine_tag_op_bg)");
    localView.setVisibility(8);
    localView = findViewById(2131307408);
    p.g(localView, "findViewById<View>(R.id.finder_machine_op_layout)");
    localView.setVisibility(8);
    AppMethodBeat.o(205204);
  }
  
  public final void setAllAddViews(ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(205193);
    p.h(paramArrayList, "<set-?>");
    this.sVD = paramArrayList;
    AppMethodBeat.o(205193);
  }
  
  public final void setClickExpand(int paramInt)
  {
    this.sVK = paramInt;
  }
  
  public final void setConfig(b paramb)
  {
    AppMethodBeat.i(205199);
    p.h(paramb, "value");
    Context localContext = getContext();
    if (localContext == null) {
      p.gfZ();
    }
    setBackgroundColor(localContext.getResources().getColor(paramb.bg));
    AppMethodBeat.o(205199);
  }
  
  public final void setExpandListener(c paramc)
  {
    AppMethodBeat.i(205200);
    p.h(paramc, "<set-?>");
    this.sVM = paramc;
    AppMethodBeat.o(205200);
  }
  
  public final void setFlodListener(d paramd)
  {
    AppMethodBeat.i(205201);
    p.h(paramd, "<set-?>");
    this.sVN = paramd;
    AppMethodBeat.o(205201);
  }
  
  public final void setFolded(boolean paramBoolean)
  {
    this.sVG = paramBoolean;
  }
  
  public final void setFoldedView(ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(205192);
    p.h(paramArrayList, "<set-?>");
    this.sVC = paramArrayList;
    AppMethodBeat.o(205192);
  }
  
  public final void setHasExpandBtn(int paramInt)
  {
    this.sVJ = paramInt;
  }
  
  public final void setOnExpandListener(d.g.a.a<d.z> parama)
  {
    this.sVI = parama;
  }
  
  public final void setOnFlodListener(d.g.a.a<d.z> parama)
  {
    this.sVH = parama;
  }
  
  public final void setOpBtn(View paramView)
  {
    AppMethodBeat.i(205191);
    p.h(paramView, "<set-?>");
    this.sVB = paramView;
    AppMethodBeat.o(205191);
  }
  
  public final void setRoot(View paramView)
  {
    AppMethodBeat.i(205198);
    p.h(paramView, "<set-?>");
    this.fOB = paramView;
    AppMethodBeat.o(205198);
  }
  
  public final void setSelectedIndex(int paramInt)
  {
    this.bxN = paramInt;
  }
  
  public final void setTagClickMap(HashMap<Long, Integer> paramHashMap)
  {
    AppMethodBeat.i(205194);
    p.h(paramHashMap, "<set-?>");
    this.sVE = paramHashMap;
    AppMethodBeat.o(205194);
  }
  
  public final void setTagData(cta paramcta)
  {
    AppMethodBeat.i(205196);
    p.h(paramcta, "<set-?>");
    this.sVF = paramcta;
    AppMethodBeat.o(205196);
  }
  
  public final void setTagLayout(FinderTagFlowLayout paramFinderTagFlowLayout)
  {
    AppMethodBeat.i(205189);
    p.h(paramFinderTagFlowLayout, "<set-?>");
    this.sVA = paramFinderTagFlowLayout;
    AppMethodBeat.o(205189);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;", "", "()V", "bg", "", "getBg", "()I", "setBg", "(I)V", "canFoldAfterExpand", "", "getCanFoldAfterExpand", "()Z", "setCanFoldAfterExpand", "(Z)V", "itemNormalBg", "getItemNormalBg", "setItemNormalBg", "itemSelectedBg", "getItemSelectedBg", "setItemSelectedBg", "itemTextNormalColor", "getItemTextNormalColor", "setItemTextNormalColor", "itemTextSelectedColor", "getItemTextSelectedColor", "setItemTextSelectedColor", "plugin-finder_release"})
  public static final class b
  {
    int bg = 2131099650;
    int sVT = 2131234879;
    int sVU = 2131234880;
    int sVV = 2131100711;
    int sVW = 2131101182;
    boolean sVX = true;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;", "Landroid/view/View$OnClickListener;", "tagView", "Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView;Lcom/tencent/mm/plugin/finder/view/FinderTagView;)V", "getTagView", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public final class c
    implements View.OnClickListener
  {
    private final FinderTagView sVY;
    
    public c()
    {
      AppMethodBeat.i(205181);
      this.sVY = localObject;
      AppMethodBeat.o(205181);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205180);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      paramView = this.sVY;
      if (paramView.sVG)
      {
        localObject = ((Iterable)paramView.sVC).iterator();
        while (((Iterator)localObject).hasNext())
        {
          View localView = (View)((Iterator)localObject).next();
          FinderTagFlowLayout localFinderTagFlowLayout = paramView.sVA;
          if (localFinderTagFlowLayout == null) {
            p.bcb("tagLayout");
          }
          localFinderTagFlowLayout.addView(localView);
        }
        paramView.sVC.clear();
        paramView.sVG = false;
        paramView.cNx();
        paramView = paramView.sVI;
        if (paramView != null) {
          paramView.invoke();
        }
      }
      FinderTagView.this.setClickExpand(1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(205180);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;", "Landroid/view/View$OnClickListener;", "tagView", "Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView;)V", "getTagView", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class d
    implements View.OnClickListener
  {
    private final FinderTagView sVY;
    
    public d(FinderTagView paramFinderTagView)
    {
      AppMethodBeat.i(205183);
      this.sVY = paramFinderTagView;
      AppMethodBeat.o(205183);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205182);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.sVY.cNy();
      this.sVY.cNx();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(205182);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(FinderTagView paramFinderTagView) {}
    
    public final void run()
    {
      AppMethodBeat.i(205184);
      if (!this.sVZ.sVG)
      {
        int j = this.sVZ.getTagLayout().sVw.size();
        this.sVZ.getFoldedView().clear();
        int i = 1;
        View localView;
        while (i < j)
        {
          localObject = this.sVZ.getTagLayout().sVw.get(i);
          p.g(localObject, "tagLayout.mAllViews[i]");
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localView = (View)((Iterator)localObject).next();
            this.sVZ.getFoldedView().add(localView);
          }
          i += 1;
        }
        Object localObject = ((Iterable)this.sVZ.getFoldedView()).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localView = (View)((Iterator)localObject).next();
          this.sVZ.getTagLayout().removeView(localView);
        }
        this.sVZ.setFolded(true);
        this.sVZ.cNx();
        localObject = this.sVZ.getOnFlodListener();
        if (localObject != null)
        {
          ((d.g.a.a)localObject).invoke();
          AppMethodBeat.o(205184);
          return;
        }
      }
      AppMethodBeat.o(205184);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class f
    implements View.OnClickListener
  {
    public f(FinderTagView paramFinderTagView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205186);
      Object localObject1 = new b();
      ((b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderTagView$genItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).ahq());
      localObject1 = FinderTagView.sVS;
      localObject1 = paramView.getTag(FinderTagView.cNz());
      if (localObject1 == null)
      {
        paramView = new v("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(205186);
        throw paramView;
      }
      boolean bool = ((Boolean)localObject1).booleanValue();
      localObject1 = new y.d();
      Object localObject2 = FinderTagView.sVS;
      paramView = paramView.getTag(FinderTagView.cNA());
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(205186);
        throw paramView;
      }
      ((y.d)localObject1).MLT = ((Integer)paramView).intValue();
      int j = this.sVZ.getAllAddViews().size();
      int i = 0;
      if (i < j)
      {
        if (i == ((y.d)localObject1).MLT)
        {
          paramView = this.sVZ;
          localObject2 = this.sVZ.getAllAddViews().get(i);
          p.g(localObject2, "allAddViews[i]");
          FinderTagView.a(paramView, true, (View)localObject2);
        }
        for (;;)
        {
          i += 1;
          break;
          paramView = this.sVZ;
          localObject2 = this.sVZ.getAllAddViews().get(i);
          p.g(localObject2, "allAddViews[i]");
          FinderTagView.a(paramView, false, (View)localObject2);
        }
      }
      if (!bool) {
        new ap().postUI((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(205185);
            FinderTagView localFinderTagView = this.sWa.sVZ;
            Object localObject = this.sWa.sVZ.getTagData().Hlo.get(this.sWb.MLT);
            p.g(localObject, "tagData.topic_list[indexClick]");
            FinderTagView.a(localFinderTagView, (asg)localObject);
            AppMethodBeat.o(205185);
          }
        });
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderTagView$genItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(205186);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(FinderTagView paramFinderTagView) {}
    
    public final void run()
    {
      AppMethodBeat.i(205187);
      if ((this.sVZ.getTagLayout().sVw.size() <= 1) && (this.sVZ.getFoldedView().isEmpty()))
      {
        this.sVZ.ms(false);
        AppMethodBeat.o(205187);
        return;
      }
      if (!this.sVZ.sVG)
      {
        if (this.sVZ.getConfig().sVX)
        {
          this.sVZ.getOpBtn().setRotation(-90.0F);
          this.sVZ.getOpBtn().setOnClickListener((View.OnClickListener)this.sVZ.getFlodListener());
          this.sVZ.ms(true);
          AppMethodBeat.o(205187);
          return;
        }
        this.sVZ.ms(false);
        AppMethodBeat.o(205187);
        return;
      }
      this.sVZ.ms(true);
      this.sVZ.getOpBtn().setRotation(90.0F);
      this.sVZ.getOpBtn().setOnClickListener((View.OnClickListener)this.sVZ.getExpandListener());
      AppMethodBeat.o(205187);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderTagView
 * JD-Core Version:    0.7.0.1
 */