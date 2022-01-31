package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.w;

final class FavOpenApiEntry$2
  implements q.a
{
  FavOpenApiEntry$2(FavOpenApiEntry paramFavOpenApiEntry, WXMediaMessage paramWXMediaMessage) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(20541);
    if (paramBoolean)
    {
      l.a(w.a(this.mEN.getIntent(), "_mmessage_sdkVersion", 0), FavOpenApiEntry.c(this.mEN), this.mEP);
      FavOpenApiEntry.b(this.mEN, this.mEP);
      paramString = ReportUtil.c(this.mEN.getIntent().getExtras(), 0);
      ReportUtil.a(this.mEN, paramString, false);
      AppMethodBeat.o(20541);
      return;
    }
    this.mEN.finish();
    ReportUtil.a(this.mEN, ReportUtil.c(this.mEN.getIntent().getExtras(), 0), true);
    AppMethodBeat.o(20541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.ui.FavOpenApiEntry.2
 * JD-Core Version:    0.7.0.1
 */