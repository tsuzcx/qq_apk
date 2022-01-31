package com.tencent.mm.plugin.fav.ui.detail;

import android.widget.ImageView;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class FavoriteSightDetailUI$2
  implements f.a
{
  FavoriteSightDetailUI$2(FavoriteSightDetailUI paramFavoriteSightDetailUI) {}
  
  public final int cv(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void cw(int paramInt1, int paramInt2) {}
  
  public final void kA()
  {
    y.i("MicroMsg.FavoriteSightDetailUI", " onPrepared");
    FavoriteSightDetailUI.d(this.kgg).setLoop(true);
    FavoriteSightDetailUI.b(this.kgg, FavoriteSightDetailUI.d(this.kgg).start());
    ai.d(new FavoriteSightDetailUI.2.1(this));
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    y.e("MicroMsg.FavoriteSightDetailUI", "VideoPlay: on play video error what %d extra %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == -1)
    {
      FavoriteSightDetailUI.d(this.kgg).stop();
      if (e.bK(b.b(FavoriteSightDetailUI.b(this.kgg)))) {
        FavoriteSightDetailUI.f(this.kgg);
      }
    }
    do
    {
      do
      {
        return;
      } while (!e.bK(b.c(FavoriteSightDetailUI.b(this.kgg))));
      FavoriteSightDetailUI.e(this.kgg).setVisibility(0);
      return;
      if (FavoriteSightDetailUI.g(this.kgg))
      {
        ug();
        return;
      }
      FavoriteSightDetailUI.d(this.kgg).stop();
    } while (FavoriteSightDetailUI.h(this.kgg));
    FavoriteSightDetailUI.i(this.kgg);
    ai.d(new FavoriteSightDetailUI.2.2(this));
  }
  
  public final void ug()
  {
    FavoriteSightDetailUI.d(this.kgg).x(0.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.2
 * JD-Core Version:    0.7.0.1
 */