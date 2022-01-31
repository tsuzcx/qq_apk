package com.tencent.mm.aw;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.TimeZone;

public final class d
{
  public static boolean aiE()
  {
    AppMethodBeat.i(108007);
    if ((aiG()) || (aiF()))
    {
      AppMethodBeat.o(108007);
      return true;
    }
    AppMethodBeat.o(108007);
    return false;
  }
  
  public static boolean aiF()
  {
    AppMethodBeat.i(108008);
    int i = g.Nq().getInt("ShakeMusicGlobalSwitch", 0);
    ab.i("MicroMsg.Music.MusicHelperUtils", "isShakeMusicGlobalUser: %d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(108008);
      return false;
    }
    AppMethodBeat.o(108008);
    return true;
  }
  
  public static boolean aiG()
  {
    AppMethodBeat.i(108009);
    Object localObject = TimeZone.getDefault();
    TimeZone localTimeZone = TimeZone.getTimeZone("GMT+08:00");
    if (((TimeZone)localObject).getRawOffset() != localTimeZone.getRawOffset())
    {
      AppMethodBeat.o(108009);
      return false;
    }
    localObject = (TelephonyManager)ah.getContext().getSystemService("phone");
    if (localObject != null)
    {
      localObject = ((TelephonyManager)localObject).getNetworkCountryIso();
      if ((!bo.isNullOrNil((String)localObject)) && (!((String)localObject).equalsIgnoreCase("cn")))
      {
        AppMethodBeat.o(108009);
        return false;
      }
    }
    AppMethodBeat.o(108009);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aw.d
 * JD-Core Version:    0.7.0.1
 */