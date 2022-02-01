package com.tencent.mm.plugin.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  public static void K(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(134217);
    if (paramBoolean) {}
    for (paramString = paramString + "," + bt.eGO() + "," + fQQ();; paramString = paramString + "," + bt.eGO() + "," + fQR())
    {
      e.vIY.a(10645, paramString, true, true);
      AppMethodBeat.o(134217);
      return;
    }
  }
  
  public static void aUy(String paramString)
  {
    AppMethodBeat.i(134212);
    aj.getContext().getSharedPreferences(aj.eFD(), 0).edit().putString("reg_last_exit_ui", paramString).commit();
    AppMethodBeat.o(134212);
  }
  
  public static void aUz(String paramString)
  {
    AppMethodBeat.i(134214);
    aj.getContext().getSharedPreferences(aj.eFD(), 0).edit().putString("reg_next_enter_ui", paramString).commit();
    AppMethodBeat.o(134214);
  }
  
  public static String fQQ()
  {
    AppMethodBeat.i(134213);
    String str = aj.getContext().getSharedPreferences(aj.eFD(), 0).getString("reg_last_exit_ui", "");
    AppMethodBeat.o(134213);
    return str;
  }
  
  private static String fQR()
  {
    AppMethodBeat.i(134215);
    String str = aj.getContext().getSharedPreferences(aj.eFD(), 0).getString("reg_next_enter_ui", "");
    AppMethodBeat.o(134215);
    return str;
  }
  
  public static void pj(String paramString)
  {
    AppMethodBeat.i(134216);
    paramString = paramString + "," + bt.eGO() + "," + fQQ();
    e.vIY.a(10645, paramString, true, true);
    AppMethodBeat.o(134216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.b.a
 * JD-Core Version:    0.7.0.1
 */