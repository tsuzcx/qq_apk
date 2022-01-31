package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;

final class FavBaseUI$3
  implements j.a
{
  long kbp = 0L;
  
  FavBaseUI$3(FavBaseUI paramFavBaseUI) {}
  
  public final void a(String paramString, l paraml)
  {
    this.kbo.jWn.removeCallbacks(FavBaseUI.h(this.kbo));
    if (bk.cp(this.kbp) > 200L)
    {
      this.kbp = bk.UZ();
      this.kbo.jWn.post(FavBaseUI.h(this.kbo));
      return;
    }
    this.kbo.jWn.postDelayed(FavBaseUI.h(this.kbo), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavBaseUI.3
 * JD-Core Version:    0.7.0.1
 */