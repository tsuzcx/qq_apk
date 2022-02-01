package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.findersdk.b.a.b;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.protocal.protobuf.awd;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateFinderUser;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "nickname", "", "signature", "avatarUrl", "extInfo", "Lcom/tencent/mm/protocal/protobuf/FinderContactExtraInfo;", "notShowSexSwitch", "", "notShowDistrictSwitch", "realPoiInfo", "showAtWxProfile", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderContactExtraInfo;IILcom/tencent/mm/protocal/protobuf/FinderContactExtraInfo;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "actionExt", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getType", "getVerifyInfo", "Lcom/tencent/mm/protocal/protobuf/FinderNicknameVerifyInfo;", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class br
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a ABG;
  private static final String TAG;
  private final JSONObject AAn;
  private final JSONObject ABH;
  private com.tencent.mm.am.h callback;
  public c rr;
  
  static
  {
    AppMethodBeat.i(165204);
    ABG = new a((byte)0);
    TAG = "Finder.NetSceneCreateFinderUser";
    AppMethodBeat.o(165204);
  }
  
  public br(String paramString1, String paramString2, String paramString3, avl paramavl1, int paramInt1, int paramInt2, avl paramavl2, boolean paramBoolean)
  {
    AppMethodBeat.i(336400);
    this.AAn = new JSONObject();
    this.ABH = new JSONObject();
    c.a locala = new c.a();
    locala.funcId = getType();
    awd localawd = new awd();
    localawd.nickname = Util.nullAsNil(paramString1);
    localawd.signature = paramString2;
    localawd.nVs = paramString3;
    localawd.ZGY = paramavl1;
    localawd.ZHa = paramInt1;
    localawd.ZGZ = paramInt2;
    paramString2 = bi.ABn;
    localawd.CJv = bi.dVu();
    localawd.ZHb = paramavl2;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      localawd.ZHc = paramInt1;
      locala.otE = ((a)localawd);
      locala.otF = ((a)new awe());
      locala.uri = "/cgi-bin/micromsg-bin/findercreateuser";
      paramString2 = locala.bEF();
      kotlin.g.b.s.s(paramString2, "builder.buildInstance()");
      this.rr = paramString2;
      this.ABH.put("nickname", paramString1);
      this.ABH.put("signature", localawd.ZHc);
      Log.i(TAG, "NetSceneCreateFinderUser init ");
      AppMethodBeat.o(336400);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336441);
    Log.i(TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = dVC();
      if (params != null)
      {
        d.a locala = d.AwY;
        d.a.d(params);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acZR, params.username);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acZS, params.nickname);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acZU, params.headUrl);
      }
    }
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336441);
  }
  
  public final FinderContact dVC()
  {
    AppMethodBeat.i(165202);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCreateUserResponse");
      AppMethodBeat.o(165202);
      throw ((Throwable)localObject);
    }
    localObject = ((awe)localObject).contact;
    AppMethodBeat.o(165202);
    return localObject;
  }
  
  public final b dVi()
  {
    return b.Hde;
  }
  
  public final JSONObject dVk()
  {
    return this.ABH;
  }
  
  public final JSONObject dVl()
  {
    return this.AAn;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(165200);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(165200);
    return i;
  }
  
  public final int getType()
  {
    return 3922;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateFinderUser$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.br
 * JD-Core Version:    0.7.0.1
 */