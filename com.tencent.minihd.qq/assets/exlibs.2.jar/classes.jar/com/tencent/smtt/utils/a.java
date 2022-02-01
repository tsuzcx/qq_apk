package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.smtt.sdk.TbsExtensionFunctionManager;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
{
  public static int a(Context paramContext, File paramFile)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 20)
        {
          if (!TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "disable_get_apk_version_switch.txt"))
          {
            bool = true;
            int i = a(paramContext, paramFile, bool);
            return i;
          }
          bool = false;
          continue;
        }
        boolean bool = false;
      }
      catch (Exception paramContext)
      {
        TbsLog.i("ApkUtil", "getApkVersion Failed");
        return 0;
      }
    }
  }
  
  public static int a(Context paramContext, File paramFile, boolean paramBoolean)
  {
    if (paramFile != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (paramFile.exists())
        {
          boolean bool1 = paramFile.getName().contains("tbs.org");
          boolean bool2 = paramFile.getName().contains("x5.tbs.decouple");
          int j;
          if ((bool1) || (bool2))
          {
            i = a(bool2, paramFile);
            if (i > 0) {
              return i;
            }
            if (!TbsShareManager.isThirdPartyApp(paramContext)) {}
          }
          else
          {
            if (((Build.VERSION.SDK_INT != 23) && (Build.VERSION.SDK_INT != 25)) || (!Build.MANUFACTURER.toLowerCase().contains("mi"))) {
              break label211;
            }
            i = 1;
            TbsPVConfig.releaseInstance();
            j = TbsPVConfig.getInstance(paramContext).getReadApk();
            if (j != 1) {
              continue;
            }
            i = 0;
            paramBoolean = false;
            break label218;
            label120:
            i = b(paramFile);
            if (i <= 0) {
              break label169;
            }
            return i;
          }
          bool1 = paramFile.getAbsolutePath().contains(paramContext.getApplicationInfo().packageName);
          if (bool1) {
            continue;
          }
          return 0;
          if (j != 2) {
            break label218;
          }
          return 0;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      label169:
      label211:
      label216:
      label218:
      do
      {
        if ((paramFile != null) && (paramFile.exists()))
        {
          try
          {
            paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramFile.getAbsolutePath(), 1);
            if (paramContext == null) {
              break label216;
            }
            i = paramContext.versionCode;
            return i;
          }
          catch (Throwable paramContext)
          {
            paramContext.printStackTrace();
            return -1;
          }
          i = 0;
          break;
        }
        return 0;
        if (paramBoolean) {
          break label120;
        }
      } while (i == 0);
    }
  }
  
  private static int a(boolean paramBoolean, File paramFile)
  {
    try
    {
      paramFile = paramFile.getParentFile();
      if (paramFile != null)
      {
        paramFile = paramFile.listFiles();
        Pattern localPattern = Pattern.compile(a(paramBoolean) + "(.*)");
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramFile[i];
          if ((localPattern.matcher(localObject.getName()).find()) && (localObject.isFile()) && (localObject.exists()))
          {
            i = Integer.parseInt(localObject.getName().substring(localObject.getName().lastIndexOf(".") + 1));
            return i;
          }
          i += 1;
        }
      }
      return -1;
    }
    catch (Exception paramFile) {}
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: bipush 16
    //   4: newarray char
    //   6: astore 6
    //   8: aload 6
    //   10: dup
    //   11: iconst_0
    //   12: ldc 194
    //   14: castore
    //   15: dup
    //   16: iconst_1
    //   17: ldc 195
    //   19: castore
    //   20: dup
    //   21: iconst_2
    //   22: ldc 196
    //   24: castore
    //   25: dup
    //   26: iconst_3
    //   27: ldc 197
    //   29: castore
    //   30: dup
    //   31: iconst_4
    //   32: ldc 198
    //   34: castore
    //   35: dup
    //   36: iconst_5
    //   37: ldc 199
    //   39: castore
    //   40: dup
    //   41: bipush 6
    //   43: ldc 200
    //   45: castore
    //   46: dup
    //   47: bipush 7
    //   49: ldc 201
    //   51: castore
    //   52: dup
    //   53: bipush 8
    //   55: ldc 202
    //   57: castore
    //   58: dup
    //   59: bipush 9
    //   61: ldc 203
    //   63: castore
    //   64: dup
    //   65: bipush 10
    //   67: ldc 204
    //   69: castore
    //   70: dup
    //   71: bipush 11
    //   73: ldc 205
    //   75: castore
    //   76: dup
    //   77: bipush 12
    //   79: ldc 206
    //   81: castore
    //   82: dup
    //   83: bipush 13
    //   85: ldc 207
    //   87: castore
    //   88: dup
    //   89: bipush 14
    //   91: ldc 208
    //   93: castore
    //   94: dup
    //   95: bipush 15
    //   97: ldc 209
    //   99: castore
    //   100: pop
    //   101: bipush 32
    //   103: newarray char
    //   105: astore 7
    //   107: ldc 211
    //   109: invokestatic 216	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   112: astore 8
    //   114: new 218	java/io/FileInputStream
    //   117: dup
    //   118: aload_0
    //   119: invokespecial 221	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   122: astore 5
    //   124: aload 5
    //   126: astore_0
    //   127: sipush 8192
    //   130: newarray byte
    //   132: astore 9
    //   134: aload 5
    //   136: astore_0
    //   137: aload 5
    //   139: aload 9
    //   141: invokevirtual 225	java/io/FileInputStream:read	([B)I
    //   144: istore_2
    //   145: iload_2
    //   146: iconst_m1
    //   147: if_icmpeq +42 -> 189
    //   150: aload 5
    //   152: astore_0
    //   153: aload 8
    //   155: aload 9
    //   157: iconst_0
    //   158: iload_2
    //   159: invokevirtual 229	java/security/MessageDigest:update	([BII)V
    //   162: goto -28 -> 134
    //   165: astore 6
    //   167: aload 5
    //   169: astore_0
    //   170: aload 6
    //   172: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   175: aload 5
    //   177: ifnull +8 -> 185
    //   180: aload 5
    //   182: invokevirtual 233	java/io/FileInputStream:close	()V
    //   185: aconst_null
    //   186: astore_0
    //   187: aload_0
    //   188: areturn
    //   189: aload 5
    //   191: astore_0
    //   192: aload 8
    //   194: invokevirtual 237	java/security/MessageDigest:digest	()[B
    //   197: astore 8
    //   199: iconst_0
    //   200: istore_2
    //   201: goto +85 -> 286
    //   204: aload 5
    //   206: astore_0
    //   207: new 60	java/lang/String
    //   210: dup
    //   211: aload 7
    //   213: invokespecial 240	java/lang/String:<init>	([C)V
    //   216: astore 6
    //   218: aload 6
    //   220: astore_0
    //   221: aload 5
    //   223: ifnull -36 -> 187
    //   226: aload 5
    //   228: invokevirtual 233	java/io/FileInputStream:close	()V
    //   231: aload 6
    //   233: areturn
    //   234: astore_0
    //   235: aload_0
    //   236: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   239: aload 6
    //   241: areturn
    //   242: astore_0
    //   243: aload_0
    //   244: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   247: goto -62 -> 185
    //   250: astore 5
    //   252: aconst_null
    //   253: astore_0
    //   254: aload_0
    //   255: ifnull +7 -> 262
    //   258: aload_0
    //   259: invokevirtual 233	java/io/FileInputStream:close	()V
    //   262: aload 5
    //   264: athrow
    //   265: astore_0
    //   266: aload_0
    //   267: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   270: goto -8 -> 262
    //   273: astore 5
    //   275: goto -21 -> 254
    //   278: astore 6
    //   280: aconst_null
    //   281: astore 5
    //   283: goto -116 -> 167
    //   286: iload_1
    //   287: bipush 16
    //   289: if_icmpge -85 -> 204
    //   292: aload 8
    //   294: iload_1
    //   295: baload
    //   296: istore_3
    //   297: iload_2
    //   298: iconst_1
    //   299: iadd
    //   300: istore 4
    //   302: aload 7
    //   304: iload_2
    //   305: aload 6
    //   307: iload_3
    //   308: iconst_4
    //   309: iushr
    //   310: bipush 15
    //   312: iand
    //   313: caload
    //   314: castore
    //   315: iload 4
    //   317: iconst_1
    //   318: iadd
    //   319: istore_2
    //   320: aload 7
    //   322: iload 4
    //   324: aload 6
    //   326: iload_3
    //   327: bipush 15
    //   329: iand
    //   330: caload
    //   331: castore
    //   332: iload_1
    //   333: iconst_1
    //   334: iadd
    //   335: istore_1
    //   336: goto -50 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	paramFile	File
    //   1	335	1	i	int
    //   144	176	2	j	int
    //   296	34	3	k	int
    //   300	23	4	m	int
    //   122	105	5	localFileInputStream	java.io.FileInputStream
    //   250	13	5	localObject1	Object
    //   273	1	5	localObject2	Object
    //   281	1	5	localObject3	Object
    //   6	3	6	arrayOfChar1	char[]
    //   165	6	6	localException1	Exception
    //   216	24	6	str	String
    //   278	47	6	localException2	Exception
    //   105	216	7	arrayOfChar2	char[]
    //   112	181	8	localObject4	Object
    //   132	24	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   127	134	165	java/lang/Exception
    //   137	145	165	java/lang/Exception
    //   153	162	165	java/lang/Exception
    //   192	199	165	java/lang/Exception
    //   207	218	165	java/lang/Exception
    //   226	231	234	java/io/IOException
    //   180	185	242	java/io/IOException
    //   107	124	250	finally
    //   258	262	265	java/io/IOException
    //   127	134	273	finally
    //   137	145	273	finally
    //   153	162	273	finally
    //   170	175	273	finally
    //   192	199	273	finally
    //   207	218	273	finally
    //   107	124	278	java/lang/Exception
  }
  
  public static final String a(boolean paramBoolean)
  {
    return a(paramBoolean, 0);
  }
  
  public static final String a(boolean paramBoolean, int paramInt)
  {
    boolean bool;
    if (paramInt == 64) {
      bool = true;
    }
    while (bool) {
      if (paramBoolean)
      {
        return "x5.64.decouple.backup";
        if (paramInt == 32) {
          bool = false;
        } else {
          bool = b.b();
        }
      }
      else
      {
        return "x5.64.backup";
      }
    }
    if (paramBoolean) {
      return "x5.decouple.backup";
    }
    return "x5.backup";
  }
  
  public static boolean a(Context paramContext, File paramFile, long paramLong, int paramInt)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      TbsLog.i("ApkUtil", "verifyTbsApk return false #1");
    }
    boolean bool;
    do
    {
      return false;
      if ((paramLong > 0L) && (paramLong != paramFile.length()))
      {
        TbsLog.i("ApkUtil", "verifyTbsApk return false #2");
        return false;
      }
      try
      {
        int i = a(paramContext, paramFile);
        if (paramInt != i)
        {
          TbsLog.i("ApkUtil", "verifyTbsApk return false #3  versionCode is " + i + " apkVersion is " + paramInt);
          return false;
        }
      }
      catch (Exception paramContext)
      {
        TbsLog.i("ApkUtil", "verifyTbsApk false  stack is " + Log.getStackTraceString(paramContext));
        return false;
      }
      bool = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(b.a(paramContext, true, paramFile));
    } while (!bool);
    return true;
  }
  
  /* Error */
  public static int b(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 293
    //   5: new 144	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 295
    //   15: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_0
    //   19: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   22: ldc_w 300
    //   25: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: invokevirtual 52	java/io/File:exists	()Z
    //   32: invokevirtual 303	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   35: ldc_w 305
    //   38: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_0
    //   42: invokevirtual 308	java/io/File:canRead	()Z
    //   45: invokevirtual 303	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   48: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 44	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: ldc 2
    //   56: monitorenter
    //   57: new 310	java/util/jar/JarFile
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 311	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   65: astore_3
    //   66: new 313	java/io/BufferedReader
    //   69: dup
    //   70: new 315	java/io/InputStreamReader
    //   73: dup
    //   74: aload_3
    //   75: aload_3
    //   76: ldc_w 317
    //   79: invokevirtual 321	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   82: invokevirtual 325	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   85: invokespecial 328	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   88: invokespecial 331	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   91: astore_0
    //   92: aload_0
    //   93: invokevirtual 334	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   96: astore_2
    //   97: aload_2
    //   98: ifnull +90 -> 188
    //   101: aload_2
    //   102: ldc_w 336
    //   105: invokevirtual 64	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   108: ifeq -16 -> 92
    //   111: aload_2
    //   112: ldc_w 338
    //   115: invokevirtual 342	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   118: astore_2
    //   119: aload_2
    //   120: ifnull -28 -> 92
    //   123: aload_2
    //   124: arraylength
    //   125: iconst_2
    //   126: if_icmpne -34 -> 92
    //   129: aload_2
    //   130: iconst_1
    //   131: aaload
    //   132: invokevirtual 345	java/lang/String:trim	()Ljava/lang/String;
    //   135: astore_2
    //   136: ldc_w 293
    //   139: new 144	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   146: ldc_w 347
    //   149: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_2
    //   153: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 44	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_2
    //   163: invokestatic 190	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   166: istore_1
    //   167: aload_0
    //   168: ifnull +7 -> 175
    //   171: aload_0
    //   172: invokevirtual 348	java/io/BufferedReader:close	()V
    //   175: aload_3
    //   176: ifnull +7 -> 183
    //   179: aload_3
    //   180: invokevirtual 349	java/util/jar/JarFile:close	()V
    //   183: ldc 2
    //   185: monitorexit
    //   186: iload_1
    //   187: ireturn
    //   188: aload_0
    //   189: ifnull +7 -> 196
    //   192: aload_0
    //   193: invokevirtual 348	java/io/BufferedReader:close	()V
    //   196: aload_3
    //   197: ifnull +7 -> 204
    //   200: aload_3
    //   201: invokevirtual 349	java/util/jar/JarFile:close	()V
    //   204: ldc 2
    //   206: monitorexit
    //   207: iconst_m1
    //   208: ireturn
    //   209: astore_0
    //   210: ldc 2
    //   212: monitorexit
    //   213: aload_0
    //   214: athrow
    //   215: astore_3
    //   216: aconst_null
    //   217: astore_0
    //   218: aload_3
    //   219: invokestatic 352	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/Throwable;)V
    //   222: aload_0
    //   223: ifnull +7 -> 230
    //   226: aload_0
    //   227: invokevirtual 348	java/io/BufferedReader:close	()V
    //   230: aload_2
    //   231: ifnull -27 -> 204
    //   234: aload_2
    //   235: invokevirtual 349	java/util/jar/JarFile:close	()V
    //   238: goto -34 -> 204
    //   241: astore_0
    //   242: goto -38 -> 204
    //   245: astore_2
    //   246: aconst_null
    //   247: astore_0
    //   248: aconst_null
    //   249: astore_3
    //   250: aload_0
    //   251: ifnull +7 -> 258
    //   254: aload_0
    //   255: invokevirtual 348	java/io/BufferedReader:close	()V
    //   258: aload_3
    //   259: ifnull +7 -> 266
    //   262: aload_3
    //   263: invokevirtual 349	java/util/jar/JarFile:close	()V
    //   266: aload_2
    //   267: athrow
    //   268: astore_0
    //   269: goto -3 -> 266
    //   272: astore_2
    //   273: aconst_null
    //   274: astore_0
    //   275: goto -25 -> 250
    //   278: astore_2
    //   279: goto -29 -> 250
    //   282: astore 4
    //   284: aload_2
    //   285: astore_3
    //   286: aload 4
    //   288: astore_2
    //   289: goto -39 -> 250
    //   292: astore 4
    //   294: aconst_null
    //   295: astore_0
    //   296: aload_3
    //   297: astore_2
    //   298: aload 4
    //   300: astore_3
    //   301: goto -83 -> 218
    //   304: astore 4
    //   306: aload_3
    //   307: astore_2
    //   308: aload 4
    //   310: astore_3
    //   311: goto -93 -> 218
    //   314: astore_0
    //   315: goto -111 -> 204
    //   318: astore_0
    //   319: goto -136 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	paramFile	File
    //   166	21	1	i	int
    //   1	234	2	localObject1	Object
    //   245	22	2	localObject2	Object
    //   272	1	2	localObject3	Object
    //   278	7	2	localObject4	Object
    //   288	20	2	localObject5	Object
    //   65	136	3	localJarFile	java.util.jar.JarFile
    //   215	4	3	localException1	Exception
    //   249	62	3	localObject6	Object
    //   282	5	4	localObject7	Object
    //   292	7	4	localException2	Exception
    //   304	5	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   171	175	209	finally
    //   179	183	209	finally
    //   183	186	209	finally
    //   192	196	209	finally
    //   200	204	209	finally
    //   204	207	209	finally
    //   210	213	209	finally
    //   226	230	209	finally
    //   234	238	209	finally
    //   254	258	209	finally
    //   262	266	209	finally
    //   266	268	209	finally
    //   57	66	215	java/lang/Exception
    //   226	230	241	java/lang/Exception
    //   234	238	241	java/lang/Exception
    //   57	66	245	finally
    //   254	258	268	java/lang/Exception
    //   262	266	268	java/lang/Exception
    //   66	92	272	finally
    //   92	97	278	finally
    //   101	119	278	finally
    //   123	167	278	finally
    //   218	222	282	finally
    //   66	92	292	java/lang/Exception
    //   92	97	304	java/lang/Exception
    //   101	119	304	java/lang/Exception
    //   123	167	304	java/lang/Exception
    //   192	196	314	java/lang/Exception
    //   200	204	314	java/lang/Exception
    //   171	175	318	java/lang/Exception
    //   179	183	318	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.a
 * JD-Core Version:    0.7.0.1
 */