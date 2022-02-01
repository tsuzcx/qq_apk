package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.live.b.x;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.protocal.protobuf.bpq;
import com.tencent.mm.protocal.protobuf.civ;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineByRoom;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "ignoreErr", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getIgnoreErr", "()Z", "getLiveId", "()J", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineByRoomRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineByRoomResponse;", "getWechatRoomId", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class c
  extends q
  implements m
{
  private static final String TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineByRoom";
  public static final a hJF;
  private i callback;
  private final String hFW;
  private bpp hJC;
  private bpq hJD;
  public final boolean hJE;
  private d hJu;
  private final long liveId;
  
  static
  {
    AppMethodBeat.i(207749);
    hJF = new a((byte)0);
    TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineByRoom";
    AppMethodBeat.o(207749);
  }
  
  public c(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(207748);
    this.liveId = paramLong;
    this.hFW = paramString;
    this.hJE = paramBoolean;
    paramString = new d.a();
    paramString.c((a)new bpp());
    paramString.d((a)new bpq());
    paramString.sG(3662);
    paramString.MB("/cgi-bin/micromsg-bin/getliveonlinebyroom");
    paramString.sI(0);
    paramString.sJ(0);
    paramString = paramString.aXF();
    p.g(paramString, "builder.buildInstance()");
    this.hJu = paramString;
    paramString = this.hJu.aYJ();
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineByRoomRequest");
      AppMethodBeat.o(207748);
      throw paramString;
    }
    this.hJC = ((bpp)paramString);
    paramString = this.hJC;
    if (paramString != null) {
      paramString.hyH = this.liveId;
    }
    paramString = this.hJC;
    if (paramString != null)
    {
      paramString.KDQ = this.hFW;
      AppMethodBeat.o(207748);
      return;
    }
    AppMethodBeat.o(207748);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(207747);
    Log.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(207747);
    return i;
  }
  
  public final int getType()
  {
    return 3662;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207746);
    Log.i(TAG, "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(207746);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineByRoomResponse");
      AppMethodBeat.o(207746);
      throw paramString;
    }
    this.hJD = ((bpq)params);
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
      AppMethodBeat.o(207746);
      return;
      paramArrayOfByte = this.hJD;
    } while (paramArrayOfByte == null);
    params = x.hJf;
    if (x.aGo().get(this.hFW) == null)
    {
      params = x.hJf;
      ((Map)x.aGo()).put(this.hFW, new o(new ArrayList(), Integer.valueOf(0)));
    }
    params = x.hJf;
    params = (o)x.aGo().get(this.hFW);
    Object localObject2;
    if (params != null)
    {
      params = (ArrayList)params.first;
      if (params != null) {
        params.clear();
      }
      if (params != null)
      {
        localObject1 = paramArrayOfByte.LXK;
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
        x localx = x.hJf;
        if (!Util.isEqual(x.aGt(), str)) {}
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
    Object localObject1 = x.hJf;
    localObject1 = x.aGr();
    if (params != null) {}
    for (paramInt1 = params.size();; paramInt1 = 0)
    {
      ((civ)localObject1).LIa = paramInt1;
      Log.i(TAG, "it.identity_id_list:" + paramArrayOfByte.LXK);
      break;
    }
    AppMethodBeat.o(207746);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineByRoom$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.c
 * JD-Core Version:    0.7.0.1
 */