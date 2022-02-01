package com.tencent.mm.plugin.finder.extension;

import com.tencent.d.a.a.a.d.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f;
import com.tencent.mm.am.f.b;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.am.g.c;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.axx;
import com.tencent.mm.protocal.protobuf.duu;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/FinderLiveNotifyFuncMsgExtension;", "Lcom/tencent/mm/modelbase/IFunctionMessageExtension;", "()V", "oldCanRevokeCount", "", "getOldCanRevokeCount", "()I", "setOldCanRevokeCount", "(I)V", "reqClientAiInfo", "", "getReqClientAiInfo", "()Ljava/lang/String;", "setReqClientAiInfo", "(Ljava/lang/String;)V", "reqFunctionMsgId", "getReqFunctionMsgId", "setReqFunctionMsgId", "reqFunctionMsgIdOnLiveClose", "getReqFunctionMsgIdOnLiveClose", "setReqFunctionMsgIdOnLiveClose", "beforeAddMsg", "", "getAddMsgType", "getBusinessId", "", "onBuildFetchParams", "params", "Lcom/tencent/mm/modelbase/IFunctionMessageExtension$FetchAddMsgParams;", "onPreAddMessage", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgReturn;", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "onPreDelMessage", "deleteMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$DeleteMsgInfo;", "requestFinderLiveNotify", "json", "requestOnLiveClose", "funcMsgId", "resetClientReq", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements f
{
  public static final a.a AOX;
  public String AOY;
  public String AOZ;
  public String APa;
  private volatile int APb;
  
  static
  {
    AppMethodBeat.i(366639);
    AOX = new a.a((byte)0);
    AppMethodBeat.o(366639);
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(366667);
    tb localtb = paramb.otK;
    if (localtb != null)
    {
      axx localaxx = new axx();
      localaxx.scene = 0;
      Object localObject1 = bi.ABn;
      localaxx.YIY = bi.dVu();
      this.APb = 0;
      if (s.p(this.AOY, paramb.otL))
      {
        localaxx.ZIW = this.APa;
        localaxx.scene = 1;
        this.APa = "";
        this.AOY = "";
      }
      if (s.p(this.AOZ, paramb.otL))
      {
        localaxx.scene = 2;
        this.AOZ = "";
      }
      Log.i("Finder.FinderLiveNotifyFuncMsgExtension", "onBuildFetchParams scene[" + localaxx.scene + ']');
      localObject1 = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveNotifyExposureInfoStorage().eub();
      paramb = new LinkedList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (g)((Iterator)localObject1).next();
        if ((((g)localObject2).field_exposureStatus == 0) && (((g)localObject2).field_liveStatus == 0)) {
          this.APb += 1;
        }
        duu localduu = new duu();
        localduu.abaF = ((g)localObject2).field_insertTime;
        localduu.ZYN = ((g)localObject2).field_tipsId;
        localduu.abaH = ((g)localObject2).field_exposureStatus;
        localduu.liveStatus = ((g)localObject2).field_liveStatus;
        localduu.mMJ = Util.safeParseLong(((g)localObject2).field_liveId);
        localduu.abaG = ((g)localObject2).field_ctrlInfoType;
        localduu.abaI = ((g)localObject2).field_bypInfo;
        localduu.object_id = Util.safeParseLong(((g)localObject2).field_feedId);
        localObject2 = ah.aiuX;
        paramb.add(localduu);
      }
      localObject1 = ah.aiuX;
      localaxx.lPK = paramb;
      if (localaxx.lPK.size() > 100)
      {
        paramb = localaxx.lPK;
        s.s(paramb, "this.list");
        localaxx.lPK = new LinkedList((Collection)p.c((Iterable)paramb, 100));
      }
      paramb = ah.aiuX;
      localtb.YYw = new com.tencent.mm.bx.b(localaxx.toByteArray());
    }
    AppMethodBeat.o(366667);
  }
  
  public final int aTl()
  {
    return -1;
  }
  
  public final long aTm()
  {
    return 70001L;
  }
  
  public final void aTn()
  {
    AppMethodBeat.i(366646);
    int i;
    if (this.APb > 0)
    {
      Object localObject = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveNotifyExposureInfoStorage().eub();
      i = 0;
      localObject = ((Iterable)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        g localg = (g)((Iterator)localObject).next();
        if ((localg.field_exposureStatus != 0) || (localg.field_liveStatus != 0)) {
          break label110;
        }
        i += 1;
      }
    }
    label110:
    for (;;)
    {
      break;
      if (this.APb > i) {
        com.tencent.mm.plugin.report.service.h.OAn.p(1552L, 89L, 1L);
      }
      AppMethodBeat.o(366646);
      return;
    }
  }
  
  public final g.b b(g.a parama)
  {
    return null;
  }
  
  public final void b(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.a
 * JD-Core Version:    0.7.0.1
 */