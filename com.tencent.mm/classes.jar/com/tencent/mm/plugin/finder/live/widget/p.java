package com.tencent.mm.plugin.finder.live.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ax;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGameJoinGuideBubbleWidget;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "entranceRoot", "Landroid/view/ViewGroup;", "parent", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/content/Context;Landroid/view/ViewGroup;Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "ARROW_SIZE", "", "RIGT_MARGIN", "TAG", "", "arrow", "Landroid/view/View;", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "bubbleHideAnim", "Landroid/animation/ObjectAnimator;", "bubbleRoot", "bubbleShowAnim", "close", "Landroid/widget/ImageView;", "container", "mCloseListener", "Landroid/view/View$OnClickListener;", "getMCloseListener", "()Landroid/view/View$OnClickListener;", "setMCloseListener", "(Landroid/view/View$OnClickListener;)V", "mListener", "getMListener", "setMListener", "subtitleTV", "Landroid/widget/TextView;", "getSubtitleTV", "()Landroid/widget/TextView;", "setSubtitleTV", "(Landroid/widget/TextView;)V", "titleTV", "getTitleTV", "setTitleTV", "adjustBubbleLayout", "", "bubbleAttachToParent", "hideBubble", "hideBubbleAnim", "isLandscape", "", "isShow", "isShowing", "()Ljava/lang/Boolean;", "setSubTitle", "subtitle", "setTitle", "title", "setVisibility", "visibility", "showBubble", "showBubbleAnim", "updateBubbleLayout", "plugin-finder_release"})
public final class p
  extends FrameLayout
{
  private final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  private TextView mNb;
  private View.OnClickListener nmC;
  private final ViewGroup parent;
  private TextView tHw;
  private final d xYq;
  View yXd;
  ViewGroup ybY;
  final int znO;
  final int znP;
  private View znQ;
  private View.OnClickListener znR;
  private ImageView znS;
  private ObjectAnimator znT;
  private ObjectAnimator znU;
  final ViewGroup znV;
  
  public p(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, com.tencent.mm.live.c.b paramb, d paramd)
  {
    super(paramContext);
    AppMethodBeat.i(269202);
    this.znV = paramViewGroup1;
    this.parent = paramViewGroup2;
    this.kCL = paramb;
    this.xYq = paramd;
    this.TAG = "Finder.FinderLiveGameJoinGuideBubbleWidget";
    this.znO = paramContext.getResources().getDimensionPixelOffset(b.d.Edge_2A);
    this.znP = paramContext.getResources().getDimensionPixelOffset(b.d.Edge_2A);
    paramContext = LayoutInflater.from(paramContext).inflate(b.g.finder_live_game_join_guide_bubble_widget_layout, (ViewGroup)this, true);
    kotlin.g.b.p.j(paramContext, "LayoutInflater.from(cont…idget_layout, this, true)");
    this.znQ = paramContext;
    paramContext = this.znQ.findViewById(b.f.close_iv);
    kotlin.g.b.p.j(paramContext, "bubbleRoot.findViewById(R.id.close_iv)");
    this.znS = ((ImageView)paramContext);
    this.mNb = ((TextView)this.znQ.findViewById(b.f.title));
    this.tHw = ((TextView)this.znQ.findViewById(b.f.subtitle));
    paramContext = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    com.tencent.mm.plugin.finder.live.utils.a.eB((View)this.znS);
    this.znQ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(265693);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveGameJoinGuideBubbleWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = this.znW.getMListener();
        if (localObject != null) {
          ((View.OnClickListener)localObject).onClick(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveGameJoinGuideBubbleWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(265693);
      }
    });
    paramContext = this.znS;
    if (paramContext != null)
    {
      paramContext.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(227900);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveGameJoinGuideBubbleWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          this.znW.dIk();
          localObject = this.znW.getMCloseListener();
          if (localObject != null) {
            ((View.OnClickListener)localObject).onClick(paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveGameJoinGuideBubbleWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(227900);
        }
      });
      AppMethodBeat.o(269202);
      return;
    }
    AppMethodBeat.o(269202);
  }
  
  public final boolean bVd()
  {
    AppMethodBeat.i(269201);
    Object localObject = this.ybY;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
    {
      localObject = this.yXd;
      if ((localObject != null) && (((View)localObject).getVisibility() == 0))
      {
        AppMethodBeat.o(269201);
        return true;
      }
    }
    AppMethodBeat.o(269201);
    return false;
  }
  
  public final void dIj()
  {
    AppMethodBeat.i(269198);
    this.znV.post((Runnable)new a(this));
    Log.i(this.TAG, "showBubbleAnim，parent visibility:" + this.parent.getVisibility());
    if (getVisibility() != 0)
    {
      setVisibility(0);
      if (this.znT == null) {
        this.znT = ObjectAnimator.ofFloat(this.parent, "alpha", new float[] { 0.0F, 1.0F });
      }
      ObjectAnimator localObjectAnimator = this.znT;
      if (localObjectAnimator != null) {
        localObjectAnimator.cancel();
      }
      localObjectAnimator = this.znT;
      if (localObjectAnimator != null)
      {
        localObjectAnimator.start();
        AppMethodBeat.o(269198);
        return;
      }
    }
    AppMethodBeat.o(269198);
  }
  
  public final void dIk()
  {
    AppMethodBeat.i(269199);
    Log.i(this.TAG, "v，parent visibility:" + this.parent.getVisibility());
    if (getVisibility() == 0)
    {
      if (this.znU == null)
      {
        this.znU = ObjectAnimator.ofFloat(this.parent, "alpha", new float[] { 1.0F, 0.0F });
        localObjectAnimator = this.znU;
        if (localObjectAnimator != null) {
          localObjectAnimator.addListener((Animator.AnimatorListener)new b(this));
        }
      }
      ObjectAnimator localObjectAnimator = this.znU;
      if (localObjectAnimator != null) {
        localObjectAnimator.cancel();
      }
      localObjectAnimator = this.znU;
      if (localObjectAnimator != null)
      {
        localObjectAnimator.start();
        AppMethodBeat.o(269199);
        return;
      }
    }
    AppMethodBeat.o(269199);
  }
  
  public final d getBasePlugin()
  {
    return this.xYq;
  }
  
  public final View.OnClickListener getMCloseListener()
  {
    return this.znR;
  }
  
  public final View.OnClickListener getMListener()
  {
    return this.nmC;
  }
  
  public final TextView getSubtitleTV()
  {
    return this.tHw;
  }
  
  public final TextView getTitleTV()
  {
    return this.mNb;
  }
  
  public final void setMCloseListener(View.OnClickListener paramOnClickListener)
  {
    this.znR = paramOnClickListener;
  }
  
  public final void setMListener(View.OnClickListener paramOnClickListener)
  {
    this.nmC = paramOnClickListener;
  }
  
  public final void setSubTitle(String paramString)
  {
    AppMethodBeat.i(269197);
    TextView localTextView = this.tHw;
    if (localTextView != null) {
      localTextView.setText((CharSequence)paramString);
    }
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      paramString = this.tHw;
      if (paramString != null)
      {
        paramString.setVisibility(8);
        AppMethodBeat.o(269197);
        return;
      }
      AppMethodBeat.o(269197);
      return;
    }
    paramString = this.tHw;
    if (paramString != null)
    {
      paramString.setVisibility(0);
      AppMethodBeat.o(269197);
      return;
    }
    AppMethodBeat.o(269197);
  }
  
  public final void setSubtitleTV(TextView paramTextView)
  {
    this.tHw = paramTextView;
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(269196);
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      TextView localTextView = this.mNb;
      if (localTextView != null)
      {
        localTextView.setText((CharSequence)paramString);
        AppMethodBeat.o(269196);
        return;
      }
      AppMethodBeat.o(269196);
      return;
    }
    paramString = this.mNb;
    if (paramString != null)
    {
      paramString.setText((CharSequence)"");
      AppMethodBeat.o(269196);
      return;
    }
    AppMethodBeat.o(269196);
  }
  
  public final void setTitleTV(TextView paramTextView)
  {
    this.mNb = paramTextView;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(269200);
    super.setVisibility(paramInt);
    Object localObject = this.ybY;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(paramInt);
    }
    localObject = this.yXd;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(paramInt);
      AppMethodBeat.o(269200);
      return;
    }
    AppMethodBeat.o(269200);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(p paramp) {}
    
    public final void run()
    {
      AppMethodBeat.i(285314);
      p.a(this.znW);
      Object localObject1 = p.b(this.znW);
      label48:
      label60:
      Object localObject2;
      ViewGroup localViewGroup;
      Object localObject3;
      Object localObject4;
      int j;
      int k;
      int i;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((ViewGroup)localObject1).indexOfChild((View)this.znW));
        if (localObject1 != null) {
          break label362;
        }
        Log.i(p.c(this.znW), "bubbleAttachToParent, have contain child!");
        localObject1 = p.b(this.znW);
        if (localObject1 != null) {
          ((ViewGroup)localObject1).setVisibility(0);
        }
        localObject1 = p.d(this.znW);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        localObject1 = p.b(this.znW);
        if (localObject1 != null) {
          ((ViewGroup)localObject1).setTag(Integer.valueOf(this.znW.getId()));
        }
        localObject2 = this.znW;
        localObject1 = aj.AGc;
        localObject1 = ((p)localObject2).yXd;
        localViewGroup = ((p)localObject2).ybY;
        if ((localObject1 == null) || (localViewGroup == null)) {
          break label804;
        }
        localObject3 = new int[2];
        ((p)localObject2).znV.getLocationOnScreen((int[])localObject3);
        localObject4 = ((p)localObject2).getRootView();
        kotlin.g.b.p.j(localObject4, "rootView");
        localObject4 = ((View)localObject4).getResources();
        kotlin.g.b.p.j(localObject4, "rootView.resources");
        j = ((Resources)localObject4).getDisplayMetrics().widthPixels;
        k = ax.getStatusBarHeight(((p)localObject2).getContext());
        localObject4 = ((p)localObject2).getContext();
        kotlin.g.b.p.j(localObject4, "context");
        localObject4 = ((Context)localObject4).getResources();
        kotlin.g.b.p.j(localObject4, "context.resources");
        if (((Resources)localObject4).getConfiguration().orientation != 2) {
          break label416;
        }
        i = 1;
        label267:
        if (i != 0) {
          break label569;
        }
        i = localViewGroup.getWidth();
        if (i != 0) {
          break label813;
        }
        localObject4 = ((p)localObject2).getContext();
        kotlin.g.b.p.j(localObject4, "context");
        i = ((Context)localObject4).getResources().getDimensionPixelOffset(b.d.Edge_26A);
      }
      label416:
      label804:
      label813:
      for (;;)
      {
        k = j - localObject3[0] - ((p)localObject2).znV.getWidth() / 2;
        localObject3 = localViewGroup.getLayoutParams();
        if (localObject3 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(285314);
          throw ((Throwable)localObject1);
          localObject1 = null;
          break;
          label362:
          if (((Integer)localObject1).intValue() != -1) {
            break label48;
          }
          localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          com.tencent.mm.plugin.finder.live.utils.a.eC((View)this.znW);
          localObject1 = p.b(this.znW);
          if (localObject1 == null) {
            break label60;
          }
          ((ViewGroup)localObject1).addView((View)this.znW);
          break label60;
          i = 0;
          break label267;
        }
        localObject3 = (LinearLayout.LayoutParams)localObject3;
        if (k - i / 2 - ((p)localObject2).znP > 0) {}
        for (((LinearLayout.LayoutParams)localObject3).rightMargin = (k - i / 2 - ((p)localObject2).znP);; ((LinearLayout.LayoutParams)localObject3).rightMargin = 0)
        {
          localViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          j = ((View)localObject1).getWidth();
          i = j;
          if (j == 0) {
            i = ((p)localObject2).znO;
          }
          i /= 2;
          j = ((p)localObject2).znP;
          localObject2 = ((View)localObject1).getLayoutParams();
          if (localObject2 != null) {
            break;
          }
          localObject1 = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(285314);
          throw ((Throwable)localObject1);
        }
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        ((LinearLayout.LayoutParams)localObject2).rightMargin = (k - i - j);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        AppMethodBeat.o(285314);
        return;
        label569:
        i = localViewGroup.getWidth();
        if (i == 0)
        {
          localObject4 = ((p)localObject2).getContext();
          kotlin.g.b.p.j(localObject4, "context");
          i = ((Context)localObject4).getResources().getDimensionPixelOffset(b.d.Edge_26A);
        }
        for (;;)
        {
          int m = j - localObject3[0] - ((p)localObject2).znV.getWidth() / 2 + k;
          localObject3 = localViewGroup.getLayoutParams();
          if (localObject3 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            AppMethodBeat.o(285314);
            throw ((Throwable)localObject1);
          }
          localObject3 = (LinearLayout.LayoutParams)localObject3;
          if (m - i / 2 - ((p)localObject2).znP > 0) {}
          for (((LinearLayout.LayoutParams)localObject3).rightMargin = (m - i / 2 - ((p)localObject2).znP);; ((LinearLayout.LayoutParams)localObject3).rightMargin = 0)
          {
            localViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject3);
            j = ((View)localObject1).getWidth();
            i = j;
            if (j == 0) {
              i = ((p)localObject2).znO;
            }
            i /= 2;
            j = ((p)localObject2).znP;
            localObject2 = ((View)localObject1).getLayoutParams();
            if (localObject2 != null) {
              break;
            }
            localObject1 = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            AppMethodBeat.o(285314);
            throw ((Throwable)localObject1);
          }
          localObject2 = (LinearLayout.LayoutParams)localObject2;
          ((LinearLayout.LayoutParams)localObject2).rightMargin = (m - i - j + k);
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          AppMethodBeat.o(285314);
          return;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/widget/FinderLiveGameJoinGuideBubbleWidget$hideBubbleAnim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(289188);
      this.znW.setVisibility(8);
      AppMethodBeat.o(289188);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.p
 * JD-Core Version:    0.7.0.1
 */