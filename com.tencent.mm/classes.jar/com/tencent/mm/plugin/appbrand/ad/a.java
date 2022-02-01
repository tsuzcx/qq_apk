package com.tencent.mm.plugin.appbrand.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;

public final class a
{
  public static String TAG;
  private static Set<Integer> jBI;
  
  static
  {
    AppMethodBeat.i(187944);
    TAG = "MicroMsg.AppBrandAdABTests[AppBrandSplashAd]";
    HashSet localHashSet = new HashSet();
    jBI = localHashSet;
    localHashSet.add(Integer.valueOf(1001));
    jBI.add(Integer.valueOf(1089));
    jBI.add(Integer.valueOf(1104));
    jBI.add(Integer.valueOf(1103));
    AppMethodBeat.o(187944);
  }
  
  public static void aXW()
  {
    AppMethodBeat.i(44003);
    ax.aQz("appbrandAd").removeValueForKey("showad");
    AppMethodBeat.o(44003);
  }
  
  public static boolean aXX()
  {
    AppMethodBeat.i(44005);
    int i = ax.aQz("appbrandAd").decodeInt("showad", -1);
    if (i >= 0)
    {
      ad.i(TAG, "canShowAppBrandAd, command value:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(44005);
        return true;
      }
      AppMethodBeat.o(44005);
      return false;
    }
    i = ((b)g.ab(b.class)).a(b.a.qvK, 0);
    ad.i(TAG, "canShowAppBrandAd, experiment value:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(44005);
      return true;
    }
    AppMethodBeat.o(44005);
    return false;
  }
  
  public static void aXY()
  {
    AppMethodBeat.i(44006);
    ax.aQz("appbrandAd").removeValueForKey("allshowad");
    AppMethodBeat.o(44006);
  }
  
  public static boolean aXZ()
  {
    AppMethodBeat.i(44008);
    int i = ax.aQz("appbrandAd").decodeInt("allshowad", -1);
    if (i >= 0)
    {
      ad.i(TAG, "canAllShowAppBrandAd, command value:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(44008);
        return true;
      }
      AppMethodBeat.o(44008);
      return false;
    }
    i = ((b)g.ab(b.class)).a(b.a.qvL, 0);
    ad.i(TAG, "canAllShowAppBrandAd, experiment value:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(44008);
      return true;
    }
    AppMethodBeat.o(44008);
    return false;
  }
  
  public static int aXl()
  {
    AppMethodBeat.i(187942);
    int i = ((b)g.ab(b.class)).a(b.a.qvR, 0);
    ad.i(TAG, "getCodeBlockTimeThreshold, timeThreshold:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(187942);
    return i;
  }
  
  public static int aYa()
  {
    AppMethodBeat.i(187943);
    int i = ((b)g.ab(b.class)).a(b.a.qvS, 0);
    ad.i(TAG, "getCheckBlockTimeThreshold, timeThreshold:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(187943);
    return i;
  }
  
  public static void rL(int paramInt)
  {
    AppMethodBeat.i(44004);
    ax.aQz("appbrandAd").encode("showad", paramInt);
    AppMethodBeat.o(44004);
  }
  
  public static void rM(int paramInt)
  {
    AppMethodBeat.i(44007);
    ax.aQz("appbrandAd").encode("allshowad", paramInt);
    AppMethodBeat.o(44007);
  }
  
  public static boolean rN(int paramInt)
  {
    AppMethodBeat.i(187941);
    Object localObject = ((b)g.ab(b.class)).a(b.a.qvQ, "");
    if (!bt.isNullOrNil((String)localObject)) {}
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
        ad.i(TAG, "checkSceneForShowAd, abtest set:%s, scene:%s", new Object[] { localHashSet, Integer.valueOf(paramInt) });
        bool = localHashSet.contains(Integer.valueOf(paramInt));
      }
      catch (Exception localException)
      {
        ad.i(TAG, "checkSceneForShowAd, exception, set:%s, scene:%s", new Object[] { jBI, Integer.valueOf(paramInt) });
        bool = jBI.contains(Integer.valueOf(paramInt));
        continue;
      }
      AppMethodBeat.o(187941);
      return bool;
      ad.i(TAG, "checkSceneForShowAd, no abtest, set:%s, scene:%s", new Object[] { jBI, Integer.valueOf(paramInt) });
      boolean bool = jBI.contains(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a
 * JD-Core Version:    0.7.0.1
 */