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
import com.tencent.mm.protocal.protobuf.euz;
import com.tencent.mm.protocal.protobuf.evf;
import com.tencent.mm.protocal.protobuf.evg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class v
{
  private static String deviceID = null;
  public static m liX = null;
  private static int liY = 0;
  private static Boolean liZ = null;
  
  public static n XZ(String paramString)
  {
    AppMethodBeat.i(147095);
    Log.i("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo extInfo=%s", new Object[] { paramString });
    n localn = new n();
    if (!Util.isNullOrNil(paramString)) {}
    try
    {
      paramString = h.FE(paramString);
      localn.lin = paramString.optBoolean("open_remote", false);
      localn.roomId = paramString.optString("room_id");
      localn.lio = paramString.optString("wxpkg_info");
      localn.lip = paramString.optString("qrcode_id");
      localn.liq = paramString.optInt("remote_network_type", 1);
      localn.cyF = paramString.optBoolean("disable_url_check", true);
      localn.lir = paramString.optInt("remote_proxy_port", 9976);
      localn.lis = paramString.optInt("remote_support_compress_algo");
      AppMethodBeat.o(147095);
      return localn;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo %s", new Object[] { paramString });
      }
    }
  }
  
  public static p a(a parama, m paramm, String paramString)
  {
    AppMethodBeat.i(147098);
    localevg = new evg();
    for (;;)
    {
      try
      {
        parama = parama.toByteArray();
        if ((parama.length <= 256) || (paramm == null) || (!wl(paramm.lhV.lis))) {
          continue;
        }
        byte[] arrayOfByte = s.compress(parama);
        localevg.LrK = b.cD(arrayOfByte);
        localevg.MVo = 1;
        Log.v("MicroMsg.RemoteDebugUtil", "use zlib %d/%d", new Object[] { Integer.valueOf(parama.length), Integer.valueOf(arrayOfByte.length) });
      }
      catch (IOException parama)
      {
        Log.e("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend %s", new Object[] { parama });
        continue;
        localevg.apr = ((int)(System.currentTimeMillis() - paramm.lhY));
        continue;
      }
      if (paramm == null)
      {
        Debug.waitForDebugger();
        Log.e("MicroMsg.RemoteDebugUtil", "env = null ");
      }
      localevg.jlm = paramm.lhW.incrementAndGet();
      if (paramm.lhY != 0L) {
        continue;
      }
      localevg.apr = 0;
      paramm.lhY = System.currentTimeMillis();
      localevg.category = paramString;
      Log.d("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend seq %d", new Object[] { Integer.valueOf(localevg.jlm) });
      parama = new p();
      parama.lhG = System.currentTimeMillis();
      parama.liC = localevg.LrK.zy.length;
      parama.liB = localevg;
      AppMethodBeat.o(147098);
      return parama;
      localevg.LrK = b.cD(parama);
    }
  }
  
  public static evf a(int paramInt, a parama)
  {
    AppMethodBeat.i(147099);
    evf localevf = new evf();
    localevf.EX = paramInt;
    if (Util.isNullOrNil(deviceID))
    {
      Random localRandom = new Random(System.currentTimeMillis());
      deviceID = localRandom.nextInt() + "-" + liY;
    }
    localevf.uuid = (deviceID + "-" + System.currentTimeMillis());
    localevf.LrK = h(parama);
    AppMethodBeat.o(147099);
    return localevf;
  }
  
  public static String a(String paramString, d paramd)
  {
    AppMethodBeat.i(147101);
    if (!paramd.OQ())
    {
      AppMethodBeat.o(147101);
      return "";
    }
    paramString = bg.d(paramd, paramString + ".map");
    if (Util.isNullOrNil(paramString))
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
      Log.e("MicroMsg.RemoteDebugUtil", "execGameExternalScript Base64.encode %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(147101);
    }
    return "";
  }
  
  public static boolean a(m paramm, evf paramevf, euz parameuz, w paramw, q paramq)
  {
    AppMethodBeat.i(147100);
    if (paramevf == null)
    {
      Log.w("MicroMsg.RemoteDebugUtil", "handleError dataFormat is null");
      AppMethodBeat.o(147100);
      return false;
    }
    int i = paramevf.EX;
    if (parameuz == null)
    {
      Log.w("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d resp is null", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(147100);
      return false;
    }
    if (i == 1006)
    {
      if (-50011 != parameuz.dIZ) {
        break label102;
      }
      paramm.gW(true);
    }
    while (parameuz.dIZ == 0)
    {
      AppMethodBeat.o(147100);
      return true;
      label102:
      boolean bool = paramm.isBusy();
      paramm.gW(false);
      if (bool) {
        paramq.bAR();
      }
    }
    Log.i("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d, uuid: %s, errorCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), paramevf.uuid, Integer.valueOf(parameuz.dIZ), parameuz.dJa });
    MMHandlerThread.postToMainThread(new w.8(paramw, i, parameuz));
    AppMethodBeat.o(147100);
    return false;
  }
  
  public static boolean bAY()
  {
    AppMethodBeat.i(147102);
    if (liZ != null)
    {
      bool = liZ.booleanValue();
      AppMethodBeat.o(147102);
      return bool;
    }
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("app_brand_global_sp", 0);
    if (localSharedPreferences == null)
    {
      Log.w("MicroMsg.RemoteDebugUtil", "isHardCodeOpenGamePreload, sp is null.");
      AppMethodBeat.o(147102);
      return true;
    }
    boolean bool = localSharedPreferences.getBoolean("hard_code_open_game_preload", true);
    liZ = Boolean.valueOf(bool);
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
      Log.w("MicroMsg.RemoteDebugUtil", parama.getMessage());
      parama = ByteBuffer.allocate(0);
      AppMethodBeat.o(147096);
    }
    return parama;
  }
  
  public static void gY(boolean paramBoolean)
  {
    AppMethodBeat.i(147103);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("app_brand_global_sp", 0);
    if (localSharedPreferences == null)
    {
      Log.w("MicroMsg.RemoteDebugUtil", "setHardCodeOpenGamePreload, sp is null.");
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
      parama = b.cD(parama.toByteArray());
      AppMethodBeat.o(147097);
      return parama;
    }
    catch (IOException parama)
    {
      Log.w("MicroMsg.RemoteDebugUtil", parama.getMessage());
      parama = b.cD(new byte[0]);
      AppMethodBeat.o(147097);
    }
    return parama;
  }
  
  public static void setUin(int paramInt)
  {
    liY = paramInt;
  }
  
  public static boolean wl(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.v
 * JD-Core Version:    0.7.0.1
 */