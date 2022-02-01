package com.tencent.mm.bj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.protocal.protobuf.de;
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
    Object localObject2 = parama.heO;
    String str = com.tencent.mm.platformtools.z.a(((de)localObject2).KHl);
    if ((!"fmessage".equals(str)) && (((de)localObject2).xKb != 37))
    {
      AppMethodBeat.o(20675);
      return null;
    }
    Object localObject1 = com.tencent.mm.platformtools.z.a(((de)localObject2).KHn);
    parama = ca.d.bkD((String)localObject1);
    Object localObject3 = com.tencent.mm.model.z.aTY();
    if ((parama.dkU != null) && (parama.dkU.equals(localObject3)))
    {
      Log.d("MicroMsg.VerifyMessageExtension", "onPreAddMessage, verify scene:%d, content:%s", new Object[] { Integer.valueOf(parama.scene), localObject1 });
      Log.e("MicroMsg.VerifyMessageExtension", "fromUserName is self, simply drop this msg");
      AppMethodBeat.o(20675);
      return null;
    }
    localObject3 = new i();
    ((i)localObject3).username = parama.dkU;
    ((i)localObject3).fuz = 3;
    ((i)localObject3).fv(true);
    ((i)localObject3).cSx = -1;
    ((i)localObject3).iKX = parama.OqM;
    ((i)localObject3).iKW = parama.OqN;
    Log.d("MicroMsg.VerifyMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { parama.dkU, ((i)localObject3).aYt(), ((i)localObject3).aYu() });
    p.aYB().b((i)localObject3);
    if (!Util.isNullOrNil(parama.dkU))
    {
      if (parama.scene == 18)
      {
        d.a((de)localObject2, parama);
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(73729, Integer.valueOf(1));
        bg.aVF();
        localObject1 = com.tencent.mm.model.c.aSN().Kn(parama.OqZ);
        if ((localObject1 == null) || ((int)((com.tencent.mm.contact.c)localObject1).gMZ <= 0)) {
          ay.a.iDq.a(parama.OqZ, null, new ay.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(20674);
              bg.aVF();
              Log.d("MicroMsg.VerifyMessageExtension", String.valueOf(com.tencent.mm.model.c.aSN().Kn(parama.OqZ)));
              paramAnonymousString = new ls();
              paramAnonymousString.dRd.dRe = parama.OqZ;
              paramAnonymousString.dRd.type = 1;
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
          if ((localObject2 != null) && (!ab.IR((String)localObject2)))
          {
            ((as)localObject1).setUsername(parama.OqZ);
            ((as)localObject1).BK(null);
            bg.aVF();
            com.tencent.mm.model.c.aSN().c((String)localObject2, (as)localObject1);
          }
          localObject1 = new ls();
          ((ls)localObject1).dRd.dRe = parama.OqZ;
          ((ls)localObject1).dRd.type = 1;
          EventCenter.instance.publish((IEvent)localObject1);
        }
      }
      if (bp.sb(parama.scene))
      {
        d.b((de)localObject2, parama);
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(73730, Integer.valueOf(1));
        AppMethodBeat.o(20675);
        return null;
      }
      if (parama.scene == 48)
      {
        localObject3 = new qh();
        ((qh)localObject3).dWE.dWG = ((String)localObject1);
        ((qh)localObject3).dWE.talker = parama.dkU;
        EventCenter.instance.publish((IEvent)localObject3);
      }
    }
    localObject1 = new bn();
    ((bn)localObject1).field_createTime = c.C(str, ((de)localObject2).CreateTime);
    if (((de)localObject2).oTW == 4) {
      i = 2;
    }
    ((bn)localObject1).field_isSend = (i + 0);
    ((bn)localObject1).field_msgContent = com.tencent.mm.platformtools.z.a(((de)localObject2).KHn);
    ((bn)localObject1).field_svrId = ((de)localObject2).Brn;
    ((bn)localObject1).field_talker = parama.dkU;
    bg.aVF();
    localObject2 = com.tencent.mm.model.c.aSN().Kn(parama.chatroomName);
    if ((localObject2 != null) && ((int)((com.tencent.mm.contact.c)localObject2).gMZ != -1)) {
      ((bn)localObject1).field_chatroomName = parama.chatroomName;
    }
    switch (parama.dKy)
    {
    case 3: 
    case 4: 
    default: 
      ((bn)localObject1).field_type = 1;
      if (!Util.isNullOrNil(parama.OqZ))
      {
        ((bn)localObject1).field_encryptTalker = parama.OqZ;
        if (d.bgN().aEl(parama.OqZ) != null)
        {
          parama = d.bgM();
          localObject2 = ((bn)localObject1).field_encryptTalker;
          str = ((bn)localObject1).field_talker;
          localObject2 = "update fmessage_msginfo set talker = '" + Util.escapeSqlValue(str) + "'  where talker = '" + Util.escapeSqlValue((String)localObject2) + "'";
          parama.db.execSQL("fmessage_msginfo", (String)localObject2);
          d.bgN().x(0L, ((bn)localObject1).field_encryptTalker);
        }
        d.bgM().b((bn)localObject1);
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
      parama = d.bgN().bkt(((bn)localObject1).field_talker);
      if (parama != null)
      {
        ((bn)localObject1).field_encryptTalker = parama.field_talker;
        ((bn)localObject1).field_talker = parama.field_talker;
      }
      d.bgM().b((bn)localObject1);
    }
  }
  
  public final void b(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bj.e
 * JD-Core Version:    0.7.0.1
 */