package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/BulletCommentWidget;", "", "bullet", "Landroid/view/ViewGroup;", "commentList", "Landroid/support/v7/widget/RecyclerView;", "(Landroid/view/ViewGroup;Landroid/support/v7/widget/RecyclerView;)V", "ANIMATION_DURATION", "", "getANIMATION_DURATION", "()I", "BULLET_COMMENT_MAX_LENGTH", "getBULLET_COMMENT_MAX_LENGTH", "BULLET_FLY_DISTANCE", "", "getBULLET_FLY_DISTANCE", "()F", "D_0_5_A", "getD_0_5_A", "D_1_5_A", "getD_1_5_A", "STAY_DURATION", "getSTAY_DURATION", "UPDATE_DURATION", "getUPDATE_DURATION", "bulletContentTv", "Landroid/widget/TextView;", "getBulletContentTv", "()Landroid/widget/TextView;", "setBulletContentTv", "(Landroid/widget/TextView;)V", "bulletInAnim", "Landroid/animation/ObjectAnimator;", "getBulletInAnim", "()Landroid/animation/ObjectAnimator;", "setBulletInAnim", "(Landroid/animation/ObjectAnimator;)V", "bulletOutAnim", "getBulletOutAnim", "setBulletOutAnim", "bulletUpdateAnim", "Landroid/view/ViewPropertyAnimator;", "getBulletUpdateAnim", "()Landroid/view/ViewPropertyAnimator;", "setBulletUpdateAnim", "(Landroid/view/ViewPropertyAnimator;)V", "container", "getContainer", "()Landroid/view/ViewGroup;", "setContainer", "(Landroid/view/ViewGroup;)V", "haveNextBullet", "", "getHaveNextBullet", "()Z", "setHaveNextBullet", "(Z)V", "localBullet", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "Lkotlin/collections/ArrayList;", "getLocalBullet", "()Ljava/util/ArrayList;", "setLocalBullet", "(Ljava/util/ArrayList;)V", "sysSpan", "com/tencent/mm/plugin/finder/live/plugin/BulletCommentWidget$sysSpan$1", "Lcom/tencent/mm/plugin/finder/live/plugin/BulletCommentWidget$sysSpan$1;", "adjustMargin", "", "clearLocalBullet", "getNextBulletComment", "getPrintMsg", "", "item", "hideBulletComment", "mergeBulletComment", "remote", "", "printMsgList", "prefix", "msgList", "", "debugPrint", "setBulletComment", "liveMsg", "setContent", "msg", "showBulletComment", "pushAnim", "showNextBullet", "updateBulletComment", "bulletCommentList", "plugin-finder_release"})
public final class b
{
  private final int ANIMATION_DURATION;
  private final int ulA;
  private final float ulB;
  private final int ulC;
  final int ulD;
  private final int ulE;
  private final int ulF;
  ViewGroup ulG;
  TextView ulH;
  ObjectAnimator ulI;
  ObjectAnimator ulJ;
  ViewPropertyAnimator ulK;
  ArrayList<awq> ulL;
  boolean ulM;
  private final b ulN;
  final ViewGroup ulO;
  final RecyclerView ulP;
  
  public b(ViewGroup paramViewGroup, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(246381);
    this.ulO = paramViewGroup;
    this.ulP = paramRecyclerView;
    this.ulA = 2000;
    this.ANIMATION_DURATION = 500;
    this.ulB = -500.0F;
    this.ulC = 1000;
    paramViewGroup = com.tencent.mm.plugin.finder.storage.c.vCb;
    this.ulD = com.tencent.mm.plugin.finder.storage.c.dvd();
    paramViewGroup = MMApplicationContext.getContext();
    p.g(paramViewGroup, "MMApplicationContext.getContext()");
    this.ulE = paramViewGroup.getResources().getDimensionPixelSize(2131165277);
    paramViewGroup = MMApplicationContext.getContext();
    p.g(paramViewGroup, "MMApplicationContext.getContext()");
    this.ulF = paramViewGroup.getResources().getDimensionPixelSize(2131165289);
    this.ulG = this.ulO;
    paramViewGroup = this.ulG.findViewById(2131297859);
    p.g(paramViewGroup, "container.findViewById(R…_comment_item_content_tv)");
    this.ulH = ((TextView)paramViewGroup);
    this.ulL = new ArrayList();
    this.ulN = new b();
    this.ulG.setVisibility(8);
    paramViewGroup = ObjectAnimator.ofFloat(this.ulG, "alpha", new float[] { 1.0F, 0.0F });
    p.g(paramViewGroup, "ObjectAnimator.ofFloat(container, \"alpha\", 1f, 0f)");
    this.ulJ = paramViewGroup;
    this.ulJ.setDuration(this.ANIMATION_DURATION);
    this.ulJ.addListener((Animator.AnimatorListener)new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(246368);
        paramAnonymousAnimator = this.ulQ.ulJ.getTarget();
        if (paramAnonymousAnimator == null)
        {
          paramAnonymousAnimator = new t("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(246368);
          throw paramAnonymousAnimator;
        }
        ((View)paramAnonymousAnimator).setVisibility(8);
        AppMethodBeat.o(246368);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    paramViewGroup = ObjectAnimator.ofFloat(this.ulG, "translationX", new float[] { this.ulB, 0.0F });
    p.g(paramViewGroup, "ObjectAnimator.ofFloat(c… BULLET_FLY_DISTANCE, 0f)");
    this.ulI = paramViewGroup;
    this.ulI.setDuration(this.ANIMATION_DURATION + this.ulA);
    this.ulI.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    this.ulI.setEvaluator((TypeEvaluator)new c(this.ANIMATION_DURATION, this.ulA));
    this.ulI.addListener((Animator.AnimatorListener)new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(246369);
        if (!this.ulQ.ulM)
        {
          this.ulQ.ulJ.start();
          AppMethodBeat.o(246369);
          return;
        }
        this.ulQ.np(false);
        AppMethodBeat.o(246369);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(246370);
        paramAnonymousAnimator = this.ulQ.ulI.getTarget();
        if (paramAnonymousAnimator == null)
        {
          paramAnonymousAnimator = new t("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(246370);
          throw paramAnonymousAnimator;
        }
        paramAnonymousAnimator = (View)paramAnonymousAnimator;
        paramAnonymousAnimator.setAlpha(1.0F);
        paramAnonymousAnimator.setVisibility(0);
        AppMethodBeat.o(246370);
      }
    });
    paramViewGroup = this.ulG.animate().setDuration(this.ulC).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(246371);
        if (!this.ulQ.ulM)
        {
          this.ulQ.ulJ.start();
          AppMethodBeat.o(246371);
          return;
        }
        this.ulQ.np(false);
        AppMethodBeat.o(246371);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(246372);
        this.ulQ.ulG.setAlpha(1.0F);
        this.ulQ.ulG.setVisibility(0);
        AppMethodBeat.o(246372);
      }
    });
    p.g(paramViewGroup, "container.animate().setD…            }\n\n        })");
    this.ulK = paramViewGroup;
    paramViewGroup = com.tencent.mm.live.core.core.d.b.hCo;
    if (com.tencent.mm.live.core.core.d.b.a.aDp())
    {
      this.ulH.setTextSize(1, 15.0F);
      AppMethodBeat.o(246381);
      return;
    }
    this.ulH.setTextSize(1, 17.0F);
    AppMethodBeat.o(246381);
  }
  
  static void b(String paramString, List<? extends awq> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(246380);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(246380);
      return;
    }
    if (paramBoolean)
    {
      y localy = y.vXH;
      if (!y.dCM())
      {
        AppMethodBeat.o(246380);
        return;
      }
    }
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Log.i("Finder.LiveCommentPlugin", paramString + " msg:" + com.tencent.mm.ac.g.bN(paramList.get(i)));
      i += 1;
    }
    AppMethodBeat.o(246380);
  }
  
  final void a(String paramString, awq paramawq)
  {
    AppMethodBeat.i(246379);
    paramawq = paramawq.LHp;
    int i;
    label29:
    Object localObject1;
    if (paramawq != null)
    {
      paramawq = paramawq.LDK;
      if (paramawq == null) {
        break label251;
      }
      i = paramawq.LFX;
      Log.i("Finder.LiveCommentPlugin", "attachBadgeInfo badgeLevel:".concat(String.valueOf(i)));
      if (i != 1) {
        break label264;
      }
      localObject1 = this.ulG.getContext().getString(2131760121, new Object[] { Integer.valueOf(i) });
      p.g(localObject1, "container.context.getStr…_badge_level, badgeLevel)");
      paramString = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(this.ulG.getContext(), (CharSequence)((String)localObject1 + paramString)));
      Object localObject2 = com.tencent.mm.plugin.finder.utils.m.vVH;
      localObject2 = com.tencent.mm.plugin.finder.utils.m.bd(i, (String)localObject1);
      ((com.tencent.mm.plugin.finder.live.model.g)localObject2).ag((String)localObject1, (String)localObject1, String.valueOf(i));
      if (paramawq == null) {
        break label256;
      }
      paramawq = paramawq.LFY;
      label159:
      ((com.tencent.mm.plugin.finder.live.model.g)localObject2).atC(paramawq);
      paramString.a(localObject2, (CharSequence)localObject1, 0);
      localObject1 = this.ulH.getParent();
      paramawq = (awq)localObject1;
      if (!(localObject1 instanceof RelativeLayout)) {
        paramawq = null;
      }
      paramawq = (RelativeLayout)paramawq;
      if (paramawq == null) {
        break label261;
      }
      paramawq.setPadding(this.ulE, paramawq.getPaddingTop(), paramawq.getPaddingRight(), paramawq.getPaddingBottom());
    }
    for (;;)
    {
      this.ulH.setText((CharSequence)paramString);
      AppMethodBeat.o(246379);
      return;
      paramawq = null;
      break;
      label251:
      i = 0;
      break label29;
      label256:
      paramawq = null;
      break label159;
      label261:
      continue;
      label264:
      paramString = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(this.ulG.getContext(), (CharSequence)paramString));
      localObject1 = this.ulH.getParent();
      paramawq = (awq)localObject1;
      if (!(localObject1 instanceof RelativeLayout)) {
        paramawq = null;
      }
      paramawq = (RelativeLayout)paramawq;
      if (paramawq != null) {
        paramawq.setPadding(this.ulF, paramawq.getPaddingTop(), paramawq.getPaddingRight(), paramawq.getPaddingBottom());
      }
    }
  }
  
  public final void dZ(final List<awq> paramList)
  {
    AppMethodBeat.i(246377);
    p.h(paramList, "bulletCommentList");
    d.h((a)new c(this, paramList));
    AppMethodBeat.o(246377);
  }
  
  public final void dgJ()
  {
    AppMethodBeat.i(246376);
    this.ulG.setVisibility(8);
    this.ulI.cancel();
    this.ulJ.cancel();
    this.ulK.cancel();
    AppMethodBeat.o(246376);
  }
  
  public final void np(final boolean paramBoolean)
  {
    AppMethodBeat.i(246378);
    d.h((a)new a(this, paramBoolean));
    AppMethodBeat.o(246378);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(b paramb, boolean paramBoolean)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/BulletCommentWidget$sysSpan$1", "Landroid/text/style/CharacterStyle;", "updateDrawState", "", "tp", "Landroid/text/TextPaint;", "plugin-finder_release"})
  public static final class b
    extends CharacterStyle
  {
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(246374);
      Context localContext = MMApplicationContext.getContext();
      p.g(localContext, "MMApplicationContext.getContext()");
      int i = localContext.getResources().getColor(2131100585);
      if (paramTextPaint != null) {
        paramTextPaint.setColor(i);
      }
      if (paramTextPaint != null)
      {
        paramTextPaint.setUnderlineText(false);
        AppMethodBeat.o(246374);
        return;
      }
      AppMethodBeat.o(246374);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(b paramb, List paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.b
 * JD-Core Version:    0.7.0.1
 */