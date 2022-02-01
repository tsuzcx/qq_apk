package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.czi;
import org.json.JSONObject;

public final class bk
{
  public czi Kvd;
  
  public static bk bz(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(283987);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(283987);
      return null;
    }
    bk localbk = new bk();
    localbk.Kvd = ae.bx(paramJSONObject);
    AppMethodBeat.o(283987);
    return localbk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.bk
 * JD-Core Version:    0.7.0.1
 */