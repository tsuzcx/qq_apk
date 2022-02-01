package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.live.b.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.protocal.protobuf.buz;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineStateRoom;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "(JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLiveId", "()J", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineStateByRoomRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineStateByRoomResponse;", "getWechatRoomId", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class d
  extends n
  implements k
{
  private static final String TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineStateRoom";
  public static final a gPD;
  private f callback;
  private final long gGy;
  private final String gME;
  private bdp gPB;
  private bdq gPC;
  private b gPp;
  
  static
  {
    AppMethodBeat.i(212180);
    gPD = new a((byte)0);
    TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineStateRoom";
    AppMethodBeat.o(212180);
  }
  
  public d(long paramLong, String paramString)
  {
    AppMethodBeat.i(212179);
    this.gGy = paramLong;
    this.gME = paramString;
    paramString = new b.a();
    paramString.c((a)new bdp());
    paramString.d((a)new bdq());
    paramString.oP(3700);
    paramString.Dl("/cgi-bin/micromsg-bin/getliveonlinestatebyroom");
    paramString.oR(0);
    paramString.oS(0);
    paramString = paramString.aDC();
    p.g(paramString, "builder.buildInstance()");
    this.gPp = paramString;
    paramString = this.gPp.aEE();
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineStateByRoomRequest");
      AppMethodBeat.o(212179);
      throw paramString;
    }
    this.gPB = ((bdp)paramString);
    paramString = this.gPB;
    if (paramString != null) {
      paramString.Fsa = this.gGy;
    }
    paramString = this.gPB;
    if (paramString != null)
    {
      paramString.Fsb = this.gME;
      AppMethodBeat.o(212179);
      return;
    }
    AppMethodBeat.o(212179);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(212177);
    ad.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
    AppMethodBeat.o(212177);
    return i;
  }
  
  public final int getType()
  {
    return 3700;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212178);
    ad.i(TAG, "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(212178);
      throw paramString;
    }
    paramq = ((b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineStateByRoomResponse");
      AppMethodBeat.o(212178);
      throw paramString;
    }
    this.gPC = ((bdq)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e(TAG, "onGYNetEnd error");
    }
    for (;;)
    {
      paramq = this.callback;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(212178);
      return;
      paramArrayOfByte = this.gPC;
      if (paramArrayOfByte != null)
      {
        paramq = g.gOr;
        if (g.ano().get(this.gME) == null)
        {
          paramq = g.gOr;
          ((Map)g.ano()).put(this.gME, new o(new ArrayList(), Integer.valueOf(0)));
        }
        paramq = g.gOr;
        paramq = (o)g.ano().get(this.gME);
        if (paramq != null) {}
        ArrayList localArrayList;
        for (paramq = (ArrayList)paramq.first;; paramq = null)
        {
          if (paramq != null) {
            paramq.clear();
          }
          localArrayList = new ArrayList();
          paramArrayOfByte = paramArrayOfByte.GAd;
          p.g(paramArrayOfByte, "it.user_online_state_list");
          paramArrayOfByte = ((Iterable)paramArrayOfByte).iterator();
          while (paramArrayOfByte.hasNext()) {
            localArrayList.add(((buz)paramArrayOfByte.next()).GOM);
          }
        }
        if (paramq != null) {
          paramq.addAll((Collection)localArrayList);
        }
        ad.i(TAG, "idList:".concat(String.valueOf(localArrayList)));
        paramq = g.gOr;
        g.ans().GzV = localArrayList.size();
      }
    }
    AppMethodBeat.o(212178);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineStateRoom$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.d
 * JD-Core Version:    0.7.0.1
 */