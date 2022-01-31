package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontWeightArg;
import org.json.JSONArray;
import org.json.JSONException;

public final class u
  implements d
{
  private static boolean b(com.tencent.mm.plugin.appbrand.canvas.d paramd, String paramString)
  {
    AppMethodBeat.i(103248);
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(103248);
      return true;
      if (!paramString.equals("bold")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("normal")) {
        break;
      }
      i = 1;
      break;
      paramd.heB.setFakeBoldText(true);
      paramd.heC.setFakeBoldText(true);
      continue;
      paramd.heB.setFakeBoldText(false);
      paramd.heC.setFakeBoldText(false);
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(103249);
    paramCanvas = (SetFontWeightArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(103249);
      return false;
    }
    boolean bool = b(paramd, paramCanvas.hfd);
    AppMethodBeat.o(103249);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103247);
    if (paramJSONArray.length() == 0)
    {
      AppMethodBeat.o(103247);
      return false;
    }
    try
    {
      paramCanvas = paramJSONArray.getString(0);
      boolean bool = b(paramd, paramCanvas);
      AppMethodBeat.o(103247);
      return bool;
    }
    catch (JSONException paramd)
    {
      com.tencent.luggage.g.d.i("MicroMsg.SetFontWeight", "get 'fontWeight' error.");
      AppMethodBeat.o(103247);
    }
    return false;
  }
  
  public final BaseDrawActionArg axW()
  {
    AppMethodBeat.i(103246);
    SetFontWeightArg localSetFontWeightArg = new SetFontWeightArg();
    AppMethodBeat.o(103246);
    return localSetFontWeightArg;
  }
  
  public final String getMethod()
  {
    return "setFontWeight";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.u
 * JD-Core Version:    0.7.0.1
 */