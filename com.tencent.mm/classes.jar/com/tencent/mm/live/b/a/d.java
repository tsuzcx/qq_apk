package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azl;
import com.tencent.mm.protocal.protobuf.azm;
import com.tencent.mm.protocal.protobuf.bqm;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.o;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineStateRoom;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "(JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLiveId", "()J", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineStateByRoomRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineStateByRoomResponse;", "getWechatRoomId", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class d
  extends n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineStateRoom";
  public static final d.a gvS;
  private com.tencent.mm.ak.g callback;
  private final long gmP;
  private final String gsT;
  private b gvE;
  private azl gvQ;
  private azm gvR;
  
  static
  {
    AppMethodBeat.i(189894);
    gvS = new d.a((byte)0);
    TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineStateRoom";
    AppMethodBeat.o(189894);
  }
  
  public d(long paramLong, String paramString)
  {
    AppMethodBeat.i(189893);
    this.gmP = paramLong;
    this.gsT = paramString;
    paramString = new b.a();
    paramString.c((a)new azl());
    paramString.d((a)new azm());
    paramString.op(3700);
    paramString.Am("/cgi-bin/micromsg-bin/getliveonlinestatebyroom");
    paramString.or(0);
    paramString.os(0);
    paramString = paramString.aAz();
    d.g.b.k.g(paramString, "builder.buildInstance()");
    this.gvE = paramString;
    paramString = this.gvE.aBC();
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineStateByRoomRequest");
      AppMethodBeat.o(189893);
      throw paramString;
    }
    this.gvQ = ((azl)paramString);
    paramString = this.gvQ;
    if (paramString != null) {
      paramString.DMV = this.gmP;
    }
    paramString = this.gvQ;
    if (paramString != null)
    {
      paramString.DMW = this.gsT;
      AppMethodBeat.o(189893);
      return;
    }
    AppMethodBeat.o(189893);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(189891);
    ac.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.gvE, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(189891);
    return i;
  }
  
  public final int getType()
  {
    return 3700;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189892);
    ac.i(TAG, "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(189892);
      throw paramString;
    }
    paramq = ((b)paramq).aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineStateByRoomResponse");
      AppMethodBeat.o(189892);
      throw paramString;
    }
    this.gvR = ((azm)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ac.e(TAG, "onGYNetEnd error");
    }
    for (;;)
    {
      paramq = this.callback;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(189892);
      return;
      paramArrayOfByte = this.gvR;
      if (paramArrayOfByte != null)
      {
        paramq = com.tencent.mm.live.b.g.guG;
        if (com.tencent.mm.live.b.g.akC().get(this.gsT) == null)
        {
          paramq = com.tencent.mm.live.b.g.guG;
          ((Map)com.tencent.mm.live.b.g.akC()).put(this.gsT, new o(new ArrayList(), Integer.valueOf(0)));
        }
        paramq = com.tencent.mm.live.b.g.guG;
        paramq = (o)com.tencent.mm.live.b.g.akC().get(this.gsT);
        if (paramq != null) {}
        ArrayList localArrayList;
        for (paramq = (ArrayList)paramq.first;; paramq = null)
        {
          if (paramq != null) {
            paramq.clear();
          }
          localArrayList = new ArrayList();
          paramArrayOfByte = paramArrayOfByte.EQM;
          d.g.b.k.g(paramArrayOfByte, "it.user_online_state_list");
          paramArrayOfByte = ((Iterable)paramArrayOfByte).iterator();
          while (paramArrayOfByte.hasNext()) {
            localArrayList.add(((bqm)paramArrayOfByte.next()).Ffi);
          }
        }
        if (paramq != null) {
          paramq.addAll((Collection)localArrayList);
        }
        ac.i(TAG, "idList:".concat(String.valueOf(localArrayList)));
        paramq = com.tencent.mm.live.b.g.guG;
        com.tencent.mm.live.b.g.akF().EQE = localArrayList.size();
      }
    }
    AppMethodBeat.o(189892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.a.d
 * JD-Core Version:    0.7.0.1
 */