package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathLineToActionArg;
import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONArray;

public final class g
  implements a
{
  public final boolean a(Path paramPath, BasePathActionArg paramBasePathActionArg)
  {
    paramBasePathActionArg = (PathLineToActionArg)paramBasePathActionArg;
    if (paramBasePathActionArg == null) {
      return false;
    }
    paramPath.lineTo(paramBasePathActionArg.x, paramBasePathActionArg.y);
    return true;
  }
  
  public final boolean a(Path paramPath, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 2) {
      return false;
    }
    paramPath.lineTo(h.d(paramJSONArray, 0), h.d(paramJSONArray, 1));
    return true;
  }
  
  public final BasePathActionArg adQ()
  {
    return new PathLineToActionArg();
  }
  
  public final String getMethod()
  {
    return "lineTo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.g
 * JD-Core Version:    0.7.0.1
 */