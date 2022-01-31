package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontFamilyActionArg;
import org.json.JSONArray;
import org.json.JSONException;

public final class r
  implements d
{
  private static boolean b(com.tencent.mm.plugin.appbrand.canvas.d paramd, String paramString)
  {
    AppMethodBeat.i(103236);
    if (!TextUtils.isEmpty(paramString))
    {
      paramd.heB.zD(paramString);
      paramd.heC.zD(paramString);
      AppMethodBeat.o(103236);
      return true;
    }
    AppMethodBeat.o(103236);
    return false;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(103237);
    paramCanvas = (SetFontFamilyActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(103237);
      return false;
    }
    boolean bool = b(paramd, paramCanvas.aWz);
    AppMethodBeat.o(103237);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103235);
    if (paramJSONArray.length() == 0)
    {
      AppMethodBeat.o(103235);
      return false;
    }
    try
    {
      paramCanvas = paramJSONArray.getString(0);
      boolean bool = b(paramd, paramCanvas);
      AppMethodBeat.o(103235);
      return bool;
    }
    catch (JSONException paramd)
    {
      com.tencent.luggage.g.d.i("MicroMsg.SetFontFamily", "get 'fontFamily' error.");
      AppMethodBeat.o(103235);
    }
    return false;
  }
  
  public final BaseDrawActionArg axW()
  {
    AppMethodBeat.i(103234);
    SetFontFamilyActionArg localSetFontFamilyActionArg = new SetFontFamilyActionArg();
    AppMethodBeat.o(103234);
    return localSetFontFamilyActionArg;
  }
  
  public final String getMethod()
  {
    return "setFontFamily";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.r
 * JD-Core Version:    0.7.0.1
 */