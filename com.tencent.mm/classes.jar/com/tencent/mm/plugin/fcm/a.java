package com.tencent.mm.plugin.fcm;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  private static final String[] wTW = { "A53", "A53m", "A53t", "A33m", "A33", "A33t", "R7Plust", "R7Plus", "A59t", "A59s", "A59m", "R9PlustA", "R9PlusmA", "R9PlustmA", "R9tm", "R9m", "R9km", "A37t", "A37m", "R7sPlus", "R7Plusm", "A53", "A51kc", "A51", "A30" };
  private static final String[] wTX = { "V1950A", "V1955A" };
  private static final String[] wTY = { "Hi3751V811", "IdeaHub" };
  
  public static void aAD(String paramString)
  {
    AppMethodBeat.i(260951);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("com.google.android.gms.common.internal.BaseGmsClient")) && (paramString.contains("android.os.BinderProxy.transactNative(Native Method)")))
    {
      paramString = MultiProcessMMKV.getDefault();
      if (paramString != null) {
        paramString.encode("fcm_last_anr_record", d.RAD);
      }
    }
    AppMethodBeat.o(260951);
  }
  
  private static boolean dmm()
  {
    AppMethodBeat.i(260949);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getDefault();
    if (localMultiProcessMMKV != null)
    {
      int i = localMultiProcessMMKV.getInt("fcm_last_anr_record", 0);
      if (i != 0)
      {
        if (i == d.RAD)
        {
          AppMethodBeat.o(260949);
          return true;
        }
        AppMethodBeat.o(260949);
        return false;
      }
    }
    AppMethodBeat.o(260949);
    return false;
  }
  
  public static boolean fo(Context paramContext)
  {
    AppMethodBeat.i(260947);
    String[] arrayOfString;
    int j;
    int i;
    String str;
    if ((Util.nullAs(Build.MANUFACTURER, "").toLowerCase().contains("oppo".toLowerCase())) && ((Build.VERSION.SDK_INT == 21) || (Build.VERSION.SDK_INT == 22)))
    {
      arrayOfString = wTW;
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
          AppMethodBeat.o(260947);
          return false;
          i += 1;
          break;
          if (Util.nullAs(Build.MANUFACTURER, "").toLowerCase().contains("vivo".toLowerCase()))
          {
            i = 1;
            label189:
            if ((i != 0) && (Build.VERSION.SDK_INT == 29))
            {
              arrayOfString = wTX;
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
          if ((k.avQ()) && (Build.VERSION.SDK_INT >= 28))
          {
            arrayOfString = wTY;
            j = arrayOfString.length;
            i = 0;
            for (;;)
            {
              if (i >= j) {
                break label374;
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
          label374:
          i = 0;
          continue;
        }
        Log.i("MicroMsg.FCM.FcmServiceHelper", "fcm is available");
        if ((ChannelUtil.isGPVersion()) || (!dmm()))
        {
          AppMethodBeat.o(260947);
          return true;
        }
        AppMethodBeat.o(260947);
        return false;
      }
    }
    Log.i("MicroMsg.FCM.FcmServiceHelper", "normal device");
    Log.i("MicroMsg.FCM.FcmServiceHelper", "fcm is available");
    if ((ChannelUtil.isGPVersion()) || (!dmm()))
    {
      AppMethodBeat.o(260947);
      return true;
    }
    AppMethodBeat.o(260947);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.a
 * JD-Core Version:    0.7.0.1
 */