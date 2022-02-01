package com.tencent.base.os.info;

import android.net.NetworkInfo;

public class NetworkState
{
  private static final int NETWORK_TYPE_1xRTT = 7;
  private static final int NETWORK_TYPE_CDMA = 4;
  private static final int NETWORK_TYPE_EDGE = 2;
  private static final int NETWORK_TYPE_EHRPD = 14;
  private static final int NETWORK_TYPE_EVDO_0 = 5;
  private static final int NETWORK_TYPE_EVDO_A = 6;
  private static final int NETWORK_TYPE_EVDO_B = 12;
  private static final int NETWORK_TYPE_GPRS = 1;
  private static final int NETWORK_TYPE_HSDPA = 8;
  private static final int NETWORK_TYPE_HSPA = 10;
  private static final int NETWORK_TYPE_HSPAP = 15;
  private static final int NETWORK_TYPE_HSUPA = 9;
  private static final int NETWORK_TYPE_IDEN = 11;
  private static final int NETWORK_TYPE_LTE = 13;
  private static final int NETWORK_TYPE_UMTS = 3;
  private static final int NETWORK_TYPE_UNKNOWN = 0;
  private static final NetworkState NONE = new NetworkState(false, null, AccessPoint.NONE, NetworkType.NONE);
  private AccessPoint accessPoint = AccessPoint.NONE;
  private String apnName = null;
  private boolean connected = false;
  private NetworkInfo moreInfo;
  private NetworkType type = NetworkType.NONE;
  
  private NetworkState() {}
  
  private NetworkState(boolean paramBoolean, String paramString, AccessPoint paramAccessPoint, NetworkType paramNetworkType)
  {
    setConnected(paramBoolean);
    setApnName(paramString);
    setAccessPoint(paramAccessPoint);
    setType(paramNetworkType);
  }
  
  public static NetworkState fromNetworkInfo(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {
      return NONE;
    }
    NetworkState localNetworkState = new NetworkState();
    localNetworkState.setConnected(paramNetworkInfo.isConnected());
    localNetworkState.setApnName(paramNetworkInfo.getExtraInfo());
    localNetworkState.setAccessPoint(AccessPoint.forName(localNetworkState.getApnName()));
    switch (paramNetworkInfo.getType())
    {
    default: 
      localNetworkState.setType(NetworkType.OTHERS);
    case 1: 
      for (;;)
      {
        localNetworkState.setMoreInfo(paramNetworkInfo);
        return localNetworkState;
        localNetworkState.setType(NetworkType.WIFI);
      }
    }
    if (is3GMobileType(paramNetworkInfo.getSubtype())) {}
    for (NetworkType localNetworkType = NetworkType.MOBILE_3G;; localNetworkType = NetworkType.MOBILE_2G)
    {
      localNetworkState.setType(localNetworkType);
      break;
    }
  }
  
  private static boolean is3GMobileType(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
    default: 
      return false;
    }
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof NetworkState)) {
      return (((NetworkState)paramObject).isConnected() == isConnected()) && (((NetworkState)paramObject).getType().equals(getType())) && (((NetworkState)paramObject).getApnName().equals(getApnName()));
    }
    return false;
  }
  
  public AccessPoint getAccessPoint()
  {
    return this.accessPoint;
  }
  
  public String getApnName()
  {
    if (this.apnName == null) {
      return "";
    }
    return this.apnName;
  }
  
  public NetworkInfo getMoreInfo()
  {
    return this.moreInfo;
  }
  
  public NetworkType getType()
  {
    return this.type;
  }
  
  public boolean isAvailable()
  {
    return this.connected;
  }
  
  public boolean isConnected()
  {
    return this.connected;
  }
  
  public void setAccessPoint(AccessPoint paramAccessPoint)
  {
    this.accessPoint = paramAccessPoint;
  }
  
  public void setApnName(String paramString)
  {
    this.apnName = paramString;
  }
  
  public void setConnected(boolean paramBoolean)
  {
    this.connected = paramBoolean;
  }
  
  public void setMoreInfo(NetworkInfo paramNetworkInfo)
  {
    this.moreInfo = paramNetworkInfo;
  }
  
  public void setType(NetworkType paramNetworkType)
  {
    this.type = paramNetworkType;
  }
  
  public String toString()
  {
    return "NetworkState [connected=" + this.connected + ", apnName=" + this.apnName + ", type=" + this.type + ", accessPoint=" + this.accessPoint + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.base.os.info.NetworkState
 * JD-Core Version:    0.7.0.1
 */