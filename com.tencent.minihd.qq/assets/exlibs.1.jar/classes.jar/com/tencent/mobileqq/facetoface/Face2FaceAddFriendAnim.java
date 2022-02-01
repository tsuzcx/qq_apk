package com.tencent.mobileqq.facetoface;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import iit;
import iiu;
import iiv;
import iiw;
import iix;
import iiz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Face2FaceAddFriendAnim
{
  public static final int a = 1;
  public static byte[] a;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 1;
  public static final int j = 2;
  static final int o = 10;
  double jdField_a_of_type_Double = 0.0D;
  public float a;
  public Context a;
  public RotateAnimation a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public QQAppInterface a;
  Face2FaceUserData jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData = null;
  public List a;
  Map jdField_a_of_type_JavaUtilMap;
  boolean jdField_a_of_type_Boolean = false;
  public float b;
  List jdField_b_of_type_JavaUtilList;
  boolean jdField_b_of_type_Boolean = false;
  List c;
  List d;
  List e;
  List f = Arrays.asList(new Integer[] { Integer.valueOf(2131297249), Integer.valueOf(2131297250), Integer.valueOf(2131297251), Integer.valueOf(2131297252), Integer.valueOf(2131297253), Integer.valueOf(2131297254), Integer.valueOf(2131297255), Integer.valueOf(2131297256), Integer.valueOf(2131297257), Integer.valueOf(2131297258) });
  int k = 1;
  public int l = -1;
  public int m;
  public int n;
  int p = 0;
  int q = -1;
  int r;
  public int s = 0;
  public int t = 0;
  int u = 0;
  int v = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[0];
  }
  
  public Face2FaceAddFriendAnim(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return (int)(Math.random() * (paramInt2 - paramInt1 + 1) + paramInt1);
  }
  
  public float a(int paramInt1, int paramInt2)
  {
    return (float)(Math.random() * (paramInt2 - paramInt1) + paramInt1);
  }
  
  public int a()
  {
    int i1 = -1;
    if (this.jdField_b_of_type_JavaUtilList.size() > 0)
    {
      int i2 = (int)a(0, this.jdField_b_of_type_JavaUtilList.size());
      i1 = ((Integer)this.jdField_b_of_type_JavaUtilList.get(i2)).intValue();
      this.jdField_b_of_type_JavaUtilList.remove(i2);
    }
    return i1;
  }
  
  public Face2FaceFriendBubbleView a(Face2FaceUserData paramFace2FaceUserData)
  {
    String str = paramFace2FaceUserData.e;
    if ((paramFace2FaceUserData instanceof Face2FaceGroupProfile)) {
      str = paramFace2FaceUserData.e + "_" + ((Face2FaceGroupProfile)paramFace2FaceUserData).b;
    }
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(str)) {
      return (Face2FaceFriendBubbleView)this.jdField_a_of_type_JavaUtilList.get(((Integer)this.jdField_a_of_type_JavaUtilMap.get(str)).intValue());
    }
    return null;
  }
  
  public Face2FaceFriendBubbleView a(String paramString)
  {
    Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = null;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      localFace2FaceFriendBubbleView = (Face2FaceFriendBubbleView)this.jdField_a_of_type_JavaUtilList.get(((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString)).intValue());
    }
    return localFace2FaceFriendBubbleView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.c.clear();
    this.d.clear();
    this.e.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt)
  {
    Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = (Face2FaceFriendBubbleView)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if ((localFace2FaceFriendBubbleView != null) && (localFace2FaceFriendBubbleView.c() != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(localFace2FaceFriendBubbleView.c())))
    {
      this.jdField_a_of_type_JavaUtilMap.remove(localFace2FaceFriendBubbleView.c());
      localFace2FaceFriendBubbleView.setVisibility(4);
      localFace2FaceFriendBubbleView.setStatusWithoutAnimation(1);
      localFace2FaceFriendBubbleView.setClickable(false);
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.a, 2, "removeShowedFriendMap uinToHoleIndex remove( " + localFace2FaceFriendBubbleView.c() + ", " + paramInt + " )");
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    if (paramInt == 1)
    {
      this.jdField_b_of_type_Float = a(45, 180);
      if (a(0, 1) < 0.5D) {
        this.jdField_b_of_type_Float *= -1.0F;
      }
    }
    for (long l1 = a(800, 1500);; l1 = 750L)
    {
      RotateAnimation localRotateAnimation = new RotateAnimation(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(l1);
      localRotateAnimation.setFillAfter(true);
      localRotateAnimation.setInterpolator(new iix(this));
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localRotateAnimation);
      localRotateAnimation.setAnimationListener(new iiv(this, paramInt, paramBoolean));
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, View paramView, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    this.m = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    this.n = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297245));
    if ((paramInt == 1) && (!TextUtils.isEmpty(paramString)))
    {
      ((ImageView)paramView.findViewById(2131297243)).setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838339);
      paramQQAppInterface = paramQQAppInterface.a(paramString, (byte)3, false, false);
      if (paramQQAppInterface != null) {
        break label476;
      }
      paramQQAppInterface = ImageUtil.d();
    }
    label476:
    for (;;)
    {
      paramString = (ImageView)paramView.findViewById(2131297244);
      paramString.setImageBitmap(paramQQAppInterface);
      paramString.setVisibility(0);
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramInt = 0;
      while (paramInt < 10)
      {
        paramQQAppInterface = (Face2FaceFriendBubbleView)paramView.findViewById(((Integer)this.f.get(paramInt)).intValue());
        paramQQAppInterface.setStatusWithAnimation(1);
        paramQQAppInterface.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_JavaUtilList.add(paramQQAppInterface);
        paramInt += 1;
      }
      this.jdField_b_of_type_JavaUtilList = new LinkedList();
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
      this.c = new LinkedList();
      this.c.addAll(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9) }));
      this.d = new LinkedList();
      this.d.addAll(Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7) }));
      this.e = new LinkedList();
      this.e.addAll(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(8), Integer.valueOf(9) }));
      return;
    }
  }
  
  public void a(Face2FaceUserData paramFace2FaceUserData, boolean paramBoolean)
  {
    if ((paramFace2FaceUserData == null) || (this.jdField_a_of_type_AndroidContentContext == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.a, 2, "startFriendDisappearAnimation disappear data is " + paramFace2FaceUserData + " mContext " + this.jdField_a_of_type_AndroidContentContext);
      }
      return;
    }
    Object localObject = paramFace2FaceUserData.e;
    if ((paramFace2FaceUserData instanceof Face2FaceGroupProfile)) {
      localObject = paramFace2FaceUserData.e + "_" + ((Face2FaceGroupProfile)paramFace2FaceUserData).b;
    }
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject)) {}
    for (int i1 = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(localObject)).intValue();; i1 = -1)
    {
      if (i1 == -1)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(Face2FaceAddFriendActivity.a, 2, "startFriendDisappearAnimation disappear uin " + paramFace2FaceUserData.e.substring(0, 4) + " is not in the hole");
        QLog.d(Face2FaceAddFriendActivity.b, 2, "startFriendDisappearAnimation disappear uin " + paramFace2FaceUserData.e.substring(0, 4) + " is not in the hole");
        this.s += 1;
        return;
      }
      localObject = (Face2FaceFriendBubbleView)this.jdField_a_of_type_JavaUtilList.get(i1);
      if (paramBoolean)
      {
        ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.4F, 1.0F, 0.4F, 1, 0.5F, 1, 0.5F);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        AnimationSet localAnimationSet = new AnimationSet(true);
        localAnimationSet.addAnimation(localScaleAnimation);
        localAnimationSet.addAnimation(localAlphaAnimation);
        localAnimationSet.setDuration(1000L);
        localAnimationSet.setFillAfter(true);
        localAnimationSet.setInterpolator(new iiz(this));
        localAnimationSet.setAnimationListener(new iiu(this));
        if (localObject != null) {
          ((Face2FaceFriendBubbleView)localObject).startAnimation(localAnimationSet);
        }
      }
      if (localObject == null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.a, 2, "startFriendDisappearAnimation disappear uin " + paramFace2FaceUserData.e.substring(0, 4));
      }
      if (this.jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(i1))) {
        this.jdField_b_of_type_JavaUtilList.remove(Integer.valueOf(i1));
      }
      a(i1);
      ((Face2FaceAddFriendActivity)this.jdField_a_of_type_AndroidContentContext).c(paramFace2FaceUserData);
      this.c.add(Integer.valueOf(i1));
      if ((i1 >= 2) && (i1 <= 7))
      {
        this.d.add(Integer.valueOf(i1));
        return;
      }
      if (((i1 < 0) || (i1 > 1)) && ((i1 < 8) || (i1 > 9))) {
        break;
      }
      this.e.add(Integer.valueOf(i1));
      return;
    }
  }
  
  public void a(Face2FaceUserData paramFace2FaceUserData, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramFace2FaceUserData == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.a, 2, "startFriendInAnimation  data is " + paramFace2FaceUserData + " mContext " + this.jdField_a_of_type_AndroidContentContext);
      }
    }
    int i2;
    int i1;
    label92:
    Object localObject1;
    do
    {
      do
      {
        return;
        i2 = -1;
        if (this.c.size() != 1) {
          break;
        }
        i1 = ((Integer)this.c.get(0)).intValue();
      } while (i1 == -1);
      localObject1 = (Face2FaceFriendBubbleView)this.jdField_a_of_type_JavaUtilList.get(i1);
      this.r = i1;
    } while (localObject1 == null);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData = paramFace2FaceUserData;
    ((Face2FaceFriendBubbleView)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFace2FaceUserData);
    ((Face2FaceFriendBubbleView)localObject1).setVisibility(0);
    ((Face2FaceFriendBubbleView)localObject1).setClickable(true);
    label219:
    Object localObject2;
    int i8;
    int i10;
    int i9;
    int i11;
    int i6;
    int i7;
    label399:
    int i4;
    int i5;
    label460:
    int i3;
    if (QLog.isColorLevel())
    {
      if (!TextUtils.isEmpty(paramFace2FaceUserData.e)) {
        QLog.d(Face2FaceAddFriendActivity.a, 2, "startFriendInAnimation get ( currentUin= " + paramFace2FaceUserData.e.substring(0, 4) + " , index = " + i1 + " )");
      }
    }
    else
    {
      this.k = 1;
      this.jdField_b_of_type_Boolean = false;
      this.l = -1;
      localObject2 = new int[2];
      this.jdField_a_of_type_AndroidWidgetImageView.getLocationOnScreen((int[])localObject2);
      i8 = localObject2[0] + (this.jdField_a_of_type_AndroidWidgetImageView.getWidth() >> 1);
      i10 = localObject2[1] + (this.jdField_a_of_type_AndroidWidgetImageView.getHeight() >> 1);
      localObject2 = new int[2];
      ((Face2FaceFriendBubbleView)localObject1).getLocationOnScreen((int[])localObject2);
      i9 = localObject2[0] + (((Face2FaceFriendBubbleView)localObject1).getWidth() >> 1);
      i11 = localObject2[1] + (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1);
      i6 = Math.abs(i8 - i9);
      i7 = Math.abs(i10 - i11);
      this.jdField_a_of_type_Double = (i6 / i7);
      i2 = ((Face2FaceFriendBubbleView)localObject1).getWidth();
      if (i6 != 0) {
        break label1105;
      }
      i2 = (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1) + i10;
      if (i11 > i10) {
        i2 = this.n - i10 + (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1);
      }
      i4 = localObject2[0] + ((Face2FaceFriendBubbleView)localObject1).getWidth();
      i5 = i2 - i7;
      if (i11 > i10) {
        this.k = 2;
      }
      if (i9 > i8)
      {
        i4 = this.m - localObject2[0];
        if (i11 >= i10) {
          break label1123;
        }
        this.k = 5;
      }
      if (i2 - i10 < ((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1)
      {
        i3 = i5;
        if (i2 - (this.n - i10) < ((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1) {}
      }
      else
      {
        if (i11 >= i10) {
          break label1140;
        }
        i3 = i10 + (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1);
        i2 = localObject2[1] + ((Face2FaceFriendBubbleView)localObject1).getHeight();
        if (i9 >= i8) {
          break label1132;
        }
        this.k = 3;
      }
    }
    for (;;)
    {
      label542:
      i4 = i3 * i6 / i7 - i6;
      i3 = i2;
      switch (this.k)
      {
      default: 
        i2 = i4;
        label612:
        double d1 = this.jdField_a_of_type_Double;
        boolean bool = this.jdField_b_of_type_Boolean;
        localObject2 = new TranslateAnimation(i2, 0.0F, i3, 0.0F);
        ((TranslateAnimation)localObject2).setDuration(400L);
        ((TranslateAnimation)localObject2).setInterpolator(new iiz(this));
        ((TranslateAnimation)localObject2).setAnimationListener(new iit(this, paramFace2FaceUserData, i1, d1, bool, paramBoolean3, paramFace2FaceUserData, paramBoolean1, paramBoolean2, (Face2FaceFriendBubbleView)localObject1, paramInt));
        ((Face2FaceFriendBubbleView)localObject1).startAnimation((Animation)localObject2);
        localObject1 = paramFace2FaceUserData.e;
        if ((paramFace2FaceUserData instanceof Face2FaceGroupProfile)) {
          localObject1 = paramFace2FaceUserData.e + "_" + ((Face2FaceGroupProfile)paramFace2FaceUserData).b;
        }
        break;
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilMap.put(localObject1, Integer.valueOf(i1));
        ((Face2FaceAddFriendActivity)this.jdField_a_of_type_AndroidContentContext).a(paramFace2FaceUserData, paramBoolean1, paramBoolean2);
        if (QLog.isColorLevel()) {
          QLog.d(Face2FaceAddFriendActivity.b, 2, "uinToHoleIndex put identify=" + (String)localObject1);
        }
        this.c.remove(Integer.valueOf(i1));
        if (this.d.contains(Integer.valueOf(i1))) {
          this.d.remove(Integer.valueOf(i1));
        }
        while (QLog.isColorLevel())
        {
          QLog.d(Face2FaceAddFriendActivity.a, 2, "startFriendInAnimation currentUIn= " + paramFace2FaceUserData.e.substring(0, 4) + " startAnimation OK");
          return;
          i1 = i2;
          if (this.c.size() <= 1) {
            break label92;
          }
          if (this.d.size() == 1)
          {
            i1 = ((Integer)this.d.get(0)).intValue();
            break label92;
          }
          if (this.d.size() > 1)
          {
            i1 = ((Integer)this.d.get(a(0, this.d.size() - 1))).intValue();
            break label92;
          }
          if (this.e.size() == 0)
          {
            i1 = ((Integer)this.e.get(0)).intValue();
            break label92;
          }
          i1 = i2;
          if (this.e.size() <= 1) {
            break label92;
          }
          i1 = ((Integer)this.e.get(a(0, this.e.size() - 1))).intValue();
          break label92;
          QLog.d(Face2FaceAddFriendActivity.a, 2, "startFriendInAnimation get  currentUin= null");
          break label219;
          label1105:
          i2 = ((i2 >> 1) + i8) * i7 / i6;
          break label399;
          label1123:
          this.k = 6;
          break label460;
          label1132:
          this.k = 4;
          break label542;
          label1140:
          if (i11 <= i10) {
            break label1402;
          }
          i2 = this.n;
          i3 = (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1) + (i2 - i10);
          i2 = this.n - localObject2[1];
          if (i9 < i8)
          {
            this.k = 7;
            break label542;
          }
          this.k = 8;
          break label542;
          i2 = -i4;
          i3 = -i3;
          this.l = -1;
          this.jdField_b_of_type_Boolean = false;
          break label612;
          i2 = -i4;
          this.l = -1;
          this.jdField_b_of_type_Boolean = true;
          break label612;
          i2 = -i4;
          i3 = -i3;
          this.l = -1;
          this.jdField_b_of_type_Boolean = false;
          break label612;
          i3 = -i3;
          this.l = 1;
          this.jdField_b_of_type_Boolean = false;
          i2 = i4;
          break label612;
          i3 = -i3;
          this.l = 1;
          this.jdField_b_of_type_Boolean = false;
          i2 = i4;
          break label612;
          this.l = 1;
          this.jdField_b_of_type_Boolean = true;
          i2 = i4;
          break label612;
          i2 = -i4;
          this.l = -1;
          this.jdField_b_of_type_Boolean = true;
          break label612;
          this.l = 1;
          this.jdField_b_of_type_Boolean = true;
          i2 = i4;
          break label612;
          if (this.e.contains(Integer.valueOf(i1))) {
            this.e.remove(Integer.valueOf(i1));
          }
        }
      }
      label1402:
      i3 = i2;
      i2 = i5;
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) && (!this.jdField_b_of_type_JavaUtilList.contains(paramString))) {
      this.jdField_b_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilMap.get(paramString));
    }
  }
  
  boolean a()
  {
    return this.c.size() > 0;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    long l1 = a(800, 1200);
    float f1 = this.jdField_b_of_type_Float;
    int i1 = (int)a(5, 12);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float - i1);
      if (f1 == this.jdField_b_of_type_Float) {
        if (this.jdField_b_of_type_Float <= this.jdField_a_of_type_Float) {
          break label190;
        }
      }
    }
    label190:
    float f2;
    for (this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float - i1);; this.jdField_b_of_type_Float = (i1 + f2))
    {
      this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(f1, this.jdField_b_of_type_Float, 1, 0.5F, 1, 0.5F);
      this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(l1);
      this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
      this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setInterpolator(new iix(this));
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
      this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setAnimationListener(new iiw(this));
      return;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float + i1);
      break;
      f2 = this.jdField_a_of_type_Float;
    }
  }
  
  public void b(int paramInt)
  {
    this.s = 0;
    this.t = paramInt;
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      this.jdField_b_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilMap.get(paramString));
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddFriendActivity", 2, "stopCompassShakeAnimation");
    }
    if (this.jdField_a_of_type_AndroidViewAnimationRotateAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.cancel();
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    }
  }
  
  public void c(int paramInt)
  {
    this.u = 0;
    this.v = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendAnim
 * JD-Core Version:    0.7.0.1
 */