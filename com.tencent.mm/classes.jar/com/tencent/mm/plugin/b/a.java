package com.tencent.mm.plugin.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;

public final class a
{
  public static String YA()
  {
    return ae.getContext().getSharedPreferences(ae.cqR(), 0).getString("reg_last_exit_ui", "");
  }
  
  public static void d(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {}
    for (paramString = paramString + "," + bk.UY() + "," + YA();; paramString = paramString + "," + bk.UY() + "," + ae.getContext().getSharedPreferences(ae.cqR(), 0).getString("reg_next_enter_ui", ""))
    {
      f.nEG.a(10645, paramString, true, true);
      return;
    }
  }
  
  public static void qi(String paramString)
  {
    ae.getContext().getSharedPreferences(ae.cqR(), 0).edit().putString("reg_last_exit_ui", paramString).commit();
  }
  
  public static void qj(String paramString)
  {
    ae.getContext().getSharedPreferences(ae.cqR(), 0).edit().putString("reg_next_enter_ui", paramString).commit();
  }
  
  public static void qk(String paramString)
  {
    paramString = paramString + "," + bk.UY() + "," + YA();
    f.nEG.a(10645, paramString, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.b.a
 * JD-Core Version:    0.7.0.1
 */