package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.a.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawTextActionArg;
import com.tencent.mm.plugin.appbrand.z.g;
import org.json.JSONArray;

public final class l
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(144897);
    Paint.FontMetrics localFontMetrics = paramd.jzb.getFontMetrics();
    float f;
    if (paramd.jzb.jAa == a.a.jAh)
    {
      f = paramFloat2 + Math.abs(localFontMetrics.ascent);
      paramd = paramd.jzc;
      paramFloat2 = paramd.measureText(paramString);
      if ((paramFloat3 <= 0.0F) || (paramFloat3 >= paramFloat2)) {
        break label189;
      }
      paramCanvas.save();
      paramFloat2 = paramFloat3 / paramFloat2;
      paramCanvas.translate(paramFloat1, f);
      paramCanvas.scale(paramFloat2, 1.0F);
      paramCanvas.drawText(paramString, 0.0F, 0.0F, paramd);
      paramCanvas.restore();
    }
    for (;;)
    {
      AppMethodBeat.o(144897);
      return true;
      if (paramd.jzb.jAa == a.a.jAj)
      {
        f = paramFloat2 + Math.abs((-localFontMetrics.ascent + localFontMetrics.descent) / 2.0F - localFontMetrics.descent);
        break;
      }
      f = paramFloat2;
      if (paramd.jzb.jAa != a.a.jAi) {
        break;
      }
      f = paramFloat2 - Math.abs(localFontMetrics.descent);
      break;
      label189:
      paramCanvas.drawText(paramString, paramFloat1, f, paramd);
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144898);
    paramDrawActionArg = (DrawTextActionArg)paramDrawActionArg;
    if (paramDrawActionArg == null)
    {
      AppMethodBeat.o(144898);
      return false;
    }
    boolean bool = a(paramd, paramCanvas, paramDrawActionArg.text, paramDrawActionArg.x, paramDrawActionArg.y, paramDrawActionArg.maxWidth);
    AppMethodBeat.o(144898);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144896);
    if (paramJSONArray.length() < 3)
    {
      AppMethodBeat.o(144896);
      return false;
    }
    boolean bool = a(paramd, paramCanvas, paramJSONArray.optString(0), g.f(paramJSONArray, 1), g.f(paramJSONArray, 2), g.f(paramJSONArray, 3));
    AppMethodBeat.o(144896);
    return bool;
  }
  
  public final BaseDrawActionArg aZO()
  {
    AppMethodBeat.i(144895);
    DrawTextActionArg localDrawTextActionArg = new DrawTextActionArg();
    AppMethodBeat.o(144895);
    return localDrawTextActionArg;
  }
  
  public final String getMethod()
  {
    return "fillText";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.l
 * JD-Core Version:    0.7.0.1
 */