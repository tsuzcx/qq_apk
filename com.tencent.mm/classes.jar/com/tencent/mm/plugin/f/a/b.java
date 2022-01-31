package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.g;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> Q(bi parambi)
  {
    Object localObject2 = null;
    AppMethodBeat.i(18617);
    if (parambi == null)
    {
      AppMethodBeat.o(18617);
      return null;
    }
    Object localObject1 = bo.apU(parambi.field_content);
    if (localObject1 != null) {}
    for (localObject1 = j.b.mY((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        ab.e("MicroMsg.AppMsgImgMsgHandler", "content is null");
        AppMethodBeat.o(18617);
        return null;
      }
      com.tencent.mm.plugin.f.b.a locala = R(parambi);
      com.tencent.mm.pluginsdk.model.app.b localb = al.aUJ().alo(((j.b)localObject1).cmN);
      long l = 0L;
      localObject1 = localObject2;
      if (localb != null)
      {
        localObject1 = localb.field_fileFullPath;
        l = e.avI((String)localObject1);
      }
      locala.field_msgSubType = 30;
      locala.field_path = Hw((String)localObject1);
      locala.field_size = l;
      localObject1 = o.ahC().J(parambi.field_imgPath, true);
      l = e.avI((String)localObject1);
      parambi = R(parambi);
      parambi.field_msgSubType = 31;
      parambi.field_path = Hw((String)localObject1);
      parambi.field_size = l;
      ab.i("MicroMsg.AppMsgImgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", new Object[] { bau(), locala, parambi });
      localObject1 = new ArrayList();
      ((List)localObject1).add(locala);
      ((List)localObject1).add(parambi);
      AppMethodBeat.o(18617);
      return localObject1;
    }
  }
  
  protected final String bau()
  {
    AppMethodBeat.i(18618);
    String str = "AppMsgImg_" + hashCode();
    AppMethodBeat.o(18618);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b
 * JD-Core Version:    0.7.0.1
 */