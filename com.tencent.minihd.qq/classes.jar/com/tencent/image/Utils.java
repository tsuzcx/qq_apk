package com.tencent.image;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Utils
{
  private static long[] CRCTable = new long[256];
  private static final long INITIALCRC = -1L;
  private static final long POLY64REV = -7661587058870466123L;
  public static final String TAG = "URLDrawable.Utils";
  private static boolean init = false;
  
  public static final long Crc64Long(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      l2 = 0L;
      return l2;
    }
    long l2 = -1L;
    int i;
    if (!init) {
      i = 0;
    }
    int j;
    for (;;)
    {
      if (i >= 256)
      {
        init = true;
        j = paramString.length();
        i = 0;
        l1 = l2;
        for (;;)
        {
          l2 = l1;
          if (i >= j) {
            break;
          }
          int k = paramString.charAt(i);
          l1 = CRCTable[(((int)l1 ^ k) & 0xFF)] ^ l1 >> 8;
          i += 1;
        }
      }
      l1 = i;
      j = 0;
      if (j < 8) {
        break label121;
      }
      CRCTable[i] = l1;
      i += 1;
    }
    label121:
    if (((int)l1 & 0x1) != 0) {}
    for (long l1 = l1 >> 1 ^ 0xAC4BC9B5;; l1 >>= 1)
    {
      j += 1;
      break;
    }
  }
  
  public static final String Crc64String(String paramString)
  {
    return Long.toString(Crc64Long(paramString), 16);
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    return calculateInSampleSize(new Rect(0, 0, paramOptions.outWidth, paramOptions.outHeight), paramInt1, paramInt2);
  }
  
  public static int calculateInSampleSize(Rect paramRect, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt1 == -1) || (paramInt2 == -1)) {
      if (paramRect.width() * paramRect.height() > 5000000)
      {
        if (QLog.isColorLevel()) {
          QLog.d("URLDrawable.Utils", 2, "calculateInSampleSize options.outWidth*options.outHeight=" + paramRect.width() * paramRect.height());
        }
        m = 2;
      }
    }
    int k;
    int j;
    int i;
    label90:
    do
    {
      return m;
      return 1;
      k = paramRect.width();
      j = paramRect.height();
      i = 1;
      if (j > paramInt2) {
        break;
      }
      m = i;
    } while (k <= paramInt1);
    int n = Math.round(j / paramInt2);
    int m = Math.round(k / paramInt1);
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
      break label90;
      n = m;
    }
  }
  
  public static final void copyFile(File paramFile1, File paramFile2)
    throws IOException
  {
    paramFile1 = new FileInputStream(paramFile1);
    paramFile2 = new FileOutputStream(paramFile2);
    byte[] arrayOfByte = new byte[8192];
    for (;;)
    {
      int i = paramFile1.read(arrayOfByte);
      if (i <= 0)
      {
        paramFile2.flush();
        paramFile1.close();
        paramFile2.close();
        return;
      }
      paramFile2.write(arrayOfByte, 0, i);
    }
  }
  
  public static void disableConnectionReuseIfNecessary()
  {
    if (hasHttpConnectionBug()) {
      System.setProperty("http.keepAlive", "false");
    }
  }
  
  @TargetApi(11)
  public static <Params, Progress, Result> void executeAsyncTaskOnSerialExcuter(AsyncTask<Params, Progress, Result> paramAsyncTask, Params... paramVarArgs)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramAsyncTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, paramVarArgs);
      return;
    }
    paramAsyncTask.execute(paramVarArgs);
  }
  
  @TargetApi(11)
  public static <Params, Progress, Result> void executeAsyncTaskOnThreadPool(AsyncTask<Params, Progress, Result> paramAsyncTask, Params... paramVarArgs)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramVarArgs);
      return;
    }
    paramAsyncTask.execute(paramVarArgs);
  }
  
  @SuppressLint({"NewApi"})
  public static int getBitmapSize(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    if (Build.VERSION.SDK_INT >= 12) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  @SuppressLint({"NewApi"})
  public static File getExternalCacheDir(Context paramContext)
  {
    if (hasExternalCacheDir()) {
      return paramContext.getExternalCacheDir();
    }
    paramContext = "/Android/data/" + paramContext.getPackageName() + "/imagecache/";
    return new File(Environment.getExternalStorageDirectory().getPath() + paramContext);
  }
  
  public static int getMemoryClass(Context paramContext)
  {
    return ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass();
  }
  
  @SuppressLint({"NewApi"})
  public static long getUsableSpace(File paramFile)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return paramFile.getUsableSpace();
    }
    paramFile = new StatFs(paramFile.getPath());
    return paramFile.getBlockSize() * paramFile.getAvailableBlocks();
  }
  
  public static boolean hasActionBar()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public static boolean hasExternalCacheDir()
  {
    return Build.VERSION.SDK_INT >= 8;
  }
  
  public static boolean hasHttpConnectionBug()
  {
    return Build.VERSION.SDK_INT < 8;
  }
  
  @SuppressLint({"NewApi"})
  public static boolean isExternalStorageRemovable()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return Environment.isExternalStorageRemovable();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.image.Utils
 * JD-Core Version:    0.7.0.1
 */