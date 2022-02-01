package com.tencent.mobileqq.transfile;

import android.app.Application;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.ThumbDecoder;
import com.tencent.mobileqq.activity.photo.VideoDecoder;
import com.tencent.mobileqq.app.AppConstants;
import java.io.File;

public class AlbumThumbDownloader
  extends ProtocolDownloader.Adapter
{
  public static int a = 200;
  public static final String c = "AlbumThumb";
  
  public AlbumThumbDownloader(Application paramApplication) {}
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = BaseApplicationImpl.getContext();
    String[] arrayOfString;
    if (LocalMediaInfo.class.isInstance(paramDownloadParams.tag))
    {
      paramFile = (LocalMediaInfo)paramDownloadParams.tag;
      arrayOfString = MimeHelper.a(paramFile.b);
      if (arrayOfString == null) {
        break label107;
      }
      if ("image".equals(arrayOfString[0])) {
        paramFile = new ThumbDecoder();
      }
    }
    for (;;)
    {
      return AlbumThumbManager.a(paramURLDrawableHandler).b(paramDownloadParams.url, paramFile);
      if ("video".equals(arrayOfString[0]))
      {
        paramFile = new VideoDecoder(paramURLDrawableHandler, paramFile);
        continue;
        paramFile = new ThumbDecoder();
      }
      else
      {
        label107:
        paramFile = null;
      }
    }
  }
  
  public boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    return true;
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new File(AppConstants.aE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AlbumThumbDownloader
 * JD-Core Version:    0.7.0.1
 */