package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import android.support.annotation.Keep;
import android.util.Pair;
import com.tencent.luggage.a.e;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.appbrand.o.a;
import com.tencent.mm.plugin.appbrand.o.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.util.ArrayList;
import java.util.HashMap;

public class WcWss
{
  private static HashMap<Pair<String, Integer>, WcWss.a> igE;
  
  static
  {
    AppMethodBeat.i(108125);
    k.a("wcwss", WcWss.class.getClassLoader());
    init();
    igE = new HashMap();
    AppMethodBeat.o(108125);
  }
  
  public static int a(WcWss.a parama, String paramString1, String paramString2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, Object paramObject, Object[] paramArrayOfObject3)
  {
    AppMethodBeat.i(108115);
    int i = connectSocket(paramString1, paramString2, paramArrayOfObject1, paramArrayOfObject2, null, paramObject, paramArrayOfObject3);
    if (i > 0)
    {
      ab.i("MicroMsg.WcWss", "connect wss pair(%s, %d)", new Object[] { paramString1, Integer.valueOf(i) });
      paramString2 = new Pair(paramString1, Integer.valueOf(i));
      if (igE.containsKey(paramString2))
      {
        ab.e("MicroMsg.WcWss", "already exists pair(%s, %d)", new Object[] { paramString1, Integer.valueOf(i) });
        AppMethodBeat.o(108115);
        return -1;
      }
      igE.put(paramString2, parama);
    }
    AppMethodBeat.o(108115);
    return i;
  }
  
  public static native void closeSocket(String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  private static native int connectSocket(String paramString1, String paramString2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, Object[] paramArrayOfObject3, Object paramObject, Object[] paramArrayOfObject4);
  
  @Keep
  public static int doCertificateVerify(String paramString1, int paramInt, String paramString2, byte[][] paramArrayOfByte)
  {
    AppMethodBeat.i(108123);
    ab.i("MicroMsg.WcWss", "doCertificateVerify group:%s,wssId:%s,hostname:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    paramString1 = new Pair(paramString1, Integer.valueOf(paramInt));
    if (igE.containsKey(paramString1))
    {
      paramInt = ((WcWss.a)igE.get(paramString1)).doCertificateVerify(paramString2, paramArrayOfByte);
      AppMethodBeat.o(108123);
      return paramInt;
    }
    ab.e("MicroMsg.WcWss", "onMessage callback is null");
    AppMethodBeat.o(108123);
    return -1;
  }
  
  @Keep
  public static int getNetworkType()
  {
    AppMethodBeat.i(108122);
    int i = getStatisticsNetType();
    AppMethodBeat.o(108122);
    return i;
  }
  
  private static int getStatisticsNetType()
  {
    AppMethodBeat.i(108124);
    try
    {
      int i = at.getNetType(ah.getContext());
      if (i == -1)
      {
        AppMethodBeat.o(108124);
        return -1;
      }
      boolean bool = at.is2G(ah.getContext());
      if (bool)
      {
        AppMethodBeat.o(108124);
        return 3;
      }
      bool = at.is3G(ah.getContext());
      if (bool)
      {
        AppMethodBeat.o(108124);
        return 4;
      }
      bool = at.is4G(ah.getContext());
      if (bool)
      {
        AppMethodBeat.o(108124);
        return 5;
      }
      bool = at.isWifi(i);
      if (bool)
      {
        AppMethodBeat.o(108124);
        return 1;
      }
      bool = at.isWap(i);
      if (bool)
      {
        AppMethodBeat.o(108124);
        return 2;
      }
      AppMethodBeat.o(108124);
      return 6;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.WcWss", localException, "getStatisticsNetType_", new Object[0]);
      AppMethodBeat.o(108124);
    }
    return -1;
  }
  
  public static native void init();
  
  @Keep
  public static void onClose(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(108119);
    ab.i("MicroMsg.WcWss", "onClose group:%s,id:%s, reason:%s, code:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2) });
    Pair localPair = new Pair(paramString1, Integer.valueOf(paramInt1));
    if (igE.containsKey(localPair))
    {
      ((WcWss.a)igE.get(localPair)).onClose(paramString1, paramInt1, paramInt2, paramString2);
      igE.remove(localPair);
      AppMethodBeat.o(108119);
      return;
    }
    ab.e("MicroMsg.WcWss", "onClose callback is null");
    AppMethodBeat.o(108119);
  }
  
  @Keep
  public static void onHandShake(String paramString, int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(108116);
    ab.i("MicroMsg.WcWss", "onHandShake group:%s, wssId:%s", new Object[] { paramString, Integer.valueOf(paramInt) });
    Pair localPair = new Pair(paramString, Integer.valueOf(paramInt));
    if (igE.containsKey(localPair))
    {
      ((WcWss.a)igE.get(localPair)).onHandShake(paramString, paramInt, paramArrayOfString1, paramArrayOfString2);
      AppMethodBeat.o(108116);
      return;
    }
    ab.e("MicroMsg.WcWss", "onHandShake callback is null");
    AppMethodBeat.o(108116);
  }
  
  @Keep
  public static void onIdKeyStat(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    AppMethodBeat.i(108121);
    ab.v("MicroMsg.WcWss", "onIdKeyStat");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfInt1.length)
    {
      localArrayList.add(new IDKey(paramArrayOfInt1[i], paramArrayOfInt2[i], paramArrayOfInt3[i]));
      i += 1;
    }
    ((a)e.r(a.class)).b(localArrayList, false);
    AppMethodBeat.o(108121);
  }
  
  @Keep
  public static void onKvStat(int paramInt, String paramString)
  {
    AppMethodBeat.i(108120);
    ab.i("MicroMsg.WcWss", "onKvStat logId:%s", new Object[] { Integer.valueOf(paramInt) });
    ((b)e.r(b.class)).kvStat(paramInt, paramString);
    AppMethodBeat.o(108120);
  }
  
  @Keep
  public static void onMessage(String paramString, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(108118);
    ab.i("MicroMsg.WcWss", "onMessage group:%s,wssId:%s,isText:%s", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    Pair localPair = new Pair(paramString, Integer.valueOf(paramInt));
    if (igE.containsKey(localPair))
    {
      ((WcWss.a)igE.get(localPair)).onMessage(paramString, paramInt, paramArrayOfByte, paramBoolean);
      AppMethodBeat.o(108118);
      return;
    }
    ab.e("MicroMsg.WcWss", "onMessage callback is null");
    AppMethodBeat.o(108118);
  }
  
  @Keep
  public static void onOpen(String paramString1, int paramInt1, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(108117);
    ab.i("MicroMsg.WcWss", "onOpen group:%s,isSuc:%s, msg:%s, code:%s, wssId:%s", new Object[] { paramString1, Boolean.valueOf(paramBoolean), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    Pair localPair = new Pair(paramString1, Integer.valueOf(paramInt1));
    if (igE.containsKey(localPair))
    {
      ((WcWss.a)igE.get(localPair)).onOpen(paramString1, paramInt1, paramBoolean, paramArrayOfString1, paramArrayOfString2, paramInt2, paramString2);
      if (!paramBoolean)
      {
        igE.remove(localPair);
        AppMethodBeat.o(108117);
      }
    }
    else
    {
      ab.e("MicroMsg.WcWss", "onOpen callback is null");
    }
    AppMethodBeat.o(108117);
  }
  
  public static native int sendBuffer(String paramString, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean);
  
  public static native void setDebugIp(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.WcWss
 * JD-Core Version:    0.7.0.1
 */