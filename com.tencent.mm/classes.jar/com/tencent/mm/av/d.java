package com.tencent.mm.av;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.TimeZone;

public final class d
{
  public static boolean PB()
  {
    return (PD()) || (PC());
  }
  
  public static boolean PC()
  {
    int i = g.AA().getInt("ShakeMusicGlobalSwitch", 0);
    y.i("MicroMsg.Music.MusicHelperUtils", "isShakeMusicGlobalUser: %d", new Object[] { Integer.valueOf(i) });
    return i != 0;
  }
  
  public static boolean PD()
  {
    Object localObject = TimeZone.getDefault();
    TimeZone localTimeZone = TimeZone.getTimeZone("GMT+08:00");
    if (((TimeZone)localObject).getRawOffset() != localTimeZone.getRawOffset()) {
      return false;
    }
    localObject = (TelephonyManager)ae.getContext().getSystemService("phone");
    if (localObject != null)
    {
      localObject = ((TelephonyManager)localObject).getNetworkCountryIso();
      if ((!bk.bl((String)localObject)) && (!((String)localObject).equalsIgnoreCase("cn"))) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.av.d
 * JD-Core Version:    0.7.0.1
 */