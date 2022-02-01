package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cbe;
import org.json.JSONObject;

public final class bi
{
  public cbe yXW;
  
  public static bi bc(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(213333);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(213333);
      return null;
    }
    bi localbi = new bi();
    localbi.yXW = ac.bb(paramJSONObject);
    AppMethodBeat.o(213333);
    return localbi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.bi
 * JD-Core Version:    0.7.0.1
 */