package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.jsapi.file.an;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.t.s;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class j$1$2
  implements a<Void, Void>
{
  j$1$2(j.1 param1) {}
  
  private Void atf()
  {
    AppMethodBeat.i(132143);
    j.c(this.ioK.ioJ);
    Object localObject1 = this.ioK.ioJ;
    AppBrandInitConfigWC localAppBrandInitConfigWC = ((o)localObject1).atS();
    if ((localAppBrandInitConfigWC == null) || (localAppBrandInitConfigWC.hiz == null) || (localAppBrandInitConfigWC.hiz.hiK != 7))
    {
      d.i("MicroMsg.OpenSdkJsApiProcessor", "initConfig is null or lanunchScene is err, return");
      localObject1 = AOo;
      AppMethodBeat.o(132143);
      return localObject1;
    }
    String str1 = localAppBrandInitConfigWC.hiz.hiN;
    d.d("MicroMsg.OpenSdkJsApiProcessor", "openapiInvokeData:%s", new Object[] { str1 });
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    com.tencent.mm.plugin.appbrand.s.j localj;
    label152:
    String str2;
    do
    {
      try
      {
        localJSONObject1 = new JSONObject(str1);
        localJSONObject2 = new JSONObject(localJSONObject1.getString("args"));
        localj = new com.tencent.mm.plugin.appbrand.s.j();
        if (((o)localObject1).wP().a(localj) != com.tencent.mm.plugin.appbrand.appstorage.j.gZA) {
          break;
        }
        Iterator localIterator = localJSONObject2.keys();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label340;
          }
          str2 = (String)localIterator.next();
          localObject2 = localJSONObject2.getString(str2);
          if (!s.Fs((String)localObject2)) {
            break;
          }
          localJSONObject2.put(str2, s.a((o)localObject1, (String)localj.value, (String)localObject2));
        }
      }
      catch (JSONException localJSONException)
      {
        d.b("MicroMsg.OpenSdkJsApiProcessor", "", new Object[] { localJSONException });
      }
    } while (!s.Ft((String)localObject2));
    Object localObject2 = new JSONArray((String)localObject2);
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    for (;;)
    {
      if (i < ((JSONArray)localObject2).length())
      {
        String str3 = ((JSONArray)localObject2).getString(i);
        if (s.Fs(str3)) {
          localJSONArray.put(s.a(localJSONException, (String)localj.value, str3));
        } else {
          localJSONArray.put(str3);
        }
      }
      else
      {
        localJSONObject2.put(str2, localJSONArray.toString());
        break label152;
        label340:
        localJSONObject1.put("args", localJSONObject2.toString());
        localAppBrandInitConfigWC.hiz.hiN = localJSONObject1.toString();
        d.d("MicroMsg.OpenSdkJsApiProcessor", "transfer finish, openapiInvokeData:%s", new Object[] { str1 });
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.j.1.2
 * JD-Core Version:    0.7.0.1
 */