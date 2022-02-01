package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTextBaseLineActionArg;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONArray;

public final class ah
  implements d
{
  private static boolean b(com.tencent.mm.plugin.appbrand.canvas.d paramd, String paramString)
  {
    AppMethodBeat.i(144979);
    ad.i("MicroMsg.SetTextBaselineAction", "SetTextBaselineAction, align:%s", new Object[] { paramString });
    if ("top".equalsIgnoreCase(paramString))
    {
      paramd.jSY.jTV = a.a.jUc;
      paramd.jSZ.jTV = a.a.jUc;
    }
    for (;;)
    {
      AppMethodBeat.o(144979);
      return true;
      if ("middle".equalsIgnoreCase(paramString))
      {
        paramd.jSY.jTV = a.a.jUe;
        paramd.jSZ.jTV = a.a.jUe;
      }
      else if ("bottom".equalsIgnoreCase(paramString))
      {
        paramd.jSY.jTV = a.a.jUd;
        paramd.jSZ.jTV = a.a.jUd;
      }
      else if ("normal".equalsIgnoreCase(paramString))
      {
        paramd.jSY.jTV = a.a.jUb;
        paramd.jSZ.jTV = a.a.jUb;
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
    boolean bool = b(paramd, paramCanvas.jTE);
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
  
  public final BaseDrawActionArg bdn()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.ah
 * JD-Core Version:    0.7.0.1
 */