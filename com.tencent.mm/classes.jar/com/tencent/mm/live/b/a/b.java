package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.live.b.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.bdf;
import com.tencent.mm.protocal.protobuf.bdg;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.o;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "roomId", "", "isForCheck", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()Z", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveInfoRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveInfoResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getLiveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class b
  extends n
  implements k
{
  public static final a gPw;
  private f callback;
  private com.tencent.mm.al.b gPp;
  private bdf gPt;
  private bdg gPu;
  private final boolean gPv;
  
  static
  {
    AppMethodBeat.i(212172);
    gPw = new a((byte)0);
    AppMethodBeat.o(212172);
  }
  
  public b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(212171);
    this.gPv = paramBoolean;
    Object localObject = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject).c((a)new bdf());
    ((com.tencent.mm.al.b.a)localObject).d((a)new bdg());
    ((com.tencent.mm.al.b.a)localObject).oP(3806);
    ((com.tencent.mm.al.b.a)localObject).Dl("/cgi-bin/micromsg-bin/getliveinfo");
    ((com.tencent.mm.al.b.a)localObject).oR(0);
    ((com.tencent.mm.al.b.a)localObject).oS(0);
    localObject = ((com.tencent.mm.al.b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.gPp = ((com.tencent.mm.al.b)localObject);
    localObject = this.gPp.aEE();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveInfoRequest");
      AppMethodBeat.o(212171);
      throw paramString;
    }
    this.gPt = ((bdf)localObject);
    this.gPt.Fsa = paramLong;
    this.gPt.Fsb = paramString;
    ad.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "get live info liveId:" + paramLong + ", roomId:" + paramString);
    AppMethodBeat.o(212171);
  }
  
  public final buq ans()
  {
    bdg localbdg = this.gPu;
    if (localbdg != null) {
      return localbdg.Gbx;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(212169);
    ad.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.gPp, (k)this);
    AppMethodBeat.o(212169);
    return i;
  }
  
  public final int getType()
  {
    return 3806;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212170);
    paramArrayOfByte = new StringBuilder("onGYNetEnd, errType:").append(paramInt2).append(", errCode:").append(paramInt3).append(", isForCheck:").append(this.gPv).append(", LiveAnchorTRTCCore.hasInstance:");
    Object localObject1 = com.tencent.mm.live.core.core.a.b.gHl;
    paramArrayOfByte = paramArrayOfByte.append(com.tencent.mm.live.core.core.a.b.a.alz()).append(" LiveVisitorTRTCCore.hasInstance:");
    localObject1 = com.tencent.mm.live.core.core.c.b.gKd;
    ad.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", com.tencent.mm.live.core.core.c.b.a.alz());
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(212170);
      throw paramString;
    }
    paramq = ((com.tencent.mm.al.b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveInfoResponse");
      AppMethodBeat.o(212170);
      throw paramString;
    }
    this.gPu = ((bdg)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "onGYNetEnd error");
    }
    for (;;)
    {
      paramq = this.callback;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(212170);
      return;
      if (!this.gPv)
      {
        paramq = com.tencent.mm.live.core.core.c.b.gKd;
        if (!com.tencent.mm.live.core.core.c.b.a.alz())
        {
          paramq = com.tencent.mm.live.core.core.a.b.gHl;
          if (!com.tencent.mm.live.core.core.a.b.a.alz()) {}
        }
        else
        {
          paramq = ans();
          if (paramq != null)
          {
            paramArrayOfByte = paramq.GOG;
            localObject1 = (Collection)paramArrayOfByte;
            if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
            for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
            {
              localObject1 = ((Iterable)paramArrayOfByte).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                String str = (String)((Iterator)localObject1).next();
                paramInt1 = com.tencent.mm.model.q.yS(str);
                Object localObject2 = g.gOr;
                if (g.ano().get(str) == null)
                {
                  localObject2 = g.gOr;
                  localObject2 = (Map)g.ano();
                  p.g(str, "it");
                  ((Map)localObject2).put(str, new o(new ArrayList(), Integer.valueOf(paramInt1)));
                }
              }
            }
            ad.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "roomList:".concat(String.valueOf(paramArrayOfByte)));
            paramArrayOfByte = g.gOr;
            g.a(paramq);
          }
        }
      }
    }
    AppMethodBeat.o(212170);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveInfo$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.b
 * JD-Core Version:    0.7.0.1
 */