package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Debug;
import android.util.Base64;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.b.s;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.protocal.protobuf.eay;
import com.tencent.mm.protocal.protobuf.eaz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class v
{
  private static String deviceID = null;
  public static m kfo = null;
  private static int kfp = 0;
  private static Boolean kfq = null;
  
  public static n OO(String paramString)
  {
    AppMethodBeat.i(147095);
    ae.i("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo extInfo=%s", new Object[] { paramString });
    n localn = new n();
    if (!bu.isNullOrNil(paramString)) {}
    try
    {
      paramString = h.xs(paramString);
      localn.keD = paramString.optBoolean("open_remote", false);
      localn.roomId = paramString.optString("room_id");
      localn.keE = paramString.optString("wxpkg_info");
      localn.keF = paramString.optString("qrcode_id");
      localn.keG = paramString.optInt("remote_network_type", 1);
      localn.cmJ = paramString.optBoolean("disable_url_check", true);
      localn.keH = paramString.optInt("remote_proxy_port", 9976);
      localn.keI = paramString.optInt("remote_support_compress_algo");
      AppMethodBeat.o(147095);
      return localn;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo %s", new Object[] { paramString });
      }
    }
  }
  
  public static p a(a parama, m paramm, String paramString)
  {
    AppMethodBeat.i(147098);
    localeaz = new eaz();
    for (;;)
    {
      try
      {
        parama = parama.toByteArray();
        if ((parama.length <= 256) || (paramm == null) || (!sp(paramm.kek.keI))) {
          continue;
        }
        byte[] arrayOfByte = s.compress(parama);
        localeaz.Gwe = b.cm(arrayOfByte);
        localeaz.HJB = 1;
        ae.v("MicroMsg.RemoteDebugUtil", "use zlib %d/%d", new Object[] { Integer.valueOf(parama.length), Integer.valueOf(arrayOfByte.length) });
      }
      catch (IOException parama)
      {
        ae.e("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend %s", new Object[] { parama });
        continue;
        localeaz.ape = ((int)(System.currentTimeMillis() - paramm.ken));
        continue;
      }
      if (paramm == null)
      {
        Debug.waitForDebugger();
        ae.e("MicroMsg.RemoteDebugUtil", "env = null ");
      }
      localeaz.iqb = paramm.kel.incrementAndGet();
      if (paramm.ken != 0L) {
        continue;
      }
      localeaz.ape = 0;
      paramm.ken = System.currentTimeMillis();
      localeaz.category = paramString;
      ae.d("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend seq %d", new Object[] { Integer.valueOf(localeaz.iqb) });
      parama = new p();
      parama.kdZ = System.currentTimeMillis();
      parama.keT = localeaz.Gwe.zr.length;
      parama.keS = localeaz;
      AppMethodBeat.o(147098);
      return parama;
      localeaz.Gwe = b.cm(parama);
    }
  }
  
  public static eay a(int paramInt, a parama)
  {
    AppMethodBeat.i(147099);
    eay localeay = new eay();
    localeay.EN = paramInt;
    if (bu.isNullOrNil(deviceID))
    {
      Random localRandom = new Random(System.currentTimeMillis());
      deviceID = localRandom.nextInt() + "-" + kfp;
    }
    localeay.uuid = (deviceID + "-" + System.currentTimeMillis());
    localeay.Gwe = h(parama);
    AppMethodBeat.o(147099);
    return localeay;
  }
  
  public static String a(String paramString, d paramd)
  {
    AppMethodBeat.i(147101);
    if (!paramd.Fj())
    {
      AppMethodBeat.o(147101);
      return "";
    }
    paramString = bg.d(paramd, paramString + ".map");
    if (bu.isNullOrNil(paramString))
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
      ae.e("MicroMsg.RemoteDebugUtil", "execGameExternalScript Base64.encode %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(147101);
    }
    return "";
  }
  
  public static boolean a(m paramm, eay parameay, eas parameas, w paramw, q paramq)
  {
    AppMethodBeat.i(147100);
    if (parameay == null)
    {
      ae.w("MicroMsg.RemoteDebugUtil", "handleError dataFormat is null");
      AppMethodBeat.o(147100);
      return false;
    }
    int i = parameay.EN;
    if (parameas == null)
    {
      ae.w("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d resp is null", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(147100);
      return false;
    }
    if (i == 1006)
    {
      if (-50011 != parameas.drN) {
        break label102;
      }
      paramm.fZ(true);
    }
    while (parameas.drN == 0)
    {
      AppMethodBeat.o(147100);
      return true;
      label102:
      boolean bool = paramm.isBusy();
      paramm.fZ(false);
      if (bool) {
        paramq.bfy();
      }
    }
    ae.i("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d, uuid: %s, errorCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), parameay.uuid, Integer.valueOf(parameas.drN), parameas.drO });
    ar.f(new w.8(paramw, i, parameas));
    AppMethodBeat.o(147100);
    return false;
  }
  
  public static boolean bfF()
  {
    AppMethodBeat.i(147102);
    if (kfq != null)
    {
      bool = kfq.booleanValue();
      AppMethodBeat.o(147102);
      return bool;
    }
    SharedPreferences localSharedPreferences = ak.getContext().getSharedPreferences("app_brand_global_sp", 0);
    if (localSharedPreferences == null)
    {
      ae.w("MicroMsg.RemoteDebugUtil", "isHardCodeOpenGamePreload, sp is null.");
      AppMethodBeat.o(147102);
      return true;
    }
    boolean bool = localSharedPreferences.getBoolean("hard_code_open_game_preload", true);
    kfq = Boolean.valueOf(bool);
    AppMethodBeat.o(147102);
    return bool;
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
      ae.w("MicroMsg.RemoteDebugUtil", parama.getMessage());
      parama = ByteBuffer.allocate(0);
      AppMethodBeat.o(147096);
    }
    return parama;
  }
  
  public static void gb(boolean paramBoolean)
  {
    AppMethodBeat.i(147103);
    SharedPreferences localSharedPreferences = ak.getContext().getSharedPreferences("app_brand_global_sp", 0);
    if (localSharedPreferences == null)
    {
      ae.w("MicroMsg.RemoteDebugUtil", "setHardCodeOpenGamePreload, sp is null.");
      AppMethodBeat.o(147103);
      return;
    }
    localSharedPreferences.edit().putBoolean("hard_code_open_game_preload", paramBoolean).commit();
    AppMethodBeat.o(147103);
  }
  
  private static b h(a parama)
  {
    AppMethodBeat.i(147097);
    try
    {
      parama = b.cm(parama.toByteArray());
      AppMethodBeat.o(147097);
      return parama;
    }
    catch (IOException parama)
    {
      ae.w("MicroMsg.RemoteDebugUtil", parama.getMessage());
      parama = b.cm(new byte[0]);
      AppMethodBeat.o(147097);
    }
    return parama;
  }
  
  public static void setUin(int paramInt)
  {
    kfp = paramInt;
  }
  
  public static boolean sp(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.v
 * JD-Core Version:    0.7.0.1
 */