package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontFamilyActionArg;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONArray;
import org.json.JSONException;

public final class r
  implements d
{
  private static boolean b(com.tencent.mm.plugin.appbrand.canvas.d paramd, String paramString)
  {
    AppMethodBeat.i(144919);
    if (!TextUtils.isEmpty(paramString))
    {
      paramd.jSY.MQ(paramString);
      paramd.jSZ.MQ(paramString);
      AppMethodBeat.o(144919);
      return true;
    }
    AppMethodBeat.o(144919);
    return false;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144920);
    paramCanvas = (SetFontFamilyActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(144920);
      return false;
    }
    boolean bool = b(paramd, paramCanvas.fontFamily);
    AppMethodBeat.o(144920);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144918);
    if (paramJSONArray.length() == 0)
    {
      AppMethodBeat.o(144918);
      return false;
    }
    try
    {
      paramCanvas = paramJSONArray.getString(0);
      boolean bool = b(paramd, paramCanvas);
      AppMethodBeat.o(144918);
      return bool;
    }
    catch (JSONException paramd)
    {
      ad.i("MicroMsg.SetFontFamily", "get 'fontFamily' error.");
      AppMethodBeat.o(144918);
    }
    return false;
  }
  
  public final BaseDrawActionArg bdn()
  {
    AppMethodBeat.i(144917);
    SetFontFamilyActionArg localSetFontFamilyActionArg = new SetFontFamilyActionArg();
    AppMethodBeat.o(144917);
    return localSetFontFamilyActionArg;
  }
  
  public final String getMethod()
  {
    return "setFontFamily";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.r
 * JD-Core Version:    0.7.0.1
 */