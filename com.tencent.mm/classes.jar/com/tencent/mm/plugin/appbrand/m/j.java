package com.tencent.mm.plugin.appbrand.m;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.IpPrefix;
import android.net.LinkProperties;
import android.net.Network;
import android.net.RouteInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.o;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.util.InetAddressUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public enum j
{
  public static boolean A(c paramc)
  {
    AppMethodBeat.i(108208);
    switch (j.2.gYx[paramc.asW().ordinal()])
    {
    default: 
      AppMethodBeat.o(108208);
      return false;
    }
    AppMethodBeat.o(108208);
    return true;
  }
  
  public static HashMap<String, String> DV(String paramString)
  {
    AppMethodBeat.i(108190);
    String str3 = "";
    Object localObject2 = "";
    str2 = "";
    Object localObject1 = localObject2;
    String str1 = str3;
    try
    {
      Uri localUri = Uri.parse(paramString);
      localObject1 = localObject2;
      str1 = str3;
      paramString = localUri.getHost();
      localObject1 = localObject2;
      str1 = paramString;
      localObject2 = localUri.getScheme();
      localObject1 = localObject2;
      str1 = paramString;
      int i = localUri.getPort();
      str2 = String.valueOf(i);
      str1 = paramString;
      localObject1 = localObject2;
      paramString = str2;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", paramString, "Exception: parseUrl error", new Object[0]);
        paramString = str2;
      }
    }
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("host", str1);
    ((HashMap)localObject2).put("scheme", localObject1);
    ((HashMap)localObject2).put("port", paramString);
    AppMethodBeat.o(108190);
    return localObject2;
  }
  
  private static boolean DW(String paramString)
  {
    AppMethodBeat.i(108196);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, url is null");
      AppMethodBeat.o(108196);
      return false;
    }
    paramString = paramString.split("\\.");
    if (paramString.length != 4)
    {
      ab.e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, invalid ip format");
      AppMethodBeat.o(108196);
      return false;
    }
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      int k = bo.getInt(paramString[i], -1);
      if ((k < 0) || (k > 255))
      {
        ab.e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, invalid ip format");
        AppMethodBeat.o(108196);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(108196);
    return true;
  }
  
  /* Error */
  public static int DX(String paramString)
  {
    // Byte code:
    //   0: ldc 129
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 131	com/tencent/mm/plugin/appbrand/m/j:DW	(Ljava/lang/String;)Z
    //   9: ifne +17 -> 26
    //   12: ldc 88
    //   14: ldc 110
    //   16: invokestatic 114	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 129
    //   21: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: iconst_0
    //   25: ireturn
    //   26: aload_0
    //   27: ldc 116
    //   29: invokevirtual 120	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   32: astore 5
    //   34: iconst_4
    //   35: newarray byte
    //   37: dup
    //   38: iconst_0
    //   39: aload 5
    //   41: iconst_0
    //   42: aaload
    //   43: iconst_0
    //   44: invokestatic 126	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   47: sipush 255
    //   50: iand
    //   51: i2b
    //   52: bastore
    //   53: dup
    //   54: iconst_1
    //   55: aload 5
    //   57: iconst_1
    //   58: aaload
    //   59: iconst_0
    //   60: invokestatic 126	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   63: sipush 255
    //   66: iand
    //   67: i2b
    //   68: bastore
    //   69: dup
    //   70: iconst_2
    //   71: aload 5
    //   73: iconst_2
    //   74: aaload
    //   75: iconst_0
    //   76: invokestatic 126	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   79: sipush 255
    //   82: iand
    //   83: i2b
    //   84: bastore
    //   85: dup
    //   86: iconst_3
    //   87: aload 5
    //   89: iconst_3
    //   90: aaload
    //   91: iconst_0
    //   92: invokestatic 126	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   95: sipush 255
    //   98: iand
    //   99: i2b
    //   100: bastore
    //   101: invokestatic 137	com/tencent/mm/a/o:z	([B)I
    //   104: istore_3
    //   105: invokestatic 143	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   108: invokevirtual 148	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   111: ldc 150
    //   113: invokevirtual 154	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   116: checkcast 156	android/net/wifi/WifiManager
    //   119: astore 5
    //   121: aload 5
    //   123: invokevirtual 159	android/net/wifi/WifiManager:getWifiState	()I
    //   126: iconst_3
    //   127: if_icmpne +182 -> 309
    //   130: aload 5
    //   132: invokevirtual 163	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   135: invokevirtual 168	android/net/wifi/WifiInfo:getIpAddress	()I
    //   138: istore 4
    //   140: new 170	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   147: iload 4
    //   149: sipush 255
    //   152: iand
    //   153: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: ldc 177
    //   158: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: iload 4
    //   163: bipush 8
    //   165: ishr
    //   166: sipush 255
    //   169: iand
    //   170: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: ldc 177
    //   175: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: iload 4
    //   180: bipush 16
    //   182: ishr
    //   183: sipush 255
    //   186: iand
    //   187: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: ldc 177
    //   192: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: iload 4
    //   197: bipush 24
    //   199: ishr
    //   200: sipush 255
    //   203: iand
    //   204: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   207: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: astore 6
    //   212: aload 5
    //   214: invokevirtual 187	android/net/wifi/WifiManager:getDhcpInfo	()Landroid/net/DhcpInfo;
    //   217: getfield 193	android/net/DhcpInfo:netmask	I
    //   220: istore_2
    //   221: iload_2
    //   222: istore_1
    //   223: iload_2
    //   224: ifgt +15 -> 239
    //   227: getstatic 198	android/os/Build$VERSION:SDK_INT	I
    //   230: bipush 21
    //   232: if_icmplt +65 -> 297
    //   235: invokestatic 201	com/tencent/mm/plugin/appbrand/m/j:aIo	()I
    //   238: istore_1
    //   239: ldc 88
    //   241: ldc 203
    //   243: iconst_5
    //   244: anewarray 92	java/lang/Object
    //   247: dup
    //   248: iconst_0
    //   249: aload_0
    //   250: aastore
    //   251: dup
    //   252: iconst_1
    //   253: aload 6
    //   255: aastore
    //   256: dup
    //   257: iconst_2
    //   258: iload_3
    //   259: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   262: aastore
    //   263: dup
    //   264: iconst_3
    //   265: iload 4
    //   267: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: aastore
    //   271: dup
    //   272: iconst_4
    //   273: iload_1
    //   274: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: aastore
    //   278: invokestatic 211	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   281: iload_1
    //   282: i2l
    //   283: iload_3
    //   284: iload 4
    //   286: invokestatic 214	com/tencent/mm/plugin/appbrand/m/j:e	(JII)I
    //   289: istore_1
    //   290: ldc 129
    //   292: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   295: iload_1
    //   296: ireturn
    //   297: ldc 88
    //   299: ldc 216
    //   301: invokestatic 114	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: iload_2
    //   305: istore_1
    //   306: goto -67 -> 239
    //   309: aload 5
    //   311: invokevirtual 220	java/lang/Object:getClass	()Ljava/lang/Class;
    //   314: ldc 222
    //   316: invokevirtual 228	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   319: aload 5
    //   321: invokevirtual 234	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   324: checkcast 205	java/lang/Integer
    //   327: invokevirtual 237	java/lang/Integer:intValue	()I
    //   330: istore_1
    //   331: aload 5
    //   333: invokevirtual 220	java/lang/Object:getClass	()Ljava/lang/Class;
    //   336: ldc 239
    //   338: iconst_0
    //   339: anewarray 224	java/lang/Class
    //   342: invokevirtual 243	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   345: aload 5
    //   347: iconst_0
    //   348: anewarray 92	java/lang/Object
    //   351: invokevirtual 249	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   354: checkcast 205	java/lang/Integer
    //   357: invokevirtual 237	java/lang/Integer:intValue	()I
    //   360: istore_2
    //   361: iload_2
    //   362: iload_1
    //   363: if_icmpne +44 -> 407
    //   366: ldc 88
    //   368: ldc 251
    //   370: invokestatic 253	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: iload_3
    //   374: invokestatic 257	com/tencent/mm/plugin/appbrand/m/j:oV	(I)I
    //   377: istore_1
    //   378: ldc 129
    //   380: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   383: iload_1
    //   384: ireturn
    //   385: astore_0
    //   386: bipush 13
    //   388: istore_1
    //   389: ldc 88
    //   391: aload_0
    //   392: ldc_w 259
    //   395: iconst_0
    //   396: anewarray 92	java/lang/Object
    //   399: invokestatic 98	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   402: iconst_0
    //   403: istore_2
    //   404: goto -43 -> 361
    //   407: ldc 88
    //   409: ldc_w 261
    //   412: iconst_1
    //   413: anewarray 92	java/lang/Object
    //   416: dup
    //   417: iconst_0
    //   418: iload_2
    //   419: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   422: aastore
    //   423: invokestatic 211	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   426: ldc 129
    //   428: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   431: iconst_0
    //   432: ireturn
    //   433: astore_0
    //   434: goto -45 -> 389
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	437	0	paramString	String
    //   222	167	1	i	int
    //   220	199	2	j	int
    //   104	270	3	k	int
    //   138	147	4	m	int
    //   32	314	5	localObject	Object
    //   210	44	6	str	String
    // Exception table:
    //   from	to	target	type
    //   309	331	385	java/lang/Exception
    //   331	361	433	java/lang/Exception
  }
  
  public static String DY(String paramString)
  {
    return paramString;
  }
  
  private static Map<String, String> J(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(108191);
    localHashMap = new HashMap();
    try
    {
      paramJSONObject = paramJSONObject.optJSONObject("header");
      if (paramJSONObject != null)
      {
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (str != null) {
            localHashMap.put(str.toLowerCase(), paramJSONObject.getString(str));
          }
        }
      }
      return localHashMap;
    }
    catch (Exception paramJSONObject)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", paramJSONObject, "Exception: get header error", new Object[0]);
      AppMethodBeat.o(108191);
    }
  }
  
  public static Map<String, String> K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(108192);
    localHashMap = new HashMap();
    try
    {
      paramJSONObject = paramJSONObject.optJSONObject("formData");
      if (paramJSONObject != null)
      {
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localHashMap.put(str, paramJSONObject.getString(str));
        }
      }
      return localHashMap;
    }
    catch (Exception paramJSONObject)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", paramJSONObject, "Exception: get form error", new Object[0]);
      AppMethodBeat.o(108192);
    }
  }
  
  public static String L(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(108211);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(108211);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    paramJSONObject = paramJSONObject.optJSONArray("protocols");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localLinkedList.add(paramJSONObject.optString(i));
        i += 1;
      }
    }
    if (!bo.es(localLinkedList))
    {
      paramJSONObject = TextUtils.join(", ", localLinkedList);
      AppMethodBeat.o(108211);
      return paramJSONObject;
    }
    AppMethodBeat.o(108211);
    return null;
  }
  
  public static int a(a parama, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return parama.isn;
    case 1: 
      return parama.iso;
    case 3: 
      return parama.isq;
    }
    return parama.isp;
  }
  
  public static String a(URI paramURI)
  {
    AppMethodBeat.i(108212);
    Object localObject2 = paramURI.getScheme();
    if (bo.isNullOrNil((String)localObject2))
    {
      AppMethodBeat.o(108212);
      return null;
    }
    Object localObject1;
    if (((String)localObject2).equalsIgnoreCase("wss"))
    {
      localObject1 = "https";
      localObject2 = new StringBuilder((String)localObject1);
      ((StringBuilder)localObject2).append("://");
      ((StringBuilder)localObject2).append(paramURI.getHost());
      i = paramURI.getPort();
      if ((i != -1) && ((!((String)localObject1).equalsIgnoreCase("http")) || (i != 80)) && ((!((String)localObject1).equalsIgnoreCase("https")) || (i != 443))) {
        break label164;
      }
    }
    label164:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append(paramURI.getPort());
      }
      paramURI = ((StringBuilder)localObject2).toString();
      AppMethodBeat.o(108212);
      return paramURI;
      localObject1 = localObject2;
      if (!((String)localObject2).equalsIgnoreCase("ws")) {
        break;
      }
      localObject1 = "http";
      break;
    }
  }
  
  public static Map<String, String> a(JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(108200);
    paramJSONObject = J(paramJSONObject);
    if (parama == null)
    {
      ab.e("MicroMsg.AppBrandNetworkUtil", "hy: no network config!");
      AppMethodBeat.o(108200);
      return paramJSONObject;
    }
    Object localObject1;
    if (parama.mode == 1)
    {
      localObject1 = paramJSONObject;
      if (parama.iss != null)
      {
        localObject1 = parama.iss;
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())) {
          break label115;
        }
        ab.e("MicroMsg.AppBrandNetworkUtil", "filterHttpHeaderBlackList fail, headerMap is null or blacklist is null or nil.");
      }
    }
    for (;;)
    {
      label72:
      localObject1 = paramJSONObject;
      label115:
      String str1;
      do
      {
        do
        {
          ((Map)localObject1).remove("referer");
          paramJSONObject = (JSONObject)localObject1;
          if (TextUtils.isEmpty(parama.referer)) {
            break;
          }
          ((Map)localObject1).put("referer", parama.referer);
          paramJSONObject = (JSONObject)localObject1;
          break;
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              localObject2 = ((String)localObject2).toLowerCase();
              str1 = (String)paramJSONObject.remove(localObject2);
              if (str1 != null) {
                ab.v("MicroMsg.AppBrandNetworkUtil", "remove key %s value %s", new Object[] { localObject2, str1 });
              }
            }
          }
          break label72;
          localObject1 = paramJSONObject;
        } while (parama.mode != 2);
        localObject1 = paramJSONObject;
      } while (parama.ist == null);
      Object localObject2 = parama.ist;
      if (localObject2 == null)
      {
        ab.e("MicroMsg.AppBrandNetworkUtil", "filterHttpHeaderWhiteList fail");
      }
      else
      {
        localObject1 = new HashMap();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          str1 = (String)((Iterator)localObject2).next();
          if (str1 != null)
          {
            str1 = str1.toLowerCase();
            String str2 = (String)paramJSONObject.get(str1);
            if (str2 != null)
            {
              ab.v("MicroMsg.AppBrandNetworkUtil", "add item, key(%s), value(%s)", new Object[] { str1, str2 });
              ((Map)localObject1).put(str1, str2);
            }
          }
        }
        paramJSONObject = (JSONObject)localObject1;
      }
    }
  }
  
  public static SSLContext a(a parama)
  {
    AppMethodBeat.i(108203);
    parama = b(parama);
    if (parama == null)
    {
      AppMethodBeat.o(108203);
      return null;
    }
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      localSSLContext.init(null, new TrustManager[] { parama }, null);
      AppMethodBeat.o(108203);
      return localSSLContext;
    }
    catch (Exception parama)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", parama, "Exception: SSLContext init error", new Object[0]);
      AppMethodBeat.o(108203);
    }
    return null;
  }
  
  public static void a(HttpURLConnection paramHttpURLConnection, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(108202);
    if (paramHttpURLConnection == null)
    {
      AppMethodBeat.o(108202);
      return;
    }
    HostnameVerifier localHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
    ((HttpsURLConnection)paramHttpURLConnection).setHostnameVerifier(new j.1(localHostnameVerifier, paramArrayList));
    AppMethodBeat.o(108202);
  }
  
  public static boolean a(ArrayList<String> paramArrayList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(108194);
    if (b(paramArrayList, paramString, paramBoolean))
    {
      AppMethodBeat.o(108194);
      return true;
    }
    if (DX((String)DV(paramString).get("host")) == 2)
    {
      ab.e("MicroMsg.AppBrandNetworkUtil", "matchUrl, url in the same net %s", new Object[] { paramString });
      AppMethodBeat.o(108194);
      return true;
    }
    AppMethodBeat.o(108194);
    return false;
  }
  
  private static int aIo()
  {
    AppMethodBeat.i(154596);
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)ah.getContext().getSystemService("connectivity");
      Network[] arrayOfNetwork = localConnectivityManager.getAllNetworks();
      int j = arrayOfNetwork.length;
      int i = 0;
      while (i < j)
      {
        Iterator localIterator = localConnectivityManager.getLinkProperties(arrayOfNetwork[i]).getRoutes().iterator();
        while (localIterator.hasNext())
        {
          RouteInfo localRouteInfo = (RouteInfo)localIterator.next();
          String str = localRouteInfo.getDestination().getAddress().getHostAddress().toUpperCase();
          if (InetAddressUtils.isIPv4Address(str))
          {
            i = localRouteInfo.getDestination().getPrefixLength();
            j = oW(i);
            ab.i("MicroMsg.AppBrandNetworkUtil", "findNetworkMask sAddr:%s,getPrefixLength:%d,netmask:%d", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j) });
            AppMethodBeat.o(154596);
            return j;
          }
        }
        i += 1;
      }
      AppMethodBeat.o(154596);
      return 0;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", localException, "Exception: findNetworkMask error ", new Object[0]);
      AppMethodBeat.o(154596);
    }
    return 0;
  }
  
  public static n b(a parama)
  {
    AppMethodBeat.i(108204);
    Object localObject = new LinkedList();
    Iterator localIterator = parama.isu.iterator();
    while (localIterator.hasNext())
    {
      byte[] arrayOfByte = (byte[])localIterator.next();
      if ((arrayOfByte != null) && (arrayOfByte.length != 0)) {
        ((LinkedList)localObject).add(new ByteArrayInputStream(arrayOfByte));
      }
    }
    if (((LinkedList)localObject).isEmpty())
    {
      if ((parama.isw == 1) || (parama.isw == 2))
      {
        ab.i("MicroMsg.AppBrandNetworkUtil", "getTrustManagerWithSelfSignedCertificates debug type");
        parama = new n(parama.isw);
        parama.init();
        AppMethodBeat.o(108204);
        return parama;
      }
      AppMethodBeat.o(108204);
      return null;
    }
    parama = new n(parama.isw);
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      parama.x((InputStream)((Iterator)localObject).next());
    }
    parama.init();
    AppMethodBeat.o(108204);
    return parama;
  }
  
  public static boolean b(b paramb)
  {
    AppMethodBeat.i(108205);
    switch (j.2.gYx[paramb.ordinal()])
    {
    default: 
      AppMethodBeat.o(108205);
      return false;
    }
    AppMethodBeat.o(108205);
    return true;
  }
  
  public static boolean b(ArrayList<String> paramArrayList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(108195);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, url is null");
      AppMethodBeat.o(108195);
      return false;
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ab.e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, configUrls is empty");
      AppMethodBeat.o(108195);
      return false;
    }
    ab.i("MicroMsg.AppBrandNetworkUtil", "url ".concat(String.valueOf(paramString)));
    ab.i("MicroMsg.AppBrandNetworkUtil", "configUrl size " + paramArrayList.size());
    Object localObject1 = DV(paramString);
    paramString = (String)((HashMap)localObject1).get("host");
    String str1 = (String)((HashMap)localObject1).get("scheme");
    localObject1 = (String)((HashMap)localObject1).get("port");
    if ((bo.isNullOrNil(paramString)) || (bo.isNullOrNil(str1)))
    {
      AppMethodBeat.o(108195);
      return false;
    }
    ab.i("MicroMsg.AppBrandNetworkUtil", "host %s  scheme %s port %s skipPortCheck %s", new Object[] { paramString, str1, localObject1, Boolean.valueOf(paramBoolean) });
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str2 = (String)paramArrayList.next();
      ab.i("MicroMsg.AppBrandNetworkUtil", "configUrl ".concat(String.valueOf(str2)));
      Object localObject2 = DV(str2);
      str2 = (String)((HashMap)localObject2).get("host");
      String str3 = (String)((HashMap)localObject2).get("scheme");
      localObject2 = (String)((HashMap)localObject2).get("port");
      ab.i("MicroMsg.AppBrandNetworkUtil", "confighost %s  configscheme %s configport %s", new Object[] { str2, str3, localObject2 });
      if ((paramString.equalsIgnoreCase(str2)) && (str1.equalsIgnoreCase(str3)) && ((paramBoolean) || (((String)localObject1).equalsIgnoreCase((String)localObject2))))
      {
        ab.i("MicroMsg.AppBrandNetworkUtil", "match!!");
        AppMethodBeat.o(108195);
        return true;
      }
    }
    AppMethodBeat.o(108195);
    return false;
  }
  
  public static boolean c(ArrayList<String> paramArrayList, String paramString)
  {
    AppMethodBeat.i(108193);
    boolean bool = a(paramArrayList, paramString, false);
    AppMethodBeat.o(108193);
    return bool;
  }
  
  public static String d(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(108201);
    if (paramHttpURLConnection == null)
    {
      AppMethodBeat.o(108201);
      return "";
    }
    URL localURL = paramHttpURLConnection.getURL();
    if (localURL == null)
    {
      AppMethodBeat.o(108201);
      return "";
    }
    String str2 = paramHttpURLConnection.getHeaderField("Location");
    String str1 = str2;
    if (str2 == null) {
      str1 = paramHttpURLConnection.getHeaderField("location");
    }
    if (str1 == null)
    {
      AppMethodBeat.o(108201);
      return null;
    }
    try
    {
      paramHttpURLConnection = localURL.toURI().resolve(str1).toString();
      AppMethodBeat.o(108201);
      return paramHttpURLConnection;
    }
    catch (URISyntaxException paramHttpURLConnection)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", paramHttpURLConnection, "URISyntaxException: resolve url error", new Object[0]);
      AppMethodBeat.o(108201);
    }
    return str1;
  }
  
  private static int e(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(108199);
    int m = o.z(new byte[] { -1, -1, -1, 0 });
    long[] arrayOfLong = hC(paramLong);
    int i = 0;
    int j = 0;
    for (;;)
    {
      int k = i;
      if (j < 4)
      {
        i = (int)(i + arrayOfLong[j]);
        if ((arrayOfLong[j] < 0L) || (arrayOfLong[j] > 255L)) {
          k = -1;
        }
      }
      else
      {
        if (k <= 0) {
          paramLong = m;
        }
        ab.i("MicroMsg.AppBrandNetworkUtil", "matchNetMask oldIpInt:%d, localIpInt:%d, netmask:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
        if ((paramInt1 & paramLong) != (paramInt2 & paramLong)) {
          break label181;
        }
        if (paramInt1 != paramInt2) {
          break;
        }
        AppMethodBeat.o(108199);
        return 1;
      }
      j += 1;
    }
    AppMethodBeat.o(108199);
    return 2;
    label181:
    AppMethodBeat.o(108199);
    return 0;
  }
  
  private static JSONArray e(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(108206);
    localJSONArray = new JSONArray();
    if (paramHttpURLConnection == null)
    {
      AppMethodBeat.o(108206);
      return localJSONArray;
    }
    paramHttpURLConnection = paramHttpURLConnection.getHeaderFields();
    if (paramHttpURLConnection == null)
    {
      AppMethodBeat.o(108206);
      return localJSONArray;
    }
    try
    {
      if (paramHttpURLConnection.containsKey("Set-Cookie"))
      {
        List localList = (List)paramHttpURLConnection.get("Set-Cookie");
        if (localList != null)
        {
          boolean bool = localList.isEmpty();
          if (!bool) {}
        }
        else
        {
          AppMethodBeat.o(108206);
          return localJSONArray;
        }
        ab.d("MicroMsg.AppBrandNetworkUtil", "getResponseHeaderCookies Set-Cookie:%s", new Object[] { paramHttpURLConnection.toString() });
        paramHttpURLConnection = localList.iterator();
        while (paramHttpURLConnection.hasNext()) {
          localJSONArray.put((String)paramHttpURLConnection.next());
        }
      }
      return localJSONArray;
    }
    catch (Exception paramHttpURLConnection)
    {
      ab.e("MicroMsg.AppBrandNetworkUtil", "getResponseHeaderCookies error : %s", new Object[] { Log.getStackTraceString(paramHttpURLConnection) });
      AppMethodBeat.o(108206);
    }
  }
  
  public static JSONObject f(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(108207);
    JSONObject localJSONObject = new JSONObject();
    if (paramHttpURLConnection == null)
    {
      AppMethodBeat.o(108207);
      return localJSONObject;
    }
    Object localObject1 = paramHttpURLConnection.getHeaderFields();
    if (localObject1 == null)
    {
      AppMethodBeat.o(108207);
      return localJSONObject;
    }
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (List)((Map.Entry)localObject2).getValue();
      if ((!bo.isNullOrNil(str)) && (localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)((List)localObject2).get(0));
        int i = 1;
        while (i < ((List)localObject2).size())
        {
          localStringBuilder.append(",");
          localStringBuilder.append((String)((List)localObject2).get(i));
          i += 1;
        }
        try
        {
          localJSONObject.put(str, localStringBuilder.toString());
        }
        catch (JSONException localJSONException)
        {
          ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", localJSONException, "JSONException: put header error", new Object[0]);
        }
      }
    }
    paramHttpURLConnection = e(paramHttpURLConnection);
    try
    {
      if (paramHttpURLConnection.length() > 0) {
        localJSONObject.put("cookies", paramHttpURLConnection);
      }
      AppMethodBeat.o(108207);
      return localJSONObject;
    }
    catch (JSONException paramHttpURLConnection)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrandNetworkUtil", "put header error : %s", new Object[] { Log.getStackTraceString(paramHttpURLConnection) });
      }
    }
  }
  
  public static int g(long paramLong, int paramInt)
  {
    if (paramLong <= 0L) {
      paramInt = 8192;
    }
    int i;
    do
    {
      return paramInt;
      i = paramInt;
      if (paramInt <= 0) {
        i = 3;
      }
      i = (int)(paramLong / i);
      if (i > 524288) {
        break;
      }
      paramInt = i;
    } while (i >= 1024);
    if (i < 1024) {
      return 1024;
    }
    return 524288;
  }
  
  public static JSONObject g(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(108209);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("__AppBrandRemoteDebugRequestHeader__", true);
      if (paramHttpURLConnection == null)
      {
        AppMethodBeat.o(108209);
        return localJSONObject;
      }
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", localJSONException1, "JSONException: put header error", new Object[0]);
      }
      paramHttpURLConnection = paramHttpURLConnection.getRequestProperties();
      if (paramHttpURLConnection == null)
      {
        AppMethodBeat.o(108209);
        return localJSONObject;
      }
      paramHttpURLConnection = paramHttpURLConnection.entrySet().iterator();
      while (paramHttpURLConnection.hasNext())
      {
        Object localObject = (Map.Entry)paramHttpURLConnection.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (List)((Map.Entry)localObject).getValue();
        if ((!bo.isNullOrNil(str)) && (localObject != null) && (!((List)localObject).isEmpty()))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)((List)localObject).get(0));
          int i = 1;
          while (i < ((List)localObject).size())
          {
            localStringBuilder.append(",");
            localStringBuilder.append((String)((List)localObject).get(i));
            i += 1;
          }
          try
          {
            localJSONObject.put(str, localStringBuilder.toString());
          }
          catch (JSONException localJSONException2)
          {
            ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", localJSONException2, "JSONException: put header error", new Object[0]);
          }
        }
      }
      AppMethodBeat.o(108209);
    }
    return localJSONObject;
  }
  
  private static long[] hC(long paramLong)
  {
    long[] arrayOfLong = new long[4];
    if (paramLong > 0L)
    {
      arrayOfLong[0] = (paramLong >>> 24);
      arrayOfLong[1] = ((0xFFFFFF & paramLong) >>> 16);
      arrayOfLong[2] = ((0xFFFF & paramLong) >>> 8);
      arrayOfLong[3] = (0xFF & paramLong);
    }
    return arrayOfLong;
  }
  
  public static int hD(long paramLong)
  {
    AppMethodBeat.i(108210);
    int i = g(paramLong, -1);
    AppMethodBeat.o(108210);
    return i;
  }
  
  private static int oV(int paramInt)
  {
    AppMethodBeat.i(108198);
    try
    {
      Object localObject = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
      InterfaceAddress localInterfaceAddress;
      String str;
      boolean bool;
      do
      {
        do
        {
          Iterator localIterator;
          while (!localIterator.hasNext())
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localIterator = ((NetworkInterface)((Iterator)localObject).next()).getInterfaceAddresses().iterator();
          }
          localInterfaceAddress = (InterfaceAddress)localIterator.next();
        } while (localInterfaceAddress.getAddress().isLoopbackAddress());
        str = localInterfaceAddress.getAddress().getHostAddress().toUpperCase();
        bool = InetAddressUtils.isIPv4Address(str);
        ab.i("MicroMsg.AppBrandNetworkUtil", "check ip:%s, isIPv4:%b", new Object[] { str, Boolean.valueOf(bool) });
      } while (!bool);
      if (!DW(str)) {}
      for (int i = 0;; i = o.z(new byte[] { (byte)(bo.getInt(localObject[0], 0) & 0xFF), (byte)(bo.getInt(localObject[1], 0) & 0xFF), (byte)(bo.getInt(localObject[2], 0) & 0xFF), (byte)(bo.getInt(localObject[3], 0) & 0xFF) }))
      {
        long l = oW(localInterfaceAddress.getNetworkPrefixLength());
        ab.i("MicroMsg.AppBrandNetworkUtil", "matchAddress oldIpInt:%d, localIpInt:%d, netmask:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Long.valueOf(l) });
        paramInt = e(l, paramInt, i);
        AppMethodBeat.o(108198);
        return paramInt;
        localObject = str.split("\\.");
      }
      return 0;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", localException, "Exception: matchAddress error", new Object[0]);
      AppMethodBeat.o(108198);
    }
  }
  
  private static int oW(int paramInt)
  {
    AppMethodBeat.i(154597);
    int[] arrayOfInt = new int[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfInt[(3 - i)] = (-1 << 32 - paramInt >> i * 8 & 0xFF);
      i += 1;
    }
    Object localObject = "" + arrayOfInt[0];
    paramInt = 1;
    while (paramInt < 4)
    {
      localObject = (String)localObject + "." + arrayOfInt[paramInt];
      paramInt += 1;
    }
    ab.i("MicroMsg.AppBrandNetworkUtil", "calcMaskByPrefixLength result:%s", new Object[] { localObject });
    localObject = ((String)localObject).split("\\.");
    paramInt = o.z(new byte[] { (byte)(bo.getInt(localObject[0], 0) & 0xFF), (byte)(bo.getInt(localObject[1], 0) & 0xFF), (byte)(bo.getInt(localObject[2], 0) & 0xFF), (byte)(bo.getInt(localObject[3], 0) & 0xFF) });
    AppMethodBeat.o(154597);
    return paramInt;
  }
  
  public static boolean oX(int paramInt)
  {
    return (paramInt == 301) || (paramInt == 302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.j
 * JD-Core Version:    0.7.0.1
 */