package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bdn;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetOnlineMemberById;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "idList", "", "", "(JLjava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineMemberByIdRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineMemberByIdResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getRemoteUserList", "Lcom/tencent/mm/protocal/protobuf/OnlineMemberInfo;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class n
  extends com.tencent.mm.al.n
  implements k
{
  public static final a gQh;
  private f callback;
  private b gPp;
  private bdn gQf;
  public bdo gQg;
  
  static
  {
    AppMethodBeat.i(212220);
    gQh = new a((byte)0);
    AppMethodBeat.o(212220);
  }
  
  public n(long paramLong, List<String> paramList)
  {
    AppMethodBeat.i(212219);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new bdn());
    ((b.a)localObject).d((a)new bdo());
    ((b.a)localObject).oP(3816);
    ((b.a)localObject).Dl("/cgi-bin/micromsg-bin/getliveonlinememberbyid");
    ((b.a)localObject).oR(0);
    ((b.a)localObject).oS(0);
    localObject = ((b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.gPp = ((b)localObject);
    localObject = this.gPp.aEE();
    if (localObject == null)
    {
      paramList = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineMemberByIdRequest");
      AppMethodBeat.o(212219);
      throw paramList;
    }
    this.gQf = ((bdn)localObject);
    this.gQf.Fsa = paramLong;
    localObject = (Collection)paramList;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.gQf.GAb;
        if (localObject != null) {
          ((LinkedList)localObject).addAll((Collection)paramList);
        }
      }
      ad.i("MicroMsg.LiveNetScene.NetSceneLiveGetOnlineMemberById", "get live info liveId:".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(212219);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(212217);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveGetOnlineMemberById", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
    AppMethodBeat.o(212217);
    return i;
  }
  
  public final int getType()
  {
    return 3806;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212218);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveGetOnlineMemberById", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(212218);
      throw paramString;
    }
    paramq = ((b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineMemberByIdResponse");
      AppMethodBeat.o(212218);
      throw paramString;
    }
    this.gQg = ((bdo)paramq);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
      AppMethodBeat.o(212218);
      return;
    }
    AppMethodBeat.o(212218);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetOnlineMemberById$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.n
 * JD-Core Version:    0.7.0.1
 */