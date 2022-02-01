package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;

public final class a
{
  public static void a(bl parambl, a parama)
  {
    AppMethodBeat.i(20656);
    if (bt.isNullOrNil(parambl.ePc))
    {
      AppMethodBeat.o(20656);
      return;
    }
    f localf = new f();
    localf.o("20ExpIdStr", parambl.ePc + ",");
    localf.o("21OpType", parama.value + ",");
    localf.o("22msgId", parambl.field_msgSvrId + ",");
    localf.o("23MessageType", parambl.getType() + ",");
    int i;
    if (parambl.cxB())
    {
      parama = k.b.ar(parambl.field_content, parambl.field_reserved);
      if (parama == null) {
        i = 0;
      }
    }
    for (;;)
    {
      parama = parambl.field_talker;
      localf.o("24AppMsgInnerType", i + ",");
      localf.o("25curUsername", parama + ",");
      String str = "";
      if (parambl.field_isSend == 1) {
        parama = u.aqG();
      }
      for (;;)
      {
        localf.o("26msgPostUserName", parama + ",");
        localf.o("27MediaState", parambl.ePd + ",");
        ad.v("MicroMsg.ChattingExpUtil", "report logbuffer(13564): [chatting_exp]" + localf.PW());
        h.vKh.f(13564, new Object[] { localf });
        AppMethodBeat.o(20656);
        return;
        i = parama.type;
        break;
        if ((parama != null) && (w.pF(parama)))
        {
          parama = str;
          if (parambl.field_content != null)
          {
            i = bi.uc(parambl.field_content);
            parama = str;
            if (i != -1) {
              parama = parambl.field_content.substring(0, i).trim();
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
      htY = new a("Expose", 0, 1);
      htZ = new a("Click", 1, 2);
      hua = new a[] { htY, htZ };
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