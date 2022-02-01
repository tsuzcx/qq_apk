package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Debug;
import android.util.Base64;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.h;
import com.tencent.mm.b.s;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.protocal.protobuf.dnq;
import com.tencent.mm.protocal.protobuf.dnw;
import com.tencent.mm.protocal.protobuf.dnx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class u
{
  private static String deviceID = null;
  public static l jhw = null;
  private static int jhx = 0;
  private static Boolean jhy = null;
  
  public static m GJ(String paramString)
  {
    AppMethodBeat.i(147095);
    ad.i("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo extInfo=%s", new Object[] { paramString });
    m localm = new m();
    if (!bt.isNullOrNil(paramString)) {}
    try
    {
      paramString = h.qE(paramString);
      localm.jgL = paramString.optBoolean("open_remote", false);
      localm.roomId = paramString.optString("room_id");
      localm.jgM = paramString.optString("wxpkg_info");
      localm.jgN = paramString.optString("qrcode_id");
      localm.jgO = paramString.optInt("remote_network_type", 1);
      localm.cft = paramString.optBoolean("disable_url_check", true);
      localm.jgP = paramString.optInt("remote_proxy_port", 9976);
      localm.jgQ = paramString.optInt("remote_support_compress_algo");
      AppMethodBeat.o(147095);
      return localm;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo %s", new Object[] { paramString });
      }
    }
  }
  
  public static o a(a parama, l paraml, String paramString)
  {
    AppMethodBeat.i(147098);
    localdnx = new dnx();
    for (;;)
    {
      try
      {
        parama = parama.toByteArray();
        if ((parama.length <= 256) || (paraml == null) || (!qX(paraml.jgt.jgQ))) {
          continue;
        }
        byte[] arrayOfByte = s.compress(parama);
        localdnx.DcU = b.cd(arrayOfByte);
        localdnx.EiC = 1;
        ad.v("MicroMsg.RemoteDebugUtil", "use zlib %d/%d", new Object[] { Integer.valueOf(parama.length), Integer.valueOf(arrayOfByte.length) });
      }
      catch (IOException parama)
      {
        ad.e("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend %s", new Object[] { parama });
        continue;
        localdnx.amt = ((int)(System.currentTimeMillis() - paraml.jgw));
        continue;
      }
      if (paraml == null)
      {
        Debug.waitForDebugger();
        ad.e("MicroMsg.RemoteDebugUtil", "env = null ");
      }
      localdnx.htk = paraml.jgu.incrementAndGet();
      if (paraml.jgw != 0L) {
        continue;
      }
      localdnx.amt = 0;
      paraml.jgw = System.currentTimeMillis();
      localdnx.category = paramString;
      ad.d("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend seq %d", new Object[] { Integer.valueOf(localdnx.htk) });
      parama = new o();
      parama.jgi = System.currentTimeMillis();
      parama.jhb = localdnx.DcU.wA.length;
      parama.jha = localdnx;
      AppMethodBeat.o(147098);
      return parama;
      localdnx.DcU = b.cd(parama);
    }
  }
  
  public static dnw a(int paramInt, a parama)
  {
    AppMethodBeat.i(147099);
    dnw localdnw = new dnw();
    localdnw.BX = paramInt;
    if (bt.isNullOrNil(deviceID))
    {
      Random localRandom = new Random(System.currentTimeMillis());
      deviceID = localRandom.nextInt() + "-" + jhx;
    }
    localdnw.uuid = (deviceID + "-" + System.currentTimeMillis());
    localdnw.DcU = h(parama);
    AppMethodBeat.o(147099);
    return localdnw;
  }
  
  public static String a(String paramString, c paramc)
  {
    AppMethodBeat.i(147101);
    if (!paramc.Ec())
    {
      AppMethodBeat.o(147101);
      return "";
    }
    paramString = be.d(paramc, paramString + ".map");
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147101);
      return "";
    }
    try
    {
      paramString = String.format("\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,%s", new Object[] { new String(Base64.encode(paramString.getBytes(), 2), "utf-8") });
      AppMethodBeat.o(147101);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      ad.e("MicroMsg.RemoteDebugUtil", "execGameExternalScript Base64.encode %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(147101);
    }
    return "";
  }
  
  public static boolean a(l paraml, dnw paramdnw, dnq paramdnq, v paramv, p paramp)
  {
    AppMethodBeat.i(147100);
    if (paramdnw == null)
    {
      ad.w("MicroMsg.RemoteDebugUtil", "handleError dataFormat is null");
      AppMethodBeat.o(147100);
      return false;
    }
    int i = paramdnw.BX;
    if (paramdnq == null)
    {
      ad.w("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d resp is null", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(147100);
      return false;
    }
    if (i == 1006)
    {
      if (-50011 != paramdnq.dhR) {
        break label102;
      }
      paraml.fz(true);
    }
    while (paramdnq.dhR == 0)
    {
      AppMethodBeat.o(147100);
      return true;
      label102:
      boolean bool = paraml.isBusy();
      paraml.fz(false);
      if (bool) {
        paramp.aUo();
      }
    }
    ad.i("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d, uuid: %s, errorCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), paramdnw.uuid, Integer.valueOf(paramdnq.dhR), paramdnq.dhS });
    aq.f(new v.8(paramv, i, paramdnq));
    AppMethodBeat.o(147100);
    return false;
  }
  
  public static boolean aUv()
  {
    AppMethodBeat.i(147102);
    if (jhy != null)
    {
      bool = jhy.booleanValue();
      AppMethodBeat.o(147102);
      return bool;
    }
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("app_brand_global_sp", 0);
    if (localSharedPreferences == null)
    {
      ad.w("MicroMsg.RemoteDebugUtil", "isHardCodeOpenGamePreload, sp is null.");
      AppMethodBeat.o(147102);
      return true;
    }
    boolean bool = localSharedPreferences.getBoolean("hard_code_open_game_preload", true);
    jhy = Boolean.valueOf(bool);
    AppMethodBeat.o(147102);
    return bool;
  }
  
  public static void fB(boolean paramBoolean)
  {
    AppMethodBeat.i(147103);
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("app_brand_global_sp", 0);
    if (localSharedPreferences == null)
    {
      ad.w("MicroMsg.RemoteDebugUtil", "setHardCodeOpenGamePreload, sp is null.");
      AppMethodBeat.o(147103);
      return;
    }
    localSharedPreferences.edit().putBoolean("hard_code_open_game_preload", paramBoolean).commit();
    AppMethodBeat.o(147103);
  }
  
  public static ByteBuffer g(a parama)
  {
    AppMethodBeat.i(147096);
    try
    {
      parama = ByteBuffer.wrap(parama.toByteArray());
      AppMethodBeat.o(147096);
      return parama;
    }
    catch (IOException parama)
    {
      ad.w("MicroMsg.RemoteDebugUtil", parama.getMessage());
      parama = ByteBuffer.allocate(0);
      AppMethodBeat.o(147096);
    }
    return parama;
  }
  
  private static b h(a parama)
  {
    AppMethodBeat.i(147097);
    try
    {
      parama = b.cd(parama.toByteArray());
      AppMethodBeat.o(147097);
      return parama;
    }
    catch (IOException parama)
    {
      ad.w("MicroMsg.RemoteDebugUtil", parama.getMessage());
      parama = b.cd(new byte[0]);
      AppMethodBeat.o(147097);
    }
    return parama;
  }
  
  public static boolean qX(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static void setUin(int paramInt)
  {
    jhx = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.u
 * JD-Core Version:    0.7.0.1
 */