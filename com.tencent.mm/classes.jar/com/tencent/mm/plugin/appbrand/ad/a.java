package com.tencent.mm.plugin.appbrand.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;

public final class a
{
  public static String TAG;
  private static Set<Integer> jis;
  
  static
  {
    AppMethodBeat.i(186281);
    TAG = "MicroMsg.AppBrandAdABTests";
    HashSet localHashSet = new HashSet();
    jis = localHashSet;
    localHashSet.add(Integer.valueOf(1001));
    jis.add(Integer.valueOf(1089));
    jis.add(Integer.valueOf(1104));
    jis.add(Integer.valueOf(1103));
    AppMethodBeat.o(186281);
  }
  
  public static void aUK()
  {
    AppMethodBeat.i(44003);
    aw.aKT("appbrandAd").removeValueForKey("showad");
    AppMethodBeat.o(44003);
  }
  
  public static boolean aUL()
  {
    AppMethodBeat.i(44005);
    int i = aw.aKT("appbrandAd").decodeInt("showad", -1);
    if (i >= 0)
    {
      ac.i(TAG, "canShowAppBrandAd, command value:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(44005);
        return true;
      }
      AppMethodBeat.o(44005);
      return false;
    }
    i = ((b)g.ab(b.class)).a(b.a.pRp, 0);
    ac.i(TAG, "canShowAppBrandAd, experiment value:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(44005);
      return true;
    }
    AppMethodBeat.o(44005);
    return false;
  }
  
  public static void aUM()
  {
    AppMethodBeat.i(44006);
    aw.aKT("appbrandAd").removeValueForKey("allshowad");
    AppMethodBeat.o(44006);
  }
  
  public static boolean aUN()
  {
    AppMethodBeat.i(44008);
    int i = aw.aKT("appbrandAd").decodeInt("allshowad", -1);
    if (i >= 0)
    {
      ac.i(TAG, "canAllShowAppBrandAd, command value:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(44008);
        return true;
      }
      AppMethodBeat.o(44008);
      return false;
    }
    i = ((b)g.ab(b.class)).a(b.a.pRq, 0);
    ac.i(TAG, "canAllShowAppBrandAd, experiment value:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(44008);
      return true;
    }
    AppMethodBeat.o(44008);
    return false;
  }
  
  public static void rk(int paramInt)
  {
    AppMethodBeat.i(44004);
    aw.aKT("appbrandAd").encode("showad", paramInt);
    AppMethodBeat.o(44004);
  }
  
  public static void rl(int paramInt)
  {
    AppMethodBeat.i(44007);
    aw.aKT("appbrandAd").encode("allshowad", paramInt);
    AppMethodBeat.o(44007);
  }
  
  public static boolean rm(int paramInt)
  {
    AppMethodBeat.i(186280);
    Object localObject = ((b)g.ab(b.class)).a(b.a.pRv, "");
    if (!bs.isNullOrNil((String)localObject)) {}
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
        ac.i(TAG, "checkSceneForShowAd, abtest set:%s, scene:%s", new Object[] { localHashSet, Integer.valueOf(paramInt) });
        bool = localHashSet.contains(Integer.valueOf(paramInt));
      }
      catch (Exception localException)
      {
        ac.i(TAG, "checkSceneForShowAd, exception, set:%s, scene:%s", new Object[] { jis, Integer.valueOf(paramInt) });
        bool = jis.contains(Integer.valueOf(paramInt));
        continue;
      }
      AppMethodBeat.o(186280);
      return bool;
      ac.i(TAG, "checkSceneForShowAd, no abtest, set:%s, scene:%s", new Object[] { jis, Integer.valueOf(paramInt) });
      boolean bool = jis.contains(Integer.valueOf(paramInt));
    }
  }
  
  public static int rn(int paramInt)
  {
    AppMethodBeat.i(163909);
    int i;
    if (paramInt > 0) {
      if (paramInt > 5) {
        i = ((b)g.ab(b.class)).a(b.a.pRt, 120);
      }
    }
    for (;;)
    {
      ac.i(TAG, "getCheckAdTimeThreshold, performanceValue:%s, timeThreshold:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(163909);
      return i;
      if (paramInt < 5) {
        i = ((b)g.ab(b.class)).a(b.a.pRu, 160);
      } else {
        i = ((b)g.ab(b.class)).a(b.a.pRs, 140);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a
 * JD-Core Version:    0.7.0.1
 */