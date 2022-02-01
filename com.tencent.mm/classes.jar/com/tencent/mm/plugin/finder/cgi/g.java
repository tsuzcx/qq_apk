package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.aua;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.brr;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderBatchGetObjectAsyncLoadInfo;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoResponse;", "units", "", "Lcom/tencent/mm/protocal/protobuf/FinderObjectUidUnit;", "scene", "", "liveReportScene", "commentScene", "finderUserName", "", "uxInfo", "(Ljava/util/List;IIILjava/lang/String;Ljava/lang/String;)V", "objectIds", "Lkotlin/Pair;", "", "(Ljava/util/List;IILjava/lang/String;Ljava/lang/String;)V", "(Ljava/util/List;II)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends c<aub>
{
  public static final g.a Ayy;
  private aua Ayz;
  
  static
  {
    AppMethodBeat.i(336419);
    Ayy = new g.a((byte)0);
    AppMethodBeat.o(336419);
  }
  
  private g(List<r<String, String>> paramList)
  {
    this((List)paramList, 3, 0);
    AppMethodBeat.o(336408);
  }
  
  public g(List<? extends brr> paramList, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(336374);
    this.Ayz = new aua();
    Object localObject1 = this.Ayz;
    Object localObject2 = bi.ABn;
    ((aua)localObject1).ZEc = bi.dVu();
    localObject2 = (Iterable)paramList;
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      brr localbrr = (brr)((Iterator)localObject2).next();
      ((Collection)localObject1).add(d.hF(localbrr.object_id) + '#' + localbrr.ZZS);
    }
    Log.i("Cgi.FinderBatchGetObjectAsyncLoadInfo", s.X("[init] idList ", (List)localObject1));
    this.Ayz.ZEv.addAll((Collection)paramList);
    this.Ayz.scene = paramInt1;
    this.Ayz.ZEw = 0;
    this.Ayz.ZEx = paramInt3;
    this.Ayz.finderUsername = paramString1;
    this.Ayz.ZEy = com.tencent.mm.plugin.sns.ad.j.g.hcn();
    this.Ayz.mdG = paramString2;
    paramList = new c.a();
    paramList.otE = ((a)this.Ayz);
    paramString1 = new aub();
    paramString1.setBaseResponse(new kd());
    paramString1.getBaseResponse().akjO = new etl();
    paramList.otF = ((a)paramString1);
    paramList.uri = "/cgi-bin/micromsg-bin/finderbatchgetobjectasyncloadinfo";
    paramList.funcId = 6499;
    c(paramList.bEF());
    AppMethodBeat.o(336374);
  }
  
  public g(List<r<Long, String>> paramList, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this((List)paramList, paramInt1, 0, paramInt2, paramString1, paramString2);
    AppMethodBeat.o(336391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.g
 * JD-Core Version:    0.7.0.1
 */