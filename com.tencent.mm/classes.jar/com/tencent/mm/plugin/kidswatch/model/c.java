package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.apq;
import com.tencent.mm.protocal.protobuf.apr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/model/NetSceneExtReg;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "nickName", "", "bindMobile", "regMode", "", "hasAvatar", "", "extRegUrl", "fileId", "aesKey", "(Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "openId", "getOpenId", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "serverTime", "getServerTime", "()I", "status", "getStatus", "uin", "getUin", "username", "getUsername", "doScene", "autoAuth", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "setReSessionId", "regSessionId", "setSecurityCheckError", "e", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckError;", "Companion", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends p
  implements m
{
  public static final a JTp;
  private h callback;
  private com.tencent.mm.am.c rr;
  
  static
  {
    AppMethodBeat.i(262307);
    JTp = new a((byte)0);
    AppMethodBeat.o(262307);
  }
  
  public c(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(262291);
    Log.d("MicroMsg.NetSceneExtReg", "NetSceneExtReg: nickname = " + paramString1 + ", bindMobile = " + paramString2 + ", regMode = 4, hasAvatar=" + paramBoolean + ", extRegUrl:" + paramString3);
    Object localObject = new com.tencent.mm.am.c.a();
    ((com.tencent.mm.am.c.a)localObject).otE = ((a)new apq());
    ((com.tencent.mm.am.c.a)localObject).otF = ((a)new apr());
    ((com.tencent.mm.am.c.a)localObject).uri = "/cgi-bin/micromsg-bin/extreg";
    ((com.tencent.mm.am.c.a)localObject).funcId = 5888;
    ((com.tencent.mm.am.c.a)localObject).otG = 0;
    ((com.tencent.mm.am.c.a)localObject).respCmdId = 0;
    localObject = ((com.tencent.mm.am.c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.am.c)localObject);
    localObject = c.b.b(this.rr.otB);
    if (localObject == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegRequest");
      AppMethodBeat.o(262291);
      throw paramString1;
    }
    localObject = (apq)localObject;
    ((apq)localObject).vhX = paramString1;
    ((apq)localObject).YBW = paramString2;
    ((apq)localObject).ZwR = 4;
    if (paramBoolean) {
      i = 1;
    }
    ((apq)localObject).ZwS = i;
    ((apq)localObject).YOs = paramString3;
    ((apq)localObject).ZwU = paramString4;
    ((apq)localObject).ZwV = paramString5;
    Log.i("MicroMsg.NetSceneExtReg", "fileId:" + paramString4 + ", aesKey:" + paramString5);
    AppMethodBeat.o(262291);
  }
  
  public final void OZ(String paramString)
  {
    AppMethodBeat.i(262322);
    if (!Util.isNullOrNil(paramString))
    {
      a locala = c.b.b(this.rr.otB);
      if (locala == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegRequest");
        AppMethodBeat.o(262322);
        throw paramString;
      }
      ((apq)locala).YOn = paramString;
      Log.i("MicroMsg.NetSceneExtReg", "setRegSessionId %s", new Object[] { paramString });
    }
    AppMethodBeat.o(262322);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(262337);
    kotlin.g.b.s.u(paramg, "autoAuth");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(262337);
    return i;
  }
  
  public final String getOpenId()
  {
    AppMethodBeat.i(262387);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegResponse");
      AppMethodBeat.o(262387);
      throw ((Throwable)localObject);
    }
    localObject = ((apr)localObject).muE;
    kotlin.g.b.s.s(localObject, "rr.responseProtoBuf as ExtRegResponse).OpenID");
    AppMethodBeat.o(262387);
    return localObject;
  }
  
  public final int getType()
  {
    return 5888;
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(262380);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegResponse");
      AppMethodBeat.o(262380);
      throw ((Throwable)localObject);
    }
    localObject = ((apr)localObject).UserName;
    AppMethodBeat.o(262380);
    return localObject;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(262374);
    kotlin.g.b.s.u(params, "rr");
    if (c.b.b(((com.tencent.mm.am.c)params).otB) == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegRequest");
      AppMethodBeat.o(262374);
      throw paramString;
    }
    if (c.c.b(((com.tencent.mm.am.c)params).otC) == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ExtRegResponse");
      AppMethodBeat.o(262374);
      throw paramString;
    }
    params = this.callback;
    kotlin.g.b.s.checkNotNull(params);
    params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    Log.i("MicroMsg.NetSceneExtReg", "errType:" + paramInt2 + ", errCode:" + paramInt3 + ", errType:" + paramString);
    AppMethodBeat.o(262374);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(262353);
    kotlin.g.b.s.u(params, "rr");
    params = p.b.ouh;
    AppMethodBeat.o(262353);
    return params;
  }
  
  public final void setSecurityCheckError(p.a parama)
  {
    AppMethodBeat.i(262358);
    kotlin.g.b.s.u(parama, "e");
    AppMethodBeat.o(262358);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/model/NetSceneExtReg$Companion;", "", "()V", "MM_REGMODE_MOBILE_NOPWD", "", "REG_MODE_MOBILE", "TAG", "", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.model.c
 * JD-Core Version:    0.7.0.1
 */