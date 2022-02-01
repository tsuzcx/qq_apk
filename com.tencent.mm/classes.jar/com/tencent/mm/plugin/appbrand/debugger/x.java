package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Debug;
import android.util.Base64;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.h;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.protocal.protobuf.ffk;
import com.tencent.mm.protocal.protobuf.ffr;
import com.tencent.mm.protocal.protobuf.ffs;
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

public final class x
{
  private static String deviceID = null;
  public static o odG = null;
  private static int odH = 0;
  private static Boolean odI = null;
  
  public static r a(a parama, o paramo, String paramString)
  {
    AppMethodBeat.i(147098);
    localffs = new ffs();
    for (;;)
    {
      try
      {
        parama = parama.toByteArray();
        if ((parama.length <= 256) || (paramo == null) || (!zy(paramo.ocD.oda))) {
          continue;
        }
        byte[] arrayOfByte = com.tencent.mm.b.s.compress(parama);
        localffs.Sth = b.cU(arrayOfByte);
        localffs.UhB = 1;
        Log.v("MicroMsg.RemoteDebugUtil", "use zlib %d/%d", new Object[] { Integer.valueOf(parama.length), Integer.valueOf(arrayOfByte.length) });
      }
      catch (IOException parama)
      {
        Log.e("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend %s", new Object[] { parama });
        continue;
        localffs.YU = ((int)(System.currentTimeMillis() - paramo.ocG));
        continue;
      }
      if (paramo == null)
      {
        Debug.waitForDebugger();
        Log.e("MicroMsg.RemoteDebugUtil", "env = null ");
      }
      localffs.mbp = paramo.ocE.incrementAndGet();
      if (paramo.ocG != 0L) {
        continue;
      }
      localffs.YU = 0;
      paramo.ocG = System.currentTimeMillis();
      localffs.idV = paramString;
      Log.d("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend seq %d", new Object[] { Integer.valueOf(localffs.mbp) });
      parama = new r();
      parama.oco = System.currentTimeMillis();
      parama.odk = localffs.Sth.UH.length;
      parama.odj = localffs;
      AppMethodBeat.o(147098);
      return parama;
      localffs.Sth = b.cU(parama);
    }
  }
  
  public static ffr a(int paramInt, a parama)
  {
    AppMethodBeat.i(147099);
    ffr localffr = new ffr();
    localffr.Vh = paramInt;
    if (Util.isNullOrNil(deviceID))
    {
      Random localRandom = new Random(System.currentTimeMillis());
      deviceID = localRandom.nextInt() + "-" + odH;
    }
    localffr.uuid = (deviceID + "-" + System.currentTimeMillis());
    localffr.Sth = h(parama);
    AppMethodBeat.o(147099);
    return localffr;
  }
  
  public static String a(String paramString, d paramd)
  {
    AppMethodBeat.i(147101);
    if (!paramd.Rp())
    {
      AppMethodBeat.o(147101);
      return "";
    }
    paramString = bl.d(paramd, paramString + ".map");
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
  
  public static boolean a(o paramo, ffr paramffr, ffk paramffk, y paramy, s params)
  {
    AppMethodBeat.i(147100);
    if (paramffr == null)
    {
      Log.w("MicroMsg.RemoteDebugUtil", "handleError dataFormat is null");
      AppMethodBeat.o(147100);
      return false;
    }
    int i = paramffr.Vh;
    if (paramffk == null)
    {
      Log.w("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d resp is null", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(147100);
      return false;
    }
    if (i == 1006)
    {
      if (-50011 != paramffk.fBP) {
        break label102;
      }
      paramo.hN(true);
    }
    while (paramffk.fBP == 0)
    {
      AppMethodBeat.o(147100);
      return true;
      label102:
      boolean bool = paramo.isBusy();
      paramo.hN(false);
      if (bool) {
        params.bMm();
      }
    }
    Log.i("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d, uuid: %s, errorCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), paramffr.uuid, Integer.valueOf(paramffk.fBP), paramffk.errmsg });
    MMHandlerThread.postToMainThread(new y.8(paramy, i, paramffk));
    AppMethodBeat.o(147100);
    return false;
  }
  
  public static p afM(String paramString)
  {
    AppMethodBeat.i(147095);
    Log.i("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo extInfo=%s", new Object[] { paramString });
    p localp = new p();
    if (!Util.isNullOrNil(paramString)) {}
    for (;;)
    {
      try
      {
        paramString = h.ME(paramString);
        localp.ocV = paramString.optBoolean("open_remote", false);
        localp.roomId = paramString.optString("room_id");
        localp.ocW = paramString.optString("wxpkg_info");
        localp.ocX = paramString.optString("qrcode_id");
        localp.ocY = paramString.optInt("remote_network_type", 1);
        localp.cxj = paramString.optBoolean("disable_url_check", true);
        localp.ocZ = paramString.optInt("remote_proxy_port", 9976);
        localp.oda = paramString.optInt("remote_support_compress_algo");
      }
      catch (Exception paramString)
      {
        int i;
        Log.e("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo %s", new Object[] { paramString });
        continue;
      }
      try
      {
        i = h.ME(paramString.optString("debug_launch_info")).optInt("debug_type", -1);
        Log.i("MicroMsg.RemoteDebugUtil", "debug_type:%d", new Object[] { Integer.valueOf(i) });
        if (i != -1) {
          localp.cBI = i;
        }
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.RemoteDebugUtil", "parse debug_launch_info %s", new Object[] { paramString });
      }
    }
    AppMethodBeat.o(147095);
    return localp;
  }
  
  public static boolean afN(String paramString)
  {
    AppMethodBeat.i(234292);
    if (afM(paramString).cBI == 1)
    {
      AppMethodBeat.o(234292);
      return true;
    }
    AppMethodBeat.o(234292);
    return false;
  }
  
  public static boolean bMt()
  {
    AppMethodBeat.i(147102);
    if (odI != null)
    {
      bool = odI.booleanValue();
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
    odI = Boolean.valueOf(bool);
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
  
  private static b h(a parama)
  {
    AppMethodBeat.i(147097);
    try
    {
      parama = b.cU(parama.toByteArray());
      AppMethodBeat.o(147097);
      return parama;
    }
    catch (IOException parama)
    {
      Log.w("MicroMsg.RemoteDebugUtil", parama.getMessage());
      parama = b.cU(new byte[0]);
      AppMethodBeat.o(147097);
    }
    return parama;
  }
  
  public static void hP(boolean paramBoolean)
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
  
  public static void setUin(int paramInt)
  {
    odH = paramInt;
  }
  
  public static boolean zy(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.x
 * JD-Core Version:    0.7.0.1
 */