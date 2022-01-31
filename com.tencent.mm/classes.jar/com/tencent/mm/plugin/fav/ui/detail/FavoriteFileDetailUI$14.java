package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class FavoriteFileDetailUI$14
  implements f.a
{
  FavoriteFileDetailUI$14(FavoriteFileDetailUI paramFavoriteFileDetailUI) {}
  
  public final int cv(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void cw(int paramInt1, int paramInt2) {}
  
  public final void kA()
  {
    y.d("MicroMsg.FavoriteFileDetailUI", g.zH() + " onPrepared");
    FavoriteFileDetailUI.l(this.kfu).setLoop(true);
    FavoriteFileDetailUI.l(this.kfu).start();
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    FavoriteFileDetailUI.l(this.kfu).stop();
    if (FavoriteFileDetailUI.m(this.kfu)) {
      return;
    }
    FavoriteFileDetailUI.n(this.kfu);
    ai.d(new FavoriteFileDetailUI.14.1(this));
  }
  
  public final void ug() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.14
 * JD-Core Version:    0.7.0.1
 */