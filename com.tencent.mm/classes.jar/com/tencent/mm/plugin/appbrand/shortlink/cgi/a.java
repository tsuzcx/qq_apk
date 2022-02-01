package com.tencent.mm.plugin.appbrand.shortlink.cgi;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.zp;
import com.tencent.mm.protocal.protobuf.zq;
import com.tencent.mm.vending.g.d.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink;", "", "()V", "checkAsync", "", "shortLink", "", "businessType", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "cgiSuccess", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "info", "Companion", "TYPE", "luggage-wechat-full-sdk_release"})
public final class a
{
  public static final a qQr;
  
  static
  {
    AppMethodBeat.i(235246);
    qQr = new a((byte)0);
    AppMethodBeat.o(235246);
  }
  
  public static void a(String paramString, b paramb, m<? super Boolean, ? super WxaShortLinkInfo, x> paramm)
  {
    AppMethodBeat.i(235243);
    p.k(paramString, "shortLink");
    p.k(paramb, "businessType");
    p.k(paramm, "callback");
    zp localzp = new zp();
    localzp.SlU = paramb.ordinal();
    localzp.SlT = paramString;
    paramString = e.K(com.tencent.mm.plugin.appbrand.networking.c.class);
    if (paramString == null) {
      p.iCn();
    }
    ((com.tencent.mm.plugin.appbrand.networking.c)paramString).a("/cgi-bin/mmbiz-bin/wxaapp/wxaapp_checkshortlink", (com.tencent.mm.cd.a)localzp, zq.class).c((com.tencent.mm.vending.c.a)new c(paramm)).a((d.a)new a.d(paramm));
    AppMethodBeat.o(235243);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$Companion;", "", "()V", "TAG", "", "URI", "luggage-wechat-full-sdk_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "", "(Ljava/lang/String;I)V", "BusinessTypeNone", "BusinessTypeWxaBase", "BusinessTypeOpenSdk", "BusinessTypeVideoAct", "luggage-wechat-full-sdk_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(244379);
      b localb1 = new b("BusinessTypeNone", 0);
      qQs = localb1;
      b localb2 = new b("BusinessTypeWxaBase", 1);
      qQt = localb2;
      b localb3 = new b("BusinessTypeOpenSdk", 2);
      qQu = localb3;
      b localb4 = new b("BusinessTypeVideoAct", 3);
      qQv = localb4;
      qQw = new b[] { localb1, localb2, localb3, localb4 };
      AppMethodBeat.o(244379);
    }
    
    private b() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckShortLinkResp;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(m paramm) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.cgi.a
 * JD-Core Version:    0.7.0.1
 */