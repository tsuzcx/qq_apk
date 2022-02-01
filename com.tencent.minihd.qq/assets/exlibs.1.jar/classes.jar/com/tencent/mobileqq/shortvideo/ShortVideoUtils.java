package com.tencent.mobileqq.shortvideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ShortVideoUtils
  implements ShortVideoConstants
{
  private static final int j = 604800000;
  private static final String q = "ShortVideoUtils";
  
  public static long a(String paramString)
  {
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "Path:" + paramString + ", not exits!");
      }
      return -1L;
    }
    MediaPlayer localMediaPlayer = new MediaPlayer();
    try
    {
      localMediaPlayer.setDataSource(paramString);
      localMediaPlayer.prepare();
      int i = localMediaPlayer.getDuration();
      long l = i;
      return l;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "getDuration", paramString);
      }
      return -1L;
    }
    finally
    {
      localMediaPlayer.release();
    }
  }
  
  public static Bitmap a(Context paramContext, String paramString)
  {
    long l1 = System.currentTimeMillis();
    paramContext = ThumbnailUtils.createVideoThumbnail(paramString, 1);
    long l2 = System.currentTimeMillis();
    if (paramContext != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "getVideoThumbnail => success, width=" + paramContext.getWidth() + ", height=" + paramContext.getHeight() + ", videoPath=" + paramString + ", cost:" + (l2 - l1) + "ms");
      }
    }
    while (!QLog.isColorLevel()) {
      return paramContext;
    }
    QLog.e("ShortVideoUtils", 2, "getVideoThumbnail => fail,  videoPath=" + paramString);
    return paramContext;
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    Object localObject;
    if (paramBitmap == null)
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      int i;
      int k;
      try
      {
        i = paramBitmap.getWidth();
        k = paramBitmap.getHeight();
        localObject = a(paramBitmap);
        if (localObject != null) {
          break label230;
        }
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        float f1;
        float f2;
        Canvas localCanvas;
        RectF localRectF;
        Paint localPaint;
        localObject = paramBitmap;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "resizeThumb ==> dstW:" + m + ", dstH:" + n);
      }
      f1 = m / i;
      f2 = n / k;
      localObject = new Matrix();
      ((Matrix)localObject).postScale(f1, f2);
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localCanvas = new Canvas((Bitmap)localObject);
      localRectF = new RectF(0.0F, 0.0F, m, n);
      localPaint = new Paint(1);
      localPaint.setColor(-16777216);
      localPaint.setAntiAlias(true);
      localCanvas.drawBitmap(paramBitmap, null, localRectF, localPaint);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        paramBitmap.recycle();
      }
      return localObject;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ShortVideoUtils", 2, "resizeThumb, OutOfMemoryError ", localOutOfMemoryError);
      return paramBitmap;
      label230:
      int m = localObject[0];
      int n = localObject[1];
      if (i == m)
      {
        localObject = paramBitmap;
        if (k == n) {
          break;
        }
      }
    }
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(b());
    localStringBuilder.append("thumbs");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    default: 
      return " TYPE_NONE ";
    case 6: 
      return " TYPE_VIDEO_C2C ";
    case 7: 
      return " TYPE_VIDEO_THUMB_C2C ";
    case 17: 
      return " TYPE_VIDEO_DISUSS";
    case 18: 
      return " TYPE_VIDEO_THUMB_DISUSS ";
    case 9: 
      return " TYPE_VIDEO_TROOP";
    }
    return " TYPE_VIDEO_THUMB_TROOP ";
  }
  
  public static String a(long paramLong)
  {
    int m = (int)paramLong / 1000;
    int i = m % 60;
    int k = m / 60 % 60;
    m /= 3600;
    if (m > 0) {
      return String.format("%d:%02d:%02d", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i) }).toString();
    }
    return String.format("%02d:%02d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) }).toString();
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    String str = Formatter.formatShortFileSize(paramContext, paramLong);
    int i = str.length();
    paramContext = str;
    if (i > 3) {
      paramContext = str.substring(0, i - 1);
    }
    return paramContext.replace(" ", "");
  }
  
  public static String a(MessageForShortVideo paramMessageForShortVideo, String paramString)
  {
    long l1 = System.currentTimeMillis();
    String str1 = paramMessageForShortVideo.md5 + "[\\s\\S]{1,}\\." + paramString;
    String str2 = b(paramMessageForShortVideo, paramString);
    String str3 = b();
    paramMessageForShortVideo = new File(str3);
    if (!paramMessageForShortVideo.exists())
    {
      paramMessageForShortVideo.mkdir();
      return str2;
    }
    String[] arrayOfString = paramMessageForShortVideo.list();
    paramString = null;
    paramMessageForShortVideo = null;
    if (arrayOfString != null)
    {
      int k = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        paramString = paramMessageForShortVideo;
        if (i >= k) {
          break;
        }
        paramString = arrayOfString[i];
        if (paramString.matches(str1))
        {
          if ((str3 + paramString).equals(str2)) {
            return str2;
          }
          paramMessageForShortVideo = str3 + paramString;
        }
        i += 1;
      }
    }
    if (paramString != null) {
      FileUtils.c(paramString, str2);
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUtils", 2, "getShortVideoSavePath-----time: = " + (l2 - l1));
    }
    return str2;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("QQ视频");
    Calendar localCalendar = Calendar.getInstance();
    localStringBuilder.append(new SimpleDateFormat("yyyyMMddHHmmss").format(localCalendar.getTime()));
    localStringBuilder.append(".");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(a());
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static URL a(String paramString)
  {
    try
    {
      paramString = new URL("shortvideothumb", null, paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static void a()
  {
    a("", false);
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(paramMessageForShortVideo.md5)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoUtils", 2, "deleteCacheFileByMessage, md5 == null! ");
    return;
    FileUtils.d(a(paramMessageForShortVideo, "mp4"));
  }
  
  public static void a(String paramString1, String paramString2)
  {
    String str1 = paramString1 + "\\.[\\s\\S]{1,}\\.tmp";
    Object localObject = new File(b());
    if (!((File)localObject).exists())
    {
      ((File)localObject).mkdir();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "fixDownloadTempFile, videoSaveDir not exits");
      }
    }
    for (;;)
    {
      return;
      localObject = ((File)localObject).list();
      int k = localObject.length;
      int i = 0;
      while (i < k)
      {
        String str2 = localObject[i];
        str2 = b() + str2;
        if (str2.matches(str1))
        {
          File localFile = new File(str2);
          String str3 = paramString1 + "." + MD5.toMD5(paramString2) + ".tmp";
          if ((!FileUtils.b(str2, str3)) && (FileUtils.c(str2, str3))) {
            localFile.delete();
          }
        }
        i += 1;
      }
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUtils", 2, "deleteDownloadTempFile, exclude :" + paramString + ",compareModifiedTime : " + paramBoolean);
    }
    Object localObject1 = new File(b());
    if (!((File)localObject1).exists()) {
      return;
    }
    localObject1 = ((File)localObject1).listFiles();
    int k = localObject1.length;
    int i = 0;
    label76:
    Object localObject2;
    if (i < k)
    {
      localObject2 = localObject1[i];
      if (!localObject2.getName().equals(paramString)) {
        break label106;
      }
    }
    for (;;)
    {
      i += 1;
      break label76;
      break;
      label106:
      if ((localObject2.isFile()) && (localObject2.getName().contains(".tmp"))) {
        if (paramBoolean)
        {
          long l = localObject2.lastModified();
          if (604800000L <= System.currentTimeMillis() - l) {
            localObject2.delete();
          }
        }
        else
        {
          localObject2.delete();
        }
      }
    }
  }
  
  public static boolean a(String paramString, long paramLong)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2;
    if ((TextUtils.isEmpty(paramString)) || (0L == paramLong))
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoUtils", 2, " verifyFileModifyTime(), filePath or lastModifyTime is vilid.");
        bool2 = bool1;
      }
    }
    long l1;
    do
    {
      long l2;
      do
      {
        do
        {
          return bool2;
          l1 = System.currentTimeMillis();
          paramString = new File(paramString);
          l2 = paramString.length();
          bool2 = bool1;
        } while (!paramString.isFile());
        bool2 = bool1;
      } while (l2 <= 0L);
      bool1 = bool3;
      if (paramLong == paramString.lastModified()) {
        bool1 = true;
      }
      paramLong = System.currentTimeMillis();
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoUtils", 2, " verifyFileModifyTime(), result = " + bool1 + ", cost time: " + (paramLong - l1) + " ms");
    return bool1;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.e("ShortVideoUtils", 2, " verifyFileMD5(), filePath or targetMD5Str is empty");
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      long l1 = System.currentTimeMillis();
      paramString1 = new File(paramString1);
      long l2 = paramString1.length();
      bool1 = bool2;
      if (paramString1.isFile())
      {
        bool1 = bool2;
        if (l2 > 0L) {
          try
          {
            paramString1 = new FileInputStream(paramString1);
            paramString1 = HexUtil.bytes2HexStr(MD5.toMD5Byte(paramString1, l2));
            l2 = System.currentTimeMillis();
            bool2 = paramString2.equals(paramString1);
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("ShortVideoUtils", 2, "verifyFileMD5(), result = " + bool2 + ", cost time: " + (l2 - l1) + " ms");
              return bool2;
            }
          }
          catch (FileNotFoundException paramString1)
          {
            paramString1.printStackTrace();
          }
        }
      }
    }
    return false;
  }
  
  public static int[] a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "calculateThumbWH, bitmap == null ！");
      }
    }
    do
    {
      return null;
      if (!paramBitmap.isRecycled()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoUtils", 2, "calculateThumbWH, bitmap isRecycled !");
    return null;
    return a(new int[] { paramBitmap.getWidth(), paramBitmap.getHeight() });
  }
  
  public static int[] a(int[] paramArrayOfInt)
  {
    float f2 = 2.0F;
    int i = 150;
    int k = 80;
    if (paramArrayOfInt == null) {
      return null;
    }
    int n = paramArrayOfInt[0];
    int i1 = paramArrayOfInt[1];
    if ((n == 0) || (i1 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "calculateThumbWH, w or h == 0 !");
      }
      return null;
    }
    float f1;
    if (i1 > n)
    {
      f1 = i1 / n;
      if (f1 <= 2.0F) {
        break label204;
      }
      f1 = f2;
      label76:
      if (i1 <= n) {
        break label227;
      }
      if (i1 <= 150) {
        break label207;
      }
    }
    for (;;)
    {
      label91:
      int m = (int)(i / f1);
      if (m < 80) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "calculateThumbWH, w = " + n + ", h = " + i1 + ", ratio = " + f1 + ", dstW = " + k + ", dstH = " + i);
        }
        return new int[] { k, i };
        f1 = n / i1;
        break;
        label204:
        break label76;
        label207:
        if (i1 >= 100) {
          break label288;
        }
        i = 100;
        break label91;
        k = m;
      }
      label227:
      if (n > 150) {}
      for (;;)
      {
        label235:
        m = (int)(i / f1);
        if (m < 80) {}
        for (;;)
        {
          m = i;
          i = k;
          k = m;
          break;
          if (n >= 100) {
            break label282;
          }
          i = 100;
          break label235;
          k = m;
        }
        label282:
        i = n;
      }
      label288:
      i = i1;
    }
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.aG);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " STATUS_NONE ";
    case 2004: 
      return " STATUS_RECV_CANCEL ";
    case 2005: 
      return " STATUS_RECV_ERROR ";
    case 2003: 
      return " STATUS_RECV_FINISHED ";
    case 2002: 
      return " STATUS_RECV_PROCESS ";
    case 2001: 
      return " STATUS_RECV_START ";
    case 1001: 
      return "STATUS_SEND_START ";
    case 1004: 
      return " STATUS_SEND_CANCEL ";
    case 1002: 
      return " STATUS_SEND_PROCESS ";
    case 1003: 
      return " STATUS_SEND_FINISHED ";
    case 1005: 
      return " STATUS_SEND_ERROR ";
    case 5001: 
      return " STATUS_FILE_UNSAFE ";
    }
    return "STATUS_FILE_EXPIRED";
  }
  
  public static String b(MessageForShortVideo paramMessageForShortVideo, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(b());
    localStringBuilder.append(paramMessageForShortVideo.md5);
    localStringBuilder.append(paramMessageForShortVideo.frienduin);
    localStringBuilder.append(paramMessageForShortVideo.msgUid);
    localStringBuilder.append(Math.abs(paramMessageForShortVideo.shmsgseq));
    localStringBuilder.append(".");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Others";
    case 1: 
      return "WIFI";
    case 2: 
      return "2G";
    case 3: 
      return "3G";
    }
    return "4G";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoUtils
 * JD-Core Version:    0.7.0.1
 */