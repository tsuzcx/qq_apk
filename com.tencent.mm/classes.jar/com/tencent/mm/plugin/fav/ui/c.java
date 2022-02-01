package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import java.util.HashMap;

public final class c
{
  public static HashMap<String, Object> F(g paramg)
  {
    AppMethodBeat.i(191048);
    ajv localajv = paramg.field_favProto.GBs;
    ajx localajx = b.c(paramg);
    Object localObject2 = String.format("file://%s", new Object[] { b.a(localajx) });
    Object localObject1 = localObject2;
    if (!o.fB((String)localObject2)) {
      localObject1 = String.format("file://%s", new Object[] { b.d(localajx) });
    }
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("desc", paramg.field_favProto.title);
    ((HashMap)localObject2).put("type", Integer.valueOf(2));
    ((HashMap)localObject2).put("title", paramg.field_favProto.title);
    ((HashMap)localObject2).put("app_id", localajv.appId);
    ((HashMap)localObject2).put("pkg_type", Integer.valueOf(localajv.duK));
    ((HashMap)localObject2).put("pkg_version", Integer.valueOf(localajv.version));
    ((HashMap)localObject2).put("img_url", localObject1);
    ((HashMap)localObject2).put("is_dynamic", Boolean.FALSE);
    ((HashMap)localObject2).put("cache_key", "");
    ((HashMap)localObject2).put("path", localajv.dlk);
    ((HashMap)localObject2).put("subType", Integer.valueOf(localajv.subType));
    ae.i("MicroMsg.FavAppBrandLogic", "buildAppBrandMsgParamsForIntent image path:%s", new Object[] { localObject1 });
    AppMethodBeat.o(191048);
    return localObject2;
  }
  
  public static boolean a(ajv paramajv)
  {
    if (paramajv == null) {}
    while ((paramajv.type != 3) && (paramajv.kuE != 1)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c
 * JD-Core Version:    0.7.0.1
 */