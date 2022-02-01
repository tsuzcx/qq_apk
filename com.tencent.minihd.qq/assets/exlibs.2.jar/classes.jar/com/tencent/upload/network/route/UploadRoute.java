package com.tencent.upload.network.route;

import com.tencent.upload.network.base.IConnection.ProtocolCategory;
import java.io.Serializable;

public final class UploadRoute
  implements Serializable
{
  private static final long serialVersionUID = 100L;
  private String mIp;
  private int mPort;
  private int mProtocol;
  private String mProxyIp;
  private int mProxyPort;
  private int mRouteCategory;
  
  public UploadRoute(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramString, paramInt1, null, 0, paramInt2, paramInt3);
  }
  
  public UploadRoute(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mIp = paramString1;
    this.mPort = paramInt1;
    this.mProxyIp = paramString2;
    this.mProxyPort = paramInt2;
    this.mProtocol = paramInt3;
    this.mRouteCategory = paramInt4;
  }
  
  public void clearProxy()
  {
    this.mProxyIp = null;
    this.mProxyPort = 0;
  }
  
  public UploadRoute clone()
  {
    return new UploadRoute(this.mIp, this.mPort, this.mProxyIp, this.mProxyPort, this.mProtocol, this.mRouteCategory);
  }
  
  public String getIp()
  {
    return this.mIp;
  }
  
  public int getPort()
  {
    return this.mPort;
  }
  
  public int getPorxyPort()
  {
    return this.mProxyPort;
  }
  
  public int getProtocol()
  {
    return this.mProtocol;
  }
  
  public String getProxyIp()
  {
    return this.mProxyIp;
  }
  
  public int getRouteCategory()
  {
    return this.mRouteCategory;
  }
  
  public boolean isDuplicate(UploadRoute paramUploadRoute)
  {
    if (paramUploadRoute == null) {}
    while ((!this.mIp.equals(paramUploadRoute.getIp())) || (this.mPort != paramUploadRoute.getPort())) {
      return false;
    }
    return true;
  }
  
  public void setIp(String paramString)
  {
    this.mIp = paramString;
  }
  
  public void setPort(int paramInt)
  {
    this.mPort = paramInt;
  }
  
  public void setPorxyPort(int paramInt)
  {
    this.mProxyPort = paramInt;
  }
  
  public void setProtocol(int paramInt)
  {
    this.mProtocol = paramInt;
  }
  
  public void setProxy(String paramString, int paramInt)
  {
    this.mProxyIp = paramString;
    this.mProxyPort = paramInt;
  }
  
  public void setProxyIp(String paramString)
  {
    this.mProxyIp = paramString;
  }
  
  public void setRouteCategory(int paramInt)
  {
    this.mRouteCategory = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("(ip:");
    if (this.mIp == null)
    {
      str = "null";
      localStringBuilder = localStringBuilder.append(str).append(", port:").append(this.mPort).append(", pIp:");
      if (this.mProxyIp != null) {
        break label117;
      }
    }
    label117:
    for (String str = "null";; str = this.mProxyIp)
    {
      return str + ", pPort:" + this.mProxyPort + ", " + IConnection.ProtocolCategory.print(this.mProtocol) + ", " + IUploadRouteStrategy.RouteCategory.print(this.mRouteCategory) + ")";
      str = this.mIp;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.upload.network.route.UploadRoute
 * JD-Core Version:    0.7.0.1
 */