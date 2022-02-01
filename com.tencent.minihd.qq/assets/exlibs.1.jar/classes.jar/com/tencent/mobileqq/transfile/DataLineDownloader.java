package com.tencent.mobileqq.transfile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.bitmapcreator.ExifBitmapCreator;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import jzv;
import jzw;

public class DataLineDownloader
  extends AbsDownloader
  implements ProtocolDownloaderConstants
{
  private static final String a = "_dataline_file";
  protected BaseApplicationImpl a;
  
  public DataLineDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.a = paramBaseApplicationImpl;
  }
  
  private Bitmap a(jzv paramjzv)
  {
    int j = 0;
    int k = paramjzv.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.f;
    int i = paramjzv.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.g;
    Object localObject;
    try
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      ((BitmapFactory.Options)localObject).inDensity = 160;
      ((BitmapFactory.Options)localObject).inTargetDensity = 160;
      ((BitmapFactory.Options)localObject).inScreenDensity = 160;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramjzv.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.a, (BitmapFactory.Options)localObject);
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inSampleSize = a((BitmapFactory.Options)localObject, k, i);
      Bitmap localBitmap = BitmapFactory.decodeFile(paramjzv.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.a, (BitmapFactory.Options)localObject);
      if (((BitmapFactory.Options)localObject).outHeight > ((BitmapFactory.Options)localObject).outWidth * 2.0F)
      {
        i = (int)((((BitmapFactory.Options)localObject).outHeight - ((BitmapFactory.Options)localObject).outWidth * 2.0F) / 2.0F);
        ((BitmapFactory.Options)localObject).outHeight = ((int)(((BitmapFactory.Options)localObject).outWidth * 2.0F));
      }
      for (;;)
      {
        localObject = ImageUtil.b(Bitmap.createBitmap(localBitmap, j, i, ((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight), k);
        if (localObject == null) {
          break label311;
        }
        return new ExifBitmapCreator(paramjzv.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.a).a((Bitmap)localObject);
        if (((BitmapFactory.Options)localObject).outWidth <= ((BitmapFactory.Options)localObject).outHeight * 2.0F) {
          break;
        }
        j = (int)((((BitmapFactory.Options)localObject).outWidth - ((BitmapFactory.Options)localObject).outHeight * 2.0F) / 2.0F);
        ((BitmapFactory.Options)localObject).outWidth = ((int)(((BitmapFactory.Options)localObject).outHeight * 2.0F));
        i = 0;
      }
    }
    catch (Exception paramjzv)
    {
      if (QLog.isColorLevel()) {
        QLog.d("_dataline_file", 2, "make Thumb ", paramjzv);
      }
      return null;
    }
    catch (OutOfMemoryError paramjzv)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("_dataline_file", 2, "make Thumb OOM ", paramjzv);
          continue;
          i = 0;
        }
      }
    }
    label311:
    return localObject;
  }
  
  public int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt1 == -1) || (paramInt2 == -1)) {
      if (paramOptions.outWidth * paramOptions.outHeight > 5000000)
      {
        if (QLog.isColorLevel()) {
          QLog.d("_dataline_file", 2, "calculateInSampleSize options.outWidth*options.outHeight=" + paramOptions.outWidth * paramOptions.outHeight);
        }
        j = 2;
      }
    }
    int k;
    int m;
    label95:
    do
    {
      do
      {
        return j;
        k = paramOptions.outHeight;
        m = paramOptions.outWidth;
        j = i;
      } while (k <= paramInt2);
      j = i;
    } while (m <= paramInt1);
    int n = Math.round(k / paramInt2);
    j = Math.round(m / paramInt1);
    if (n < j) {}
    for (;;)
    {
      j = i;
      if (n < 2) {
        break;
      }
      m /= 2;
      k /= 2;
      i *= 2;
      break label95;
      n = j;
    }
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = a(paramDownloadParams.url);
    if (paramOutputStream != null) {
      return new File(paramOutputStream.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.a);
    }
    return new File(AppConstants.aE);
  }
  
  public jzv a(URL paramURL)
  {
    try
    {
      jzv localjzv = new jzv(this);
      paramURL = paramURL.getFile().split("\\|");
      localjzv.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
      localjzv.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.a = paramURL[0];
      localjzv.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.f = Integer.parseInt(paramURL[1]);
      localjzv.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.g = Integer.parseInt(paramURL[2]);
      localjzv.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.d = Long.parseLong(paramURL[3]);
      localjzv.jdField_a_of_type_Boolean = Boolean.parseBoolean(paramURL[4]);
      return localjzv;
    }
    catch (Exception paramURL) {}
    return null;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramFile = AlbumThumbManager.a(BaseApplicationImpl.getContext());
    paramURLDrawableHandler = new jzw(this);
    paramFile = paramFile.b(paramDownloadParams.url, paramURLDrawableHandler);
    if (paramFile == null) {
      return null;
    }
    paramDownloadParams = a(paramDownloadParams.url);
    if ((paramDownloadParams != null) && (paramDownloadParams.jdField_a_of_type_Boolean))
    {
      paramDownloadParams = ImageUtil.a(paramFile, AIOUtils.a(12.0F, BaseApplicationImpl.getContext().getResources()));
      paramFile.recycle();
      return paramDownloadParams;
    }
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.DataLineDownloader
 * JD-Core Version:    0.7.0.1
 */