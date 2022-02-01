package com.tencent.mm.plugin.finder.live.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
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
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.br;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGameJoinGuideBubbleWidget;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "entranceRoot", "Landroid/view/ViewGroup;", "parent", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/content/Context;Landroid/view/ViewGroup;Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "ARROW_SIZE", "", "RIGT_MARGIN", "TAG", "", "arrow", "Landroid/view/View;", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "bubbleHideAnim", "Landroid/animation/ObjectAnimator;", "bubbleRoot", "bubbleShowAnim", "close", "Landroid/widget/ImageView;", "container", "currentEntranceLocX", "currentEntranceLocY", "giftTitleTV", "Landroid/widget/TextView;", "getGiftTitleTV", "()Landroid/widget/TextView;", "setGiftTitleTV", "(Landroid/widget/TextView;)V", "mCloseListener", "Landroid/view/View$OnClickListener;", "getMCloseListener", "()Landroid/view/View$OnClickListener;", "setMCloseListener", "(Landroid/view/View$OnClickListener;)V", "mListener", "getMListener", "setMListener", "paySubtitleTV", "getPaySubtitleTV", "setPaySubtitleTV", "subtitleTV", "getSubtitleTV", "setSubtitleTV", "titleTV", "getTitleTV", "setTitleTV", "adjustBubbleLayout", "", "bubbleAttachToParent", "hideBubble", "hideBubbleAnim", "isLandscape", "", "isShow", "isShowing", "()Ljava/lang/Boolean;", "setGiftTitle", "title", "setSubTitle", "subtitle", "accessibilityDesc", "payment", "setTitle", "allowTwoLines", "setVisibility", "visibility", "showBubble", "showBubbleAnim", "updateBubbleLayout", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
  extends FrameLayout
{
  private ViewGroup CAj;
  private final ViewGroup CZa;
  private final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  private View DmL;
  private ObjectAnimator EqA;
  private ObjectAnimator EqB;
  private final int Eqr;
  private final int Eqs;
  private View Eqt;
  private View.OnClickListener Equ;
  private TextView Eqv;
  private TextView Eqw;
  private ImageView Eqx;
  private int Eqy;
  private int Eqz;
  private final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  private TextView pJJ;
  private final ViewGroup parent;
  private View.OnClickListener qjL;
  private TextView wLg;
  
  public ae(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    super(paramContext);
    AppMethodBeat.i(361723);
    this.CZa = paramViewGroup1;
    this.parent = paramViewGroup2;
    this.nfT = paramb;
    this.CwG = paramb1;
    this.TAG = "Finder.FinderLiveGameJoinGuideBubbleWidget";
    this.Eqr = paramContext.getResources().getDimensionPixelOffset(p.c.Edge_2A);
    this.Eqs = paramContext.getResources().getDimensionPixelOffset(p.c.Edge_2A);
    paramContext = LayoutInflater.from(paramContext).inflate(p.f.CdO, (ViewGroup)this, true);
    s.s(paramContext, "from(context).inflate(R.…idget_layout, this, true)");
    this.Eqt = paramContext;
    paramContext = this.Eqt.findViewById(p.e.close_iv);
    s.s(paramContext, "bubbleRoot.findViewById(R.id.close_iv)");
    this.Eqx = ((ImageView)paramContext);
    this.pJJ = ((TextView)this.Eqt.findViewById(p.e.title));
    this.wLg = ((TextView)this.Eqt.findViewById(p.e.subtitle));
    this.Eqv = ((TextView)this.Eqt.findViewById(p.e.BZh));
    this.Eqw = ((TextView)this.Eqt.findViewById(p.e.BVA));
    this.Eqt.setOnClickListener(new ae..ExternalSyntheticLambda0(this));
    paramContext = this.Eqx;
    if (paramContext != null) {
      paramContext.setOnClickListener(new ae..ExternalSyntheticLambda1(this));
    }
    AppMethodBeat.o(361723);
  }
  
  private static final void a(ae paramae)
  {
    AppMethodBeat.i(361764);
    s.u(paramae, "this$0");
    paramae.CAj = ((ViewGroup)paramae.parent.findViewById(p.e.BUV));
    paramae.DmL = paramae.parent.findViewById(p.e.BUU);
    Object localObject = paramae.CAj;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label153;
      }
      label59:
      Log.i(paramae.TAG, "bubbleAttachToParent, have contain child!");
    }
    for (;;)
    {
      localObject = paramae.CAj;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(0);
      }
      localObject = paramae.DmL;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = paramae.CAj;
      if (localObject != null) {
        ((ViewGroup)localObject).setTag(Integer.valueOf(paramae.getId()));
      }
      paramae.Eqy = 0;
      paramae.Eqz = 0;
      paramae.erX();
      AppMethodBeat.o(361764);
      return;
      localObject = Integer.valueOf(((ViewGroup)localObject).indexOfChild((View)paramae));
      break;
      label153:
      if (((Integer)localObject).intValue() != -1) {
        break label59;
      }
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.gg((View)paramae);
      localObject = paramae.CAj;
      if (localObject != null) {
        ((ViewGroup)localObject).addView((View)paramae);
      }
    }
  }
  
  private static final void a(ae paramae, View paramView)
  {
    AppMethodBeat.i(361746);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramae);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveGameJoinGuideBubbleWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramae, "this$0");
    paramae = paramae.getMListener();
    if (paramae != null) {
      paramae.onClick(paramView);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveGameJoinGuideBubbleWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361746);
  }
  
  private static final void b(ae paramae, View paramView)
  {
    AppMethodBeat.i(361753);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramae);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveGameJoinGuideBubbleWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramae, "this$0");
    paramae.eAP();
    paramae = paramae.getMCloseListener();
    if (paramae != null) {
      paramae.onClick(paramView);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveGameJoinGuideBubbleWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361753);
  }
  
  private boolean isLandscape()
  {
    AppMethodBeat.i(361733);
    if (getContext().getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(361733);
      return true;
    }
    AppMethodBeat.o(361733);
    return false;
  }
  
  public final void Z(String paramString1, String paramString2, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(361898);
    if (TextUtils.isEmpty((CharSequence)paramString1))
    {
      paramString1 = this.wLg;
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
      paramString1 = this.Eqv;
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
      AppMethodBeat.o(361898);
      return;
    }
    Object localObject1 = this.wLg;
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)paramString1);
    }
    if (paramInt <= 0)
    {
      paramString1 = this.Eqv;
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
      paramString1 = this.wLg;
      if (paramString1 != null) {
        paramString1.setVisibility(0);
      }
      if (paramString2 != null)
      {
        paramInt = i;
        if (((CharSequence)paramString2).length() > 0) {
          paramInt = 1;
        }
        if (paramInt != 0)
        {
          paramString1 = getSubtitleTV();
          if (paramString1 != null) {
            paramString1.setContentDescription((CharSequence)paramString2);
          }
          paramString1 = getPaySubtitleTV();
          if (paramString1 != null) {
            paramString1.setContentDescription((CharSequence)" ");
          }
        }
      }
      AppMethodBeat.o(361898);
      return;
    }
    paramString1 = this.Eqv;
    if (paramString1 != null) {
      paramString1.setVisibility(0);
    }
    Object localObject2 = getContext().getString(p.h.CgQ, new Object[] { Integer.valueOf(paramInt) });
    s.s(localObject2, "context.getString(R.stri…team_bubble_pay, payment)");
    paramInt = n.a((CharSequence)localObject2, String.valueOf(paramInt), 0, false, 6);
    paramString1 = getContext();
    localObject1 = ((String)localObject2).substring(0, paramInt);
    s.s(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localObject1 = (CharSequence)localObject1;
    localObject2 = ((String)localObject2).substring(paramInt, ((String)localObject2).length());
    s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localObject2 = (CharSequence)localObject2;
    Object localObject3 = this.wLg;
    if (localObject3 == null) {}
    for (float f = 0.0F;; f = ((TextView)localObject3).getTextSize())
    {
      localObject3 = bb.m(getContext(), p.g.coin_icon, getContext().getResources().getColor(p.b.Brand_100));
      ((Drawable)localObject3).setBounds(0, 0, com.tencent.mm.cd.a.bs(getContext(), p.c.Edge_1_5_A), com.tencent.mm.cd.a.bs(getContext(), p.c.Edge_1_5_A));
      ah localah = ah.aiuX;
      paramString1 = new SpannableStringBuilder((CharSequence)p.a(paramString1, (CharSequence)localObject1, (CharSequence)localObject2, f, (Drawable)localObject3, false));
      localObject1 = this.Eqv;
      if (localObject1 == null) {
        break;
      }
      ((TextView)localObject1).setText((CharSequence)paramString1);
      break;
    }
  }
  
  public final void bE(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(361886);
    TextView localTextView = this.pJJ;
    if (localTextView != null) {
      if (!paramBoolean) {
        break label66;
      }
    }
    label66:
    for (int i = 2;; i = 1)
    {
      localTextView.setMaxLines(i);
      if (TextUtils.isEmpty((CharSequence)paramString)) {
        break;
      }
      localTextView = this.pJJ;
      if (localTextView == null) {
        break label90;
      }
      localTextView.setText((CharSequence)paramString);
      AppMethodBeat.o(361886);
      return;
    }
    paramString = this.pJJ;
    if (paramString != null) {
      paramString.setText((CharSequence)"");
    }
    label90:
    AppMethodBeat.o(361886);
  }
  
  public final boolean cvt()
  {
    AppMethodBeat.i(361955);
    Object localObject = this.CAj;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
    {
      i = 1;
      if (i == 0) {
        break label68;
      }
      localObject = this.DmL;
      if ((localObject == null) || (((View)localObject).getVisibility() != 0)) {
        break label63;
      }
    }
    label63:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label68;
      }
      AppMethodBeat.o(361955);
      return true;
      i = 0;
      break;
    }
    label68:
    AppMethodBeat.o(361955);
    return false;
  }
  
  public final Boolean eAN()
  {
    AppMethodBeat.i(361877);
    if (getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(361877);
      return Boolean.valueOf(bool);
    }
  }
  
  public final void eAO()
  {
    AppMethodBeat.i(361933);
    Object localObject = (br)this.CwG.getPlugin(br.class);
    if ((localObject != null) && (((com.tencent.mm.live.b.a)localObject).mJe.getVisibility() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i(this.TAG, "FinderLivePromoteBubblePlugin is showing, return ");
      AppMethodBeat.o(361933);
      return;
    }
    if (!((e)this.CwG.getBuContext().business(e.class)).DUe)
    {
      this.CZa.post(new ae..ExternalSyntheticLambda2(this));
      Log.i(this.TAG, s.X("showBubbleAnim，parent visibility:", Integer.valueOf(this.parent.getVisibility())));
      if (getVisibility() != 0)
      {
        setVisibility(0);
        if (this.EqA == null) {
          this.EqA = ObjectAnimator.ofFloat(this.parent, "alpha", new float[] { 0.0F, 1.0F });
        }
        localObject = this.EqA;
        if (localObject != null) {
          ((ObjectAnimator)localObject).cancel();
        }
        localObject = this.EqA;
        if (localObject != null) {
          ((ObjectAnimator)localObject).start();
        }
      }
    }
    AppMethodBeat.o(361933);
  }
  
  public final void eAP()
  {
    AppMethodBeat.i(361942);
    Log.i(this.TAG, s.X("v，parent visibility:", Integer.valueOf(this.parent.getVisibility())));
    if (getVisibility() == 0)
    {
      if (this.EqB == null)
      {
        this.EqB = ObjectAnimator.ofFloat(this.parent, "alpha", new float[] { 1.0F, 0.0F });
        localObjectAnimator = this.EqB;
        if (localObjectAnimator != null) {
          localObjectAnimator.addListener((Animator.AnimatorListener)new a(this));
        }
      }
      ObjectAnimator localObjectAnimator = this.EqB;
      if (localObjectAnimator != null) {
        localObjectAnimator.cancel();
      }
      localObjectAnimator = this.EqB;
      if (localObjectAnimator != null) {
        localObjectAnimator.start();
      }
    }
    AppMethodBeat.o(361942);
  }
  
  public final void erX()
  {
    AppMethodBeat.i(361921);
    Object localObject1 = aw.Gjk;
    localObject1 = this.DmL;
    Object localObject2 = this.CAj;
    Object localObject3;
    int j;
    int k;
    int i;
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject3 = new int[2];
      this.CZa.getLocationOnScreen((int[])localObject3);
      if ((this.Eqy == localObject3[0]) && (this.Eqz == localObject3[1]))
      {
        AppMethodBeat.o(361921);
        return;
      }
      this.Eqy = localObject3[0];
      this.Eqz = localObject3[1];
      j = getRootView().getResources().getDisplayMetrics().widthPixels;
      k = bf.getStatusBarHeight(getContext());
      if (!isLandscape())
      {
        i = ((ViewGroup)localObject2).getWidth();
        if (i != 0) {
          break label574;
        }
        i = getContext().getResources().getDimensionPixelOffset(p.c.Edge_26A);
      }
    }
    label574:
    for (;;)
    {
      k = j - localObject3[0] - this.CZa.getWidth() / 2;
      localObject3 = ((ViewGroup)localObject2).getLayoutParams();
      if (localObject3 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(361921);
        throw ((Throwable)localObject1);
      }
      localObject3 = (LinearLayout.LayoutParams)localObject3;
      if (k - i / 2 - this.Eqs > 0) {}
      for (((LinearLayout.LayoutParams)localObject3).rightMargin = (k - i / 2 - this.Eqs);; ((LinearLayout.LayoutParams)localObject3).rightMargin = 0)
      {
        ((ViewGroup)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        j = ((View)localObject1).getWidth();
        i = j;
        if (j == 0) {
          i = this.Eqr;
        }
        i /= 2;
        j = this.Eqs;
        localObject2 = ((View)localObject1).getLayoutParams();
        if (localObject2 != null) {
          break;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(361921);
        throw ((Throwable)localObject1);
      }
      localObject2 = (LinearLayout.LayoutParams)localObject2;
      ((LinearLayout.LayoutParams)localObject2).rightMargin = (k - i - j);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      AppMethodBeat.o(361921);
      return;
      i = ((ViewGroup)localObject2).getWidth();
      if (i == 0) {
        i = getContext().getResources().getDimensionPixelOffset(p.c.Edge_26A);
      }
      for (;;)
      {
        int m = j - localObject3[0] - this.CZa.getWidth() / 2 + k;
        localObject3 = ((ViewGroup)localObject2).getLayoutParams();
        if (localObject3 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(361921);
          throw ((Throwable)localObject1);
        }
        localObject3 = (LinearLayout.LayoutParams)localObject3;
        if (m - i / 2 - this.Eqs > 0) {}
        for (((LinearLayout.LayoutParams)localObject3).rightMargin = (m - i / 2 - this.Eqs);; ((LinearLayout.LayoutParams)localObject3).rightMargin = 0)
        {
          ((ViewGroup)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          j = ((View)localObject1).getWidth();
          i = j;
          if (j == 0) {
            i = this.Eqr;
          }
          i /= 2;
          j = this.Eqs;
          localObject2 = ((View)localObject1).getLayoutParams();
          if (localObject2 != null) {
            break;
          }
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(361921);
          throw ((Throwable)localObject1);
        }
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        ((LinearLayout.LayoutParams)localObject2).rightMargin = (m - i - j + k);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        AppMethodBeat.o(361921);
        return;
      }
    }
  }
  
  public final com.tencent.mm.plugin.finder.live.plugin.b getBasePlugin()
  {
    return this.CwG;
  }
  
  public final TextView getGiftTitleTV()
  {
    return this.Eqw;
  }
  
  public final View.OnClickListener getMCloseListener()
  {
    return this.Equ;
  }
  
  public final View.OnClickListener getMListener()
  {
    return this.qjL;
  }
  
  public final TextView getPaySubtitleTV()
  {
    return this.Eqv;
  }
  
  public final TextView getSubtitleTV()
  {
    return this.wLg;
  }
  
  public final TextView getTitleTV()
  {
    return this.pJJ;
  }
  
  public final void setGiftTitle(String paramString)
  {
    AppMethodBeat.i(361903);
    TextView localTextView = this.Eqw;
    if (localTextView != null) {
      localTextView.setText((CharSequence)paramString);
    }
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      paramString = this.Eqw;
      if (paramString != null)
      {
        paramString.setVisibility(8);
        AppMethodBeat.o(361903);
      }
    }
    else
    {
      paramString = this.Eqw;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
    }
    AppMethodBeat.o(361903);
  }
  
  public final void setGiftTitleTV(TextView paramTextView)
  {
    this.Eqw = paramTextView;
  }
  
  public final void setMCloseListener(View.OnClickListener paramOnClickListener)
  {
    this.Equ = paramOnClickListener;
  }
  
  public final void setMListener(View.OnClickListener paramOnClickListener)
  {
    this.qjL = paramOnClickListener;
  }
  
  public final void setPaySubtitleTV(TextView paramTextView)
  {
    this.Eqv = paramTextView;
  }
  
  public final void setSubtitleTV(TextView paramTextView)
  {
    this.wLg = paramTextView;
  }
  
  public final void setTitleTV(TextView paramTextView)
  {
    this.pJJ = paramTextView;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(361948);
    super.setVisibility(paramInt);
    Object localObject = this.CAj;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(paramInt);
    }
    localObject = this.DmL;
    if (localObject != null) {
      ((View)localObject).setVisibility(paramInt);
    }
    AppMethodBeat.o(361948);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveGameJoinGuideBubbleWidget$hideBubbleAnim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Animator.AnimatorListener
  {
    a(ae paramae) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(361394);
      this.EqC.setVisibility(8);
      AppMethodBeat.o(361394);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ae
 * JD-Core Version:    0.7.0.1
 */