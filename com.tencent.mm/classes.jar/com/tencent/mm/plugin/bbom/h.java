package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.n;
import com.tencent.mm.av.o;
import com.tencent.mm.av.s;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.modelmulti.o.a;
import com.tencent.mm.modelmulti.o.c;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.byp.b.b;
import com.tencent.mm.plugin.emoji.a;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.plugin.i.a.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;

public final class h
  implements o.c
{
  public final o.a a(o.e parame)
  {
    AppMethodBeat.i(231633);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject1;
    if (parame.jec == o.d.jdK)
    {
      localObject2 = new o.a();
      boolean bool1 = ((aa)com.tencent.mm.kernel.g.af(aa.class)).avl(parame.toUser);
      boolean bool2 = as.bju(parame.toUser);
      Log.i("MicroMsg.CreateSendMsgCgiCallback", "[createTextCgi] constructorId=%s toUser=%s isFinderMessage=%s isGameLifeMessage=%s", new Object[] { Integer.valueOf(parame.jdR), parame.toUser, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (bool1)
      {
        localObject3 = parame.toUser;
        localObject4 = ((aa)com.tencent.mm.kernel.g.af(aa.class)).avi((String)localObject3);
        if (as.bjt((String)localObject4))
        {
          localObject1 = z.aTY();
          parame.dRL = ((String)localObject1);
          parame = new com.tencent.mm.plugin.byp.b.d(1, (String)localObject3, parame.dRL, (String)localObject4, parame.content, parame.msgId);
          ((o.a)localObject2).jdI = parame.dCM.field_msgId;
          ((o.a)localObject2).dGJ = parame;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(231633);
        return localObject2;
        localObject1 = z.aUg();
        break;
        if (bool2)
        {
          localObject1 = parame.toUser;
          localObject3 = ((f)com.tencent.mm.kernel.g.af(f.class)).aAW((String)localObject1);
          parame.dRL = ((com.tencent.mm.plugin.gamelife.a.e)localObject3).getSelfUsername();
          parame = new com.tencent.mm.plugin.byp.b.d(3, (String)localObject1, parame.dRL, ((com.tencent.mm.plugin.gamelife.a.e)localObject3).ajO(), parame.content, parame.msgId);
          ((o.a)localObject2).jdI = parame.dCM.field_msgId;
          ((o.a)localObject2).dGJ = parame;
        }
        else if (parame.jdR == 5)
        {
          parame = new i(parame.toUser, parame.content, parame.type, parame.cSx, parame.jdQ);
          ((o.a)localObject2).jdI = parame.msgId;
          ((o.a)localObject2).dGJ = parame;
        }
        else if (parame.jdR == 4)
        {
          parame = new i(parame.toUser, parame.content, parame.type, parame.cSx);
          ((o.a)localObject2).jdI = parame.msgId;
          ((o.a)localObject2).dGJ = parame;
        }
        else if (parame.jdR == 2)
        {
          parame = new i(parame.msgId);
          ((o.a)localObject2).jdI = parame.msgId;
          ((o.a)localObject2).dGJ = parame;
        }
        else
        {
          parame = new i();
          ((o.a)localObject2).jdI = parame.msgId;
          ((o.a)localObject2).dGJ = parame;
        }
      }
    }
    if (parame.jec == o.d.jdL)
    {
      localObject3 = new o.a();
      Log.i("MicroMsg.CreateSendMsgCgiCallback", "[createImageCgi] constructorId=%s toUser=%s", new Object[] { Integer.valueOf(parame.jdR), parame.toUser });
      localObject1 = null;
      if (parame.jdR == 2)
      {
        localObject2 = new n(parame.jdZ, parame.iXp);
        localObject1 = localObject2;
        if (parame.hmr)
        {
          ((n)localObject2).bcE();
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((n)localObject1).bcD() != null)) {
        ((o.a)localObject3).jdI = ((n)localObject1).bcD().field_msgId;
      }
      ((o.a)localObject3).dGJ = ((q)localObject1);
      AppMethodBeat.o(231633);
      return localObject3;
      if (parame.jdR == 3)
      {
        localObject2 = new n(parame.jdZ, parame.iXp, parame.jdS);
        localObject1 = localObject2;
        if (parame.hmr)
        {
          ((n)localObject2).bcE();
          localObject1 = localObject2;
        }
      }
      else if (parame.jdR == 6)
      {
        localObject2 = new n(parame.hmk, parame.dRL, parame.toUser, parame.iZt, parame.iXp, parame.jdS);
        localObject1 = localObject2;
        if (parame.hmr)
        {
          ((n)localObject2).bcE();
          localObject1 = localObject2;
        }
      }
      else if (parame.jdR == 9)
      {
        localObject2 = new n(parame.hmk, parame.dRL, parame.toUser, parame.iZt, parame.iXp, parame.jdS, parame.dQd, parame.iXy, parame.thumbPath);
        localObject1 = localObject2;
        if (parame.hmr)
        {
          ((n)localObject2).bcE();
          localObject1 = localObject2;
        }
      }
      else if (parame.jdR == 10)
      {
        localObject2 = new n(parame.hmk, parame.dRL, parame.toUser, parame.iZt, parame.iXp, parame.jdS, parame.dQd, parame.jdT, parame.jdU);
        localObject1 = localObject2;
        if (parame.hmr)
        {
          ((n)localObject2).bcE();
          localObject1 = localObject2;
        }
      }
      else if (parame.jdR == 11)
      {
        localObject2 = new n(parame.hmk, parame.dRL, parame.toUser, parame.iZt, parame.iXp, parame.jdS, parame.dQd, parame.iXy, parame.thumbPath, parame.jdV, parame.jdU);
        localObject1 = localObject2;
        if (parame.hmr)
        {
          ((n)localObject2).bcE();
          localObject1 = localObject2;
        }
      }
      else if (parame.jdR == 13)
      {
        localObject2 = new n(parame.hmk, parame.dRL, parame.toUser, parame.iZt, parame.iXp, parame.jdS, parame.dQd, parame.iXy, parame.thumbPath, parame.jdV, parame.jdU, parame.jdW, parame.jdY);
        localObject1 = localObject2;
        if (parame.hmr)
        {
          ((n)localObject2).bcE();
          localObject1 = localObject2;
        }
      }
      else if (parame.jdR == 14)
      {
        localObject1 = new n(parame.jdZ, parame.hmk, parame.dRL, parame.toUser, parame.iZt, parame.iXp, parame.jdS, parame.dQd, parame.iXy, parame.thumbPath, parame.jdV, parame.jdU, parame.jea);
        if (parame.hmr) {
          ((n)localObject1).bcE();
        }
      }
      else if (parame.jdR == 19)
      {
        localObject2 = new n(parame.hmk, parame.dRL, parame.toUser, parame.iZt, parame.iXp, parame.jdS, parame.dQd, parame.iXy, parame.thumbPath, parame.jdV, parame.jdU, parame.jea, parame.jeb, parame.dTj, parame.latitude, parame.jdX, parame.jdW, parame.jdY);
        localObject1 = localObject2;
        if (parame.hmr)
        {
          ((n)localObject2).bcE();
          localObject1 = localObject2;
          continue;
          if (parame.jec == o.d.jdM)
          {
            localObject2 = new o.a();
            if ((parame instanceof s))
            {
              localObject3 = (s)parame;
              Log.i("MicroMsg.CreateSendMsgCgiCallback", "[createVideoCgi] constructorId=%s fileName=%s", new Object[] { Integer.valueOf(parame.jdR), ((s)localObject3).fileName });
              if (parame.jdR != 1) {
                break label1333;
              }
              ((o.a)localObject2).dGJ = new com.tencent.mm.modelvideo.g(((s)localObject3).fileName);
            }
            for (;;)
            {
              AppMethodBeat.o(231633);
              return localObject2;
              label1333:
              if (parame.jdR == 4)
              {
                if (ar.bjj(((s)localObject3).fileName))
                {
                  localObject4 = ((s)localObject3).jaC.field_toUser;
                  localObject1 = ((aa)com.tencent.mm.kernel.g.af(aa.class)).avi((String)localObject4);
                  parame.toUser = ((String)localObject1);
                  if (as.bjt((String)localObject1)) {}
                  for (localObject1 = z.aTY();; localObject1 = z.aUg())
                  {
                    parame.dRL = ((String)localObject1);
                    localObject1 = new com.tencent.mm.modelvideo.h(((s)localObject3).fileName, ((s)localObject3).jaB, ((s)localObject3).jaC, ((s)localObject3).jaD);
                    ((o.a)localObject2).dGJ = new com.tencent.mm.plugin.byp.b.e(1, (String)localObject4, parame.dRL, parame.toUser, (com.tencent.mm.modelvideo.h)localObject1);
                    break;
                  }
                }
                if (ar.bjk(((s)localObject3).fileName))
                {
                  localObject1 = ((s)localObject3).jaC.field_toUser;
                  localObject4 = ((f)com.tencent.mm.kernel.g.af(f.class)).aAW((String)localObject1);
                  parame.toUser = ((com.tencent.mm.plugin.gamelife.a.e)localObject4).ajO();
                  parame.dRL = ((com.tencent.mm.plugin.gamelife.a.e)localObject4).getSelfUsername();
                  Log.i("MicroMsg.CreateSendMsgCgiCallback", "[createVideoCgi] gameLife fromUserName:%s,toUserName:%s", new Object[] { parame.dRL, parame.toUser });
                  localObject3 = new com.tencent.mm.modelvideo.h(((s)localObject3).fileName, ((s)localObject3).jaB, ((s)localObject3).jaC, ((s)localObject3).jaD);
                  ((o.a)localObject2).dGJ = new com.tencent.mm.plugin.byp.b.e(3, (String)localObject1, parame.dRL, parame.toUser, (com.tencent.mm.modelvideo.h)localObject3);
                }
                else
                {
                  ((o.a)localObject2).dGJ = new com.tencent.mm.modelvideo.h(((s)localObject3).fileName, ((s)localObject3).jaB, ((s)localObject3).jaC, ((s)localObject3).jaD);
                }
              }
            }
          }
          if (parame.jec == o.d.jdN)
          {
            Log.i("MicroMsg.CreateSendMsgCgiCallback", "[createCdnImageCgi] constructorId=%s toUser=%s", new Object[] { Integer.valueOf(parame.jdR), parame.toUser });
            localObject2 = new o.a();
            String str;
            if ((parame instanceof com.tencent.mm.av.c))
            {
              localObject3 = (com.tencent.mm.av.c)parame;
              if (!as.avl(parame.toUser)) {
                break label1800;
              }
              localObject4 = parame.toUser;
              str = ((aa)com.tencent.mm.kernel.g.af(aa.class)).avi((String)localObject4);
              if (!as.bjt(str)) {
                break label1792;
              }
              localObject1 = z.aTY();
              parame.dRL = ((String)localObject1);
              ((o.a)localObject2).dGJ = new com.tencent.mm.plugin.byp.b.c(1, (String)localObject4, ((com.tencent.mm.av.c)localObject3).dRL, str, (com.tencent.mm.av.c)localObject3);
            }
            for (;;)
            {
              AppMethodBeat.o(231633);
              return localObject2;
              label1792:
              localObject1 = z.aUg();
              break;
              label1800:
              if (as.bju(parame.toUser))
              {
                localObject1 = parame.toUser;
                localObject4 = ((f)com.tencent.mm.kernel.g.af(f.class)).aAW((String)localObject1);
                str = ((com.tencent.mm.plugin.gamelife.a.e)localObject4).ajO();
                parame.dRL = ((com.tencent.mm.plugin.gamelife.a.e)localObject4).getSelfUsername();
                ((o.a)localObject2).dGJ = new com.tencent.mm.plugin.byp.b.c(3, (String)localObject1, ((com.tencent.mm.av.c)localObject3).dRL, str, (com.tencent.mm.av.c)localObject3);
              }
              else
              {
                ((o.a)localObject2).dGJ = new o(((com.tencent.mm.av.c)localObject3).hmk, ((com.tencent.mm.av.c)localObject3).iWW, ((com.tencent.mm.av.c)localObject3).iWX, ((com.tencent.mm.av.c)localObject3).hmq, ((com.tencent.mm.av.c)localObject3).iWY);
              }
            }
          }
          if (parame.jec == o.d.jdO)
          {
            localObject1 = new o.a();
            if ((parame instanceof a))
            {
              localObject2 = (a)parame;
              if (as.bju(parame.toUser))
              {
                parame = parame.toUser;
                localObject3 = ((f)com.tencent.mm.kernel.g.af(f.class)).aAW(parame);
                ((a)localObject2).toUser = ((com.tencent.mm.plugin.gamelife.a.e)localObject3).ajO();
                ((a)localObject2).dRL = ((com.tencent.mm.plugin.gamelife.a.e)localObject3).getSelfUsername();
                ((o.a)localObject1).dGJ = new b(parame, ((a)localObject2).dRL, ((a)localObject2).toUser, ((a)localObject2).gWm, ((a)localObject2).msgId);
              }
            }
            AppMethodBeat.o(231633);
            return localObject1;
          }
          AppMethodBeat.o(231633);
          return null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.h
 * JD-Core Version:    0.7.0.1
 */