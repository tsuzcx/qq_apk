package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.live.b.u;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bxj;
import com.tencent.mm.protocal.protobuf.bxk;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineByRoom;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "ignoreErr", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getIgnoreErr", "()Z", "getLiveId", "()J", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineByRoomRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineByRoomResponse;", "getWechatRoomId", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class c
  extends q
  implements m
{
  private static final String TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineByRoom";
  public static final a kwZ;
  private i callback;
  public final String ktU;
  private d kwO;
  private bxj kwW;
  private bxk kwX;
  public final boolean kwY;
  private final long liveId;
  
  static
  {
    AppMethodBeat.i(194193);
    kwZ = new a((byte)0);
    TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineByRoom";
    AppMethodBeat.o(194193);
  }
  
  public c(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(194190);
    this.liveId = paramLong;
    this.ktU = paramString;
    this.kwY = paramBoolean;
    paramString = new d.a();
    paramString.c((a)new bxj());
    paramString.d((a)new bxk());
    paramString.vD(3662);
    paramString.TW("/cgi-bin/micromsg-bin/getliveonlinebyroom");
    paramString.vF(0);
    paramString.vG(0);
    paramString = paramString.bgN();
    p.j(paramString, "builder.buildInstance()");
    this.kwO = paramString;
    paramString = this.kwO.bhX();
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineByRoomRequest");
      AppMethodBeat.o(194190);
      throw paramString;
    }
    this.kwW = ((bxj)paramString);
    paramString = this.kwW;
    if (paramString != null) {
      paramString.klE = this.liveId;
    }
    paramString = this.kwW;
    if (paramString != null)
    {
      paramString.RFj = this.ktU;
      AppMethodBeat.o(194190);
      return;
    }
    AppMethodBeat.o(194190);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(194189);
    Log.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.kwO, (m)this);
    AppMethodBeat.o(194189);
    return i;
  }
  
  public final int getType()
  {
    return 3662;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(194188);
    Log.i(TAG, "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(194188);
      throw paramString;
    }
    params = ((d)params).bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineByRoomResponse");
      AppMethodBeat.o(194188);
      throw paramString;
    }
    this.kwX = ((bxk)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "onGYNetEnd error");
    }
    do
    {
      params = this.callback;
      if (params == null) {
        break;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(194188);
      return;
      paramArrayOfByte = this.kwX;
    } while (paramArrayOfByte == null);
    params = u.kwz;
    if (u.aOo().get(this.ktU) == null)
    {
      params = u.kwz;
      ((Map)u.aOo()).put(this.ktU, new o(new ArrayList(), Integer.valueOf(0)));
    }
    params = u.kwz;
    params = (o)u.aOo().get(this.ktU);
    Object localObject2;
    if (params != null)
    {
      params = (ArrayList)params.Mx;
      if (params != null) {
        params.clear();
      }
      if (params != null)
      {
        localObject1 = paramArrayOfByte.Thb;
        p.j(localObject1, "it.identity_id_list");
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
        u localu = u.kwz;
        if (!Util.isEqual(u.aOt(), str)) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label376;
          }
          ((Collection)localObject1).add(localObject3);
          break label306;
          params = null;
          break;
        }
      }
      label378:
      params.addAll((Collection)localObject1);
    }
    Object localObject1 = u.kwz;
    localObject1 = u.aOr();
    if (params != null) {}
    for (paramInt1 = params.size();; paramInt1 = 0)
    {
      ((crq)localObject1).SOs = paramInt1;
      Log.i(TAG, "it.identity_id_list:" + paramArrayOfByte.Thb);
      break;
    }
    AppMethodBeat.o(194188);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineByRoom$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.c
 * JD-Core Version:    0.7.0.1
 */