package com.tencent.mm.live.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.live.core.core.f.d;
import com.tencent.mm.live.core.core.f.d.a;
import com.tencent.mm.live.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.cmg;
import com.tencent.mm.protocal.protobuf.cmh;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "roomId", "", "isForCheck", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()Z", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveInfoRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveInfoResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getLiveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends p
  implements m
{
  public static final b.a nar;
  private h callback;
  private c nao;
  private final boolean nas;
  private cmg nat;
  private cmh nau;
  
  static
  {
    AppMethodBeat.i(246838);
    nar = new b.a((byte)0);
    AppMethodBeat.o(246838);
  }
  
  public b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(246824);
    this.nas = paramBoolean;
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((a)new cmg());
    ((c.a)localObject).otF = ((a)new cmh());
    ((c.a)localObject).funcId = 3806;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getliveinfo";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.nao = ((c)localObject);
    localObject = c.b.b(this.nao.otB);
    if (localObject == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveInfoRequest");
      AppMethodBeat.o(246824);
      throw paramString;
    }
    this.nat = ((cmg)localObject);
    this.nat.mMJ = paramLong;
    this.nat.YBL = paramString;
    Log.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "get live info liveId:" + paramLong + ", roomId:" + paramString);
    AppMethodBeat.o(246824);
  }
  
  public final dio bie()
  {
    cmh localcmh = this.nau;
    if (localcmh == null) {
      return null;
    }
    return localcmh.Zqe;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(246844);
    Log.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.nao, (m)this);
    AppMethodBeat.o(246844);
    return i;
  }
  
  public final int getType()
  {
    return 3806;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(246871);
    paramArrayOfByte = new StringBuilder("onGYNetEnd, errType:").append(paramInt2).append(", errCode:").append(paramInt3).append(", isForCheck:").append(this.nas).append(", LiveAnchorTRTCCore.hasInstance:");
    Object localObject1 = com.tencent.mm.live.core.core.a.b.mMo;
    paramArrayOfByte = paramArrayOfByte.append(com.tencent.mm.live.core.core.a.b.a.bek()).append(" LiveVisitorTRTCCore.hasInstance:");
    localObject1 = d.mUj;
    Log.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", d.a.bek());
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(246871);
      throw paramString;
    }
    params = c.c.b(((c)params).otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveInfoResponse");
      AppMethodBeat.o(246871);
      throw paramString;
    }
    this.nau = ((cmh)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "onGYNetEnd error");
    }
    for (;;)
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(246871);
      return;
      if (!this.nas)
      {
        params = d.mUj;
        if (!d.a.bek())
        {
          params = com.tencent.mm.live.core.core.a.b.mMo;
          if (!com.tencent.mm.live.core.core.a.b.a.bek()) {}
        }
        else
        {
          params = bie();
          if (params != null)
          {
            paramArrayOfByte = params.aaNl;
            localObject1 = (Collection)paramArrayOfByte;
            if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
            for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
            {
              kotlin.g.b.s.s(paramArrayOfByte, "roomList");
              localObject1 = ((Iterable)paramArrayOfByte).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                String str = (String)((Iterator)localObject1).next();
                paramInt1 = v.getMembersCountByChatRoomName(str);
                Object localObject2 = u.mZl;
                if (u.bib().get(str) == null)
                {
                  localObject2 = u.mZl;
                  localObject2 = (Map)u.bib();
                  kotlin.g.b.s.s(str, "it");
                  ((Map)localObject2).put(str, new r(new ArrayList(), Integer.valueOf(paramInt1)));
                }
              }
            }
            Log.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", kotlin.g.b.s.X("roomList:", paramArrayOfByte));
            paramArrayOfByte = u.mZl;
            u.a(params);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.model.a.b
 * JD-Core Version:    0.7.0.1
 */