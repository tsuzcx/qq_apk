package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.azb;
import com.tencent.mm.protocal.protobuf.azc;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.o;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "roomId", "", "isForCheck", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()Z", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveInfoRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveInfoResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getLiveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class b
  extends n
  implements com.tencent.mm.network.k
{
  public static final b.a gvL;
  private com.tencent.mm.ak.g callback;
  private com.tencent.mm.ak.b gvE;
  private azb gvI;
  private azc gvJ;
  private final boolean gvK;
  
  static
  {
    AppMethodBeat.i(189886);
    gvL = new b.a((byte)0);
    AppMethodBeat.o(189886);
  }
  
  public b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(189885);
    this.gvK = paramBoolean;
    Object localObject = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject).c((a)new azb());
    ((com.tencent.mm.ak.b.a)localObject).d((a)new azc());
    ((com.tencent.mm.ak.b.a)localObject).op(3806);
    ((com.tencent.mm.ak.b.a)localObject).Am("/cgi-bin/micromsg-bin/getliveinfo");
    ((com.tencent.mm.ak.b.a)localObject).or(0);
    ((com.tencent.mm.ak.b.a)localObject).os(0);
    localObject = ((com.tencent.mm.ak.b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.gvE = ((com.tencent.mm.ak.b)localObject);
    localObject = this.gvE.aBC();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveInfoRequest");
      AppMethodBeat.o(189885);
      throw paramString;
    }
    this.gvI = ((azb)localObject);
    this.gvI.DMV = paramLong;
    this.gvI.DMW = paramString;
    ac.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "get live info liveId:" + paramLong + ", roomId:" + paramString);
    AppMethodBeat.o(189885);
  }
  
  public final bqd akF()
  {
    azc localazc = this.gvJ;
    if (localazc != null) {
      return localazc.Eue;
    }
    return null;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(189883);
    ac.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.gvE, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(189883);
    return i;
  }
  
  public final int getType()
  {
    return 3806;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189884);
    paramArrayOfByte = new StringBuilder("onGYNetEnd, errType:").append(paramInt2).append(", errCode:").append(paramInt3).append(", isForCheck:").append(this.gvK).append(", LiveAnchorTRTCCore.hasInstance:");
    Object localObject1 = com.tencent.mm.live.core.core.a.b.gnC;
    paramArrayOfByte = paramArrayOfByte.append(com.tencent.mm.live.core.core.a.b.a.aiN()).append(" LiveVisitorTRTCCore.hasInstance:");
    localObject1 = com.tencent.mm.live.core.core.c.b.gqt;
    ac.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", com.tencent.mm.live.core.core.c.b.a.aiN());
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(189884);
      throw paramString;
    }
    paramq = ((com.tencent.mm.ak.b)paramq).aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveInfoResponse");
      AppMethodBeat.o(189884);
      throw paramString;
    }
    this.gvJ = ((azc)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ac.e("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "onGYNetEnd error");
    }
    for (;;)
    {
      paramq = this.callback;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(189884);
      return;
      if (!this.gvK)
      {
        paramq = com.tencent.mm.live.core.core.c.b.gqt;
        if (!com.tencent.mm.live.core.core.c.b.a.aiN())
        {
          paramq = com.tencent.mm.live.core.core.a.b.gnC;
          if (!com.tencent.mm.live.core.core.a.b.a.aiN()) {}
        }
        else
        {
          paramq = akF();
          if (paramq != null)
          {
            paramArrayOfByte = paramq.Ffc;
            localObject1 = (Collection)paramArrayOfByte;
            if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
            for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
            {
              localObject1 = ((Iterable)paramArrayOfByte).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                String str = (String)((Iterator)localObject1).next();
                paramInt1 = com.tencent.mm.model.q.wb(str);
                Object localObject2 = com.tencent.mm.live.b.g.guG;
                if (com.tencent.mm.live.b.g.akC().get(str) == null)
                {
                  localObject2 = com.tencent.mm.live.b.g.guG;
                  localObject2 = (Map)com.tencent.mm.live.b.g.akC();
                  d.g.b.k.g(str, "it");
                  ((Map)localObject2).put(str, new o(new ArrayList(), Integer.valueOf(paramInt1)));
                }
              }
            }
            ac.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "roomList:".concat(String.valueOf(paramArrayOfByte)));
            paramArrayOfByte = com.tencent.mm.live.b.g.guG;
            com.tencent.mm.live.b.g.a(paramq);
          }
        }
      }
    }
    AppMethodBeat.o(189884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.a.b
 * JD-Core Version:    0.7.0.1
 */