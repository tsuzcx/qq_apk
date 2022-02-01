package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;

public final class a
{
  public static void a(bu parambu, a parama)
  {
    AppMethodBeat.i(20656);
    if (bt.isNullOrNil(parambu.fkz))
    {
      AppMethodBeat.o(20656);
      return;
    }
    com.tencent.mm.modelsns.g localg = new com.tencent.mm.modelsns.g();
    localg.m("20ExpIdStr", parambu.fkz + ",");
    localg.m("21OpType", parama.value + ",");
    localg.m("22msgId", parambu.field_msgSvrId + ",");
    localg.m("23MessageType", parambu.getType() + ",");
    int i;
    if (parambu.cTc())
    {
      parama = k.b.aA(parambu.field_content, parambu.field_reserved);
      if (parama == null) {
        i = 0;
      }
    }
    for (;;)
    {
      parama = parambu.field_talker;
      localg.m("24AppMsgInnerType", i + ",");
      localg.m("25curUsername", parama + ",");
      String str = "";
      if (parambu.field_isSend == 1) {
        parama = u.aAm();
      }
      for (;;)
      {
        localg.m("26msgPostUserName", parama + ",");
        localg.m("27MediaState", parambu.fkA + ",");
        ad.v("MicroMsg.ChattingExpUtil", "report logbuffer(13564): [chatting_exp]" + localg.RE());
        com.tencent.mm.plugin.report.service.g.yhR.f(13564, new Object[] { localg });
        AppMethodBeat.o(20656);
        return;
        i = parama.type;
        break;
        if ((parama != null) && (w.vF(parama)))
        {
          parama = str;
          if (parambu.field_content != null)
          {
            i = bj.Bh(parambu.field_content);
            parama = str;
            if (i != -1) {
              parama = parambu.field_content.substring(0, i).trim();
            }
          }
        }
      }
      i = 0;
    }
  }
  
  public static enum a
  {
    public int value = 0;
    
    static
    {
      AppMethodBeat.i(20655);
      inV = new a("Expose", 0, 1);
      inW = new a("Click", 1, 2);
      inX = new a[] { inV, inW };
      AppMethodBeat.o(20655);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelstat.a
 * JD-Core Version:    0.7.0.1
 */