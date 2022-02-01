package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.sdk.platformtools.Log;
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
    AppMethodBeat.i(144949);
    if (paramJSONArray.length() == 0)
    {
      AppMethodBeat.o(144949);
      return false;
    }
    try
    {
      i.v(paramJSONArray);
      AppMethodBeat.o(144949);
      return false;
    }
    catch (JSONException paramd)
    {
      for (;;)
      {
        Log.i("MicroMsg.SetLineHeight", "get 'lineHeight' error");
      }
    }
  }
  
  public final BaseDrawActionArg cjY()
  {
    return null;
  }
  
  public final String getMethod()
  {
    return "setLineHeight";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.z
 * JD-Core Version:    0.7.0.1
 */