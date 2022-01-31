package com.tencent.mm.plugin.game.luggage.c.a;

import com.tencent.luggage.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bcz;
import org.json.JSONObject;

final class e$1
  extends c
{
  e$1(e parame, bcz parambcz) {}
  
  public final String name()
  {
    return "onCustomGameMenuClicked";
  }
  
  public final JSONObject tY()
  {
    AppMethodBeat.i(135902);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("itemId", this.nkd.xsZ);
      AppMethodBeat.o(135902);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(135902);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.e.1
 * JD-Core Version:    0.7.0.1
 */