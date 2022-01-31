package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.plugin.base.stub.d.a;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.sdk.platformtools.ab;

final class FavOpenApiEntry$1$1
  implements d.a
{
  FavOpenApiEntry$1$1(FavOpenApiEntry.1 param1) {}
  
  public final void fH(boolean paramBoolean)
  {
    AppMethodBeat.i(153530);
    boolean bool = this.mEO.mEN.isFinishing();
    ab.i("MicroMsg.FavOpenApiEntry", "onCheckEnd, isPass = " + paramBoolean + ", isFinishing = " + bool);
    if ((paramBoolean) && (!bool))
    {
      FavOpenApiEntry.a(this.mEO.mEN, FavOpenApiEntry.d(this.mEO.mEN).message);
      AppMethodBeat.o(153530);
      return;
    }
    ReportUtil.ReportArgs localReportArgs = ReportUtil.c(this.mEO.mEN.getIntent().getExtras(), -3);
    ReportUtil.a(this.mEO.mEN, localReportArgs, false);
    this.mEO.mEN.finish();
    AppMethodBeat.o(153530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.ui.FavOpenApiEntry.1.1
 * JD-Core Version:    0.7.0.1
 */