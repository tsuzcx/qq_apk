package com.tencent.mm.ay;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.TimeZone;

public final class e
{
  public static boolean aGD()
  {
    AppMethodBeat.i(103250);
    if ((aGF()) || (aGE()))
    {
      AppMethodBeat.o(103250);
      return true;
    }
    AppMethodBeat.o(103250);
    return false;
  }
  
  public static boolean aGE()
  {
    AppMethodBeat.i(103251);
    int i = g.ZY().getInt("ShakeMusicGlobalSwitch", 0);
    ac.i("MicroMsg.Music.MusicHelperUtils", "isShakeMusicGlobalUser: %d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(103251);
      return false;
    }
    AppMethodBeat.o(103251);
    return true;
  }
  
  public static boolean aGF()
  {
    AppMethodBeat.i(103252);
    Object localObject = TimeZone.getDefault();
    TimeZone localTimeZone = TimeZone.getTimeZone("GMT+08:00");
    if (((TimeZone)localObject).getRawOffset() != localTimeZone.getRawOffset())
    {
      AppMethodBeat.o(103252);
      return false;
    }
    localObject = (TelephonyManager)ai.getContext().getSystemService("phone");
    if (localObject != null)
    {
      localObject = ((TelephonyManager)localObject).getNetworkCountryIso();
      if ((!bs.isNullOrNil((String)localObject)) && (!((String)localObject).equalsIgnoreCase("cn")))
      {
        AppMethodBeat.o(103252);
        return false;
      }
    }
    AppMethodBeat.o(103252);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ay.e
 * JD-Core Version:    0.7.0.1
 */