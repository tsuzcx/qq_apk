package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontStyleActionArg;
import org.json.JSONArray;
import org.json.JSONException;

public final class t
  implements d
{
  private static boolean b(com.tencent.mm.plugin.appbrand.canvas.d paramd, String paramString)
  {
    AppMethodBeat.i(103244);
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
      AppMethodBeat.o(103244);
      return true;
      if (!paramString.equals("oblique")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("italic")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("normal")) {
        break;
      }
      i = 2;
      break;
      paramd.heB.ny(2);
      paramd.heC.ny(2);
      continue;
      paramd.heB.ny(2);
      paramd.heC.ny(2);
      continue;
      paramd.heB.ny(0);
      paramd.heC.ny(0);
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(103245);
    paramCanvas = (SetFontStyleActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(103245);
      return false;
    }
    boolean bool = b(paramd, paramCanvas.hfc);
    AppMethodBeat.o(103245);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103243);
    if (paramJSONArray.length() == 0)
    {
      AppMethodBeat.o(103243);
      return false;
    }
    try
    {
      paramCanvas = paramJSONArray.getString(0);
      boolean bool = b(paramd, paramCanvas);
      AppMethodBeat.o(103243);
      return bool;
    }
    catch (JSONException paramd)
    {
      com.tencent.luggage.g.d.i("MicroMsg.SetFontStyle", "get 'fontStyle' error.");
      AppMethodBeat.o(103243);
    }
    return false;
  }
  
  public final BaseDrawActionArg axW()
  {
    AppMethodBeat.i(103242);
    SetFontStyleActionArg localSetFontStyleActionArg = new SetFontStyleActionArg();
    AppMethodBeat.o(103242);
    return localSetFontStyleActionArg;
  }
  
  public final String getMethod()
  {
    return "setFontStyle";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.t
 * JD-Core Version:    0.7.0.1
 */