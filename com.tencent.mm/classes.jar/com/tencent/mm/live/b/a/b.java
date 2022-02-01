package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.live.b.f;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.protocal.protobuf.eab;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.o;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "roomId", "", "isForCheck", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()Z", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveInfoRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveInfoResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getLiveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class b
  extends n
  implements com.tencent.mm.network.k
{
  public static final a zba;
  private g callback;
  private com.tencent.mm.al.b iaa;
  private eaa zaX;
  private eab zaY;
  private final boolean zaZ;
  
  static
  {
    AppMethodBeat.i(202695);
    zba = new a((byte)0);
    AppMethodBeat.o(202695);
  }
  
  public b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(202694);
    this.zaZ = paramBoolean;
    Object localObject = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject).c((a)new eaa());
    ((com.tencent.mm.al.b.a)localObject).d((a)new eab());
    ((com.tencent.mm.al.b.a)localObject).nB(3806);
    ((com.tencent.mm.al.b.a)localObject).wg("/cgi-bin/micromsg-bin/getliveinfo");
    ((com.tencent.mm.al.b.a)localObject).nD(0);
    ((com.tencent.mm.al.b.a)localObject).nE(0);
    localObject = ((com.tencent.mm.al.b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.iaa = ((com.tencent.mm.al.b)localObject);
    localObject = this.iaa.auL();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveInfoRequest");
      AppMethodBeat.o(202694);
      throw paramString;
    }
    this.zaX = ((eaa)localObject);
    this.zaX.LwA = paramLong;
    this.zaX.EEF = paramString;
    ad.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "get live info liveId:" + paramLong + ", roomId:" + paramString);
    AppMethodBeat.o(202694);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(202692);
    ad.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.iaa, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(202692);
    return i;
  }
  
  public final eas eNG()
  {
    eab localeab = this.zaY;
    if (localeab != null) {
      return localeab.Lxa;
    }
    return null;
  }
  
  public final int getType()
  {
    return 3806;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(202693);
    paramArrayOfByte = new StringBuilder("onGYNetEnd, errType:").append(paramInt2).append(", errCode:").append(paramInt3).append(", isForCheck:").append(this.zaZ).append(", LiveAnchorTRTCCore.hasInstance:");
    Object localObject1 = com.tencent.mm.live.core.core.a.b.qym;
    paramArrayOfByte = paramArrayOfByte.append(com.tencent.mm.live.core.core.a.b.a.cnr()).append(" LiveVisitorTRTCCore.hasInstance:");
    localObject1 = com.tencent.mm.live.core.core.c.b.qOk;
    ad.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", com.tencent.mm.live.core.core.c.b.a.cnr());
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(202693);
      throw paramString;
    }
    paramq = ((com.tencent.mm.al.b)paramq).auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveInfoResponse");
      AppMethodBeat.o(202693);
      throw paramString;
    }
    this.zaY = ((eab)paramq);
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
      AppMethodBeat.o(202693);
      return;
      if (!this.zaZ)
      {
        paramq = eNG();
        if (paramq != null)
        {
          paramArrayOfByte = paramq.Lzc;
          localObject1 = (Collection)paramArrayOfByte;
          if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
          for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
          {
            localObject1 = ((Iterable)paramArrayOfByte).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              String str = (String)((Iterator)localObject1).next();
              paramInt1 = com.tencent.mm.model.q.rY(str);
              Object localObject2 = f.rGw;
              if (f.eND().get(str) == null)
              {
                localObject2 = f.rGw;
                localObject2 = (Map)f.eND();
                d.g.b.k.g(str, "it");
                ((Map)localObject2).put(str, new o(new ArrayList(), Integer.valueOf(paramInt1)));
              }
            }
          }
          ad.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "roomList:".concat(String.valueOf(paramArrayOfByte)));
          paramArrayOfByte = f.rGw;
          f.a(paramq);
        }
      }
    }
    AppMethodBeat.o(202693);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveInfo$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.a.b
 * JD-Core Version:    0.7.0.1
 */