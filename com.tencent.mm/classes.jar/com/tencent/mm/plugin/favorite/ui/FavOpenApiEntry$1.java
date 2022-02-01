package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.plugin.base.stub.d;
import com.tencent.mm.plugin.base.stub.d.a;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au.a;

final class FavOpenApiEntry$1
  implements au.a
{
  FavOpenApiEntry$1(FavOpenApiEntry paramFavOpenApiEntry) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(24617);
    if ((this.qVk.getWindow() == null) || (this.qVk.getWindow().getDecorView() == null) || (this.qVk.getWindow().getDecorView().getWindowToken() == null))
    {
      if (FavOpenApiEntry.a(this.qVk) < 10)
      {
        FavOpenApiEntry.b(this.qVk);
        AppMethodBeat.o(24617);
        return true;
      }
      AppMethodBeat.o(24617);
      return false;
    }
    new d(this.qVk, FavOpenApiEntry.c(this.qVk), FavOpenApiEntry.d(this.qVk).openId, new d.a()
    {
      public final void iT(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(24616);
        boolean bool = FavOpenApiEntry.1.this.qVk.isFinishing();
        ac.i("MicroMsg.FavOpenApiEntry", "onCheckEnd, isPass = " + paramAnonymousBoolean + ", isFinishing = " + bool);
        if ((paramAnonymousBoolean) && (!bool))
        {
          FavOpenApiEntry.a(FavOpenApiEntry.1.this.qVk, FavOpenApiEntry.d(FavOpenApiEntry.1.this.qVk).message);
          AppMethodBeat.o(24616);
          return;
        }
        ReportUtil.ReportArgs localReportArgs = ReportUtil.c(FavOpenApiEntry.1.this.qVk.getIntent().getExtras(), -3);
        ReportUtil.a(FavOpenApiEntry.1.this.qVk, localReportArgs, false);
        FavOpenApiEntry.1.this.qVk.finish();
        AppMethodBeat.o(24616);
      }
    }).bHP();
    AppMethodBeat.o(24617);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.ui.FavOpenApiEntry.1
 * JD-Core Version:    0.7.0.1
 */