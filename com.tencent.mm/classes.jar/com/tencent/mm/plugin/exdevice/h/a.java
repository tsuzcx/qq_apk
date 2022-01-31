package com.tencent.mm.plugin.exdevice.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public static boolean A(String paramString, long paramLong)
  {
    y.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "isItemInSharedPreferences, key = %s, device id = %d", new Object[] { paramString, Long.valueOf(paramLong) });
    if (bk.bl(paramString)) {
      y.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
    }
    SharedPreferences localSharedPreferences;
    do
    {
      return false;
      localSharedPreferences = ae.getContext().getSharedPreferences("exdevice_pref", 0);
      if (localSharedPreferences == null)
      {
        y.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
        return false;
      }
      b(localSharedPreferences);
    } while (!b.cV(String.valueOf(paramLong), localSharedPreferences.getString(paramString, new String())));
    return true;
  }
  
  public static boolean B(String paramString, long paramLong)
  {
    y.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "addToSharedPreferences, key = %s, deviceId = %d", new Object[] { paramString, Long.valueOf(paramLong) });
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
      return false;
    }
    SharedPreferences localSharedPreferences = ae.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localSharedPreferences == null)
    {
      y.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
      return false;
    }
    b(localSharedPreferences);
    String str1 = String.valueOf(paramLong);
    String str2 = localSharedPreferences.getString(paramString, new String());
    y.i("MicroMsg.exdevice.Util", "addDeviceToDeviceList, device = %s, device list = %s", new Object[] { str1, str2 });
    if ((bk.bl(str1)) || (str2 == null))
    {
      y.e("MicroMsg.exdevice.Util", "Error parameters!!!");
      str1 = null;
    }
    while (str1 == null)
    {
      y.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "addDeviceToDeviceList failed!!!");
      return false;
      String str3 = new String();
      str2 = str3 + str2;
      str1 = str2 + str1;
      str1 = str1 + "|";
      y.i("MicroMsg.exdevice.Util", "add device to device list successful, new device list = %s", new Object[] { str1 });
    }
    if (!localSharedPreferences.edit().putString(paramString, str1).commit())
    {
      y.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().putString().commit() Failed!!!");
      return false;
    }
    y.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "add to sharepreference successful, new device list is %s", new Object[] { str1 });
    return true;
  }
  
  public static long[] BE(String paramString)
  {
    y.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "getListFromSharedPreferences, key = %s", new Object[] { paramString });
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
      return null;
    }
    Object localObject = ae.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localObject == null)
    {
      y.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
      return null;
    }
    b((SharedPreferences)localObject);
    try
    {
      localObject = ((SharedPreferences)localObject).getString(paramString, new String()).split("\\|");
      if ((localObject == null) || (localObject.length == 0))
      {
        y.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == strDeviceList || 0 == strDeviceList.length");
        return null;
      }
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "split failed!!!, %s", new Object[] { paramString.getMessage() });
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
          y.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "parse %s to long", new Object[] { paramString });
          k = paramString.length();
          if (k != 0) {
            continue;
          }
        }
        catch (Exception paramString)
        {
          try
          {
            arrayOfLong[i] = bk.getLong(paramString, 0L);
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
        y.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "try pase string device id to long failed : " + paramString.getMessage());
      }
    }
    if (i == 0) {
      return null;
    }
    return arrayOfLong;
  }
  
  public static boolean C(String paramString, long paramLong)
  {
    y.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "removeFromSharedPreferences, key = %s, deviceId = %d", new Object[] { paramString, Long.valueOf(paramLong) });
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
      return false;
    }
    SharedPreferences localSharedPreferences = ae.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localSharedPreferences == null)
    {
      y.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
      return false;
    }
    b(localSharedPreferences);
    String str = b.cW(String.valueOf(paramLong), localSharedPreferences.getString(paramString, new String()));
    if (str == null)
    {
      y.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove device from device list failed!!!");
      return false;
    }
    if (str.length() == 0) {}
    for (boolean bool = localSharedPreferences.edit().remove(paramString).commit(); !bool; bool = localSharedPreferences.edit().putString(paramString, str).commit())
    {
      y.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().putString().commit()");
      return false;
    }
    y.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove from sharepreference successful, new device list is %s", new Object[] { str });
    return true;
  }
  
  private static void b(SharedPreferences paramSharedPreferences)
  {
    int i = 0;
    y.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "tryToClearDirtyData");
    if (Build.VERSION.SDK_INT < 11) {
      return;
    }
    if (paramSharedPreferences == null)
    {
      y.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == aSP");
      return;
    }
    while (i < 2)
    {
      String str = new String[] { "conneted_device", "shut_down_device" }[i];
      try
      {
        if (paramSharedPreferences.getStringSet(str, null) != null)
        {
          y.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "find dirty data, remove it, key = %s", new Object[] { str });
          if (!paramSharedPreferences.edit().remove(str).commit()) {
            y.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove dirty data failed!!!");
          }
        }
        label105:
        i += 1;
      }
      catch (Exception localException)
      {
        break label105;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.h.a
 * JD-Core Version:    0.7.0.1
 */