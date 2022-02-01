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
import com.tencent.mm.protocal.protobuf.bef;
import com.tencent.mm.protocal.protobuf.beg;
import com.tencent.mm.protocal.protobuf.bvt;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineStateRoom;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "(JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLiveId", "()J", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineStateByRoomRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineStateByRoomResponse;", "getWechatRoomId", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class d
  extends n
  implements k
{
  private static final String TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineStateRoom";
  public static final a gSl;
  private f callback;
  private final long gJh;
  private final String gPn;
  private b gRX;
  private bef gSj;
  private beg gSk;
  
  static
  {
    AppMethodBeat.i(215800);
    gSl = new a((byte)0);
    TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineStateRoom";
    AppMethodBeat.o(215800);
  }
  
  public d(long paramLong, String paramString)
  {
    AppMethodBeat.i(215799);
    this.gJh = paramLong;
    this.gPn = paramString;
    paramString = new b.a();
    paramString.c((a)new bef());
    paramString.d((a)new beg());
    paramString.oS(3700);
    paramString.DN("/cgi-bin/micromsg-bin/getliveonlinestatebyroom");
    paramString.oU(0);
    paramString.oV(0);
    paramString = paramString.aDS();
    p.g(paramString, "builder.buildInstance()");
    this.gRX = paramString;
    paramString = this.gRX.aEU();
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineStateByRoomRequest");
      AppMethodBeat.o(215799);
      throw paramString;
    }
    this.gSj = ((bef)paramString);
    paramString = this.gSj;
    if (paramString != null) {
      paramString.FKy = this.gJh;
    }
    paramString = this.gSj;
    if (paramString != null)
    {
      paramString.FKz = this.gPn;
      AppMethodBeat.o(215799);
      return;
    }
    AppMethodBeat.o(215799);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215797);
    ae.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(215797);
    return i;
  }
  
  public final int getType()
  {
    return 3700;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215798);
    ae.i(TAG, "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(215798);
      throw paramString;
    }
    paramq = ((b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineStateByRoomResponse");
      AppMethodBeat.o(215798);
      throw paramString;
    }
    this.gSk = ((beg)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e(TAG, "onGYNetEnd error");
    }
    for (;;)
    {
      paramq = this.callback;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(215798);
      return;
      paramArrayOfByte = this.gSk;
      if (paramArrayOfByte != null)
      {
        paramq = g.gQZ;
        if (g.anE().get(this.gPn) == null)
        {
          paramq = g.gQZ;
          ((Map)g.anE()).put(this.gPn, new o(new ArrayList(), Integer.valueOf(0)));
        }
        paramq = g.gQZ;
        paramq = (o)g.anE().get(this.gPn);
        if (paramq != null) {}
        ArrayList localArrayList;
        for (paramq = (ArrayList)paramq.first;; paramq = null)
        {
          if (paramq != null) {
            paramq.clear();
          }
          localArrayList = new ArrayList();
          paramArrayOfByte = paramArrayOfByte.GTD;
          p.g(paramArrayOfByte, "it.user_online_state_list");
          paramArrayOfByte = ((Iterable)paramArrayOfByte).iterator();
          while (paramArrayOfByte.hasNext()) {
            localArrayList.add(((bvt)paramArrayOfByte.next()).Hio);
          }
        }
        if (paramq != null) {
          paramq.addAll((Collection)localArrayList);
        }
        ae.i(TAG, "idList:".concat(String.valueOf(localArrayList)));
        paramq = g.gQZ;
        g.anH().GTv = localArrayList.size();
      }
    }
    AppMethodBeat.o(215798);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineStateRoom$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.d
 * JD-Core Version:    0.7.0.1
 */