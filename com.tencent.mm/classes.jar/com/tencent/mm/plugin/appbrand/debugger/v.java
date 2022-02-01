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
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.protocal.protobuf.dzb;
import com.tencent.mm.protocal.protobuf.dzh;
import com.tencent.mm.protocal.protobuf.dzi;
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

public final class v
{
  private static String deviceID = null;
  public static m kbX = null;
  private static int kbY = 0;
  private static Boolean kbZ = null;
  
  public static n Oh(String paramString)
  {
    AppMethodBeat.i(147095);
    ad.i("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo extInfo=%s", new Object[] { paramString });
    n localn = new n();
    if (!bt.isNullOrNil(paramString)) {}
    try
    {
      paramString = h.wJ(paramString);
      localn.kbm = paramString.optBoolean("open_remote", false);
      localn.roomId = paramString.optString("room_id");
      localn.kbn = paramString.optString("wxpkg_info");
      localn.kbo = paramString.optString("qrcode_id");
      localn.kbp = paramString.optInt("remote_network_type", 1);
      localn.cmH = paramString.optBoolean("disable_url_check", true);
      localn.kbq = paramString.optInt("remote_proxy_port", 9976);
      localn.kbr = paramString.optInt("remote_support_compress_algo");
      AppMethodBeat.o(147095);
      return localn;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo %s", new Object[] { paramString });
      }
    }
  }
  
  public static p a(a parama, m paramm, String paramString)
  {
    AppMethodBeat.i(147098);
    localdzi = new dzi();
    for (;;)
    {
      try
      {
        parama = parama.toByteArray();
        if ((parama.length <= 256) || (paramm == null) || (!sm(paramm.kaU.kbr))) {
          continue;
        }
        byte[] arrayOfByte = s.compress(parama);
        localdzi.Gdx = b.cj(arrayOfByte);
        localdzi.HpZ = 1;
        ad.v("MicroMsg.RemoteDebugUtil", "use zlib %d/%d", new Object[] { Integer.valueOf(parama.length), Integer.valueOf(arrayOfByte.length) });
      }
      catch (IOException parama)
      {
        ad.e("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend %s", new Object[] { parama });
        continue;
        localdzi.ape = ((int)(System.currentTimeMillis() - paramm.kaX));
        continue;
      }
      if (paramm == null)
      {
        Debug.waitForDebugger();
        ad.e("MicroMsg.RemoteDebugUtil", "env = null ");
      }
      localdzi.inh = paramm.kaV.incrementAndGet();
      if (paramm.kaX != 0L) {
        continue;
      }
      localdzi.ape = 0;
      paramm.kaX = System.currentTimeMillis();
      localdzi.category = paramString;
      ad.d("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend seq %d", new Object[] { Integer.valueOf(localdzi.inh) });
      parama = new p();
      parama.kaJ = System.currentTimeMillis();
      parama.kbC = localdzi.Gdx.zr.length;
      parama.kbB = localdzi;
      AppMethodBeat.o(147098);
      return parama;
      localdzi.Gdx = b.cj(parama);
    }
  }
  
  public static dzh a(int paramInt, a parama)
  {
    AppMethodBeat.i(147099);
    dzh localdzh = new dzh();
    localdzh.EN = paramInt;
    if (bt.isNullOrNil(deviceID))
    {
      Random localRandom = new Random(System.currentTimeMillis());
      deviceID = localRandom.nextInt() + "-" + kbY;
    }
    localdzh.uuid = (deviceID + "-" + System.currentTimeMillis());
    localdzh.Gdx = h(parama);
    AppMethodBeat.o(147099);
    return localdzh;
  }
  
  public static String a(String paramString, c paramc)
  {
    AppMethodBeat.i(147101);
    if (!paramc.Fe())
    {
      AppMethodBeat.o(147101);
      return "";
    }
    paramString = bf.d(paramc, paramString + ".map");
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
  
  public static boolean a(m paramm, dzh paramdzh, dzb paramdzb, w paramw, q paramq)
  {
    AppMethodBeat.i(147100);
    if (paramdzh == null)
    {
      ad.w("MicroMsg.RemoteDebugUtil", "handleError dataFormat is null");
      AppMethodBeat.o(147100);
      return false;
    }
    int i = paramdzh.EN;
    if (paramdzb == null)
    {
      ad.w("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d resp is null", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(147100);
      return false;
    }
    if (i == 1006)
    {
      if (-50011 != paramdzb.dqI) {
        break label102;
      }
      paramm.ga(true);
    }
    while (paramdzb.dqI == 0)
    {
      AppMethodBeat.o(147100);
      return true;
      label102:
      boolean bool = paramm.isBusy();
      paramm.ga(false);
      if (bool) {
        paramq.beQ();
      }
    }
    ad.i("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d, uuid: %s, errorCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), paramdzh.uuid, Integer.valueOf(paramdzb.dqI), paramdzb.dqJ });
    aq.f(new w.8(paramw, i, paramdzb));
    AppMethodBeat.o(147100);
    return false;
  }
  
  public static boolean beX()
  {
    AppMethodBeat.i(147102);
    if (kbZ != null)
    {
      bool = kbZ.booleanValue();
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
    kbZ = Boolean.valueOf(bool);
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
      ad.w("MicroMsg.RemoteDebugUtil", parama.getMessage());
      parama = ByteBuffer.allocate(0);
      AppMethodBeat.o(147096);
    }
    return parama;
  }
  
  public static void gc(boolean paramBoolean)
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
  
  private static b h(a parama)
  {
    AppMethodBeat.i(147097);
    try
    {
      parama = b.cj(parama.toByteArray());
      AppMethodBeat.o(147097);
      return parama;
    }
    catch (IOException parama)
    {
      ad.w("MicroMsg.RemoteDebugUtil", parama.getMessage());
      parama = b.cj(new byte[0]);
      AppMethodBeat.o(147097);
    }
    return parama;
  }
  
  public static void setUin(int paramInt)
  {
    kbY = paramInt;
  }
  
  public static boolean sm(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.v
 * JD-Core Version:    0.7.0.1
 */