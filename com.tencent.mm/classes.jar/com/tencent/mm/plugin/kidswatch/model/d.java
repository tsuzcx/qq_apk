package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ala;
import com.tencent.mm.protocal.protobuf.alb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/model/NetSceneExtReg;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "nickName", "", "bindMobile", "regMode", "", "hasAvatar", "", "extRegUrl", "fileId", "aesKey", "(Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "openId", "getOpenId", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "serverTime", "getServerTime", "()I", "status", "getStatus", "uin", "getUin", "username", "getUsername", "doScene", "autoAuth", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "setReSessionId", "regSessionId", "setSecurityCheckError", "e", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckError;", "Companion", "plugin-kidswatch_release"})
public final class d
  extends q
  implements m
{
  public static final d.a yAW;
  private i callback;
  private com.tencent.mm.ak.d rr;
  
  static
  {
    AppMethodBeat.i(256205);
    yAW = new d.a((byte)0);
    AppMethodBeat.o(256205);
  }
  
  public d(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(256204);
    Log.d("MicroMsg.NetSceneExtReg", "NetSceneExtReg: nickname = " + paramString1 + ", bindMobile = " + paramString2 + ", regMode = 4, hasAvatar=" + paramBoolean + ", extRegUrl:" + paramString3);
    Object localObject = new com.tencent.mm.ak.d.a();
    ((com.tencent.mm.ak.d.a)localObject).c((a)new ala());
    ((com.tencent.mm.ak.d.a)localObject).d((a)new alb());
    ((com.tencent.mm.ak.d.a)localObject).MB("/cgi-bin/micromsg-bin/extreg");
    ((com.tencent.mm.ak.d.a)localObject).sG(5888);
    ((com.tencent.mm.ak.d.a)localObject).sI(0);
    ((com.tencent.mm.ak.d.a)localObject).sJ(0);
    localObject = ((com.tencent.mm.ak.d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.ak.d)localObject);
    localObject = this.rr.aYJ();
    if (localObject == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegRequest");
      AppMethodBeat.o(256204);
      throw paramString1;
    }
    localObject = (ala)localObject;
    ((ala)localObject).oUJ = paramString1;
    ((ala)localObject).KEb = paramString2;
    ((ala)localObject).LtW = 4;
    if (paramBoolean) {
      i = 1;
    }
    ((ala)localObject).LtX = i;
    ((ala)localObject).KQf = paramString3;
    ((ala)localObject).LtZ = paramString4;
    ((ala)localObject).Lua = paramString5;
    Log.i("MicroMsg.NetSceneExtReg", "fileId:" + paramString4 + ", aesKey:" + paramString5);
    AppMethodBeat.o(256204);
  }
  
  public final void PB(String paramString)
  {
    AppMethodBeat.i(256197);
    if (!Util.isNullOrNil(paramString))
    {
      a locala = this.rr.aYJ();
      if (locala == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegRequest");
        AppMethodBeat.o(256197);
        throw paramString;
      }
      ((ala)locala).KQa = paramString;
      Log.i("MicroMsg.NetSceneExtReg", "setRegSessionId %s", new Object[] { paramString });
    }
    AppMethodBeat.o(256197);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(256198);
    p.h(paramg, "autoAuth");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(256198);
    return i;
  }
  
  public final String getOpenId()
  {
    AppMethodBeat.i(256203);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegResponse");
      AppMethodBeat.o(256203);
      throw ((Throwable)localObject);
    }
    localObject = ((alb)localObject).hio;
    p.g(localObject, "(rr.responseProtoBuf as ExtRegResponse).OpenID");
    AppMethodBeat.o(256203);
    return localObject;
  }
  
  public final int getType()
  {
    return 5888;
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(256202);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegResponse");
      AppMethodBeat.o(256202);
      throw ((Throwable)localObject);
    }
    localObject = ((alb)localObject).UserName;
    AppMethodBeat.o(256202);
    return localObject;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(256201);
    p.h(params, "rr");
    if (((com.tencent.mm.ak.d)params).aYJ() == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegRequest");
      AppMethodBeat.o(256201);
      throw paramString;
    }
    if (((com.tencent.mm.ak.d)params).aYK() == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegResponse");
      AppMethodBeat.o(256201);
      throw paramString;
    }
    params = this.callback;
    if (params == null) {
      p.hyc();
    }
    params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    Log.i("MicroMsg.NetSceneExtReg", "errType:" + paramInt2 + ", errCode:" + paramInt3 + ", errType:" + paramString);
    AppMethodBeat.o(256201);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(256199);
    p.h(params, "rr");
    params = q.b.iMq;
    AppMethodBeat.o(256199);
    return params;
  }
  
  public final void setSecurityCheckError(q.a parama)
  {
    AppMethodBeat.i(256200);
    p.h(parama, "e");
    AppMethodBeat.o(256200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.model.d
 * JD-Core Version:    0.7.0.1
 */