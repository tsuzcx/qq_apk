package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.appbrand.jsapi.autofill.d.b;
import com.tencent.mm.protocal.protobuf.ddh;
import com.tencent.mm.protocal.protobuf.deg;
import com.tencent.mm.protocal.protobuf.deh;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.protocal.protobuf.eul;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.r;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiGetAllPhone;", "", "appId", "", "apiName", "withCredentials", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getApiName", "()Ljava/lang/String;", "getAppId", "getWithCredentials", "()Z", "jsonStringer", "run", "", "callback", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "isSucces", "errMsg", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "phoneItems", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "info", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private final String appId;
  private final String efV;
  private final boolean tGd;
  
  public d(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(148028);
    this.appId = paramString1;
    this.efV = paramString2;
    this.tGd = paramBoolean;
    AppMethodBeat.o(148028);
  }
  
  private static final ah a(r paramr, deh paramdeh)
  {
    AppMethodBeat.i(318960);
    Log.i("Luggage.FULL.CgiPhoneNumber", "getPhoneNumber success");
    int i = paramdeh.aaJx.hGE;
    Object localObject1 = paramdeh.aaJx.errmsg;
    Object localObject2 = h.tGf;
    if (i != h.cHj())
    {
      Log.e("Luggage.FULL.CgiPhoneNumber", "jsErrcode:" + i + ", jsErrmsg:" + localObject1);
      if (paramr != null)
      {
        localObject2 = Boolean.FALSE;
        paramdeh = (deh)localObject1;
        if (localObject1 == null) {
          paramdeh = "";
        }
        paramr.a(localObject2, paramdeh, null, null);
      }
      paramr = ah.aiuX;
      AppMethodBeat.o(318960);
      return paramr;
    }
    localObject1 = new JSONObject(paramdeh.vgA.ZV());
    ArrayList localArrayList = new ArrayList();
    localObject2 = PhoneItem.tGI;
    localObject2 = ((JSONObject)localObject1).optString("wx_phone");
    s.s(localObject2, "phoneItemsJsonObj.optString(\"wx_phone\")");
    localObject2 = PhoneItem.a.afx((String)localObject2);
    if (localObject2 != null)
    {
      ((PhoneItem)localObject2).tGO = true;
      localArrayList.add(localObject2);
    }
    localObject1 = ((JSONObject)localObject1).optJSONArray("custom_phone_list");
    int k;
    if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
    {
      i = 0;
      k = ((JSONArray)localObject1).length();
      if (k <= 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      localObject2 = PhoneItem.tGI;
      localObject2 = ((JSONArray)localObject1).getString(i);
      s.s(localObject2, "customPhoneItemsObjArray.getString(i)");
      localObject2 = PhoneItem.a.afx((String)localObject2);
      if (localObject2 != null) {
        localArrayList.add(localObject2);
      }
      if (j >= k)
      {
        if (paramr != null)
        {
          Boolean localBoolean = Boolean.TRUE;
          eul localeul = paramdeh.aaJO;
          eq localeq = paramdeh.aaAr;
          localObject2 = paramdeh.aaJD;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          paramr.a(localBoolean, "", localArrayList, new d.b(localeul, localeq, (String)localObject1, paramdeh.aaAs));
        }
        paramr = ah.aiuX;
        AppMethodBeat.o(318960);
        return paramr;
      }
      i = j;
    }
  }
  
  private static final void a(r paramr, Object paramObject)
  {
    AppMethodBeat.i(318967);
    Log.e("Luggage.FULL.CgiPhoneNumber", "getPhoneNumber fail");
    if ((paramObject instanceof Exception)) {
      Log.e("Luggage.FULL.CgiPhoneNumber", s.X("CgiGetAllPhone ", ((Exception)paramObject).getMessage()));
    }
    if (paramr != null) {
      paramr.a(Boolean.FALSE, "cgi fail", null, null);
    }
    AppMethodBeat.o(318967);
  }
  
  private static String aO(String paramString, boolean paramBoolean)
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
      s.s(paramString, "jsonStringer.toString()");
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
  
  public final void b(r<? super Boolean, ? super String, ? super List<PhoneItem>, ? super d.b, ah> paramr)
  {
    AppMethodBeat.i(148027);
    Object localObject = aO(this.efV, this.tGd);
    deg localdeg = new deg();
    localdeg.oOI = this.appId;
    Charset localCharset = kotlin.n.d.UTF_8;
    if (localObject == null)
    {
      paramr = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(148027);
      throw paramr;
    }
    localObject = ((String)localObject).getBytes(localCharset);
    s.s(localObject, "(this as java.lang.String).getBytes(charset)");
    localdeg.vgA = new b((byte[])localObject);
    ((com.tencent.mm.plugin.appbrand.networking.c)e.T(com.tencent.mm.plugin.appbrand.networking.c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", (a)localdeg, deh.class).c(new d..ExternalSyntheticLambda0(paramr)).a(new d..ExternalSyntheticLambda1(paramr));
    AppMethodBeat.o(148027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.d
 * JD-Core Version:    0.7.0.1
 */