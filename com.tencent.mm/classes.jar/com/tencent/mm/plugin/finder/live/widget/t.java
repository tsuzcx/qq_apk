package com.tencent.mm.plugin.finder.live.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.f;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveBulletCommentWidget;", "", "bullet", "Landroid/view/ViewGroup;", "commentList", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroid/view/ViewGroup;Landroidx/recyclerview/widget/RecyclerView;)V", "bulletBgDrawableList", "Ljava/util/HashMap;", "", "Landroid/graphics/drawable/Drawable;", "Lkotlin/collections/HashMap;", "getBulletBgDrawableList", "()Ljava/util/HashMap;", "bulletBgDrawableList$delegate", "Lkotlin/Lazy;", "bulletContentTv", "Landroid/widget/TextView;", "getBulletContentTv", "()Landroid/widget/TextView;", "setBulletContentTv", "(Landroid/widget/TextView;)V", "bulletInAnim", "Landroid/animation/ObjectAnimator;", "getBulletInAnim", "()Landroid/animation/ObjectAnimator;", "setBulletInAnim", "(Landroid/animation/ObjectAnimator;)V", "bulletOutAnim", "getBulletOutAnim", "setBulletOutAnim", "bulletUpdateAnim", "Landroid/view/ViewPropertyAnimator;", "getBulletUpdateAnim", "()Landroid/view/ViewPropertyAnimator;", "setBulletUpdateAnim", "(Landroid/view/ViewPropertyAnimator;)V", "container", "getContainer", "()Landroid/view/ViewGroup;", "setContainer", "(Landroid/view/ViewGroup;)V", "haveNextBullet", "", "getHaveNextBullet", "()Z", "setHaveNextBullet", "(Z)V", "localBullet", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "Lkotlin/collections/ArrayList;", "getLocalBullet", "()Ljava/util/ArrayList;", "setLocalBullet", "(Ljava/util/ArrayList;)V", "shoppingIconSize", "getShoppingIconSize", "()I", "setShoppingIconSize", "(I)V", "adjustMargin", "", "clearLocalBullet", "getJoinLiveBg", "extInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveJoinLiveMsgExtInfo;", "getNextBulletComment", "getPrintMsg", "", "item", "getShoppingSpan", "Landroid/text/style/ImageSpan;", "hideBulletComment", "mergeBulletComment", "remote", "", "printMsgList", "prefix", "msgList", "", "debugPrint", "setBulletComment", "liveMsg", "setContent", "msg", "showBulletComment", "pushAnim", "showNextBullet", "updateBulletComment", "bulletCommentList", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
{
  private static final int DWQ;
  private static final int DWT;
  public static final t.a EnA;
  private static final int EnL;
  private static final int EnM;
  private static final int EnN;
  private static final int EnO;
  private static final int EnP;
  ViewGroup CAj;
  private final ViewGroup EnB;
  private final RecyclerView EnC;
  private final j EnD;
  private TextView EnE;
  ObjectAnimator EnF;
  ObjectAnimator EnG;
  private ViewPropertyAnimator EnH;
  public ArrayList<aq> EnI;
  boolean EnJ;
  private int EnK;
  
  static
  {
    AppMethodBeat.i(362300);
    EnA = new t.a((byte)0);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    EnL = com.tencent.d.a.a.a.a.a.jTy();
    EnM = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_A);
    DWT = MMApplicationContext.getContext().getResources().getDimensionPixelSize(p.c.Edge_0_5_A);
    DWQ = MMApplicationContext.getContext().getResources().getDimensionPixelSize(p.c.Edge_A);
    EnN = MMApplicationContext.getContext().getResources().getDimensionPixelSize(p.c.Edge_1_5_A);
    EnO = MMApplicationContext.getContext().getResources().getDimensionPixelSize(p.c.Edge_2A);
    EnP = MMApplicationContext.getContext().getResources().getDimensionPixelSize(p.c.Edge_2_5_A);
    AppMethodBeat.o(362300);
  }
  
  public t(ViewGroup paramViewGroup, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(362196);
    this.EnB = paramViewGroup;
    this.EnC = paramRecyclerView;
    this.EnD = k.cm((kotlin.g.a.a)b.EnR);
    this.CAj = this.EnB;
    paramViewGroup = this.CAj.findViewById(p.e.BBT);
    s.s(paramViewGroup, "container.findViewById(R…_comment_item_content_tv)");
    this.EnE = ((TextView)paramViewGroup);
    this.EnI = new ArrayList();
    this.EnK = EnO;
    this.CAj.setVisibility(8);
    paramViewGroup = ObjectAnimator.ofFloat(this.CAj, "alpha", new float[] { 1.0F, 0.0F });
    s.s(paramViewGroup, "ofFloat(container, \"alpha\", 1f, 0f)");
    this.EnG = paramViewGroup;
    this.EnG.setDuration(500L);
    this.EnG.addListener((Animator.AnimatorListener)new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(362018);
        paramAnonymousAnimator = this.EnQ.EnG.getTarget();
        if (paramAnonymousAnimator == null)
        {
          paramAnonymousAnimator = new NullPointerException("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(362018);
          throw paramAnonymousAnimator;
        }
        ((View)paramAnonymousAnimator).setVisibility(8);
        AppMethodBeat.o(362018);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    paramViewGroup = ObjectAnimator.ofFloat(this.CAj, "translationX", new float[] { -500.0F, 0.0F });
    s.s(paramViewGroup, "ofFloat(container, \"tran… BULLET_FLY_DISTANCE, 0f)");
    this.EnF = paramViewGroup;
    this.EnF.setDuration(2500L);
    this.EnF.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    this.EnF.setEvaluator((TypeEvaluator)new a());
    this.EnF.addListener((Animator.AnimatorListener)new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(362027);
        if (!this.EnQ.EnJ)
        {
          this.EnQ.EnG.start();
          AppMethodBeat.o(362027);
          return;
        }
        this.EnQ.sz(false);
        AppMethodBeat.o(362027);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(362039);
        paramAnonymousAnimator = this.EnQ.EnF.getTarget();
        if (paramAnonymousAnimator == null)
        {
          paramAnonymousAnimator = new NullPointerException("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(362039);
          throw paramAnonymousAnimator;
        }
        paramAnonymousAnimator = (View)paramAnonymousAnimator;
        paramAnonymousAnimator.setAlpha(1.0F);
        paramAnonymousAnimator.setVisibility(0);
        AppMethodBeat.o(362039);
      }
    });
    paramViewGroup = this.CAj.animate().setDuration(1000L).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(362020);
        if (!this.EnQ.EnJ)
        {
          this.EnQ.EnG.start();
          AppMethodBeat.o(362020);
          return;
        }
        this.EnQ.sz(false);
        AppMethodBeat.o(362020);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(362030);
        this.EnQ.CAj.setAlpha(1.0F);
        this.EnQ.CAj.setVisibility(0);
        AppMethodBeat.o(362030);
      }
    });
    s.s(paramViewGroup, "container.animate().setD…            }\n\n        })");
    this.EnH = paramViewGroup;
    paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      this.EnE.setTextSize(1, 17.0F);
      this.EnK = EnP;
      AppMethodBeat.o(362196);
      return;
    }
    this.EnE.setTextSize(1, 15.0F);
    this.EnK = EnO;
    AppMethodBeat.o(362196);
  }
  
  private static void b(String paramString, List<? extends aq> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(362221);
    aw localaw = aw.Gjk;
    if ((!aw.bgV()) || (!paramBoolean) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(362221);
      return;
    }
    int k = paramList.size();
    int i = 0;
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      Log.i("Finder.LiveCommentPlugin_Bullet", paramString + " msg:" + f.dg(paramList.get(i)));
      if (j >= k)
      {
        AppMethodBeat.o(362221);
        return;
      }
      i = j;
    }
  }
  
  private final HashMap<Integer, Drawable> eAl()
  {
    AppMethodBeat.i(362203);
    HashMap localHashMap = (HashMap)this.EnD.getValue();
    AppMethodBeat.o(362203);
    return localHashMap;
  }
  
  public final void eAm()
  {
    AppMethodBeat.i(362308);
    this.CAj.setVisibility(4);
    this.EnF.cancel();
    this.EnG.cancel();
    this.EnH.cancel();
    AppMethodBeat.o(362308);
  }
  
  public final void ha(final List<aq> paramList)
  {
    AppMethodBeat.i(362313);
    s.u(paramList, "bulletCommentList");
    d.uiThread((kotlin.g.a.a)new d(this, paramList));
    AppMethodBeat.o(362313);
  }
  
  public final void sz(final boolean paramBoolean)
  {
    AppMethodBeat.i(362317);
    d.uiThread((kotlin.g.a.a)new c(this, paramBoolean));
    AppMethodBeat.o(362317);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/HashMap;", "", "Landroid/graphics/drawable/Drawable;", "Lkotlin/collections/HashMap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<HashMap<Integer, Drawable>>
  {
    public static final b EnR;
    
    static
    {
      AppMethodBeat.i(361906);
      EnR = new b();
      AppMethodBeat.o(361906);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(t paramt, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(t paramt, List<aq> paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.t
 * JD-Core Version:    0.7.0.1
 */