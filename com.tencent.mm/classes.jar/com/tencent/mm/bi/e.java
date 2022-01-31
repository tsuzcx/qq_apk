package com.tencent.mm.bi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.g.a.jh;
import com.tencent.mm.g.a.ni;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.z;

public final class e
  implements com.tencent.mm.ai.e
{
  public final void a(e.c paramc) {}
  
  public final e.b b(e.a parama)
  {
    int i = 0;
    AppMethodBeat.i(16632);
    Object localObject2 = parama.eyJ;
    String str = aa.a(((cm)localObject2).woP);
    if ((!"fmessage".equals(str)) && (((cm)localObject2).nqW != 37))
    {
      AppMethodBeat.o(16632);
      return null;
    }
    Object localObject1 = aa.a(((cm)localObject2).woR);
    parama = bi.d.asm((String)localObject1);
    Object localObject3 = r.Zn();
    if ((parama.tac != null) && (parama.tac.equals(localObject3)))
    {
      ab.d("MicroMsg.VerifyMessageExtension", "onPreAddMessage, verify scene:%d, content:%s", new Object[] { Integer.valueOf(parama.scene), localObject1 });
      ab.e("MicroMsg.VerifyMessageExtension", "fromUserName is self, simply drop this msg");
      AppMethodBeat.o(16632);
      return null;
    }
    localObject3 = new h();
    ((h)localObject3).username = parama.tac;
    ((h)localObject3).dqB = 3;
    ((h)localObject3).cM(true);
    ((h)localObject3).bsY = -1;
    ((h)localObject3).fsl = parama.yOk;
    ((h)localObject3).fsk = parama.yOl;
    ab.d("MicroMsg.VerifyMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { parama.tac, ((h)localObject3).acX(), ((h)localObject3).acY() });
    o.adg().b((h)localObject3);
    if (!bo.isNullOrNil(parama.tac))
    {
      if (parama.scene == 18)
      {
        d.a((cm)localObject2, parama);
        com.tencent.mm.model.aw.aaz();
        com.tencent.mm.model.c.Ru().set(73729, Integer.valueOf(1));
        com.tencent.mm.model.aw.aaz();
        localObject1 = com.tencent.mm.model.c.YA().arw(parama.yOx);
        if ((localObject1 == null) || ((int)((com.tencent.mm.n.a)localObject1).euF <= 0)) {
          ao.a.flI.a(parama.yOx, null, new e.1(this, parama));
        }
        for (;;)
        {
          AppMethodBeat.o(16632);
          return null;
          localObject2 = ((aq)localObject1).field_username;
          if ((localObject2 != null) && (!t.nS((String)localObject2)))
          {
            ((ad)localObject1).setUsername(parama.yOx);
            ((ad)localObject1).jv(null);
            com.tencent.mm.model.aw.aaz();
            com.tencent.mm.model.c.YA().b((String)localObject2, (ad)localObject1);
          }
          localObject1 = new jh();
          ((jh)localObject1).cyK.cyL = parama.yOx;
          ((jh)localObject1).cyK.type = 1;
          com.tencent.mm.sdk.b.a.ymk.l((b)localObject1);
        }
      }
      if (bf.kD(parama.scene))
      {
        d.b((cm)localObject2, parama);
        com.tencent.mm.model.aw.aaz();
        com.tencent.mm.model.c.Ru().set(73730, Integer.valueOf(1));
        AppMethodBeat.o(16632);
        return null;
      }
      if (parama.scene == 48)
      {
        localObject3 = new ni();
        ((ni)localObject3).cDG.cDI = ((String)localObject1);
        ((ni)localObject3).cDG.talker = parama.tac;
        com.tencent.mm.sdk.b.a.ymk.l((b)localObject3);
      }
    }
    localObject1 = new ax();
    ((ax)localObject1).field_createTime = c.x(str, ((cm)localObject2).CreateTime);
    if (((cm)localObject2).jJS == 4) {
      i = 2;
    }
    ((ax)localObject1).field_isSend = (i + 0);
    ((ax)localObject1).field_msgContent = aa.a(((cm)localObject2).woR);
    ((ax)localObject1).field_svrId = ((cm)localObject2).pIG;
    ((ax)localObject1).field_talker = parama.tac;
    com.tencent.mm.model.aw.aaz();
    localObject2 = com.tencent.mm.model.c.YA().arw(parama.chatroomName);
    if ((localObject2 != null) && ((int)((com.tencent.mm.n.a)localObject2).euF != -1)) {
      ((ax)localObject1).field_chatroomName = parama.chatroomName;
    }
    switch (parama.cut)
    {
    case 3: 
    case 4: 
    default: 
      ((ax)localObject1).field_type = 1;
      if (!bo.isNullOrNil(parama.yOx))
      {
        ((ax)localObject1).field_encryptTalker = parama.yOx;
        if (d.ali().Tc(parama.yOx) != null)
        {
          parama = d.alh();
          localObject2 = ((ax)localObject1).field_encryptTalker;
          str = ((ax)localObject1).field_talker;
          localObject2 = "update fmessage_msginfo set talker = '" + bo.wC(str) + "'  where talker = '" + bo.wC((String)localObject2) + "'";
          parama.db.execSQL("fmessage_msginfo", (String)localObject2);
          d.ali().p(0L, ((ax)localObject1).field_encryptTalker);
        }
        d.alh().b((ax)localObject1);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(16632);
      return null;
      ((ax)localObject1).field_type = 1;
      break;
      ((ax)localObject1).field_type = 2;
      break;
      ((ax)localObject1).field_type = 3;
      break;
      ab.e("MicroMsg.VerifyMessageExtension", "it should not go in here");
      parama = d.ali().asb(((ax)localObject1).field_talker);
      if (parama != null)
      {
        ((ax)localObject1).field_encryptTalker = parama.field_talker;
        ((ax)localObject1).field_talker = parama.field_talker;
      }
      d.alh().b((ax)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bi.e
 * JD-Core Version:    0.7.0.1
 */