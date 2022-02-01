package com.tencent.mm.plugin.appbrand.app;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.plugin.report.service.h;

final class n$2
  implements v
{
  n$2(n paramn) {}
  
  public final void EW(long paramLong)
  {
    AppMethodBeat.i(174702);
    h.IzE.idkeyStat(1132L, paramLong, 1L, false);
    AppMethodBeat.o(174702);
  }
  
  public final void KP(String paramString)
  {
    AppMethodBeat.i(174703);
    h.IzE.kvStat(17952, paramString);
    AppMethodBeat.o(174703);
  }
  
  public final boolean avc()
  {
    AppMethodBeat.i(174704);
    if (TextUtils.equals(d.dgX().a("clicfg_media_codec_proxy_kv_switch", "1", false, false), "0"))
    {
      AppMethodBeat.o(174704);
      return false;
    }
    AppMethodBeat.o(174704);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.n.2
 * JD-Core Version:    0.7.0.1
 */