package com.tencent.mm.plugin.appbrand.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;

public final class a
{
  public static String TAG;
  private static Set<Integer> iIo;
  
  static
  {
    AppMethodBeat.i(195581);
    TAG = "MicroMsg.AppBrandAdABTests";
    HashSet localHashSet = new HashSet();
    iIo = localHashSet;
    localHashSet.add(Integer.valueOf(1001));
    iIo.add(Integer.valueOf(1089));
    iIo.add(Integer.valueOf(1104));
    iIo.add(Integer.valueOf(1103));
    AppMethodBeat.o(195581);
  }
  
  public static void aNU()
  {
    AppMethodBeat.i(44003);
    ax.aFC("appbrandAd").removeValueForKey("showad");
    AppMethodBeat.o(44003);
  }
  
  public static boolean aNV()
  {
    AppMethodBeat.i(44005);
    int i = ax.aFC("appbrandAd").decodeInt("showad", -1);
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
    i = ((b)g.ab(b.class)).a(b.a.pnP, 0);
    ad.i(TAG, "canShowAppBrandAd, experiment value:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(44005);
      return true;
    }
    AppMethodBeat.o(44005);
    return false;
  }
  
  public static void aNW()
  {
    AppMethodBeat.i(44006);
    ax.aFC("appbrandAd").removeValueForKey("allshowad");
    AppMethodBeat.o(44006);
  }
  
  public static boolean aNX()
  {
    AppMethodBeat.i(44008);
    int i = ax.aFC("appbrandAd").decodeInt("allshowad", -1);
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
    i = ((b)g.ab(b.class)).a(b.a.pnQ, 0);
    ad.i(TAG, "canAllShowAppBrandAd, experiment value:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(44008);
      return true;
    }
    AppMethodBeat.o(44008);
    return false;
  }
  
  public static int qA(int paramInt)
  {
    AppMethodBeat.i(163909);
    int i;
    if (paramInt > 0) {
      if (paramInt > 5) {
        i = ((b)g.ab(b.class)).a(b.a.pnT, 120);
      }
    }
    for (;;)
    {
      ad.i(TAG, "getCheckAdTimeThreshold, performanceValue:%s, timeThreshold:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(163909);
      return i;
      if (paramInt < 5) {
        i = ((b)g.ab(b.class)).a(b.a.pnU, 160);
      } else {
        i = ((b)g.ab(b.class)).a(b.a.pnS, 140);
      }
    }
  }
  
  public static void qx(int paramInt)
  {
    AppMethodBeat.i(44004);
    ax.aFC("appbrandAd").encode("showad", paramInt);
    AppMethodBeat.o(44004);
  }
  
  public static void qy(int paramInt)
  {
    AppMethodBeat.i(44007);
    ax.aFC("appbrandAd").encode("allshowad", paramInt);
    AppMethodBeat.o(44007);
  }
  
  public static boolean qz(int paramInt)
  {
    AppMethodBeat.i(195580);
    Object localObject = ((b)g.ab(b.class)).a(b.a.pnV, "");
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
        ad.i(TAG, "checkSceneForShowAd, exception, set:%s, scene:%s", new Object[] { iIo, Integer.valueOf(paramInt) });
        bool = iIo.contains(Integer.valueOf(paramInt));
        continue;
      }
      AppMethodBeat.o(195580);
      return bool;
      ad.i(TAG, "checkSceneForShowAd, no abtest, set:%s, scene:%s", new Object[] { iIo, Integer.valueOf(paramInt) });
      boolean bool = iIo.contains(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a
 * JD-Core Version:    0.7.0.1
 */