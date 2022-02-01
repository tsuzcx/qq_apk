package com.tencent.mm.plugin.appbrand.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;

public final class b
{
  public static String TAG;
  private static Set<Integer> jEF;
  
  static
  {
    AppMethodBeat.i(222054);
    TAG = "MicroMsg.AppBrandAdABTests[AppBrandSplashAd]";
    HashSet localHashSet = new HashSet();
    jEF = localHashSet;
    localHashSet.add(Integer.valueOf(1001));
    jEF.add(Integer.valueOf(1089));
    jEF.add(Integer.valueOf(1104));
    jEF.add(Integer.valueOf(1103));
    AppMethodBeat.o(222054);
  }
  
  public static int aXG()
  {
    AppMethodBeat.i(222052);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qCQ, 0);
    ae.i(TAG, "getCodeBlockTimeThreshold, timeThreshold:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(222052);
    return i;
  }
  
  public static void aYq()
  {
    AppMethodBeat.i(44003);
    ay.aRW("appbrandAd").removeValueForKey("showad");
    AppMethodBeat.o(44003);
  }
  
  public static boolean aYr()
  {
    AppMethodBeat.i(44005);
    int i = ay.aRW("appbrandAd").decodeInt("showad", -1);
    if (i >= 0)
    {
      ae.i(TAG, "canShowAppBrandAd, command value:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(44005);
        return true;
      }
      AppMethodBeat.o(44005);
      return false;
    }
    i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qCJ, 0);
    ae.i(TAG, "canShowAppBrandAd, experiment value:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(44005);
      return true;
    }
    AppMethodBeat.o(44005);
    return false;
  }
  
  public static void aYs()
  {
    AppMethodBeat.i(44006);
    ay.aRW("appbrandAd").removeValueForKey("allshowad");
    AppMethodBeat.o(44006);
  }
  
  public static boolean aYt()
  {
    AppMethodBeat.i(44008);
    int i = ay.aRW("appbrandAd").decodeInt("allshowad", -1);
    if (i >= 0)
    {
      ae.i(TAG, "canAllShowAppBrandAd, command value:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(44008);
        return true;
      }
      AppMethodBeat.o(44008);
      return false;
    }
    i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qCK, 0);
    ae.i(TAG, "canAllShowAppBrandAd, experiment value:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(44008);
      return true;
    }
    AppMethodBeat.o(44008);
    return false;
  }
  
  public static int aYu()
  {
    AppMethodBeat.i(222053);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qCR, 0);
    ae.i(TAG, "getCheckBlockTimeThreshold, timeThreshold:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(222053);
    return i;
  }
  
  public static void rO(int paramInt)
  {
    AppMethodBeat.i(44004);
    ay.aRW("appbrandAd").encode("showad", paramInt);
    AppMethodBeat.o(44004);
  }
  
  public static void rP(int paramInt)
  {
    AppMethodBeat.i(44007);
    ay.aRW("appbrandAd").encode("allshowad", paramInt);
    AppMethodBeat.o(44007);
  }
  
  public static boolean rQ(int paramInt)
  {
    AppMethodBeat.i(222051);
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qCP, "");
    if (!bu.isNullOrNil((String)localObject)) {}
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
        ae.i(TAG, "checkSceneForShowAd, abtest set:%s, scene:%s", new Object[] { localHashSet, Integer.valueOf(paramInt) });
        bool = localHashSet.contains(Integer.valueOf(paramInt));
      }
      catch (Exception localException)
      {
        ae.i(TAG, "checkSceneForShowAd, exception, set:%s, scene:%s", new Object[] { jEF, Integer.valueOf(paramInt) });
        bool = jEF.contains(Integer.valueOf(paramInt));
        continue;
      }
      AppMethodBeat.o(222051);
      return bool;
      ae.i(TAG, "checkSceneForShowAd, no abtest, set:%s, scene:%s", new Object[] { jEF, Integer.valueOf(paramInt) });
      boolean bool = jEF.contains(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.b
 * JD-Core Version:    0.7.0.1
 */