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
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import d.o;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineByRoom;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "(JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLiveId", "()J", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineByRoomRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineByRoomResponse;", "getWechatRoomId", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class c
  extends n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineByRoom";
  public static final a zbd;
  private final long DlB;
  private g callback;
  private b iaa;
  private final String qVO;
  private eae zbb;
  private eaf zbc;
  
  static
  {
    AppMethodBeat.i(202699);
    zbd = new a((byte)0);
    TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineByRoom";
    AppMethodBeat.o(202699);
  }
  
  public c(long paramLong, String paramString)
  {
    AppMethodBeat.i(202698);
    this.DlB = paramLong;
    this.qVO = paramString;
    paramString = new b.a();
    paramString.c((a)new eae());
    paramString.d((a)new eaf());
    paramString.nB(3662);
    paramString.wg("/cgi-bin/micromsg-bin/getliveonlinebyroom");
    paramString.nD(0);
    paramString.nE(0);
    paramString = paramString.atI();
    d.g.b.k.g(paramString, "builder.buildInstance()");
    this.iaa = paramString;
    paramString = this.iaa.auL();
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineByRoomRequest");
      AppMethodBeat.o(202698);
      throw paramString;
    }
    this.zbb = ((eae)paramString);
    paramString = this.zbb;
    if (paramString != null) {
      paramString.LwA = this.DlB;
    }
    paramString = this.zbb;
    if (paramString != null)
    {
      paramString.EEF = this.qVO;
      AppMethodBeat.o(202698);
      return;
    }
    AppMethodBeat.o(202698);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(202697);
    ad.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.iaa, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(202697);
    return i;
  }
  
  public final int getType()
  {
    return 3662;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(202696);
    ad.i(TAG, "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(202696);
      throw paramString;
    }
    paramq = ((b)paramq).auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineByRoomResponse");
      AppMethodBeat.o(202696);
      throw paramString;
    }
    this.zbc = ((eaf)paramq);
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
      AppMethodBeat.o(202696);
      return;
      paramArrayOfByte = this.zbc;
    } while (paramArrayOfByte == null);
    paramq = f.rGw;
    if (f.eND().get(this.qVO) == null)
    {
      paramq = f.rGw;
      ((Map)f.eND()).put(this.qVO, new o(new ArrayList(), Integer.valueOf(0)));
    }
    paramq = f.rGw;
    paramq = (o)f.eND().get(this.qVO);
    Object localObject2;
    if (paramq != null)
    {
      paramq = (ArrayList)paramq.first;
      if (paramq != null) {
        paramq.clear();
      }
      if (paramq != null)
      {
        localObject1 = paramArrayOfByte.LyT;
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
        f localf = f.rGw;
        if (!bt.kU(f.eNI(), str)) {}
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
    Object localObject1 = f.rGw;
    localObject1 = f.eNG();
    if (paramq != null) {}
    for (paramInt1 = paramq.size();; paramInt1 = 0)
    {
      ((eas)localObject1).LyP = paramInt1;
      ad.i(TAG, "it.identity_id_list:" + paramArrayOfByte.LyT);
      break;
    }
    AppMethodBeat.o(202696);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineByRoom$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.a.c
 * JD-Core Version:    0.7.0.1
 */