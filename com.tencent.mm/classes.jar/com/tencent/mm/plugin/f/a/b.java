package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.g;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.du;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> ac(bl parambl)
  {
    Object localObject2 = null;
    AppMethodBeat.i(22726);
    if (parambl == null)
    {
      AppMethodBeat.o(22726);
      return null;
    }
    Object localObject1 = bt.aGg(parambl.field_content);
    if (localObject1 != null) {}
    for (localObject1 = k.b.rx((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        ad.e("MicroMsg.AppMsgImgMsgHandler", "content is null");
        AppMethodBeat.o(22726);
        return null;
      }
      com.tencent.mm.plugin.f.b.a locala = ad(parambl);
      c localc = ap.bxS().aAL(((k.b)localObject1).dbA);
      long l = 0L;
      localObject1 = localObject2;
      if (localc != null)
      {
        localObject1 = localc.field_fileFullPath;
        l = i.aMN((String)localObject1);
      }
      locala.field_msgSubType = 30;
      locala.field_path = aUM((String)localObject1);
      locala.field_size = l;
      localObject1 = o.ayF().Q(parambl.field_imgPath, true);
      l = i.aMN((String)localObject1);
      parambl = ad(parambl);
      parambl.field_msgSubType = 31;
      parambl.field_path = aUM((String)localObject1);
      parambl.field_size = l;
      ad.i("MicroMsg.AppMsgImgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", new Object[] { info(), locala, parambl });
      localObject1 = new ArrayList();
      ((List)localObject1).add(locala);
      ((List)localObject1).add(parambl);
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