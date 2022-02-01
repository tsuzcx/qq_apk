package cooperation.qqwifi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QQWiFiHelper
{
  public static int a = 0;
  public static long a = 0L;
  public static final String a = "com.tencent.mobileqq.qqwifi.scanStateChange";
  public static long b = 3600000L;
  public static final String b = "intervalTime";
  private static final String c = "QQWiFiHelper";
  private static final String d = "com.tencent.mobileqq.qqwifi.QQWiFiInterface";
  private static final String e = "com.tencent.mobileqq.qqwifi.QQWiFiMapInterface";
  
  static
  {
    jdField_a_of_type_Int = 10104;
    jdField_a_of_type_Long = 5000L;
  }
  
  public static int a(Context paramContext, String paramString)
  {
    paramContext = a(new File(paramContext.getDir("qqwifi_dir", 0), "freetime_file"));
    try
    {
      if (TextUtils.isEmpty(paramContext)) {
        return -1;
      }
      int i = new JSONObject(paramContext).getInt("mFreeTime_" + paramString);
      return i;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
      return -1;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return -1;
  }
  
  private static IPluginManager.PluginParams a(Intent paramIntent, String paramString)
  {
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = "QQWifiPlugin.apk";
    localPluginParams.d = "QQWifiPlugin";
    localPluginParams.jdField_a_of_type_JavaLangString = paramString;
    localPluginParams.e = "com.tencent.wifisdk.service.QQWTFService";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    return localPluginParams;
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_3
    //   3: astore_2
    //   4: aload_0
    //   5: ifnull +12 -> 17
    //   8: aload_0
    //   9: invokevirtual 127	java/io/File:exists	()Z
    //   12: ifne +7 -> 19
    //   15: aload_3
    //   16: astore_2
    //   17: aload_2
    //   18: areturn
    //   19: new 77	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   26: astore_2
    //   27: new 129	java/io/BufferedReader
    //   30: dup
    //   31: new 131	java/io/FileReader
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 134	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   39: invokespecial 137	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: invokevirtual 140	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore 4
    //   51: aload 4
    //   53: ifnull +41 -> 94
    //   56: aload_1
    //   57: astore_0
    //   58: aload_2
    //   59: aload 4
    //   61: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: goto -22 -> 43
    //   68: astore_2
    //   69: aload_1
    //   70: astore_0
    //   71: aload_2
    //   72: invokevirtual 141	java/io/FileNotFoundException:printStackTrace	()V
    //   75: aload_3
    //   76: astore_2
    //   77: aload_1
    //   78: ifnull -61 -> 17
    //   81: aload_1
    //   82: invokevirtual 144	java/io/BufferedReader:close	()V
    //   85: aconst_null
    //   86: areturn
    //   87: astore_0
    //   88: aload_0
    //   89: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   92: aconst_null
    //   93: areturn
    //   94: aload_1
    //   95: astore_0
    //   96: aload_1
    //   97: invokevirtual 144	java/io/BufferedReader:close	()V
    //   100: aload_1
    //   101: astore_0
    //   102: aload_2
    //   103: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: astore_2
    //   107: aload_2
    //   108: astore_0
    //   109: aload_0
    //   110: astore_2
    //   111: aload_1
    //   112: ifnull -95 -> 17
    //   115: aload_1
    //   116: invokevirtual 144	java/io/BufferedReader:close	()V
    //   119: aload_0
    //   120: areturn
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   126: aload_0
    //   127: areturn
    //   128: astore_2
    //   129: aconst_null
    //   130: astore_1
    //   131: aload_1
    //   132: astore_0
    //   133: aload_2
    //   134: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   137: aload_3
    //   138: astore_2
    //   139: aload_1
    //   140: ifnull -123 -> 17
    //   143: aload_1
    //   144: invokevirtual 144	java/io/BufferedReader:close	()V
    //   147: aconst_null
    //   148: areturn
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   154: aconst_null
    //   155: areturn
    //   156: astore_1
    //   157: aconst_null
    //   158: astore_0
    //   159: aload_0
    //   160: ifnull +7 -> 167
    //   163: aload_0
    //   164: invokevirtual 144	java/io/BufferedReader:close	()V
    //   167: aload_1
    //   168: athrow
    //   169: astore_0
    //   170: aload_0
    //   171: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   174: goto -7 -> 167
    //   177: astore_1
    //   178: goto -19 -> 159
    //   181: astore_2
    //   182: goto -51 -> 131
    //   185: astore_2
    //   186: aconst_null
    //   187: astore_1
    //   188: goto -119 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramFile	File
    //   42	74	1	localBufferedReader	java.io.BufferedReader
    //   121	2	1	localIOException1	java.io.IOException
    //   130	14	1	localObject1	Object
    //   156	12	1	localObject2	Object
    //   177	1	1	localObject3	Object
    //   187	1	1	localObject4	Object
    //   3	56	2	localObject5	Object
    //   68	4	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   76	35	2	localObject6	Object
    //   128	6	2	localIOException2	java.io.IOException
    //   138	1	2	localObject7	Object
    //   181	1	2	localIOException3	java.io.IOException
    //   185	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	137	3	localObject8	Object
    //   49	11	4	str	String
    // Exception table:
    //   from	to	target	type
    //   45	51	68	java/io/FileNotFoundException
    //   58	65	68	java/io/FileNotFoundException
    //   96	100	68	java/io/FileNotFoundException
    //   102	107	68	java/io/FileNotFoundException
    //   81	85	87	java/io/IOException
    //   115	119	121	java/io/IOException
    //   19	43	128	java/io/IOException
    //   143	147	149	java/io/IOException
    //   19	43	156	finally
    //   163	167	169	java/io/IOException
    //   45	51	177	finally
    //   58	65	177	finally
    //   71	75	177	finally
    //   96	100	177	finally
    //   102	107	177	finally
    //   133	137	177	finally
    //   45	51	181	java/io/IOException
    //   58	65	181	java/io/IOException
    //   96	100	181	java/io/IOException
    //   102	107	181	java/io/IOException
    //   19	43	185	java/io/FileNotFoundException
  }
  
  /* Error */
  public static List a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 48	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: ldc 50
    //   9: iconst_0
    //   10: invokevirtual 56	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   13: ldc 148
    //   15: invokespecial 61	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   18: invokestatic 64	cooperation/qqwifi/QQWiFiHelper:a	(Ljava/io/File;)Ljava/lang/String;
    //   21: astore_0
    //   22: aload_0
    //   23: invokestatic 70	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifeq +5 -> 31
    //   29: aconst_null
    //   30: areturn
    //   31: new 72	org/json/JSONObject
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 75	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   39: ldc 150
    //   41: invokevirtual 154	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   44: astore_3
    //   45: new 156	java/util/ArrayList
    //   48: dup
    //   49: invokespecial 157	java/util/ArrayList:<init>	()V
    //   52: astore_0
    //   53: aload_3
    //   54: invokevirtual 163	org/json/JSONArray:length	()I
    //   57: istore_2
    //   58: iload_1
    //   59: iload_2
    //   60: if_icmpge +45 -> 105
    //   63: aload_0
    //   64: aload_3
    //   65: iload_1
    //   66: invokevirtual 167	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   69: invokeinterface 173 2 0
    //   74: pop
    //   75: iload_1
    //   76: iconst_1
    //   77: iadd
    //   78: istore_1
    //   79: goto -26 -> 53
    //   82: astore 4
    //   84: aload 4
    //   86: invokevirtual 95	org/json/JSONException:printStackTrace	()V
    //   89: goto -14 -> 75
    //   92: astore_3
    //   93: aload_3
    //   94: invokevirtual 95	org/json/JSONException:printStackTrace	()V
    //   97: aload_0
    //   98: areturn
    //   99: astore_3
    //   100: aconst_null
    //   101: astore_0
    //   102: goto -9 -> 93
    //   105: aload_0
    //   106: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramContext	Context
    //   1	78	1	i	int
    //   57	4	2	j	int
    //   44	21	3	localJSONArray	JSONArray
    //   92	2	3	localJSONException1	JSONException
    //   99	1	3	localJSONException2	JSONException
    //   82	3	4	localJSONException3	JSONException
    // Exception table:
    //   from	to	target	type
    //   63	75	82	org/json/JSONException
    //   53	58	92	org/json/JSONException
    //   84	89	92	org/json/JSONException
    //   22	29	99	org/json/JSONException
    //   31	53	99	org/json/JSONException
  }
  
  /* Error */
  public static Map a(Context paramContext)
  {
    // Byte code:
    //   0: new 48	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: ldc 50
    //   7: iconst_0
    //   8: invokevirtual 56	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   11: ldc 176
    //   13: invokespecial 61	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   16: invokestatic 64	cooperation/qqwifi/QQWiFiHelper:a	(Ljava/io/File;)Ljava/lang/String;
    //   19: astore_0
    //   20: aload_0
    //   21: invokestatic 70	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +5 -> 29
    //   27: aconst_null
    //   28: areturn
    //   29: new 72	org/json/JSONObject
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 75	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   37: astore_0
    //   38: new 178	java/util/HashMap
    //   41: dup
    //   42: invokespecial 179	java/util/HashMap:<init>	()V
    //   45: astore_1
    //   46: aload_0
    //   47: invokevirtual 183	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   50: astore_2
    //   51: aload_2
    //   52: invokeinterface 188 1 0
    //   57: ifeq +36 -> 93
    //   60: aload_2
    //   61: invokeinterface 192 1 0
    //   66: checkcast 194	java/lang/String
    //   69: astore_3
    //   70: aload_1
    //   71: aload_3
    //   72: aload_0
    //   73: aload_3
    //   74: invokevirtual 197	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   77: invokeinterface 203 3 0
    //   82: pop
    //   83: goto -32 -> 51
    //   86: astore_0
    //   87: aload_0
    //   88: invokevirtual 95	org/json/JSONException:printStackTrace	()V
    //   91: aconst_null
    //   92: areturn
    //   93: aload_1
    //   94: areturn
    //   95: astore_0
    //   96: aload_0
    //   97: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   100: goto -9 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramContext	Context
    //   45	49	1	localHashMap	java.util.HashMap
    //   50	11	2	localIterator	Iterator
    //   69	5	3	str	String
    // Exception table:
    //   from	to	target	type
    //   20	27	86	org/json/JSONException
    //   29	51	86	org/json/JSONException
    //   51	83	86	org/json/JSONException
    //   20	27	95	java/lang/Exception
    //   29	51	95	java/lang/Exception
    //   51	83	95	java/lang/Exception
  }
  
  /* Error */
  public static lzs a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 19
    //   8: iconst_2
    //   9: ldc 211
    //   11: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: new 48	java/io/File
    //   17: dup
    //   18: aload_0
    //   19: ldc 50
    //   21: iconst_0
    //   22: invokevirtual 56	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   25: new 77	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   32: ldc 216
    //   34: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 61	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   47: astore_0
    //   48: aload_0
    //   49: invokevirtual 127	java/io/File:exists	()Z
    //   52: ifne +5 -> 57
    //   55: aconst_null
    //   56: areturn
    //   57: aload_0
    //   58: invokevirtual 219	java/io/File:length	()J
    //   61: l2i
    //   62: newarray byte
    //   64: astore_1
    //   65: new 221	java/io/FileInputStream
    //   68: dup
    //   69: aload_0
    //   70: invokespecial 222	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   73: astore_2
    //   74: aload_2
    //   75: astore_0
    //   76: aload_2
    //   77: aload_1
    //   78: invokevirtual 226	java/io/FileInputStream:read	([B)I
    //   81: pop
    //   82: aload_2
    //   83: astore_0
    //   84: aload_1
    //   85: iconst_0
    //   86: invokestatic 232	com/tencent/mobileqq/utils/Base64Util:decode	([BI)[B
    //   89: astore_1
    //   90: aload_1
    //   91: ifnull +251 -> 342
    //   94: aload_2
    //   95: astore_0
    //   96: aload_1
    //   97: arraylength
    //   98: ifle +244 -> 342
    //   101: aload_2
    //   102: astore_0
    //   103: new 194	java/lang/String
    //   106: dup
    //   107: aload_1
    //   108: invokespecial 235	java/lang/String:<init>	([B)V
    //   111: astore_1
    //   112: aload_1
    //   113: astore_0
    //   114: aload_2
    //   115: ifnull +9 -> 124
    //   118: aload_2
    //   119: invokevirtual 236	java/io/FileInputStream:close	()V
    //   122: aload_1
    //   123: astore_0
    //   124: aload_0
    //   125: invokestatic 70	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   128: ifne -73 -> 55
    //   131: new 238	lzs
    //   134: dup
    //   135: invokespecial 239	lzs:<init>	()V
    //   138: astore_1
    //   139: new 72	org/json/JSONObject
    //   142: dup
    //   143: aload_0
    //   144: invokespecial 75	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   147: astore_0
    //   148: aload_1
    //   149: aload_0
    //   150: ldc 241
    //   152: invokevirtual 244	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   155: putfield 245	lzs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   158: aload_1
    //   159: aload_0
    //   160: ldc 247
    //   162: invokevirtual 244	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   165: putfield 248	lzs:b	Ljava/lang/String;
    //   168: aload_1
    //   169: aload_0
    //   170: ldc 250
    //   172: invokevirtual 244	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   175: putfield 252	lzs:c	Ljava/lang/String;
    //   178: aload_1
    //   179: aload_0
    //   180: ldc 254
    //   182: invokevirtual 244	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   185: putfield 255	lzs:d	Ljava/lang/String;
    //   188: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq +29 -> 220
    //   194: ldc 19
    //   196: iconst_2
    //   197: new 77	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   204: ldc_w 257
    //   207: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_1
    //   211: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 263	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload_1
    //   221: areturn
    //   222: astore_0
    //   223: aload_0
    //   224: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   227: aload_1
    //   228: astore_0
    //   229: goto -105 -> 124
    //   232: astore_3
    //   233: aconst_null
    //   234: astore_1
    //   235: aload_1
    //   236: astore_0
    //   237: aload_3
    //   238: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   241: aload_1
    //   242: ifnull +95 -> 337
    //   245: aload_1
    //   246: invokevirtual 236	java/io/FileInputStream:close	()V
    //   249: aconst_null
    //   250: astore_0
    //   251: goto -127 -> 124
    //   254: astore_0
    //   255: aload_0
    //   256: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   259: aconst_null
    //   260: astore_0
    //   261: goto -137 -> 124
    //   264: astore_1
    //   265: aconst_null
    //   266: astore_0
    //   267: aload_0
    //   268: ifnull +7 -> 275
    //   271: aload_0
    //   272: invokevirtual 236	java/io/FileInputStream:close	()V
    //   275: aload_1
    //   276: athrow
    //   277: astore_0
    //   278: aload_0
    //   279: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   282: goto -7 -> 275
    //   285: astore_0
    //   286: aload_0
    //   287: invokevirtual 95	org/json/JSONException:printStackTrace	()V
    //   290: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   293: ifeq -238 -> 55
    //   296: ldc 19
    //   298: iconst_2
    //   299: new 77	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   306: ldc_w 265
    //   309: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload_0
    //   313: invokevirtual 268	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   316: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 263	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   325: aconst_null
    //   326: areturn
    //   327: astore_1
    //   328: goto -61 -> 267
    //   331: astore_3
    //   332: aload_2
    //   333: astore_1
    //   334: goto -99 -> 235
    //   337: aconst_null
    //   338: astore_0
    //   339: goto -215 -> 124
    //   342: aconst_null
    //   343: astore_1
    //   344: goto -232 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	paramContext	Context
    //   0	347	1	paramString	String
    //   73	260	2	localFileInputStream	java.io.FileInputStream
    //   232	6	3	localException1	Exception
    //   331	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   118	122	222	java/io/IOException
    //   65	74	232	java/lang/Exception
    //   245	249	254	java/io/IOException
    //   65	74	264	finally
    //   271	275	277	java/io/IOException
    //   139	220	285	org/json/JSONException
    //   76	82	327	finally
    //   84	90	327	finally
    //   96	101	327	finally
    //   103	112	327	finally
    //   237	241	327	finally
    //   76	82	331	java/lang/Exception
    //   84	90	331	java/lang/Exception
    //   96	101	331	java/lang/Exception
    //   103	112	331	java/lang/Exception
  }
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.tencent.mobileqq.qqwifi.QQWiFiInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        try
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("QQWiFiHelper", 2, "*createQQWiFiAppInterface load class fail");
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          paramBaseApplicationImpl.printStackTrace();
        }
        paramString = paramString;
        paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "QQWifiPlugin.apk");
        paramBaseApplicationImpl = paramString.loadClass("com.tencent.mobileqq.qqwifi.QQWiFiInterface");
        BasicClassTypeUtil.setClassLoader(true, paramString);
      }
      do
      {
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
      paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    if (paramBaseApplicationImpl == null) {}
    return null;
  }
  
  public static void a(AppInterface paramAppInterface, Intent paramIntent)
  {
    if (paramAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiHelper", 2, "loadQQWiFiService app null,return");
      }
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (paramIntent != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QQWiFiHelper", 2, "loadQQWiFiService intent null,return");
        return;
        localObject = (IPluginManager)paramAppInterface.getManager(26);
        if ((localObject != null) && (((IPluginManager)localObject).isPlugininstalled("QQWifiPlugin.apk"))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQWiFiHelper", 2, "loadQQWiFiService plugin has not installed,return");
      return;
      localObject = paramIntent.getSerializableExtra("services");
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQWiFiHelper", 2, "loadQQWiFiService services null return");
    return;
    paramIntent.setClass(paramAppInterface.a(), QQWiFiAssistService.class);
    paramIntent.putExtra("useSkinEngine", -1);
    paramIntent.putExtra("autoconnect", true);
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiHelper", 2, "loadQQWiFiService services:" + localObject.toString());
    }
    IPluginManager.b(paramAppInterface.a(), a(paramIntent, paramAppInterface.a()));
  }
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (paramAppInterface == null) {
      return;
    }
    Intent localIntent = new Intent(paramAppInterface.a(), QQWiFiAssistService.class);
    localIntent.putExtra("useSkinEngine", -1);
    localIntent.putExtra("isStartForReport", paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiHelper", 2, "Start QQWiFiService load,isStartReport：" + paramBoolean);
    }
    IPluginManager.b(paramAppInterface.a(), a(localIntent, paramAppInterface.a()));
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getDir("qqwifi_dir", 0);
      if (!paramContext.exists())
      {
        if (QLog.isColorLevel())
        {
          QLog.i("QQWiFiHelper", 2, "isHistoryRecordExits dirfile not exists");
          return false;
        }
      }
      else
      {
        paramContext = new File(paramContext, "data_history_WiFiUsedData");
        if (QLog.isColorLevel()) {
          QLog.i("QQWiFiHelper", 2, "isHistoryRecordExits data_history_WiFiUsedData exites:" + paramContext.exists());
        }
        if ((paramContext.exists()) && (paramContext.length() > 10L))
        {
          if (QLog.isColorLevel()) {
            QLog.i("QQWiFiHelper", 2, "isHistoryRecordExits data_history_WiFiUsedData exites,length=" + paramContext.length());
          }
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QQWiFiHelper", 2, "isHistoryRecordExits", paramContext);
      }
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiHelper", 2, "func readEnableInfo begins, ctx:" + paramContext);
    }
    paramContext = a(new File(paramContext.getDir("qqwifi_dir", 0), "enable_file"));
    try
    {
      if (TextUtils.isEmpty(paramContext)) {
        return false;
      }
      boolean bool = new JSONObject(paramContext).getBoolean("mIsQQWiFiEnable_" + paramString);
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiHelper", 2, "func readEnableInfo ends, enable:" + bool);
      }
      return bool;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiHelper", 2, "func readEnableInfo ends, err:" + paramContext.getMessage());
      }
      if (QLog.isColorLevel())
      {
        QLog.d("QQWiFiHelper", 2, "func readEnableInfo ends, enable:" + false);
        return false;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiHelper", 2, "func readEnableInfo ends, err:" + paramContext.getMessage());
        }
      }
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    File localFile = new File(paramContext.getDir("qqwifi_dir", 0), "freetime_file");
    paramContext = a(localFile);
    try
    {
      if (TextUtils.isEmpty(paramContext)) {}
      for (paramContext = new JSONObject(); (!paramContext.has("mFreeTime_" + paramString)) || (paramContext.getInt("mFreeTime_" + paramString) != paramInt); paramContext = new JSONObject(paramContext))
      {
        paramContext.put("mFreeTime_" + paramString, paramInt);
        return a(localFile, paramContext.toString());
      }
      return false;
    }
    catch (JSONException paramContext)
    {
      localFile.delete();
      paramContext.printStackTrace();
      return false;
    }
    catch (Exception paramContext)
    {
      localFile.delete();
      paramContext.printStackTrace();
    }
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    File localFile = new File(paramContext.getDir("qqwifi_dir", 0), "enable_file");
    paramContext = a(localFile);
    try
    {
      if (TextUtils.isEmpty(paramContext)) {}
      for (paramContext = new JSONObject(); (!paramContext.has("mIsQQWiFiEnable_" + paramString)) || (paramContext.getBoolean("mIsQQWiFiEnable_" + paramString) != paramBoolean); paramContext = new JSONObject(paramContext))
      {
        paramContext.put("mIsQQWiFiEnable_" + paramString, paramBoolean);
        return a(localFile, paramContext.toString());
      }
      return false;
    }
    catch (JSONException paramContext)
    {
      localFile.delete();
      paramContext.printStackTrace();
      return false;
    }
    catch (Exception paramContext)
    {
      localFile.delete();
      paramContext.printStackTrace();
    }
  }
  
  public static boolean a(Context paramContext, List paramList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    File localFile;
    int i;
    if (paramList != null)
    {
      localFile = new File(paramContext.getDir("qqwifi_dir", 0), "ssids_file");
      List localList = a(paramContext);
      paramContext = new JSONArray();
      Object localObject;
      if (localList != null)
      {
        localObject = localList.iterator();
        while (((Iterator)localObject).hasNext()) {
          paramContext.put((String)((Iterator)localObject).next());
        }
      }
      paramList = paramList.iterator();
      i = 0;
      if (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        if ((TextUtils.isEmpty((CharSequence)localObject)) || ((localList != null) && (localList.contains(localObject)))) {
          break label193;
        }
        paramContext.put(localObject);
        i = 1;
      }
    }
    label193:
    for (;;)
    {
      break;
      bool1 = bool2;
      if (i != 0) {
        paramList = new JSONObject();
      }
      try
      {
        paramList.put("ssidList", paramContext);
        bool1 = a(localFile, paramList.toString());
        return bool1;
      }
      catch (JSONException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
  }
  
  public static boolean a(Context paramContext, Map paramMap)
  {
    Object localObject1;
    String str;
    if (paramMap != null)
    {
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
      localObject1 = "";
      if (paramMap.containsKey("blackBarAdapter"))
      {
        localObject2 = (String)paramMap.get("blackBarAdapter");
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (localSharedPreferences != null)
          {
            localSharedPreferences.edit().putString("blackBarAdapter", (String)localObject2).commit();
            localObject1 = localObject2;
          }
        }
      }
      if (!paramMap.containsKey("whiteBarAdapter")) {
        break label406;
      }
      str = (String)paramMap.get("whiteBarAdapter");
      localObject2 = str;
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = str;
        if (localSharedPreferences != null)
        {
          localSharedPreferences.edit().putString("whiteBarAdapter", str).commit();
          localObject2 = str;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQWiFiHelper", 2, "updateParams:blackBarAdapter=" + (String)localObject1 + " whiteBarAdapter=" + (String)localObject2);
      }
    }
    Object localObject2 = null;
    for (;;)
    {
      try
      {
        localObject1 = new File(paramContext.getDir("qqwifi_dir", 0), "params_file");
        int i;
        boolean bool;
        return false;
      }
      catch (Exception paramContext)
      {
        try
        {
          paramContext = a((File)localObject1);
          if (TextUtils.isEmpty(paramContext))
          {
            paramContext = new JSONObject();
            if (paramMap == null) {
              break label417;
            }
            localObject2 = paramMap.keySet().iterator();
            i = 0;
            j = i;
            if (((Iterator)localObject2).hasNext())
            {
              str = (String)((Iterator)localObject2).next();
              if ((paramContext.has(str)) && (paramContext.get(str).equals(paramMap.get(str)))) {
                break label403;
              }
              paramContext.put(str, paramMap.get(str));
              i = 1;
              break label414;
            }
          }
          else
          {
            paramContext = new JSONObject(paramContext);
            continue;
          }
          if (j == 0) {
            break label394;
          }
          bool = a((File)localObject1, paramContext.toString());
          return bool;
        }
        catch (Exception paramContext)
        {
          paramMap = (Map)localObject1;
          continue;
        }
        paramContext = paramContext;
        paramMap = (Map)localObject2;
        if (paramMap != null) {
          paramMap.delete();
        }
        paramContext.printStackTrace();
      }
      label394:
      label403:
      break label414;
      label406:
      localObject2 = "";
      break;
      label414:
      continue;
      label417:
      int j = 0;
    }
  }
  
  /* Error */
  public static boolean a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: invokestatic 70	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +24 -> 30
    //   9: iload_3
    //   10: istore_2
    //   11: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +14 -> 28
    //   17: ldc 19
    //   19: iconst_2
    //   20: ldc_w 526
    //   23: invokestatic 263	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: iload_3
    //   27: istore_2
    //   28: iload_2
    //   29: ireturn
    //   30: aconst_null
    //   31: astore 4
    //   33: aload_1
    //   34: invokevirtual 530	java/lang/String:getBytes	()[B
    //   37: astore_1
    //   38: new 532	java/io/FileOutputStream
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 533	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   46: astore_0
    //   47: aload_0
    //   48: aload_1
    //   49: invokevirtual 536	java/io/FileOutputStream:write	([B)V
    //   52: iconst_1
    //   53: istore_2
    //   54: aload_0
    //   55: ifnull -27 -> 28
    //   58: aload_0
    //   59: invokevirtual 537	java/io/FileOutputStream:close	()V
    //   62: iconst_1
    //   63: ireturn
    //   64: astore_0
    //   65: iconst_1
    //   66: ireturn
    //   67: astore_0
    //   68: aconst_null
    //   69: astore_0
    //   70: iload_3
    //   71: istore_2
    //   72: aload_0
    //   73: ifnull -45 -> 28
    //   76: aload_0
    //   77: invokevirtual 537	java/io/FileOutputStream:close	()V
    //   80: iconst_0
    //   81: ireturn
    //   82: astore_0
    //   83: iconst_0
    //   84: ireturn
    //   85: astore_0
    //   86: aload 4
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull +7 -> 97
    //   93: aload_1
    //   94: invokevirtual 537	java/io/FileOutputStream:close	()V
    //   97: aload_0
    //   98: athrow
    //   99: astore_1
    //   100: goto -3 -> 97
    //   103: astore 4
    //   105: aload_0
    //   106: astore_1
    //   107: aload 4
    //   109: astore_0
    //   110: goto -21 -> 89
    //   113: astore_1
    //   114: goto -44 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramFile	File
    //   0	117	1	paramString	String
    //   10	62	2	bool1	boolean
    //   1	70	3	bool2	boolean
    //   31	56	4	localObject1	Object
    //   103	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   58	62	64	java/io/IOException
    //   33	47	67	java/lang/Exception
    //   76	80	82	java/io/IOException
    //   33	47	85	finally
    //   93	97	99	java/io/IOException
    //   47	52	103	finally
    //   47	52	113	java/lang/Exception
  }
  
  public static AppRuntime b(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.tencent.mobileqq.qqwifi.QQWiFiMapInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        try
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("QQWiFiHelper", 2, "*createQQWiFiMapAppInterface load class fail");
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          paramBaseApplicationImpl.printStackTrace();
        }
        paramString = paramString;
        paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "QQWifiPlugin.apk");
        paramBaseApplicationImpl = paramString.loadClass("com.tencent.mobileqq.qqwifi.QQWiFiMapInterface");
        BasicClassTypeUtil.setClassLoader(true, paramString);
      }
      do
      {
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
      paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    if (paramBaseApplicationImpl == null) {}
    return null;
  }
  
  public static boolean b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getDir("qqwifi_dir", 0);
      if (!paramContext.exists())
      {
        if (QLog.isColorLevel())
        {
          QLog.i("QQWiFiHelper", 2, "isStatusRecordExits dirfile not exists");
          return false;
        }
      }
      else
      {
        paramContext = new File(paramContext, "data_buffer_WiFiStatus_");
        if (QLog.isColorLevel()) {
          QLog.i("QQWiFiHelper", 2, "isStatusRecordExits data_buffer_WiFiStatus_ exites:" + paramContext.exists());
        }
        if ((paramContext.exists()) && (paramContext.length() > 10L))
        {
          if (QLog.isColorLevel()) {
            QLog.i("QQWiFiHelper", 2, "isStatusRecordExits data_buffer_WiFiStatus_ exites,length=" + paramContext.length());
          }
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QQWiFiHelper", 2, "isStatusRecordExits", paramContext);
      }
    }
    return false;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    Context localContext = BaseApplication.getContext();
    int i;
    boolean bool1;
    if (Build.VERSION.SDK_INT > 10)
    {
      i = 4;
      i = localContext.getSharedPreferences("mobileQQ", i).getInt("bar_switch_operation" + paramString, 0);
      if (i != 1) {
        break label68;
      }
      bool1 = true;
    }
    label68:
    do
    {
      do
      {
        return bool1;
        i = 0;
        break;
        bool1 = bool2;
      } while (i == -1);
      paramContext = a(paramContext);
      bool1 = bool2;
    } while (paramContext == null);
    return "1".equals((String)paramContext.get("systemNotifyBarSwitch"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qqwifi.QQWiFiHelper
 * JD-Core Version:    0.7.0.1
 */