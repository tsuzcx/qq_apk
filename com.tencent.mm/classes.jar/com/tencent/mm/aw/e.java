package com.tencent.mm.aw;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.TimeZone;

public final class e
{
  public static boolean bLs()
  {
    AppMethodBeat.i(103250);
    if ((bLu()) || (bLt()))
    {
      AppMethodBeat.o(103250);
      return true;
    }
    AppMethodBeat.o(103250);
    return false;
  }
  
  public static boolean bLt()
  {
    AppMethodBeat.i(103251);
    int i = i.aRC().getInt("ShakeMusicGlobalSwitch", 0);
    Log.i("MicroMsg.Music.MusicHelperUtils", "isShakeMusicGlobalUser: %d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(103251);
      return false;
    }
    AppMethodBeat.o(103251);
    return true;
  }
  
  public static boolean bLu()
  {
    AppMethodBeat.i(103252);
    Object localObject = TimeZone.getDefault();
    TimeZone localTimeZone = TimeZone.getTimeZone("GMT+08:00");
    if (((TimeZone)localObject).getRawOffset() != localTimeZone.getRawOffset())
    {
      AppMethodBeat.o(103252);
      return false;
    }
    localObject = (TelephonyManager)MMApplicationContext.getContext().getSystemService("phone");
    if (localObject != null)
    {
      localObject = ((TelephonyManager)localObject).getNetworkCountryIso();
      if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).equalsIgnoreCase("cn")))
      {
        AppMethodBeat.o(103252);
        return false;
      }
    }
    AppMethodBeat.o(103252);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aw.e
 * JD-Core Version:    0.7.0.1
 */