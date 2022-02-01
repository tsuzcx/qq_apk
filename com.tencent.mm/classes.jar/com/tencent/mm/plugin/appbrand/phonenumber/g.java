package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dgj;
import com.tencent.mm.protocal.protobuf.dgk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.a;
import d.g.a.b;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiUpdateUserPhone;", "", "appId", "", "mobile", "type", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getMobile", "getType", "()I", "run", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;", "Lkotlin/ParameterName;", "name", "resp", "Companion", "luggage-wechat-full-sdk_release"})
public final class g
{
  public static final a ljx;
  private final String appId;
  private final String dpO;
  private final int type;
  
  static
  {
    AppMethodBeat.i(148041);
    ljx = new a((byte)0);
    AppMethodBeat.o(148041);
  }
  
  public g(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(148040);
    this.appId = paramString1;
    this.dpO = paramString2;
    this.type = paramInt;
    AppMethodBeat.o(148040);
  }
  
  public final void t(b<? super dgk, y> paramb)
  {
    AppMethodBeat.i(148039);
    dgj localdgj = new dgj();
    localdgj.dlB = this.appId;
    localdgj.dpO = this.dpO;
    localdgj.type = this.type;
    ((com.tencent.mm.plugin.appbrand.networking.a)e.K(com.tencent.mm.plugin.appbrand.networking.a.class)).a("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone", (com.tencent.mm.bx.a)localdgj, dgk.class).c((com.tencent.mm.vending.c.a)new b(paramb)).a((d.a)new c(paramb));
    AppMethodBeat.o(148039);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiUpdateUserPhone$Companion;", "", "()V", "ADD", "", "DELETE", "luggage-wechat-full-sdk_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;)Lkotlin/Unit;"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(b paramb) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class c<T>
    implements d.a<Object>
  {
    c(b paramb) {}
    
    public final void ce(Object paramObject)
    {
      AppMethodBeat.i(148038);
      if ((paramObject instanceof Exception)) {
        ad.e("Luggage.FULL.CgiPhoneNumber", "CgiUpdateUserPhone " + ((Exception)paramObject).getMessage());
      }
      paramObject = this.fLH;
      if (paramObject != null)
      {
        paramObject.aA(null);
        AppMethodBeat.o(148038);
        return;
      }
      AppMethodBeat.o(148038);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.g
 * JD-Core Version:    0.7.0.1
 */