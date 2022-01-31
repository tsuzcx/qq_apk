package com.tencent.mm.plugin.appbrand.appcache.b.d;

import android.util.Pair;
import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.appbrand.t.c;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.protocal.c.pc;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

public class e
  extends c<f>
{
  public static final String[] dUb = { i.a(f.dUa, "PredownloadIssueLaunchWxaAppResponse") };
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, f.dUa, "PredownloadIssueLaunchWxaAppResponse", f.cqY);
  }
  
  public static void acw() {}
  
  public final boolean a(byte[] paramArrayOfByte, String paramString, List<Integer> paramList, long paramLong1, long paramLong2)
  {
    if ((bk.bE(paramArrayOfByte)) || (bk.bl(paramString)))
    {
      y.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, invalid input %s", new Object[] { paramString });
      return false;
    }
    if (bk.dk(paramList))
    {
      y.e("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, appId %s, empty sceneList", new Object[] { paramString });
      return false;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool1 = true;
    if (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      f localf = new f();
      localf.field_appId = paramString;
      localf.field_scene = i;
      boolean bool2 = b(localf, new String[0]);
      localf.field_launchProtoBlob = paramArrayOfByte;
      localf.field_startTime = paramLong1;
      localf.field_endTime = paramLong2;
      if (bool2) {}
      for (bool2 = c(localf, new String[0]);; bool2 = b(localf))
      {
        bool1 = bool2 & bool1;
        break;
      }
    }
    y.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, appId %s, sceneList %d, setOk %b", new Object[] { paramString, Integer.valueOf(paramList.size()), Boolean.valueOf(bool1) });
    return bool1;
  }
  
  public final Pair<ati, Long> an(String paramString, int paramInt)
  {
    try
    {
      long l = bk.UX();
      f localf = new f();
      localf.field_appId = paramString;
      localf.field_scene = paramInt;
      if (b(localf, new String[0]))
      {
        y.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "found info with appId(%s) scene(%d), [%d, %d]", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(localf.field_startTime), Long.valueOf(localf.field_endTime) });
        if ((localf.field_startTime <= l) && (l <= localf.field_endTime))
        {
          ati localati = new ati();
          localati.aH(localf.field_launchProtoBlob);
          if (localati.toW.sMN.oY.length > 0) {
            return Pair.create(localati, Long.valueOf(localf.field_reportId));
          }
          y.e("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "found into with appId(%s) scene(%d), but jsapi_control_bytes invalid", new Object[] { paramString, Integer.valueOf(paramInt) });
        }
      }
      return Pair.create(null, Long.valueOf(-1L));
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", localException, "get with appId(%s) scene(%d)", new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    return Pair.create(null, Long.valueOf(-1L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.d.e
 * JD-Core Version:    0.7.0.1
 */