package com.tencent.mm.modelappbrand;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  public static String dZL;
  public static String dZM;
  
  public static String Jk()
  {
    StringBuilder localStringBuilder = new StringBuilder("sid_");
    g.DN();
    dZL = a.CK() + "_" + bk.UY();
    y.v("MicroMsg.AppBrandReporter", "refreshWeAppSearchSessionId : %s", new Object[] { dZL });
    return dZL;
  }
  
  public static void jr(String paramString)
  {
    Object localObject = MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "pref_appbrand_process", 4);
    paramString = paramString + ":start_time";
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).remove(paramString);
    ((SharedPreferences.Editor)localObject).commit();
    f.nEG.a(365L, 5L, 1L, false);
    y.v("MicroMsg.AppBrandReporter", "onProcessExit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.b
 * JD-Core Version:    0.7.0.1
 */