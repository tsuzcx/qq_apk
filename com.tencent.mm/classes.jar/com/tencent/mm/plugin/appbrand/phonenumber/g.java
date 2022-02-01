package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.drp;
import com.tencent.mm.protocal.protobuf.drq;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.a;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiUpdateUserPhone;", "", "appId", "", "mobile", "type", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getMobile", "getType", "()I", "run", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;", "Lkotlin/ParameterName;", "name", "resp", "Companion", "luggage-wechat-full-sdk_release"})
public final class g
{
  public static final a mjc;
  private final String appId;
  private final String dzn;
  private final int type;
  
  static
  {
    AppMethodBeat.i(148041);
    mjc = new a((byte)0);
    AppMethodBeat.o(148041);
  }
  
  public g(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(148040);
    this.appId = paramString1;
    this.dzn = paramString2;
    this.type = paramInt;
    AppMethodBeat.o(148040);
  }
  
  public final void y(d.g.a.b<? super drq, z> paramb)
  {
    AppMethodBeat.i(148039);
    drp localdrp = new drp();
    localdrp.duW = this.appId;
    localdrp.dzn = this.dzn;
    localdrp.type = this.type;
    ((com.tencent.mm.plugin.appbrand.networking.b)e.K(com.tencent.mm.plugin.appbrand.networking.b.class)).a("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone", (com.tencent.mm.bx.a)localdrp, drq.class).c((com.tencent.mm.vending.c.a)new g.b(paramb)).a((d.a)new g.c(paramb));
    AppMethodBeat.o(148039);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiUpdateUserPhone$Companion;", "", "()V", "ADD", "", "DELETE", "luggage-wechat-full-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.g
 * JD-Core Version:    0.7.0.1
 */