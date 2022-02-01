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
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.aa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z.d;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "allAddViews", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "getAllAddViews", "()Ljava/util/ArrayList;", "setAllAddViews", "(Ljava/util/ArrayList;)V", "value", "Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;", "config", "getConfig", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;", "setConfig", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;)V", "expandListener", "Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;", "getExpandListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;", "setExpandListener", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;)V", "flodListener", "Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;", "getFlodListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;", "setFlodListener", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;)V", "foldedView", "getFoldedView", "setFoldedView", "hasExpandBtn", "", "getHasExpandBtn", "()I", "setHasExpandBtn", "(I)V", "isClickExpand", "setClickExpand", "isFolded", "", "()Z", "setFolded", "(Z)V", "onExpandListener", "Lkotlin/Function0;", "", "getOnExpandListener", "()Lkotlin/jvm/functions/Function0;", "setOnExpandListener", "(Lkotlin/jvm/functions/Function0;)V", "onFlodListener", "getOnFlodListener", "setOnFlodListener", "opBtn", "getOpBtn", "()Landroid/view/View;", "setOpBtn", "(Landroid/view/View;)V", "root", "getRoot", "setRoot", "selectedIndex", "getSelectedIndex", "setSelectedIndex", "tagClickMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getTagClickMap", "()Ljava/util/HashMap;", "setTagClickMap", "(Ljava/util/HashMap;)V", "tagData", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "getTagData", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setTagData", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "tagLayout", "Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;", "getTagLayout", "()Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;", "setTagLayout", "(Lcom/tencent/mm/plugin/finder/view/FinderTagFlowLayout;)V", "addDummyTag", "tags", "addTags", "expandTags", "flodTags", "genItemView", "tag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "index", "init", "notiftyTagClick", "refreshOpBtn", "setTagState", "selected", "view", "showOrDimissOpBtn", "show", "Companion", "Config", "expandOnClickListener", "flodOnClickListener", "plugin-finder_release"})
public final class FinderTagView
  extends RelativeLayout
{
  private static final int wpr = -1;
  private static final int wps = -2;
  private static final int wpt;
  public static final long wpu = -1L;
  public static final a wpv;
  private int bxP;
  public View gvQ;
  public FinderTagFlowLayout wpd;
  public View wpe;
  ArrayList<View> wpf;
  public ArrayList<View> wpg;
  public HashMap<Long, Integer> wph;
  public dmk wpi;
  boolean wpj;
  private kotlin.g.a.a<x> wpk;
  kotlin.g.a.a<x> wpl;
  private int wpm;
  public int wpn;
  private b wpo;
  private c wpp;
  private d wpq;
  
  static
  {
    AppMethodBeat.i(254991);
    wpv = new a((byte)0);
    wpr = -1;
    wps = -2;
    wpt = 2131300842;
    wpu = -1L;
    AppMethodBeat.o(254991);
  }
  
  public FinderTagView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(254989);
    this.wpf = new ArrayList();
    this.wpg = new ArrayList();
    this.bxP = -1;
    this.wph = new HashMap();
    this.wpo = new b();
    this.wpp = new c(this);
    this.wpq = new d(this);
    init(paramContext);
    AppMethodBeat.o(254989);
  }
  
  public FinderTagView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254990);
    this.wpf = new ArrayList();
    this.wpg = new ArrayList();
    this.bxP = -1;
    this.wph = new HashMap();
    this.wpo = new b();
    this.wpp = new c(this);
    this.wpq = new d(this);
    init(paramContext);
    AppMethodBeat.o(254990);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(254984);
    View localView = aa.jQ(paramContext).inflate(2131494498, (ViewGroup)this);
    p.g(localView, "MMLayoutInflater.getInfl…chinetab_tag_layout,this)");
    this.gvQ = localView;
    localView = this.gvQ;
    if (localView == null) {
      p.btv("root");
    }
    localView = localView.findViewById(2131301350);
    p.g(localView, "root.findViewById(R.id.finder_machine_tag_layout)");
    this.wpd = ((FinderTagFlowLayout)localView);
    localView = this.gvQ;
    if (localView == null) {
      p.btv("root");
    }
    localView = localView.findViewById(2131301352);
    p.g(localView, "root.findViewById(R.id.finder_machine_tag_op_icon)");
    this.wpe = localView;
    if (paramContext == null) {
      p.hyc();
    }
    setBackgroundColor(paramContext.getResources().getColor(this.wpo.bg));
    AppMethodBeat.o(254984);
  }
  
  public final void a(boolean paramBoolean, View paramView, int paramInt)
  {
    AppMethodBeat.i(254988);
    if (paramInt >= 0) {
      paramView.setTag(wps, Integer.valueOf(paramInt));
    }
    paramView.setTag(wpr, Boolean.valueOf(paramBoolean));
    paramView = (TextView)paramView.findViewById(2131301348);
    if (paramBoolean)
    {
      localObject = this.gvQ;
      if (localObject == null) {
        p.btv("root");
      }
      localObject = ((View)localObject).getContext();
      p.g(localObject, "root.context");
      paramView.setTextColor(((Context)localObject).getResources().getColor(this.wpo.wpz));
      paramView.setBackgroundResource(this.wpo.wpx);
      AppMethodBeat.o(254988);
      return;
    }
    Object localObject = this.gvQ;
    if (localObject == null) {
      p.btv("root");
    }
    localObject = ((View)localObject).getContext();
    p.g(localObject, "root.context");
    paramView.setTextColor(((Context)localObject).getResources().getColor(this.wpo.wpy));
    paramView.setBackgroundResource(this.wpo.wpw);
    AppMethodBeat.o(254988);
  }
  
  public final void dHg()
  {
    AppMethodBeat.i(254985);
    FinderTagFlowLayout localFinderTagFlowLayout = this.wpd;
    if (localFinderTagFlowLayout == null) {
      p.btv("tagLayout");
    }
    localFinderTagFlowLayout.post((Runnable)new g(this));
    AppMethodBeat.o(254985);
  }
  
  public final void dHh()
  {
    AppMethodBeat.i(254987);
    FinderTagFlowLayout localFinderTagFlowLayout = this.wpd;
    if (localFinderTagFlowLayout == null) {
      p.btv("tagLayout");
    }
    localFinderTagFlowLayout.post((Runnable)new e(this));
    AppMethodBeat.o(254987);
  }
  
  public final ArrayList<View> getAllAddViews()
  {
    return this.wpg;
  }
  
  public final b getConfig()
  {
    return this.wpo;
  }
  
  public final c getExpandListener()
  {
    return this.wpp;
  }
  
  public final d getFlodListener()
  {
    return this.wpq;
  }
  
  public final ArrayList<View> getFoldedView()
  {
    return this.wpf;
  }
  
  public final int getHasExpandBtn()
  {
    return this.wpm;
  }
  
  public final kotlin.g.a.a<x> getOnExpandListener()
  {
    return this.wpl;
  }
  
  public final kotlin.g.a.a<x> getOnFlodListener()
  {
    return this.wpk;
  }
  
  public final View getOpBtn()
  {
    AppMethodBeat.i(254972);
    View localView = this.wpe;
    if (localView == null) {
      p.btv("opBtn");
    }
    AppMethodBeat.o(254972);
    return localView;
  }
  
  public final View getRoot()
  {
    AppMethodBeat.i(254979);
    View localView = this.gvQ;
    if (localView == null) {
      p.btv("root");
    }
    AppMethodBeat.o(254979);
    return localView;
  }
  
  public final int getSelectedIndex()
  {
    return this.bxP;
  }
  
  public final HashMap<Long, Integer> getTagClickMap()
  {
    return this.wph;
  }
  
  public final dmk getTagData()
  {
    AppMethodBeat.i(254977);
    dmk localdmk = this.wpi;
    if (localdmk == null) {
      p.btv("tagData");
    }
    AppMethodBeat.o(254977);
    return localdmk;
  }
  
  public final FinderTagFlowLayout getTagLayout()
  {
    AppMethodBeat.i(254970);
    FinderTagFlowLayout localFinderTagFlowLayout = this.wpd;
    if (localFinderTagFlowLayout == null) {
      p.btv("tagLayout");
    }
    AppMethodBeat.o(254970);
    return localFinderTagFlowLayout;
  }
  
  public final void pa(boolean paramBoolean)
  {
    AppMethodBeat.i(254986);
    if (paramBoolean)
    {
      this.wpm = 1;
      localView = this.wpe;
      if (localView == null) {
        p.btv("opBtn");
      }
      localView.setVisibility(0);
      localView = findViewById(2131301351);
      p.g(localView, "findViewById<View>(R.id.finder_machine_tag_op_bg)");
      localView.setVisibility(0);
      localView = findViewById(2131301349);
      p.g(localView, "findViewById<View>(R.id.finder_machine_op_layout)");
      localView.setVisibility(0);
      AppMethodBeat.o(254986);
      return;
    }
    View localView = this.wpe;
    if (localView == null) {
      p.btv("opBtn");
    }
    localView.setOnClickListener(null);
    localView = this.wpe;
    if (localView == null) {
      p.btv("opBtn");
    }
    localView.setVisibility(8);
    localView = findViewById(2131301351);
    p.g(localView, "findViewById<View>(R.id.finder_machine_tag_op_bg)");
    localView.setVisibility(8);
    localView = findViewById(2131301349);
    p.g(localView, "findViewById<View>(R.id.finder_machine_op_layout)");
    localView.setVisibility(8);
    AppMethodBeat.o(254986);
  }
  
  public final void setAllAddViews(ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(254975);
    p.h(paramArrayList, "<set-?>");
    this.wpg = paramArrayList;
    AppMethodBeat.o(254975);
  }
  
  public final void setClickExpand(int paramInt)
  {
    this.wpn = paramInt;
  }
  
  public final void setConfig(b paramb)
  {
    AppMethodBeat.i(254981);
    p.h(paramb, "value");
    Context localContext = getContext();
    if (localContext == null) {
      p.hyc();
    }
    setBackgroundColor(localContext.getResources().getColor(paramb.bg));
    AppMethodBeat.o(254981);
  }
  
  public final void setExpandListener(c paramc)
  {
    AppMethodBeat.i(254982);
    p.h(paramc, "<set-?>");
    this.wpp = paramc;
    AppMethodBeat.o(254982);
  }
  
  public final void setFlodListener(d paramd)
  {
    AppMethodBeat.i(254983);
    p.h(paramd, "<set-?>");
    this.wpq = paramd;
    AppMethodBeat.o(254983);
  }
  
  public final void setFolded(boolean paramBoolean)
  {
    this.wpj = paramBoolean;
  }
  
  public final void setFoldedView(ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(254974);
    p.h(paramArrayList, "<set-?>");
    this.wpf = paramArrayList;
    AppMethodBeat.o(254974);
  }
  
  public final void setHasExpandBtn(int paramInt)
  {
    this.wpm = paramInt;
  }
  
  public final void setOnExpandListener(kotlin.g.a.a<x> parama)
  {
    this.wpl = parama;
  }
  
  public final void setOnFlodListener(kotlin.g.a.a<x> parama)
  {
    this.wpk = parama;
  }
  
  public final void setOpBtn(View paramView)
  {
    AppMethodBeat.i(254973);
    p.h(paramView, "<set-?>");
    this.wpe = paramView;
    AppMethodBeat.o(254973);
  }
  
  public final void setRoot(View paramView)
  {
    AppMethodBeat.i(254980);
    p.h(paramView, "<set-?>");
    this.gvQ = paramView;
    AppMethodBeat.o(254980);
  }
  
  public final void setSelectedIndex(int paramInt)
  {
    this.bxP = paramInt;
  }
  
  public final void setTagClickMap(HashMap<Long, Integer> paramHashMap)
  {
    AppMethodBeat.i(254976);
    p.h(paramHashMap, "<set-?>");
    this.wph = paramHashMap;
    AppMethodBeat.o(254976);
  }
  
  public final void setTagData(dmk paramdmk)
  {
    AppMethodBeat.i(254978);
    p.h(paramdmk, "<set-?>");
    this.wpi = paramdmk;
    AppMethodBeat.o(254978);
  }
  
  public final void setTagLayout(FinderTagFlowLayout paramFinderTagFlowLayout)
  {
    AppMethodBeat.i(254971);
    p.h(paramFinderTagFlowLayout, "<set-?>");
    this.wpd = paramFinderTagFlowLayout;
    AppMethodBeat.o(254971);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$Companion;", "", "()V", "FLOAT_VIEW_ID", "", "getFLOAT_VIEW_ID", "()I", "TAG", "", "TAG_ALL_TOPIC_ID", "", "getTAG_ALL_TOPIC_ID", "()J", "TAG_VIEW_INDEX", "getTAG_VIEW_INDEX", "TAG_VIEW_SELECTED_STATE", "getTAG_VIEW_SELECTED_STATE", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$Config;", "", "()V", "bg", "", "getBg", "()I", "setBg", "(I)V", "canFoldAfterExpand", "", "getCanFoldAfterExpand", "()Z", "setCanFoldAfterExpand", "(Z)V", "itemNormalBg", "getItemNormalBg", "setItemNormalBg", "itemSelectedBg", "getItemSelectedBg", "setItemSelectedBg", "itemTextNormalColor", "getItemTextNormalColor", "setItemTextNormalColor", "itemTextSelectedColor", "getItemTextSelectedColor", "setItemTextSelectedColor", "plugin-finder_release"})
  public static final class b
  {
    int bg = 2131099650;
    boolean wpA = true;
    int wpw = 2131232659;
    int wpx = 2131232660;
    int wpy = 2131100904;
    int wpz = 2131101427;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener;", "Landroid/view/View$OnClickListener;", "tagView", "Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView;Lcom/tencent/mm/plugin/finder/view/FinderTagView;)V", "getTagView", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public final class c
    implements View.OnClickListener
  {
    private final FinderTagView wpB;
    
    public c()
    {
      AppMethodBeat.i(254963);
      this.wpB = localObject;
      AppMethodBeat.o(254963);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(254962);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = this.wpB;
      if (paramView.wpj)
      {
        localObject = ((Iterable)paramView.wpf).iterator();
        while (((Iterator)localObject).hasNext())
        {
          View localView = (View)((Iterator)localObject).next();
          FinderTagFlowLayout localFinderTagFlowLayout = paramView.wpd;
          if (localFinderTagFlowLayout == null) {
            p.btv("tagLayout");
          }
          localFinderTagFlowLayout.addView(localView);
        }
        paramView.wpf.clear();
        paramView.wpj = false;
        paramView.dHg();
        paramView = paramView.wpl;
        if (paramView != null) {
          paramView.invoke();
        }
      }
      FinderTagView.this.setClickExpand(1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderTagView$expandOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(254962);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener;", "Landroid/view/View$OnClickListener;", "tagView", "Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "(Lcom/tencent/mm/plugin/finder/view/FinderTagView;)V", "getTagView", "()Lcom/tencent/mm/plugin/finder/view/FinderTagView;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
  public static final class d
    implements View.OnClickListener
  {
    private final FinderTagView wpB;
    
    public d(FinderTagView paramFinderTagView)
    {
      AppMethodBeat.i(254965);
      this.wpB = paramFinderTagView;
      AppMethodBeat.o(254965);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(254964);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.wpB.dHh();
      this.wpB.dHg();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderTagView$flodOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(254964);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(FinderTagView paramFinderTagView) {}
    
    public final void run()
    {
      AppMethodBeat.i(254966);
      if (!this.wpC.wpj)
      {
        int j = this.wpC.getTagLayout().woZ.size();
        this.wpC.getFoldedView().clear();
        int i = 1;
        View localView;
        while (i < j)
        {
          localObject = this.wpC.getTagLayout().woZ.get(i);
          p.g(localObject, "tagLayout.mAllViews[i]");
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localView = (View)((Iterator)localObject).next();
            this.wpC.getFoldedView().add(localView);
          }
          i += 1;
        }
        Object localObject = ((Iterable)this.wpC.getFoldedView()).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localView = (View)((Iterator)localObject).next();
          this.wpC.getTagLayout().removeView(localView);
        }
        this.wpC.setFolded(true);
        this.wpC.dHg();
        localObject = this.wpC.getOnFlodListener();
        if (localObject != null)
        {
          ((kotlin.g.a.a)localObject).invoke();
          AppMethodBeat.o(254966);
          return;
        }
      }
      AppMethodBeat.o(254966);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class f
    implements View.OnClickListener
  {
    public f(FinderTagView paramFinderTagView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(254968);
      Object localObject1 = new b();
      ((b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderTagView$genItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
      localObject1 = FinderTagView.wpv;
      localObject1 = paramView.getTag(FinderTagView.dHi());
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(254968);
        throw paramView;
      }
      boolean bool = ((Boolean)localObject1).booleanValue();
      localObject1 = new z.d();
      Object localObject2 = FinderTagView.wpv;
      paramView = paramView.getTag(FinderTagView.dHj());
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(254968);
        throw paramView;
      }
      ((z.d)localObject1).SYE = ((Integer)paramView).intValue();
      int j = this.wpC.getAllAddViews().size();
      int i = 0;
      if (i < j)
      {
        if (i == ((z.d)localObject1).SYE)
        {
          paramView = this.wpC;
          localObject2 = this.wpC.getAllAddViews().get(i);
          p.g(localObject2, "allAddViews[i]");
          FinderTagView.a(paramView, true, (View)localObject2);
        }
        for (;;)
        {
          i += 1;
          break;
          paramView = this.wpC;
          localObject2 = this.wpC.getAllAddViews().get(i);
          p.g(localObject2, "allAddViews[i]");
          FinderTagView.a(paramView, false, (View)localObject2);
        }
      }
      if (!bool) {
        new MMHandler().postUI((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(254967);
            FinderTagView localFinderTagView = this.wpD.wpC;
            Object localObject = this.wpD.wpC.getTagData().MPW.get(this.wpE.SYE);
            p.g(localObject, "tagData.topic_list[indexClick]");
            FinderTagView.a(localFinderTagView, (bds)localObject);
            AppMethodBeat.o(254967);
          }
        });
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderTagView$genItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(254968);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(FinderTagView paramFinderTagView) {}
    
    public final void run()
    {
      AppMethodBeat.i(254969);
      if ((this.wpC.getTagLayout().woZ.size() <= 1) && (this.wpC.getFoldedView().isEmpty()))
      {
        this.wpC.pa(false);
        AppMethodBeat.o(254969);
        return;
      }
      if (!this.wpC.wpj)
      {
        if (this.wpC.getConfig().wpA)
        {
          this.wpC.getOpBtn().setRotation(-90.0F);
          this.wpC.getOpBtn().setOnClickListener((View.OnClickListener)this.wpC.getFlodListener());
          this.wpC.pa(true);
          AppMethodBeat.o(254969);
          return;
        }
        this.wpC.pa(false);
        AppMethodBeat.o(254969);
        return;
      }
      this.wpC.pa(true);
      this.wpC.getOpBtn().setRotation(90.0F);
      this.wpC.getOpBtn().setOnClickListener((View.OnClickListener)this.wpC.getExpandListener());
      AppMethodBeat.o(254969);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderTagView
 * JD-Core Version:    0.7.0.1
 */