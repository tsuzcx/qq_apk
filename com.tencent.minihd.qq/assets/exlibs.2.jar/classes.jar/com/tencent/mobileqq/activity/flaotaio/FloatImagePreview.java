package com.tencent.mobileqq.activity.flaotaio;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.Gallery;
import gmi;
import gmj;
import gmk;
import gml;
import gmm;
import gmn;
import java.net.URL;

public class FloatImagePreview
  implements AdapterView.OnItemClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "NOSAMPLE";
  private static final String jdField_b_of_type_JavaLangString = "DISPLAY";
  private static final String c = "PART";
  private float jdField_a_of_type_Float;
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  public AIOImageData a;
  private FloatGalleryProgress jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatGalleryProgress;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  MessageForPic jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
  private Gallery jdField_a_of_type_ComTencentWidgetGallery;
  private gmn jdField_a_of_type_Gmn;
  boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  public boolean b;
  
  public FloatImagePreview(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramQQAppInterface.a().getApplicationContext();
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
  }
  
  private int a(int paramInt)
  {
    return (int)(this.jdField_a_of_type_Float * paramInt + 0.5F);
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData = ((AIOImageData)paramBundle.getParcelable("FLOAT_IMAGE_DATA"));
  }
  
  private void e()
  {
    SizeMeasure.b(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903323, null);
    if ((this.jdField_a_of_type_AndroidViewView instanceof FloatRelativeLayout)) {
      ((FloatRelativeLayout)this.jdField_a_of_type_AndroidViewView).setWindowCloseCallBack(new gmi(this));
    }
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)this.jdField_a_of_type_AndroidViewView.findViewById(2131297712));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131296573);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatGalleryProgress = new FloatGalleryProgress();
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatGalleryProgress.a(this.jdField_a_of_type_AndroidContentContext, (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297713));
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatGalleryProgress.a();
    this.jdField_a_of_type_Gmn = new gmn(this);
    this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_Gmn);
    this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(this);
  }
  
  public void a()
  {
    WindowManager localWindowManager;
    WindowManager.LayoutParams localLayoutParams;
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_Boolean = true;
      localWindowManager = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
      localLayoutParams = new WindowManager.LayoutParams();
      localLayoutParams.flags = 262432;
      localLayoutParams.format = -3;
      localLayoutParams.softInputMode = 18;
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      localLayoutParams.type = 2002;
      localLayoutParams.windowAnimations = 2131558951;
    }
    try
    {
      localWindowManager.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      label92:
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new gmk(this));
      return;
    }
    catch (Exception localException)
    {
      break label92;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatGalleryProgress != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatGalleryProgress.b(paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatGalleryProgress != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatGalleryProgress.c();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null)) {
      return;
    }
    MessageForPic localMessageForPic = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
    PicReq localPicReq1;
    int i;
    switch (paramInt2)
    {
    case 3: 
    default: 
      return;
    case 1: 
      localPicReq1 = PicBusiManager.a(5, 1);
      i = 65537;
    }
    for (;;)
    {
      try
      {
        localPicReq1.a(localMessageForPic, localMessageForPic.getPicDownloadInfo());
        String str1 = URLDrawableHelper.a(localMessageForPic, i, null).toString();
        String str2 = AbsDownloader.d(str1.toString());
        Log.i("app2", "downloadImage-->url=" + str1 + " cacheFile=" + str2);
        localPicReq1.a(new gmj(this, paramLong, paramInt1, paramInt2, localMessageForPic.size, str2));
        PicBusiManager.a(localPicReq1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      catch (Exception localException)
      {
        Log.e("app2", "download imgage error", localException);
        return;
      }
      PicReq localPicReq2 = PicBusiManager.a(6, 1536, 1);
      i = 1;
      continue;
      localPicReq2 = PicBusiManager.a(7, 1);
      i = 131075;
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    Log.i("app2", "notifyImageProgress=" + paramInt3 + " needRefresh=" + paramBoolean);
    if (paramInt2 == 2)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
      if ((((AIOImageData)localObject).a == paramLong1) && (((AIOImageData)localObject).e == paramInt1))
      {
        this.jdField_a_of_type_Int = paramInt3;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatGalleryProgress != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatGalleryProgress.a())) {
          this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatGalleryProgress.b(paramInt3 / 100);
        }
        if ((paramBoolean) && (this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount() > 0))
        {
          localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(0);
          this.jdField_a_of_type_Gmn.a(0, (View)localObject, paramBoolean);
        }
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    Log.i("app2", "notifyImageResult");
    if ((paramInt2 == 2) && (this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount() > 0))
    {
      paramString = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(0);
      this.jdField_a_of_type_Gmn.b(0, paramString, paramBoolean);
    }
  }
  
  public void a(Bundle paramBundle, MessageForPic paramMessageForPic)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
    a(paramBundle);
    e();
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).removeView(this.jdField_a_of_type_AndroidViewView);
      if (paramBoolean) {
        d();
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    Gallery localGallery = this.jdField_a_of_type_ComTencentWidgetGallery;
    int i = SizeMeasure.h(this.jdField_a_of_type_AndroidContentContext);
    int j = SizeMeasure.i(this.jdField_a_of_type_AndroidContentContext);
    float f1 = 200.0F / i;
    float f2 = i - a(300) + a(116) - i / 2;
    float f3 = a(140) + a(140) - j / 2;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(350L);
    localValueAnimator.setInterpolator(new LinearInterpolator());
    localValueAnimator.addUpdateListener(new gml(this, localView, f1, localGallery, f2, f3));
    localValueAnimator.addListener(new gmm(this));
    localValueAnimator.start();
  }
  
  public void c()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery;
    int i = SizeMeasure.h(this.jdField_a_of_type_AndroidContentContext);
    int j = SizeMeasure.i(this.jdField_a_of_type_AndroidContentContext);
    float f1 = 200.0F / i;
    float f2 = i - a(300) + a(116) - i / 2;
    float f3 = a(140) + a(140) - j / 2;
    AnimationSet localAnimationSet = new AnimationSet(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(f1, 1.0F, f1, 1.0F, 1, 0.5F, 1, 0.5F);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, f2, 0, 0.0F, 0, f3, 0, 0.0F);
    localAnimationSet.addAnimation(new AlphaAnimation(0.0F, 1.0F));
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.setDuration(400);
    localAnimationSet.setInterpolator(new DecelerateInterpolator(1.2F));
    ((Gallery)localObject).startAnimation(localAnimationSet);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(400);
    localView.startAnimation((Animation)localObject);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FloatImagePreview
 * JD-Core Version:    0.7.0.1
 */