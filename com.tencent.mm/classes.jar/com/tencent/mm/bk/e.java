package com.tencent.mm.bk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.e.c;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.g.a.po;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu.d;

public final class e
  implements com.tencent.mm.al.e
{
  public final e.b b(final e.a parama)
  {
    int i = 0;
    AppMethodBeat.i(20675);
    Object localObject2 = parama.gqE;
    String str = z.a(((cv)localObject2).Fvi);
    if ((!"fmessage".equals(str)) && (((cv)localObject2).ugm != 37))
    {
      AppMethodBeat.o(20675);
      return null;
    }
    Object localObject1 = z.a(((cv)localObject2).Fvk);
    parama = bu.d.aUe((String)localObject1);
    Object localObject3 = u.aAm();
    if ((parama.dHm != null) && (parama.dHm.equals(localObject3)))
    {
      ad.d("MicroMsg.VerifyMessageExtension", "onPreAddMessage, verify scene:%d, content:%s", new Object[] { Integer.valueOf(parama.scene), localObject1 });
      ad.e("MicroMsg.VerifyMessageExtension", "fromUserName is self, simply drop this msg");
      AppMethodBeat.o(20675);
      return null;
    }
    localObject3 = new i();
    ((i)localObject3).username = parama.dHm;
    ((i)localObject3).ePj = 3;
    ((i)localObject3).eB(true);
    ((i)localObject3).dDp = -1;
    ((i)localObject3).hMX = parama.IMo;
    ((i)localObject3).hMW = parama.IMp;
    ad.d("MicroMsg.VerifyMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { parama.dHm, ((i)localObject3).aEq(), ((i)localObject3).aEr() });
    p.aEx().b((i)localObject3);
    if (!bt.isNullOrNil(parama.dHm))
    {
      if (parama.scene == 18)
      {
        d.a((cv)localObject2, parama);
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(73729, Integer.valueOf(1));
        ba.aBQ();
        localObject1 = com.tencent.mm.model.c.azp().Bf(parama.IMB);
        if ((localObject1 == null) || ((int)((com.tencent.mm.o.b)localObject1).gfj <= 0)) {
          as.a.hFO.a(parama.IMB, null, new as.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(20674);
              ba.aBQ();
              ad.d("MicroMsg.VerifyMessageExtension", String.valueOf(com.tencent.mm.model.c.azp().Bf(parama.IMB)));
              paramAnonymousString = new lb();
              paramAnonymousString.dyl.dym = parama.IMB;
              paramAnonymousString.dyl.type = 1;
              a.IbL.l(paramAnonymousString);
              AppMethodBeat.o(20674);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(20675);
          return null;
          localObject2 = ((aw)localObject1).field_username;
          if ((localObject2 != null) && (!w.zC((String)localObject2)))
          {
            ((am)localObject1).setUsername(parama.IMB);
            ((am)localObject1).sZ(null);
            ba.aBQ();
            com.tencent.mm.model.c.azp().c((String)localObject2, (am)localObject1);
          }
          localObject1 = new lb();
          ((lb)localObject1).dyl.dym = parama.IMB;
          ((lb)localObject1).dyl.type = 1;
          a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
        }
      }
      if (bj.ox(parama.scene))
      {
        d.b((cv)localObject2, parama);
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(73730, Integer.valueOf(1));
        AppMethodBeat.o(20675);
        return null;
      }
      if (parama.scene == 48)
      {
        localObject3 = new po();
        ((po)localObject3).dDN.dDP = ((String)localObject1);
        ((po)localObject3).dDN.talker = parama.dHm;
        a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
      }
    }
    localObject1 = new bh();
    ((bh)localObject1).field_createTime = c.B(str, ((cv)localObject2).CreateTime);
    if (((cv)localObject2).nDG == 4) {
      i = 2;
    }
    ((bh)localObject1).field_isSend = (i + 0);
    ((bh)localObject1).field_msgContent = z.a(((cv)localObject2).Fvk);
    ((bh)localObject1).field_svrId = ((cv)localObject2).xbt;
    ((bh)localObject1).field_talker = parama.dHm;
    ba.aBQ();
    localObject2 = com.tencent.mm.model.c.azp().Bf(parama.chatroomName);
    if ((localObject2 != null) && ((int)((com.tencent.mm.o.b)localObject2).gfj != -1)) {
      ((bh)localObject1).field_chatroomName = parama.chatroomName;
    }
    switch (parama.dsi)
    {
    case 3: 
    case 4: 
    default: 
      ((bh)localObject1).field_type = 1;
      if (!bt.isNullOrNil(parama.IMB))
      {
        ((bh)localObject1).field_encryptTalker = parama.IMB;
        if (d.aMo().apL(parama.IMB) != null)
        {
          parama = d.aMn();
          localObject2 = ((bh)localObject1).field_encryptTalker;
          str = ((bh)localObject1).field_talker;
          localObject2 = "update fmessage_msginfo set talker = '" + bt.aQN(str) + "'  where talker = '" + bt.aQN((String)localObject2) + "'";
          parama.db.execSQL("fmessage_msginfo", (String)localObject2);
          d.aMo().t(0L, ((bh)localObject1).field_encryptTalker);
        }
        d.aMn().b((bh)localObject1);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(20675);
      return null;
      ((bh)localObject1).field_type = 1;
      break;
      ((bh)localObject1).field_type = 2;
      break;
      ((bh)localObject1).field_type = 3;
      break;
      ad.e("MicroMsg.VerifyMessageExtension", "it should not go in here");
      parama = d.aMo().aTU(((bh)localObject1).field_talker);
      if (parama != null)
      {
        ((bh)localObject1).field_encryptTalker = parama.field_talker;
        ((bh)localObject1).field_talker = parama.field_talker;
      }
      d.aMn().b((bh)localObject1);
    }
  }
  
  public final void b(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bk.e
 * JD-Core Version:    0.7.0.1
 */