package com.tencent.mm.plugin.address.e;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.j.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public static String a(b paramb)
  {
    AppMethodBeat.i(17014);
    JSONObject localJSONObject = new JSONObject();
    if (paramb == null)
    {
      paramb = localJSONObject.toString();
      AppMethodBeat.o(17014);
      return paramb;
    }
    try
    {
      localJSONObject.put("type", paramb.type);
      if ((paramb.type != null) && (paramb.type.equals("1")))
      {
        localJSONObject.put("title", paramb.nLn);
        localJSONObject.put("taxNumber", "");
        localJSONObject.put("companyAddress", "");
        localJSONObject.put("telephone", "");
        localJSONObject.put("bankName", "");
        localJSONObject.put("bankAccount", "");
      }
      for (;;)
      {
        paramb = localJSONObject.toString();
        AppMethodBeat.o(17014);
        return paramb;
        localJSONObject.put("title", paramb.title);
        if (paramb.nLo == null) {
          break;
        }
        localJSONObject.put("taxNumber", paramb.nLo);
        if (paramb.nLu == null) {
          break label268;
        }
        localJSONObject.put("companyAddress", paramb.nLu);
        if (paramb.nLs == null) {
          break label280;
        }
        localJSONObject.put("telephone", paramb.nLs);
        if (paramb.nLq == null) {
          break label292;
        }
        localJSONObject.put("bankName", paramb.nLq);
        if (paramb.nLp == null) {
          break label304;
        }
        localJSONObject.put("bankAccount", paramb.nLp);
      }
    }
    catch (JSONException paramb)
    {
      for (;;)
      {
        ab.e("MicroMsg.InvoiceUtil", "put json value error : %s", new Object[] { Log.getStackTraceString(paramb) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.e.e
 * JD-Core Version:    0.7.0.1
 */