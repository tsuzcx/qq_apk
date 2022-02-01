package com.tencent.mobileqq.transfile;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Thumbnails;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import jzx;
import jzy;

public class DeviceMsgThumbDownloader
  extends AbsDownloader
{
  private static final int jdField_a_of_type_Int = 1;
  public static final String a = "devicemsgthumb";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  private static final String b = DeviceMsgThumbDownloader.class.getSimpleName();
  private static final String c = "file://";
  
  static
  {
    a = new String[] { "DISTINCT _id", "_data" };
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    String str;
    do
    {
      return paramString;
      str = paramString;
      if (paramString.startsWith("file://")) {
        str = paramString.substring("file://".length());
      }
      paramString = str;
    } while (str.startsWith(File.separator));
    return File.separator + str;
  }
  
  public static URL a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    try
    {
      paramString1 = new URL("devicemsgthumb", "", localStringBuilder.toString());
      return paramString1;
    }
    catch (MalformedURLException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DeviceMsgThumbDownloader", 2, paramString1.getMessage(), paramString1);
      }
    }
    return null;
  }
  
  public Cursor a(String paramString)
  {
    paramString = "_data='" + a(paramString) + "' COLLATE NOCASE";
    return BaseApplicationImpl.getContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, a, paramString, null, null);
  }
  
  @SuppressLint({"NewApi"})
  public Bitmap a(String paramString)
  {
    if (Build.VERSION.SDK_INT < 8) {
      return null;
    }
    return ThumbnailUtils.createVideoThumbnail(paramString, 1);
  }
  
  public LocalMediaInfo a(URL paramURL)
  {
    try
    {
      LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
      paramURL = paramURL.getFile().split("\\|");
      localLocalMediaInfo.a = paramURL[0];
      localLocalMediaInfo.f = Integer.parseInt(paramURL[1]);
      localLocalMediaInfo.g = Integer.parseInt(paramURL[2]);
      return localLocalMediaInfo;
    }
    catch (Exception paramURL) {}
    return null;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new File(AppConstants.aE);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Bitmap b(String paramString)
  {
    Object localObject = null;
    Cursor localCursor = null;
    if (Build.VERSION.SDK_INT < 5)
    {
      localObject = localCursor;
      label17:
      return localObject;
    }
    try
    {
      localCursor = a(paramString);
      paramString = (String)localObject;
      if (localCursor != null) {
        paramString = (String)localObject;
      }
    }
    finally
    {
      try
      {
        if (localCursor.getCount() > 0)
        {
          long l = localCursor.getLong(localCursor.getColumnIndexOrThrow("_id"));
          paramString = (String)localObject;
          if (localCursor.moveToFirst()) {
            paramString = MediaStore.Video.Thumbnails.getThumbnail(BaseApplicationImpl.getContext().getContentResolver(), l, 1, null);
          }
        }
        localObject = paramString;
        if (localCursor == null) {
          break label17;
        }
        localCursor.close();
        return paramString;
      }
      finally
      {
        break label112;
      }
      paramString = finally;
      localCursor = null;
    }
    label112:
    if (localCursor != null) {
      localCursor.close();
    }
    throw paramString;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramFile = a(paramDownloadParams.url);
    if (!FileUtils.b(paramFile.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "decodeFile file not exits. just return");
      }
      return null;
    }
    paramURLDrawableHandler = BaseApplicationImpl.getContext();
    if (FileManagerUtil.a(paramFile.a) == 2) {}
    for (paramFile = new jzy(this);; paramFile = new jzx(this)) {
      return AlbumThumbManager.a(paramURLDrawableHandler).b(paramDownloadParams.url, paramFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.DeviceMsgThumbDownloader
 * JD-Core Version:    0.7.0.1
 */