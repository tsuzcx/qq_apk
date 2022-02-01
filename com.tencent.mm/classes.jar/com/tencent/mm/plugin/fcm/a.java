package com.tencent.mm.plugin.fcm;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  private static final String[] tnA = { "Hi3751V811", "IdeaHub" };
  private static final String[] tny = { "A53", "A53m", "A53t", "A33m", "A33", "A33t", "R7Plust", "R7Plus", "A59t", "A59s", "A59m", "R9PlustA", "R9PlusmA", "R9PlustmA", "R9tm", "R9m", "R9km", "A37t", "A37m", "R7sPlus", "R7Plusm", "A53", "A51kc", "A51", "A30" };
  private static final String[] tnz = { "V1950A", "V1955A" };
  
  public static void asz(String paramString)
  {
    AppMethodBeat.i(192522);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("com.google.android.gms.common.internal.BaseGmsClient")) && (paramString.contains("android.os.BinderProxy.transactNative(Native Method)")))
    {
      paramString = MultiProcessMMKV.getDefault();
      if (paramString != null) {
        paramString.encode("fcm_last_anr_record", d.KyO);
      }
    }
    AppMethodBeat.o(192522);
  }
  
  private static boolean cXe()
  {
    AppMethodBeat.i(192521);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getDefault();
    if (localMultiProcessMMKV != null)
    {
      int i = localMultiProcessMMKV.getInt("fcm_last_anr_record", 0);
      if (i != 0)
      {
        if (i == d.KyO)
        {
          AppMethodBeat.o(192521);
          return true;
        }
        AppMethodBeat.o(192521);
        return false;
      }
    }
    AppMethodBeat.o(192521);
    return false;
  }
  
  public static boolean fj(Context paramContext)
  {
    AppMethodBeat.i(192520);
    String[] arrayOfString;
    int j;
    int i;
    String str;
    if ((Util.nullAs(Build.MANUFACTURER, "").toLowerCase().contains("oppo".toLowerCase())) && ((Build.VERSION.SDK_INT == 21) || (Build.VERSION.SDK_INT == 22)))
    {
      arrayOfString = tny;
      j = arrayOfString.length;
      i = 0;
      if (i < j)
      {
        str = arrayOfString[i];
        if ((str.equalsIgnoreCase(Build.DEVICE)) || (str.equalsIgnoreCase(Build.PRODUCT)))
        {
          Log.w("MicroMsg.FCM.FcmServiceHelper", "fcm service incompatible!");
          Log.w("MicroMsg.FCM.FcmServiceHelper", "for oppo firebase problem, %s", new Object[] { Build.MODEL });
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        Log.w("MicroMsg.FCM.FcmServiceHelper", "fcm-incompatible device");
        i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext);
        Log.i("MicroMsg.FCM.FcmServiceHelper", "check google play service available, code = ".concat(String.valueOf(i)));
        if (i != 0)
        {
          Log.i("MicroMsg.FCM.FcmServiceHelper", "fcm is NOT available");
          AppMethodBeat.o(192520);
          return false;
          i += 1;
          break;
          if (Util.nullAs(Build.MANUFACTURER, "").toLowerCase().contains("vivo".toLowerCase()))
          {
            i = 1;
            label189:
            if ((i != 0) && (Build.VERSION.SDK_INT == 29))
            {
              arrayOfString = tnz;
              j = arrayOfString.length;
              i = 0;
            }
          }
          else
          {
            for (;;)
            {
              if (i >= j) {
                break label283;
              }
              str = arrayOfString[i];
              if ((str.equalsIgnoreCase(Build.DEVICE)) || (str.equalsIgnoreCase(Build.PRODUCT)))
              {
                Log.w("MicroMsg.FCM.FcmServiceHelper", "fcm service incompatible!");
                Log.w("MicroMsg.FCM.FcmServiceHelper", "for vivo firebase problem, %s", new Object[] { Build.MODEL });
                i = 1;
                break;
                i = 0;
                break label189;
              }
              i += 1;
            }
          }
          label283:
          if ((Util.nullAs(Build.MANUFACTURER, "").toLowerCase().contains("huawei".toLowerCase())) && (Build.VERSION.SDK_INT >= 28))
          {
            arrayOfString = tnA;
            j = arrayOfString.length;
            i = 0;
            for (;;)
            {
              if (i >= j) {
                break label390;
              }
              str = arrayOfString[i];
              if ((str.equalsIgnoreCase(Build.DEVICE)) || (str.equalsIgnoreCase(Build.PRODUCT)))
              {
                Log.w("MicroMsg.FCM.FcmServiceHelper", "fcm service incompatible!");
                Log.w("MicroMsg.FCM.FcmServiceHelper", "for huawei firebase problem, %s", new Object[] { Build.MODEL });
                i = 1;
                break;
              }
              i += 1;
            }
          }
          label390:
          i = 0;
          continue;
        }
        Log.i("MicroMsg.FCM.FcmServiceHelper", "fcm is available");
        if ((ChannelUtil.isGPVersion()) || (!cXe()))
        {
          AppMethodBeat.o(192520);
          return true;
        }
        AppMethodBeat.o(192520);
        return false;
      }
    }
    Log.i("MicroMsg.FCM.FcmServiceHelper", "normal device");
    Log.i("MicroMsg.FCM.FcmServiceHelper", "fcm is available");
    if ((ChannelUtil.isGPVersion()) || (!cXe()))
    {
      AppMethodBeat.o(192520);
      return true;
    }
    AppMethodBeat.o(192520);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.a
 * JD-Core Version:    0.7.0.1
 */