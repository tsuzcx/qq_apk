package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azh;
import com.tencent.mm.protocal.protobuf.azi;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.l;
import d.o;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineByRoom;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "ignoreErr", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getIgnoreErr", "()Z", "getLiveId", "()J", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineByRoomRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineByRoomResponse;", "getWechatRoomId", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class c
  extends n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineByRoom";
  public static final c.a gvP;
  private com.tencent.mm.ak.g callback;
  private final long gmP;
  private final String gsT;
  private b gvE;
  private azh gvM;
  private azi gvN;
  public final boolean gvO;
  
  static
  {
    AppMethodBeat.i(189890);
    gvP = new c.a((byte)0);
    TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineByRoom";
    AppMethodBeat.o(189890);
  }
  
  public c(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(189889);
    this.gmP = paramLong;
    this.gsT = paramString;
    this.gvO = paramBoolean;
    paramString = new b.a();
    paramString.c((a)new azh());
    paramString.d((a)new azi());
    paramString.op(3662);
    paramString.Am("/cgi-bin/micromsg-bin/getliveonlinebyroom");
    paramString.or(0);
    paramString.os(0);
    paramString = paramString.aAz();
    d.g.b.k.g(paramString, "builder.buildInstance()");
    this.gvE = paramString;
    paramString = this.gvE.aBC();
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineByRoomRequest");
      AppMethodBeat.o(189889);
      throw paramString;
    }
    this.gvM = ((azh)paramString);
    paramString = this.gvM;
    if (paramString != null) {
      paramString.DMV = this.gmP;
    }
    paramString = this.gvM;
    if (paramString != null)
    {
      paramString.DMW = this.gsT;
      AppMethodBeat.o(189889);
      return;
    }
    AppMethodBeat.o(189889);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(189888);
    ac.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.gvE, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(189888);
    return i;
  }
  
  public final int getType()
  {
    return 3662;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189887);
    ac.i(TAG, "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(189887);
      throw paramString;
    }
    paramq = ((b)paramq).aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineByRoomResponse");
      AppMethodBeat.o(189887);
      throw paramString;
    }
    this.gvN = ((azi)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ac.e("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "onGYNetEnd error");
    }
    do
    {
      paramq = this.callback;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(189887);
      return;
      paramArrayOfByte = this.gvN;
    } while (paramArrayOfByte == null);
    paramq = com.tencent.mm.live.b.g.guG;
    if (com.tencent.mm.live.b.g.akC().get(this.gsT) == null)
    {
      paramq = com.tencent.mm.live.b.g.guG;
      ((Map)com.tencent.mm.live.b.g.akC()).put(this.gsT, new o(new ArrayList(), Integer.valueOf(0)));
    }
    paramq = com.tencent.mm.live.b.g.guG;
    paramq = (o)com.tencent.mm.live.b.g.akC().get(this.gsT);
    Object localObject2;
    if (paramq != null)
    {
      paramq = (ArrayList)paramq.first;
      if (paramq != null) {
        paramq.clear();
      }
      if (paramq != null)
      {
        localObject1 = paramArrayOfByte.EQK;
        d.g.b.k.g(localObject1, "it.identity_id_list");
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
        com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.guG;
        if (!bs.lr(com.tencent.mm.live.b.g.akH(), str)) {}
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
    Object localObject1 = com.tencent.mm.live.b.g.guG;
    localObject1 = com.tencent.mm.live.b.g.akF();
    if (paramq != null) {}
    for (paramInt1 = paramq.size();; paramInt1 = 0)
    {
      ((bqd)localObject1).EQE = paramInt1;
      ac.i(TAG, "it.identity_id_list:" + paramArrayOfByte.EQK);
      break;
    }
    AppMethodBeat.o(189887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.a.c
 * JD-Core Version:    0.7.0.1
 */