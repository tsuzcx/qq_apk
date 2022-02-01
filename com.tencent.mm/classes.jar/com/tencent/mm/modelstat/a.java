package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.b.a.hw;
import com.tencent.mm.f.b.a.hx;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class a
{
  public static void a(ca paramca, a parama)
  {
    AppMethodBeat.i(20656);
    if (Util.isNullOrNil(paramca.ilq))
    {
      AppMethodBeat.o(20656);
      return;
    }
    n localn = new n();
    localn.m("20ExpIdStr", paramca.ilq + ",");
    localn.m("21OpType", parama.value + ",");
    localn.m("22msgId", paramca.field_msgSvrId + ",");
    localn.m("23MessageType", paramca.getType() + ",");
    int i;
    if (paramca.erk())
    {
      parama = k.b.aG(paramca.field_content, paramca.field_reserved);
      if (parama == null) {
        i = 0;
      }
    }
    for (;;)
    {
      parama = paramca.field_talker;
      localn.m("24AppMsgInnerType", i + ",");
      localn.m("25curUsername", parama + ",");
      String str = "";
      if (paramca.field_isSend == 1) {
        parama = z.bcZ();
      }
      for (;;)
      {
        localn.m("26msgPostUserName", parama + ",");
        localn.m("27MediaState", paramca.ilr + ",");
        Log.v("MicroMsg.ChattingExpUtil", "report logbuffer(13564): [chatting_exp]" + localn.agI());
        h.IzE.a(13564, new Object[] { localn });
        AppMethodBeat.o(20656);
        return;
        i = parama.type;
        break;
        if ((parama != null) && (ab.Lj(parama)))
        {
          parama = str;
          if (paramca.field_content != null)
          {
            i = bq.RI(paramca.field_content);
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
  
  public static void ai(ca paramca)
  {
    AppMethodBeat.i(276621);
    if (paramca == null)
    {
      Log.v("MicroMsg.ChattingExpUtil", "reportClickRecordHistoryMsgs, msg = null.");
      AppMethodBeat.o(276621);
      return;
    }
    hx localhx = new hx();
    paramca = paramca.field_talker;
    localhx.gGV = localhx.z("ChatNameStr", paramca, true);
    int i = ac.Rl(paramca);
    localhx.gAN = i;
    localhx.bpa();
    Log.d("MicroMsg.ChattingExpUtil", "report logbuffer(22335): [curUsername]: %s, chatType: %s", new Object[] { paramca, Integer.valueOf(i) });
    AppMethodBeat.o(276621);
  }
  
  public static void c(ca paramca, int paramInt)
  {
    AppMethodBeat.i(276622);
    if (paramca == null)
    {
      Log.v("MicroMsg.ChattingExpUtil", "reportHistoryRecordAction, msg = null.");
      AppMethodBeat.o(276622);
      return;
    }
    hw localhw = new hw();
    String str2 = paramca.field_talker;
    String str1 = Util.nullAs(str2, "");
    boolean bool = ab.Lj(str2);
    if ((bool) && (bool))
    {
      paramca = bq.RL(paramca.field_content);
      if ((paramca == null) || (paramca.length() <= 0)) {}
    }
    for (;;)
    {
      str1 = z.bcZ();
      int i = ac.Rl(str2);
      localhw.gAN = i;
      Log.d("MicroMsg.ChattingExpUtil", "report logbuffer(22336): [username]: %s, curUsername: %s, actionType: %s, chatType: %s, chatname: %s.", new Object[] { str1, str2, Integer.valueOf(paramInt), Integer.valueOf(i), paramca });
      localhw.gGV = localhw.z("ChatNameStr", str2, true);
      localhw.gef = paramInt;
      localhw.bpa();
      AppMethodBeat.o(276622);
      return;
      paramca = str1;
    }
  }
  
  public static enum a
  {
    public int value = 0;
    
    static
    {
      AppMethodBeat.i(20655);
      mca = new a("Expose", 0, 1);
      mcb = new a("Click", 1, 2);
      mcd = new a[] { mca, mcb };
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