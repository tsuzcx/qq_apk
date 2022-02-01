package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.erc;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ReportUserCheckPhonePrivacy;", "", "appId", "", "userAgreementChecked", "", "(Ljava/lang/String;Z)V", "getAppId", "()Ljava/lang/String;", "getUserAgreementChecked", "()Z", "run", "", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final a rId;
  private final String appId;
  private final boolean rFg;
  
  static
  {
    AppMethodBeat.i(326635);
    rId = new a((byte)0);
    AppMethodBeat.o(326635);
  }
  
  public k(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(326631);
    this.appId = paramString;
    this.rFg = paramBoolean;
    AppMethodBeat.o(326631);
  }
  
  private static final ah a(erd paramerd)
  {
    return ah.aiuX;
  }
  
  private static final void dZ(Object paramObject)
  {
    AppMethodBeat.i(326633);
    if ((paramObject instanceof Exception)) {
      Log.e("MicroMsg.ReportUserCheckPhonePrivacy", s.X("CgiCheckVerifyCodeWxaPhone ", ((Exception)paramObject).getMessage()));
    }
    AppMethodBeat.o(326633);
  }
  
  public final void run()
  {
    AppMethodBeat.i(326650);
    erc localerc = new erc();
    localerc.appid = this.appId;
    localerc.aaJw = this.rFg;
    ((com.tencent.mm.plugin.appbrand.networking.c)e.T(com.tencent.mm.plugin.appbrand.networking.c.class)).a("/cgi-bin/mmbiz-bin/wxabusiness/reportusercheckphoneprivacy", (a)localerc, erd.class).c(k..ExternalSyntheticLambda0.INSTANCE).a(k..ExternalSyntheticLambda1.INSTANCE);
    AppMethodBeat.o(326650);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ReportUserCheckPhonePrivacy$Companion;", "", "()V", "TAG", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.k
 * JD-Core Version:    0.7.0.1
 */