package c.t.m.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class q
{
  public static final Object a;
  public static String b;
  public static long c;
  
  static
  {
    AppMethodBeat.i(136434);
    a = new Object();
    b = "complist_loading";
    c = 0L;
    AppMethodBeat.o(136434);
  }
  
  public static double a(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(136431);
    paramDouble1 = a(paramDouble1);
    paramDouble3 = a(paramDouble3);
    paramDouble2 = a(paramDouble2);
    paramDouble4 = a(paramDouble4);
    double d = Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D);
    paramDouble1 = Math.round(Math.asin(Math.sqrt(Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D) + d)) * 2.0D * 6378.1369999999997D * 10000.0D) / 10000.0D;
    AppMethodBeat.o(136431);
    return paramDouble1 * 1000.0D;
  }
  
  public static String a()
  {
    AppMethodBeat.i(136409);
    try
    {
      String str = Build.MODEL.replaceAll("[_]", "");
      AppMethodBeat.o(136409);
      return str;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(136409);
    }
    return "";
  }
  
  public static String a(Context paramContext)
  {
    AppMethodBeat.i(136405);
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0);
      str = paramContext.versionName;
      int i = paramContext.versionCode;
      if (str != null)
      {
        paramContext = str;
        if (str.trim().length() > 0) {}
      }
      else
      {
        AppMethodBeat.o(136405);
        return String.valueOf(i);
      }
    }
    catch (Exception paramContext)
    {
      paramContext = "";
      AppMethodBeat.o(136405);
    }
    return paramContext;
  }
  
  public static String a(File paramFile)
  {
    AppMethodBeat.i(136413);
    if (!paramFile.isFile())
    {
      AppMethodBeat.o(136413);
      return null;
    }
    byte[] arrayOfByte = new byte[1024];
    MessageDigest localMessageDigest;
    try
    {
      localMessageDigest = MessageDigest.getInstance("MD5");
      paramFile = new FileInputStream(paramFile);
      for (;;)
      {
        int i = paramFile.read(arrayOfByte, 0, 1024);
        if (i == -1) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramFile.close();
    }
    catch (Exception paramFile)
    {
      AppMethodBeat.o(136413);
      return null;
    }
    paramFile = c(localMessageDigest.digest());
    AppMethodBeat.o(136413);
    return paramFile;
  }
  
  public static String a(String paramString)
  {
    AppMethodBeat.i(136414);
    try
    {
      String str = c(MessageDigest.getInstance("MD5").digest(paramString.getBytes()));
      AppMethodBeat.o(136414);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(136414);
    }
    return paramString;
  }
  
  public static String a(List<a> paramList)
  {
    AppMethodBeat.i(136424);
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      localStringBuilder.append(locala.a).append(",");
      localStringBuilder.append(locala.b).append(",");
      if (!locala.c.contains(".dex")) {
        locala.c += ".dex";
      }
      localStringBuilder.append(locala.c).append(",");
      localStringBuilder.append(locala.d).append(",");
      localStringBuilder.append(locala.e).append(",");
      localStringBuilder.append(locala.f).append(";");
    }
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(136424);
    return paramList;
  }
  
  public static void a(long paramLong)
  {
    AppMethodBeat.i(136418);
    try
    {
      Thread.sleep(paramLong);
      AppMethodBeat.o(136418);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      AppMethodBeat.o(136418);
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool2 = true;
    int i = 0;
    AppMethodBeat.i(136412);
    if ((paramContext != null) && (paramString != null))
    {
      boolean bool1;
      if (paramContext.checkPermission(paramString, Process.myPid(), Process.myUid()) == 0) {
        bool1 = true;
      }
      while (!bool1) {
        try
        {
          paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096).requestedPermissions;
          if (paramContext != null)
          {
            int j = paramContext.length;
            label65:
            if (i < j)
            {
              boolean bool3 = paramString.equals(paramContext[i]);
              if (bool3) {
                bool1 = bool2;
              }
            }
          }
          for (;;)
          {
            AppMethodBeat.o(136412);
            return bool1;
            bool1 = false;
            break;
            i += 1;
            break label65;
          }
        }
        catch (Throwable paramContext) {}
      }
    }
    AppMethodBeat.o(136412);
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString, Long paramLong)
  {
    AppMethodBeat.i(136402);
    boolean bool = PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong(paramString, paramLong.longValue()).commit();
    AppMethodBeat.o(136402);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(136401);
    boolean bool = PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString(paramString1, paramString2).commit();
    AppMethodBeat.o(136401);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, byte[] paramArrayOfByte)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    AppMethodBeat.i(136426);
    paramString3 = paramString2 + File.separator + paramString3;
    paramString2 = new File(paramString2);
    if (!paramString2.exists()) {
      paramString2.mkdir();
    }
    boolean bool2 = bool3;
    try
    {
      paramContext = paramContext.getResources().getAssets().open(paramString1);
      bool2 = bool3;
      paramString1 = new ByteArrayOutputStream();
      bool2 = bool3;
      paramContext.available();
      bool2 = bool3;
      paramString2 = new BufferedOutputStream(new FileOutputStream(paramString3, true), 1024);
      for (;;)
      {
        bool2 = bool3;
        int i = paramContext.read(paramArrayOfByte);
        if (i <= 0) {
          break;
        }
        bool2 = bool3;
        paramString1.write(paramArrayOfByte, 0, i);
      }
      AppMethodBeat.o(136426);
    }
    catch (Exception paramContext)
    {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool2 = bool3;
      paramString1.close();
      bool2 = bool3;
      paramString1 = a(m.b(paramString1.toByteArray(), "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q"));
      if (paramString1 != null)
      {
        bool2 = bool3;
        paramString2.write(paramString1);
        bool2 = bool3;
        paramString2.close();
        bool1 = true;
      }
      bool2 = bool1;
      paramContext.close();
    }
  }
  
  public static boolean a(Context paramContext, List<a> paramList)
  {
    AppMethodBeat.i(136425);
    List localList = b(b(paramContext, "__SP_Tencent_Loc_COMP_INFO__", ""));
    if ((localList.size() == 0) || (paramList.size() == 0))
    {
      AppMethodBeat.o(136425);
      return false;
    }
    int i = 0;
    if (i < localList.size())
    {
      a locala1 = (a)localList.get(i);
      int j = 0;
      for (;;)
      {
        if (j < paramList.size())
        {
          a locala2 = (a)paramList.get(j);
          if (locala2.a == locala1.a)
          {
            locala1.c = locala2.c;
            locala1.b = locala2.b;
            locala1.d = locala2.d;
            locala1.e = locala2.e;
          }
        }
        else
        {
          i += 1;
          break;
        }
        j += 1;
      }
    }
    boolean bool = a(paramContext, "__SP_Tencent_Loc_COMP_INFO__", a(localList));
    AppMethodBeat.o(136425);
    return bool;
  }
  
  public static byte[] a(int paramInt)
  {
    AppMethodBeat.i(136421);
    byte[] arrayOfByte = new byte[2];
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < 2)
    {
      arrayOfByte[paramInt] = Integer.valueOf(i & 0xFF).byteValue();
      i >>= 8;
      paramInt += 1;
    }
    AppMethodBeat.o(136421);
    return arrayOfByte;
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 410
    //   6: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ifnull +8 -> 18
    //   13: aload_0
    //   14: arraylength
    //   15: ifne +11 -> 26
    //   18: ldc_w 410
    //   21: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aconst_null
    //   25: areturn
    //   26: new 334	java/io/ByteArrayOutputStream
    //   29: dup
    //   30: invokespecial 335	java/io/ByteArrayOutputStream:<init>	()V
    //   33: astore_2
    //   34: new 412	java/io/ByteArrayInputStream
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 414	java/io/ByteArrayInputStream:<init>	([B)V
    //   42: astore_3
    //   43: new 416	java/util/zip/GZIPInputStream
    //   46: dup
    //   47: aload_3
    //   48: invokespecial 419	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   51: astore_0
    //   52: ldc_w 420
    //   55: newarray byte
    //   57: astore 4
    //   59: aload_0
    //   60: aload 4
    //   62: invokevirtual 421	java/util/zip/GZIPInputStream:read	([B)I
    //   65: istore_1
    //   66: iload_1
    //   67: iflt +57 -> 124
    //   70: aload_2
    //   71: aload 4
    //   73: iconst_0
    //   74: iload_1
    //   75: invokevirtual 356	java/io/ByteArrayOutputStream:write	([BII)V
    //   78: goto -19 -> 59
    //   81: astore 4
    //   83: aload_0
    //   84: ifnull +7 -> 91
    //   87: aload_0
    //   88: invokevirtual 422	java/util/zip/GZIPInputStream:close	()V
    //   91: aload_3
    //   92: ifnull +7 -> 99
    //   95: aload_3
    //   96: invokevirtual 423	java/io/ByteArrayInputStream:close	()V
    //   99: aload 5
    //   101: astore 4
    //   103: aload_2
    //   104: ifnull +11 -> 115
    //   107: aload_2
    //   108: invokevirtual 357	java/io/ByteArrayOutputStream:close	()V
    //   111: aload 5
    //   113: astore 4
    //   115: ldc_w 410
    //   118: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload 4
    //   123: areturn
    //   124: aload_2
    //   125: invokevirtual 360	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   128: astore 4
    //   130: aload_0
    //   131: invokevirtual 422	java/util/zip/GZIPInputStream:close	()V
    //   134: aload_3
    //   135: invokevirtual 423	java/io/ByteArrayInputStream:close	()V
    //   138: aload_2
    //   139: invokevirtual 357	java/io/ByteArrayOutputStream:close	()V
    //   142: goto -27 -> 115
    //   145: astore_0
    //   146: goto -31 -> 115
    //   149: astore_0
    //   150: aconst_null
    //   151: astore_0
    //   152: aconst_null
    //   153: astore_3
    //   154: aconst_null
    //   155: astore_2
    //   156: aload_0
    //   157: ifnull +7 -> 164
    //   160: aload_0
    //   161: invokevirtual 422	java/util/zip/GZIPInputStream:close	()V
    //   164: aload_3
    //   165: ifnull +7 -> 172
    //   168: aload_3
    //   169: invokevirtual 423	java/io/ByteArrayInputStream:close	()V
    //   172: aload 5
    //   174: astore 4
    //   176: aload_2
    //   177: ifnull -62 -> 115
    //   180: aload_2
    //   181: invokevirtual 357	java/io/ByteArrayOutputStream:close	()V
    //   184: aload 5
    //   186: astore 4
    //   188: goto -73 -> 115
    //   191: astore_0
    //   192: aload 5
    //   194: astore 4
    //   196: goto -81 -> 115
    //   199: astore_0
    //   200: aconst_null
    //   201: astore_2
    //   202: aconst_null
    //   203: astore_3
    //   204: aconst_null
    //   205: astore 4
    //   207: aload_2
    //   208: ifnull +7 -> 215
    //   211: aload_2
    //   212: invokevirtual 422	java/util/zip/GZIPInputStream:close	()V
    //   215: aload_3
    //   216: ifnull +7 -> 223
    //   219: aload_3
    //   220: invokevirtual 423	java/io/ByteArrayInputStream:close	()V
    //   223: aload 4
    //   225: ifnull +8 -> 233
    //   228: aload 4
    //   230: invokevirtual 357	java/io/ByteArrayOutputStream:close	()V
    //   233: ldc_w 410
    //   236: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: aload_0
    //   240: athrow
    //   241: astore_2
    //   242: goto -9 -> 233
    //   245: astore_0
    //   246: aconst_null
    //   247: astore 5
    //   249: aconst_null
    //   250: astore_3
    //   251: aload_2
    //   252: astore 4
    //   254: aload 5
    //   256: astore_2
    //   257: goto -50 -> 207
    //   260: astore_0
    //   261: aconst_null
    //   262: astore 5
    //   264: aload_2
    //   265: astore 4
    //   267: aload 5
    //   269: astore_2
    //   270: goto -63 -> 207
    //   273: astore 5
    //   275: aload_0
    //   276: astore 6
    //   278: aload_2
    //   279: astore 4
    //   281: aload 5
    //   283: astore_0
    //   284: aload 6
    //   286: astore_2
    //   287: goto -80 -> 207
    //   290: astore_0
    //   291: aconst_null
    //   292: astore_0
    //   293: aconst_null
    //   294: astore_3
    //   295: goto -139 -> 156
    //   298: astore_0
    //   299: aconst_null
    //   300: astore_0
    //   301: goto -145 -> 156
    //   304: astore 4
    //   306: goto -150 -> 156
    //   309: astore_0
    //   310: aload 5
    //   312: astore 4
    //   314: goto -199 -> 115
    //   317: astore_0
    //   318: aconst_null
    //   319: astore_0
    //   320: aconst_null
    //   321: astore_3
    //   322: aconst_null
    //   323: astore_2
    //   324: goto -241 -> 83
    //   327: astore_0
    //   328: aconst_null
    //   329: astore_0
    //   330: aconst_null
    //   331: astore_3
    //   332: goto -249 -> 83
    //   335: astore_0
    //   336: aconst_null
    //   337: astore_0
    //   338: goto -255 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	paramArrayOfByte	byte[]
    //   65	10	1	i	int
    //   33	179	2	localByteArrayOutputStream	ByteArrayOutputStream
    //   241	11	2	localException1	Exception
    //   256	68	2	localObject1	Object
    //   42	290	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   57	15	4	arrayOfByte1	byte[]
    //   81	1	4	localException2	Exception
    //   101	179	4	localObject2	Object
    //   304	1	4	localError	java.lang.Error
    //   312	1	4	localObject3	Object
    //   1	267	5	localObject4	Object
    //   273	38	5	localObject5	Object
    //   276	9	6	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   52	59	81	java/lang/Exception
    //   59	66	81	java/lang/Exception
    //   70	78	81	java/lang/Exception
    //   124	130	81	java/lang/Exception
    //   130	142	145	java/lang/Exception
    //   26	34	149	java/lang/Error
    //   160	164	191	java/lang/Exception
    //   168	172	191	java/lang/Exception
    //   180	184	191	java/lang/Exception
    //   26	34	199	finally
    //   211	215	241	java/lang/Exception
    //   219	223	241	java/lang/Exception
    //   228	233	241	java/lang/Exception
    //   34	43	245	finally
    //   43	52	260	finally
    //   52	59	273	finally
    //   59	66	273	finally
    //   70	78	273	finally
    //   124	130	273	finally
    //   34	43	290	java/lang/Error
    //   43	52	298	java/lang/Error
    //   52	59	304	java/lang/Error
    //   59	66	304	java/lang/Error
    //   70	78	304	java/lang/Error
    //   124	130	304	java/lang/Error
    //   87	91	309	java/lang/Exception
    //   95	99	309	java/lang/Exception
    //   107	111	309	java/lang/Exception
    //   26	34	317	java/lang/Exception
    //   34	43	327	java/lang/Exception
    //   43	52	335	java/lang/Exception
  }
  
  public static Long b(Context paramContext, String paramString, Long paramLong)
  {
    AppMethodBeat.i(136404);
    long l = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong(paramString, paramLong.longValue());
    AppMethodBeat.o(136404);
    return Long.valueOf(l);
  }
  
  public static String b()
  {
    AppMethodBeat.i(136410);
    try
    {
      String str = Build.MANUFACTURER.replaceAll("[_]", "");
      AppMethodBeat.o(136410);
      return str;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(136410);
    }
    return "";
  }
  
  public static String b(Context paramContext)
  {
    AppMethodBeat.i(136406);
    paramContext = paramContext.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/comp";
    AppMethodBeat.o(136406);
    return paramContext;
  }
  
  /* Error */
  public static String b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc_w 452
    //   3: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 182	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   13: astore_2
    //   14: aload_0
    //   15: invokevirtual 453	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   18: aload_1
    //   19: invokevirtual 332	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: astore_0
    //   23: new 455	java/io/BufferedReader
    //   26: dup
    //   27: new 457	java/io/InputStreamReader
    //   30: dup
    //   31: aload_0
    //   32: ldc_w 459
    //   35: invokespecial 462	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   38: invokespecial 465	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 468	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   46: astore_3
    //   47: aload_3
    //   48: ifnull +26 -> 74
    //   51: aload_2
    //   52: aload_3
    //   53: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: goto -15 -> 42
    //   60: astore_0
    //   61: aload_2
    //   62: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: astore_0
    //   66: ldc_w 452
    //   69: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_0
    //   73: areturn
    //   74: aload_1
    //   75: invokevirtual 469	java/io/BufferedReader:close	()V
    //   78: aload_0
    //   79: invokevirtual 374	java/io/InputStream:close	()V
    //   82: goto -21 -> 61
    //   85: astore_0
    //   86: goto -25 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramContext	Context
    //   0	89	1	paramString	String
    //   13	49	2	localStringBuilder	StringBuilder
    //   46	7	3	str	String
    // Exception table:
    //   from	to	target	type
    //   14	42	60	java/io/UnsupportedEncodingException
    //   42	47	60	java/io/UnsupportedEncodingException
    //   51	57	60	java/io/UnsupportedEncodingException
    //   74	82	60	java/io/UnsupportedEncodingException
    //   14	42	85	java/io/IOException
    //   42	47	85	java/io/IOException
    //   51	57	85	java/io/IOException
    //   74	82	85	java/io/IOException
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(136403);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString1, paramString2);
    AppMethodBeat.o(136403);
    return paramContext;
  }
  
  public static List<a> b(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(136422);
    localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        paramString = paramString.split(";");
        int j = paramString.length;
        if (i < j)
        {
          arrayOfString = paramString[i].split(",");
          int k = arrayOfString.length;
          if (k < 5) {}
        }
      }
      catch (Exception paramString)
      {
        String[] arrayOfString;
        a locala;
        AppMethodBeat.o(136422);
        return localArrayList;
      }
      try
      {
        locala = new a();
        locala.a = Integer.valueOf(arrayOfString[0]).intValue();
        locala.b = arrayOfString[1];
        locala.c = arrayOfString[2];
        locala.d = Integer.valueOf(arrayOfString[3]).intValue();
        locala.e = arrayOfString[4];
        if (arrayOfString.length > 5) {
          locala.f = arrayOfString[5];
        }
        localArrayList.add(locala);
      }
      catch (Exception localException)
      {
        continue;
      }
      i += 1;
    }
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    AppMethodBeat.i(136428);
    paramContext = paramString2 + File.separator + paramString3;
    paramString2 = new File(paramString2);
    if (!paramString2.exists()) {
      paramString2.mkdir();
    }
    boolean bool1 = bool2;
    try
    {
      paramString1 = new FileInputStream(paramString1);
      bool1 = bool2;
      paramContext = new FileOutputStream(paramContext);
      for (;;)
      {
        bool1 = bool2;
        int i = paramString1.read(paramArrayOfByte);
        if (i <= 0) {
          break;
        }
        bool1 = bool2;
        paramContext.write(paramArrayOfByte, 0, i);
      }
      AppMethodBeat.o(136428);
    }
    catch (Exception paramContext) {}
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      paramContext.close();
      bool2 = true;
      bool1 = true;
      paramString1.close();
      bool1 = bool2;
    }
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136420);
    Object localObject2 = null;
    localObject1 = localObject2;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
      localObject1 = localObject2;
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localObject1 = localObject2;
      localGZIPOutputStream.write(paramArrayOfByte);
      localObject1 = localObject2;
      localGZIPOutputStream.close();
      localObject1 = localObject2;
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localObject1 = paramArrayOfByte;
      localByteArrayOutputStream.close();
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = (byte[])localObject1;
      }
    }
    AppMethodBeat.o(136420);
    return paramArrayOfByte;
  }
  
  public static int c()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static String c(String paramString)
  {
    AppMethodBeat.i(136423);
    try
    {
      Object localObject1 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject1).getString("status");
      e.a().a("DRG", "statucode:".concat(String.valueOf(paramString)));
      boolean bool = paramString.equals("-3");
      if (bool)
      {
        AppMethodBeat.o(136423);
        return null;
      }
      if (paramString.equals("0"))
      {
        paramString = "";
        localObject1 = ((JSONObject)localObject1).getJSONArray("compList");
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          int j = ((JSONObject)localObject2).getInt("compId");
          String str1 = ((JSONObject)localObject2).getString("compVer");
          String str2 = ((JSONObject)localObject2).getString("md5");
          int k = ((JSONObject)localObject2).getInt("size");
          localObject2 = ((JSONObject)localObject2).getString("compName");
          paramString = paramString + j + "," + str1 + "," + (String)localObject2 + "," + k + "," + str2 + ",;";
          i += 1;
        }
        AppMethodBeat.o(136423);
        return paramString;
      }
      bool = paramString.equals("-1");
      if (bool)
      {
        AppMethodBeat.o(136423);
        return null;
      }
      bool = paramString.equals("-2");
      if (bool)
      {
        AppMethodBeat.o(136423);
        return null;
      }
      bool = paramString.equals("-4");
      if (bool)
      {
        AppMethodBeat.o(136423);
        return null;
      }
      bool = paramString.equals("-5");
      if (bool)
      {
        AppMethodBeat.o(136423);
        return null;
      }
    }
    catch (Exception paramString)
    {
      e.a().a("DRG", "statucode:" + paramString.toString());
      AppMethodBeat.o(136423);
    }
    return null;
  }
  
  private static String c(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136415);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(136415);
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuffer.append("0");
      }
      localStringBuffer.append(str);
      i += 1;
    }
    paramArrayOfByte = localStringBuffer.toString().toLowerCase();
    AppMethodBeat.o(136415);
    return paramArrayOfByte;
  }
  
  public static List<String> c(Context paramContext)
  {
    AppMethodBeat.i(136407);
    Object localObject = new File(paramContext.getFilesDir(), "TencentLocation/comp");
    ArrayList localArrayList = null;
    paramContext = localArrayList;
    if (((File)localObject).exists())
    {
      paramContext = localArrayList;
      if (((File)localObject).isDirectory())
      {
        localObject = ((File)localObject).listFiles();
        paramContext = localArrayList;
        if (localObject != null)
        {
          paramContext = localArrayList;
          if (localObject.length > 0)
          {
            localArrayList = new ArrayList();
            int j = localObject.length;
            int i = 0;
            for (;;)
            {
              paramContext = localArrayList;
              if (i >= j) {
                break;
              }
              paramContext = localObject[i];
              localArrayList.add(paramContext.getName() + "," + paramContext.length());
              i += 1;
            }
          }
        }
      }
    }
    AppMethodBeat.o(136407);
    return paramContext;
  }
  
  public static long d()
  {
    AppMethodBeat.i(136416);
    long l1 = 0L;
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l2 = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      l1 = i * l2;
    }
    catch (Exception localException)
    {
      label41:
      break label41;
    }
    AppMethodBeat.o(136416);
    return l1;
  }
  
  public static String d(Context paramContext)
  {
    AppMethodBeat.i(136408);
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      if (paramContext != null)
      {
        if (paramContext.containsKey("TencentGeoLocationSDK"))
        {
          paramContext = paramContext.getString("TencentGeoLocationSDK");
          AppMethodBeat.o(136408);
          return paramContext;
        }
        if (paramContext.containsKey("TencentMapSDK"))
        {
          paramContext = paramContext.getString("TencentMapSDK");
          AppMethodBeat.o(136408);
          return paramContext;
        }
        AppMethodBeat.o(136408);
        return "";
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(136408);
    }
    return "";
  }
  
  public static boolean d(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(136427);
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      AppMethodBeat.o(136427);
      return false;
    }
    localObject = ((File)localObject).list();
    int j = localObject.length;
    if (i < j)
    {
      File localFile = new File(paramString, localObject[i]);
      if (localFile.isDirectory())
      {
        d(localFile.getAbsolutePath());
        localFile.delete();
      }
      for (;;)
      {
        i += 1;
        break;
        localFile.delete();
      }
    }
    AppMethodBeat.o(136427);
    return true;
  }
  
  public static String e(Context paramContext)
  {
    AppMethodBeat.i(136411);
    String str = "";
    if (paramContext == null)
    {
      AppMethodBeat.o(136411);
      return "";
    }
    localObject = str;
    for (;;)
    {
      try
      {
        if (!a(paramContext, "android.permission.READ_PHONE_STATE")) {
          continue;
        }
        localObject = str;
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        localObject = str;
        if (Build.VERSION.SDK_INT < 26) {
          continue;
        }
        localObject = str;
        paramContext = paramContext.getImei();
        if (paramContext != null) {
          continue;
        }
        paramContext = "";
      }
      catch (Throwable paramContext)
      {
        paramContext = (Context)localObject;
        continue;
        paramContext = "";
        continue;
      }
      AppMethodBeat.o(136411);
      return paramContext;
      localObject = str;
      paramContext = paramContext.getDeviceId();
      continue;
      localObject = paramContext;
      paramContext = paramContext.toLowerCase();
    }
  }
  
  public static boolean e(String paramString)
  {
    AppMethodBeat.i(136429);
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      ((File)localObject).mkdirs();
      AppMethodBeat.o(136429);
      return true;
    }
    localObject = ((File)localObject).list();
    int j = localObject.length;
    int i = 0;
    if (i < j)
    {
      File localFile = new File(paramString, localObject[i]);
      if (localFile.isDirectory())
      {
        d(localFile.getAbsolutePath());
        localFile.delete();
      }
      for (;;)
      {
        i += 1;
        break;
        localFile.delete();
      }
    }
    AppMethodBeat.o(136429);
    return true;
  }
  
  public static boolean f(Context paramContext)
  {
    AppMethodBeat.i(136417);
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if (paramContext != null)
        {
          int i = paramContext.getType();
          if (i == 1)
          {
            AppMethodBeat.o(136417);
            return true;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(136417);
    }
    return false;
  }
  
  /* Error */
  public static int g(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 709
    //   3: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +11 -> 18
    //   10: ldc_w 709
    //   13: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: iconst_m1
    //   17: ireturn
    //   18: aload_0
    //   19: invokestatic 712	c/t/m/c/q:h	(Landroid/content/Context;)Z
    //   22: istore 9
    //   24: aload_0
    //   25: ldc_w 714
    //   28: invokevirtual 679	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   31: checkcast 716	android/net/wifi/WifiManager
    //   34: astore 10
    //   36: aload 10
    //   38: ifnull +217 -> 255
    //   41: aload 10
    //   43: invokevirtual 719	android/net/wifi/WifiManager:isWifiEnabled	()Z
    //   46: istore 7
    //   48: iload 7
    //   50: ifeq +339 -> 389
    //   53: iconst_1
    //   54: istore_1
    //   55: getstatic 513	android/os/Build$VERSION:SDK_INT	I
    //   58: bipush 18
    //   60: if_icmplt +324 -> 384
    //   63: aload 10
    //   65: invokevirtual 722	android/net/wifi/WifiManager:isScanAlwaysAvailable	()Z
    //   68: istore 7
    //   70: iload 7
    //   72: ifeq +312 -> 384
    //   75: iconst_1
    //   76: istore_3
    //   77: iconst_1
    //   78: istore_2
    //   79: iload_1
    //   80: istore 4
    //   82: aload_0
    //   83: ldc_w 724
    //   86: invokevirtual 679	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   89: checkcast 726	android/location/LocationManager
    //   92: astore 10
    //   94: aload 10
    //   96: ifnull +211 -> 307
    //   99: aload_0
    //   100: invokevirtual 730	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   103: ldc_w 732
    //   106: invokestatic 737	android/provider/Settings$Secure:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;)I
    //   109: istore_1
    //   110: aload 10
    //   112: ldc_w 739
    //   115: invokevirtual 742	android/location/LocationManager:isProviderEnabled	(Ljava/lang/String;)Z
    //   118: istore 8
    //   120: aload 10
    //   122: invokevirtual 746	android/location/LocationManager:getAllProviders	()Ljava/util/List;
    //   125: astore_0
    //   126: aload_0
    //   127: ifnonnull +166 -> 293
    //   130: iconst_0
    //   131: istore 7
    //   133: iload 9
    //   135: ifne +243 -> 378
    //   138: iconst_1
    //   139: istore 6
    //   141: iload 6
    //   143: istore 5
    //   145: iload 4
    //   147: ifne +9 -> 156
    //   150: iload 6
    //   152: iconst_2
    //   153: iadd
    //   154: istore 5
    //   156: iload 5
    //   158: istore 4
    //   160: iload 8
    //   162: ifne +9 -> 171
    //   165: iload 5
    //   167: iconst_4
    //   168: iadd
    //   169: istore 4
    //   171: iload 4
    //   173: istore 5
    //   175: iload_3
    //   176: ifne +10 -> 186
    //   179: iload 4
    //   181: bipush 8
    //   183: iadd
    //   184: istore 5
    //   186: iload 5
    //   188: istore_3
    //   189: iload 7
    //   191: ifne +9 -> 200
    //   194: iload 5
    //   196: bipush 16
    //   198: iadd
    //   199: istore_3
    //   200: iload_3
    //   201: istore 4
    //   203: iload_2
    //   204: ifne +9 -> 213
    //   207: iload_3
    //   208: bipush 32
    //   210: iadd
    //   211: istore 4
    //   213: iload_1
    //   214: tableswitch	default:+30 -> 244, 0:+116->330, 1:+125->339, 2:+135->349, 3:+145->359
    //   245: iconst_1
    //   246: istore_1
    //   247: ldc_w 709
    //   250: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: iload_1
    //   254: ireturn
    //   255: iconst_0
    //   256: istore_2
    //   257: iconst_0
    //   258: istore_1
    //   259: iconst_0
    //   260: istore 4
    //   262: iload_2
    //   263: istore_3
    //   264: iload 4
    //   266: istore_2
    //   267: iload_1
    //   268: istore 4
    //   270: goto -188 -> 82
    //   273: astore 10
    //   275: iconst_0
    //   276: istore_1
    //   277: iconst_0
    //   278: istore_3
    //   279: iconst_0
    //   280: istore_2
    //   281: iload_1
    //   282: istore 4
    //   284: goto -202 -> 82
    //   287: astore_0
    //   288: iconst_0
    //   289: istore_1
    //   290: goto -180 -> 110
    //   293: aload_0
    //   294: ldc_w 739
    //   297: invokeinterface 748 2 0
    //   302: istore 7
    //   304: goto -171 -> 133
    //   307: iconst_0
    //   308: istore 7
    //   310: iconst_0
    //   311: istore_1
    //   312: iconst_0
    //   313: istore 8
    //   315: goto -182 -> 133
    //   318: astore_0
    //   319: iconst_0
    //   320: istore_1
    //   321: iconst_0
    //   322: istore 7
    //   324: iconst_0
    //   325: istore 8
    //   327: goto -194 -> 133
    //   330: iload 4
    //   332: bipush 64
    //   334: iadd
    //   335: istore_1
    //   336: goto -89 -> 247
    //   339: iload 4
    //   341: sipush 128
    //   344: iadd
    //   345: istore_1
    //   346: goto -99 -> 247
    //   349: iload 4
    //   351: sipush 256
    //   354: iadd
    //   355: istore_1
    //   356: goto -109 -> 247
    //   359: iload 4
    //   361: sipush 512
    //   364: iadd
    //   365: istore_1
    //   366: goto -119 -> 247
    //   369: astore_0
    //   370: goto -49 -> 321
    //   373: astore 10
    //   375: goto -98 -> 277
    //   378: iconst_0
    //   379: istore 6
    //   381: goto -240 -> 141
    //   384: iconst_1
    //   385: istore_2
    //   386: goto -127 -> 259
    //   389: iconst_0
    //   390: istore_1
    //   391: goto -336 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	paramContext	Context
    //   54	337	1	i	int
    //   78	308	2	j	int
    //   76	203	3	k	int
    //   80	285	4	m	int
    //   143	56	5	n	int
    //   139	241	6	i1	int
    //   46	277	7	bool1	boolean
    //   118	208	8	bool2	boolean
    //   22	112	9	bool3	boolean
    //   34	87	10	localObject	Object
    //   273	1	10	localThrowable1	Throwable
    //   373	1	10	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   24	36	273	java/lang/Throwable
    //   41	48	273	java/lang/Throwable
    //   99	110	287	java/lang/Throwable
    //   82	94	318	java/lang/Exception
    //   99	110	318	java/lang/Exception
    //   110	126	369	java/lang/Exception
    //   293	304	369	java/lang/Exception
    //   55	70	373	java/lang/Throwable
  }
  
  private static boolean h(Context paramContext)
  {
    AppMethodBeat.i(136433);
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null)
      {
        AppMethodBeat.o(136433);
        return false;
      }
      int i = paramContext.getSimState();
      if (i == 5)
      {
        AppMethodBeat.o(136433);
        return true;
      }
      AppMethodBeat.o(136433);
      return false;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(136433);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     c.t.m.c.q
 * JD-Core Version:    0.7.0.1
 */