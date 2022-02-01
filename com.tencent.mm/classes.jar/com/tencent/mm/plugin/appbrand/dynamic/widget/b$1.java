package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.c;
import java.util.Map;

final class b$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(121571);
    Object localObject = a.a.gaa;
    localObject = a.qu("100284");
    if (localObject == null)
    {
      ad.i("MicroMsg.WidgetDrawableViewFactory", "widget canvas mode ABTest item is null.");
      AppMethodBeat.o(121571);
      return;
    }
    if (!((c)localObject).isValid())
    {
      b.rf(0);
      AppMethodBeat.o(121571);
      return;
    }
    try
    {
      b.rf(bt.getInt((String)((c)localObject).eJy().get("mode"), 0));
      ad.i("MicroMsg.WidgetDrawableViewFactory", "current canvas mode is : %d", new Object[] { Integer.valueOf(b.access$000()) });
      AppMethodBeat.o(121571);
      return;
    }
    catch (Exception localException)
    {
      ad.w("MicroMsg.WidgetDrawableViewFactory", "parse widget canvas mode error : %s", new Object[] { Log.getStackTraceString(localException) });
      AppMethodBeat.o(121571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.b.1
 * JD-Core Version:    0.7.0.1
 */