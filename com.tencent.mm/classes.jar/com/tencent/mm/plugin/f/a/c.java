package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.g;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.du;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> ac(bl parambl)
  {
    long l = 0L;
    com.tencent.mm.pluginsdk.model.app.c localc2 = null;
    Object localObject2 = null;
    com.tencent.mm.pluginsdk.model.app.c localc1 = null;
    AppMethodBeat.i(22728);
    if (parambl == null)
    {
      AppMethodBeat.o(22728);
      return null;
    }
    Object localObject1 = bt.aGg(parambl.field_content);
    if (localObject1 != null) {}
    for (localObject1 = k.b.rx((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        ad.e("MicroMsg.AppMsgMsgHandler", "content is null");
        AppMethodBeat.o(22728);
        return null;
      }
      com.tencent.mm.plugin.f.b.a locala = ad(parambl);
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
        localc2 = ap.bxS().aAL(((k.b)localObject1).dbA);
        localObject1 = localc1;
        if (localc2 != null)
        {
          localObject1 = localc2.field_fileFullPath;
          l = i.aMN((String)localObject1);
        }
        locala.field_msgSubType = 30;
        locala.field_path = aUM((String)localObject1);
        locala.field_size = l;
        i = 31;
      }
      for (;;)
      {
        localObject1 = o.ayF().Q(parambl.field_imgPath, true);
        l = i.aMN((String)localObject1);
        parambl = ad(parambl);
        parambl.field_msgSubType = i;
        parambl.field_path = aUM((String)localObject1);
        parambl.field_size = l;
        ad.i("MicroMsg.AppMsgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", new Object[] { info(), locala, parambl });
        localObject1 = new ArrayList();
        ((List)localObject1).add(locala);
        ((List)localObject1).add(parambl);
        AppMethodBeat.o(22728);
        return localObject1;
        localc1 = ap.bxS().aAL(((k.b)localObject1).dbA);
        localObject1 = localc2;
        if (localc1 != null)
        {
          localObject1 = localc1.field_fileFullPath;
          l = i.aMN((String)localObject1);
        }
        locala.field_msgSubType = 32;
        locala.field_path = aUM((String)localObject1);
        locala.field_size = l;
        i = 33;
        continue;
        localc1 = ap.bxS().aAL(((k.b)localObject1).dbA);
        localObject1 = localObject2;
        if (localc1 != null)
        {
          localObject1 = localc1.field_fileFullPath;
          l = i.aMN((String)localObject1);
        }
        locala.field_msgSubType = 34;
        locala.field_path = aUM((String)localObject1);
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