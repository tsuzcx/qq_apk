package com.tencent.mm.plugin.appbrand.appcache.b.e;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

public class e
  extends com.tencent.mm.plugin.appbrand.r.c<f>
{
  public static final String[] fkl;
  
  static
  {
    AppMethodBeat.i(129515);
    fkl = new String[] { j.getCreateSQLs(f.fkk, "PredownloadIssueLaunchWxaAppResponse") };
    AppMethodBeat.o(129515);
  }
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, f.fkk, "PredownloadIssueLaunchWxaAppResponse", f.INDEX_CREATE);
  }
  
  public final boolean a(byte[] paramArrayOfByte, String paramString, List<Integer> paramList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(129513);
    if ((bo.ce(paramArrayOfByte)) || (bo.isNullOrNil(paramString)))
    {
      ab.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, invalid input %s", new Object[] { paramString });
      AppMethodBeat.o(129513);
      return false;
    }
    if (bo.es(paramList))
    {
      ab.e("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, appId %s, empty sceneList", new Object[] { paramString });
      AppMethodBeat.o(129513);
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
    ab.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, appId %s, sceneList %d, setOk %b", new Object[] { paramString, Integer.valueOf(paramList.size()), Boolean.valueOf(bool1) });
    AppMethodBeat.o(129513);
    return bool1;
  }
  
  public final Pair<azn, Long> aA(String paramString, int paramInt)
  {
    AppMethodBeat.i(129514);
    try
    {
      long l = bo.aox();
      Object localObject = new f();
      ((f)localObject).field_appId = paramString;
      ((f)localObject).field_scene = paramInt;
      if (get((com.tencent.mm.sdk.e.c)localObject, new String[0]))
      {
        ab.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "found info with appId(%s) scene(%d), [%d, %d]", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(((f)localObject).field_startTime), Long.valueOf(((f)localObject).field_endTime) });
        if ((((f)localObject).field_startTime <= l) && (l <= ((f)localObject).field_endTime))
        {
          azn localazn = new azn();
          localazn.parseFrom(((f)localObject).field_launchProtoBlob);
          if (localazn.xoU.wKA.pW.length > 0)
          {
            localObject = Pair.create(localazn, Long.valueOf(((f)localObject).field_reportId));
            AppMethodBeat.o(129514);
            return localObject;
          }
          ab.e("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "found into with appId(%s) scene(%d), but jsapi_control_bytes invalid", new Object[] { paramString, Integer.valueOf(paramInt) });
        }
      }
      paramString = Pair.create(null, Long.valueOf(-1L));
      AppMethodBeat.o(129514);
      return paramString;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", localException, "get with appId(%s) scene(%d)", new Object[] { paramString, Integer.valueOf(paramInt) });
      paramString = Pair.create(null, Long.valueOf(-1L));
      AppMethodBeat.o(129514);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.e.e
 * JD-Core Version:    0.7.0.1
 */