package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.sdk.platformtools.y;

final class FavOpenApiEntry$2
  implements y.a
{
  FavOpenApiEntry$2(FavOpenApiEntry paramFavOpenApiEntry, WXMediaMessage paramWXMediaMessage) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(24618);
    if (paramBoolean)
    {
      o.a(y.getIntExtra(this.rFy.getIntent(), "_mmessage_sdkVersion", 0), FavOpenApiEntry.c(this.rFy), this.rFA);
      FavOpenApiEntry.b(this.rFy, this.rFA);
      paramString = ReportUtil.d(this.rFy.getIntent().getExtras(), 0);
      ReportUtil.a(this.rFy, paramString, false);
      AppMethodBeat.o(24618);
      return;
    }
    this.rFy.finish();
    ReportUtil.a(this.rFy, ReportUtil.d(this.rFy.getIntent().getExtras(), 0), true);
    AppMethodBeat.o(24618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.ui.FavOpenApiEntry.2
 * JD-Core Version:    0.7.0.1
 */