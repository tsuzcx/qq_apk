package com.tencent.mm.compatible.g;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class b
{
  private static int gdq = 0;
  
  public static boolean abd()
  {
    AppMethodBeat.i(155860);
    if (gdq == 0)
    {
      SharedPreferences localSharedPreferences = aj.fkD();
      if ((localSharedPreferences == null) || (!localSharedPreferences.getBoolean("settings_support_swipe", true))) {
        break label49;
      }
    }
    label49:
    for (gdq = 1; gdq == 1; gdq = 2)
    {
      AppMethodBeat.o(155860);
      return true;
    }
    AppMethodBeat.o(155860);
    return false;
  }
  
  public static void cK(boolean paramBoolean)
  {
    AppMethodBeat.i(155861);
    SharedPreferences localSharedPreferences = aj.fkD();
    boolean bool = localSharedPreferences.getBoolean("settings_support_swipe", true);
    if (bool != paramBoolean) {
      localSharedPreferences.edit().putBoolean("settings_support_swipe", paramBoolean).commit();
    }
    ad.i("MicroMsg.StyleUtil", "switchSwipebackMode, from %B to %B", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(155861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.g.b
 * JD-Core Version:    0.7.0.1
 */