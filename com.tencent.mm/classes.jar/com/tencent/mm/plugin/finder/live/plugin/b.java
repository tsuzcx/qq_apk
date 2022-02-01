package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.g;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.bbd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/BulletCommentWidget;", "", "bullet", "Landroid/view/ViewGroup;", "commentList", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroid/view/ViewGroup;Landroidx/recyclerview/widget/RecyclerView;)V", "bulletContentTv", "Landroid/widget/TextView;", "getBulletContentTv", "()Landroid/widget/TextView;", "setBulletContentTv", "(Landroid/widget/TextView;)V", "bulletInAnim", "Landroid/animation/ObjectAnimator;", "getBulletInAnim", "()Landroid/animation/ObjectAnimator;", "setBulletInAnim", "(Landroid/animation/ObjectAnimator;)V", "bulletOutAnim", "getBulletOutAnim", "setBulletOutAnim", "bulletUpdateAnim", "Landroid/view/ViewPropertyAnimator;", "getBulletUpdateAnim", "()Landroid/view/ViewPropertyAnimator;", "setBulletUpdateAnim", "(Landroid/view/ViewPropertyAnimator;)V", "container", "getContainer", "()Landroid/view/ViewGroup;", "setContainer", "(Landroid/view/ViewGroup;)V", "haveNextBullet", "", "getHaveNextBullet", "()Z", "setHaveNextBullet", "(Z)V", "localBullet", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "Lkotlin/collections/ArrayList;", "getLocalBullet", "()Ljava/util/ArrayList;", "setLocalBullet", "(Ljava/util/ArrayList;)V", "shoppingIconSize", "", "getShoppingIconSize", "()I", "setShoppingIconSize", "(I)V", "sysSpan", "com/tencent/mm/plugin/finder/live/plugin/BulletCommentWidget$sysSpan$1", "Lcom/tencent/mm/plugin/finder/live/plugin/BulletCommentWidget$sysSpan$1;", "adjustMargin", "", "clearLocalBullet", "getNextBulletComment", "getPrintMsg", "", "item", "getShoppingSpan", "Landroid/text/style/ImageSpan;", "hideBulletComment", "mergeBulletComment", "remote", "", "printMsgList", "prefix", "msgList", "", "debugPrint", "setBulletComment", "liveMsg", "setContent", "msg", "showBulletComment", "pushAnim", "showNextBullet", "updateBulletComment", "bulletCommentList", "Companion", "plugin-finder_release"})
public final class b
{
  static final int ygm;
  static final int ygn;
  private static final int ykO;
  static final int ykP;
  private static final int ykQ;
  private static final int ykR;
  public static final a ykS;
  ViewGroup ybY;
  TextView ykE;
  ObjectAnimator ykF;
  ObjectAnimator ykG;
  ViewPropertyAnimator ykH;
  ArrayList<bbd> ykI;
  boolean ykJ;
  int ykK;
  private final c ykL;
  final ViewGroup ykM;
  final RecyclerView ykN;
  
  static
  {
    AppMethodBeat.i(267989);
    ykS = new a((byte)0);
    Object localObject = com.tencent.c.a.a.a.a.a.Zlt;
    ykO = com.tencent.c.a.a.a.a.a.imR();
    localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    ygn = ((Context)localObject).getResources().getDimensionPixelSize(com.tencent.mm.plugin.finder.b.d.Edge_0_5_A);
    localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    ygm = ((Context)localObject).getResources().getDimensionPixelSize(com.tencent.mm.plugin.finder.b.d.Edge_A);
    localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    ykP = ((Context)localObject).getResources().getDimensionPixelSize(com.tencent.mm.plugin.finder.b.d.Edge_1_5_A);
    localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    ykQ = ((Context)localObject).getResources().getDimensionPixelSize(com.tencent.mm.plugin.finder.b.d.Edge_2A);
    localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    ykR = ((Context)localObject).getResources().getDimensionPixelSize(com.tencent.mm.plugin.finder.b.d.Edge_2_5_A);
    AppMethodBeat.o(267989);
  }
  
  public b(ViewGroup paramViewGroup, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(267988);
    this.ykM = paramViewGroup;
    this.ykN = paramRecyclerView;
    this.ybY = this.ykM;
    paramViewGroup = this.ybY.findViewById(b.f.bullet_comment_item_content_tv);
    p.j(paramViewGroup, "container.findViewById(R…_comment_item_content_tv)");
    this.ykE = ((TextView)paramViewGroup);
    this.ykI = new ArrayList();
    this.ykK = ykQ;
    this.ykL = new c();
    this.ybY.setVisibility(8);
    paramViewGroup = ObjectAnimator.ofFloat(this.ybY, "alpha", new float[] { 1.0F, 0.0F });
    p.j(paramViewGroup, "ObjectAnimator.ofFloat(container, \"alpha\", 1f, 0f)");
    this.ykG = paramViewGroup;
    this.ykG.setDuration(500L);
    this.ykG.addListener((Animator.AnimatorListener)new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(275488);
        paramAnonymousAnimator = this.ykT.ykG.getTarget();
        if (paramAnonymousAnimator == null)
        {
          paramAnonymousAnimator = new t("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(275488);
          throw paramAnonymousAnimator;
        }
        ((View)paramAnonymousAnimator).setVisibility(8);
        AppMethodBeat.o(275488);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    paramViewGroup = ObjectAnimator.ofFloat(this.ybY, "translationX", new float[] { -500.0F, 0.0F });
    p.j(paramViewGroup, "ObjectAnimator.ofFloat(c… BULLET_FLY_DISTANCE, 0f)");
    this.ykF = paramViewGroup;
    this.ykF.setDuration(2500L);
    this.ykF.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    this.ykF.setEvaluator((TypeEvaluator)new c());
    this.ykF.addListener((Animator.AnimatorListener)new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(279783);
        if (!this.ykT.ykJ)
        {
          this.ykT.ykG.start();
          AppMethodBeat.o(279783);
          return;
        }
        this.ykT.oS(false);
        AppMethodBeat.o(279783);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(279784);
        paramAnonymousAnimator = this.ykT.ykF.getTarget();
        if (paramAnonymousAnimator == null)
        {
          paramAnonymousAnimator = new t("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(279784);
          throw paramAnonymousAnimator;
        }
        paramAnonymousAnimator = (View)paramAnonymousAnimator;
        paramAnonymousAnimator.setAlpha(1.0F);
        paramAnonymousAnimator.setVisibility(0);
        AppMethodBeat.o(279784);
      }
    });
    paramViewGroup = this.ybY.animate().setDuration(1000L).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(291604);
        if (!this.ykT.ykJ)
        {
          this.ykT.ykG.start();
          AppMethodBeat.o(291604);
          return;
        }
        this.ykT.oS(false);
        AppMethodBeat.o(291604);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(291605);
        this.ykT.ybY.setAlpha(1.0F);
        this.ykT.ybY.setVisibility(0);
        AppMethodBeat.o(291605);
      }
    });
    p.j(paramViewGroup, "container.animate().setD…            }\n\n        })");
    this.ykH = paramViewGroup;
    paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
    {
      this.ykE.setTextSize(1, 17.0F);
      this.ykK = ykR;
      AppMethodBeat.o(267988);
      return;
    }
    this.ykE.setTextSize(1, 15.0F);
    this.ykK = ykQ;
    AppMethodBeat.o(267988);
  }
  
  private static void b(String paramString, List<? extends bbd> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(267987);
    aj localaj = aj.AGc;
    if ((!aj.eej()) || (!paramBoolean) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(267987);
      return;
    }
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Log.i("Finder.LiveCommentPlugin", paramString + " msg:" + g.bN(paramList.get(i)));
      i += 1;
    }
    AppMethodBeat.o(267987);
  }
  
  public final void dAm()
  {
    AppMethodBeat.i(267982);
    this.ybY.setVisibility(8);
    this.ykF.cancel();
    this.ykG.cancel();
    this.ykH.cancel();
    AppMethodBeat.o(267982);
  }
  
  public final void eo(final List<bbd> paramList)
  {
    AppMethodBeat.i(267983);
    p.k(paramList, "bulletCommentList");
    d.uiThread((kotlin.g.a.a)new d(this, paramList));
    AppMethodBeat.o(267983);
  }
  
  public final void oS(final boolean paramBoolean)
  {
    AppMethodBeat.i(267985);
    d.uiThread((kotlin.g.a.a)new b(this, paramBoolean));
    AppMethodBeat.o(267985);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/BulletCommentWidget$Companion;", "", "()V", "ANIMATION_DURATION", "", "BULLET_COMMENT_MAX_LENGTH", "getBULLET_COMMENT_MAX_LENGTH", "()I", "BULLET_FLY_DISTANCE", "", "D_0_5_A", "getD_0_5_A", "D_1_5_A", "getD_1_5_A", "D_2A", "getD_2A", "D_2_5_A", "getD_2_5_A", "D_A", "getD_A", "STAY_DURATION", "UPDATE_DURATION", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(b paramb, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/BulletCommentWidget$sysSpan$1", "Landroid/text/style/CharacterStyle;", "updateDrawState", "", "tp", "Landroid/text/TextPaint;", "plugin-finder_release"})
  public static final class c
    extends CharacterStyle
  {
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(291221);
      Context localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      int i = localContext.getResources().getColor(com.tencent.mm.plugin.finder.b.c.half_alpha_white);
      if (paramTextPaint != null) {
        paramTextPaint.setColor(i);
      }
      if (paramTextPaint != null)
      {
        paramTextPaint.setUnderlineText(false);
        AppMethodBeat.o(291221);
        return;
      }
      AppMethodBeat.o(291221);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(b paramb, List paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.b
 * JD-Core Version:    0.7.0.1
 */