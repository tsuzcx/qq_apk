package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class a
{
  public static void a(ca paramca, a parama)
  {
    AppMethodBeat.i(20656);
    if (Util.isNullOrNil(paramca.fRa))
    {
      AppMethodBeat.o(20656);
      return;
    }
    m localm = new m();
    localm.n("20ExpIdStr", paramca.fRa + ",");
    localm.n("21OpType", parama.value + ",");
    localm.n("22msgId", paramca.field_msgSvrId + ",");
    localm.n("23MessageType", paramca.getType() + ",");
    int i;
    if (paramca.dOQ())
    {
      parama = k.b.aD(paramca.field_content, paramca.field_reserved);
      if (parama == null) {
        i = 0;
      }
    }
    for (;;)
    {
      parama = paramca.field_talker;
      localm.n("24AppMsgInnerType", i + ",");
      localm.n("25curUsername", parama + ",");
      String str = "";
      if (paramca.field_isSend == 1) {
        parama = z.aTY();
      }
      for (;;)
      {
        localm.n("26msgPostUserName", parama + ",");
        localm.n("27MediaState", paramca.fRb + ",");
        Log.v("MicroMsg.ChattingExpUtil", "report logbuffer(13564): [chatting_exp]" + localm.abW());
        h.CyF.a(13564, new Object[] { localm });
        AppMethodBeat.o(20656);
        return;
        i = parama.type;
        break;
        if ((parama != null) && (ab.Eq(parama)))
        {
          parama = str;
          if (paramca.field_content != null)
          {
            i = bp.Kp(paramca.field_content);
            parama = str;
            if (i != -1) {
              parama = paramca.field_content.substring(0, i).trim();
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
      jlZ = new a("Expose", 0, 1);
      jma = new a("Click", 1, 2);
      jmb = new a[] { jlZ, jma };
      AppMethodBeat.o(20655);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.a
 * JD-Core Version:    0.7.0.1
 */