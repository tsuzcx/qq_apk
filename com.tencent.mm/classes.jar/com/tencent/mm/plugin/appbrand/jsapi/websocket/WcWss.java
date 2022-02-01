package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import android.support.annotation.Keep;
import android.util.Pair;
import com.tencent.luggage.a.e;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.t.a;
import com.tencent.mm.plugin.appbrand.t.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import java.util.ArrayList;
import java.util.HashMap;

public class WcWss
{
  private static HashMap<Pair<String, Integer>, a> gMapCallbacks;
  
  static
  {
    AppMethodBeat.i(144293);
    WcWss.class.getClassLoader();
    j.sC("wcwss");
    gMapCallbacks = new HashMap();
    AppMethodBeat.o(144293);
  }
  
  public static int a(a parama, String paramString1, String paramString2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, Object paramObject, Object[] paramArrayOfObject3)
  {
    AppMethodBeat.i(144283);
    int i = connectSocket(paramString1, paramString2, paramArrayOfObject1, paramArrayOfObject2, null, paramObject, paramArrayOfObject3);
    if (i > 0)
    {
      ac.i("MicroMsg.WcWss", "connect wss pair(%s, %d)", new Object[] { paramString1, Integer.valueOf(i) });
      paramString2 = new Pair(paramString1, Integer.valueOf(i));
      if (gMapCallbacks.containsKey(paramString2))
      {
        ac.e("MicroMsg.WcWss", "already exists pair(%s, %d)", new Object[] { paramString1, Integer.valueOf(i) });
        AppMethodBeat.o(144283);
        return -1;
      }
      gMapCallbacks.put(paramString2, parama);
    }
    AppMethodBeat.o(144283);
    return i;
  }
  
  public static void bln()
  {
    AppMethodBeat.i(144282);
    ac.i("MicroMsg.WcWss", "initWcWss");
    init();
    AppMethodBeat.o(144282);
  }
  
  public static native void closeSocket(String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  private static native int connectSocket(String paramString1, String paramString2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, Object[] paramArrayOfObject3, Object paramObject, Object[] paramArrayOfObject4);
  
  @Keep
  public static int doCertificateVerify(String paramString1, int paramInt, String paramString2, byte[][] paramArrayOfByte)
  {
    AppMethodBeat.i(144291);
    ac.i("MicroMsg.WcWss", "doCertificateVerify group:%s,wssId:%s,hostname:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    paramString1 = new Pair(paramString1, Integer.valueOf(paramInt));
    if (gMapCallbacks.containsKey(paramString1))
    {
      paramInt = ((a)gMapCallbacks.get(paramString1)).doCertificateVerify(paramString2, paramArrayOfByte);
      AppMethodBeat.o(144291);
      return paramInt;
    }
    ac.e("MicroMsg.WcWss", "onMessage callback is null");
    AppMethodBeat.o(144291);
    return -1;
  }
  
  @Keep
  public static int getNetworkType()
  {
    AppMethodBeat.i(144290);
    int i = getStatisticsNetType();
    AppMethodBeat.o(144290);
    return i;
  }
  
  private static int getStatisticsNetType()
  {
    AppMethodBeat.i(144292);
    try
    {
      int i = ax.getNetType(ai.getContext());
      if (i == -1)
      {
        AppMethodBeat.o(144292);
        return -1;
      }
      boolean bool = ax.is2G(ai.getContext());
      if (bool)
      {
        AppMethodBeat.o(144292);
        return 3;
      }
      bool = ax.is3G(ai.getContext());
      if (bool)
      {
        AppMethodBeat.o(144292);
        return 4;
      }
      bool = ax.is4G(ai.getContext());
      if (bool)
      {
        AppMethodBeat.o(144292);
        return 5;
      }
      bool = ax.isWifi(i);
      if (bool)
      {
        AppMethodBeat.o(144292);
        return 1;
      }
      bool = ax.isWap(i);
      if (bool)
      {
        AppMethodBeat.o(144292);
        return 2;
      }
      AppMethodBeat.o(144292);
      return 6;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.WcWss", localException, "getStatisticsNetType_", new Object[0]);
      AppMethodBeat.o(144292);
    }
    return -1;
  }
  
  public static native void init();
  
  @Keep
  public static void onClose(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(144287);
    ac.i("MicroMsg.WcWss", "onClose group:%s,id:%s, reason:%s, code:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2) });
    Pair localPair = new Pair(paramString1, Integer.valueOf(paramInt1));
    if (gMapCallbacks.containsKey(localPair))
    {
      ((a)gMapCallbacks.get(localPair)).onClose(paramString1, paramInt1, paramInt2, paramString2);
      gMapCallbacks.remove(localPair);
      AppMethodBeat.o(144287);
      return;
    }
    ac.e("MicroMsg.WcWss", "onClose callback is null");
    AppMethodBeat.o(144287);
  }
  
  @Keep
  public static void onHandShake(String paramString, int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(144284);
    ac.i("MicroMsg.WcWss", "onHandShake group:%s, wssId:%s", new Object[] { paramString, Integer.valueOf(paramInt) });
    Pair localPair = new Pair(paramString, Integer.valueOf(paramInt));
    if (gMapCallbacks.containsKey(localPair))
    {
      ((a)gMapCallbacks.get(localPair)).onHandShake(paramString, paramInt, paramArrayOfString1, paramArrayOfString2);
      AppMethodBeat.o(144284);
      return;
    }
    ac.e("MicroMsg.WcWss", "onHandShake callback is null");
    AppMethodBeat.o(144284);
  }
  
  @Keep
  public static void onIdKeyStat(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    AppMethodBeat.i(144289);
    ac.v("MicroMsg.WcWss", "onIdKeyStat");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfInt1.length)
    {
      localArrayList.add(new IDKey(paramArrayOfInt1[i], paramArrayOfInt2[i], paramArrayOfInt3[i]));
      i += 1;
    }
    ((a)e.L(a.class)).b(localArrayList, false);
    AppMethodBeat.o(144289);
  }
  
  @Keep
  public static void onKvStat(int paramInt, String paramString)
  {
    AppMethodBeat.i(144288);
    ac.i("MicroMsg.WcWss", "onKvStat logId:%s", new Object[] { Integer.valueOf(paramInt) });
    ((b)e.L(b.class)).kvStat(paramInt, paramString);
    AppMethodBeat.o(144288);
  }
  
  @Keep
  public static void onMessage(String paramString, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(144286);
    ac.d("MicroMsg.WcWss", "onMessage group:%s,wssId:%s,isText:%s", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    Pair localPair = new Pair(paramString, Integer.valueOf(paramInt));
    if (gMapCallbacks.containsKey(localPair))
    {
      ((a)gMapCallbacks.get(localPair)).onMessage(paramString, paramInt, paramArrayOfByte, paramBoolean);
      AppMethodBeat.o(144286);
      return;
    }
    ac.e("MicroMsg.WcWss", "onMessage callback is null");
    AppMethodBeat.o(144286);
  }
  
  @Keep
  public static void onOpen(String paramString1, int paramInt1, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt2, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8)
  {
    AppMethodBeat.i(175389);
    ac.i("MicroMsg.WcWss", "onOpen group:%s,isSuc:%s, msg:%s, code:%s, wssId:%s", new Object[] { paramString1, Boolean.valueOf(paramBoolean), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    Pair localPair = new Pair(paramString1, Integer.valueOf(paramInt1));
    if (gMapCallbacks.containsKey(localPair))
    {
      ((a)gMapCallbacks.get(localPair)).onOpen(paramString1, paramInt1, paramBoolean, paramArrayOfString1, paramArrayOfString2, paramInt2, paramString2, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramLong8);
      if (!paramBoolean)
      {
        gMapCallbacks.remove(localPair);
        AppMethodBeat.o(175389);
      }
    }
    else
    {
      ac.e("MicroMsg.WcWss", "onOpen callback is null");
    }
    AppMethodBeat.o(175389);
  }
  
  public static native int sendBuffer(String paramString, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean);
  
  public static native void setDebugIp(String paramString, int paramInt);
  
  public static abstract interface a
  {
    public abstract int doCertificateVerify(String paramString, byte[][] paramArrayOfByte);
    
    public abstract void onClose(String paramString1, int paramInt1, int paramInt2, String paramString2);
    
    public abstract void onHandShake(String paramString, int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2);
    
    public abstract void onMessage(String paramString, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean);
    
    public abstract void onOpen(String paramString1, int paramInt1, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt2, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.WcWss
 * JD-Core Version:    0.7.0.1
 */