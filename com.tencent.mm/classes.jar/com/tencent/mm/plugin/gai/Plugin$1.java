package com.tencent.mm.plugin.gai;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class Plugin$1
  implements Plugin.a
{
  Plugin$1(Plugin paramPlugin) {}
  
  public final void Em(String paramString)
  {
    ae.getContext().getSharedPreferences(ae.cqR() + "_google_aid", 4).edit().putString("getgoogleaid", paramString).commit();
    paramString = String.format("%s,%s,%s,%s,%s,%s", new Object[] { "", q.getDeviceID(ae.getContext()), q.getAndroidId(), q.zi(), paramString, ae.getContext().getSharedPreferences(ae.cqR(), 0).getString("installreferer", "") });
    y.i("MicroMsg.Plugin.gai", "Advertisement MAT rsakv logID:%d val:%s", new Object[] { Integer.valueOf(11238), paramString });
    h.nFQ.a(11238, paramString, true, true);
    ae.getContext().getSharedPreferences(ae.cqR() + "_google_aid", 4).edit().putBoolean("already_report_googleaid", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gai.Plugin.1
 * JD-Core Version:    0.7.0.1
 */