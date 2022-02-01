package com.tencent.mm.compatible.h;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  private static int lYL = 0;
  
  public static boolean aPR()
  {
    AppMethodBeat.i(155860);
    if (lYL == 0)
    {
      SharedPreferences localSharedPreferences = MMApplicationContext.getDefaultPreference();
      if ((localSharedPreferences == null) || (!localSharedPreferences.getBoolean("settings_support_swipe", true))) {
        break label49;
      }
    }
    label49:
    for (lYL = 1; lYL == 1; lYL = 2)
    {
      AppMethodBeat.o(155860);
      return true;
    }
    AppMethodBeat.o(155860);
    return false;
  }
  
  public static void eG(boolean paramBoolean)
  {
    AppMethodBeat.i(155861);
    SharedPreferences localSharedPreferences = MMApplicationContext.getDefaultPreference();
    boolean bool = localSharedPreferences.getBoolean("settings_support_swipe", true);
    if (bool != paramBoolean) {
      localSharedPreferences.edit().putBoolean("settings_support_swipe", paramBoolean).commit();
    }
    Log.i("MicroMsg.StyleUtil", "switchSwipebackMode, from %B to %B", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(155861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.h.a
 * JD-Core Version:    0.7.0.1
 */