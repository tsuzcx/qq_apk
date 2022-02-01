package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> ap(ca paramca)
  {
    long l = 0L;
    com.tencent.mm.pluginsdk.model.app.c localc2 = null;
    Object localObject2 = null;
    com.tencent.mm.pluginsdk.model.app.c localc1 = null;
    AppMethodBeat.i(22728);
    if (paramca == null)
    {
      AppMethodBeat.o(22728);
      return null;
    }
    Object localObject1 = Util.processXml(paramca.field_content);
    if (localObject1 != null) {}
    for (localObject1 = k.b.HD((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        Log.e("MicroMsg.AppMsgMsgHandler", "content is null");
        AppMethodBeat.o(22728);
        return null;
      }
      com.tencent.mm.plugin.f.b.a locala = aq(paramca);
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
        localc2 = ao.cgO().bdx(((k.b)localObject1).dCK);
        localObject1 = localc1;
        if (localc2 != null)
        {
          localObject1 = localc2.field_fileFullPath;
          l = s.boW((String)localObject1);
        }
        locala.field_msgSubType = 30;
        locala.field_path = bxb((String)localObject1);
        locala.field_size = l;
        i = 31;
      }
      for (;;)
      {
        localObject1 = q.bcR().R(paramca.field_imgPath, true);
        l = s.boW((String)localObject1);
        paramca = aq(paramca);
        paramca.field_msgSubType = i;
        paramca.field_path = bxb((String)localObject1);
        paramca.field_size = l;
        Log.i("MicroMsg.AppMsgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", new Object[] { info(), locala, paramca });
        localObject1 = new ArrayList();
        ((List)localObject1).add(locala);
        ((List)localObject1).add(paramca);
        AppMethodBeat.o(22728);
        return localObject1;
        localc1 = ao.cgO().bdx(((k.b)localObject1).dCK);
        localObject1 = localc2;
        if (localc1 != null)
        {
          localObject1 = localc1.field_fileFullPath;
          l = s.boW((String)localObject1);
        }
        locala.field_msgSubType = 32;
        locala.field_path = bxb((String)localObject1);
        locala.field_size = l;
        i = 33;
        continue;
        localc1 = ao.cgO().bdx(((k.b)localObject1).dCK);
        localObject1 = localObject2;
        if (localc1 != null)
        {
          localObject1 = localc1.field_fileFullPath;
          l = s.boW((String)localObject1);
        }
        locala.field_msgSubType = 34;
        locala.field_path = bxb((String)localObject1);
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