package com.tencent.mm.plugin.game.luggage.c.a;

import com.tencent.luggage.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.ipc.AddShortcutTask;
import org.json.JSONObject;

final class d$1$1
  extends c
{
  d$1$1(d.1 param1) {}
  
  public final String name()
  {
    return "onAddShortcutStatus";
  }
  
  public final JSONObject tY()
  {
    AppMethodBeat.i(135897);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("success", this.nkc.njZ.success);
      label30:
      AppMethodBeat.o(135897);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label30;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.d.1.1
 * JD-Core Version:    0.7.0.1
 */