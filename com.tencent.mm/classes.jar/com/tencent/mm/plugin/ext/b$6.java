package com.tencent.mm.plugin.ext;

import com.tencent.mm.ah.b.c;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.pluginsdk.model.i;
import com.tencent.mm.pluginsdk.model.i.a;
import com.tencent.mm.pluginsdk.model.i.b;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.protocal.c.alt;
import com.tencent.mm.protocal.c.ccc;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
    if (paraml == null) {}
    int i;
    label267:
    do
    {
      return;
      Object localObject1;
      if (paraml.jvQ == null)
      {
        localObject1 = null;
        localObject1 = ((alt)localObject1).thJ.iterator();
        i = 0;
      }
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label267;
        }
        Object localObject2 = (ccc)((Iterator)localObject1).next();
        y.v("MicroMsg.SubCoreExt", "AppId[%s], UserName[%s], Xml[%s]", new Object[] { paraml.rTu, ((ccc)localObject2).hPY, ((ccc)localObject2).tRy });
        if ((!bk.bl(((ccc)localObject2).hPY)) && (!bk.bl(((ccc)localObject2).tRy)))
        {
          au.Hx();
          Object localObject3 = c.Fw().abj(((ccc)localObject2).hPY);
          if ((localObject3 == null) || ((int)((a)localObject3).dBe <= 0))
          {
            y.e("MicroMsg.SubCoreExt", "contact is null");
            continue;
            localObject1 = (alt)paraml.jvQ.ecF.ecN;
            break;
          }
          if (((ad)localObject3).cua())
          {
            y.w("MicroMsg.SubCoreExt", "isBizContact");
          }
          else
          {
            localObject3 = i.VL(((ccc)localObject2).tRy);
            if ((localObject3 != null) && (!bk.bl(((i.b)localObject3).rTn)))
            {
              y.v("MicroMsg.SubCoreExt", "AppId[%s], openId[%s]", new Object[] { paraml.rTu, ((i.b)localObject3).rTn });
              localObject2 = new bz(paraml.rTu, ((ccc)localObject2).hPY, ((i.b)localObject3).rTn);
              b.aNq().a((bz)localObject2);
              i = 1;
            }
          }
        }
      }
    } while (i == 0);
    this.jJF.aNu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.6
 * JD-Core Version:    0.7.0.1
 */