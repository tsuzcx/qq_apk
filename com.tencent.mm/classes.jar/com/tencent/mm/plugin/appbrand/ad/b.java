package com.tencent.mm.plugin.appbrand.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
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
  private static Set<Integer> kGp;
  
  static
  {
    AppMethodBeat.i(226256);
    TAG = "MicroMsg.AppBrandAdABTests[AppBrandSplashAd]";
    HashSet localHashSet = new HashSet();
    kGp = localHashSet;
    localHashSet.add(Integer.valueOf(1001));
    kGp.add(Integer.valueOf(1089));
    kGp.add(Integer.valueOf(1104));
    kGp.add(Integer.valueOf(1103));
    AppMethodBeat.o(226256);
  }
  
  public static int bsL()
  {
    AppMethodBeat.i(226254);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rVG, 0);
    Log.i(TAG, "getCodeBlockTimeThreshold, timeThreshold:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(226254);
    return i;
  }
  
  public static void btE()
  {
    AppMethodBeat.i(44003);
    MultiProcessMMKV.getMMKV("appbrandAd").removeValueForKey("showad");
    AppMethodBeat.o(44003);
  }
  
  public static boolean btF()
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
    i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rVz, 0);
    Log.i(TAG, "canShowAppBrandAd, experiment value:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(44005);
      return true;
    }
    AppMethodBeat.o(44005);
    return false;
  }
  
  public static void btG()
  {
    AppMethodBeat.i(44006);
    MultiProcessMMKV.getMMKV("appbrandAd").removeValueForKey("allshowad");
    AppMethodBeat.o(44006);
  }
  
  public static boolean btH()
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
    i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rVA, 0);
    Log.i(TAG, "canAllShowAppBrandAd, experiment value:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(44008);
      return true;
    }
    AppMethodBeat.o(44008);
    return false;
  }
  
  public static int btI()
  {
    AppMethodBeat.i(226255);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rVH, 0);
    Log.i(TAG, "getCheckBlockTimeThreshold, timeThreshold:%d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(226255);
    return i;
  }
  
  public static void vJ(int paramInt)
  {
    AppMethodBeat.i(44004);
    MultiProcessMMKV.getMMKV("appbrandAd").encode("showad", paramInt);
    AppMethodBeat.o(44004);
  }
  
  public static void vK(int paramInt)
  {
    AppMethodBeat.i(44007);
    MultiProcessMMKV.getMMKV("appbrandAd").encode("allshowad", paramInt);
    AppMethodBeat.o(44007);
  }
  
  public static boolean vL(int paramInt)
  {
    AppMethodBeat.i(226253);
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rVF, "");
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
        Log.i(TAG, "checkSceneForShowAd, exception, set:%s, scene:%s", new Object[] { kGp, Integer.valueOf(paramInt) });
        bool = kGp.contains(Integer.valueOf(paramInt));
        continue;
      }
      AppMethodBeat.o(226253);
      return bool;
      Log.i(TAG, "checkSceneForShowAd, no abtest, set:%s, scene:%s", new Object[] { kGp, Integer.valueOf(paramInt) });
      boolean bool = kGp.contains(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.b
 * JD-Core Version:    0.7.0.1
 */