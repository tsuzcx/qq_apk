package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class ProfileImgDownloader
  extends AbsDownloader
{
  protected static final String a = "ProfileImgDownloader";
  public static final String b = "profile_img_big";
  public static final String c = "profile_img_thumb";
  public static final String d = "profile_img_icon";
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    int m = j;
    if (paramInt1 != 0)
    {
      m = j;
      if (paramInt2 != 0)
      {
        m = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label42;
          }
          m = j;
        }
      }
    }
    label42:
    int k;
    label54:
    do
    {
      return m;
      j = paramOptions.outHeight;
      k = paramOptions.outWidth;
      if (j > paramInt2) {
        break;
      }
      m = i;
    } while (k <= paramInt1);
    int n = Math.round(j / paramInt2);
    m = Math.round(k / paramInt1);
    if (n > m) {}
    for (;;)
    {
      m = i;
      if (n < 2) {
        break;
      }
      k /= 2;
      j /= 2;
      i *= 2;
      break label54;
      n = m;
    }
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.i("ProfileImgDownloader", 2, "downloadImage() url = " + paramDownloadParams.url);
    }
    paramURLDrawableHandler = paramDownloadParams.url.getProtocol();
    paramOutputStream = paramDownloadParams.url.getHost();
    paramDownloadParams = paramDownloadParams.url.getFile();
    int i;
    int j;
    if ((paramOutputStream != null) && ((paramOutputStream.startsWith("[")) || (paramOutputStream.endsWith("]")))) {
      if (paramOutputStream.startsWith("["))
      {
        i = 1;
        if (!paramOutputStream.endsWith("]")) {
          break label205;
        }
        j = paramOutputStream.length() - 1;
        label112:
        if (i >= j) {
          break label435;
        }
        paramOutputStream = paramOutputStream.substring(i, j);
      }
    }
    label408:
    label435:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileImgDownloader", 2, "downloadImage() [" + paramURLDrawableHandler + "," + paramOutputStream + "," + paramDownloadParams + "]");
      }
      if (TextUtils.isEmpty(paramDownloadParams))
      {
        throw new RuntimeException("downloadImage() path is null");
        i = 0;
        break;
        label205:
        j = paramOutputStream.length();
        break label112;
      }
      File localFile1 = new File(paramDownloadParams);
      File localFile2;
      if (!localFile1.exists())
      {
        if (!"profile_img_icon".equals(paramURLDrawableHandler)) {
          break label408;
        }
        paramURLDrawableHandler = paramDownloadParams + "_temp";
        localFile2 = new File(paramURLDrawableHandler);
        if (localFile2.exists()) {
          localFile2.delete();
        }
        File localFile3 = localFile2.getParentFile();
        if ((localFile3 != null) && (!localFile3.exists())) {
          localFile3.mkdirs();
        }
      }
      try
      {
        bool1 = HttpDownloadUtil.a(null, MsfSdkUtils.insertMtype("qzone", paramOutputStream), localFile2);
        if (bool1)
        {
          FileUtils.c(paramURLDrawableHandler, paramDownloadParams);
          localFile2.delete();
          return localFile1;
        }
      }
      catch (Exception paramOutputStream)
      {
        for (;;)
        {
          boolean bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "downloadQzonePic() " + paramOutputStream.toString());
            bool1 = bool2;
            continue;
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.FrdProfileCard", 2, "downloadQzonePic() fail");
            }
          }
        }
      }
      throw new RuntimeException("downloadImage() file not exist, path = " + paramDownloadParams);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileImgDownloader", 2, "decodeFile() url = " + paramDownloadParams.url + ", path = " + paramFile.getAbsolutePath());
    }
    if ("profile_img_thumb".equals(paramDownloadParams.url.getProtocol())) {
      try
      {
        Object localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramFile.getAbsolutePath(), (BitmapFactory.Options)localObject);
        ((BitmapFactory.Options)localObject).inSampleSize = a((BitmapFactory.Options)localObject, 160, 160);
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        localObject = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), (BitmapFactory.Options)localObject);
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ProfileImgDownloader", 2, "decodeFile(): OutOfMemoryError, " + localOutOfMemoryError.getMessage());
        }
      }
    }
    return super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ProfileImgDownloader
 * JD-Core Version:    0.7.0.1
 */