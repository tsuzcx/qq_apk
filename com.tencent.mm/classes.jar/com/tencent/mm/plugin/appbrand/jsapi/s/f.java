package com.tencent.mm.plugin.appbrand.jsapi.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends c
{
  public static final int CTRL_INDEX = 1056;
  public static final String NAME = "getIPAddress";
  
  public static String cnl()
  {
    AppMethodBeat.i(327274);
    Object localObject1 = null;
    label91:
    for (;;)
    {
      try
      {
        Enumeration localEnumeration = NetworkInterface.getNetworkInterfaces();
        localObject1 = null;
        Object localObject2;
        InetAddress localInetAddress;
        Log.printErrStackTrace("MicroMsg.JsApiGetIPAddress", localSocketException1, "lm:get host ip failed", new Object[0]);
      }
      catch (SocketException localSocketException1)
      {
        try
        {
          if (localEnumeration.hasMoreElements())
          {
            localObject2 = ((NetworkInterface)localEnumeration.nextElement()).getInetAddresses();
            if (!((Enumeration)localObject2).hasMoreElements()) {
              continue;
            }
            localInetAddress = (InetAddress)((Enumeration)localObject2).nextElement();
            if (((localInetAddress instanceof Inet6Address)) || ("127.0.0.1".equals(localInetAddress.getHostAddress()))) {
              continue;
            }
            localObject2 = localInetAddress.getHostAddress();
            localObject1 = localObject2;
            continue;
          }
          AppMethodBeat.o(327274);
          return localObject1;
        }
        catch (SocketException localSocketException2)
        {
          break label91;
        }
        localSocketException1 = localSocketException1;
      }
    }
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(327277);
    h.ahAA.bo(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(327264);
        long l = Util.currentTicks();
        String str = f.cnl();
        l = Util.ticksToNow(l);
        Log.i("MicroMsg.JsApiGetIPAddress", "localip:%s,cost:%d", new Object[] { str, Long.valueOf(l) });
        HashMap localHashMap = new HashMap();
        localHashMap.put("localip", str);
        localHashMap.put("cost", Long.valueOf(l));
        paramf.callback(paramInt, f.this.m("ok", localHashMap));
        AppMethodBeat.o(327264);
      }
    });
    AppMethodBeat.o(327277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.f
 * JD-Core Version:    0.7.0.1
 */