package com.tencent.mm.plugin.finder.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import kotlin.g.b.q;
import kotlin.l;

@com.tencent.mm.ui.base.a(35)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "animationLayout", "Lcom/tencent/mm/view/AnimationLayout;", "gallery", "Lcom/tencent/mm/ui/tools/MMGestureGallery;", "galleryBg", "Landroid/view/View;", "isAvatar", "", "playingAnimation", "root", "scaleX", "", "scaleY", "thumRect", "Landroid/graphics/Rect;", "translationX", "translationY", "convertActivityFromTranslucent", "getLayoutId", "", "goBack", "", "initDragGallery", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "runEnterAnimation", "runExitAnimation", "setFullscreen", "FinderPreviewImageAdapter", "plugin-finder_release"})
public final class FinderImagePreviewUI
  extends MMFinderUI
{
  private final String TAG = "MicroMsg.FinderImagePreviewUI";
  private HashMap _$_findViewCache;
  private View gvQ;
  private AnimationLayout jUD;
  private boolean jUE;
  private MMGestureGallery jUy;
  private float scaleX;
  private float scaleY;
  private float translationX;
  private float translationY;
  private Rect vKA;
  private View vKy;
  private boolean vKz;
  
  private final void goBack()
  {
    AppMethodBeat.i(167310);
    if (this.vKA != null)
    {
      if (this.jUE)
      {
        finish();
        AppMethodBeat.o(167310);
        return;
      }
      this.jUE = true;
      Log.i(this.TAG, "runExitAnimation");
      Object localObject = this.jUy;
      if (localObject == null) {
        kotlin.g.b.p.btv("gallery");
      }
      localObject = ((MMGestureGallery)localObject).getSelectedView();
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
        AppMethodBeat.o(167310);
        throw ((Throwable)localObject);
      }
      localObject = (MultiTouchImageView)localObject;
      AnimationLayout localAnimationLayout = this.jUD;
      if (localAnimationLayout == null) {
        kotlin.g.b.p.btv("animationLayout");
      }
      View localView1 = this.vKy;
      if (localView1 == null) {
        kotlin.g.b.p.btv("galleryBg");
      }
      View localView2 = this.gvQ;
      if (localView2 == null) {
        kotlin.g.b.p.btv("root");
      }
      localAnimationLayout.a(localView1, localView2, new ViewAnimHelper.ViewInfo(this.vKA), (Animator.AnimatorListener)new e(this, (MultiTouchImageView)localObject), (ValueAnimator.AnimatorUpdateListener)new f(this, (MultiTouchImageView)localObject));
      AppMethodBeat.o(167310);
      return;
    }
    finish();
    AppMethodBeat.o(167310);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252436);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252436);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252435);
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
    AppMethodBeat.o(252435);
    return localView1;
  }
  
  public final boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public final int getLayoutId()
  {
    return 2131494348;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167309);
    Object localObject1 = getController();
    kotlin.g.b.p.g(localObject1, "controller");
    ((com.tencent.mm.ui.t)localObject1).getSupportActionBar().hide();
    getController().p((Activity)this, getResources().getColor(2131101287));
    getController().setNavigationbarColor(getResources().getColor(2131101287));
    localObject1 = findViewById(2131307157);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.root)");
    this.gvQ = ((View)localObject1);
    localObject1 = findViewById(2131301853);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.gallery)");
    this.jUy = ((MMGestureGallery)localObject1);
    localObject1 = findViewById(2131301854);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.gallery_bg)");
    this.vKy = ((View)localObject1);
    localObject1 = findViewById(2131296763);
    kotlin.g.b.p.g(localObject1, "findViewById(R.id.animation_layout)");
    this.jUD = ((AnimationLayout)localObject1);
    Object localObject2 = getIntent().getStringArrayListExtra("key_file_list");
    Object localObject3 = getIntent().getStringArrayListExtra("key_url_list");
    this.vKz = getIntent().getBooleanExtra("key_preview_avatar", false);
    this.vKA = ((Rect)getIntent().getParcelableExtra("key_thumb_location"));
    Log.i(this.TAG, "files %s, urls", new Object[] { localObject2, localObject3 });
    localObject1 = new a();
    if (localObject2 != null)
    {
      ((a)localObject1).al((ArrayList)localObject2);
      ((a)localObject1).dLQ = true;
    }
    for (;;)
    {
      localObject2 = this.jUy;
      if (localObject2 == null) {
        kotlin.g.b.p.btv("gallery");
      }
      ((MMGestureGallery)localObject2).setSingleClickOverListener((MMGestureGallery.f)new c(this));
      localObject2 = this.jUy;
      if (localObject2 == null) {
        kotlin.g.b.p.btv("gallery");
      }
      ((MMGestureGallery)localObject2).setAdapter((SpinnerAdapter)localObject1);
      localObject1 = this.jUy;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("gallery");
      }
      ((MMGestureGallery)localObject1).setGalleryScaleListener((MMGestureGallery.b)new b(this));
      if (this.vKA == null) {
        break;
      }
      if (!this.jUE)
      {
        this.jUE = true;
        Log.i(this.TAG, "runEnterAnimation");
        localObject1 = this.jUD;
        if (localObject1 == null) {
          kotlin.g.b.p.btv("animationLayout");
        }
        localObject2 = this.vKy;
        if (localObject2 == null) {
          kotlin.g.b.p.btv("galleryBg");
        }
        localObject3 = this.gvQ;
        if (localObject3 == null) {
          kotlin.g.b.p.btv("root");
        }
        ((AnimationLayout)localObject1).a((View)localObject2, (View)localObject3, new ViewAnimHelper.ViewInfo(this.vKA), (Animator.AnimatorListener)new d(this));
      }
      AppMethodBeat.o(167309);
      return;
      if (localObject3 != null)
      {
        ((a)localObject1).al((ArrayList)localObject3);
        ((a)localObject1).dLQ = false;
      }
    }
    localObject1 = this.vKy;
    if (localObject1 == null) {
      kotlin.g.b.p.btv("galleryBg");
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
    kotlin.g.b.p.g(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    kotlin.g.b.p.g(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(5894);
    initView();
    AppMethodBeat.o(167308);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$FinderPreviewImageAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI;)V", "images", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "isLocal", "", "getCount", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "view", "viewGroup", "Landroid/view/ViewGroup;", "setImages", "", "files", "setIsLocal", "plugin-finder_release"})
  public final class a
    extends BaseAdapter
  {
    boolean dLQ;
    private ArrayList<String> images;
    
    public a()
    {
      AppMethodBeat.i(167298);
      this.images = new ArrayList();
      AppMethodBeat.o(167298);
    }
    
    private String getItem(int paramInt)
    {
      AppMethodBeat.i(167294);
      String str = (String)this.images.get(paramInt);
      AppMethodBeat.o(167294);
      return str;
    }
    
    public final void al(ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(167297);
      kotlin.g.b.p.h(paramArrayList, "files");
      this.images.addAll((Collection)paramArrayList);
      AppMethodBeat.o(167297);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(167293);
      int i = this.images.size();
      AppMethodBeat.o(167293);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(167296);
      kotlin.g.b.p.h(paramViewGroup, "viewGroup");
      if (paramView == null)
      {
        paramView = (View)new MultiTouchImageView((Context)this.vKB, 0, 0, (byte)0);
        ((MultiTouchImageView)paramView).setLayoutParams((ViewGroup.LayoutParams)new Gallery.LayoutParams(-1, -1));
      }
      for (;;)
      {
        if (this.dLQ)
        {
          paramViewGroup = com.tencent.mm.loader.e.hXU;
          paramViewGroup = com.tencent.mm.loader.e.aJs();
          String str = getItem(paramInt);
          if (str == null) {
            kotlin.g.b.p.hyc();
          }
          paramViewGroup = paramViewGroup.Hf(str);
          paramViewGroup.hXY = ((com.tencent.mm.loader.f.e)a.vKC);
          paramViewGroup.c((ImageView)paramView);
          AppMethodBeat.o(167296);
          return paramView;
        }
        if (!FinderImagePreviewUI.a(this.vKB)) {
          paramViewGroup = com.tencent.mm.plugin.finder.loader.m.uJa;
        }
        for (paramViewGroup = com.tencent.mm.plugin.finder.loader.m.djY().bQ(new com.tencent.mm.plugin.finder.loader.p(Util.nullAsNil(getItem(paramInt)), com.tencent.mm.plugin.finder.storage.x.vEn));; paramViewGroup = com.tencent.mm.plugin.finder.loader.m.dkd().bQ(new com.tencent.mm.plugin.finder.loader.a(Util.nullAsNil(getItem(paramInt)))))
        {
          ((com.tencent.mm.loader.a.a)paramViewGroup).a((ImageView)paramView, (kotlin.g.a.m)b.vKF);
          break;
          paramViewGroup = com.tencent.mm.plugin.finder.loader.m.uJa;
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "", "kotlin.jvm.PlatformType", "imageView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
    static final class a<T, R>
      implements com.tencent.mm.loader.f.e<String, Bitmap>
    {
      public static final a vKC;
      
      static
      {
        AppMethodBeat.i(167289);
        vKC = new a();
        AppMethodBeat.o(167289);
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$FinderPreviewImageAdapter$getView$1$1$1"})
      static final class a
        implements Runnable
      {
        a(g paramg, Bitmap paramBitmap) {}
        
        public final void run()
        {
          AppMethodBeat.i(167287);
          Object localObject = this.vKD;
          kotlin.g.b.p.g(localObject, "imageView");
          localObject = ((g)localObject).getView();
          if (localObject != null)
          {
            if (localObject == null)
            {
              localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
              AppMethodBeat.o(167287);
              throw ((Throwable)localObject);
            }
            ((MultiTouchImageView)localObject).cN(this.vKE.getWidth(), this.vKE.getHeight());
            ((MultiTouchImageView)localObject).gKy();
            AppMethodBeat.o(167287);
            return;
          }
          AppMethodBeat.o(167287);
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "imageView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.m<g<?>, Bitmap, kotlin.x>
    {
      public static final b vKF;
      
      static
      {
        AppMethodBeat.i(167292);
        vKF = new b();
        AppMethodBeat.o(167292);
      }
      
      b()
      {
        super();
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$FinderPreviewImageAdapter$getView$2$1$1"})
      static final class a
        implements Runnable
      {
        a(g paramg, Bitmap paramBitmap) {}
        
        public final void run()
        {
          AppMethodBeat.i(167290);
          Object localObject = this.vKD.getView();
          if (localObject != null)
          {
            if (localObject == null)
            {
              localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
              AppMethodBeat.o(167290);
              throw ((Throwable)localObject);
            }
            ((MultiTouchImageView)localObject).cN(this.vKE.getWidth(), this.vKE.getHeight());
            ((MultiTouchImageView)localObject).gKy();
            AppMethodBeat.o(167290);
            return;
          }
          AppMethodBeat.o(167290);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$initDragGallery$1", "Lcom/tencent/mm/ui/tools/MMGestureGallery$IOnGalleryScale;", "onGalleryScale", "", "tx", "", "ty", "onSetPrePrama", "plugin-finder_release"})
  public static final class b
    implements MMGestureGallery.b
  {
    public final void S(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(167299);
      float f2 = 1.0F - paramFloat2 / FinderImagePreviewUI.c(this.vKB).getHeight();
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      Log.d(FinderImagePreviewUI.d(this.vKB), "onGalleryScale tx: %f, ty: %f, scale: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(f1) });
      Object localObject = FinderImagePreviewUI.c(this.vKB).getSelectedView();
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
        AppMethodBeat.o(167299);
        throw ((Throwable)localObject);
      }
      localObject = (MultiTouchImageView)localObject;
      ((MultiTouchImageView)localObject).setPivotX(FinderImagePreviewUI.c(this.vKB).getWidth() / 2);
      ((MultiTouchImageView)localObject).setPivotY(FinderImagePreviewUI.c(this.vKB).getHeight() / 2);
      ((MultiTouchImageView)localObject).setScaleX(f1);
      ((MultiTouchImageView)localObject).setScaleY(f1);
      ((MultiTouchImageView)localObject).setTranslationX(paramFloat1);
      ((MultiTouchImageView)localObject).setTranslationY(paramFloat2);
      FinderImagePreviewUI.e(this.vKB).setAlpha(f1);
      AppMethodBeat.o(167299);
    }
    
    public final void T(float paramFloat1, float paramFloat2) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "singleClickOver"})
  static final class c
    implements MMGestureGallery.f
  {
    c(FinderImagePreviewUI paramFinderImagePreviewUI) {}
    
    public final void bmt()
    {
      AppMethodBeat.i(167300);
      FinderImagePreviewUI.b(this.vKB);
      AppMethodBeat.o(167300);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$runEnterAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(167301);
      FinderImagePreviewUI.f(this.vKB);
      AppMethodBeat.o(167301);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(167302);
      FinderImagePreviewUI.g(this.vKB).setVisibility(0);
      AppMethodBeat.o(167302);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$runExitAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class e
    implements Animator.AnimatorListener
  {
    e(MultiTouchImageView paramMultiTouchImageView) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(167305);
      kotlin.g.b.p.h(paramAnimator, "animation");
      AppMethodBeat.o(167305);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(167304);
      kotlin.g.b.p.h(paramAnimator, "animation");
      this.vKB.finish();
      this.vKB.overridePendingTransition(2130771986, 2130771986);
      AppMethodBeat.o(167304);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(167306);
      kotlin.g.b.p.h(paramAnimator, "animation");
      AppMethodBeat.o(167306);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(167303);
      kotlin.g.b.p.h(paramAnimator, "animation");
      if (this.vKG.getScale() > 1.0F) {
        this.vKG.gKy();
      }
      FinderImagePreviewUI.a(this.vKB, this.vKG.getTranslationX());
      FinderImagePreviewUI.b(this.vKB, this.vKG.getTranslationY());
      FinderImagePreviewUI.c(this.vKB, this.vKG.getScaleX());
      FinderImagePreviewUI.d(this.vKB, this.vKG.getScaleY());
      AppMethodBeat.o(167303);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$runExitAnimation$2", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "plugin-finder_release"})
  public static final class f
    implements ValueAnimator.AnimatorUpdateListener
  {
    f(MultiTouchImageView paramMultiTouchImageView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(167307);
      kotlin.g.b.p.h(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(167307);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      this.vKG.setTranslationX(FinderImagePreviewUI.h(this.vKB) * (1.0F - f));
      this.vKG.setTranslationY(FinderImagePreviewUI.i(this.vKB) * (1.0F - f));
      this.vKG.setScaleX((1.0F - f) * FinderImagePreviewUI.j(this.vKB) + f);
      this.vKG.setScaleY(f + (1.0F - f) * FinderImagePreviewUI.k(this.vKB));
      AppMethodBeat.o(167307);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderImagePreviewUI
 * JD-Core Version:    0.7.0.1
 */