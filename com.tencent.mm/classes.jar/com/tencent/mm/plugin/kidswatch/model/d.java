package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.a;
import com.tencent.mm.an.q.b;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.amb;
import com.tencent.mm.protocal.protobuf.amc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/model/NetSceneExtReg;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "nickName", "", "bindMobile", "regMode", "", "hasAvatar", "", "extRegUrl", "fileId", "aesKey", "(Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "openId", "getOpenId", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "serverTime", "getServerTime", "()I", "status", "getStatus", "uin", "getUin", "username", "getUsername", "doScene", "autoAuth", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "setReSessionId", "regSessionId", "setSecurityCheckError", "e", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckError;", "Companion", "plugin-kidswatch_release"})
public final class d
  extends q
  implements m
{
  public static final a Ecl;
  private i callback;
  private com.tencent.mm.an.d rr;
  
  static
  {
    AppMethodBeat.i(252314);
    Ecl = new a((byte)0);
    AppMethodBeat.o(252314);
  }
  
  public d(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(252313);
    Log.d("MicroMsg.NetSceneExtReg", "NetSceneExtReg: nickname = " + paramString1 + ", bindMobile = " + paramString2 + ", regMode = 4, hasAvatar=" + paramBoolean + ", extRegUrl:" + paramString3);
    Object localObject = new com.tencent.mm.an.d.a();
    ((com.tencent.mm.an.d.a)localObject).c((a)new amb());
    ((com.tencent.mm.an.d.a)localObject).d((a)new amc());
    ((com.tencent.mm.an.d.a)localObject).TW("/cgi-bin/micromsg-bin/extreg");
    ((com.tencent.mm.an.d.a)localObject).vD(5888);
    ((com.tencent.mm.an.d.a)localObject).vF(0);
    ((com.tencent.mm.an.d.a)localObject).vG(0);
    localObject = ((com.tencent.mm.an.d.a)localObject).bgN();
    p.j(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.an.d)localObject);
    localObject = this.rr.bhX();
    if (localObject == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegRequest");
      AppMethodBeat.o(252313);
      throw paramString1;
    }
    localObject = (amb)localObject;
    ((amb)localObject).rWI = paramString1;
    ((amb)localObject).RFt = paramString2;
    ((amb)localObject).Swu = 4;
    if (paramBoolean) {
      i = 1;
    }
    ((amb)localObject).Swv = i;
    ((amb)localObject).RRd = paramString3;
    ((amb)localObject).Swx = paramString4;
    ((amb)localObject).Swy = paramString5;
    Log.i("MicroMsg.NetSceneExtReg", "fileId:" + paramString4 + ", aesKey:" + paramString5);
    AppMethodBeat.o(252313);
  }
  
  public final void WZ(String paramString)
  {
    AppMethodBeat.i(252303);
    if (!Util.isNullOrNil(paramString))
    {
      a locala = this.rr.bhX();
      if (locala == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegRequest");
        AppMethodBeat.o(252303);
        throw paramString;
      }
      ((amb)locala).RQY = paramString;
      Log.i("MicroMsg.NetSceneExtReg", "setRegSessionId %s", new Object[] { paramString });
    }
    AppMethodBeat.o(252303);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(252305);
    p.k(paramg, "autoAuth");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(252305);
    return i;
  }
  
  public final String getOpenId()
  {
    AppMethodBeat.i(252312);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegResponse");
      AppMethodBeat.o(252312);
      throw ((Throwable)localObject);
    }
    localObject = ((amc)localObject).jUm;
    p.j(localObject, "(rr.responseProtoBuf as ExtRegResponse).OpenID");
    AppMethodBeat.o(252312);
    return localObject;
  }
  
  public final int getType()
  {
    return 5888;
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(252310);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegResponse");
      AppMethodBeat.o(252310);
      throw ((Throwable)localObject);
    }
    localObject = ((amc)localObject).UserName;
    AppMethodBeat.o(252310);
    return localObject;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(252309);
    p.k(params, "rr");
    if (((com.tencent.mm.an.d)params).bhX() == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegRequest");
      AppMethodBeat.o(252309);
      throw paramString;
    }
    if (((com.tencent.mm.an.d)params).bhY() == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegResponse");
      AppMethodBeat.o(252309);
      throw paramString;
    }
    params = this.callback;
    if (params == null) {
      p.iCn();
    }
    params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    Log.i("MicroMsg.NetSceneExtReg", "errType:" + paramInt2 + ", errCode:" + paramInt3 + ", errType:" + paramString);
    AppMethodBeat.o(252309);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(252307);
    p.k(params, "rr");
    params = q.b.lCx;
    AppMethodBeat.o(252307);
    return params;
  }
  
  public final void setSecurityCheckError(q.a parama)
  {
    AppMethodBeat.i(252308);
    p.k(parama, "e");
    AppMethodBeat.o(252308);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/model/NetSceneExtReg$Companion;", "", "()V", "MM_REGMODE_MOBILE_NOPWD", "", "REG_MODE_MOBILE", "TAG", "", "plugin-kidswatch_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.model.d
 * JD-Core Version:    0.7.0.1
 */