package com.tencent.mobileqq.pic.compress;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public abstract class PicType
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 2;
  public static int e = 80;
  public static int f = 0;
  public static int g = 70;
  public static final int h = 2560;
  public static int i = 960;
  public static final int j = -1;
  public static final int k = 0;
  public static final int l = 1;
  public static final int m = 2;
  CompressInfo a;
  protected String a;
  protected int n;
  
  static
  {
    jdField_f_of_type_Int = 70;
  }
  
  PicType(CompressInfo paramCompressInfo)
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    if ((paramCompressInfo == null) || (TextUtils.isEmpty(paramCompressInfo.c))) {
      throw new IllegalArgumentException("info == null || TextUtils.isEmpty(info.srcPath)");
    }
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo = paramCompressInfo;
    int i1 = a(paramCompressInfo);
    this.n = i1;
    if (i1 == -1) {
      throw new IllegalArgumentException("create PicQuality is Fail");
    }
  }
  
  private int a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i1 = 1;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!FileUtils.b(paramString1))) {
      Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " sampleCompress()", " infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:" + paramString1 + " outfilePath:" + paramString2);
    }
    BitmapFactory.Options localOptions;
    do
    {
      return 0;
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = false;
      localOptions.inSampleSize = 2;
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      try
      {
        Bitmap localBitmap3 = BitmapFactory.decodeFile(paramString1, localOptions);
        Bitmap localBitmap1 = localBitmap3;
        if (localBitmap3 != null) {
          break;
        }
        Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " sampleCompress()", " bm == null, maybe is broken");
        return 0;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(true);
        Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " sampleCompress()", " decodeFile OutOfMemoryError, sampleCnt:" + 1 + " oomKeepCompress:" + paramBoolean);
      }
    } while (!paramBoolean);
    localOptions.inSampleSize = 4;
    for (;;)
    {
      try
      {
        Bitmap localBitmap2 = BitmapFactory.decodeFile(paramString1, localOptions);
        i1 = 2;
        paramBoolean = Utils.a(paramString2, localBitmap2, a(), this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
        if (localBitmap2 != null) {
          localBitmap2.recycle();
        }
        if (paramBoolean) {
          return i1;
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(false);
        paramString1.printStackTrace();
        Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " sampleCompress()", " oomKeepCompress decodeFile OutOfMemoryError, sampleCnt:" + 2);
        return 0;
      }
      i1 = 0;
    }
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.g == 2) {
      return 100;
    }
    switch (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.h)
    {
    case 2: 
    case 3: 
    default: 
      return jdField_f_of_type_Int;
    case 1: 
      return e;
    }
    return g;
  }
  
  protected abstract int a(CompressInfo paramCompressInfo);
  
  final boolean a()
  {
    if (this.n == 2) {
      return c();
    }
    return d();
  }
  
  final int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.h == 1) {
      return 20971520;
    }
    return 4194304;
  }
  
  final boolean b()
  {
    bool1 = false;
    bool2 = false;
    if (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c)) {
      Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " startThumbnail()", " src file does not exist");
    }
    label241:
    do
    {
      return bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c);
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString))
        {
          Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " startThumbnail()", " destPath is empty");
          return false;
        }
      }
      if ((FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_Boolean))
      {
        Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " startThumbnail()", " destPath exist. return true");
        return true;
      }
      if ((!Utils.b()) || (!ImageUtil.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c))) {
        break label353;
      }
      try
      {
        bool2 = Utils.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.d, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
        bool1 = bool2;
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("peak_pgjpeg", 2, "PicType.startThumbnail() error", localRuntimeException);
          }
          try
          {
            bool2 = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.d, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
            bool1 = bool2;
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
          }
          continue;
          try
          {
            bool2 = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.d, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
            bool1 = bool2;
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
      }
      catch (Exception localException3)
      {
        break label241;
      }
      bool2 = bool1;
    } while (bool1);
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
    Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " startThumbnail()", " compressAIOThumbnail is failed");
    return bool1;
  }
  
  final boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.g == 2) {
      if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c) <= 20971520L)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c;
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress() 直接传原图，UI上选择了原图");
        Logger.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", "直接传原图，UI上选择了原图");
        if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_Int != 2) {
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_Boolean = true;
        }
      }
    }
    for (;;)
    {
      return true;
      Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", "直接传原图，UI上选择了原图，该图片 > 最大文件限制");
      continue;
      int i1 = b();
      if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c) > i1)
      {
        Logger.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " src file size > max, file size:" + Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c) + " max:" + i1);
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.g);
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString))
        {
          Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " destPath is empty");
          return false;
        }
        if (FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString))
        {
          Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " destPath exist. return true");
          return true;
        }
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.i = 0;
        int i2 = a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString, true);
        if (i2 != 0)
        {
          Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
          ((CompressInfo)localObject1).i = (i2 + ((CompressInfo)localObject1).i);
          if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString) > i1)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.i >= 2)
            {
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(false);
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress() 面积是原来的1/16，不能再小了fileSize:" + Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString) + " max:" + i1);
              Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " 面积是原来的1/16，不能再小了fileSize:" + Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString) + " max:" + i1);
              FileUtils.d(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString);
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
              return false;
            }
            Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString;
            localObject1 = (String)localObject2 + "_second";
            this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
            i2 = a((String)localObject2, (String)localObject1, false);
            FileUtils.d((String)localObject2);
            if (i2 != 0)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
              ((CompressInfo)localObject2).i = (i2 + ((CompressInfo)localObject2).i);
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = ((String)localObject1);
              if (Utils.a((String)localObject1) > i1)
              {
                this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(false);
                this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress() 已经2次sample压缩，长、宽各是原来的1/4；面积是原来的1/16。fileSize:" + Utils.a((String)localObject1) + " max:" + i1);
                Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " 已经2次sample压缩，长、宽各是原来的1/4；面积是原来的1/16。fileSize:" + Utils.a((String)localObject1) + " max:" + i1);
                FileUtils.d(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString);
                this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
                return false;
              }
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress() 第二次压缩失败");
              Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " 第二次压缩失败");
              return false;
            }
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress() sampleCompress failed");
          Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " sampleCompress failed");
          return false;
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c;
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress() 直接传原图");
        Logger.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", "直接传原图");
        if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_Int != 2) {
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_Boolean = true;
        }
      }
    }
  }
  
  protected abstract boolean d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.PicType
 * JD-Core Version:    0.7.0.1
 */