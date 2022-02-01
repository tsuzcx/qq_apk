package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.live.b.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.beb;
import com.tencent.mm.protocal.protobuf.bec;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.o;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineByRoom;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "ignoreErr", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getIgnoreErr", "()Z", "getLiveId", "()J", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineByRoomRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineByRoomResponse;", "getWechatRoomId", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class c
  extends n
  implements k
{
  private static final String TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineByRoom";
  public static final a gSi;
  private f callback;
  private final long gJh;
  private final String gPn;
  private b gRX;
  private beb gSf;
  private bec gSg;
  public final boolean gSh;
  
  static
  {
    AppMethodBeat.i(215796);
    gSi = new a((byte)0);
    TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineByRoom";
    AppMethodBeat.o(215796);
  }
  
  public c(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(215795);
    this.gJh = paramLong;
    this.gPn = paramString;
    this.gSh = paramBoolean;
    paramString = new b.a();
    paramString.c((a)new beb());
    paramString.d((a)new bec());
    paramString.oS(3662);
    paramString.DN("/cgi-bin/micromsg-bin/getliveonlinebyroom");
    paramString.oU(0);
    paramString.oV(0);
    paramString = paramString.aDS();
    p.g(paramString, "builder.buildInstance()");
    this.gRX = paramString;
    paramString = this.gRX.aEU();
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineByRoomRequest");
      AppMethodBeat.o(215795);
      throw paramString;
    }
    this.gSf = ((beb)paramString);
    paramString = this.gSf;
    if (paramString != null) {
      paramString.FKy = this.gJh;
    }
    paramString = this.gSf;
    if (paramString != null)
    {
      paramString.FKz = this.gPn;
      AppMethodBeat.o(215795);
      return;
    }
    AppMethodBeat.o(215795);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215794);
    ae.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(215794);
    return i;
  }
  
  public final int getType()
  {
    return 3662;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215793);
    ae.i(TAG, "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(215793);
      throw paramString;
    }
    paramq = ((b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineByRoomResponse");
      AppMethodBeat.o(215793);
      throw paramString;
    }
    this.gSg = ((bec)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "onGYNetEnd error");
    }
    do
    {
      paramq = this.callback;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(215793);
      return;
      paramArrayOfByte = this.gSg;
    } while (paramArrayOfByte == null);
    paramq = g.gQZ;
    if (g.anE().get(this.gPn) == null)
    {
      paramq = g.gQZ;
      ((Map)g.anE()).put(this.gPn, new o(new ArrayList(), Integer.valueOf(0)));
    }
    paramq = g.gQZ;
    paramq = (o)g.anE().get(this.gPn);
    Object localObject2;
    if (paramq != null)
    {
      paramq = (ArrayList)paramq.first;
      if (paramq != null) {
        paramq.clear();
      }
      if (paramq != null)
      {
        localObject1 = paramArrayOfByte.GTB;
        p.g(localObject1, "it.identity_id_list");
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
      }
    }
    else
    {
      label306:
      label376:
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label378;
        }
        Object localObject3 = ((Iterator)localObject2).next();
        String str = (String)localObject3;
        g localg = g.gQZ;
        if (!bu.lX(g.anJ(), str)) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label376;
          }
          ((Collection)localObject1).add(localObject3);
          break label306;
          paramq = null;
          break;
        }
      }
      label378:
      paramq.addAll((Collection)localObject1);
    }
    Object localObject1 = g.gQZ;
    localObject1 = g.anH();
    if (paramq != null) {}
    for (paramInt1 = paramq.size();; paramInt1 = 0)
    {
      ((bvk)localObject1).GTv = paramInt1;
      ae.i(TAG, "it.identity_id_list:" + paramArrayOfByte.GTB);
      break;
    }
    AppMethodBeat.o(215793);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineByRoom$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.c
 * JD-Core Version:    0.7.0.1
 */