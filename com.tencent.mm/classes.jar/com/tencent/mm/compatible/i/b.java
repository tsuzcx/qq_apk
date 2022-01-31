package com.tencent.mm.compatible.i;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class b
{
  private static int esh = 0;
  
  public static boolean Mg()
  {
    AppMethodBeat.i(93055);
    if (esh == 0)
    {
      SharedPreferences localSharedPreferences = ah.dsQ();
      if ((localSharedPreferences == null) || (!localSharedPreferences.getBoolean("settings_support_swipe", true))) {
        break label49;
      }
    }
    label49:
    for (esh = 1; esh == 1; esh = 2)
    {
      AppMethodBeat.o(93055);
      return true;
    }
    AppMethodBeat.o(93055);
    return false;
  }
  
  public static void bS(boolean paramBoolean)
  {
    AppMethodBeat.i(93056);
    SharedPreferences localSharedPreferences = ah.dsQ();
    boolean bool = localSharedPreferences.getBoolean("settings_support_swipe", true);
    if (bool != paramBoolean) {
      localSharedPreferences.edit().putBoolean("settings_support_swipe", paramBoolean).commit();
    }
    ab.i("MicroMsg.StyleUtil", "switchSwipebackMode, from %B to %B", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(93056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.i.b
 * JD-Core Version:    0.7.0.1
 */