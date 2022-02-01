package com.tencent.mm.bl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.am.q;
import com.tencent.mm.an.h;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.an.h.c;
import com.tencent.mm.f.a.mj;
import com.tencent.mm.f.a.rh;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca.d;

public final class e
  implements h
{
  public final h.b b(final h.a parama)
  {
    int i = 0;
    AppMethodBeat.i(20675);
    Object localObject2 = parama.jQG;
    String str = com.tencent.mm.platformtools.z.a(((db)localObject2).RID);
    if ((!"fmessage".equals(str)) && (((db)localObject2).COi != 37))
    {
      AppMethodBeat.o(20675);
      return null;
    }
    Object localObject1 = com.tencent.mm.platformtools.z.a(((db)localObject2).RIF);
    parama = ca.d.bxc((String)localObject1);
    Object localObject3 = com.tencent.mm.model.z.bcZ();
    if ((parama.fcC != null) && (parama.fcC.equals(localObject3)))
    {
      Log.d("MicroMsg.VerifyMessageExtension", "onPreAddMessage, verify scene:%d, content:%s", new Object[] { Integer.valueOf(parama.scene), localObject1 });
      Log.e("MicroMsg.VerifyMessageExtension", "fromUserName is self, simply drop this msg");
      AppMethodBeat.o(20675);
      return null;
    }
    localObject3 = new j();
    ((j)localObject3).username = parama.fcC;
    ((j)localObject3).hDc = 3;
    ((j)localObject3).gg(true);
    ((j)localObject3).cUP = -1;
    ((j)localObject3).lBe = parama.VGI;
    ((j)localObject3).lBd = parama.VGJ;
    Log.d("MicroMsg.VerifyMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { parama.fcC, ((j)localObject3).bhH(), ((j)localObject3).bhI() });
    q.bhP().b((j)localObject3);
    if (!Util.isNullOrNil(parama.fcC))
    {
      if (parama.scene == 18)
      {
        d.a((db)localObject2, parama);
        bh.beI();
        com.tencent.mm.model.c.aHp().i(73729, Integer.valueOf(1));
        bh.beI();
        localObject1 = com.tencent.mm.model.c.bbL().RG(parama.VGV);
        if ((localObject1 == null) || ((int)((com.tencent.mm.contact.d)localObject1).jxt <= 0)) {
          az.a.ltq.a(parama.VGV, null, new az.b.a()
          {
            public final void s(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(20674);
              bh.beI();
              Log.d("MicroMsg.VerifyMessageExtension", String.valueOf(com.tencent.mm.model.c.bbL().RG(parama.VGV)));
              paramAnonymousString = new mj();
              paramAnonymousString.fKt.fKu = parama.VGV;
              paramAnonymousString.fKt.type = 1;
              EventCenter.instance.publish(paramAnonymousString);
              AppMethodBeat.o(20674);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(20675);
          return null;
          localObject2 = ((ax)localObject1).field_username;
          if ((localObject2 != null) && (!ab.Qk((String)localObject2)))
          {
            ((as)localObject1).setUsername(parama.VGV);
            ((as)localObject1).Iy(null);
            bh.beI();
            com.tencent.mm.model.c.bbL().c((String)localObject2, (as)localObject1);
          }
          localObject1 = new mj();
          ((mj)localObject1).fKt.fKu = parama.VGV;
          ((mj)localObject1).fKt.type = 1;
          EventCenter.instance.publish((IEvent)localObject1);
        }
      }
      if (bq.uY(parama.scene))
      {
        d.b((db)localObject2, parama);
        bh.beI();
        com.tencent.mm.model.c.aHp().i(73730, Integer.valueOf(1));
        AppMethodBeat.o(20675);
        return null;
      }
      if (parama.scene == 48)
      {
        localObject3 = new rh();
        ((rh)localObject3).fQq.fQs = ((String)localObject1);
        ((rh)localObject3).fQq.talker = parama.fcC;
        EventCenter.instance.publish((IEvent)localObject3);
      }
    }
    localObject1 = new bn();
    ((bn)localObject1).field_createTime = c.z(str, ((db)localObject2).CreateTime);
    if (((db)localObject2).rVU == 4) {
      i = 2;
    }
    ((bn)localObject1).field_isSend = (i + 0);
    ((bn)localObject1).field_msgContent = com.tencent.mm.platformtools.z.a(((db)localObject2).RIF);
    ((bn)localObject1).field_svrId = ((db)localObject2).HlH;
    ((bn)localObject1).field_talker = parama.fcC;
    bh.beI();
    localObject2 = com.tencent.mm.model.c.bbL().RG(parama.chatroomName);
    if ((localObject2 != null) && ((int)((com.tencent.mm.contact.d)localObject2).jxt != -1)) {
      ((bn)localObject1).field_chatroomName = parama.chatroomName;
    }
    switch (parama.fDn)
    {
    case 3: 
    case 4: 
    default: 
      ((bn)localObject1).field_type = 1;
      if (!Util.isNullOrNil(parama.VGV))
      {
        ((bn)localObject1).field_encryptTalker = parama.VGV;
        if (d.bqc().aOv(parama.VGV) != null)
        {
          parama = d.bqb();
          localObject2 = ((bn)localObject1).field_encryptTalker;
          str = ((bn)localObject1).field_talker;
          localObject2 = "update fmessage_msginfo set talker = '" + Util.escapeSqlValue(str) + "'  where talker = '" + Util.escapeSqlValue((String)localObject2) + "'";
          parama.db.execSQL("fmessage_msginfo", (String)localObject2);
          d.bqc().E(0L, ((bn)localObject1).field_encryptTalker);
        }
        d.bqb().b((bn)localObject1);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(20675);
      return null;
      ((bn)localObject1).field_type = 1;
      break;
      ((bn)localObject1).field_type = 2;
      break;
      ((bn)localObject1).field_type = 3;
      break;
      Log.e("MicroMsg.VerifyMessageExtension", "it should not go in here");
      parama = d.bqc().bwS(((bn)localObject1).field_talker);
      if (parama != null)
      {
        ((bn)localObject1).field_encryptTalker = parama.field_talker;
        ((bn)localObject1).field_talker = parama.field_talker;
      }
      d.bqb().b((bn)localObject1);
    }
  }
  
  public final void b(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bl.e
 * JD-Core Version:    0.7.0.1
 */