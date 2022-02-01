package com.tencent.mobileqq.bubble;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner.AIOAnimator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import hus;
import huw;
import hux;
import huy;
import huz;
import hva;
import hvb;
import hvc;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(11)
public class BubbleNewAIOAnim
  extends AIOAnimationConatiner.AIOAnimator
{
  public long a;
  public AnimatorSet a;
  private final Resources jdField_a_of_type_AndroidContentResResources;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  public View a;
  public BaseBubbleBuilder.ViewHolder a;
  public QQAppInterface a;
  public AnimationConfig a;
  public BubbleConfig a;
  public BubbleManager a;
  private BubbleNewAIOAnim.AnimPicData jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim$AnimPicData;
  public String a;
  public ArrayList a;
  public ConcurrentHashMap a;
  public boolean a;
  public int b;
  public View b;
  public String b;
  public int c;
  public View c;
  public int d;
  public View d;
  public int e;
  public View e;
  public int f;
  public int g;
  public int h;
  private int i;
  private int j;
  private int k = 0;
  private int l = 0;
  private int m;
  private int n = -1;
  
  public BubbleNewAIOAnim(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentResResources = paramListView.getResources();
    this.jdField_h_of_type_Int = AIOUtils.a(12.0F, paramListView.getContext().getResources());
    this.k = AIOUtils.a(50.0F, paramListView.getContext().getResources());
    this.l = AIOUtils.a(45.0F, paramListView.getContext().getResources());
  }
  
  private int a(float paramFloat)
  {
    int i1 = Math.abs(this.jdField_e_of_type_Int - this.jdField_d_of_type_Int);
    if (paramFloat == 0.1F)
    {
      if (this.jdField_a_of_type_Boolean) {}
      for (i1 = this.jdField_e_of_type_Int - this.jdField_h_of_type_Int;; i1 = this.jdField_d_of_type_Int + this.jdField_h_of_type_Int) {
        return i1 - this.i / 2;
      }
    }
    if (paramFloat == 0.9F)
    {
      if (this.jdField_a_of_type_Boolean) {}
      for (paramFloat = this.jdField_d_of_type_Int + this.jdField_h_of_type_Int;; paramFloat = this.jdField_e_of_type_Int - this.jdField_h_of_type_Int)
      {
        i1 = (int)paramFloat;
        break;
      }
    }
    paramFloat = i1 * paramFloat;
    if (this.jdField_a_of_type_Boolean) {}
    for (paramFloat = this.jdField_e_of_type_Int - paramFloat;; paramFloat += this.jdField_d_of_type_Int)
    {
      i1 = (int)paramFloat;
      break;
    }
  }
  
  private int a(Animator paramAnimator, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i1 = 0;
      if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        if (!((BubbleNewAnimConf)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_JavaLangString.equals(paramString)) {}
      }
      for (;;)
      {
        if (i1 != -1)
        {
          paramString = (BubbleNewAnimConf)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if (!(paramString instanceof BubbleNewAnimConf.PathAnimConf)) {
            break label113;
          }
        }
        label113:
        for (paramString = f((BubbleNewAnimConf.PathAnimConf)paramString);; paramString = null)
        {
          if ((paramAnimator != null) && (paramString != null))
          {
            paramString.setDuration(paramAnimator.getDuration());
            paramAnimator.addListener(new huz(this, paramString));
          }
          return i1;
          i1 += 1;
          break;
        }
        i1 = -1;
      }
    }
    return -1;
  }
  
  private ObjectAnimator a(BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, false), this.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_a_of_type_JavaLangString);
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    if (i1 < paramPathAnimConf.jdField_e_of_type_Int)
    {
      String str = localFile.getAbsolutePath() + File.separatorChar + paramPathAnimConf.jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i1 + 1) });
      BubbleNewAIOAnim.AnimPicData localAnimPicData = new BubbleNewAIOAnim.AnimPicData();
      localAnimPicData.jdField_b_of_type_JavaLangString = str;
      localAnimPicData.jdField_a_of_type_JavaLangString = (paramPathAnimConf.jdField_a_of_type_JavaLangString + str);
      boolean bool;
      if (this.jdField_a_of_type_Boolean) {
        bool = paramPathAnimConf.jdField_a_of_type_Boolean;
      }
      for (;;)
      {
        localAnimPicData.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        localArrayList.add(localAnimPicData);
        i1 += 1;
        break;
        if (!paramPathAnimConf.jdField_a_of_type_Boolean) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
    return a(localArrayList);
  }
  
  private ObjectAnimator a(BubbleNewAnimConf.PendantAnimConf paramPendantAnimConf)
  {
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, false), this.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_a_of_type_JavaLangString);
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    if (i1 < paramPendantAnimConf.jdField_e_of_type_Int)
    {
      String str = localFile.getAbsolutePath() + File.separatorChar + paramPendantAnimConf.jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i1 + 1) });
      BubbleNewAIOAnim.AnimPicData localAnimPicData = new BubbleNewAIOAnim.AnimPicData();
      localAnimPicData.jdField_b_of_type_JavaLangString = str;
      localAnimPicData.jdField_a_of_type_JavaLangString = (paramPendantAnimConf.jdField_a_of_type_JavaLangString + str);
      if (this.jdField_a_of_type_Boolean) {}
      for (boolean bool = false;; bool = true)
      {
        localAnimPicData.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        localArrayList.add(localAnimPicData);
        i1 += 1;
        break;
      }
    }
    return b(localArrayList);
  }
  
  private ObjectAnimator a(List paramList)
  {
    if (paramList.size() <= 0) {
      return null;
    }
    Object localObject = new Keyframe[paramList.size() + 1];
    float f1 = 1.0F / paramList.size();
    localObject[0] = Keyframe.ofObject(0.0F, this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim$AnimPicData);
    int i1 = 0;
    if (i1 < paramList.size())
    {
      if (i1 != paramList.size() - 1) {
        localObject[(i1 + 1)] = Keyframe.ofObject((i1 + 1) * f1, paramList.get(i1));
      }
      for (;;)
      {
        i1 += 1;
        break;
        localObject[(i1 + 1)] = Keyframe.ofObject(1.0F, paramList.get(i1));
      }
    }
    localObject = PropertyValuesHolder.ofKeyframe("bitmapData", (Keyframe[])localObject);
    ((PropertyValuesHolder)localObject).setEvaluator(new BubbleNewAIOAnim.BimapEvaluator(this));
    return ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { localObject }).setDuration(paramList.size() * 125);
  }
  
  private Interpolator a(BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    switch (paramPathAnimConf.jdField_f_of_type_Int)
    {
    case 0: 
    default: 
      return null;
    case 1: 
      return new AccelerateInterpolator();
    }
    return new DecelerateInterpolator();
  }
  
  private int b(float paramFloat)
  {
    int i1 = Math.abs(this.jdField_f_of_type_Int - this.jdField_g_of_type_Int);
    if (paramFloat == 0.1F) {
      i1 = this.jdField_f_of_type_Int + this.jdField_h_of_type_Int;
    }
    for (;;)
    {
      return i1 - this.j / 2;
      if (paramFloat == 0.9F)
      {
        i1 = this.jdField_g_of_type_Int - this.jdField_h_of_type_Int;
      }
      else
      {
        float f1 = this.jdField_f_of_type_Int;
        i1 = (int)(i1 * paramFloat + f1);
      }
    }
  }
  
  private ObjectAnimator b(BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    int i2 = a(paramPathAnimConf.jdField_a_of_type_Float);
    int i3 = b(paramPathAnimConf.jdField_b_of_type_Float);
    int i4 = a(paramPathAnimConf.c);
    int i5 = b(paramPathAnimConf.jdField_d_of_type_Float);
    if (this.jdField_a_of_type_Boolean) {}
    for (int i1 = 1;; i1 = -1)
    {
      Object localObject = new ArrayList();
      PathPoint localPathPoint = PathPoint.b(i2, i3);
      localPathPoint.c = (paramPathAnimConf.i * i1);
      localPathPoint.jdField_d_of_type_Float = (paramPathAnimConf.jdField_g_of_type_Int / 100.0F);
      ((ArrayList)localObject).add(localPathPoint);
      localPathPoint = PathPoint.a(i4, i5);
      localPathPoint.c = (i1 * paramPathAnimConf.j);
      localPathPoint.jdField_d_of_type_Float = (paramPathAnimConf.jdField_h_of_type_Int / 100.0F);
      ((ArrayList)localObject).add(localPathPoint);
      localObject = ObjectAnimator.ofObject(this, "pathLocation", new PathPoint.PathEvaluator(), ((ArrayList)localObject).toArray());
      ((ObjectAnimator)localObject).setInterpolator(a(paramPathAnimConf));
      ((ObjectAnimator)localObject).setDuration(((Math.abs(i2 - i4) + Math.abs(i3 - i5)) * 1.0F / this.k * (float)paramPathAnimConf.jdField_a_of_type_Long));
      return localObject;
    }
  }
  
  private ObjectAnimator b(BubbleNewAnimConf.PendantAnimConf paramPendantAnimConf)
  {
    ObjectAnimator localObjectAnimator = a(paramPendantAnimConf);
    if (localObjectAnimator != null) {
      localObjectAnimator.addListener(new hvb(this, paramPendantAnimConf));
    }
    return localObjectAnimator;
  }
  
  private ObjectAnimator b(List paramList)
  {
    if (paramList.size() <= 0) {
      return null;
    }
    Object localObject = new Keyframe[paramList.size() + 1];
    float f1 = 1.0F / paramList.size();
    localObject[0] = Keyframe.ofObject(0.0F, this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim$AnimPicData);
    int i1 = 0;
    if (i1 < paramList.size())
    {
      if (i1 != paramList.size() - 1) {
        localObject[(i1 + 1)] = Keyframe.ofObject((i1 + 1) * f1, paramList.get(i1));
      }
      for (;;)
      {
        i1 += 1;
        break;
        localObject[(i1 + 1)] = Keyframe.ofObject(1.0F, paramList.get(i1));
      }
    }
    localObject = PropertyValuesHolder.ofKeyframe("pendantBitmap", (Keyframe[])localObject);
    ((PropertyValuesHolder)localObject).setEvaluator(new BubbleNewAIOAnim.BimapEvaluator(this));
    return ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { localObject }).setDuration(paramList.size() * 125);
  }
  
  private ObjectAnimator c(BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    int i2 = a(paramPathAnimConf.jdField_a_of_type_Float);
    int i3 = b(paramPathAnimConf.jdField_b_of_type_Float);
    int i4 = a(paramPathAnimConf.c);
    int i5 = b(paramPathAnimConf.jdField_d_of_type_Float);
    int i6 = a(paramPathAnimConf.jdField_e_of_type_Float);
    int i7 = b(paramPathAnimConf.jdField_f_of_type_Float);
    int i8 = a(paramPathAnimConf.jdField_g_of_type_Float);
    int i9 = b(paramPathAnimConf.jdField_h_of_type_Float);
    if (this.jdField_a_of_type_Boolean) {}
    for (int i1 = 1;; i1 = -1)
    {
      Object localObject = new ArrayList();
      PathPoint localPathPoint = PathPoint.b(i2, i3);
      localPathPoint.jdField_d_of_type_Float = paramPathAnimConf.jdField_g_of_type_Int;
      localPathPoint.c = (paramPathAnimConf.i * i1);
      ((ArrayList)localObject).add(localPathPoint);
      localPathPoint = PathPoint.a(i6, i7, i8, i9, i4, i5);
      a("play circle points: " + PathPoint.a(i6, i7, i8, i9, i4, i5).toString());
      localPathPoint.c = (paramPathAnimConf.j * i1);
      localPathPoint.jdField_d_of_type_Float = (paramPathAnimConf.jdField_h_of_type_Int / 100.0F);
      ((ArrayList)localObject).add(localPathPoint);
      localObject = ObjectAnimator.ofObject(this, "pathLocation", new PathPoint.PathEvaluator(), ((ArrayList)localObject).toArray());
      ((ObjectAnimator)localObject).setInterpolator(a(paramPathAnimConf));
      ((ObjectAnimator)localObject).setDuration(((Math.abs(i2 - i4) + Math.abs(i3 - i5)) * 1.0F / this.k * (float)paramPathAnimConf.jdField_a_of_type_Long * 3.141592653589793D * 0.4000000059604645D));
      return localObject;
    }
  }
  
  private ObjectAnimator d(BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    int i3 = a(paramPathAnimConf.jdField_a_of_type_Float);
    int i4 = b(paramPathAnimConf.jdField_b_of_type_Float);
    int i2 = a(paramPathAnimConf.c);
    if (i4 != b(paramPathAnimConf.jdField_d_of_type_Float)) {
      return null;
    }
    int i1;
    int i5;
    int i6;
    if (i2 > i3)
    {
      i1 = 1;
      i5 = this.k;
      i5 = paramPathAnimConf.k * i5;
      i6 = Math.abs(i3 - i2);
      i2 = (int)(Math.abs(i3 - i2) * 1.0F / i5 + 0.5F);
      if (i2 != 0) {
        break label558;
      }
      i2 = 1;
    }
    label558:
    for (;;)
    {
      a("playPeriodicalCircleAnim, periodLen: " + i5 + ", period: " + i2 + ", resize periodLen: " + i6 / i2);
      i5 = i6 / i2;
      i6 = (int)(i3 + i5 * paramPathAnimConf.jdField_e_of_type_Float * i1);
      int i7 = (int)(i4 + i5 * paramPathAnimConf.jdField_f_of_type_Float);
      int i8 = (int)(i3 + i5 * paramPathAnimConf.jdField_g_of_type_Float * i1);
      int i9 = (int)(i4 + i5 * paramPathAnimConf.jdField_h_of_type_Float);
      int i10 = i3 + i5 * i1;
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(PathPoint.b(i3, i4));
      ((ArrayList)localObject).add(PathPoint.a(i6, i7, i8, i9, i10, i4));
      a("next points: " + PathPoint.a(i6, i7, i8, i9, i10, i4).toString());
      i3 = 1;
      for (;;)
      {
        if (i3 < i2)
        {
          int i11 = i1 * i3 * i5 + i6;
          int i12 = i1 * i3 * i5 + i8;
          int i13 = i1 * i3 * i5 + i10;
          ((ArrayList)localObject).add(PathPoint.a(i11, i7, i12, i9, i13, i4));
          a("next points: " + PathPoint.a(i11, i7, i12, i9, i13, i4).toString());
          i3 += 1;
          continue;
          i1 = -1;
          break;
        }
      }
      localObject = ObjectAnimator.ofObject(this, "pathLocation", new PathPoint.PathEvaluator(), ((ArrayList)localObject).toArray());
      ((ObjectAnimator)localObject).setInterpolator(a(paramPathAnimConf));
      a("duration: " + paramPathAnimConf.jdField_a_of_type_Long * i2 * 3.141592653589793D * 0.4000000059604645D);
      ((ObjectAnimator)localObject).setDuration((paramPathAnimConf.jdField_a_of_type_Long * i2 * 3.141592653589793D * 0.4000000059604645D));
      return localObject;
    }
  }
  
  private ObjectAnimator e(BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    int i1 = a(paramPathAnimConf.jdField_a_of_type_Float);
    int i2 = b(paramPathAnimConf.jdField_b_of_type_Float);
    int i3 = a(paramPathAnimConf.c);
    int i4 = b(paramPathAnimConf.jdField_d_of_type_Float);
    if ((i1 == i3) || (i2 == i4)) {
      if (i2 == i4) {
        i1 = 1;
      }
    }
    while (i1 != 0)
    {
      return d(paramPathAnimConf);
      i1 = 0;
      continue;
      return null;
    }
    return null;
  }
  
  private void e()
  {
    ViewGroup localViewGroup;
    int i1;
    if ((this.jdField_b_of_type_AndroidViewView != null) && ((this.jdField_b_of_type_AndroidViewView instanceof ViewGroup)))
    {
      localViewGroup = (ViewGroup)this.jdField_b_of_type_AndroidViewView;
      i1 = 0;
    }
    for (;;)
    {
      if (i1 < localViewGroup.getChildCount())
      {
        View localView = localViewGroup.getChildAt(i1);
        if ((localView.getId() == 2131296324) && (localView.getVisibility() == 0))
        {
          this.jdField_e_of_type_AndroidViewView = localView;
          this.jdField_d_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentWidgetListView.getContext());
          this.jdField_d_of_type_AndroidViewView.layout(0, 0, AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentResResources), AIOUtils.a(59.0F, this.jdField_a_of_type_AndroidContentResResources));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView(this.jdField_d_of_type_AndroidViewView);
        }
      }
      else
      {
        return;
      }
      i1 += 1;
    }
  }
  
  private ObjectAnimator f(BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    ObjectAnimator localObjectAnimator1;
    if ((paramPathAnimConf.jdField_e_of_type_Float == 0.0F) && (paramPathAnimConf.jdField_f_of_type_Float == 0.0F) && (paramPathAnimConf.jdField_g_of_type_Float == 0.0F) && (paramPathAnimConf.jdField_h_of_type_Float == 0.0F)) {
      localObjectAnimator1 = b(paramPathAnimConf);
    }
    ObjectAnimator localObjectAnimator2;
    for (;;)
    {
      localObjectAnimator2 = a(paramPathAnimConf);
      if ((localObjectAnimator1 != null) && (localObjectAnimator2 != null)) {
        break;
      }
      return null;
      if (paramPathAnimConf.jdField_b_of_type_Boolean) {
        localObjectAnimator1 = e(paramPathAnimConf);
      } else {
        localObjectAnimator1 = c(paramPathAnimConf);
      }
    }
    int i1;
    if ((paramPathAnimConf.jdField_a_of_type_Float == paramPathAnimConf.c) && (paramPathAnimConf.jdField_b_of_type_Float == paramPathAnimConf.jdField_d_of_type_Float))
    {
      localObjectAnimator1.setDuration(localObjectAnimator2.getDuration());
      if (paramPathAnimConf.jdField_d_of_type_Int - 1 >= 0)
      {
        i1 = paramPathAnimConf.jdField_d_of_type_Int - 1;
        localObjectAnimator1.setRepeatCount(i1);
      }
    }
    for (;;)
    {
      localObjectAnimator1.addListener(new hva(this, localObjectAnimator2));
      return localObjectAnimator1;
      i1 = 0;
      break;
      localObjectAnimator2.setRepeatCount(-1);
    }
  }
  
  private void f()
  {
    this.jdField_d_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getLeft() + BaseChatItemLayout.k);
    this.jdField_e_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getRight() - BaseChatItemLayout.k);
    this.jdField_f_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getTop() + BaseChatItemLayout.i);
    this.jdField_g_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getBottom() - BaseChatItemLayout.j);
    this.jdField_f_of_type_Int += this.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.q / 2;
    this.jdField_g_of_type_Int -= this.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.r / 2;
    this.jdField_d_of_type_Int += this.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.o / 2;
    this.jdField_e_of_type_Int -= this.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.p / 2;
    if (this.jdField_g_of_type_Int <= this.jdField_f_of_type_Int)
    {
      this.jdField_f_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getTop() + BaseChatItemLayout.i);
      this.jdField_g_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getBottom() - BaseChatItemLayout.j);
    }
    if (this.jdField_e_of_type_Int <= this.jdField_d_of_type_Int)
    {
      this.jdField_d_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getLeft() + BaseChatItemLayout.k);
      this.jdField_e_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getRight() - BaseChatItemLayout.k);
    }
    if (this.jdField_b_of_type_Int == 160)
    {
      this.jdField_d_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getLeft() + BaseChatItemLayout.k - this.i / 3);
      this.jdField_e_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getRight() - BaseChatItemLayout.k + this.i / 3);
      this.jdField_f_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getTop() + BaseChatItemLayout.i - this.j / 3);
      this.jdField_g_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getBottom() - BaseChatItemLayout.j + this.j / 3);
    }
  }
  
  private void g()
  {
    boolean bool = false;
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject1 = (BubbleNewAnimConf)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (!(localObject1 instanceof BubbleNewAnimConf.PathAnimConf)) {}
    }
    for (Object localObject1 = (BubbleNewAnimConf.PathAnimConf)localObject1;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        return;
        i1 += 1;
        break;
      }
      Object localObject2 = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, false), this.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_a_of_type_JavaLangString);
      localObject2 = ((File)localObject2).getAbsolutePath() + File.separatorChar + ((BubbleNewAnimConf.PathAnimConf)localObject1).jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(1) });
      Object localObject3 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
      BitmapFactory.decodeFile((String)localObject2, (BitmapFactory.Options)localObject3);
      this.i = Utils.a(((BitmapFactory.Options)localObject3).outWidth, 320, this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi);
      this.j = Utils.a(((BitmapFactory.Options)localObject3).outHeight, 320, this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi);
      if (this.i > BaseChatItemLayout.k * 2)
      {
        i1 = BaseChatItemLayout.k * 2;
        this.j = ((int)(this.j * i1 * 1.0F / this.i));
        this.i = i1;
      }
      localObject3 = new View(this.jdField_a_of_type_ComTencentWidgetListView.getContext());
      ((View)localObject3).layout(0, 0, this.i, this.j);
      ((View)localObject3).setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim$AnimPicData = new BubbleNewAIOAnim.AnimPicData();
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim$AnimPicData.jdField_b_of_type_JavaLangString = ((String)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim$AnimPicData.jdField_a_of_type_JavaLangString = (((BubbleNewAnimConf.PathAnimConf)localObject1).jdField_a_of_type_JavaLangString + (String)localObject2);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleNewAIOAnim$AnimPicData;
      if (this.jdField_a_of_type_Boolean) {
        bool = ((BubbleNewAnimConf.PathAnimConf)localObject1).jdField_a_of_type_Boolean;
      }
      for (;;)
      {
        ((BubbleNewAIOAnim.AnimPicData)localObject2).jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView((View)localObject3);
        this.jdField_c_of_type_AndroidViewView = ((View)localObject3);
        return;
        if (!((BubbleNewAnimConf.PathAnimConf)localObject1).jdField_a_of_type_Boolean) {
          bool = true;
        }
      }
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    int i1;
    if (this.jdField_a_of_type_ComTencentWidgetListView.s() == 0)
    {
      i1 = 0;
      if (i1 >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label328;
      }
      localObject = (BubbleNewAnimConf)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (!(localObject instanceof BubbleNewAnimConf.PathAnimConf)) {
        break label134;
      }
    }
    label134:
    label273:
    label319:
    label328:
    for (Object localObject = (BubbleNewAnimConf.PathAnimConf)localObject;; localObject = null)
    {
      localObject = a((BubbleNewAnimConf.PathAnimConf)localObject);
      if (localObject != null)
      {
        ((ObjectAnimator)localObject).setDuration(200L);
        localArrayList.add(localObject);
      }
      int i2 = 0;
      i1 = -1;
      int i3;
      for (;;)
      {
        if (i2 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          if (i2 == i1)
          {
            i3 = i1;
            i2 += 1;
            i1 = i3;
            continue;
            i1 += 1;
            break;
          }
          localObject = (BubbleNewAnimConf)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
          if ((localObject instanceof BubbleNewAnimConf.PathAnimConf)) {
            localObject = f((BubbleNewAnimConf.PathAnimConf)localObject);
          }
        }
      }
      for (;;)
      {
        i3 = i1;
        if (localObject == null) {
          break;
        }
        localArrayList.add(localObject);
        i3 = i1;
        break;
        if ((localObject instanceof BubbleNewAnimConf.PendantAnimConf))
        {
          BubbleNewAnimConf.PendantAnimConf localPendantAnimConf = (BubbleNewAnimConf.PendantAnimConf)localObject;
          localObject = b(localPendantAnimConf);
          if (localObject != null) {
            if (localPendantAnimConf.jdField_d_of_type_Int - 1 < 0) {
              break label273;
            }
          }
          for (i3 = localPendantAnimConf.jdField_d_of_type_Int - 1;; i3 = 0)
          {
            ((ObjectAnimator)localObject).setRepeatCount(i3);
            if (TextUtils.isEmpty(localPendantAnimConf.c)) {
              break label319;
            }
            i1 = a((Animator)localObject, localPendantAnimConf.c);
            break;
          }
          this.jdField_a_of_type_AndroidAnimationAnimatorSet.playSequentially(localArrayList);
          this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new hux(this));
          this.jdField_a_of_type_AndroidOsHandler.post(new huy(this));
          return;
        }
        else
        {
          localObject = null;
        }
      }
    }
  }
  
  private void i()
  {
    ThreadManager.b(new hvc(this));
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setTranslationY(this.jdField_c_of_type_AndroidViewView.getTranslationY() + paramInt);
    }
    if ((this.jdField_d_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView != null))
    {
      paramInt = (int)(this.jdField_d_of_type_AndroidViewView.getTranslationY() + paramInt);
      this.jdField_d_of_type_AndroidViewView.setTranslationY(paramInt);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleNewAIOAnim", 4, paramString);
    }
  }
  
  protected boolean a(int paramInt)
  {
    return true;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_c_of_type_Int = AIOUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.a());
    Object localObject1 = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_c_of_type_Int));
    Object localObject2;
    if ((localObject1 != null) && ((localObject1 instanceof BaseBubbleBuilder.ViewHolder)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder = ((BaseBubbleBuilder.ViewHolder)localObject1);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_c_of_type_AndroidViewView;
      this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
      if ((this.jdField_b_of_type_AndroidViewView != null) && ((this.jdField_b_of_type_AndroidViewView instanceof ViewGroup)))
      {
        localObject2 = (ViewGroup)this.jdField_b_of_type_AndroidViewView;
        paramInt1 = 0;
        if (paramInt1 < ((ViewGroup)localObject2).getChildCount())
        {
          View localView = ((ViewGroup)localObject2).getChildAt(paramInt1);
          if (localView.getId() != 2131296324) {
            break label193;
          }
          this.jdField_e_of_type_AndroidViewView = localView;
        }
      }
      label143:
      localObject2 = new StringBuilder().append("relayout children,  p : ").append(this.jdField_c_of_type_Int).append(", get object: ");
      if (localObject1 == null) {
        break label207;
      }
    }
    label193:
    label207:
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(paramBoolean);
      return false;
      paramInt1 += 1;
      break;
      c();
      break label143;
    }
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    if ((this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) && (this.jdField_a_of_type_AndroidAnimationAnimatorSet.isRunning())) {
      return false;
    }
    if (!VersionUtils.e()) {
      return false;
    }
    this.n = ((Integer)paramVarArgs[0]).intValue();
    this.jdField_a_of_type_Long = ((Long)paramVarArgs[1]).longValue();
    this.jdField_b_of_type_Int = ((Integer)paramVarArgs[2]).intValue();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramVarArgs[3]);
    a("start msg id " + this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager = ((BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43));
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager == null) || (this.jdField_a_of_type_Long == 0L)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, false);
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, this.n);
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig == null) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_a_of_type_JavaUtilArrayList;
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      return false;
    }
    this.jdField_c_of_type_Int = AIOUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.a());
    paramVarArgs = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_c_of_type_Int));
    if ((paramVarArgs != null) && ((paramVarArgs instanceof BaseBubbleBuilder.ViewHolder)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder = ((BaseBubbleBuilder.ViewHolder)paramVarArgs);
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.a.isSend();
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_c_of_type_AndroidViewView;
      this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
      this.m = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth();
      i();
      g();
      f();
      e();
      h();
      return true;
    }
    return false;
  }
  
  protected void c()
  {
    a("now stop new bubble animation conf!");
    this.jdField_a_of_type_AndroidOsHandler.post(new huw(this));
  }
  
  public void setBitmapData(BubbleNewAIOAnim.AnimPicData paramAnimPicData)
  {
    if (paramAnimPicData == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_c_of_type_AndroidViewView == null))
          {
            c();
            return;
          }
        } while (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramAnimPicData.jdField_a_of_type_JavaLangString));
        if (paramAnimPicData.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          localObject = new hus(paramAnimPicData.jdField_a_of_type_AndroidGraphicsBitmap);
          ((hus)localObject).jdField_a_of_type_Boolean = paramAnimPicData.jdField_a_of_type_JavaLangBoolean.booleanValue();
          this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
          this.jdField_a_of_type_JavaLangString = paramAnimPicData.jdField_a_of_type_JavaLangString;
          a("set bitmap path:" + paramAnimPicData.jdField_a_of_type_JavaLangString);
          this.jdField_c_of_type_AndroidViewView.invalidate();
          return;
        }
      } while (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramAnimPicData.jdField_a_of_type_JavaLangString));
      a("get cache bitmap path:" + paramAnimPicData.jdField_a_of_type_JavaLangString);
      localObject = (Bitmap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramAnimPicData.jdField_a_of_type_JavaLangString);
    } while (localObject == null);
    Object localObject = new hus((Bitmap)localObject);
    ((hus)localObject).jdField_a_of_type_Boolean = paramAnimPicData.jdField_a_of_type_JavaLangBoolean.booleanValue();
    this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_JavaLangString = paramAnimPicData.jdField_a_of_type_JavaLangString;
    this.jdField_c_of_type_AndroidViewView.invalidate();
  }
  
  public void setPathLocation(PathPoint paramPathPoint)
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_c_of_type_AndroidViewView == null))
    {
      c();
      return;
    }
    this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth();
    if (this.jdField_a_of_type_Boolean) {
      f1 = paramPathPoint.jdField_a_of_type_Float;
    }
    float f2;
    for (float f1 = i1 - this.m + f1;; f1 = paramPathPoint.jdField_a_of_type_Float)
    {
      f2 = paramPathPoint.jdField_b_of_type_Float + this.jdField_b_of_type_AndroidViewView.getTop() - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
      if ((f2 <= this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getBottom()) && (f2 >= this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop())) {
        break;
      }
      a("now scroll over sreen, stop bubble animatorset!");
      c();
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setTranslationX(f1);
    this.jdField_c_of_type_AndroidViewView.setTranslationY(f2);
    this.jdField_c_of_type_AndroidViewView.setAlpha(paramPathPoint.jdField_d_of_type_Float);
    this.jdField_c_of_type_AndroidViewView.setRotation(paramPathPoint.c);
  }
  
  public void setPendantBitmap(BubbleNewAIOAnim.AnimPicData paramAnimPicData)
  {
    if (paramAnimPicData == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_d_of_type_AndroidViewView == null) || (this.jdField_e_of_type_AndroidViewView == null))
          {
            c();
            return;
          }
        } while (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(paramAnimPicData.jdField_a_of_type_JavaLangString));
        int i1 = this.jdField_e_of_type_AndroidViewView.getLeft();
        this.jdField_d_of_type_AndroidViewView.setTranslationX(i1);
        i1 = this.jdField_e_of_type_AndroidViewView.getTop() + this.jdField_b_of_type_AndroidViewView.getTop() - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
        this.jdField_d_of_type_AndroidViewView.setTranslationY(i1);
        if ((i1 > this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getBottom()) || (i1 < this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop()))
        {
          a("now scroll over sreen, stop pendant animatorset!");
          c();
          return;
        }
        a("tranY: " + i1 + ", containerTop:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop() + ", parent top:" + this.jdField_b_of_type_AndroidViewView.getTop() + ", pendantTop:" + this.jdField_e_of_type_AndroidViewView.getTop());
        if (paramAnimPicData.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          localObject = new hus(paramAnimPicData.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_b_of_type_JavaLangString = paramAnimPicData.jdField_a_of_type_JavaLangString;
          ((hus)localObject).jdField_a_of_type_Boolean = paramAnimPicData.jdField_a_of_type_JavaLangBoolean.booleanValue();
          this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
          this.jdField_d_of_type_AndroidViewView.invalidate();
          return;
        }
      } while (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramAnimPicData.jdField_a_of_type_JavaLangString));
      localObject = (Bitmap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramAnimPicData.jdField_a_of_type_JavaLangString);
    } while (localObject == null);
    Object localObject = new hus((Bitmap)localObject);
    this.jdField_b_of_type_JavaLangString = paramAnimPicData.jdField_a_of_type_JavaLangString;
    ((hus)localObject).jdField_a_of_type_Boolean = paramAnimPicData.jdField_a_of_type_JavaLangBoolean.booleanValue();
    this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
    this.jdField_d_of_type_AndroidViewView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleNewAIOAnim
 * JD-Core Version:    0.7.0.1
 */