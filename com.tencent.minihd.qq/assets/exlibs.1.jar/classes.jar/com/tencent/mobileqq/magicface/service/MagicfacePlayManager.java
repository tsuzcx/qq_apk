package com.tencent.mobileqq.magicface.service;

import com.tencent.mobileqq.magicface.model.MagicFaceSuperBigDecoder;
import com.tencent.mobileqq.magicface.model.MagicfaceData;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicPlayListener;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicfaceRenderListener;
import com.tencent.mobileqq.magicface.model.MagicfaceFFMepgDecoder;
import com.tencent.mobileqq.magicface.model.MagicfacePlayRes;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;
import com.tencent.mobileqq.magicface.model.MagicfaceXBigDecoder;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;

public class MagicfacePlayManager
{
  private static final String jdField_a_of_type_JavaLangString = MagicfacePlayManager.class.getSimpleName();
  private MagicfaceData jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData;
  private MagicfaceDecoder.MagicfaceRenderListener jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener;
  private MagicfaceDecoder jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder;
  private MagicfaceResLoader jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader;
  private SoundPoolUtil jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil;
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func init begins, magicfaceDecoder:" + this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder == null)
    {
      boolean bool = DeviceInfoUtil.e();
      long l = Math.min(DeviceInfoUtil.f(), DeviceInfoUtil.g());
      if ((!bool) || (l < 720L)) {
        break label121;
      }
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder = new MagicFaceSuperBigDecoder();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func init, use [SuperBigDecoder]");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func init ends.");
      }
      return;
      label121:
      if ("xbig".equalsIgnoreCase(MagicfaceResLoader.a()))
      {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder = new MagicfaceXBigDecoder();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "func init, use [XBigDecoder]");
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder = new MagicfaceFFMepgDecoder();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "func init, use [FFMepgDecoder]");
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder.a(paramInt);
    }
  }
  
  public void a(MagicfaceDecoder.MagicPlayListener paramMagicPlayListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder.a(paramMagicPlayListener);
    }
  }
  
  public void a(MagicfaceDecoder.MagicfaceRenderListener paramMagicfaceRenderListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener = paramMagicfaceRenderListener;
  }
  
  public void a(MagicfacePlayRes paramMagicfacePlayRes)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData != null) && (paramMagicfacePlayRes.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData.jdField_a_of_type_JavaLangString))) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder.d();
      return;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData = this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader.a(paramMagicfacePlayRes.jdField_a_of_type_JavaLangString, paramMagicfacePlayRes.b);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData.jdField_a_of_type_JavaLangString = paramMagicfacePlayRes.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData.b = paramMagicfacePlayRes.b;
    }
  }
  
  public void a(MagicfaceResLoader paramMagicfaceResLoader)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader = paramMagicfaceResLoader;
  }
  
  public void a(SoundPoolUtil paramSoundPoolUtil)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil = paramSoundPoolUtil;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader.b(paramString));
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader.b(paramString), paramInt);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder.e();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.service.MagicfacePlayManager
 * JD-Core Version:    0.7.0.1
 */