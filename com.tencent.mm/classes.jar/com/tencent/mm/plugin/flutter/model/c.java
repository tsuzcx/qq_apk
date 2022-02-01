package com.tencent.mm.plugin.flutter.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.al;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import io.flutter.plugin.a.m.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements k.c
{
  private final m.c bbB;
  
  c(m.c paramc)
  {
    this.bbB = paramc;
  }
  
  public final void a(j paramj, k.d paramd)
  {
    AppMethodBeat.i(148873);
    if (paramj.method.equals("getDisplayParams"))
    {
      DisplayMetrics localDisplayMetrics = this.bbB.JZ().getResources().getDisplayMetrics();
      Point localPoint = al.ck(this.bbB.JZ());
      paramj = new JSONObject();
      try
      {
        paramj.put("screenWidth", localPoint.x);
        paramj.put("screenHeight", localPoint.y);
        paramj.put("densityDpi", localDisplayMetrics.densityDpi);
        paramj.put("density", localDisplayMetrics.density);
        paramd.df(paramj.toString());
        AppMethodBeat.o(148873);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.Flutter.FlutterLvCppHandler", localJSONException, "", new Object[0]);
        }
      }
    }
    paramd.dmQ();
    AppMethodBeat.o(148873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.model.c
 * JD-Core Version:    0.7.0.1
 */