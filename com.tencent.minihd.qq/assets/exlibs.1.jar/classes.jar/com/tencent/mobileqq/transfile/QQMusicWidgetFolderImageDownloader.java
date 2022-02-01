package com.tencent.mobileqq.transfile;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import java.io.File;

public class QQMusicWidgetFolderImageDownloader
  extends ThirdPartAppIconDownloader
{
  public static final String a = "folder";
  private float a;
  
  public QQMusicWidgetFolderImageDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super(paramBaseApplicationImpl);
    this.a = paramBaseApplicationImpl.getResources().getDisplayMetrics().density;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams = null;
    try
    {
      paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), null);
      paramFile = a(paramFile, this.a * 56.0F, this.a * 56.0F);
      int i = paramFile.getWidth();
      int j = paramFile.getHeight();
      paramDownloadParams = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      paramDownloadParams.setDensity(160);
      paramURLDrawableHandler = new Canvas(paramDownloadParams);
      Paint localPaint = new Paint(1);
      localPaint.setColor(-16777216);
      Rect localRect = new Rect(0, 0, i, j);
      RectF localRectF = new RectF(localRect);
      float f = i / 2;
      paramURLDrawableHandler.drawRoundRect(localRectF, f, f, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      paramURLDrawableHandler.drawBitmap(paramFile, localRect, localRect, localPaint);
      if ((paramFile != null) && (!paramFile.isRecycled())) {
        paramFile.recycle();
      }
      return paramDownloadParams;
    }
    catch (OutOfMemoryError paramFile)
    {
      for (;;)
      {
        paramFile.printStackTrace();
        paramFile = paramDownloadParams;
      }
    }
    catch (Exception paramFile)
    {
      for (;;)
      {
        paramFile.printStackTrace();
        paramFile = paramDownloadParams;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.QQMusicWidgetFolderImageDownloader
 * JD-Core Version:    0.7.0.1
 */