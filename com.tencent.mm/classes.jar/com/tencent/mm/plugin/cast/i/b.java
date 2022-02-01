package com.tencent.mm.plugin.cast.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/utils/CastHelper;", "", "()V", "getPhoneIp", "", "plugin-cast_release"})
public final class b
{
  public static final b tKV;
  
  static
  {
    AppMethodBeat.i(190448);
    tKV = new b();
    AppMethodBeat.o(190448);
  }
  
  public static final String cMc()
  {
    AppMethodBeat.i(190444);
    try
    {
      Object localObject1 = NetworkInterface.getNetworkInterfaces();
      p.j(localObject1, "NetworkInterface.getNetworkInterfaces()");
      Object localObject3;
      do
      {
        Object localObject2;
        while (!((Enumeration)localObject2).hasMoreElements())
        {
          if (!((Enumeration)localObject1).hasMoreElements()) {
            break;
          }
          localObject2 = ((Enumeration)localObject1).nextElement();
          p.j(localObject2, "en.nextElement()");
          localObject2 = ((NetworkInterface)localObject2).getInetAddresses();
          p.j(localObject2, "intf.inetAddresses");
        }
        localObject3 = ((Enumeration)localObject2).nextElement();
        p.j(localObject3, "enumIpAddr.nextElement()");
        localObject3 = (InetAddress)localObject3;
      } while ((((InetAddress)localObject3).isLoopbackAddress()) || (!(localObject3 instanceof Inet4Address)));
      localObject1 = ((InetAddress)localObject3).getHostAddress().toString();
      AppMethodBeat.o(190444);
      return localObject1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(190444);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.i.b
 * JD-Core Version:    0.7.0.1
 */