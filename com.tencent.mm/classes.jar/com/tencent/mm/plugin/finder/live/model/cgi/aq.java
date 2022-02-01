package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.bqw;
import com.tencent.mm.protocal.protobuf.buc;
import com.tencent.mm.protocal.protobuf.bud;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshNotify;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderRefreshTipsResponse;", "tipsEntryList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderNotifyTipsEntry;", "callBack", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshNotify$CallBack;", "(Ljava/util/LinkedList;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshNotify$CallBack;)V", "TAG", "", "getCallBack", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshNotify$CallBack;", "entryStr", "Ljava/lang/StringBuilder;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderRefreshTipsRequest;", "getTipsEntryList", "()Ljava/util/LinkedList;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aq
  extends o<bud>
{
  private final LinkedList<bqw> CKr;
  private final a CKs;
  private buc CKt;
  private StringBuilder CKu;
  private final String TAG;
  
  public aq(LinkedList<bqw> paramLinkedList, a parama)
  {
    AppMethodBeat.i(360205);
    this.CKr = paramLinkedList;
    this.CKs = parama;
    this.TAG = "Finder.CgiFinderLiveRefreshNotify";
    this.CKt = new buc();
    this.CKu = new StringBuilder("");
    this.CKt.username = z.bAM();
    paramLinkedList = this.CKt;
    parama = bi.ABn;
    paramLinkedList.YIY = bi.dVu();
    this.CKt.aabU = this.CKr;
    paramLinkedList = new c.a();
    paramLinkedList.otE = ((a)this.CKt);
    parama = new bud();
    parama.setBaseResponse(new kd());
    parama.getBaseResponse().akjO = new etl();
    paramLinkedList.otF = ((a)parama);
    paramLinkedList.uri = "/cgi-bin/micromsg-bin/finderrefreshtips";
    paramLinkedList.funcId = 5273;
    paramLinkedList = paramLinkedList.bEF();
    Log.i(this.TAG, s.X("entryStr:", this.CKu));
    c(paramLinkedList);
    paramLinkedList = ((Iterable)this.CKr).iterator();
    while (paramLinkedList.hasNext())
    {
      parama = (bqw)paramLinkedList.next();
      this.CKu.append(parama.ZYN).append('|');
    }
    Log.i(this.TAG, s.X("init req ,list = ", this.CKu));
    AppMethodBeat.o(360205);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshNotify$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderRefreshTipsResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, bud parambud);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.aq
 * JD-Core Version:    0.7.0.1
 */