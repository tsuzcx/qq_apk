package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetGlobalAlphaActionArg;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;

public final class v
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, int paramInt)
  {
    AppMethodBeat.i(144935);
    paramd.nTw.aG(paramInt / 255.0F);
    paramd.nTx.aG(paramInt / 255.0F);
    AppMethodBeat.o(144935);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144936);
    paramCanvas = (SetGlobalAlphaActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(144936);
      return false;
    }
    boolean bool = a(paramd, paramCanvas.alpha);
    AppMethodBeat.o(144936);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144934);
    try
    {
      int i = paramJSONArray.getInt(0);
      boolean bool = a(paramd, i);
      AppMethodBeat.o(144934);
      return bool;
    }
    catch (JSONException paramd)
    {
      Log.e("MicroMsg.SetGlobalAlphaAction", "getGlobalAlpha value error. exception : %s", new Object[] { paramd });
      AppMethodBeat.o(144934);
    }
    return false;
  }
  
  public final BaseDrawActionArg bKy()
  {
    AppMethodBeat.i(144933);
    SetGlobalAlphaActionArg localSetGlobalAlphaActionArg = new SetGlobalAlphaActionArg();
    AppMethodBeat.o(144933);
    return localSetGlobalAlphaActionArg;
  }
  
  public final String getMethod()
  {
    return "setGlobalAlpha";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.v
 * JD-Core Version:    0.7.0.1
 */