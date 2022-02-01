package com.tencent.mm.plugin.appbrand.appcache.b.e;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.btg;
import com.tencent.mm.protocal.protobuf.xf;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.List;

public class e
  extends com.tencent.mm.plugin.appbrand.y.c<f>
{
  public static final String[] hEf;
  
  static
  {
    AppMethodBeat.i(44442);
    hEf = new String[] { j.getCreateSQLs(f.hEe, "PredownloadIssueLaunchWxaAppResponse") };
    AppMethodBeat.o(44442);
  }
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, f.hEe, "PredownloadIssueLaunchWxaAppResponse", f.INDEX_CREATE);
  }
  
  public final boolean a(byte[] paramArrayOfByte, String paramString, List<Integer> paramList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(44440);
    if ((bt.cC(paramArrayOfByte)) || (bt.isNullOrNil(paramString)))
    {
      ad.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, invalid input %s", new Object[] { paramString });
      AppMethodBeat.o(44440);
      return false;
    }
    if (bt.hj(paramList))
    {
      ad.e("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, appId %s, empty sceneList", new Object[] { paramString });
      AppMethodBeat.o(44440);
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
      boolean bool2 = get(localf, new String[0]);
      localf.field_launchProtoBlob = paramArrayOfByte;
      localf.field_startTime = paramLong1;
      localf.field_endTime = paramLong2;
      if (bool2) {}
      for (bool2 = update(localf, new String[0]);; bool2 = insert(localf))
      {
        bool1 = bool2 & bool1;
        break;
      }
    }
    ad.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, appId %s, sceneList %d, setOk %b", new Object[] { paramString, Integer.valueOf(paramList.size()), Boolean.valueOf(bool1) });
    AppMethodBeat.o(44440);
    return bool1;
  }
  
  public final Pair<btg, Long> aV(String paramString, int paramInt)
  {
    AppMethodBeat.i(44441);
    try
    {
      long l = bt.aQJ();
      Object localObject = new f();
      ((f)localObject).field_appId = paramString;
      ((f)localObject).field_scene = paramInt;
      if (get((com.tencent.mm.sdk.e.c)localObject, new String[0]))
      {
        ad.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "found info with appId(%s) scene(%d), [%d, %d]", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(((f)localObject).field_startTime), Long.valueOf(((f)localObject).field_endTime) });
        if ((((f)localObject).field_startTime <= l) && (l <= ((f)localObject).field_endTime))
        {
          btg localbtg = new btg();
          localbtg.parseFrom(((f)localObject).field_launchProtoBlob);
          if (localbtg.GNK.FWI.zr.length > 0)
          {
            localObject = Pair.create(localbtg, Long.valueOf(((f)localObject).field_reportId));
            AppMethodBeat.o(44441);
            return localObject;
          }
          ad.e("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "found into with appId(%s) scene(%d), but jsapi_control_bytes invalid", new Object[] { paramString, Integer.valueOf(paramInt) });
        }
      }
      paramString = Pair.create(null, Long.valueOf(-1L));
      AppMethodBeat.o(44441);
      return paramString;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", localException, "get with appId(%s) scene(%d)", new Object[] { paramString, Integer.valueOf(paramInt) });
      paramString = Pair.create(null, Long.valueOf(-1L));
      AppMethodBeat.o(44441);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.e.e
 * JD-Core Version:    0.7.0.1
 */