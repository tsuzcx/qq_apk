package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import java.util.HashMap;

public final class c
{
  public static HashMap<String, Object> F(g paramg)
  {
    AppMethodBeat.i(186912);
    afw localafw = paramg.field_favProto.DhR;
    afy localafy = b.c(paramg);
    Object localObject2 = String.format("file://%s", new Object[] { b.a(localafy) });
    Object localObject1 = localObject2;
    if (!i.eK((String)localObject2)) {
      localObject1 = String.format("file://%s", new Object[] { b.d(localafy) });
    }
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("desc", paramg.field_favProto.title);
    ((HashMap)localObject2).put("type", Integer.valueOf(2));
    ((HashMap)localObject2).put("title", paramg.field_favProto.title);
    ((HashMap)localObject2).put("app_id", localafw.appId);
    ((HashMap)localObject2).put("pkg_type", Integer.valueOf(localafw.dkC));
    ((HashMap)localObject2).put("pkg_version", Integer.valueOf(localafw.version));
    ((HashMap)localObject2).put("img_url", localObject1);
    ((HashMap)localObject2).put("is_dynamic", Boolean.FALSE);
    ((HashMap)localObject2).put("cache_key", "");
    ((HashMap)localObject2).put("path", localafw.dbu);
    ((HashMap)localObject2).put("subType", Integer.valueOf(localafw.subType));
    ad.i("MicroMsg.FavAppBrandLogic", "buildAppBrandMsgParamsForIntent image path:%s", new Object[] { localObject1 });
    AppMethodBeat.o(186912);
    return localObject2;
  }
  
  public static boolean a(afw paramafw)
  {
    if (paramafw == null) {}
    while ((paramafw.type != 3) && (paramafw.jwB != 1)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c
 * JD-Core Version:    0.7.0.1
 */