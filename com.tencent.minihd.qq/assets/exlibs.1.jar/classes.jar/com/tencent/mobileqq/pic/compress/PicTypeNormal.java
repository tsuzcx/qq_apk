package com.tencent.mobileqq.pic.compress;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;

public class PicTypeNormal
  extends PicType
{
  PicTypeNormal(CompressInfo paramCompressInfo)
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
      return 0;
    }
    return 2;
  }
  
  protected final int[] a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.g == 2) {
      return null;
    }
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = PicType.i;
    arrayOfInt[1] = (arrayOfInt[0] * 2);
    return arrayOfInt;
  }
  
  protected boolean d()
  {
    float f = 1.0F;
    int n = 0;
    int i1;
    int i;
    Bitmap localBitmap;
    int j;
    Matrix localMatrix;
    int m;
    if (this.n == 0)
    {
      Object localObject1 = a();
      if (localObject1 == null)
      {
        Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " largerSide is null");
        return false;
      }
      i1 = localObject1[0];
      i = localObject1[1];
      this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.g);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e))
      {
        Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " destPath is empty");
        return false;
      }
      if (FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e))
      {
        Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " destPath exist. return true");
        return true;
      }
      localObject1 = new BitmapFactory.Options();
      if (!Utils.a((BitmapFactory.Options)localObject1, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, i, i1))
      {
        Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " calculateInSampleSize fail");
        return false;
      }
      try
      {
        localBitmap = BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, (BitmapFactory.Options)localObject1);
        if (localBitmap == null)
        {
          Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " bm == null, maybe is broken");
          return false;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(true);
        localOutOfMemoryError1.printStackTrace();
        Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " decodeFile oom, execute commonCompress()");
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e = "";
        return c();
      }
      i = localBitmap.getWidth();
      j = localBitmap.getHeight();
      localMatrix = new Matrix();
      if (i > j)
      {
        k = i;
        m = j;
        if (k <= i1) {
          break label693;
        }
        f = i1 / (1.0F * k);
        m = (int)(m * f);
        k = (int)(k * f);
      }
    }
    label554:
    label693:
    for (int k = 1;; k = 0)
    {
      for (;;)
      {
        if (i > j) {}
        i1 = ImageUtil.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c);
        m = n;
        if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.d)
        {
          m = n;
          if (i1 != 0)
          {
            m = n;
            if (i1 % 90 == 0)
            {
              localMatrix.postRotate(i1, i >> 1, j >> 1);
              m = 1;
            }
          }
        }
        if (k != 0) {
          localMatrix.postScale(f, f);
        }
        Object localObject2;
        if (m == 0)
        {
          localObject2 = localBitmap;
          if (k == 0) {
            break label554;
          }
        }
        try
        {
          localObject2 = Bitmap.createBitmap(localBitmap, 0, 0, i, j, localMatrix, true);
          boolean bool = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e, (Bitmap)localObject2, a(), this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
          if (localObject2 != null) {
            ((Bitmap)localObject2).recycle();
          }
          return bool;
          k = j;
          m = i;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          for (;;)
          {
            Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " scale or rotate createBitmap OutOfMemoryError");
            Object localObject3 = localBitmap;
          }
        }
        catch (NullPointerException localNullPointerException)
        {
          for (;;)
          {
            Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " scale or rotate createBitmap NullPointerException");
            Object localObject4 = localBitmap;
          }
        }
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.PicTypeNormal
 * JD-Core Version:    0.7.0.1
 */