package com.tencent.mm.plugin.appbrand.m;

import android.annotation.TargetApi;
import android.net.nsd.NsdServiceInfo;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class p$c
{
  public String ip;
  public Map<String, String> itF;
  public String itG;
  public String itH;
  public int port;
  
  public p$c()
  {
    AppMethodBeat.i(108271);
    this.itF = new HashMap();
    AppMethodBeat.o(108271);
  }
  
  @TargetApi(21)
  p$c(NsdServiceInfo paramNsdServiceInfo)
  {
    AppMethodBeat.i(108270);
    this.itF = new HashMap();
    Object localObject = paramNsdServiceInfo.getHost();
    if (localObject != null) {
      this.ip = ((InetAddress)localObject).getHostAddress();
    }
    this.port = paramNsdServiceInfo.getPort();
    this.itG = paramNsdServiceInfo.getServiceName();
    this.itH = paramNsdServiceInfo.getServiceType();
    if (Build.VERSION.SDK_INT >= 21) {}
    for (paramNsdServiceInfo = paramNsdServiceInfo.getAttributes();; paramNsdServiceInfo = null)
    {
      if (paramNsdServiceInfo != null)
      {
        localObject = paramNsdServiceInfo.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          byte[] arrayOfByte = (byte[])paramNsdServiceInfo.get(str);
          if (arrayOfByte != null) {
            this.itF.put(str, new String(Base64.encode(arrayOfByte, 2)));
          }
        }
      }
      AppMethodBeat.o(108270);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.p.c
 * JD-Core Version:    0.7.0.1
 */