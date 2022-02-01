package com.tencent.upload.common;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileUtils
{
  public static final String UPLOAD_TEMP_DIR = "uploader";
  public static final String UPLOAD_TEMP_FILE_SEPERATOR = "_";
  public static final int UPLOAD_TEMP_SPACE_THRESHOLD = 5;
  public static final String UPLOAD_TEMP_SUFFIX = ".qtmp";
  private static final String tag = FileUtils.class.getSimpleName();
  
  public static void clearUploadDir(Context paramContext, long paramLong1, long paramLong2)
  {
    File localFile = getExternalFilesDir(paramContext);
    if ((localFile != null) && (getCacheDirUsedSpace(localFile) >= paramLong1)) {
      deleteDir(localFile);
    }
    paramContext = paramContext.getDir("uploader", 0);
    if ((paramContext != null) && (getCacheDirUsedSpace(paramContext) >= paramLong2)) {
      deleteDir(paramContext);
    }
  }
  
  /* Error */
  public static boolean copyFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +17 -> 18
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifeq +9 -> 18
    //   12: iconst_1
    //   13: istore 8
    //   15: iload 8
    //   17: ireturn
    //   18: iconst_0
    //   19: istore 8
    //   21: aconst_null
    //   22: astore 17
    //   24: aconst_null
    //   25: astore 11
    //   27: aconst_null
    //   28: astore 16
    //   30: aconst_null
    //   31: astore 15
    //   33: aconst_null
    //   34: astore 12
    //   36: aconst_null
    //   37: astore 13
    //   39: aconst_null
    //   40: astore 14
    //   42: iconst_0
    //   43: istore_3
    //   44: iconst_0
    //   45: istore 5
    //   47: iconst_0
    //   48: istore 6
    //   50: iconst_0
    //   51: istore 4
    //   53: iconst_0
    //   54: istore_2
    //   55: new 71	java/io/FileInputStream
    //   58: dup
    //   59: aload_0
    //   60: invokespecial 74	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   63: astore_0
    //   64: new 76	java/io/FileOutputStream
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 77	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   72: astore 11
    //   74: iload 6
    //   76: istore_3
    //   77: sipush 10240
    //   80: newarray byte
    //   82: astore 12
    //   84: iload_2
    //   85: istore_3
    //   86: iload_2
    //   87: istore 4
    //   89: aload_0
    //   90: aload 12
    //   92: invokevirtual 81	java/io/FileInputStream:read	([B)I
    //   95: istore 5
    //   97: iload 5
    //   99: iconst_m1
    //   100: if_icmpne +99 -> 199
    //   103: iload_2
    //   104: istore_3
    //   105: iload_2
    //   106: istore 4
    //   108: aload 11
    //   110: invokevirtual 84	java/io/FileOutputStream:flush	()V
    //   113: iconst_1
    //   114: istore 7
    //   116: aload_0
    //   117: ifnull +7 -> 124
    //   120: aload_0
    //   121: invokevirtual 87	java/io/FileInputStream:close	()V
    //   124: aload 11
    //   126: ifnull +303 -> 429
    //   129: aload 11
    //   131: invokevirtual 88	java/io/FileOutputStream:close	()V
    //   134: aconst_null
    //   135: astore 11
    //   137: new 90	java/io/File
    //   140: dup
    //   141: aload_1
    //   142: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   145: astore_0
    //   146: aload_0
    //   147: ifnull +24 -> 171
    //   150: aload_0
    //   151: invokevirtual 95	java/io/File:exists	()Z
    //   154: ifeq +17 -> 171
    //   157: aload_0
    //   158: invokevirtual 99	java/io/File:length	()J
    //   161: lstore 9
    //   163: lload 9
    //   165: iload_2
    //   166: i2l
    //   167: lcmp
    //   168: ifeq +339 -> 507
    //   171: iconst_0
    //   172: istore 7
    //   174: iload 7
    //   176: istore 8
    //   178: iload 7
    //   180: ifne -165 -> 15
    //   183: iload 7
    //   185: istore 8
    //   187: aload_0
    //   188: ifnull -173 -> 15
    //   191: aload_0
    //   192: invokevirtual 102	java/io/File:delete	()Z
    //   195: pop
    //   196: iload 7
    //   198: ireturn
    //   199: iload_2
    //   200: istore_3
    //   201: iload_2
    //   202: istore 4
    //   204: aload 11
    //   206: aload 12
    //   208: iconst_0
    //   209: iload 5
    //   211: invokevirtual 106	java/io/FileOutputStream:write	([BII)V
    //   214: iload_2
    //   215: iload 5
    //   217: iadd
    //   218: istore_2
    //   219: goto -135 -> 84
    //   222: astore 13
    //   224: iload_3
    //   225: istore 4
    //   227: aload 16
    //   229: astore_0
    //   230: aload_0
    //   231: astore 11
    //   233: aload 14
    //   235: astore 12
    //   237: getstatic 31	com/tencent/upload/common/FileUtils:tag	Ljava/lang/String;
    //   240: ldc 108
    //   242: aload 13
    //   244: invokestatic 114	com/tencent/upload/common/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   247: aload_0
    //   248: ifnull +7 -> 255
    //   251: aload_0
    //   252: invokevirtual 87	java/io/FileInputStream:close	()V
    //   255: iload 8
    //   257: istore 7
    //   259: iload 4
    //   261: istore_2
    //   262: aload 14
    //   264: ifnull -130 -> 134
    //   267: aload 14
    //   269: invokevirtual 88	java/io/FileOutputStream:close	()V
    //   272: iload 8
    //   274: istore 7
    //   276: iload 4
    //   278: istore_2
    //   279: goto -145 -> 134
    //   282: astore_0
    //   283: getstatic 31	com/tencent/upload/common/FileUtils:tag	Ljava/lang/String;
    //   286: ldc 108
    //   288: aload_0
    //   289: invokestatic 114	com/tencent/upload/common/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   292: iload 8
    //   294: istore 7
    //   296: iload 4
    //   298: istore_2
    //   299: goto -165 -> 134
    //   302: astore 13
    //   304: iload 5
    //   306: istore_3
    //   307: aload 15
    //   309: astore 14
    //   311: aload 17
    //   313: astore_0
    //   314: aload_0
    //   315: astore 11
    //   317: aload 14
    //   319: astore 12
    //   321: getstatic 31	com/tencent/upload/common/FileUtils:tag	Ljava/lang/String;
    //   324: ldc 108
    //   326: aload 13
    //   328: invokestatic 114	com/tencent/upload/common/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   331: aload_0
    //   332: ifnull +7 -> 339
    //   335: aload_0
    //   336: invokevirtual 87	java/io/FileInputStream:close	()V
    //   339: iload 8
    //   341: istore 7
    //   343: iload_3
    //   344: istore_2
    //   345: aload 14
    //   347: ifnull -213 -> 134
    //   350: aload 14
    //   352: invokevirtual 88	java/io/FileOutputStream:close	()V
    //   355: iload 8
    //   357: istore 7
    //   359: iload_3
    //   360: istore_2
    //   361: goto -227 -> 134
    //   364: astore_0
    //   365: getstatic 31	com/tencent/upload/common/FileUtils:tag	Ljava/lang/String;
    //   368: ldc 108
    //   370: aload_0
    //   371: invokestatic 114	com/tencent/upload/common/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   374: iload 8
    //   376: istore 7
    //   378: iload_3
    //   379: istore_2
    //   380: goto -246 -> 134
    //   383: astore_0
    //   384: aload 11
    //   386: ifnull +8 -> 394
    //   389: aload 11
    //   391: invokevirtual 87	java/io/FileInputStream:close	()V
    //   394: aload 12
    //   396: ifnull +8 -> 404
    //   399: aload 12
    //   401: invokevirtual 88	java/io/FileOutputStream:close	()V
    //   404: aload_0
    //   405: athrow
    //   406: astore_1
    //   407: getstatic 31	com/tencent/upload/common/FileUtils:tag	Ljava/lang/String;
    //   410: ldc 108
    //   412: aload_1
    //   413: invokestatic 114	com/tencent/upload/common/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   416: goto -12 -> 404
    //   419: astore_0
    //   420: getstatic 31	com/tencent/upload/common/FileUtils:tag	Ljava/lang/String;
    //   423: ldc 108
    //   425: aload_0
    //   426: invokestatic 114	com/tencent/upload/common/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   429: goto -295 -> 134
    //   432: astore_0
    //   433: aload 11
    //   435: astore_0
    //   436: goto -262 -> 174
    //   439: astore_1
    //   440: goto -266 -> 174
    //   443: astore_1
    //   444: aload_0
    //   445: astore 11
    //   447: aload 13
    //   449: astore 12
    //   451: aload_1
    //   452: astore_0
    //   453: goto -69 -> 384
    //   456: astore_1
    //   457: aload 11
    //   459: astore 12
    //   461: aload_0
    //   462: astore 11
    //   464: aload_1
    //   465: astore_0
    //   466: goto -82 -> 384
    //   469: astore 13
    //   471: aload 15
    //   473: astore 14
    //   475: iload 5
    //   477: istore_3
    //   478: goto -164 -> 314
    //   481: astore 13
    //   483: aload 11
    //   485: astore 14
    //   487: goto -173 -> 314
    //   490: astore 13
    //   492: iload_3
    //   493: istore 4
    //   495: goto -265 -> 230
    //   498: astore 13
    //   500: aload 11
    //   502: astore 14
    //   504: goto -274 -> 230
    //   507: goto -333 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	510	0	paramString1	String
    //   0	510	1	paramString2	String
    //   54	326	2	i	int
    //   43	450	3	j	int
    //   51	443	4	k	int
    //   45	431	5	m	int
    //   48	27	6	n	int
    //   114	263	7	bool1	boolean
    //   13	362	8	bool2	boolean
    //   161	3	9	l	long
    //   25	476	11	localObject1	Object
    //   34	426	12	localObject2	Object
    //   37	1	13	localObject3	Object
    //   222	21	13	localFileNotFoundException1	java.io.FileNotFoundException
    //   302	146	13	localIOException1	java.io.IOException
    //   469	1	13	localIOException2	java.io.IOException
    //   481	1	13	localIOException3	java.io.IOException
    //   490	1	13	localFileNotFoundException2	java.io.FileNotFoundException
    //   498	1	13	localFileNotFoundException3	java.io.FileNotFoundException
    //   40	463	14	localObject4	Object
    //   31	441	15	localObject5	Object
    //   28	200	16	localObject6	Object
    //   22	290	17	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   55	64	222	java/io/FileNotFoundException
    //   251	255	282	java/io/IOException
    //   267	272	282	java/io/IOException
    //   55	64	302	java/io/IOException
    //   335	339	364	java/io/IOException
    //   350	355	364	java/io/IOException
    //   55	64	383	finally
    //   237	247	383	finally
    //   321	331	383	finally
    //   389	394	406	java/io/IOException
    //   399	404	406	java/io/IOException
    //   120	124	419	java/io/IOException
    //   129	134	419	java/io/IOException
    //   137	146	432	java/lang/IllegalArgumentException
    //   150	163	439	java/lang/IllegalArgumentException
    //   64	74	443	finally
    //   77	84	456	finally
    //   89	97	456	finally
    //   108	113	456	finally
    //   204	214	456	finally
    //   64	74	469	java/io/IOException
    //   77	84	481	java/io/IOException
    //   89	97	481	java/io/IOException
    //   108	113	481	java/io/IOException
    //   204	214	481	java/io/IOException
    //   64	74	490	java/io/FileNotFoundException
    //   77	84	498	java/io/FileNotFoundException
    //   89	97	498	java/io/FileNotFoundException
    //   108	113	498	java/io/FileNotFoundException
    //   204	214	498	java/io/FileNotFoundException
  }
  
  public static final void deleteClosedTempFile(String paramString)
  {
    if ((paramString == null) || (!paramString.endsWith(".qtmp"))) {}
    do
    {
      return;
      paramString = new File(paramString);
    } while ((paramString.exists()) && (!paramString.renameTo(paramString.getAbsoluteFile())));
    paramString.delete();
  }
  
  private static void deleteDir(File paramFile)
  {
    String[] arrayOfString;
    if ((paramFile != null) && (paramFile.isDirectory()))
    {
      arrayOfString = paramFile.list();
      if (arrayOfString != null) {}
    }
    else
    {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label26:
    String str;
    if (i < j)
    {
      str = arrayOfString[i];
      if (!TextUtils.isEmpty(str)) {
        break label51;
      }
    }
    for (;;)
    {
      i += 1;
      break label26;
      break;
      label51:
      new File(paramFile, str).delete();
    }
  }
  
  public static final void deleteTempFile(String paramString)
  {
    if ((paramString == null) || (!paramString.endsWith(".qtmp"))) {
      return;
    }
    new File(paramString).delete();
    UploadLog.d(tag, "deleteTempFile: " + paramString);
  }
  
  public static final long getCacheDirUsedSpace(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.isDirectory())) {}
    String[] arrayOfString;
    do
    {
      return 0L;
      arrayOfString = paramFile.list();
    } while (arrayOfString == null);
    int j = 0;
    int k = arrayOfString.length;
    int i = 0;
    if (i >= k) {
      return j;
    }
    String str = arrayOfString[i];
    if (str == null) {}
    for (;;)
    {
      i += 1;
      break;
      j = (int)(j + new File(paramFile, str).length());
    }
  }
  
  private static final String getCachePathByPrefix(File paramFile, String paramString)
  {
    if ((paramFile == null) || (!paramFile.isDirectory())) {}
    String[] arrayOfString;
    do
    {
      return null;
      arrayOfString = paramFile.list();
    } while (arrayOfString == null);
    int j = arrayOfString.length;
    int i = 0;
    label30:
    String str;
    if (i < j)
    {
      str = arrayOfString[i];
      if ((str != null) && (str.startsWith(paramString)) && (str.endsWith(".qtmp"))) {
        break label72;
      }
    }
    label72:
    File localFile;
    do
    {
      i += 1;
      break label30;
      break;
      localFile = new File(paramFile, str);
    } while ((localFile.length() == 0L) || (!localFile.isFile()));
    return 3 + paramFile.getAbsolutePath() + File.separator + str;
  }
  
  private static File getExternalFilesDir(Context paramContext)
  {
    File localFile = Environment.getExternalStorageDirectory();
    if ((localFile == null) || (!localFile.exists()) || (paramContext == null)) {
      paramContext = null;
    }
    do
    {
      do
      {
        return paramContext;
        StringBuilder localStringBuilder = new StringBuilder(11);
        localStringBuilder.append(localFile.getAbsolutePath());
        localStringBuilder.append(File.separator);
        localStringBuilder.append("Android");
        localStringBuilder.append(File.separator);
        localStringBuilder.append("data");
        localStringBuilder.append(File.separator);
        localStringBuilder.append(paramContext.getPackageName());
        localStringBuilder.append(File.separator);
        localStringBuilder.append("files");
        localStringBuilder.append(File.separator);
        localStringBuilder.append("uploader");
        localFile = new File(localStringBuilder.toString());
        paramContext = localFile;
      } while (localFile.isDirectory());
      paramContext = localFile;
    } while (localFile.mkdirs());
    return null;
  }
  
  public static String getFilePathByPrefix(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      paramString1 = null;
    }
    do
    {
      String str;
      do
      {
        return paramString1;
        str = paramString2;
        if (paramString2 == null) {
          str = "";
        }
        str = getTempFilePerfix(str.hashCode(), paramString1.hashCode());
        if ((!"mounted".equals(Environment.getExternalStorageState())) || (getSdCardAvailableSize() <= 5)) {
          break;
        }
        paramString1 = getExternalFilesDir(paramContext);
        if (paramString1 == null) {
          break;
        }
        paramString2 = getCachePathByPrefix(paramString1, str);
        paramString1 = paramString2;
      } while (paramString2 != null);
      if (getInternalAvailableSize() <= 5) {
        break;
      }
      paramContext = paramContext.getDir("uploader", 0);
      if (paramContext == null) {
        break;
      }
      paramContext = getCachePathByPrefix(paramContext, str);
      paramString1 = paramContext;
    } while (paramContext != null);
    return null;
  }
  
  public static int getInternalAvailableSize()
  {
    StatFs localStatFs = new StatFs(Environment.getRootDirectory().getPath());
    int i = localStatFs.getBlockSize();
    return (int)(1.0D * localStatFs.getAvailableBlocks() * i / 1024.0D / 1024.0D);
  }
  
  public static String getMd5(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.reset();
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = StringUtils.toHexString(localMessageDigest.digest());
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte) {}
    return "";
  }
  
  /* Error */
  private static String getMd5ByFile(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 95	java/io/File:exists	()Z
    //   8: ifne +6 -> 14
    //   11: ldc 198
    //   13: areturn
    //   14: aload_0
    //   15: invokevirtual 99	java/io/File:length	()J
    //   18: lstore_2
    //   19: lload_2
    //   20: ldc2_w 267
    //   23: lcmp
    //   24: ifle +145 -> 169
    //   27: lload_2
    //   28: ldc2_w 269
    //   31: ldiv
    //   32: lstore_2
    //   33: bipush 32
    //   35: newarray byte
    //   37: astore 7
    //   39: aconst_null
    //   40: astore 5
    //   42: aconst_null
    //   43: astore 6
    //   45: aconst_null
    //   46: astore 4
    //   48: new 71	java/io/FileInputStream
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 272	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   56: astore_0
    //   57: aload_0
    //   58: lload_2
    //   59: invokevirtual 276	java/io/FileInputStream:skip	(J)J
    //   62: pop2
    //   63: iconst_0
    //   64: istore_1
    //   65: iload_1
    //   66: iconst_4
    //   67: if_icmplt +21 -> 88
    //   70: aload 7
    //   72: invokestatic 264	com/tencent/upload/common/StringUtils:toHexString	([B)Ljava/lang/String;
    //   75: astore 4
    //   77: aload_0
    //   78: ifnull +311 -> 389
    //   81: aload_0
    //   82: invokevirtual 87	java/io/FileInputStream:close	()V
    //   85: aload 4
    //   87: areturn
    //   88: aload_0
    //   89: aload 7
    //   91: iload_1
    //   92: bipush 8
    //   94: imul
    //   95: bipush 8
    //   97: invokevirtual 279	java/io/FileInputStream:read	([BII)I
    //   100: pop
    //   101: aload_0
    //   102: lload_2
    //   103: ldc2_w 280
    //   106: lsub
    //   107: invokevirtual 276	java/io/FileInputStream:skip	(J)J
    //   110: pop2
    //   111: iload_1
    //   112: iconst_1
    //   113: iadd
    //   114: istore_1
    //   115: goto -50 -> 65
    //   118: astore_0
    //   119: aload 4
    //   121: areturn
    //   122: astore_0
    //   123: aload 4
    //   125: astore_0
    //   126: aload_0
    //   127: ifnull +7 -> 134
    //   130: aload_0
    //   131: invokevirtual 87	java/io/FileInputStream:close	()V
    //   134: ldc 198
    //   136: areturn
    //   137: astore_0
    //   138: aload 5
    //   140: astore_0
    //   141: aload_0
    //   142: ifnull -8 -> 134
    //   145: aload_0
    //   146: invokevirtual 87	java/io/FileInputStream:close	()V
    //   149: goto -15 -> 134
    //   152: astore_0
    //   153: aload 6
    //   155: astore 4
    //   157: aload 4
    //   159: ifnull +8 -> 167
    //   162: aload 4
    //   164: invokevirtual 87	java/io/FileInputStream:close	()V
    //   167: aload_0
    //   168: athrow
    //   169: aconst_null
    //   170: astore 6
    //   172: aconst_null
    //   173: astore 7
    //   175: aconst_null
    //   176: astore 8
    //   178: aconst_null
    //   179: astore 5
    //   181: ldc 242
    //   183: invokestatic 248	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   186: astore 9
    //   188: aload 9
    //   190: invokevirtual 251	java/security/MessageDigest:reset	()V
    //   193: new 71	java/io/FileInputStream
    //   196: dup
    //   197: aload_0
    //   198: invokespecial 272	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   201: astore 4
    //   203: aload 9
    //   205: aload 4
    //   207: invokevirtual 285	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   210: getstatic 291	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   213: lconst_0
    //   214: aload_0
    //   215: invokevirtual 99	java/io/File:length	()J
    //   218: invokevirtual 297	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   221: invokevirtual 300	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   224: aload 9
    //   226: invokevirtual 259	java/security/MessageDigest:digest	()[B
    //   229: invokestatic 264	com/tencent/upload/common/StringUtils:toHexString	([B)Ljava/lang/String;
    //   232: astore_0
    //   233: aload 4
    //   235: ifnull +152 -> 387
    //   238: aload 4
    //   240: invokevirtual 87	java/io/FileInputStream:close	()V
    //   243: aload_0
    //   244: areturn
    //   245: astore 4
    //   247: aload_0
    //   248: areturn
    //   249: astore_0
    //   250: aload 5
    //   252: astore_0
    //   253: aload_0
    //   254: ifnull -120 -> 134
    //   257: aload_0
    //   258: invokevirtual 87	java/io/FileInputStream:close	()V
    //   261: goto -127 -> 134
    //   264: astore_0
    //   265: aload 6
    //   267: astore_0
    //   268: aload_0
    //   269: ifnull -135 -> 134
    //   272: aload_0
    //   273: invokevirtual 87	java/io/FileInputStream:close	()V
    //   276: goto -142 -> 134
    //   279: astore_0
    //   280: aload 7
    //   282: astore_0
    //   283: aload_0
    //   284: ifnull -150 -> 134
    //   287: aload_0
    //   288: invokevirtual 87	java/io/FileInputStream:close	()V
    //   291: goto -157 -> 134
    //   294: astore_0
    //   295: aload 8
    //   297: astore 4
    //   299: aload 4
    //   301: ifnull +8 -> 309
    //   304: aload 4
    //   306: invokevirtual 87	java/io/FileInputStream:close	()V
    //   309: aload_0
    //   310: athrow
    //   311: astore_0
    //   312: goto -178 -> 134
    //   315: astore_0
    //   316: goto -182 -> 134
    //   319: astore 4
    //   321: goto -154 -> 167
    //   324: astore_0
    //   325: goto -191 -> 134
    //   328: astore_0
    //   329: goto -195 -> 134
    //   332: astore_0
    //   333: goto -199 -> 134
    //   336: astore 4
    //   338: goto -29 -> 309
    //   341: astore_0
    //   342: goto -43 -> 299
    //   345: astore_0
    //   346: aload 4
    //   348: astore_0
    //   349: goto -66 -> 283
    //   352: astore_0
    //   353: aload 4
    //   355: astore_0
    //   356: goto -88 -> 268
    //   359: astore_0
    //   360: aload 4
    //   362: astore_0
    //   363: goto -110 -> 253
    //   366: astore 5
    //   368: aload_0
    //   369: astore 4
    //   371: aload 5
    //   373: astore_0
    //   374: goto -217 -> 157
    //   377: astore 4
    //   379: goto -238 -> 141
    //   382: astore 4
    //   384: goto -258 -> 126
    //   387: aload_0
    //   388: areturn
    //   389: aload 4
    //   391: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	paramFile	File
    //   64	51	1	i	int
    //   18	85	2	l	long
    //   46	193	4	localObject1	Object
    //   245	1	4	localIOException1	java.io.IOException
    //   297	8	4	localObject2	Object
    //   319	1	4	localIOException2	java.io.IOException
    //   336	25	4	localIOException3	java.io.IOException
    //   369	1	4	localFile	File
    //   377	1	4	localIOException4	java.io.IOException
    //   382	8	4	localFileNotFoundException	java.io.FileNotFoundException
    //   40	211	5	localObject3	Object
    //   366	6	5	localObject4	Object
    //   43	223	6	localObject5	Object
    //   37	244	7	arrayOfByte	byte[]
    //   176	120	8	localObject6	Object
    //   186	39	9	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   81	85	118	java/io/IOException
    //   48	57	122	java/io/FileNotFoundException
    //   48	57	137	java/io/IOException
    //   48	57	152	finally
    //   238	243	245	java/io/IOException
    //   181	203	249	java/security/NoSuchAlgorithmException
    //   181	203	264	java/io/FileNotFoundException
    //   181	203	279	java/io/IOException
    //   181	203	294	finally
    //   130	134	311	java/io/IOException
    //   145	149	315	java/io/IOException
    //   162	167	319	java/io/IOException
    //   257	261	324	java/io/IOException
    //   272	276	328	java/io/IOException
    //   287	291	332	java/io/IOException
    //   304	309	336	java/io/IOException
    //   203	233	341	finally
    //   203	233	345	java/io/IOException
    //   203	233	352	java/io/FileNotFoundException
    //   203	233	359	java/security/NoSuchAlgorithmException
    //   57	63	366	finally
    //   70	77	366	finally
    //   88	111	366	finally
    //   57	63	377	java/io/IOException
    //   70	77	377	java/io/IOException
    //   88	111	377	java/io/IOException
    //   57	63	382	java/io/FileNotFoundException
    //   70	77	382	java/io/FileNotFoundException
    //   88	111	382	java/io/FileNotFoundException
  }
  
  public static UploaderMD5 getMd5ByFile_200K(File paramFile)
  {
    if (paramFile.length() < 204800L) {
      return new UploaderMD5(1, getMd5ByFile_REAL(paramFile));
    }
    return new UploaderMD5(0, getMd5ByFile(paramFile));
  }
  
  public static UploaderMD5 getMd5ByFile_FAKE(File paramFile)
  {
    return new UploaderMD5(0, getMd5ByFile(paramFile));
  }
  
  /* Error */
  public static String getMd5ByFile_REAL(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_2
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_2
    //   11: astore_1
    //   12: ldc 242
    //   14: invokestatic 248	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   17: astore 6
    //   19: aload_2
    //   20: astore_1
    //   21: aload 6
    //   23: invokevirtual 251	java/security/MessageDigest:reset	()V
    //   26: aload_2
    //   27: astore_1
    //   28: new 71	java/io/FileInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 272	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   36: astore_2
    //   37: aload 6
    //   39: aload_2
    //   40: invokevirtual 285	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   43: getstatic 291	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   46: lconst_0
    //   47: aload_0
    //   48: invokevirtual 99	java/io/File:length	()J
    //   51: invokevirtual 297	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   54: invokevirtual 300	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   57: aload 6
    //   59: invokevirtual 259	java/security/MessageDigest:digest	()[B
    //   62: invokestatic 264	com/tencent/upload/common/StringUtils:toHexString	([B)Ljava/lang/String;
    //   65: astore_0
    //   66: aload_2
    //   67: ifnull +20 -> 87
    //   70: aload_2
    //   71: invokevirtual 87	java/io/FileInputStream:close	()V
    //   74: aload_0
    //   75: areturn
    //   76: astore_1
    //   77: getstatic 31	com/tencent/upload/common/FileUtils:tag	Ljava/lang/String;
    //   80: aload_1
    //   81: invokevirtual 314	java/io/IOException:toString	()Ljava/lang/String;
    //   84: invokestatic 317	com/tencent/upload/common/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload_0
    //   88: areturn
    //   89: astore_2
    //   90: aload_3
    //   91: astore_0
    //   92: aload_0
    //   93: astore_1
    //   94: getstatic 31	com/tencent/upload/common/FileUtils:tag	Ljava/lang/String;
    //   97: aload_2
    //   98: invokevirtual 318	java/security/NoSuchAlgorithmException:toString	()Ljava/lang/String;
    //   101: invokestatic 317	com/tencent/upload/common/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_0
    //   105: ifnull +7 -> 112
    //   108: aload_0
    //   109: invokevirtual 87	java/io/FileInputStream:close	()V
    //   112: ldc 198
    //   114: areturn
    //   115: astore_0
    //   116: getstatic 31	com/tencent/upload/common/FileUtils:tag	Ljava/lang/String;
    //   119: aload_0
    //   120: invokevirtual 314	java/io/IOException:toString	()Ljava/lang/String;
    //   123: invokestatic 317	com/tencent/upload/common/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: goto -14 -> 112
    //   129: astore_2
    //   130: aload 4
    //   132: astore_0
    //   133: aload_0
    //   134: astore_1
    //   135: getstatic 31	com/tencent/upload/common/FileUtils:tag	Ljava/lang/String;
    //   138: aload_2
    //   139: invokevirtual 319	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   142: invokestatic 317	com/tencent/upload/common/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload_0
    //   146: ifnull -34 -> 112
    //   149: aload_0
    //   150: invokevirtual 87	java/io/FileInputStream:close	()V
    //   153: goto -41 -> 112
    //   156: astore_0
    //   157: getstatic 31	com/tencent/upload/common/FileUtils:tag	Ljava/lang/String;
    //   160: aload_0
    //   161: invokevirtual 314	java/io/IOException:toString	()Ljava/lang/String;
    //   164: invokestatic 317	com/tencent/upload/common/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: goto -55 -> 112
    //   170: astore_2
    //   171: aload 5
    //   173: astore_0
    //   174: aload_0
    //   175: astore_1
    //   176: getstatic 31	com/tencent/upload/common/FileUtils:tag	Ljava/lang/String;
    //   179: aload_2
    //   180: invokevirtual 314	java/io/IOException:toString	()Ljava/lang/String;
    //   183: invokestatic 317	com/tencent/upload/common/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload_0
    //   187: ifnull -75 -> 112
    //   190: aload_0
    //   191: invokevirtual 87	java/io/FileInputStream:close	()V
    //   194: goto -82 -> 112
    //   197: astore_0
    //   198: getstatic 31	com/tencent/upload/common/FileUtils:tag	Ljava/lang/String;
    //   201: aload_0
    //   202: invokevirtual 314	java/io/IOException:toString	()Ljava/lang/String;
    //   205: invokestatic 317	com/tencent/upload/common/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: goto -96 -> 112
    //   211: astore_0
    //   212: aload_1
    //   213: ifnull +7 -> 220
    //   216: aload_1
    //   217: invokevirtual 87	java/io/FileInputStream:close	()V
    //   220: aload_0
    //   221: athrow
    //   222: astore_1
    //   223: getstatic 31	com/tencent/upload/common/FileUtils:tag	Ljava/lang/String;
    //   226: aload_1
    //   227: invokevirtual 314	java/io/IOException:toString	()Ljava/lang/String;
    //   230: invokestatic 317	com/tencent/upload/common/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: goto -13 -> 220
    //   236: astore_0
    //   237: aload_2
    //   238: astore_1
    //   239: goto -27 -> 212
    //   242: astore_1
    //   243: aload_2
    //   244: astore_0
    //   245: aload_1
    //   246: astore_2
    //   247: goto -73 -> 174
    //   250: astore_1
    //   251: aload_2
    //   252: astore_0
    //   253: aload_1
    //   254: astore_2
    //   255: goto -122 -> 133
    //   258: astore_1
    //   259: aload_2
    //   260: astore_0
    //   261: aload_1
    //   262: astore_2
    //   263: goto -171 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	paramFile	File
    //   11	17	1	localFileInputStream1	java.io.FileInputStream
    //   76	5	1	localIOException1	java.io.IOException
    //   93	124	1	localFile	File
    //   222	5	1	localIOException2	java.io.IOException
    //   238	1	1	localIOException3	java.io.IOException
    //   242	4	1	localIOException4	java.io.IOException
    //   250	4	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   258	4	1	localNoSuchAlgorithmException1	NoSuchAlgorithmException
    //   7	64	2	localFileInputStream2	java.io.FileInputStream
    //   89	9	2	localNoSuchAlgorithmException2	NoSuchAlgorithmException
    //   129	10	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   170	74	2	localIOException5	java.io.IOException
    //   246	17	2	localObject1	Object
    //   9	82	3	localObject2	Object
    //   1	130	4	localObject3	Object
    //   4	168	5	localObject4	Object
    //   17	41	6	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   70	74	76	java/io/IOException
    //   12	19	89	java/security/NoSuchAlgorithmException
    //   21	26	89	java/security/NoSuchAlgorithmException
    //   28	37	89	java/security/NoSuchAlgorithmException
    //   108	112	115	java/io/IOException
    //   12	19	129	java/io/FileNotFoundException
    //   21	26	129	java/io/FileNotFoundException
    //   28	37	129	java/io/FileNotFoundException
    //   149	153	156	java/io/IOException
    //   12	19	170	java/io/IOException
    //   21	26	170	java/io/IOException
    //   28	37	170	java/io/IOException
    //   190	194	197	java/io/IOException
    //   12	19	211	finally
    //   21	26	211	finally
    //   28	37	211	finally
    //   94	104	211	finally
    //   135	145	211	finally
    //   176	186	211	finally
    //   216	220	222	java/io/IOException
    //   37	66	236	finally
    //   37	66	242	java/io/IOException
    //   37	66	250	java/io/FileNotFoundException
    //   37	66	258	java/security/NoSuchAlgorithmException
  }
  
  public static int getSdCardAvailableSize()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    int i = localStatFs.getBlockSize();
    return (int)(1.0D * localStatFs.getAvailableBlocks() * i / 1024.0D / 1024.0D);
  }
  
  public static final String getTempFileAbsolutePath(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return 8 + paramString + File.separator + paramInt1 + "_" + paramInt2 + "_" + paramInt3 + ".qtmp";
  }
  
  public static String getTempFilePath(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 == null) {}
    int i;
    int j;
    do
    {
      do
      {
        return null;
        String str = paramString2;
        if (paramString2 == null) {
          str = "";
        }
        i = str.hashCode();
        j = paramString1.hashCode();
        if (("mounted".equals(Environment.getExternalStorageState())) && (getSdCardAvailableSize() > 5))
        {
          paramString1 = getExternalFilesDir(paramContext);
          if (paramString1 != null) {
            return getTempFileAbsolutePath(paramString1.getAbsolutePath(), i, j, paramInt);
          }
        }
      } while (getInternalAvailableSize() <= 5);
      paramContext = paramContext.getDir("uploader", 0);
    } while (paramContext == null);
    return getTempFileAbsolutePath(paramContext.getAbsolutePath(), i, j, paramInt);
  }
  
  public static final String getTempFilePerfix(int paramInt1, int paramInt2)
  {
    return 3 + paramInt1 + "_" + paramInt2;
  }
  
  public static final boolean isFileExist(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static final boolean isValidTempFile(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (new File(paramString).length() > 0L);
  }
  
  public static class UploaderMD5
  {
    public static final int FAKE_FILE_MD5 = 0;
    public static final int REAL_FILE_MD5 = 1;
    int type = 0;
    String value = "";
    
    public UploaderMD5(int paramInt, String paramString)
    {
      this.type = paramInt;
      this.value = paramString;
    }
    
    public int getType()
    {
      return this.type;
    }
    
    public String getValue()
    {
      return this.value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.common.FileUtils
 * JD-Core Version:    0.7.0.1
 */