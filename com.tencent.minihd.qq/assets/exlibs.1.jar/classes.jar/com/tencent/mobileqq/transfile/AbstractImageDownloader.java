package com.tencent.mobileqq.transfile;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.BaseStrategy;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import mqq.app.AccountNotMatchException;

public abstract class AbstractImageDownloader
  extends AbsDownloader
{
  private static final String N = "big_img_decode_slice";
  public static int a = 0;
  public static final String a = "c2c_file";
  public static int b = 0;
  public static final String b = "group_file";
  public static final String c = "discuss_file";
  private static final String e = "big_img_decode";
  private static int f = 1048576;
  private static int g = f * 2;
  private static final int jdField_h_of_type_Int = 88000;
  private static final String jdField_h_of_type_JavaLangString = "big_img_decode_long";
  private static final int i = 0;
  private static final int j = -1;
  private static final int k = 1;
  private static final int l = 2;
  private static final int m = 3;
  private static final int n = 4;
  private static final int o = 5;
  private static final int p = 6;
  protected BaseApplicationImpl a;
  protected String d;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 0;
  }
  
  public AbstractImageDownloader(String paramString, BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.d = paramString;
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
  }
  
  public static int a(Application paramApplication, int paramInt)
  {
    float f1 = 1.0F;
    if (paramInt > 150) {
      f1 = paramInt / 100;
    }
    float f2 = paramApplication.getResources().getDisplayMetrics().density;
    if (f2 <= 1.5D) {
      return (int)(f1 * 9.0F);
    }
    if (f2 <= 2.0D) {
      return (int)(f1 * 9.0F);
    }
    return (int)(f1 * 4.0F);
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    return Utils.calculateInSampleSize(paramOptions, paramInt1, paramInt2);
  }
  
  private RoundRectBitmap a(Bitmap paramBitmap)
  {
    int i2;
    int i1;
    int i3;
    for (;;)
    {
      try
      {
        float f3 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().density;
        int i4 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().densityDpi;
        i2 = (int)(URLDrawableHelper.e * f3 + 0.5F);
        i1 = (int)(URLDrawableHelper.f * f3 + 0.5F);
        int i5 = paramBitmap.getWidth();
        i3 = paramBitmap.getHeight();
        Paint localPaint = new Paint(1);
        localPaint.setColor(-16777216);
        if ((i5 < URLDrawableHelper.e) || (i3 < URLDrawableHelper.e))
        {
          if (i5 < i3)
          {
            i3 = (int)(i2 / i5 * i3 + 0.5F);
            if (i3 > i1)
            {
              Bitmap localBitmap = Bitmap.createBitmap(i2, i1, URLDrawableHelper.jdField_b_of_type_AndroidGraphicsBitmap$Config);
              localBitmap.setDensity(i4);
              new Canvas(localBitmap).drawBitmap(paramBitmap, null, new Rect(0, 0, i2, i1), localPaint);
              return new RoundRectBitmap(localBitmap, 12.0F * f3);
            }
          }
          else
          {
            i3 = (int)(i2 / i3 * i5 + 0.5F);
            if (i3 <= i1) {
              break label383;
            }
            break;
          }
        }
        else
        {
          if ((i5 < URLDrawableHelper.f) && (i3 < URLDrawableHelper.f))
          {
            i2 = (int)(i5 * f3 + 0.5F);
            i1 = (int)(i3 * f3 + 0.5F);
            continue;
          }
          float f1;
          if (i5 > i3)
          {
            f1 = i1 / i5;
            if (i5 > i3)
            {
              f2 = i2 / i3;
              f1 = Math.max(f1, f2);
              i2 = (int)(i5 * f1 + 0.5F);
              i1 = (int)(f1 * i3 + 0.5F);
            }
          }
          else
          {
            f1 = i1 / i3;
            continue;
          }
          float f2 = i2 / i5;
          continue;
        }
        i1 = i3;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        return new RoundRectBitmap(paramBitmap, 12.0F);
      }
    }
    for (;;)
    {
      i3 = i1;
      i1 = i2;
      i2 = i3;
      break;
      label383:
      i1 = i3;
    }
  }
  
  public static String a(Exception paramException)
  {
    int i1 = 8;
    if (paramException == null) {
      return "Exception e is null,holy shit";
    }
    Object localObject = paramException.getMessage();
    StackTraceElement[] arrayOfStackTraceElement = paramException.getStackTrace();
    if (arrayOfStackTraceElement != null)
    {
      localObject = new StringBuilder(":");
      int i2 = arrayOfStackTraceElement.length;
      if (i2 > 8) {}
      for (;;)
      {
        ((StringBuilder)localObject).append("\n");
        i2 = 0;
        while (i2 < i1)
        {
          ((StringBuilder)localObject).append(arrayOfStackTraceElement[i2].toString()).append("\n");
          i2 += 1;
        }
        i1 = i2;
      }
      return paramException.toString() + ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private void a(Application paramApplication, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        paramApplication = ((QQAppInterface)((BaseApplicationImpl)paramApplication).getAppRuntime(paramString2)).a();
      }
      catch (AccountNotMatchException paramApplication)
      {
        return;
      }
      paramString2 = new HashMap();
      paramString2.put("param_FailCode", Integer.toString(paramInt2 * 7 + paramInt1 + 88000));
      StatisticCollector.a(BaseApplication.getContext()).a(paramApplication, paramString1, bool, 0L, 0L, paramString2, "");
      return;
      boolean bool = false;
      continue;
      paramApplication = paramString2;
      if (paramInt2 == 0) {
        bool = true;
      }
    }
  }
  
  private void a(Application paramApplication, String paramString, int paramInt, boolean paramBoolean)
  {
    int i1 = 0;
    paramInt *= 4;
    try
    {
      if (paramInt < f)
      {
        paramInt = i1;
        if (!paramBoolean) {
          break label183;
        }
        paramInt = 1;
      }
      for (;;)
      {
        paramApplication = (QQAppInterface)((BaseApplicationImpl)paramApplication).getAppRuntime(paramString);
        paramString = new HashMap();
        paramString.put("param_FailCode", Integer.toString(paramInt + 88050));
        StatisticCollector.a(BaseApplication.getContext()).a(paramApplication.a(), "report_aio_photo_size", false, 0L, 0L, paramString, "");
        return;
        paramInt /= g;
        if (paramInt >= 10)
        {
          if (paramBoolean) {}
          for (paramInt = 17;; paramInt = 16) {
            break;
          }
        }
        if (paramInt >= 8)
        {
          if (paramBoolean) {}
          for (paramInt = 15;; paramInt = 14) {
            break;
          }
        }
        if (paramInt >= 6)
        {
          if (paramBoolean) {}
          for (paramInt = 13;; paramInt = 12) {
            break;
          }
        }
        if (paramBoolean) {}
        for (paramInt = paramInt * 2 + 3;; paramInt = paramInt * 2 + 2) {
          break;
        }
      }
    }
    catch (AccountNotMatchException paramApplication) {}
  }
  
  private void a(DownloadParams paramDownloadParams)
  {
    MessageForPic localMessageForPic;
    Object localObject;
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof MessageForPic)))
    {
      localMessageForPic = (MessageForPic)paramDownloadParams.tag;
      localObject = localMessageForPic.selfuin;
    }
    try
    {
      localObject = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime((String)localObject);
      ((QQAppInterface)localObject).a().a.a(localMessageForPic, localMessageForPic.size);
      ((QQAppInterface)localObject).a().d();
      return;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      a(paramDownloadParams, "payPicFlow", "FAIL,exceptionmsg:" + localAccountNotMatchException);
    }
  }
  
  private void a(DownloadParams paramDownloadParams, File paramFile, String paramString1, BitmapFactory.Options paramOptions, int paramInt, boolean paramBoolean, String paramString2)
  {
    if (paramBoolean) {
      if (QLog.isColorLevel()) {
        a(paramDownloadParams, "DecodeFile", "DecodeFile SUCCESS,retryCount=" + paramInt + ",options.inSampleSize=" + paramOptions.inSampleSize + ",cacheFile=" + paramFile.getAbsolutePath() + ",url=" + paramString1 + ",extraMsg=" + paramString2);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    a(paramDownloadParams, "DecodeFile", "DecodeFile FAIL,retryCount=" + paramInt + ",options.inSampleSize=" + paramOptions.inSampleSize + ",cacheFile=" + paramFile.getAbsolutePath() + ",url=" + paramString1 + ",extraMsg=" + paramString2);
  }
  
  public static void a(AbstractImageDownloader.ReportData paramReportData, boolean paramBoolean, int paramInt1, int paramInt2, String paramString, FileMsg.StepBaseInfo paramStepBaseInfo1, FileMsg.StepBaseInfo paramStepBaseInfo2, FileMsg.StepTransInfo paramStepTransInfo)
  {
    System.currentTimeMillis();
    long l1;
    if (paramStepTransInfo != null)
    {
      l1 = paramStepTransInfo.jdField_e_of_type_Long;
      if (paramStepTransInfo == null) {
        break label42;
      }
    }
    label42:
    for (long l2 = paramStepTransInfo.f;; l2 = 0L)
    {
      if (!RichMediaStrategy.c(paramInt2)) {
        break label48;
      }
      return;
      l1 = 0L;
      break;
    }
    label48:
    HashMap localHashMap = new HashMap();
    String str2;
    String str1;
    if (!BaseTransProcessor.a(paramInt2, localHashMap))
    {
      localHashMap.put("param_FailCode", Integer.toString(paramInt2));
      if ((paramInt2 == -9527) || (paramInt2 == 9311) || (paramInt2 == 9044) || (paramInt2 == 9350) || (paramInt2 == 9351))
      {
        localHashMap.put(BaseTransProcessor.V, paramString);
        str2 = "";
        if ((!paramBoolean) || (paramStepBaseInfo1 != null) || (paramStepBaseInfo2 != null) || (paramStepTransInfo != null)) {
          break label472;
        }
        str1 = "1_-1_0_0_0;2_-1_0_0_0;3_-1_0_0_0";
        label152:
        if (QLog.isColorLevel()) {
          QLog.d("reportResult", 2, "parmStep: " + str1);
        }
        localHashMap.put("param_step", str1);
        localHashMap.put("param_uuid", paramReportData.f);
        localHashMap.put("flow", String.valueOf(l1));
        localHashMap.put("msgTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramReportData.jdField_a_of_type_Long * 1000L)));
        localHashMap.put("client_exist", String.valueOf(paramReportData.jdField_a_of_type_Boolean));
        if (paramStepBaseInfo2 != null) {
          localHashMap.put("param_RequestUrl", paramStepBaseInfo2.b());
        }
        if (paramStepTransInfo != null) {
          localHashMap.put("param_HttpTran", paramStepTransInfo.b());
        }
        if (paramStepTransInfo != null)
        {
          localHashMap.put("param_retry", String.valueOf(paramStepTransInfo.jdField_b_of_type_Int));
          if (!paramStepTransInfo.jdField_a_of_type_Boolean) {
            break label553;
          }
          localHashMap.put("serverip", paramStepTransInfo.c);
          localHashMap.put("param_Server", paramStepTransInfo.c);
        }
        label373:
        if (!paramBoolean) {
          break label621;
        }
        if ((!paramReportData.c.equals("actC2CPicDownloadV1")) && (!paramReportData.c.equals("actC2CPicSmallDownV1"))) {
          break label605;
        }
        localHashMap.put("param_toUin", paramReportData.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      StatisticCollector.a(BaseApplication.getContext()).a(null, paramReportData.c, true, paramInt1, l1, localHashMap, "");
      return;
      localHashMap.put("param_errorDesc", paramString);
      break;
      paramInt2 = -9527;
      localHashMap.put("param_errorDesc", paramString);
      break;
      label472:
      str1 = str2;
      if (paramStepBaseInfo1 == null) {
        break label152;
      }
      str1 = str2;
      if (paramStepBaseInfo2 == null) {
        break label152;
      }
      str1 = str2;
      if (paramStepTransInfo == null) {
        break label152;
      }
      str1 = paramStepBaseInfo1.a(1) + ";" + paramStepBaseInfo2.a(2) + ";" + paramStepTransInfo.a(3);
      break label152;
      label553:
      localHashMap.put("serverip", paramStepTransInfo.d);
      localHashMap.put("param_Server", paramStepTransInfo.d);
      if (paramInt2 != -9527) {
        break label373;
      }
      localHashMap.put("param_rspHeader", paramStepTransInfo.jdField_e_of_type_JavaLangString);
      break label373;
      label605:
      localHashMap.put("param_grpUin", paramReportData.jdField_a_of_type_JavaLangString);
    }
    label621:
    if (paramInt2 == 9301) {
      localHashMap.put("param_connecttrycount", paramString);
    }
    if ((paramReportData.g != null) && (!paramReportData.g.equals(""))) {
      localHashMap.put("param_MsgTime", paramReportData.g);
    }
    long l3 = paramInt1;
    if ((paramReportData.c.equals("actC2CPicDownloadV1")) || (paramReportData.c.equals("actC2CPicSmallDownV1")))
    {
      localHashMap.put("param_toUin", paramReportData.jdField_a_of_type_JavaLangString);
      localHashMap.put("param_url", paramReportData.jdField_e_of_type_JavaLangString);
      localHashMap.put("param_fsized", l1 + "");
      localHashMap.put("param_fsizeo", l2 + "");
    }
    for (;;)
    {
      StatisticCollector.a(BaseApplication.getContext()).a(null, paramReportData.c, false, 0L, 0L, localHashMap, "");
      return;
      localHashMap.put("param_grpUin", paramReportData.jdField_a_of_type_JavaLangString);
      localHashMap.put("param_url", paramReportData.jdField_e_of_type_JavaLangString);
      localHashMap.put("param_fsized", l1 + "");
      localHashMap.put("param_fsizeo", l2 + "");
    }
  }
  
  /* Error */
  protected static void a(java.io.OutputStream paramOutputStream, File paramFile, com.tencent.image.URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 468	java/io/File:length	()J
    //   4: lstore 6
    //   6: new 470	java/io/FileInputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 473	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: astore_1
    //   15: lconst_0
    //   16: lstore 4
    //   18: sipush 8192
    //   21: newarray byte
    //   23: astore 8
    //   25: aload_1
    //   26: aload 8
    //   28: invokevirtual 477	java/io/FileInputStream:read	([B)I
    //   31: istore_3
    //   32: iload_3
    //   33: iconst_m1
    //   34: if_icmpeq +77 -> 111
    //   37: aload_0
    //   38: aload 8
    //   40: iconst_0
    //   41: iload_3
    //   42: invokevirtual 483	java/io/OutputStream:write	([BII)V
    //   45: aload_0
    //   46: invokevirtual 486	java/io/OutputStream:flush	()V
    //   49: lload 4
    //   51: iload_3
    //   52: i2l
    //   53: ladd
    //   54: lstore 4
    //   56: aload_2
    //   57: lload 4
    //   59: l2f
    //   60: lload 6
    //   62: l2f
    //   63: fdiv
    //   64: ldc_w 487
    //   67: fmul
    //   68: f2i
    //   69: invokeinterface 492 2 0
    //   74: goto -49 -> 25
    //   77: astore_0
    //   78: aload_0
    //   79: invokevirtual 493	java/io/IOException:getMessage	()Ljava/lang/String;
    //   82: ldc_w 495
    //   85: invokevirtual 499	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   88: ifeq +28 -> 116
    //   91: new 501	com/tencent/mobileqq/transfile/FileDownloadFailedException
    //   94: dup
    //   95: sipush 9040
    //   98: ldc2_w 502
    //   101: aload_0
    //   102: invokevirtual 493	java/io/IOException:getMessage	()Ljava/lang/String;
    //   105: iconst_0
    //   106: iconst_0
    //   107: invokespecial 506	com/tencent/mobileqq/transfile/FileDownloadFailedException:<init>	(IJLjava/lang/String;ZZ)V
    //   110: athrow
    //   111: aload_1
    //   112: invokevirtual 509	java/io/FileInputStream:close	()V
    //   115: return
    //   116: new 501	com/tencent/mobileqq/transfile/FileDownloadFailedException
    //   119: dup
    //   120: sipush 9301
    //   123: ldc2_w 510
    //   126: aload_0
    //   127: invokevirtual 493	java/io/IOException:getMessage	()Ljava/lang/String;
    //   130: iconst_0
    //   131: iconst_0
    //   132: invokespecial 506	com/tencent/mobileqq/transfile/FileDownloadFailedException:<init>	(IJLjava/lang/String;ZZ)V
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramOutputStream	java.io.OutputStream
    //   0	136	1	paramFile	File
    //   0	136	2	paramURLDrawableHandler	com.tencent.image.URLDrawableHandler
    //   31	21	3	i1	int
    //   16	42	4	l1	long
    //   4	57	6	l2	long
    //   23	16	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	15	77	java/io/IOException
    //   18	25	77	java/io/IOException
    //   25	32	77	java/io/IOException
    //   37	49	77	java/io/IOException
    //   56	74	77	java/io/IOException
    //   111	115	77	java/io/IOException
  }
  
  private void a(Object paramObject, String paramString1, String paramString2)
  {
    if ((paramObject instanceof DownloadParams))
    {
      localObject = (DownloadParams)paramObject;
      if ((((DownloadParams)localObject).tag instanceof PicUiInterface))
      {
        paramObject = (PicUiInterface)((DownloadParams)localObject).tag;
        localObject = ((DownloadParams)localObject).url.getProtocol();
        if (paramObject.isSendFromLocal())
        {
          i1 = RichMediaUtil.a(URLDrawableHelper.a((String)localObject, false));
          paramObject = paramObject.getPicUploadInfo();
          RichMediaUtil.a(paramObject.jdField_b_of_type_Int, false, i1, String.valueOf(paramObject.jdField_a_of_type_Long), paramString1, paramString2);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      int i1;
      return;
      paramObject = paramObject.getPicDownloadInfo();
      if (paramObject.f == 1) {}
      for (boolean bool = true;; bool = false)
      {
        i1 = RichMediaUtil.a(URLDrawableHelper.a((String)localObject, bool));
        RichMediaUtil.a(paramObject.jdField_b_of_type_Int, false, i1, String.valueOf(paramObject.jdField_a_of_type_Long), paramString1, paramString2);
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("obj").append(paramObject);
    ((StringBuilder)localObject).append(" \tstep:").append(paramString1);
    ((StringBuilder)localObject).append(" \tcontent:").append(paramString2);
    QLog.d("Q.richmedia.", 2, ((StringBuilder)localObject).toString());
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt1, int paramInt2, String paramString, boolean paramBoolean5)
  {
    if (paramInt2 == 3)
    {
      paramInt2 = paramInt1 - 1;
      if (paramInt1 != 1) {
        break label49;
      }
      a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", 0, paramString, paramInt2);
      a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_long", 0, paramString, paramInt2);
    }
    label49:
    do
    {
      for (;;)
      {
        return;
        if (!paramBoolean5) {
          break;
        }
        if (!paramBoolean1) {
          if (paramBoolean3)
          {
            a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", -1, paramString, paramInt2);
            if (!paramBoolean2) {
              break label152;
            }
            a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_long", 3, paramString, paramInt2);
          }
        }
        for (;;)
        {
          if (!paramBoolean2) {
            break label168;
          }
          a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_slice", 0, paramString, paramInt2);
          return;
          a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", 2, paramString, paramInt2);
          break;
          a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", 1, paramString, paramInt2);
          break;
          a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_long", 4, paramString, paramInt2);
        }
      }
      if (paramBoolean1) {
        a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", 5, paramString, paramInt2);
      }
      if (paramBoolean2) {
        a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_long", 6, paramString, paramInt2);
      }
    } while (!paramBoolean4);
    label152:
    label168:
    a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_slice", 6, paramString, paramInt2);
  }
  
  /* Error */
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, com.tencent.image.URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: invokestatic 292	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +34 -> 37
    //   6: aload_0
    //   7: aload_2
    //   8: ldc_w 294
    //   11: new 180	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 568
    //   21: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_2
    //   25: getfield 251	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   28: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 285	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_2
    //   38: getfield 571	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   41: astore 16
    //   43: aload_2
    //   44: getfield 517	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   47: astore 15
    //   49: aload 15
    //   51: invokevirtual 522	java/net/URL:getProtocol	()Ljava/lang/String;
    //   54: astore_3
    //   55: ldc_w 573
    //   58: aload_3
    //   59: invokevirtual 426	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   62: ifne +1597 -> 1659
    //   65: ldc_w 575
    //   68: aload_3
    //   69: invokevirtual 426	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   72: ifeq +168 -> 240
    //   75: goto +1584 -> 1659
    //   78: invokestatic 292	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +45 -> 126
    //   84: aload_0
    //   85: aload_2
    //   86: ldc_w 294
    //   89: new 180	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 577
    //   99: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: invokevirtual 313	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   106: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc_w 315
    //   112: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 16
    //   117: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokespecial 285	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   126: new 303	android/graphics/BitmapFactory$Options
    //   129: dup
    //   130: invokespecial 578	android/graphics/BitmapFactory$Options:<init>	()V
    //   133: astore 17
    //   135: aload 17
    //   137: getstatic 580	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_a_of_type_AndroidGraphicsBitmap$Config	Landroid/graphics/Bitmap$Config;
    //   140: putfield 583	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   143: aload 17
    //   145: sipush 160
    //   148: putfield 586	android/graphics/BitmapFactory$Options:inDensity	I
    //   151: aload 17
    //   153: sipush 160
    //   156: putfield 589	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   159: aload 17
    //   161: sipush 160
    //   164: putfield 592	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   167: aload 17
    //   169: iconst_1
    //   170: putfield 595	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   173: aload_1
    //   174: invokestatic 601	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   177: ifeq +69 -> 246
    //   180: iload 4
    //   182: ifne +64 -> 246
    //   185: aload_0
    //   186: aload_2
    //   187: invokespecial 603	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;)V
    //   190: invokestatic 292	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +45 -> 238
    //   196: aload_0
    //   197: aload_2
    //   198: ldc_w 294
    //   201: new 180	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   208: ldc_w 605
    //   211: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_1
    //   215: invokevirtual 313	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   218: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc_w 315
    //   224: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload 16
    //   229: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokespecial 285	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   238: aconst_null
    //   239: areturn
    //   240: iconst_0
    //   241: istore 4
    //   243: goto -165 -> 78
    //   246: iload 4
    //   248: ifeq +514 -> 762
    //   251: aload 17
    //   253: getstatic 132	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_b_of_type_AndroidGraphicsBitmap$Config	Landroid/graphics/Bitmap$Config;
    //   256: putfield 583	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   259: aload 17
    //   261: iconst_0
    //   262: putfield 595	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   265: aload_1
    //   266: invokevirtual 608	java/io/File:getName	()Ljava/lang/String;
    //   269: astore_3
    //   270: aload_3
    //   271: ldc_w 610
    //   274: invokevirtual 614	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   277: ifne +249 -> 526
    //   280: new 180	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   287: aload_3
    //   288: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: ldc_w 610
    //   294: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: astore_3
    //   301: new 310	java/io/File
    //   304: dup
    //   305: getstatic 617	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   308: aload_3
    //   309: invokespecial 620	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   312: astore 15
    //   314: aload_1
    //   315: astore_3
    //   316: aload 15
    //   318: invokevirtual 623	java/io/File:exists	()Z
    //   321: ifeq +107 -> 428
    //   324: aload_1
    //   325: invokestatic 627	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   328: invokestatic 292	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   331: ifeq +45 -> 376
    //   334: aload_0
    //   335: aload_2
    //   336: ldc_w 294
    //   339: new 180	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   346: ldc_w 629
    //   349: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload_1
    //   353: invokevirtual 313	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   356: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc_w 631
    //   362: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 16
    //   367: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokespecial 285	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   376: invokestatic 292	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   379: ifeq +46 -> 425
    //   382: aload_0
    //   383: aload_2
    //   384: ldc_w 294
    //   387: new 180	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   394: ldc_w 633
    //   397: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload 15
    //   402: invokevirtual 313	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   405: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: ldc_w 631
    //   411: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload 16
    //   416: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokespecial 285	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   425: aload 15
    //   427: astore_3
    //   428: aload_3
    //   429: astore_1
    //   430: aload_1
    //   431: invokevirtual 313	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   434: aload 17
    //   436: invokestatic 638	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   439: astore_3
    //   440: aload_3
    //   441: ifnull +179 -> 620
    //   444: aload_0
    //   445: aload_3
    //   446: invokespecial 640	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Landroid/graphics/Bitmap;)Lcom/tencent/image/RoundRectBitmap;
    //   449: astore 15
    //   451: aload_3
    //   452: aload 15
    //   454: getfield 644	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   457: invokevirtual 647	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   460: ifne +7 -> 467
    //   463: aload_3
    //   464: invokevirtual 650	android/graphics/Bitmap:recycle	()V
    //   467: new 155	com/tencent/image/RoundRectBitmap
    //   470: dup
    //   471: new 652	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator
    //   474: dup
    //   475: aload_1
    //   476: invokevirtual 313	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   479: invokespecial 653	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator:<init>	(Ljava/lang/String;)V
    //   482: aload 15
    //   484: getfield 644	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   487: invokevirtual 656	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   490: aload 15
    //   492: getfield 659	com/tencent/image/RoundRectBitmap:mCornerRadius	F
    //   495: aload 15
    //   497: getfield 662	com/tencent/image/RoundRectBitmap:mBoardColor	I
    //   500: aload 15
    //   502: getfield 665	com/tencent/image/RoundRectBitmap:mBorderWidth	F
    //   505: invokespecial 668	com/tencent/image/RoundRectBitmap:<init>	(Landroid/graphics/Bitmap;FIF)V
    //   508: astore_3
    //   509: aload_0
    //   510: aload_2
    //   511: aload_1
    //   512: aload 16
    //   514: aload 17
    //   516: iconst_1
    //   517: iconst_1
    //   518: ldc_w 670
    //   521: invokespecial 672	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   524: aload_3
    //   525: areturn
    //   526: aload_3
    //   527: invokevirtual 674	java/lang/String:length	()I
    //   530: iconst_3
    //   531: if_icmple +86 -> 617
    //   534: aload_3
    //   535: iconst_0
    //   536: aload_3
    //   537: invokevirtual 674	java/lang/String:length	()I
    //   540: iconst_3
    //   541: isub
    //   542: invokevirtual 678	java/lang/String:substring	(II)Ljava/lang/String;
    //   545: astore_3
    //   546: new 310	java/io/File
    //   549: dup
    //   550: getstatic 617	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   553: aload_3
    //   554: invokespecial 620	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   557: astore_3
    //   558: aload_3
    //   559: invokevirtual 623	java/io/File:exists	()Z
    //   562: ifeq +55 -> 617
    //   565: aload_3
    //   566: invokestatic 627	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   569: invokestatic 292	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   572: ifeq +45 -> 617
    //   575: aload_0
    //   576: aload_2
    //   577: ldc_w 294
    //   580: new 180	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   587: ldc_w 629
    //   590: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: aload_1
    //   594: invokevirtual 313	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   597: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: ldc_w 631
    //   603: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: aload 16
    //   608: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: invokespecial 285	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   617: goto -187 -> 430
    //   620: aload_1
    //   621: invokevirtual 681	java/io/File:delete	()Z
    //   624: pop
    //   625: aload_0
    //   626: aload_2
    //   627: aload_1
    //   628: aload 16
    //   630: aload 17
    //   632: iconst_1
    //   633: iconst_0
    //   634: ldc_w 683
    //   637: invokespecial 672	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   640: new 465	java/io/IOException
    //   643: dup
    //   644: ldc_w 683
    //   647: invokespecial 684	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   650: athrow
    //   651: astore_3
    //   652: aload_0
    //   653: aload_2
    //   654: aload_1
    //   655: aload 16
    //   657: aload 17
    //   659: iconst_1
    //   660: iconst_0
    //   661: new 180	java/lang/StringBuilder
    //   664: dup
    //   665: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   668: ldc_w 686
    //   671: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: aload_3
    //   675: invokevirtual 687	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   678: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: invokespecial 672	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   687: aload_3
    //   688: athrow
    //   689: astore 15
    //   691: aload 15
    //   693: invokestatic 689	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   696: astore_3
    //   697: aload_3
    //   698: ifnull +12 -> 710
    //   701: aload_3
    //   702: astore_1
    //   703: aload_3
    //   704: invokevirtual 674	java/lang/String:length	()I
    //   707: ifne +9 -> 716
    //   710: aload 15
    //   712: invokevirtual 198	java/lang/Exception:toString	()Ljava/lang/String;
    //   715: astore_1
    //   716: invokestatic 292	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   719: ifeq +40 -> 759
    //   722: aload_0
    //   723: getfield 63	com/tencent/mobileqq/transfile/AbstractImageDownloader:d	Ljava/lang/String;
    //   726: iconst_2
    //   727: aload_1
    //   728: invokestatic 691	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   731: aload_0
    //   732: aload_2
    //   733: ldc_w 294
    //   736: new 180	java/lang/StringBuilder
    //   739: dup
    //   740: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   743: ldc_w 693
    //   746: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: aload_1
    //   750: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   756: invokespecial 285	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   759: aload 15
    //   761: athrow
    //   762: aload_0
    //   763: aload_2
    //   764: invokespecial 603	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;)V
    //   767: aload 17
    //   769: iconst_1
    //   770: putfield 595	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   773: aload_1
    //   774: invokevirtual 313	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   777: aload 17
    //   779: invokestatic 638	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   782: pop
    //   783: aload 17
    //   785: getfield 696	android/graphics/BitmapFactory$Options:outHeight	I
    //   788: ifeq +11 -> 799
    //   791: aload 17
    //   793: getfield 699	android/graphics/BitmapFactory$Options:outWidth	I
    //   796: ifne +34 -> 830
    //   799: aload_1
    //   800: invokevirtual 681	java/io/File:delete	()Z
    //   803: pop
    //   804: aload_0
    //   805: aload_2
    //   806: aload_1
    //   807: aload 16
    //   809: aload 17
    //   811: iconst_1
    //   812: iconst_0
    //   813: ldc_w 701
    //   816: invokespecial 672	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   819: new 465	java/io/IOException
    //   822: dup
    //   823: ldc_w 701
    //   826: invokespecial 684	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   829: athrow
    //   830: aload 17
    //   832: aload 17
    //   834: aload_2
    //   835: getfield 704	com/tencent/image/DownloadParams:reqWidth	I
    //   838: aload_2
    //   839: getfield 707	com/tencent/image/DownloadParams:reqHeight	I
    //   842: invokestatic 709	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   845: putfield 306	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   848: aload 17
    //   850: getfield 699	android/graphics/BitmapFactory$Options:outWidth	I
    //   853: istore 6
    //   855: aload 17
    //   857: getfield 696	android/graphics/BitmapFactory$Options:outHeight	I
    //   860: istore 7
    //   862: aload 17
    //   864: iconst_0
    //   865: putfield 595	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   868: iconst_0
    //   869: istore 9
    //   871: aconst_null
    //   872: astore_3
    //   873: iconst_1
    //   874: istore 5
    //   876: aload 15
    //   878: invokevirtual 522	java/net/URL:getProtocol	()Ljava/lang/String;
    //   881: ldc_w 711
    //   884: invokevirtual 426	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   887: ifne +63 -> 950
    //   890: aload 15
    //   892: invokevirtual 522	java/net/URL:getProtocol	()Ljava/lang/String;
    //   895: ldc_w 713
    //   898: invokevirtual 426	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   901: ifne +49 -> 950
    //   904: aload 15
    //   906: invokevirtual 522	java/net/URL:getProtocol	()Ljava/lang/String;
    //   909: ldc_w 715
    //   912: invokevirtual 426	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   915: ifne +35 -> 950
    //   918: aload 15
    //   920: invokevirtual 522	java/net/URL:getProtocol	()Ljava/lang/String;
    //   923: ldc_w 717
    //   926: invokevirtual 426	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   929: ifne +21 -> 950
    //   932: aload 15
    //   934: invokevirtual 522	java/net/URL:getProtocol	()Ljava/lang/String;
    //   937: ldc_w 719
    //   940: invokevirtual 426	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   943: istore 10
    //   945: iload 10
    //   947: ifeq +706 -> 1653
    //   950: iconst_3
    //   951: istore 4
    //   953: iload 5
    //   955: iload 4
    //   957: if_icmpgt +691 -> 1648
    //   960: aload_1
    //   961: invokevirtual 313	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   964: aload 17
    //   966: invokestatic 638	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   969: astore 15
    //   971: aload 15
    //   973: astore_3
    //   974: aload_3
    //   975: ifnonnull +258 -> 1233
    //   978: iload 9
    //   980: istore 10
    //   982: invokestatic 292	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   985: ifeq +60 -> 1045
    //   988: iload 9
    //   990: istore 10
    //   992: aload_0
    //   993: aload_2
    //   994: ldc_w 294
    //   997: new 180	java/lang/StringBuilder
    //   1000: dup
    //   1001: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   1004: ldc_w 721
    //   1007: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1010: aload 16
    //   1012: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: ldc_w 723
    //   1018: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: iload 5
    //   1023: invokevirtual 299	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1026: ldc_w 725
    //   1029: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: aload_1
    //   1033: invokevirtual 313	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1036: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1042: invokespecial 285	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   1045: iload 9
    //   1047: istore 10
    //   1049: new 99	java/lang/OutOfMemoryError
    //   1052: dup
    //   1053: new 180	java/lang/StringBuilder
    //   1056: dup
    //   1057: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   1060: ldc_w 721
    //   1063: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: aload 16
    //   1068: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1071: ldc_w 723
    //   1074: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: iload 5
    //   1079: invokevirtual 299	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1082: ldc_w 725
    //   1085: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: aload_1
    //   1089: invokevirtual 313	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1092: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1098: invokespecial 726	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   1101: athrow
    //   1102: astore 15
    //   1104: iload 10
    //   1106: istore 9
    //   1108: aload_3
    //   1109: ifnull +7 -> 1116
    //   1112: aload_3
    //   1113: invokevirtual 650	android/graphics/Bitmap:recycle	()V
    //   1116: aload 15
    //   1118: ifnull +455 -> 1573
    //   1121: aload 15
    //   1123: invokevirtual 687	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1126: astore 15
    //   1128: invokestatic 292	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1131: ifeq +81 -> 1212
    //   1134: aload_0
    //   1135: aload_2
    //   1136: ldc_w 294
    //   1139: new 180	java/lang/StringBuilder
    //   1142: dup
    //   1143: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   1146: ldc_w 728
    //   1149: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: iload 5
    //   1154: invokevirtual 299	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1157: ldc_w 301
    //   1160: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1163: aload 17
    //   1165: getfield 306	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1168: invokevirtual 299	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1171: ldc_w 308
    //   1174: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: aload_1
    //   1178: invokevirtual 313	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1181: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: ldc_w 315
    //   1187: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1190: aload 16
    //   1192: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: ldc_w 730
    //   1198: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1201: aload 15
    //   1203: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1209: invokespecial 285	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   1212: iload 5
    //   1214: iconst_1
    //   1215: iadd
    //   1216: istore 5
    //   1218: aload 17
    //   1220: aload 17
    //   1222: getfield 306	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1225: iconst_2
    //   1226: imul
    //   1227: putfield 306	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1230: goto -277 -> 953
    //   1233: iload 9
    //   1235: istore 10
    //   1237: getstatic 735	android/os/Build$VERSION:SDK_INT	I
    //   1240: bipush 11
    //   1242: if_icmplt +328 -> 1570
    //   1245: iload 9
    //   1247: istore 10
    //   1249: aload_3
    //   1250: invokestatic 741	com/tencent/image/SliceBitmap:needSlice	(Landroid/graphics/Bitmap;)Z
    //   1253: istore 11
    //   1255: iload 11
    //   1257: ifeq +313 -> 1570
    //   1260: iload 9
    //   1262: istore 10
    //   1264: new 737	com/tencent/image/SliceBitmap
    //   1267: dup
    //   1268: aload_3
    //   1269: invokespecial 742	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   1272: astore 15
    //   1274: iconst_1
    //   1275: istore 9
    //   1277: aload_3
    //   1278: invokevirtual 650	android/graphics/Bitmap:recycle	()V
    //   1281: aload_0
    //   1282: aload_2
    //   1283: aload_1
    //   1284: aload 16
    //   1286: aload 17
    //   1288: iload 5
    //   1290: iconst_1
    //   1291: ldc_w 744
    //   1294: invokespecial 672	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   1297: aload 15
    //   1299: astore_3
    //   1300: iconst_1
    //   1301: istore 9
    //   1303: aload_3
    //   1304: ifnull +275 -> 1579
    //   1307: iconst_1
    //   1308: istore 10
    //   1310: aload_0
    //   1311: aload_2
    //   1312: aload_1
    //   1313: aload 16
    //   1315: aload 17
    //   1317: iload 5
    //   1319: iload 10
    //   1321: ldc 237
    //   1323: invokespecial 672	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   1326: aload_2
    //   1327: getfield 251	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   1330: ifnull +172 -> 1502
    //   1333: aload_2
    //   1334: getfield 251	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   1337: instanceof 253
    //   1340: ifeq +162 -> 1502
    //   1343: aload_2
    //   1344: getfield 251	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   1347: checkcast 253	com/tencent/mobileqq/data/MessageForPic
    //   1350: astore_1
    //   1351: aload_1
    //   1352: getfield 256	com/tencent/mobileqq/data/MessageForPic:selfuin	Ljava/lang/String;
    //   1355: astore 15
    //   1357: aload_1
    //   1358: invokevirtual 745	com/tencent/mobileqq/data/MessageForPic:isSendFromLocal	()Z
    //   1361: istore 14
    //   1363: aload_3
    //   1364: ifnull +221 -> 1585
    //   1367: iconst_1
    //   1368: istore 10
    //   1370: iload 6
    //   1372: iload 7
    //   1374: imul
    //   1375: istore 8
    //   1377: iload 8
    //   1379: getstatic 746	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_Int	I
    //   1382: if_icmple +209 -> 1591
    //   1385: iconst_1
    //   1386: istore 11
    //   1388: goto +277 -> 1665
    //   1391: getstatic 49	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_Int	I
    //   1394: ifeq +9 -> 1403
    //   1397: getstatic 51	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_b_of_type_Int	I
    //   1400: ifne +35 -> 1435
    //   1403: aload_0
    //   1404: getfield 65	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1407: invokevirtual 102	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   1410: invokevirtual 78	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1413: getfield 749	android/util/DisplayMetrics:widthPixels	I
    //   1416: putstatic 49	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_Int	I
    //   1419: aload_0
    //   1420: getfield 65	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1423: invokevirtual 102	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   1426: invokevirtual 78	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1429: getfield 752	android/util/DisplayMetrics:heightPixels	I
    //   1432: putstatic 51	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_b_of_type_Int	I
    //   1435: getstatic 49	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_Int	I
    //   1438: getstatic 51	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_b_of_type_Int	I
    //   1441: if_icmple +162 -> 1603
    //   1444: getstatic 49	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_Int	I
    //   1447: istore 6
    //   1449: iload 8
    //   1451: getstatic 753	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_b_of_type_Int	I
    //   1454: if_icmpgt +157 -> 1611
    //   1457: iload 6
    //   1459: sipush 1000
    //   1462: if_icmple +149 -> 1611
    //   1465: iconst_1
    //   1466: istore 13
    //   1468: aload_0
    //   1469: iload 11
    //   1471: iload 12
    //   1473: iload 13
    //   1475: iload 9
    //   1477: iload 5
    //   1479: iload 4
    //   1481: aload 15
    //   1483: iload 10
    //   1485: invokespecial 755	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(ZZZZIILjava/lang/String;Z)V
    //   1488: aload_0
    //   1489: aload_0
    //   1490: getfield 65	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1493: aload 15
    //   1495: iload 8
    //   1497: iload 14
    //   1499: invokespecial 757	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Landroid/app/Application;Ljava/lang/String;IZ)V
    //   1502: aload_3
    //   1503: ifnonnull +114 -> 1617
    //   1506: new 465	java/io/IOException
    //   1509: dup
    //   1510: ldc_w 759
    //   1513: invokespecial 684	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1516: athrow
    //   1517: astore 15
    //   1519: iload 9
    //   1521: istore 10
    //   1523: aload_0
    //   1524: aload_2
    //   1525: ldc_w 294
    //   1528: new 180	java/lang/StringBuilder
    //   1531: dup
    //   1532: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   1535: ldc_w 761
    //   1538: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1541: aload 15
    //   1543: invokevirtual 174	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1546: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1549: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1552: invokespecial 285	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   1555: iload 9
    //   1557: istore 10
    //   1559: new 99	java/lang/OutOfMemoryError
    //   1562: dup
    //   1563: ldc_w 763
    //   1566: invokespecial 726	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   1569: athrow
    //   1570: goto -267 -> 1303
    //   1573: aconst_null
    //   1574: astore 15
    //   1576: goto -448 -> 1128
    //   1579: iconst_0
    //   1580: istore 10
    //   1582: goto -272 -> 1310
    //   1585: iconst_0
    //   1586: istore 10
    //   1588: goto -218 -> 1370
    //   1591: iconst_0
    //   1592: istore 11
    //   1594: goto +71 -> 1665
    //   1597: iconst_0
    //   1598: istore 12
    //   1600: goto -209 -> 1391
    //   1603: getstatic 51	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_b_of_type_Int	I
    //   1606: istore 6
    //   1608: goto -159 -> 1449
    //   1611: iconst_0
    //   1612: istore 13
    //   1614: goto -146 -> 1468
    //   1617: aload_3
    //   1618: areturn
    //   1619: astore 15
    //   1621: goto -513 -> 1108
    //   1624: astore 15
    //   1626: goto -518 -> 1108
    //   1629: astore 15
    //   1631: iconst_1
    //   1632: istore 9
    //   1634: goto -115 -> 1519
    //   1637: astore_3
    //   1638: goto -986 -> 652
    //   1641: astore_3
    //   1642: aload 15
    //   1644: astore_1
    //   1645: goto -993 -> 652
    //   1648: aconst_null
    //   1649: astore_3
    //   1650: goto -347 -> 1303
    //   1653: iconst_1
    //   1654: istore 4
    //   1656: goto -703 -> 953
    //   1659: iconst_1
    //   1660: istore 4
    //   1662: goto -1584 -> 78
    //   1665: iload 6
    //   1667: sipush 2048
    //   1670: if_icmpgt +11 -> 1681
    //   1673: iload 7
    //   1675: sipush 2048
    //   1678: if_icmple -81 -> 1597
    //   1681: iconst_1
    //   1682: istore 12
    //   1684: goto -293 -> 1391
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1687	0	this	AbstractImageDownloader
    //   0	1687	1	paramFile	File
    //   0	1687	2	paramDownloadParams	DownloadParams
    //   0	1687	3	paramURLDrawableHandler	com.tencent.image.URLDrawableHandler
    //   180	1481	4	i1	int
    //   874	604	5	i2	int
    //   853	818	6	i3	int
    //   860	819	7	i4	int
    //   1375	121	8	i5	int
    //   869	764	9	bool1	boolean
    //   943	644	10	bool2	boolean
    //   1253	340	11	bool3	boolean
    //   1471	212	12	bool4	boolean
    //   1466	147	13	bool5	boolean
    //   1361	137	14	bool6	boolean
    //   47	454	15	localObject1	Object
    //   689	244	15	localException1	Exception
    //   969	3	15	localBitmap	Bitmap
    //   1102	20	15	localOutOfMemoryError1	OutOfMemoryError
    //   1126	368	15	localObject2	Object
    //   1517	25	15	localException2	Exception
    //   1574	1	15	localObject3	Object
    //   1619	1	15	localOutOfMemoryError2	OutOfMemoryError
    //   1624	1	15	localOutOfMemoryError3	OutOfMemoryError
    //   1629	14	15	localException3	Exception
    //   41	1273	16	str	String
    //   133	1183	17	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   430	440	651	java/lang/OutOfMemoryError
    //   444	467	651	java/lang/OutOfMemoryError
    //   467	524	651	java/lang/OutOfMemoryError
    //   620	651	651	java/lang/OutOfMemoryError
    //   37	75	689	java/lang/Exception
    //   78	126	689	java/lang/Exception
    //   126	180	689	java/lang/Exception
    //   185	238	689	java/lang/Exception
    //   251	314	689	java/lang/Exception
    //   316	376	689	java/lang/Exception
    //   376	425	689	java/lang/Exception
    //   430	440	689	java/lang/Exception
    //   444	467	689	java/lang/Exception
    //   467	524	689	java/lang/Exception
    //   526	617	689	java/lang/Exception
    //   620	651	689	java/lang/Exception
    //   652	689	689	java/lang/Exception
    //   762	799	689	java/lang/Exception
    //   799	830	689	java/lang/Exception
    //   830	868	689	java/lang/Exception
    //   876	945	689	java/lang/Exception
    //   960	971	689	java/lang/Exception
    //   982	988	689	java/lang/Exception
    //   992	1045	689	java/lang/Exception
    //   1049	1102	689	java/lang/Exception
    //   1112	1116	689	java/lang/Exception
    //   1121	1128	689	java/lang/Exception
    //   1128	1212	689	java/lang/Exception
    //   1218	1230	689	java/lang/Exception
    //   1237	1245	689	java/lang/Exception
    //   1249	1255	689	java/lang/Exception
    //   1310	1363	689	java/lang/Exception
    //   1377	1385	689	java/lang/Exception
    //   1391	1403	689	java/lang/Exception
    //   1403	1435	689	java/lang/Exception
    //   1435	1449	689	java/lang/Exception
    //   1449	1457	689	java/lang/Exception
    //   1468	1502	689	java/lang/Exception
    //   1506	1517	689	java/lang/Exception
    //   1523	1555	689	java/lang/Exception
    //   1559	1570	689	java/lang/Exception
    //   1603	1608	689	java/lang/Exception
    //   982	988	1102	java/lang/OutOfMemoryError
    //   992	1045	1102	java/lang/OutOfMemoryError
    //   1049	1102	1102	java/lang/OutOfMemoryError
    //   1237	1245	1102	java/lang/OutOfMemoryError
    //   1249	1255	1102	java/lang/OutOfMemoryError
    //   1264	1274	1102	java/lang/OutOfMemoryError
    //   1523	1555	1102	java/lang/OutOfMemoryError
    //   1559	1570	1102	java/lang/OutOfMemoryError
    //   1264	1274	1517	java/lang/Exception
    //   1277	1297	1619	java/lang/OutOfMemoryError
    //   960	971	1624	java/lang/OutOfMemoryError
    //   1277	1297	1629	java/lang/Exception
    //   251	314	1637	java/lang/OutOfMemoryError
    //   316	376	1637	java/lang/OutOfMemoryError
    //   526	617	1637	java/lang/OutOfMemoryError
    //   376	425	1641	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AbstractImageDownloader
 * JD-Core Version:    0.7.0.1
 */