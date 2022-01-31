package com.tencent.mm.bh;

import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.h.a.iy;
import com.tencent.mm.h.a.mn;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.z;

public final class e
  implements com.tencent.mm.ah.e
{
  public final void a(e.c paramc) {}
  
  public final e.b b(e.a parama)
  {
    int i = 0;
    Object localObject2 = parama.dBs;
    String str = aa.a(((cd)localObject2).svF);
    if ((!"fmessage".equals(str)) && (((cd)localObject2).kSW != 37)) {
      return null;
    }
    Object localObject1 = aa.a(((cd)localObject2).svH);
    parama = bi.d.acc((String)localObject1);
    Object localObject3 = q.Gj();
    if ((parama.pyp != null) && (parama.pyp.equals(localObject3)))
    {
      y.d("MicroMsg.VerifyMessageExtension", "onPreAddMessage, verify scene:%d, content:%s", new Object[] { Integer.valueOf(parama.scene), localObject1 });
      y.e("MicroMsg.VerifyMessageExtension", "fromUserName is self, simply drop this msg");
      return null;
    }
    localObject3 = new h();
    ((h)localObject3).username = parama.pyp;
    ((h)localObject3).cCq = 3;
    ((h)localObject3).bK(true);
    ((h)localObject3).bcw = -1;
    ((h)localObject3).ebT = parama.uBY;
    ((h)localObject3).ebS = parama.uBZ;
    y.d("MicroMsg.VerifyMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { parama.pyp, ((h)localObject3).JX(), ((h)localObject3).JY() });
    o.Kh().a((h)localObject3);
    if (!bk.bl(parama.pyp))
    {
      if (parama.scene == 18)
      {
        d.a((cd)localObject2, parama);
        au.Hx();
        com.tencent.mm.model.c.Dz().o(73729, Integer.valueOf(1));
        au.Hx();
        localObject1 = com.tencent.mm.model.c.Fw().abl(parama.uCl);
        if ((localObject1 == null) || ((int)((com.tencent.mm.n.a)localObject1).dBe <= 0))
        {
          am.a.dVy.a(parama.uCl, null, new e.1(this, parama));
          return null;
        }
        localObject2 = ((ao)localObject1).field_username;
        if ((localObject2 != null) && (!s.hj((String)localObject2)))
        {
          ((ad)localObject1).setUsername(parama.uCl);
          ((ad)localObject1).dq(null);
          au.Hx();
          com.tencent.mm.model.c.Fw().a((String)localObject2, (ad)localObject1);
        }
        localObject1 = new iy();
        ((iy)localObject1).bRi.bRj = parama.uCl;
        ((iy)localObject1).bRi.type = 1;
        com.tencent.mm.sdk.b.a.udP.m((b)localObject1);
        return null;
      }
      if (com.tencent.mm.model.bd.hR(parama.scene))
      {
        d.b((cd)localObject2, parama);
        au.Hx();
        com.tencent.mm.model.c.Dz().o(73730, Integer.valueOf(1));
        return null;
      }
      if (parama.scene == 48)
      {
        localObject3 = new mn();
        ((mn)localObject3).bVT.bVV = ((String)localObject1);
        ((mn)localObject3).bVT.talker = parama.pyp;
        com.tencent.mm.sdk.b.a.udP.m((b)localObject3);
      }
    }
    localObject1 = new ax();
    ((ax)localObject1).field_createTime = c.o(str, ((cd)localObject2).mPL);
    if (((cd)localObject2).hQq == 4) {
      i = 2;
    }
    ((ax)localObject1).field_isSend = (i + 0);
    ((ax)localObject1).field_msgContent = aa.a(((cd)localObject2).svH);
    ((ax)localObject1).field_svrId = ((cd)localObject2).ndp;
    ((ax)localObject1).field_talker = parama.pyp;
    au.Hx();
    localObject2 = com.tencent.mm.model.c.Fw().abl(parama.chatroomName);
    if ((localObject2 != null) && ((int)((com.tencent.mm.n.a)localObject2).dBe != -1)) {
      ((ax)localObject1).field_chatroomName = parama.chatroomName;
    }
    switch (parama.bNb)
    {
    case 3: 
    case 4: 
    default: 
      ((ax)localObject1).field_type = 1;
    }
    while (!bk.bl(parama.uCl))
    {
      ((ax)localObject1).field_encryptTalker = parama.uCl;
      if (d.RY().Hq(parama.uCl) != null)
      {
        parama = d.RX();
        localObject2 = ((ax)localObject1).field_encryptTalker;
        str = ((ax)localObject1).field_talker;
        localObject2 = "update fmessage_msginfo set talker = '" + bk.pl(str) + "'  where talker = '" + bk.pl((String)localObject2) + "'";
        parama.dXw.gk("fmessage_msginfo", (String)localObject2);
        d.RY().p(0L, ((ax)localObject1).field_encryptTalker);
      }
      d.RX().b((ax)localObject1);
      return null;
      ((ax)localObject1).field_type = 1;
      continue;
      ((ax)localObject1).field_type = 2;
      continue;
      ((ax)localObject1).field_type = 3;
    }
    y.e("MicroMsg.VerifyMessageExtension", "it should not go in here");
    parama = d.RY().abR(((ax)localObject1).field_talker);
    if (parama != null)
    {
      ((ax)localObject1).field_encryptTalker = parama.field_talker;
      ((ax)localObject1).field_talker = parama.field_talker;
    }
    d.RX().b((ax)localObject1);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bh.e
 * JD-Core Version:    0.7.0.1
 */