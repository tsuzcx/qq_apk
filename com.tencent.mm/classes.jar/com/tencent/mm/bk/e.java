package com.tencent.mm.bk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.f;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.al.f.c;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.g.a.ov;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl.d;

public final class e
  implements f
{
  public final f.b b(final f.a parama)
  {
    int i = 0;
    AppMethodBeat.i(20675);
    Object localObject2 = parama.fTo;
    String str = z.a(((cs)localObject2).Cxx);
    if ((!"fmessage".equals(str)) && (((cs)localObject2).saz != 37))
    {
      AppMethodBeat.o(20675);
      return null;
    }
    Object localObject1 = z.a(((cs)localObject2).Cxz);
    parama = bl.d.aIR((String)localObject1);
    Object localObject3 = u.aqG();
    if ((parama.yGA != null) && (parama.yGA.equals(localObject3)))
    {
      ad.d("MicroMsg.VerifyMessageExtension", "onPreAddMessage, verify scene:%d, content:%s", new Object[] { Integer.valueOf(parama.scene), localObject1 });
      ad.e("MicroMsg.VerifyMessageExtension", "fromUserName is self, simply drop this msg");
      AppMethodBeat.o(20675);
      return null;
    }
    localObject3 = new i();
    ((i)localObject3).username = parama.yGA;
    ((i)localObject3).evo = 3;
    ((i)localObject3).ee(true);
    ((i)localObject3).dtM = -1;
    ((i)localObject3).gUg = parama.FzX;
    ((i)localObject3).gUf = parama.FzY;
    ad.d("MicroMsg.VerifyMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { parama.yGA, ((i)localObject3).aux(), ((i)localObject3).auy() });
    p.auF().b((i)localObject3);
    if (!bt.isNullOrNil(parama.yGA))
    {
      if (parama.scene == 18)
      {
        d.a((cs)localObject2, parama);
        com.tencent.mm.model.az.arV();
        com.tencent.mm.model.c.afk().set(73729, Integer.valueOf(1));
        com.tencent.mm.model.az.arV();
        localObject1 = com.tencent.mm.model.c.apM().aHY(parama.FAk);
        if ((localObject1 == null) || ((int)((com.tencent.mm.n.b)localObject1).fId <= 0)) {
          ar.a.gMW.a(parama.FAk, null, new ar.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(20674);
              com.tencent.mm.model.az.arV();
              ad.d("MicroMsg.VerifyMessageExtension", String.valueOf(com.tencent.mm.model.c.apM().aHY(parama.FAk)));
              paramAnonymousString = new kk();
              paramAnonymousString.doP.doQ = parama.FAk;
              paramAnonymousString.doP.type = 1;
              a.ESL.l(paramAnonymousString);
              AppMethodBeat.o(20674);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(20675);
          return null;
          localObject2 = ((au)localObject1).field_username;
          if ((localObject2 != null) && (!w.sC((String)localObject2)))
          {
            ((af)localObject1).setUsername(parama.FAk);
            ((af)localObject1).nj(null);
            com.tencent.mm.model.az.arV();
            com.tencent.mm.model.c.apM().c((String)localObject2, (af)localObject1);
          }
          localObject1 = new kk();
          ((kk)localObject1).doP.doQ = parama.FAk;
          ((kk)localObject1).doP.type = 1;
          a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        }
      }
      if (bi.nj(parama.scene))
      {
        d.b((cs)localObject2, parama);
        com.tencent.mm.model.az.arV();
        com.tencent.mm.model.c.afk().set(73730, Integer.valueOf(1));
        AppMethodBeat.o(20675);
        return null;
      }
      if (parama.scene == 48)
      {
        localObject3 = new ov();
        ((ov)localObject3).dui.duk = ((String)localObject1);
        ((ov)localObject3).dui.talker = parama.yGA;
        a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
      }
    }
    localObject1 = new ba();
    ((ba)localObject1).field_createTime = c.y(str, ((cs)localObject2).CreateTime);
    if (((cs)localObject2).mBi == 4) {
      i = 2;
    }
    ((ba)localObject1).field_isSend = (i + 0);
    ((ba)localObject1).field_msgContent = z.a(((cs)localObject2).Cxz);
    ((ba)localObject1).field_svrId = ((cs)localObject2).uKZ;
    ((ba)localObject1).field_talker = parama.yGA;
    com.tencent.mm.model.az.arV();
    localObject2 = com.tencent.mm.model.c.apM().aHY(parama.chatroomName);
    if ((localObject2 != null) && ((int)((com.tencent.mm.n.b)localObject2).fId != -1)) {
      ((ba)localObject1).field_chatroomName = parama.chatroomName;
    }
    switch (parama.djq)
    {
    case 3: 
    case 4: 
    default: 
      ((ba)localObject1).field_type = 1;
      if (!bt.isNullOrNil(parama.FAk))
      {
        ((ba)localObject1).field_encryptTalker = parama.FAk;
        if (d.aCo().agf(parama.FAk) != null)
        {
          parama = d.aCn();
          localObject2 = ((ba)localObject1).field_encryptTalker;
          str = ((ba)localObject1).field_talker;
          localObject2 = "update fmessage_msginfo set talker = '" + bt.aFQ(str) + "'  where talker = '" + bt.aFQ((String)localObject2) + "'";
          parama.db.execSQL("fmessage_msginfo", (String)localObject2);
          d.aCo().u(0L, ((ba)localObject1).field_encryptTalker);
        }
        d.aCn().b((ba)localObject1);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(20675);
      return null;
      ((ba)localObject1).field_type = 1;
      break;
      ((ba)localObject1).field_type = 2;
      break;
      ((ba)localObject1).field_type = 3;
      break;
      ad.e("MicroMsg.VerifyMessageExtension", "it should not go in here");
      parama = d.aCo().aIH(((ba)localObject1).field_talker);
      if (parama != null)
      {
        ((ba)localObject1).field_encryptTalker = parama.field_talker;
        ((ba)localObject1).field_talker = parama.field_talker;
      }
      d.aCn().b((ba)localObject1);
    }
  }
  
  public final void b(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bk.e
 * JD-Core Version:    0.7.0.1
 */