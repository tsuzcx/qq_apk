package com.tencent.mm.bj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo.d;

public final class e
  implements f
{
  public final f.b b(final f.a parama)
  {
    int i = 0;
    AppMethodBeat.i(20675);
    Object localObject2 = parama.fXi;
    String str = z.a(((cu)localObject2).DPT);
    if ((!"fmessage".equals(str)) && (((cu)localObject2).tit != 37))
    {
      AppMethodBeat.o(20675);
      return null;
    }
    Object localObject1 = z.a(((cu)localObject2).DPV);
    parama = bo.d.aOn((String)localObject1);
    Object localObject3 = u.axw();
    if ((parama.zTO != null) && (parama.zTO.equals(localObject3)))
    {
      ac.d("MicroMsg.VerifyMessageExtension", "onPreAddMessage, verify scene:%d, content:%s", new Object[] { Integer.valueOf(parama.scene), localObject1 });
      ac.e("MicroMsg.VerifyMessageExtension", "fromUserName is self, simply drop this msg");
      AppMethodBeat.o(20675);
      return null;
    }
    localObject3 = new i();
    ((i)localObject3).username = parama.zTO;
    ((i)localObject3).exK = 3;
    ((i)localObject3).ez(true);
    ((i)localObject3).drx = -1;
    ((i)localObject3).huF = parama.GYZ;
    ((i)localObject3).huE = parama.GZa;
    ac.d("MicroMsg.VerifyMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { parama.zTO, ((i)localObject3).aBo(), ((i)localObject3).aBp() });
    p.aBw().b((i)localObject3);
    if (!bs.isNullOrNil(parama.zTO))
    {
      if (parama.scene == 18)
      {
        d.a((cu)localObject2, parama);
        az.ayM();
        com.tencent.mm.model.c.agA().set(73729, Integer.valueOf(1));
        az.ayM();
        localObject1 = com.tencent.mm.model.c.awB().aNt(parama.GZm);
        if ((localObject1 == null) || ((int)((com.tencent.mm.n.b)localObject1).fLJ <= 0)) {
          ar.a.hnw.a(parama.GZm, null, new ar.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(20674);
              az.ayM();
              ac.d("MicroMsg.VerifyMessageExtension", String.valueOf(com.tencent.mm.model.c.awB().aNt(parama.GZm)));
              paramAnonymousString = new ks();
              paramAnonymousString.dmx.dmy = parama.GZm;
              paramAnonymousString.dmx.type = 1;
              a.GpY.l(paramAnonymousString);
              AppMethodBeat.o(20674);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(20675);
          return null;
          localObject2 = ((av)localObject1).field_username;
          if ((localObject2 != null) && (!w.wF((String)localObject2)))
          {
            ((ai)localObject1).setUsername(parama.GZm);
            ((ai)localObject1).qp(null);
            az.ayM();
            com.tencent.mm.model.c.awB().c((String)localObject2, (ai)localObject1);
          }
          localObject1 = new ks();
          ((ks)localObject1).dmx.dmy = parama.GZm;
          ((ks)localObject1).dmx.type = 1;
          a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
        }
      }
      if (bi.nX(parama.scene))
      {
        d.b((cu)localObject2, parama);
        az.ayM();
        com.tencent.mm.model.c.agA().set(73730, Integer.valueOf(1));
        AppMethodBeat.o(20675);
        return null;
      }
      if (parama.scene == 48)
      {
        localObject3 = new pe();
        ((pe)localObject3).drT.drV = ((String)localObject1);
        ((pe)localObject3).drT.talker = parama.zTO;
        a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
      }
    }
    localObject1 = new bd();
    ((bd)localObject1).field_createTime = c.z(str, ((cu)localObject2).CreateTime);
    if (((cu)localObject2).ndj == 4) {
      i = 2;
    }
    ((bd)localObject1).field_isSend = (i + 0);
    ((bd)localObject1).field_msgContent = z.a(((cu)localObject2).DPV);
    ((bd)localObject1).field_svrId = ((cu)localObject2).vTQ;
    ((bd)localObject1).field_talker = parama.zTO;
    az.ayM();
    localObject2 = com.tencent.mm.model.c.awB().aNt(parama.chatroomName);
    if ((localObject2 != null) && ((int)((com.tencent.mm.n.b)localObject2).fLJ != -1)) {
      ((bd)localObject1).field_chatroomName = parama.chatroomName;
    }
    switch (parama.dgL)
    {
    case 3: 
    case 4: 
    default: 
      ((bd)localObject1).field_type = 1;
      if (!bs.isNullOrNil(parama.GZm))
      {
        ((bd)localObject1).field_encryptTalker = parama.GZm;
        if (d.aJe().akZ(parama.GZm) != null)
        {
          parama = d.aJd();
          localObject2 = ((bd)localObject1).field_encryptTalker;
          str = ((bd)localObject1).field_talker;
          localObject2 = "update fmessage_msginfo set talker = '" + bs.aLh(str) + "'  where talker = '" + bs.aLh((String)localObject2) + "'";
          parama.db.execSQL("fmessage_msginfo", (String)localObject2);
          d.aJe().s(0L, ((bd)localObject1).field_encryptTalker);
        }
        d.aJd().b((bd)localObject1);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(20675);
      return null;
      ((bd)localObject1).field_type = 1;
      break;
      ((bd)localObject1).field_type = 2;
      break;
      ((bd)localObject1).field_type = 3;
      break;
      ac.e("MicroMsg.VerifyMessageExtension", "it should not go in here");
      parama = d.aJe().aOd(((bd)localObject1).field_talker);
      if (parama != null)
      {
        ((bd)localObject1).field_encryptTalker = parama.field_talker;
        ((bd)localObject1).field_talker = parama.field_talker;
      }
      d.aJd().b((bd)localObject1);
    }
  }
  
  public final void b(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bj.e
 * JD-Core Version:    0.7.0.1
 */