package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> af(bu parambu)
  {
    long l = 0L;
    com.tencent.mm.pluginsdk.model.app.c localc2 = null;
    Object localObject2 = null;
    com.tencent.mm.pluginsdk.model.app.c localc1 = null;
    AppMethodBeat.i(22728);
    if (parambu == null)
    {
      AppMethodBeat.o(22728);
      return null;
    }
    Object localObject1 = bt.aRd(parambu.field_content);
    if (localObject1 != null) {}
    for (localObject1 = k.b.yr((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        ad.e("MicroMsg.AppMsgMsgHandler", "content is null");
        AppMethodBeat.o(22728);
        return null;
      }
      com.tencent.mm.plugin.f.b.a locala = ag(parambu);
      int i;
      switch (((k.b)localObject1).type)
      {
      case 3: 
      case 4: 
      case 5: 
      default: 
        AppMethodBeat.o(22728);
        return null;
      case 2: 
        localc2 = ao.bIX().aLD(((k.b)localObject1).dks);
        localObject1 = localc1;
        if (localc2 != null)
        {
          localObject1 = localc2.field_fileFullPath;
          l = com.tencent.mm.vfs.i.aYo((String)localObject1);
        }
        locala.field_msgSubType = 30;
        locala.field_path = ahL((String)localObject1);
        locala.field_size = l;
        i = 31;
      }
      for (;;)
      {
        localObject1 = q.aIF().R(parambu.field_imgPath, true);
        l = com.tencent.mm.vfs.i.aYo((String)localObject1);
        parambu = ag(parambu);
        parambu.field_msgSubType = i;
        parambu.field_path = ahL((String)localObject1);
        parambu.field_size = l;
        ad.i("MicroMsg.AppMsgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", new Object[] { info(), locala, parambu });
        localObject1 = new ArrayList();
        ((List)localObject1).add(locala);
        ((List)localObject1).add(parambu);
        AppMethodBeat.o(22728);
        return localObject1;
        localc1 = ao.bIX().aLD(((k.b)localObject1).dks);
        localObject1 = localc2;
        if (localc1 != null)
        {
          localObject1 = localc1.field_fileFullPath;
          l = com.tencent.mm.vfs.i.aYo((String)localObject1);
        }
        locala.field_msgSubType = 32;
        locala.field_path = ahL((String)localObject1);
        locala.field_size = l;
        i = 33;
        continue;
        localc1 = ao.bIX().aLD(((k.b)localObject1).dks);
        localObject1 = localObject2;
        if (localc1 != null)
        {
          localObject1 = localc1.field_fileFullPath;
          l = com.tencent.mm.vfs.i.aYo((String)localObject1);
        }
        locala.field_msgSubType = 34;
        locala.field_path = ahL((String)localObject1);
        locala.field_size = l;
        i = 35;
      }
    }
  }
  
  protected final String info()
  {
    AppMethodBeat.i(22729);
    String str = "AppMsg_" + hashCode();
    AppMethodBeat.o(22729);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.c
 * JD-Core Version:    0.7.0.1
 */