package com.tencent.mm.plugin.cast.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/utils/CastHelper;", "", "()V", "getPhoneIp", "", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b wOk;
  
  static
  {
    AppMethodBeat.i(274206);
    wOk = new b();
    AppMethodBeat.o(274206);
  }
  
  public static final String dpG()
  {
    AppMethodBeat.i(274198);
    try
    {
      Object localObject1 = NetworkInterface.getNetworkInterfaces();
      s.s(localObject1, "getNetworkInterfaces()");
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
          s.s(localObject2, "en.nextElement()");
          localObject2 = ((NetworkInterface)localObject2).getInetAddresses();
          s.s(localObject2, "intf.inetAddresses");
        }
        localObject3 = ((Enumeration)localObject2).nextElement();
        s.s(localObject3, "enumIpAddr.nextElement()");
        localObject3 = (InetAddress)localObject3;
      } while ((((InetAddress)localObject3).isLoopbackAddress()) || (!(localObject3 instanceof Inet4Address)));
      localObject1 = ((InetAddress)localObject3).getHostAddress().toString();
      AppMethodBeat.o(274198);
      return localObject1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(274198);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.h.b
 * JD-Core Version:    0.7.0.1
 */