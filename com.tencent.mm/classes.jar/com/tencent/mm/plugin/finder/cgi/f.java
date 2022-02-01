package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aow;
import com.tencent.mm.protocal.protobuf.aox;
import com.tencent.mm.protocal.protobuf.azz;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderBatchGetObjectAsyncLoadInfoRequest;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoResponse;", "objectIds", "", "Lkotlin/Pair;", "", "", "scene", "", "(Ljava/util/List;I)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class f
  extends an<aox>
{
  private final String TAG;
  private aow tsN;
  
  public f(List<o<Long, String>> paramList, int paramInt)
  {
    AppMethodBeat.i(242208);
    this.TAG = "Finder.CgiFinderBatchGetObjectAsyncLoadInfoRequest";
    this.tsN = new aow();
    Object localObject1 = this.tsN;
    Object localObject2 = am.tuw;
    ((aow)localObject1).LAI = am.cXY();
    localObject1 = new LinkedList();
    localObject2 = ((Iterable)paramList).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      o localo = (o)((Iterator)localObject2).next();
      azz localazz = new azz();
      localazz.object_id = ((Number)localo.first).longValue();
      localazz.object_nonce_id = ((String)localo.second);
      ((LinkedList)localObject1).add(localazz);
    }
    Log.i(this.TAG, "init idList " + ((LinkedList)localObject1).size() + " objectIds: " + paramList.size());
    this.tsN.LAU = ((LinkedList)localObject1);
    this.tsN.scene = paramInt;
    paramList = new d.a();
    paramList.c((a)this.tsN);
    localObject1 = new aox();
    ((aox)localObject1).setBaseResponse(new BaseResponse());
    ((aox)localObject1).getBaseResponse().ErrMsg = new dqi();
    paramList.d((a)localObject1);
    paramList.MB("/cgi-bin/micromsg-bin/finderbatchgetobjectasyncloadinfo");
    paramList.sG(6499);
    c(paramList.aXF());
    Log.i(this.TAG, "init");
    AppMethodBeat.o(242208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.f
 * JD-Core Version:    0.7.0.1
 */