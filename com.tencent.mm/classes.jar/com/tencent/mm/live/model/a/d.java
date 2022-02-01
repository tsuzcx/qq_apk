package com.tencent.mm.live.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.live.model.u;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.cmq;
import com.tencent.mm.protocal.protobuf.cmr;
import com.tencent.mm.protocal.protobuf.dja;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineStateRoom;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "(JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLiveId", "()J", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineStateByRoomRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineStateByRoomResponse;", "getWechatRoomId", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends p
  implements m
{
  private static final String TAG;
  public static final a naz;
  private h callback;
  private final long liveId;
  private final String mXO;
  private cmq naA;
  private cmr naB;
  private c nao;
  
  static
  {
    AppMethodBeat.i(246847);
    naz = new a((byte)0);
    TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineStateRoom";
    AppMethodBeat.o(246847);
  }
  
  public d(long paramLong, String paramString)
  {
    AppMethodBeat.i(246839);
    this.liveId = paramLong;
    this.mXO = paramString;
    paramString = new c.a();
    paramString.otE = ((a)new cmq());
    paramString.otF = ((a)new cmr());
    paramString.funcId = 3700;
    paramString.uri = "/cgi-bin/micromsg-bin/getliveonlinestatebyroom";
    paramString.otG = 0;
    paramString.respCmdId = 0;
    paramString = paramString.bEF();
    kotlin.g.b.s.s(paramString, "builder.buildInstance()");
    this.nao = paramString;
    paramString = c.b.b(this.nao.otB);
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineStateByRoomRequest");
      AppMethodBeat.o(246839);
      throw paramString;
    }
    this.naA = ((cmq)paramString);
    paramString = this.naA;
    if (paramString != null) {
      paramString.mMJ = this.liveId;
    }
    paramString = this.naA;
    if (paramString != null) {
      paramString.YBL = this.mXO;
    }
    AppMethodBeat.o(246839);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(246865);
    Log.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.nao, (m)this);
    AppMethodBeat.o(246865);
    return i;
  }
  
  public final int getType()
  {
    return 3700;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(246876);
    Log.i(TAG, "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(246876);
      throw paramString;
    }
    params = c.c.b(((c)params).otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineStateByRoomResponse");
      AppMethodBeat.o(246876);
      throw paramString;
    }
    this.naB = ((cmr)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e(TAG, "onGYNetEnd error");
    }
    for (;;)
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(246876);
      return;
      paramArrayOfByte = this.naB;
      if (paramArrayOfByte != null)
      {
        params = u.mZl;
        if (u.bib().get(this.mXO) == null)
        {
          params = u.mZl;
          ((Map)u.bib()).put(this.mXO, new r(new ArrayList(), Integer.valueOf(0)));
        }
        params = u.mZl;
        params = (r)u.bib().get(this.mXO);
        if (params == null) {}
        ArrayList localArrayList;
        for (params = null;; params = (ArrayList)params.bsC)
        {
          if (params != null) {
            params.clear();
          }
          localArrayList = new ArrayList();
          paramArrayOfByte = paramArrayOfByte.aaut;
          kotlin.g.b.s.s(paramArrayOfByte, "it.user_online_state_list");
          paramArrayOfByte = ((Iterable)paramArrayOfByte).iterator();
          while (paramArrayOfByte.hasNext()) {
            localArrayList.add(((dja)paramArrayOfByte.next()).aaNt);
          }
        }
        if (params != null) {
          params.addAll((Collection)localArrayList);
        }
        Log.i(TAG, kotlin.g.b.s.X("idList:", localArrayList));
        params = u.mZl;
        u.bie().ZWw = localArrayList.size();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineStateRoom$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.model.a.d
 * JD-Core Version:    0.7.0.1
 */