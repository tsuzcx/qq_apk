package com.tencent.mobileqq.pic;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.compress.PicType;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.BinderWarpper;
import java.util.ArrayList;
import mqq.manager.ServerConfigManager.ConfigType;

public class PicBusiManager
{
  public static final int a = 1;
  private static final String a;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  
  static
  {
    jdField_a_of_type_JavaLangString = PicBusiManager.class.getSimpleName();
  }
  
  static BasePicOprerator a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    switch (paramInt)
    {
    case 1030: 
    default: 
      return null;
    }
    return new AioPicOperator(paramQQAppInterface);
  }
  
  public static CompressInfo a(int paramInt, Intent paramIntent)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramIntent);
  }
  
  static InfoBuilder a(int paramInt)
  {
    switch (paramInt)
    {
    case 1030: 
    default: 
      return null;
    }
    return new AioPicOperator();
  }
  
  public static PicDownloadInfo a(int paramInt, Intent paramIntent)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramIntent);
  }
  
  public static PicFowardInfo a(int paramInt, Intent paramIntent)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramIntent);
  }
  
  public static PicFowardInfo a(int paramInt1, MessageForPic paramMessageForPic, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    InfoBuilder localInfoBuilder = a(paramInt1);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramMessageForPic, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static PicReq a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, 0, paramInt2);
  }
  
  public static PicReq a(int paramInt1, int paramInt2, int paramInt3)
  {
    PicReq localPicReq = new PicReq();
    localPicReq.n = paramInt1;
    localPicReq.p = paramInt2;
    localPicReq.o = paramInt3;
    return localPicReq;
  }
  
  public static PicUploadInfo a(int paramInt, Intent paramIntent)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramIntent);
  }
  
  public static ArrayList a(int paramInt1, MessageForMixedMsg paramMessageForMixedMsg, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    InfoBuilder localInfoBuilder = a(paramInt1);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramMessageForMixedMsg, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static void a(PicReq paramPicReq, QQAppInterface paramQQAppInterface)
  {
    if (paramPicReq == null)
    {
      Logger.b(jdField_a_of_type_JavaLangString, "launch", "error,req == null");
      return;
    }
    BasePicOprerator localBasePicOprerator = a(paramPicReq.o, paramQQAppInterface);
    if (localBasePicOprerator == null)
    {
      Logger.b(jdField_a_of_type_JavaLangString, "launch", "error,busiInterface == null,req.busiType:" + paramPicReq.o);
      return;
    }
    localBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq = paramPicReq;
    localBasePicOprerator.jdField_a_of_type_JavaLangString = paramPicReq.jdField_a_of_type_JavaLangString;
    localBasePicOprerator.b = paramPicReq.b;
    localBasePicOprerator.a(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicUiCallBack);
    Logger.a(jdField_a_of_type_JavaLangString, "launch", "cmd:" + paramPicReq.n + ",busiType" + paramPicReq.o + "localUUID:" + paramPicReq.jdField_a_of_type_JavaLangString);
    switch (paramPicReq.n)
    {
    default: 
      return;
    case 1: 
      a(paramQQAppInterface);
      paramQQAppInterface = new Intent(BaseApplication.getContext(), PeakService.class);
      paramQQAppInterface.putExtra("ServiceAction", 1);
      paramQQAppInterface.putExtra("CompressInfo", paramPicReq.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
      if (paramPicReq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoICompressionCallBack != null) {
        paramQQAppInterface.putExtra("CompressCallback", new BinderWarpper(paramPicReq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoICompressionCallBack.asBinder()));
      }
      BaseApplication.getContext().startService(paramQQAppInterface);
      return;
    case 5: 
    case 6: 
    case 7: 
      localBasePicOprerator.b(paramPicReq);
      return;
    case 2: 
      localBasePicOprerator.a(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo);
      return;
    case 3: 
      localBasePicOprerator.a(paramPicReq);
      return;
    case 4: 
      localBasePicOprerator.a(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo);
      return;
    }
    localBasePicOprerator.a(paramPicReq.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public static int[] a(QQAppInterface paramQQAppInterface)
  {
    String str = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "SendPhotoMaxLongSide");
    long l1;
    if (str != null)
    {
      l1 = DeviceInfoUtil.f();
      long l2 = DeviceInfoUtil.g();
      if (l2 <= l1) {
        break label723;
      }
      l1 = l2;
    }
    label723:
    for (;;)
    {
      try
      {
        arrayOfString = str.split("\\|");
        arrayOfInt2 = new int[arrayOfString.length];
        i = 0;
      }
      catch (Exception localException3)
      {
        String[] arrayOfString;
        int[] arrayOfInt2;
        int i;
        Object localObject1;
        Object localObject2 = null;
        continue;
        i += 1;
        continue;
      }
      localObject1 = arrayOfInt2;
      try
      {
        if (i < arrayOfString.length)
        {
          j = Integer.parseInt(arrayOfString[i]);
          if ((j <= 0) || (j > 2560)) {
            continue;
          }
          if (i > 0)
          {
            if (j > arrayOfInt2[(i - 1)])
            {
              arrayOfInt2[i] = j;
              continue;
            }
            Logger.a(jdField_a_of_type_JavaLangString, "launch", "Invalid config = " + str);
            localObject1 = null;
          }
        }
        else
        {
          if (localObject1 != null)
          {
            i = 0;
            if (i < localObject1.length)
            {
              if ((l1 > localObject1[i]) && (i != localObject1.length - 1)) {
                continue;
              }
              PicType.i = localObject1[i];
              Logger.a(jdField_a_of_type_JavaLangString, "launch", "Update SendPhotoMaxLongSide to " + PicType.i);
            }
          }
          localObject1 = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "SendPhotoWiFiPicQuality");
          if (localObject1 == null) {}
        }
      }
      catch (Exception localException1)
      {
        int j;
        arrayOfInt1 = arrayOfInt2;
      }
      try
      {
        i = Integer.parseInt((String)localObject1);
        if ((i <= 0) || (i > 100)) {
          continue;
        }
        PicType.e = i;
        Logger.a(jdField_a_of_type_JavaLangString, "launch", "Update SendPhotoWiFIPicQuality to " + i);
      }
      catch (Exception localException4)
      {
        Logger.a(jdField_a_of_type_JavaLangString, "launch", "Invalid SendPhotoWiFIPicQuality config = " + arrayOfInt1);
        continue;
        Logger.a(jdField_a_of_type_JavaLangString, "launch", "Invalid SendPhoto23GPicQuality config = " + arrayOfInt1);
        continue;
      }
      localObject1 = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "SendPhoto23GPicQuality");
      if (localObject1 != null) {}
      try
      {
        i = Integer.parseInt((String)localObject1);
        if ((i <= 0) || (i > 100)) {
          continue;
        }
        PicType.f = i;
        Logger.a(jdField_a_of_type_JavaLangString, "launch", "Update SendPhoto23GPicQuality to " + i);
      }
      catch (Exception localException5)
      {
        Logger.a(jdField_a_of_type_JavaLangString, "launch", "Invalid SendPhoto23GPicQuality config = " + arrayOfInt1);
        continue;
        Logger.a(jdField_a_of_type_JavaLangString, "launch", "Invalid SendPhoto4GPicQuality config = " + paramQQAppInterface);
        continue;
      }
      paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "SendPhoto4GPicQuality");
      if (paramQQAppInterface != null) {}
      try
      {
        i = Integer.parseInt(paramQQAppInterface);
        if ((i <= 0) || (i > 100)) {
          continue;
        }
        PicType.g = i;
        Logger.a(jdField_a_of_type_JavaLangString, "launch", "Update SendPhoto4GPicQuality to " + i);
      }
      catch (Exception localException2)
      {
        int[] arrayOfInt1;
        Logger.a(jdField_a_of_type_JavaLangString, "launch", "Invalid SendPhoto4GPicQuality config = " + paramQQAppInterface);
        continue;
      }
      return new int[] { PicType.i, PicType.e, PicType.f, PicType.g };
      arrayOfInt2[i] = j;
      continue;
      Logger.a(jdField_a_of_type_JavaLangString, "launch", "Invalid SendPhotoMaxLongSide config = " + str);
      continue;
      Logger.a(jdField_a_of_type_JavaLangString, "launch", "Invalid config = " + str);
      arrayOfInt1 = null;
      continue;
      i += 1;
      continue;
      Logger.a(jdField_a_of_type_JavaLangString, "launch", "Invalid SendPhotoWiFIPicQuality config = " + arrayOfInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicBusiManager
 * JD-Core Version:    0.7.0.1
 */