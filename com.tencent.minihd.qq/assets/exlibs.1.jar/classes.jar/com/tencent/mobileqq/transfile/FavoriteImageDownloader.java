package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class FavoriteImageDownloader
  extends AbstractImageDownloader
{
  public static final String e = "favimage";
  private static final String h = "qqfav.FavoriteImageDownloader";
  
  public FavoriteImageDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super("favimage", paramBaseApplicationImpl);
  }
  
  public FavoriteImageDownloader(String paramString, BaseApplicationImpl paramBaseApplicationImpl)
  {
    super(paramString, paramBaseApplicationImpl);
  }
  
  public static File a(URL paramURL)
  {
    paramURL = a(paramURL, new String[] { null });
    if (paramURL == null) {
      return null;
    }
    return new File(paramURL);
  }
  
  private static String a(URL paramURL, String[] paramArrayOfString)
  {
    Object localObject = paramURL.getFile();
    if (((String)localObject).startsWith("file/")) {
      paramURL = ((String)localObject).substring("file/".length());
    }
    do
    {
      do
      {
        return paramURL;
        if (((String)localObject).startsWith("file://")) {
          return ((String)localObject).substring(7);
        }
        paramURL = (URL)localObject;
      } while (!((String)localObject).startsWith("http"));
      paramURL = (URL)localObject;
      if (((String)localObject).startsWith("http/")) {
        paramURL = ((String)localObject).substring("http/".length());
      }
      localObject = paramURL.split("\\|");
    } while (localObject.length < 2);
    paramArrayOfString[0] = localObject[0];
    return localObject[1];
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = new String[1];
    paramOutputStream[0] = null;
    String str1 = a(paramDownloadParams.url, paramOutputStream);
    int i;
    Object localObject;
    if (paramOutputStream[0] != null)
    {
      if (new File(str1).exists()) {
        break label404;
      }
      i = 1;
      j = i;
      if (i == 0)
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      }
    }
    label100:
    String str3;
    try
    {
      BitmapFactory.decodeFile(str1, (BitmapFactory.Options)localObject);
      i = ((BitmapFactory.Options)localObject).outHeight;
      j = ((BitmapFactory.Options)localObject).outWidth;
      if (j + i != 0) {
        break label410;
      }
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2;
        label404:
        label410:
        i = 1;
      }
    }
    int j = i;
    if (i != 0)
    {
      new File(str1).delete();
      j = i;
    }
    if ((j != 0) && (NetworkUtil.f(this.a.getApplicationContext())))
    {
      localObject = paramDownloadParams.url;
      str2 = paramDownloadParams.urlStr;
      paramDownloadParams.url = new URL(paramOutputStream[0]);
      paramDownloadParams.urlStr = paramOutputStream[0];
      if (QLog.isDevelopLevel()) {
        QLog.d("qqfav", 4, "favimage download: " + paramOutputStream[0] + " -> " + str1);
      }
      str3 = str1 + ".tmp";
      paramOutputStream = new File(str3);
      if (paramOutputStream.exists()) {
        paramOutputStream.delete();
      }
      paramURLDrawableHandler.publishProgress(0);
    }
    for (;;)
    {
      try
      {
        paramOutputStream = new FileOutputStream(str3);
      }
      catch (Exception paramOutputStream)
      {
        File localFile;
        paramOutputStream = null;
      }
      try
      {
        new HttpDownloader().a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
        paramOutputStream.close();
        paramURLDrawableHandler = new File(str3);
        localFile = new File(str1);
        if (!paramURLDrawableHandler.renameTo(localFile))
        {
          FileUtils.a(paramURLDrawableHandler, localFile);
          paramURLDrawableHandler.delete();
        }
        QfavReport.a(this.a.waitAppRuntime(null), false, new File(str1).length());
        paramDownloadParams.url = ((URL)localObject);
        paramDownloadParams.urlStr = str2;
        paramOutputStream = new File(str1);
        if ((!paramOutputStream.exists()) || (paramOutputStream.length() <= 0L)) {
          break label451;
        }
        return paramOutputStream;
      }
      catch (Exception paramURLDrawableHandler)
      {
        break label427;
      }
      i = 0;
      break;
      i = 0;
      break label100;
      label427:
      if (paramOutputStream != null) {
        paramOutputStream.close();
      }
      new File(str3).delete();
    }
    label451:
    paramOutputStream.delete();
    QLog.e("qqfav.FavoriteImageDownloader", 1, "downloadImage|file not exist or empty. filepath=" + str1);
    throw new IOException("File not Found. url: " + paramDownloadParams.url);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (5 == FileManagerUtil.a(paramFile.getName()))
    {
      Drawable localDrawable = FileCategoryUtil.b(this.a, paramFile.getPath());
      if (localDrawable != null)
      {
        if ((localDrawable instanceof BitmapDrawable)) {
          return ((BitmapDrawable)localDrawable).getBitmap();
        }
        paramFile = Bitmap.createBitmap(localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight(), Bitmap.Config.RGB_565);
        paramDownloadParams = new Canvas(paramFile);
        localDrawable.setBounds(0, 0, paramDownloadParams.getWidth(), paramDownloadParams.getHeight());
        localDrawable.draw(paramDownloadParams);
        return paramFile;
      }
    }
    try
    {
      paramDownloadParams = super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
      return paramDownloadParams;
    }
    catch (Exception paramDownloadParams)
    {
      if ((paramFile != null) && (QLog.isColorLevel())) {
        QLog.e("FavoriteImageDownloader", 2, "decodeFile|Execption,cacheFile=" + paramFile.getAbsolutePath() + ",filelength=" + paramFile.length());
      }
      throw paramDownloadParams;
    }
  }
  
  public boolean gifHasDifferentState()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FavoriteImageDownloader
 * JD-Core Version:    0.7.0.1
 */