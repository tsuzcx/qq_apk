package com.tencent.mm.plugin.fcm;

import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class d
{
  private static final String[] rNP = { "A53", "A53m", "A53t", "A33m", "A33", "A33t", "R7Plust", "R7Plus", "A59t", "A59s", "A59m", "R9PlustA", "R9PlusmA", "R9PlustmA", "R9tm", "R9m", "R9km", "A37t", "A37m", "R7sPlus", "R7Plusm", "A53", "A51kc", "A51", "A30" };
  
  public static final boolean f(g paramg)
  {
    AppMethodBeat.i(127581);
    int i;
    if (((Build.VERSION.SDK_INT == 21) || (Build.VERSION.SDK_INT == 22)) && (bu.bI(Build.MANUFACTURER, "").toLowerCase().contains("oppo".toLowerCase())))
    {
      String[] arrayOfString = rNP;
      int j = arrayOfString.length;
      i = 0;
      if (i < j)
      {
        String str = arrayOfString[i];
        if ((str.equalsIgnoreCase(Build.DEVICE)) || (str.equalsIgnoreCase(Build.PRODUCT)))
        {
          ae.i("OPPOFirebaseProblem", "for oppo firebase problem, %s", new Object[] { Build.MODEL });
          i = 1;
          label106:
          if ((i == 0) || (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramg.ca) == 0)) {
            break label159;
          }
        }
      }
    }
    label159:
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.FCM.OPPOFirebaseProblem", "isNoSupportFCM() result:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(127581);
      return bool;
      i += 1;
      break;
      i = 0;
      break label106;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.d
 * JD-Core Version:    0.7.0.1
 */