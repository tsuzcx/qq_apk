package com.tencent.mm.compatible.i;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  private static int dzs = 0;
  
  public static void bt(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = ae.cqS();
    boolean bool = localSharedPreferences.getBoolean("settings_support_swipe", true);
    if (bool != paramBoolean) {
      localSharedPreferences.edit().putBoolean("settings_support_swipe", paramBoolean).commit();
    }
    y.i("MicroMsg.StyleUtil", "switchSwipebackMode, from %B to %B", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
  }
  
  public static boolean zD()
  {
    if (dzs == 0)
    {
      SharedPreferences localSharedPreferences = ae.cqS();
      if ((localSharedPreferences == null) || (!localSharedPreferences.getBoolean("settings_support_swipe", true))) {
        break label39;
      }
    }
    label39:
    for (dzs = 1; dzs == 1; dzs = 2) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.i.a
 * JD-Core Version:    0.7.0.1
 */