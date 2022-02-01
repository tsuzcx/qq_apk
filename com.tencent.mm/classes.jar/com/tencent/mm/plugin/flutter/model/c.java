package com.tencent.mm.plugin.flutter.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import io.flutter.embedding.engine.plugins.a;
import io.flutter.embedding.engine.plugins.a.b;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements a, k.c
{
  private Context context;
  private k wJr;
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(240946);
    Log.i("MicroMsg.Flutter.FlutterLvCppHandler", "onAttachedToEngine FlutterLvCppHandler CHANNEL%s", new Object[] { "com.tencent.mm.mmflutter.lvcppmethod" });
    this.wJr = new k(paramb.SOH, "com.tencent.mm.mmflutter.lvcppmethod");
    this.wJr.a(this);
    this.context = paramb.applicationContext;
    AppMethodBeat.o(240946);
  }
  
  public final void a(j paramj, k.d paramd)
  {
    AppMethodBeat.i(148873);
    if (paramj.method.equals("getDisplayParams"))
    {
      paramj = new JSONObject();
      try
      {
        DisplayMetrics localDisplayMetrics = this.context.getResources().getDisplayMetrics();
        Point localPoint = ao.az(this.context);
        paramj.put("screenWidth", localPoint.x);
        paramj.put("screenHeight", localPoint.y);
        paramj.put("densityDpi", localDisplayMetrics.densityDpi);
        paramj.put("density", localDisplayMetrics.density);
        paramd.ba(paramj.toString());
        AppMethodBeat.o(148873);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Flutter.FlutterLvCppHandler", localJSONException, "", new Object[0]);
        }
      }
    }
    paramd.dLv();
    AppMethodBeat.o(148873);
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(240947);
    this.wJr.a(null);
    AppMethodBeat.o(240947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.model.c
 * JD-Core Version:    0.7.0.1
 */