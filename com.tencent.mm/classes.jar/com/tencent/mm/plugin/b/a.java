package com.tencent.mm.plugin.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
{
  public static String awy()
  {
    AppMethodBeat.i(123481);
    String str = ah.getContext().getSharedPreferences(ah.dsP(), 0).getString("reg_last_exit_ui", "");
    AppMethodBeat.o(123481);
    return str;
  }
  
  private static String awz()
  {
    AppMethodBeat.i(123483);
    String str = ah.getContext().getSharedPreferences(ah.dsP(), 0).getString("reg_next_enter_ui", "");
    AppMethodBeat.o(123483);
    return str;
  }
  
  public static void g(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(123485);
    if (paramBoolean) {}
    for (paramString = paramString + "," + bo.aoy() + "," + awy();; paramString = paramString + "," + bo.aoy() + "," + awz())
    {
      e.qrI.a(10645, paramString, true, true);
      AppMethodBeat.o(123485);
      return;
    }
  }
  
  public static void xC(String paramString)
  {
    AppMethodBeat.i(123480);
    ah.getContext().getSharedPreferences(ah.dsP(), 0).edit().putString("reg_last_exit_ui", paramString).commit();
    AppMethodBeat.o(123480);
  }
  
  public static void xD(String paramString)
  {
    AppMethodBeat.i(123482);
    ah.getContext().getSharedPreferences(ah.dsP(), 0).edit().putString("reg_next_enter_ui", paramString).commit();
    AppMethodBeat.o(123482);
  }
  
  public static void xE(String paramString)
  {
    AppMethodBeat.i(123484);
    paramString = paramString + "," + bo.aoy() + "," + awy();
    e.qrI.a(10645, paramString, true, true);
    AppMethodBeat.o(123484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.b.a
 * JD-Core Version:    0.7.0.1
 */