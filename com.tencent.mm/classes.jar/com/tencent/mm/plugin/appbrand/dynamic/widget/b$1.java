package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.c;
import java.util.Map;

final class b$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(121571);
    Object localObject = a.a.gAX;
    localObject = a.xi("100284");
    if (localObject == null)
    {
      ae.i("MicroMsg.WidgetDrawableViewFactory", "widget canvas mode ABTest item is null.");
      AppMethodBeat.o(121571);
      return;
    }
    if (!((c)localObject).isValid())
    {
      b.sx(0);
      AppMethodBeat.o(121571);
      return;
    }
    try
    {
      b.sx(bu.getInt((String)((c)localObject).fsy().get("mode"), 0));
      ae.i("MicroMsg.WidgetDrawableViewFactory", "current canvas mode is : %d", new Object[] { Integer.valueOf(b.access$000()) });
      AppMethodBeat.o(121571);
      return;
    }
    catch (Exception localException)
    {
      ae.w("MicroMsg.WidgetDrawableViewFactory", "parse widget canvas mode error : %s", new Object[] { Log.getStackTraceString(localException) });
      AppMethodBeat.o(121571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.b.1
 * JD-Core Version:    0.7.0.1
 */