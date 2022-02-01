package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> ap(ca paramca)
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
    for (localObject1 = k.b.HD((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        Log.e("MicroMsg.AppMsgImgMsgHandler", "content is null");
        AppMethodBeat.o(22726);
        return null;
      }
      com.tencent.mm.plugin.f.b.a locala = aq(paramca);
      c localc = ao.cgO().bdx(((k.b)localObject1).dCK);
      long l = 0L;
      localObject1 = localObject2;
      if (localc != null)
      {
        localObject1 = localc.field_fileFullPath;
        l = s.boW((String)localObject1);
      }
      locala.field_msgSubType = 30;
      locala.field_path = bxb((String)localObject1);
      locala.field_size = l;
      localObject1 = q.bcR().R(paramca.field_imgPath, true);
      l = s.boW((String)localObject1);
      paramca = aq(paramca);
      paramca.field_msgSubType = 31;
      paramca.field_path = bxb((String)localObject1);
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
 * Qualified Name:     com.tencent.mm.plugin.f.a.b
 * JD-Core Version:    0.7.0.1
 */