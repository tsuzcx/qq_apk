package com.tencent.mm.az;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.TimeZone;

public final class e
{
  public static boolean azN()
  {
    AppMethodBeat.i(103250);
    if ((azP()) || (azO()))
    {
      AppMethodBeat.o(103250);
      return true;
    }
    AppMethodBeat.o(103250);
    return false;
  }
  
  public static boolean azO()
  {
    AppMethodBeat.i(103251);
    int i = g.Zd().getInt("ShakeMusicGlobalSwitch", 0);
    ad.i("MicroMsg.Music.MusicHelperUtils", "isShakeMusicGlobalUser: %d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(103251);
      return false;
    }
    AppMethodBeat.o(103251);
    return true;
  }
  
  public static boolean azP()
  {
    AppMethodBeat.i(103252);
    Object localObject = TimeZone.getDefault();
    TimeZone localTimeZone = TimeZone.getTimeZone("GMT+08:00");
    if (((TimeZone)localObject).getRawOffset() != localTimeZone.getRawOffset())
    {
      AppMethodBeat.o(103252);
      return false;
    }
    localObject = (TelephonyManager)aj.getContext().getSystemService("phone");
    if (localObject != null)
    {
      localObject = ((TelephonyManager)localObject).getNetworkCountryIso();
      if ((!bt.isNullOrNil((String)localObject)) && (!((String)localObject).equalsIgnoreCase("cn")))
      {
        AppMethodBeat.o(103252);
        return false;
      }
    }
    AppMethodBeat.o(103252);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.az.e
 * JD-Core Version:    0.7.0.1
 */