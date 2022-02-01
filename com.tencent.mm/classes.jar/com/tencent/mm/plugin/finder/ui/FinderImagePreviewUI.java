package com.tencent.mm.plugin.finder.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.Window;
import android.widget.SpinnerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.HashMap;

@a(35)
@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "animationLayout", "Lcom/tencent/mm/view/AnimationLayout;", "gallery", "Lcom/tencent/mm/ui/tools/MMGestureGallery;", "galleryBg", "Landroid/view/View;", "isAvatar", "", "playingAnimation", "root", "scaleX", "", "scaleY", "thumRect", "Landroid/graphics/Rect;", "translationX", "translationY", "convertActivityFromTranslucent", "getLayoutId", "", "goBack", "", "initDragGallery", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "runEnterAnimation", "runExitAnimation", "setFullscreen", "FinderPreviewImageAdapter", "plugin-finder_release"})
public final class FinderImagePreviewUI
  extends MMFinderUI
{
  private final String TAG = "MicroMsg.FinderImagePreviewUI";
  private HashMap _$_findViewCache;
  private View fQH;
  private MMGestureGallery iXA;
  private AnimationLayout iXF;
  private boolean iXG;
  private View sNN;
  private boolean sNO;
  private Rect sNP;
  private float scaleX;
  private float scaleY;
  private float translationX;
  private float translationY;
  
  private final void goBack()
  {
    AppMethodBeat.i(167310);
    if (this.sNP != null)
    {
      if (this.iXG)
      {
        finish();
        AppMethodBeat.o(167310);
        return;
      }
      this.iXG = true;
      ae.i(this.TAG, "runExitAnimation");
      Object localObject = this.iXA;
      if (localObject == null) {
        p.bdF("gallery");
      }
      localObject = ((MMGestureGallery)localObject).getSelectedView();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
        AppMethodBeat.o(167310);
        throw ((Throwable)localObject);
      }
      localObject = (MultiTouchImageView)localObject;
      AnimationLayout localAnimationLayout = this.iXF;
      if (localAnimationLayout == null) {
        p.bdF("animationLayout");
      }
      View localView1 = this.sNN;
      if (localView1 == null) {
        p.bdF("galleryBg");
      }
      View localView2 = this.fQH;
      if (localView2 == null) {
        p.bdF("root");
      }
      localAnimationLayout.a(localView1, localView2, new ViewAnimHelper.ViewInfo(this.sNP), (Animator.AnimatorListener)new e(this, (MultiTouchImageView)localObject), (ValueAnimator.AnimatorUpdateListener)new f(this, (MultiTouchImageView)localObject));
      AppMethodBeat.o(167310);
      return;
    }
    finish();
    AppMethodBeat.o(167310);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204616);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(204616);
    return localView1;
  }
  
  public final boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public final int getLayoutId()
  {
    return 2131494058;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167309);
    Object localObject1 = getController();
    p.g(localObject1, "controller");
    ((s)localObject1).getSupportActionBar().hide();
    getController().q((Activity)this, getResources().getColor(2131101053));
    getController().setNavigationbarColor(getResources().getColor(2131101053));
    localObject1 = findViewById(2131304239);
    p.g(localObject1, "findViewById(R.id.root)");
    this.fQH = ((View)localObject1);
    localObject1 = findViewById(2131300335);
    p.g(localObject1, "findViewById(R.id.gallery)");
    this.iXA = ((MMGestureGallery)localObject1);
    localObject1 = findViewById(2131300336);
    p.g(localObject1, "findViewById(R.id.gallery_bg)");
    this.sNN = ((View)localObject1);
    localObject1 = findViewById(2131296674);
    p.g(localObject1, "findViewById(R.id.animation_layout)");
    this.iXF = ((AnimationLayout)localObject1);
    Object localObject2 = getIntent().getStringArrayListExtra("key_file_list");
    Object localObject3 = getIntent().getStringArrayListExtra("key_url_list");
    this.sNO = getIntent().getBooleanExtra("key_preview_avatar", false);
    this.sNP = ((Rect)getIntent().getParcelableExtra("key_thumb_location"));
    ae.i(this.TAG, "files %s, urls", new Object[] { localObject2, localObject3 });
    localObject1 = new FinderImagePreviewUI.a(this);
    if (localObject2 != null)
    {
      ((FinderImagePreviewUI.a)localObject1).X((ArrayList)localObject2);
      ((FinderImagePreviewUI.a)localObject1).dDV = true;
    }
    for (;;)
    {
      localObject2 = this.iXA;
      if (localObject2 == null) {
        p.bdF("gallery");
      }
      ((MMGestureGallery)localObject2).setSingleClickOverListener((MMGestureGallery.f)new c(this));
      localObject2 = this.iXA;
      if (localObject2 == null) {
        p.bdF("gallery");
      }
      ((MMGestureGallery)localObject2).setAdapter((SpinnerAdapter)localObject1);
      localObject1 = this.iXA;
      if (localObject1 == null) {
        p.bdF("gallery");
      }
      ((MMGestureGallery)localObject1).setGalleryScaleListener((MMGestureGallery.b)new b(this));
      if (this.sNP == null) {
        break;
      }
      if (!this.iXG)
      {
        this.iXG = true;
        ae.i(this.TAG, "runEnterAnimation");
        localObject1 = this.iXF;
        if (localObject1 == null) {
          p.bdF("animationLayout");
        }
        localObject2 = this.sNN;
        if (localObject2 == null) {
          p.bdF("galleryBg");
        }
        localObject3 = this.fQH;
        if (localObject3 == null) {
          p.bdF("root");
        }
        ((AnimationLayout)localObject1).a((View)localObject2, (View)localObject3, new ViewAnimHelper.ViewInfo(this.sNP), (Animator.AnimatorListener)new d(this));
      }
      AppMethodBeat.o(167309);
      return;
      if (localObject3 != null)
      {
        ((FinderImagePreviewUI.a)localObject1).X((ArrayList)localObject3);
        ((FinderImagePreviewUI.a)localObject1).dDV = false;
      }
    }
    localObject1 = this.sNN;
    if (localObject1 == null) {
      p.bdF("galleryBg");
    }
    ((View)localObject1).setVisibility(0);
    AppMethodBeat.o(167309);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(167311);
    goBack();
    AppMethodBeat.o(167311);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167308);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.g(paramBundle, "decorView");
    paramBundle.setSystemUiVisibility(5894);
    initView();
    AppMethodBeat.o(167308);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$initDragGallery$1", "Lcom/tencent/mm/ui/tools/MMGestureGallery$IOnGalleryScale;", "onGalleryScale", "", "tx", "", "ty", "onSetPrePrama", "plugin-finder_release"})
  public static final class b
    implements MMGestureGallery.b
  {
    public final void O(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(167299);
      float f2 = 1.0F - paramFloat2 / FinderImagePreviewUI.c(this.sNR).getHeight();
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      ae.d(FinderImagePreviewUI.d(this.sNR), "onGalleryScale tx: %f, ty: %f, scale: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(f1) });
      Object localObject = FinderImagePreviewUI.c(this.sNR).getSelectedView();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
        AppMethodBeat.o(167299);
        throw ((Throwable)localObject);
      }
      localObject = (MultiTouchImageView)localObject;
      ((MultiTouchImageView)localObject).setPivotX(FinderImagePreviewUI.c(this.sNR).getWidth() / 2);
      ((MultiTouchImageView)localObject).setPivotY(FinderImagePreviewUI.c(this.sNR).getHeight() / 2);
      ((MultiTouchImageView)localObject).setScaleX(f1);
      ((MultiTouchImageView)localObject).setScaleY(f1);
      ((MultiTouchImageView)localObject).setTranslationX(paramFloat1);
      ((MultiTouchImageView)localObject).setTranslationY(paramFloat2);
      FinderImagePreviewUI.e(this.sNR).setAlpha(f1);
      AppMethodBeat.o(167299);
    }
    
    public final void P(float paramFloat1, float paramFloat2) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "singleClickOver"})
  static final class c
    implements MMGestureGallery.f
  {
    c(FinderImagePreviewUI paramFinderImagePreviewUI) {}
    
    public final void aRO()
    {
      AppMethodBeat.i(167300);
      FinderImagePreviewUI.b(this.sNR);
      AppMethodBeat.o(167300);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$runEnterAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(167301);
      FinderImagePreviewUI.f(this.sNR);
      AppMethodBeat.o(167301);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(167302);
      FinderImagePreviewUI.g(this.sNR).setVisibility(0);
      AppMethodBeat.o(167302);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$runExitAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class e
    implements Animator.AnimatorListener
  {
    e(MultiTouchImageView paramMultiTouchImageView) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(167305);
      p.h(paramAnimator, "animation");
      AppMethodBeat.o(167305);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(167304);
      p.h(paramAnimator, "animation");
      this.sNR.finish();
      this.sNR.overridePendingTransition(2130771986, 2130771986);
      AppMethodBeat.o(167304);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(167306);
      p.h(paramAnimator, "animation");
      AppMethodBeat.o(167306);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(167303);
      p.h(paramAnimator, "animation");
      if (this.sNW.getScale() > 1.0F) {
        this.sNW.fCA();
      }
      FinderImagePreviewUI.a(this.sNR, this.sNW.getTranslationX());
      FinderImagePreviewUI.b(this.sNR, this.sNW.getTranslationY());
      FinderImagePreviewUI.c(this.sNR, this.sNW.getScaleX());
      FinderImagePreviewUI.d(this.sNR, this.sNW.getScaleY());
      AppMethodBeat.o(167303);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$runExitAnimation$2", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "plugin-finder_release"})
  public static final class f
    implements ValueAnimator.AnimatorUpdateListener
  {
    f(MultiTouchImageView paramMultiTouchImageView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(167307);
      p.h(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(167307);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      this.sNW.setTranslationX(FinderImagePreviewUI.h(this.sNR) * (1.0F - f));
      this.sNW.setTranslationY(FinderImagePreviewUI.i(this.sNR) * (1.0F - f));
      this.sNW.setScaleX((1.0F - f) * FinderImagePreviewUI.j(this.sNR) + f);
      this.sNW.setScaleY(f + (1.0F - f) * FinderImagePreviewUI.k(this.sNR));
      AppMethodBeat.o(167307);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderImagePreviewUI
 * JD-Core Version:    0.7.0.1
 */