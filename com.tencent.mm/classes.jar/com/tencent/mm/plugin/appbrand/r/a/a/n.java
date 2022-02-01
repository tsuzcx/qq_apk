package com.tencent.mm.plugin.appbrand.r.a.a;

import android.app.ActivityManager.TaskDescription;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.appbrand.r.a.c.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

final class n
{
  static ActivityManager.TaskDescription a(c.b paramb)
  {
    AppMethodBeat.i(176758);
    int i = paramb.colorPrimary;
    i = Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
    if (paramb.lzV > 0)
    {
      if (Build.VERSION.SDK_INT >= 28)
      {
        paramb = new ActivityManager.TaskDescription(paramb.label, paramb.lzV, i);
        AppMethodBeat.o(176758);
        return paramb;
      }
      try
      {
        Object localObject = MMBitmapFactory.decodeResource(ai.getResources(), paramb.lzV);
        localObject = new ActivityManager.TaskDescription(paramb.label, (Bitmap)localObject, i);
        AppMethodBeat.o(176758);
        return localObject;
      }
      catch (Exception localException)
      {
        ac.e("Luggage.WXA.WindowAndroidActivityFactory", "decode bitmap failed e=%s", new Object[] { localException });
        paramb = new ActivityManager.TaskDescription(paramb.label, null, i);
        AppMethodBeat.o(176758);
        return paramb;
      }
    }
    paramb = new ActivityManager.TaskDescription(paramb.label, paramb.lOP, i);
    AppMethodBeat.o(176758);
    return paramb;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.a.n
 * JD-Core Version:    0.7.0.1
 */