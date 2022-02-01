package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Debug;
import android.util.Base64;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.h;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.protocal.protobuf.gbw;
import com.tencent.mm.protocal.protobuf.gcd;
import com.tencent.mm.protocal.protobuf.gce;
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
  public static o reA = null;
  private static int reB = 0;
  private static Boolean reC = null;
  
  public static p Yl(String paramString)
  {
    AppMethodBeat.i(147095);
    Log.i("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo extInfo=%s", new Object[] { paramString });
    p localp = new p();
    if (!Util.isNullOrNil(paramString)) {}
    for (;;)
    {
      try
      {
        paramString = h.Fn(paramString);
        localp.rdL = paramString.optBoolean("open_remote", false);
        localp.roomId = paramString.optString("room_id");
        localp.rdM = paramString.optString("wxpkg_info");
        localp.rdN = paramString.optString("qrcode_id");
        localp.rdO = paramString.optInt("remote_network_type", 1);
        localp.epB = paramString.optBoolean("disable_url_check", true);
        localp.rdP = paramString.optInt("remote_proxy_port", 9976);
        localp.rdQ = paramString.optInt("remote_support_compress_algo");
      }
      catch (Exception paramString)
      {
        int i;
        Log.e("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo %s", new Object[] { paramString });
        continue;
      }
      try
      {
        paramString = h.Fn(paramString.optString("debug_launch_info"));
        if (paramString == null) {
          continue;
        }
        i = paramString.optInt("debug_type", -1);
        Log.i("MicroMsg.RemoteDebugUtil", "debug_type:%d", new Object[] { Integer.valueOf(i) });
        if (i != -1) {
          localp.eul = i;
        }
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.RemoteDebugUtil", "parse debug_launch_info %s", new Object[] { paramString });
        continue;
      }
      AppMethodBeat.o(147095);
      return localp;
      Log.e("MicroMsg.RemoteDebugUtil", "debug_launch_info obj is null");
    }
  }
  
  public static boolean Ym(String paramString)
  {
    AppMethodBeat.i(319696);
    if (Yl(paramString).eul == 1)
    {
      AppMethodBeat.o(319696);
      return true;
    }
    AppMethodBeat.o(319696);
    return false;
  }
  
  public static r a(a parama, o paramo, String paramString)
  {
    AppMethodBeat.i(147098);
    localgce = new gce();
    for (;;)
    {
      try
      {
        parama = parama.toByteArray();
        if ((parama.length <= 256) || (paramo == null) || (!zN(paramo.rdu.rdQ))) {
          continue;
        }
        byte[] arrayOfByte = com.tencent.mm.b.s.compress(parama);
        localgce.Zsu = b.cX(arrayOfByte);
        localgce.YCv = 1;
        Log.v("MicroMsg.RemoteDebugUtil", "use zlib %d/%d", new Object[] { Integer.valueOf(parama.length), Integer.valueOf(arrayOfByte.length) });
      }
      catch (IOException parama)
      {
        Log.e("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend %s", new Object[] { parama });
        continue;
        localgce.bGp = ((int)(System.currentTimeMillis() - paramo.rdw));
        continue;
      }
      if (paramo == null)
      {
        Debug.waitForDebugger();
        Log.e("MicroMsg.RemoteDebugUtil", "env = null ");
      }
      localgce.oUj = paramo.cqS.incrementAndGet();
      if (paramo.rdw != 0L) {
        continue;
      }
      localgce.bGp = 0;
      paramo.rdw = System.currentTimeMillis();
      localgce.kDf = paramString;
      Log.d("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend seq %d", new Object[] { Integer.valueOf(localgce.oUj) });
      parama = new r();
      parama.rdg = System.currentTimeMillis();
      parama.reb = localgce.Zsu.Op.length;
      parama.rea = localgce;
      AppMethodBeat.o(147098);
      return parama;
      localgce.Zsu = b.cX(parama);
    }
  }
  
  public static gcd a(int paramInt, a parama)
  {
    AppMethodBeat.i(147099);
    gcd localgcd = new gcd();
    localgcd.bUl = paramInt;
    if (Util.isNullOrNil(deviceID))
    {
      Random localRandom = new Random(System.currentTimeMillis());
      deviceID = localRandom.nextInt() + "-" + reB;
    }
    localgcd.uuid = (deviceID + "-" + System.currentTimeMillis());
    localgcd.Zsu = e(parama);
    AppMethodBeat.o(147099);
    return localgcd;
  }
  
  public static String a(String paramString, d paramd)
  {
    AppMethodBeat.i(147101);
    if (!paramd.arD())
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
  
  public static boolean a(o paramo, gcd paramgcd, gbw paramgbw, y paramy, s params)
  {
    AppMethodBeat.i(147100);
    if (paramgcd == null)
    {
      Log.w("MicroMsg.RemoteDebugUtil", "handleError dataFormat is null");
      AppMethodBeat.o(147100);
      return false;
    }
    int i = paramgcd.bUl;
    if (paramgbw == null)
    {
      Log.w("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d resp is null", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(147100);
      return false;
    }
    if (i == 1006)
    {
      if (-50011 != paramgbw.hGE) {
        break label102;
      }
      paramo.iK(true);
    }
    while (paramgbw.hGE == 0)
    {
      AppMethodBeat.o(147100);
      return true;
      label102:
      boolean bool = paramo.isBusy();
      paramo.iK(false);
      if (bool) {
        params.clM();
      }
    }
    Log.i("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d, uuid: %s, errorCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), paramgcd.uuid, Integer.valueOf(paramgbw.hGE), paramgbw.errmsg });
    MMHandlerThread.postToMainThread(new y.10(paramy, i, paramgbw));
    AppMethodBeat.o(147100);
    return false;
  }
  
  public static boolean clT()
  {
    AppMethodBeat.i(147102);
    if (reC != null)
    {
      bool = reC.booleanValue();
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
    reC = Boolean.valueOf(bool);
    AppMethodBeat.o(147102);
    return bool;
  }
  
  public static ByteBuffer d(a parama)
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
  
  private static b e(a parama)
  {
    AppMethodBeat.i(147097);
    try
    {
      parama = b.cX(parama.toByteArray());
      AppMethodBeat.o(147097);
      return parama;
    }
    catch (IOException parama)
    {
      Log.w("MicroMsg.RemoteDebugUtil", parama.getMessage());
      parama = b.cX(new byte[0]);
      AppMethodBeat.o(147097);
    }
    return parama;
  }
  
  public static void iM(boolean paramBoolean)
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
    reB = paramInt;
  }
  
  public static boolean zN(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.x
 * JD-Core Version:    0.7.0.1
 */