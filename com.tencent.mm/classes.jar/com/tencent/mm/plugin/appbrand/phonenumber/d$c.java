package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.a.r;
import a.f.b.j;
import a.l;
import a.v;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.axz;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "callback"})
final class d$c
  implements b.a
{
  d$c(r paramr) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(143923);
    d.i("MicroMsg.GetAllPhone", "getPhoneNumber errType:" + paramInt1 + ',' + " errCode:" + paramInt2 + ", errMsg:" + paramString);
    Object localObject1;
    Object localObject2;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      j.p(paramb, "rr");
      paramb = paramb.adn();
      if (paramb == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.JSOperateWxDataResponse");
        AppMethodBeat.o(143923);
        throw paramString;
      }
      localObject1 = (axz)paramb;
      paramInt1 = ((axz)localObject1).xmS.csV;
      paramb = ((axz)localObject1).xmS.csW;
      if (paramInt1 != 0)
      {
        d.e("MicroMsg.GetAllPhone", "jsErrcode:" + paramInt1 + ", jsErrmsg:" + paramb);
        localObject1 = this.iCH;
        if (localObject1 != null)
        {
          localObject2 = Boolean.FALSE;
          if (paramb != null) {
            break label475;
          }
        }
      }
    }
    label475:
    for (paramString = "";; paramString = paramb)
    {
      ((r)localObject1).a(localObject2, paramString, null, null);
      AppMethodBeat.o(143923);
      return;
      AppMethodBeat.o(143923);
      return;
      paramb = new JSONObject(((axz)localObject1).jJh.dqj());
      localObject2 = new ArrayList();
      Object localObject3 = PhoneItem.iDu;
      localObject3 = paramb.optString("wx_phone");
      j.p(localObject3, "phoneItemsJsonObj.optString(\"wx_phone\")");
      localObject3 = PhoneItem.a.EB((String)localObject3);
      if (localObject3 != null)
      {
        ((PhoneItem)localObject3).iDs = true;
        ((ArrayList)localObject2).add(localObject3);
      }
      paramb = paramb.optJSONArray("custom_phone_list");
      if ((paramb != null) && (paramb.length() > 0))
      {
        paramInt1 = 0;
        paramInt2 = paramb.length() - 1;
        if (paramInt2 >= 0) {
          for (;;)
          {
            localObject3 = PhoneItem.iDu;
            localObject3 = paramb.getString(paramInt1);
            j.p(localObject3, "customPhoneItemsObjArray.getString(i)");
            localObject3 = PhoneItem.a.EB((String)localObject3);
            if (localObject3 != null) {
              ((ArrayList)localObject2).add(localObject3);
            }
            if (paramInt1 == paramInt2) {
              break;
            }
            paramInt1 += 1;
          }
        }
      }
      localObject3 = this.iCH;
      if (localObject3 != null)
      {
        Boolean localBoolean = Boolean.TRUE;
        paramb = paramString;
        if (paramString == null) {
          paramb = "";
        }
        ((r)localObject3).a(localBoolean, paramb, localObject2, ((axz)localObject1).xnd);
        AppMethodBeat.o(143923);
        return;
      }
      AppMethodBeat.o(143923);
      return;
      localObject1 = this.iCH;
      if (localObject1 != null)
      {
        localObject2 = Boolean.FALSE;
        paramb = paramString;
        if (paramString == null) {
          paramb = "";
        }
        ((r)localObject1).a(localObject2, paramb, null, null);
        AppMethodBeat.o(143923);
        return;
      }
      AppMethodBeat.o(143923);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.d.c
 * JD-Core Version:    0.7.0.1
 */