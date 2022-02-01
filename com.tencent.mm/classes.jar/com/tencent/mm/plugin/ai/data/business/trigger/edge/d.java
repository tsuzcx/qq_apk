package com.tencent.mm.plugin.ai.data.business.trigger.edge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

final class d
{
  String qnP;
  String qnQ;
  long qnR;
  String qnS;
  
  final JSONObject TP(String paramString)
  {
    AppMethodBeat.i(267683);
    this.qnS = "";
    try
    {
      paramString = new JSONObject(paramString);
      this.qnP = paramString.optString("url", "");
      this.qnQ = paramString.optString("md5", "");
      this.qnR = paramString.optLong("freq", 300000L);
      AppMethodBeat.o(267683);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(267683);
    }
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(267689);
    String str = "EdgeJsConfig{edgeUrl='" + this.qnP + '\'' + ", edgeMd5='" + this.qnQ + '\'' + ", edgeFreq=" + this.qnR + ", edgeJs='" + this.qnS + '\'' + '}';
    AppMethodBeat.o(267689);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.edge.d
 * JD-Core Version:    0.7.0.1
 */