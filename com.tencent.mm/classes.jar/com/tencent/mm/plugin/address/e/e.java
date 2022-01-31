package com.tencent.mm.plugin.address.e;

import android.util.Log;
import com.tencent.mm.plugin.o.a.b;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public static String a(b paramb)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramb == null) {
      return localJSONObject.toString();
    }
    try
    {
      localJSONObject.put("type", paramb.type);
      if ((paramb.type != null) && (paramb.type.equals("1")))
      {
        localJSONObject.put("title", paramb.lnQ);
        localJSONObject.put("taxNumber", "");
        localJSONObject.put("companyAddress", "");
        localJSONObject.put("telephone", "");
        localJSONObject.put("bankName", "");
        localJSONObject.put("bankAccount", "");
      }
      for (;;)
      {
        return localJSONObject.toString();
        localJSONObject.put("title", paramb.title);
        if (paramb.lnR == null) {
          break;
        }
        localJSONObject.put("taxNumber", paramb.lnR);
        if (paramb.lnX == null) {
          break label246;
        }
        localJSONObject.put("companyAddress", paramb.lnX);
        if (paramb.lnV == null) {
          break label258;
        }
        localJSONObject.put("telephone", paramb.lnV);
        if (paramb.lnT == null) {
          break label270;
        }
        localJSONObject.put("bankName", paramb.lnT);
        if (paramb.lnS == null) {
          break label282;
        }
        localJSONObject.put("bankAccount", paramb.lnS);
      }
    }
    catch (JSONException paramb)
    {
      for (;;)
      {
        y.e("MicroMsg.InvoiceUtil", "put json value error : %s", new Object[] { Log.getStackTraceString(paramb) });
        continue;
        localJSONObject.put("taxNumber", "");
        continue;
        label246:
        localJSONObject.put("companyAddress", "");
        continue;
        label258:
        localJSONObject.put("telephone", "");
        continue;
        label270:
        localJSONObject.put("bankName", "");
        continue;
        label282:
        localJSONObject.put("bankAccount", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.e.e
 * JD-Core Version:    0.7.0.1
 */