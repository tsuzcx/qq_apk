package com.tencent.mobileqq.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import java.util.HashMap;
import java.util.Iterator;
import ktx;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

public class ReverseGeocode
{
  private static final int jdField_a_of_type_Int = 10;
  private static final Uri jdField_a_of_type_AndroidNetUri;
  public static final String a = "ctnet";
  private static final int b = 20000;
  public static final String b = "ctwap";
  private static final int c = 10000;
  public static final String c = "cmnet";
  private static final int d = 8192;
  public static final String d = "cmwap";
  private static final int e = 10;
  public static final String e = "uninet";
  private static final int f = 20000;
  public static final String f = "uniwap";
  private static final int g = 10000;
  public static final String g = "3gwap";
  
  static
  {
    a = Uri.parse("content://telephony/carriers/preferapn");
  }
  
  private static String a(Context paramContext)
  {
    String str = null;
    int i;
    if (paramContext == null)
    {
      str = Proxy.getDefaultHost();
      i = Proxy.getDefaultPort();
    }
    for (;;)
    {
      if ((str != null) && (str.trim().length() > 0))
      {
        return str + ":" + i;
        NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localNetworkInfo != null)
        {
          if (NetworkUtil.a(localNetworkInfo))
          {
            str = Proxy.getHost(paramContext);
            int j = Proxy.getPort(paramContext);
            if ((str != null) && (str.trim().length() != 0))
            {
              i = j;
              if (j > 0) {
                continue;
              }
            }
            str = Proxy.getDefaultHost();
            j = Proxy.getDefaultPort();
            if ((str != null) && (str.trim().length() != 0))
            {
              i = j;
              if (j > 0) {
                continue;
              }
            }
            paramContext = a(paramContext);
            str = paramContext.jdField_a_of_type_JavaLangString;
            i = paramContext.jdField_a_of_type_Int;
            continue;
          }
          return null;
        }
      }
      else
      {
        return "";
      }
      i = 0;
    }
  }
  
  /* Error */
  public static String a(Context paramContext, double paramDouble1, double paramDouble2, int paramInt, HttpClient paramHttpClient)
  {
    // Byte code:
    //   0: new 69	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   7: ldc 126
    //   9: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: dload_1
    //   13: invokevirtual 129	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   16: ldc 131
    //   18: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: dload_3
    //   22: invokevirtual 129	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   25: ldc 133
    //   27: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 6
    //   35: new 135	org/apache/http/params/BasicHttpParams
    //   38: dup
    //   39: invokespecial 136	org/apache/http/params/BasicHttpParams:<init>	()V
    //   42: astore 7
    //   44: aload 7
    //   46: ldc2_w 137
    //   49: invokestatic 144	org/apache/http/conn/params/ConnManagerParams:setTimeout	(Lorg/apache/http/params/HttpParams;J)V
    //   52: aload 7
    //   54: new 146	org/apache/http/conn/params/ConnPerRouteBean
    //   57: dup
    //   58: bipush 10
    //   60: invokespecial 149	org/apache/http/conn/params/ConnPerRouteBean:<init>	(I)V
    //   63: invokestatic 153	org/apache/http/conn/params/ConnManagerParams:setMaxConnectionsPerRoute	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/params/ConnPerRoute;)V
    //   66: aload 7
    //   68: bipush 10
    //   70: invokestatic 157	org/apache/http/conn/params/ConnManagerParams:setMaxTotalConnections	(Lorg/apache/http/params/HttpParams;I)V
    //   73: aload 7
    //   75: sipush 10000
    //   78: invokestatic 162	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   81: aload 7
    //   83: sipush 20000
    //   86: invokestatic 165	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   89: aload 7
    //   91: iconst_1
    //   92: invokestatic 169	org/apache/http/params/HttpConnectionParams:setTcpNoDelay	(Lorg/apache/http/params/HttpParams;Z)V
    //   95: aload 7
    //   97: sipush 8192
    //   100: invokestatic 172	org/apache/http/params/HttpConnectionParams:setSocketBufferSize	(Lorg/apache/http/params/HttpParams;I)V
    //   103: aload 7
    //   105: getstatic 178	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   108: invokestatic 184	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
    //   111: aload 7
    //   113: ldc 186
    //   115: invokestatic 190	org/apache/http/params/HttpProtocolParams:setUserAgent	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   118: new 192	org/apache/http/impl/client/DefaultHttpClient
    //   121: dup
    //   122: aload 7
    //   124: invokespecial 195	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   127: astore 7
    //   129: aload_0
    //   130: aload 7
    //   132: invokestatic 198	com/tencent/mobileqq/utils/ReverseGeocode:a	(Landroid/content/Context;Lorg/apache/http/client/HttpClient;)V
    //   135: new 200	java/io/BufferedReader
    //   138: dup
    //   139: new 202	java/io/InputStreamReader
    //   142: dup
    //   143: aload 7
    //   145: new 204	org/apache/http/client/methods/HttpGet
    //   148: dup
    //   149: aload 6
    //   151: invokespecial 207	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   154: invokeinterface 213 2 0
    //   159: invokeinterface 219 1 0
    //   164: invokeinterface 225 1 0
    //   169: invokespecial 228	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   172: invokespecial 231	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   175: astore 7
    //   177: ldc 119
    //   179: astore_0
    //   180: aload 7
    //   182: invokevirtual 234	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   185: astore 8
    //   187: aload_0
    //   188: astore 6
    //   190: aload 8
    //   192: ifnull +43 -> 235
    //   195: new 69	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   202: aload_0
    //   203: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload 8
    //   208: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: astore 6
    //   216: aload 6
    //   218: astore_0
    //   219: goto -39 -> 180
    //   222: astore 6
    //   224: ldc 119
    //   226: astore_0
    //   227: aload 6
    //   229: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   232: aload_0
    //   233: astore 6
    //   235: new 239	org/json/JSONObject
    //   238: dup
    //   239: aload 6
    //   241: invokespecial 240	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   244: ldc 242
    //   246: invokevirtual 246	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   249: astore_0
    //   250: aload_0
    //   251: iconst_0
    //   252: invokevirtual 252	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   255: astore 7
    //   257: ldc 119
    //   259: astore 6
    //   261: aload 6
    //   263: astore_0
    //   264: aload 7
    //   266: ifnull +11 -> 277
    //   269: aload 7
    //   271: ldc 254
    //   273: invokevirtual 258	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   276: astore_0
    //   277: aload_0
    //   278: ldc_w 260
    //   281: invokevirtual 264	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   284: istore 5
    //   286: aload_0
    //   287: astore 6
    //   289: iload 5
    //   291: iflt +15 -> 306
    //   294: aload_0
    //   295: iconst_0
    //   296: iload 5
    //   298: invokevirtual 268	java/lang/String:substring	(II)Ljava/lang/String;
    //   301: invokevirtual 64	java/lang/String:trim	()Ljava/lang/String;
    //   304: astore 6
    //   306: aload 6
    //   308: areturn
    //   309: astore_0
    //   310: ldc 119
    //   312: areturn
    //   313: astore_0
    //   314: aload_0
    //   315: invokevirtual 269	org/json/JSONException:printStackTrace	()V
    //   318: aload 6
    //   320: astore_0
    //   321: goto -44 -> 277
    //   324: astore 6
    //   326: goto -99 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	paramContext	Context
    //   0	329	1	paramDouble1	double
    //   0	329	3	paramDouble2	double
    //   0	329	5	paramInt	int
    //   0	329	6	paramHttpClient	HttpClient
    //   42	228	7	localObject	Object
    //   185	22	8	str	String
    // Exception table:
    //   from	to	target	type
    //   135	177	222	java/io/IOException
    //   235	250	309	org/json/JSONException
    //   269	277	313	org/json/JSONException
    //   180	187	324	java/io/IOException
    //   195	216	324	java/io/IOException
  }
  
  /* Error */
  private static ktx a(Context paramContext)
  {
    // Byte code:
    //   0: new 113	ktx
    //   3: dup
    //   4: invokespecial 272	ktx:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: invokevirtual 276	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: getstatic 44	com/tencent/mobileqq/utils/ReverseGeocode:a	Landroid/net/Uri;
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: invokevirtual 282	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore_1
    //   24: aload_1
    //   25: astore_0
    //   26: aload_1
    //   27: invokeinterface 288 1 0
    //   32: pop
    //   33: aload_1
    //   34: astore_0
    //   35: aload_1
    //   36: aload_1
    //   37: ldc_w 290
    //   40: invokeinterface 293 2 0
    //   45: invokeinterface 296 2 0
    //   50: astore_2
    //   51: aload_2
    //   52: ifnull +291 -> 343
    //   55: aload_1
    //   56: astore_0
    //   57: aload_2
    //   58: invokevirtual 299	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   61: astore_2
    //   62: aload_1
    //   63: astore_0
    //   64: aload_1
    //   65: aload_1
    //   66: ldc_w 301
    //   69: invokeinterface 293 2 0
    //   74: invokeinterface 296 2 0
    //   79: astore 6
    //   81: aload_1
    //   82: astore_0
    //   83: aload_1
    //   84: aload_1
    //   85: ldc_w 303
    //   88: invokeinterface 293 2 0
    //   93: invokeinterface 296 2 0
    //   98: astore 4
    //   100: aload 4
    //   102: astore_3
    //   103: aload 4
    //   105: ifnull +11 -> 116
    //   108: aload_1
    //   109: astore_0
    //   110: aload 4
    //   112: invokevirtual 299	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   115: astore_3
    //   116: aload_1
    //   117: astore_0
    //   118: aload_1
    //   119: invokeinterface 306 1 0
    //   124: aload_2
    //   125: ifnull +61 -> 186
    //   128: aload_1
    //   129: astore_0
    //   130: aload_2
    //   131: invokevirtual 67	java/lang/String:length	()I
    //   134: ifle +52 -> 186
    //   137: aload_1
    //   138: astore_0
    //   139: aload 6
    //   141: invokestatic 312	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   144: invokevirtual 315	java/lang/Integer:intValue	()I
    //   147: ifle +39 -> 186
    //   150: aload_1
    //   151: astore_0
    //   152: aload 5
    //   154: aload_2
    //   155: putfield 115	ktx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   158: aload_1
    //   159: astore_0
    //   160: aload 5
    //   162: aload 6
    //   164: invokestatic 312	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   167: invokevirtual 315	java/lang/Integer:intValue	()I
    //   170: putfield 117	ktx:jdField_a_of_type_Int	I
    //   173: aload_1
    //   174: ifnull +9 -> 183
    //   177: aload_1
    //   178: invokeinterface 306 1 0
    //   183: aload 5
    //   185: areturn
    //   186: aload_3
    //   187: ifnull +56 -> 243
    //   190: aload_1
    //   191: astore_0
    //   192: aload_3
    //   193: ldc 15
    //   195: invokevirtual 319	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   198: ifeq +45 -> 243
    //   201: aload_1
    //   202: astore_0
    //   203: aload 5
    //   205: ldc_w 321
    //   208: putfield 115	ktx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   211: aload_1
    //   212: astore_0
    //   213: aload 5
    //   215: bipush 80
    //   217: putfield 117	ktx:jdField_a_of_type_Int	I
    //   220: goto -47 -> 173
    //   223: astore_2
    //   224: aload_1
    //   225: astore_0
    //   226: aload_2
    //   227: invokevirtual 322	java/lang/Exception:printStackTrace	()V
    //   230: aload_1
    //   231: ifnull +9 -> 240
    //   234: aload_1
    //   235: invokeinterface 306 1 0
    //   240: aload 5
    //   242: areturn
    //   243: aload_3
    //   244: ifnull +50 -> 294
    //   247: aload_1
    //   248: astore_0
    //   249: aload_3
    //   250: ldc 23
    //   252: invokevirtual 319	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   255: ifeq +39 -> 294
    //   258: aload_1
    //   259: astore_0
    //   260: aload 5
    //   262: ldc_w 324
    //   265: putfield 115	ktx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   268: aload_1
    //   269: astore_0
    //   270: aload 5
    //   272: bipush 80
    //   274: putfield 117	ktx:jdField_a_of_type_Int	I
    //   277: goto -104 -> 173
    //   280: astore_1
    //   281: aload_0
    //   282: ifnull +9 -> 291
    //   285: aload_0
    //   286: invokeinterface 306 1 0
    //   291: aload 5
    //   293: areturn
    //   294: aload_3
    //   295: ifnull -122 -> 173
    //   298: aload_1
    //   299: astore_0
    //   300: aload_3
    //   301: ldc 29
    //   303: invokevirtual 319	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   306: ifeq -133 -> 173
    //   309: aload_1
    //   310: astore_0
    //   311: aload 5
    //   313: ldc_w 324
    //   316: putfield 115	ktx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   319: aload_1
    //   320: astore_0
    //   321: aload 5
    //   323: bipush 80
    //   325: putfield 117	ktx:jdField_a_of_type_Int	I
    //   328: goto -155 -> 173
    //   331: astore_0
    //   332: aconst_null
    //   333: astore_0
    //   334: goto -53 -> 281
    //   337: astore_2
    //   338: aconst_null
    //   339: astore_1
    //   340: goto -116 -> 224
    //   343: goto -281 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	paramContext	Context
    //   23	246	1	localCursor	android.database.Cursor
    //   280	40	1	localObject1	Object
    //   339	1	1	localObject2	Object
    //   50	105	2	str1	String
    //   223	4	2	localException1	java.lang.Exception
    //   337	1	2	localException2	java.lang.Exception
    //   102	199	3	str2	String
    //   98	13	4	str3	String
    //   7	315	5	localktx	ktx
    //   79	84	6	str4	String
    // Exception table:
    //   from	to	target	type
    //   26	33	223	java/lang/Exception
    //   35	51	223	java/lang/Exception
    //   57	62	223	java/lang/Exception
    //   64	81	223	java/lang/Exception
    //   83	100	223	java/lang/Exception
    //   110	116	223	java/lang/Exception
    //   118	124	223	java/lang/Exception
    //   130	137	223	java/lang/Exception
    //   139	150	223	java/lang/Exception
    //   152	158	223	java/lang/Exception
    //   160	173	223	java/lang/Exception
    //   192	201	223	java/lang/Exception
    //   203	211	223	java/lang/Exception
    //   213	220	223	java/lang/Exception
    //   249	258	223	java/lang/Exception
    //   260	268	223	java/lang/Exception
    //   270	277	223	java/lang/Exception
    //   300	309	223	java/lang/Exception
    //   311	319	223	java/lang/Exception
    //   321	328	223	java/lang/Exception
    //   26	33	280	finally
    //   35	51	280	finally
    //   57	62	280	finally
    //   64	81	280	finally
    //   83	100	280	finally
    //   110	116	280	finally
    //   118	124	280	finally
    //   130	137	280	finally
    //   139	150	280	finally
    //   152	158	280	finally
    //   160	173	280	finally
    //   192	201	280	finally
    //   203	211	280	finally
    //   213	220	280	finally
    //   226	230	280	finally
    //   249	258	280	finally
    //   260	268	280	finally
    //   270	277	280	finally
    //   300	309	280	finally
    //   311	319	280	finally
    //   321	328	280	finally
    //   9	24	331	finally
    //   9	24	337	java/lang/Exception
  }
  
  public static void a(Context paramContext, HttpClient paramHttpClient)
  {
    paramHttpClient.getParams().removeParameter("http.route.default-proxy");
    paramContext = a(paramContext);
    if ((paramContext != null) && (paramContext.length() > 0))
    {
      paramContext = paramContext.split(":");
      if ((paramContext != null) && (paramContext.length == 2))
      {
        paramContext = new HttpHost(paramContext[0], Integer.valueOf(paramContext[1]).intValue());
        paramHttpClient.getParams().setParameter("http.route.default-proxy", paramContext);
      }
    }
  }
  
  private static void a(JSONObject paramJSONObject, HashMap paramHashMap)
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      try
      {
        String str2 = paramJSONObject.getString(str1);
        if (!str2.startsWith("{")) {
          break label66;
        }
        a(new JSONObject(str2), paramHashMap);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      continue;
      label66:
      paramHashMap.put(localJSONException, paramJSONObject.getString(localJSONException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ReverseGeocode
 * JD-Core Version:    0.7.0.1
 */