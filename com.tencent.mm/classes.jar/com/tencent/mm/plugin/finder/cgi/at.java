package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateFinderUser;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "nickname", "", "signature", "avatarUrl", "extInfo", "Lcom/tencent/mm/protocal/protobuf/FinderContactExtraInfo;", "notShowSexSwitch", "", "notShowDistrictSwitch", "realPoiInfo", "showAtWxProfile", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderContactExtraInfo;IILcom/tencent/mm/protocal/protobuf/FinderContactExtraInfo;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "actionExt", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getType", "getVerifyInfo", "Lcom/tencent/mm/protocal/protobuf/FinderNicknameVerifyInfo;", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class at
  extends ax
  implements m
{
  private static final String TAG = "Finder.NetSceneCreateFinderUser";
  public static final a tuM;
  private i callback;
  public d rr;
  private final JSONObject ttQ;
  private final JSONObject tuL;
  
  static
  {
    AppMethodBeat.i(165204);
    tuM = new a((byte)0);
    TAG = "Finder.NetSceneCreateFinderUser";
    AppMethodBeat.o(165204);
  }
  
  public at(String paramString1, String paramString2, String paramString3, app paramapp1, int paramInt1, int paramInt2, app paramapp2, boolean paramBoolean)
  {
    AppMethodBeat.i(242344);
    this.ttQ = new JSONObject();
    this.tuL = new JSONObject();
    d.a locala = new d.a();
    locala.sG(getType());
    aqe localaqe = new aqe();
    localaqe.nickname = Util.nullAsNil(paramString1);
    localaqe.signature = paramString2;
    localaqe.iAR = paramString3;
    localaqe.LCi = paramapp1;
    localaqe.LCk = paramInt1;
    localaqe.LCj = paramInt2;
    paramString2 = am.tuw;
    localaqe.uli = am.cXY();
    localaqe.LCl = paramapp2;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      localaqe.LCm = paramInt1;
      locala.c((a)localaqe);
      locala.d((a)new aqf());
      locala.MB("/cgi-bin/micromsg-bin/findercreateuser");
      paramString2 = locala.aXF();
      p.g(paramString2, "builder.buildInstance()");
      this.rr = paramString2;
      this.tuL.put("nickname", paramString1);
      this.tuL.put("signature", localaqe.LCm);
      Log.i(TAG, "NetSceneCreateFinderUser init ");
      AppMethodBeat.o(242344);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242343);
    Log.i(TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = cYe();
      if (params != null)
      {
        Object localObject = c.tsp;
        c.a.a(params);
        localObject = com.tencent.mm.kernel.g.aAh();
        p.g(localObject, "MMKernel.storage()");
        ((e)localObject).azQ().set(ar.a.OjG, params.username);
        localObject = com.tencent.mm.kernel.g.aAh();
        p.g(localObject, "MMKernel.storage()");
        ((e)localObject).azQ().set(ar.a.OjH, params.nickname);
        localObject = com.tencent.mm.kernel.g.aAh();
        p.g(localObject, "MMKernel.storage()");
        ((e)localObject).azQ().set(ar.a.OjJ, params.headUrl);
      }
    }
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.hyc();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(242343);
  }
  
  public final b cXS()
  {
    return b.tye;
  }
  
  public final JSONObject cXV()
  {
    return this.tuL;
  }
  
  public final JSONObject cXW()
  {
    return this.ttQ;
  }
  
  public final FinderContact cYe()
  {
    AppMethodBeat.i(165202);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCreateUserResponse");
      AppMethodBeat.o(165202);
      throw ((Throwable)localObject);
    }
    localObject = ((aqf)localObject).contact;
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateFinderUser$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.at
 * JD-Core Version:    0.7.0.1
 */