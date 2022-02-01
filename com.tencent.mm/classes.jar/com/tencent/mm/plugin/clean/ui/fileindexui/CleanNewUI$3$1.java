package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.f.c.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.f.c;

final class CleanNewUI$3$1
  implements f.c
{
  CleanNewUI$3$1(CleanNewUI.3 param3) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(186438);
    if (paramBoolean)
    {
      ae.i("MicroMsg.CleanNewUI", "click cleanCacheBtn.");
      paramString = this.pcr.pcq;
      CleanNewUI localCleanNewUI = this.pcr.pcq;
      this.pcr.pcq.getString(2131757367);
      CleanNewUI.a(paramString, h.c(localCleanNewUI, "", false, null));
      CleanNewUI.a(this.pcr.pcq, bu.fpO());
      CleanNewUI.a(this.pcr.pcq, new a(d.caX().oCB, d.caX().cacheSize, d.caX().oCC, CleanNewUI.b(this.pcr.pcq)));
      b.c(CleanNewUI.c(this.pcr.pcq), "cleanCacheTask");
      g.yxI.idkeyStat(714L, 14L, 1L, false);
    }
    AppMethodBeat.o(186438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.3.1
 * JD-Core Version:    0.7.0.1
 */