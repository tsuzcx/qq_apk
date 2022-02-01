package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper;", "", "()V", "TAG", "", "location", "", "anim", "", "view", "Landroid/view/View;", "from", "", "to", "listener", "Landroid/animation/Animator$AnimatorListener;", "setAvatarImg", "info", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "Landroid/widget/ImageView;", "start", "startAvatarAnimator", "likeList", "Ljava/util/LinkedList;", "avatarLayoutList", "", "parent", "avatarRectControl", "", "startWithAlpha", "scale", "e", "Landroid/view/MotionEvent;", "isDetach", "heightOffset", "plugin-finder_release"})
public final class c
{
  private static final int[] BdE;
  public static final c BdF;
  
  static
  {
    AppMethodBeat.i(168461);
    BdF = new c();
    BdE = new int[2];
    AppMethodBeat.o(168461);
  }
  
  public static void a(final View paramView, final float paramFloat1, MotionEvent paramMotionEvent, final boolean paramBoolean, final float paramFloat2)
  {
    AppMethodBeat.i(278996);
    p.k(paramView, "view");
    if (paramView.getVisibility() == 0)
    {
      AppMethodBeat.o(278996);
      return;
    }
    paramView.setVisibility(0);
    paramView.setAlpha(0.0F);
    paramView.post((Runnable)new d(paramMotionEvent, paramView, paramFloat2, paramFloat1, paramBoolean));
    AppMethodBeat.o(278996);
  }
  
  private static void a(View paramView, String paramString, float paramFloat1, float paramFloat2, Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(279000);
    paramString = ObjectAnimator.ofFloat(paramView, paramString, new float[] { paramFloat1, paramFloat2 });
    p.j(paramString, "tranX");
    paramString.setDuration(500L);
    if (paramAnimatorListener != null) {
      paramString.addListener(paramAnimatorListener);
    }
    for (;;)
    {
      paramString.start();
      AppMethodBeat.o(279000);
      return;
      paramString.addListener((Animator.AnimatorListener)new a(paramView));
    }
  }
  
  private static void a(FinderCommentInfo paramFinderCommentInfo, ImageView paramImageView)
  {
    AppMethodBeat.i(279001);
    paramImageView.setImageDrawable(null);
    if (p.h(paramFinderCommentInfo.username, z.bcZ()))
    {
      paramFinderCommentInfo = com.tencent.mm.plugin.finder.loader.t.ztT;
      paramFinderCommentInfo = com.tencent.mm.plugin.finder.loader.t.dJj();
      localObject = new e("");
      localt = com.tencent.mm.plugin.finder.loader.t.ztT;
      paramFinderCommentInfo.a(localObject, paramImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztY));
      paramFinderCommentInfo = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dTF().aSr()).intValue() == 1)
      {
        a.b.c(paramImageView, z.bcZ());
        AppMethodBeat.o(279001);
        return;
      }
      a.b.d(paramImageView, z.bcZ(), 0.0F);
      AppMethodBeat.o(279001);
      return;
    }
    Object localObject = com.tencent.mm.plugin.finder.loader.t.ztT;
    localObject = com.tencent.mm.plugin.finder.loader.t.dJj();
    paramFinderCommentInfo = new e(paramFinderCommentInfo.headUrl);
    com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
    ((com.tencent.mm.loader.d)localObject).a(paramFinderCommentInfo, paramImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztY));
    AppMethodBeat.o(279001);
  }
  
  public static void c(final LinkedList<FinderCommentInfo> paramLinkedList, List<View> paramList, View paramView, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(278998);
    p.k(paramLinkedList, "likeList");
    p.k(paramList, "avatarLayoutList");
    p.k(paramView, "parent");
    int k = paramLinkedList.size();
    if (k == 0)
    {
      AppMethodBeat.o(278998);
      return;
    }
    float f;
    if (paramBoolean)
    {
      localObject1 = (View)paramList.get(0);
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).getContext();
        if (localObject1 != null)
        {
          localObject1 = ((Context)localObject1).getResources();
          if (localObject1 == null) {}
        }
      }
      for (f = ((Resources)localObject1).getDimension(b.d.Edge_3_5_A);; f = 0.0F)
      {
        if (k == 1)
        {
          localObject1 = (View)paramList.get(0);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(0);
          }
        }
        if ((k != 2) && (k != 3)) {
          break label405;
        }
        if (k <= paramList.size()) {
          break;
        }
        AppMethodBeat.o(278998);
        return;
      }
    }
    Object localObject1 = (View)paramList.get(0);
    if (localObject1 != null) {}
    for (localObject1 = ((View)localObject1).getContext();; localObject1 = null)
    {
      f = a.fromDPToPix((Context)localObject1, 14);
      break;
    }
    int m = k - 2;
    if (m >= 0)
    {
      i = 0;
      for (;;)
      {
        localObject1 = (View)paramList.get(i);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        if (i == m) {
          break;
        }
        i += 1;
      }
    }
    localObject1 = (View)paramList.get(0);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    if (localObject1 == null) {
      p.iCn();
    }
    a((View)localObject1, "alpha", 0.0F, 1.0F, null);
    int i = 1;
    while (i < k)
    {
      localObject1 = (View)paramList.get(i);
      if (localObject1 != null) {
        a((View)localObject1, "translationX", -f, 0.0F, null);
      }
      i += 1;
    }
    localObject1 = paramView.findViewById(b.f.real_name_recommend_nickname);
    Object localObject2 = paramView.findViewById(b.f.real_name_recommend_desc);
    if (localObject1 != null) {
      a((View)localObject1, "translationX", -f, 0.0F, null);
    }
    if (localObject2 != null) {
      a((View)localObject2, "translationX", -f, 0.0F, null);
    }
    label405:
    if (k > 3)
    {
      localObject1 = new aa.f();
      ((aa.f)localObject1).aaBC = paramView.findViewById(b.f.friend_avatar_layout_extra);
      paramView = (View)((aa.f)localObject1).aaBC;
      p.j(paramView, "avatarExtra");
      paramView.setVisibility(0);
      paramView = paramLinkedList.get(0);
      p.j(paramView, "likeList[0]");
      paramView = (FinderCommentInfo)paramView;
      localObject2 = ((View)((aa.f)localObject1).aaBC).findViewById(b.f.friend_avatar_extra);
      p.j(localObject2, "avatarExtra.findViewById(R.id.friend_avatar_extra)");
      a(paramView, (ImageView)localObject2);
      paramView = paramLinkedList.get(1);
      p.j(paramView, "likeList[1]");
      paramView = (FinderCommentInfo)paramView;
      localObject2 = paramList.get(0);
      if (localObject2 == null) {
        p.iCn();
      }
      localObject2 = ((View)localObject2).findViewById(b.f.friend_avatar_1);
      p.j(localObject2, "avatarLayoutList[0]!!.fi…yId(R.id.friend_avatar_1)");
      a(paramView, (ImageView)localObject2);
      paramView = paramLinkedList.get(2);
      p.j(paramView, "likeList[2]");
      paramView = (FinderCommentInfo)paramView;
      localObject2 = paramList.get(1);
      if (localObject2 == null) {
        p.iCn();
      }
      localObject2 = ((View)localObject2).findViewById(b.f.friend_avatar_2);
      p.j(localObject2, "avatarLayoutList[1]!!.fi…yId(R.id.friend_avatar_2)");
      a(paramView, (ImageView)localObject2);
      paramView = paramLinkedList.get(3);
      p.j(paramView, "likeList[3]");
      paramView = (FinderCommentInfo)paramView;
      localObject2 = paramList.get(2);
      if (localObject2 == null) {
        p.iCn();
      }
      localObject2 = ((View)localObject2).findViewById(b.f.friend_avatar_3);
      p.j(localObject2, "avatarLayoutList[2]!!.fi…yId(R.id.friend_avatar_3)");
      a(paramView, (ImageView)localObject2);
      paramView = ((Iterable)paramList).iterator();
      for (;;)
      {
        i = j;
        if (!paramView.hasNext()) {
          break;
        }
        localObject2 = (View)paramView.next();
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(0);
        }
      }
      while (i < 2)
      {
        paramView = (View)paramList.get(i);
        if (paramView != null) {
          a(paramView, "translationX", 0.0F, f, null);
        }
        i += 1;
      }
      paramView = paramList.get(2);
      if (paramView == null) {
        p.iCn();
      }
      a((View)paramView, "alpha", 1.0F, 0.0F, null);
      paramView = (View)((aa.f)localObject1).aaBC;
      p.j(paramView, "avatarExtra");
      a(paramView, "alpha", 0.0F, 1.0F, (Animator.AnimatorListener)new c(paramList, (aa.f)localObject1, paramLinkedList));
    }
    AppMethodBeat.o(278998);
  }
  
  public static void eT(View paramView)
  {
    AppMethodBeat.i(168459);
    p.k(paramView, "view");
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 1.0F, 1.05F, 1.0F, 0.95F, 1.0F }) });
    localValueAnimator.setDuration(500L).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b(paramView));
    localValueAnimator.start();
    AppMethodBeat.o(168459);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$anim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class a
    implements Animator.AnimatorListener
  {
    a(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(251596);
      if (paramAnimator != null)
      {
        paramAnimator.cancel();
        AppMethodBeat.o(251596);
        return;
      }
      AppMethodBeat.o(251596);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(251598);
      this.kqJ.setVisibility(0);
      AppMethodBeat.o(251598);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(View paramView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(168455);
      paramValueAnimator = paramValueAnimator.getAnimatedValue("scale");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(168455);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      Log.d("LikeIconAnimationHelper", "valueScale=".concat(String.valueOf(f)));
      this.kqJ.setScaleX(f);
      this.kqJ.setScaleY(f);
      AppMethodBeat.o(168455);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$startAvatarAnimator$6", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class c
    implements Animator.AnimatorListener
  {
    c(List paramList, aa.f paramf, LinkedList paramLinkedList) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(290695);
      paramAnimator = ((Iterable)this.xiS).iterator();
      while (paramAnimator.hasNext())
      {
        localObject = (View)paramAnimator.next();
        if (localObject != null) {
          ((View)localObject).setTranslationX(0.0F);
        }
        if (localObject != null) {
          ((View)localObject).setAlpha(1.0F);
        }
      }
      paramAnimator = (View)this.BdG.aaBC;
      p.j(paramAnimator, "avatarExtra");
      paramAnimator.setVisibility(8);
      paramAnimator = (View)this.BdG.aaBC;
      p.j(paramAnimator, "avatarExtra");
      paramAnimator.setTranslationX(0.0F);
      paramAnimator = c.BdF;
      paramAnimator = paramLinkedList.get(0);
      p.j(paramAnimator, "likeList[0]");
      paramAnimator = (FinderCommentInfo)paramAnimator;
      Object localObject = this.xiS.get(0);
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((View)localObject).findViewById(b.f.friend_avatar_1);
      p.j(localObject, "avatarLayoutList[0]!!.fi…yId(R.id.friend_avatar_1)");
      c.b(paramAnimator, (ImageView)localObject);
      paramAnimator = c.BdF;
      paramAnimator = paramLinkedList.get(1);
      p.j(paramAnimator, "likeList[1]");
      paramAnimator = (FinderCommentInfo)paramAnimator;
      localObject = this.xiS.get(1);
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((View)localObject).findViewById(b.f.friend_avatar_2);
      p.j(localObject, "avatarLayoutList[1]!!.fi…yId(R.id.friend_avatar_2)");
      c.b(paramAnimator, (ImageView)localObject);
      paramAnimator = c.BdF;
      paramAnimator = paramLinkedList.get(2);
      p.j(paramAnimator, "likeList[2]");
      paramAnimator = (FinderCommentInfo)paramAnimator;
      localObject = this.xiS.get(2);
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((View)localObject).findViewById(b.f.friend_avatar_3);
      p.j(localObject, "avatarLayoutList[2]!!.fi…yId(R.id.friend_avatar_3)");
      c.b(paramAnimator, (ImageView)localObject);
      AppMethodBeat.o(290695);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(MotionEvent paramMotionEvent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(288815);
      if (this.BdI != null)
      {
        paramView.setTranslationX(0.0F);
        paramView.setTranslationY(0.0F);
        localObject = paramView;
        c localc = c.BdF;
        ((View)localObject).getLocationInWindow(c.ejC());
        localObject = paramView;
        float f = this.BdI.getRawX();
        localc = c.BdF;
        ((View)localObject).setTranslationX(f - c.ejC()[0] - paramView.getWidth() / 2);
        localObject = paramView;
        f = this.BdI.getRawY();
        localc = c.BdF;
        ((View)localObject).setTranslationY(f - c.ejC()[1] - paramView.getHeight() / 2 + paramFloat2);
      }
      paramView.setAlpha(1.0F);
      Object localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { paramFloat1 * 0.5F, paramFloat1 * 1.75F, paramFloat1 * 1.25F, paramFloat1 * 1.5F }), PropertyValuesHolder.ofFloat("alpha", new float[] { 0.7F, 0.5F, 0.8F, 1.0F }) });
      ((ValueAnimator)localObject).setDuration(500L).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(271592);
          Object localObject = paramAnonymousValueAnimator.getAnimatedValue("scale");
          if (localObject == null)
          {
            paramAnonymousValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Float");
            AppMethodBeat.o(271592);
            throw paramAnonymousValueAnimator;
          }
          float f1 = ((Float)localObject).floatValue();
          paramAnonymousValueAnimator = paramAnonymousValueAnimator.getAnimatedValue("alpha");
          if (paramAnonymousValueAnimator == null)
          {
            paramAnonymousValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Float");
            AppMethodBeat.o(271592);
            throw paramAnonymousValueAnimator;
          }
          float f2 = ((Float)paramAnonymousValueAnimator).floatValue();
          this.BdM.kqJ.setScaleX(f1);
          this.BdM.kqJ.setScaleY(f1);
          this.BdM.kqJ.setAlpha(f2);
          AppMethodBeat.o(271592);
        }
      });
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(271680);
          this.BdM.kqJ.animate().alpha(0.0F).setStartDelay(300L).setListener((Animator.AnimatorListener)new a(this)).start();
          AppMethodBeat.o(271680);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
        
        @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$startWithAlpha$1$3$onAnimationEnd$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
        public static final class a
          implements Animator.AnimatorListener
        {
          public final void onAnimationCancel(Animator paramAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnimator)
          {
            AppMethodBeat.i(288345);
            this.BdN.BdM.kqJ.setScaleX(1.0F);
            this.BdN.BdM.kqJ.setScaleY(1.0F);
            this.BdN.BdM.kqJ.setAlpha(1.0F);
            this.BdN.BdM.kqJ.setTranslationX(0.0F);
            this.BdN.BdM.kqJ.setTranslationY(0.0F);
            this.BdN.BdM.kqJ.setVisibility(8);
            if (this.BdN.BdM.BdL) {
              this.BdN.BdM.kqJ.post((Runnable)new a(this));
            }
            AppMethodBeat.o(288345);
          }
          
          public final void onAnimationRepeat(Animator paramAnimator) {}
          
          public final void onAnimationStart(Animator paramAnimator) {}
          
          @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
          static final class a
            implements Runnable
          {
            a(c.d.2.a parama) {}
            
            public final void run()
            {
              AppMethodBeat.i(282159);
              Object localObject = this.BdO.BdN.BdM.kqJ.getParent();
              if (localObject == null)
              {
                localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(282159);
                throw ((Throwable)localObject);
              }
              ((ViewGroup)localObject).removeView(this.BdO.BdN.BdM.kqJ);
              AppMethodBeat.o(282159);
            }
          }
        }
      });
      ((ValueAnimator)localObject).start();
      AppMethodBeat.o(288815);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.c
 * JD-Core Version:    0.7.0.1
 */