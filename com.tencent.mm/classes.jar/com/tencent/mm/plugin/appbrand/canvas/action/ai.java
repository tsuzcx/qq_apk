package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTransformActionArg;
import com.tencent.mm.plugin.appbrand.z.g;
import org.json.JSONArray;
import org.json.JSONException;

public final class ai
  implements d
{
  private static boolean a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    AppMethodBeat.i(144983);
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    localMatrix.setValues(new float[] { paramFloat1, paramFloat3, paramFloat5, paramFloat2, paramFloat4, paramFloat6, 0.0F, 0.0F, 1.0F });
    paramCanvas.setMatrix(localMatrix);
    AppMethodBeat.o(144983);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144984);
    paramd = (SetTransformActionArg)paramDrawActionArg;
    if (paramd == null)
    {
      AppMethodBeat.o(144984);
      return false;
    }
    boolean bool = a(paramCanvas, paramd.scaleX, paramd.jTF, paramd.jTG, paramd.scaleY, paramd.translateX, paramd.translateY);
    AppMethodBeat.o(144984);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144982);
    if (paramJSONArray.length() < 6)
    {
      AppMethodBeat.o(144982);
      return false;
    }
    try
    {
      boolean bool = a(paramCanvas, (float)paramJSONArray.getDouble(0), (float)paramJSONArray.getDouble(1), (float)paramJSONArray.getDouble(2), (float)paramJSONArray.getDouble(3), g.e(paramJSONArray, 4), g.e(paramJSONArray, 5));
      AppMethodBeat.o(144982);
      return bool;
    }
    catch (JSONException paramd)
    {
      AppMethodBeat.o(144982);
    }
    return false;
  }
  
  public final BaseDrawActionArg bdn()
  {
    AppMethodBeat.i(144981);
    SetTransformActionArg localSetTransformActionArg = new SetTransformActionArg();
    AppMethodBeat.o(144981);
    return localSetTransformActionArg;
  }
  
  public final String getMethod()
  {
    return "setTransform";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.ai
 * JD-Core Version:    0.7.0.1
 */