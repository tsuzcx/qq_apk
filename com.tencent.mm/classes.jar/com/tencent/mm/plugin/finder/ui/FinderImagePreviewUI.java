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
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.loader.e;
import com.tencent.mm.plugin.finder.e.a;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;
import com.tencent.mm.ui.y;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;

@com.tencent.mm.ui.base.a(35)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "animationLayout", "Lcom/tencent/mm/view/AnimationLayout;", "gallery", "Lcom/tencent/mm/ui/tools/MMGestureGallery;", "galleryBg", "Landroid/view/View;", "isAvatar", "", "playingAnimation", "root", "scaleX", "", "scaleY", "thumRect", "Landroid/graphics/Rect;", "translationX", "translationY", "convertActivityFromTranslucent", "getLayoutId", "", "goBack", "", "initDragGallery", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "runEnterAnimation", "runExitAnimation", "setFullscreen", "FinderPreviewImageAdapter", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderImagePreviewUI
  extends MMFinderUI
{
  private View FQV;
  private boolean FQW;
  private Rect FQX;
  private final String TAG = "MicroMsg.FinderImagePreviewUI";
  private float ayc;
  private float ayd;
  private View lBX;
  private MMGestureGallery pIt;
  private AnimationLayout pIy;
  private boolean pIz;
  private float scaleX;
  private float scaleY;
  
  private static final void a(FinderImagePreviewUI paramFinderImagePreviewUI)
  {
    AppMethodBeat.i(347603);
    kotlin.g.b.s.u(paramFinderImagePreviewUI, "this$0");
    paramFinderImagePreviewUI.goBack();
    AppMethodBeat.o(347603);
  }
  
  private final void goBack()
  {
    Object localObject3 = null;
    AppMethodBeat.i(167310);
    if (this.FQX != null)
    {
      if (this.pIz)
      {
        finish();
        AppMethodBeat.o(167310);
        return;
      }
      this.pIz = true;
      Log.i(this.TAG, "runExitAnimation");
      Object localObject2 = this.pIt;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("gallery");
        localObject1 = null;
      }
      localObject1 = ((MMGestureGallery)localObject1).getSelectedView();
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
        AppMethodBeat.o(167310);
        throw ((Throwable)localObject1);
      }
      MultiTouchImageView localMultiTouchImageView = (MultiTouchImageView)localObject1;
      localObject2 = this.pIy;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("animationLayout");
        localObject1 = null;
      }
      View localView = this.FQV;
      localObject2 = localView;
      if (localView == null)
      {
        kotlin.g.b.s.bIx("galleryBg");
        localObject2 = null;
      }
      localView = this.lBX;
      if (localView == null) {
        kotlin.g.b.s.bIx("root");
      }
      for (;;)
      {
        ((AnimationLayout)localObject1).a((View)localObject2, (View)localObject3, new ViewAnimHelper.ViewInfo(this.FQX), (Animator.AnimatorListener)new d(localMultiTouchImageView, this), (ValueAnimator.AnimatorUpdateListener)new e(localMultiTouchImageView, this));
        AppMethodBeat.o(167310);
        return;
        localObject3 = localView;
      }
    }
    finish();
    AppMethodBeat.o(167310);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_img_preview_ui;
  }
  
  public final void initView()
  {
    View localView = null;
    Object localObject2 = null;
    AppMethodBeat.i(167309);
    getController().getSupportActionBar().hide();
    getController().s((Activity)this, getResources().getColor(e.b.transparent));
    getController().setNavigationbarColor(getResources().getColor(e.b.transparent));
    Object localObject1 = findViewById(e.e.root);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.root)");
    this.lBX = ((View)localObject1);
    localObject1 = findViewById(e.e.gallery);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.gallery)");
    this.pIt = ((MMGestureGallery)localObject1);
    localObject1 = findViewById(e.e.gallery_bg);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.gallery_bg)");
    this.FQV = ((View)localObject1);
    localObject1 = findViewById(e.e.animation_layout);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.animation_layout)");
    this.pIy = ((AnimationLayout)localObject1);
    localObject1 = getIntent().getStringArrayListExtra("key_file_list");
    Object localObject3 = getIntent().getStringArrayListExtra("key_url_list");
    this.FQW = getIntent().getBooleanExtra("key_preview_avatar", false);
    this.FQX = ((Rect)getIntent().getParcelableExtra("key_thumb_location"));
    Log.i(this.TAG, "files %s, urls", new Object[] { localObject1, localObject3 });
    a locala = new a();
    if (localObject1 != null)
    {
      locala.aB((ArrayList)localObject1);
      locala.hJv = true;
      localObject3 = this.pIt;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("gallery");
        localObject1 = null;
      }
      ((MMGestureGallery)localObject1).setSingleClickOverListener(new FinderImagePreviewUI..ExternalSyntheticLambda0(this));
      localObject3 = this.pIt;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("gallery");
        localObject1 = null;
      }
      ((MMGestureGallery)localObject1).setAdapter((SpinnerAdapter)locala);
      localObject1 = this.pIt;
      if (localObject1 != null) {
        break label473;
      }
      kotlin.g.b.s.bIx("gallery");
      localObject1 = null;
      label326:
      ((MMGestureGallery)localObject1).setGalleryScaleListener((MMGestureGallery.b)new b(this));
      if (this.FQX == null) {
        break label488;
      }
      if (!this.pIz)
      {
        this.pIz = true;
        Log.i(this.TAG, "runEnterAnimation");
        localObject1 = this.pIy;
        if (localObject1 != null) {
          break label476;
        }
        kotlin.g.b.s.bIx("animationLayout");
        localObject1 = null;
        label386:
        localView = this.FQV;
        if (localView != null) {
          break label479;
        }
        kotlin.g.b.s.bIx("galleryBg");
        localView = null;
        label402:
        localObject3 = this.lBX;
        if (localObject3 != null) {
          break label482;
        }
        kotlin.g.b.s.bIx("root");
      }
    }
    for (;;)
    {
      ((AnimationLayout)localObject1).a(localView, (View)localObject2, new ViewAnimHelper.ViewInfo(this.FQX), (Animator.AnimatorListener)new c(this));
      AppMethodBeat.o(167309);
      return;
      if (localObject3 == null) {
        break;
      }
      locala.aB((ArrayList)localObject3);
      locala.hJv = false;
      break;
      label473:
      break label326;
      label476:
      break label386;
      label479:
      break label402;
      label482:
      localObject2 = localObject3;
    }
    label488:
    localObject1 = this.FQV;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("galleryBg");
      localObject1 = localView;
    }
    for (;;)
    {
      ((View)localObject1).setVisibility(0);
      AppMethodBeat.o(167309);
      return;
    }
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
    paramBundle = getWindow().getDecorView();
    kotlin.g.b.s.s(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(5894);
    initView();
    AppMethodBeat.o(167308);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$FinderPreviewImageAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI;)V", "images", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "isLocal", "", "getCount", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "view", "viewGroup", "Landroid/view/ViewGroup;", "setImages", "", "files", "setIsLocal", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends BaseAdapter
  {
    private ArrayList<String> FQY;
    boolean hJv;
    
    public a()
    {
      AppMethodBeat.i(167298);
      this.FQY = new ArrayList();
      AppMethodBeat.o(167298);
    }
    
    private static final void a(g paramg, Bitmap paramBitmap)
    {
      AppMethodBeat.i(347243);
      paramg = paramg.getView();
      if (paramg != null)
      {
        ((MultiTouchImageView)paramg).dU(paramBitmap.getWidth(), paramBitmap.getHeight());
        ((MultiTouchImageView)paramg).jma();
      }
      AppMethodBeat.o(347243);
    }
    
    private static final void a(com.tencent.mm.loader.g.a.a parama, g paramg, Bitmap paramBitmap)
    {
      AppMethodBeat.i(347248);
      if (paramBitmap != null) {
        MMHandlerThread.postToMainThread(new FinderImagePreviewUI.a..ExternalSyntheticLambda1(paramg, paramBitmap));
      }
      AppMethodBeat.o(347248);
    }
    
    private String getItem(int paramInt)
    {
      AppMethodBeat.i(167294);
      String str = (String)this.FQY.get(paramInt);
      AppMethodBeat.o(167294);
      return str;
    }
    
    public final void aB(ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(167297);
      kotlin.g.b.s.u(paramArrayList, "files");
      this.FQY.addAll((Collection)paramArrayList);
      AppMethodBeat.o(167297);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(167293);
      int i = this.FQY.size();
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
      kotlin.g.b.s.u(paramViewGroup, "viewGroup");
      if (paramView == null)
      {
        paramView = (View)new MultiTouchImageView((Context)this.FQZ, 0, 0, (byte)0);
        ((MultiTouchImageView)paramView).setLayoutParams((ViewGroup.LayoutParams)new Gallery.LayoutParams(-1, -1));
      }
      for (;;)
      {
        if (this.hJv)
        {
          paramViewGroup = e.noo;
          paramViewGroup = e.blh();
          String str = getItem(paramInt);
          kotlin.g.b.s.checkNotNull(str);
          paramViewGroup = paramViewGroup.GE(str);
          paramViewGroup.nov = FinderImagePreviewUI.a..ExternalSyntheticLambda0.INSTANCE;
          paramViewGroup.d((ImageView)paramView);
        }
        label207:
        for (;;)
        {
          AppMethodBeat.o(167296);
          return paramView;
          if (!FinderImagePreviewUI.k(this.FQZ)) {
            paramViewGroup = p.ExI;
          }
          for (paramViewGroup = p.eCl().dk(new com.tencent.mm.plugin.finder.loader.s(Util.nullAsNil(getItem(paramInt)), v.FKY));; paramViewGroup = p.eCs().dk(new com.tencent.mm.plugin.finder.loader.b(Util.nullAsNil(getItem(paramInt)), v.FLE)))
          {
            if (!(paramViewGroup instanceof com.tencent.mm.loader.a.a)) {
              break label207;
            }
            ((com.tencent.mm.loader.a.a)paramViewGroup).a((ImageView)paramView, (m)a.FRa);
            break;
            paramViewGroup = p.ExI;
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "imageView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements m<g<?>, Bitmap, ah>
    {
      public static final a FRa;
      
      static
      {
        AppMethodBeat.i(167292);
        FRa = new a();
        AppMethodBeat.o(167292);
      }
      
      a()
      {
        super();
      }
      
      private static final void b(g paramg, Bitmap paramBitmap)
      {
        AppMethodBeat.i(346721);
        kotlin.g.b.s.u(paramg, "$imageView");
        paramg = paramg.getView();
        if (paramg != null)
        {
          ((MultiTouchImageView)paramg).dU(paramBitmap.getWidth(), paramBitmap.getHeight());
          ((MultiTouchImageView)paramg).jma();
        }
        AppMethodBeat.o(346721);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$initDragGallery$1", "Lcom/tencent/mm/ui/tools/MMGestureGallery$IOnGalleryScale;", "onGalleryScale", "", "tx", "", "ty", "onSetPrePrama", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements MMGestureGallery.b
  {
    b(FinderImagePreviewUI paramFinderImagePreviewUI) {}
    
    public final void aC(float paramFloat1, float paramFloat2) {}
    
    public final void onGalleryScale(float paramFloat1, float paramFloat2)
    {
      float f1 = 1.0F;
      Object localObject2 = null;
      AppMethodBeat.i(167299);
      MMGestureGallery localMMGestureGallery = FinderImagePreviewUI.b(this.FQZ);
      Object localObject1 = localMMGestureGallery;
      if (localMMGestureGallery == null)
      {
        kotlin.g.b.s.bIx("gallery");
        localObject1 = null;
      }
      float f2 = 1.0F - paramFloat2 / ((MMGestureGallery)localObject1).getHeight();
      if (f2 > 1.0F) {}
      for (;;)
      {
        Log.d(FinderImagePreviewUI.c(this.FQZ), "onGalleryScale tx: %f, ty: %f, scale: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(f1) });
        localMMGestureGallery = FinderImagePreviewUI.b(this.FQZ);
        localObject1 = localMMGestureGallery;
        if (localMMGestureGallery == null)
        {
          kotlin.g.b.s.bIx("gallery");
          localObject1 = null;
        }
        localObject1 = ((MMGestureGallery)localObject1).getSelectedView();
        if (localObject1 != null) {
          break;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
        AppMethodBeat.o(167299);
        throw ((Throwable)localObject1);
        f1 = f2;
      }
      MultiTouchImageView localMultiTouchImageView = (MultiTouchImageView)localObject1;
      localMMGestureGallery = FinderImagePreviewUI.b(this.FQZ);
      localObject1 = localMMGestureGallery;
      if (localMMGestureGallery == null)
      {
        kotlin.g.b.s.bIx("gallery");
        localObject1 = null;
      }
      localMultiTouchImageView.setPivotX(((MMGestureGallery)localObject1).getWidth() / 2);
      localMMGestureGallery = FinderImagePreviewUI.b(this.FQZ);
      localObject1 = localMMGestureGallery;
      if (localMMGestureGallery == null)
      {
        kotlin.g.b.s.bIx("gallery");
        localObject1 = null;
      }
      localMultiTouchImageView.setPivotY(((MMGestureGallery)localObject1).getHeight() / 2);
      localMultiTouchImageView.setScaleX(f1);
      localMultiTouchImageView.setScaleY(f1);
      localMultiTouchImageView.setTranslationX(paramFloat1);
      localMultiTouchImageView.setTranslationY(paramFloat2);
      localObject1 = FinderImagePreviewUI.d(this.FQZ);
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("root");
        localObject1 = localObject2;
      }
      for (;;)
      {
        ((View)localObject1).setAlpha(f1);
        AppMethodBeat.o(167299);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$runEnterAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animator.AnimatorListener
  {
    c(FinderImagePreviewUI paramFinderImagePreviewUI) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(167301);
      FinderImagePreviewUI.e(this.FQZ);
      AppMethodBeat.o(167301);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(167302);
      View localView = FinderImagePreviewUI.f(this.FQZ);
      paramAnimator = localView;
      if (localView == null)
      {
        kotlin.g.b.s.bIx("galleryBg");
        paramAnimator = null;
      }
      paramAnimator.setVisibility(0);
      AppMethodBeat.o(167302);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$runExitAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Animator.AnimatorListener
  {
    d(MultiTouchImageView paramMultiTouchImageView, FinderImagePreviewUI paramFinderImagePreviewUI) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(167305);
      kotlin.g.b.s.u(paramAnimator, "animation");
      AppMethodBeat.o(167305);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(167304);
      kotlin.g.b.s.u(paramAnimator, "animation");
      jdField_this.finish();
      paramAnimator = jdField_this;
      int i = e.a.anim_not_change;
      paramAnimator.overridePendingTransition(i, i);
      AppMethodBeat.o(167304);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(167306);
      kotlin.g.b.s.u(paramAnimator, "animation");
      AppMethodBeat.o(167306);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(167303);
      kotlin.g.b.s.u(paramAnimator, "animation");
      if (this.FRb.getScale() > 1.0F) {
        this.FRb.jma();
      }
      FinderImagePreviewUI.a(jdField_this, this.FRb.getTranslationX());
      FinderImagePreviewUI.b(jdField_this, this.FRb.getTranslationY());
      FinderImagePreviewUI.c(jdField_this, this.FRb.getScaleX());
      FinderImagePreviewUI.d(jdField_this, this.FRb.getScaleY());
      AppMethodBeat.o(167303);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$runExitAnimation$2", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(MultiTouchImageView paramMultiTouchImageView, FinderImagePreviewUI paramFinderImagePreviewUI) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(167307);
      kotlin.g.b.s.u(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(167307);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      this.FRb.setTranslationX(FinderImagePreviewUI.g(jdField_this) * (1.0F - f));
      this.FRb.setTranslationY(FinderImagePreviewUI.h(jdField_this) * (1.0F - f));
      this.FRb.setScaleX((1.0F - f) * FinderImagePreviewUI.i(jdField_this) + f);
      this.FRb.setScaleY(f + (1.0F - f) * FinderImagePreviewUI.j(jdField_this));
      AppMethodBeat.o(167307);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderImagePreviewUI
 * JD-Core Version:    0.7.0.1
 */