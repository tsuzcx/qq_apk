package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class d
  extends a
{
  public static final int CTRL_INDEX = 39;
  public static final String NAME = "getNetworkType";
  
  public static d.a cM(Context paramContext)
  {
    AppMethodBeat.i(126412);
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null)
      {
        paramContext = d.a.iaO;
        AppMethodBeat.o(126412);
        return paramContext;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext == null) || (!paramContext.isConnected()))
      {
        paramContext = d.a.iaJ;
        AppMethodBeat.o(126412);
        return paramContext;
      }
      if (paramContext.getType() == 1)
      {
        paramContext = d.a.iaN;
        AppMethodBeat.o(126412);
        return paramContext;
      }
      if ((paramContext.getSubtype() == 2) || (paramContext.getSubtype() == 1) || (paramContext.getSubtype() == 4))
      {
        paramContext = d.a.iaK;
        AppMethodBeat.o(126412);
        return paramContext;
      }
      if ((paramContext.getSubtype() >= 5) && (paramContext.getSubtype() < 13))
      {
        paramContext = d.a.iaL;
        AppMethodBeat.o(126412);
        return paramContext;
      }
      if (paramContext.getSubtype() >= 13)
      {
        paramContext = d.a.iaM;
        AppMethodBeat.o(126412);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      com.tencent.luggage.g.d.printErrStackTrace("MicroMsg.JsApiGetNetworkType", paramContext, "", new Object[0]);
      paramContext = d.a.iaO;
      AppMethodBeat.o(126412);
    }
    return paramContext;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(126410);
    paramJSONObject = new HashMap();
    paramJSONObject.put("networkType", x(paramc).value);
    paramc.h(paramInt, j("ok", paramJSONObject));
    AppMethodBeat.o(126410);
  }
  
  protected d.a x(c paramc)
  {
    AppMethodBeat.i(126411);
    paramc = cM(paramc.getContext());
    AppMethodBeat.o(126411);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.d
 * JD-Core Version:    0.7.0.1
 */