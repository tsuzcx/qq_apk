package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.an.h.c;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;

public class e
  implements com.tencent.mm.an.h
{
  private static final e.a lri;
  
  static
  {
    AppMethodBeat.i(42771);
    lri = new e.a();
    AppMethodBeat.o(42771);
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(42768);
    lri.add(paramc);
    AppMethodBeat.o(42768);
  }
  
  protected ca a(h.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(240579);
    db localdb = parama.jQG;
    if (paramString3.equals(paramString1)) {}
    for (parama = paramString2;; parama = paramString1)
    {
      paramString3 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aL(parama, localdb.HlH);
      Log.i("MicroMsg.BaseMsgExtension", "summerbadcr dkmsgid prepareMsgInfo svrid:%d localid:%d  from:%s to:%s talker:%s", new Object[] { Long.valueOf(localdb.HlH), Long.valueOf(paramString3.field_msgId), paramString1, paramString2, parama });
      if ((paramString3.field_msgId != 0L) && (paramString3.field_createTime + 604800000L < bq.z(parama, localdb.CreateTime)))
      {
        Log.w("MicroMsg.BaseMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localdb.HlH), Long.valueOf(paramString3.field_msgId) });
        bq.Gk(paramString3.field_msgId);
        paramString3.setMsgId(0L);
      }
      paramString1 = paramString3;
      if (paramString3.field_msgId == 0L)
      {
        paramString1 = new ca();
        paramString1.Jm(parama);
        paramString1.EG(localdb.HlH);
        paramString1.setCreateTime(bq.z(parama, localdb.CreateTime));
        paramString1.setType(localdb.COi);
        paramString1.setContent(Util.escapeStringForUCC(Util.nullAsNil(com.tencent.mm.platformtools.z.a(localdb.RIF))));
      }
      AppMethodBeat.o(240579);
      return paramString1;
    }
  }
  
  public h.b b(h.a parama)
  {
    AppMethodBeat.i(42769);
    Object localObject1 = parama.jQG;
    Object localObject2 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(2, "");
    if (((String)localObject2).length() <= 0)
    {
      AppMethodBeat.o(42769);
      return null;
    }
    String str1 = com.tencent.mm.platformtools.z.a(((db)localObject1).RID);
    String str3 = com.tencent.mm.platformtools.z.a(((db)localObject1).RIE);
    if ((Util.nullAsNil(str1).length() <= 0) || (Util.nullAsNil(str3).length() <= 0))
    {
      Log.e("MicroMsg.BaseMsgExtension", "neither from-user nor to-user can be empty");
      AppMethodBeat.o(42769);
      return null;
    }
    ca localca = a(parama, str1, str3, (String)localObject2);
    if (localca == null)
    {
      AppMethodBeat.o(42769);
      return null;
    }
    int i;
    label190:
    boolean bool;
    label224:
    h.b localb;
    label367:
    String str2;
    if (!localca.gX)
    {
      if ((((n)com.tencent.mm.kernel.h.ae(n.class)).bbU().has(str1)) || (((String)localObject2).equals(str1)))
      {
        i = 1;
        if (i == 0) {
          break label669;
        }
        localca.pJ(1);
        localca.Jm(str3);
        i = ((db)localObject1).rVU;
        localca.setStatus(i);
      }
    }
    else
    {
      if (((db)localObject1).COi == 10000) {
        localca.setStatus(4);
      }
      if (localca.field_isSend != 1) {
        break label705;
      }
      bool = true;
      localca.Ip(((db)localObject1).RII);
      if (localca.bwY(z.bcZ()))
      {
        localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwx(localca.field_talker);
        if (localObject2 != null)
        {
          ((az)localObject2).ro(16777216);
          ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().a((az)localObject2, localca.field_talker);
        }
      }
      lri.a(parama, localca, str1, str3, bool);
      if (localca.field_msgId != 0L) {
        break label710;
      }
      localca.setFlag(2);
      bq.a(localca, parama);
      localca.setMsgId(bq.z(localca));
      localb = new h.b(localca, true);
      if (!Util.isNullOrNil(localca.field_content))
      {
        if (!bool) {
          break label750;
        }
        str2 = str3;
        label386:
        if ((!parama.lCc) && (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aKT(str2)))
        {
          if (!bool) {
            break label757;
          }
          localObject2 = localca.field_content;
          localObject1 = str1;
        }
      }
    }
    for (;;)
    {
      if (BuildInfo.DEBUG) {
        Log.d("MicroMsg.BaseMsgExtension", "onPreAddMessage() isSender:%s fromUser:%s creator:%s content:%s", new Object[] { Boolean.valueOf(bool), str1, localObject1, Util.nullAs((String)localObject2, "null") });
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.l.class)).a(str2, (String)localObject1, (String)localObject2, localca.field_msgId, localca.field_createTime / 1000L);
      if ((localca.hAl()) && (ab.PP(localca.field_talker)) && (((w)com.tencent.mm.kernel.h.ae(w.class)).asb()))
      {
        com.tencent.mm.kernel.h.aHH();
        localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(localca.field_talker);
        long l = ((ax)localObject1).hDD;
        ((as)localObject1).EA(localca.field_msgId);
        com.tencent.mm.kernel.h.aHH();
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().au((as)localObject1);
        if (l != 0L) {
          ((w)com.tencent.mm.kernel.h.ae(w.class)).o(localca.field_talker, l);
        }
      }
      lri.b(parama, localca, str1, str3, bool);
      AppMethodBeat.o(42769);
      return localb;
      i = 0;
      break;
      label669:
      localca.pJ(0);
      localca.Jm(str1);
      if (((db)localObject1).rVU > 3)
      {
        i = ((db)localObject1).rVU;
        break label190;
      }
      i = 3;
      break label190;
      label705:
      bool = false;
      break label224;
      label710:
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().b(((db)localObject1).HlH, localca);
      localb = new h.b(localca, false);
      break label367;
      label750:
      str2 = str1;
      break label386;
      label757:
      localObject2 = localca.field_content;
      i = bq.RI(localca.field_content);
      if (i != -1)
      {
        localObject1 = ((String)localObject2).substring(0, i).trim();
        if ((localObject1 != null) && (((String)localObject1).length() > 0)) {}
        for (;;)
        {
          localObject2 = ((String)localObject2).substring(i + 1).trim();
          break;
          localObject1 = "";
        }
      }
      localObject1 = "";
    }
  }
  
  public void b(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.e
 * JD-Core Version:    0.7.0.1
 */