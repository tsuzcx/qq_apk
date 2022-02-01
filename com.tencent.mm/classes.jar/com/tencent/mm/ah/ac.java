package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.t;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import d.g.b.p;
import d.l;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/message/ReportAppMsgInsertEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/AppMsgInsertEvent;", "()V", "callback", "", "event", "doReportReceiveAppMsgFromNotifyMessage", "", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "getBusinessType", "", "opType", "getJumpUrl", "Lkotlin/Pair;", "", "srcUsername", "values", "", "getNewTemplateType", "getSrcUsername", "getTitle", "isNewTemplateSubscribeMsg", "templateType", "reportReceiveAppMsgFromNotifyMessage", "Companion", "plugin-biz_release"})
public final class ac
  extends c<t>
{
  public static final ac.a hGO;
  
  static
  {
    AppMethodBeat.i(188748);
    hGO = new ac.a((byte)0);
    AppMethodBeat.o(188748);
  }
  
  private static boolean on(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3);
  }
  
  private static int v(Map<String, String> paramMap)
  {
    AppMethodBeat.i(188747);
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
        i = bu.m(Integer.valueOf(i), -1);
        AppMethodBeat.o(188747);
        return i;
        i = 0;
      }
      catch (Exception paramMap)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.AppMsgInsertEventListener", (Throwable)paramMap, "", new Object[0]);
          i = -1;
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(ac paramac, bv parambv) {}
    
    public final void run()
    {
      AppMethodBeat.i(188745);
      ac.u(this.hGQ);
      AppMethodBeat.o(188745);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.ac
 * JD-Core Version:    0.7.0.1
 */