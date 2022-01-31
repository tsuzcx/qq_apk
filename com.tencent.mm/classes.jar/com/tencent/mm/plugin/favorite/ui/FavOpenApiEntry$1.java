package com.tencent.mm.plugin.favorite.ui;

import android.view.View;
import android.view.Window;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.sdk.platformtools.am.a;

final class FavOpenApiEntry$1
  implements am.a
{
  FavOpenApiEntry$1(FavOpenApiEntry paramFavOpenApiEntry) {}
  
  public final boolean tC()
  {
    boolean bool = false;
    if ((this.kki.getWindow() == null) || (this.kki.getWindow().getDecorView() == null) || (this.kki.getWindow().getDecorView().getWindowToken() == null))
    {
      if (FavOpenApiEntry.a(this.kki) < 10)
      {
        FavOpenApiEntry.b(this.kki);
        bool = true;
      }
      return bool;
    }
    FavOpenApiEntry.a(this.kki, FavOpenApiEntry.c(this.kki).message);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.ui.FavOpenApiEntry.1
 * JD-Core Version:    0.7.0.1
 */