package com.tencent.mm.plugin.appbrand.shortlink.cgi;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink;", "", "()V", "checkAsync", "", "shortLink", "", "businessType", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "cgiSuccess", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "info", "Companion", "TYPE", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a tVd;
  
  static
  {
    AppMethodBeat.i(321888);
    tVd = new a.a((byte)0);
    AppMethodBeat.o(321888);
  }
  
  private static final ah a(m paramm, abo paramabo)
  {
    AppMethodBeat.i(321882);
    s.u(paramm, "$callback");
    if (paramabo.BaseResponse.Idd != 0)
    {
      Log.e("MicroMsg.CgiCheckWxaShortLink", "checkAsync cig fail. Ret[" + paramabo.BaseResponse.Idd + "]  ErrMsg[" + paramabo.BaseResponse.akjO + ']');
      paramm.invoke(Boolean.FALSE, null);
      paramm = ah.aiuX;
      AppMethodBeat.o(321882);
      return paramm;
    }
    Log.i("MicroMsg.CgiCheckWxaShortLink", "checkAsync cig success.");
    Boolean localBoolean = Boolean.TRUE;
    Object localObject1 = WxaShortLinkInfo.tVj;
    s.s(paramabo, "resp");
    s.u(paramabo, "resp");
    localObject1 = paramabo.Zkg;
    label134:
    Object localObject2;
    label149:
    Object localObject3;
    label164:
    int i;
    int j;
    if (localObject1 == null)
    {
      localObject1 = "";
      localObject2 = paramabo.Zki;
      if (localObject2 != null) {
        break label239;
      }
      localObject2 = "";
      localObject3 = paramabo.Zkh;
      if (localObject3 != null) {
        break label264;
      }
      localObject3 = "";
      i = paramabo.version;
      j = paramabo.Tqb;
      paramabo = paramabo.Zkj;
      if (paramabo != null) {
        break label289;
      }
      paramabo = "";
    }
    for (;;)
    {
      paramm.invoke(localBoolean, new WxaShortLinkInfo((String)localObject1, (String)localObject2, (String)localObject3, i, j, paramabo));
      break;
      localObject2 = ((b)localObject1).toString("UTF-8");
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label134;
      }
      localObject1 = "";
      break label134;
      label239:
      localObject3 = ((b)localObject2).toString("UTF-8");
      localObject2 = localObject3;
      if (localObject3 != null) {
        break label149;
      }
      localObject2 = "";
      break label149;
      label264:
      String str = ((b)localObject3).toString("UTF-8");
      localObject3 = str;
      if (str != null) {
        break label164;
      }
      localObject3 = "";
      break label164;
      label289:
      str = paramabo.ZV();
      paramabo = str;
      if (str == null) {
        paramabo = "";
      }
    }
  }
  
  public static void a(String paramString, a.b paramb, m<? super Boolean, ? super WxaShortLinkInfo, ah> paramm)
  {
    AppMethodBeat.i(321874);
    s.u(paramString, "shortLink");
    s.u(paramb, "businessType");
    s.u(paramm, "callback");
    abn localabn = new abn();
    localabn.Zkf = paramb.ordinal();
    localabn.Zke = paramString;
    paramString = e.T(com.tencent.mm.plugin.appbrand.networking.c.class);
    s.checkNotNull(paramString);
    ((com.tencent.mm.plugin.appbrand.networking.c)paramString).a("/cgi-bin/mmbiz-bin/wxaapp/wxaapp_checkshortlink", (com.tencent.mm.bx.a)localabn, abo.class).c(new a..ExternalSyntheticLambda0(paramm)).a(new a..ExternalSyntheticLambda1(paramm));
    AppMethodBeat.o(321874);
  }
  
  private static final void a(m paramm, Object paramObject)
  {
    AppMethodBeat.i(321886);
    s.u(paramm, "$callback");
    if ((paramObject instanceof Exception)) {
      Log.e("MicroMsg.CgiCheckWxaShortLink", s.X("checkAsync exception", ((Exception)paramObject).getMessage()));
    }
    paramm.invoke(Boolean.FALSE, null);
    AppMethodBeat.o(321886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.cgi.a
 * JD-Core Version:    0.7.0.1
 */