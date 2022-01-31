package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;

public class e
  implements com.tencent.mm.ai.e
{
  private static final e.a fkF;
  
  static
  {
    AppMethodBeat.i(59721);
    fkF = new e.a((byte)0);
    AppMethodBeat.o(59721);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(59718);
    fkF.at(parama);
    AppMethodBeat.o(59718);
  }
  
  protected bi a(cm paramcm, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(59720);
    if (paramString3.equals(paramString1)) {}
    for (paramString3 = paramString2;; paramString3 = paramString1)
    {
      bi localbi = ((j)g.E(j.class)).bPQ().ag(paramString3, paramcm.pIG);
      ab.i("MicroMsg.BaseMsgExtension", "summerbadcr dkmsgid prepareMsgInfo svrid:%d localid:%d  from:%s to:%s talker:%s", new Object[] { Long.valueOf(paramcm.pIG), Long.valueOf(localbi.field_msgId), paramString1, paramString2, paramString3 });
      if ((localbi.field_msgId != 0L) && (localbi.field_createTime + 604800000L < bf.x(paramString3, paramcm.CreateTime)))
      {
        ab.w("MicroMsg.BaseMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(paramcm.pIG), Long.valueOf(localbi.field_msgId) });
        bf.gw(localbi.field_msgId);
        localbi.setMsgId(0L);
      }
      paramString1 = localbi;
      if (localbi.field_msgId == 0L)
      {
        paramString1 = new bi();
        paramString1.fP(paramcm.pIG);
        paramString1.fQ(bf.x(paramString3, paramcm.CreateTime));
        paramString1.setType(paramcm.nqW);
        paramString1.setContent(bo.aql(bo.nullAsNil(aa.a(paramcm.woR))));
      }
      AppMethodBeat.o(59720);
      return paramString1;
    }
  }
  
  public void a(e.c paramc) {}
  
  public e.b b(com.tencent.mm.ai.e.a parama)
  {
    AppMethodBeat.i(59719);
    Object localObject1 = parama.eyJ;
    Object localObject2 = (String)g.RL().Ru().get(2, "");
    if (((String)localObject2).length() <= 0)
    {
      AppMethodBeat.o(59719);
      return null;
    }
    String str1 = aa.a(((cm)localObject1).woP);
    String str2 = aa.a(((cm)localObject1).woQ);
    if ((bo.nullAsNil(str1).length() <= 0) || (bo.nullAsNil(str2).length() <= 0))
    {
      ab.e("MicroMsg.BaseMsgExtension", "neither from-user nor to-user can be empty");
      AppMethodBeat.o(59719);
      return null;
    }
    bi localbi = a((cm)localObject1, str1, str2, (String)localObject2);
    if (localbi == null)
    {
      AppMethodBeat.o(59719);
      return null;
    }
    boolean bool;
    int i;
    if ((((j)g.E(j.class)).YI().has(str1)) || (((String)localObject2).equals(str1)))
    {
      bool = true;
      if (!bool) {
        break label375;
      }
      localbi.hL(1);
      localbi.kj(str2);
      i = ((cm)localObject1).jJS;
      label183:
      localbi.setStatus(i);
      if (((cm)localObject1).nqW == 10000) {
        localbi.setStatus(4);
      }
      localbi.jl(((cm)localObject1).woU);
      if (localbi.asi(r.Zn()))
      {
        localObject2 = ((j)g.E(j.class)).YF().arH(localbi.field_talker);
        if (localObject2 != null)
        {
          ((ak)localObject2).jh(16777216);
          ((j)g.E(j.class)).YF().a((ak)localObject2, localbi.field_talker);
        }
      }
      fkF.a(parama, localbi, str1, str2, bool);
      if (localbi.field_msgId != 0L) {
        break label411;
      }
      localbi.hV(2);
      bf.a(localbi, parama);
      localbi.setMsgId(bf.l(localbi));
    }
    for (localObject1 = new e.b(localbi, true);; localObject1 = new e.b(localbi, false))
    {
      fkF.b(parama, localbi, str1, str2, bool);
      AppMethodBeat.o(59719);
      return localObject1;
      bool = false;
      break;
      label375:
      localbi.hL(0);
      localbi.kj(str1);
      if (((cm)localObject1).jJS > 3)
      {
        i = ((cm)localObject1).jJS;
        break label183;
      }
      i = 3;
      break label183;
      label411:
      ((j)g.E(j.class)).bPQ().b(((cm)localObject1).pIG, localbi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.model.e
 * JD-Core Version:    0.7.0.1
 */