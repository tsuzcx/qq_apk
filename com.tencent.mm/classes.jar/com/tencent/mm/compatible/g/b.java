package com.tencent.mm.compatible.g;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class b
{
  private static int fJP = 0;
  
  public static boolean YB()
  {
    AppMethodBeat.i(155860);
    if (fJP == 0)
    {
      SharedPreferences localSharedPreferences = ai.eUY();
      if ((localSharedPreferences == null) || (!localSharedPreferences.getBoolean("settings_support_swipe", true))) {
        break label49;
      }
    }
    label49:
    for (fJP = 1; fJP == 1; fJP = 2)
    {
      AppMethodBeat.o(155860);
      return true;
    }
    AppMethodBeat.o(155860);
    return false;
  }
  
  public static void cI(boolean paramBoolean)
  {
    AppMethodBeat.i(155861);
    SharedPreferences localSharedPreferences = ai.eUY();
    boolean bool = localSharedPreferences.getBoolean("settings_support_swipe", true);
    if (bool != paramBoolean) {
      localSharedPreferences.edit().putBoolean("settings_support_swipe", paramBoolean).commit();
    }
    ac.i("MicroMsg.StyleUtil", "switchSwipebackMode, from %B to %B", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(155861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.g.b
 * JD-Core Version:    0.7.0.1
 */