package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.w;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/message/ReportAppMsgInsertEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/AppMsgInsertEvent;", "()V", "callback", "", "event", "doReportReceiveAppMsgFromNotifyMessage", "", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "getBusinessType", "", "opType", "getJumpUrl", "Lkotlin/Pair;", "", "srcUsername", "values", "", "getNewTemplateType", "getSrcUsername", "getTitle", "isNewTemplateSubscribeMsg", "templateType", "reportReceiveAppMsgFromNotifyMessage", "Companion", "plugin-biz_release"})
public final class ad
  extends IListener<w>
{
  public static final ad.a lqw;
  
  static
  {
    AppMethodBeat.i(206367);
    lqw = new ad.a((byte)0);
    AppMethodBeat.o(206367);
  }
  
  private static int p(Map<String, String> paramMap)
  {
    AppMethodBeat.i(206365);
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
        p.j(paramMap, "Integer.valueOf(newTemplateMsgStr)");
        i = paramMap.intValue();
        i = Util.nullAsInt(Integer.valueOf(i), -1);
        AppMethodBeat.o(206365);
        return i;
        i = 0;
      }
      catch (Exception paramMap)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AppMsgInsertEventListener", (Throwable)paramMap, "", new Object[0]);
          i = -1;
        }
      }
    }
  }
  
  private static boolean uF(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(ad paramad, ca paramca) {}
    
    public final void run()
    {
      AppMethodBeat.i(205211);
      ad.y(this.lqy);
      AppMethodBeat.o(205211);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.ad
 * JD-Core Version:    0.7.0.1
 */