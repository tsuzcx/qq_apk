package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;

public final class a
{
  public static void a(bv parambv, a parama)
  {
    AppMethodBeat.i(20656);
    if (bu.isNullOrNil(parambv.fmw))
    {
      AppMethodBeat.o(20656);
      return;
    }
    com.tencent.mm.modelsns.g localg = new com.tencent.mm.modelsns.g();
    localg.m("20ExpIdStr", parambv.fmw + ",");
    localg.m("21OpType", parama.value + ",");
    localg.m("22msgId", parambv.field_msgSvrId + ",");
    localg.m("23MessageType", parambv.getType() + ",");
    int i;
    if (parambv.cVH())
    {
      parama = k.b.aB(parambv.field_content, parambv.field_reserved);
      if (parama == null) {
        i = 0;
      }
    }
    for (;;)
    {
      parama = parambv.field_talker;
      localg.m("24AppMsgInnerType", i + ",");
      localg.m("25curUsername", parama + ",");
      String str = "";
      if (parambv.field_isSend == 1) {
        parama = v.aAC();
      }
      for (;;)
      {
        localg.m("26msgPostUserName", parama + ",");
        localg.m("27MediaState", parambv.fmx + ",");
        ae.v("MicroMsg.ChattingExpUtil", "report logbuffer(13564): [chatting_exp]" + localg.RD());
        com.tencent.mm.plugin.report.service.g.yxI.f(13564, new Object[] { localg });
        AppMethodBeat.o(20656);
        return;
        i = parama.type;
        break;
        if ((parama != null) && (x.wb(parama)))
        {
          parama = str;
          if (parambv.field_content != null)
          {
            i = bl.BJ(parambv.field_content);
            parama = str;
            if (i != -1) {
              parama = parambv.field_content.substring(0, i).trim();
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
      iqP = new a("Expose", 0, 1);
      iqQ = new a("Click", 1, 2);
      iqR = new a[] { iqP, iqQ };
      AppMethodBeat.o(20655);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.a
 * JD-Core Version:    0.7.0.1
 */