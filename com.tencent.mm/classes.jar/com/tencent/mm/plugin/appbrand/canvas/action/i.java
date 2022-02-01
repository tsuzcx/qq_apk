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
import org.json.JSONArray;

public final class i
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(144885);
    Paint.FontMetrics localFontMetrics = paramd.qTi.getFontMetrics();
    float f;
    if (paramd.qTi.qUd == a.a.qUk)
    {
      f = paramFloat2 + Math.abs(localFontMetrics.ascent);
      paramd = paramd.qTi;
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
      AppMethodBeat.o(144885);
      return true;
      if (paramd.qTi.qUd == a.a.qUm)
      {
        f = paramFloat2 + Math.abs((-localFontMetrics.ascent + localFontMetrics.descent) / 2.0F - localFontMetrics.descent);
        break;
      }
      f = paramFloat2;
      if (paramd.qTi.qUd != a.a.qUl) {
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
    AppMethodBeat.i(144886);
    paramDrawActionArg = (DrawTextActionArg)paramDrawActionArg;
    if (paramDrawActionArg == null)
    {
      AppMethodBeat.o(144886);
      return false;
    }
    boolean bool = a(paramd, paramCanvas, paramDrawActionArg.text, paramDrawActionArg.x, paramDrawActionArg.y, paramDrawActionArg.maxWidth);
    AppMethodBeat.o(144886);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144884);
    if (paramJSONArray.length() < 3)
    {
      AppMethodBeat.o(144884);
      return false;
    }
    boolean bool = a(paramd, paramCanvas, paramJSONArray.optString(0), com.tencent.mm.plugin.appbrand.af.i.f(paramJSONArray, 1), com.tencent.mm.plugin.appbrand.af.i.f(paramJSONArray, 2), com.tencent.mm.plugin.appbrand.af.i.f(paramJSONArray, 3));
    AppMethodBeat.o(144884);
    return bool;
  }
  
  public final BaseDrawActionArg cjY()
  {
    AppMethodBeat.i(144883);
    DrawTextActionArg localDrawTextActionArg = new DrawTextActionArg();
    AppMethodBeat.o(144883);
    return localDrawTextActionArg;
  }
  
  public final String getMethod()
  {
    return "strokeText";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.i
 * JD-Core Version:    0.7.0.1
 */