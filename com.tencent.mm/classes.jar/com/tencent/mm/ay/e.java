package com.tencent.mm.ay;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.TimeZone;

public final class e
{
  public static boolean aKh()
  {
    AppMethodBeat.i(103250);
    if ((aKj()) || (aKi()))
    {
      AppMethodBeat.o(103250);
      return true;
    }
    AppMethodBeat.o(103250);
    return false;
  }
  
  public static boolean aKi()
  {
    AppMethodBeat.i(103251);
    int i = g.acL().getInt("ShakeMusicGlobalSwitch", 0);
    ae.i("MicroMsg.Music.MusicHelperUtils", "isShakeMusicGlobalUser: %d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(103251);
      return false;
    }
    AppMethodBeat.o(103251);
    return true;
  }
  
  public static boolean aKj()
  {
    AppMethodBeat.i(103252);
    Object localObject = TimeZone.getDefault();
    TimeZone localTimeZone = TimeZone.getTimeZone("GMT+08:00");
    if (((TimeZone)localObject).getRawOffset() != localTimeZone.getRawOffset())
    {
      AppMethodBeat.o(103252);
      return false;
    }
    localObject = (TelephonyManager)ak.getContext().getSystemService("phone");
    if (localObject != null)
    {
      localObject = ((TelephonyManager)localObject).getNetworkCountryIso();
      if ((!bu.isNullOrNil((String)localObject)) && (!((String)localObject).equalsIgnoreCase("cn")))
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