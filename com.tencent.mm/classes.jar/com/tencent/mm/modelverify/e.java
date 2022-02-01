package com.tencent.mm.modelverify;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.am.g.c;
import com.tencent.mm.autogen.a.np;
import com.tencent.mm.autogen.a.sw;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc.f;

public final class e
  implements g
{
  public final g.b b(final g.a parama)
  {
    int i = 0;
    AppMethodBeat.i(20675);
    Object localObject2 = parama.mpN;
    String str = w.a(((dl)localObject2).YFE);
    if ((!"fmessage".equals(str)) && (((dl)localObject2).IIs != 37))
    {
      AppMethodBeat.o(20675);
      return null;
    }
    Object localObject1 = w.a(((dl)localObject2).YFG);
    parama = cc.f.byv((String)localObject1);
    Object localObject3 = z.bAM();
    if ((parama != null) && (parama.hgk != null) && (parama.hgk.equals(localObject3)))
    {
      Log.d("MicroMsg.VerifyMessageExtension", "onPreAddMessage, verify scene:%d, content:%s", new Object[] { Integer.valueOf(parama.scene), localObject1 });
      Log.e("MicroMsg.VerifyMessageExtension", "fromUserName is self, simply drop this msg");
      AppMethodBeat.o(20675);
      return null;
    }
    localObject3 = new j();
    ((j)localObject3).username = parama.hgk;
    ((j)localObject3).jZY = 3;
    ((j)localObject3).gX(true);
    ((j)localObject3).eQp = -1;
    ((j)localObject3).osN = parama.adkB;
    ((j)localObject3).osM = parama.adkC;
    Log.d("MicroMsg.VerifyMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { parama.hgk, ((j)localObject3).bFw(), ((j)localObject3).bFx() });
    q.bFE().b((j)localObject3);
    if ((parama != null) && (!Util.isNullOrNil(parama.hgk)))
    {
      if (parama.scene == 18)
      {
        d.a((dl)localObject2, parama);
        bh.bCz();
        com.tencent.mm.model.c.ban().B(73729, Integer.valueOf(1));
        bh.bCz();
        localObject1 = com.tencent.mm.model.c.bzA().JE(parama.adkQ);
        if ((localObject1 == null) || ((int)((com.tencent.mm.contact.d)localObject1).maN <= 0)) {
          az.a.okP.a(parama.adkQ, null, new az.b.a()
          {
            public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(20674);
              bh.bCz();
              Log.d("MicroMsg.VerifyMessageExtension", String.valueOf(com.tencent.mm.model.c.bzA().JE(parama.adkQ)));
              paramAnonymousString = new np();
              paramAnonymousString.hPZ.hQa = parama.adkQ;
              paramAnonymousString.hPZ.type = 1;
              paramAnonymousString.publish();
              AppMethodBeat.o(20674);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(20675);
          return null;
          localObject2 = ((az)localObject1).field_username;
          if ((localObject2 != null) && (!au.bxa((String)localObject2)))
          {
            ((au)localObject1).setUsername(parama.adkQ);
            ((au)localObject1).Bd(null);
            bh.bCz();
            com.tencent.mm.model.c.bzA().d((String)localObject2, (au)localObject1);
          }
          localObject1 = new np();
          ((np)localObject1).hPZ.hQa = parama.adkQ;
          ((np)localObject1).hPZ.type = 1;
          ((np)localObject1).publish();
        }
      }
      if (br.vj(parama.scene))
      {
        d.b((dl)localObject2, parama);
        bh.bCz();
        com.tencent.mm.model.c.ban().B(73730, Integer.valueOf(1));
        AppMethodBeat.o(20675);
        return null;
      }
      if (parama.scene == 48)
      {
        localObject3 = new sw();
        ((sw)localObject3).hWl.hWn = ((String)localObject1);
        ((sw)localObject3).hWl.talker = parama.hgk;
        ((sw)localObject3).publish();
      }
    }
    if (parama != null)
    {
      localObject1 = new bp();
      ((bp)localObject1).field_createTime = c.D(str, ((dl)localObject2).CreateTime);
      if (((dl)localObject2).vhk == 4) {
        i = 2;
      }
      ((bp)localObject1).field_isSend = (i + 0);
      ((bp)localObject1).field_msgContent = w.a(((dl)localObject2).YFG);
      ((bp)localObject1).field_svrId = ((dl)localObject2).Njv;
      ((bp)localObject1).field_talker = parama.hgk;
      bh.bCz();
      localObject2 = com.tencent.mm.model.c.bzA().JE(parama.chatroomName);
      if ((localObject2 != null) && ((int)((com.tencent.mm.contact.d)localObject2).maN != -1)) {
        ((bp)localObject1).field_chatroomName = parama.chatroomName;
      }
      switch (parama.hId)
      {
      case 3: 
      case 4: 
      default: 
        ((bp)localObject1).field_type = 1;
        if (!Util.isNullOrNil(parama.adkQ))
        {
          ((bp)localObject1).field_encryptTalker = parama.adkQ;
          if (d.bNI().aLu(parama.adkQ) != null)
          {
            parama = d.bNH();
            localObject2 = ((bp)localObject1).field_encryptTalker;
            str = ((bp)localObject1).field_talker;
            localObject2 = "update fmessage_msginfo set talker = '" + Util.escapeSqlValue(str) + "'  where talker = '" + Util.escapeSqlValue((String)localObject2) + "'";
            parama.db.execSQL("fmessage_msginfo", (String)localObject2);
            d.bNI().S(0L, ((bp)localObject1).field_encryptTalker);
          }
          d.bNH().b((bp)localObject1);
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(20675);
      return null;
      ((bp)localObject1).field_type = 1;
      break;
      ((bp)localObject1).field_type = 2;
      break;
      ((bp)localObject1).field_type = 3;
      break;
      Log.e("MicroMsg.VerifyMessageExtension", "it should not go in here");
      parama = d.bNI().byl(((bp)localObject1).field_talker);
      if (parama != null)
      {
        ((bp)localObject1).field_encryptTalker = parama.field_talker;
        ((bp)localObject1).field_talker = parama.field_talker;
      }
      d.bNH().b((bp)localObject1);
    }
  }
  
  public final void b(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelverify.e
 * JD-Core Version:    0.7.0.1
 */