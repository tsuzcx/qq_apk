package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> ae(bv parambv)
  {
    Object localObject2 = null;
    AppMethodBeat.i(22726);
    if (parambv == null)
    {
      AppMethodBeat.o(22726);
      return null;
    }
    Object localObject1 = bu.aSA(parambv.field_content);
    if (localObject1 != null) {}
    for (localObject1 = k.b.zb((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        ae.e("MicroMsg.AppMsgImgMsgHandler", "content is null");
        AppMethodBeat.o(22726);
        return null;
      }
      com.tencent.mm.plugin.f.b.a locala = af(parambv);
      c localc = ao.bJV().aMZ(((k.b)localObject1).dlu);
      long l = 0L;
      localObject1 = localObject2;
      if (localc != null)
      {
        localObject1 = localc.field_fileFullPath;
        l = o.aZR((String)localObject1);
      }
      locala.field_msgSubType = 30;
      locala.field_path = aJh((String)localObject1);
      locala.field_size = l;
      localObject1 = q.aIX().R(parambv.field_imgPath, true);
      l = o.aZR((String)localObject1);
      parambv = af(parambv);
      parambv.field_msgSubType = 31;
      parambv.field_path = aJh((String)localObject1);
      parambv.field_size = l;
      ae.i("MicroMsg.AppMsgImgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", new Object[] { info(), locala, parambv });
      localObject1 = new ArrayList();
      ((List)localObject1).add(locala);
      ((List)localObject1).add(parambv);
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