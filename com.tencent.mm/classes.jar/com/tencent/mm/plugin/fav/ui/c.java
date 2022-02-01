package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.HashMap;

public final class c
{
  public static HashMap<String, Object> F(g paramg)
  {
    AppMethodBeat.i(235280);
    amj localamj = paramg.field_favProto.Lxf;
    aml localaml = b.c(paramg);
    Object localObject2 = String.format("file://%s", new Object[] { b.a(localaml) });
    Object localObject1 = localObject2;
    if (!s.YS((String)localObject2)) {
      localObject1 = String.format("file://%s", new Object[] { b.d(localaml) });
    }
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("desc", paramg.field_favProto.title);
    ((HashMap)localObject2).put("type", Integer.valueOf(2));
    ((HashMap)localObject2).put("title", paramg.field_favProto.title);
    ((HashMap)localObject2).put("app_id", localamj.appId);
    ((HashMap)localObject2).put("pkg_type", Integer.valueOf(localamj.dMe));
    ((HashMap)localObject2).put("pkg_version", Integer.valueOf(localamj.version));
    ((HashMap)localObject2).put("img_url", localObject1);
    ((HashMap)localObject2).put("is_dynamic", Boolean.FALSE);
    ((HashMap)localObject2).put("cache_key", "");
    ((HashMap)localObject2).put("path", localamj.dCx);
    ((HashMap)localObject2).put("subType", Integer.valueOf(localamj.subType));
    Log.i("MicroMsg.FavAppBrandLogic", "buildAppBrandMsgParamsForIntent image path:%s", new Object[] { localObject1 });
    AppMethodBeat.o(235280);
    return localObject2;
  }
  
  public static boolean a(amj paramamj)
  {
    if (paramamj == null) {}
    while ((paramamj.type != 3) && (paramamj.lyE != 1)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c
 * JD-Core Version:    0.7.0.1
 */