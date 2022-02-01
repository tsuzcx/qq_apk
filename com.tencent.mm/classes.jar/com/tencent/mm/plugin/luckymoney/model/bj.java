package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cjf;
import org.json.JSONObject;

public final class bj
{
  public cjf ECc;
  
  public static bj bj(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(269352);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(269352);
      return null;
    }
    bj localbj = new bj();
    localbj.ECc = ad.bi(paramJSONObject);
    AppMethodBeat.o(269352);
    return localbj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.bj
 * JD-Core Version:    0.7.0.1
 */