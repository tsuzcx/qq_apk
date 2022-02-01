package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontWeightArg;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;

public final class u
  implements d
{
  private static boolean b(com.tencent.mm.plugin.appbrand.canvas.d paramd, String paramString)
  {
    AppMethodBeat.i(144931);
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
      AppMethodBeat.o(144931);
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
      paramd.nTw.setFakeBoldText(true);
      paramd.nTx.setFakeBoldText(true);
      continue;
      paramd.nTw.setFakeBoldText(false);
      paramd.nTx.setFakeBoldText(false);
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144932);
    paramCanvas = (SetFontWeightArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(144932);
      return false;
    }
    boolean bool = b(paramd, paramCanvas.cOk);
    AppMethodBeat.o(144932);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144930);
    if (paramJSONArray.length() == 0)
    {
      AppMethodBeat.o(144930);
      return false;
    }
    try
    {
      paramCanvas = paramJSONArray.getString(0);
      boolean bool = b(paramd, paramCanvas);
      AppMethodBeat.o(144930);
      return bool;
    }
    catch (JSONException paramd)
    {
      Log.i("MicroMsg.SetFontWeight", "get 'fontWeight' error.");
      AppMethodBeat.o(144930);
    }
    return false;
  }
  
  public final BaseDrawActionArg bKy()
  {
    AppMethodBeat.i(144929);
    SetFontWeightArg localSetFontWeightArg = new SetFontWeightArg();
    AppMethodBeat.o(144929);
    return localSetFontWeightArg;
  }
  
  public final String getMethod()
  {
    return "setFontWeight";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.u
 * JD-Core Version:    0.7.0.1
 */