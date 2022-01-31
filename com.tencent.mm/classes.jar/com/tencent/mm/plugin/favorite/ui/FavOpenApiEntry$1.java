package com.tencent.mm.plugin.favorite.ui;

import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.plugin.base.stub.d;
import com.tencent.mm.sdk.platformtools.ap.a;

final class FavOpenApiEntry$1
  implements ap.a
{
  FavOpenApiEntry$1(FavOpenApiEntry paramFavOpenApiEntry) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(20540);
    if ((this.mEN.getWindow() == null) || (this.mEN.getWindow().getDecorView() == null) || (this.mEN.getWindow().getDecorView().getWindowToken() == null))
    {
      if (FavOpenApiEntry.a(this.mEN) < 10)
      {
        FavOpenApiEntry.b(this.mEN);
        AppMethodBeat.o(20540);
        return true;
      }
      AppMethodBeat.o(20540);
      return false;
    }
    new d(this.mEN, FavOpenApiEntry.c(this.mEN), FavOpenApiEntry.d(this.mEN).openId, new FavOpenApiEntry.1.1(this)).aVE();
    AppMethodBeat.o(20540);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.ui.FavOpenApiEntry.1
 * JD-Core Version:    0.7.0.1
 */