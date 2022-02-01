package com.tencent.mobileqq.facetoface;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.utils.StackBlur;
import com.tencent.qphone.base.util.QLog;
import ija;
import ijb;

public abstract class Face2FaceDetailBaseView
  extends RelativeLayout
{
  private static final String jdField_a_of_type_JavaLangString = "Face2FaceDetailBaseView";
  protected static final int d = 0;
  protected static final int e = 1;
  protected float a;
  protected int a;
  long jdField_a_of_type_Long = 0L;
  protected Canvas a;
  protected View a;
  public Face2FaceDetailBaseView.IFace2faceContext a;
  public Face2FaceFriendBubbleView a;
  protected boolean a;
  protected final int b;
  protected View b;
  private boolean b;
  protected final int c;
  public View c;
  protected View d;
  protected View e;
  
  public Face2FaceDetailBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Float = 1.5F;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 8;
    this.jdField_c_of_type_Int = 10;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
    d();
  }
  
  private AnimationSet a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(-paramInt1, 0.0F, -paramInt2, 0.0F);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(paramFloat1, 1.0F, paramFloat2, 1.0F, 1, 0.0F, 1, 0.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setDuration(350L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator(this.jdField_a_of_type_Float));
    return localAnimationSet;
  }
  
  private AnimationSet b(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, -paramInt1, 0.0F, -paramInt2);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, paramFloat1, 1.0F, paramFloat2, 1, 0.0F, 1, 0.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setDuration(350L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator(this.jdField_a_of_type_Float));
    return localAnimationSet;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
    this.jdField_a_of_type_Int = 2130838334;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected abstract void a();
  
  protected void a(View paramView)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
      long l2 = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(localBitmap);
      paramView.draw(this.jdField_a_of_type_AndroidGraphicsCanvas);
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(Color.parseColor("#70000000"), PorterDuff.Mode.DARKEN);
      long l3 = System.currentTimeMillis();
      paramView = Bitmap.createScaledBitmap(localBitmap, localBitmap.getWidth() / 10, localBitmap.getHeight() / 10, true);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
      long l4 = System.currentTimeMillis();
      StackBlur.a(paramView, 8);
      long l5 = System.currentTimeMillis();
      if (paramView != null) {
        this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(new BitmapDrawable(getResources(), paramView));
      }
      while (QLog.isColorLevel())
      {
        QLog.d("Face2FaceDetailBaseView", 2, "blurBackground, createEmptyBmp=" + (l2 - l1) + ", drawBmp=" + (l3 - l2) + ", scale-recyle=" + (l4 - l3) + ", blur=" + (l5 - l4) + " total=" + (l5 - l1));
        return;
        this.jdField_c_of_type_AndroidViewView.setBackgroundResource(this.jdField_a_of_type_Int);
      }
      return;
    }
    catch (OutOfMemoryError paramView)
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(this.jdField_a_of_type_Int);
      if (QLog.isColorLevel())
      {
        QLog.e("Face2FaceDetailBaseView", 2, "blurBackground:" + paramView.toString());
        return;
      }
    }
    catch (Exception paramView)
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(this.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.e("Face2FaceDetailBaseView", 2, "blurBackground:" + paramView.toString());
      }
    }
  }
  
  public void a(View paramView, Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext.a();
    this.d = paramView;
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView = paramFace2FaceFriendBubbleView;
    a(this.d);
    b();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void b()
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    setVisibility(0);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.findViewById(2131297636);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.findViewById(2131297634);
    int i = this.jdField_a_of_type_AndroidViewView.getLeft();
    int j = ((View)localObject1).getLeft();
    int k = ((View)localObject2).getLeft();
    int m = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.getLeft();
    int n = this.jdField_a_of_type_AndroidViewView.getTop();
    int i1 = ((View)localObject1).getTop();
    int i2 = ((View)localObject2).getTop();
    int i3 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.getTop();
    float f = ((View)localObject1).getWidth() * 1.0F / this.jdField_a_of_type_AndroidViewView.getWidth();
    localObject1 = a(i - (j + k + m), n - (i2 + i1 + i3), f, f);
    localObject2 = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject2).setDuration(200L);
    ((AlphaAnimation)localObject2).setStartOffset(150L);
    ((AlphaAnimation)localObject2).setAnimationListener(new ija(this));
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation1.setDuration(150L);
    localAlphaAnimation1.setStartOffset(350L);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation2.setDuration(150L);
    localAlphaAnimation2.setStartOffset(350L);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.a();
    this.jdField_c_of_type_AndroidViewView.startAnimation((Animation)localObject2);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject1);
    this.jdField_b_of_type_AndroidViewView.startAnimation(localAlphaAnimation1);
    this.e.startAnimation(localAlphaAnimation2);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceDetailBaseView", 2, "animShow: totalTime=" + (l2 - this.jdField_a_of_type_Long) + ",blurAndVisiableTime:" + (l1 - this.jdField_a_of_type_Long) + ",buildAnimTime:" + (l2 - l1) + "");
    }
  }
  
  public boolean b()
  {
    c();
    return true;
  }
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceDetailBaseView", 2, "animHide, isAnimHideEnd=" + this.jdField_b_of_type_Boolean);
    }
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.findViewById(2131297636);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.findViewById(2131297634);
    int i = this.jdField_a_of_type_AndroidViewView.getLeft();
    int j = ((View)localObject1).getLeft();
    int k = ((View)localObject2).getLeft();
    int m = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.getLeft();
    int n = this.jdField_a_of_type_AndroidViewView.getTop();
    int i1 = ((View)localObject1).getTop();
    int i2 = ((View)localObject2).getTop();
    int i3 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.getTop();
    float f = ((View)localObject1).getWidth() * 1.0F / this.jdField_a_of_type_AndroidViewView.getWidth();
    localObject1 = b(i - (j + k + m), n - (i2 + i1 + i3), f, f);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext.c();
    ((AnimationSet)localObject1).setAnimationListener(new ijb(this));
    localObject2 = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject2).setDuration(200L);
    ((AlphaAnimation)localObject2).setFillAfter(true);
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation1.setDuration(150L);
    localAlphaAnimation1.setFillAfter(true);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation2.setDuration(150L);
    localAlphaAnimation2.setFillAfter(true);
    this.jdField_c_of_type_AndroidViewView.startAnimation((Animation)localObject2);
    this.jdField_b_of_type_AndroidViewView.startAnimation(localAlphaAnimation1);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject1);
    this.e.startAnimation(localAlphaAnimation2);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    a();
    this.jdField_c_of_type_AndroidViewView = new View(getContext());
    addView(this.jdField_c_of_type_AndroidViewView, 0, new RelativeLayout.LayoutParams(-1, -1));
  }
  
  public void setInfc(Face2FaceDetailBaseView.IFace2faceContext paramIFace2faceContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext = paramIFace2faceContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView
 * JD-Core Version:    0.7.0.1
 */