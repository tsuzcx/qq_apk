package com.tencent.mm.plugin.appbrand.appcache.predownload.e;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.appbrand.ab.c;
import com.tencent.mm.protocal.protobuf.cqa;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.List;

public class e
  extends c<f>
{
  public static final String[] lqL;
  
  static
  {
    AppMethodBeat.i(44442);
    lqL = new String[] { MAutoStorage.getCreateSQLs(f.lqK, "PredownloadIssueLaunchWxaAppResponse") };
    AppMethodBeat.o(44442);
  }
  
  public e(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, f.lqK, "PredownloadIssueLaunchWxaAppResponse", f.INDEX_CREATE);
  }
  
  public final boolean a(byte[] paramArrayOfByte, String paramString, List<Integer> paramList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(44440);
    if ((Util.isNullOrNil(paramArrayOfByte)) || (Util.isNullOrNil(paramString)))
    {
      Log.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, invalid input %s", new Object[] { paramString });
      AppMethodBeat.o(44440);
      return false;
    }
    if (Util.isNullOrNil(paramList))
    {
      Log.e("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, appId %s, empty sceneList", new Object[] { paramString });
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
    Log.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, appId %s, sceneList %d, setOk %b", new Object[] { paramString, Integer.valueOf(paramList.size()), Boolean.valueOf(bool1) });
    AppMethodBeat.o(44440);
    return bool1;
  }
  
  public final Pair<cqa, Long> bw(String paramString, int paramInt)
  {
    AppMethodBeat.i(44441);
    try
    {
      long l = Util.nowSecond();
      Object localObject = new f();
      ((f)localObject).field_appId = paramString;
      ((f)localObject).field_scene = paramInt;
      if (get((IAutoDBItem)localObject, new String[0]))
      {
        Log.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "found info with appId(%s) scene(%d), [%d, %d]", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(((f)localObject).field_startTime), Long.valueOf(((f)localObject).field_endTime) });
        if ((((f)localObject).field_startTime <= l) && (l <= ((f)localObject).field_endTime))
        {
          cqa localcqa = new cqa();
          localcqa.parseFrom(((f)localObject).field_launchProtoBlob);
          if (localcqa.Txv.SkZ.UH.length > 0)
          {
            localObject = Pair.create(localcqa, Long.valueOf(((f)localObject).field_reportId));
            AppMethodBeat.o(44441);
            return localObject;
          }
          Log.e("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "found into with appId(%s) scene(%d), but jsapi_control_bytes invalid", new Object[] { paramString, Integer.valueOf(paramInt) });
        }
      }
      paramString = Pair.create(null, Long.valueOf(-1L));
      AppMethodBeat.o(44441);
      return paramString;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", localException, "get with appId(%s) scene(%d)", new Object[] { paramString, Integer.valueOf(paramInt) });
      paramString = Pair.create(null, Long.valueOf(-1L));
      AppMethodBeat.o(44441);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.e.e
 * JD-Core Version:    0.7.0.1
 */