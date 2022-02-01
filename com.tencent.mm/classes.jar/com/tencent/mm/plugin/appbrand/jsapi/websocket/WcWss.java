package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import android.util.Pair;
import com.tencent.luggage.a.e;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.appbrand.x.a;
import com.tencent.mm.plugin.appbrand.x.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.ArrayList;
import java.util.HashMap;

public class WcWss
{
  private static HashMap<Pair<String, Integer>, a> sKZ;
  
  static
  {
    AppMethodBeat.i(144293);
    WcWss.class.getClassLoader();
    k.DA("wcwss");
    sKZ = new HashMap();
    AppMethodBeat.o(144293);
  }
  
  public static int a(a parama, String paramString1, String paramString2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, Object paramObject, Object[] paramArrayOfObject3)
  {
    AppMethodBeat.i(144283);
    int i = connectSocket(paramString1, paramString2, paramArrayOfObject1, paramArrayOfObject2, null, paramObject, paramArrayOfObject3);
    if (i > 0)
    {
      Log.i("MicroMsg.WcWss", "connect wss pair(%s, %d)", new Object[] { paramString1, Integer.valueOf(i) });
      paramString2 = new Pair(paramString1, Integer.valueOf(i));
      if (sKZ.containsKey(paramString2))
      {
        Log.e("MicroMsg.WcWss", "already exists pair(%s, %d)", new Object[] { paramString1, Integer.valueOf(i) });
        AppMethodBeat.o(144283);
        return -1;
      }
      sKZ.put(paramString2, parama);
    }
    AppMethodBeat.o(144283);
    return i;
  }
  
  public static native void closeSocket(String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  private static native int connectSocket(String paramString1, String paramString2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, Object[] paramArrayOfObject3, Object paramObject, Object[] paramArrayOfObject4);
  
  public static void cxB()
  {
    AppMethodBeat.i(144282);
    Log.i("MicroMsg.WcWss", "initWcWss");
    init();
    AppMethodBeat.o(144282);
  }
  
  public static int doCertificateVerify(String paramString1, int paramInt, String paramString2, byte[][] paramArrayOfByte)
  {
    AppMethodBeat.i(144291);
    Log.i("MicroMsg.WcWss", "doCertificateVerify group:%s,wssId:%s,hostname:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    paramString1 = new Pair(paramString1, Integer.valueOf(paramInt));
    if (sKZ.containsKey(paramString1))
    {
      paramInt = ((a)sKZ.get(paramString1)).doCertificateVerify(paramString2, paramArrayOfByte);
      AppMethodBeat.o(144291);
      return paramInt;
    }
    Log.e("MicroMsg.WcWss", "onMessage callback is null");
    AppMethodBeat.o(144291);
    return -1;
  }
  
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
      int i = NetStatusUtil.getNetType(MMApplicationContext.getContext());
      if (i == -1)
      {
        AppMethodBeat.o(144292);
        return -1;
      }
      boolean bool = NetStatusUtil.is2G(MMApplicationContext.getContext());
      if (bool)
      {
        AppMethodBeat.o(144292);
        return 3;
      }
      bool = NetStatusUtil.is3G(MMApplicationContext.getContext());
      if (bool)
      {
        AppMethodBeat.o(144292);
        return 4;
      }
      bool = NetStatusUtil.is4G(MMApplicationContext.getContext());
      if (bool)
      {
        AppMethodBeat.o(144292);
        return 5;
      }
      bool = NetStatusUtil.isWifi(i);
      if (bool)
      {
        AppMethodBeat.o(144292);
        return 1;
      }
      bool = NetStatusUtil.isWap(i);
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
      Log.printErrStackTrace("MicroMsg.WcWss", localException, "getStatisticsNetType_", new Object[0]);
      AppMethodBeat.o(144292);
    }
    return -1;
  }
  
  public static native void init();
  
  public static void onClose(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(144287);
    Log.i("MicroMsg.WcWss", "onClose group:%s,id:%s, reason:%s, code:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2) });
    Pair localPair = new Pair(paramString1, Integer.valueOf(paramInt1));
    if (sKZ.containsKey(localPair))
    {
      ((a)sKZ.get(localPair)).onClose(paramString1, paramInt1, paramInt2, paramString2);
      sKZ.remove(localPair);
      AppMethodBeat.o(144287);
      return;
    }
    Log.e("MicroMsg.WcWss", "onClose callback is null");
    AppMethodBeat.o(144287);
  }
  
  public static void onHandShake(String paramString, int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(144284);
    Log.i("MicroMsg.WcWss", "onHandShake group:%s, wssId:%s", new Object[] { paramString, Integer.valueOf(paramInt) });
    Pair localPair = new Pair(paramString, Integer.valueOf(paramInt));
    if (sKZ.containsKey(localPair))
    {
      ((a)sKZ.get(localPair)).onHandShake(paramString, paramInt, paramArrayOfString1, paramArrayOfString2);
      AppMethodBeat.o(144284);
      return;
    }
    Log.e("MicroMsg.WcWss", "onHandShake callback is null");
    AppMethodBeat.o(144284);
  }
  
  public static void onIdKeyStat(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    AppMethodBeat.i(144289);
    Log.v("MicroMsg.WcWss", "onIdKeyStat");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfInt1.length)
    {
      localArrayList.add(new IDKey(paramArrayOfInt1[i], paramArrayOfInt2[i], paramArrayOfInt3[i]));
      i += 1;
    }
    ((a)e.U(a.class)).b(localArrayList, false);
    AppMethodBeat.o(144289);
  }
  
  public static void onKvStat(int paramInt, String paramString)
  {
    AppMethodBeat.i(144288);
    Log.i("MicroMsg.WcWss", "onKvStat logId:%s", new Object[] { Integer.valueOf(paramInt) });
    ((b)e.U(b.class)).kvStat(paramInt, paramString);
    AppMethodBeat.o(144288);
  }
  
  public static void onMessage(String paramString, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(144286);
    Log.d("MicroMsg.WcWss", "onMessage group:%s,wssId:%s,isText:%s", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    Pair localPair = new Pair(paramString, Integer.valueOf(paramInt));
    if (sKZ.containsKey(localPair))
    {
      ((a)sKZ.get(localPair)).onMessage(paramString, paramInt, paramArrayOfByte, paramBoolean);
      AppMethodBeat.o(144286);
      return;
    }
    Log.e("MicroMsg.WcWss", "onMessage callback is null");
    AppMethodBeat.o(144286);
  }
  
  public static void onOpen(String paramString1, int paramInt1, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt2, String paramString2, String[] paramArrayOfString3, String[] paramArrayOfString4)
  {
    AppMethodBeat.i(325806);
    Log.i("MicroMsg.WcWss", "onOpen group:%s,isSuc:%s, msg:%s, code:%s, wssId:%s", new Object[] { paramString1, Boolean.valueOf(paramBoolean), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    Pair localPair = new Pair(paramString1, Integer.valueOf(paramInt1));
    if (sKZ.containsKey(localPair))
    {
      ((a)sKZ.get(localPair)).onOpen(paramString1, paramInt1, paramBoolean, paramArrayOfString1, paramArrayOfString2, paramInt2, paramString2, paramArrayOfString3, paramArrayOfString4);
      if (!paramBoolean)
      {
        sKZ.remove(localPair);
        AppMethodBeat.o(325806);
      }
    }
    else
    {
      Log.e("MicroMsg.WcWss", "onOpen callback is null");
    }
    AppMethodBeat.o(325806);
  }
  
  public static native int sendBuffer(String paramString, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean);
  
  public static native void setDebugIp(String paramString, int paramInt);
  
  public static abstract interface a
  {
    public abstract int doCertificateVerify(String paramString, byte[][] paramArrayOfByte);
    
    public abstract void onClose(String paramString1, int paramInt1, int paramInt2, String paramString2);
    
    public abstract void onHandShake(String paramString, int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2);
    
    public abstract void onMessage(String paramString, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean);
    
    public abstract void onOpen(String paramString1, int paramInt1, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt2, String paramString2, String[] paramArrayOfString3, String[] paramArrayOfString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.WcWss
 * JD-Core Version:    0.7.0.1
 */