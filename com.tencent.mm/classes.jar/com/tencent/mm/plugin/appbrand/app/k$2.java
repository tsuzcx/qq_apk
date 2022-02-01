package com.tencent.mm.plugin.appbrand.app;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.u;
import com.tencent.mm.plugin.expt.e.b;
import com.tencent.mm.plugin.report.service.h;

final class k$2
  implements u
{
  k$2(k paramk) {}
  
  public final boolean Xo()
  {
    AppMethodBeat.i(174704);
    if (TextUtils.equals(b.ceD().b("clicfg_media_codec_proxy_kv_switch", "1", false, false), "0"))
    {
      AppMethodBeat.o(174704);
      return false;
    }
    AppMethodBeat.o(174704);
    return true;
  }
  
  public final void ln(long paramLong)
  {
    AppMethodBeat.i(174702);
    h.vKh.idkeyStat(1132L, paramLong, 1L, false);
    AppMethodBeat.o(174702);
  }
  
  public final void pj(String paramString)
  {
    AppMethodBeat.i(174703);
    h.vKh.kvStat(17952, paramString);
    AppMethodBeat.o(174703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.k.2
 * JD-Core Version:    0.7.0.1
 */