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
import com.tencent.mm.protocal.protobuf.bdl;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.o;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineByRoom;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "ignoreErr", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getIgnoreErr", "()Z", "getLiveId", "()J", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineByRoomRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineByRoomResponse;", "getWechatRoomId", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class c
  extends n
  implements k
{
  private static final String TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineByRoom";
  public static final a gPA;
  private f callback;
  private final long gGy;
  private final String gME;
  private b gPp;
  private bdl gPx;
  private bdm gPy;
  public final boolean gPz;
  
  static
  {
    AppMethodBeat.i(212176);
    gPA = new a((byte)0);
    TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineByRoom";
    AppMethodBeat.o(212176);
  }
  
  public c(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(212175);
    this.gGy = paramLong;
    this.gME = paramString;
    this.gPz = paramBoolean;
    paramString = new b.a();
    paramString.c((a)new bdl());
    paramString.d((a)new bdm());
    paramString.oP(3662);
    paramString.Dl("/cgi-bin/micromsg-bin/getliveonlinebyroom");
    paramString.oR(0);
    paramString.oS(0);
    paramString = paramString.aDC();
    p.g(paramString, "builder.buildInstance()");
    this.gPp = paramString;
    paramString = this.gPp.aEE();
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineByRoomRequest");
      AppMethodBeat.o(212175);
      throw paramString;
    }
    this.gPx = ((bdl)paramString);
    paramString = this.gPx;
    if (paramString != null) {
      paramString.Fsa = this.gGy;
    }
    paramString = this.gPx;
    if (paramString != null)
    {
      paramString.Fsb = this.gME;
      AppMethodBeat.o(212175);
      return;
    }
    AppMethodBeat.o(212175);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(212174);
    ad.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
    AppMethodBeat.o(212174);
    return i;
  }
  
  public final int getType()
  {
    return 3662;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212173);
    ad.i(TAG, "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(212173);
      throw paramString;
    }
    paramq = ((b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineByRoomResponse");
      AppMethodBeat.o(212173);
      throw paramString;
    }
    this.gPy = ((bdm)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "onGYNetEnd error");
    }
    do
    {
      paramq = this.callback;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(212173);
      return;
      paramArrayOfByte = this.gPy;
    } while (paramArrayOfByte == null);
    paramq = g.gOr;
    if (g.ano().get(this.gME) == null)
    {
      paramq = g.gOr;
      ((Map)g.ano()).put(this.gME, new o(new ArrayList(), Integer.valueOf(0)));
    }
    paramq = g.gOr;
    paramq = (o)g.ano().get(this.gME);
    Object localObject2;
    if (paramq != null)
    {
      paramq = (ArrayList)paramq.first;
      if (paramq != null) {
        paramq.clear();
      }
      if (paramq != null)
      {
        localObject1 = paramArrayOfByte.GAb;
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
        g localg = g.gOr;
        if (!bt.lQ(g.anu(), str)) {}
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
    Object localObject1 = g.gOr;
    localObject1 = g.ans();
    if (paramq != null) {}
    for (paramInt1 = paramq.size();; paramInt1 = 0)
    {
      ((buq)localObject1).GzV = paramInt1;
      ad.i(TAG, "it.identity_id_list:" + paramArrayOfByte.GAb);
      break;
    }
    AppMethodBeat.o(212173);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineByRoom$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.c
 * JD-Core Version:    0.7.0.1
 */