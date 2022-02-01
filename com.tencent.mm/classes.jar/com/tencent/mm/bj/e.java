package com.tencent.mm.bj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.g.a.lc;
import com.tencent.mm.g.a.pp;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv.d;

public final class e
  implements com.tencent.mm.ak.e
{
  public final e.b b(final e.a parama)
  {
    int i = 0;
    AppMethodBeat.i(20675);
    Object localObject2 = parama.gte;
    String str = z.a(((cv)localObject2).FNG);
    if ((!"fmessage".equals(str)) && (((cv)localObject2).urJ != 37))
    {
      AppMethodBeat.o(20675);
      return null;
    }
    Object localObject1 = z.a(((cv)localObject2).FNI);
    parama = bv.d.aVF((String)localObject1);
    Object localObject3 = v.aAC();
    if ((parama.cUA != null) && (parama.cUA.equals(localObject3)))
    {
      ae.d("MicroMsg.VerifyMessageExtension", "onPreAddMessage, verify scene:%d, content:%s", new Object[] { Integer.valueOf(parama.scene), localObject1 });
      ae.e("MicroMsg.VerifyMessageExtension", "fromUserName is self, simply drop this msg");
      AppMethodBeat.o(20675);
      return null;
    }
    localObject3 = new i();
    ((i)localObject3).username = parama.cUA;
    ((i)localObject3).eQU = 3;
    ((i)localObject3).eD(true);
    ((i)localObject3).dEu = -1;
    ((i)localObject3).hPQ = parama.JgV;
    ((i)localObject3).hPP = parama.JgW;
    ae.d("MicroMsg.VerifyMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { parama.cUA, ((i)localObject3).aEG(), ((i)localObject3).aEH() });
    p.aEN().b((i)localObject3);
    if (!bu.isNullOrNil(parama.cUA))
    {
      if (parama.scene == 18)
      {
        d.a((cv)localObject2, parama);
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(73729, Integer.valueOf(1));
        bc.aCg();
        localObject1 = com.tencent.mm.model.c.azF().BH(parama.Jhi);
        if ((localObject1 == null) || ((int)((com.tencent.mm.contact.c)localObject1).ght <= 0)) {
          au.a.hIG.a(parama.Jhi, null, new au.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(20674);
              bc.aCg();
              ae.d("MicroMsg.VerifyMessageExtension", String.valueOf(com.tencent.mm.model.c.azF().BH(parama.Jhi)));
              paramAnonymousString = new lc();
              paramAnonymousString.dzq.dzr = parama.Jhi;
              paramAnonymousString.dzq.type = 1;
              a.IvT.l(paramAnonymousString);
              AppMethodBeat.o(20674);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(20675);
          return null;
          localObject2 = ((aw)localObject1).field_username;
          if ((localObject2 != null) && (!x.Am((String)localObject2)))
          {
            ((an)localObject1).setUsername(parama.Jhi);
            ((an)localObject1).tu(null);
            bc.aCg();
            com.tencent.mm.model.c.azF().c((String)localObject2, (an)localObject1);
          }
          localObject1 = new lc();
          ((lc)localObject1).dzq.dzr = parama.Jhi;
          ((lc)localObject1).dzq.type = 1;
          a.IvT.l((b)localObject1);
        }
      }
      if (bl.oA(parama.scene))
      {
        d.b((cv)localObject2, parama);
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(73730, Integer.valueOf(1));
        AppMethodBeat.o(20675);
        return null;
      }
      if (parama.scene == 48)
      {
        localObject3 = new pp();
        ((pp)localObject3).dES.dEU = ((String)localObject1);
        ((pp)localObject3).dES.talker = parama.cUA;
        a.IvT.l((b)localObject3);
      }
    }
    localObject1 = new bi();
    ((bi)localObject1).field_createTime = c.B(str, ((cv)localObject2).CreateTime);
    if (((cv)localObject2).nJb == 4) {
      i = 2;
    }
    ((bi)localObject1).field_isSend = (i + 0);
    ((bi)localObject1).field_msgContent = z.a(((cv)localObject2).FNI);
    ((bi)localObject1).field_svrId = ((cv)localObject2).xrk;
    ((bi)localObject1).field_talker = parama.cUA;
    bc.aCg();
    localObject2 = com.tencent.mm.model.c.azF().BH(parama.chatroomName);
    if ((localObject2 != null) && ((int)((com.tencent.mm.contact.c)localObject2).ght != -1)) {
      ((bi)localObject1).field_chatroomName = parama.chatroomName;
    }
    switch (parama.dto)
    {
    case 3: 
    case 4: 
    default: 
      ((bi)localObject1).field_type = 1;
      if (!bu.isNullOrNil(parama.Jhi))
      {
        ((bi)localObject1).field_encryptTalker = parama.Jhi;
        if (d.aMM().aqQ(parama.Jhi) != null)
        {
          parama = d.aML();
          localObject2 = ((bi)localObject1).field_encryptTalker;
          str = ((bi)localObject1).field_talker;
          localObject2 = "update fmessage_msginfo set talker = '" + bu.aSk(str) + "'  where talker = '" + bu.aSk((String)localObject2) + "'";
          parama.db.execSQL("fmessage_msginfo", (String)localObject2);
          d.aMM().t(0L, ((bi)localObject1).field_encryptTalker);
        }
        d.aML().b((bi)localObject1);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(20675);
      return null;
      ((bi)localObject1).field_type = 1;
      break;
      ((bi)localObject1).field_type = 2;
      break;
      ((bi)localObject1).field_type = 3;
      break;
      ae.e("MicroMsg.VerifyMessageExtension", "it should not go in here");
      parama = d.aMM().aVv(((bi)localObject1).field_talker);
      if (parama != null)
      {
        ((bi)localObject1).field_encryptTalker = parama.field_talker;
        ((bi)localObject1).field_talker = parama.field_talker;
      }
      d.aML().b((bi)localObject1);
    }
  }
  
  public final void b(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bj.e
 * JD-Core Version:    0.7.0.1
 */