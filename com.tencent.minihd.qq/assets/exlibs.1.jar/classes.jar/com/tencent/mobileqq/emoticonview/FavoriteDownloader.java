package com.tencent.mobileqq.emoticonview;

import android.app.Application;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class FavoriteDownloader
  extends AlbumThumbDownloader
{
  public static final String a = "favorite";
  public static final String b = "FavoriteDownloader";
  
  public FavoriteDownloader(Application paramApplication)
  {
    super(paramApplication);
  }
  
  public static URL a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.a = paramString;
      paramString = new File(paramString);
      if (paramString.exists()) {
        localLocalMediaInfo.d = paramString.lastModified();
      }
      localLocalMediaInfo.f = paramInt1;
      localLocalMediaInfo.g = paramInt2;
      paramString = new URL("favorite", null, LocalMediaInfo.a(localLocalMediaInfo));
      if (QLog.isColorLevel()) {
        QLog.d("FavoriteDownloader", 2, "<--generateURL output: urlString =" + paramString.toString());
      }
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FavoriteDownloader
 * JD-Core Version:    0.7.0.1
 */