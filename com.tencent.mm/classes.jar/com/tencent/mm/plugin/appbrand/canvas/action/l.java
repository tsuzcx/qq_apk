package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.a.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawTextActionArg;
import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONArray;

public final class l
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Paint.FontMetrics localFontMetrics = paramd.fLp.getFontMetrics();
    float f;
    if (paramd.fLp.fMs == a.a.fMz)
    {
      f = paramFloat2 + Math.abs(localFontMetrics.ascent);
      paramd = paramd.fLq;
      paramFloat2 = paramd.measureText(paramString);
      if ((paramFloat3 <= 0.0F) || (paramFloat3 >= paramFloat2)) {
        break label179;
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
      return true;
      if (paramd.fLp.fMs == a.a.fMB)
      {
        f = paramFloat2 + Math.abs((-localFontMetrics.ascent + localFontMetrics.descent) / 2.0F - localFontMetrics.descent);
        break;
      }
      f = paramFloat2;
      if (paramd.fLp.fMs != a.a.fMA) {
        break;
      }
      f = paramFloat2 - Math.abs(localFontMetrics.descent);
      break;
      label179:
      paramCanvas.drawText(paramString, paramFloat1, f, paramd);
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    paramDrawActionArg = (DrawTextActionArg)paramDrawActionArg;
    if (paramDrawActionArg == null) {
      return false;
    }
    return a(paramd, paramCanvas, paramDrawActionArg.text, paramDrawActionArg.x, paramDrawActionArg.y, paramDrawActionArg.fLH);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 3) {
      return false;
    }
    return a(paramd, paramCanvas, paramJSONArray.optString(0), h.d(paramJSONArray, 1), h.d(paramJSONArray, 2), h.d(paramJSONArray, 3));
  }
  
  public final BaseDrawActionArg adE()
  {
    return new DrawTextActionArg();
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