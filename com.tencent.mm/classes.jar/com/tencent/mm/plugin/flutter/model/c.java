package com.tencent.mm.plugin.flutter.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.aj;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import io.flutter.plugin.a.m.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements k.c
{
  private final m.c aRg;
  
  c(m.c paramc)
  {
    this.aRg = paramc;
  }
  
  public final void a(j paramj, k.d paramd)
  {
    AppMethodBeat.i(148873);
    if (paramj.method.equals("getDisplayParams"))
    {
      DisplayMetrics localDisplayMetrics = this.aRg.Ir().getResources().getDisplayMetrics();
      Point localPoint = aj.cl(this.aRg.Ir());
      paramj = new JSONObject();
      try
      {
        paramj.put("screenWidth", localPoint.x);
        paramj.put("screenHeight", localPoint.y);
        paramj.put("densityDpi", localDisplayMetrics.densityDpi);
        paramj.put("density", localDisplayMetrics.density);
        paramd.db(paramj.toString());
        AppMethodBeat.o(148873);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.Flutter.FlutterLvCppHandler", localJSONException, "", new Object[0]);
        }
      }
    }
    paramd.daE();
    AppMethodBeat.o(148873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.model.c
 * JD-Core Version:    0.7.0.1
 */