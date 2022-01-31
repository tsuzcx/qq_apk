package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

final class FavOpenApiEntry$2
  implements q.a
{
  FavOpenApiEntry$2(FavOpenApiEntry paramFavOpenApiEntry, WXMediaMessage paramWXMediaMessage) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      FavOpenApiEntry.b(this.kki, this.kkj);
      paramString = ReportUtil.c(this.kki.getIntent().getExtras(), 0);
      ReportUtil.a(this.kki, paramString, false);
      return;
    }
    this.kki.finish();
    ReportUtil.a(this.kki, ReportUtil.c(this.kki.getIntent().getExtras(), 0), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.ui.FavOpenApiEntry.2
 * JD-Core Version:    0.7.0.1
 */