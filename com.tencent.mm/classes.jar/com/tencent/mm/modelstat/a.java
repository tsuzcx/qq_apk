package com.tencent.mm.modelstat;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

public final class a
{
  public static void a(bi parambi, a.a parama)
  {
    if (bk.bl(parambi.cQO)) {
      return;
    }
    d locald = new d();
    locald.j("20ExpIdStr", parambi.cQO + ",");
    locald.j("21OpType", parama.value + ",");
    locald.j("22msgId", parambi.field_msgSvrId + ",");
    locald.j("23MessageType", parambi.getType() + ",");
    int i;
    if (parambi.aVK())
    {
      parama = g.a.M(parambi.field_content, parambi.field_reserved);
      if (parama == null) {
        i = 0;
      }
    }
    for (;;)
    {
      parama = parambi.field_talker;
      locald.j("24AppMsgInnerType", i + ",");
      locald.j("25curUsername", parama + ",");
      String str = "";
      if (parambi.field_isSend == 1) {
        parama = q.Gj();
      }
      for (;;)
      {
        locald.j("26msgPostUserName", parama + ",");
        locald.j("27MediaState", parambi.cQP + ",");
        y.v("MicroMsg.ChattingExpUtil", "report logbuffer(13564): [chatting_exp]" + locald.uJ());
        h.nFQ.f(13564, new Object[] { locald });
        return;
        i = parama.type;
        break;
        if ((parama != null) && (s.fn(parama)))
        {
          parama = str;
          if (parambi.field_content != null)
          {
            i = bd.iH(parambi.field_content);
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