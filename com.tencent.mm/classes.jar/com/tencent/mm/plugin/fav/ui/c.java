package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import java.util.HashMap;

public final class c
{
  public static HashMap<String, Object> F(g paramg)
  {
    AppMethodBeat.i(209479);
    agv localagv = paramg.field_favProto.EAX;
    agx localagx = b.c(paramg);
    Object localObject2 = String.format("file://%s", new Object[] { b.a(localagx) });
    Object localObject1 = localObject2;
    if (!i.eA((String)localObject2)) {
      localObject1 = String.format("file://%s", new Object[] { b.d(localagx) });
    }
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("desc", paramg.field_favProto.title);
    ((HashMap)localObject2).put("type", Integer.valueOf(2));
    ((HashMap)localObject2).put("title", paramg.field_favProto.title);
    ((HashMap)localObject2).put("app_id", localagv.appId);
    ((HashMap)localObject2).put("pkg_type", Integer.valueOf(localagv.dib));
    ((HashMap)localObject2).put("pkg_version", Integer.valueOf(localagv.version));
    ((HashMap)localObject2).put("img_url", localObject1);
    ((HashMap)localObject2).put("is_dynamic", Boolean.FALSE);
    ((HashMap)localObject2).put("cache_key", "");
    ((HashMap)localObject2).put("path", localagv.cYQ);
    ((HashMap)localObject2).put("subType", Integer.valueOf(localagv.subType));
    ac.i("MicroMsg.FavAppBrandLogic", "buildAppBrandMsgParamsForIntent image path:%s", new Object[] { localObject1 });
    AppMethodBeat.o(209479);
    return localObject2;
  }
  
  public static boolean a(agv paramagv)
  {
    if (paramagv == null) {}
    while ((paramagv.type != 3) && (paramagv.jWX != 1)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c
 * JD-Core Version:    0.7.0.1
 */