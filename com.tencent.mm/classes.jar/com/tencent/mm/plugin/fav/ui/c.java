package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import java.util.HashMap;

public final class c
{
  public static HashMap<String, Object> F(g paramg)
  {
    AppMethodBeat.i(218773);
    ajl localajl = paramg.field_favProto.GiJ;
    ajn localajn = b.c(paramg);
    Object localObject2 = String.format("file://%s", new Object[] { b.a(localajn) });
    Object localObject1 = localObject2;
    if (!i.fv((String)localObject2)) {
      localObject1 = String.format("file://%s", new Object[] { b.d(localajn) });
    }
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("desc", paramg.field_favProto.title);
    ((HashMap)localObject2).put("type", Integer.valueOf(2));
    ((HashMap)localObject2).put("title", paramg.field_favProto.title);
    ((HashMap)localObject2).put("app_id", localajl.appId);
    ((HashMap)localObject2).put("pkg_type", Integer.valueOf(localajl.dtF));
    ((HashMap)localObject2).put("pkg_version", Integer.valueOf(localajl.version));
    ((HashMap)localObject2).put("img_url", localObject1);
    ((HashMap)localObject2).put("is_dynamic", Boolean.FALSE);
    ((HashMap)localObject2).put("cache_key", "");
    ((HashMap)localObject2).put("path", localajl.dki);
    ((HashMap)localObject2).put("subType", Integer.valueOf(localajl.subType));
    ad.i("MicroMsg.FavAppBrandLogic", "buildAppBrandMsgParamsForIntent image path:%s", new Object[] { localObject1 });
    AppMethodBeat.o(218773);
    return localObject2;
  }
  
  public static boolean a(ajl paramajl)
  {
    if (paramajl == null) {}
    while ((paramajl.type != 3) && (paramajl.kro != 1)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c
 * JD-Core Version:    0.7.0.1
 */