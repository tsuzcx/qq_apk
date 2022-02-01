package com.tencent.mm.plugin.luckymoney.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.aj;
import org.json.JSONObject;

public final class a
  extends aj
{
  public final String drI()
  {
    return "/cgi-bin/mmpay-bin/cfrequestwxhb";
  }
  
  public final int drJ()
  {
    return 0;
  }
  
  public final int getType()
  {
    return 1639;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(283869);
    paramJSONObject.optString("sendId");
    AppMethodBeat.o(283869);
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.a
 * JD-Core Version:    0.7.0.1
 */