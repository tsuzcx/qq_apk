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
import com.tencent.mm.loader.a.a.a;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(35)
@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "animationLayout", "Lcom/tencent/mm/view/AnimationLayout;", "gallery", "Lcom/tencent/mm/ui/tools/MMGestureGallery;", "galleryBg", "Landroid/view/View;", "isAvatar", "", "playingAnimation", "root", "scaleX", "", "scaleY", "thumRect", "Landroid/graphics/Rect;", "translationX", "translationY", "convertActivityFromTranslucent", "getLayoutId", "", "goBack", "", "initDragGallery", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "runEnterAnimation", "runExitAnimation", "setFullscreen", "FinderPreviewImageAdapter", "plugin-finder_release"})
public final class FinderImagePreviewUI
  extends MMFinderUI
{
  private final String TAG = "MicroMsg.FinderImagePreviewUI";
  private HashMap _$_findViewCache;
  private View fOB;
  private MMGestureGallery iUH;
  private AnimationLayout iUM;
  private boolean iUN;
  private View sCO;
  private boolean sCP;
  private Rect sCQ;
  private float scaleX;
  private float scaleY;
  private float translationX;
  private float translationY;
  
  private final void goBack()
  {
    AppMethodBeat.i(167310);
    if (this.sCQ != null)
    {
      if (this.iUN)
      {
        finish();
        AppMethodBeat.o(167310);
        return;
      }
      this.iUN = true;
      ad.i(this.TAG, "runExitAnimation");
      Object localObject = this.iUH;
      if (localObject == null) {
        p.bcb("gallery");
      }
      localObject = ((MMGestureGallery)localObject).getSelectedView();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
        AppMethodBeat.o(167310);
        throw ((Throwable)localObject);
      }
      localObject = (MultiTouchImageView)localObject;
      AnimationLayout localAnimationLayout = this.iUM;
      if (localAnimationLayout == null) {
        p.bcb("animationLayout");
      }
      View localView1 = this.sCO;
      if (localView1 == null) {
        p.bcb("galleryBg");
      }
      View localView2 = this.fOB;
      if (localView2 == null) {
        p.bcb("root");
      }
      localAnimationLayout.a(localView1, localView2, new ViewAnimHelper.ViewInfo(this.sCQ), (Animator.AnimatorListener)new e(this, (MultiTouchImageView)localObject), (ValueAnimator.AnimatorUpdateListener)new f(this, (MultiTouchImageView)localObject));
      AppMethodBeat.o(167310);
      return;
    }
    finish();
    AppMethodBeat.o(167310);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204020);
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
    AppMethodBeat.o(204020);
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
    this.fOB = ((View)localObject1);
    localObject1 = findViewById(2131300335);
    p.g(localObject1, "findViewById(R.id.gallery)");
    this.iUH = ((MMGestureGallery)localObject1);
    localObject1 = findViewById(2131300336);
    p.g(localObject1, "findViewById(R.id.gallery_bg)");
    this.sCO = ((View)localObject1);
    localObject1 = findViewById(2131296674);
    p.g(localObject1, "findViewById(R.id.animation_layout)");
    this.iUM = ((AnimationLayout)localObject1);
    Object localObject2 = getIntent().getStringArrayListExtra("key_file_list");
    Object localObject3 = getIntent().getStringArrayListExtra("key_url_list");
    this.sCP = getIntent().getBooleanExtra("key_preview_avatar", false);
    this.sCQ = ((Rect)getIntent().getParcelableExtra("key_thumb_location"));
    ad.i(this.TAG, "files %s, urls", new Object[] { localObject2, localObject3 });
    localObject1 = new a();
    if (localObject2 != null)
    {
      ((a)localObject1).X((ArrayList)localObject2);
      ((a)localObject1).dCQ = true;
    }
    for (;;)
    {
      localObject2 = this.iUH;
      if (localObject2 == null) {
        p.bcb("gallery");
      }
      ((MMGestureGallery)localObject2).setSingleClickOverListener((MMGestureGallery.f)new c(this));
      localObject2 = this.iUH;
      if (localObject2 == null) {
        p.bcb("gallery");
      }
      ((MMGestureGallery)localObject2).setAdapter((SpinnerAdapter)localObject1);
      localObject1 = this.iUH;
      if (localObject1 == null) {
        p.bcb("gallery");
      }
      ((MMGestureGallery)localObject1).setGalleryScaleListener((MMGestureGallery.b)new b(this));
      if (this.sCQ == null) {
        break;
      }
      if (!this.iUN)
      {
        this.iUN = true;
        ad.i(this.TAG, "runEnterAnimation");
        localObject1 = this.iUM;
        if (localObject1 == null) {
          p.bcb("animationLayout");
        }
        localObject2 = this.sCO;
        if (localObject2 == null) {
          p.bcb("galleryBg");
        }
        localObject3 = this.fOB;
        if (localObject3 == null) {
          p.bcb("root");
        }
        ((AnimationLayout)localObject1).a((View)localObject2, (View)localObject3, new ViewAnimHelper.ViewInfo(this.sCQ), (Animator.AnimatorListener)new d(this));
      }
      AppMethodBeat.o(167309);
      return;
      if (localObject3 != null)
      {
        ((a)localObject1).X((ArrayList)localObject3);
        ((a)localObject1).dCQ = false;
      }
    }
    localObject1 = this.sCO;
    if (localObject1 == null) {
      p.bcb("galleryBg");
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$FinderPreviewImageAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI;)V", "images", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "isLocal", "", "getCount", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "view", "viewGroup", "Landroid/view/ViewGroup;", "setImages", "", "files", "setIsLocal", "plugin-finder_release"})
  public final class a
    extends BaseAdapter
  {
    boolean dCQ;
    private ArrayList<String> sCR;
    
    public a()
    {
      AppMethodBeat.i(167298);
      this.sCR = new ArrayList();
      AppMethodBeat.o(167298);
    }
    
    private String getItem(int paramInt)
    {
      AppMethodBeat.i(167294);
      String str = (String)this.sCR.get(paramInt);
      AppMethodBeat.o(167294);
      return str;
    }
    
    public final void X(ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(167297);
      p.h(paramArrayList, "files");
      this.sCR.addAll((Collection)paramArrayList);
      AppMethodBeat.o(167297);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(167293);
      int i = this.sCR.size();
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
      p.h(paramViewGroup, "viewGroup");
      if (paramView == null)
      {
        paramView = (View)new MultiTouchImageView((Context)this.sCS, 0, 0, (byte)0);
        ((MultiTouchImageView)paramView).setLayoutParams((ViewGroup.LayoutParams)new Gallery.LayoutParams(-1, -1));
      }
      for (;;)
      {
        Object localObject;
        if (this.dCQ)
        {
          paramViewGroup = com.tencent.mm.loader.e.hcm;
          paramViewGroup = com.tencent.mm.loader.e.aqF();
          localObject = getItem(paramInt);
          if (localObject == null) {
            p.gfZ();
          }
          paramViewGroup = paramViewGroup.xW((String)localObject);
          paramViewGroup.hcq = ((com.tencent.mm.loader.f.e)a.sCT);
          paramViewGroup.c((ImageView)paramView);
          AppMethodBeat.o(167296);
          return paramView;
        }
        if (!FinderImagePreviewUI.a(this.sCS)) {
          paramViewGroup = i.sja;
        }
        for (paramViewGroup = i.cCB().bI(new com.tencent.mm.plugin.finder.loader.l(bt.nullAsNil(getItem(paramInt)), r.syD));; paramViewGroup = i.cCE().bI(new com.tencent.mm.plugin.finder.loader.a(bt.nullAsNil(getItem(paramInt)))))
        {
          paramViewGroup = (com.tencent.mm.loader.a.a)paramViewGroup;
          localObject = (ImageView)paramView;
          m localm = (m)b.sCW;
          p.h(localObject, "imageView");
          if (paramViewGroup.hcL == null) {
            paramViewGroup.hcL = ((com.tencent.mm.loader.e.b.d)new a.a(localm, (ImageView)localObject, new g(localObject)));
          }
          paramViewGroup.vw();
          break;
          paramViewGroup = i.sja;
        }
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "", "kotlin.jvm.PlatformType", "imageView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
    static final class a<T, R>
      implements com.tencent.mm.loader.f.e<String, Bitmap>
    {
      public static final a sCT;
      
      static
      {
        AppMethodBeat.i(167289);
        sCT = new a();
        AppMethodBeat.o(167289);
      }
      
      @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$FinderPreviewImageAdapter$getView$1$1$1"})
      static final class a
        implements Runnable
      {
        a(g paramg, Bitmap paramBitmap) {}
        
        public final void run()
        {
          AppMethodBeat.i(167287);
          Object localObject = this.sCU;
          p.g(localObject, "imageView");
          localObject = ((g)localObject).getView();
          if (localObject != null)
          {
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
              AppMethodBeat.o(167287);
              throw ((Throwable)localObject);
            }
            ((MultiTouchImageView)localObject).cH(this.sCV.getWidth(), this.sCV.getHeight());
            ((MultiTouchImageView)localObject).fyy();
            AppMethodBeat.o(167287);
            return;
          }
          AppMethodBeat.o(167287);
        }
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "imageView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "invoke"})
    static final class b
      extends q
      implements m<g<?>, Bitmap, z>
    {
      public static final b sCW;
      
      static
      {
        AppMethodBeat.i(167292);
        sCW = new b();
        AppMethodBeat.o(167292);
      }
      
      b()
      {
        super();
      }
      
      @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$FinderPreviewImageAdapter$getView$2$1$1"})
      static final class a
        implements Runnable
      {
        a(g paramg, Bitmap paramBitmap) {}
        
        public final void run()
        {
          AppMethodBeat.i(167290);
          Object localObject = this.sCU.getView();
          if (localObject != null)
          {
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
              AppMethodBeat.o(167290);
              throw ((Throwable)localObject);
            }
            ((MultiTouchImageView)localObject).cH(this.sCV.getWidth(), this.sCV.getHeight());
            ((MultiTouchImageView)localObject).fyy();
            AppMethodBeat.o(167290);
            return;
          }
          AppMethodBeat.o(167290);
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$initDragGallery$1", "Lcom/tencent/mm/ui/tools/MMGestureGallery$IOnGalleryScale;", "onGalleryScale", "", "tx", "", "ty", "onSetPrePrama", "plugin-finder_release"})
  public static final class b
    implements MMGestureGallery.b
  {
    public final void O(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(167299);
      float f2 = 1.0F - paramFloat2 / FinderImagePreviewUI.c(this.sCS).getHeight();
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      ad.d(FinderImagePreviewUI.d(this.sCS), "onGalleryScale tx: %f, ty: %f, scale: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(f1) });
      Object localObject = FinderImagePreviewUI.c(this.sCS).getSelectedView();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
        AppMethodBeat.o(167299);
        throw ((Throwable)localObject);
      }
      localObject = (MultiTouchImageView)localObject;
      ((MultiTouchImageView)localObject).setPivotX(FinderImagePreviewUI.c(this.sCS).getWidth() / 2);
      ((MultiTouchImageView)localObject).setPivotY(FinderImagePreviewUI.c(this.sCS).getHeight() / 2);
      ((MultiTouchImageView)localObject).setScaleX(f1);
      ((MultiTouchImageView)localObject).setScaleY(f1);
      ((MultiTouchImageView)localObject).setTranslationX(paramFloat1);
      ((MultiTouchImageView)localObject).setTranslationY(paramFloat2);
      FinderImagePreviewUI.e(this.sCS).setAlpha(f1);
      AppMethodBeat.o(167299);
    }
    
    public final void P(float paramFloat1, float paramFloat2) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "singleClickOver"})
  static final class c
    implements MMGestureGallery.f
  {
    c(FinderImagePreviewUI paramFinderImagePreviewUI) {}
    
    public final void aRp()
    {
      AppMethodBeat.i(167300);
      FinderImagePreviewUI.b(this.sCS);
      AppMethodBeat.o(167300);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$runEnterAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(167301);
      FinderImagePreviewUI.f(this.sCS);
      AppMethodBeat.o(167301);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(167302);
      FinderImagePreviewUI.g(this.sCS).setVisibility(0);
      AppMethodBeat.o(167302);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$runExitAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
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
      this.sCS.finish();
      this.sCS.overridePendingTransition(2130771986, 2130771986);
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
      if (this.sCX.getScale() > 1.0F) {
        this.sCX.fyy();
      }
      FinderImagePreviewUI.a(this.sCS, this.sCX.getTranslationX());
      FinderImagePreviewUI.b(this.sCS, this.sCX.getTranslationY());
      FinderImagePreviewUI.c(this.sCS, this.sCX.getScaleX());
      FinderImagePreviewUI.d(this.sCS, this.sCX.getScaleY());
      AppMethodBeat.o(167303);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$runExitAnimation$2", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "plugin-finder_release"})
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
      this.sCX.setTranslationX(FinderImagePreviewUI.h(this.sCS) * (1.0F - f));
      this.sCX.setTranslationY(FinderImagePreviewUI.i(this.sCS) * (1.0F - f));
      this.sCX.setScaleX((1.0F - f) * FinderImagePreviewUI.j(this.sCS) + f);
      this.sCX.setScaleY(f + (1.0F - f) * FinderImagePreviewUI.k(this.sCS));
      AppMethodBeat.o(167307);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderImagePreviewUI
 * JD-Core Version:    0.7.0.1
 */