package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.g;
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> ac(bo parambo)
  {
    Object localObject2 = null;
    AppMethodBeat.i(22726);
    if (parambo == null)
    {
      AppMethodBeat.o(22726);
      return null;
    }
    Object localObject1 = bs.aLx(parambo.field_content);
    if (localObject1 != null) {}
    for (localObject1 = k.b.vA((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        ac.e("MicroMsg.AppMsgImgMsgHandler", "content is null");
        AppMethodBeat.o(22726);
        return null;
      }
      com.tencent.mm.plugin.f.b.a locala = ad(parambo);
      c localc = ap.bEO().aGd(((k.b)localObject1).cZa);
      long l = 0L;
      localObject1 = localObject2;
      if (localc != null)
      {
        localObject1 = localc.field_fileFullPath;
        l = i.aSp((String)localObject1);
      }
      locala.field_msgSubType = 30;
      locala.field_path = aBR((String)localObject1);
      locala.field_size = l;
      localObject1 = o.aFx().R(parambo.field_imgPath, true);
      l = i.aSp((String)localObject1);
      parambo = ad(parambo);
      parambo.field_msgSubType = 31;
      parambo.field_path = aBR((String)localObject1);
      parambo.field_size = l;
      ac.i("MicroMsg.AppMsgImgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", new Object[] { info(), locala, parambo });
      localObject1 = new ArrayList();
      ((List)localObject1).add(locala);
      ((List)localObject1).add(parambo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b
 * JD-Core Version:    0.7.0.1
 */