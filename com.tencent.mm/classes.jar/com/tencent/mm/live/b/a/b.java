package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.live.b.g;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bdv;
import com.tencent.mm.protocal.protobuf.bdw;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.o;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "roomId", "", "isForCheck", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()Z", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveInfoRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveInfoResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getLiveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class b
  extends n
  implements k
{
  public static final a gSe;
  private f callback;
  private com.tencent.mm.ak.b gRX;
  private bdv gSb;
  private bdw gSc;
  private final boolean gSd;
  
  static
  {
    AppMethodBeat.i(215792);
    gSe = new a((byte)0);
    AppMethodBeat.o(215792);
  }
  
  public b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(215791);
    this.gSd = paramBoolean;
    Object localObject = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject).c((a)new bdv());
    ((com.tencent.mm.ak.b.a)localObject).d((a)new bdw());
    ((com.tencent.mm.ak.b.a)localObject).oS(3806);
    ((com.tencent.mm.ak.b.a)localObject).DN("/cgi-bin/micromsg-bin/getliveinfo");
    ((com.tencent.mm.ak.b.a)localObject).oU(0);
    ((com.tencent.mm.ak.b.a)localObject).oV(0);
    localObject = ((com.tencent.mm.ak.b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.gRX = ((com.tencent.mm.ak.b)localObject);
    localObject = this.gRX.aEU();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveInfoRequest");
      AppMethodBeat.o(215791);
      throw paramString;
    }
    this.gSb = ((bdv)localObject);
    this.gSb.FKy = paramLong;
    this.gSb.FKz = paramString;
    ae.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "get live info liveId:" + paramLong + ", roomId:" + paramString);
    AppMethodBeat.o(215791);
  }
  
  public final bvk anH()
  {
    bdw localbdw = this.gSc;
    if (localbdw != null) {
      return localbdw.Gue;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215789);
    ae.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(215789);
    return i;
  }
  
  public final int getType()
  {
    return 3806;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215790);
    paramArrayOfByte = new StringBuilder("onGYNetEnd, errType:").append(paramInt2).append(", errCode:").append(paramInt3).append(", isForCheck:").append(this.gSd).append(", LiveAnchorTRTCCore.hasInstance:");
    Object localObject1 = com.tencent.mm.live.core.core.a.b.gJU;
    paramArrayOfByte = paramArrayOfByte.append(com.tencent.mm.live.core.core.a.b.a.alO()).append(" LiveVisitorTRTCCore.hasInstance:");
    localObject1 = com.tencent.mm.live.core.core.c.b.gMM;
    ae.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", com.tencent.mm.live.core.core.c.b.a.alO());
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(215790);
      throw paramString;
    }
    paramq = ((com.tencent.mm.ak.b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveInfoResponse");
      AppMethodBeat.o(215790);
      throw paramString;
    }
    this.gSc = ((bdw)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "onGYNetEnd error");
    }
    for (;;)
    {
      paramq = this.callback;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(215790);
      return;
      if (!this.gSd)
      {
        paramq = com.tencent.mm.live.core.core.c.b.gMM;
        if (!com.tencent.mm.live.core.core.c.b.a.alO())
        {
          paramq = com.tencent.mm.live.core.core.a.b.gJU;
          if (!com.tencent.mm.live.core.core.a.b.a.alO()) {}
        }
        else
        {
          paramq = anH();
          if (paramq != null)
          {
            paramArrayOfByte = paramq.Hig;
            localObject1 = (Collection)paramArrayOfByte;
            if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
            for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
            {
              localObject1 = ((Iterable)paramArrayOfByte).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                String str = (String)((Iterator)localObject1).next();
                paramInt1 = r.zC(str);
                Object localObject2 = g.gQZ;
                if (g.anE().get(str) == null)
                {
                  localObject2 = g.gQZ;
                  localObject2 = (Map)g.anE();
                  p.g(str, "it");
                  ((Map)localObject2).put(str, new o(new ArrayList(), Integer.valueOf(paramInt1)));
                }
              }
            }
            ae.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "roomList:".concat(String.valueOf(paramArrayOfByte)));
            paramArrayOfByte = g.gQZ;
            g.a(paramq);
          }
        }
      }
    }
    AppMethodBeat.o(215790);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveInfo$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.b
 * JD-Core Version:    0.7.0.1
 */