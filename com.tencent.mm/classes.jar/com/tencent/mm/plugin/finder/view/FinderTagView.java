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
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.cnx;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.z;
import d.g.a.a;
import d.g.b.k;
import d.g.b.v.d;
import d.l;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "allAddViews", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "getAllAddViews", "()Ljava/util/ArrayList;", "setAllAddViews", "(Ljava/util/ArrayList;)V", "value", "Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;", "config", "getConfig", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;", "setConfig", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;)V", "expandListener", "Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;", "getExpandListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;", "setExpandListener", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;)V", "flodListener", "Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;", "getFlodListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;", "setFlodListener", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;)V", "foldedView", "getFoldedView", "setFoldedView", "hasExpandBtn", "", "getHasExpandBtn", "()I", "setHasExpandBtn", "(I)V", "isClickExpand", "setClickExpand", "isFolded", "", "()Z", "setFolded", "(Z)V", "onExpandListener", "Lkotlin/Function0;", "", "getOnExpandListener", "()Lkotlin/jvm/functions/Function0;", "setOnExpandListener", "(Lkotlin/jvm/functions/Function0;)V", "onFlodListener", "getOnFlodListener", "setOnFlodListener", "opBtn", "getOpBtn", "()Landroid/view/View;", "setOpBtn", "(Landroid/view/View;)V", "root", "getRoot", "setRoot", "selectedIndex", "getSelectedIndex", "setSelectedIndex", "tagClickMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getTagClickMap", "()Ljava/util/HashMap;", "setTagClickMap", "(Ljava/util/HashMap;)V", "tagData", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTagData", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setTagData", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "tagLayout", "Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;", "getTagLayout", "()Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;", "setTagLayout", "(Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;)V", "addDummyTag", "tags", "addTags", "expandTags", "flodTags", "genItemView", "tag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "index", "init", "notiftyTagClick", "refreshOpBtn", "setTagState", "selected", "view", "showOrDimissOpBtn", "show", "Companion", "Config", "expandOnClickListener", "flodOnClickListener", "plugin-finder_release"})
public final class FinderTagView
  extends RelativeLayout
{
  private static final int rYS = -1;
  private static final int rYT = -2;
  private static final int rYU;
  public static final long rYV = -1L;
  public static final FinderTagView.a rYW;
  private int bns;
  public View fvu;
  public FinderTagFlowLayout rYE;
  public View rYF;
  ArrayList<View> rYG;
  public ArrayList<View> rYH;
  public HashMap<Long, Integer> rYI;
  public cnx rYJ;
  boolean rYK;
  private a<y> rYL;
  a<y> rYM;
  private int rYN;
  public int rYO;
  private b rYP;
  private c rYQ;
  private d rYR;
  
  static
  {
    AppMethodBeat.i(204229);
    rYW = new FinderTagView.a((byte)0);
    rYS = -1;
    rYT = -2;
    rYU = 2131307398;
    rYV = -1L;
    AppMethodBeat.o(204229);
  }
  
  public FinderTagView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(204227);
    this.rYG = new ArrayList();
    this.rYH = new ArrayList();
    this.bns = -1;
    this.rYI = new HashMap();
    this.rYP = new b();
    this.rYQ = new c(this);
    this.rYR = new d(this);
    init(paramContext);
    AppMethodBeat.o(204227);
  }
  
  public FinderTagView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(204228);
    this.rYG = new ArrayList();
    this.rYH = new ArrayList();
    this.bns = -1;
    this.rYI = new HashMap();
    this.rYP = new b();
    this.rYQ = new c(this);
    this.rYR = new d(this);
    init(paramContext);
    AppMethodBeat.o(204228);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(204222);
    View localView = z.jD(paramContext).inflate(2131496228, (ViewGroup)this);
    k.g(localView, "MMLayoutInflater.getInfl…chinetab_tag_layout,this)");
    this.fvu = localView;
    localView = this.fvu;
    if (localView == null) {
      k.aVY("root");
    }
    localView = localView.findViewById(2131307409);
    k.g(localView, "root.findViewById(R.id.finder_machine_tag_layout)");
    this.rYE = ((FinderTagFlowLayout)localView);
    localView = this.fvu;
    if (localView == null) {
      k.aVY("root");
    }
    localView = localView.findViewById(2131307411);
    k.g(localView, "root.findViewById(R.id.finder_machine_tag_op_icon)");
    this.rYF = localView;
    if (paramContext == null) {
      k.fOy();
    }
    setBackgroundColor(paramContext.getResources().getColor(this.rYP.bg));
    AppMethodBeat.o(204222);
  }
  
  public final void a(boolean paramBoolean, View paramView, int paramInt)
  {
    AppMethodBeat.i(204226);
    if (paramInt >= 0) {
      paramView.setTag(rYT, Integer.valueOf(paramInt));
    }
    paramView.setTag(rYS, Boolean.valueOf(paramBoolean));
    paramView = (TextView)paramView.findViewById(2131307407);
    if (paramBoolean)
    {
      localObject = this.fvu;
      if (localObject == null) {
        k.aVY("root");
      }
      localObject = ((View)localObject).getContext();
      k.g(localObject, "root.context");
      paramView.setTextColor(((Context)localObject).getResources().getColor(this.rYP.rZa));
      paramView.setBackgroundResource(this.rYP.rYY);
      AppMethodBeat.o(204226);
      return;
    }
    Object localObject = this.fvu;
    if (localObject == null) {
      k.aVY("root");
    }
    localObject = ((View)localObject).getContext();
    k.g(localObject, "root.context");
    paramView.setTextColor(((Context)localObject).getResources().getColor(this.rYP.rYZ));
    paramView.setBackgroundResource(this.rYP.rYX);
    AppMethodBeat.o(204226);
  }
  
  public final void cFd()
  {
    AppMethodBeat.i(204223);
    FinderTagFlowLayout localFinderTagFlowLayout = this.rYE;
    if (localFinderTagFlowLayout == null) {
      k.aVY("tagLayout");
    }
    localFinderTagFlowLayout.post((Runnable)new g(this));
    AppMethodBeat.o(204223);
  }
  
  public final void cFe()
  {
    AppMethodBeat.i(204225);
    FinderTagFlowLayout localFinderTagFlowLayout = this.rYE;
    if (localFinderTagFlowLayout == null) {
      k.aVY("tagLayout");
    }
    localFinderTagFlowLayout.post((Runnable)new e(this));
    AppMethodBeat.o(204225);
  }
  
  public final ArrayList<View> getAllAddViews()
  {
    return this.rYH;
  }
  
  public final b getConfig()
  {
    return this.rYP;
  }
  
  public final c getExpandListener()
  {
    return this.rYQ;
  }
  
  public final d getFlodListener()
  {
    return this.rYR;
  }
  
  public final ArrayList<View> getFoldedView()
  {
    return this.rYG;
  }
  
  public final int getHasExpandBtn()
  {
    return this.rYN;
  }
  
  public final a<y> getOnExpandListener()
  {
    return this.rYM;
  }
  
  public final a<y> getOnFlodListener()
  {
    return this.rYL;
  }
  
  public final View getOpBtn()
  {
    AppMethodBeat.i(204210);
    View localView = this.rYF;
    if (localView == null) {
      k.aVY("opBtn");
    }
    AppMethodBeat.o(204210);
    return localView;
  }
  
  public final View getRoot()
  {
    AppMethodBeat.i(204217);
    View localView = this.fvu;
    if (localView == null) {
      k.aVY("root");
    }
    AppMethodBeat.o(204217);
    return localView;
  }
  
  public final int getSelectedIndex()
  {
    return this.bns;
  }
  
  public final HashMap<Long, Integer> getTagClickMap()
  {
    return this.rYI;
  }
  
  public final cnx getTagData()
  {
    AppMethodBeat.i(204215);
    cnx localcnx = this.rYJ;
    if (localcnx == null) {
      k.aVY("tagData");
    }
    AppMethodBeat.o(204215);
    return localcnx;
  }
  
  public final FinderTagFlowLayout getTagLayout()
  {
    AppMethodBeat.i(204208);
    FinderTagFlowLayout localFinderTagFlowLayout = this.rYE;
    if (localFinderTagFlowLayout == null) {
      k.aVY("tagLayout");
    }
    AppMethodBeat.o(204208);
    return localFinderTagFlowLayout;
  }
  
  public final void ma(boolean paramBoolean)
  {
    AppMethodBeat.i(204224);
    if (paramBoolean)
    {
      this.rYN = 1;
      localView = this.rYF;
      if (localView == null) {
        k.aVY("opBtn");
      }
      localView.setVisibility(0);
      localView = findViewById(2131307410);
      k.g(localView, "findViewById<View>(R.id.finder_machine_tag_op_bg)");
      localView.setVisibility(0);
      localView = findViewById(2131307408);
      k.g(localView, "findViewById<View>(R.id.finder_machine_op_layout)");
      localView.setVisibility(0);
      AppMethodBeat.o(204224);
      return;
    }
    View localView = this.rYF;
    if (localView == null) {
      k.aVY("opBtn");
    }
    localView.setOnClickListener(null);
    localView = this.rYF;
    if (localView == null) {
      k.aVY("opBtn");
    }
    localView.setVisibility(8);
    localView = findViewById(2131307410);
    k.g(localView, "findViewById<View>(R.id.finder_machine_tag_op_bg)");
    localView.setVisibility(8);
    localView = findViewById(2131307408);
    k.g(localView, "findViewById<View>(R.id.finder_machine_op_layout)");
    localView.setVisibility(8);
    AppMethodBeat.o(204224);
  }
  
  public final void setAllAddViews(ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(204213);
    k.h(paramArrayList, "<set-?>");
    this.rYH = paramArrayList;
    AppMethodBeat.o(204213);
  }
  
  public final void setClickExpand(int paramInt)
  {
    this.rYO = paramInt;
  }
  
  public final void setConfig(b paramb)
  {
    AppMethodBeat.i(204219);
    k.h(paramb, "value");
    Context localContext = getContext();
    if (localContext == null) {
      k.fOy();
    }
    setBackgroundColor(localContext.getResources().getColor(paramb.bg));
    AppMethodBeat.o(204219);
  }
  
  public final void setExpandListener(c paramc)
  {
    AppMethodBeat.i(204220);
    k.h(paramc, "<set-?>");
    this.rYQ = paramc;
    AppMethodBeat.o(204220);
  }
  
  public final void setFlodListener(d paramd)
  {
    AppMethodBeat.i(204221);
    k.h(paramd, "<set-?>");
    this.rYR = paramd;
    AppMethodBeat.o(204221);
  }
  
  public final void setFolded(boolean paramBoolean)
  {
    this.rYK = paramBoolean;
  }
  
  public final void setFoldedView(ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(204212);
    k.h(paramArrayList, "<set-?>");
    this.rYG = paramArrayList;
    AppMethodBeat.o(204212);
  }
  
  public final void setHasExpandBtn(int paramInt)
  {
    this.rYN = paramInt;
  }
  
  public final void setOnExpandListener(a<y> parama)
  {
    this.rYM = parama;
  }
  
  public final void setOnFlodListener(a<y> parama)
  {
    this.rYL = parama;
  }
  
  public final void setOpBtn(View paramView)
  {
    AppMethodBeat.i(204211);
    k.h(paramView, "<set-?>");
    this.rYF = paramView;
    AppMethodBeat.o(204211);
  }
  
  public final void setRoot(View paramView)
  {
    AppMethodBeat.i(204218);
    k.h(paramView, "<set-?>");
    this.fvu = paramView;
    AppMethodBeat.o(204218);
  }
  
  public final void setSelectedIndex(int paramInt)
  {
    this.bns = paramInt;
  }
  
  public final void setTagClickMap(HashMap<Long, Integer> paramHashMap)
  {
    AppMethodBeat.i(204214);
    k.h(paramHashMap, "<set-?>");
    this.rYI = paramHashMap;
    AppMethodBeat.o(204214);
  }
  
  public final void setTagData(cnx paramcnx)
  {
    AppMethodBeat.i(204216);
    k.h(paramcnx, "<set-?>");
    this.rYJ = paramcnx;
    AppMethodBeat.o(204216);
  }
  
  public final void setTagLayout(FinderTagFlowLayout paramFinderTagFlowLayout)
  {
    AppMethodBeat.i(204209);
    k.h(paramFinderTagFlowLayout, "<set-?>");
    this.rYE = paramFinderTagFlowLayout;
    AppMethodBeat.o(204209);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;", "", "()V", "bg", "", "getBg", "()I", "setBg", "(I)V", "canFoldAfterExpand", "", "getCanFoldAfterExpand", "()Z", "setCanFoldAfterExpand", "(Z)V", "itemNormalBg", "getItemNormalBg", "setItemNormalBg", "itemSelectedBg", "getItemSelectedBg", "setItemSelectedBg", "itemTextNormalColor", "getItemTextNormalColor", "setItemTextNormalColor", "itemTextSelectedColor", "getItemTextSelectedColor", "setItemTextSelectedColor", "plugin-finder_release"})
  public static final class b
  {
    int bg = 2131099650;
    int rYX = 2131234879;
    int rYY = 2131234880;
    int rYZ = 2131100711;
    int rZa = 2131101182;
    boolean rZb = true;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;", "Landroid/view/View$OnClickListener;", "tagView", "Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView;Lcom/tencent/mm/plugin/finder/view/FinderTagView;)V", "getTagView", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public final class c
    implements View.OnClickListener
  {
    private final FinderTagView rZc;
    
    public c()
    {
      AppMethodBeat.i(204201);
      this.rZc = localObject;
      AppMethodBeat.o(204201);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204200);
      paramView = this.rZc;
      if (paramView.rYK)
      {
        Iterator localIterator = ((Iterable)paramView.rYG).iterator();
        while (localIterator.hasNext())
        {
          View localView = (View)localIterator.next();
          FinderTagFlowLayout localFinderTagFlowLayout = paramView.rYE;
          if (localFinderTagFlowLayout == null) {
            k.aVY("tagLayout");
          }
          localFinderTagFlowLayout.addView(localView);
        }
        paramView.rYG.clear();
        paramView.rYK = false;
        paramView.cFd();
        paramView = paramView.rYM;
        if (paramView != null) {
          paramView.invoke();
        }
      }
      FinderTagView.this.setClickExpand(1);
      AppMethodBeat.o(204200);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;", "Landroid/view/View$OnClickListener;", "tagView", "Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView;)V", "getTagView", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class d
    implements View.OnClickListener
  {
    private final FinderTagView rZc;
    
    public d(FinderTagView paramFinderTagView)
    {
      AppMethodBeat.i(204203);
      this.rZc = paramFinderTagView;
      AppMethodBeat.o(204203);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204202);
      this.rZc.cFe();
      this.rZc.cFd();
      AppMethodBeat.o(204202);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(FinderTagView paramFinderTagView) {}
    
    public final void run()
    {
      AppMethodBeat.i(204204);
      if (!this.rZd.rYK)
      {
        int j = this.rZd.getTagLayout().rYA.size();
        this.rZd.getFoldedView().clear();
        int i = 1;
        View localView;
        while (i < j)
        {
          localObject = this.rZd.getTagLayout().rYA.get(i);
          k.g(localObject, "tagLayout.mAllViews[i]");
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localView = (View)((Iterator)localObject).next();
            this.rZd.getFoldedView().add(localView);
          }
          i += 1;
        }
        Object localObject = ((Iterable)this.rZd.getFoldedView()).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localView = (View)((Iterator)localObject).next();
          this.rZd.getTagLayout().removeView(localView);
        }
        this.rZd.setFolded(true);
        this.rZd.cFd();
        localObject = this.rZd.getOnFlodListener();
        if (localObject != null)
        {
          ((a)localObject).invoke();
          AppMethodBeat.o(204204);
          return;
        }
      }
      AppMethodBeat.o(204204);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class f
    implements View.OnClickListener
  {
    public f(FinderTagView paramFinderTagView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204206);
      Object localObject1 = FinderTagView.rYW;
      localObject1 = paramView.getTag(FinderTagView.cFf());
      if (localObject1 == null)
      {
        paramView = new v("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(204206);
        throw paramView;
      }
      boolean bool = ((Boolean)localObject1).booleanValue();
      localObject1 = new v.d();
      Object localObject2 = FinderTagView.rYW;
      paramView = paramView.getTag(FinderTagView.cFg());
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(204206);
        throw paramView;
      }
      ((v.d)localObject1).KUO = ((Integer)paramView).intValue();
      int j = this.rZd.getAllAddViews().size();
      int i = 0;
      if (i < j)
      {
        if (i == ((v.d)localObject1).KUO)
        {
          paramView = this.rZd;
          localObject2 = this.rZd.getAllAddViews().get(i);
          k.g(localObject2, "allAddViews[i]");
          FinderTagView.a(paramView, true, (View)localObject2);
        }
        for (;;)
        {
          i += 1;
          break;
          paramView = this.rZd;
          localObject2 = this.rZd.getAllAddViews().get(i);
          k.g(localObject2, "allAddViews[i]");
          FinderTagView.a(paramView, false, (View)localObject2);
        }
      }
      if (!bool) {
        new ao().postUI((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(204205);
            FinderTagView localFinderTagView = this.rZe.rZd;
            Object localObject = this.rZe.rZd.getTagData().FBb.get(this.rZf.KUO);
            k.g(localObject, "tagData.topic_list[indexClick]");
            FinderTagView.a(localFinderTagView, (aop)localObject);
            AppMethodBeat.o(204205);
          }
        });
      }
      AppMethodBeat.o(204206);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(FinderTagView paramFinderTagView) {}
    
    public final void run()
    {
      AppMethodBeat.i(204207);
      if ((this.rZd.getTagLayout().rYA.size() <= 1) && (this.rZd.getFoldedView().isEmpty()))
      {
        this.rZd.ma(false);
        AppMethodBeat.o(204207);
        return;
      }
      if (!this.rZd.rYK)
      {
        if (this.rZd.getConfig().rZb)
        {
          this.rZd.getOpBtn().setRotation(-90.0F);
          this.rZd.getOpBtn().setOnClickListener((View.OnClickListener)this.rZd.getFlodListener());
          this.rZd.ma(true);
          AppMethodBeat.o(204207);
          return;
        }
        this.rZd.ma(false);
        AppMethodBeat.o(204207);
        return;
      }
      this.rZd.ma(true);
      this.rZd.getOpBtn().setRotation(90.0F);
      this.rZd.getOpBtn().setOnClickListener((View.OnClickListener)this.rZd.getExpandListener());
      AppMethodBeat.o(204207);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderTagView
 * JD-Core Version:    0.7.0.1
 */