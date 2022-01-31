package com.tencent.mm.plugin.exdevice.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
{
  public static boolean K(String paramString, long paramLong)
  {
    AppMethodBeat.i(19707);
    ab.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "isItemInSharedPreferences, key = %s, device id = %d", new Object[] { paramString, Long.valueOf(paramLong) });
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
      AppMethodBeat.o(19707);
      return false;
    }
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localSharedPreferences == null)
    {
      ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
      AppMethodBeat.o(19707);
      return false;
    }
    b(localSharedPreferences);
    if (!b.dZ(String.valueOf(paramLong), localSharedPreferences.getString(paramString, new String())))
    {
      AppMethodBeat.o(19707);
      return false;
    }
    AppMethodBeat.o(19707);
    return true;
  }
  
  public static boolean L(String paramString, long paramLong)
  {
    AppMethodBeat.i(19708);
    ab.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "addToSharedPreferences, key = %s, deviceId = %d", new Object[] { paramString, Long.valueOf(paramLong) });
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
      AppMethodBeat.o(19708);
      return false;
    }
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localSharedPreferences == null)
    {
      ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
      AppMethodBeat.o(19708);
      return false;
    }
    b(localSharedPreferences);
    String str = b.ea(String.valueOf(paramLong), localSharedPreferences.getString(paramString, new String()));
    if (str == null)
    {
      ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "addDeviceToDeviceList failed!!!");
      AppMethodBeat.o(19708);
      return false;
    }
    if (!localSharedPreferences.edit().putString(paramString, str).commit())
    {
      ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().putString().commit() Failed!!!");
      AppMethodBeat.o(19708);
      return false;
    }
    ab.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "add to sharepreference successful, new device list is %s", new Object[] { str });
    AppMethodBeat.o(19708);
    return true;
  }
  
  public static long[] LG(String paramString)
  {
    AppMethodBeat.i(19710);
    ab.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "getListFromSharedPreferences, key = %s", new Object[] { paramString });
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
      AppMethodBeat.o(19710);
      return null;
    }
    Object localObject = ah.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localObject == null)
    {
      ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
      AppMethodBeat.o(19710);
      return null;
    }
    b((SharedPreferences)localObject);
    try
    {
      localObject = ((SharedPreferences)localObject).getString(paramString, new String()).split("\\|");
      if ((localObject == null) || (localObject.length == 0))
      {
        ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == strDeviceList || 0 == strDeviceList.length");
        AppMethodBeat.o(19710);
        return null;
      }
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "split failed!!!, %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(19710);
      return null;
    }
    long[] arrayOfLong = new long[localObject.length];
    int m = localObject.length;
    int j = 0;
    i = 0;
    if (j < m)
    {
      paramString = localObject[j];
      for (;;)
      {
        try
        {
          ab.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "parse %s to long", new Object[] { paramString });
          k = paramString.length();
          if (k != 0) {
            continue;
          }
        }
        catch (Exception paramString)
        {
          try
          {
            arrayOfLong[i] = bo.getLong(paramString, 0L);
            i = k;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              int k;
              i = k;
            }
          }
          paramString = paramString;
        }
        j += 1;
        break;
        k = i + 1;
        ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "try pase string device id to long failed : " + paramString.getMessage());
      }
    }
    if (i == 0)
    {
      AppMethodBeat.o(19710);
      return null;
    }
    AppMethodBeat.o(19710);
    return arrayOfLong;
  }
  
  public static boolean M(String paramString, long paramLong)
  {
    AppMethodBeat.i(19709);
    ab.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "removeFromSharedPreferences, key = %s, deviceId = %d", new Object[] { paramString, Long.valueOf(paramLong) });
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
      AppMethodBeat.o(19709);
      return false;
    }
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localSharedPreferences == null)
    {
      ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
      AppMethodBeat.o(19709);
      return false;
    }
    b(localSharedPreferences);
    String str = b.eb(String.valueOf(paramLong), localSharedPreferences.getString(paramString, new String()));
    if (str == null)
    {
      ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove device from device list failed!!!");
      AppMethodBeat.o(19709);
      return false;
    }
    if (str.length() == 0) {}
    for (boolean bool = localSharedPreferences.edit().remove(paramString).commit(); !bool; bool = localSharedPreferences.edit().putString(paramString, str).commit())
    {
      ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().putString().commit()");
      AppMethodBeat.o(19709);
      return false;
    }
    ab.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove from sharepreference successful, new device list is %s", new Object[] { str });
    AppMethodBeat.o(19709);
    return true;
  }
  
  private static void b(SharedPreferences paramSharedPreferences)
  {
    int i = 0;
    AppMethodBeat.i(19706);
    ab.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "tryToClearDirtyData");
    if (Build.VERSION.SDK_INT < 11)
    {
      AppMethodBeat.o(19706);
      return;
    }
    if (paramSharedPreferences == null)
    {
      ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == aSP");
      AppMethodBeat.o(19706);
      return;
    }
    for (;;)
    {
      String str;
      if (i < 2) {
        str = new String[] { "conneted_device", "shut_down_device" }[i];
      }
      try
      {
        if (paramSharedPreferences.getStringSet(str, null) != null)
        {
          ab.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "find dirty data, remove it, key = %s", new Object[] { str });
          if (!paramSharedPreferences.edit().remove(str).commit()) {
            ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove dirty data failed!!!");
          }
        }
        label123:
        i += 1;
        continue;
        AppMethodBeat.o(19706);
        return;
      }
      catch (Exception localException)
      {
        break label123;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.h.a
 * JD-Core Version:    0.7.0.1
 */