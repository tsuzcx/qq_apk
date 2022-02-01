package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aie;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneReportScreenShot;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "actionType", "", "extStats", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "(ILjava/util/LinkedList;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getActionType", "()I", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getExtStats", "()Ljava/util/LinkedList;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bi
  extends n
  implements k
{
  private final String TAG;
  private final int actionType;
  private f callback;
  private final LinkedList<aie> rKn;
  private b rr;
  
  public bi(LinkedList<aie> paramLinkedList)
  {
    AppMethodBeat.i(201176);
    this.actionType = 0;
    this.rKn = paramLinkedList;
    this.TAG = "Finder.NetSceneReportScreenShot";
    paramLinkedList = new b.a();
    paramLinkedList.oP(getType());
    Object localObject = new aml();
    ((aml)localObject).rTn = u.aAu();
    ((aml)localObject).actionType = this.actionType;
    ((aml)localObject).rKn = this.rKn;
    paramLinkedList.c((a)localObject);
    localObject = new amm();
    ((amm)localObject).setBaseResponse(new BaseResponse());
    paramLinkedList.d((a)localObject);
    paramLinkedList.Dl("/cgi-bin/micromsg-bin/finderextstatsreport");
    paramLinkedList = paramLinkedList.aDC();
    p.g(paramLinkedList, "builder.buildInstance()");
    this.rr = paramLinkedList;
    paramLinkedList = new StringBuilder("");
    localObject = ((Iterable)this.rKn).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramLinkedList.append(c.rc(((aie)((Iterator)localObject).next()).rIZ)).append(",");
    }
    ad.i(this.TAG, "NetSceneReportScreenShot start " + this.actionType + ", " + paramLinkedList);
    AppMethodBeat.o(201176);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(201175);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201175);
    return i;
  }
  
  public final int getType()
  {
    return 6681;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201174);
    ad.i(this.TAG, "onGYNetEnd " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramString + ' ');
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(201174);
      return;
    }
    AppMethodBeat.o(201174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bi
 * JD-Core Version:    0.7.0.1
 */