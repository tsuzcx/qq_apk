package com.tencent.mm.plugin.flutter.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ai;
import io.flutter.a.a.j;
import io.flutter.a.a.k.c;
import io.flutter.a.a.k.d;
import io.flutter.a.a.m.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements k.c
{
  private final m.c rdH;
  
  c(m.c paramc)
  {
    this.rdH = paramc;
  }
  
  public final void a(j paramj, k.d paramd)
  {
    AppMethodBeat.i(148873);
    if (paramj.method.equals("getDisplayParams"))
    {
      DisplayMetrics localDisplayMetrics = this.rdH.II().getResources().getDisplayMetrics();
      Point localPoint = ai.cf(this.rdH.II());
      paramj = new JSONObject();
      try
      {
        paramj.put("screenWidth", localPoint.x);
        paramj.put("screenHeight", localPoint.y);
        paramj.put("densityDpi", localDisplayMetrics.densityDpi);
        paramj.put("density", localDisplayMetrics.density);
        paramd.ay(paramj.toString());
        AppMethodBeat.o(148873);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.Flutter.FlutterLvCppHandler", localJSONException, "", new Object[0]);
        }
      }
    }
    paramd.Av();
    AppMethodBeat.o(148873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.model.c
 * JD-Core Version:    0.7.0.1
 */