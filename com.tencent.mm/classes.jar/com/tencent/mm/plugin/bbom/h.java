package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.o;
import com.tencent.mm.aw.s;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.u;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.modelmulti.o.a;
import com.tencent.mm.modelmulti.o.c;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.byp.b.b;
import com.tencent.mm.plugin.gamelife.a.e;
import com.tencent.mm.plugin.i.a.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.am;

public final class h
  implements o.c
{
  public final o.a a(o.e parame)
  {
    AppMethodBeat.i(193164);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject1;
    if (parame.ign == o.d.ifW)
    {
      localObject2 = new o.a();
      boolean bool1 = ((p)com.tencent.mm.kernel.g.ab(p.class)).ail(parame.toUser);
      boolean bool2 = am.aSV(parame.toUser);
      ad.i("MicroMsg.CreateSendMsgCgiCallback", "[createTextCgi] constructorId=%s toUser=%s isFinderMessage=%s isGameLifeMessage=%s", new Object[] { Integer.valueOf(parame.igc), parame.toUser, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (bool1)
      {
        localObject3 = parame.toUser;
        localObject4 = ((p)com.tencent.mm.kernel.g.ab(p.class)).aii((String)localObject3);
        if (am.aSU((String)localObject4))
        {
          localObject1 = u.aAm();
          parame.dyU = ((String)localObject1);
          parame = new com.tencent.mm.plugin.byp.b.c(1, (String)localObject3, parame.dyU, (String)localObject4, parame.content, parame.msgId);
          ((o.a)localObject2).ifU = parame.dku.field_msgId;
          ((o.a)localObject2).dor = parame;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(193164);
        return localObject2;
        localObject1 = u.aAu();
        break;
        if (bool2)
        {
          localObject1 = parame.toUser;
          localObject3 = ((e)com.tencent.mm.kernel.g.ab(e.class)).amC((String)localObject1);
          parame.dyU = ((com.tencent.mm.plugin.gamelife.a.d)localObject3).getSelfUsername();
          parame = new com.tencent.mm.plugin.byp.b.c(3, (String)localObject1, parame.dyU, ((com.tencent.mm.plugin.gamelife.a.d)localObject3).VS(), parame.content, parame.msgId);
          ((o.a)localObject2).ifU = parame.dku.field_msgId;
          ((o.a)localObject2).dor = parame;
        }
        else if (parame.igc == 5)
        {
          parame = new i(parame.toUser, parame.content, parame.type, parame.dDp, parame.igb);
          ((o.a)localObject2).ifU = parame.msgId;
          ((o.a)localObject2).dor = parame;
        }
        else if (parame.igc == 4)
        {
          parame = new i(parame.toUser, parame.content, parame.type, parame.dDp);
          ((o.a)localObject2).ifU = parame.msgId;
          ((o.a)localObject2).dor = parame;
        }
        else if (parame.igc == 2)
        {
          parame = new i(parame.msgId);
          ((o.a)localObject2).ifU = parame.msgId;
          ((o.a)localObject2).dor = parame;
        }
        else
        {
          parame = new i();
          ((o.a)localObject2).ifU = parame.msgId;
          ((o.a)localObject2).dor = parame;
        }
      }
    }
    if (parame.ign == o.d.ifX)
    {
      localObject3 = new o.a();
      ad.i("MicroMsg.CreateSendMsgCgiCallback", "[createImageCgi] constructorId=%s toUser=%s", new Object[] { Integer.valueOf(parame.igc), parame.toUser });
      localObject1 = null;
      if (parame.igc == 2)
      {
        localObject2 = new com.tencent.mm.aw.n(parame.igk, parame.hZz);
        localObject1 = localObject2;
        if (parame.gwX)
        {
          ((com.tencent.mm.aw.n)localObject2).aIs();
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((com.tencent.mm.aw.n)localObject1).aIr() != null)) {
        ((o.a)localObject3).ifU = ((com.tencent.mm.aw.n)localObject1).aIr().field_msgId;
      }
      ((o.a)localObject3).dor = ((com.tencent.mm.al.n)localObject1);
      AppMethodBeat.o(193164);
      return localObject3;
      if (parame.igc == 3)
      {
        localObject2 = new com.tencent.mm.aw.n(parame.igk, parame.hZz, parame.igd);
        localObject1 = localObject2;
        if (parame.gwX)
        {
          ((com.tencent.mm.aw.n)localObject2).aIs();
          localObject1 = localObject2;
        }
      }
      else if (parame.igc == 6)
      {
        localObject2 = new com.tencent.mm.aw.n(parame.gwQ, parame.dyU, parame.toUser, parame.ibF, parame.hZz, parame.igd);
        localObject1 = localObject2;
        if (parame.gwX)
        {
          ((com.tencent.mm.aw.n)localObject2).aIs();
          localObject1 = localObject2;
        }
      }
      else if (parame.igc == 9)
      {
        localObject2 = new com.tencent.mm.aw.n(parame.gwQ, parame.dyU, parame.toUser, parame.ibF, parame.hZz, parame.igd, parame.dxr, parame.hZI, parame.thumbPath);
        localObject1 = localObject2;
        if (parame.gwX)
        {
          ((com.tencent.mm.aw.n)localObject2).aIs();
          localObject1 = localObject2;
        }
      }
      else if (parame.igc == 10)
      {
        localObject2 = new com.tencent.mm.aw.n(parame.gwQ, parame.dyU, parame.toUser, parame.ibF, parame.hZz, parame.igd, parame.dxr, parame.ige, parame.igf);
        localObject1 = localObject2;
        if (parame.gwX)
        {
          ((com.tencent.mm.aw.n)localObject2).aIs();
          localObject1 = localObject2;
        }
      }
      else if (parame.igc == 11)
      {
        localObject2 = new com.tencent.mm.aw.n(parame.gwQ, parame.dyU, parame.toUser, parame.ibF, parame.hZz, parame.igd, parame.dxr, parame.hZI, parame.thumbPath, parame.igg, parame.igf);
        localObject1 = localObject2;
        if (parame.gwX)
        {
          ((com.tencent.mm.aw.n)localObject2).aIs();
          localObject1 = localObject2;
        }
      }
      else if (parame.igc == 13)
      {
        localObject2 = new com.tencent.mm.aw.n(parame.gwQ, parame.dyU, parame.toUser, parame.ibF, parame.hZz, parame.igd, parame.dxr, parame.hZI, parame.thumbPath, parame.igg, parame.igf, parame.igh, parame.igj);
        localObject1 = localObject2;
        if (parame.gwX)
        {
          ((com.tencent.mm.aw.n)localObject2).aIs();
          localObject1 = localObject2;
        }
      }
      else if (parame.igc == 14)
      {
        localObject1 = new com.tencent.mm.aw.n(parame.igk, parame.gwQ, parame.dyU, parame.toUser, parame.ibF, parame.hZz, parame.igd, parame.dxr, parame.hZI, parame.thumbPath, parame.igg, parame.igf, parame.igl);
        if (parame.gwX) {
          ((com.tencent.mm.aw.n)localObject1).aIs();
        }
      }
      else if (parame.igc == 19)
      {
        localObject2 = new com.tencent.mm.aw.n(parame.gwQ, parame.dyU, parame.toUser, parame.ibF, parame.hZz, parame.igd, parame.dxr, parame.hZI, parame.thumbPath, parame.igg, parame.igf, parame.igl, parame.igm, parame.dAp, parame.dyz, parame.igi, parame.igh, parame.igj);
        localObject1 = localObject2;
        if (parame.gwX)
        {
          ((com.tencent.mm.aw.n)localObject2).aIs();
          localObject1 = localObject2;
          continue;
          if (parame.ign == o.d.ifY)
          {
            localObject2 = new o.a();
            if ((parame instanceof s))
            {
              localObject4 = (s)parame;
              ad.i("MicroMsg.CreateSendMsgCgiCallback", "[createVideoCgi] constructorId=%s fileName=%s", new Object[] { Integer.valueOf(parame.igc), ((s)localObject4).fileName });
              if (parame.igc != 1) {
                break label1333;
              }
              ((o.a)localObject2).dor = new com.tencent.mm.modelvideo.g(((s)localObject4).fileName);
            }
            for (;;)
            {
              AppMethodBeat.o(193164);
              return localObject2;
              label1333:
              if (parame.igc == 4)
              {
                if (al.aSL(((s)localObject4).fileName))
                {
                  localObject3 = ((s)localObject4).icO.field_toUser;
                  localObject1 = ((p)com.tencent.mm.kernel.g.ab(p.class)).aii((String)localObject3);
                  parame.toUser = ((String)localObject1);
                  if (am.aSU((String)localObject1)) {}
                  for (localObject1 = u.aAm();; localObject1 = u.aAu())
                  {
                    parame.dyU = ((String)localObject1);
                    localObject1 = new com.tencent.mm.modelvideo.h(((s)localObject4).fileName, ((s)localObject4).icN, ((s)localObject4).icO, ((s)localObject4).icP);
                    ((o.a)localObject2).dor = new com.tencent.mm.plugin.byp.b.d((String)localObject3, parame.dyU, parame.toUser, (com.tencent.mm.modelvideo.h)localObject1);
                    break;
                  }
                }
                ((o.a)localObject2).dor = new com.tencent.mm.modelvideo.h(((s)localObject4).fileName, ((s)localObject4).icN, ((s)localObject4).icO, ((s)localObject4).icP);
              }
            }
          }
          if (parame.ign == o.d.ifZ)
          {
            ad.i("MicroMsg.CreateSendMsgCgiCallback", "[createCdnImageCgi] constructorId=%s toUser=%s", new Object[] { Integer.valueOf(parame.igc), parame.toUser });
            localObject2 = new o.a();
            String str;
            if ((parame instanceof com.tencent.mm.aw.c))
            {
              localObject3 = (com.tencent.mm.aw.c)parame;
              if (!am.ail(parame.toUser)) {
                break label1655;
              }
              localObject4 = parame.toUser;
              str = ((p)com.tencent.mm.kernel.g.ab(p.class)).aii((String)localObject4);
              if (!am.aSU(str)) {
                break label1647;
              }
              localObject1 = u.aAm();
              parame.dyU = ((String)localObject1);
            }
            label1647:
            label1655:
            for (((o.a)localObject2).dor = new b((String)localObject4, ((com.tencent.mm.aw.c)localObject3).dyU, str, (com.tencent.mm.aw.c)localObject3);; ((o.a)localObject2).dor = new o(((com.tencent.mm.aw.c)localObject3).gwQ, ((com.tencent.mm.aw.c)localObject3).hZg, ((com.tencent.mm.aw.c)localObject3).hZh, ((com.tencent.mm.aw.c)localObject3).gwW, ((com.tencent.mm.aw.c)localObject3).hZi))
            {
              AppMethodBeat.o(193164);
              return localObject2;
              localObject1 = u.aAu();
              break;
            }
          }
          AppMethodBeat.o(193164);
          return null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.h
 * JD-Core Version:    0.7.0.1
 */