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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.HashMap;

@a(35)
@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "animationLayout", "Lcom/tencent/mm/view/AnimationLayout;", "gallery", "Lcom/tencent/mm/ui/tools/MMGestureGallery;", "galleryBg", "Landroid/view/View;", "isAvatar", "", "playingAnimation", "root", "scaleX", "", "scaleY", "thumRect", "Landroid/graphics/Rect;", "translationX", "translationY", "convertActivityFromTranslucent", "getLayoutId", "", "goBack", "", "initDragGallery", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "runEnterAnimation", "runExitAnimation", "setFullscreen", "FinderPreviewImageAdapter", "plugin-finder_release"})
public final class FinderImagePreviewUI
  extends MMFinderUI
{
  private final String TAG = "MicroMsg.FinderImagePreviewUI";
  private HashMap _$_findViewCache;
  private View fvu;
  private AnimationLayout iBC;
  private boolean iBD;
  private MMGestureGallery iBx;
  private View rHQ;
  private boolean rHR;
  private Rect rHS;
  private float scaleX;
  private float scaleY;
  private float translationX;
  private float translationY;
  
  private final void goBack()
  {
    AppMethodBeat.i(167310);
    if (this.rHS != null)
    {
      if (this.iBD)
      {
        finish();
        AppMethodBeat.o(167310);
        return;
      }
      this.iBD = true;
      ac.i(this.TAG, "runExitAnimation");
      Object localObject = this.iBx;
      if (localObject == null) {
        k.aVY("gallery");
      }
      localObject = ((MMGestureGallery)localObject).getSelectedView();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
        AppMethodBeat.o(167310);
        throw ((Throwable)localObject);
      }
      localObject = (MultiTouchImageView)localObject;
      AnimationLayout localAnimationLayout = this.iBC;
      if (localAnimationLayout == null) {
        k.aVY("animationLayout");
      }
      View localView1 = this.rHQ;
      if (localView1 == null) {
        k.aVY("galleryBg");
      }
      View localView2 = this.fvu;
      if (localView2 == null) {
        k.aVY("root");
      }
      localAnimationLayout.a(localView1, localView2, new ViewAnimHelper.ViewInfo(this.rHS), (Animator.AnimatorListener)new e(this, (MultiTouchImageView)localObject), (ValueAnimator.AnimatorUpdateListener)new f(this, (MultiTouchImageView)localObject));
      AppMethodBeat.o(167310);
      return;
    }
    finish();
    AppMethodBeat.o(167310);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203220);
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
    AppMethodBeat.o(203220);
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
    k.g(localObject1, "controller");
    ((s)localObject1).getSupportActionBar().hide();
    getController().q((Activity)this, getResources().getColor(2131101053));
    getController().setNavigationbarColor(getResources().getColor(2131101053));
    localObject1 = findViewById(2131304239);
    k.g(localObject1, "findViewById(R.id.root)");
    this.fvu = ((View)localObject1);
    localObject1 = findViewById(2131300335);
    k.g(localObject1, "findViewById(R.id.gallery)");
    this.iBx = ((MMGestureGallery)localObject1);
    localObject1 = findViewById(2131300336);
    k.g(localObject1, "findViewById(R.id.gallery_bg)");
    this.rHQ = ((View)localObject1);
    localObject1 = findViewById(2131296674);
    k.g(localObject1, "findViewById(R.id.animation_layout)");
    this.iBC = ((AnimationLayout)localObject1);
    Object localObject2 = getIntent().getStringArrayListExtra("key_file_list");
    Object localObject3 = getIntent().getStringArrayListExtra("key_url_list");
    this.rHR = getIntent().getBooleanExtra("key_preview_avatar", false);
    this.rHS = ((Rect)getIntent().getParcelableExtra("key_thumb_location"));
    ac.i(this.TAG, "files %s, urls", new Object[] { localObject2, localObject3 });
    localObject1 = new FinderImagePreviewUI.a(this);
    if (localObject2 != null)
    {
      ((FinderImagePreviewUI.a)localObject1).Z((ArrayList)localObject2);
      ((FinderImagePreviewUI.a)localObject1).dqZ = true;
    }
    for (;;)
    {
      localObject2 = this.iBx;
      if (localObject2 == null) {
        k.aVY("gallery");
      }
      ((MMGestureGallery)localObject2).setSingleClickOverListener((MMGestureGallery.f)new c(this));
      localObject2 = this.iBx;
      if (localObject2 == null) {
        k.aVY("gallery");
      }
      ((MMGestureGallery)localObject2).setAdapter((SpinnerAdapter)localObject1);
      localObject1 = this.iBx;
      if (localObject1 == null) {
        k.aVY("gallery");
      }
      ((MMGestureGallery)localObject1).setGalleryScaleListener((MMGestureGallery.b)new b(this));
      if (this.rHS == null) {
        break;
      }
      if (!this.iBD)
      {
        this.iBD = true;
        ac.i(this.TAG, "runEnterAnimation");
        localObject1 = this.iBC;
        if (localObject1 == null) {
          k.aVY("animationLayout");
        }
        localObject2 = this.rHQ;
        if (localObject2 == null) {
          k.aVY("galleryBg");
        }
        localObject3 = this.fvu;
        if (localObject3 == null) {
          k.aVY("root");
        }
        ((AnimationLayout)localObject1).a((View)localObject2, (View)localObject3, new ViewAnimHelper.ViewInfo(this.rHS), (Animator.AnimatorListener)new d(this));
      }
      AppMethodBeat.o(167309);
      return;
      if (localObject3 != null)
      {
        ((FinderImagePreviewUI.a)localObject1).Z((ArrayList)localObject3);
        ((FinderImagePreviewUI.a)localObject1).dqZ = false;
      }
    }
    localObject1 = this.rHQ;
    if (localObject1 == null) {
      k.aVY("galleryBg");
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
    k.g(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    k.g(paramBundle, "decorView");
    paramBundle.setSystemUiVisibility(5894);
    initView();
    AppMethodBeat.o(167308);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$initDragGallery$1", "Lcom/tencent/mm/ui/tools/MMGestureGallery$IOnGalleryScale;", "onGalleryScale", "", "tx", "", "ty", "onSetPrePrama", "plugin-finder_release"})
  public static final class b
    implements MMGestureGallery.b
  {
    public final void M(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(167299);
      float f2 = 1.0F - paramFloat2 / FinderImagePreviewUI.c(this.rHU).getHeight();
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      ac.d(FinderImagePreviewUI.d(this.rHU), "onGalleryScale tx: %f, ty: %f, scale: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(f1) });
      Object localObject = FinderImagePreviewUI.c(this.rHU).getSelectedView();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
        AppMethodBeat.o(167299);
        throw ((Throwable)localObject);
      }
      localObject = (MultiTouchImageView)localObject;
      ((MultiTouchImageView)localObject).setPivotX(FinderImagePreviewUI.c(this.rHU).getWidth() / 2);
      ((MultiTouchImageView)localObject).setPivotY(FinderImagePreviewUI.c(this.rHU).getHeight() / 2);
      ((MultiTouchImageView)localObject).setScaleX(f1);
      ((MultiTouchImageView)localObject).setScaleY(f1);
      ((MultiTouchImageView)localObject).setTranslationX(paramFloat1);
      ((MultiTouchImageView)localObject).setTranslationY(paramFloat2);
      FinderImagePreviewUI.e(this.rHU).setAlpha(f1);
      AppMethodBeat.o(167299);
    }
    
    public final void N(float paramFloat1, float paramFloat2) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "singleClickOver"})
  static final class c
    implements MMGestureGallery.f
  {
    c(FinderImagePreviewUI paramFinderImagePreviewUI) {}
    
    public final void aOd()
    {
      AppMethodBeat.i(167300);
      FinderImagePreviewUI.b(this.rHU);
      AppMethodBeat.o(167300);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$runEnterAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(167301);
      FinderImagePreviewUI.f(this.rHU);
      AppMethodBeat.o(167301);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(167302);
      FinderImagePreviewUI.g(this.rHU).setVisibility(0);
      AppMethodBeat.o(167302);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$runExitAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class e
    implements Animator.AnimatorListener
  {
    e(MultiTouchImageView paramMultiTouchImageView) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(167305);
      k.h(paramAnimator, "animation");
      AppMethodBeat.o(167305);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(167304);
      k.h(paramAnimator, "animation");
      this.rHU.finish();
      this.rHU.overridePendingTransition(2130771986, 2130771986);
      AppMethodBeat.o(167304);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(167306);
      k.h(paramAnimator, "animation");
      AppMethodBeat.o(167306);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(167303);
      k.h(paramAnimator, "animation");
      if (this.rHZ.getScale() > 1.0F) {
        this.rHZ.fij();
      }
      FinderImagePreviewUI.a(this.rHU, this.rHZ.getTranslationX());
      FinderImagePreviewUI.b(this.rHU, this.rHZ.getTranslationY());
      FinderImagePreviewUI.c(this.rHU, this.rHZ.getScaleX());
      FinderImagePreviewUI.d(this.rHU, this.rHZ.getScaleY());
      AppMethodBeat.o(167303);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$runExitAnimation$2", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "plugin-finder_release"})
  public static final class f
    implements ValueAnimator.AnimatorUpdateListener
  {
    f(MultiTouchImageView paramMultiTouchImageView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(167307);
      k.h(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(167307);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      this.rHZ.setTranslationX(FinderImagePreviewUI.h(this.rHU) * (1.0F - f));
      this.rHZ.setTranslationY(FinderImagePreviewUI.i(this.rHU) * (1.0F - f));
      this.rHZ.setScaleX((1.0F - f) * FinderImagePreviewUI.j(this.rHU) + f);
      this.rHZ.setScaleY(f + (1.0F - f) * FinderImagePreviewUI.k(this.rHU));
      AppMethodBeat.o(167307);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderImagePreviewUI
 * JD-Core Version:    0.7.0.1
 */