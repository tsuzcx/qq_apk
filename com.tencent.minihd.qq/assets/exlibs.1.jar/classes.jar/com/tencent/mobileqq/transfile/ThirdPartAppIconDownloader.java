package com.tencent.mobileqq.transfile;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
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
import java.io.OutputStream;
import java.net.URL;

public class ThirdPartAppIconDownloader
  extends HttpDownloader
{
  public static final String b = "third_part";
  private float a = 2.0F;
  
  public ThirdPartAppIconDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    try
    {
      this.a = paramBaseApplicationImpl.getResources().getDisplayMetrics().density;
      return;
    }
    catch (Exception paramBaseApplicationImpl) {}
  }
  
  public static Bitmap a(Bitmap paramBitmap, double paramDouble1, double paramDouble2)
  {
    float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    Object localObject = new Matrix();
    ((Matrix)localObject).postScale((float)paramDouble1 / f1, (float)paramDouble2 / f2);
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, (int)f1, (int)f2, (Matrix)localObject, true);
    if ((localObject != paramBitmap) && (paramBitmap != null)) {
      paramBitmap.recycle();
    }
    return localObject;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    URL localURL = paramDownloadParams.url;
    paramDownloadParams.url = new URL("http", localURL.getAuthority(), localURL.getFile());
    return super.a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams = null;
    try
    {
      paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), null);
      paramFile = a(paramFile, this.a * 50.0F, this.a * 50.0F);
      int i = paramFile.getWidth();
      int j = paramFile.getHeight();
      paramDownloadParams = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      paramDownloadParams.setDensity(160);
      paramURLDrawableHandler = new Canvas(paramDownloadParams);
      Paint localPaint = new Paint(1);
      localPaint.setColor(-16777216);
      Rect localRect = new Rect(0, 0, i, j);
      RectF localRectF = new RectF(localRect);
      float f = 10.0F * this.a;
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
 * Qualified Name:     com.tencent.mobileqq.transfile.ThirdPartAppIconDownloader
 * JD-Core Version:    0.7.0.1
 */