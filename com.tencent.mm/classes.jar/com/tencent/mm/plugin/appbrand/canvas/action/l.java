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
import com.tencent.mm.plugin.appbrand.s.g;
import org.json.JSONArray;

public final class l
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(103214);
    Paint.FontMetrics localFontMetrics = paramd.heB.getFontMetrics();
    float f;
    if (paramd.heB.hfC == a.a.hfJ)
    {
      f = paramFloat2 + Math.abs(localFontMetrics.ascent);
      paramd = paramd.heC;
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
      AppMethodBeat.o(103214);
      return true;
      if (paramd.heB.hfC == a.a.hfL)
      {
        f = paramFloat2 + Math.abs((-localFontMetrics.ascent + localFontMetrics.descent) / 2.0F - localFontMetrics.descent);
        break;
      }
      f = paramFloat2;
      if (paramd.heB.hfC != a.a.hfK) {
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
    AppMethodBeat.i(103215);
    paramDrawActionArg = (DrawTextActionArg)paramDrawActionArg;
    if (paramDrawActionArg == null)
    {
      AppMethodBeat.o(103215);
      return false;
    }
    boolean bool = a(paramd, paramCanvas, paramDrawActionArg.text, paramDrawActionArg.x, paramDrawActionArg.y, paramDrawActionArg.maxWidth);
    AppMethodBeat.o(103215);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103213);
    if (paramJSONArray.length() < 3)
    {
      AppMethodBeat.o(103213);
      return false;
    }
    boolean bool = a(paramd, paramCanvas, paramJSONArray.optString(0), g.d(paramJSONArray, 1), g.d(paramJSONArray, 2), g.d(paramJSONArray, 3));
    AppMethodBeat.o(103213);
    return bool;
  }
  
  public final BaseDrawActionArg axW()
  {
    AppMethodBeat.i(103212);
    DrawTextActionArg localDrawTextActionArg = new DrawTextActionArg();
    AppMethodBeat.o(103212);
    return localDrawTextActionArg;
  }
  
  public final String getMethod()
  {
    return "fillText";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.l
 * JD-Core Version:    0.7.0.1
 */