package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.appbrand.jsapi.a.c.b;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.g.c;
import d.g.a.r;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.nio.charset.Charset;
import java.util.List;
import org.json.JSONException;
import org.json.JSONStringer;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiGetAllPhone;", "", "appId", "", "apiName", "withCredentials", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getApiName", "()Ljava/lang/String;", "getAppId", "getWithCredentials", "()Z", "jsonStringer", "run", "", "callback", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "isSucces", "errMsg", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "phoneItems", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "info", "luggage-wechat-full-sdk_release"})
public final class d
{
  private final String appId;
  private final String lju;
  private final boolean ljv;
  
  public d(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(148028);
    this.appId = paramString1;
    this.lju = paramString2;
    this.ljv = paramBoolean;
    AppMethodBeat.o(148028);
  }
  
  private static String aw(String paramString, boolean paramBoolean)
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
      k.g(paramString, "jsonStringer.toString()");
      AppMethodBeat.o(148026);
      return paramString;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.JsApiGetPhoneNumberNew", (Throwable)paramString, "", new Object[0]);
      }
    }
  }
  
  public final void a(r<? super Boolean, ? super String, ? super List<PhoneItem>, ? super c.b, y> paramr)
  {
    AppMethodBeat.i(148027);
    Object localObject = aw(this.lju, this.ljv);
    bje localbje = new bje();
    localbje.hnC = this.appId;
    Charset localCharset = d.n.d.UTF_8;
    if (localObject == null)
    {
      paramr = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(148027);
      throw paramr;
    }
    localObject = ((String)localObject).getBytes(localCharset);
    k.g(localObject, "(this as java.lang.String).getBytes(charset)");
    localbje.mAx = new b((byte[])localObject);
    ((com.tencent.mm.plugin.appbrand.networking.a)e.K(com.tencent.mm.plugin.appbrand.networking.a.class)).a("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", (com.tencent.mm.bx.a)localbje, bjf.class).c((com.tencent.mm.vending.c.a)new d.a(paramr)).a((com.tencent.mm.vending.g.d.a)new b(paramr));
    AppMethodBeat.o(148027);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class b<T>
    implements com.tencent.mm.vending.g.d.a<Object>
  {
    b(r paramr) {}
    
    public final void ce(Object paramObject)
    {
      AppMethodBeat.i(148025);
      ad.e("Luggage.FULL.CgiPhoneNumber", "getPhoneNumber fail");
      if ((paramObject instanceof Exception)) {
        ad.e("Luggage.FULL.CgiPhoneNumber", "CgiGetAllPhone " + ((Exception)paramObject).getMessage());
      }
      paramObject = this.ljw;
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