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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av.a;

final class FavOpenApiEntry$1
  implements av.a
{
  FavOpenApiEntry$1(FavOpenApiEntry paramFavOpenApiEntry) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(24617);
    if ((this.rFy.getWindow() == null) || (this.rFy.getWindow().getDecorView() == null) || (this.rFy.getWindow().getDecorView().getWindowToken() == null))
    {
      if (FavOpenApiEntry.a(this.rFy) < 10)
      {
        FavOpenApiEntry.b(this.rFy);
        AppMethodBeat.o(24617);
        return true;
      }
      AppMethodBeat.o(24617);
      return false;
    }
    new d(this.rFy, FavOpenApiEntry.c(this.rFy), FavOpenApiEntry.d(this.rFy).openId, new d.a()
    {
      public final void jc(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(24616);
        boolean bool = FavOpenApiEntry.1.this.rFy.isFinishing();
        ad.i("MicroMsg.FavOpenApiEntry", "onCheckEnd, isPass = " + paramAnonymousBoolean + ", isFinishing = " + bool);
        if ((paramAnonymousBoolean) && (!bool))
        {
          FavOpenApiEntry.a(FavOpenApiEntry.1.this.rFy, FavOpenApiEntry.d(FavOpenApiEntry.1.this.rFy).message);
          AppMethodBeat.o(24616);
          return;
        }
        ReportUtil.ReportArgs localReportArgs = ReportUtil.d(FavOpenApiEntry.1.this.rFy.getIntent().getExtras(), -3);
        ReportUtil.a(FavOpenApiEntry.1.this.rFy, localReportArgs, false);
        FavOpenApiEntry.1.this.rFy.finish();
        AppMethodBeat.o(24616);
      }
    }).bMa();
    AppMethodBeat.o(24617);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.ui.FavOpenApiEntry.1
 * JD-Core Version:    0.7.0.1
 */