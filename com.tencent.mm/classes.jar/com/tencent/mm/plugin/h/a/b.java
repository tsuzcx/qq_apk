package com.tencent.mm.plugin.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.c.et;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends a
{
  protected final List<com.tencent.mm.plugin.h.b.a> ax(ca paramca)
  {
    Object localObject2 = null;
    AppMethodBeat.i(22726);
    if (paramca == null)
    {
      AppMethodBeat.o(22726);
      return null;
    }
    Object localObject1 = Util.processXml(paramca.field_content);
    if (localObject1 != null) {}
    for (localObject1 = k.b.OQ((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        Log.e("MicroMsg.AppMsgImgMsgHandler", "content is null");
        AppMethodBeat.o(22726);
        return null;
      }
      com.tencent.mm.plugin.h.b.a locala = ay(paramca);
      c localc = ao.ctZ().bpR(((k.b)localObject1).fvr);
      long l = 0L;
      localObject1 = localObject2;
      if (localc != null)
      {
        localObject1 = localc.field_fileFullPath;
        l = u.bBQ((String)localObject1);
      }
      locala.field_msgSubType = 30;
      locala.field_path = bAT((String)localObject1);
      locala.field_size = l;
      localObject1 = q.bmh().T(paramca.field_imgPath, true);
      l = u.bBQ((String)localObject1);
      paramca = ay(paramca);
      paramca.field_msgSubType = 31;
      paramca.field_path = bAT((String)localObject1);
      paramca.field_size = l;
      Log.i("MicroMsg.AppMsgImgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", new Object[] { info(), locala, paramca });
      localObject1 = new ArrayList();
      ((List)localObject1).add(locala);
      ((List)localObject1).add(paramca);
      AppMethodBeat.o(22726);
      return localObject1;
    }
  }
  
  protected final String info()
  {
    AppMethodBeat.i(22727);
    String str = "AppMsgImg_" + hashCode();
    AppMethodBeat.o(22727);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.h.a.b
 * JD-Core Version:    0.7.0.1
 */