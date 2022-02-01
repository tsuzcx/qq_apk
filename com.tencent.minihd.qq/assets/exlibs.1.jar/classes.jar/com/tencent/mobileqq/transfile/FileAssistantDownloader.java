package com.tencent.mobileqq.transfile;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.SliceBitmap;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.transfile.bitmapcreator.ExifBitmapCreator;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import kad;
import kae;

public class FileAssistantDownloader
  extends AbsDownloader
  implements ProtocolDownloaderConstants
{
  private static final String a = "FileAssistantDownloader";
  protected BaseApplicationImpl a;
  
  public FileAssistantDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.a = paramBaseApplicationImpl;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private Bitmap a(kad paramkad)
  {
    Object localObject2 = null;
    int i = paramkad.jdField_a_of_type_Int;
    int j = paramkad.jdField_b_of_type_Int;
    try
    {
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.RGB_565;
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramkad.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject1);
      ((BitmapFactory.Options)localObject1).inSampleSize = ImageUtil.b((BitmapFactory.Options)localObject1, i, j);
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
      Bitmap localBitmap = BitmapFactory.decodeFile(paramkad.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject1);
      localObject1 = localObject2;
      if (localBitmap != null) {
        localObject1 = new ExifBitmapCreator(paramkad.jdField_a_of_type_JavaLangString).a(localBitmap);
      }
    }
    catch (Exception paramkad)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("AlbumThumbManager", 2, "make Thumb", paramkad);
      return null;
    }
    catch (OutOfMemoryError paramkad)
    {
      do
      {
        Object localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("AlbumThumbManager", 2, "make Thumb. OutOfMemoryError", paramkad);
    }
    return localObject1;
    return null;
  }
  
  public Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f = this.a.getResources().getDisplayMetrics().density;
    paramInt1 = (int)(paramInt1 * f);
    paramInt2 = (int)(f * paramInt2);
    return ImageUtil.a(paramBitmap, paramInt1, paramInt1, paramInt2);
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = a(paramDownloadParams.url);
    if (paramOutputStream.jdField_a_of_type_JavaLangString == null) {
      return new File(AppConstants.aE);
    }
    return new File(paramOutputStream.jdField_a_of_type_JavaLangString);
  }
  
  public Object a(DownloadParams paramDownloadParams, kad paramkad)
  {
    Object localObject = null;
    paramDownloadParams = null;
    String str = paramkad.jdField_a_of_type_JavaLangString;
    if (str == null) {
      paramkad = paramDownloadParams;
    }
    File localFile;
    for (;;)
    {
      return paramkad;
      localFile = new File(str);
      try
      {
        if ((GifDrawable.isGifFile(localFile)) && (paramkad.jdField_a_of_type_Boolean))
        {
          paramkad = paramDownloadParams;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("FileAssistantDownloader", 2, "DecodeFile END,GIF image,cacheFile=" + localFile.getAbsolutePath() + ",url=" + str);
          return null;
        }
      }
      catch (Exception paramDownloadParams)
      {
        throw paramDownloadParams;
      }
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = URLDrawableHelper.a;
    localOptions.inDensity = 160;
    localOptions.inTargetDensity = 160;
    localOptions.inScreenDensity = 160;
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(localFile.getAbsolutePath(), localOptions);
    if ((localOptions.outHeight == 0) || (localOptions.outWidth == 0)) {
      throw new IOException("step:decode bounds error, not valid pic");
    }
    localOptions.inSampleSize = AbstractImageDownloader.a(localOptions, paramkad.jdField_a_of_type_Int, paramkad.jdField_b_of_type_Int);
    int i = localOptions.outWidth;
    i = localOptions.outHeight;
    localOptions.inJustDecodeBounds = false;
    i = 1;
    paramkad = null;
    label222:
    paramDownloadParams = localObject;
    if (i <= 3)
    {
      paramDownloadParams = paramkad;
      try
      {
        paramkad = BitmapFactory.decodeFile(localFile.getAbsolutePath(), localOptions);
        if (paramkad == null)
        {
          paramDownloadParams = paramkad;
          throw new OutOfMemoryError("DecodeFile Failed,bitmap == null, url:" + str + " ,retry count: " + i + ",path:" + localFile.getAbsolutePath());
        }
      }
      catch (OutOfMemoryError paramkad)
      {
        if (paramDownloadParams != null) {
          paramDownloadParams.recycle();
        }
        if (paramkad == null) {}
      }
    }
    for (paramkad = paramkad.getMessage();; paramkad = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileAssistantDownloader", 2, "DecodeFile ERROR,oom retryCount=" + i + ",options.inSampleSize=" + localOptions.inSampleSize + ",cacheFile=" + localFile.getAbsolutePath() + ",url=" + str + ",oom.msg:" + paramkad);
      }
      localOptions.inSampleSize *= 2;
      i += 1;
      paramkad = paramDownloadParams;
      break label222;
      paramDownloadParams = paramkad;
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramDownloadParams = paramkad;
        boolean bool = SliceBitmap.needSlice(paramkad);
        if (!bool) {}
      }
      paramDownloadParams = paramkad;
      paramkad = paramDownloadParams;
      if (paramDownloadParams != null) {
        break;
      }
      throw new IOException("decode image failed");
    }
  }
  
  public kad a(URL paramURL)
  {
    boolean bool2 = true;
    try
    {
      paramURL = paramURL.getFile().split("\\|");
      kad localkad = new kad(this);
      localkad.jdField_a_of_type_JavaLangString = paramURL[0];
      localkad.jdField_a_of_type_Int = Integer.parseInt(paramURL[1]);
      localkad.jdField_b_of_type_Int = Integer.parseInt(paramURL[2]);
      localkad.jdField_b_of_type_Long = Long.parseLong(paramURL[3]);
      if (paramURL.length > 4)
      {
        if (Integer.parseInt(paramURL[4]) == 1)
        {
          bool1 = true;
          localkad.jdField_a_of_type_Boolean = bool1;
        }
      }
      else
      {
        if (paramURL.length > 5)
        {
          if (Integer.parseInt(paramURL[5]) != 1) {
            break label146;
          }
          bool1 = true;
          label106:
          localkad.jdField_b_of_type_Boolean = bool1;
        }
        if (paramURL.length > 6) {
          if (Integer.parseInt(paramURL[6]) != 1) {
            break label151;
          }
        }
      }
      label146:
      label151:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localkad.c = bool1;
        return localkad;
        bool1 = false;
        break;
        bool1 = false;
        break label106;
      }
      return null;
    }
    catch (Exception paramURL) {}
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = null;
    paramFile = AlbumThumbManager.a(BaseApplicationImpl.getContext());
    kad localkad = a(paramDownloadParams.url);
    if ((localkad.jdField_a_of_type_Boolean) && (!localkad.jdField_b_of_type_Boolean) && (!localkad.c))
    {
      paramDownloadParams = a(paramDownloadParams, localkad);
      return paramDownloadParams;
    }
    if (localkad.c)
    {
      paramFile = FileCategoryUtil.b(this.a, localkad.jdField_a_of_type_JavaLangString);
      if (paramFile == null) {
        break label133;
      }
      paramFile = a(paramFile);
    }
    for (;;)
    {
      paramDownloadParams = paramURLDrawableHandler;
      if (paramFile == null) {
        break;
      }
      if (localkad.jdField_b_of_type_Boolean)
      {
        return a(paramFile, paramFile.getWidth(), paramFile.getHeight());
        paramFile = paramFile.b(paramDownloadParams.url, new kae(this));
      }
      else
      {
        return paramFile;
        label133:
        paramFile = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FileAssistantDownloader
 * JD-Core Version:    0.7.0.1
 */