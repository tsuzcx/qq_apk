package com.tencent.mm.plugin.finder.view.sidebar;

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/sidebar/FinderSideBar;", "", "config", "Lcom/tencent/mm/plugin/finder/view/sidebar/FinderSideBar$Config;", "parent", "Landroid/view/ViewGroup;", "layoutId", "", "index", "(Lcom/tencent/mm/plugin/finder/view/sidebar/FinderSideBar$Config;Landroid/view/ViewGroup;II)V", "TAG", "", "bodyRoot", "Lcom/tencent/mm/plugin/finder/view/sidebar/DraggableConstraintLayout;", "getBodyRoot", "()Lcom/tencent/mm/plugin/finder/view/sidebar/DraggableConstraintLayout;", "getConfig", "()Lcom/tencent/mm/plugin/finder/view/sidebar/FinderSideBar$Config;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dragMode", "getDragMode", "()I", "setDragMode", "(I)V", "footer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getFooter", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "header", "getHeader", "lastPercent", "", "getLastPercent", "()F", "setLastPercent", "(F)V", "getParent", "()Landroid/view/ViewGroup;", "rootLayout", "getRootLayout", "sideBarRoot", "getSideBarRoot", "targetBodyMarginBottom", "getTargetBodyMarginBottom", "setTargetBodyMarginBottom", "targetBodyMarginTop", "getTargetBodyMarginTop", "setTargetBodyMarginTop", "targetBodyWidth", "getTargetBodyWidth", "setTargetBodyWidth", "totalDistance", "getTotalDistance", "setTotalDistance", "animateToHide", "", "animateToShow", "changeBodyLayout", "curBodyWidth", "curMarginTop", "curMarginBottom", "debugLog", "log", "determineDragMode", "disableDrag", "dragging", "percent", "distance", "enableDrag", "finishDrag", "springBack", "", "innerEnableDrag", "showing", "measureSideBar", "startContinueAnimation", "view", "Landroid/view/View;", "currentPercent", "targetPercent", "animationEnd", "Lkotlin/Function0;", "startDrag", "Config", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private int GIA;
  private int GIB;
  float GIC;
  int GIk;
  int GIo;
  private final ConstraintLayout GIt;
  private final ConstraintLayout GIu;
  private final ConstraintLayout GIv;
  public final DraggableConstraintLayout GIw;
  private final ConstraintLayout GIx;
  public final a GIy;
  private int GIz;
  private final String TAG;
  private final Context context;
  private final ViewGroup parent;
  
  public a(a parama, ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(344593);
    this.TAG = "Finder.FinderSideBar";
    Object localObject = DraggableConstraintLayout.GIg;
    this.GIk = DraggableConstraintLayout.fmd();
    this.GIy = parama;
    this.parent = paramViewGroup;
    localObject = paramViewGroup.getContext();
    s.s(localObject, "parent.context");
    this.context = ((Context)localObject);
    localObject = LayoutInflater.from(this.context).inflate(paramInt, paramViewGroup, false);
    if (localObject == null)
    {
      parama = new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
      AppMethodBeat.o(344593);
      throw parama;
    }
    this.GIt = ((ConstraintLayout)localObject);
    paramViewGroup.addView((View)this.GIt, 0, new ViewGroup.LayoutParams(-1, -1));
    localObject = this.GIt.findViewById(com.tencent.mm.w.a.a.a.e.sidebar_header);
    s.s(localObject, "rootLayout.findViewById(R.id.sidebar_header)");
    this.GIu = ((ConstraintLayout)localObject);
    localObject = this.GIt.findViewById(com.tencent.mm.w.a.a.a.e.sidebar_footer);
    s.s(localObject, "rootLayout.findViewById(R.id.sidebar_footer)");
    this.GIv = ((ConstraintLayout)localObject);
    localObject = this.GIt.findViewById(com.tencent.mm.w.a.a.a.e.sidebar_body_left);
    s.s(localObject, "rootLayout.findViewById(R.id.sidebar_body_left)");
    this.GIw = ((DraggableConstraintLayout)localObject);
    localObject = this.GIt.findViewById(com.tencent.mm.w.a.a.a.e.sidebar_body_right);
    s.s(localObject, "rootLayout.findViewById(R.id.sidebar_body_right)");
    this.GIx = ((ConstraintLayout)localObject);
    parama.e(this.GIu);
    parama.h((ConstraintLayout)this.GIw);
    parama.g(this.GIx);
    parama.f(this.GIv);
    this.GIw.setDragListener((DraggableConstraintLayout.b)new DraggableConstraintLayout.b()
    {
      public final void UP(int paramAnonymousInt)
      {
        float f2 = 0.0F;
        float f1 = 1.0F;
        AppMethodBeat.i(344586);
        a locala = this.GID;
        float f3 = Math.abs(paramAnonymousInt) * 1.0F / locala.GIo;
        if (f3 > 1.0F) {}
        for (;;)
        {
          if (f1 < 0.0F) {
            f1 = f2;
          }
          for (;;)
          {
            locala.cr(f1);
            AppMethodBeat.o(344586);
            return;
          }
          f1 = f3;
        }
      }
      
      public final void fmg()
      {
        AppMethodBeat.i(344582);
        Object localObject = this.GID;
        ((a)localObject).GIC = 0.0F;
        a.a locala = ((a)localObject).GIy;
        int i = ((a)localObject).GIk;
        localObject = DraggableConstraintLayout.GIg;
        if (i == DraggableConstraintLayout.fme()) {}
        for (boolean bool = true;; bool = false)
        {
          locala.qk(bool);
          AppMethodBeat.o(344582);
          return;
        }
      }
      
      public final void ve(boolean paramAnonymousBoolean)
      {
        boolean bool2 = true;
        float f1 = 0.0F;
        AppMethodBeat.i(344592);
        Object localObject1 = this.GID;
        int i = ((a)localObject1).GIk;
        Object localObject2 = DraggableConstraintLayout.GIg;
        boolean bool1;
        float f2;
        if ((i != DraggableConstraintLayout.fme()) || (paramAnonymousBoolean))
        {
          i = ((a)localObject1).GIk;
          localObject2 = DraggableConstraintLayout.GIg;
          if ((i != DraggableConstraintLayout.fmf()) || (!paramAnonymousBoolean)) {}
        }
        else
        {
          bool1 = true;
          if ((((a)localObject1).GIC <= 0.0F) || (((a)localObject1).GIC >= 1.0F)) {
            break label158;
          }
          ((a)localObject1).GIw.GIk = DraggableConstraintLayout.GIp;
          localObject2 = (View)((a)localObject1).GIw;
          f2 = ((a)localObject1).GIC;
          if (!paramAnonymousBoolean) {
            break label153;
          }
        }
        for (;;)
        {
          ((a)localObject1).a((View)localObject2, f2, f1, (kotlin.g.a.a)new a.d((a)localObject1, bool1));
          AppMethodBeat.o(344592);
          return;
          bool1 = false;
          break;
          label153:
          f1 = 1.0F;
        }
        label158:
        ((a)localObject1).vf(bool1);
        localObject2 = ((a)localObject1).GIy;
        i = ((a)localObject1).GIk;
        localObject1 = DraggableConstraintLayout.GIg;
        if (i == DraggableConstraintLayout.fmf()) {}
        for (paramAnonymousBoolean = bool2;; paramAnonymousBoolean = false)
        {
          ((a.a)localObject2).ql(paramAnonymousBoolean);
          AppMethodBeat.o(344592);
          return;
        }
      }
    });
    paramViewGroup.post(new a..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(344593);
  }
  
  private final void G(String paramString)
  {
    AppMethodBeat.i(344601);
    Log.i(this.TAG, paramString);
    AppMethodBeat.o(344601);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(344609);
    s.u(parama, "this$0");
    int i = parama.GIu.getHeight();
    int j = parama.GIv.getHeight();
    int k = parama.GIx.getWidth();
    int m = aw.bf(parama.context).x;
    parama.GIo = k;
    parama.GIz = (m - k);
    parama.GIA = i;
    parama.GIB = j;
    parama.G("totalDistance:" + parama.GIo + ", targetBodyWidth:" + parama.GIz + ", targetBodyMarginTop:" + parama.GIA + " targetBodyMarginBottom:" + parama.GIB);
    AppMethodBeat.o(344609);
  }
  
  private static final void b(a parama)
  {
    AppMethodBeat.i(344615);
    s.u(parama, "this$0");
    parama.fmi();
    AppMethodBeat.o(344615);
  }
  
  private static final void c(a parama)
  {
    AppMethodBeat.i(344622);
    s.u(parama, "this$0");
    DraggableConstraintLayout.a locala = DraggableConstraintLayout.GIg;
    parama.GIk = DraggableConstraintLayout.fmd();
    parama.GIw.GIk = DraggableConstraintLayout.GIp;
    AppMethodBeat.o(344622);
  }
  
  public final void a(View paramView, final float paramFloat1, final float paramFloat2, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(344702);
    f localf = new f(this, paramFloat1, paramFloat2);
    localf.setDuration(((float)this.GIy.etE() * Math.abs(paramFloat2 - paramFloat1)));
    localf.setAnimationListener((Animation.AnimationListener)new a.e(parama));
    localf.setInterpolator((Interpolator)new LinearInterpolator());
    paramView.startAnimation((Animation)localf);
    AppMethodBeat.o(344702);
  }
  
  final void cr(float paramFloat)
  {
    AppMethodBeat.i(344693);
    G(s.X("dragging percent:", Float.valueOf(paramFloat)));
    if (paramFloat == this.GIC) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(344693);
      return;
    }
    i = this.GIk;
    Object localObject = DraggableConstraintLayout.GIg;
    if (i == DraggableConstraintLayout.fme()) {}
    int j;
    int k;
    for (float f = paramFloat;; f = 1.0F - paramFloat)
    {
      i = (int)(this.GIo * (1.0F - f) + this.GIz);
      j = (int)(this.GIA * f);
      k = (int)(this.GIB * f);
      localObject = this.GIw.getLayoutParams();
      if (localObject != null) {
        break;
      }
      localObject = new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
      AppMethodBeat.o(344693);
      throw ((Throwable)localObject);
    }
    localObject = (ConstraintLayout.LayoutParams)localObject;
    ((ConstraintLayout.LayoutParams)localObject).width = i;
    ((ConstraintLayout.LayoutParams)localObject).topMargin = j;
    ((ConstraintLayout.LayoutParams)localObject).bottomMargin = k;
    this.GIw.requestLayout();
    this.GIy.cl(f);
    this.GIC = paramFloat;
    AppMethodBeat.o(344693);
  }
  
  public final void fmh()
  {
    AppMethodBeat.i(344647);
    this.parent.post(new a..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(344647);
  }
  
  final void fmi()
  {
    AppMethodBeat.i(344655);
    int i = Math.abs(this.GIw.getWidth() - this.GIz);
    int j = Math.abs(this.GIw.getWidth() - this.GIz - this.GIo);
    G("determineDragMode distanceFromTarget:" + i + ", " + j + ", bodyRoot.width:" + this.GIw.getWidth() + ", targetBodyWidth:" + this.GIz + ", totalDistance:" + this.GIo);
    Object localObject;
    if (i > j)
    {
      localObject = DraggableConstraintLayout.GIg;
      i = DraggableConstraintLayout.fme();
      this.GIk = i;
      localObject = this.GIw;
      i = this.GIk;
      DraggableConstraintLayout.a locala = DraggableConstraintLayout.GIg;
      if (i != DraggableConstraintLayout.fme()) {
        break label195;
      }
    }
    label195:
    for (boolean bool = true;; bool = false)
    {
      ((DraggableConstraintLayout)localObject).l(bool, this.GIo / 2, this.GIo);
      AppMethodBeat.o(344655);
      return;
      localObject = DraggableConstraintLayout.GIg;
      i = DraggableConstraintLayout.fmf();
      break;
    }
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(344668);
    this.parent.post(new a..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(344668);
  }
  
  public final void fmk()
  {
    AppMethodBeat.i(344675);
    this.GIw.GIk = DraggableConstraintLayout.GIp;
    this.GIy.qk(false);
    a((View)this.GIw, 0.0F, 1.0F, (kotlin.g.a.a)new b(this));
    AppMethodBeat.o(344675);
  }
  
  final void vf(boolean paramBoolean)
  {
    AppMethodBeat.i(344661);
    G(s.X("innerEnableDrag showing:", Boolean.valueOf(paramBoolean)));
    Object localObject;
    int i;
    if (!paramBoolean)
    {
      localObject = DraggableConstraintLayout.GIg;
      i = DraggableConstraintLayout.fme();
      this.GIk = i;
      localObject = this.GIw;
      if (paramBoolean) {
        break label81;
      }
    }
    label81:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((DraggableConstraintLayout)localObject).l(paramBoolean, this.GIo / 2, this.GIo);
      AppMethodBeat.o(344661);
      return;
      localObject = DraggableConstraintLayout.GIg;
      i = DraggableConstraintLayout.fmf();
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/sidebar/FinderSideBar$Config;", "", "()V", "buildBody", "", "bodyRoot", "Landroidx/constraintlayout/widget/ConstraintLayout;", "buildFooter", "footer", "buildHeader", "header", "buildSideBar", "sideBarRoot", "getDragRate", "", "getTotalAnimationDuration", "", "onDragFinished", "show", "", "onDragProgress", "percent", "onDragStarted", "toShow", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class a
  {
    public abstract void cl(float paramFloat);
    
    public abstract void e(ConstraintLayout paramConstraintLayout);
    
    public abstract long etE();
    
    public abstract void f(ConstraintLayout paramConstraintLayout);
    
    public abstract void g(ConstraintLayout paramConstraintLayout);
    
    public abstract void h(ConstraintLayout paramConstraintLayout);
    
    public abstract void qk(boolean paramBoolean);
    
    public abstract void ql(boolean paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    public c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(a parama, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/sidebar/FinderSideBar$startContinueAnimation$animation$1", "Landroid/view/animation/Animation;", "applyTransformation", "", "interpolatedTime", "", "t", "Landroid/view/animation/Transformation;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends Animation
  {
    f(a parama, float paramFloat1, float paramFloat2) {}
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(344572);
      this.GID.cr(paramFloat1 + (paramFloat2 - paramFloat1) * paramFloat);
      AppMethodBeat.o(344572);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.sidebar.a
 * JD-Core Version:    0.7.0.1
 */