package com.tencent.device;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cws;
import cwt;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;

@SuppressLint({"UseSparseArrays"})
public class DeviceHeadMgr
{
  private static DeviceHeadMgr jdField_a_of_type_ComTencentDeviceDeviceHeadMgr = null;
  protected static final String a = "https://i.gtimg.cn/open/device_icon/%s/%s/%s/%s/%s.png";
  private int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private String jdField_b_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + "/devicehead/";
  private HashMap jdField_b_of_type_JavaUtilHashMap;
  
  public static DeviceHeadMgr a()
  {
    if (jdField_a_of_type_ComTencentDeviceDeviceHeadMgr == null)
    {
      jdField_a_of_type_ComTencentDeviceDeviceHeadMgr = new DeviceHeadMgr();
      jdField_a_of_type_ComTencentDeviceDeviceHeadMgr.a();
    }
    return jdField_a_of_type_ComTencentDeviceDeviceHeadMgr;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (paramString.length() < 8) {}
    for (String str = "00000000" + paramString;; str = paramString)
    {
      str = str.substring(str.length() - 8);
      return String.format("https://i.gtimg.cn/open/device_icon/%s/%s/%s/%s/%s.png", new Object[] { str.substring(0, 2), str.substring(2, 4), str.substring(4, 6), str.substring(6, 8), paramString });
    }
  }
  
  private void a()
  {
    Util.a(this.jdField_b_of_type_JavaLangString);
    if (SystemUtil.a()) {}
    for (this.jdField_b_of_type_JavaLangString = AppConstants.cd;; this.jdField_b_of_type_JavaLangString = (SystemUtil.a + "head/_dhd/"))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
      if ((localAppRuntime instanceof QQAppInterface))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localAppRuntime);
        this.jdField_a_of_type_Int = 3;
      }
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      if (this.jdField_b_of_type_JavaUtilHashMap == null) {
        this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
      }
      return;
    }
  }
  
  public Bitmap a(int paramInt)
  {
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    Object localObject1 = localBitmap;
    String str1;
    if (localBitmap == null)
    {
      str1 = String.valueOf(paramInt);
      if (TextUtils.isEmpty(str1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DeviceHeadMgr", 2, "productid is not valid");
        }
        try
        {
          localObject1 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), 2130838238);
          return localObject1;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          do
          {
            localObject1 = null;
          } while (!QLog.isColorLevel());
          QLog.d("DeviceHeadMgr", 2, "getDeviceHeadByPID BitmapFactory.decodeResource", localOutOfMemoryError);
          return null;
        }
      }
      String str2 = this.jdField_b_of_type_JavaLangString + str1;
      localObject2 = BitmapManager.a(str2);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)))
        {
          localObject1 = new File(str2);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            break label268;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new cws(this, str1, (File)localObject1));
          label170:
          this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), Integer.valueOf(0));
          localObject1 = localObject2;
        }
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      switch (this.jdField_a_of_type_Int)
      {
      }
    }
    for (localObject2 = ImageUtil.a((Bitmap)localObject1, 50, 50);; localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((Bitmap)localObject1, 50, 50))
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localObject2);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      return BitmapManager.a(BaseApplication.getContext().getResources(), 2130838238);
      label268:
      new Thread(new cwt(this, str1, (File)localObject1)).start();
      break label170;
    }
  }
  
  public Bitmap a(String paramString)
  {
    paramString = ((SmartDeviceProxyMgr)((QQAppInterface)BaseApplicationImpl.a().a()).a(53)).a(Long.parseLong(paramString));
    if (paramString == null) {
      return a(0);
    }
    return a(paramString.productId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.DeviceHeadMgr
 * JD-Core Version:    0.7.0.1
 */