package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.ceu;
import com.tencent.mm.protocal.protobuf.cev;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.json.JSONException;
import org.json.JSONStringer;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiGetAllPhone;", "", "appId", "", "apiName", "withCredentials", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getApiName", "()Ljava/lang/String;", "getAppId", "getWithCredentials", "()Z", "jsonStringer", "run", "", "callback", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "isSucces", "errMsg", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "phoneItems", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "info", "luggage-wechat-full-sdk_release"})
public final class d
{
  private final String appId;
  private final String nbb;
  private final boolean nyJ;
  
  public d(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(148028);
    this.appId = paramString1;
    this.nbb = paramString2;
    this.nyJ = paramBoolean;
    AppMethodBeat.o(148028);
  }
  
  private static String aA(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(148026);
    JSONStringer localJSONStringer = new JSONStringer();
    try
    {
      localJSONStringer.object();
      localJSONStringer.key("api_name");
      localJSONStringer.value(paramString);
      localJSONStringer.key("with_credentials");
      localJSONStringer.value(paramBoolean);
      localJSONStringer.endObject();
      paramString = localJSONStringer.toString();
      p.g(paramString, "jsonStringer.toString()");
      AppMethodBeat.o(148026);
      return paramString;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.JsApiGetPhoneNumberNew", (Throwable)paramString, "", new Object[0]);
      }
    }
  }
  
  public final void b(r<? super Boolean, ? super String, ? super List<PhoneItem>, ? super com.tencent.mm.plugin.appbrand.jsapi.autofill.d.b, x> paramr)
  {
    AppMethodBeat.i(148027);
    Object localObject = aA(this.nbb, this.nyJ);
    ceu localceu = new ceu();
    localceu.jfi = this.appId;
    Charset localCharset = kotlin.n.d.UTF_8;
    if (localObject == null)
    {
      paramr = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(148027);
      throw paramr;
    }
    localObject = ((String)localObject).getBytes(localCharset);
    p.g(localObject, "(this as java.lang.String).getBytes(charset)");
    localceu.oTm = new b((byte[])localObject);
    ((com.tencent.mm.plugin.appbrand.networking.c)e.M(com.tencent.mm.plugin.appbrand.networking.c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", (com.tencent.mm.bw.a)localceu, cev.class).c((com.tencent.mm.vending.c.a)new a(paramr)).a((com.tencent.mm.vending.g.d.a)new d.b(paramr));
    AppMethodBeat.o(148027);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(r paramr) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.d
 * JD-Core Version:    0.7.0.1
 */