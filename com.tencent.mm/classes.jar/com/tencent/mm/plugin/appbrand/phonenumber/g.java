package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.fsj;
import com.tencent.mm.protocal.protobuf.fsk;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiUpdateUserPhone;", "", "appId", "", "mobile", "type", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getMobile", "getType", "()I", "run", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;", "Lkotlin/ParameterName;", "name", "resp", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final a tGe;
  private final String appId;
  private final String hRk;
  private final int type;
  
  static
  {
    AppMethodBeat.i(148041);
    tGe = new a((byte)0);
    AppMethodBeat.o(148041);
  }
  
  public g(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(148040);
    this.appId = paramString1;
    this.hRk = paramString2;
    this.type = paramInt;
    AppMethodBeat.o(148040);
  }
  
  private static final ah a(b paramb, fsk paramfsk)
  {
    AppMethodBeat.i(318929);
    if (paramb == null)
    {
      AppMethodBeat.o(318929);
      return null;
    }
    paramb.invoke(paramfsk);
    paramb = ah.aiuX;
    AppMethodBeat.o(318929);
    return paramb;
  }
  
  private static final void f(b paramb, Object paramObject)
  {
    AppMethodBeat.i(318936);
    if ((paramObject instanceof Exception)) {
      Log.e("Luggage.FULL.CgiPhoneNumber", s.X("CgiUpdateUserPhone ", ((Exception)paramObject).getMessage()));
    }
    if (paramb != null) {
      paramb.invoke(null);
    }
    AppMethodBeat.o(318936);
  }
  
  public final void Z(b<? super fsk, ah> paramb)
  {
    AppMethodBeat.i(148039);
    fsj localfsj = new fsj();
    localfsj.appid = this.appId;
    localfsj.hRk = this.hRk;
    localfsj.type = this.type;
    ((com.tencent.mm.plugin.appbrand.networking.c)e.T(com.tencent.mm.plugin.appbrand.networking.c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone", (a)localfsj, fsk.class).c(new g..ExternalSyntheticLambda0(paramb)).a(new g..ExternalSyntheticLambda1(paramb));
    AppMethodBeat.o(148039);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiUpdateUserPhone$Companion;", "", "()V", "ADD", "", "DELETE", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.g
 * JD-Core Version:    0.7.0.1
 */