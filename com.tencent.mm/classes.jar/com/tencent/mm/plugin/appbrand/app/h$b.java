package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandZombieTaskKiller$CheckScene;", "", "reportCountKey", "", "(Ljava/lang/String;II)V", "getReportCountKey", "()I", "APP_FOREGROUND", "FIRST_SCREEN", "PULLDOWN_TASK_BAR", "APPBRAND_LAUNCHER", "APPBRAND_BINDER_DIED", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum h$b
{
  final int qBZ;
  
  static
  {
    AppMethodBeat.i(317787);
    qCa = new b("APP_FOREGROUND", 0, 21);
    qCb = new b("FIRST_SCREEN", 1, 25);
    qCc = new b("PULLDOWN_TASK_BAR", 2, 22);
    qCd = new b("APPBRAND_LAUNCHER", 3, 23);
    qCe = new b("APPBRAND_BINDER_DIED", 4, 24);
    qCf = new b[] { qCa, qCb, qCc, qCd, qCe };
    AppMethodBeat.o(317787);
  }
  
  private h$b(int paramInt)
  {
    this.qBZ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.h.b
 * JD-Core Version:    0.7.0.1
 */