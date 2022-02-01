package com.tencent.mm.plugin.appbrand.shortlink.cgi;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.zl;
import com.tencent.mm.protocal.protobuf.zm;
import com.tencent.mm.vending.g.d.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink;", "", "()V", "checkAsync", "", "shortLink", "", "businessType", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "cgiSuccess", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "info", "Companion", "TYPE", "luggage-wechat-full-sdk_release"})
public final class a
{
  public static final a nNV;
  
  static
  {
    AppMethodBeat.i(230183);
    nNV = new a((byte)0);
    AppMethodBeat.o(230183);
  }
  
  public static void a(String paramString, a.b paramb, m<? super Boolean, ? super WxaShortLinkInfo, x> paramm)
  {
    AppMethodBeat.i(230182);
    p.h(paramString, "shortLink");
    p.h(paramb, "businessType");
    p.h(paramm, "callback");
    zl localzl = new zl();
    localzl.LkL = paramb.ordinal();
    localzl.LkK = paramString;
    paramString = e.M(com.tencent.mm.plugin.appbrand.networking.c.class);
    if (paramString == null) {
      p.hyc();
    }
    ((com.tencent.mm.plugin.appbrand.networking.c)paramString).a("/cgi-bin/mmbiz-bin/wxaapp/wxaapp_checkshortlink", (com.tencent.mm.bw.a)localzl, zm.class).c((com.tencent.mm.vending.c.a)new c(paramm)).a((d.a)new a.d(paramm));
    AppMethodBeat.o(230182);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$Companion;", "", "()V", "TAG", "", "URI", "luggage-wechat-full-sdk_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckShortLinkResp;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(m paramm) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.cgi.a
 * JD-Core Version:    0.7.0.1
 */