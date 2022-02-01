package com.tencent.mobileqq.pic.compress;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.utils.FileUtils;

public class PicTypeLong
  extends PicType
{
  PicTypeLong(CompressInfo paramCompressInfo)
  {
    super(paramCompressInfo);
  }
  
  protected int a(CompressInfo paramCompressInfo)
  {
    switch (paramCompressInfo.g)
    {
    default: 
      return -1;
    case 0: 
    case 1: 
      return 1;
    }
    return 2;
  }
  
  protected boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.n == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.g);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e)) {
        break label87;
      }
      Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " destPath is empty");
      bool1 = bool2;
    }
    label87:
    do
    {
      return bool1;
      if (FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e))
      {
        Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " destPath exist. return true");
        return true;
      }
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c);
        if (localBitmap == null)
        {
          Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " bm == null, maybe is broken");
          return false;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(true);
        Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " decodeFile oom, execute commonCompress()");
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e = "";
        return c();
      }
      bool2 = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e, localOutOfMemoryError, a(), this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
      bool1 = bool2;
    } while (localOutOfMemoryError == null);
    localOutOfMemoryError.recycle();
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.PicTypeLong
 * JD-Core Version:    0.7.0.1
 */