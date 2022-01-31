package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Debug;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.r;
import com.tencent.mm.aa.h;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.protocal.protobuf.ctp;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.protocal.protobuf.ctw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class t
{
  private static String deviceID = null;
  public static l hmt = null;
  private static int hmu = 0;
  private static Boolean hmv = null;
  
  public static m AS(String paramString)
  {
    AppMethodBeat.i(101907);
    ab.i("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo extInfo=%s", new Object[] { paramString });
    m localm = new m();
    if (!bo.isNullOrNil(paramString)) {}
    try
    {
      paramString = h.mo(paramString);
      localm.hlH = paramString.optBoolean("open_remote", false);
      localm.eeu = paramString.optString("room_id");
      localm.hlI = paramString.optString("wxpkg_info");
      localm.hlJ = paramString.optString("qrcode_id");
      localm.hlK = paramString.optInt("remote_network_type", 1);
      localm.bDm = paramString.optBoolean("disable_url_check", true);
      localm.hlL = paramString.optInt("remote_proxy_port", 9976);
      localm.hlM = paramString.optInt("remote_support_compress_algo");
      AppMethodBeat.o(101907);
      return localm;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo %s", new Object[] { paramString });
      }
    }
  }
  
  public static o a(a parama, l paraml, String paramString)
  {
    AppMethodBeat.i(101910);
    ctw localctw = new ctw();
    try
    {
      parama = parama.toByteArray();
      if ((parama.length > 256) && (nD(paraml.hlp.hlM)))
      {
        byte[] arrayOfByte = r.compress(parama);
        localctw.wPX = com.tencent.mm.bv.b.bL(arrayOfByte);
        localctw.xKQ = 1;
        ab.v("MicroMsg.RemoteDebugUtil", "use zlib %d/%d", new Object[] { Integer.valueOf(parama.length), Integer.valueOf(arrayOfByte.length) });
      }
      for (;;)
      {
        if (paraml == null)
        {
          Debug.waitForDebugger();
          ab.e("MicroMsg.RemoteDebugUtil", "env = null ");
        }
        localctw.fQD = paraml.hlq.incrementAndGet();
        if (paraml.hls != 0L) {
          break;
        }
        localctw.afm = 0;
        paraml.hls = System.currentTimeMillis();
        localctw.category = paramString;
        ab.d("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend seq %d", new Object[] { Integer.valueOf(localctw.fQD) });
        parama = new o();
        parama.hlb = System.currentTimeMillis();
        parama.hlW = localctw.wPX.pW.length;
        parama.hlV = localctw;
        AppMethodBeat.o(101910);
        return parama;
        localctw.wPX = com.tencent.mm.bv.b.bL(parama);
      }
    }
    catch (IOException parama)
    {
      for (;;)
      {
        ab.e("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend %s", new Object[] { parama });
        continue;
        localctw.afm = ((int)(System.currentTimeMillis() - paraml.hls));
      }
    }
  }
  
  public static ctv a(int paramInt, a parama)
  {
    AppMethodBeat.i(101911);
    ctv localctv = new ctv();
    localctv.vA = paramInt;
    if (bo.isNullOrNil(deviceID))
    {
      Random localRandom = new Random(System.currentTimeMillis());
      deviceID = localRandom.nextInt() + "-" + hmu;
    }
    localctv.eAx = (deviceID + "-" + System.currentTimeMillis());
    localctv.wPX = d(parama);
    AppMethodBeat.o(101911);
    return localctv;
  }
  
  public static String a(String paramString, com.tencent.luggage.sdk.d.b paramb)
  {
    AppMethodBeat.i(101913);
    if (!paramb.wV())
    {
      AppMethodBeat.o(101913);
      return "";
    }
    paramString = ax.c(paramb, paramString + ".map");
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(101913);
      return "";
    }
    try
    {
      paramString = String.format("\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,%s", new Object[] { new String(Base64.encode(paramString.getBytes(), 2), "utf-8") });
      AppMethodBeat.o(101913);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      ab.e("MicroMsg.RemoteDebugUtil", "execGameExternalScript Base64.encode %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(101913);
    }
    return "";
  }
  
  public static boolean a(l paraml, ctv paramctv, ctp paramctp, u paramu, p paramp)
  {
    AppMethodBeat.i(101912);
    if (paramctv == null)
    {
      ab.w("MicroMsg.RemoteDebugUtil", "handleError dataFormat is null");
      AppMethodBeat.o(101912);
      return false;
    }
    int i = paramctv.vA;
    if (paramctp == null)
    {
      ab.w("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d resp is null", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(101912);
      return false;
    }
    if (i == 1006)
    {
      if (-50011 != paramctp.csV) {
        break label102;
      }
      paraml.dR(true);
    }
    while (paramctp.csV == 0)
    {
      AppMethodBeat.o(101912);
      return true;
      label102:
      boolean bool = paraml.isBusy();
      paraml.dR(false);
      if (bool) {
        paramp.azh();
      }
    }
    ab.i("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d, uuid: %s, errorCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), paramctv.eAx, Integer.valueOf(paramctp.csV), paramctp.csW });
    al.d(new u.8(paramu, i, paramctp));
    AppMethodBeat.o(101912);
    return false;
  }
  
  public static boolean azo()
  {
    AppMethodBeat.i(101914);
    if (hmv != null)
    {
      bool = hmv.booleanValue();
      AppMethodBeat.o(101914);
      return bool;
    }
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("app_brand_global_sp", 0);
    if (localSharedPreferences == null)
    {
      ab.w("MicroMsg.RemoteDebugUtil", "isHardCodeOpenGamePreload, sp is null.");
      AppMethodBeat.o(101914);
      return true;
    }
    boolean bool = localSharedPreferences.getBoolean("hard_code_open_game_preload", true);
    hmv = Boolean.valueOf(bool);
    AppMethodBeat.o(101914);
    return bool;
  }
  
  public static ByteBuffer c(a parama)
  {
    AppMethodBeat.i(101908);
    try
    {
      parama = ByteBuffer.wrap(parama.toByteArray());
      AppMethodBeat.o(101908);
      return parama;
    }
    catch (IOException parama)
    {
      ab.w("MicroMsg.RemoteDebugUtil", parama.getMessage());
      parama = ByteBuffer.allocate(0);
      AppMethodBeat.o(101908);
    }
    return parama;
  }
  
  private static com.tencent.mm.bv.b d(a parama)
  {
    AppMethodBeat.i(101909);
    try
    {
      parama = com.tencent.mm.bv.b.bL(parama.toByteArray());
      AppMethodBeat.o(101909);
      return parama;
    }
    catch (IOException parama)
    {
      ab.w("MicroMsg.RemoteDebugUtil", parama.getMessage());
      parama = com.tencent.mm.bv.b.bL(new byte[0]);
      AppMethodBeat.o(101909);
    }
    return parama;
  }
  
  public static void dT(boolean paramBoolean)
  {
    AppMethodBeat.i(101915);
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("app_brand_global_sp", 0);
    if (localSharedPreferences == null)
    {
      ab.w("MicroMsg.RemoteDebugUtil", "setHardCodeOpenGamePreload, sp is null.");
      AppMethodBeat.o(101915);
      return;
    }
    localSharedPreferences.edit().putBoolean("hard_code_open_game_preload", paramBoolean).commit();
    AppMethodBeat.o(101915);
  }
  
  public static boolean nD(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static void setUin(int paramInt)
  {
    hmu = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.t
 * JD-Core Version:    0.7.0.1
 */