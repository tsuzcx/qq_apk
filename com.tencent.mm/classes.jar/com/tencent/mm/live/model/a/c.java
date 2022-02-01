package com.tencent.mm.live.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.live.model.u;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.protocal.protobuf.cmn;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineByRoom;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "ignoreErr", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getIgnoreErr", "()Z", "getLiveId", "()J", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineByRoomRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineByRoomResponse;", "getWechatRoomId", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends p
  implements m
{
  private static final String TAG;
  public static final a nav;
  private h callback;
  private final long liveId;
  public final String mXO;
  private com.tencent.mm.am.c nao;
  public final boolean naw;
  private cmm nax;
  private cmn nay;
  
  static
  {
    AppMethodBeat.i(246830);
    nav = new a((byte)0);
    TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineByRoom";
    AppMethodBeat.o(246830);
  }
  
  public c(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(246823);
    this.liveId = paramLong;
    this.mXO = paramString;
    this.naw = paramBoolean;
    paramString = new com.tencent.mm.am.c.a();
    paramString.otE = ((a)new cmm());
    paramString.otF = ((a)new cmn());
    paramString.funcId = 3662;
    paramString.uri = "/cgi-bin/micromsg-bin/getliveonlinebyroom";
    paramString.otG = 0;
    paramString.respCmdId = 0;
    paramString = paramString.bEF();
    kotlin.g.b.s.s(paramString, "builder.buildInstance()");
    this.nao = paramString;
    paramString = c.b.b(this.nao.otB);
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineByRoomRequest");
      AppMethodBeat.o(246823);
      throw paramString;
    }
    this.nax = ((cmm)paramString);
    paramString = this.nax;
    if (paramString != null) {
      paramString.mMJ = this.liveId;
    }
    paramString = this.nax;
    if (paramString != null) {
      paramString.YBL = this.mXO;
    }
    AppMethodBeat.o(246823);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(246863);
    Log.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.nao, (m)this);
    AppMethodBeat.o(246863);
    return i;
  }
  
  public final int getType()
  {
    return 3662;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(246845);
    Log.i(TAG, "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(246845);
      throw paramString;
    }
    params = c.c.b(((com.tencent.mm.am.c)params).otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineByRoomResponse");
      AppMethodBeat.o(246845);
      throw paramString;
    }
    this.nay = ((cmn)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "onGYNetEnd error");
    }
    do
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(246845);
      return;
      paramArrayOfByte = this.nay;
    } while (paramArrayOfByte == null);
    params = u.mZl;
    if (u.bib().get(this.mXO) == null)
    {
      params = u.mZl;
      ((Map)u.bib()).put(this.mXO, new r(new ArrayList(), Integer.valueOf(0)));
    }
    params = u.mZl;
    params = (r)u.bib().get(this.mXO);
    Object localObject2;
    if (params == null)
    {
      params = null;
      if (params != null) {
        params.clear();
      }
      if (params != null)
      {
        localObject1 = paramArrayOfByte.aaur;
        kotlin.g.b.s.s(localObject1, "it.identity_id_list");
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
      }
    }
    else
    {
      label302:
      label379:
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label381;
        }
        Object localObject3 = ((Iterator)localObject2).next();
        String str = (String)localObject3;
        u localu = u.mZl;
        if (!Util.isEqual(u.big(), str)) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label379;
          }
          ((Collection)localObject1).add(localObject3);
          break label302;
          params = (ArrayList)params.bsC;
          break;
        }
      }
      label381:
      params.addAll((Collection)localObject1);
    }
    Object localObject1 = u.mZl;
    localObject1 = u.bie();
    if (params == null) {}
    for (paramInt1 = 0;; paramInt1 = params.size())
    {
      ((dio)localObject1).ZWw = paramInt1;
      Log.i(TAG, kotlin.g.b.s.X("it.identity_id_list:", paramArrayOfByte.aaur));
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineByRoom$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.model.a.c
 * JD-Core Version:    0.7.0.1
 */