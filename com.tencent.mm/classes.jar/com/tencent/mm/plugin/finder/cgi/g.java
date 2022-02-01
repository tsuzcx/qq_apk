package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.protocal.protobuf.bgf;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderBatchGetObjectAsyncLoadInfoRequest;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoResponse;", "objectIds", "", "Lkotlin/Pair;", "", "", "scene", "", "liveReportScene", "commentScene", "finderUserName", "uxInfo", "(Ljava/util/List;IIILjava/lang/String;Ljava/lang/String;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class g
  extends c<aqg>
{
  private final String TAG;
  private aqf xav;
  
  private g(List<o<Long, String>> paramList, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(291755);
    this.TAG = "Finder.CgiFinderBatchGetObjectAsyncLoadInfoRequest";
    this.xav = new aqf();
    Object localObject1 = this.xav;
    Object localObject2 = ao.xcj;
    ((aqf)localObject1).SDi = ao.dnO();
    localObject1 = new LinkedList();
    localObject2 = ((Iterable)paramList).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      o localo = (o)((Iterator)localObject2).next();
      bgf localbgf = new bgf();
      localbgf.object_id = ((Number)localo.Mx).longValue();
      localbgf.object_nonce_id = ((String)localo.My);
      ((LinkedList)localObject1).add(localbgf);
    }
    Log.i(this.TAG, "init idList " + ((LinkedList)localObject1).size() + " objectIds: " + paramList.size());
    this.xav.SDx = ((LinkedList)localObject1);
    this.xav.scene = paramInt1;
    this.xav.SDy = 0;
    this.xav.SDz = paramInt2;
    this.xav.finderUsername = paramString1;
    this.xav.SDA = com.tencent.mm.plugin.sns.ad.i.g.fLT();
    this.xav.jDL = paramString2;
    paramList = new d.a();
    paramList.c((a)this.xav);
    paramString1 = new aqg();
    paramString1.setBaseResponse(new jh());
    paramString1.getBaseResponse().Tef = new eaf();
    paramList.d((a)paramString1);
    paramList.TW("/cgi-bin/micromsg-bin/finderbatchgetobjectasyncloadinfo");
    paramList.vD(6499);
    c(paramList.bgN());
    Log.i(this.TAG, "init");
    AppMethodBeat.o(291755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.g
 * JD-Core Version:    0.7.0.1
 */