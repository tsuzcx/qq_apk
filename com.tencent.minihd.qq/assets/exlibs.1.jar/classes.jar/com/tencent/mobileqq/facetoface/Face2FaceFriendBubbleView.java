package com.tencent.mobileqq.facetoface;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import ijc;
import ijd;
import ije;
import java.util.HashMap;

public class Face2FaceFriendBubbleView
  extends FrameLayout
{
  public static final int a = 1;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131297635, 2131297639 };
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  private static final int e = 1;
  private static final int f = 2;
  private View jdField_a_of_type_AndroidViewView = null;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new ijc(this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation = null;
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private String jdField_a_of_type_JavaLangString = null;
  private HashMap jdField_a_of_type_JavaUtilHashMap = null;
  private Animation.AnimationListener jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener = new ijd(this);
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation = null;
  private ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  private String jdField_b_of_type_JavaLangString = "";
  private ImageView c = null;
  private int g = 1;
  private int h = 0;
  private int i = 0;
  private int j = 1;
  
  public Face2FaceFriendBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public Face2FaceFriendBubbleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, 0);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903308, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297633));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297636));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297640));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297635);
    this.c = ((ImageView)findViewById(2131297637));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131297638));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297641));
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("");
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(paramContext, 2130968626);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(paramContext, 2130968625);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener);
  }
  
  public int a()
  {
    return this.g;
  }
  
  public Face2FaceUserData a()
  {
    if (getTag() != null) {
      return (Face2FaceUserData)getTag();
    }
    return null;
  }
  
  public String a()
  {
    String str2 = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
    String str1 = str2;
    if (TextUtils.isEmpty(str2.trim())) {
      str1 = this.jdField_a_of_type_JavaLangString;
    }
    return str1;
  }
  
  public void a()
  {
    int m = jdField_a_of_type_ArrayOfInt.length;
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap(m);
    }
    for (;;)
    {
      int k = 0;
      while (k < m)
      {
        View localView = findViewById(jdField_a_of_type_ArrayOfInt[k]);
        int n = localView.getVisibility();
        this.jdField_a_of_type_JavaUtilHashMap.put(localView, Integer.valueOf(n));
        if (n == 0)
        {
          Animation localAnimation = AnimationUtils.loadAnimation(BaseApplicationImpl.getContext(), 2130968623);
          localAnimation.setAnimationListener(new ije(this, 1, localView));
          localView.startAnimation(localAnimation);
        }
        k += 1;
      }
      if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Face2FaceUserData paramFace2FaceUserData)
  {
    if (paramFace2FaceUserData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "bindFriendInfo Face2FaceUserData is Null~~~~~");
      }
      return;
    }
    setTag(paramFace2FaceUserData);
    this.jdField_a_of_type_JavaLangString = paramFace2FaceUserData.e;
    this.g = paramFace2FaceUserData.a;
    this.jdField_b_of_type_JavaLangString = paramFace2FaceUserData.e;
    if ((paramFace2FaceUserData instanceof Face2FaceGroupProfile)) {
      this.jdField_b_of_type_JavaLangString = (paramFace2FaceUserData.e + "_" + ((Face2FaceGroupProfile)paramFace2FaceUserData).jdField_b_of_type_JavaLangString);
    }
    String str = paramFace2FaceUserData.e;
    int m = this.g;
    Object localObject;
    int k;
    if (this.g == 1)
    {
      paramFace2FaceUserData = (NearbyUser)paramFace2FaceUserData;
      if (TextUtils.isEmpty(paramFace2FaceUserData.jdField_a_of_type_JavaLangString))
      {
        localObject = paramFace2FaceUserData.jdField_b_of_type_JavaLangString;
        this.jdField_a_of_type_AndroidWidgetTextView.setLines(1);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        k = m;
        label153:
        if (localObject != null) {
          break label423;
        }
        paramFace2FaceUserData = this.jdField_a_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramFace2FaceUserData);
      a(paramQQAppInterface, this.jdField_a_of_type_JavaLangString, k);
      return;
      localObject = paramFace2FaceUserData.jdField_a_of_type_JavaLangString;
      break;
      localObject = str;
      k = m;
      if (this.g != 2) {
        break label153;
      }
      if ((paramFace2FaceUserData instanceof Face2FaceUserProfile))
      {
        localObject = ((Face2FaceUserProfile)paramFace2FaceUserData).jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_AndroidWidgetTextView.setLines(1);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        k = 1;
        break label153;
      }
      localObject = str;
      k = m;
      if (!(paramFace2FaceUserData instanceof Face2FaceGroupProfile)) {
        break label153;
      }
      paramFace2FaceUserData = ((Face2FaceGroupProfile)paramFace2FaceUserData).jdField_a_of_type_JavaLangString;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.h < 1)
      {
        this.i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131493449);
        this.h = BaseApplicationImpl.getContext().getResources().getDrawable(2130838361).getIntrinsicWidth();
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setLines(2);
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.i - this.h);
      localObject = paramFace2FaceUserData;
      k = m;
      if (!QLog.isColorLevel()) {
        break label153;
      }
      QLog.e("zivonchen", 2, "nickMaxWidth = " + this.i + ", flagWidth = " + this.h + ", realWidth = " + (this.i - this.h));
      localObject = paramFace2FaceUserData;
      k = m;
      break label153;
      label423:
      paramFace2FaceUserData = (Face2FaceUserData)localObject;
      if (TextUtils.isEmpty(((String)localObject).trim())) {
        paramFace2FaceUserData = this.jdField_a_of_type_JavaLangString;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject = null;
    if (paramInt == 1)
    {
      paramQQAppInterface = paramQQAppInterface.a(paramString, (byte)3, true);
      localObject = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        localObject = ImageUtil.a();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      return;
      if (paramInt == 2)
      {
        paramQQAppInterface = paramQQAppInterface.a(paramString, (byte)3, false, false);
        localObject = paramQQAppInterface;
        if (paramQQAppInterface == null) {
          localObject = ImageUtil.d();
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public int b()
  {
    return this.j;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    int m = jdField_a_of_type_ArrayOfInt.length;
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() != m))
    {
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
      if (QLog.isColorLevel()) {
        QLog.e(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "restoreAndHideLables error: ids.size not equals cache.size~~~~~");
      }
      return;
    }
    int k = 0;
    while (k < m)
    {
      View localView = findViewById(jdField_a_of_type_ArrayOfInt[k]);
      if ((((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localView)).intValue() == 0) && (localView.getVisibility() == 4))
      {
        Animation localAnimation = AnimationUtils.loadAnimation(BaseApplicationImpl.getContext(), 2130968624);
        localAnimation.setAnimationListener(new ije(this, 0, localView));
        localView.startAnimation(localAnimation);
      }
      k += 1;
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public String c()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void setStatusWithAnimation(int paramInt)
  {
    String str2;
    String str1;
    switch (paramInt)
    {
    default: 
      str2 = a();
      if (paramInt == 2) {
        str1 = str2 + "好友";
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription(str1);
      return;
      this.j = paramInt;
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {
        break;
      }
      this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      break;
      this.j = paramInt;
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        break;
      }
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      }
      this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      break;
      if (paramInt == 3)
      {
        str1 = str2 + "请求加我为好友";
      }
      else
      {
        str1 = str2;
        if (paramInt == 4) {
          str1 = str2 + "等待对方验证";
        }
      }
    }
  }
  
  public void setStatusWithoutAnimation(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.j = paramInt;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 2: 
      this.j = paramInt;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.c.setImageResource(2130838342);
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    case 3: 
      this.j = paramInt;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.c.setImageResource(2130838343);
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.j = paramInt;
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.c.setImageResource(2130838344);
    this.c.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView
 * JD-Core Version:    0.7.0.1
 */