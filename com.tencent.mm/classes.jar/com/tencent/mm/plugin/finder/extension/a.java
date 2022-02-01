package com.tencent.mm.plugin.finder.extension;

import com.tencent.c.a.a.a.d.a.e;
import com.tencent.c.a.a.a.d.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.g;
import com.tencent.mm.an.g.b;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.an.h.c;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.atj;
import com.tencent.mm.protocal.protobuf.dcz;
import com.tencent.mm.protocal.protobuf.rq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/FinderLiveNotifyFuncMsgExtension;", "Lcom/tencent/mm/modelbase/IFunctionMessageExtension;", "()V", "oldCanRevokeCount", "", "getOldCanRevokeCount", "()I", "setOldCanRevokeCount", "(I)V", "reqClientAiInfo", "", "getReqClientAiInfo", "()Ljava/lang/String;", "setReqClientAiInfo", "(Ljava/lang/String;)V", "reqFunctionMsgId", "getReqFunctionMsgId", "setReqFunctionMsgId", "reqFunctionMsgIdOnLiveClose", "getReqFunctionMsgIdOnLiveClose", "setReqFunctionMsgIdOnLiveClose", "beforeAddMsg", "", "getAddMsgType", "getBusinessId", "", "onBuildFetchParams", "params", "Lcom/tencent/mm/modelbase/IFunctionMessageExtension$FetchAddMsgParams;", "onPreAddMessage", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgReturn;", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "onPreDelMessage", "deleteMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$DeleteMsgInfo;", "requestFinderLiveNotify", "json", "requestOnLiveClose", "funcMsgId", "resetClientReq", "Companion", "plugin-finder_release"})
public final class a
  implements g
{
  public static final a xrR;
  public String xrN;
  public String xrO;
  public String xrP;
  private volatile int xrQ;
  
  static
  {
    AppMethodBeat.i(275405);
    xrR = new a((byte)0);
    AppMethodBeat.o(275405);
  }
  
  public final void a(g.b paramb)
  {
    AppMethodBeat.i(275403);
    rq localrq = paramb.lCa;
    if (localrq != null)
    {
      atj localatj = new atj();
      localatj.scene = 0;
      Object localObject = ao.xcj;
      localatj.RLM = ao.dnO();
      this.xrQ = 0;
      if (p.h(this.xrN, paramb.lCb))
      {
        localatj.SGm = this.xrP;
        localatj.scene = 1;
        this.xrP = "";
        this.xrN = "";
      }
      if (p.h(this.xrO, paramb.lCb))
      {
        localatj.scene = 2;
        this.xrO = "";
      }
      Log.i("Finder.FinderLiveNotifyFuncMsgExtension", "onBuildFetchParams scene[" + localatj.scene + ']');
      localObject = ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveNotifyExposureInfoStorage().dDR();
      paramb = new LinkedList();
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        e locale = (e)((Iterator)localObject).next();
        if ((locale.field_exposureStatus == 0) && (locale.field_liveStatus == 0)) {
          this.xrQ += 1;
        }
        dcz localdcz = new dcz();
        localdcz.TKL = locale.field_insertTime;
        localdcz.SQm = locale.field_tipsId;
        localdcz.TKN = locale.field_exposureStatus;
        localdcz.liveStatus = locale.field_liveStatus;
        localdcz.klE = Util.safeParseLong(locale.field_liveId);
        localdcz.TKM = locale.field_ctrlInfoType;
        localdcz.TKO = locale.field_bypInfo;
        paramb.add(localdcz);
      }
      localatj.jmy = paramb;
      if (localatj.jmy.size() > 100)
      {
        paramb = localatj.jmy;
        p.j(paramb, "this.list");
        localatj.jmy = new LinkedList((Collection)j.c((Iterable)paramb, 100));
      }
      localrq.Sax = new com.tencent.mm.cd.b(localatj.toByteArray());
      AppMethodBeat.o(275403);
      return;
    }
    AppMethodBeat.o(275403);
  }
  
  public final int aAq()
  {
    return -1;
  }
  
  public final long aAr()
  {
    return 70001L;
  }
  
  public final void aAs()
  {
    AppMethodBeat.i(275400);
    int i;
    if (this.xrQ > 0)
    {
      Object localObject = ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveNotifyExposureInfoStorage().dDR();
      i = 0;
      localObject = ((Iterable)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        e locale = (e)((Iterator)localObject).next();
        if ((locale.field_exposureStatus != 0) || (locale.field_liveStatus != 0)) {
          break label110;
        }
        i += 1;
      }
    }
    label110:
    for (;;)
    {
      break;
      if (this.xrQ > i) {
        com.tencent.mm.plugin.report.service.h.IzE.p(1552L, 89L, 1L);
      }
      AppMethodBeat.o(275400);
      return;
    }
  }
  
  public final h.b b(h.a parama)
  {
    return null;
  }
  
  public final void b(h.c paramc) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/FinderLiveNotifyFuncMsgExtension$Companion;", "", "()V", "FUNC_MSGID_PREFIX", "", "Finder_Get_live_tips_CGI", "Finder_Get_live_tips_report_ID", "", "Finder_Get_live_tips_report_IDKey", "MMFinderFuncMsgScene_ByPass", "MMFinderFuncMsgScene_Client", "MMFinderFuncMsgScene_RevokePull", "TAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.a
 * JD-Core Version:    0.7.0.1
 */