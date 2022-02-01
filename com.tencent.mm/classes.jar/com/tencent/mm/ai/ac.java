package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.t;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import d.g.b.p;
import d.l;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/message/ReportAppMsgInsertEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/AppMsgInsertEvent;", "()V", "callback", "", "event", "doReportReceiveAppMsgFromNotifyMessage", "", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "getBusinessType", "", "opType", "getJumpUrl", "Lkotlin/Pair;", "", "srcUsername", "values", "", "getNewTemplateType", "getSrcUsername", "getTitle", "isNewTemplateSubscribeMsg", "templateType", "reportReceiveAppMsgFromNotifyMessage", "Companion", "plugin-biz_release"})
public final class ac
  extends c<t>
{
  public static final ac.a hDW;
  
  static
  {
    AppMethodBeat.i(207286);
    hDW = new ac.a((byte)0);
    AppMethodBeat.o(207286);
  }
  
  private static int o(Map<String, String> paramMap)
  {
    AppMethodBeat.i(207285);
    paramMap = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.new_tmpl_type");
    CharSequence localCharSequence = (CharSequence)paramMap;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        paramMap = "-1";
      }
      try
      {
        paramMap = Integer.valueOf(paramMap);
        p.g(paramMap, "Integer.valueOf(newTemplateMsgStr)");
        i = paramMap.intValue();
        i = bt.m(Integer.valueOf(i), -1);
        AppMethodBeat.o(207285);
        return i;
        i = 0;
      }
      catch (Exception paramMap)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.AppMsgInsertEventListener", (Throwable)paramMap, "", new Object[0]);
          i = -1;
        }
      }
    }
  }
  
  private static boolean ok(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(ac paramac, bu parambu) {}
    
    public final void run()
    {
      AppMethodBeat.i(207283);
      ac.u(this.hDY);
      AppMethodBeat.o(207283);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.ac
 * JD-Core Version:    0.7.0.1
 */