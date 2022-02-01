package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetGlobalCompositeOperationActionArg;
import org.json.JSONArray;
import org.json.JSONException;

public final class w
  implements d
{
  private static boolean b(com.tencent.mm.plugin.appbrand.canvas.d paramd, String paramString)
  {
    AppMethodBeat.i(144939);
    paramd = paramd.jzc;
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
      AppMethodBeat.o(144939);
      return true;
      if (!paramString.equals("source-over")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("source-in")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("source-out")) {
        break;
      }
      i = 2;
      break;
      if (!paramString.equals("source-atop")) {
        break;
      }
      i = 3;
      break;
      if (!paramString.equals("destination-over")) {
        break;
      }
      i = 4;
      break;
      if (!paramString.equals("destination-in")) {
        break;
      }
      i = 5;
      break;
      if (!paramString.equals("destination-out")) {
        break;
      }
      i = 6;
      break;
      if (!paramString.equals("destination-atop")) {
        break;
      }
      i = 7;
      break;
      if (!paramString.equals("lighter")) {
        break;
      }
      i = 8;
      break;
      if (!paramString.equals("copy")) {
        break;
      }
      i = 9;
      break;
      if (!paramString.equals("xor")) {
        break;
      }
      i = 10;
      break;
      if (!paramString.equals("multiply")) {
        break;
      }
      i = 11;
      break;
      if (!paramString.equals("overlay")) {
        break;
      }
      i = 12;
      break;
      if (!paramString.equals("darken")) {
        break;
      }
      i = 13;
      break;
      if (!paramString.equals("lighten")) {
        break;
      }
      i = 14;
      break;
      if (!paramString.equals("color-dodge")) {
        break;
      }
      i = 15;
      break;
      if (!paramString.equals("color-burn")) {
        break;
      }
      i = 16;
      break;
      if (!paramString.equals("hard-light")) {
        break;
      }
      i = 17;
      break;
      if (!paramString.equals("soft-light")) {
        break;
      }
      i = 18;
      break;
      if (!paramString.equals("difference")) {
        break;
      }
      i = 19;
      break;
      if (!paramString.equals("exclusion")) {
        break;
      }
      i = 20;
      break;
      if (!paramString.equals("hue")) {
        break;
      }
      i = 21;
      break;
      if (!paramString.equals("saturation")) {
        break;
      }
      i = 22;
      break;
      if (!paramString.equals("color")) {
        break;
      }
      i = 23;
      break;
      if (!paramString.equals("luminosity")) {
        break;
      }
      i = 24;
      break;
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
      continue;
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      continue;
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
      continue;
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
      continue;
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
      continue;
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      continue;
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
      continue;
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
      continue;
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
      continue;
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.ADD));
      continue;
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
      continue;
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
      continue;
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.OVERLAY));
      continue;
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DARKEN));
      continue;
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144940);
    paramCanvas = (SetGlobalCompositeOperationActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(144940);
      return false;
    }
    boolean bool = b(paramd, paramCanvas.type);
    AppMethodBeat.o(144940);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144938);
    if (paramJSONArray.length() <= 0)
    {
      AppMethodBeat.o(144938);
      return false;
    }
    try
    {
      paramCanvas = paramJSONArray.getString(0);
      boolean bool = b(paramd, paramCanvas);
      AppMethodBeat.o(144938);
      return bool;
    }
    catch (JSONException paramd)
    {
      AppMethodBeat.o(144938);
    }
    return false;
  }
  
  public final BaseDrawActionArg aZO()
  {
    AppMethodBeat.i(144937);
    SetGlobalCompositeOperationActionArg localSetGlobalCompositeOperationActionArg = new SetGlobalCompositeOperationActionArg();
    AppMethodBeat.o(144937);
    return localSetGlobalCompositeOperationActionArg;
  }
  
  public final String getMethod()
  {
    return "setGlobalCompositeOperation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.w
 * JD-Core Version:    0.7.0.1
 */