package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.g;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> Q(bi parambi)
  {
    long l = 0L;
    b localb2 = null;
    Object localObject2 = null;
    b localb1 = null;
    AppMethodBeat.i(18619);
    if (parambi == null)
    {
      AppMethodBeat.o(18619);
      return null;
    }
    Object localObject1 = bo.apU(parambi.field_content);
    if (localObject1 != null) {}
    for (localObject1 = j.b.mY((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        ab.e("MicroMsg.AppMsgMsgHandler", "content is null");
        AppMethodBeat.o(18619);
        return null;
      }
      com.tencent.mm.plugin.f.b.a locala = R(parambi);
      int i;
      switch (((j.b)localObject1).type)
      {
      case 3: 
      case 4: 
      case 5: 
      default: 
        AppMethodBeat.o(18619);
        return null;
      case 2: 
        localb2 = al.aUJ().alo(((j.b)localObject1).cmN);
        localObject1 = localb1;
        if (localb2 != null)
        {
          localObject1 = localb2.field_fileFullPath;
          l = e.avI((String)localObject1);
        }
        locala.field_msgSubType = 30;
        locala.field_path = Hw((String)localObject1);
        locala.field_size = l;
        i = 31;
      }
      for (;;)
      {
        localObject1 = o.ahC().J(parambi.field_imgPath, true);
        l = e.avI((String)localObject1);
        parambi = R(parambi);
        parambi.field_msgSubType = i;
        parambi.field_path = Hw((String)localObject1);
        parambi.field_size = l;
        ab.i("MicroMsg.AppMsgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", new Object[] { bau(), locala, parambi });
        localObject1 = new ArrayList();
        ((List)localObject1).add(locala);
        ((List)localObject1).add(parambi);
        AppMethodBeat.o(18619);
        return localObject1;
        localb1 = al.aUJ().alo(((j.b)localObject1).cmN);
        localObject1 = localb2;
        if (localb1 != null)
        {
          localObject1 = localb1.field_fileFullPath;
          l = e.avI((String)localObject1);
        }
        locala.field_msgSubType = 32;
        locala.field_path = Hw((String)localObject1);
        locala.field_size = l;
        i = 33;
        continue;
        localb1 = al.aUJ().alo(((j.b)localObject1).cmN);
        localObject1 = localObject2;
        if (localb1 != null)
        {
          localObject1 = localb1.field_fileFullPath;
          l = e.avI((String)localObject1);
        }
        locala.field_msgSubType = 34;
        locala.field_path = Hw((String)localObject1);
        locala.field_size = l;
        i = 35;
      }
    }
  }
  
  protected final String bau()
  {
    AppMethodBeat.i(18620);
    String str = "AppMsg_" + hashCode();
    AppMethodBeat.o(18620);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.c
 * JD-Core Version:    0.7.0.1
 */