package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.bfp;
import com.tencent.mm.protocal.protobuf.bia;
import com.tencent.mm.protocal.protobuf.bib;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshNotify;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderRefreshTipsResponse;", "tipsEntryList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderNotifyTipsEntry;", "callBack", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshNotify$CallBack;", "(Ljava/util/LinkedList;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshNotify$CallBack;)V", "TAG", "", "getCallBack", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshNotify$CallBack;", "entryStr", "Ljava/lang/StringBuilder;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderRefreshTipsRequest;", "getTipsEntryList", "()Ljava/util/LinkedList;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class ah
  extends n<bib>
{
  private final String TAG;
  private bia yjX;
  private StringBuilder yjY;
  private final LinkedList<bfp> yjZ;
  private final a yka;
  
  public ah(LinkedList<bfp> paramLinkedList, a parama)
  {
    AppMethodBeat.i(277379);
    this.yjZ = paramLinkedList;
    this.yka = parama;
    this.TAG = "Finder.CgiFinderLiveRefreshNotify";
    this.yjX = new bia();
    this.yjY = new StringBuilder("");
    this.yjX.username = z.bcZ();
    paramLinkedList = this.yjX;
    parama = ao.xcj;
    paramLinkedList.RLM = ao.dnO();
    this.yjX.SSC = this.yjZ;
    paramLinkedList = new d.a();
    paramLinkedList.c((a)this.yjX);
    parama = new bib();
    parama.setBaseResponse(new jh());
    parama.getBaseResponse().Tef = new eaf();
    paramLinkedList.d((a)parama);
    paramLinkedList.TW("/cgi-bin/micromsg-bin/finderrefreshtips");
    paramLinkedList.vD(5273);
    paramLinkedList = paramLinkedList.bgN();
    Log.i(this.TAG, "entryStr:" + this.yjY.toString());
    c(paramLinkedList);
    paramLinkedList = ((Iterable)this.yjZ).iterator();
    while (paramLinkedList.hasNext())
    {
      parama = (bfp)paramLinkedList.next();
      this.yjY.append(parama.SQm).append('|');
    }
    Log.i(this.TAG, "init req ,list = " + this.yjY.toString());
    AppMethodBeat.o(277379);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshNotify$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderRefreshTipsResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, bib parambib);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ah
 * JD-Core Version:    0.7.0.1
 */