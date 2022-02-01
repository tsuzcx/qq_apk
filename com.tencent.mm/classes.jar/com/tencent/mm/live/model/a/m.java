package com.tencent.mm.live.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.live.model.j;
import com.tencent.mm.live.model.k;
import com.tencent.mm.live.model.o;
import com.tencent.mm.live.model.u;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.protocal.protobuf.cmi;
import com.tencent.mm.protocal.protobuf.cmj;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetLiveMessage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "offline", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "duration", "getDuration", "()J", "setDuration", "(J)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveMessageRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveMessageResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends p
  implements com.tencent.mm.network.m
{
  public static final a nba;
  private h callback;
  public long duration;
  private c nao;
  private final cmi nbb;
  private cmj nbc;
  
  static
  {
    AppMethodBeat.i(246898);
    nba = new a((byte)0);
    AppMethodBeat.o(246898);
  }
  
  public m(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(246886);
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((a)new cmi());
    ((c.a)localObject).otF = ((a)new cmj());
    ((c.a)localObject).funcId = 3767;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getlivemessage";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    ((c.a)localObject).longPolling = true;
    ((c.a)localObject).longPollingTimeout = 25000;
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.nao = ((c)localObject);
    localObject = c.b.b(this.nao.otB);
    if (localObject == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMessageRequest");
      AppMethodBeat.o(246886);
      throw paramString;
    }
    this.nbb = ((cmi)localObject);
    this.nbb.mMJ = paramLong;
    this.nbb.YBL = paramString;
    localObject = this.nbb;
    u localu = u.mZl;
    ((cmi)localObject).YJa = com.tencent.mm.bx.b.cX(u.bid());
    this.nbb.LXS = paramBoolean;
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "get live message:" + paramLong + " wechatRoomId:" + paramString + " offline:" + paramBoolean);
    AppMethodBeat.o(246886);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(246906);
    this.duration = System.currentTimeMillis();
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.nao, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(246906);
    return i;
  }
  
  public final int getType()
  {
    return 3767;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = null;
    AppMethodBeat.i(246925);
    kotlin.g.b.s.u(params, "rr");
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.duration = (System.currentTimeMillis() - this.duration);
    Object localObject1 = k.mYa;
    if (k.en(paramInt2, paramInt3))
    {
      o.a(o.mZb);
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
        AppMethodBeat.o(246925);
      }
    }
    else
    {
      params = c.c.b(((c)params).otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMessageResponse");
        AppMethodBeat.o(246925);
        throw paramString;
      }
      this.nbc = ((cmj)params);
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label213;
      }
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "onGYNetEnd error");
      if (paramInt3 == -100056)
      {
        params = j.mXT;
        j.bhg();
      }
    }
    for (;;)
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(246925);
      return;
      label213:
      localObject1 = this.nbc;
      if (localObject1 == null) {
        continue;
      }
      Object localObject2;
      if (((cmj)localObject1).aauo)
      {
        params = u.mZl;
        if (u.bie().ZWw != ((cmj)localObject1).ZWw)
        {
          params = j.mXT;
          j.bhh();
        }
        params = u.mZl;
        u.bie().ZWw = ((cmj)localObject1).ZWw;
        params = u.mZl;
        params = u.bie();
        localObject2 = u.mZl;
        params.aaun = Math.max(u.bie().aaun, ((cmj)localObject1).aaun);
        params = u.mZl;
        u.bia().clear();
        params = u.mZl;
        localObject2 = u.bia();
        params = ((cmj)localObject1).aaum;
        if (params != null) {
          break label654;
        }
        params = (Collection)new ArrayList();
        label354:
        ((ArrayList)localObject2).addAll(params);
        params = u.mZl;
        u.a(new dih());
        params = u.mZl;
        localObject2 = (a)u.bik();
        params = ((cmj)localObject1).aaup;
        if (params != null) {
          break label664;
        }
        params = null;
      }
      try
      {
        for (;;)
        {
          ((a)localObject2).parseFrom(params);
          params = com.tencent.mm.live.model.d.b.nbZ;
          params = u.mZl;
          localObject2 = u.bic();
          params = ((cmj)localObject1).aaul;
          if (params != null) {
            break label715;
          }
          params = (List)new ArrayList();
          String str = z.bAM();
          kotlin.g.b.s.s(str, "getUsernameFromUserInfo()");
          com.tencent.mm.live.model.d.b.a((ArrayList)localObject2, params, str);
          params = j.mXT;
          j.bhf();
          params = u.mZl;
          u.am(((cmj)localObject1).YJa.Op);
          params = new StringBuilder("onlineCount:");
          localObject2 = u.mZl;
          params = params.append(u.bie().ZWw).append(" headerList:");
          localObject2 = u.mZl;
          localObject2 = params.append(u.bia().size()).append(" remoteMsgSize:");
          params = ((cmj)localObject1).aaul;
          if (params != null) {
            break label725;
          }
          params = paramArrayOfByte;
          params = ((StringBuilder)localObject2).append(params).append(", msgSize:");
          paramArrayOfByte = u.mZl;
          params = params.append(u.bic().size()).append(" likeCount:");
          paramArrayOfByte = u.mZl;
          Log.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", u.bie().aaun + ", needUpdate:" + ((cmj)localObject1).aauo);
          break;
          label654:
          params = (Collection)params;
          break label354;
          label664:
          params = params.aacO;
          if (params == null) {
            params = null;
          } else {
            params = params.Op;
          }
        }
      }
      catch (Exception params)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { params });
          continue;
          label715:
          params = (List)params;
          continue;
          label725:
          params = Integer.valueOf(params.size());
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetLiveMessage$Companion;", "", "()V", "TAG", "", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.model.a.m
 * JD-Core Version:    0.7.0.1
 */