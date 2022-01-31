package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathClosePathActionArg;
import org.json.JSONArray;

public final class f
  implements a
{
  public final boolean a(Path paramPath, BasePathActionArg paramBasePathActionArg)
  {
    paramPath.close();
    return true;
  }
  
  public final boolean a(Path paramPath, JSONArray paramJSONArray)
  {
    paramPath.close();
    return true;
  }
  
  public final BasePathActionArg adQ()
  {
    return new PathClosePathActionArg();
  }
  
  public final String getMethod()
  {
    return "closePath";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.f
 * JD-Core Version:    0.7.0.1
 */