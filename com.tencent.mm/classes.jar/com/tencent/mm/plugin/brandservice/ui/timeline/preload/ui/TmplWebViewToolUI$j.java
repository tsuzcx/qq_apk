package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.v;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.e.l;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "invoke"})
final class TmplWebViewToolUI$j
  extends k
  implements a.f.a.a<TmplParams>
{
  TmplWebViewToolUI$j(TmplWebViewToolUI paramTmplWebViewToolUI)
  {
    super(0);
  }
  
  private TmplParams aYX()
  {
    AppMethodBeat.i(138517);
    Object localObject2;
    try
    {
      Object localObject1 = this.keI.getIntent().getParcelableExtra(e.l.yVj);
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.preload.TmplParams");
        AppMethodBeat.o(138517);
        throw ((Throwable)localObject1);
      }
    }
    catch (Exception localException)
    {
      localObject2 = TmplWebViewToolUI.c(this.keI);
      Object localObject3 = new StringBuilder("tmplParam is null, ");
      Intent localIntent = this.keI.getIntent();
      j.p(localIntent, "intent");
      ab.e((String)localObject2, d.Q(localIntent));
      com.tencent.mm.plugin.webview.preload.a.JZ(150);
      localObject2 = h.qsU;
      localObject3 = this.keI.getIntent();
      j.p(localObject3, "intent");
      ((h)localObject2).e(17260, new Object[] { Integer.valueOf(2), d.Q((Intent)localObject3) });
      this.keI.finish();
      localObject2 = new TmplParams();
    }
    for (;;)
    {
      AppMethodBeat.o(138517);
      return localObject2;
      localObject2 = (TmplParams)localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI.j
 * JD-Core Version:    0.7.0.1
 */