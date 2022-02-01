package com.tencent.mm.plugin.appbrand.appcache.b.e;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.protocal.protobuf.xi;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.List;

public class e
  extends com.tencent.mm.plugin.appbrand.x.c<f>
{
  public static final String[] hGX;
  
  static
  {
    AppMethodBeat.i(44442);
    hGX = new String[] { j.getCreateSQLs(f.hGW, "PredownloadIssueLaunchWxaAppResponse") };
    AppMethodBeat.o(44442);
  }
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, f.hGW, "PredownloadIssueLaunchWxaAppResponse", f.INDEX_CREATE);
  }
  
  public final boolean a(byte[] paramArrayOfByte, String paramString, List<Integer> paramList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(44440);
    if ((bu.cF(paramArrayOfByte)) || (bu.isNullOrNil(paramString)))
    {
      ae.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, invalid input %s", new Object[] { paramString });
      AppMethodBeat.o(44440);
      return false;
    }
    if (bu.ht(paramList))
    {
      ae.e("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, appId %s, empty sceneList", new Object[] { paramString });
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
    ae.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, appId %s, sceneList %d, setOk %b", new Object[] { paramString, Integer.valueOf(paramList.size()), Boolean.valueOf(bool1) });
    AppMethodBeat.o(44440);
    return bool1;
  }
  
  public final Pair<bua, Long> aY(String paramString, int paramInt)
  {
    AppMethodBeat.i(44441);
    try
    {
      long l = bu.aRi();
      Object localObject = new f();
      ((f)localObject).field_appId = paramString;
      ((f)localObject).field_scene = paramInt;
      if (get((com.tencent.mm.sdk.e.c)localObject, new String[0]))
      {
        ae.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "found info with appId(%s) scene(%d), [%d, %d]", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(((f)localObject).field_startTime), Long.valueOf(((f)localObject).field_endTime) });
        if ((((f)localObject).field_startTime <= l) && (l <= ((f)localObject).field_endTime))
        {
          bua localbua = new bua();
          localbua.parseFrom(((f)localObject).field_launchProtoBlob);
          if (localbua.Hhk.Gph.zr.length > 0)
          {
            localObject = Pair.create(localbua, Long.valueOf(((f)localObject).field_reportId));
            AppMethodBeat.o(44441);
            return localObject;
          }
          ae.e("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "found into with appId(%s) scene(%d), but jsapi_control_bytes invalid", new Object[] { paramString, Integer.valueOf(paramInt) });
        }
      }
      paramString = Pair.create(null, Long.valueOf(-1L));
      AppMethodBeat.o(44441);
      return paramString;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", localException, "get with appId(%s) scene(%d)", new Object[] { paramString, Integer.valueOf(paramInt) });
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