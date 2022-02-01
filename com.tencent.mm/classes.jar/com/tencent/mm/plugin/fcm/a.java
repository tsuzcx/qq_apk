package com.tencent.mm.plugin.fcm;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class a
{
  private static final String[] AqA = { "V1950A", "V1955A" };
  private static final String[] AqB = { "Hi3751V811", "IdeaHub" };
  private static final String[] Aqz = { "A53", "A53m", "A53t", "A33m", "A33", "A33t", "R7Plust", "R7Plus", "A59t", "A59s", "A59m", "R9PlustA", "R9PlusmA", "R9PlustmA", "R9tm", "R9m", "R9km", "A37t", "A37m", "R7sPlus", "R7Plusm", "A53", "A51kc", "A51", "A30" };
  
  public static void auL(String paramString)
  {
    AppMethodBeat.i(260593);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("com.google.android.gms.common.internal.BaseGmsClient")) && (paramString.contains("android.os.BinderProxy.transactNative(Native Method)")))
    {
      paramString = MultiProcessMMKV.getDefault();
      if (paramString != null) {
        paramString.encode("fcm_last_anr_record", d.Yxh);
      }
    }
    AppMethodBeat.o(260593);
  }
  
  private static boolean dTc()
  {
    AppMethodBeat.i(260589);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getDefault();
    if (localMultiProcessMMKV != null)
    {
      int i = localMultiProcessMMKV.getInt("fcm_last_anr_record", 0);
      if (i != 0)
      {
        if (i == d.Yxh)
        {
          AppMethodBeat.o(260589);
          return true;
        }
        AppMethodBeat.o(260589);
        return false;
      }
    }
    AppMethodBeat.o(260589);
    return false;
  }
  
  public static boolean gm(Context paramContext)
  {
    AppMethodBeat.i(260588);
    String[] arrayOfString;
    int j;
    int i;
    String str;
    if ((l.aQm()) && ((Build.VERSION.SDK_INT == 21) || (Build.VERSION.SDK_INT == 22)))
    {
      arrayOfString = Aqz;
      j = arrayOfString.length;
      i = 0;
      if (i < j)
      {
        str = arrayOfString[i];
        if ((str.equalsIgnoreCase(Build.DEVICE)) || (str.equalsIgnoreCase(Build.PRODUCT)))
        {
          Log.w("MicroMsg.FCM.FcmServiceHelper", "fcm service incompatible!");
          Log.w("MicroMsg.FCM.FcmServiceHelper", "for oppo firebase problem, %s", new Object[] { q.aPo() });
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
          AppMethodBeat.o(260588);
          return false;
          i += 1;
          break;
          if ((l.aQn()) && (Build.VERSION.SDK_INT == 29))
          {
            arrayOfString = AqA;
            j = arrayOfString.length;
            i = 0;
            for (;;)
            {
              if (i >= j) {
                break label240;
              }
              str = arrayOfString[i];
              if ((str.equalsIgnoreCase(Build.DEVICE)) || (str.equalsIgnoreCase(Build.PRODUCT)))
              {
                Log.w("MicroMsg.FCM.FcmServiceHelper", "fcm service incompatible!");
                Log.w("MicroMsg.FCM.FcmServiceHelper", "for vivo firebase problem, %s", new Object[] { q.aPo() });
                i = 1;
                break;
              }
              i += 1;
            }
          }
          label240:
          if ((l.aQo()) && (Build.VERSION.SDK_INT >= 28))
          {
            arrayOfString = AqB;
            j = arrayOfString.length;
            i = 0;
            for (;;)
            {
              if (i >= j) {
                break label331;
              }
              str = arrayOfString[i];
              if ((str.equalsIgnoreCase(Build.DEVICE)) || (str.equalsIgnoreCase(Build.PRODUCT)))
              {
                Log.w("MicroMsg.FCM.FcmServiceHelper", "fcm service incompatible!");
                Log.w("MicroMsg.FCM.FcmServiceHelper", "for huawei firebase problem, %s", new Object[] { q.aPo() });
                i = 1;
                break;
              }
              i += 1;
            }
          }
          label331:
          i = 0;
          continue;
        }
        Log.i("MicroMsg.FCM.FcmServiceHelper", "fcm is available");
        if ((ChannelUtil.isGPVersion()) || (!dTc()))
        {
          AppMethodBeat.o(260588);
          return true;
        }
        AppMethodBeat.o(260588);
        return false;
      }
    }
    Log.i("MicroMsg.FCM.FcmServiceHelper", "normal device");
    Log.i("MicroMsg.FCM.FcmServiceHelper", "fcm is available");
    if ((ChannelUtil.isGPVersion()) || (!dTc()))
    {
      AppMethodBeat.o(260588);
      return true;
    }
    AppMethodBeat.o(260588);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.a
 * JD-Core Version:    0.7.0.1
 */