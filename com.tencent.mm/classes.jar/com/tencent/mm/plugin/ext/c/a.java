package com.tencent.mm.plugin.ext.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.cun;
import com.tencent.mm.protocal.protobuf.cuo;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ext/net/NetSceneGetUserAuth;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "appid", "", "packageName", "signature", "mIOnNetSceneEnd", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "mCallback", "<set-?>", "Lcom/tencent/mm/protocal/protobuf/GetUserAuthResp;", "resp", "getResp", "()Lcom/tencent/mm/protocal/protobuf/GetUserAuthResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends p
  implements m
{
  private final String appid;
  private h mAY;
  private final String packageName;
  private final String signature;
  private final h zOF;
  public cuo zOG;
  
  public a(String paramString1, String paramString2, String paramString3, h paramh)
  {
    AppMethodBeat.i(39602);
    this.appid = paramString1;
    this.packageName = paramString2;
    this.signature = paramString3;
    this.zOF = paramh;
    AppMethodBeat.o(39602);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(39601);
    this.mAY = paramh;
    paramh = new c.a();
    cun localcun = new cun();
    localcun.appid = this.appid;
    localcun.xlr = this.packageName;
    localcun.signature = this.signature;
    paramh.otE = ((com.tencent.mm.bx.a)localcun);
    this.zOG = new cuo();
    paramh.otF = ((com.tencent.mm.bx.a)this.zOG);
    paramh.uri = "/cgi-bin/mmbiz-bin/getuserauth";
    paramh.funcId = getType();
    paramh.otG = 0;
    paramh.respCmdId = 0;
    paramh = paramh.bEF();
    kotlin.g.b.s.s(paramh, "builder.buildInstance()");
    int i = dispatch(paramg, (com.tencent.mm.network.s)paramh, (m)this);
    AppMethodBeat.o(39601);
    return i;
  }
  
  public final int getType()
  {
    return 2711;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(39600);
    params = this.zOF;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    params = this.mAY;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(39600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.a
 * JD-Core Version:    0.7.0.1
 */