package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Debug;
import android.util.Base64;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.b.s;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.protocal.protobuf.dth;
import com.tencent.mm.protocal.protobuf.dtn;
import com.tencent.mm.protocal.protobuf.dto;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class u
{
  private static String deviceID = null;
  public static l jHL = null;
  private static int jHM = 0;
  private static Boolean jHN = null;
  
  public static m KN(String paramString)
  {
    AppMethodBeat.i(147095);
    ac.i("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo extInfo=%s", new Object[] { paramString });
    m localm = new m();
    if (!bs.isNullOrNil(paramString)) {}
    try
    {
      paramString = h.tT(paramString);
      localm.jHa = paramString.optBoolean("open_remote", false);
      localm.roomId = paramString.optString("room_id");
      localm.jHb = paramString.optString("wxpkg_info");
      localm.jHc = paramString.optString("qrcode_id");
      localm.jHd = paramString.optInt("remote_network_type", 1);
      localm.ccq = paramString.optBoolean("disable_url_check", true);
      localm.jHe = paramString.optInt("remote_proxy_port", 9976);
      localm.jHf = paramString.optInt("remote_support_compress_algo");
      AppMethodBeat.o(147095);
      return localm;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.e("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo %s", new Object[] { paramString });
      }
    }
  }
  
  public static o a(a parama, l paraml, String paramString)
  {
    AppMethodBeat.i(147098);
    localdto = new dto();
    for (;;)
    {
      try
      {
        parama = parama.toByteArray();
        if ((parama.length <= 256) || (paraml == null) || (!rK(paraml.jGI.jHf))) {
          continue;
        }
        byte[] arrayOfByte = s.compress(parama);
        localdto.Ewb = b.cc(arrayOfByte);
        localdto.FFA = 1;
        ac.v("MicroMsg.RemoteDebugUtil", "use zlib %d/%d", new Object[] { Integer.valueOf(parama.length), Integer.valueOf(arrayOfByte.length) });
      }
      catch (IOException parama)
      {
        ac.e("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend %s", new Object[] { parama });
        continue;
        localdto.ann = ((int)(System.currentTimeMillis() - paraml.jGL));
        continue;
      }
      if (paraml == null)
      {
        Debug.waitForDebugger();
        ac.e("MicroMsg.RemoteDebugUtil", "env = null ");
      }
      localdto.hTM = paraml.jGJ.incrementAndGet();
      if (paraml.jGL != 0L) {
        continue;
      }
      localdto.ann = 0;
      paraml.jGL = System.currentTimeMillis();
      localdto.category = paramString;
      ac.d("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend seq %d", new Object[] { Integer.valueOf(localdto.hTM) });
      parama = new o();
      parama.jGx = System.currentTimeMillis();
      parama.jHq = localdto.Ewb.xy.length;
      parama.jHp = localdto;
      AppMethodBeat.o(147098);
      return parama;
      localdto.Ewb = b.cc(parama);
    }
  }
  
  public static dtn a(int paramInt, a parama)
  {
    AppMethodBeat.i(147099);
    dtn localdtn = new dtn();
    localdtn.CW = paramInt;
    if (bs.isNullOrNil(deviceID))
    {
      Random localRandom = new Random(System.currentTimeMillis());
      deviceID = localRandom.nextInt() + "-" + jHM;
    }
    localdtn.uuid = (deviceID + "-" + System.currentTimeMillis());
    localdtn.Ewb = h(parama);
    AppMethodBeat.o(147099);
    return localdtn;
  }
  
  public static String a(String paramString, c paramc)
  {
    AppMethodBeat.i(147101);
    if (!paramc.DF())
    {
      AppMethodBeat.o(147101);
      return "";
    }
    paramString = be.d(paramc, paramString + ".map");
    if (bs.isNullOrNil(paramString))
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
      ac.e("MicroMsg.RemoteDebugUtil", "execGameExternalScript Base64.encode %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(147101);
    }
    return "";
  }
  
  public static boolean a(l paraml, dtn paramdtn, dth paramdth, v paramv, p paramp)
  {
    AppMethodBeat.i(147100);
    if (paramdtn == null)
    {
      ac.w("MicroMsg.RemoteDebugUtil", "handleError dataFormat is null");
      AppMethodBeat.o(147100);
      return false;
    }
    int i = paramdtn.CW;
    if (paramdth == null)
    {
      ac.w("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d resp is null", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(147100);
      return false;
    }
    if (i == 1006)
    {
      if (-50011 != paramdth.dfm) {
        break label102;
      }
      paraml.fV(true);
    }
    while (paramdth.dfm == 0)
    {
      AppMethodBeat.o(147100);
      return true;
      label102:
      boolean bool = paraml.isBusy();
      paraml.fV(false);
      if (bool) {
        paramp.bbm();
      }
    }
    ac.i("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d, uuid: %s, errorCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), paramdtn.uuid, Integer.valueOf(paramdth.dfm), paramdth.dfn });
    ap.f(new v.8(paramv, i, paramdth));
    AppMethodBeat.o(147100);
    return false;
  }
  
  public static boolean bbt()
  {
    AppMethodBeat.i(147102);
    if (jHN != null)
    {
      bool = jHN.booleanValue();
      AppMethodBeat.o(147102);
      return bool;
    }
    SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("app_brand_global_sp", 0);
    if (localSharedPreferences == null)
    {
      ac.w("MicroMsg.RemoteDebugUtil", "isHardCodeOpenGamePreload, sp is null.");
      AppMethodBeat.o(147102);
      return true;
    }
    boolean bool = localSharedPreferences.getBoolean("hard_code_open_game_preload", true);
    jHN = Boolean.valueOf(bool);
    AppMethodBeat.o(147102);
    return bool;
  }
  
  public static void fX(boolean paramBoolean)
  {
    AppMethodBeat.i(147103);
    SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("app_brand_global_sp", 0);
    if (localSharedPreferences == null)
    {
      ac.w("MicroMsg.RemoteDebugUtil", "setHardCodeOpenGamePreload, sp is null.");
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
      ac.w("MicroMsg.RemoteDebugUtil", parama.getMessage());
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
      parama = b.cc(parama.toByteArray());
      AppMethodBeat.o(147097);
      return parama;
    }
    catch (IOException parama)
    {
      ac.w("MicroMsg.RemoteDebugUtil", parama.getMessage());
      parama = b.cc(new byte[0]);
      AppMethodBeat.o(147097);
    }
    return parama;
  }
  
  public static boolean rK(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static void setUin(int paramInt)
  {
    jHM = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.u
 * JD-Core Version:    0.7.0.1
 */