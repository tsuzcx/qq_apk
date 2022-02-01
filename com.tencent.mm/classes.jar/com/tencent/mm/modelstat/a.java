package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;

public final class a
{
  public static void a(bo parambo, a parama)
  {
    AppMethodBeat.i(20656);
    if (bs.isNullOrNil(parambo.eSk))
    {
      AppMethodBeat.o(20656);
      return;
    }
    f localf = new f();
    localf.n("20ExpIdStr", parambo.eSk + ",");
    localf.n("21OpType", parama.value + ",");
    localf.n("22msgId", parambo.field_msgSvrId + ",");
    localf.n("23MessageType", parambo.getType() + ",");
    int i;
    if (parambo.cKN())
    {
      parama = k.b.az(parambo.field_content, parambo.field_reserved);
      if (parama == null) {
        i = 0;
      }
    }
    for (;;)
    {
      parama = parambo.field_talker;
      localf.n("24AppMsgInnerType", i + ",");
      localf.n("25curUsername", parama + ",");
      String str = "";
      if (parambo.field_isSend == 1) {
        parama = u.axw();
      }
      for (;;)
      {
        localf.n("26msgPostUserName", parama + ",");
        localf.n("27MediaState", parambo.eSl + ",");
        ac.v("MicroMsg.ChattingExpUtil", "report logbuffer(13564): [chatting_exp]" + localf.PS());
        h.wUl.f(13564, new Object[] { localf });
        AppMethodBeat.o(20656);
        return;
        i = parama.type;
        break;
        if ((parama != null) && (w.sQ(parama)))
        {
          parama = str;
          if (parambo.field_content != null)
          {
            i = bi.yi(parambo.field_content);
            parama = str;
            if (i != -1) {
              parama = parambo.field_content.substring(0, i).trim();
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
      hUA = new a("Expose", 0, 1);
      hUB = new a("Click", 1, 2);
      hUC = new a[] { hUA, hUB };
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