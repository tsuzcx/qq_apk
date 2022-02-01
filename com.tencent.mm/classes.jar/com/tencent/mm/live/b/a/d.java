package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.live.b.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.eai;
import com.tencent.mm.protocal.protobuf.eaj;
import com.tencent.mm.protocal.protobuf.eaz;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.o;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineStateRoom;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "(JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLiveId", "()J", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineStateByRoomRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineStateByRoomResponse;", "getWechatRoomId", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class d
  extends n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineStateRoom";
  public static final a zbg;
  private final long DlB;
  private g callback;
  private b iaa;
  private final String qVO;
  private eai zbe;
  private eaj zbf;
  
  static
  {
    AppMethodBeat.i(202703);
    zbg = new a((byte)0);
    TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineStateRoom";
    AppMethodBeat.o(202703);
  }
  
  public d(long paramLong, String paramString)
  {
    AppMethodBeat.i(202702);
    this.DlB = paramLong;
    this.qVO = paramString;
    paramString = new b.a();
    paramString.c((a)new eai());
    paramString.d((a)new eaj());
    paramString.nB(3700);
    paramString.wg("/cgi-bin/micromsg-bin/getliveonlinestatebyroom");
    paramString.nD(0);
    paramString.nE(0);
    paramString = paramString.atI();
    d.g.b.k.g(paramString, "builder.buildInstance()");
    this.iaa = paramString;
    paramString = this.iaa.auL();
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineStateByRoomRequest");
      AppMethodBeat.o(202702);
      throw paramString;
    }
    this.zbe = ((eai)paramString);
    paramString = this.zbe;
    if (paramString != null) {
      paramString.LwA = this.DlB;
    }
    paramString = this.zbe;
    if (paramString != null)
    {
      paramString.EEF = this.qVO;
      AppMethodBeat.o(202702);
      return;
    }
    AppMethodBeat.o(202702);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(202700);
    ad.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.iaa, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(202700);
    return i;
  }
  
  public final int getType()
  {
    return 3700;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(202701);
    ad.i(TAG, "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(202701);
      throw paramString;
    }
    paramq = ((b)paramq).auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineStateByRoomResponse");
      AppMethodBeat.o(202701);
      throw paramString;
    }
    this.zbf = ((eaj)paramq);
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
      AppMethodBeat.o(202701);
      return;
      paramArrayOfByte = this.zbf;
      if (paramArrayOfByte != null)
      {
        paramq = f.rGw;
        if (f.eND().get(this.qVO) == null)
        {
          paramq = f.rGw;
          ((Map)f.eND()).put(this.qVO, new o(new ArrayList(), Integer.valueOf(0)));
        }
        paramq = f.rGw;
        paramq = (o)f.eND().get(this.qVO);
        if (paramq != null) {}
        ArrayList localArrayList;
        for (paramq = (ArrayList)paramq.first;; paramq = null)
        {
          if (paramq != null) {
            paramq.clear();
          }
          localArrayList = new ArrayList();
          paramArrayOfByte = paramArrayOfByte.LyV;
          d.g.b.k.g(paramArrayOfByte, "it.user_online_state_list");
          paramArrayOfByte = ((Iterable)paramArrayOfByte).iterator();
          while (paramArrayOfByte.hasNext()) {
            localArrayList.add(((eaz)paramArrayOfByte.next()).Lzi);
          }
        }
        if (paramq != null) {
          paramq.addAll((Collection)localArrayList);
        }
        ad.i(TAG, "idList:".concat(String.valueOf(localArrayList)));
      }
    }
    AppMethodBeat.o(202701);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineStateRoom$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.a.d
 * JD-Core Version:    0.7.0.1
 */