package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTextBaseLineActionArg;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;

public final class ah
  implements d
{
  private static boolean b(com.tencent.mm.plugin.appbrand.canvas.d paramd, String paramString)
  {
    AppMethodBeat.i(144979);
    Log.i("MicroMsg.SetTextBaselineAction", "SetTextBaselineAction, align:%s", new Object[] { paramString });
    if ("top".equalsIgnoreCase(paramString))
    {
      paramd.qTi.qUd = a.a.qUk;
      paramd.qTj.qUd = a.a.qUk;
    }
    for (;;)
    {
      AppMethodBeat.o(144979);
      return true;
      if ("middle".equalsIgnoreCase(paramString))
      {
        paramd.qTi.qUd = a.a.qUm;
        paramd.qTj.qUd = a.a.qUm;
      }
      else if ("bottom".equalsIgnoreCase(paramString))
      {
        paramd.qTi.qUd = a.a.qUl;
        paramd.qTj.qUd = a.a.qUl;
      }
      else if ("normal".equalsIgnoreCase(paramString))
      {
        paramd.qTi.qUd = a.a.qUj;
        paramd.qTj.qUd = a.a.qUj;
      }
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144980);
    paramCanvas = (SetTextBaseLineActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(144980);
      return false;
    }
    boolean bool = b(paramd, paramCanvas.qTN);
    AppMethodBeat.o(144980);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144978);
    if (paramJSONArray.length() <= 0)
    {
      AppMethodBeat.o(144978);
      return false;
    }
    boolean bool = b(paramd, paramJSONArray.optString(0));
    AppMethodBeat.o(144978);
    return bool;
  }
  
  public final BaseDrawActionArg cjY()
  {
    AppMethodBeat.i(144977);
    SetTextBaseLineActionArg localSetTextBaseLineActionArg = new SetTextBaseLineActionArg();
    AppMethodBeat.o(144977);
    return localSetTextBaseLineActionArg;
  }
  
  public final String getMethod()
  {
    return "setTextBaseline";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.ah
 * JD-Core Version:    0.7.0.1
 */