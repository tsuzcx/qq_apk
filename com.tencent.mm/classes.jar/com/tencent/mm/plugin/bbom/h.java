package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.o;
import com.tencent.mm.av.s;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.v;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.modelmulti.o.a;
import com.tencent.mm.modelmulti.o.c;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.byp.b.b;
import com.tencent.mm.plugin.gamelife.a.e;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.plugin.i.a.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.an;

public final class h
  implements o.c
{
  public final o.a a(o.e parame)
  {
    AppMethodBeat.i(186422);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject1;
    if (parame.ijg == o.d.iiP)
    {
      localObject2 = new o.a();
      boolean bool1 = ((p)com.tencent.mm.kernel.g.ab(p.class)).aji(parame.toUser);
      boolean bool2 = an.aUv(parame.toUser);
      ae.i("MicroMsg.CreateSendMsgCgiCallback", "[createTextCgi] constructorId=%s toUser=%s isFinderMessage=%s isGameLifeMessage=%s", new Object[] { Integer.valueOf(parame.iiV), parame.toUser, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (bool1)
      {
        localObject3 = parame.toUser;
        localObject4 = ((p)com.tencent.mm.kernel.g.ab(p.class)).ajf((String)localObject3);
        if (an.aUu((String)localObject4))
        {
          localObject1 = v.aAC();
          parame.dzZ = ((String)localObject1);
          parame = new com.tencent.mm.plugin.byp.b.c(1, (String)localObject3, parame.dzZ, (String)localObject4, parame.content, parame.msgId);
          ((o.a)localObject2).iiN = parame.dlw.field_msgId;
          ((o.a)localObject2).dpw = parame;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(186422);
        return localObject2;
        localObject1 = v.aAK();
        break;
        if (bool2)
        {
          localObject1 = parame.toUser;
          localObject3 = ((f)com.tencent.mm.kernel.g.ab(f.class)).anD((String)localObject1);
          parame.dzZ = ((e)localObject3).getSelfUsername();
          parame = new com.tencent.mm.plugin.byp.b.c(3, (String)localObject1, parame.dzZ, ((e)localObject3).Wa(), parame.content, parame.msgId);
          ((o.a)localObject2).iiN = parame.dlw.field_msgId;
          ((o.a)localObject2).dpw = parame;
        }
        else if (parame.iiV == 5)
        {
          parame = new i(parame.toUser, parame.content, parame.type, parame.dEu, parame.iiU);
          ((o.a)localObject2).iiN = parame.msgId;
          ((o.a)localObject2).dpw = parame;
        }
        else if (parame.iiV == 4)
        {
          parame = new i(parame.toUser, parame.content, parame.type, parame.dEu);
          ((o.a)localObject2).iiN = parame.msgId;
          ((o.a)localObject2).dpw = parame;
        }
        else if (parame.iiV == 2)
        {
          parame = new i(parame.msgId);
          ((o.a)localObject2).iiN = parame.msgId;
          ((o.a)localObject2).dpw = parame;
        }
        else
        {
          parame = new i();
          ((o.a)localObject2).iiN = parame.msgId;
          ((o.a)localObject2).dpw = parame;
        }
      }
    }
    if (parame.ijg == o.d.iiQ)
    {
      localObject3 = new o.a();
      ae.i("MicroMsg.CreateSendMsgCgiCallback", "[createImageCgi] constructorId=%s toUser=%s", new Object[] { Integer.valueOf(parame.iiV), parame.toUser });
      localObject1 = null;
      if (parame.iiV == 2)
      {
        localObject2 = new com.tencent.mm.av.n(parame.ijd, parame.icr);
        localObject1 = localObject2;
        if (parame.gzE)
        {
          ((com.tencent.mm.av.n)localObject2).aIK();
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((com.tencent.mm.av.n)localObject1).aIJ() != null)) {
        ((o.a)localObject3).iiN = ((com.tencent.mm.av.n)localObject1).aIJ().field_msgId;
      }
      ((o.a)localObject3).dpw = ((com.tencent.mm.ak.n)localObject1);
      AppMethodBeat.o(186422);
      return localObject3;
      if (parame.iiV == 3)
      {
        localObject2 = new com.tencent.mm.av.n(parame.ijd, parame.icr, parame.iiW);
        localObject1 = localObject2;
        if (parame.gzE)
        {
          ((com.tencent.mm.av.n)localObject2).aIK();
          localObject1 = localObject2;
        }
      }
      else if (parame.iiV == 6)
      {
        localObject2 = new com.tencent.mm.av.n(parame.gzx, parame.dzZ, parame.toUser, parame.iey, parame.icr, parame.iiW);
        localObject1 = localObject2;
        if (parame.gzE)
        {
          ((com.tencent.mm.av.n)localObject2).aIK();
          localObject1 = localObject2;
        }
      }
      else if (parame.iiV == 9)
      {
        localObject2 = new com.tencent.mm.av.n(parame.gzx, parame.dzZ, parame.toUser, parame.iey, parame.icr, parame.iiW, parame.dyw, parame.icA, parame.thumbPath);
        localObject1 = localObject2;
        if (parame.gzE)
        {
          ((com.tencent.mm.av.n)localObject2).aIK();
          localObject1 = localObject2;
        }
      }
      else if (parame.iiV == 10)
      {
        localObject2 = new com.tencent.mm.av.n(parame.gzx, parame.dzZ, parame.toUser, parame.iey, parame.icr, parame.iiW, parame.dyw, parame.iiX, parame.iiY);
        localObject1 = localObject2;
        if (parame.gzE)
        {
          ((com.tencent.mm.av.n)localObject2).aIK();
          localObject1 = localObject2;
        }
      }
      else if (parame.iiV == 11)
      {
        localObject2 = new com.tencent.mm.av.n(parame.gzx, parame.dzZ, parame.toUser, parame.iey, parame.icr, parame.iiW, parame.dyw, parame.icA, parame.thumbPath, parame.iiZ, parame.iiY);
        localObject1 = localObject2;
        if (parame.gzE)
        {
          ((com.tencent.mm.av.n)localObject2).aIK();
          localObject1 = localObject2;
        }
      }
      else if (parame.iiV == 13)
      {
        localObject2 = new com.tencent.mm.av.n(parame.gzx, parame.dzZ, parame.toUser, parame.iey, parame.icr, parame.iiW, parame.dyw, parame.icA, parame.thumbPath, parame.iiZ, parame.iiY, parame.ija, parame.ijc);
        localObject1 = localObject2;
        if (parame.gzE)
        {
          ((com.tencent.mm.av.n)localObject2).aIK();
          localObject1 = localObject2;
        }
      }
      else if (parame.iiV == 14)
      {
        localObject1 = new com.tencent.mm.av.n(parame.ijd, parame.gzx, parame.dzZ, parame.toUser, parame.iey, parame.icr, parame.iiW, parame.dyw, parame.icA, parame.thumbPath, parame.iiZ, parame.iiY, parame.ije);
        if (parame.gzE) {
          ((com.tencent.mm.av.n)localObject1).aIK();
        }
      }
      else if (parame.iiV == 19)
      {
        localObject2 = new com.tencent.mm.av.n(parame.gzx, parame.dzZ, parame.toUser, parame.iey, parame.icr, parame.iiW, parame.dyw, parame.icA, parame.thumbPath, parame.iiZ, parame.iiY, parame.ije, parame.ijf, parame.dBu, parame.dzE, parame.ijb, parame.ija, parame.ijc);
        localObject1 = localObject2;
        if (parame.gzE)
        {
          ((com.tencent.mm.av.n)localObject2).aIK();
          localObject1 = localObject2;
          continue;
          if (parame.ijg == o.d.iiR)
          {
            localObject2 = new o.a();
            if ((parame instanceof s))
            {
              localObject3 = (s)parame;
              ae.i("MicroMsg.CreateSendMsgCgiCallback", "[createVideoCgi] constructorId=%s fileName=%s", new Object[] { Integer.valueOf(parame.iiV), ((s)localObject3).fileName });
              if (parame.iiV != 1) {
                break label1333;
              }
              ((o.a)localObject2).dpw = new com.tencent.mm.modelvideo.g(((s)localObject3).fileName);
            }
            for (;;)
            {
              AppMethodBeat.o(186422);
              return localObject2;
              label1333:
              if (parame.iiV == 4)
              {
                if (am.aUk(((s)localObject3).fileName))
                {
                  localObject4 = ((s)localObject3).ifH.field_toUser;
                  localObject1 = ((p)com.tencent.mm.kernel.g.ab(p.class)).ajf((String)localObject4);
                  parame.toUser = ((String)localObject1);
                  if (an.aUu((String)localObject1)) {}
                  for (localObject1 = v.aAC();; localObject1 = v.aAK())
                  {
                    parame.dzZ = ((String)localObject1);
                    localObject1 = new com.tencent.mm.modelvideo.h(((s)localObject3).fileName, ((s)localObject3).ifG, ((s)localObject3).ifH, ((s)localObject3).ifI);
                    ((o.a)localObject2).dpw = new com.tencent.mm.plugin.byp.b.d(1, (String)localObject4, parame.dzZ, parame.toUser, (com.tencent.mm.modelvideo.h)localObject1);
                    break;
                  }
                }
                if (am.aUl(((s)localObject3).fileName))
                {
                  localObject1 = ((s)localObject3).ifH.field_toUser;
                  localObject4 = ((f)com.tencent.mm.kernel.g.ab(f.class)).anD((String)localObject1);
                  parame.toUser = ((e)localObject4).Wa();
                  parame.dzZ = ((e)localObject4).getSelfUsername();
                  ae.i("MicroMsg.CreateSendMsgCgiCallback", "[createVideoCgi] gameLife fromUserName:%s,toUserName:%s", new Object[] { parame.dzZ, parame.toUser });
                  localObject3 = new com.tencent.mm.modelvideo.h(((s)localObject3).fileName, ((s)localObject3).ifG, ((s)localObject3).ifH, ((s)localObject3).ifI);
                  ((o.a)localObject2).dpw = new com.tencent.mm.plugin.byp.b.d(3, (String)localObject1, parame.dzZ, parame.toUser, (com.tencent.mm.modelvideo.h)localObject3);
                }
                else
                {
                  ((o.a)localObject2).dpw = new com.tencent.mm.modelvideo.h(((s)localObject3).fileName, ((s)localObject3).ifG, ((s)localObject3).ifH, ((s)localObject3).ifI);
                }
              }
            }
          }
          if (parame.ijg == o.d.iiS)
          {
            ae.i("MicroMsg.CreateSendMsgCgiCallback", "[createCdnImageCgi] constructorId=%s toUser=%s", new Object[] { Integer.valueOf(parame.iiV), parame.toUser });
            localObject2 = new o.a();
            String str;
            if ((parame instanceof com.tencent.mm.av.c))
            {
              localObject3 = (com.tencent.mm.av.c)parame;
              if (!an.aji(parame.toUser)) {
                break label1800;
              }
              localObject4 = parame.toUser;
              str = ((p)com.tencent.mm.kernel.g.ab(p.class)).ajf((String)localObject4);
              if (!an.aUu(str)) {
                break label1792;
              }
              localObject1 = v.aAC();
              parame.dzZ = ((String)localObject1);
              ((o.a)localObject2).dpw = new b(1, (String)localObject4, ((com.tencent.mm.av.c)localObject3).dzZ, str, (com.tencent.mm.av.c)localObject3);
            }
            for (;;)
            {
              AppMethodBeat.o(186422);
              return localObject2;
              label1792:
              localObject1 = v.aAK();
              break;
              label1800:
              if (an.aUv(parame.toUser))
              {
                localObject1 = parame.toUser;
                localObject4 = ((f)com.tencent.mm.kernel.g.ab(f.class)).anD((String)localObject1);
                str = ((e)localObject4).Wa();
                parame.dzZ = ((e)localObject4).getSelfUsername();
                ((o.a)localObject2).dpw = new b(3, (String)localObject1, ((com.tencent.mm.av.c)localObject3).dzZ, str, (com.tencent.mm.av.c)localObject3);
              }
              else
              {
                ((o.a)localObject2).dpw = new o(((com.tencent.mm.av.c)localObject3).gzx, ((com.tencent.mm.av.c)localObject3).ibY, ((com.tencent.mm.av.c)localObject3).ibZ, ((com.tencent.mm.av.c)localObject3).gzD, ((com.tencent.mm.av.c)localObject3).ica);
              }
            }
          }
          AppMethodBeat.o(186422);
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