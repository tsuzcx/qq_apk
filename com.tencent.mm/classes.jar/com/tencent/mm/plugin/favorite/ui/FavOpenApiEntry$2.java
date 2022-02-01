package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.sdk.platformtools.x;

final class FavOpenApiEntry$2
  implements y.a
{
  FavOpenApiEntry$2(FavOpenApiEntry paramFavOpenApiEntry, WXMediaMessage paramWXMediaMessage) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(24618);
    if (paramBoolean)
    {
      o.a(x.getIntExtra(this.qVk.getIntent(), "_mmessage_sdkVersion", 0), FavOpenApiEntry.c(this.qVk), this.qVm);
      FavOpenApiEntry.b(this.qVk, this.qVm);
      paramString = ReportUtil.c(this.qVk.getIntent().getExtras(), 0);
      ReportUtil.a(this.qVk, paramString, false);
      AppMethodBeat.o(24618);
      return;
    }
    this.qVk.finish();
    ReportUtil.a(this.qVk, ReportUtil.c(this.qVk.getIntent().getExtras(), 0), true);
    AppMethodBeat.o(24618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.ui.FavOpenApiEntry.2
 * JD-Core Version:    0.7.0.1
 */