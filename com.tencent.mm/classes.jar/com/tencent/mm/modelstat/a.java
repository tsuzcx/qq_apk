package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class a
{
  public static void a(bi parambi, a.a parama)
  {
    AppMethodBeat.i(16612);
    if (bo.isNullOrNil(parambi.dHa))
    {
      AppMethodBeat.o(16612);
      return;
    }
    d locald = new d();
    locald.k("20ExpIdStr", parambi.dHa + ",");
    locald.k("21OpType", parama.value + ",");
    locald.k("22msgId", parambi.field_msgSvrId + ",");
    locald.k("23MessageType", parambi.getType() + ",");
    int i;
    if (parambi.bCn())
    {
      parama = j.b.ab(parambi.field_content, parambi.field_reserved);
      if (parama == null) {
        i = 0;
      }
    }
    for (;;)
    {
      parama = parambi.field_talker;
      locald.k("24AppMsgInnerType", i + ",");
      locald.k("25curUsername", parama + ",");
      String str = "";
      if (parambi.field_isSend == 1) {
        parama = r.Zn();
      }
      for (;;)
      {
        locald.k("26msgPostUserName", parama + ",");
        locald.k("27MediaState", parambi.dHb + ",");
        ab.v("MicroMsg.ChattingExpUtil", "report logbuffer(13564): [chatting_exp]" + locald.Fg());
        h.qsU.e(13564, new Object[] { locald });
        AppMethodBeat.o(16612);
        return;
        i = parama.type;
        break;
        if ((parama != null) && (t.lA(parama)))
        {
          parama = str;
          if (parambi.field_content != null)
          {
            i = bf.pt(parambi.field_content);
            parama = str;
            if (i != -1) {
              parama = parambi.field_content.substring(0, i).trim();
            }
          }
        }
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelstat.a
 * JD-Core Version:    0.7.0.1
 */