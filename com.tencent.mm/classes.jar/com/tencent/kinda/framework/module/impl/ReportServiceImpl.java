package com.tencent.kinda.framework.module.impl;

import android.content.SharedPreferences.Editor;
import com.tencent.kinda.gen.KReportService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.wallet_core.ui.g;

public class ReportServiceImpl
  implements KReportService
{
  public String getLastSessionInfo()
  {
    AppMethodBeat.i(264914);
    String str = g.ijy().getString("lastReportSession", "");
    AppMethodBeat.o(264914);
    return str;
  }
  
  public void idkeyStat(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(18677);
    h.IzE.idkeyStat(paramLong1, paramLong2, paramLong3, paramBoolean);
    AppMethodBeat.o(18677);
  }
  
  public void kvStat(int paramInt, String paramString)
  {
    AppMethodBeat.i(18678);
    h.IzE.kvStat(paramInt, paramString);
    AppMethodBeat.o(18678);
  }
  
  public void setLastSessionInfo(String paramString)
  {
    AppMethodBeat.i(264913);
    g.ijy().edit().putString("lastReportSession", paramString).apply();
    AppMethodBeat.o(264913);
  }
  
  public long svrTimeMs()
  {
    AppMethodBeat.i(18679);
    long l = cm.bfC();
    AppMethodBeat.o(18679);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.ReportServiceImpl
 * JD-Core Version:    0.7.0.1
 */