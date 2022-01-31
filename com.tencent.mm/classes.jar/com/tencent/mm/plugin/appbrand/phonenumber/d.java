package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f;
import a.f.a.a;
import a.f.a.r;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.g;
import a.j.k;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.bwv;
import java.util.List;
import org.json.JSONException;
import org.json.JSONStringer;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiGetAllPhone;", "", "appId", "", "apiName", "withCredentials", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRr", "()Lcom/tencent/mm/modelbase/CommReqResp;", "rr$delegate", "Lkotlin/Lazy;", "jsonStringer", "run", "", "callback", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "isSucces", "errMsg", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "phoneItems", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "scope", "Companion", "plugin-appbrand-integration_release"})
public final class d
{
  public static final d.a iCI;
  private final f iCD;
  
  static
  {
    AppMethodBeat.i(143924);
    eOJ = new k[] { (k)v.a(new t(v.aG(d.class), "rr", "getRr()Lcom/tencent/mm/modelbase/CommReqResp;")) };
    iCI = new d.a((byte)0);
    AppMethodBeat.o(143924);
  }
  
  public d(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(134780);
    this.iCD = g.j((a)new d.b(this, paramString2, paramBoolean, paramString1));
    AppMethodBeat.o(134780);
  }
  
  private com.tencent.mm.ai.b aKG()
  {
    AppMethodBeat.i(143925);
    com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)this.iCD.getValue();
    AppMethodBeat.o(143925);
    return localb;
  }
  
  private static String ar(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(134779);
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
      j.p(paramString, "jsonStringer.toString()");
      AppMethodBeat.o(134779);
      return paramString;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        com.tencent.luggage.g.d.printErrStackTrace("MicroMsg.JsApiGetPhoneNumberNew", (Throwable)paramString, "", new Object[0]);
      }
    }
  }
  
  public final void a(r<? super Boolean, ? super String, ? super List<PhoneItem>, ? super bwv, y> paramr)
  {
    AppMethodBeat.i(143926);
    com.tencent.mm.ipcinvoker.wx_extension.b.a(aKG(), (b.a)new d.c(paramr));
    AppMethodBeat.o(143926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.d
 * JD-Core Version:    0.7.0.1
 */