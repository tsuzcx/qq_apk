package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.qphone.base.util.QLog;
import jea;

public class MagicFaceSuperBigDecoder
  extends MagicfaceFFMepgDecoder
{
  public static final String a;
  private Runnable a;
  
  static
  {
    jdField_a_of_type_JavaLangString = MagicFaceSuperBigDecoder.class.getSimpleName();
  }
  
  public MagicFaceSuperBigDecoder()
  {
    this.jdField_a_of_type_JavaLangRunnable = new jea(this);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func MagicFaceSuperBigDecoder [Constructor] begins");
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil = new DecoderUtil();
    int i = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createVideoDecoder();
    int j = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createAlphaDecoder();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func MagicFaceSuperBigDecoder [Constructor] ends, videoRet:" + i + ",alphaRet:" + j);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func maigcfaceDecoder begins");
    }
    this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData.b;
    if (this.jdField_a_of_type_ArrayOfByte == null) {}
    do
    {
      do
      {
        return;
        this.d = this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData.jdField_a_of_type_ArrayOfByte;
      } while (this.d == null);
      b();
      this.jdField_a_of_type_JavaLangRunnable.run();
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "func maigcfaceDecoder ends");
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func initXbig begins");
    }
    try
    {
      this.c = new byte[817920];
      this.f = new byte[817920];
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func initXbig ends");
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func release begins.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil = null;
    super.c();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func release ends.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicFaceSuperBigDecoder
 * JD-Core Version:    0.7.0.1
 */