package com.tencent.mm.plugin.ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.pluginsdk.model.i;
import com.tencent.mm.pluginsdk.model.i.a;
import com.tencent.mm.pluginsdk.model.i.b;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.cpi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.LinkedList;

final class b$6
  implements i.a
{
  b$6(b paramb) {}
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(20264);
    if (paraml == null)
    {
      AppMethodBeat.o(20264);
      return;
    }
    Iterator localIterator = paraml.dlj().xgx.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = (cpi)localIterator.next();
      ab.v("MicroMsg.SubCoreExt", "AppId[%s], UserName[%s], Xml[%s]", new Object[] { paraml.hAf, ((cpi)localObject1).jJA, ((cpi)localObject1).xYu });
      if ((!bo.isNullOrNil(((cpi)localObject1).jJA)) && (!bo.isNullOrNil(((cpi)localObject1).xYu)))
      {
        aw.aaz();
        Object localObject2 = c.YA().aru(((cpi)localObject1).jJA);
        if ((localObject2 == null) || ((int)((a)localObject2).euF <= 0))
        {
          ab.e("MicroMsg.SubCoreExt", "contact is null");
        }
        else if (((ad)localObject2).dwz())
        {
          ab.w("MicroMsg.SubCoreExt", "isBizContact");
        }
        else
        {
          localObject2 = i.alj(((cpi)localObject1).xYu);
          if ((localObject2 != null) && (!bo.isNullOrNil(((i.b)localObject2).vKl)))
          {
            ab.v("MicroMsg.SubCoreExt", "AppId[%s], openId[%s]", new Object[] { paraml.hAf, ((i.b)localObject2).vKl });
            localObject1 = new bz(paraml.hAf, ((cpi)localObject1).jJA, ((i.b)localObject2).vKl);
            b.btt().a((bz)localObject1);
            i = 1;
          }
        }
      }
    }
    if (i != 0) {
      this.mdJ.btx();
    }
    AppMethodBeat.o(20264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.6
 * JD-Core Version:    0.7.0.1
 */