package com.tencent.mm.plugin.appbrand.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;

public final class b
{
  public static String TAG;
  private static Set<Integer> qyZ;
  
  static
  {
    AppMethodBeat.i(321299);
    TAG = "MicroMsg.AppBrandAdABTests[AppBrandSplashAd]";
    HashSet localHashSet = new HashSet();
    qyZ = localHashSet;
    localHashSet.add(Integer.valueOf(1001));
    qyZ.add(Integer.valueOf(1089));
    qyZ.add(Integer.valueOf(1104));
    qyZ.add(Integer.valueOf(1103));
    AppMethodBeat.o(321299);
  }
  
  public static int ccV()
  {
    AppMethodBeat.i(321291);
    int i = ((c)h.ax(c.class)).a(c.a.yQn, 0);
    Log.i(TAG, "getCodeBlockTimeThreshold, timeThreshold:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(321291);
    return i;
  }
  
  public static void cdN()
  {
    AppMethodBeat.i(44003);
    MultiProcessMMKV.getMMKV("appbrandAd").removeValueForKey("showad");
    AppMethodBeat.o(44003);
  }
  
  public static boolean cdO()
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
    i = ((c)h.ax(c.class)).a(c.a.yQg, 0);
    Log.i(TAG, "canShowAppBrandAd, experiment value:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(44005);
      return true;
    }
    AppMethodBeat.o(44005);
    return false;
  }
  
  public static void cdP()
  {
    AppMethodBeat.i(44006);
    MultiProcessMMKV.getMMKV("appbrandAd").removeValueForKey("allshowad");
    AppMethodBeat.o(44006);
  }
  
  public static boolean cdQ()
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
    i = ((c)h.ax(c.class)).a(c.a.yQh, 0);
    Log.i(TAG, "canAllShowAppBrandAd, experiment value:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(44008);
      return true;
    }
    AppMethodBeat.o(44008);
    return false;
  }
  
  public static int cdR()
  {
    AppMethodBeat.i(321294);
    int i = ((c)h.ax(c.class)).a(c.a.yQo, 0);
    Log.i(TAG, "getCheckBlockTimeThreshold, timeThreshold:%d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(321294);
    return i;
  }
  
  public static void zd(int paramInt)
  {
    AppMethodBeat.i(44004);
    MultiProcessMMKV.getMMKV("appbrandAd").encode("showad", paramInt);
    AppMethodBeat.o(44004);
  }
  
  public static void ze(int paramInt)
  {
    AppMethodBeat.i(44007);
    MultiProcessMMKV.getMMKV("appbrandAd").encode("allshowad", paramInt);
    AppMethodBeat.o(44007);
  }
  
  public static boolean zf(int paramInt)
  {
    AppMethodBeat.i(321284);
    Object localObject = ((c)h.ax(c.class)).a(c.a.yQm, "");
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
        Log.i(TAG, "checkSceneForShowAd, exception, set:%s, scene:%s", new Object[] { qyZ, Integer.valueOf(paramInt) });
        bool = qyZ.contains(Integer.valueOf(paramInt));
        continue;
      }
      AppMethodBeat.o(321284);
      return bool;
      Log.i(TAG, "checkSceneForShowAd, no abtest, set:%s, scene:%s", new Object[] { qyZ, Integer.valueOf(paramInt) });
      boolean bool = qyZ.contains(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.b
 * JD-Core Version:    0.7.0.1
 */