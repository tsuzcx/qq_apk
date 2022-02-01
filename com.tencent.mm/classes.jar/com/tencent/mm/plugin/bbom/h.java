package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.ay.n;
import com.tencent.mm.ay.o;
import com.tencent.mm.ay.s;
import com.tencent.mm.f.c.et;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.modelmulti.o.a;
import com.tencent.mm.modelmulti.o.c;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.modelvideo.l;
import com.tencent.mm.plugin.byp.b.b;
import com.tencent.mm.plugin.emoji.a;
import com.tencent.mm.plugin.findersdk.a.ab;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;

public final class h
  implements o.c
{
  public final o.a a(o.e parame)
  {
    AppMethodBeat.i(287692);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (parame.lUB == o.d.lUj)
    {
      localObject1 = new o.a();
      boolean bool1 = ((ab)com.tencent.mm.kernel.h.ae(ab.class)).aEF(parame.toUser);
      boolean bool2 = as.bvQ(parame.toUser);
      Log.i("MicroMsg.CreateSendMsgCgiCallback", "[createTextCgi] constructorId=%s toUser=%s isFinderMessage=%s isGameLifeMessage=%s", new Object[] { Integer.valueOf(parame.lUq), parame.toUser, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (bool1)
      {
        localObject2 = parame.toUser;
        localObject3 = ((ab)com.tencent.mm.kernel.h.ae(ab.class)).aED((String)localObject2);
        parame.fLi = ((ab)com.tencent.mm.kernel.h.ae(ab.class)).aEE((String)localObject2);
        parame = new com.tencent.mm.plugin.byp.b.d(1, (String)localObject2, parame.fLi, (String)localObject3, parame.content, parame.msgId);
        ((o.a)localObject1).lUh = parame.fvt.field_msgId;
        ((o.a)localObject1).fzz = parame;
      }
      for (;;)
      {
        AppMethodBeat.o(287692);
        return localObject1;
        if (bool2)
        {
          localObject2 = parame.toUser;
          localObject3 = ((f)com.tencent.mm.kernel.h.ae(f.class)).aKJ((String)localObject2);
          parame.fLi = ((com.tencent.mm.plugin.gamelife.a.e)localObject3).getSelfUsername();
          parame = new com.tencent.mm.plugin.byp.b.d(3, (String)localObject2, parame.fLi, ((com.tencent.mm.plugin.gamelife.a.e)localObject3).apJ(), parame.content, parame.msgId);
          ((o.a)localObject1).lUh = parame.fvt.field_msgId;
          ((o.a)localObject1).fzz = parame;
        }
        else if (parame.lUq == 5)
        {
          parame = new i(parame.toUser, parame.content, parame.type, parame.cUP, parame.lUp);
          ((o.a)localObject1).lUh = parame.msgId;
          ((o.a)localObject1).fzz = parame;
        }
        else if (parame.lUq == 4)
        {
          parame = new i(parame.toUser, parame.content, parame.type, parame.cUP);
          ((o.a)localObject1).lUh = parame.msgId;
          ((o.a)localObject1).fzz = parame;
        }
        else if (parame.lUq == 2)
        {
          parame = new i(parame.msgId);
          ((o.a)localObject1).lUh = parame.msgId;
          ((o.a)localObject1).fzz = parame;
        }
        else
        {
          parame = new i();
          ((o.a)localObject1).lUh = parame.msgId;
          ((o.a)localObject1).fzz = parame;
        }
      }
    }
    if (parame.lUB == o.d.lUk)
    {
      localObject3 = new o.a();
      Log.i("MicroMsg.CreateSendMsgCgiCallback", "[createImageCgi] constructorId=%s toUser=%s", new Object[] { Integer.valueOf(parame.lUq), parame.toUser });
      localObject1 = null;
      if (parame.lUq == 2)
      {
        localObject2 = new n(parame.lUy, parame.lNK);
        localObject1 = localObject2;
        if (parame.jYb)
        {
          ((n)localObject2).blU();
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((n)localObject1).blT() != null)) {
        ((o.a)localObject3).lUh = ((n)localObject1).blT().field_msgId;
      }
      ((o.a)localObject3).fzz = ((q)localObject1);
      AppMethodBeat.o(287692);
      return localObject3;
      if (parame.lUq == 3)
      {
        localObject2 = new n(parame.lUy, parame.lNK, parame.lUr);
        localObject1 = localObject2;
        if (parame.jYb)
        {
          ((n)localObject2).blU();
          localObject1 = localObject2;
        }
      }
      else if (parame.lUq == 6)
      {
        localObject2 = new n(parame.jXU, parame.fLi, parame.toUser, parame.lPO, parame.lNK, parame.lUr);
        localObject1 = localObject2;
        if (parame.jYb)
        {
          ((n)localObject2).blU();
          localObject1 = localObject2;
        }
      }
      else if (parame.lUq == 9)
      {
        localObject2 = new n(parame.jXU, parame.fLi, parame.toUser, parame.lPO, parame.lNK, parame.lUr, parame.fJu, parame.lNS, parame.thumbPath);
        localObject1 = localObject2;
        if (parame.jYb)
        {
          ((n)localObject2).blU();
          localObject1 = localObject2;
        }
      }
      else if (parame.lUq == 10)
      {
        localObject2 = new n(parame.jXU, parame.fLi, parame.toUser, parame.lPO, parame.lNK, parame.lUr, parame.fJu, parame.lUs, parame.lUt);
        localObject1 = localObject2;
        if (parame.jYb)
        {
          ((n)localObject2).blU();
          localObject1 = localObject2;
        }
      }
      else if (parame.lUq == 11)
      {
        localObject2 = new n(parame.jXU, parame.fLi, parame.toUser, parame.lPO, parame.lNK, parame.lUr, parame.fJu, parame.lNS, parame.thumbPath, parame.lUu, parame.lUt);
        localObject1 = localObject2;
        if (parame.jYb)
        {
          ((n)localObject2).blU();
          localObject1 = localObject2;
        }
      }
      else if (parame.lUq == 13)
      {
        localObject2 = new n(parame.jXU, parame.fLi, parame.toUser, parame.lPO, parame.lNK, parame.lUr, parame.fJu, parame.lNS, parame.thumbPath, parame.lUu, parame.lUt, parame.lUv, parame.lUx);
        localObject1 = localObject2;
        if (parame.jYb)
        {
          ((n)localObject2).blU();
          localObject1 = localObject2;
        }
      }
      else if (parame.lUq == 14)
      {
        localObject1 = new n(parame.lUy, parame.jXU, parame.fLi, parame.toUser, parame.lPO, parame.lNK, parame.lUr, parame.fJu, parame.lNS, parame.thumbPath, parame.lUu, parame.lUt, parame.lUz);
        if (parame.jYb) {
          ((n)localObject1).blU();
        }
      }
      else if (parame.lUq == 19)
      {
        localObject2 = new n(parame.jXU, parame.fLi, parame.toUser, parame.lPO, parame.lNK, parame.lUr, parame.fJu, parame.lNS, parame.thumbPath, parame.lUu, parame.lUt, parame.lUz, parame.lUA, parame.longitude, parame.latitude, parame.lUw, parame.lUv, parame.lUx);
        localObject1 = localObject2;
        if (parame.jYb)
        {
          ((n)localObject2).blU();
          localObject1 = localObject2;
          continue;
          label1325:
          Object localObject4;
          if (parame.lUB == o.d.lUl)
          {
            localObject1 = new o.a();
            if ((parame instanceof s))
            {
              localObject2 = (s)parame;
              Log.i("MicroMsg.CreateSendMsgCgiCallback", "[createVideoCgi] constructorId=%s fileName=%s", new Object[] { Integer.valueOf(parame.lUq), ((s)localObject2).fileName });
              if (parame.lUq != 1) {
                break label1325;
              }
              ((o.a)localObject1).fzz = new k(((s)localObject2).fileName);
            }
            for (;;)
            {
              AppMethodBeat.o(287692);
              return localObject1;
              if (parame.lUq == 4) {
                if (ar.bvD(((s)localObject2).fileName))
                {
                  localObject3 = ((s)localObject2).lQZ.field_toUser;
                  parame.toUser = ((ab)com.tencent.mm.kernel.h.ae(ab.class)).aED((String)localObject3);
                  parame.fLi = ((ab)com.tencent.mm.kernel.h.ae(ab.class)).aEE((String)localObject3);
                  localObject2 = new l(((s)localObject2).fileName, ((s)localObject2).lQY, ((s)localObject2).lQZ, ((s)localObject2).lRa);
                  ((o.a)localObject1).fzz = new com.tencent.mm.plugin.byp.b.e(1, (String)localObject3, parame.fLi, parame.toUser, (l)localObject2);
                }
                else if (ar.bvE(((s)localObject2).fileName))
                {
                  localObject3 = ((s)localObject2).lQZ.field_toUser;
                  localObject4 = ((f)com.tencent.mm.kernel.h.ae(f.class)).aKJ((String)localObject3);
                  parame.toUser = ((com.tencent.mm.plugin.gamelife.a.e)localObject4).apJ();
                  parame.fLi = ((com.tencent.mm.plugin.gamelife.a.e)localObject4).getSelfUsername();
                  Log.i("MicroMsg.CreateSendMsgCgiCallback", "[createVideoCgi] gameLife fromUserName:%s,toUserName:%s", new Object[] { parame.fLi, parame.toUser });
                  localObject2 = new l(((s)localObject2).fileName, ((s)localObject2).lQY, ((s)localObject2).lQZ, ((s)localObject2).lRa);
                  ((o.a)localObject1).fzz = new com.tencent.mm.plugin.byp.b.e(3, (String)localObject3, parame.fLi, parame.toUser, (l)localObject2);
                }
                else
                {
                  ((o.a)localObject1).fzz = new l(((s)localObject2).fileName, ((s)localObject2).lQY, ((s)localObject2).lQZ, ((s)localObject2).lRa);
                }
              }
            }
          }
          if (parame.lUB == o.d.lUm)
          {
            Log.i("MicroMsg.CreateSendMsgCgiCallback", "[createCdnImageCgi] constructorId=%s toUser=%s", new Object[] { Integer.valueOf(parame.lUq), parame.toUser });
            localObject1 = new o.a();
            if ((parame instanceof com.tencent.mm.ay.c))
            {
              localObject2 = (com.tencent.mm.ay.c)parame;
              if (!as.aEF(parame.toUser)) {
                break label1772;
              }
              localObject3 = parame.toUser;
              localObject4 = ((ab)com.tencent.mm.kernel.h.ae(ab.class)).aED((String)localObject3);
              parame.fLi = ((ab)com.tencent.mm.kernel.h.ae(ab.class)).aEE((String)localObject3);
              ((o.a)localObject1).fzz = new com.tencent.mm.plugin.byp.b.c(1, (String)localObject3, ((com.tencent.mm.ay.c)localObject2).fLi, (String)localObject4, (com.tencent.mm.ay.c)localObject2);
            }
            for (;;)
            {
              AppMethodBeat.o(287692);
              return localObject1;
              label1772:
              if (as.bvQ(parame.toUser))
              {
                localObject3 = parame.toUser;
                localObject4 = ((f)com.tencent.mm.kernel.h.ae(f.class)).aKJ((String)localObject3);
                String str = ((com.tencent.mm.plugin.gamelife.a.e)localObject4).apJ();
                parame.fLi = ((com.tencent.mm.plugin.gamelife.a.e)localObject4).getSelfUsername();
                ((o.a)localObject1).fzz = new com.tencent.mm.plugin.byp.b.c(3, (String)localObject3, ((com.tencent.mm.ay.c)localObject2).fLi, str, (com.tencent.mm.ay.c)localObject2);
              }
              else
              {
                ((o.a)localObject1).fzz = new o(((com.tencent.mm.ay.c)localObject2).jXU, ((com.tencent.mm.ay.c)localObject2).lNr, ((com.tencent.mm.ay.c)localObject2).lNs, ((com.tencent.mm.ay.c)localObject2).jYa, ((com.tencent.mm.ay.c)localObject2).lNt);
              }
            }
          }
          if (parame.lUB == o.d.lUn)
          {
            localObject1 = new o.a();
            if ((parame instanceof a))
            {
              localObject2 = (a)parame;
              if (as.bvQ(parame.toUser))
              {
                parame = parame.toUser;
                localObject3 = ((f)com.tencent.mm.kernel.h.ae(f.class)).aKJ(parame);
                ((a)localObject2).toUser = ((com.tencent.mm.plugin.gamelife.a.e)localObject3).apJ();
                ((a)localObject2).fLi = ((com.tencent.mm.plugin.gamelife.a.e)localObject3).getSelfUsername();
                ((o.a)localObject1).fzz = new b(parame, ((a)localObject2).fLi, ((a)localObject2).toUser, ((a)localObject2).jHh, ((a)localObject2).msgId);
              }
            }
            AppMethodBeat.o(287692);
            return localObject1;
          }
          AppMethodBeat.o(287692);
          return null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.h
 * JD-Core Version:    0.7.0.1
 */