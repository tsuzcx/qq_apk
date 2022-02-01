package com.tencent.mobileqq.transfile;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.PicBaseInfo;
import com.tencent.mobileqq.pic.PicContants;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class URLDrawableHelper
{
  public static final float a = 12.0F;
  public static int a = 0;
  public static Bitmap.Config a;
  public static Drawable a;
  public static File a;
  public static final String a = "URLDrawableHelper";
  static List a;
  public static final float b = 28.0F;
  public static int b = 0;
  public static Bitmap.Config b;
  public static Drawable b;
  public static final float c;
  public static final int c = 99;
  public static Drawable c;
  public static final int d = 99;
  public static final Drawable d;
  public static int e = 0;
  public static final Drawable e;
  public static int f = 0;
  public static int g = 0;
  public static int h = 0;
  public static int i = 0;
  public static int j = 0;
  public static final int k = -921103;
  private static int l;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
    jdField_b_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.RGB_565;
    jdField_b_of_type_Int = 921600;
    jdField_e_of_type_Int = 45;
    f = 198;
    g = f;
    h = 160;
    c = 198.0F / f;
    i = jdField_e_of_type_Int;
    j = f;
    d = new ColorDrawable(0);
    jdField_e_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(1073741824);
    Context localContext = BaseApplicationImpl.getContext();
    int m = localContext.getResources().getDimensionPixelSize(2131492911);
    int n = SizeMeasure.d(localContext);
    int i1 = AIOUtils.a(h, localContext.getResources());
    m = (Math.min(SizeMeasure.h(localContext), SizeMeasure.i(localContext)) - m * 32 - (n - m * 32 - i1 * 2)) / 2;
    float f1 = localContext.getResources().getDisplayMetrics().density;
    g = (int)(m / f1);
    if (BaseBubbleBuilder.a) {
      m = Math.min(f, g);
    }
    for (;;)
    {
      f = m;
      try
      {
        jdField_a_of_type_AndroidGraphicsDrawableDrawable = localContext.getResources().getDrawable(2130837580);
        jdField_b_of_type_AndroidGraphicsDrawableDrawable = localContext.getResources().getDrawable(2130837582);
        a();
        l = localContext.getResources().getDisplayMetrics().densityDpi;
        jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
        return;
        m = Math.max(f, g);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("URLDrawableHelper", 2, "", localThrowable);
          }
          if (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
            jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable();
          }
          if (jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
            jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable();
          }
        }
      }
    }
  }
  
  public static int a()
  {
    Context localContext = BaseApplication.getContext();
    if (localContext.getResources().getConfiguration().orientation == 1) {}
    for (float f1 = g;; f1 = h) {
      return AIOUtils.a(f1, localContext.getResources());
    }
  }
  
  public static int a(String paramString)
  {
    try
    {
      paramString = new ExifInterface(paramString);
      if (paramString == null) {
        return 0;
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("URLDrawableHelper", 2, "new ExifInterface", paramString);
        }
        paramString = null;
      }
      switch (paramString.getAttributeInt("Orientation", 0))
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      }
    }
    return 180;
    return 90;
    return 270;
  }
  
  public static int a(String paramString, boolean paramBoolean)
  {
    int m = 65537;
    if ("chatthumb".equals(paramString)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatImageDownloader", 2, "getFileSizeType protocol:" + paramString + ",output_type:" + m);
      }
      return m;
      if ("chatimg".equals(paramString))
      {
        if (paramBoolean) {
          m = 1;
        } else {
          m = 131075;
        }
      }
      else if ("chatraw".equals(paramString)) {
        m = 131075;
      }
    }
  }
  
  public static Bitmap a()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.a != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.a.get("static://CommonProgress");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.a(BaseApplicationImpl.getContext().getResources(), 2130838129);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.a != null)
        {
          BaseApplicationImpl.a.put("static://CommonProgress", localBitmap1, (byte)0);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  public static URLDrawable a(PicUiInterface paramPicUiInterface, int paramInt)
  {
    return a(paramPicUiInterface, paramInt, null);
  }
  
  public static URLDrawable a(PicUiInterface paramPicUiInterface, int paramInt, String paramString)
  {
    boolean bool2 = true;
    if (paramPicUiInterface == null) {
      return null;
    }
    paramString = URLDrawable.getDrawable(a(paramPicUiInterface, paramInt, paramString));
    paramString.setTag(paramPicUiInterface);
    if (paramPicUiInterface.isSendFromLocal()) {}
    for (;;)
    {
      return paramString;
      if (!PicContants.jdField_b_of_type_Boolean) {
        break;
      }
      paramString.setAutoDownload(true);
    }
    boolean bool3 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131366260), "qqsetting_auto_receive_pic_key", true);
    boolean bool1 = bool2;
    if (NetworkUtil.b(BaseApplication.getContext()) != 1) {
      if (!bool3) {
        break label100;
      }
    }
    label100:
    for (bool1 = bool2;; bool1 = false)
    {
      paramString.setAutoDownload(bool1);
      break;
    }
  }
  
  private static String a(PicBaseInfo paramPicBaseInfo)
  {
    if (paramPicBaseInfo == null) {
      return null;
    }
    switch (paramPicBaseInfo.jdField_b_of_type_Int)
    {
    default: 
      return null;
    case 0: 
    case 1000: 
    case 1001: 
    case 1004: 
    case 1005: 
    case 1006: 
    case 1008: 
    case 1009: 
    case 1020: 
    case 1023: 
    case 1024: 
    case 7100: 
      return "C2C";
    case 1: 
      return "Troup";
    }
    return "Disscussion";
  }
  
  private static String a(PicBaseInfo paramPicBaseInfo, int paramInt)
  {
    int m;
    String str;
    if (paramInt == 65537)
    {
      m = 1;
      str = null;
      if (paramInt != 65537) {
        break label55;
      }
      str = "chatthumb";
      label19:
      switch (paramPicBaseInfo.jdField_b_of_type_Int)
      {
      }
    }
    label55:
    do
    {
      return str;
      m = 0;
      break;
      if (paramInt == 1)
      {
        str = "chatimg";
        break label19;
      }
      if (paramInt != 131075) {
        break label19;
      }
      str = "chatraw";
      break label19;
      return "favimage";
    } while (paramPicBaseInfo.jdField_e_of_type_Int >= 3);
    if (m != 0) {
      return "lbsthumb";
    }
    return "lbsimg";
  }
  
  public static URL a(PicDownloadInfo paramPicDownloadInfo, int paramInt, String paramString)
  {
    if (paramPicDownloadInfo == null) {
      return null;
    }
    String str1 = paramPicDownloadInfo.f;
    if ((str1 != null) && (!"null".equals(str1)) && (!"".equals(str1)))
    {
      if (paramPicDownloadInfo.jdField_b_of_type_Boolean) {
        paramInt = 1;
      }
      if (paramString == null) {
        break label164;
      }
    }
    for (;;)
    {
      String str2 = str1;
      if (str1 == null) {}
      try
      {
        str1 = "holyshit_" + System.currentTimeMillis();
        str2 = str1;
        if (QLog.isColorLevel())
        {
          QLog.e("URLDrawableHelper", 2, "getURL file == null" + paramPicDownloadInfo.toString());
          str2 = str1;
        }
        paramPicDownloadInfo = new URL(paramString, null, str2);
      }
      catch (MalformedURLException paramPicDownloadInfo)
      {
        for (;;)
        {
          paramPicDownloadInfo.printStackTrace();
          paramPicDownloadInfo = null;
        }
      }
      return paramPicDownloadInfo;
      if ((paramPicDownloadInfo.jdField_b_of_type_Int == 8000) && (paramInt == 65537))
      {
        str1 = paramPicDownloadInfo.h;
        break;
      }
      str1 = paramPicDownloadInfo.g;
      break;
      label164:
      paramString = a(paramPicDownloadInfo, paramInt);
    }
  }
  
  public static URL a(PicUiInterface paramPicUiInterface, int paramInt)
  {
    return a(paramPicUiInterface, paramInt, null);
  }
  
  public static URL a(PicUiInterface paramPicUiInterface, int paramInt, String paramString)
  {
    if (paramPicUiInterface == null) {
      return null;
    }
    if (paramPicUiInterface.isSendFromLocal()) {
      return a(paramPicUiInterface.getPicUploadInfo(), paramInt, paramString);
    }
    return a(paramPicUiInterface.getPicDownloadInfo(), paramInt, paramString);
  }
  
  public static URL a(PicUploadInfo paramPicUploadInfo, int paramInt, String paramString)
  {
    if (paramPicUploadInfo == null) {
      return null;
    }
    if (paramPicUploadInfo.jdField_e_of_type_Int < 4) {}
    for (String str2 = a(paramPicUploadInfo);; str2 = null)
    {
      String str3 = a(paramPicUploadInfo, paramInt);
      if ((paramPicUploadInfo.jdField_b_of_type_Int == 8000) && (paramInt == 65537)) {}
      for (String str1 = paramPicUploadInfo.h;; str1 = "") {
        for (;;)
        {
          if (str1 != null) {}
          try
          {
            if (("".equals(str1)) && (QLog.isColorLevel())) {
              QLog.e("URLDrawableHelper", 2, "getURL file == null" + paramPicUploadInfo.toString());
            }
            if (paramString != null)
            {
              paramPicUploadInfo = new URL(paramString, str2, str1);
              return paramPicUploadInfo;
              if ((paramPicUploadInfo.f != null) && (!"".equals(paramPicUploadInfo.f)))
              {
                str1 = paramPicUploadInfo.f;
                continue;
              }
              if ((paramPicUploadInfo.a != null) && (!"".equals(paramPicUploadInfo.a)))
              {
                str1 = paramPicUploadInfo.a;
                continue;
              }
              if ((paramPicUploadInfo.g != null) && (!"".equals(paramPicUploadInfo.g))) {
                str1 = paramPicUploadInfo.g;
              }
            }
            else
            {
              paramPicUploadInfo = new URL(str3, str2, str1);
              return paramPicUploadInfo;
            }
          }
          catch (MalformedURLException paramPicUploadInfo)
          {
            paramPicUploadInfo.printStackTrace();
            return null;
          }
        }
      }
    }
  }
  
  public static URL a(String paramString, int paramInt)
  {
    String str = "chatimg";
    if (paramInt == 65537) {
      str = "chatthumb";
    }
    for (;;)
    {
      try
      {
        paramString = new URL(str, null, paramString);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        paramString.printStackTrace();
      }
      if (paramInt == 1) {
        str = "chatimg";
      } else if (paramInt == 131075) {
        str = "chatraw";
      }
    }
    return null;
  }
  
  public static void a(URLDrawable paramURLDrawable, String paramString, boolean paramBoolean)
  {
    String str = paramURLDrawable.getURL().toString();
    if ((paramURLDrawable.getStatus() != 1) && (AbsDownloader.a(str))) {}
    try
    {
      paramURLDrawable.downloadImediatly();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("URLDrawableHelper", 2, "downloadImediatly decode OOM,currentAccountUin=" + paramString + ",d.getURL=" + paramURLDrawable.getURL());
    }
  }
  
  /* Error */
  public static void a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc_w 431
    //   5: ldc_w 433
    //   8: new 218	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 435
    //   18: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: getstatic 158	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   24: invokeinterface 440 1 0
    //   29: invokevirtual 230	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 445	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   38: invokestatic 179	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   41: invokestatic 311	com/tencent/mobileqq/utils/NetworkUtil:b	(Landroid/content/Context;)I
    //   44: iconst_1
    //   45: if_icmpne +123 -> 168
    //   48: invokestatic 179	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   51: invokestatic 448	com/tencent/mobileqq/utils/NetworkUtil:d	(Landroid/content/Context;)Z
    //   54: istore_2
    //   55: iload_1
    //   56: ifne +7 -> 63
    //   59: iload_2
    //   60: ifeq +122 -> 182
    //   63: invokestatic 453	android/os/Looper:prepare	()V
    //   66: new 148	java/util/ArrayList
    //   69: dup
    //   70: getstatic 158	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   73: invokeinterface 440 1 0
    //   78: anewarray 455	com/tencent/mobileqq/data/MessageForPic
    //   81: invokestatic 461	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   84: invokespecial 464	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   87: astore_0
    //   88: aload_0
    //   89: getstatic 158	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   92: invokestatic 468	java/util/Collections:copy	(Ljava/util/List;Ljava/util/List;)V
    //   95: aload_0
    //   96: invokeinterface 472 1 0
    //   101: astore_0
    //   102: aload_0
    //   103: invokeinterface 477 1 0
    //   108: ifeq +65 -> 173
    //   111: aload_0
    //   112: invokeinterface 481 1 0
    //   117: checkcast 455	com/tencent/mobileqq/data/MessageForPic
    //   120: astore_3
    //   121: ldc_w 431
    //   124: ldc_w 483
    //   127: new 218	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 485
    //   137: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_3
    //   141: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 445	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload_3
    //   151: iconst_1
    //   152: invokestatic 487	com/tencent/mobileqq/transfile/URLDrawableHelper:a	(Lcom/tencent/mobileqq/pic/PicUiInterface;I)Lcom/tencent/image/URLDrawable;
    //   155: iconst_0
    //   156: invokevirtual 490	com/tencent/image/URLDrawable:startDownload	(Z)V
    //   159: goto -57 -> 102
    //   162: astore_0
    //   163: aload_0
    //   164: invokevirtual 491	java/lang/Exception:printStackTrace	()V
    //   167: return
    //   168: iconst_0
    //   169: istore_1
    //   170: goto -122 -> 48
    //   173: getstatic 158	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   176: invokeinterface 494 1 0
    //   181: return
    //   182: ldc_w 431
    //   185: ldc_w 433
    //   188: ldc_w 496
    //   191: invokestatic 445	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   194: return
    //   195: astore_0
    //   196: goto -130 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   1	169	1	m	int
    //   54	6	2	bool	boolean
    //   120	31	3	localMessageForPic	com.tencent.mobileqq.data.MessageForPic
    // Exception table:
    //   from	to	target	type
    //   2	48	162	java/lang/Exception
    //   48	55	162	java/lang/Exception
    //   66	102	162	java/lang/Exception
    //   102	159	162	java/lang/Exception
    //   173	181	162	java/lang/Exception
    //   182	194	162	java/lang/Exception
    //   63	66	195	java/lang/Exception
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool1 = NetworkUtil.c(BaseApplication.getContext());
    boolean bool2 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131366260), "qqsetting_auto_receive_pic_key", true);
    return (bool1) && (!bool2);
  }
  
  public static boolean a(Context paramContext, PicUiInterface paramPicUiInterface, int paramInt)
  {
    return AbsDownloader.a(a(paramPicUiInterface, paramInt).toString()) != null;
  }
  
  public static URLDrawable b(PicUiInterface paramPicUiInterface, int paramInt)
  {
    URLDrawable localURLDrawable = URLDrawable.getDrawable(a(paramPicUiInterface, 65537));
    localURLDrawable.setTargetDensity(l);
    int m;
    URL localURL;
    if (localURLDrawable.getStatus() == 1)
    {
      m = 1;
      localURL = a(paramPicUiInterface, paramInt);
      if (m == 0) {
        break label68;
      }
    }
    label68:
    for (localURLDrawable = URLDrawable.getDrawable(localURL, -1, -1, localURLDrawable, null, true);; localURLDrawable = URLDrawable.getDrawable(localURL, -1, -1, true))
    {
      localURLDrawable.setTargetDensity(l);
      localURLDrawable.setTag(paramPicUiInterface);
      return localURLDrawable;
      m = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.URLDrawableHelper
 * JD-Core Version:    0.7.0.1
 */