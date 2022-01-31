package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
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
    paramd = paramd.fLq;
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return true;
        if (paramString.equals("source-over"))
        {
          i = 0;
          continue;
          if (paramString.equals("source-in"))
          {
            i = 1;
            continue;
            if (paramString.equals("source-out"))
            {
              i = 2;
              continue;
              if (paramString.equals("source-atop"))
              {
                i = 3;
                continue;
                if (paramString.equals("destination-over"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("destination-in"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("destination-out"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("destination-atop"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("lighter"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("copy"))
                          {
                            i = 9;
                            continue;
                            if (paramString.equals("xor"))
                            {
                              i = 10;
                              continue;
                              if (paramString.equals("multiply"))
                              {
                                i = 11;
                                continue;
                                if (paramString.equals("overlay"))
                                {
                                  i = 12;
                                  continue;
                                  if (paramString.equals("darken"))
                                  {
                                    i = 13;
                                    continue;
                                    if (paramString.equals("lighten"))
                                    {
                                      i = 14;
                                      continue;
                                      if (paramString.equals("color-dodge"))
                                      {
                                        i = 15;
                                        continue;
                                        if (paramString.equals("color-burn"))
                                        {
                                          i = 16;
                                          continue;
                                          if (paramString.equals("hard-light"))
                                          {
                                            i = 17;
                                            continue;
                                            if (paramString.equals("soft-light"))
                                            {
                                              i = 18;
                                              continue;
                                              if (paramString.equals("difference"))
                                              {
                                                i = 19;
                                                continue;
                                                if (paramString.equals("exclusion"))
                                                {
                                                  i = 20;
                                                  continue;
                                                  if (paramString.equals("hue"))
                                                  {
                                                    i = 21;
                                                    continue;
                                                    if (paramString.equals("saturation"))
                                                    {
                                                      i = 22;
                                                      continue;
                                                      if (paramString.equals("color"))
                                                      {
                                                        i = 23;
                                                        continue;
                                                        if (paramString.equals("luminosity")) {
                                                          i = 24;
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    return true;
    paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    return true;
    paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
    return true;
    paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
    return true;
    paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    return true;
    paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    return true;
    paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    return true;
    paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    return true;
    paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
    return true;
    paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.ADD));
    return true;
    paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
    return true;
    paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
    return true;
    paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.OVERLAY));
    return true;
    paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DARKEN));
    return true;
    paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    paramCanvas = (SetGlobalCompositeOperationActionArg)paramDrawActionArg;
    if (paramCanvas == null) {
      return false;
    }
    return b(paramd, paramCanvas.type);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() <= 0) {
      return false;
    }
    try
    {
      paramCanvas = paramJSONArray.getString(0);
      return b(paramd, paramCanvas);
    }
    catch (JSONException paramd) {}
    return false;
  }
  
  public final BaseDrawActionArg adE()
  {
    return new SetGlobalCompositeOperationActionArg();
  }
  
  public final String getMethod()
  {
    return "setGlobalCompositeOperation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.w
 * JD-Core Version:    0.7.0.1
 */