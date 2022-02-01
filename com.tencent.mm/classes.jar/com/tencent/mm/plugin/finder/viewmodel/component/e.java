package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "actionBarLayoutChangeListener", "Lcom/tencent/mm/plugin/finder/viewmodel/component/ActionBarLayoutChangeListener;", "actionBarMergedLayout", "Landroid/view/ViewGroup;", "getActionBarMergedLayout", "()Landroid/view/ViewGroup;", "actionBarMergedLayout$delegate", "Lkotlin/Lazy;", "actionBarMergedLayoutLoc", "", "actionBarMergedLayoutLocY", "", "actionBarOverlayLayout", "getActionBarOverlayLayout", "actionBarOverlayLayout$delegate", "feedFullMergedHeaderConvert", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullMergedHeaderConvert;", "feedFullMergedHeaderHolder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "headerFullMergedData", "Lcom/tencent/mm/plugin/finder/model/FinderHeaderFullMergedData;", "lastActionBarMergedLayoutLocY", "maxPosition", "onPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "getOnPreDrawListener", "()Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDrawListener$delegate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "showingAction", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$Action;", "state", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "tabType", "getTabType", "()I", "tabType$delegate", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "checkShowStreamDividerTip", "", "getActionBarLayoutHeight", "getActionBarLayoutLocY", "hideCompleted", "isBegin", "", "action", "notifyHeaderFullMergedView", "onActionbarClick", "isDouble", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "registActionBarLayoutChangeListener", "setHeaderFullMergedData", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter;", "showActionBarTip", "isShow", "content", "", "duration", "", "showCompleted", "showTips", "transOffset", "y", "", "unRegisteActionBarLayoutChangeListener", "Action", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends UIComponent
{
  private static final int GMJ;
  public static final b GMw;
  public al Bas;
  private final kotlin.j CNQ;
  private final kotlin.j Fqc;
  private int GMA;
  public com.tencent.mm.plugin.finder.convert.s GMB;
  public com.tencent.mm.view.recyclerview.j GMC;
  public a GMD;
  private int[] GME;
  private int GMF;
  private int GMG;
  private final kotlin.j GMH;
  private a GMI;
  public final kotlin.j GMx;
  private final kotlin.j GMy;
  private final com.tencent.mm.plugin.finder.viewmodel.d GMz;
  private final MMHandler mRi;
  
  static
  {
    AppMethodBeat.i(338098);
    GMw = new b((byte)0);
    GMJ = MMApplicationContext.getContext().getResources().getDisplayMetrics().heightPixels * 2;
    AppMethodBeat.o(338098);
  }
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(337887);
    this.CNQ = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.GMx = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.GMy = kotlin.k.cm((kotlin.g.a.a)new c(this));
    paramAppCompatActivity = com.tencent.mm.ui.component.k.aeZF;
    paramAppCompatActivity = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class);
    kotlin.g.b.s.s(paramAppCompatActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.GMz = ((com.tencent.mm.plugin.finder.viewmodel.d)paramAppCompatActivity);
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.Fqc = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.GME = new int[2];
    this.GMH = kotlin.k.cm((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(337887);
  }
  
  public e(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(337897);
    this.CNQ = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.GMx = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.GMy = kotlin.k.cm((kotlin.g.a.a)new c(this));
    paramFragment = com.tencent.mm.ui.component.k.aeZF;
    paramFragment = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class);
    kotlin.g.b.s.s(paramFragment, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.GMz = ((com.tencent.mm.plugin.finder.viewmodel.d)paramFragment);
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.Fqc = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.GME = new int[2];
    this.GMH = kotlin.k.cm((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(337897);
  }
  
  private static final void a(e parame, int paramInt)
  {
    AppMethodBeat.i(337965);
    kotlin.g.b.s.u(parame, "this$0");
    Object localObject1 = parame.getRecyclerView().fU(paramInt);
    Object localObject2;
    if ((localObject1 != null) && ((localObject1 instanceof com.tencent.mm.view.recyclerview.j)))
    {
      localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).CSA;
      int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adhL, 0);
      if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).streamDivider != null))
      {
        localObject1 = ((BaseFinderFeed)localObject2).streamDivider;
        if ((localObject1 == null) || (((bwc)localObject1).aadB != 8)) {
          break label173;
        }
        paramInt = 1;
        if (paramInt != 0)
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eWL().bmg()).intValue() != 1) {
            break label178;
          }
          paramInt = 1;
          label125:
          if (paramInt == 0) {
            break label191;
          }
          if (i >= 3)
          {
            localObject1 = ((BaseFinderFeed)localObject2).streamDivider;
            if (localObject1 != null) {
              break label183;
            }
          }
        }
      }
    }
    label173:
    label178:
    label183:
    for (localObject1 = null;; localObject1 = ((bwc)localObject1).wording)
    {
      a(parame, (CharSequence)localObject1);
      ((BaseFinderFeed)localObject2).streamDivider = null;
      AppMethodBeat.o(337965);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label125;
    }
    label191:
    localObject1 = ((BaseFinderFeed)localObject2).streamDivider;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((bwc)localObject1).wording)
    {
      a(parame, (CharSequence)localObject1);
      break;
    }
  }
  
  private static final void a(e parame, a parama)
  {
    AppMethodBeat.i(337972);
    kotlin.g.b.s.u(parame, "this$0");
    kotlin.g.b.s.u(parama, "$action");
    parame.a(false, parama);
    AppMethodBeat.o(337972);
  }
  
  private final void a(boolean paramBoolean, final a parama)
  {
    int j = 0;
    AppMethodBeat.i(337924);
    if (paramBoolean)
    {
      this.GMI = parama;
      localObject = findViewById(com.tencent.mm.plugin.finder.e.e.actionBarTips);
      if (localObject != null)
      {
        ((View)localObject).animate().cancel();
        c(true, parama);
        if (((View)localObject).getVisibility() == 8)
        {
          ((View)localObject).setVisibility(0);
          ((View)localObject).setAlpha(0.0F);
          ((View)localObject).animate().alpha(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new h(this, parama)).start();
        }
      }
      parama = com.tencent.mm.ui.component.k.aeZF;
      ((bf)com.tencent.mm.ui.component.k.d(getActivity()).q(bf.class)).fpw();
      AppMethodBeat.o(337924);
      return;
    }
    Object localObject = this.GMI;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (((a)localObject).type == parama.type) {
        i = 1;
      }
    }
    if ((i != 0) || (this.GMI == null))
    {
      localObject = findViewById(com.tencent.mm.plugin.finder.e.e.actionBarTips);
      if (localObject != null)
      {
        ((View)localObject).animate().cancel();
        if (((View)localObject).getVisibility() == 0)
        {
          b(true, parama);
          ((View)localObject).animate().alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new i((View)localObject, this, parama)).start();
        }
      }
    }
    AppMethodBeat.o(337924);
  }
  
  private static final void b(e parame, a parama)
  {
    AppMethodBeat.i(337979);
    kotlin.g.b.s.u(parame, "this$0");
    kotlin.g.b.s.u(parama, "$action");
    parame.a(false, parama);
    AppMethodBeat.o(337979);
  }
  
  private static void b(boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(337936);
    Log.i("Finder.DoubleClickTipUIC", "[hideCompleted] isBegin=" + paramBoolean + " action=" + parama.type);
    AppMethodBeat.o(337936);
  }
  
  private static final void c(e parame, a parama)
  {
    AppMethodBeat.i(337984);
    kotlin.g.b.s.u(parame, "this$0");
    kotlin.g.b.s.u(parama, "$action");
    parame.a(false, parama);
    AppMethodBeat.o(337984);
  }
  
  private final void c(boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(337952);
    Log.i("Finder.DoubleClickTipUIC", "[showCompleted] isBegin=" + paramBoolean + " action=" + parama.type);
    Object localObject;
    if (parama.type == 1)
    {
      if (paramBoolean)
      {
        parama = (TextView)findViewById(com.tencent.mm.plugin.finder.e.e.tips_desc);
        if (parama != null)
        {
          parama.setText((CharSequence)getContext().getResources().getString(com.tencent.mm.plugin.finder.e.h.finder_double_tips));
          parama.setVisibility(0);
        }
        parama = (WeImageView)findViewById(com.tencent.mm.plugin.finder.e.e.tips_icon);
        if (parama != null)
        {
          parama.setVisibility(0);
          parama.setIconColor(getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.hot_tab_BW_100_Alpha_0_8));
          parama.setRotation(-90.0F);
          parama.setImageResource(com.tencent.mm.plugin.finder.e.g.finder_self_feed_like_arrow);
          AppMethodBeat.o(337952);
        }
      }
      else
      {
        localObject = getFragment();
        if (localObject == null)
        {
          parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
          AppMethodBeat.o(337952);
          throw parama;
        }
        com.tencent.mm.plugin.finder.viewmodel.d.UX(((FinderHomeTabFragment)localObject).hJx);
        this.mRi.postDelayed(new e..ExternalSyntheticLambda3(this, parama), parama.duration);
        AppMethodBeat.o(337952);
      }
    }
    else
    {
      if (parama.type == 2)
      {
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(22077, "");
        localObject = (TextView)findViewById(com.tencent.mm.plugin.finder.e.e.tips_desc);
        if (localObject != null)
        {
          ((TextView)localObject).setText((CharSequence)getContext().getResources().getString(com.tencent.mm.plugin.finder.e.h.finder_no_more_new_feed_tips));
          ((TextView)localObject).setVisibility(0);
        }
        localObject = (WeImageView)findViewById(com.tencent.mm.plugin.finder.e.e.tips_icon);
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(8);
        }
        this.mRi.postDelayed(new e..ExternalSyntheticLambda2(this, parama), parama.duration);
        AppMethodBeat.o(337952);
        return;
      }
      if (parama.type == 0)
      {
        localObject = (TextView)findViewById(com.tencent.mm.plugin.finder.e.e.tips_desc);
        if (localObject != null)
        {
          ((TextView)localObject).setText(parama.title);
          ((TextView)localObject).setVisibility(0);
        }
        localObject = (WeImageView)findViewById(com.tencent.mm.plugin.finder.e.e.tips_icon);
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(8);
        }
        this.mRi.postDelayed(new e..ExternalSyntheticLambda1(this, parama), parama.duration);
      }
    }
    AppMethodBeat.o(337952);
  }
  
  private final int getTabType()
  {
    AppMethodBeat.i(337904);
    int i = ((Number)this.Fqc.getValue()).intValue();
    AppMethodBeat.o(337904);
    return i;
  }
  
  public final ViewGroup fmZ()
  {
    AppMethodBeat.i(338149);
    ViewGroup localViewGroup = (ViewGroup)this.GMy.getValue();
    AppMethodBeat.o(338149);
    return localViewGroup;
  }
  
  public final ViewTreeObserver.OnPreDrawListener fna()
  {
    AppMethodBeat.i(338159);
    ViewTreeObserver.OnPreDrawListener localOnPreDrawListener = (ViewTreeObserver.OnPreDrawListener)this.GMH.getValue();
    AppMethodBeat.o(338159);
    return localOnPreDrawListener;
  }
  
  public final void fnb()
  {
    AppMethodBeat.i(338167);
    Object localObject = av.GiL;
    com.tencent.mm.view.recyclerview.j localj = this.GMC;
    al localal = this.Bas;
    localObject = aw.Gjk;
    if ((localj != null) && (localal != null))
    {
      com.tencent.mm.plugin.finder.convert.s locals = this.GMB;
      localObject = locals;
      if (locals == null)
      {
        kotlin.g.b.s.bIx("feedFullMergedHeaderConvert");
        localObject = null;
      }
      ((com.tencent.mm.plugin.finder.convert.s)localObject).a(localj, localal, 0);
    }
    AppMethodBeat.o(338167);
  }
  
  public final void fnc()
  {
    AppMethodBeat.i(338189);
    a(false, new a(1));
    com.tencent.mm.plugin.finder.viewmodel.d.iG(getTabType(), 10000);
    AppMethodBeat.o(338189);
  }
  
  public final void fnd()
  {
    AppMethodBeat.i(338200);
    Object localObject = getRecyclerView().getLayoutManager();
    if ((localObject instanceof LinearLayoutManager))
    {
      int i = ((LinearLayoutManager)localObject).Ju();
      if (i != -1)
      {
        localObject = getRecyclerView();
        if (localObject != null) {
          ((RecyclerView)localObject).post(new e..ExternalSyntheticLambda0(this, i));
        }
      }
    }
    AppMethodBeat.o(338200);
  }
  
  public final void fne()
  {
    AppMethodBeat.i(338220);
    Log.i("Finder.DoubleClickTipUIC", "unRegisteActionBarLayoutChangeListener!");
    Object localObject = fmZ();
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).getViewTreeObserver();
      if (localObject != null) {
        ((ViewTreeObserver)localObject).removeOnPreDrawListener(fna());
      }
    }
    this.GMD = null;
    AppMethodBeat.o(338220);
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(338143);
    RecyclerView localRecyclerView = (RecyclerView)this.CNQ.getValue();
    AppMethodBeat.o(338143);
    return localRecyclerView;
  }
  
  public final void onCreateAfter(final Bundle paramBundle)
  {
    AppMethodBeat.i(338178);
    super.onCreateAfter(paramBundle);
    paramBundle = (ViewGroup)findViewById(com.tencent.mm.plugin.finder.e.e.actionBarMergedLayout);
    getRecyclerView().a((RecyclerView.l)new e(this, paramBundle));
    AppMethodBeat.o(338178);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(338213);
    super.onDestroy();
    this.mRi.removeCallbacksAndMessages(null);
    fne();
    AppMethodBeat.o(338213);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$Action;", "", "type", "", "(I)V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "title", "", "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "getType", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final a GMK;
    long duration;
    CharSequence title;
    final int type;
    
    static
    {
      AppMethodBeat.i(337532);
      GMK = new a((byte)0);
      AppMethodBeat.o(337532);
    }
    
    public a(int paramInt)
    {
      this.type = paramInt;
      this.duration = 5000L;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
      } while (this.type == paramObject.type);
      return false;
    }
    
    public final int hashCode()
    {
      return this.type;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(337539);
      String str = "Action(type=" + this.type + ')';
      AppMethodBeat.o(337539);
      return str;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$Action$Companion;", "", "()V", "TYPE_DOUBLE_CLICK_TIPS", "", "TYPE_HISTORY_TIPS", "TYPE_NORMAL_TIPS", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$Companion;", "", "()V", "OFFSET", "", "OFFSET_DISTANCE", "getOFFSET_DISTANCE", "()I", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    d(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$onCreateAfter$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "checkHeaderFullMergedShow", "", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends RecyclerView.l
  {
    private final Rect rect;
    
    e(e parame, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(337514);
      this.rect = new Rect();
      AppMethodBeat.o(337514);
    }
    
    private final void fnf()
    {
      AppMethodBeat.i(337525);
      if (e.a(this.GML) == null)
      {
        AppMethodBeat.o(337525);
        return;
      }
      Object localObject1 = e.b(this.GML).getAdapter();
      Object localObject2;
      label74:
      label107:
      int i;
      if ((localObject1 instanceof WxRecyclerAdapter))
      {
        localObject1 = (WxRecyclerAdapter)localObject1;
        if (localObject1 == null) {
          break label188;
        }
        localObject1 = (List)((WxRecyclerAdapter)localObject1).data;
        if (localObject1 == null) {
          break label188;
        }
        localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
        if (!((ListIterator)localObject2).hasPrevious()) {
          break label188;
        }
        localObject1 = (com.tencent.mm.view.recyclerview.a)((ListIterator)localObject2).previous();
        if (!(localObject1 instanceof BaseFinderFeed)) {
          break label178;
        }
        localObject1 = (BaseFinderFeed)localObject1;
        if ((localObject1 == null) || (((BaseFinderFeed)localObject1).isHistoryFeed != true)) {
          break label183;
        }
        i = 1;
        label121:
        if (i == 0) {
          break label186;
        }
        i = ((ListIterator)localObject2).nextIndex();
        label133:
        if (i < 0) {
          break label193;
        }
        i += 1;
      }
      for (;;)
      {
        localObject1 = e.b(this.GML).getLayoutManager();
        if (localObject1 != null) {
          break label198;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(337525);
        throw ((Throwable)localObject1);
        localObject1 = null;
        break;
        label178:
        localObject1 = null;
        break label107;
        label183:
        i = 0;
        break label121;
        label186:
        break label74;
        label188:
        i = -1;
        break label133;
        label193:
        i = 0;
      }
      label198:
      int j = ((LinearLayoutManager)localObject1).Ju();
      if ((j <= i) && (paramBundle.getVisibility() != 0)) {
        paramBundle.setVisibility(0);
      }
      if ((j == i) && (paramBundle.getHeight() > 0))
      {
        localObject1 = e.b(this.GML).fU(i);
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject1 == null)
          {
            paramBundle.setVisibility(8);
            AppMethodBeat.o(337525);
          }
        }
        else
        {
          localObject2 = this.GML;
          ViewGroup localViewGroup = paramBundle;
          e.b((e)localObject2);
          RecyclerView.getDecoratedBoundsWithMargins(((RecyclerView.v)localObject1).caK, this.rect);
          this.rect.top = Math.max(0, this.rect.top);
          this.rect.bottom = Math.max(0, this.rect.bottom);
          if (this.rect.height() > 0) {
            localViewGroup.setAlpha(1.0F * this.rect.height() / ((RecyclerView.v)localObject1).caK.getHeight());
          }
          for (;;)
          {
            localObject1 = ah.aiuX;
            break;
            localViewGroup.setVisibility(8);
          }
        }
        AppMethodBeat.o(337525);
        return;
      }
      if (j > i) {
        paramBundle.setVisibility(8);
      }
      AppMethodBeat.o(337525);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(337538);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$onCreateAfter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      localObject = paramRecyclerView.getLayoutManager();
      if (localObject == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(337538);
        throw paramRecyclerView;
      }
      int i = ((LinearLayoutManager)localObject).Ju();
      if (e.c(this.GML) < i) {
        e.b(this.GML, i);
      }
      paramRecyclerView = paramRecyclerView.getAdapter();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
        AppMethodBeat.o(337538);
        throw paramRecyclerView;
      }
      if (i <= ((WxRecyclerAdapter)paramRecyclerView).agOb.size())
      {
        e.a(this.GML, false, new e.a(1));
        e.b(this.GML, 0);
      }
      for (;;)
      {
        if (paramInt == 0)
        {
          this.GML.fnd();
          fnf();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$onCreateAfter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(337538);
        return;
        if ((e.c(this.GML) - i >= 2) && (e.d(this.GML).UW(e.e(this.GML)))) {
          e.a(this.GML, true, new e.a(1));
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(337530);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$onCreateAfter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      fnf();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$onCreateAfter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(337530);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewTreeObserver$OnPreDrawListener;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ViewTreeObserver.OnPreDrawListener>
  {
    f(e parame)
    {
      super();
    }
    
    private static final boolean k(e parame)
    {
      AppMethodBeat.i(337534);
      kotlin.g.b.s.u(parame, "this$0");
      e.c(parame, e.g(parame));
      if (e.h(parame) != e.i(parame))
      {
        Object localObject = e.j(parame);
        if (localObject != null) {
          ((a)localObject).Nh(e.h(parame));
        }
        localObject = av.GiL;
        if (av.bgV()) {
          Log.i("Finder.DoubleClickTipUIC", "OnPreDrawListener lastY=" + e.i(parame) + ",currY=" + e.h(parame));
        }
        e.d(parame, e.h(parame));
      }
      AppMethodBeat.o(337534);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<RecyclerView>
  {
    g(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$showTips$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements Animator.AnimatorListener
  {
    h(e parame, e.a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(337580);
      e.d(this.GML, parama);
      AppMethodBeat.o(337580);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC$showTips$2$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements Animator.AnimatorListener
  {
    i(View paramView, e parame, e.a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(337577);
      this.GMO.setVisibility(8);
      e.f(jdField_this);
      e.a(parama);
      AppMethodBeat.o(337577);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<Integer>
  {
    j(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.e
 * JD-Core Version:    0.7.0.1
 */