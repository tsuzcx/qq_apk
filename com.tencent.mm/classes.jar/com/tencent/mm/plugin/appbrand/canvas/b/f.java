package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathClosePathActionArg;
import org.json.JSONArray;

public final class f
  implements a
{
  public final boolean a(Path paramPath, BasePathActionArg paramBasePathActionArg)
  {
    AppMethodBeat.i(145367);
    paramPath.close();
    AppMethodBeat.o(145367);
    return true;
  }
  
  public final boolean a(Path paramPath, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(145366);
    paramPath.close();
    AppMethodBeat.o(145366);
    return true;
  }
  
  public final BasePathActionArg ckk()
  {
    AppMethodBeat.i(145368);
    PathClosePathActionArg localPathClosePathActionArg = new PathClosePathActionArg();
    AppMethodBeat.o(145368);
    return localPathClosePathActionArg;
  }
  
  public final String getMethod()
  {
    return "closePath";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.f
 * JD-Core Version:    0.7.0.1
 */