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
import com.tencent.mm.protocal.protobuf.dzw;
import com.tencent.mm.protocal.protobuf.ebq;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.a.a;
import d.g.b.k;
import d.g.b.v.c;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "allAddViews", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "getAllAddViews", "()Ljava/util/ArrayList;", "setAllAddViews", "(Ljava/util/ArrayList;)V", "value", "Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;", "config", "getConfig", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;", "setConfig", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;)V", "expandListener", "Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;", "getExpandListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;", "setExpandListener", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;)V", "flodListener", "Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;", "getFlodListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;", "setFlodListener", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;)V", "foldedView", "getFoldedView", "setFoldedView", "hasExpandBtn", "", "getHasExpandBtn", "()I", "setHasExpandBtn", "(I)V", "isClickExpand", "setClickExpand", "isFolded", "", "()Z", "setFolded", "(Z)V", "onExpandListener", "Lkotlin/Function0;", "", "getOnExpandListener", "()Lkotlin/jvm/functions/Function0;", "setOnExpandListener", "(Lkotlin/jvm/functions/Function0;)V", "onFlodListener", "getOnFlodListener", "setOnFlodListener", "opBtn", "getOpBtn", "()Landroid/view/View;", "setOpBtn", "(Landroid/view/View;)V", "root", "getRoot", "setRoot", "selectedIndex", "getSelectedIndex", "setSelectedIndex", "tagClickMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getTagClickMap", "()Ljava/util/HashMap;", "setTagClickMap", "(Ljava/util/HashMap;)V", "tagData", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTagData", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setTagData", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "tagLayout", "Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;", "getTagLayout", "()Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;", "setTagLayout", "(Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;)V", "addDummyTag", "tags", "addTags", "expandTags", "flodTags", "genItemView", "tag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "index", "init", "notiftyTagClick", "refreshOpBtn", "setTagState", "selected", "view", "showOrDimissOpBtn", "show", "Companion", "Config", "expandOnClickListener", "flodOnClickListener", "plugin-finder_release"})
public final class FinderTagView
  extends RelativeLayout
{
  public static final long LfA = -1L;
  public static final a LfB;
  private static final int Lfx = -1;
  private static final int Lfy = -2;
  private static final int Lfz;
  public FinderTagFlowLayout Lfj;
  public View Lfk;
  ArrayList<View> Lfl;
  public ArrayList<View> Lfm;
  public HashMap<Long, Integer> Lfn;
  public ebq Lfo;
  boolean Lfp;
  private a<d.y> Lfq;
  a<d.y> Lfr;
  private int Lfs;
  public int Lft;
  private b Lfu;
  private c Lfv;
  private d Lfw;
  private int boX;
  public View frN;
  
  static
  {
    AppMethodBeat.i(200159);
    LfB = new a((byte)0);
    Lfx = -1;
    Lfy = -2;
    Lfz = 2131307329;
    LfA = -1L;
    AppMethodBeat.o(200159);
  }
  
  public FinderTagView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(200157);
    this.Lfl = new ArrayList();
    this.Lfm = new ArrayList();
    this.boX = -1;
    this.Lfn = new HashMap();
    this.Lfu = new b();
    this.Lfv = new c(this);
    this.Lfw = new d(this);
    init(paramContext);
    AppMethodBeat.o(200157);
  }
  
  public FinderTagView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200158);
    this.Lfl = new ArrayList();
    this.Lfm = new ArrayList();
    this.boX = -1;
    this.Lfn = new HashMap();
    this.Lfu = new b();
    this.Lfv = new c(this);
    this.Lfw = new d(this);
    init(paramContext);
    AppMethodBeat.o(200158);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(200152);
    View localView = com.tencent.mm.ui.y.js(paramContext).inflate(2131496227, (ViewGroup)this);
    k.g(localView, "MMLayoutInflater.getInfl…chinetab_tag_layout,this)");
    this.frN = localView;
    localView = this.frN;
    if (localView == null) {
      k.aPZ("root");
    }
    localView = localView.findViewById(2131307340);
    k.g(localView, "root.findViewById(R.id.finder_machine_tag_layout)");
    this.Lfj = ((FinderTagFlowLayout)localView);
    localView = this.frN;
    if (localView == null) {
      k.aPZ("root");
    }
    localView = localView.findViewById(2131307342);
    k.g(localView, "root.findViewById(R.id.finder_machine_tag_op_icon)");
    this.Lfk = localView;
    if (paramContext == null) {
      k.fvU();
    }
    setBackgroundColor(paramContext.getResources().getColor(this.Lfu.bg));
    AppMethodBeat.o(200152);
  }
  
  public final void a(boolean paramBoolean, View paramView, int paramInt)
  {
    AppMethodBeat.i(200156);
    if (paramInt >= 0) {
      paramView.setTag(Lfy, Integer.valueOf(paramInt));
    }
    paramView.setTag(Lfx, Boolean.valueOf(paramBoolean));
    paramView = (TextView)paramView.findViewById(2131307338);
    if (paramBoolean)
    {
      localObject = this.frN;
      if (localObject == null) {
        k.aPZ("root");
      }
      localObject = ((View)localObject).getContext();
      k.g(localObject, "root.context");
      paramView.setTextColor(((Context)localObject).getResources().getColor(this.Lfu.LfF));
      paramView.setBackgroundResource(this.Lfu.LfD);
      AppMethodBeat.o(200156);
      return;
    }
    Object localObject = this.frN;
    if (localObject == null) {
      k.aPZ("root");
    }
    localObject = ((View)localObject).getContext();
    k.g(localObject, "root.context");
    paramView.setTextColor(((Context)localObject).getResources().getColor(this.Lfu.LfE));
    paramView.setBackgroundResource(this.Lfu.LfC);
    AppMethodBeat.o(200156);
  }
  
  public final void fWS()
  {
    AppMethodBeat.i(200153);
    FinderTagFlowLayout localFinderTagFlowLayout = this.Lfj;
    if (localFinderTagFlowLayout == null) {
      k.aPZ("tagLayout");
    }
    localFinderTagFlowLayout.post((Runnable)new g(this));
    AppMethodBeat.o(200153);
  }
  
  public final void fWT()
  {
    AppMethodBeat.i(200155);
    FinderTagFlowLayout localFinderTagFlowLayout = this.Lfj;
    if (localFinderTagFlowLayout == null) {
      k.aPZ("tagLayout");
    }
    localFinderTagFlowLayout.post((Runnable)new e(this));
    AppMethodBeat.o(200155);
  }
  
  public final ArrayList<View> getAllAddViews()
  {
    return this.Lfm;
  }
  
  public final b getConfig()
  {
    return this.Lfu;
  }
  
  public final c getExpandListener()
  {
    return this.Lfv;
  }
  
  public final d getFlodListener()
  {
    return this.Lfw;
  }
  
  public final ArrayList<View> getFoldedView()
  {
    return this.Lfl;
  }
  
  public final int getHasExpandBtn()
  {
    return this.Lfs;
  }
  
  public final a<d.y> getOnExpandListener()
  {
    return this.Lfr;
  }
  
  public final a<d.y> getOnFlodListener()
  {
    return this.Lfq;
  }
  
  public final View getOpBtn()
  {
    AppMethodBeat.i(200140);
    View localView = this.Lfk;
    if (localView == null) {
      k.aPZ("opBtn");
    }
    AppMethodBeat.o(200140);
    return localView;
  }
  
  public final View getRoot()
  {
    AppMethodBeat.i(200147);
    View localView = this.frN;
    if (localView == null) {
      k.aPZ("root");
    }
    AppMethodBeat.o(200147);
    return localView;
  }
  
  public final int getSelectedIndex()
  {
    return this.boX;
  }
  
  public final HashMap<Long, Integer> getTagClickMap()
  {
    return this.Lfn;
  }
  
  public final ebq getTagData()
  {
    AppMethodBeat.i(200145);
    ebq localebq = this.Lfo;
    if (localebq == null) {
      k.aPZ("tagData");
    }
    AppMethodBeat.o(200145);
    return localebq;
  }
  
  public final FinderTagFlowLayout getTagLayout()
  {
    AppMethodBeat.i(200138);
    FinderTagFlowLayout localFinderTagFlowLayout = this.Lfj;
    if (localFinderTagFlowLayout == null) {
      k.aPZ("tagLayout");
    }
    AppMethodBeat.o(200138);
    return localFinderTagFlowLayout;
  }
  
  public final void setAllAddViews(ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(200143);
    k.h(paramArrayList, "<set-?>");
    this.Lfm = paramArrayList;
    AppMethodBeat.o(200143);
  }
  
  public final void setClickExpand(int paramInt)
  {
    this.Lft = paramInt;
  }
  
  public final void setConfig(b paramb)
  {
    AppMethodBeat.i(200149);
    k.h(paramb, "value");
    Context localContext = getContext();
    if (localContext == null) {
      k.fvU();
    }
    setBackgroundColor(localContext.getResources().getColor(paramb.bg));
    AppMethodBeat.o(200149);
  }
  
  public final void setExpandListener(c paramc)
  {
    AppMethodBeat.i(200150);
    k.h(paramc, "<set-?>");
    this.Lfv = paramc;
    AppMethodBeat.o(200150);
  }
  
  public final void setFlodListener(d paramd)
  {
    AppMethodBeat.i(200151);
    k.h(paramd, "<set-?>");
    this.Lfw = paramd;
    AppMethodBeat.o(200151);
  }
  
  public final void setFolded(boolean paramBoolean)
  {
    this.Lfp = paramBoolean;
  }
  
  public final void setFoldedView(ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(200142);
    k.h(paramArrayList, "<set-?>");
    this.Lfl = paramArrayList;
    AppMethodBeat.o(200142);
  }
  
  public final void setHasExpandBtn(int paramInt)
  {
    this.Lfs = paramInt;
  }
  
  public final void setOnExpandListener(a<d.y> parama)
  {
    this.Lfr = parama;
  }
  
  public final void setOnFlodListener(a<d.y> parama)
  {
    this.Lfq = parama;
  }
  
  public final void setOpBtn(View paramView)
  {
    AppMethodBeat.i(200141);
    k.h(paramView, "<set-?>");
    this.Lfk = paramView;
    AppMethodBeat.o(200141);
  }
  
  public final void setRoot(View paramView)
  {
    AppMethodBeat.i(200148);
    k.h(paramView, "<set-?>");
    this.frN = paramView;
    AppMethodBeat.o(200148);
  }
  
  public final void setSelectedIndex(int paramInt)
  {
    this.boX = paramInt;
  }
  
  public final void setTagClickMap(HashMap<Long, Integer> paramHashMap)
  {
    AppMethodBeat.i(200144);
    k.h(paramHashMap, "<set-?>");
    this.Lfn = paramHashMap;
    AppMethodBeat.o(200144);
  }
  
  public final void setTagData(ebq paramebq)
  {
    AppMethodBeat.i(200146);
    k.h(paramebq, "<set-?>");
    this.Lfo = paramebq;
    AppMethodBeat.o(200146);
  }
  
  public final void setTagLayout(FinderTagFlowLayout paramFinderTagFlowLayout)
  {
    AppMethodBeat.i(200139);
    k.h(paramFinderTagFlowLayout, "<set-?>");
    this.Lfj = paramFinderTagFlowLayout;
    AppMethodBeat.o(200139);
  }
  
  public final void yQ(boolean paramBoolean)
  {
    AppMethodBeat.i(200154);
    if (paramBoolean)
    {
      this.Lfs = 1;
      localView = this.Lfk;
      if (localView == null) {
        k.aPZ("opBtn");
      }
      localView.setVisibility(0);
      localView = findViewById(2131307341);
      k.g(localView, "findViewById<View>(R.id.finder_machine_tag_op_bg)");
      localView.setVisibility(0);
      localView = findViewById(2131307339);
      k.g(localView, "findViewById<View>(R.id.finder_machine_op_layout)");
      localView.setVisibility(0);
      AppMethodBeat.o(200154);
      return;
    }
    View localView = this.Lfk;
    if (localView == null) {
      k.aPZ("opBtn");
    }
    localView.setOnClickListener(null);
    localView = this.Lfk;
    if (localView == null) {
      k.aPZ("opBtn");
    }
    localView.setVisibility(8);
    localView = findViewById(2131307341);
    k.g(localView, "findViewById<View>(R.id.finder_machine_tag_op_bg)");
    localView.setVisibility(8);
    localView = findViewById(2131307339);
    k.g(localView, "findViewById<View>(R.id.finder_machine_op_layout)");
    localView.setVisibility(8);
    AppMethodBeat.o(200154);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$Companion;", "", "()V", "FLOAT_VIEW_ID", "", "getFLOAT_VIEW_ID", "()I", "TAG", "", "TAG_ALL_TOPIC_ID", "", "getTAG_ALL_TOPIC_ID", "()J", "TAG_VIEW_INDEX", "getTAG_VIEW_INDEX", "TAG_VIEW_SELECTED_STATE", "getTAG_VIEW_SELECTED_STATE", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;", "", "()V", "bg", "", "getBg", "()I", "setBg", "(I)V", "canFoldAfterExpand", "", "getCanFoldAfterExpand", "()Z", "setCanFoldAfterExpand", "(Z)V", "itemNormalBg", "getItemNormalBg", "setItemNormalBg", "itemSelectedBg", "getItemSelectedBg", "setItemSelectedBg", "itemTextNormalColor", "getItemTextNormalColor", "setItemTextNormalColor", "itemTextSelectedColor", "getItemTextSelectedColor", "setItemTextSelectedColor", "plugin-finder_release"})
  public static final class b
  {
    int LfC = 2131234875;
    int LfD = 2131234876;
    int LfE = 2131100711;
    int LfF = 2131101182;
    boolean LfG = true;
    int bg = 2131099650;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;", "Landroid/view/View$OnClickListener;", "tagView", "Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView;Lcom/tencent/mm/plugin/finder/view/FinderTagView;)V", "getTagView", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public final class c
    implements View.OnClickListener
  {
    private final FinderTagView LfH;
    
    public c()
    {
      AppMethodBeat.i(200131);
      this.LfH = localObject;
      AppMethodBeat.o(200131);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200130);
      paramView = this.LfH;
      if (paramView.Lfp)
      {
        Iterator localIterator = ((Iterable)paramView.Lfl).iterator();
        while (localIterator.hasNext())
        {
          View localView = (View)localIterator.next();
          FinderTagFlowLayout localFinderTagFlowLayout = paramView.Lfj;
          if (localFinderTagFlowLayout == null) {
            k.aPZ("tagLayout");
          }
          localFinderTagFlowLayout.addView(localView);
        }
        paramView.Lfl.clear();
        paramView.Lfp = false;
        paramView.fWS();
        paramView = paramView.Lfr;
        if (paramView != null) {
          paramView.invoke();
        }
      }
      FinderTagView.this.setClickExpand(1);
      AppMethodBeat.o(200130);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;", "Landroid/view/View$OnClickListener;", "tagView", "Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView;)V", "getTagView", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class d
    implements View.OnClickListener
  {
    private final FinderTagView LfH;
    
    public d(FinderTagView paramFinderTagView)
    {
      AppMethodBeat.i(200133);
      this.LfH = paramFinderTagView;
      AppMethodBeat.o(200133);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200132);
      this.LfH.fWT();
      this.LfH.fWS();
      AppMethodBeat.o(200132);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(FinderTagView paramFinderTagView) {}
    
    public final void run()
    {
      AppMethodBeat.i(200134);
      if (!this.LfI.Lfp)
      {
        int j = this.LfI.getTagLayout().qXQ.size();
        this.LfI.getFoldedView().clear();
        int i = 1;
        View localView;
        while (i < j)
        {
          localObject = this.LfI.getTagLayout().qXQ.get(i);
          k.g(localObject, "tagLayout.mAllViews[i]");
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localView = (View)((Iterator)localObject).next();
            this.LfI.getFoldedView().add(localView);
          }
          i += 1;
        }
        Object localObject = ((Iterable)this.LfI.getFoldedView()).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localView = (View)((Iterator)localObject).next();
          this.LfI.getTagLayout().removeView(localView);
        }
        this.LfI.setFolded(true);
        this.LfI.fWS();
        localObject = this.LfI.getOnFlodListener();
        if (localObject != null)
        {
          ((a)localObject).invoke();
          AppMethodBeat.o(200134);
          return;
        }
      }
      AppMethodBeat.o(200134);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class f
    implements View.OnClickListener
  {
    public f(FinderTagView paramFinderTagView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200136);
      Object localObject1 = FinderTagView.LfB;
      localObject1 = paramView.getTag(FinderTagView.fWU());
      if (localObject1 == null)
      {
        paramView = new v("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(200136);
        throw paramView;
      }
      boolean bool = ((Boolean)localObject1).booleanValue();
      localObject1 = new v.c();
      Object localObject2 = FinderTagView.LfB;
      paramView = paramView.getTag(FinderTagView.fWV());
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(200136);
        throw paramView;
      }
      ((v.c)localObject1).Jhu = ((Integer)paramView).intValue();
      int j = this.LfI.getAllAddViews().size();
      int i = 0;
      if (i < j)
      {
        if (i == ((v.c)localObject1).Jhu)
        {
          paramView = this.LfI;
          localObject2 = this.LfI.getAllAddViews().get(i);
          k.g(localObject2, "allAddViews[i]");
          FinderTagView.a(paramView, true, (View)localObject2);
        }
        for (;;)
        {
          i += 1;
          break;
          paramView = this.LfI;
          localObject2 = this.LfI.getAllAddViews().get(i);
          k.g(localObject2, "allAddViews[i]");
          FinderTagView.a(paramView, false, (View)localObject2);
        }
      }
      if (!bool) {
        new ap().postUI((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(200135);
            FinderTagView localFinderTagView = this.LfJ.LfI;
            Object localObject = this.LfJ.LfI.getTagData().LAk.get(this.LfK.Jhu);
            k.g(localObject, "tagData.topic_list[indexClick]");
            FinderTagView.a(localFinderTagView, (dzw)localObject);
            AppMethodBeat.o(200135);
          }
        });
      }
      AppMethodBeat.o(200136);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(FinderTagView paramFinderTagView) {}
    
    public final void run()
    {
      AppMethodBeat.i(200137);
      if ((this.LfI.getTagLayout().qXQ.size() <= 1) && (this.LfI.getFoldedView().isEmpty()))
      {
        this.LfI.yQ(false);
        AppMethodBeat.o(200137);
        return;
      }
      if (!this.LfI.Lfp)
      {
        if (this.LfI.getConfig().LfG)
        {
          this.LfI.getOpBtn().setRotation(-90.0F);
          this.LfI.getOpBtn().setOnClickListener((View.OnClickListener)this.LfI.getFlodListener());
          this.LfI.yQ(true);
          AppMethodBeat.o(200137);
          return;
        }
        this.LfI.yQ(false);
        AppMethodBeat.o(200137);
        return;
      }
      this.LfI.yQ(true);
      this.LfI.getOpBtn().setRotation(90.0F);
      this.LfI.getOpBtn().setOnClickListener((View.OnClickListener)this.LfI.getExpandListener());
      AppMethodBeat.o(200137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderTagView
 * JD-Core Version:    0.7.0.1
 */