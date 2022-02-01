package com.tencent.mobileqq.transfile;

import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.util.Locale;

public abstract class AbsDownloader
  extends ProtocolDownloader.Adapter
  implements ProtocolDownloaderConstants
{
  private static final String a = AbsDownloader.class.getSimpleName();
  
  public static final File a(String paramString)
  {
    if (paramString != null)
    {
      String str = c(paramString);
      File localFile = new File(d(paramString));
      if (paramString.startsWith("chatthumb"))
      {
        paramString = new File(URLDrawableHelper.a, str + "_hd");
        if (!paramString.exists()) {}
      }
      do
      {
        return paramString;
        paramString = localFile;
      } while (localFile.exists());
      return null;
    }
    return null;
  }
  
  public static final boolean a(String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1;
    if (paramString != null) {
      if (paramString.startsWith("regionalthumb")) {
        localObject1 = localObject2;
      }
    }
    try
    {
      if (paramString.substring(0, "regionalthumb:".length()).equalsIgnoreCase("regionalthumb:")) {
        localObject1 = paramString.substring("regionalthumb:".length());
      }
      if (localObject1 != null)
      {
        paramString = ((String)localObject1).split("\\|");
        if (paramString != null)
        {
          return new File(paramString[0]).exists();
          if (paramString.toLowerCase(Locale.US).startsWith("file")) {
            localObject1 = localObject3;
          }
        }
      }
      try
      {
        if (paramString.substring(0, "file:".length()).equalsIgnoreCase("file:")) {
          localObject1 = paramString.substring("file:".length());
        }
        if (localObject1 != null)
        {
          return new File((String)localObject1).exists();
          paramString = b(paramString);
          if (paramString != null) {
            return a(paramString) != null;
          }
        }
        return false;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        for (;;)
        {
          localObject1 = localObject3;
        }
      }
    }
    catch (IndexOutOfBoundsException paramString)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
  }
  
  public static String b(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString;
    }
    try
    {
      if (paramString.substring(0, "aiothumb".length()).equalsIgnoreCase("aiothumb"))
      {
        str = "chatthumb" + paramString.substring("aiothumb".length());
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "getUrlStringForDisk newUrl = " + str);
        }
      }
      return str;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      do
      {
        str = paramString;
      } while (!QLog.isColorLevel());
      QLog.d(a, 2, "getUrlStringForDisk IndexOutOfBoundsException" + localIndexOutOfBoundsException);
    }
    return paramString;
  }
  
  public static final String c(String paramString)
  {
    return "Cache_" + Utils.Crc64String(paramString);
  }
  
  public static final String d(String paramString)
  {
    String str2 = URLDrawableHelper.a + "/" + c(paramString);
    String str1 = str2;
    if (paramString.startsWith("chatthumb"))
    {
      str1 = str2;
      if (new File(str2 + "_hd").exists()) {
        str1 = str2 + "_hd";
      }
    }
    return str1;
  }
  
  public static String e(String paramString)
  {
    return d(paramString) + "_dp";
  }
  
  public abstract File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler);
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(DownloadParams paramDownloadParams)
  {
    return false;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public final boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    if (!a()) {
      return false;
    }
    return a(paramDownloadParams.urlStr);
  }
  
  /* Error */
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aload_0
    //   7: invokevirtual 146	com/tencent/mobileqq/transfile/AbsDownloader:a	()Z
    //   10: ifeq +235 -> 245
    //   13: aload_1
    //   14: getfield 151	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   17: astore 9
    //   19: aload 9
    //   21: invokestatic 112	com/tencent/mobileqq/transfile/AbsDownloader:a	(Ljava/lang/String;)Ljava/io/File;
    //   24: astore 6
    //   26: aload 6
    //   28: ifnull +8 -> 36
    //   31: aload 6
    //   33: astore_2
    //   34: aload_2
    //   35: areturn
    //   36: aload 9
    //   38: invokestatic 27	com/tencent/mobileqq/transfile/AbsDownloader:c	(Ljava/lang/String;)Ljava/lang/String;
    //   41: astore 10
    //   43: getstatic 164	com/tencent/mobileqq/startup/step/InitUrlDrawable:a	Lcom/tencent/mobileqq/transfile/DiskCache;
    //   46: aload 10
    //   48: invokevirtual 169	com/tencent/mobileqq/transfile/DiskCache:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/transfile/DiskCache$Editor;
    //   51: astore 11
    //   53: aload_0
    //   54: invokevirtual 171	com/tencent/mobileqq/transfile/AbsDownloader:b	()Z
    //   57: istore 4
    //   59: iload 4
    //   61: ifeq +218 -> 279
    //   64: aload 7
    //   66: astore 6
    //   68: aload_1
    //   69: aload 11
    //   71: getfield 174	com/tencent/mobileqq/transfile/DiskCache$Editor:a	Ljava/io/File;
    //   74: invokevirtual 177	java/io/File:length	()J
    //   77: putfield 181	com/tencent/image/DownloadParams:downloaded	J
    //   80: aload 7
    //   82: astore 6
    //   84: aload_0
    //   85: aload_1
    //   86: invokevirtual 183	com/tencent/mobileqq/transfile/AbsDownloader:a	(Lcom/tencent/image/DownloadParams;)Z
    //   89: istore 5
    //   91: iload 5
    //   93: ifne +63 -> 156
    //   96: iconst_1
    //   97: istore_3
    //   98: iload 4
    //   100: iload_3
    //   101: iand
    //   102: istore 4
    //   104: aload 7
    //   106: astore 6
    //   108: new 185	java/io/FileOutputStream
    //   111: dup
    //   112: aload 11
    //   114: getfield 174	com/tencent/mobileqq/transfile/DiskCache$Editor:a	Ljava/io/File;
    //   117: iload 4
    //   119: invokespecial 188	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   122: astore 7
    //   124: aload_0
    //   125: aload 7
    //   127: aload_1
    //   128: aload_2
    //   129: invokevirtual 190	com/tencent/mobileqq/transfile/AbsDownloader:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   132: pop
    //   133: aload 11
    //   135: invokevirtual 193	com/tencent/mobileqq/transfile/DiskCache$Editor:a	()Ljava/io/File;
    //   138: astore_1
    //   139: aload_1
    //   140: astore_2
    //   141: aload 7
    //   143: ifnull -109 -> 34
    //   146: aload 7
    //   148: invokevirtual 198	java/io/OutputStream:close	()V
    //   151: aload_1
    //   152: areturn
    //   153: astore_2
    //   154: aload_1
    //   155: areturn
    //   156: iconst_0
    //   157: istore_3
    //   158: goto -60 -> 98
    //   161: astore_1
    //   162: aload 8
    //   164: astore_2
    //   165: aload 11
    //   167: ifnull +13 -> 180
    //   170: aload_2
    //   171: astore 6
    //   173: aload 11
    //   175: iload 4
    //   177: invokevirtual 201	com/tencent/mobileqq/transfile/DiskCache$Editor:a	(Z)V
    //   180: aload_2
    //   181: astore 6
    //   183: ldc 203
    //   185: ldc 204
    //   187: new 50	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   194: ldc 206
    //   196: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload 10
    //   201: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc 208
    //   206: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 9
    //   211: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 213	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   220: aload_2
    //   221: astore 6
    //   223: aload_1
    //   224: invokevirtual 216	java/lang/Exception:printStackTrace	()V
    //   227: aload_2
    //   228: astore 6
    //   230: aload_1
    //   231: athrow
    //   232: astore_1
    //   233: aload 6
    //   235: ifnull +8 -> 243
    //   238: aload 6
    //   240: invokevirtual 198	java/io/OutputStream:close	()V
    //   243: aload_1
    //   244: athrow
    //   245: aload_0
    //   246: aconst_null
    //   247: aload_1
    //   248: aload_2
    //   249: invokevirtual 190	com/tencent/mobileqq/transfile/AbsDownloader:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   252: areturn
    //   253: astore_2
    //   254: goto -11 -> 243
    //   257: astore_1
    //   258: aload 7
    //   260: astore 6
    //   262: goto -29 -> 233
    //   265: astore_1
    //   266: aload 8
    //   268: astore_2
    //   269: goto -104 -> 165
    //   272: astore_1
    //   273: aload 7
    //   275: astore_2
    //   276: goto -111 -> 165
    //   279: goto -175 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	AbsDownloader
    //   0	282	1	paramDownloadParams	DownloadParams
    //   0	282	2	paramURLDrawableHandler	URLDrawableHandler
    //   97	61	3	bool1	boolean
    //   57	119	4	bool2	boolean
    //   89	3	5	bool3	boolean
    //   24	237	6	localObject1	Object
    //   1	273	7	localFileOutputStream	java.io.FileOutputStream
    //   4	263	8	localObject2	Object
    //   17	193	9	str1	String
    //   41	159	10	str2	String
    //   51	123	11	localEditor	DiskCache.Editor
    // Exception table:
    //   from	to	target	type
    //   146	151	153	java/io/IOException
    //   68	80	161	java/lang/Exception
    //   84	91	161	java/lang/Exception
    //   68	80	232	finally
    //   84	91	232	finally
    //   108	124	232	finally
    //   173	180	232	finally
    //   183	220	232	finally
    //   223	227	232	finally
    //   230	232	232	finally
    //   238	243	253	java/io/IOException
    //   124	139	257	finally
    //   108	124	265	java/lang/Exception
    //   124	139	272	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AbsDownloader
 * JD-Core Version:    0.7.0.1
 */