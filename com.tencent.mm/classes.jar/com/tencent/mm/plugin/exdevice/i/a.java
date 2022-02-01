package com.tencent.mm.plugin.exdevice.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public static boolean ah(String paramString, long paramLong)
  {
    AppMethodBeat.i(23775);
    Log.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "isItemInSharedPreferences, key = %s, device id = %d", new Object[] { paramString, Long.valueOf(paramLong) });
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
      AppMethodBeat.o(23775);
      return false;
    }
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localSharedPreferences == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
      AppMethodBeat.o(23775);
      return false;
    }
    c(localSharedPreferences);
    if (!b.gY(String.valueOf(paramLong), localSharedPreferences.getString(paramString, new String())))
    {
      AppMethodBeat.o(23775);
      return false;
    }
    AppMethodBeat.o(23775);
    return true;
  }
  
  public static boolean ai(String paramString, long paramLong)
  {
    AppMethodBeat.i(23776);
    Log.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "addToSharedPreferences, key = %s, deviceId = %d", new Object[] { paramString, Long.valueOf(paramLong) });
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
      AppMethodBeat.o(23776);
      return false;
    }
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localSharedPreferences == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
      AppMethodBeat.o(23776);
      return false;
    }
    c(localSharedPreferences);
    String str = b.gZ(String.valueOf(paramLong), localSharedPreferences.getString(paramString, new String()));
    if (str == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "addDeviceToDeviceList failed!!!");
      AppMethodBeat.o(23776);
      return false;
    }
    if (!localSharedPreferences.edit().putString(paramString, str).commit())
    {
      Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().putString().commit() Failed!!!");
      AppMethodBeat.o(23776);
      return false;
    }
    Log.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "add to sharepreference successful, new device list is %s", new Object[] { str });
    AppMethodBeat.o(23776);
    return true;
  }
  
  public static boolean aj(String paramString, long paramLong)
  {
    AppMethodBeat.i(23777);
    Log.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "removeFromSharedPreferences, key = %s, deviceId = %d", new Object[] { paramString, Long.valueOf(paramLong) });
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
      AppMethodBeat.o(23777);
      return false;
    }
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localSharedPreferences == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
      AppMethodBeat.o(23777);
      return false;
    }
    c(localSharedPreferences);
    String str = b.ha(String.valueOf(paramLong), localSharedPreferences.getString(paramString, new String()));
    if (str == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove device from device list failed!!!");
      AppMethodBeat.o(23777);
      return false;
    }
    if (str.length() == 0) {}
    for (boolean bool = localSharedPreferences.edit().remove(paramString).commit(); !bool; bool = localSharedPreferences.edit().putString(paramString, str).commit())
    {
      Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().putString().commit()");
      AppMethodBeat.o(23777);
      return false;
    }
    Log.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove from sharepreference successful, new device list is %s", new Object[] { str });
    AppMethodBeat.o(23777);
    return true;
  }
  
  public static long[] apG(String paramString)
  {
    AppMethodBeat.i(23778);
    Log.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "getListFromSharedPreferences, key = %s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
      AppMethodBeat.o(23778);
      return null;
    }
    Object localObject = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localObject == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
      AppMethodBeat.o(23778);
      return null;
    }
    c((SharedPreferences)localObject);
    try
    {
      localObject = ((SharedPreferences)localObject).getString(paramString, new String()).split("\\|");
      if ((localObject == null) || (localObject.length == 0))
      {
        Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == strDeviceList || 0 == strDeviceList.length");
        AppMethodBeat.o(23778);
        return null;
      }
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "split failed!!!, %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(23778);
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
          Log.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "parse %s to long", new Object[] { paramString });
          k = paramString.length();
          if (k != 0) {
            continue;
          }
        }
        catch (Exception paramString)
        {
          try
          {
            arrayOfLong[i] = Util.getLong(paramString, 0L);
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
        Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "try pase string device id to long failed : " + paramString.getMessage());
      }
    }
    if (i == 0)
    {
      AppMethodBeat.o(23778);
      return null;
    }
    AppMethodBeat.o(23778);
    return arrayOfLong;
  }
  
  private static void c(SharedPreferences paramSharedPreferences)
  {
    int i = 0;
    AppMethodBeat.i(23774);
    Log.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "tryToClearDirtyData");
    if (Build.VERSION.SDK_INT < 11)
    {
      AppMethodBeat.o(23774);
      return;
    }
    if (paramSharedPreferences == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == aSP");
      AppMethodBeat.o(23774);
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
          Log.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "find dirty data, remove it, key = %s", new Object[] { str });
          if (!paramSharedPreferences.edit().remove(str).commit()) {
            Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove dirty data failed!!!");
          }
        }
        label123:
        i += 1;
        continue;
        AppMethodBeat.o(23774);
        return;
      }
      catch (Exception localException)
      {
        break label123;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.a
 * JD-Core Version:    0.7.0.1
 */