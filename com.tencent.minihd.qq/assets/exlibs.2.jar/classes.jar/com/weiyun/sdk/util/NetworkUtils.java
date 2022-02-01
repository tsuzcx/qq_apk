package com.weiyun.sdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.weiyun.sdk.log.Log;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.ByteOrder;
import java.util.Enumeration;

public class NetworkUtils
{
  public static final int CN_2G = 1;
  public static final int CN_3G = 2;
  public static final int CN_ALL = -1;
  public static final int CN_NONE = 0;
  public static final int CN_PCNET = 4;
  public static final int CN_WIFI = 3;
  private static final int NETWORK_TYPE_EHRPD = 14;
  private static final int NETWORK_TYPE_EVDO_B = 12;
  private static final int NETWORK_TYPE_HSPAP = 15;
  private static final int NETWORK_TYPE_LTE = 13;
  private static final String TAG = "NetworkUtils";
  private static Context mContext = null;
  private static volatile String sLocalIp = null;
  
  public static long getHostOrderIp(int paramInt)
  {
    if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN)
    {
      long l = Long.parseLong(Integer.toHexString(paramInt), 16);
      return l << 24 | (0xFF00 & l) << 8 | (0xFF0000 & l) >> 8 | l >> 24;
    }
    return Long.parseLong(Integer.toHexString(paramInt), 16);
  }
  
  public static String getLocalIpAddress(Context paramContext)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    Object localObject3;
    try
    {
      localObject3 = getWifiConfigAddress(paramContext);
      localObject1 = localObject2;
      if ((isWifiEnable(paramContext)) && (localObject3 != null))
      {
        localObject1 = localObject2;
        if (!((String)localObject3).equals("")) {
          return localObject3;
        }
      }
      localObject1 = localObject2;
      Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
      localObject1 = localObject2;
      localObject3 = localObject2;
      if (localEnumeration1.hasMoreElements())
      {
        localObject1 = localObject2;
        Enumeration localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
        localObject3 = localObject2;
        boolean bool;
        do
        {
          do
          {
            do
            {
              localObject2 = localObject3;
              localObject1 = localObject3;
              if (!localEnumeration2.hasMoreElements()) {
                break;
              }
              localObject1 = localObject3;
              localObject2 = (InetAddress)localEnumeration2.nextElement();
              localObject1 = localObject3;
            } while (((InetAddress)localObject2).isLoopbackAddress());
            localObject1 = localObject3;
          } while (!(localObject2 instanceof Inet4Address));
          localObject1 = localObject3;
          localObject2 = ((InetAddress)localObject2).getHostAddress();
          localObject1 = localObject2;
          if (!isWifiApEnabled(paramContext)) {
            break label165;
          }
          localObject1 = localObject2;
          bool = ((String)localObject2).startsWith("192.168");
          localObject3 = localObject2;
        } while (!bool);
        label165:
        return localObject2;
      }
    }
    catch (Exception paramContext)
    {
      Log.e("NetworkUtils", "Fail to get IpAddress:" + paramContext.toString());
      localObject3 = localObject1;
    }
    return localObject3;
  }
  
  public static int getNetWorkType(Context paramContext)
  {
    return getNetWorkTypeImpl(getNetworkInfo(paramContext));
  }
  
  private static int getNetWorkTypeImpl(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {
      Log.i("NetworkUtils", "net info is null");
    }
    int i;
    do
    {
      return 0;
      if (!paramNetworkInfo.isAvailable())
      {
        Log.i("NetworkUtils", "net is unavailable. net.type:" + paramNetworkInfo.getType() + " net.subtype:" + paramNetworkInfo.getSubtype() + " net.typename:" + paramNetworkInfo.getTypeName());
        return 0;
      }
      i = paramNetworkInfo.getType();
      int j = paramNetworkInfo.getSubtype();
      if (i == 1) {
        return 3;
      }
      if ((i == 0) || (i == 4) || (i == 5) || (i == 2) || (i == 3))
      {
        switch (j)
        {
        case 0: 
        default: 
          return 0;
        case 1: 
          return 1;
        case 7: 
          return 1;
        case 4: 
          return 1;
        case 2: 
          return 1;
        case 5: 
          return 2;
        case 6: 
          return 2;
        case 8: 
          return 2;
        case 10: 
          return 2;
        case 9: 
          return 2;
        case 3: 
          return 2;
        case 11: 
          return 1;
        case 12: 
          return 2;
        case 13: 
          return 2;
        case 14: 
          return 2;
        }
        return 2;
      }
    } while ((i != 6) && (i != 9));
    return 3;
  }
  
  public static NetworkInfo getNetworkInfo(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {}
    try
    {
      localContext = mContext;
      paramContext = ((ConnectivityManager)localContext.getSystemService("connectivity")).getActiveNetworkInfo();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.w("NetworkUtils", paramContext);
    }
    return null;
  }
  
  public static int getPacketSize(Context paramContext)
  {
    int i = getNetWorkType(paramContext);
    if (i == 2) {
      return 32768;
    }
    if (i == 1) {
      return 16384;
    }
    if (i == 3) {
      return 65536;
    }
    return -1;
  }
  
  public static String getWifiBSSID(Context paramContext)
  {
    paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    if ((paramContext != null) && (paramContext.getBSSID() != null)) {
      return paramContext.getBSSID().toLowerCase().replaceAll(":", "-");
    }
    return null;
  }
  
  public static String getWifiConfigAddress(Context paramContext)
  {
    if (sLocalIp != null) {
      return sLocalIp;
    }
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    WifiInfo localWifiInfo = paramContext.getConnectionInfo();
    if (localWifiInfo != null)
    {
      int j = localWifiInfo.getIpAddress();
      int i = j;
      if (j == 0) {
        i = paramContext.getDhcpInfo().ipAddress;
      }
      sLocalIp = longToIP(getHostOrderIp(i));
      return sLocalIp;
    }
    return "";
  }
  
  public static String getWifiMacAddress(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = mContext;
    }
    paramContext = ((WifiManager)localContext.getSystemService("wifi")).getConnectionInfo();
    if (paramContext == null)
    {
      Log.w("NetworkUtils", "can *NOT* get connect info when get mac address!");
      return null;
    }
    paramContext = paramContext.getMacAddress();
    if (paramContext == null)
    {
      Log.w("NetworkUtils", "mac address is null!");
      return null;
    }
    return paramContext.toLowerCase().replaceAll(":", "-");
  }
  
  public static String getWifiName(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = mContext;
    }
    paramContext = ((WifiManager)localContext.getSystemService("wifi")).getConnectionInfo();
    if ((paramContext != null) && (paramContext.getSSID() != null)) {
      return paramContext.getSSID();
    }
    return null;
  }
  
  public static int getWifiSignalStrength(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = mContext;
    }
    return ((WifiManager)localContext.getSystemService("wifi")).getConnectionInfo().getRssi();
  }
  
  public static boolean hasInternet(Context paramContext)
  {
    paramContext = getNetworkInfo(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static boolean isBigEndian()
  {
    return ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
  }
  
  public static boolean isCnwapConnection(Context paramContext)
  {
    paramContext = getNetworkInfo(paramContext);
    if (paramContext == null) {}
    do
    {
      return false;
      paramContext = paramContext.getExtraInfo();
    } while ((paramContext == null) || (!paramContext.toLowerCase().contains("wap")));
    return true;
  }
  
  public static boolean isLittleEndian()
  {
    return ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
  }
  
  public static boolean isMobileNetwork(Context paramContext)
  {
    return (hasInternet(paramContext)) && (!isWIFI(paramContext));
  }
  
  public static boolean isWIFI(Context paramContext)
  {
    return getNetWorkType(paramContext) == 3;
  }
  
  public static boolean isWifiApEnabled(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      Method localMethod = paramContext.getClass().getDeclaredMethod("isWifiApEnabled", new Class[0]);
      boolean bool1 = bool2;
      if (localMethod != null)
      {
        paramContext = localMethod.invoke(paramContext, new Object[0]);
        bool1 = bool2;
        if (paramContext != null) {
          bool1 = Boolean.parseBoolean(paramContext.toString());
        }
      }
      return bool1;
    }
    catch (Exception paramContext)
    {
      Log.w("NetworkUtils", paramContext);
    }
    return false;
  }
  
  public static boolean isWifiEnable(Context paramContext)
  {
    return ((WifiManager)paramContext.getSystemService("wifi")).isWifiEnabled();
  }
  
  public static String longToIP(long paramLong)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.insert(0, paramLong & 0xFF).insert(0, '.');
    paramLong >>>= 8;
    localStringBuilder2 = localStringBuilder2.insert(0, paramLong & 0xFF).insert(0, '.');
    paramLong >>>= 8;
    localStringBuilder2.insert(0, paramLong & 0xFF).insert(0, '.').insert(0, paramLong >>> 8 & 0xFF);
    return localStringBuilder1.toString();
  }
  
  public static void setContext(Context paramContext)
  {
    mContext = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.util.NetworkUtils
 * JD-Core Version:    0.7.0.1
 */