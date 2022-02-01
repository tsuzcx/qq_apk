package com.tencent.mm.cs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/xmltojson/XmlToJsonUtil;", "", "()V", "Companion", "libcompatible_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final a agZu;
  
  static
  {
    AppMethodBeat.i(231609);
    agZu = new a((byte)0);
    AppMethodBeat.o(231609);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/xmltojson/XmlToJsonUtil$Companion;", "", "()V", "ANONYMITY_ARRAY_TAG", "", "ATTRIBUTE_PREFIX_TAG", "CDATA_TAG", "TAG", "toJson", "Lorg/json/JSONObject;", "xml", "toXml", "jsonObj", "libcompatible_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static JSONObject bFf(String paramString)
    {
      AppMethodBeat.i(231604);
      s.u(paramString, "xml");
      try
      {
        paramString = new JSONObject(h.bFd(paramString).toString());
        AppMethodBeat.o(231604);
        return paramString;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Json.XmlToJsonUtil", (Throwable)paramString, "toJsonString", new Object[0]);
          paramString = null;
        }
      }
    }
    
    public static String cS(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(231607);
      s.u(paramJSONObject, "jsonObj");
      try
      {
        paramJSONObject = h.ca(new c(paramJSONObject.toString()));
        AppMethodBeat.o(231607);
        return paramJSONObject;
      }
      catch (Exception paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.Json.XmlToJsonUtil", (Throwable)paramJSONObject, "toXml", new Object[0]);
        AppMethodBeat.o(231607);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cs.l
 * JD-Core Version:    0.7.0.1
 */