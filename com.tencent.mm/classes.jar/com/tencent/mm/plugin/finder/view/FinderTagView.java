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
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.protocal.protobuf.dwb;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "allAddViews", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "getAllAddViews", "()Ljava/util/ArrayList;", "setAllAddViews", "(Ljava/util/ArrayList;)V", "value", "Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;", "config", "getConfig", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;", "setConfig", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;)V", "expandListener", "Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;", "getExpandListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;", "setExpandListener", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;)V", "flodListener", "Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;", "getFlodListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;", "setFlodListener", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;)V", "foldedView", "getFoldedView", "setFoldedView", "hasExpandBtn", "", "getHasExpandBtn", "()I", "setHasExpandBtn", "(I)V", "isClickExpand", "setClickExpand", "isFolded", "", "()Z", "setFolded", "(Z)V", "onExpandListener", "Lkotlin/Function0;", "", "getOnExpandListener", "()Lkotlin/jvm/functions/Function0;", "setOnExpandListener", "(Lkotlin/jvm/functions/Function0;)V", "onFlodListener", "getOnFlodListener", "setOnFlodListener", "opBtn", "getOpBtn", "()Landroid/view/View;", "setOpBtn", "(Landroid/view/View;)V", "root", "getRoot", "setRoot", "selectedIndex", "getSelectedIndex", "setSelectedIndex", "tagClickMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getTagClickMap", "()Ljava/util/HashMap;", "setTagClickMap", "(Ljava/util/HashMap;)V", "tagData", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTagData", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setTagData", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "tagLayout", "Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;", "getTagLayout", "()Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;", "setTagLayout", "(Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;)V", "addDummyTag", "tags", "addTags", "expandTags", "flodTags", "genItemView", "tag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "index", "init", "notiftyTagClick", "refreshOpBtn", "setTagState", "selected", "view", "showOrDimissOpBtn", "show", "Companion", "Config", "expandOnClickListener", "flodOnClickListener", "plugin-finder_release"})
public final class FinderTagView
  extends RelativeLayout
{
  private static final int BaA = -1;
  private static final int BaB = -2;
  private static final int BaC;
  public static final long BaD = -1L;
  public static final FinderTagView.a BaE;
  public FinderTagFlowLayout Bam;
  public View Ban;
  ArrayList<View> Bao;
  public ArrayList<View> Bap;
  public HashMap<Long, Integer> Baq;
  public dwb Bar;
  boolean Bas;
  private kotlin.g.a.a<x> Bat;
  kotlin.g.a.a<x> Bau;
  private int Bav;
  public int Baw;
  private FinderTagView.b Bax;
  private c Bay;
  private d Baz;
  private int bhr;
  public View jac;
  
  static
  {
    AppMethodBeat.i(272375);
    BaE = new FinderTagView.a((byte)0);
    BaA = -1;
    BaB = -2;
    BaC = b.f.finder_feed_tag_float_view;
    BaD = -1L;
    AppMethodBeat.o(272375);
  }
  
  public FinderTagView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(272373);
    this.Bao = new ArrayList();
    this.Bap = new ArrayList();
    this.bhr = -1;
    this.Baq = new HashMap();
    this.Bax = new FinderTagView.b();
    this.Bay = new c(this);
    this.Baz = new d(this);
    init(paramContext);
    AppMethodBeat.o(272373);
  }
  
  public FinderTagView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(272374);
    this.Bao = new ArrayList();
    this.Bap = new ArrayList();
    this.bhr = -1;
    this.Baq = new HashMap();
    this.Bax = new FinderTagView.b();
    this.Bay = new c(this);
    this.Baz = new d(this);
    init(paramContext);
    AppMethodBeat.o(272374);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(272364);
    View localView = ad.kS(paramContext).inflate(b.g.finder_machinetab_tag_layout, (ViewGroup)this);
    p.j(localView, "MMLayoutInflater.getInfl…chinetab_tag_layout,this)");
    this.jac = localView;
    localView = this.jac;
    if (localView == null) {
      p.bGy("root");
    }
    localView = localView.findViewById(b.f.finder_machine_tag_layout);
    p.j(localView, "root.findViewById(R.id.finder_machine_tag_layout)");
    this.Bam = ((FinderTagFlowLayout)localView);
    localView = this.jac;
    if (localView == null) {
      p.bGy("root");
    }
    localView = localView.findViewById(b.f.finder_machine_tag_op_icon);
    p.j(localView, "root.findViewById(R.id.finder_machine_tag_op_icon)");
    this.Ban = localView;
    if (paramContext == null) {
      p.iCn();
    }
    setBackgroundColor(paramContext.getResources().getColor(this.Bax.bg));
    AppMethodBeat.o(272364);
  }
  
  public final void a(boolean paramBoolean, View paramView, int paramInt)
  {
    AppMethodBeat.i(272372);
    if (paramInt >= 0) {
      paramView.setTag(BaB, Integer.valueOf(paramInt));
    }
    paramView.setTag(BaA, Boolean.valueOf(paramBoolean));
    paramView = (TextView)paramView.findViewById(b.f.finder_machine_item_tv);
    if (paramBoolean)
    {
      localObject = this.jac;
      if (localObject == null) {
        p.bGy("root");
      }
      localObject = ((View)localObject).getContext();
      p.j(localObject, "root.context");
      paramView.setTextColor(((Context)localObject).getResources().getColor(this.Bax.BaI));
      paramView.setBackgroundResource(this.Bax.BaG);
      AppMethodBeat.o(272372);
      return;
    }
    Object localObject = this.jac;
    if (localObject == null) {
      p.bGy("root");
    }
    localObject = ((View)localObject).getContext();
    p.j(localObject, "root.context");
    paramView.setTextColor(((Context)localObject).getResources().getColor(this.Bax.BaH));
    paramView.setBackgroundResource(this.Bax.BaF);
    AppMethodBeat.o(272372);
  }
  
  public final void ejh()
  {
    AppMethodBeat.i(272366);
    FinderTagFlowLayout localFinderTagFlowLayout = this.Bam;
    if (localFinderTagFlowLayout == null) {
      p.bGy("tagLayout");
    }
    localFinderTagFlowLayout.post((Runnable)new g(this));
    AppMethodBeat.o(272366);
  }
  
  public final void eji()
  {
    AppMethodBeat.i(272371);
    FinderTagFlowLayout localFinderTagFlowLayout = this.Bam;
    if (localFinderTagFlowLayout == null) {
      p.bGy("tagLayout");
    }
    localFinderTagFlowLayout.post((Runnable)new e(this));
    AppMethodBeat.o(272371);
  }
  
  public final ArrayList<View> getAllAddViews()
  {
    return this.Bap;
  }
  
  public final FinderTagView.b getConfig()
  {
    return this.Bax;
  }
  
  public final c getExpandListener()
  {
    return this.Bay;
  }
  
  public final d getFlodListener()
  {
    return this.Baz;
  }
  
  public final ArrayList<View> getFoldedView()
  {
    return this.Bao;
  }
  
  public final int getHasExpandBtn()
  {
    return this.Bav;
  }
  
  public final kotlin.g.a.a<x> getOnExpandListener()
  {
    return this.Bau;
  }
  
  public final kotlin.g.a.a<x> getOnFlodListener()
  {
    return this.Bat;
  }
  
  public final View getOpBtn()
  {
    AppMethodBeat.i(272340);
    View localView = this.Ban;
    if (localView == null) {
      p.bGy("opBtn");
    }
    AppMethodBeat.o(272340);
    return localView;
  }
  
  public final View getRoot()
  {
    AppMethodBeat.i(272357);
    View localView = this.jac;
    if (localView == null) {
      p.bGy("root");
    }
    AppMethodBeat.o(272357);
    return localView;
  }
  
  public final int getSelectedIndex()
  {
    return this.bhr;
  }
  
  public final HashMap<Long, Integer> getTagClickMap()
  {
    return this.Baq;
  }
  
  public final dwb getTagData()
  {
    AppMethodBeat.i(272353);
    dwb localdwb = this.Bar;
    if (localdwb == null) {
      p.bGy("tagData");
    }
    AppMethodBeat.o(272353);
    return localdwb;
  }
  
  public final FinderTagFlowLayout getTagLayout()
  {
    AppMethodBeat.i(272336);
    FinderTagFlowLayout localFinderTagFlowLayout = this.Bam;
    if (localFinderTagFlowLayout == null) {
      p.bGy("tagLayout");
    }
    AppMethodBeat.o(272336);
    return localFinderTagFlowLayout;
  }
  
  public final void ru(boolean paramBoolean)
  {
    AppMethodBeat.i(272368);
    if (paramBoolean)
    {
      this.Bav = 1;
      localView = this.Ban;
      if (localView == null) {
        p.bGy("opBtn");
      }
      localView.setVisibility(0);
      localView = findViewById(b.f.finder_machine_tag_op_bg);
      p.j(localView, "findViewById<View>(R.id.finder_machine_tag_op_bg)");
      localView.setVisibility(0);
      localView = findViewById(b.f.finder_machine_op_layout);
      p.j(localView, "findViewById<View>(R.id.finder_machine_op_layout)");
      localView.setVisibility(0);
      AppMethodBeat.o(272368);
      return;
    }
    View localView = this.Ban;
    if (localView == null) {
      p.bGy("opBtn");
    }
    localView.setOnClickListener(null);
    localView = this.Ban;
    if (localView == null) {
      p.bGy("opBtn");
    }
    localView.setVisibility(8);
    localView = findViewById(b.f.finder_machine_tag_op_bg);
    p.j(localView, "findViewById<View>(R.id.finder_machine_tag_op_bg)");
    localView.setVisibility(8);
    localView = findViewById(b.f.finder_machine_op_layout);
    p.j(localView, "findViewById<View>(R.id.finder_machine_op_layout)");
    localView.setVisibility(8);
    AppMethodBeat.o(272368);
  }
  
  public final void setAllAddViews(ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(272348);
    p.k(paramArrayList, "<set-?>");
    this.Bap = paramArrayList;
    AppMethodBeat.o(272348);
  }
  
  public final void setClickExpand(int paramInt)
  {
    this.Baw = paramInt;
  }
  
  public final void setConfig(FinderTagView.b paramb)
  {
    AppMethodBeat.i(272359);
    p.k(paramb, "value");
    Context localContext = getContext();
    if (localContext == null) {
      p.iCn();
    }
    setBackgroundColor(localContext.getResources().getColor(paramb.bg));
    AppMethodBeat.o(272359);
  }
  
  public final void setExpandListener(c paramc)
  {
    AppMethodBeat.i(272360);
    p.k(paramc, "<set-?>");
    this.Bay = paramc;
    AppMethodBeat.o(272360);
  }
  
  public final void setFlodListener(d paramd)
  {
    AppMethodBeat.i(272362);
    p.k(paramd, "<set-?>");
    this.Baz = paramd;
    AppMethodBeat.o(272362);
  }
  
  public final void setFolded(boolean paramBoolean)
  {
    this.Bas = paramBoolean;
  }
  
  public final void setFoldedView(ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(272345);
    p.k(paramArrayList, "<set-?>");
    this.Bao = paramArrayList;
    AppMethodBeat.o(272345);
  }
  
  public final void setHasExpandBtn(int paramInt)
  {
    this.Bav = paramInt;
  }
  
  public final void setOnExpandListener(kotlin.g.a.a<x> parama)
  {
    this.Bau = parama;
  }
  
  public final void setOnFlodListener(kotlin.g.a.a<x> parama)
  {
    this.Bat = parama;
  }
  
  public final void setOpBtn(View paramView)
  {
    AppMethodBeat.i(272343);
    p.k(paramView, "<set-?>");
    this.Ban = paramView;
    AppMethodBeat.o(272343);
  }
  
  public final void setRoot(View paramView)
  {
    AppMethodBeat.i(272358);
    p.k(paramView, "<set-?>");
    this.jac = paramView;
    AppMethodBeat.o(272358);
  }
  
  public final void setSelectedIndex(int paramInt)
  {
    this.bhr = paramInt;
  }
  
  public final void setTagClickMap(HashMap<Long, Integer> paramHashMap)
  {
    AppMethodBeat.i(272351);
    p.k(paramHashMap, "<set-?>");
    this.Baq = paramHashMap;
    AppMethodBeat.o(272351);
  }
  
  public final void setTagData(dwb paramdwb)
  {
    AppMethodBeat.i(272354);
    p.k(paramdwb, "<set-?>");
    this.Bar = paramdwb;
    AppMethodBeat.o(272354);
  }
  
  public final void setTagLayout(FinderTagFlowLayout paramFinderTagFlowLayout)
  {
    AppMethodBeat.i(272337);
    p.k(paramFinderTagFlowLayout, "<set-?>");
    this.Bam = paramFinderTagFlowLayout;
    AppMethodBeat.o(272337);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;", "Landroid/view/View$OnClickListener;", "tagView", "Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView;Lcom/tencent/mm/plugin/finder/view/FinderTagView;)V", "getTagView", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public final class c
    implements View.OnClickListener
  {
    private final FinderTagView BaK;
    
    public c()
    {
      AppMethodBeat.i(279746);
      this.BaK = localObject;
      AppMethodBeat.o(279746);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(279744);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = this.BaK;
      if (paramView.Bas)
      {
        localObject = ((Iterable)paramView.Bao).iterator();
        while (((Iterator)localObject).hasNext())
        {
          View localView = (View)((Iterator)localObject).next();
          FinderTagFlowLayout localFinderTagFlowLayout = paramView.Bam;
          if (localFinderTagFlowLayout == null) {
            p.bGy("tagLayout");
          }
          localFinderTagFlowLayout.addView(localView);
        }
        paramView.Bao.clear();
        paramView.Bas = false;
        paramView.ejh();
        paramView = paramView.Bau;
        if (paramView != null) {
          paramView.invoke();
        }
      }
      FinderTagView.this.setClickExpand(1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(279744);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;", "Landroid/view/View$OnClickListener;", "tagView", "Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView;)V", "getTagView", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class d
    implements View.OnClickListener
  {
    private final FinderTagView BaK;
    
    public d(FinderTagView paramFinderTagView)
    {
      AppMethodBeat.i(282411);
      this.BaK = paramFinderTagView;
      AppMethodBeat.o(282411);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(282410);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.BaK.eji();
      this.BaK.ejh();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(282410);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(FinderTagView paramFinderTagView) {}
    
    public final void run()
    {
      AppMethodBeat.i(291216);
      if (!this.BaL.Bas)
      {
        int j = this.BaL.getTagLayout().Bai.size();
        this.BaL.getFoldedView().clear();
        int i = 1;
        View localView;
        while (i < j)
        {
          localObject = this.BaL.getTagLayout().Bai.get(i);
          p.j(localObject, "tagLayout.mAllViews[i]");
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localView = (View)((Iterator)localObject).next();
            this.BaL.getFoldedView().add(localView);
          }
          i += 1;
        }
        Object localObject = ((Iterable)this.BaL.getFoldedView()).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localView = (View)((Iterator)localObject).next();
          this.BaL.getTagLayout().removeView(localView);
        }
        this.BaL.setFolded(true);
        this.BaL.ejh();
        localObject = this.BaL.getOnFlodListener();
        if (localObject != null)
        {
          ((kotlin.g.a.a)localObject).invoke();
          AppMethodBeat.o(291216);
          return;
        }
      }
      AppMethodBeat.o(291216);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class f
    implements View.OnClickListener
  {
    public f(FinderTagView paramFinderTagView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(271398);
      Object localObject1 = new b();
      ((b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderTagView$genItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
      localObject1 = FinderTagView.BaE;
      localObject1 = paramView.getTag(FinderTagView.ejj());
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(271398);
        throw paramView;
      }
      boolean bool = ((Boolean)localObject1).booleanValue();
      localObject1 = new aa.d();
      Object localObject2 = FinderTagView.BaE;
      paramView = paramView.getTag(FinderTagView.ejk());
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(271398);
        throw paramView;
      }
      ((aa.d)localObject1).aaBA = ((Integer)paramView).intValue();
      int j = this.BaL.getAllAddViews().size();
      int i = 0;
      if (i < j)
      {
        if (i == ((aa.d)localObject1).aaBA)
        {
          paramView = this.BaL;
          localObject2 = this.BaL.getAllAddViews().get(i);
          p.j(localObject2, "allAddViews[i]");
          FinderTagView.a(paramView, true, (View)localObject2);
        }
        for (;;)
        {
          i += 1;
          break;
          paramView = this.BaL;
          localObject2 = this.BaL.getAllAddViews().get(i);
          p.j(localObject2, "allAddViews[i]");
          FinderTagView.a(paramView, false, (View)localObject2);
        }
      }
      if (!bool) {
        new MMHandler().postUI((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(272223);
            FinderTagView localFinderTagView = this.BaM.BaL;
            Object localObject = this.BaM.BaL.getTagData().Uca.get(this.BaN.aaBA);
            p.j(localObject, "tagData.topic_list[indexClick]");
            FinderTagView.a(localFinderTagView, (bkr)localObject);
            AppMethodBeat.o(272223);
          }
        });
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderTagView$genItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(271398);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(FinderTagView paramFinderTagView) {}
    
    public final void run()
    {
      AppMethodBeat.i(280906);
      if ((this.BaL.getTagLayout().Bai.size() <= 1) && (this.BaL.getFoldedView().isEmpty()))
      {
        this.BaL.ru(false);
        AppMethodBeat.o(280906);
        return;
      }
      if (!this.BaL.Bas)
      {
        if (this.BaL.getConfig().BaJ)
        {
          this.BaL.getOpBtn().setRotation(-90.0F);
          this.BaL.getOpBtn().setOnClickListener((View.OnClickListener)this.BaL.getFlodListener());
          this.BaL.ru(true);
          AppMethodBeat.o(280906);
          return;
        }
        this.BaL.ru(false);
        AppMethodBeat.o(280906);
        return;
      }
      this.BaL.ru(true);
      this.BaL.getOpBtn().setRotation(90.0F);
      this.BaL.getOpBtn().setOnClickListener((View.OnClickListener)this.BaL.getExpandListener());
      AppMethodBeat.o(280906);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderTagView
 * JD-Core Version:    0.7.0.1
 */