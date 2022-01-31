package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathMoveToActionArg;
import org.json.JSONArray;

public final class h
  implements a
{
  public final boolean a(Path paramPath, BasePathActionArg paramBasePathActionArg)
  {
    paramBasePathActionArg = (PathMoveToActionArg)paramBasePathActionArg;
    if (paramBasePathActionArg == null) {
      return false;
    }
    paramPath.moveTo(paramBasePathActionArg.x, paramBasePathActionArg.y);
    return true;
  }
  
  public final boolean a(Path paramPath, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 2) {
      return false;
    }
    paramPath.moveTo(com.tencent.mm.plugin.appbrand.u.h.d(paramJSONArray, 0), com.tencent.mm.plugin.appbrand.u.h.d(paramJSONArray, 1));
    return true;
  }
  
  public final BasePathActionArg adQ()
  {
    return new PathMoveToActionArg();
  }
  
  public final String getMethod()
  {
    return "moveTo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.h
 * JD-Core Version:    0.7.0.1
 */