package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.s.g;
import org.json.JSONArray;
import org.json.JSONException;

@Deprecated
public final class z
  implements d
{
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    return false;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103266);
    if (paramJSONArray.length() == 0)
    {
      AppMethodBeat.o(103266);
      return false;
    }
    try
    {
      g.p(paramJSONArray);
      AppMethodBeat.o(103266);
      return false;
    }
    catch (JSONException paramd)
    {
      for (;;)
      {
        com.tencent.luggage.g.d.i("MicroMsg.SetLineHeight", "get 'lineHeight' error");
      }
    }
  }
  
  public final BaseDrawActionArg axW()
  {
    return null;
  }
  
  public final String getMethod()
  {
    return "setLineHeight";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.z
 * JD-Core Version:    0.7.0.1
 */