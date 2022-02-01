package com.tencent.open.appcommon;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.js.AsyncMethodMap;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Common
{
  protected static final String A = "/mnt/sdcard-ext";
  public static final String B = "sd://";
  public static final String C = "file:///";
  public static final String D = "file:///android_asset" + File.separator + "Page/system";
  public static final String E = "applist.db";
  public static final int a = 2;
  public static final String n = "Common";
  public static final String o = "qzoneappcenter";
  public static final String p = ".AppCenterWebBuffer_QQ";
  public static final String q = "qapp_social_apps.html";
  public static final String r = "qapp_center_index.htm";
  public static final String s = "qapp_center_detail.htm";
  public static final String t = "system_old_";
  public static final String u = "tmp";
  public static final String v = "user";
  public static final String w = "resource.zip";
  public static final String x = "resource.diff";
  public static final String y = "resource_merged.zip";
  public static final String z = "Page/system";
  
  public static int a()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).getInt("appTabVersionCode", -1);
  }
  
  public static long a()
  {
    StatFs localStatFs = new StatFs(f());
    return localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
  }
  
  /* Error */
  public static long a(java.io.InputStream paramInputStream, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 75	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 132	java/io/File:exists	()Z
    //   13: ifne +8 -> 21
    //   16: aload_1
    //   17: invokevirtual 135	java/io/File:mkdir	()Z
    //   20: pop
    //   21: new 75	java/io/File
    //   24: dup
    //   25: aload_1
    //   26: aload_2
    //   27: invokespecial 138	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   30: astore 4
    //   32: new 140	java/io/FileOutputStream
    //   35: dup
    //   36: aload 4
    //   38: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   41: astore_2
    //   42: aload_2
    //   43: astore_1
    //   44: sipush 4096
    //   47: newarray byte
    //   49: astore 5
    //   51: aload_2
    //   52: astore_1
    //   53: aload_0
    //   54: aload 5
    //   56: invokevirtual 149	java/io/InputStream:read	([B)I
    //   59: istore_3
    //   60: iconst_m1
    //   61: iload_3
    //   62: if_icmpeq +32 -> 94
    //   65: aload_2
    //   66: astore_1
    //   67: aload_2
    //   68: aload 5
    //   70: iconst_0
    //   71: iload_3
    //   72: invokevirtual 153	java/io/FileOutputStream:write	([BII)V
    //   75: goto -24 -> 51
    //   78: astore_0
    //   79: aload_2
    //   80: astore_1
    //   81: aload_0
    //   82: athrow
    //   83: astore_0
    //   84: aload_1
    //   85: ifnull +7 -> 92
    //   88: aload_1
    //   89: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   92: aload_0
    //   93: athrow
    //   94: aload_2
    //   95: astore_1
    //   96: aload_2
    //   97: invokevirtual 159	java/io/FileOutputStream:flush	()V
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   108: aload 4
    //   110: invokevirtual 162	java/io/File:length	()J
    //   113: lreturn
    //   114: astore_0
    //   115: goto -7 -> 108
    //   118: astore_1
    //   119: goto -27 -> 92
    //   122: astore_0
    //   123: aconst_null
    //   124: astore_1
    //   125: goto -41 -> 84
    //   128: astore_0
    //   129: aconst_null
    //   130: astore_1
    //   131: goto -50 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramInputStream	java.io.InputStream
    //   0	134	1	paramString1	String
    //   0	134	2	paramString2	String
    //   59	13	3	i	int
    //   30	79	4	localFile	File
    //   49	20	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   44	51	78	java/lang/Exception
    //   53	60	78	java/lang/Exception
    //   67	75	78	java/lang/Exception
    //   96	100	78	java/lang/Exception
    //   44	51	83	finally
    //   53	60	83	finally
    //   67	75	83	finally
    //   81	83	83	finally
    //   96	100	83	finally
    //   104	108	114	java/lang/Exception
    //   88	92	118	java/lang/Exception
    //   32	42	122	finally
    //   32	42	128	java/lang/Exception
  }
  
  public static File a()
  {
    Object localObject;
    if (Environment.getExternalStorageState().equals("mounted")) {
      localObject = Environment.getExternalStorageDirectory();
    }
    File localFile;
    do
    {
      return localObject;
      localFile = new File("/mnt/sdcard-ext");
      localObject = localFile;
    } while (localFile.isDirectory());
    return null;
  }
  
  public static String a(WebView paramWebView, HashMap paramHashMap, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray1 = new JSONArray();
    label699:
    for (;;)
    {
      try
      {
        localJSONObject.put("r", "-1");
        localJSONObject.put("data", localJSONArray1);
        JSONArray localJSONArray2 = new JSONArray(URLDecoder.decode(paramString, "UTF-8"));
        int i = 0;
        String str1;
        String str2;
        Object localObject;
        if (i < localJSONArray2.length())
        {
          paramWebView = localJSONArray2.optJSONObject(i);
          if (paramWebView == null) {
            break label699;
          }
          paramString = paramWebView.optString("ns");
          str1 = paramWebView.optString("method");
          str2 = paramWebView.optString("guid");
          paramWebView = paramWebView.optString("args");
          localObject = new ArrayList();
        }
        int j;
        Method[] arrayOfMethod;
        int k;
        i += 1;
      }
      catch (UnsupportedEncodingException paramWebView)
      {
        try
        {
          paramWebView = new JSONArray(paramWebView);
          j = 0;
          if (j < paramWebView.length())
          {
            ((List)localObject).add(paramWebView.getString(j));
            j += 1;
          }
          else
          {
            paramWebView = (Class)AsyncMethodMap.jdField_a_of_type_JavaUtilHashMap.get(paramString);
            if (AsyncMethodMap.jdField_a_of_type_JavaUtilArrayList.contains(str1)) {
              ((List)localObject).add(str2);
            }
            if (paramWebView != null)
            {
              arrayOfMethod = paramWebView.getMethods();
              k = arrayOfMethod.length;
              j = 0;
              if (j < k)
              {
                paramWebView = arrayOfMethod[j];
                if ((paramWebView.getName().equals(str1)) && (paramWebView.getParameterTypes().length == ((List)localObject).size()))
                {
                  if (paramWebView == null) {
                    break label699;
                  }
                  paramString = paramHashMap.get(paramString);
                  try
                  {
                    LogUtility.c("Common", "callBatch <call> class : " + paramString.getClass().getName() + " , method : " + str1 + "\n , args : " + localObject.toString());
                    if (((List)localObject).size() != 0) {
                      continue;
                    }
                    paramString = paramWebView.invoke(paramString, new Object[0]);
                    paramWebView = paramWebView.getReturnType();
                    if ((paramWebView == Void.TYPE) || (paramWebView == Void.class) || (paramString == null)) {
                      break label699;
                    }
                    if (!(paramString instanceof String)) {
                      continue;
                    }
                    ((String)paramString).replace("\\", "\\\\").replace("'", "\\'");
                    paramWebView = (String)paramString;
                    paramString = new JSONObject();
                    localObject = new JSONArray();
                    paramString.put("guid", str2);
                    paramString.put("r", 0);
                    paramString.put("data", paramWebView);
                    ((JSONArray)localObject).put("interface." + str1);
                    ((JSONArray)localObject).put(paramString);
                    localJSONArray1.put(localObject);
                  }
                  catch (Exception paramWebView)
                  {
                    LogUtility.c("Common", "callBatch error", paramWebView);
                  }
                  paramWebView = paramWebView;
                  LogUtility.b("Common", "callBatch decode params format err", paramWebView);
                  return localJSONObject.toString();
                }
              }
            }
          }
        }
        catch (Exception paramWebView)
        {
          LogUtility.e("Common", "callBatch args error : " + paramWebView.toString());
        }
      }
      catch (JSONException paramWebView)
      {
        LogUtility.b("Common", "callBatch request params format err", paramWebView);
        continue;
        j += 1;
        continue;
        paramString = paramWebView.invoke(paramString, ((List)localObject).toArray());
        continue;
        if (((paramString instanceof Number)) || ((paramString instanceof Long)) || ((paramString instanceof Integer)) || ((paramString instanceof Double)) || ((paramString instanceof Float)))
        {
          paramWebView = paramString.toString();
        }
        else if ((paramString instanceof Boolean))
        {
          paramWebView = paramString.toString();
          continue;
          localJSONObject.put("r", 0);
          localJSONObject.put("data", localJSONArray1);
          LogUtility.c("Common", "Response<callBatch> syncCallBatch result : " + localJSONObject);
        }
        else
        {
          paramWebView = "";
          continue;
          paramWebView = null;
        }
      }
    }
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 373	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 374	java/lang/StringBuffer:<init>	()V
    //   7: astore 4
    //   9: new 75	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_2
    //   18: aload_2
    //   19: invokevirtual 132	java/io/File:exists	()Z
    //   22: ifne +33 -> 55
    //   25: ldc_w 376
    //   28: new 64	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 378
    //   38: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_0
    //   42: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 294	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: ldc_w 369
    //   54: areturn
    //   55: new 380	java/io/InputStreamReader
    //   58: dup
    //   59: new 382	java/io/FileInputStream
    //   62: dup
    //   63: aload_2
    //   64: invokespecial 383	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   67: invokespecial 386	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   70: astore_2
    //   71: aload_2
    //   72: astore_0
    //   73: aload_2
    //   74: invokevirtual 390	java/io/Reader:read	()I
    //   77: istore_1
    //   78: iload_1
    //   79: iconst_m1
    //   80: if_icmpeq +58 -> 138
    //   83: iload_1
    //   84: i2c
    //   85: bipush 13
    //   87: if_icmpeq -16 -> 71
    //   90: iload_1
    //   91: i2c
    //   92: bipush 10
    //   94: if_icmpeq -23 -> 71
    //   97: iload_1
    //   98: i2c
    //   99: bipush 9
    //   101: if_icmpeq -30 -> 71
    //   104: aload_2
    //   105: astore_0
    //   106: aload 4
    //   108: iload_1
    //   109: i2c
    //   110: invokevirtual 393	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   113: pop
    //   114: goto -43 -> 71
    //   117: astore_3
    //   118: aload_2
    //   119: astore_0
    //   120: aload_3
    //   121: invokevirtual 396	java/lang/Exception:printStackTrace	()V
    //   124: aload_2
    //   125: ifnull +7 -> 132
    //   128: aload_2
    //   129: invokevirtual 397	java/io/Reader:close	()V
    //   132: aload 4
    //   134: invokevirtual 398	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   137: areturn
    //   138: aload_2
    //   139: astore_0
    //   140: aload_2
    //   141: invokevirtual 397	java/io/Reader:close	()V
    //   144: iconst_0
    //   145: ifeq -13 -> 132
    //   148: new 400	java/lang/NullPointerException
    //   151: dup
    //   152: invokespecial 401	java/lang/NullPointerException:<init>	()V
    //   155: athrow
    //   156: astore_0
    //   157: aload_0
    //   158: invokevirtual 402	java/io/IOException:printStackTrace	()V
    //   161: goto -29 -> 132
    //   164: astore_0
    //   165: aload_0
    //   166: invokevirtual 402	java/io/IOException:printStackTrace	()V
    //   169: goto -37 -> 132
    //   172: astore_2
    //   173: aconst_null
    //   174: astore_0
    //   175: aload_0
    //   176: ifnull +7 -> 183
    //   179: aload_0
    //   180: invokevirtual 397	java/io/Reader:close	()V
    //   183: aload_2
    //   184: athrow
    //   185: astore_0
    //   186: aload_0
    //   187: invokevirtual 402	java/io/IOException:printStackTrace	()V
    //   190: goto -7 -> 183
    //   193: astore_2
    //   194: goto -19 -> 175
    //   197: astore_3
    //   198: aconst_null
    //   199: astore_2
    //   200: goto -82 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramString	String
    //   77	32	1	i	int
    //   17	124	2	localObject1	Object
    //   172	12	2	localObject2	Object
    //   193	1	2	localObject3	Object
    //   199	1	2	localObject4	Object
    //   117	4	3	localException1	Exception
    //   197	1	3	localException2	Exception
    //   7	126	4	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   73	78	117	java/lang/Exception
    //   106	114	117	java/lang/Exception
    //   140	144	117	java/lang/Exception
    //   148	156	156	java/io/IOException
    //   128	132	164	java/io/IOException
    //   55	71	172	finally
    //   179	183	185	java/io/IOException
    //   73	78	193	finally
    //   106	114	193	finally
    //   120	124	193	finally
    //   140	144	193	finally
    //   55	71	197	java/lang/Exception
  }
  
  public static String a(Map paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramMap.get(str1);
      if (i != 0)
      {
        localStringBuilder.append(str1 + "=" + URLEncoder.encode(str2, "utf-8"));
        i = 0;
      }
      for (;;)
      {
        break;
        if (str2 != null) {
          localStringBuilder.append("&" + str1 + "=" + URLEncoder.encode(str2, "utf-8"));
        } else {
          localStringBuilder.append("&" + str1 + "=");
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static HashMap a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramString != null)
    {
      Object localObject;
      if (!paramString.startsWith("?"))
      {
        localObject = paramString;
        if (!paramString.startsWith("&")) {}
      }
      else
      {
        localObject = paramString.substring(1);
      }
      paramString = ((String)localObject).split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localObject = paramString[i].split("=");
        if (localObject.length > 1)
        {
          String str = URLDecoder.decode(localObject[1]);
          localHashMap.put(localObject[0], str);
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  public static void a()
  {
    try
    {
      LogUtility.b("Common", "<initSystemFolder> begin to init system file... ");
      File localFile = new File(e());
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      a(true);
      return;
    }
    finally {}
  }
  
  public static void a(int paramInt)
  {
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).edit();
    localEditor.putInt("appTabVersionCode", paramInt);
    localEditor.commit();
  }
  
  public static void a(long paramLong1, long paramLong2)
  {
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).edit();
    localEditor.putLong("remaxage", paramLong1);
    localEditor.putLong("relasttime", paramLong2);
    localEditor.commit();
  }
  
  public static void a(String paramString)
  {
    LogUtility.c("Common", "setResourceMD5=" + paramString);
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).edit();
    localEditor.putString("relastmd5", paramString);
    localEditor.commit();
  }
  
  /* Error */
  public static void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 505	java/util/concurrent/Executors:newSingleThreadScheduledExecutor	()Ljava/util/concurrent/ScheduledExecutorService;
    //   6: astore_3
    //   7: new 507	ldm
    //   10: dup
    //   11: invokespecial 508	ldm:<init>	()V
    //   14: astore 4
    //   16: iload_0
    //   17: ifeq +24 -> 41
    //   20: ldc2_w 509
    //   23: lstore_1
    //   24: aload_3
    //   25: aload 4
    //   27: lload_1
    //   28: getstatic 516	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   31: invokeinterface 522 5 0
    //   36: pop
    //   37: ldc 2
    //   39: monitorexit
    //   40: return
    //   41: lconst_0
    //   42: lstore_1
    //   43: goto -19 -> 24
    //   46: astore_3
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_3
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	paramBoolean	boolean
    //   23	20	1	l	long
    //   6	19	3	localScheduledExecutorService	java.util.concurrent.ScheduledExecutorService
    //   46	5	3	localObject	Object
    //   14	12	4	localldm	ldm
    // Exception table:
    //   from	to	target	type
    //   3	16	46	finally
    //   24	37	46	finally
  }
  
  public static boolean a()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    while (new File("/mnt/sdcard-ext").isDirectory()) {
      return true;
    }
    return false;
  }
  
  public static long[] a()
  {
    SharedPreferences localSharedPreferences = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0);
    return new long[] { localSharedPreferences.getLong("remaxage", 0L), localSharedPreferences.getLong("relasttime", 0L) };
  }
  
  public static String[] a(String paramString)
  {
    String str2;
    String str1;
    if (paramString.toLowerCase().startsWith("sd://"))
    {
      str2 = paramString.substring("sd://".length());
      int i = str2.indexOf("?");
      if (i != -1)
      {
        str1 = str2.substring(0, i);
        paramString = str2.substring(i + 1);
        if (new File(i() + File.separator + str1).exists())
        {
          str2 = "file:///" + i() + File.separator + str1;
          str1 = paramString;
        }
      }
    }
    for (;;)
    {
      paramString = str1;
      if (!TextUtils.isEmpty(str1)) {
        paramString = "&" + str1;
      }
      LogUtility.c("Common", "url params= " + str2 + " " + paramString);
      return new String[] { str2, paramString };
      str2 = "file:///android_asset/Page/system/" + str1;
      str1 = paramString;
      continue;
      paramString = "";
      str1 = str2;
      break;
      str1 = "";
      str2 = paramString;
    }
  }
  
  public static void b(String paramString)
  {
    LogUtility.c("Common", "setLastResourceZipMd5=" + paramString);
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).edit();
    localEditor.putString("lastresourcezipmd5", paramString);
    localEditor.commit();
  }
  
  public static void b(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).edit();
    localEditor.putBoolean("appstoreclearcache", paramBoolean);
    localEditor.commit();
  }
  
  public static boolean b()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).getBoolean("appstoreclearcache", false);
  }
  
  public static void c(String paramString)
  {
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).edit();
    localEditor.putString("appstoreagentversion", paramString);
    localEditor.commit();
  }
  
  public static void d(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).edit();
      localEditor.putString("sdhtmldir", paramString);
      localEditor.commit();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static String e()
  {
    return f() + File.separator + ".AppCenterWebBuffer_QQ";
  }
  
  public static String f()
  {
    String str = ".";
    if (Environment.getExternalStorageState().equals("mounted")) {
      str = Environment.getExternalStorageDirectory().getAbsolutePath();
    }
    while (!new File("/mnt/sdcard-ext").isDirectory()) {
      return str;
    }
    return "/mnt/sdcard-ext";
  }
  
  public static String g()
  {
    return i() + File.separator + "qapp_social_apps.html";
  }
  
  public static String h()
  {
    return i() + File.separator + "qapp_center_index.htm";
  }
  
  public static String i()
  {
    String str = t();
    LogUtility.b("Common", "<getSDResDir> getSDResDir=" + str);
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    return e() + File.separator + str;
  }
  
  public static String j()
  {
    return e() + File.separator + "tmp";
  }
  
  public static String k()
  {
    return e() + File.separator + "system_old_";
  }
  
  public static String l()
  {
    return e() + File.separator + "user";
  }
  
  public static String m()
  {
    return e() + File.separator + "resource.zip";
  }
  
  public static String n()
  {
    return e() + File.separator + "resource.diff";
  }
  
  public static String o()
  {
    return e() + File.separator + "resource_merged.zip";
  }
  
  public static String p()
  {
    return "file:///android_asset" + File.separator + "Page/system";
  }
  
  public static String q()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).getString("relastmd5", "");
  }
  
  public static String r()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).getString("lastresourcezipmd5", "");
  }
  
  public static String s()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).getString("appstoreagentversion", "");
  }
  
  public static String t()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).getString("sdhtmldir", "");
  }
  
  public static String u()
  {
    int i = Process.myPid();
    try
    {
      Object localObject = CommonDataAdapter.a().a();
      if (localObject != null)
      {
        localObject = ((ActivityManager)((Context)localObject).getSystemService("activity")).getRunningAppProcesses().iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (localRunningAppProcessInfo.pid == i)
          {
            localObject = localRunningAppProcessInfo.processName;
            return localObject;
          }
        }
      }
    }
    catch (Exception localException)
    {
      LogUtility.c("Common", "exception happened!");
      return "";
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.appcommon.Common
 * JD-Core Version:    0.7.0.1
 */