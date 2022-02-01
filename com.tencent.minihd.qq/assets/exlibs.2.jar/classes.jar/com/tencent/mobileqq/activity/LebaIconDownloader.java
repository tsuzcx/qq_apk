package com.tencent.mobileqq.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil.HttpDownloadListener;
import egq;

public class LebaIconDownloader
{
  private static final String a = "LebaIconDownloader";
  
  /* Error */
  public static Drawable a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 18	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokevirtual 24	android/content/Context:getFilesDir	()Ljava/io/File;
    //   14: aload_1
    //   15: invokespecial 27	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   18: astore_0
    //   19: aload_0
    //   20: ifnull +117 -> 137
    //   23: aload_0
    //   24: invokevirtual 31	java/io/File:exists	()Z
    //   27: ifeq +110 -> 137
    //   30: new 33	java/io/FileInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 36	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: astore_1
    //   39: aload_1
    //   40: astore_0
    //   41: new 38	android/graphics/drawable/BitmapDrawable
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 41	android/graphics/drawable/BitmapDrawable:<init>	(Ljava/io/InputStream;)V
    //   49: astore_2
    //   50: aload_2
    //   51: astore_0
    //   52: aload_1
    //   53: ifnull +9 -> 62
    //   56: aload_1
    //   57: invokevirtual 44	java/io/FileInputStream:close	()V
    //   60: aload_2
    //   61: astore_0
    //   62: aload_0
    //   63: areturn
    //   64: astore_2
    //   65: aconst_null
    //   66: astore_1
    //   67: aload_1
    //   68: astore_0
    //   69: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +33 -> 105
    //   75: aload_1
    //   76: astore_0
    //   77: ldc 8
    //   79: iconst_2
    //   80: new 51	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   87: ldc 54
    //   89: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_2
    //   93: invokevirtual 62	java/lang/Exception:toString	()Ljava/lang/String;
    //   96: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 67	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aload_1
    //   106: ifnull +7 -> 113
    //   109: aload_1
    //   110: invokevirtual 44	java/io/FileInputStream:close	()V
    //   113: aconst_null
    //   114: astore_0
    //   115: goto -53 -> 62
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_0
    //   121: goto -59 -> 62
    //   124: astore_1
    //   125: aconst_null
    //   126: astore_0
    //   127: aload_0
    //   128: ifnull +7 -> 135
    //   131: aload_0
    //   132: invokevirtual 44	java/io/FileInputStream:close	()V
    //   135: aload_1
    //   136: athrow
    //   137: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq -136 -> 4
    //   143: ldc 8
    //   145: iconst_2
    //   146: new 51	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   153: ldc 69
    //   155: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_1
    //   159: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 71
    //   164: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 67	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aconst_null
    //   174: areturn
    //   175: astore_0
    //   176: aload_2
    //   177: astore_0
    //   178: goto -116 -> 62
    //   181: astore_0
    //   182: goto -47 -> 135
    //   185: astore_1
    //   186: goto -59 -> 127
    //   189: astore_2
    //   190: goto -123 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramContext	Context
    //   0	193	1	paramString	String
    //   49	12	2	localBitmapDrawable	BitmapDrawable
    //   64	113	2	localException1	java.lang.Exception
    //   189	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   30	39	64	java/lang/Exception
    //   109	113	118	java/lang/Exception
    //   30	39	124	finally
    //   56	60	175	java/lang/Exception
    //   131	135	181	java/lang/Exception
    //   41	50	185	finally
    //   69	75	185	finally
    //   77	105	185	finally
    //   41	50	189	java/lang/Exception
  }
  
  public static Drawable a(QQAppInterface paramQQAppInterface, Drawable paramDrawable)
  {
    if ((paramQQAppInterface == null) || (paramDrawable == null)) {}
    int i;
    int j;
    do
    {
      return null;
      i = paramDrawable.getMinimumWidth();
      j = paramDrawable.getMinimumHeight();
    } while ((i <= 0) || (j <= 0));
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, i, j);
      paramDrawable.draw(localCanvas);
      return new BitmapDrawable(paramQQAppInterface.a((Bitmap)localObject, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight()));
    }
  }
  
  public static Drawable a(String paramString)
  {
    paramString = BaseApplicationImpl.a.get(paramString);
    if (paramString == null) {
      return null;
    }
    if (((paramString instanceof Drawable)) || ((paramString instanceof BitmapDrawable))) {
      return (Drawable)paramString;
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, HttpDownloadUtil.HttpDownloadListener paramHttpDownloadListener)
  {
    if (paramContext == null) {}
    while ((paramString == null) || ("".equals(paramString)) || (paramQQAppInterface == null)) {
      return;
    }
    new egq(paramContext, paramString, paramQQAppInterface, paramHttpDownloadListener).start();
  }
  
  public static void a(String paramString, Drawable paramDrawable)
  {
    BaseApplicationImpl.a.put(paramString, paramDrawable);
  }
  
  public static Drawable b(Context paramContext, String paramString)
  {
    if (a(paramString) != null) {
      return a(paramString);
    }
    if (a(paramContext, paramString) != null)
    {
      a(paramString, a(paramContext, paramString));
      return a(paramContext, paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaIconDownloader
 * JD-Core Version:    0.7.0.1
 */