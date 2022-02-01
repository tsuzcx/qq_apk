package com.tencent.mobileqq.pic.compress;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.text.TextUtils;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.JpegCompressor;
import com.tencent.mobileqq.pic.JpegDecompressor;
import com.tencent.mobileqq.pic.JpegOptions;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import jmh;
import jmi;

public class Utils
{
  public static final int a = 20971520;
  private static final String a = "compress.Utils";
  
  public static long a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!FileUtils.b(paramString)))
    {
      Logger.b("compress.Utils", "getFileSize()", "path is empty, or file does not exist. path:" + paramString);
      return 0L;
    }
    return new File(paramString).length();
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return paramBitmap;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawColor(-1);
      Paint localPaint = new Paint();
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
      localPaint.setXfermode(null);
      paramBitmap.recycle();
      paramBitmap = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
    Logger.a("compress.Utils", "compositingWhiteBg()", "compositingWhiteBg is success");
    return paramBitmap;
  }
  
  public static String a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (FileUtils.a(paramString)))
    {
      String str2 = AppConstants.aG + "thumb/";
      if (paramString.startsWith(str2)) {
        return paramString;
      }
      int i = paramString.lastIndexOf("/");
      int j = paramString.lastIndexOf(".");
      String str1;
      if (j <= 0) {
        str1 = paramString.substring(i + 1);
      }
      for (;;)
      {
        long l = new File(paramString).lastModified();
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(str2);
        localStringBuffer.append("_").append(paramString.hashCode());
        localStringBuffer.append("_").append(str1);
        localStringBuffer.append("_").append(l);
        localStringBuffer.append(".jpg");
        paramString = new File(str2);
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        return localStringBuffer.toString();
        if (i < j + 1) {
          str1 = paramString.substring(i + 1, j);
        } else {
          str1 = paramString.substring(i + 1);
        }
      }
    }
    Logger.a("compress.Utils", "getThumbnailPath()", "realpath is empty, or file does not exist, realpath:" + paramString);
    return "";
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (FileUtils.a(paramString)) && (PicQuality.a(paramInt)))
    {
      int i = paramString.lastIndexOf("/");
      int j = paramString.lastIndexOf(".");
      Object localObject;
      String str;
      StringBuffer localStringBuffer;
      if ((j <= 0) || (j <= i))
      {
        localObject = paramString.substring(i + 1);
        long l = new File(paramString).lastModified();
        str = AppConstants.aG + "photo/";
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(str);
        localStringBuffer.append("_").append(paramString.hashCode());
        localStringBuffer.append("_").append((String)localObject);
        localStringBuffer.append("_").append(l);
        localObject = localStringBuffer.append("_");
        if (!a()) {
          break label233;
        }
      }
      label233:
      for (paramString = "wifi";; paramString = "xg")
      {
        ((StringBuffer)localObject).append(paramString);
        localStringBuffer.append("_").append(paramInt);
        localStringBuffer.append(".jpg");
        paramString = new File(str);
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        return localStringBuffer.toString();
        localObject = paramString.substring(i + 1, j);
        break;
      }
    }
    Logger.a("compress.Utils", "getSendPhotoPath()", "realpath is empty, or file does not exist, or picQuality Illegal realpath:" + paramString + " picQuality:" + paramInt);
    return "";
  }
  
  private static jmi a(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 1;
    int k = URLDrawableHelper.j;
    int m = URLDrawableHelper.i;
    if (paramInt1 > k) {
      if (a(paramInt1, paramInt2))
      {
        paramInt2 = 1;
        paramInt1 = j;
      }
    }
    for (;;)
    {
      jmi localjmi = new jmi(null);
      localjmi.a = paramInt2;
      localjmi.b = paramInt1;
      Logger.a("compress.Utils", "getType()", " type=" + localjmi);
      return localjmi;
      paramInt1 = 2;
      paramInt2 = 2;
      continue;
      if ((paramInt1 <= k) && (paramInt1 > m))
      {
        if (paramInt2 > k)
        {
          if (a(paramInt1, paramInt2))
          {
            paramInt2 = 1;
            paramInt1 = 3;
            continue;
          }
          paramInt1 = 4;
          paramInt2 = 2;
          continue;
        }
        if ((paramInt2 <= k) && (paramInt2 > m))
        {
          paramInt1 = 5;
          paramInt2 = 3;
        }
      }
      else if ((paramInt1 <= m) && (paramInt1 > 0))
      {
        if (paramInt2 > k)
        {
          paramInt1 = 6;
          paramInt2 = 4;
          continue;
        }
        if ((paramInt2 <= k) && (paramInt2 > m))
        {
          if (a(paramInt1, paramInt2))
          {
            paramInt1 = 7;
            paramInt2 = 4;
            continue;
          }
          paramInt1 = 8;
          paramInt2 = 3;
          continue;
        }
        if ((paramInt2 <= m) && (paramInt2 > 0))
        {
          if (a(paramInt1, paramInt2))
          {
            paramInt1 = 9;
            paramInt2 = 4;
            continue;
          }
          paramInt1 = 10;
          paramInt2 = 3;
          continue;
        }
      }
      paramInt1 = 0;
      paramInt2 = i;
    }
  }
  
  public static void a(Context paramContext, List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    int n;
    int m;
    int j;
    Object localObject1;
    String str2;
    String str3;
    String str4;
    String str5;
    int i1;
    int i;
    String str1;
    String str6;
    String str7;
    Object localObject3;
    Object localObject2;
    Object localObject4;
    Object localObject5;
    int k;
    if (paramList.size() > 1)
    {
      n = 1;
      m = 0;
      j = 0;
      localObject1 = "";
      str2 = BaseApplication.getContext().getString(2131369189);
      str3 = BaseApplication.getContext().getString(2131369190);
      str4 = BaseApplication.getContext().getString(2131369191);
      str5 = BaseApplication.getContext().getString(2131369192);
      i1 = 0;
      i = 0;
      str1 = "";
      str6 = BaseApplication.getContext().getString(2131369193);
      str7 = BaseApplication.getContext().getString(2131369194);
      localObject3 = BaseApplication.getContext().getString(2131369195);
      localObject2 = BaseApplication.getContext().getString(2131369196);
      localObject4 = paramList.iterator();
      for (;;)
      {
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (CompressInfo)((Iterator)localObject4).next();
          if ((localObject5 != null) && (((CompressInfo)localObject5).c)) {
            if (n != 0)
            {
              k = 1;
              localObject3 = localObject2;
            }
          }
        }
      }
    }
    for (;;)
    {
      label187:
      localObject4 = str1;
      localObject2 = localObject1;
      if (k == 0)
      {
        localObject5 = paramList.iterator();
        paramList = str1;
        label211:
        localObject4 = paramList;
        i1 = i;
        localObject2 = localObject1;
        m = j;
        if (((Iterator)localObject5).hasNext())
        {
          localObject2 = (CompressInfo)((Iterator)localObject5).next();
          if ((localObject2 == null) || (((CompressInfo)localObject2).e) || (!((CompressInfo)localObject2).jdField_b_of_type_Boolean)) {
            break label435;
          }
          i1 = 1;
          j = 1;
          if (!str4.equals(((CompressInfo)localObject2).jdField_b_of_type_JavaLangString)) {
            break label381;
          }
          localObject4 = paramList;
          i1 = i;
          localObject2 = localObject1;
          m = j;
          if (!str4.equals(localObject1))
          {
            if (n == 0) {
              break label365;
            }
            localObject2 = str5;
            m = j;
            i1 = i;
            localObject4 = paramList;
          }
        }
      }
      for (;;)
      {
        if (k == 0) {
          break label493;
        }
        QQToast.a(paramContext, (CharSequence)localObject3, 0).b(paramContext.getResources().getDimensionPixelSize(2131492923));
        return;
        n = 0;
        break;
        k = 1;
        break label187;
        label365:
        localObject2 = str4;
        localObject4 = paramList;
        i1 = i;
        m = j;
      }
      label381:
      m = i1;
      if (str2.equals(((CompressInfo)localObject2).jdField_b_of_type_JavaLangString))
      {
        m = i1;
        if (!str2.equals(localObject1)) {
          if (n != 0)
          {
            j = 1;
            localObject1 = str3;
          }
        }
      }
      for (;;)
      {
        break label211;
        j = 1;
        localObject1 = str2;
        continue;
        label435:
        m = j;
        if (localObject2 != null)
        {
          m = j;
          if (((CompressInfo)localObject2).e)
          {
            m = j;
            if (((CompressInfo)localObject2).jdField_b_of_type_Boolean)
            {
              m = j;
              if (i == 0)
              {
                if (n != 0)
                {
                  i = 1;
                  paramList = str7;
                  continue;
                }
                i = 1;
                paramList = str6;
                continue;
                label493:
                if (m != 0)
                {
                  QQToast.a(paramContext, (CharSequence)localObject2, 0).b(paramContext.getResources().getDimensionPixelSize(2131492923));
                  return;
                }
                if (i1 == 0) {
                  break;
                }
                QQToast.a(paramContext, (CharSequence)localObject4, 0).b(paramContext.getResources().getDimensionPixelSize(2131492923));
                return;
              }
            }
          }
        }
        j = m;
      }
      localObject3 = "";
      k = 0;
    }
  }
  
  public static boolean a()
  {
    return NetworkUtil.b(BaseApplication.getContext()) == 1;
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return paramInt2 > paramInt1 * 3;
  }
  
  private static boolean a(BitmapFactory.Options paramOptions, int paramInt)
  {
    if (paramOptions == null)
    {
      Logger.b("compress.Utils", "calculateInSampleSizeThumbnail()", "options is null");
      return false;
    }
    int m = paramOptions.outWidth;
    int n = paramOptions.outHeight;
    if ((m == 0) || (n == 0))
    {
      Logger.b("compress.Utils", "calculateInSampleSizeThumbnail()", "width == 0 || height ==0");
      return false;
    }
    int j = n;
    int k = m;
    int i = 1;
    k >>= 1;
    j >>= 1;
    if ((k < paramInt) || (j < paramInt))
    {
      paramOptions.inSampleSize = i;
      paramOptions.inJustDecodeBounds = false;
      if (paramOptions.inSampleSize < 1) {
        break label172;
      }
    }
    label172:
    for (paramInt = paramOptions.inSampleSize;; paramInt = 1)
    {
      paramOptions.inSampleSize = paramInt;
      Logger.a("compress.Utils", "calculateInSampleSizeThumbnail()", "options.inSampleSize=" + paramOptions.inSampleSize + " srcWidth:" + m + " srcHeight:" + n);
      return true;
      i *= 2;
      break;
    }
  }
  
  public static boolean a(BitmapFactory.Options paramOptions, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramOptions == null) || (TextUtils.isEmpty(paramString)))
    {
      Logger.b("compress.Utils", "calculateInSampleSize()", "options == null || TextUtils.isEmpty(filepath)");
      return false;
    }
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 < paramInt2)) {
      throw new IllegalArgumentException("max < 0 || min < 0 || max < min");
    }
    if (paramInt2 > paramInt1 / 2) {
      throw new IllegalArgumentException("min > max / 2");
    }
    paramOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, paramOptions);
    int i = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    if (j > i)
    {
      i = j;
      if (i > paramInt1)
      {
        j = 1;
        int k;
        int m;
        do
        {
          do
          {
            k = i >> 1;
            m = j * 2;
            i = k;
            j = m;
          } while (k < paramInt2);
          i = k;
          j = m;
        } while (k > paramInt1);
        paramOptions.inSampleSize = m;
      }
      paramOptions.inJustDecodeBounds = false;
      if (paramOptions.inSampleSize < 1) {
        break label214;
      }
    }
    label214:
    for (paramInt1 = paramOptions.inSampleSize;; paramInt1 = 1)
    {
      paramOptions.inSampleSize = paramInt1;
      Logger.a("compress.Utils", "calculateInSampleSize()", "options.inSampleSize=" + paramOptions.inSampleSize);
      return true;
      break;
    }
  }
  
  private static boolean a(JpegOptions paramJpegOptions, int paramInt)
  {
    if (paramJpegOptions == null)
    {
      Logger.b("compress.Utils", "calculateInSampleSizeThumbnail()", "options is null");
      return false;
    }
    int m = paramJpegOptions.outWidth;
    int n = paramJpegOptions.outHeight;
    if ((m == 0) || (n == 0))
    {
      Logger.b("compress.Utils", "calculateInSampleSizeThumbnail()", "width == 0 || height ==0");
      return false;
    }
    int j = n;
    int k = m;
    int i = 1;
    k >>= 1;
    j >>= 1;
    if ((k < paramInt) || (j < paramInt))
    {
      paramJpegOptions.inSampleSize = i;
      paramJpegOptions.inJustDecodeBounds = false;
      if (paramJpegOptions.inSampleSize < 1) {
        break label172;
      }
    }
    label172:
    for (paramInt = paramJpegOptions.inSampleSize;; paramInt = 1)
    {
      paramJpegOptions.inSampleSize = paramInt;
      Logger.a("compress.Utils", "calculateInSampleSizeThumbnail()", "options.inSampleSize=" + paramJpegOptions.inSampleSize + " srcWidth:" + m + " srcHeight:" + n);
      return true;
      i *= 2;
      break;
    }
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      boolean bool = GifDrawable.isGifFile(new File(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "isGifFile result:" + bool);
      }
      return bool;
    }
    return false;
  }
  
  public static boolean a(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2, CompressInfo paramCompressInfo)
  {
    if (c()) {
      return b(paramString1, paramBitmap, paramInt, paramString2, paramCompressInfo);
    }
    return c(paramString1, paramBitmap, paramInt, paramString2, paramCompressInfo);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    return ImageUtil.b(paramString1, paramString2);
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!FileUtils.b(paramString1)))
    {
      Logger.b("compress.Utils", "compressAIOThumbnail", paramString3 + " infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:" + paramString1 + " outfilePath:" + paramString2);
      paramBoolean = false;
      label65:
      return paramBoolean;
    }
    Logger.a("compress.Utils", "compressAIOThumbnail", paramString3);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString1, localOptions);
    int j;
    if (localOptions.outWidth > localOptions.outHeight) {
      j = localOptions.outWidth;
    }
    jmi localjmi;
    for (int i = localOptions.outHeight;; i = localOptions.outWidth)
    {
      localjmi = a(i, j);
      if (a(localOptions, URLDrawableHelper.j)) {
        break;
      }
      Logger.b("compress.Utils", "compressAIOThumbnail", paramString3 + " calculateInSampleSize fail");
      return false;
      j = localOptions.outHeight;
    }
    Object localObject3;
    try
    {
      localObject3 = BitmapFactory.decodeFile(paramString1, localOptions);
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        Logger.b("compress.Utils", "compressAIOThumbnail", paramString3 + " bm == null, maybe is broken");
        return false;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      Logger.b("compress.Utils", "compressAIOThumbnail", paramString3 + " decodeFile OutOfMemoryError");
      localOptions.inSampleSize *= 2;
    }
    for (;;)
    {
      Object localObject2;
      int k;
      int m;
      int n;
      int i4;
      int i2;
      boolean bool1;
      try
      {
        localObject2 = BitmapFactory.decodeFile(paramString1, localOptions);
        k = ((Bitmap)localObject2).getWidth();
        j = ((Bitmap)localObject2).getHeight();
        Logger.a("compress.Utils", "compressAIOThumbnail", paramString3 + " sample after W:" + k + " H:" + j);
        switch (localjmi.b)
        {
        case 2: 
        case 4: 
        case 5: 
        default: 
          i = j;
          m = k;
          n = k;
          k = i;
          i = j;
          j = n;
          localObject3 = new Matrix();
          i4 = ImageUtil.b(paramString1);
          if ((!paramBoolean) || (i4 == 0) || (i4 % 90 != 0)) {
            break label1930;
          }
          bool2 = true;
          Logger.a("compress.Utils", "compressAIOThumbnail", paramString3 + " sample after W:" + j + " H:" + i + " isLongImg:" + a(0, 0) + " type:" + localjmi + " needRotate:" + bool2);
          if (m <= k) {
            break label961;
          }
          i3 = m;
          i1 = k;
          n = URLDrawableHelper.j;
          i2 = URLDrawableHelper.i;
          switch (localjmi.a)
          {
          default: 
            bool1 = false;
            paramString1 = (String)localObject2;
            paramBoolean = false;
            Logger.a("compress.Utils", "compressAIOThumbnail", paramString3 + " destWidth：" + m + " destHeight:" + k + " needCut:" + bool1 + " needScale:" + paramBoolean + " needRotate:" + bool2);
            paramString1 = a(paramString1);
            bool1 = c(paramString2, paramString1, 70, paramString3, null);
            paramBoolean = bool1;
            if (paramString1 == null) {
              break label65;
            }
            paramString1.recycle();
            return bool1;
          }
          break;
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        paramString1.printStackTrace();
        Logger.b("compress.Utils", "compressAIOThumbnail", paramString3 + " decodeFile OutOfMemoryError, op.inSampleSize:" + localOptions.inSampleSize);
        return false;
      }
      Logger.a("compress.Utils", "compressAIOThumbnail", paramString3 + " type.type2:136");
      if (k > j)
      {
        i = j;
        label792:
        m = i * 3;
        if (k <= j) {
          break label900;
        }
        j = m;
      }
      for (;;)
      {
        for (;;)
        {
          k = j;
          try
          {
            if (j > ((Bitmap)localObject2).getWidth()) {
              k = ((Bitmap)localObject2).getWidth();
            }
            j = i;
            if (i > ((Bitmap)localObject2).getHeight()) {
              j = ((Bitmap)localObject2).getHeight();
            }
            localObject3 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, k, j);
            j = ((Bitmap)localObject3).getWidth();
            i = ((Bitmap)localObject3).getHeight();
            k = i;
            m = j;
            localObject2 = localObject3;
          }
          catch (OutOfMemoryError paramString1)
          {
            label900:
            if (localObject2 == null) {
              break label922;
            }
            ((Bitmap)localObject2).recycle();
            paramString1.printStackTrace();
            Logger.b("compress.Utils", "compressAIOThumbnail", paramString3 + " cut 3:1 createBitmap OutOfMemoryError, type:" + localjmi);
            return false;
          }
        }
        i = k;
        break label792;
        j = i;
        i = m;
      }
      label922:
      label961:
      int i3 = k;
      int i1 = m;
      continue;
      float f = i2 / (i1 * 1.0F);
      i1 = (int)(i3 * f);
      if (bool2) {
        ((Matrix)localObject3).postRotate(i4, j >> 1, i >> 1);
      }
      ((Matrix)localObject3).postScale(f, f);
      i1 = j;
      for (;;)
      {
        for (;;)
        {
          try
          {
            if (j > ((Bitmap)localObject2).getWidth()) {
              i1 = ((Bitmap)localObject2).getWidth();
            }
            j = i;
            if (i > ((Bitmap)localObject2).getHeight()) {
              j = ((Bitmap)localObject2).getHeight();
            }
            localObject3 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, i1, j, (Matrix)localObject3, true);
            if (m > k)
            {
              j = i2;
              i = n;
            }
          }
          catch (OutOfMemoryError paramString1)
          {
            try
            {
              if (i4 / 90 % 2 == 0) {
                break label1915;
              }
              m = j;
              if (j > ((Bitmap)localObject3).getWidth()) {
                m = ((Bitmap)localObject3).getWidth();
              }
              k = i;
              if (i > ((Bitmap)localObject3).getHeight()) {
                k = ((Bitmap)localObject3).getHeight();
              }
              paramString1 = Bitmap.createBitmap((Bitmap)localObject3, 0, 0, m, k);
              bool1 = true;
              paramBoolean = true;
            }
            catch (OutOfMemoryError paramString1)
            {
              if (localObject3 == null) {
                break label1243;
              }
              ((Bitmap)localObject3).recycle();
              paramString1.printStackTrace();
              Logger.b("compress.Utils", "compressAIOThumbnail", paramString3 + " case 1: cut createBitmap OutOfMemoryError, type:" + localjmi);
              return false;
            }
            paramString1 = paramString1;
            if (localObject2 != null) {
              ((Bitmap)localObject2).recycle();
            }
            paramString1.printStackTrace();
            Logger.b("compress.Utils", "compressAIOThumbnail", paramString3 + " case 1: scale or rotate createBitmap OutOfMemoryError, type:" + localjmi);
            return false;
          }
          j = n;
          i = i2;
          continue;
          label1243:
          f = n / (i3 * 1.0F);
          i1 = (int)(i1 * f);
          if (m > k) {
            k = i1;
          }
          for (m = n;; m = i1)
          {
            for (;;)
            {
              if (bool2) {
                ((Matrix)localObject3).postRotate(i4, j >> 1, i >> 1);
              }
              ((Matrix)localObject3).postScale(f, f);
              n = j;
              try
              {
                if (j > ((Bitmap)localObject2).getWidth()) {
                  n = ((Bitmap)localObject2).getWidth();
                }
                j = i;
                if (i > ((Bitmap)localObject2).getHeight()) {
                  j = ((Bitmap)localObject2).getHeight();
                }
                paramString1 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, n, j, (Matrix)localObject3, true);
                bool1 = false;
                paramBoolean = true;
              }
              catch (OutOfMemoryError paramString1)
              {
                if (localObject2 == null) {
                  break label1438;
                }
                ((Bitmap)localObject2).recycle();
                paramString1.printStackTrace();
                Logger.b("compress.Utils", "compressAIOThumbnail", paramString3 + " case 2: scale or rotate createBitmap OutOfMemoryError, type:" + localjmi);
                return false;
              }
            }
            k = n;
          }
          label1438:
          if (!bool2) {
            break;
          }
          ((Matrix)localObject3).postRotate(i4, j >> 1, i >> 1);
          n = j;
          try
          {
            if (j > ((Bitmap)localObject2).getWidth()) {
              n = ((Bitmap)localObject2).getWidth();
            }
            j = i;
            if (i > ((Bitmap)localObject2).getHeight()) {
              j = ((Bitmap)localObject2).getHeight();
            }
            paramString1 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, n, j, (Matrix)localObject3, true);
            bool1 = false;
            paramBoolean = false;
          }
          catch (OutOfMemoryError paramString1)
          {
            if (localObject2 != null) {
              ((Bitmap)localObject2).recycle();
            }
            paramString1.printStackTrace();
            Logger.b("compress.Utils", "compressAIOThumbnail", paramString3 + " case 3: rotate createBitmap OutOfMemoryError, type:" + localjmi);
            return false;
          }
        }
        if (bool2)
        {
          ((Matrix)localObject3).postRotate(i4, j >> 1, i >> 1);
          n = j;
        }
        for (;;)
        {
          try
          {
            if (j > ((Bitmap)localObject2).getWidth()) {
              n = ((Bitmap)localObject2).getWidth();
            }
            j = i;
            if (i > ((Bitmap)localObject2).getHeight()) {
              j = ((Bitmap)localObject2).getHeight();
            }
            paramString1 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, n, j, (Matrix)localObject3, true);
            j = i1 * 3;
            if (m > k)
            {
              i = j;
              j = i1;
            }
          }
          catch (OutOfMemoryError paramString1)
          {
            try
            {
              if (i4 / 90 % 2 == 0) {
                break label1894;
              }
              m = j;
              if (j > paramString1.getWidth()) {
                m = paramString1.getWidth();
              }
              k = i;
              if (i > paramString1.getHeight()) {
                k = paramString1.getHeight();
              }
              localObject2 = Bitmap.createBitmap(paramString1, 0, 0, m, k);
              paramString1 = (String)localObject2;
              bool1 = true;
              paramBoolean = false;
            }
            catch (OutOfMemoryError paramString2)
            {
              if (paramString1 == null) {
                break label1855;
              }
              paramString1.recycle();
              paramString2.printStackTrace();
              Logger.b("compress.Utils", "compressAIOThumbnail", paramString3 + " case 4: cut createBitmap OutOfMemoryError, type:" + localjmi);
              return false;
            }
            paramString1 = paramString1;
            if (localObject2 != null) {
              ((Bitmap)localObject2).recycle();
            }
            paramString1.printStackTrace();
            Logger.b("compress.Utils", "compressAIOThumbnail", paramString3 + " case 4: rotate createBitmap OutOfMemoryError, type:" + localjmi);
            return false;
          }
          i = i1;
          continue;
          label1855:
          label1894:
          k = i;
          i = j;
          j = k;
          continue;
          paramString1 = (String)localObject2;
        }
        label1915:
        k = i;
        i = j;
        j = k;
      }
      label1930:
      boolean bool2 = false;
    }
  }
  
  public static boolean b()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.pg_switch.name(), "1|1");
    if (QLog.isDevelopLevel()) {
      QLog.d("peak_pgjpeg", 4, "DeviceProfileManager.DpcNames.pg_switch value " + (String)localObject);
    }
    localObject = ((String)localObject).split("\\|");
    if (localObject.length < 2) {
      return false;
    }
    return localObject[1].equals("1");
  }
  
  public static boolean b(String paramString)
  {
    boolean bool2 = false;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    int i = localOptions.outHeight;
    int j = localOptions.outWidth;
    if (QLog.isColorLevel()) {
      QLog.d("_photo", 2, "isLargeFile w:" + j + ",h:" + i);
    }
    boolean bool1 = bool2;
    if (i != -1)
    {
      bool1 = bool2;
      if (j != -1) {
        if (i <= j * 3)
        {
          bool1 = bool2;
          if (j <= i * 3) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static boolean b(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2, CompressInfo paramCompressInfo)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramBitmap == null) || (paramInt > 100) || (paramInt <= 0))
    {
      Logger.b("compress.Utils", "compressQualityWithProgressive()", paramString2 + " TextUtils.isEmpty(destPath) || bm == null || quality > 100 || quality <= 0");
      return false;
    }
    Logger.a("compress.Utils", "compressQualityWithProgressive()", paramString2 + " quality:" + paramInt);
    Object localObject = new File(paramString1);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    try
    {
      ((File)localObject).createNewFile();
      localObject = new JpegCompressor(new jmh((File)localObject, paramCompressInfo));
      ((JpegCompressor)localObject).setParams(paramInt, true, true, false);
      try
      {
        LogTag.a();
        ((JpegCompressor)localObject).compress(paramBitmap);
        LogTag.a("peak_pgjpeg", "pgjpeg " + paramBitmap.getWidth() + "x" + paramBitmap.getHeight() + " compress");
        Logger.a("compress.Utils", "compressQualityWithProgressive()", paramString2 + " quality:" + paramInt);
        return true;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("peak_pgjpeg", 2, "JpegCompressor.compress() error", localException);
        }
        return c(paramString1, paramBitmap, paramInt, paramString2, paramCompressInfo);
      }
      return false;
    }
    catch (FileNotFoundException paramString1)
    {
      Logger.b("compress.Utils", "compressQualityWithProgressive()", paramString2 + " FileOutputStream FileNotFoundException");
      paramString1.printStackTrace();
      return false;
    }
    catch (IOException paramString1)
    {
      Logger.b("compress.Utils", "compressQualityWithProgressive()", paramString2 + " createNewFile IOException");
      paramString1.printStackTrace();
    }
  }
  
  public static boolean b(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!FileUtils.b(paramString1)))
    {
      Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:" + paramString1 + " outfilePath:" + paramString2);
      paramBoolean = false;
      label65:
      return paramBoolean;
    }
    Logger.a("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3);
    JpegOptions localJpegOptions = new JpegOptions();
    localJpegOptions.inJustDecodeBounds = true;
    JpegDecompressor.decodeFile(paramString1, localJpegOptions);
    int j;
    if (localJpegOptions.outWidth > localJpegOptions.outHeight) {
      j = localJpegOptions.outWidth;
    }
    jmi localjmi;
    for (int i = localJpegOptions.outHeight;; i = localJpegOptions.outWidth)
    {
      localjmi = a(i, j);
      if (a(localJpegOptions, URLDrawableHelper.j)) {
        break;
      }
      Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " calculateInSampleSize fail");
      return false;
      j = localJpegOptions.outHeight;
    }
    Object localObject3;
    try
    {
      localObject3 = JpegDecompressor.decodeFile(paramString1, localJpegOptions);
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " bm == null, maybe is broken");
        return false;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " decodeFile OutOfMemoryError");
      localJpegOptions.inSampleSize *= 2;
    }
    for (;;)
    {
      Object localObject2;
      int k;
      int m;
      int n;
      int i4;
      int i2;
      boolean bool1;
      try
      {
        localObject2 = JpegDecompressor.decodeFile(paramString1, localJpegOptions);
        k = ((Bitmap)localObject2).getWidth();
        j = ((Bitmap)localObject2).getHeight();
        Logger.a("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " sample after W:" + k + " H:" + j);
        switch (localjmi.b)
        {
        case 2: 
        case 4: 
        case 5: 
        default: 
          i = j;
          m = k;
          n = k;
          k = i;
          i = j;
          j = n;
          localObject3 = new Matrix();
          i4 = ImageUtil.b(paramString1);
          if ((!paramBoolean) || (i4 == 0) || (i4 % 90 != 0)) {
            break label1930;
          }
          bool2 = true;
          Logger.a("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " sample after W:" + j + " H:" + i + " isLongImg:" + a(0, 0) + " type:" + localjmi + " needRotate:" + bool2);
          if (m <= k) {
            break label961;
          }
          i3 = m;
          i1 = k;
          n = URLDrawableHelper.j;
          i2 = URLDrawableHelper.i;
          switch (localjmi.a)
          {
          default: 
            bool1 = false;
            paramString1 = (String)localObject2;
            paramBoolean = false;
            Logger.a("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " destWidth：" + m + " destHeight:" + k + " needCut:" + bool1 + " needScale:" + paramBoolean + " needRotate:" + bool2);
            paramString1 = a(paramString1);
            bool1 = c(paramString2, paramString1, 70, paramString3, null);
            paramBoolean = bool1;
            if (paramString1 == null) {
              break label65;
            }
            paramString1.recycle();
            return bool1;
          }
          break;
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        paramString1.printStackTrace();
        Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " decodeFile OutOfMemoryError, op.inSampleSize:" + localJpegOptions.inSampleSize);
        return false;
      }
      Logger.a("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " type.type2:136");
      if (k > j)
      {
        i = j;
        label792:
        m = i * 3;
        if (k <= j) {
          break label900;
        }
        j = m;
      }
      for (;;)
      {
        for (;;)
        {
          k = j;
          try
          {
            if (j > ((Bitmap)localObject2).getWidth()) {
              k = ((Bitmap)localObject2).getWidth();
            }
            j = i;
            if (i > ((Bitmap)localObject2).getHeight()) {
              j = ((Bitmap)localObject2).getHeight();
            }
            localObject3 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, k, j);
            j = ((Bitmap)localObject3).getWidth();
            i = ((Bitmap)localObject3).getHeight();
            k = i;
            m = j;
            localObject2 = localObject3;
          }
          catch (OutOfMemoryError paramString1)
          {
            label900:
            if (localObject2 == null) {
              break label922;
            }
            ((Bitmap)localObject2).recycle();
            paramString1.printStackTrace();
            Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " cut 3:1 createBitmap OutOfMemoryError, type:" + localjmi);
            return false;
          }
        }
        i = k;
        break label792;
        j = i;
        i = m;
      }
      label922:
      label961:
      int i3 = k;
      int i1 = m;
      continue;
      float f = i2 / (i1 * 1.0F);
      i1 = (int)(i3 * f);
      if (bool2) {
        ((Matrix)localObject3).postRotate(i4, j >> 1, i >> 1);
      }
      ((Matrix)localObject3).postScale(f, f);
      i1 = j;
      for (;;)
      {
        for (;;)
        {
          try
          {
            if (j > ((Bitmap)localObject2).getWidth()) {
              i1 = ((Bitmap)localObject2).getWidth();
            }
            j = i;
            if (i > ((Bitmap)localObject2).getHeight()) {
              j = ((Bitmap)localObject2).getHeight();
            }
            localObject3 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, i1, j, (Matrix)localObject3, true);
            if (m > k)
            {
              j = i2;
              i = n;
            }
          }
          catch (OutOfMemoryError paramString1)
          {
            try
            {
              if (i4 / 90 % 2 == 0) {
                break label1915;
              }
              m = j;
              if (j > ((Bitmap)localObject3).getWidth()) {
                m = ((Bitmap)localObject3).getWidth();
              }
              k = i;
              if (i > ((Bitmap)localObject3).getHeight()) {
                k = ((Bitmap)localObject3).getHeight();
              }
              paramString1 = Bitmap.createBitmap((Bitmap)localObject3, 0, 0, m, k);
              bool1 = true;
              paramBoolean = true;
            }
            catch (OutOfMemoryError paramString1)
            {
              if (localObject3 == null) {
                break label1243;
              }
              ((Bitmap)localObject3).recycle();
              paramString1.printStackTrace();
              Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " case 1: cut createBitmap OutOfMemoryError, type:" + localjmi);
              return false;
            }
            paramString1 = paramString1;
            if (localObject2 != null) {
              ((Bitmap)localObject2).recycle();
            }
            paramString1.printStackTrace();
            Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " case 1: scale or rotate createBitmap OutOfMemoryError, type:" + localjmi);
            return false;
          }
          j = n;
          i = i2;
          continue;
          label1243:
          f = n / (i3 * 1.0F);
          i1 = (int)(i1 * f);
          if (m > k) {
            k = i1;
          }
          for (m = n;; m = i1)
          {
            for (;;)
            {
              if (bool2) {
                ((Matrix)localObject3).postRotate(i4, j >> 1, i >> 1);
              }
              ((Matrix)localObject3).postScale(f, f);
              n = j;
              try
              {
                if (j > ((Bitmap)localObject2).getWidth()) {
                  n = ((Bitmap)localObject2).getWidth();
                }
                j = i;
                if (i > ((Bitmap)localObject2).getHeight()) {
                  j = ((Bitmap)localObject2).getHeight();
                }
                paramString1 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, n, j, (Matrix)localObject3, true);
                bool1 = false;
                paramBoolean = true;
              }
              catch (OutOfMemoryError paramString1)
              {
                if (localObject2 == null) {
                  break label1438;
                }
                ((Bitmap)localObject2).recycle();
                paramString1.printStackTrace();
                Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " case 2: scale or rotate createBitmap OutOfMemoryError, type:" + localjmi);
                return false;
              }
            }
            k = n;
          }
          label1438:
          if (!bool2) {
            break;
          }
          ((Matrix)localObject3).postRotate(i4, j >> 1, i >> 1);
          n = j;
          try
          {
            if (j > ((Bitmap)localObject2).getWidth()) {
              n = ((Bitmap)localObject2).getWidth();
            }
            j = i;
            if (i > ((Bitmap)localObject2).getHeight()) {
              j = ((Bitmap)localObject2).getHeight();
            }
            paramString1 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, n, j, (Matrix)localObject3, true);
            bool1 = false;
            paramBoolean = false;
          }
          catch (OutOfMemoryError paramString1)
          {
            if (localObject2 != null) {
              ((Bitmap)localObject2).recycle();
            }
            paramString1.printStackTrace();
            Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " case 3: rotate createBitmap OutOfMemoryError, type:" + localjmi);
            return false;
          }
        }
        if (bool2)
        {
          ((Matrix)localObject3).postRotate(i4, j >> 1, i >> 1);
          n = j;
        }
        for (;;)
        {
          try
          {
            if (j > ((Bitmap)localObject2).getWidth()) {
              n = ((Bitmap)localObject2).getWidth();
            }
            j = i;
            if (i > ((Bitmap)localObject2).getHeight()) {
              j = ((Bitmap)localObject2).getHeight();
            }
            paramString1 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, n, j, (Matrix)localObject3, true);
            j = i1 * 3;
            if (m > k)
            {
              i = j;
              j = i1;
            }
          }
          catch (OutOfMemoryError paramString1)
          {
            try
            {
              if (i4 / 90 % 2 == 0) {
                break label1894;
              }
              m = j;
              if (j > paramString1.getWidth()) {
                m = paramString1.getWidth();
              }
              k = i;
              if (i > paramString1.getHeight()) {
                k = paramString1.getHeight();
              }
              localObject2 = Bitmap.createBitmap(paramString1, 0, 0, m, k);
              paramString1 = (String)localObject2;
              bool1 = true;
              paramBoolean = false;
            }
            catch (OutOfMemoryError paramString2)
            {
              if (paramString1 == null) {
                break label1855;
              }
              paramString1.recycle();
              paramString2.printStackTrace();
              Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " case 4: cut createBitmap OutOfMemoryError, type:" + localjmi);
              return false;
            }
            paramString1 = paramString1;
            if (localObject2 != null) {
              ((Bitmap)localObject2).recycle();
            }
            paramString1.printStackTrace();
            Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " case 4: rotate createBitmap OutOfMemoryError, type:" + localjmi);
            return false;
          }
          i = i1;
          continue;
          label1855:
          label1894:
          k = i;
          i = j;
          j = k;
          continue;
          paramString1 = (String)localObject2;
        }
        label1915:
        k = i;
        i = j;
        j = k;
      }
      label1930:
      boolean bool2 = false;
    }
  }
  
  public static boolean c()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.pg_switch.name(), "1|1");
    if (QLog.isDevelopLevel()) {
      QLog.d("peak_pgjpeg", 4, "DeviceProfileManager.DpcNames.pg_switch value " + (String)localObject);
    }
    localObject = ((String)localObject).split("\\|");
    if (localObject.length < 1) {
      return false;
    }
    return localObject[0].equals("1");
  }
  
  /* Error */
  private static boolean c(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2, CompressInfo paramCompressInfo)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: aload_0
    //   4: invokestatic 22	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +17 -> 24
    //   10: aload_1
    //   11: ifnull +13 -> 24
    //   14: iload_2
    //   15: bipush 100
    //   17: if_icmpgt +7 -> 24
    //   20: iload_2
    //   21: ifgt +37 -> 58
    //   24: ldc 10
    //   26: ldc_w 592
    //   29: new 32	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   36: aload_3
    //   37: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 529
    //   43: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 48	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   52: iconst_0
    //   53: istore 5
    //   55: iload 5
    //   57: ireturn
    //   58: ldc 10
    //   60: ldc_w 592
    //   63: new 32	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   70: aload_3
    //   71: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc_w 531
    //   77: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: iload_2
    //   81: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 119	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   90: new 50	java/io/File
    //   93: dup
    //   94: aload_0
    //   95: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   98: astore_0
    //   99: aload_0
    //   100: invokevirtual 175	java/io/File:exists	()Z
    //   103: ifeq +8 -> 111
    //   106: aload_0
    //   107: invokevirtual 534	java/io/File:delete	()Z
    //   110: pop
    //   111: aload_0
    //   112: invokevirtual 537	java/io/File:createNewFile	()Z
    //   115: pop
    //   116: new 594	java/io/FileOutputStream
    //   119: dup
    //   120: aload_0
    //   121: invokespecial 597	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   124: astore 6
    //   126: aload 6
    //   128: astore_0
    //   129: aload_1
    //   130: getstatic 603	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   133: iload_2
    //   134: aload 6
    //   136: invokevirtual 606	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   139: pop
    //   140: aload 6
    //   142: astore_0
    //   143: aload 6
    //   145: invokevirtual 609	java/io/FileOutputStream:flush	()V
    //   148: aload 6
    //   150: astore_0
    //   151: aload 6
    //   153: invokevirtual 613	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   156: astore_1
    //   157: aload_1
    //   158: ifnull +20 -> 178
    //   161: aload 6
    //   163: astore_0
    //   164: aload_1
    //   165: invokevirtual 618	java/io/FileDescriptor:valid	()Z
    //   168: ifeq +10 -> 178
    //   171: aload 6
    //   173: astore_0
    //   174: aload_1
    //   175: invokevirtual 621	java/io/FileDescriptor:sync	()V
    //   178: aload 6
    //   180: ifnull -125 -> 55
    //   183: aload 6
    //   185: invokevirtual 624	java/io/FileOutputStream:close	()V
    //   188: iconst_1
    //   189: ireturn
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual 578	java/io/IOException:printStackTrace	()V
    //   195: iconst_1
    //   196: ireturn
    //   197: astore_0
    //   198: aload 4
    //   200: ifnull +12 -> 212
    //   203: aload 6
    //   205: astore_0
    //   206: aload 4
    //   208: iconst_1
    //   209: invokevirtual 627	com/tencent/mobileqq/pic/CompressInfo:b	(Z)V
    //   212: aload 6
    //   214: astore_0
    //   215: ldc 10
    //   217: ldc_w 592
    //   220: ldc_w 629
    //   223: invokestatic 48	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   226: goto -48 -> 178
    //   229: astore_1
    //   230: aload 6
    //   232: astore_0
    //   233: ldc 10
    //   235: ldc_w 592
    //   238: new 32	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   245: aload_3
    //   246: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: ldc_w 574
    //   252: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 48	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   261: aload 6
    //   263: astore_0
    //   264: aload_1
    //   265: invokevirtual 575	java/io/FileNotFoundException:printStackTrace	()V
    //   268: aload 6
    //   270: ifnull +8 -> 278
    //   273: aload 6
    //   275: invokevirtual 624	java/io/FileOutputStream:close	()V
    //   278: iconst_0
    //   279: ireturn
    //   280: astore_0
    //   281: aload 4
    //   283: ifnull +12 -> 295
    //   286: aload 6
    //   288: astore_0
    //   289: aload 4
    //   291: iconst_1
    //   292: invokevirtual 627	com/tencent/mobileqq/pic/CompressInfo:b	(Z)V
    //   295: aload 6
    //   297: astore_0
    //   298: ldc 10
    //   300: ldc_w 592
    //   303: ldc_w 631
    //   306: invokestatic 48	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   309: goto -131 -> 178
    //   312: astore_1
    //   313: aload 6
    //   315: astore_0
    //   316: ldc 10
    //   318: ldc_w 592
    //   321: new 32	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   328: aload_3
    //   329: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: ldc_w 577
    //   335: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 48	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   344: aload 6
    //   346: astore_0
    //   347: aload_1
    //   348: invokevirtual 578	java/io/IOException:printStackTrace	()V
    //   351: aload 6
    //   353: ifnull +8 -> 361
    //   356: aload 6
    //   358: invokevirtual 624	java/io/FileOutputStream:close	()V
    //   361: iconst_0
    //   362: ireturn
    //   363: astore_0
    //   364: aload_0
    //   365: invokevirtual 578	java/io/IOException:printStackTrace	()V
    //   368: goto -90 -> 278
    //   371: astore_0
    //   372: aload_0
    //   373: invokevirtual 578	java/io/IOException:printStackTrace	()V
    //   376: goto -15 -> 361
    //   379: astore_1
    //   380: aconst_null
    //   381: astore_0
    //   382: aload_0
    //   383: ifnull +7 -> 390
    //   386: aload_0
    //   387: invokevirtual 624	java/io/FileOutputStream:close	()V
    //   390: aload_1
    //   391: athrow
    //   392: astore_0
    //   393: aload_0
    //   394: invokevirtual 578	java/io/IOException:printStackTrace	()V
    //   397: goto -7 -> 390
    //   400: astore_1
    //   401: goto -19 -> 382
    //   404: astore_1
    //   405: aconst_null
    //   406: astore 6
    //   408: goto -95 -> 313
    //   411: astore_1
    //   412: aconst_null
    //   413: astore 6
    //   415: goto -185 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	paramString1	String
    //   0	418	1	paramBitmap	Bitmap
    //   0	418	2	paramInt	int
    //   0	418	3	paramString2	String
    //   0	418	4	paramCompressInfo	CompressInfo
    //   1	55	5	bool	boolean
    //   124	290	6	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   183	188	190	java/io/IOException
    //   143	148	197	java/io/SyncFailedException
    //   151	157	197	java/io/SyncFailedException
    //   164	171	197	java/io/SyncFailedException
    //   174	178	197	java/io/SyncFailedException
    //   129	140	229	java/io/FileNotFoundException
    //   143	148	229	java/io/FileNotFoundException
    //   151	157	229	java/io/FileNotFoundException
    //   164	171	229	java/io/FileNotFoundException
    //   174	178	229	java/io/FileNotFoundException
    //   206	212	229	java/io/FileNotFoundException
    //   215	226	229	java/io/FileNotFoundException
    //   289	295	229	java/io/FileNotFoundException
    //   298	309	229	java/io/FileNotFoundException
    //   143	148	280	java/io/IOException
    //   151	157	280	java/io/IOException
    //   164	171	280	java/io/IOException
    //   174	178	280	java/io/IOException
    //   129	140	312	java/io/IOException
    //   206	212	312	java/io/IOException
    //   215	226	312	java/io/IOException
    //   289	295	312	java/io/IOException
    //   298	309	312	java/io/IOException
    //   273	278	363	java/io/IOException
    //   356	361	371	java/io/IOException
    //   111	126	379	finally
    //   386	390	392	java/io/IOException
    //   129	140	400	finally
    //   143	148	400	finally
    //   151	157	400	finally
    //   164	171	400	finally
    //   174	178	400	finally
    //   206	212	400	finally
    //   215	226	400	finally
    //   233	261	400	finally
    //   264	268	400	finally
    //   289	295	400	finally
    //   298	309	400	finally
    //   316	344	400	finally
    //   347	351	400	finally
    //   111	126	404	java/io/IOException
    //   111	126	411	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.Utils
 * JD-Core Version:    0.7.0.1
 */