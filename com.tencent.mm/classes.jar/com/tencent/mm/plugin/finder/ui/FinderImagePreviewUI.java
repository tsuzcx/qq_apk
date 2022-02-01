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
import android.view.View;
import android.view.Window;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.w;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@a(35)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "animationLayout", "Lcom/tencent/mm/view/AnimationLayout;", "gallery", "Lcom/tencent/mm/ui/tools/MMGestureGallery;", "galleryBg", "Landroid/view/View;", "isAvatar", "", "playingAnimation", "root", "scaleX", "", "scaleY", "thumRect", "Landroid/graphics/Rect;", "translationX", "translationY", "convertActivityFromTranslucent", "getLayoutId", "", "goBack", "", "initDragGallery", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "runEnterAnimation", "runExitAnimation", "setFullscreen", "FinderPreviewImageAdapter", "plugin-finder_release"})
public final class FinderImagePreviewUI
  extends MMFinderUI
{
  private View Arr;
  private boolean Ars;
  private Rect Art;
  private float GB;
  private float GC;
  private final String TAG = "MicroMsg.FinderImagePreviewUI";
  private HashMap _$_findViewCache;
  private View jac;
  private MMGestureGallery mLL;
  private AnimationLayout mLQ;
  private boolean mLR;
  private float scaleX;
  private float scaleY;
  
  private final void goBack()
  {
    AppMethodBeat.i(167310);
    if (this.Art != null)
    {
      if (this.mLR)
      {
        finish();
        AppMethodBeat.o(167310);
        return;
      }
      this.mLR = true;
      Log.i(this.TAG, "runExitAnimation");
      Object localObject = this.mLL;
      if (localObject == null) {
        p.bGy("gallery");
      }
      localObject = ((MMGestureGallery)localObject).getSelectedView();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
        AppMethodBeat.o(167310);
        throw ((Throwable)localObject);
      }
      localObject = (MultiTouchImageView)localObject;
      AnimationLayout localAnimationLayout = this.mLQ;
      if (localAnimationLayout == null) {
        p.bGy("animationLayout");
      }
      View localView1 = this.Arr;
      if (localView1 == null) {
        p.bGy("galleryBg");
      }
      View localView2 = this.jac;
      if (localView2 == null) {
        p.bGy("root");
      }
      localAnimationLayout.a(localView1, localView2, new ViewAnimHelper.ViewInfo(this.Art), (Animator.AnimatorListener)new e(this, (MultiTouchImageView)localObject), (ValueAnimator.AnimatorUpdateListener)new f(this, (MultiTouchImageView)localObject));
      AppMethodBeat.o(167310);
      return;
    }
    finish();
    AppMethodBeat.o(167310);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(280883);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(280883);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(280882);
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
    AppMethodBeat.o(280882);
    return localView1;
  }
  
  public final boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_img_preview_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167309);
    Object localObject1 = getController();
    p.j(localObject1, "controller");
    ((w)localObject1).getSupportActionBar().hide();
    getController().q((Activity)this, getResources().getColor(b.c.transparent));
    getController().setNavigationbarColor(getResources().getColor(b.c.transparent));
    localObject1 = findViewById(b.f.root);
    p.j(localObject1, "findViewById(R.id.root)");
    this.jac = ((View)localObject1);
    localObject1 = findViewById(b.f.gallery);
    p.j(localObject1, "findViewById(R.id.gallery)");
    this.mLL = ((MMGestureGallery)localObject1);
    localObject1 = findViewById(b.f.gallery_bg);
    p.j(localObject1, "findViewById(R.id.gallery_bg)");
    this.Arr = ((View)localObject1);
    localObject1 = findViewById(b.f.animation_layout);
    p.j(localObject1, "findViewById(R.id.animation_layout)");
    this.mLQ = ((AnimationLayout)localObject1);
    Object localObject2 = getIntent().getStringArrayListExtra("key_file_list");
    Object localObject3 = getIntent().getStringArrayListExtra("key_url_list");
    this.Ars = getIntent().getBooleanExtra("key_preview_avatar", false);
    this.Art = ((Rect)getIntent().getParcelableExtra("key_thumb_location"));
    Log.i(this.TAG, "files %s, urls", new Object[] { localObject2, localObject3 });
    localObject1 = new FinderImagePreviewUI.a(this);
    if (localObject2 != null)
    {
      ((FinderImagePreviewUI.a)localObject1).aq((ArrayList)localObject2);
      ((FinderImagePreviewUI.a)localObject1).fEF = true;
    }
    for (;;)
    {
      localObject2 = this.mLL;
      if (localObject2 == null) {
        p.bGy("gallery");
      }
      ((MMGestureGallery)localObject2).setSingleClickOverListener((MMGestureGallery.f)new c(this));
      localObject2 = this.mLL;
      if (localObject2 == null) {
        p.bGy("gallery");
      }
      ((MMGestureGallery)localObject2).setAdapter((SpinnerAdapter)localObject1);
      localObject1 = this.mLL;
      if (localObject1 == null) {
        p.bGy("gallery");
      }
      ((MMGestureGallery)localObject1).setGalleryScaleListener((MMGestureGallery.b)new b(this));
      if (this.Art == null) {
        break;
      }
      if (!this.mLR)
      {
        this.mLR = true;
        Log.i(this.TAG, "runEnterAnimation");
        localObject1 = this.mLQ;
        if (localObject1 == null) {
          p.bGy("animationLayout");
        }
        localObject2 = this.Arr;
        if (localObject2 == null) {
          p.bGy("galleryBg");
        }
        localObject3 = this.jac;
        if (localObject3 == null) {
          p.bGy("root");
        }
        ((AnimationLayout)localObject1).a((View)localObject2, (View)localObject3, new ViewAnimHelper.ViewInfo(this.Art), (Animator.AnimatorListener)new d(this));
      }
      AppMethodBeat.o(167309);
      return;
      if (localObject3 != null)
      {
        ((FinderImagePreviewUI.a)localObject1).aq((ArrayList)localObject3);
        ((FinderImagePreviewUI.a)localObject1).fEF = false;
      }
    }
    localObject1 = this.Arr;
    if (localObject1 == null) {
      p.bGy("galleryBg");
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
    p.j(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.j(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(5894);
    initView();
    AppMethodBeat.o(167308);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$initDragGallery$1", "Lcom/tencent/mm/ui/tools/MMGestureGallery$IOnGalleryScale;", "onGalleryScale", "", "tx", "", "ty", "onSetPrePrama", "plugin-finder_release"})
  public static final class b
    implements MMGestureGallery.b
  {
    public final void U(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(167299);
      float f2 = 1.0F - paramFloat2 / FinderImagePreviewUI.c(this.Aru).getHeight();
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      Log.d(FinderImagePreviewUI.d(this.Aru), "onGalleryScale tx: %f, ty: %f, scale: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(f1) });
      Object localObject = FinderImagePreviewUI.c(this.Aru).getSelectedView();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
        AppMethodBeat.o(167299);
        throw ((Throwable)localObject);
      }
      localObject = (MultiTouchImageView)localObject;
      ((MultiTouchImageView)localObject).setPivotX(FinderImagePreviewUI.c(this.Aru).getWidth() / 2);
      ((MultiTouchImageView)localObject).setPivotY(FinderImagePreviewUI.c(this.Aru).getHeight() / 2);
      ((MultiTouchImageView)localObject).setScaleX(f1);
      ((MultiTouchImageView)localObject).setScaleY(f1);
      ((MultiTouchImageView)localObject).setTranslationX(paramFloat1);
      ((MultiTouchImageView)localObject).setTranslationY(paramFloat2);
      FinderImagePreviewUI.e(this.Aru).setAlpha(f1);
      AppMethodBeat.o(167299);
    }
    
    public final void V(float paramFloat1, float paramFloat2) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "singleClickOver"})
  static final class c
    implements MMGestureGallery.f
  {
    c(FinderImagePreviewUI paramFinderImagePreviewUI) {}
    
    public final void bwB()
    {
      AppMethodBeat.i(167300);
      FinderImagePreviewUI.b(this.Aru);
      AppMethodBeat.o(167300);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$runEnterAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(167301);
      FinderImagePreviewUI.f(this.Aru);
      AppMethodBeat.o(167301);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(167302);
      FinderImagePreviewUI.g(this.Aru).setVisibility(0);
      AppMethodBeat.o(167302);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$runExitAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class e
    implements Animator.AnimatorListener
  {
    e(MultiTouchImageView paramMultiTouchImageView) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(167305);
      p.k(paramAnimator, "animation");
      AppMethodBeat.o(167305);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(167304);
      p.k(paramAnimator, "animation");
      this.Aru.finish();
      paramAnimator = this.Aru;
      int i = b.a.anim_not_change;
      paramAnimator.overridePendingTransition(i, i);
      AppMethodBeat.o(167304);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(167306);
      p.k(paramAnimator, "animation");
      AppMethodBeat.o(167306);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(167303);
      p.k(paramAnimator, "animation");
      if (this.Arz.getScale() > 1.0F) {
        this.Arz.hJx();
      }
      FinderImagePreviewUI.a(this.Aru, this.Arz.getTranslationX());
      FinderImagePreviewUI.b(this.Aru, this.Arz.getTranslationY());
      FinderImagePreviewUI.c(this.Aru, this.Arz.getScaleX());
      FinderImagePreviewUI.d(this.Aru, this.Arz.getScaleY());
      AppMethodBeat.o(167303);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$runExitAnimation$2", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "plugin-finder_release"})
  public static final class f
    implements ValueAnimator.AnimatorUpdateListener
  {
    f(MultiTouchImageView paramMultiTouchImageView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(167307);
      p.k(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(167307);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      this.Arz.setTranslationX(FinderImagePreviewUI.h(this.Aru) * (1.0F - f));
      this.Arz.setTranslationY(FinderImagePreviewUI.i(this.Aru) * (1.0F - f));
      this.Arz.setScaleX((1.0F - f) * FinderImagePreviewUI.j(this.Aru) + f);
      this.Arz.setScaleY(f + (1.0F - f) * FinderImagePreviewUI.k(this.Aru));
      AppMethodBeat.o(167307);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderImagePreviewUI
 * JD-Core Version:    0.7.0.1
 */