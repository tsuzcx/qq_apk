package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.g;
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> ac(bo parambo)
  {
    long l = 0L;
    com.tencent.mm.pluginsdk.model.app.c localc2 = null;
    Object localObject2 = null;
    com.tencent.mm.pluginsdk.model.app.c localc1 = null;
    AppMethodBeat.i(22728);
    if (parambo == null)
    {
      AppMethodBeat.o(22728);
      return null;
    }
    Object localObject1 = bs.aLx(parambo.field_content);
    if (localObject1 != null) {}
    for (localObject1 = k.b.vA((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        ac.e("MicroMsg.AppMsgMsgHandler", "content is null");
        AppMethodBeat.o(22728);
        return null;
      }
      com.tencent.mm.plugin.f.b.a locala = ad(parambo);
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
        localc2 = ap.bEO().aGd(((k.b)localObject1).cZa);
        localObject1 = localc1;
        if (localc2 != null)
        {
          localObject1 = localc2.field_fileFullPath;
          l = i.aSp((String)localObject1);
        }
        locala.field_msgSubType = 30;
        locala.field_path = aBR((String)localObject1);
        locala.field_size = l;
        i = 31;
      }
      for (;;)
      {
        localObject1 = o.aFx().R(parambo.field_imgPath, true);
        l = i.aSp((String)localObject1);
        parambo = ad(parambo);
        parambo.field_msgSubType = i;
        parambo.field_path = aBR((String)localObject1);
        parambo.field_size = l;
        ac.i("MicroMsg.AppMsgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", new Object[] { info(), locala, parambo });
        localObject1 = new ArrayList();
        ((List)localObject1).add(locala);
        ((List)localObject1).add(parambo);
        AppMethodBeat.o(22728);
        return localObject1;
        localc1 = ap.bEO().aGd(((k.b)localObject1).cZa);
        localObject1 = localc2;
        if (localc1 != null)
        {
          localObject1 = localc1.field_fileFullPath;
          l = i.aSp((String)localObject1);
        }
        locala.field_msgSubType = 32;
        locala.field_path = aBR((String)localObject1);
        locala.field_size = l;
        i = 33;
        continue;
        localc1 = ap.bEO().aGd(((k.b)localObject1).cZa);
        localObject1 = localObject2;
        if (localc1 != null)
        {
          localObject1 = localc1.field_fileFullPath;
          l = i.aSp((String)localObject1);
        }
        locala.field_msgSubType = 34;
        locala.field_path = aBR((String)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.c
 * JD-Core Version:    0.7.0.1
 */