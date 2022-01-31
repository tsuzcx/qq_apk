package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.mm.ab.h;
import com.tencent.mm.bv.a;
import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.protocal.c.cge;
import com.tencent.mm.protocal.c.cgk;
import com.tencent.mm.protocal.c.cgl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class r
{
  private static String deviceID = null;
  public static j fST = null;
  private static Boolean fSU = null;
  
  public static m a(a parama, j paramj, String paramString)
  {
    cgl localcgl = new cgl();
    try
    {
      parama = parama.toByteArray();
      if ((parama.length > 256) && (kF(paramj.fRO.fSl)))
      {
        byte[] arrayOfByte = com.tencent.mm.a.q.l(parama);
        localcgl.sRj = b.bk(arrayOfByte);
        localcgl.tGT = 1;
        y.v("MicroMsg.RemoteDebugUtil", "use zlib %d/%d", new Object[] { Integer.valueOf(parama.length), Integer.valueOf(arrayOfByte.length) });
      }
      for (;;)
      {
        localcgl.eAK = paramj.fRP.incrementAndGet();
        if (paramj.fRR != 0L) {
          break;
        }
        localcgl.tVt = 0;
        paramj.fRR = System.currentTimeMillis();
        localcgl.category = paramString;
        y.d("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend seq %d", new Object[] { Integer.valueOf(localcgl.eAK) });
        parama = new m();
        parama.fRE = System.currentTimeMillis();
        parama.fSv = localcgl.sRj.oY.length;
        parama.fSu = localcgl;
        return parama;
        localcgl.sRj = b.bk(parama);
      }
    }
    catch (IOException parama)
    {
      for (;;)
      {
        y.e("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend %s", new Object[] { parama });
        continue;
        localcgl.tVt = ((int)(System.currentTimeMillis() - paramj.fRR));
      }
    }
  }
  
  public static cgk a(int paramInt, a parama)
  {
    cgk localcgk = new cgk();
    localcgk.uC = paramInt;
    if (bk.bl(deviceID)) {
      deviceID = com.tencent.mm.compatible.e.q.getDeviceID(ae.getContext());
    }
    localcgk.dCX = (deviceID + "-" + System.currentTimeMillis());
    localcgk.sRj = d(parama);
    return localcgk;
  }
  
  public static String a(String paramString, com.tencent.mm.plugin.appbrand.n paramn)
  {
    if (!paramn.aah()) {
      return "";
    }
    paramString = aq.a(paramn, paramString + ".map");
    if (bk.bl(paramString)) {
      return "";
    }
    try
    {
      paramString = String.format("\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,%s", new Object[] { new String(Base64.encode(paramString.getBytes(), 2), "utf-8") });
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      y.e("MicroMsg.RemoteDebugUtil", "execGameExternalScript Base64.encode %s", new Object[] { paramString.getMessage() });
    }
    return "";
  }
  
  public static boolean a(j paramj, cgk paramcgk, cge paramcge, s params, n paramn)
  {
    if (paramcgk == null)
    {
      y.w("MicroMsg.RemoteDebugUtil", "handleError dataFormat is null");
      return false;
    }
    int i = paramcgk.uC;
    if (paramcge == null)
    {
      y.w("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d resp is null", new Object[] { Integer.valueOf(i) });
      return false;
    }
    if (i == 1006)
    {
      if (-50011 != paramcge.bLB) {
        break label75;
      }
      paramj.cN(true);
    }
    while (paramcge.bLB == 0)
    {
      return true;
      label75:
      boolean bool = paramj.isBusy();
      paramj.cN(false);
      if (bool) {
        paramn.aeH();
      }
    }
    y.i("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d, uuid: %s, errorCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), paramcgk.dCX, Integer.valueOf(paramcge.bLB), paramcge.bLC });
    ai.d(new s.8(params, i, paramcge));
    return false;
  }
  
  public static boolean aeN()
  {
    if (fSU != null) {
      return fSU.booleanValue();
    }
    SharedPreferences localSharedPreferences = ae.getContext().getSharedPreferences("app_brand_global_sp", 0);
    if (localSharedPreferences == null)
    {
      y.w("MicroMsg.RemoteDebugUtil", "isHardCodeOpenGamePreload, sp is null.");
      return true;
    }
    boolean bool = localSharedPreferences.getBoolean("hard_code_open_game_preload", true);
    fSU = Boolean.valueOf(bool);
    return bool;
  }
  
  public static ByteBuffer c(a parama)
  {
    try
    {
      parama = ByteBuffer.wrap(parama.toByteArray());
      return parama;
    }
    catch (IOException parama)
    {
      y.w("MicroMsg.RemoteDebugUtil", parama.getMessage());
    }
    return ByteBuffer.allocate(0);
  }
  
  public static void cP(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = ae.getContext().getSharedPreferences("app_brand_global_sp", 0);
    if (localSharedPreferences == null)
    {
      y.w("MicroMsg.RemoteDebugUtil", "setHardCodeOpenGamePreload, sp is null.");
      return;
    }
    localSharedPreferences.edit().putBoolean("hard_code_open_game_preload", paramBoolean).commit();
  }
  
  private static b d(a parama)
  {
    try
    {
      parama = b.bk(parama.toByteArray());
      return parama;
    }
    catch (IOException parama)
    {
      y.w("MicroMsg.RemoteDebugUtil", parama.getMessage());
    }
    return b.bk(new byte[0]);
  }
  
  public static boolean kF(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static k sR(String paramString)
  {
    y.i("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo extInfo=%s", new Object[] { paramString });
    k localk = new k();
    if (!bk.bl(paramString)) {}
    try
    {
      paramString = h.fU(paramString);
      localk.fSg = paramString.optBoolean("open_remote", false);
      localk.dmT = paramString.optString("room_id");
      localk.fSh = paramString.optString("wxpkg_info");
      localk.fSi = paramString.optString("qrcode_id");
      localk.fSj = paramString.optInt("remote_network_type", 1);
      localk.fPV = paramString.optBoolean("disable_url_check", true);
      localk.fSk = paramString.optInt("remote_proxy_port", 9976);
      localk.fSl = paramString.optInt("remote_support_compress_algo");
      return localk;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo %s", new Object[] { paramString });
    }
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.r
 * JD-Core Version:    0.7.0.1
 */