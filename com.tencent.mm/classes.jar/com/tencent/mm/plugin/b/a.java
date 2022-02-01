package com.tencent.mm.plugin.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
{
  public static String EL()
  {
    AppMethodBeat.i(134213);
    String str = ai.getContext().getSharedPreferences(ai.eUX(), 0).getString("reg_last_exit_ui", "");
    AppMethodBeat.o(134213);
    return str;
  }
  
  public static void IK(String paramString)
  {
    AppMethodBeat.i(134212);
    ai.getContext().getSharedPreferences(ai.eUX(), 0).edit().putString("reg_last_exit_ui", paramString).commit();
    AppMethodBeat.o(134212);
  }
  
  public static void IL(String paramString)
  {
    AppMethodBeat.i(134214);
    ai.getContext().getSharedPreferences(ai.eUX(), 0).edit().putString("reg_next_enter_ui", paramString).commit();
    AppMethodBeat.o(134214);
  }
  
  private static String aRD()
  {
    AppMethodBeat.i(134215);
    String str = ai.getContext().getSharedPreferences(ai.eUX(), 0).getString("reg_next_enter_ui", "");
    AppMethodBeat.o(134215);
    return str;
  }
  
  public static void h(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(134217);
    if (paramBoolean) {}
    for (paramString = paramString + "," + bs.eWj() + "," + EL();; paramString = paramString + "," + bs.eWj() + "," + aRD())
    {
      e.wTc.a(10645, paramString, true, true);
      AppMethodBeat.o(134217);
      return;
    }
  }
  
  public static void sv(String paramString)
  {
    AppMethodBeat.i(134216);
    paramString = paramString + "," + bs.eWj() + "," + EL();
    e.wTc.a(10645, paramString, true, true);
    AppMethodBeat.o(134216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.b.a
 * JD-Core Version:    0.7.0.1
 */