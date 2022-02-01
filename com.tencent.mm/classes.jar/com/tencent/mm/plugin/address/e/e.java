package com.tencent.mm.plugin.address.e;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.j.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public static String a(b paramb)
  {
    AppMethodBeat.i(21057);
    JSONObject localJSONObject = new JSONObject();
    if (paramb == null)
    {
      paramb = localJSONObject.toString();
      AppMethodBeat.o(21057);
      return paramb;
    }
    try
    {
      localJSONObject.put("type", paramb.type);
      if ((paramb.type != null) && (paramb.type.equals("1")))
      {
        localJSONObject.put("title", paramb.tGP);
        localJSONObject.put("taxNumber", "");
        localJSONObject.put("companyAddress", "");
        localJSONObject.put("telephone", "");
        localJSONObject.put("bankName", "");
        localJSONObject.put("bankAccount", "");
      }
      for (;;)
      {
        paramb = localJSONObject.toString();
        AppMethodBeat.o(21057);
        return paramb;
        localJSONObject.put("title", paramb.title);
        if (paramb.tGQ == null) {
          break;
        }
        localJSONObject.put("taxNumber", paramb.tGQ);
        if (paramb.tGW == null) {
          break label268;
        }
        localJSONObject.put("companyAddress", paramb.tGW);
        if (paramb.tGU == null) {
          break label280;
        }
        localJSONObject.put("telephone", paramb.tGU);
        if (paramb.tGS == null) {
          break label292;
        }
        localJSONObject.put("bankName", paramb.tGS);
        if (paramb.tGR == null) {
          break label304;
        }
        localJSONObject.put("bankAccount", paramb.tGR);
      }
    }
    catch (JSONException paramb)
    {
      for (;;)
      {
        ac.e("MicroMsg.InvoiceUtil", "put json value error : %s", new Object[] { Log.getStackTraceString(paramb) });
        continue;
        localJSONObject.put("taxNumber", "");
        continue;
        label268:
        localJSONObject.put("companyAddress", "");
        continue;
        label280:
        localJSONObject.put("telephone", "");
        continue;
        label292:
        localJSONObject.put("bankName", "");
        continue;
        label304:
        localJSONObject.put("bankAccount", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.e.e
 * JD-Core Version:    0.7.0.1
 */