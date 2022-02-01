package com.tencent.mm.plugin.appbrand.dynamic.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import java.util.Map;

final class b$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(121571);
    Object localObject = a.a.hnM;
    localObject = a.Fu("100284");
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WidgetDrawableViewFactory", "widget canvas mode ABTest item is null.");
      AppMethodBeat.o(121571);
      return;
    }
    if (!((c)localObject).isValid())
    {
      b.wt(0);
      AppMethodBeat.o(121571);
      return;
    }
    try
    {
      b.wt(Util.getInt((String)((c)localObject).gzz().get("mode"), 0));
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WidgetDrawableViewFactory", "current canvas mode is : %d", new Object[] { Integer.valueOf(b.access$000()) });
      AppMethodBeat.o(121571);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.WidgetDrawableViewFactory", "parse widget canvas mode error : %s", new Object[] { android.util.Log.getStackTraceString(localException) });
      AppMethodBeat.o(121571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.b.1
 * JD-Core Version:    0.7.0.1
 */