package com.tencent.mm.plugin.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public static void Du(String paramString)
  {
    AppMethodBeat.i(134216);
    paramString = paramString + "," + Util.nowMilliSecond() + "," + chY();
    f.Ozc.b(10645, paramString, true, true);
    AppMethodBeat.o(134216);
  }
  
  public static void TA(String paramString)
  {
    AppMethodBeat.i(134214);
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putString("reg_next_enter_ui", paramString).commit();
    AppMethodBeat.o(134214);
  }
  
  public static void Tz(String paramString)
  {
    AppMethodBeat.i(134212);
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putString("reg_last_exit_ui", paramString).commit();
    AppMethodBeat.o(134212);
  }
  
  public static String chY()
  {
    AppMethodBeat.i(134213);
    String str = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("reg_last_exit_ui", "");
    AppMethodBeat.o(134213);
    return str;
  }
  
  private static String cib()
  {
    AppMethodBeat.i(134215);
    String str = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("reg_next_enter_ui", "");
    AppMethodBeat.o(134215);
    return str;
  }
  
  public static void z(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(134217);
    if (paramBoolean) {}
    for (paramString = paramString + "," + Util.nowMilliSecond() + "," + chY();; paramString = paramString + "," + Util.nowMilliSecond() + "," + cib())
    {
      f.Ozc.b(10645, paramString, true, true);
      AppMethodBeat.o(134217);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.b.a
 * JD-Core Version:    0.7.0.1
 */