package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.plugin.fav.ui.a.b;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class FavSearchUI$8$1
  implements Runnable
{
  FavSearchUI$8$1(FavSearchUI.8 param8, List paramList1, List paramList2, List paramList3) {}
  
  public final void run()
  {
    if ((this.kcN.isEmpty()) && (this.kcO.isEmpty()) && (FavSearchUI.e(this.kcQ.kcM)))
    {
      FavSearchUI.a(this.kcQ.kcM, false);
      FavSearchUI.a(this.kcQ.kcM, this.kcN, this.kcO);
      return;
    }
    FavSearchUI.a(this.kcQ.kcM, this.kcN, this.kcO);
    y.d("MicroMsg.FavSearchUI", "on text changed, types %s keys %s tags %s", new Object[] { this.kcP, this.kcN, this.kcO });
    FavSearchUI.b(this.kcQ.kcM, this.kcN);
    FavSearchUI.c(this.kcQ.kcM, this.kcO);
    FavSearchUI.d(this.kcQ.kcM, this.kcP);
    FavSearchUI.f(this.kcQ.kcM).bt(this.kcO);
    FavSearchUI.g(this.kcQ.kcM).b(this.kcP, this.kcN, this.kcO);
    FavSearchUI.b(this.kcQ.kcM, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI.8.1
 * JD-Core Version:    0.7.0.1
 */