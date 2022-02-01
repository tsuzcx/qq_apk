package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.findersdk.b.a.b;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateFinderUser;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "nickname", "", "signature", "avatarUrl", "extInfo", "Lcom/tencent/mm/protocal/protobuf/FinderContactExtraInfo;", "notShowSexSwitch", "", "notShowDistrictSwitch", "realPoiInfo", "showAtWxProfile", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderContactExtraInfo;IILcom/tencent/mm/protocal/protobuf/FinderContactExtraInfo;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "actionExt", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getType", "getVerifyInfo", "Lcom/tencent/mm/protocal/protobuf/FinderNicknameVerifyInfo;", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class aw
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private static final String TAG = "Finder.NetSceneCreateFinderUser";
  public static final a xcv;
  private i callback;
  public com.tencent.mm.an.d rr;
  private final JSONObject xbw;
  private final JSONObject xcu;
  
  static
  {
    AppMethodBeat.i(165204);
    xcv = new a((byte)0);
    TAG = "Finder.NetSceneCreateFinderUser";
    AppMethodBeat.o(165204);
  }
  
  public aw(String paramString1, String paramString2, String paramString3, ard paramard1, int paramInt1, int paramInt2, ard paramard2, boolean paramBoolean)
  {
    AppMethodBeat.i(278314);
    this.xbw = new JSONObject();
    this.xcu = new JSONObject();
    com.tencent.mm.an.d.a locala = new com.tencent.mm.an.d.a();
    locala.vD(getType());
    aru localaru = new aru();
    localaru.nickname = Util.nullAsNil(paramString1);
    localaru.signature = paramString2;
    localaru.lqp = paramString3;
    localaru.SFj = paramard1;
    localaru.SFl = paramInt1;
    localaru.SFk = paramInt2;
    paramString2 = ao.xcj;
    localaru.yjp = ao.dnO();
    localaru.SFm = paramard2;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      localaru.SFn = paramInt1;
      locala.c((a)localaru);
      locala.d((a)new arv());
      locala.TW("/cgi-bin/micromsg-bin/findercreateuser");
      paramString2 = locala.bgN();
      p.j(paramString2, "builder.buildInstance()");
      this.rr = paramString2;
      this.xcu.put("nickname", paramString1);
      this.xcu.put("signature", localaru.SFn);
      Log.i(TAG, "NetSceneCreateFinderUser init ");
      AppMethodBeat.o(278314);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(278313);
    Log.i(TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = dnV();
      if (params != null)
      {
        Object localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
        com.tencent.mm.plugin.finder.api.d.a.a(params);
        localObject = h.aHG();
        p.j(localObject, "MMKernel.storage()");
        ((f)localObject).aHp().set(ar.a.VxX, params.username);
        localObject = h.aHG();
        p.j(localObject, "MMKernel.storage()");
        ((f)localObject).aHp().set(ar.a.VxY, params.nickname);
        localObject = h.aHG();
        p.j(localObject, "MMKernel.storage()");
        ((f)localObject).aHp().set(ar.a.Vya, params.headUrl);
      }
    }
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.iCn();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(278313);
  }
  
  public final b dnF()
  {
    return b.BvU;
  }
  
  public final JSONObject dnI()
  {
    return this.xcu;
  }
  
  public final JSONObject dnJ()
  {
    return this.xbw;
  }
  
  public final FinderContact dnV()
  {
    AppMethodBeat.i(165202);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCreateUserResponse");
      AppMethodBeat.o(165202);
      throw ((Throwable)localObject);
    }
    localObject = ((arv)localObject).contact;
    AppMethodBeat.o(165202);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(165200);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(165200);
    return i;
  }
  
  public final int getType()
  {
    return 3922;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateFinderUser$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aw
 * JD-Core Version:    0.7.0.1
 */