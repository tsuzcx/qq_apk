package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.util.HashMap;

public final class b
{
  public static HashMap<String, Object> F(g paramg)
  {
    AppMethodBeat.i(274421);
    ard localard = paramg.field_favProto.ZAw;
    arf localarf = com.tencent.mm.plugin.fav.a.b.c(paramg);
    Object localObject2 = String.format("file://%s", new Object[] { com.tencent.mm.plugin.fav.a.b.a(localarf) });
    Object localObject1 = localObject2;
    if (!y.ZC((String)localObject2)) {
      localObject1 = String.format("file://%s", new Object[] { com.tencent.mm.plugin.fav.a.b.d(localarf) });
    }
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("desc", paramg.field_favProto.title);
    ((HashMap)localObject2).put("type", Integer.valueOf(2));
    ((HashMap)localObject2).put("title", paramg.field_favProto.title);
    ((HashMap)localObject2).put("app_id", localard.appId);
    ((HashMap)localObject2).put("pkg_type", Integer.valueOf(localard.hJK));
    ((HashMap)localObject2).put("pkg_version", Integer.valueOf(localard.version));
    ((HashMap)localObject2).put("img_url", localObject1);
    ((HashMap)localObject2).put("is_dynamic", Boolean.FALSE);
    ((HashMap)localObject2).put("cache_key", "");
    ((HashMap)localObject2).put("path", localard.hzy);
    ((HashMap)localObject2).put("subType", Integer.valueOf(localard.subType));
    Log.i("MicroMsg.FavAppBrandLogic", "buildAppBrandMsgParamsForIntent image path:%s", new Object[] { localObject1 });
    AppMethodBeat.o(274421);
    return localObject2;
  }
  
  public static boolean a(ard paramard)
  {
    if (paramard == null) {}
    while ((paramard.type != 3) && (paramard.rxs != 1)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b
 * JD-Core Version:    0.7.0.1
 */