package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.jz;
import com.tencent.mm.autogen.mmdata.rpt.ka;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;

public final class a
{
  public static void a(cc paramcc, a parama)
  {
    AppMethodBeat.i(20656);
    if (Util.isNullOrNil(paramcc.kLp))
    {
      AppMethodBeat.o(20656);
      return;
    }
    n localn = new n();
    localn.s("20ExpIdStr", paramcc.kLp + ",");
    localn.s("21OpType", parama.value + ",");
    localn.s("22msgId", paramcc.field_msgSvrId + ",");
    localn.s("23MessageType", paramcc.getType() + ",");
    int i;
    if (paramcc.fxR())
    {
      parama = k.b.aP(paramcc.field_content, paramcc.field_reserved);
      if (parama == null) {
        i = 0;
      }
    }
    for (;;)
    {
      parama = paramcc.field_talker;
      localn.s("24AppMsgInnerType", i + ",");
      localn.s("25curUsername", parama + ",");
      String str = "";
      if (paramcc.field_isSend == 1) {
        parama = z.bAM();
      }
      for (;;)
      {
        localn.s("26msgPostUserName", parama + ",");
        localn.s("27MediaState", paramcc.kLq + ",");
        Log.v("MicroMsg.ChattingExpUtil", "report logbuffer(13564): [chatting_exp]" + localn.aIF());
        h.OAn.b(13564, new Object[] { localn });
        AppMethodBeat.o(20656);
        return;
        i = parama.type;
        break;
        if ((parama != null) && (au.bwE(parama)))
        {
          parama = str;
          if (paramcc.field_content != null)
          {
            i = br.JG(paramcc.field_content);
            parama = str;
            if (i != -1) {
              parama = paramcc.field_content.substring(0, i).trim();
            }
          }
        }
      }
      i = 0;
    }
  }
  
  public static void an(cc paramcc)
  {
    AppMethodBeat.i(242902);
    if (paramcc == null)
    {
      Log.v("MicroMsg.ChattingExpUtil", "reportClickRecordHistoryMsgs, msg = null.");
      AppMethodBeat.o(242902);
      return;
    }
    ka localka = new ka();
    paramcc = paramcc.field_talker;
    localka.iVm = localka.F("ChatNameStr", paramcc, true);
    int i = ac.Jj(paramcc);
    localka.iNl = i;
    localka.bMH();
    Log.d("MicroMsg.ChattingExpUtil", "report logbuffer(22335): [curUsername]: %s, chatType: %s", new Object[] { paramcc, Integer.valueOf(i) });
    AppMethodBeat.o(242902);
  }
  
  public static void c(cc paramcc, int paramInt)
  {
    AppMethodBeat.i(242905);
    if (paramcc == null)
    {
      Log.v("MicroMsg.ChattingExpUtil", "reportHistoryRecordAction, msg = null.");
      AppMethodBeat.o(242905);
      return;
    }
    jz localjz = new jz();
    String str2 = paramcc.field_talker;
    String str1 = Util.nullAs(str2, "");
    boolean bool = au.bwE(str2);
    if ((bool) && (bool))
    {
      paramcc = br.JJ(paramcc.field_content);
      if ((paramcc == null) || (paramcc.length() <= 0)) {}
    }
    for (;;)
    {
      str1 = z.bAM();
      int i = ac.Jj(str2);
      localjz.iNl = i;
      Log.d("MicroMsg.ChattingExpUtil", "report logbuffer(22336): [username]: %s, curUsername: %s, actionType: %s, chatType: %s, chatname: %s.", new Object[] { str1, str2, Integer.valueOf(paramInt), Integer.valueOf(i), paramcc });
      localjz.iVm = localjz.F("ChatNameStr", str2, true);
      localjz.ikE = paramInt;
      localjz.bMH();
      AppMethodBeat.o(242905);
      return;
      paramcc = str1;
    }
  }
  
  public static enum a
  {
    public int value = 0;
    
    static
    {
      AppMethodBeat.i(20655);
      oUV = new a("Expose", 0, 1);
      oUW = new a("Click", 1, 2);
      oUX = new a[] { oUV, oUW };
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