package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> af(bu parambu)
  {
    Object localObject2 = null;
    AppMethodBeat.i(22726);
    if (parambu == null)
    {
      AppMethodBeat.o(22726);
      return null;
    }
    Object localObject1 = bt.aRd(parambu.field_content);
    if (localObject1 != null) {}
    for (localObject1 = k.b.yr((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        ad.e("MicroMsg.AppMsgImgMsgHandler", "content is null");
        AppMethodBeat.o(22726);
        return null;
      }
      com.tencent.mm.plugin.f.b.a locala = ag(parambu);
      c localc = ao.bIX().aLD(((k.b)localObject1).dks);
      long l = 0L;
      localObject1 = localObject2;
      if (localc != null)
      {
        localObject1 = localc.field_fileFullPath;
        l = com.tencent.mm.vfs.i.aYo((String)localObject1);
      }
      locala.field_msgSubType = 30;
      locala.field_path = ahL((String)localObject1);
      locala.field_size = l;
      localObject1 = q.aIF().R(parambu.field_imgPath, true);
      l = com.tencent.mm.vfs.i.aYo((String)localObject1);
      parambu = ag(parambu);
      parambu.field_msgSubType = 31;
      parambu.field_path = ahL((String)localObject1);
      parambu.field_size = l;
      ad.i("MicroMsg.AppMsgImgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", new Object[] { info(), locala, parambu });
      localObject1 = new ArrayList();
      ((List)localObject1).add(locala);
      ((List)localObject1).add(parambu);
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