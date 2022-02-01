package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.util.HashMap;

public final class c
{
  public static HashMap<String, Object> F(g paramg)
  {
    AppMethodBeat.i(230149);
    ank localank = paramg.field_favProto.SzE;
    anm localanm = b.c(paramg);
    Object localObject2 = String.format("file://%s", new Object[] { b.a(localanm) });
    Object localObject1 = localObject2;
    if (!u.agG((String)localObject2)) {
      localObject1 = String.format("file://%s", new Object[] { b.d(localanm) });
    }
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("desc", paramg.field_favProto.title);
    ((HashMap)localObject2).put("type", Integer.valueOf(2));
    ((HashMap)localObject2).put("title", paramg.field_favProto.title);
    ((HashMap)localObject2).put("app_id", localank.appId);
    ((HashMap)localObject2).put("pkg_type", Integer.valueOf(localank.fES));
    ((HashMap)localObject2).put("pkg_version", Integer.valueOf(localank.version));
    ((HashMap)localObject2).put("img_url", localObject1);
    ((HashMap)localObject2).put("is_dynamic", Boolean.FALSE);
    ((HashMap)localObject2).put("cache_key", "");
    ((HashMap)localObject2).put("path", localank.fve);
    ((HashMap)localObject2).put("subType", Integer.valueOf(localank.subType));
    Log.i("MicroMsg.FavAppBrandLogic", "buildAppBrandMsgParamsForIntent image path:%s", new Object[] { localObject1 });
    AppMethodBeat.o(230149);
    return localObject2;
  }
  
  public static boolean a(ank paramank)
  {
    if (paramank == null) {}
    while ((paramank.type != 3) && (paramank.otE != 1)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c
 * JD-Core Version:    0.7.0.1
 */