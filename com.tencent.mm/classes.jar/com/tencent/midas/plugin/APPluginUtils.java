package com.tencent.midas.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.pay.tool.APMidasTools;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APMidasRSATools;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.data.APPluginReportManager;
import com.tencent.midas.jsbridge.APWebJSBridgeActivity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class APPluginUtils
{
  private static final int BUFFER_LENGTH = 8192;
  private static final char[] HEX_DIGITS;
  private static final String TAG = "PluginUtils";
  private static Object copyFileObject;
  private static ArrayList<String> emptyResList;
  private static String[] fileList;
  static String installErrMsg;
  
  static
  {
    AppMethodBeat.i(193162);
    HEX_DIGITS = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
    installErrMsg = null;
    emptyResList = null;
    fileList = null;
    copyFileObject = new Object();
    AppMethodBeat.o(193162);
  }
  
  static void backUp(boolean paramBoolean, final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(193150);
    Object localObject = null;
    try
    {
      String str = Environment.getExternalStorageDirectory().getCanonicalPath();
      localObject = str;
    }
    catch (IOException localIOException)
    {
      label20:
      break label20;
    }
    if (TextUtils.isEmpty(localObject))
    {
      AppMethodBeat.o(193150);
      return;
    }
    new Thread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193120);
        synchronized (APPluginUtils.copyFileObject)
        {
          if (this.val$isNeedCheckMD5Copy)
          {
            String str2 = paramString1;
            String str1 = str2;
            if (str2.endsWith(".jar")) {
              str1 = str2.replace(".jar", ".apk");
            }
            long l1 = System.currentTimeMillis();
            APPluginUtils.copyFile(paramString3, this.val$sdcardPath, str1, paramString2);
            long l2 = System.currentTimeMillis();
            APLog.i("Times", "File" + str1 + "backup times:" + (l2 - l1));
          }
          AppMethodBeat.o(193120);
          return;
        }
      }
    }).start();
    AppMethodBeat.o(193150);
  }
  
  private static void callbackInMidasPluginWhenRunningInNewProcess(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(193160);
    try
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("EXTRA_CALLBACK_RESULT_CODE", paramInt);
      localIntent.putExtra("EXTRA_CALLBACK_RESULT_MSG", paramString);
      APPluginInterfaceManager.initPluginInterface(paramContext, APMidasPayHelper.MIDAS_PLUGIN_NAME, APMidasPayHelper.PKG_DISTRIBUTE, "callbackFromMidasPay", new Object[] { paramContext, localIntent });
      AppMethodBeat.o(193160);
      return;
    }
    catch (Exception paramContext)
    {
      APLog.e("PluginProxyActivity", "openPlugin error:" + paramContext.toString());
      AppMethodBeat.o(193160);
    }
  }
  
  public static void callbackInMidasPluginWithoutCaringAboutNewProcess(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(193159);
    if (paramContext == null)
    {
      APLog.e("PluginUtils", "Call back in plugin without caring process fail, null context!");
      AppMethodBeat.o(193159);
      return;
    }
    APLog.d("PluginUtils", "Call back in plugin without caring process, context ok!");
    if (APMidasPayHelper.isNewProcess(paramContext))
    {
      APLog.d("PluginUtils", "Call back in plugin without caring process, is new process!");
      callbackInMidasPluginWhenRunningInNewProcess(paramContext, paramInt, paramString);
      AppMethodBeat.o(193159);
      return;
    }
    APLog.d("PluginUtils", "Call back in plugin without caring process, not new process!");
    paramContext = new APMidasResponse();
    paramContext.resultCode = paramInt;
    paramContext.resultMsg = paramString;
    APMidasPayHelper.midasCallBack(paramContext);
    AppMethodBeat.o(193159);
  }
  
  public static boolean checkFileMD5(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193151);
    str2 = "";
    try
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        boolean bool = TextUtils.isEmpty(paramString1);
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(193151);
        return false;
      }
      paramString1 = new FileInputStream(paramString1);
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        byte[] arrayOfByte = new byte[8192];
        for (;;)
        {
          int i = paramString1.read(arrayOfByte);
          if (i == -1) {
            break;
          }
          localMessageDigest.update(arrayOfByte, 0, i);
        }
        str1 = str2;
      }
      catch (Exception localException) {}
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        String str1;
        paramString1 = null;
      }
    }
    if (paramString1 != null) {}
    for (;;)
    {
      try
      {
        paramString1.close();
        str1 = str2;
      }
      catch (IOException paramString1)
      {
        str1 = str2;
        continue;
      }
      if (!str1.equalsIgnoreCase(paramString2)) {
        continue;
      }
      AppMethodBeat.o(193151);
      return true;
      paramString1.close();
      str1 = toHexString(str1.digest());
    }
    AppMethodBeat.o(193151);
    return false;
  }
  
  public static void clearDirContent(File paramFile)
  {
    AppMethodBeat.i(193129);
    if ((paramFile != null) && ((paramFile.exists() & paramFile.isDirectory())))
    {
      APLog.d("PluginUtils", "About to clear dir, path = " + paramFile.getAbsolutePath());
      paramFile = paramFile.listFiles();
      if ((paramFile == null) || (paramFile.length == 0))
      {
        AppMethodBeat.o(193129);
        return;
      }
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramFile[i];
        if ((localObject != null) && (localObject.exists())) {
          localObject.delete();
        }
        i += 1;
      }
      AppMethodBeat.o(193129);
      return;
    }
    APLog.e("PluginUtils", "call clear dir content, but parameter error!");
    AppMethodBeat.o(193129);
  }
  
  static void copyDirect(Context paramContext, File paramFile1, File paramFile2)
  {
    AppMethodBeat.i(193155);
    if ((paramFile1 != null) && (paramFile2 != null))
    {
      paramContext = paramFile1.listFiles();
      if (paramContext == null)
      {
        AppMethodBeat.o(193155);
        return;
      }
      int i = 0;
      while (i < paramContext.length)
      {
        paramFile1 = paramContext[i];
        String str = paramFile1.getName();
        copyFile(paramFile1.getAbsolutePath(), paramFile2.getAbsolutePath(), str);
        i += 1;
      }
    }
    AppMethodBeat.o(193155);
  }
  
  static void copyEmtpyResAPKFromAssets(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(193149);
    if (!isHasBSL())
    {
      AppMethodBeat.o(193149);
      return;
    }
    String[] arrayOfString = getAssetFileList(paramContext);
    if (arrayOfString == null)
    {
      AppMethodBeat.o(193149);
      return;
    }
    int j = arrayOfString.length;
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      if (i < j)
      {
        localObject1 = arrayOfString[i];
        if ((((String)localObject1).startsWith("MidasEmptyRes")) && (((String)localObject1).endsWith(".apk")))
        {
          localObject2 = APPluginConfig.getPluginEmptyResPath(paramContext).getAbsolutePath() + File.separator + (String)localObject1;
          APLog.i("APPluginUtils", "copyEmtpyResAPKFromAssets meptyResPath:".concat(String.valueOf(localObject2)));
        }
      }
      else
      {
        try
        {
          localObject1 = paramContext.getAssets().open((String)localObject1);
          localObject2 = new File((String)localObject2);
          ((File)localObject2).createNewFile();
          localObject2 = new FileOutputStream((File)localObject2);
          byte[] arrayOfByte = new byte[1024];
          for (;;)
          {
            int k = ((InputStream)localObject1).read(arrayOfByte);
            if (k <= 0) {
              break;
            }
            ((FileOutputStream)localObject2).write(arrayOfByte, 0, k);
          }
          ((FileOutputStream)localObject2).flush();
          ((FileOutputStream)localObject2).close();
          ((InputStream)localObject1).close();
        }
        catch (IOException localIOException) {}
        AppMethodBeat.o(193149);
        return;
      }
      i += 1;
    }
  }
  
  /* Error */
  public static void copyFile(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: ldc_w 343
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 199
    //   8: astore 7
    //   10: new 201	java/io/FileInputStream
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 202	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   18: astore 6
    //   20: ldc 204
    //   22: invokestatic 210	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   25: astore 8
    //   27: new 80	java/io/File
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 327	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_0
    //   36: aload_0
    //   37: invokevirtual 244	java/io/File:exists	()Z
    //   40: ifne +8 -> 48
    //   43: aload_0
    //   44: invokevirtual 346	java/io/File:mkdir	()Z
    //   47: pop
    //   48: new 80	java/io/File
    //   51: dup
    //   52: new 94	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   59: aload_1
    //   60: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_2
    //   64: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokespecial 327	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 244	java/io/File:exists	()Z
    //   78: istore 5
    //   80: iload 5
    //   82: ifeq +29 -> 111
    //   85: aload 6
    //   87: invokevirtual 223	java/io/InputStream:close	()V
    //   90: ldc 199
    //   92: aload_3
    //   93: invokevirtual 350	java/lang/String:compareToIgnoreCase	(Ljava/lang/String;)I
    //   96: ifeq +8 -> 104
    //   99: aload_0
    //   100: invokevirtual 259	java/io/File:delete	()Z
    //   103: pop
    //   104: ldc_w 343
    //   107: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: return
    //   111: aload_0
    //   112: invokevirtual 353	java/io/File:getParentFile	()Ljava/io/File;
    //   115: invokevirtual 244	java/io/File:exists	()Z
    //   118: ifne +11 -> 129
    //   121: aload_0
    //   122: invokevirtual 353	java/io/File:getParentFile	()Ljava/io/File;
    //   125: invokevirtual 356	java/io/File:mkdirs	()Z
    //   128: pop
    //   129: aload_0
    //   130: invokevirtual 330	java/io/File:createNewFile	()Z
    //   133: pop
    //   134: new 332	java/io/FileOutputStream
    //   137: dup
    //   138: aload_0
    //   139: invokespecial 334	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   142: astore_1
    //   143: sipush 8192
    //   146: newarray byte
    //   148: astore_2
    //   149: aload 6
    //   151: aload_2
    //   152: invokevirtual 216	java/io/InputStream:read	([B)I
    //   155: istore 4
    //   157: iload 4
    //   159: iconst_m1
    //   160: if_icmpeq +69 -> 229
    //   163: aload_1
    //   164: aload_2
    //   165: iconst_0
    //   166: iload 4
    //   168: invokevirtual 337	java/io/FileOutputStream:write	([BII)V
    //   171: aload 8
    //   173: aload_2
    //   174: iconst_0
    //   175: iload 4
    //   177: invokevirtual 220	java/security/MessageDigest:update	([BII)V
    //   180: goto -31 -> 149
    //   183: astore_2
    //   184: aload 7
    //   186: astore_2
    //   187: aload 6
    //   189: ifnull +8 -> 197
    //   192: aload 6
    //   194: invokevirtual 223	java/io/InputStream:close	()V
    //   197: aload_1
    //   198: ifnull +7 -> 205
    //   201: aload_1
    //   202: invokevirtual 341	java/io/FileOutputStream:close	()V
    //   205: aload_2
    //   206: aload_3
    //   207: invokevirtual 350	java/lang/String:compareToIgnoreCase	(Ljava/lang/String;)I
    //   210: ifeq +117 -> 327
    //   213: aload_0
    //   214: ifnull +113 -> 327
    //   217: aload_0
    //   218: invokevirtual 259	java/io/File:delete	()Z
    //   221: pop
    //   222: ldc_w 343
    //   225: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: return
    //   229: aload 8
    //   231: invokevirtual 233	java/security/MessageDigest:digest	()[B
    //   234: invokestatic 237	com/tencent/midas/plugin/APPluginUtils:toHexString	([B)Ljava/lang/String;
    //   237: astore_2
    //   238: aload_1
    //   239: invokevirtual 340	java/io/FileOutputStream:flush	()V
    //   242: aload 6
    //   244: invokevirtual 223	java/io/InputStream:close	()V
    //   247: aload_1
    //   248: invokevirtual 341	java/io/FileOutputStream:close	()V
    //   251: aload_2
    //   252: aload_3
    //   253: invokevirtual 350	java/lang/String:compareToIgnoreCase	(Ljava/lang/String;)I
    //   256: ifeq +71 -> 327
    //   259: aload_0
    //   260: invokevirtual 259	java/io/File:delete	()Z
    //   263: pop
    //   264: ldc_w 343
    //   267: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: return
    //   271: astore_0
    //   272: aconst_null
    //   273: astore_1
    //   274: aconst_null
    //   275: astore_2
    //   276: aconst_null
    //   277: astore 7
    //   279: ldc 199
    //   281: astore 6
    //   283: aload 7
    //   285: ifnull +8 -> 293
    //   288: aload 7
    //   290: invokevirtual 223	java/io/InputStream:close	()V
    //   293: aload_2
    //   294: ifnull +7 -> 301
    //   297: aload_2
    //   298: invokevirtual 341	java/io/FileOutputStream:close	()V
    //   301: aload 6
    //   303: aload_3
    //   304: invokevirtual 350	java/lang/String:compareToIgnoreCase	(Ljava/lang/String;)I
    //   307: ifeq +12 -> 319
    //   310: aload_1
    //   311: ifnull +8 -> 319
    //   314: aload_1
    //   315: invokevirtual 259	java/io/File:delete	()Z
    //   318: pop
    //   319: ldc_w 343
    //   322: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   325: aload_0
    //   326: athrow
    //   327: ldc_w 343
    //   330: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   333: return
    //   334: astore_1
    //   335: goto -245 -> 90
    //   338: astore_2
    //   339: goto -38 -> 301
    //   342: astore_0
    //   343: aconst_null
    //   344: astore_1
    //   345: aconst_null
    //   346: astore_2
    //   347: ldc 199
    //   349: astore 8
    //   351: aload 6
    //   353: astore 7
    //   355: aload 8
    //   357: astore 6
    //   359: goto -76 -> 283
    //   362: astore_1
    //   363: aload_0
    //   364: astore_2
    //   365: aconst_null
    //   366: astore 9
    //   368: ldc 199
    //   370: astore 8
    //   372: aload 6
    //   374: astore 7
    //   376: aload_1
    //   377: astore_0
    //   378: aload_2
    //   379: astore_1
    //   380: aload 9
    //   382: astore_2
    //   383: aload 8
    //   385: astore 6
    //   387: goto -104 -> 283
    //   390: astore_2
    //   391: aload_0
    //   392: astore 8
    //   394: aload_1
    //   395: astore 9
    //   397: ldc 199
    //   399: astore 10
    //   401: aload 6
    //   403: astore 7
    //   405: aload_2
    //   406: astore_0
    //   407: aload 8
    //   409: astore_1
    //   410: aload 9
    //   412: astore_2
    //   413: aload 10
    //   415: astore 6
    //   417: goto -134 -> 283
    //   420: astore 8
    //   422: aload_0
    //   423: astore 9
    //   425: aload_1
    //   426: astore 10
    //   428: aload_2
    //   429: astore 11
    //   431: aload 6
    //   433: astore 7
    //   435: aload 8
    //   437: astore_0
    //   438: aload 9
    //   440: astore_1
    //   441: aload 10
    //   443: astore_2
    //   444: aload 11
    //   446: astore 6
    //   448: goto -165 -> 283
    //   451: astore_1
    //   452: goto -247 -> 205
    //   455: astore_0
    //   456: aconst_null
    //   457: astore_0
    //   458: aconst_null
    //   459: astore_1
    //   460: aconst_null
    //   461: astore 6
    //   463: aload 7
    //   465: astore_2
    //   466: goto -279 -> 187
    //   469: astore_0
    //   470: aconst_null
    //   471: astore_0
    //   472: aconst_null
    //   473: astore_1
    //   474: aload 7
    //   476: astore_2
    //   477: goto -290 -> 187
    //   480: astore_1
    //   481: aconst_null
    //   482: astore_1
    //   483: aload 7
    //   485: astore_2
    //   486: goto -299 -> 187
    //   489: astore 7
    //   491: goto -304 -> 187
    //   494: astore_1
    //   495: goto -244 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	498	0	paramString1	String
    //   0	498	1	paramString2	String
    //   0	498	2	paramString3	String
    //   0	498	3	paramString4	String
    //   155	21	4	i	int
    //   78	3	5	bool	boolean
    //   18	444	6	localObject1	Object
    //   8	476	7	localObject2	Object
    //   489	1	7	localException	Exception
    //   25	383	8	localObject3	Object
    //   420	16	8	localObject4	Object
    //   366	73	9	str1	String
    //   399	43	10	str2	String
    //   429	16	11	str3	String
    // Exception table:
    //   from	to	target	type
    //   143	149	183	java/lang/Exception
    //   149	157	183	java/lang/Exception
    //   163	180	183	java/lang/Exception
    //   229	238	183	java/lang/Exception
    //   10	20	271	finally
    //   85	90	334	java/io/IOException
    //   288	293	338	java/io/IOException
    //   297	301	338	java/io/IOException
    //   20	48	342	finally
    //   48	74	342	finally
    //   74	80	362	finally
    //   111	129	362	finally
    //   129	143	362	finally
    //   143	149	390	finally
    //   149	157	390	finally
    //   163	180	390	finally
    //   229	238	390	finally
    //   238	242	420	finally
    //   192	197	451	java/io/IOException
    //   201	205	451	java/io/IOException
    //   10	20	455	java/lang/Exception
    //   20	48	469	java/lang/Exception
    //   48	74	469	java/lang/Exception
    //   74	80	480	java/lang/Exception
    //   111	129	480	java/lang/Exception
    //   129	143	480	java/lang/Exception
    //   238	242	489	java/lang/Exception
    //   242	251	494	java/io/IOException
  }
  
  /* Error */
  public static boolean copyFile(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc_w 357
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 201	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 202	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore 5
    //   16: new 80	java/io/File
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 327	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: aload_0
    //   26: invokevirtual 244	java/io/File:exists	()Z
    //   29: ifne +8 -> 37
    //   32: aload_0
    //   33: invokevirtual 346	java/io/File:mkdir	()Z
    //   36: pop
    //   37: new 80	java/io/File
    //   40: dup
    //   41: aload_1
    //   42: aload_2
    //   43: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: astore_0
    //   47: aload_0
    //   48: invokevirtual 244	java/io/File:exists	()Z
    //   51: istore 4
    //   53: iload 4
    //   55: ifeq +16 -> 71
    //   58: aload 5
    //   60: invokevirtual 223	java/io/InputStream:close	()V
    //   63: ldc_w 357
    //   66: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: iconst_0
    //   70: ireturn
    //   71: new 332	java/io/FileOutputStream
    //   74: dup
    //   75: aload_0
    //   76: invokespecial 334	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   79: astore_1
    //   80: sipush 8192
    //   83: newarray byte
    //   85: astore_0
    //   86: aload 5
    //   88: aload_0
    //   89: invokevirtual 216	java/io/InputStream:read	([B)I
    //   92: istore_3
    //   93: iload_3
    //   94: iconst_m1
    //   95: if_icmpeq +42 -> 137
    //   98: aload_1
    //   99: aload_0
    //   100: iconst_0
    //   101: iload_3
    //   102: invokevirtual 337	java/io/FileOutputStream:write	([BII)V
    //   105: goto -19 -> 86
    //   108: astore_0
    //   109: aload_1
    //   110: astore_0
    //   111: aload 5
    //   113: ifnull +8 -> 121
    //   116: aload 5
    //   118: invokevirtual 223	java/io/InputStream:close	()V
    //   121: aload_0
    //   122: ifnull +7 -> 129
    //   125: aload_0
    //   126: invokevirtual 341	java/io/FileOutputStream:close	()V
    //   129: ldc_w 357
    //   132: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: iconst_0
    //   136: ireturn
    //   137: aload_1
    //   138: invokevirtual 340	java/io/FileOutputStream:flush	()V
    //   141: aload 5
    //   143: invokevirtual 223	java/io/InputStream:close	()V
    //   146: aload_1
    //   147: invokevirtual 341	java/io/FileOutputStream:close	()V
    //   150: ldc_w 357
    //   153: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iconst_1
    //   157: ireturn
    //   158: astore_0
    //   159: aconst_null
    //   160: astore_1
    //   161: aconst_null
    //   162: astore 5
    //   164: aload 5
    //   166: ifnull +8 -> 174
    //   169: aload 5
    //   171: invokevirtual 223	java/io/InputStream:close	()V
    //   174: aload_1
    //   175: ifnull +7 -> 182
    //   178: aload_1
    //   179: invokevirtual 341	java/io/FileOutputStream:close	()V
    //   182: ldc_w 357
    //   185: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_0
    //   189: athrow
    //   190: astore_0
    //   191: goto -128 -> 63
    //   194: astore_1
    //   195: goto -13 -> 182
    //   198: astore_0
    //   199: aconst_null
    //   200: astore_1
    //   201: goto -37 -> 164
    //   204: astore_0
    //   205: goto -41 -> 164
    //   208: astore_0
    //   209: goto -80 -> 129
    //   212: astore_0
    //   213: aconst_null
    //   214: astore_0
    //   215: aconst_null
    //   216: astore 5
    //   218: goto -107 -> 111
    //   221: astore_0
    //   222: aconst_null
    //   223: astore_0
    //   224: goto -113 -> 111
    //   227: astore_0
    //   228: goto -78 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	paramString1	String
    //   0	231	1	paramString2	String
    //   0	231	2	paramString3	String
    //   92	10	3	i	int
    //   51	3	4	bool	boolean
    //   14	203	5	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   80	86	108	java/lang/Exception
    //   86	93	108	java/lang/Exception
    //   98	105	108	java/lang/Exception
    //   137	141	108	java/lang/Exception
    //   6	16	158	finally
    //   58	63	190	java/io/IOException
    //   169	174	194	java/io/IOException
    //   178	182	194	java/io/IOException
    //   16	37	198	finally
    //   37	53	198	finally
    //   71	80	198	finally
    //   80	86	204	finally
    //   86	93	204	finally
    //   98	105	204	finally
    //   137	141	204	finally
    //   116	121	208	java/io/IOException
    //   125	129	208	java/io/IOException
    //   6	16	212	java/lang/Exception
    //   16	37	221	java/lang/Exception
    //   37	53	221	java/lang/Exception
    //   71	80	221	java/lang/Exception
    //   141	150	227	java/io/IOException
  }
  
  static void deleteBKPlugin(Context paramContext)
  {
    AppMethodBeat.i(193131);
    APLog.i("APPluginUtils", "deleteUpdatePlugin");
    deleteFiles(APPluginConfig.getPluginBackUpPath(paramContext));
    AppMethodBeat.o(193131);
  }
  
  public static void deleteDex(Context paramContext)
  {
    AppMethodBeat.i(193134);
    APLog.i("APPluginUtils", "deleteDex");
    deleteFiles(APPluginConfig.getOptimizedDexPath(paramContext));
    AppMethodBeat.o(193134);
  }
  
  public static void deleteFiles(File paramFile)
  {
    AppMethodBeat.i(193130);
    if (paramFile == null)
    {
      AppMethodBeat.o(193130);
      return;
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile == null)
      {
        AppMethodBeat.o(193130);
        return;
      }
      int i = 0;
      while (i < arrayOfFile.length)
      {
        File localFile = arrayOfFile[i];
        if ((localFile != null) && (localFile.exists())) {
          localFile.delete();
        }
        i += 1;
      }
      paramFile.delete();
      AppMethodBeat.o(193130);
      return;
    }
    paramFile.delete();
    AppMethodBeat.o(193130);
  }
  
  public static void deleteLibs(Context paramContext)
  {
    AppMethodBeat.i(193135);
    APLog.i("APPluginUtils", "deleteLibs");
    deleteFiles(APPluginConfig.getLibPath(paramContext));
    AppMethodBeat.o(193135);
  }
  
  public static void deletePlugin(Context paramContext)
  {
    AppMethodBeat.i(193133);
    APLog.i("APPluginUtils", "deletePlugin");
    deleteFiles(APPluginConfig.getPluginPath(paramContext));
    AppMethodBeat.o(193133);
  }
  
  public static void deleteUpdatePlugin(Context paramContext)
  {
    AppMethodBeat.i(193132);
    APLog.d("PluginUtils", "Calling into deleteUpdatePlugin " + Thread.currentThread().getStackTrace()[3].toString());
    deleteFiles(APPluginConfig.getPluginUpdatePath(paramContext));
    AppMethodBeat.o(193132);
  }
  
  /* Error */
  public static int extractLibs(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 408
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 413	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   9: ldc_w 415
    //   12: invokevirtual 286	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   15: ifeq +450 -> 465
    //   18: ldc_w 415
    //   21: astore_3
    //   22: ldc_w 302
    //   25: new 94	java/lang/StringBuilder
    //   28: dup
    //   29: ldc_w 417
    //   32: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: aload_3
    //   36: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 419
    //   42: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: getstatic 413	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   48: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 314	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_1
    //   58: astore 7
    //   60: aload_1
    //   61: getstatic 300	java/io/File:separator	Ljava/lang/String;
    //   64: invokevirtual 291	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   67: ifne +25 -> 92
    //   70: new 94	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   77: aload_1
    //   78: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: getstatic 300	java/io/File:separator	Ljava/lang/String;
    //   84: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: astore 7
    //   92: aconst_null
    //   93: putstatic 52	com/tencent/midas/plugin/APPluginUtils:installErrMsg	Ljava/lang/String;
    //   96: getstatic 52	com/tencent/midas/plugin/APPluginUtils:installErrMsg	Ljava/lang/String;
    //   99: ifnonnull +356 -> 455
    //   102: new 421	java/util/zip/ZipFile
    //   105: dup
    //   106: aload_0
    //   107: invokespecial 422	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   110: astore 8
    //   112: sipush 4096
    //   115: newarray byte
    //   117: astore 9
    //   119: aload 8
    //   121: invokevirtual 426	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   124: astore 10
    //   126: aload 10
    //   128: invokeinterface 431 1 0
    //   133: ifeq +322 -> 455
    //   136: aload 10
    //   138: invokeinterface 434 1 0
    //   143: checkcast 436	java/util/zip/ZipEntry
    //   146: astore 5
    //   148: aload 5
    //   150: invokevirtual 437	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   153: astore 4
    //   155: aload 4
    //   157: getstatic 300	java/io/File:separator	Ljava/lang/String;
    //   160: invokevirtual 291	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   163: ifne -37 -> 126
    //   166: aload 4
    //   168: ldc_w 439
    //   171: invokevirtual 442	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   174: ifne -48 -> 126
    //   177: aload 4
    //   179: ldc_w 444
    //   182: invokevirtual 442	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   185: ifne +14 -> 199
    //   188: aload 4
    //   190: ldc_w 446
    //   193: invokevirtual 291	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   196: ifeq -70 -> 126
    //   199: ldc_w 302
    //   202: ldc_w 448
    //   205: aload 4
    //   207: invokestatic 308	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   210: invokevirtual 312	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   213: invokestatic 314	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: new 80	java/io/File
    //   219: dup
    //   220: new 94	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   227: aload 7
    //   229: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload 4
    //   234: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokespecial 327	java/io/File:<init>	(Ljava/lang/String;)V
    //   243: astore_1
    //   244: aload 4
    //   246: getstatic 300	java/io/File:separator	Ljava/lang/String;
    //   249: invokevirtual 451	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   252: istore_2
    //   253: aload 4
    //   255: astore_0
    //   256: iload_2
    //   257: iconst_m1
    //   258: if_icmpeq +12 -> 270
    //   261: aload 4
    //   263: iload_2
    //   264: iconst_1
    //   265: iadd
    //   266: invokevirtual 455	java/lang/String:substring	(I)Ljava/lang/String;
    //   269: astore_0
    //   270: new 80	java/io/File
    //   273: dup
    //   274: new 94	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   281: aload 7
    //   283: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload_0
    //   287: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokespecial 327	java/io/File:<init>	(Ljava/lang/String;)V
    //   296: astore 4
    //   298: aload_1
    //   299: astore_0
    //   300: aload_0
    //   301: ifnull +322 -> 623
    //   304: aload_0
    //   305: invokevirtual 267	java/io/File:getName	()Ljava/lang/String;
    //   308: aload_3
    //   309: invokevirtual 459	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   312: ifeq +191 -> 503
    //   315: iconst_1
    //   316: istore_2
    //   317: iload_2
    //   318: ifeq -192 -> 126
    //   321: aload 4
    //   323: invokevirtual 353	java/io/File:getParentFile	()Ljava/io/File;
    //   326: invokevirtual 356	java/io/File:mkdirs	()Z
    //   329: pop
    //   330: aload 8
    //   332: aload 5
    //   334: invokevirtual 463	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   337: astore_0
    //   338: new 332	java/io/FileOutputStream
    //   341: dup
    //   342: aload 4
    //   344: invokespecial 334	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   347: astore_1
    //   348: aload_0
    //   349: astore 6
    //   351: aload_1
    //   352: astore 4
    //   354: aload_0
    //   355: aload 9
    //   357: invokevirtual 216	java/io/InputStream:read	([B)I
    //   360: istore_2
    //   361: iload_2
    //   362: ifle +149 -> 511
    //   365: aload_0
    //   366: astore 6
    //   368: aload_1
    //   369: astore 4
    //   371: aload_1
    //   372: aload 9
    //   374: iconst_0
    //   375: iload_2
    //   376: invokevirtual 337	java/io/FileOutputStream:write	([BII)V
    //   379: goto -31 -> 348
    //   382: astore 5
    //   384: aload_0
    //   385: astore 6
    //   387: aload_1
    //   388: astore 4
    //   390: ldc_w 465
    //   393: new 94	java/lang/StringBuilder
    //   396: dup
    //   397: ldc_w 467
    //   400: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   403: aload 5
    //   405: invokevirtual 468	java/io/IOException:toString	()Ljava/lang/String;
    //   408: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 471	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   417: aload_0
    //   418: astore 6
    //   420: aload_1
    //   421: astore 4
    //   423: aload 5
    //   425: invokestatic 475	com/tencent/midas/plugin/APPluginUtils:getFullExceptionStacktrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   428: putstatic 52	com/tencent/midas/plugin/APPluginUtils:installErrMsg	Ljava/lang/String;
    //   431: aload_1
    //   432: ifnull +7 -> 439
    //   435: aload_1
    //   436: invokevirtual 341	java/io/FileOutputStream:close	()V
    //   439: aload_0
    //   440: ifnull +7 -> 447
    //   443: aload_0
    //   444: invokevirtual 223	java/io/InputStream:close	()V
    //   447: getstatic 52	com/tencent/midas/plugin/APPluginUtils:installErrMsg	Ljava/lang/String;
    //   450: astore_0
    //   451: aload_0
    //   452: ifnull -326 -> 126
    //   455: iconst_0
    //   456: istore_2
    //   457: ldc_w 408
    //   460: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   463: iload_2
    //   464: ireturn
    //   465: getstatic 413	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   468: ldc_w 477
    //   471: invokevirtual 286	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   474: ifne +22 -> 496
    //   477: getstatic 413	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   480: ldc_w 479
    //   483: invokevirtual 286	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   486: ifeq +10 -> 496
    //   489: ldc_w 479
    //   492: astore_3
    //   493: goto -471 -> 22
    //   496: ldc_w 481
    //   499: astore_3
    //   500: goto -478 -> 22
    //   503: aload_0
    //   504: invokevirtual 353	java/io/File:getParentFile	()Ljava/io/File;
    //   507: astore_0
    //   508: goto -208 -> 300
    //   511: aload_0
    //   512: astore 6
    //   514: aload_1
    //   515: astore 4
    //   517: aload_1
    //   518: invokevirtual 340	java/io/FileOutputStream:flush	()V
    //   521: aload_1
    //   522: invokevirtual 341	java/io/FileOutputStream:close	()V
    //   525: aload_0
    //   526: ifnull -79 -> 447
    //   529: aload_0
    //   530: invokevirtual 223	java/io/InputStream:close	()V
    //   533: goto -86 -> 447
    //   536: astore_0
    //   537: goto -90 -> 447
    //   540: astore_1
    //   541: aconst_null
    //   542: astore_0
    //   543: aconst_null
    //   544: astore 4
    //   546: aload 4
    //   548: ifnull +8 -> 556
    //   551: aload 4
    //   553: invokevirtual 341	java/io/FileOutputStream:close	()V
    //   556: aload_0
    //   557: ifnull +7 -> 564
    //   560: aload_0
    //   561: invokevirtual 223	java/io/InputStream:close	()V
    //   564: ldc_w 408
    //   567: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   570: aload_1
    //   571: athrow
    //   572: astore_0
    //   573: aload_0
    //   574: invokestatic 475	com/tencent/midas/plugin/APPluginUtils:getFullExceptionStacktrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   577: putstatic 52	com/tencent/midas/plugin/APPluginUtils:installErrMsg	Ljava/lang/String;
    //   580: iconst_m1
    //   581: istore_2
    //   582: goto -125 -> 457
    //   585: astore_0
    //   586: goto -22 -> 564
    //   589: astore_1
    //   590: aconst_null
    //   591: astore 4
    //   593: goto -47 -> 546
    //   596: astore_1
    //   597: aload 6
    //   599: astore_0
    //   600: goto -54 -> 546
    //   603: astore_0
    //   604: goto -157 -> 447
    //   607: astore 5
    //   609: aconst_null
    //   610: astore_0
    //   611: aconst_null
    //   612: astore_1
    //   613: goto -229 -> 384
    //   616: astore 5
    //   618: aconst_null
    //   619: astore_1
    //   620: goto -236 -> 384
    //   623: iconst_0
    //   624: istore_2
    //   625: goto -308 -> 317
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	628	0	paramString1	String
    //   0	628	1	paramString2	String
    //   252	373	2	i	int
    //   21	479	3	str1	String
    //   153	439	4	localObject	Object
    //   146	187	5	localZipEntry	java.util.zip.ZipEntry
    //   382	42	5	localIOException1	IOException
    //   607	1	5	localIOException2	IOException
    //   616	1	5	localIOException3	IOException
    //   349	249	6	str2	String
    //   58	224	7	str3	String
    //   110	221	8	localZipFile	java.util.zip.ZipFile
    //   117	256	9	arrayOfByte	byte[]
    //   124	13	10	localEnumeration	java.util.Enumeration
    // Exception table:
    //   from	to	target	type
    //   354	361	382	java/io/IOException
    //   371	379	382	java/io/IOException
    //   517	521	382	java/io/IOException
    //   521	525	536	java/io/IOException
    //   529	533	536	java/io/IOException
    //   330	338	540	finally
    //   96	126	572	java/io/IOException
    //   126	199	572	java/io/IOException
    //   199	253	572	java/io/IOException
    //   261	270	572	java/io/IOException
    //   270	298	572	java/io/IOException
    //   304	315	572	java/io/IOException
    //   321	330	572	java/io/IOException
    //   447	451	572	java/io/IOException
    //   503	508	572	java/io/IOException
    //   564	572	572	java/io/IOException
    //   551	556	585	java/io/IOException
    //   560	564	585	java/io/IOException
    //   338	348	589	finally
    //   354	361	596	finally
    //   371	379	596	finally
    //   390	417	596	finally
    //   423	431	596	finally
    //   517	521	596	finally
    //   435	439	603	java/io/IOException
    //   443	447	603	java/io/IOException
    //   330	338	607	java/io/IOException
    //   338	348	616	java/io/IOException
  }
  
  private static String[] getAssetFileList(Context paramContext)
  {
    AppMethodBeat.i(193141);
    try
    {
      if (fileList == null)
      {
        long l = System.currentTimeMillis();
        fileList = paramContext.getAssets().list("");
        APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), "sdk.plugin.init.getFileListFromAssets.time", l);
      }
      paramContext = fileList;
      AppMethodBeat.o(193141);
      return paramContext;
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        APLog.w("APPLuginUtils", "getPluginNameFromAssets e:" + paramContext.getMessage());
      }
    }
  }
  
  /* Error */
  static int getAssetsVersionCode(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 519
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_2
    //   10: aload_0
    //   11: invokevirtual 320	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   14: ldc_w 521
    //   17: invokevirtual 326	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   20: astore 4
    //   22: aload 4
    //   24: astore_2
    //   25: aload 4
    //   27: astore_3
    //   28: aload_0
    //   29: aload 4
    //   31: invokestatic 525	com/tencent/midas/plugin/APPluginUtils:getZipVersionCodeWtihStream	(Landroid/content/Context;Ljava/io/InputStream;)I
    //   34: istore_1
    //   35: aload 4
    //   37: ifnull +8 -> 45
    //   40: aload 4
    //   42: invokevirtual 223	java/io/InputStream:close	()V
    //   45: ldc_w 519
    //   48: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iload_1
    //   52: ireturn
    //   53: astore_0
    //   54: aload_2
    //   55: astore_3
    //   56: aload_0
    //   57: invokestatic 475	com/tencent/midas/plugin/APPluginUtils:getFullExceptionStacktrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   60: putstatic 52	com/tencent/midas/plugin/APPluginUtils:installErrMsg	Ljava/lang/String;
    //   63: aload_2
    //   64: ifnull +7 -> 71
    //   67: aload_2
    //   68: invokevirtual 223	java/io/InputStream:close	()V
    //   71: ldc_w 527
    //   74: ldc_w 529
    //   77: invokestatic 314	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: ldc_w 519
    //   83: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: iconst_0
    //   87: ireturn
    //   88: astore_0
    //   89: aload_3
    //   90: ifnull +7 -> 97
    //   93: aload_3
    //   94: invokevirtual 223	java/io/InputStream:close	()V
    //   97: ldc_w 519
    //   100: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_0
    //   104: athrow
    //   105: astore_0
    //   106: goto -61 -> 45
    //   109: astore_0
    //   110: goto -39 -> 71
    //   113: astore_2
    //   114: goto -17 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramContext	Context
    //   34	18	1	i	int
    //   9	59	2	localObject1	Object
    //   113	1	2	localIOException	IOException
    //   7	87	3	localObject2	Object
    //   20	21	4	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   10	22	53	java/lang/Exception
    //   28	35	53	java/lang/Exception
    //   10	22	88	finally
    //   28	35	88	finally
    //   56	63	88	finally
    //   40	45	105	java/io/IOException
    //   67	71	109	java/io/IOException
    //   93	97	113	java/io/IOException
  }
  
  public static File getDataZipFile(Context paramContext)
  {
    AppMethodBeat.i(193137);
    paramContext = APMidasPayAPI.getPath();
    if (!TextUtils.isEmpty(paramContext))
    {
      APLog.i("APPluginUtils", "getDataZipFile sPath:".concat(String.valueOf(paramContext)));
      paramContext = new File(paramContext);
      if ((paramContext.getName().startsWith("MidasPay")) && (paramContext.getName().endsWith(".zip")))
      {
        AppMethodBeat.o(193137);
        return paramContext;
      }
    }
    AppMethodBeat.o(193137);
    return null;
  }
  
  public static String getExceptionInfo(Throwable paramThrowable)
  {
    AppMethodBeat.i(193146);
    while (paramThrowable.getCause() != null) {
      paramThrowable = paramThrowable.getCause();
    }
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter, true));
    paramThrowable = localStringWriter.getBuffer().toString();
    AppMethodBeat.o(193146);
    return paramThrowable;
  }
  
  /* Error */
  public static String getFullExceptionStacktrace(Throwable paramThrowable)
  {
    // Byte code:
    //   0: ldc_w 570
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 552	java/io/StringWriter
    //   9: dup
    //   10: invokespecial 553	java/io/StringWriter:<init>	()V
    //   13: astore_2
    //   14: new 555	java/io/PrintWriter
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 573	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   22: astore_1
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 562	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   28: aload_2
    //   29: invokevirtual 574	java/io/StringWriter:toString	()Ljava/lang/String;
    //   32: astore_0
    //   33: aload_2
    //   34: invokevirtual 575	java/io/StringWriter:close	()V
    //   37: aload_1
    //   38: invokevirtual 576	java/io/PrintWriter:close	()V
    //   41: ldc_w 570
    //   44: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_0
    //   48: areturn
    //   49: astore_0
    //   50: aconst_null
    //   51: astore_1
    //   52: aconst_null
    //   53: astore_2
    //   54: aload_2
    //   55: ifnull +7 -> 62
    //   58: aload_2
    //   59: invokevirtual 575	java/io/StringWriter:close	()V
    //   62: aload_1
    //   63: ifnull +7 -> 70
    //   66: aload_1
    //   67: invokevirtual 576	java/io/PrintWriter:close	()V
    //   70: ldc_w 570
    //   73: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_0
    //   77: athrow
    //   78: astore_1
    //   79: goto -9 -> 70
    //   82: astore_0
    //   83: aconst_null
    //   84: astore_1
    //   85: goto -31 -> 54
    //   88: astore_0
    //   89: goto -35 -> 54
    //   92: astore_1
    //   93: goto -52 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramThrowable	Throwable
    //   22	45	1	localPrintWriter	PrintWriter
    //   78	1	1	localIOException1	IOException
    //   84	1	1	localObject	Object
    //   92	1	1	localIOException2	IOException
    //   13	46	2	localStringWriter	StringWriter
    // Exception table:
    //   from	to	target	type
    //   6	14	49	finally
    //   58	62	78	java/io/IOException
    //   66	70	78	java/io/IOException
    //   14	23	82	finally
    //   23	33	88	finally
    //   33	41	92	java/io/IOException
  }
  
  public static String getInitErrorMsg()
  {
    return installErrMsg;
  }
  
  public static File getInstallPath(Context paramContext, String paramString)
  {
    AppMethodBeat.i(193128);
    paramContext = APPluginInstallerAndUpdater.getInstallPath(paramContext, paramString);
    AppMethodBeat.o(193128);
    return paramContext;
  }
  
  public static String getInstallPathString(Context paramContext, String paramString)
  {
    AppMethodBeat.i(193125);
    paramContext = APPluginInstallerAndUpdater.getInstallPathString(paramContext, paramString);
    AppMethodBeat.o(193125);
    return paramContext;
  }
  
  public static File getLibPath(Context paramContext)
  {
    AppMethodBeat.i(193126);
    paramContext = APPluginConfig.getLibPath(paramContext);
    AppMethodBeat.o(193126);
    return paramContext;
  }
  
  public static String getMD5FromPath(String paramString)
  {
    AppMethodBeat.i(193156);
    String str2 = "";
    String str1 = str2;
    int i;
    int j;
    if (!TextUtils.isEmpty(paramString))
    {
      i = paramString.lastIndexOf(".apk");
      j = paramString.lastIndexOf("_");
      str1 = str2;
      if (i != -1)
      {
        str1 = str2;
        if (j == -1) {}
      }
    }
    try
    {
      str1 = paramString.substring(j + 1, i);
      AppMethodBeat.o(193156);
      return str1;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        str1 = str2;
      }
    }
  }
  
  public static String getMidasCoreVersionName(Context paramContext)
  {
    AppMethodBeat.i(193143);
    Object localObject1 = APPluginConfig.getPluginPath(paramContext);
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((File)localObject1).listFiles();
      i = 0;
      if (i < localObject1.length)
      {
        localObject2 = localObject1[i];
        if (!localObject2.getName().startsWith("MidasCore")) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = localObject2.getCanonicalPath();
        paramContext = getPackageInfo(paramContext, (String)localObject1);
        if (paramContext == null) {
          break label87;
        }
        paramContext = paramContext.versionName;
        AppMethodBeat.o(193143);
        return paramContext;
      }
      catch (IOException localIOException)
      {
        str = "";
        continue;
      }
      i += 1;
      break;
      label87:
      paramContext = "";
      continue;
      String str = "";
    }
  }
  
  public static ArrayList<String> getMidasEmptyPaht(Context paramContext)
  {
    AppMethodBeat.i(193144);
    int i;
    if (emptyResList == null)
    {
      emptyResList = new ArrayList();
      paramContext = APPluginConfig.getPluginEmptyResPath(paramContext);
      if (paramContext != null)
      {
        paramContext = paramContext.listFiles();
        i = 0;
      }
    }
    for (;;)
    {
      String str;
      if (i < paramContext.length)
      {
        str = paramContext[i];
        if ((!str.getName().startsWith("MidasEmptyRes")) || (!str.getName().endsWith(".apk"))) {}
      }
      try
      {
        str = str.getCanonicalPath();
        emptyResList.add(str);
        label87:
        i += 1;
        continue;
        paramContext = emptyResList;
        AppMethodBeat.o(193144);
        return paramContext;
      }
      catch (IOException localIOException)
      {
        break label87;
      }
    }
  }
  
  public static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(193145);
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(193145);
      return null;
    }
    PackageInfo localPackageInfo = (PackageInfo)APPluginInstallerAndUpdater.sPackageInfoMap.get(paramString);
    paramContext = localPackageInfo;
    if (localPackageInfo == null)
    {
      localPackageInfo = localPackageManager.getPackageArchiveInfo(paramString, 128);
      paramContext = localPackageInfo;
      if (localPackageInfo != null)
      {
        APPluginInstallerAndUpdater.sPackageInfoMap.put(paramString, localPackageInfo);
        paramContext = localPackageInfo;
      }
    }
    AppMethodBeat.o(193145);
    return paramContext;
  }
  
  /* Error */
  static int getZipVersionCodeWtihFileName(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc_w 650
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 652
    //   9: ldc_w 654
    //   12: aload_1
    //   13: invokestatic 308	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   16: invokevirtual 312	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokestatic 314	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: new 201	java/io/FileInputStream
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 202	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   30: astore_3
    //   31: aload_3
    //   32: astore_1
    //   33: aload_0
    //   34: aload_3
    //   35: invokestatic 525	com/tencent/midas/plugin/APPluginUtils:getZipVersionCodeWtihStream	(Landroid/content/Context;Ljava/io/InputStream;)I
    //   38: istore_2
    //   39: aload_3
    //   40: invokevirtual 655	java/io/FileInputStream:close	()V
    //   43: ldc_w 650
    //   46: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: iload_2
    //   50: ireturn
    //   51: astore 4
    //   53: aconst_null
    //   54: astore_0
    //   55: aload_0
    //   56: astore_1
    //   57: aload 4
    //   59: invokestatic 475	com/tencent/midas/plugin/APPluginUtils:getFullExceptionStacktrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   62: putstatic 52	com/tencent/midas/plugin/APPluginUtils:installErrMsg	Ljava/lang/String;
    //   65: aload_0
    //   66: ifnull +7 -> 73
    //   69: aload_0
    //   70: invokevirtual 655	java/io/FileInputStream:close	()V
    //   73: ldc_w 657
    //   76: ldc_w 529
    //   79: invokestatic 314	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: ldc_w 650
    //   85: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: iconst_0
    //   89: ireturn
    //   90: astore_0
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 655	java/io/FileInputStream:close	()V
    //   101: ldc_w 650
    //   104: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_0
    //   108: athrow
    //   109: astore_0
    //   110: goto -67 -> 43
    //   113: astore_0
    //   114: goto -41 -> 73
    //   117: astore_1
    //   118: goto -17 -> 101
    //   121: astore_0
    //   122: goto -29 -> 93
    //   125: astore 4
    //   127: aload_3
    //   128: astore_0
    //   129: goto -74 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramContext	Context
    //   0	132	1	paramString	String
    //   38	12	2	i	int
    //   30	98	3	localFileInputStream	FileInputStream
    //   51	7	4	localException1	Exception
    //   125	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   22	31	51	java/lang/Exception
    //   22	31	90	finally
    //   39	43	109	java/io/IOException
    //   69	73	113	java/io/IOException
    //   97	101	117	java/io/IOException
    //   33	39	121	finally
    //   57	65	121	finally
    //   33	39	125	java/lang/Exception
  }
  
  /* Error */
  private static int getZipVersionCodeWtihStream(Context paramContext, InputStream paramInputStream)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: ldc_w 658
    //   8: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: new 660	java/util/zip/ZipInputStream
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 663	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: astore 5
    //   21: aload 5
    //   23: astore_0
    //   24: aload 5
    //   26: invokevirtual 667	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   29: astore_1
    //   30: aload 5
    //   32: astore_0
    //   33: ldc_w 652
    //   36: ldc_w 669
    //   39: aload_1
    //   40: invokestatic 308	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   43: invokevirtual 312	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   46: invokestatic 314	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: iload 4
    //   51: istore_2
    //   52: aload_1
    //   53: ifnull +125 -> 178
    //   56: aload 5
    //   58: astore_0
    //   59: aload_1
    //   60: invokevirtual 437	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   63: astore 6
    //   65: aload 5
    //   67: astore_0
    //   68: ldc_w 652
    //   71: ldc_w 448
    //   74: aload 6
    //   76: invokestatic 308	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   79: invokevirtual 312	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   82: invokestatic 314	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload 5
    //   87: astore_0
    //   88: aload_1
    //   89: invokevirtual 670	java/util/zip/ZipEntry:isDirectory	()Z
    //   92: ifne +17 -> 109
    //   95: aload 5
    //   97: astore_0
    //   98: aload 6
    //   100: ldc_w 439
    //   103: invokevirtual 442	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   106: ifeq +15 -> 121
    //   109: aload 5
    //   111: astore_0
    //   112: aload 5
    //   114: invokevirtual 667	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   117: astore_1
    //   118: goto -69 -> 49
    //   121: aload 5
    //   123: astore_0
    //   124: aload 6
    //   126: ldc_w 602
    //   129: invokevirtual 286	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   132: ifeq +75 -> 207
    //   135: aload 5
    //   137: astore_0
    //   138: aload 6
    //   140: ldc_w 672
    //   143: invokevirtual 291	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   146: ifeq +61 -> 207
    //   149: aload 5
    //   151: astore_0
    //   152: aload 6
    //   154: iconst_0
    //   155: aload 6
    //   157: ldc_w 672
    //   160: invokevirtual 451	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   163: invokevirtual 597	java/lang/String:substring	(II)Ljava/lang/String;
    //   166: ldc_w 594
    //   169: invokevirtual 675	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   172: iconst_2
    //   173: aaload
    //   174: invokestatic 680	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   177: istore_2
    //   178: aload 5
    //   180: invokevirtual 681	java/util/zip/ZipInputStream:close	()V
    //   183: ldc_w 657
    //   186: ldc_w 683
    //   189: iload_2
    //   190: invokestatic 685	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   193: invokevirtual 312	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   196: invokestatic 314	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: ldc_w 658
    //   202: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: iload_2
    //   206: ireturn
    //   207: aload 5
    //   209: astore_0
    //   210: aload 5
    //   212: invokevirtual 667	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   215: astore_1
    //   216: goto -167 -> 49
    //   219: astore 6
    //   221: aconst_null
    //   222: astore_1
    //   223: aload_1
    //   224: astore_0
    //   225: aload 6
    //   227: invokestatic 475	com/tencent/midas/plugin/APPluginUtils:getFullExceptionStacktrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   230: putstatic 52	com/tencent/midas/plugin/APPluginUtils:installErrMsg	Ljava/lang/String;
    //   233: iload_3
    //   234: istore_2
    //   235: aload_1
    //   236: ifnull -53 -> 183
    //   239: aload_1
    //   240: invokevirtual 681	java/util/zip/ZipInputStream:close	()V
    //   243: iload_3
    //   244: istore_2
    //   245: goto -62 -> 183
    //   248: astore_0
    //   249: iload_3
    //   250: istore_2
    //   251: goto -68 -> 183
    //   254: astore_1
    //   255: aconst_null
    //   256: astore_0
    //   257: aload_0
    //   258: ifnull +7 -> 265
    //   261: aload_0
    //   262: invokevirtual 681	java/util/zip/ZipInputStream:close	()V
    //   265: ldc_w 658
    //   268: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: aload_1
    //   272: athrow
    //   273: astore_0
    //   274: goto -91 -> 183
    //   277: astore_0
    //   278: goto -13 -> 265
    //   281: astore_1
    //   282: goto -25 -> 257
    //   285: astore 6
    //   287: aload 5
    //   289: astore_1
    //   290: goto -67 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramContext	Context
    //   0	293	1	paramInputStream	InputStream
    //   51	200	2	i	int
    //   1	249	3	j	int
    //   3	47	4	k	int
    //   19	269	5	localZipInputStream	java.util.zip.ZipInputStream
    //   63	93	6	str	String
    //   219	7	6	localException1	Exception
    //   285	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   11	21	219	java/lang/Exception
    //   239	243	248	java/lang/Exception
    //   11	21	254	finally
    //   178	183	273	java/lang/Exception
    //   261	265	277	java/lang/Exception
    //   24	30	281	finally
    //   33	49	281	finally
    //   59	65	281	finally
    //   68	85	281	finally
    //   88	95	281	finally
    //   98	109	281	finally
    //   112	118	281	finally
    //   124	135	281	finally
    //   138	149	281	finally
    //   152	178	281	finally
    //   210	216	281	finally
    //   225	233	281	finally
    //   24	30	285	java/lang/Exception
    //   33	49	285	java/lang/Exception
    //   59	65	285	java/lang/Exception
    //   68	85	285	java/lang/Exception
    //   88	95	285	java/lang/Exception
    //   98	109	285	java/lang/Exception
    //   112	118	285	java/lang/Exception
    //   124	135	285	java/lang/Exception
    //   138	149	285	java/lang/Exception
    //   152	178	285	java/lang/Exception
    //   210	216	285	java/lang/Exception
  }
  
  private static boolean isHasBSL()
  {
    boolean bool2 = true;
    AppMethodBeat.i(193148);
    try
    {
      Class.forName("com.tencent.theme.SkinEngine").getMethod("getInstances", new Class[0]);
      bool1 = true;
    }
    catch (Exception localException1)
    {
      boolean bool1;
      for (;;)
      {
        APLog.w("APPluginContext", " is not has com.tencent.theme.SkinEngine e:" + localException1.toString());
        bool1 = false;
      }
    }
    if (!bool1)
    {
      try
      {
        Class.forName("com.tencent.component.theme.SkinEngine").getMethod("getInstances", new Class[0]);
        bool1 = bool2;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          APLog.w("APPluginContext", " is not has com.tencent.component.theme.SkinEngine e:" + localException2.toString());
          bool1 = false;
        }
      }
      AppMethodBeat.o(193148);
      return bool1;
    }
  }
  
  static void readSingInfo(HashMap<String, String> paramHashMap, File paramFile)
  {
    AppMethodBeat.i(193124);
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader(paramFile.getCanonicalPath()));
      APMidasRSATools localAPMidasRSATools = new APMidasRSATools();
      for (paramFile = localBufferedReader.readLine(); (paramFile != null) && (!TextUtils.isEmpty(paramFile)); paramFile = localBufferedReader.readLine())
      {
        Object localObject = paramFile.split("\\:");
        paramFile = localObject[0];
        localObject = localAPMidasRSATools.deCodeKey(localObject[1]);
        localObject = ((String)localObject).substring(((String)localObject).length() - 32);
        paramHashMap.put(paramFile.split("\\_")[0], localObject);
      }
      localBufferedReader.close();
      AppMethodBeat.o(193124);
      return;
    }
    catch (FileNotFoundException paramHashMap)
    {
      AppMethodBeat.o(193124);
      return;
    }
    catch (IOException paramHashMap)
    {
      AppMethodBeat.o(193124);
    }
  }
  
  static void readSingInfoItems(HashMap<String, APSignIniItem> paramHashMap, File paramFile)
  {
    AppMethodBeat.i(193123);
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader(paramFile.getCanonicalPath()));
      APMidasRSATools localAPMidasRSATools = new APMidasRSATools();
      for (paramFile = localBufferedReader.readLine(); (paramFile != null) && (!TextUtils.isEmpty(paramFile)); paramFile = localBufferedReader.readLine())
      {
        paramFile = paramFile.split("\\:");
        String str2 = paramFile[0];
        String str1 = localAPMidasRSATools.deCodeKey(paramFile[1]);
        str1 = str1.substring(str1.length() - 32);
        str2 = str2.split("\\_")[0];
        APSignIniItem localAPSignIniItem = new APSignIniItem();
        localAPSignIniItem.name = str2;
        localAPSignIniItem.md5 = str1;
        localAPSignIniItem.fullName = paramFile[0];
        paramHashMap.put(str2, localAPSignIniItem);
      }
      localBufferedReader.close();
      AppMethodBeat.o(193123);
      return;
    }
    catch (FileNotFoundException paramHashMap)
    {
      AppMethodBeat.o(193123);
      return;
    }
    catch (IOException paramHashMap)
    {
      AppMethodBeat.o(193123);
    }
  }
  
  public static void release()
  {
    AppMethodBeat.i(193136);
    APPluginInstallerAndUpdater.sInstallPathMap.clear();
    APPluginInstallerAndUpdater.sPackageInfoMap.clear();
    AppMethodBeat.o(193136);
  }
  
  static void showLaunchPluginFail(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(193158);
    APLog.d("PluginUtils", "Calling into showLaunchPluginFail, needToPureH5Pay = " + paramBoolean + " caller = " + Thread.currentThread().getStackTrace()[3].toString());
    if (!TextUtils.isEmpty(paramString)) {
      APPluginReportManager.getInstance().reportImmediatelyOneRecord("launchpay", "sdk.plugin.launch.error", paramString);
    }
    if (paramBoolean)
    {
      if (APWebJSBridgeActivity.startPureH5Pay(paramContext, paramString, "showLaunchPluginFail"))
      {
        AppMethodBeat.o(193158);
        return;
      }
      if ((paramString == null) || ((!paramString.contains("空间")) && (!paramString.contains("Space")))) {
        break label141;
      }
      Toast.makeText(paramContext, "系统可用内存不足，请退出重试", 0).show();
    }
    for (;;)
    {
      callbackInMidasPluginWithoutCaringAboutNewProcess(paramContext, 100, "Unexpected error!");
      AppMethodBeat.o(193158);
      return;
      label141:
      if ((!TextUtils.isEmpty(paramString)) && ((paramString.contains("webview")) || (paramString.contains("Webview")))) {
        Toast.makeText(paramContext, "系统组件缺失，请退出重试", 0).show();
      } else {
        Toast.makeText(paramContext, "系统繁忙，请退出重试", 0).show();
      }
    }
  }
  
  public static String toHexString(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(193152);
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(HEX_DIGITS[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(HEX_DIGITS[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    paramArrayOfByte = localStringBuilder.toString();
    AppMethodBeat.o(193152);
    return paramArrayOfByte;
  }
  
  public static void unInstallPlugin(Context paramContext)
  {
    AppMethodBeat.i(193127);
    APLog.d("PluginUtils", "unInstallPlugin " + Thread.currentThread().getStackTrace()[3].toString());
    APPluginInstallerAndUpdater.unInstallPlugin(paramContext);
    AppMethodBeat.o(193127);
  }
  
  public static void updateLibExtendNum()
  {
    AppMethodBeat.i(193157);
    APPluginConfig.libExtend += 1;
    APLog.i("APPluginUtils", "updateLibExtendNum libExtend:" + APPluginConfig.libExtend);
    AppMethodBeat.o(193157);
  }
  
  public static HashMap<String, String> url2Map(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(193161);
    HashMap localHashMap = new HashMap();
    Object localObject = paramString.split("\\?");
    if (localObject == null)
    {
      AppMethodBeat.o(193161);
      return null;
    }
    if (localObject.length == 1) {
      paramString = localObject[0];
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          arrayOfString = paramString.split("\\&");
          paramString = "";
          localObject = "";
          int j = arrayOfString.length;
          if (i >= j) {
            continue;
          }
        }
      }
      catch (Exception paramString)
      {
        String[] arrayOfString;
        String str1;
        String str2;
        APLog.w("url2Map", paramString.toString());
        continue;
      }
      try
      {
        str1 = arrayOfString[i].split("\\=")[0];
        paramString = str1;
        str2 = arrayOfString[i].split("\\=")[1];
        localObject = str2;
        paramString = str1;
      }
      catch (Exception localException)
      {
        continue;
      }
      if (!TextUtils.isEmpty(paramString)) {
        localHashMap.put(paramString, localObject);
      }
      i += 1;
      continue;
      if (localObject.length == 2) {
        paramString = localObject[1];
      }
    }
    APLog.i("url2Map", "url后参数为空");
    AppMethodBeat.o(193161);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.plugin.APPluginUtils
 * JD-Core Version:    0.7.0.1
 */