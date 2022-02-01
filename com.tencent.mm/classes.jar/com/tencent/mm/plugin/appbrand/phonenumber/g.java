package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.emk;
import com.tencent.mm.protocal.protobuf.eml;
import com.tencent.mm.vending.g.d.a;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiUpdateUserPhone;", "", "appId", "", "mobile", "type", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getMobile", "getType", "()I", "run", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;", "Lkotlin/ParameterName;", "name", "resp", "Companion", "luggage-wechat-full-sdk_release"})
public final class g
{
  public static final a nyL;
  private final String appId;
  private final String dSf;
  private final int type;
  
  static
  {
    AppMethodBeat.i(148041);
    nyL = new a((byte)0);
    AppMethodBeat.o(148041);
  }
  
  public g(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(148040);
    this.appId = paramString1;
    this.dSf = paramString2;
    this.type = paramInt;
    AppMethodBeat.o(148040);
  }
  
  public final void y(b<? super eml, x> paramb)
  {
    AppMethodBeat.i(148039);
    emk localemk = new emk();
    localemk.dNI = this.appId;
    localemk.dSf = this.dSf;
    localemk.type = this.type;
    ((com.tencent.mm.plugin.appbrand.networking.c)e.M(com.tencent.mm.plugin.appbrand.networking.c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone", (com.tencent.mm.bw.a)localemk, eml.class).c((com.tencent.mm.vending.c.a)new b(paramb)).a((d.a)new g.c(paramb));
    AppMethodBeat.o(148039);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiUpdateUserPhone$Companion;", "", "()V", "ADD", "", "DELETE", "luggage-wechat-full-sdk_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;)Lkotlin/Unit;"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.g
 * JD-Core Version:    0.7.0.1
 */