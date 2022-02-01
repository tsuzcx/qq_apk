package com.tencent.mm.plugin.appbrand.q;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.IpPrefix;
import android.net.LinkProperties;
import android.net.Network;
import android.net.RouteInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mars.cdn.CronetLogic.WebPageProfile;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.o;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.util.InetAddressUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public enum j
{
  public static boolean F(c paramc)
  {
    AppMethodBeat.i(144388);
    switch (j.2.iRi[paramc.aLA().ordinal()])
    {
    default: 
      AppMethodBeat.o(144388);
      return false;
    }
    AppMethodBeat.o(144388);
    return true;
  }
  
  public static HashMap<String, String> Le(String paramString)
  {
    AppMethodBeat.i(144368);
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
        ad.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", paramString, "Exception: parseUrl error", new Object[0]);
        paramString = str2;
      }
    }
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("host", str1);
    ((HashMap)localObject2).put("scheme", localObject1);
    ((HashMap)localObject2).put("port", paramString);
    AppMethodBeat.o(144368);
    return localObject2;
  }
  
  private static boolean Lf(String paramString)
  {
    AppMethodBeat.i(144374);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, url is null");
      AppMethodBeat.o(144374);
      return false;
    }
    paramString = paramString.split("\\.");
    if (paramString.length != 4)
    {
      ad.e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, invalid ip format");
      AppMethodBeat.o(144374);
      return false;
    }
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      int k = bt.getInt(paramString[i], -1);
      if ((k < 0) || (k > 255))
      {
        ad.e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, invalid ip format");
        AppMethodBeat.o(144374);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(144374);
    return true;
  }
  
  public static int Lg(String paramString)
  {
    AppMethodBeat.i(144375);
    if (!Lf(paramString))
    {
      ad.e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, url is null");
      AppMethodBeat.o(144375);
      return 0;
    }
    Object localObject = paramString.split("\\.");
    int k = o.G(new byte[] { (byte)(bt.getInt(localObject[0], 0) & 0xFF), (byte)(bt.getInt(localObject[1], 0) & 0xFF), (byte)(bt.getInt(localObject[2], 0) & 0xFF), (byte)(bt.getInt(localObject[3], 0) & 0xFF) });
    WifiManager localWifiManager = (WifiManager)aj.getContext().getApplicationContext().getSystemService("wifi");
    int i;
    int j;
    if (localWifiManager.getWifiState() == 3)
    {
      int m = localWifiManager.getConnectionInfo().getIpAddress();
      localObject = (m & 0xFF) + "." + (m >> 8 & 0xFF) + "." + (m >> 16 & 0xFF) + "." + (m >> 24 & 0xFF);
      try
      {
        i = localWifiManager.getDhcpInfo().netmask;
        j = i;
        if (i <= 0)
        {
          if (Build.VERSION.SDK_INT >= 21) {
            j = bit();
          }
        }
        else
        {
          ad.i("MicroMsg.AppBrandNetworkUtil", "matchIp oldIpStr:%s, localIp:%s,oldIpInt:%d, localIpInt:%d, netmask:%d", new Object[] { paramString, localObject, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
          i = e(j, k, m);
          AppMethodBeat.o(144375);
          return i;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", localNullPointerException, "NullPointerException: getDhcpInfo error", new Object[0]);
          i = 0;
          continue;
          ad.e("MicroMsg.AppBrandNetworkUtil", "invalid netmask");
          j = i;
        }
      }
    }
    for (;;)
    {
      try
      {
        i = ((Integer)localNullPointerException.getClass().getField("WIFI_AP_STATE_ENABLED").get(localNullPointerException)).intValue();
        ad.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", paramString, "Exception: getWifiApState error", new Object[0]);
      }
      catch (Exception paramString)
      {
        try
        {
          j = ((Integer)localNullPointerException.getClass().getMethod("getWifiApState", new Class[0]).invoke(localNullPointerException, new Object[0])).intValue();
          if (j != i) {
            break;
          }
          ad.i("MicroMsg.AppBrandNetworkUtil", "matchip in apmode");
          i = tk(k);
          AppMethodBeat.o(144375);
          return i;
        }
        catch (Exception paramString)
        {
          break label410;
        }
        paramString = paramString;
        i = 13;
      }
      label410:
      j = 0;
    }
    ad.i("MicroMsg.AppBrandNetworkUtil", "apState:%d", new Object[] { Integer.valueOf(j) });
    AppMethodBeat.o(144375);
    return 0;
  }
  
  public static String Lh(String paramString)
  {
    return paramString;
  }
  
  public static Map<String, List<String>> N(Map<String, String> paramMap)
  {
    AppMethodBeat.i(144391);
    localHashMap = new HashMap();
    try
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        String str1 = (String)paramMap.getKey();
        if ((str1 != null) && (!str1.isEmpty()))
        {
          String str2 = (String)paramMap.getValue();
          List localList = (List)localHashMap.get(str1);
          paramMap = localList;
          if (localList == null) {
            paramMap = new ArrayList();
          }
          paramMap.add(str2);
          localHashMap.put(str1, paramMap);
        }
      }
      return localHashMap;
    }
    catch (Exception paramMap)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", paramMap, "JSONException: put header error", new Object[0]);
      AppMethodBeat.o(144391);
    }
  }
  
  private static Map<String, String> X(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(144369);
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
      ad.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", paramJSONObject, "Exception: get header error", new Object[0]);
      AppMethodBeat.o(144369);
    }
  }
  
  public static Map<String, String> Y(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(144370);
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
      ad.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", paramJSONObject, "Exception: get form error", new Object[0]);
      AppMethodBeat.o(144370);
    }
  }
  
  public static String Z(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(144393);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(144393);
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
    if (!bt.gL(localLinkedList))
    {
      paramJSONObject = TextUtils.join(", ", localLinkedList);
      AppMethodBeat.o(144393);
      return paramJSONObject;
    }
    AppMethodBeat.o(144393);
    return null;
  }
  
  public static int a(a parama, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return parama.kUp;
    case 1: 
      return parama.kUq;
    case 3: 
      return parama.kUs;
    }
    return parama.kUr;
  }
  
  public static String a(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(144381);
    if (paramHttpURLConnection == null)
    {
      AppMethodBeat.o(144381);
      return "";
    }
    URL localURL = paramHttpURLConnection.getURL();
    if (localURL == null)
    {
      AppMethodBeat.o(144381);
      return "";
    }
    String str2 = paramHttpURLConnection.getHeaderField("Location");
    String str1 = str2;
    if (str2 == null) {
      str1 = paramHttpURLConnection.getHeaderField("location");
    }
    if (str1 == null)
    {
      AppMethodBeat.o(144381);
      return null;
    }
    try
    {
      paramHttpURLConnection = localURL.toURI().resolve(str1).toString();
      AppMethodBeat.o(144381);
      return paramHttpURLConnection;
    }
    catch (URISyntaxException paramHttpURLConnection)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", paramHttpURLConnection, "URISyntaxException: resolve url error", new Object[0]);
      AppMethodBeat.o(144381);
    }
    return str1;
  }
  
  public static String a(URI paramURI)
  {
    AppMethodBeat.i(144394);
    Object localObject2 = paramURI.getScheme();
    if (bt.isNullOrNil((String)localObject2))
    {
      AppMethodBeat.o(144394);
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
      AppMethodBeat.o(144394);
      return paramURI;
      localObject1 = localObject2;
      if (!((String)localObject2).equalsIgnoreCase("ws")) {
        break;
      }
      localObject1 = "http";
      break;
    }
  }
  
  public static Map<String, Object> a(CronetLogic.WebPageProfile paramWebPageProfile)
  {
    try
    {
      AppMethodBeat.i(175394);
      HashMap localHashMap = new HashMap();
      if (paramWebPageProfile != null)
      {
        localHashMap.put("redirectStart", Long.valueOf(paramWebPageProfile.redirectStart));
        localHashMap.put("redirectEnd", Long.valueOf(paramWebPageProfile.redirectEnd));
        localHashMap.put("fetchStart", Long.valueOf(paramWebPageProfile.fetchStart));
        localHashMap.put("domainLookUpStart", Long.valueOf(paramWebPageProfile.domainLookUpStart));
        localHashMap.put("domainLookUpEnd", Long.valueOf(paramWebPageProfile.domainLookUpEnd));
        localHashMap.put("connectStart", Long.valueOf(paramWebPageProfile.connectStart));
        localHashMap.put("connectEnd", Long.valueOf(paramWebPageProfile.connectEnd));
        localHashMap.put("SSLconnectionStart", Long.valueOf(paramWebPageProfile.SSLconnectionStart));
        localHashMap.put("SSLconnectionEnd", Long.valueOf(paramWebPageProfile.SSLconnectionEnd));
        localHashMap.put("requestStart", Long.valueOf(paramWebPageProfile.requestStart));
        localHashMap.put("requestEnd", Long.valueOf(paramWebPageProfile.requestEnd));
        localHashMap.put("responseStart", Long.valueOf(paramWebPageProfile.responseStart));
        localHashMap.put("responseEnd", Long.valueOf(paramWebPageProfile.responseEnd));
        localHashMap.put("rtt", Integer.valueOf(paramWebPageProfile.rtt));
        localHashMap.put("estimate_nettype", Integer.valueOf(paramWebPageProfile.networkTypeEstimate));
        localHashMap.put("httpRttEstimate", Integer.valueOf(paramWebPageProfile.httpRttEstimate));
        localHashMap.put("transportRttEstimate", Integer.valueOf(paramWebPageProfile.transportRttEstimate));
        localHashMap.put("downstreamThroughputKbpsEstimate", Integer.valueOf(paramWebPageProfile.downstreamThroughputKbpsEstimate));
        localHashMap.put("throughputKbps", Integer.valueOf(paramWebPageProfile.throughputKbps));
        localHashMap.put("peerIP", paramWebPageProfile.peerIP);
        localHashMap.put("port", Integer.valueOf(paramWebPageProfile.port));
        localHashMap.put("protocol", paramWebPageProfile.protocol);
        localHashMap.put("socketReused", Boolean.valueOf(paramWebPageProfile.socketReused));
        localHashMap.put("sendBytesCount", Long.valueOf(paramWebPageProfile.sendBytesCount));
        localHashMap.put("receivedBytedCount", Long.valueOf(paramWebPageProfile.receivedBytedCount));
      }
      AppMethodBeat.o(175394);
      return localHashMap;
    }
    finally {}
  }
  
  public static Map<String, String> a(JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(144380);
    paramJSONObject = X(paramJSONObject);
    if (parama == null)
    {
      ad.e("MicroMsg.AppBrandNetworkUtil", "hy: no network config!");
      AppMethodBeat.o(144380);
      return paramJSONObject;
    }
    Object localObject1;
    if (parama.mode == 1)
    {
      localObject1 = paramJSONObject;
      if (parama.kUu != null)
      {
        localObject1 = parama.kUu;
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())) {
          break label115;
        }
        ad.e("MicroMsg.AppBrandNetworkUtil", "filterHttpHeaderBlackList fail, headerMap is null or blacklist is null or nil.");
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
                ad.v("MicroMsg.AppBrandNetworkUtil", "remove key %s value %s", new Object[] { localObject2, str1 });
              }
            }
          }
          break label72;
          localObject1 = paramJSONObject;
        } while (parama.mode != 2);
        localObject1 = paramJSONObject;
      } while (parama.kUv == null);
      Object localObject2 = parama.kUv;
      if (localObject2 == null)
      {
        ad.e("MicroMsg.AppBrandNetworkUtil", "filterHttpHeaderWhiteList fail");
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
              ad.v("MicroMsg.AppBrandNetworkUtil", "add item, key(%s), value(%s)", new Object[] { str1, str2 });
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
    AppMethodBeat.i(144383);
    parama = b(parama);
    if (parama == null)
    {
      AppMethodBeat.o(144383);
      return null;
    }
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      localSSLContext.init(null, new TrustManager[] { parama }, null);
      AppMethodBeat.o(144383);
      return localSSLContext;
    }
    catch (Exception parama)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", parama, "Exception: SSLContext init error", new Object[0]);
      AppMethodBeat.o(144383);
    }
    return null;
  }
  
  public static void a(HttpURLConnection paramHttpURLConnection, final ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(144382);
    if (paramHttpURLConnection == null)
    {
      AppMethodBeat.o(144382);
      return;
    }
    HostnameVerifier localHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
    ((HttpsURLConnection)paramHttpURLConnection).setHostnameVerifier(new HostnameVerifier()
    {
      public final boolean verify(String paramAnonymousString, SSLSession paramAnonymousSSLSession)
      {
        AppMethodBeat.i(144364);
        if ((this.kVx.verify(paramAnonymousString, paramAnonymousSSLSession)) || (j.d(paramArrayList, paramAnonymousString)))
        {
          AppMethodBeat.o(144364);
          return true;
        }
        AppMethodBeat.o(144364);
        return false;
      }
    });
    AppMethodBeat.o(144382);
  }
  
  public static boolean a(ArrayList<String> paramArrayList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(144372);
    if (b(paramArrayList, paramString, paramBoolean))
    {
      AppMethodBeat.o(144372);
      return true;
    }
    if (Lg((String)Le(paramString).get("host")) == 2)
    {
      ad.e("MicroMsg.AppBrandNetworkUtil", "matchUrl, url in the same net %s", new Object[] { paramString });
      AppMethodBeat.o(144372);
      return true;
    }
    AppMethodBeat.o(144372);
    return false;
  }
  
  public static n b(a parama)
  {
    AppMethodBeat.i(144384);
    Object localObject = new LinkedList();
    Iterator localIterator = parama.kUw.iterator();
    while (localIterator.hasNext())
    {
      byte[] arrayOfByte = (byte[])localIterator.next();
      if ((arrayOfByte != null) && (arrayOfByte.length != 0)) {
        ((LinkedList)localObject).add(new ByteArrayInputStream(arrayOfByte));
      }
    }
    if (((LinkedList)localObject).isEmpty())
    {
      if (parama.kUz)
      {
        ad.i("MicroMsg.AppBrandNetworkUtil", "getTrustManagerWithSelfSignedCertificates debug type");
        parama = new n(true);
        parama.init();
        AppMethodBeat.o(144384);
        return parama;
      }
      AppMethodBeat.o(144384);
      return null;
    }
    parama = new n(parama.kUz);
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      parama.E((InputStream)((Iterator)localObject).next());
    }
    parama.init();
    AppMethodBeat.o(144384);
    return parama;
  }
  
  public static JSONObject b(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(144387);
    if (paramHttpURLConnection == null)
    {
      paramHttpURLConnection = c(null, 2);
      AppMethodBeat.o(144387);
      return paramHttpURLConnection;
    }
    paramHttpURLConnection = c(paramHttpURLConnection.getHeaderFields(), 2);
    AppMethodBeat.o(144387);
    return paramHttpURLConnection;
  }
  
  public static boolean b(b paramb)
  {
    AppMethodBeat.i(144385);
    switch (j.2.iRi[paramb.ordinal()])
    {
    default: 
      AppMethodBeat.o(144385);
      return false;
    }
    AppMethodBeat.o(144385);
    return true;
  }
  
  public static boolean b(ArrayList<String> paramArrayList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(144373);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, url is null");
      AppMethodBeat.o(144373);
      return false;
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ad.e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, configUrls is empty");
      AppMethodBeat.o(144373);
      return false;
    }
    ad.i("MicroMsg.AppBrandNetworkUtil", "url ".concat(String.valueOf(paramString)));
    ad.i("MicroMsg.AppBrandNetworkUtil", "configUrl size " + paramArrayList.size());
    Object localObject1 = Le(paramString);
    paramString = (String)((HashMap)localObject1).get("host");
    String str1 = (String)((HashMap)localObject1).get("scheme");
    localObject1 = (String)((HashMap)localObject1).get("port");
    if ((bt.isNullOrNil(paramString)) || (bt.isNullOrNil(str1)))
    {
      AppMethodBeat.o(144373);
      return false;
    }
    ad.i("MicroMsg.AppBrandNetworkUtil", "host %s  scheme %s port %s skipPortCheck %s", new Object[] { paramString, str1, localObject1, Boolean.valueOf(paramBoolean) });
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str2 = (String)paramArrayList.next();
      ad.i("MicroMsg.AppBrandNetworkUtil", "configUrl ".concat(String.valueOf(str2)));
      Object localObject2 = Le(str2);
      str2 = (String)((HashMap)localObject2).get("host");
      String str3 = (String)((HashMap)localObject2).get("scheme");
      localObject2 = (String)((HashMap)localObject2).get("port");
      ad.i("MicroMsg.AppBrandNetworkUtil", "confighost %s  configscheme %s configport %s", new Object[] { str2, str3, localObject2 });
      if ((paramString.equalsIgnoreCase(str2)) && (str1.equalsIgnoreCase(str3)) && ((paramBoolean) || (((String)localObject1).equalsIgnoreCase((String)localObject2))))
      {
        ad.i("MicroMsg.AppBrandNetworkUtil", "match!!");
        AppMethodBeat.o(144373);
        return true;
      }
    }
    AppMethodBeat.o(144373);
    return false;
  }
  
  private static int bit()
  {
    AppMethodBeat.i(144376);
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)aj.getContext().getSystemService("connectivity");
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
            j = tl(i);
            ad.i("MicroMsg.AppBrandNetworkUtil", "findNetworkMask sAddr:%s,getPrefixLength:%d,netmask:%d", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j) });
            AppMethodBeat.o(144376);
            return j;
          }
        }
        i += 1;
      }
      AppMethodBeat.o(144376);
      return 0;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", localException, "Exception: findNetworkMask error ", new Object[0]);
      AppMethodBeat.o(144376);
    }
    return 0;
  }
  
  public static JSONObject c(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(144389);
    if (paramHttpURLConnection == null)
    {
      paramHttpURLConnection = c(null, 1);
      AppMethodBeat.o(144389);
      return paramHttpURLConnection;
    }
    paramHttpURLConnection = c(paramHttpURLConnection.getRequestProperties(), 1);
    AppMethodBeat.o(144389);
    return paramHttpURLConnection;
  }
  
  public static JSONObject c(Map<String, List<String>> paramMap, int paramInt)
  {
    AppMethodBeat.i(144390);
    JSONObject localJSONObject = new JSONObject();
    if (paramInt == 1) {}
    try
    {
      localJSONObject.put("__AppBrandRemoteDebugRequestHeader__", true);
      if (paramMap == null)
      {
        AppMethodBeat.o(144390);
        return localJSONObject;
      }
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", localJSONException1, "JSONException: getHeaderJsonObject put REQUEST_HEADER header error", new Object[0]);
      }
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (List)((Map.Entry)localObject).getValue();
        if ((!bt.isNullOrNil(str)) && (localObject != null) && (!((List)localObject).isEmpty()))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)((List)localObject).get(0));
          paramInt = 1;
          while (paramInt < ((List)localObject).size())
          {
            localStringBuilder.append(",");
            localStringBuilder.append((String)((List)localObject).get(paramInt));
            paramInt += 1;
          }
          try
          {
            localJSONObject.put(str, localStringBuilder.toString());
          }
          catch (JSONException localJSONException2)
          {
            ad.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", localJSONException2, "JSONException: getHeaderJsonObject put header error", new Object[0]);
          }
        }
      }
      AppMethodBeat.o(144390);
    }
    return localJSONObject;
  }
  
  public static boolean c(ArrayList<String> paramArrayList, String paramString)
  {
    AppMethodBeat.i(144371);
    boolean bool = a(paramArrayList, paramString, false);
    AppMethodBeat.o(144371);
    return bool;
  }
  
  private static int e(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144379);
    int m = o.G(new byte[] { -1, -1, -1, 0 });
    long[] arrayOfLong = nj(paramLong);
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
        ad.i("MicroMsg.AppBrandNetworkUtil", "matchNetMask oldIpInt:%d, localIpInt:%d, netmask:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
        if ((paramInt1 & paramLong) != (paramInt2 & paramLong)) {
          break label181;
        }
        if (paramInt1 != paramInt2) {
          break;
        }
        AppMethodBeat.o(144379);
        return 1;
      }
      j += 1;
    }
    AppMethodBeat.o(144379);
    return 2;
    label181:
    AppMethodBeat.o(144379);
    return 0;
  }
  
  public static int h(long paramLong, int paramInt)
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
  
  public static boolean na(int paramInt)
  {
    return (paramInt == 301) || (paramInt == 302);
  }
  
  private static long[] nj(long paramLong)
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
  
  public static int nk(long paramLong)
  {
    AppMethodBeat.i(144392);
    int i = h(paramLong, -1);
    AppMethodBeat.o(144392);
    return i;
  }
  
  private static int tk(int paramInt)
  {
    AppMethodBeat.i(144377);
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
        ad.i("MicroMsg.AppBrandNetworkUtil", "check ip:%s, isIPv4:%b", new Object[] { str, Boolean.valueOf(bool) });
      } while (!bool);
      if (!Lf(str)) {}
      for (int i = 0;; i = o.G(new byte[] { (byte)(bt.getInt(localObject[0], 0) & 0xFF), (byte)(bt.getInt(localObject[1], 0) & 0xFF), (byte)(bt.getInt(localObject[2], 0) & 0xFF), (byte)(bt.getInt(localObject[3], 0) & 0xFF) }))
      {
        long l = tl(localInterfaceAddress.getNetworkPrefixLength());
        ad.i("MicroMsg.AppBrandNetworkUtil", "matchAddress oldIpInt:%d, localIpInt:%d, netmask:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Long.valueOf(l) });
        paramInt = e(l, paramInt, i);
        AppMethodBeat.o(144377);
        return paramInt;
        localObject = str.split("\\.");
      }
      return 0;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", localException, "Exception: matchAddress error", new Object[0]);
      AppMethodBeat.o(144377);
    }
  }
  
  private static int tl(int paramInt)
  {
    AppMethodBeat.i(144378);
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
    ad.i("MicroMsg.AppBrandNetworkUtil", "calcMaskByPrefixLength result:%s", new Object[] { localObject });
    localObject = ((String)localObject).split("\\.");
    paramInt = o.G(new byte[] { (byte)(bt.getInt(localObject[0], 0) & 0xFF), (byte)(bt.getInt(localObject[1], 0) & 0xFF), (byte)(bt.getInt(localObject[2], 0) & 0xFF), (byte)(bt.getInt(localObject[3], 0) & 0xFF) });
    AppMethodBeat.o(144378);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.j
 * JD-Core Version:    0.7.0.1
 */