package com.tencent.mobileqq.bubble;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import hvo;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class BubbleInfo
{
  public static final int a = 65;
  private static final boolean a = true;
  public static final int b = 57;
  private static final String f;
  public static final int i = 0;
  public static final int j = 1;
  public static final int k = 2;
  public static final int l = 3;
  public static final int m = 4;
  public static final int n = 5;
  public static final int o = 6;
  public static final int p = 7;
  public static final int q = 0;
  public static final int r = 1;
  public static final int s = 2;
  public static final int t = 3;
  public static final int u = 4;
  public static final int v = 5;
  public BubbleInfo.CommonAttrs a;
  public String a;
  public HashMap a;
  public List a;
  public String[] a;
  public BubbleInfo.CommonAttrs b;
  public String b;
  List jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  public int c;
  public String c;
  List jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = false;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public int g;
  public int h;
  private int w;
  private int x;
  
  static
  {
    jdField_f_of_type_JavaLangString = BubbleInfo.class.getSimpleName();
  }
  
  public BubbleInfo(int paramInt)
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 2130841642;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public BubbleInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 2130841642;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = paramInt1;
    this.w = paramInt2;
    this.x = paramInt3;
  }
  
  public BubbleInfo(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, String[] paramArrayOfString, BubbleInfo.CommonAttrs paramCommonAttrs1, int paramInt4, int paramInt5, BubbleInfo.CommonAttrs paramCommonAttrs2, List paramList, HashMap paramHashMap)
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 2130841642;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_e_of_type_Int = paramInt2;
    this.jdField_f_of_type_Int = paramInt3;
    this.g = paramInt4;
    this.h = paramInt5;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    paramString1 = paramList;
    if (paramList == null) {
      paramString1 = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs = paramCommonAttrs1;
    this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs = paramCommonAttrs2;
    paramString1 = paramHashMap;
    if (paramHashMap == null) {
      paramString1 = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap = paramString1;
  }
  
  private Drawable a(Context paramContext, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("bubbleinfo_").append(paramInt1).append("_bg_").append(paramBoolean1).append("_").append(paramBoolean2);
    Object localObject = (Pair)BaseApplicationImpl.a.get(localStringBuffer.toString());
    if ((localObject != null) && (((Pair)localObject).first != null)) {
      paramContext = ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(paramContext.getResources());
    }
    do
    {
      return paramContext;
      Drawable localDrawable = paramContext.getResources().getDrawable(paramInt2);
      paramContext = paramContext.getResources().getDrawable(paramInt3);
      localObject = new StateListDrawable();
      if (localDrawable != null) {
        ((StateListDrawable)localObject).addState(new int[] { 16842919, 16842910 }, localDrawable);
      }
      if (paramContext != null)
      {
        ((StateListDrawable)localObject).addState(new int[] { 16842910 }, paramContext);
        ((StateListDrawable)localObject).addState(new int[] { -16842910 }, paramContext);
      }
      paramInt1 = SkinUtils.a(localDrawable) + SkinUtils.a(paramContext);
      paramContext = (Context)localObject;
    } while (paramInt1 <= 0);
    BaseApplicationImpl.a.put(localStringBuffer.toString(), new Pair(((StateListDrawable)localObject).getConstantState(), Integer.valueOf(paramInt1)));
    return localObject;
  }
  
  /* Error */
  public static Pair a(com.tencent.common.app.AppInterface paramAppInterface, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: iconst_0
    //   7: istore_3
    //   8: aload_1
    //   9: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +363 -> 375
    //   15: aload_1
    //   16: ldc 216
    //   18: invokevirtual 222	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   21: ifeq +198 -> 219
    //   24: iconst_1
    //   25: istore_2
    //   26: aconst_null
    //   27: astore 6
    //   29: aload 6
    //   31: ifnull +11 -> 42
    //   34: aload 6
    //   36: invokevirtual 228	java/io/File:exists	()Z
    //   39: ifne +7 -> 46
    //   42: iload_2
    //   43: ifeq +174 -> 217
    //   46: new 230	android/graphics/Rect
    //   49: dup
    //   50: invokespecial 231	android/graphics/Rect:<init>	()V
    //   53: astore 9
    //   55: new 233	android/graphics/BitmapFactory$Options
    //   58: dup
    //   59: invokespecial 234	android/graphics/BitmapFactory$Options:<init>	()V
    //   62: astore 10
    //   64: aload 10
    //   66: sipush 320
    //   69: putfield 237	android/graphics/BitmapFactory$Options:inDensity	I
    //   72: aload 10
    //   74: aload_0
    //   75: invokevirtual 242	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   78: invokevirtual 245	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   81: invokevirtual 249	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   84: getfield 254	android/util/DisplayMetrics:densityDpi	I
    //   87: putfield 257	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   90: iload_2
    //   91: ifeq +143 -> 234
    //   94: aload_1
    //   95: astore 6
    //   97: aload_1
    //   98: astore 7
    //   100: aload_1
    //   101: ldc_w 259
    //   104: invokevirtual 263	java/lang/String:length	()I
    //   107: invokevirtual 267	java/lang/String:substring	(I)Ljava/lang/String;
    //   110: astore_1
    //   111: aload_1
    //   112: astore 6
    //   114: aload_1
    //   115: astore 7
    //   117: aload_0
    //   118: invokevirtual 242	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   121: invokevirtual 271	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   124: invokevirtual 275	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   127: aload_1
    //   128: invokevirtual 281	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   131: astore 8
    //   133: aload_1
    //   134: astore 6
    //   136: aload_1
    //   137: astore 7
    //   139: aload 8
    //   141: aload 9
    //   143: aload 10
    //   145: invokestatic 287	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   148: astore 9
    //   150: aload 9
    //   152: astore 6
    //   154: iload 5
    //   156: istore_2
    //   157: aload 6
    //   159: invokestatic 293	com/tencent/image/Utils:getBitmapSize	(Landroid/graphics/Bitmap;)I
    //   162: istore_3
    //   163: iload_3
    //   164: istore_2
    //   165: iload_3
    //   166: istore 4
    //   168: aload 8
    //   170: invokevirtual 298	java/io/InputStream:close	()V
    //   173: iload_3
    //   174: istore_2
    //   175: aload 6
    //   177: astore 8
    //   179: aload 8
    //   181: ifnonnull +72 -> 253
    //   184: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq +30 -> 217
    //   190: getstatic 55	com/tencent/mobileqq/bubble/BubbleInfo:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   193: iconst_2
    //   194: new 305	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 306	java/lang/StringBuilder:<init>	()V
    //   201: ldc_w 308
    //   204: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_1
    //   208: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 315	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: aconst_null
    //   218: areturn
    //   219: new 224	java/io/File
    //   222: dup
    //   223: aload_1
    //   224: invokespecial 318	java/io/File:<init>	(Ljava/lang/String;)V
    //   227: astore 6
    //   229: iconst_0
    //   230: istore_2
    //   231: goto -202 -> 29
    //   234: aload_1
    //   235: astore 6
    //   237: aload_1
    //   238: astore 7
    //   240: new 320	java/io/FileInputStream
    //   243: dup
    //   244: aload_1
    //   245: invokespecial 321	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   248: astore 8
    //   250: goto -117 -> 133
    //   253: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq +30 -> 286
    //   259: getstatic 55	com/tencent/mobileqq/bubble/BubbleInfo:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   262: iconst_2
    //   263: new 305	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 306	java/lang/StringBuilder:<init>	()V
    //   270: ldc_w 323
    //   273: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_1
    //   277: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 315	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: new 325	android/graphics/drawable/BitmapDrawable
    //   289: dup
    //   290: aload_0
    //   291: invokevirtual 242	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   294: invokevirtual 245	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   297: aload 8
    //   299: invokespecial 328	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   302: astore_1
    //   303: aload_1
    //   304: aload_0
    //   305: invokevirtual 242	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   308: invokevirtual 245	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   311: invokevirtual 249	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   314: invokevirtual 332	android/graphics/drawable/BitmapDrawable:setTargetDensity	(Landroid/util/DisplayMetrics;)V
    //   317: new 149	com/tencent/util/Pair
    //   320: dup
    //   321: aload_1
    //   322: iload_2
    //   323: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   326: invokespecial 199	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   329: areturn
    //   330: astore_1
    //   331: aconst_null
    //   332: astore 8
    //   334: iload_3
    //   335: istore_2
    //   336: aload 6
    //   338: astore_1
    //   339: goto -160 -> 179
    //   342: astore 7
    //   344: aload 6
    //   346: astore 8
    //   348: goto -169 -> 179
    //   351: astore_1
    //   352: aconst_null
    //   353: astore 8
    //   355: iload_3
    //   356: istore_2
    //   357: aload 7
    //   359: astore_1
    //   360: goto -181 -> 179
    //   363: astore 7
    //   365: aload 6
    //   367: astore 8
    //   369: iload 4
    //   371: istore_2
    //   372: goto -193 -> 179
    //   375: iconst_0
    //   376: istore_2
    //   377: aconst_null
    //   378: astore 6
    //   380: goto -351 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	paramAppInterface	com.tencent.common.app.AppInterface
    //   0	383	1	paramString	String
    //   25	352	2	i1	int
    //   7	349	3	i2	int
    //   4	366	4	i3	int
    //   1	154	5	i4	int
    //   27	352	6	localObject1	Object
    //   98	141	7	str	String
    //   342	16	7	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   363	1	7	localException	java.lang.Exception
    //   131	237	8	localObject2	Object
    //   53	98	9	localObject3	Object
    //   62	82	10	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   100	111	330	java/lang/OutOfMemoryError
    //   117	133	330	java/lang/OutOfMemoryError
    //   139	150	330	java/lang/OutOfMemoryError
    //   240	250	330	java/lang/OutOfMemoryError
    //   157	163	342	java/lang/OutOfMemoryError
    //   168	173	342	java/lang/OutOfMemoryError
    //   100	111	351	java/lang/Exception
    //   117	133	351	java/lang/Exception
    //   139	150	351	java/lang/Exception
    //   240	250	351	java/lang/Exception
    //   157	163	363	java/lang/Exception
    //   168	173	363	java/lang/Exception
  }
  
  private Pair a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (((BubbleInfo.CommonAttrs)localPair.first).jdField_b_of_type_JavaLangString == paramString) {
          return localPair;
        }
      }
    }
    return null;
  }
  
  private void a(QQAppInterface paramQQAppInterface, View paramView, Drawable paramDrawable)
  {
    if ((paramDrawable == null) || (paramView == null)) {
      return;
    }
    paramQQAppInterface = new Rect();
    paramDrawable.getPadding(paramQQAppInterface);
    int i1 = paramView.getPaddingTop();
    int i2 = paramQQAppInterface.top;
    int i3 = paramView.getPaddingLeft();
    int i4 = paramQQAppInterface.left;
    int i5 = paramView.getPaddingRight();
    int i6 = paramQQAppInterface.right;
    int i7 = paramView.getPaddingBottom();
    int i8 = paramQQAppInterface.bottom;
    paramView.setBackgroundDrawable(paramDrawable);
    paramView.setPadding(i3 + i4, i1 + i2, i5 + i6, i8 + i7);
  }
  
  public Drawable a(QQAppInterface paramQQAppInterface, boolean paramBoolean, View paramView)
  {
    Object localObject = null;
    if (0 == 0)
    {
      localObject = paramQQAppInterface.a().getResources();
      if (!paramBoolean) {
        break label45;
      }
    }
    label45:
    for (int i1 = 2130838366;; i1 = 2130838363)
    {
      localObject = ((Resources)localObject).getDrawable(i1);
      a(paramQQAppInterface, paramView, (Drawable)localObject);
      return localObject;
    }
  }
  
  public Drawable a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, View paramView)
  {
    Object localObject3;
    Object localObject1;
    Object localObject2;
    if (paramBoolean2) {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
      {
        localObject3 = "bubblebg://" + this.jdField_c_of_type_Int + "_" + "local";
        if (BaseApplicationImpl.a == null) {
          break label699;
        }
        localObject1 = (hvo)BaseApplicationImpl.a.get(localObject3);
        if (localObject1 == null) {
          break label699;
        }
        localObject1 = ((hvo)localObject1).newDrawable(paramQQAppInterface.a().getResources());
        localObject2 = (VipBubbleDrawable)localObject1;
        if (!paramBoolean1)
        {
          paramBoolean2 = true;
          ((VipBubbleDrawable)localObject2).a(paramBoolean2, paramBoolean3);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_f_of_type_JavaLangString, 2, "getBubbleDrawable from imageCache, key=" + (String)localObject3);
          }
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (new File(this.jdField_a_of_type_JavaLangString).exists())
        {
          localObject2 = localObject1;
          if (new File(this.jdField_b_of_type_JavaLangString).exists())
          {
            localObject2 = new VipBubbleDrawable(paramQQAppInterface.a().getResources(), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
            if (paramBoolean1) {
              break label595;
            }
            paramBoolean2 = true;
            label234:
            ((VipBubbleDrawable)localObject2).a(paramBoolean2, paramBoolean3);
            if (BaseApplicationImpl.a != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d(jdField_f_of_type_JavaLangString, 2, "getBubbleDrawable put into imageCache, key=" + (String)localObject3);
              }
              BaseApplicationImpl.a.put(localObject3, ((VipBubbleDrawable)localObject2).getConstantState());
            }
          }
        }
      }
      if ((!BubbleManager.a) && (this.jdField_c_of_type_Int != 0)) {
        BubbleManager.a = true;
      }
      localObject1 = localObject2;
      for (;;)
      {
        if (localObject1 == null) {
          if (paramBoolean1)
          {
            localObject2 = "bubblebg://default_mine";
            label331:
            if (BaseApplicationImpl.a == null) {
              break label690;
            }
            localObject3 = (Drawable.ConstantState)BaseApplicationImpl.a.get(localObject2);
            if (localObject3 == null) {
              break label690;
            }
            if (QLog.isColorLevel()) {
              QLog.d(jdField_f_of_type_JavaLangString, 2, "getBubbleDrawable, get Default from imageCache, key=" + (String)localObject2 + ", bubbleId=" + this.jdField_c_of_type_Int);
            }
            localObject1 = ((Drawable.ConstantState)localObject3).newDrawable();
          }
        }
        label666:
        label674:
        label682:
        label690:
        for (;;)
        {
          localObject2 = localObject1;
          int i1;
          if (localObject1 == null)
          {
            localObject2 = paramQQAppInterface.a().getResources();
            if (!paramBoolean1) {
              break label666;
            }
            i1 = 2130841749;
            label436:
            localObject1 = ((Resources)localObject2).getDrawable(i1);
            if (!paramBoolean1) {
              break label674;
            }
            i1 = 2130841748;
            label454:
            localObject3 = ((Resources)localObject2).getDrawable(i1);
            localObject2 = new StateListDrawable();
            ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject1);
            ((StateListDrawable)localObject2).addState(new int[] { 16842910 }, (Drawable)localObject3);
            if (BaseApplicationImpl.a != null) {
              if (!paramBoolean1) {
                break label682;
              }
            }
          }
          for (localObject1 = "bubblebg://default_mine";; localObject1 = "bubblebg://default_friend")
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_f_of_type_JavaLangString, 2, "getBubbleDrawable, put default bubble to imageCache, key=" + (String)localObject1 + ", bubbleId=" + this.jdField_c_of_type_Int);
            }
            BaseApplicationImpl.a.put(localObject1, ((StateListDrawable)localObject2).getConstantState());
            a(paramQQAppInterface, paramView, (Drawable)localObject2);
            return localObject2;
            paramBoolean2 = false;
            break;
            label595:
            paramBoolean2 = false;
            break label234;
            if ((this.jdField_c_of_type_Int != 100000) && (this.jdField_c_of_type_Int != 100001)) {
              break label693;
            }
            if (paramBoolean1) {}
            for (localObject1 = null;; localObject1 = a(paramQQAppInterface.a(), this.jdField_c_of_type_Int, paramBoolean1, paramBoolean3, this.w, this.x)) {
              break;
            }
            localObject2 = "bubblebg://default_friend";
            break label331;
            i1 = 2130841711;
            break label436;
            i1 = 2130841710;
            break label454;
          }
        }
        label693:
        localObject1 = null;
      }
      label699:
      localObject1 = null;
    }
  }
  
  public Pair a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    StringBuilder localStringBuilder = null;
    Object localObject1;
    if (paramQQAppInterface != null)
    {
      localObject1 = (BubbleManager)paramQQAppInterface.getManager(43);
      localObject2 = localStringBuilder;
      if (localObject1 != null)
      {
        localObject2 = ((BubbleManager)localObject1).a(this.jdField_c_of_type_Int, true);
        if (localObject2 != null) {
          break label53;
        }
        localObject2 = localStringBuilder;
      }
    }
    label53:
    label86:
    do
    {
      do
      {
        return localObject2;
        localObject1 = null;
        break;
        switch (paramInt)
        {
        default: 
          paramQQAppInterface = null;
          localObject2 = localStringBuilder;
        }
      } while (TextUtils.isEmpty(paramQQAppInterface));
      localObject2 = a(paramQQAppInterface);
      localObject1 = ((BubbleManager)localObject1).a(this.jdField_c_of_type_Int, paramQQAppInterface, (Pair)localObject2);
      localObject2 = localObject1;
    } while (!QLog.isDevelopLevel());
    Object localObject2 = jdField_f_of_type_JavaLangString;
    localStringBuilder = new StringBuilder().append("getAttrs|key=").append(paramQQAppInterface).append(", animAttrs=");
    if (localObject1 == null) {}
    for (paramQQAppInterface = "null";; paramQQAppInterface = "first:" + ((Pair)localObject1).first + ",second:" + ((Pair)localObject1).second)
    {
      QLog.w((String)localObject2, 4, paramQQAppInterface);
      return localObject1;
      if (((BubbleConfig)localObject2).a == null) {
        break;
      }
      paramQQAppInterface = ((BubbleConfig)localObject2).a.jdField_b_of_type_JavaLangString;
      break label86;
      if (((BubbleConfig)localObject2).b == null) {
        break;
      }
      paramQQAppInterface = ((BubbleConfig)localObject2).b.jdField_b_of_type_JavaLangString;
      break label86;
      paramQQAppInterface = "width";
      if (((BubbleConfig)localObject2).c == null) {
        break label86;
      }
      paramQQAppInterface = ((BubbleConfig)localObject2).c.jdField_b_of_type_JavaLangString;
      break label86;
      if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() <= 0) || (this.jdField_e_of_type_JavaLangString == null)) {
        break;
      }
      paramQQAppInterface = (String)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_e_of_type_JavaLangString);
      break label86;
    }
  }
  
  public String a(String paramString)
  {
    if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (!TextUtils.isEmpty(paramString)))
    {
      String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = arrayOfString[i1];
        if (paramString.indexOf(str.toLowerCase()) != -1)
        {
          this.jdField_e_of_type_JavaLangString = str;
          return str;
        }
        i1 += 1;
      }
    }
    return null;
  }
  
  public void a()
  {
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    synchronized (this.jdField_c_of_type_JavaUtilList)
    {
      this.jdField_c_of_type_JavaUtilList.clear();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public void a(View arg1, View paramView2)
  {
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      this.jdField_b_of_type_JavaUtilList.remove(???);
    }
    synchronized (this.jdField_c_of_type_JavaUtilList)
    {
      this.jdField_c_of_type_JavaUtilList.remove(paramView2);
      return;
      ??? = finally;
      throw ???;
    }
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
  }
  
  public boolean a(int paramInt)
  {
    return (this.g > 0) && (this.h > this.g) && (paramInt >= this.g) && (paramInt <= this.h);
  }
  
  public String toString()
  {
    return "BubbleInfo [bubbleId=" + this.jdField_c_of_type_Int + ",aioUserBgNorResPath=" + this.jdField_a_of_type_JavaLangString + ",aioUserPicNorResPath=" + this.jdField_b_of_type_JavaLangString + ",bubbleThumbnailResPath=" + this.jdField_d_of_type_JavaLangString + ", mTextColor=" + this.jdField_e_of_type_Int + ", mKeyWords=" + Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString) + ", currKeyWord=" + this.jdField_e_of_type_JavaLangString + ", mBubbleHeightBegin=" + this.g + ", mBubbleHeightEnd=" + this.h + ", pttAttrs=" + this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs + ", heightAttrs=" + this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs + ", keywordAttrs=" + this.jdField_a_of_type_JavaUtilList + ", keyWorsAnimMap=" + this.jdField_a_of_type_JavaUtilHashMap + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInfo
 * JD-Core Version:    0.7.0.1
 */