package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.app.ActivityManager.TaskDescription;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.appbrand.platform.window.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class n
{
  static ActivityManager.TaskDescription a(c.a parama)
  {
    AppMethodBeat.i(176758);
    int i = parama.colorPrimary;
    i = Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
    if (parama.qpN > 0)
    {
      if (Build.VERSION.SDK_INT >= 28)
      {
        parama = new ActivityManager.TaskDescription(parama.label, parama.qpN, i);
        AppMethodBeat.o(176758);
        return parama;
      }
      try
      {
        Object localObject = MMBitmapFactory.decodeResource(MMApplicationContext.getResources(), parama.qpN);
        localObject = new ActivityManager.TaskDescription(parama.label, (Bitmap)localObject, i);
        AppMethodBeat.o(176758);
        return localObject;
      }
      catch (Exception localException)
      {
        Log.e("Luggage.WXA.WindowAndroidActivityFactory", "decode bitmap failed e=%s", new Object[] { localException });
        parama = new ActivityManager.TaskDescription(parama.label, null, i);
        AppMethodBeat.o(176758);
        return parama;
      }
    }
    parama = new ActivityManager.TaskDescription(parama.label, parama.qGu, i);
    AppMethodBeat.o(176758);
    return parama;
  }
  
  static boolean a(Configuration paramConfiguration1, Configuration paramConfiguration2)
  {
    if ((paramConfiguration1 == null) || (paramConfiguration2 == null)) {}
    while ((paramConfiguration1.screenWidthDp != paramConfiguration2.screenWidthDp) || (paramConfiguration1.screenHeightDp != paramConfiguration2.screenHeightDp) || (paramConfiguration1.smallestScreenWidthDp != paramConfiguration2.smallestScreenWidthDp)) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.n
 * JD-Core Version:    0.7.0.1
 */