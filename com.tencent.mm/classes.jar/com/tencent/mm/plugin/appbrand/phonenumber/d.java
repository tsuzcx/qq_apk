package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.bsa;
import com.tencent.mm.protocal.protobuf.bsb;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.r;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.nio.charset.Charset;
import java.util.List;
import org.json.JSONException;
import org.json.JSONStringer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiGetAllPhone;", "", "appId", "", "apiName", "withCredentials", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getApiName", "()Ljava/lang/String;", "getAppId", "getWithCredentials", "()Z", "jsonStringer", "run", "", "callback", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "isSucces", "errMsg", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "phoneItems", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "info", "luggage-wechat-full-sdk_release"})
public final class d
{
  private final String appId;
  private final String lTy;
  private final boolean mnX;
  
  public d(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(148028);
    this.appId = paramString1;
    this.lTy = paramString2;
    this.mnX = paramBoolean;
    AppMethodBeat.o(148028);
  }
  
  private static String az(String paramString, boolean paramBoolean)
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
        ae.printErrStackTrace("MicroMsg.JsApiGetPhoneNumberNew", (Throwable)paramString, "", new Object[0]);
      }
    }
  }
  
  public final void b(r<? super Boolean, ? super String, ? super List<PhoneItem>, ? super com.tencent.mm.plugin.appbrand.jsapi.autofill.d.b, z> paramr)
  {
    AppMethodBeat.i(148027);
    Object localObject = az(this.lTy, this.mnX);
    bsa localbsa = new bsa();
    localbsa.ikm = this.appId;
    Charset localCharset = d.n.d.UTF_8;
    if (localObject == null)
    {
      paramr = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(148027);
      throw paramr;
    }
    localObject = ((String)localObject).getBytes(localCharset);
    p.g(localObject, "(this as java.lang.String).getBytes(charset)");
    localbsa.nIq = new b((byte[])localObject);
    ((com.tencent.mm.plugin.appbrand.networking.c)e.K(com.tencent.mm.plugin.appbrand.networking.c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", (com.tencent.mm.bw.a)localbsa, bsb.class).c((com.tencent.mm.vending.c.a)new d.a(paramr)).a((com.tencent.mm.vending.g.d.a)new b(paramr));
    AppMethodBeat.o(148027);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class b<T>
    implements com.tencent.mm.vending.g.d.a<Object>
  {
    b(r paramr) {}
    
    public final void ce(Object paramObject)
    {
      AppMethodBeat.i(148025);
      ae.e("Luggage.FULL.CgiPhoneNumber", "getPhoneNumber fail");
      if ((paramObject instanceof Exception)) {
        ae.e("Luggage.FULL.CgiPhoneNumber", "CgiGetAllPhone " + ((Exception)paramObject).getMessage());
      }
      paramObject = this.mnY;
      if (paramObject != null)
      {
        paramObject.a(Boolean.FALSE, "cgi fail", null, null);
        AppMethodBeat.o(148025);
        return;
      }
      AppMethodBeat.o(148025);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.d
 * JD-Core Version:    0.7.0.1
 */