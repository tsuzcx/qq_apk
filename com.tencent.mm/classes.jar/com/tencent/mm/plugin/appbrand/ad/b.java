package com.tencent.mm.plugin.appbrand.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;

public final class b
{
  public static String TAG;
  private static Set<Integer> nzW;
  
  static
  {
    AppMethodBeat.i(280207);
    TAG = "MicroMsg.AppBrandAdABTests[AppBrandSplashAd]";
    HashSet localHashSet = new HashSet();
    nzW = localHashSet;
    localHashSet.add(Integer.valueOf(1001));
    nzW.add(Integer.valueOf(1089));
    nzW.add(Integer.valueOf(1104));
    nzW.add(Integer.valueOf(1103));
    AppMethodBeat.o(280207);
  }
  
  public static int bDI()
  {
    AppMethodBeat.i(280203);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vCg, 0);
    Log.i(TAG, "getCodeBlockTimeThreshold, timeThreshold:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(280203);
    return i;
  }
  
  public static void bEC()
  {
    AppMethodBeat.i(44003);
    MultiProcessMMKV.getMMKV("appbrandAd").removeValueForKey("showad");
    AppMethodBeat.o(44003);
  }
  
  public static boolean bED()
  {
    AppMethodBeat.i(44005);
    int i = MultiProcessMMKV.getMMKV("appbrandAd").decodeInt("showad", -1);
    if (i >= 0)
    {
      Log.i(TAG, "canShowAppBrandAd, command value:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(44005);
        return true;
      }
      AppMethodBeat.o(44005);
      return false;
    }
    i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vBZ, 0);
    Log.i(TAG, "canShowAppBrandAd, experiment value:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(44005);
      return true;
    }
    AppMethodBeat.o(44005);
    return false;
  }
  
  public static void bEE()
  {
    AppMethodBeat.i(44006);
    MultiProcessMMKV.getMMKV("appbrandAd").removeValueForKey("allshowad");
    AppMethodBeat.o(44006);
  }
  
  public static boolean bEF()
  {
    AppMethodBeat.i(44008);
    int i = MultiProcessMMKV.getMMKV("appbrandAd").decodeInt("allshowad", -1);
    if (i >= 0)
    {
      Log.i(TAG, "canAllShowAppBrandAd, command value:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(44008);
        return true;
      }
      AppMethodBeat.o(44008);
      return false;
    }
    i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vCa, 0);
    Log.i(TAG, "canAllShowAppBrandAd, experiment value:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(44008);
      return true;
    }
    AppMethodBeat.o(44008);
    return false;
  }
  
  public static int bEG()
  {
    AppMethodBeat.i(280205);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vCh, 0);
    Log.i(TAG, "getCheckBlockTimeThreshold, timeThreshold:%d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(280205);
    return i;
  }
  
  public static void yU(int paramInt)
  {
    AppMethodBeat.i(44004);
    MultiProcessMMKV.getMMKV("appbrandAd").encode("showad", paramInt);
    AppMethodBeat.o(44004);
  }
  
  public static void yV(int paramInt)
  {
    AppMethodBeat.i(44007);
    MultiProcessMMKV.getMMKV("appbrandAd").encode("allshowad", paramInt);
    AppMethodBeat.o(44007);
  }
  
  public static boolean yW(int paramInt)
  {
    AppMethodBeat.i(280202);
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vCf, "");
    if (!Util.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      try
      {
        HashSet localHashSet = new HashSet();
        localObject = new JSONArray((String)localObject);
        int i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          localHashSet.add(Integer.valueOf(((JSONArray)localObject).optInt(i)));
          i += 1;
          continue;
        }
        Log.i(TAG, "checkSceneForShowAd, abtest set:%s, scene:%s", new Object[] { localHashSet, Integer.valueOf(paramInt) });
        bool = localHashSet.contains(Integer.valueOf(paramInt));
      }
      catch (Exception localException)
      {
        Log.i(TAG, "checkSceneForShowAd, exception, set:%s, scene:%s", new Object[] { nzW, Integer.valueOf(paramInt) });
        bool = nzW.contains(Integer.valueOf(paramInt));
        continue;
      }
      AppMethodBeat.o(280202);
      return bool;
      Log.i(TAG, "checkSceneForShowAd, no abtest, set:%s, scene:%s", new Object[] { nzW, Integer.valueOf(paramInt) });
      boolean bool = nzW.contains(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.b
 * JD-Core Version:    0.7.0.1
 */