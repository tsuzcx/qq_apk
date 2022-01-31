package com.tencent.mm.plugin.appbrand.o;

import android.net.nsd.NsdServiceInfo;
import java.net.InetAddress;

public final class o$c
{
  public String gRN;
  public String gRO;
  public String ip;
  public int port;
  
  public o$c() {}
  
  o$c(NsdServiceInfo paramNsdServiceInfo)
  {
    InetAddress localInetAddress = paramNsdServiceInfo.getHost();
    if (localInetAddress != null) {
      this.ip = localInetAddress.getHostAddress();
    }
    this.port = paramNsdServiceInfo.getPort();
    this.gRN = paramNsdServiceInfo.getServiceName();
    this.gRO = paramNsdServiceInfo.getServiceType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.o.c
 * JD-Core Version:    0.7.0.1
 */