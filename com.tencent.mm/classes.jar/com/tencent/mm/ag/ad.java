package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.v;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/message/ReportAppMsgInsertEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/AppMsgInsertEvent;", "()V", "callback", "", "event", "doReportReceiveAppMsgFromNotifyMessage", "", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "getBusinessType", "", "opType", "getJumpUrl", "Lkotlin/Pair;", "", "srcUsername", "values", "", "getNewTemplateType", "getSrcUsername", "getTitle", "isNewTemplateSubscribeMsg", "templateType", "reportReceiveAppMsgFromNotifyMessage", "Companion", "plugin-biz_release"})
public final class ad
  extends IListener<v>
{
  public static final ad.a iAY;
  
  static
  {
    AppMethodBeat.i(212375);
    iAY = new ad.a((byte)0);
    AppMethodBeat.o(212375);
  }
  
  private static boolean rL(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3);
  }
  
  private static int x(Map<String, String> paramMap)
  {
    AppMethodBeat.i(212374);
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
        i = Util.nullAsInt(Integer.valueOf(i), -1);
        AppMethodBeat.o(212374);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(ad paramad, ca paramca) {}
    
    public final void run()
    {
      AppMethodBeat.i(212372);
      ad.w(this.iBa);
      AppMethodBeat.o(212372);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ag.ad
 * JD-Core Version:    0.7.0.1
 */