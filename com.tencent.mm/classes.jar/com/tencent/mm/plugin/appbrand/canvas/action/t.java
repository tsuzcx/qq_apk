package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontStyleActionArg;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;

public final class t
  implements d
{
  private static boolean b(com.tencent.mm.plugin.appbrand.canvas.d paramd, String paramString)
  {
    AppMethodBeat.i(144927);
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
      AppMethodBeat.o(144927);
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
      paramd.nTw.zp(2);
      paramd.nTx.zp(2);
      continue;
      paramd.nTw.zp(2);
      paramd.nTx.zp(2);
      continue;
      paramd.nTw.zp(0);
      paramd.nTx.zp(0);
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144928);
    paramCanvas = (SetFontStyleActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(144928);
      return false;
    }
    boolean bool = b(paramd, paramCanvas.fontStyle);
    AppMethodBeat.o(144928);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144926);
    if (paramJSONArray.length() == 0)
    {
      AppMethodBeat.o(144926);
      return false;
    }
    try
    {
      paramCanvas = paramJSONArray.getString(0);
      boolean bool = b(paramd, paramCanvas);
      AppMethodBeat.o(144926);
      return bool;
    }
    catch (JSONException paramd)
    {
      Log.i("MicroMsg.SetFontStyle", "get 'fontStyle' error.");
      AppMethodBeat.o(144926);
    }
    return false;
  }
  
  public final BaseDrawActionArg bKy()
  {
    AppMethodBeat.i(144925);
    SetFontStyleActionArg localSetFontStyleActionArg = new SetFontStyleActionArg();
    AppMethodBeat.o(144925);
    return localSetFontStyleActionArg;
  }
  
  public final String getMethod()
  {
    return "setFontStyle";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.t
 * JD-Core Version:    0.7.0.1
 */