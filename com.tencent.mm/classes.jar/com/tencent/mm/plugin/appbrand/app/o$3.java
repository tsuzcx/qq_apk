package com.tencent.mm.plugin.appbrand.app;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.plugin.expt.e.d;
import com.tencent.mm.plugin.report.service.h;

final class o$3
  implements v
{
  o$3(o paramo) {}
  
  public final void Du(String paramString)
  {
    AppMethodBeat.i(317696);
    h.OAn.kvStat(17952, paramString);
    AppMethodBeat.o(317696);
  }
  
  public final boolean aPx()
  {
    AppMethodBeat.i(317699);
    if (TextUtils.equals(d.dNI().a("clicfg_media_codec_proxy_kv_switch", "1", false, false), "0"))
    {
      AppMethodBeat.o(317699);
      return false;
    }
    AppMethodBeat.o(317699);
    return true;
  }
  
  public final void hp(long paramLong)
  {
    AppMethodBeat.i(317693);
    h.OAn.idkeyStat(1132L, paramLong, 1L, false);
    AppMethodBeat.o(317693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.o.3
 * JD-Core Version:    0.7.0.1
 */