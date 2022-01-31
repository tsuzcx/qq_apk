package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.util.Log;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class c$1
  implements Runnable
{
  public final void run()
  {
    Object localObject = a.b.dHs;
    localObject = a.fJ("100284");
    if (localObject == null)
    {
      y.i("MicroMsg.WidgetDrawableViewFactory", "widget canvas mode ABTest item is null.");
      return;
    }
    if (!((com.tencent.mm.storage.c)localObject).isValid())
    {
      c.kO(0);
      return;
    }
    try
    {
      c.kO(bk.getInt((String)((com.tencent.mm.storage.c)localObject).ctr().get("mode"), 0));
      y.i("MicroMsg.WidgetDrawableViewFactory", "current canvas mode is : %d", new Object[] { Integer.valueOf(c.access$000()) });
      return;
    }
    catch (Exception localException)
    {
      y.w("MicroMsg.WidgetDrawableViewFactory", "parse widget canvas mode error : %s", new Object[] { Log.getStackTraceString(localException) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.c.1
 * JD-Core Version:    0.7.0.1
 */