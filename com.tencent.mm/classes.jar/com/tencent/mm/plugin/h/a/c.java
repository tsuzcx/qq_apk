package com.tencent.mm.plugin.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.c.et;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends a
{
  protected final List<com.tencent.mm.plugin.h.b.a> ax(ca paramca)
  {
    long l = 0L;
    com.tencent.mm.plugin.h.b.a locala = null;
    Object localObject2 = null;
    com.tencent.mm.pluginsdk.model.app.c localc = null;
    Object localObject3 = null;
    Object localObject4 = null;
    AppMethodBeat.i(22728);
    if (paramca == null)
    {
      AppMethodBeat.o(22728);
      return null;
    }
    Object localObject1 = Util.processXml(paramca.field_content);
    if (localObject1 != null) {}
    for (localObject1 = k.b.OQ((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        Log.e("MicroMsg.AppMsgMsgHandler", "content is null");
        AppMethodBeat.o(22728);
        return null;
      }
      int i;
      switch (((k.b)localObject1).type)
      {
      case 3: 
      case 4: 
      case 5: 
      default: 
        if (!Util.isNullOrNil(paramca.field_imgPath))
        {
          i = 38;
          localObject1 = localObject4;
          localObject2 = q.bmh().T(paramca.field_imgPath, true);
          l = u.bBQ((String)localObject2);
          locala = ay(paramca);
          locala.field_msgSubType = i;
          locala.field_path = bAT((String)localObject2);
          locala.field_size = l;
          localObject2 = info();
          if (localObject1 != null) {
            break label575;
          }
        }
        break;
      }
      label575:
      for (paramca = "null";; paramca = (ca)localObject1)
      {
        Log.i("MicroMsg.AppMsgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", new Object[] { localObject2, paramca, locala });
        paramca = new ArrayList();
        if (localObject1 != null) {
          paramca.add(localObject1);
        }
        paramca.add(locala);
        AppMethodBeat.o(22728);
        return paramca;
        localc = ao.ctZ().bpR(((k.b)localObject1).fvr);
        localObject2 = ay(paramca);
        localObject1 = locala;
        if (localc != null)
        {
          localObject1 = localc.field_fileFullPath;
          l = u.bBQ((String)localObject1);
        }
        ((com.tencent.mm.plugin.h.b.a)localObject2).field_msgSubType = 30;
        ((com.tencent.mm.plugin.h.b.a)localObject2).field_path = bAT((String)localObject1);
        ((com.tencent.mm.plugin.h.b.a)localObject2).field_size = l;
        i = 31;
        localObject1 = localObject2;
        break;
        localc = ao.ctZ().bpR(((k.b)localObject1).fvr);
        locala = ay(paramca);
        localObject1 = localObject2;
        if (localc != null)
        {
          localObject1 = localc.field_fileFullPath;
          l = u.bBQ((String)localObject1);
        }
        locala.field_msgSubType = 32;
        locala.field_path = bAT((String)localObject1);
        locala.field_size = l;
        i = 33;
        localObject1 = locala;
        break;
        localObject2 = ao.ctZ().bpR(((k.b)localObject1).fvr);
        locala = ay(paramca);
        localObject1 = localc;
        if (localObject2 != null)
        {
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
          l = u.bBQ((String)localObject1);
        }
        locala.field_msgSubType = 34;
        locala.field_path = bAT((String)localObject1);
        locala.field_size = l;
        i = 35;
        localObject1 = locala;
        break;
        localObject2 = ao.ctZ().bpR(((k.b)localObject1).fvr);
        locala = ay(paramca);
        localObject1 = localObject3;
        if (localObject2 != null)
        {
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
          l = u.bBQ((String)localObject1);
        }
        locala.field_msgSubType = 36;
        locala.field_path = bAT((String)localObject1);
        locala.field_size = l;
        i = 37;
        localObject1 = locala;
        break;
        AppMethodBeat.o(22728);
        return null;
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
 * Qualified Name:     com.tencent.mm.plugin.h.a.c
 * JD-Core Version:    0.7.0.1
 */