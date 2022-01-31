package com.tencent.mm.plugin.fav.ui.detail;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.vfs.e;

final class FavoriteSightDetailUI$2
  implements e.a
{
  FavoriteSightDetailUI$2(FavoriteSightDetailUI paramFavoriteSightDetailUI) {}
  
  public final void Es()
  {
    AppMethodBeat.i(74413);
    FavoriteSightDetailUI.d(this.mAS).A(0.0D);
    AppMethodBeat.o(74413);
  }
  
  public final int dP(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void dQ(int paramInt1, int paramInt2) {}
  
  public final void mG()
  {
    AppMethodBeat.i(74411);
    ab.i("MicroMsg.FavoriteSightDetailUI", " onPrepared");
    FavoriteSightDetailUI.d(this.mAS).setLoop(true);
    FavoriteSightDetailUI.b(this.mAS, FavoriteSightDetailUI.d(this.mAS).start());
    al.d(new FavoriteSightDetailUI.2.1(this));
    AppMethodBeat.o(74411);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74412);
    ab.e("MicroMsg.FavoriteSightDetailUI", "VideoPlay: on play video error what %d extra %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == -1)
    {
      FavoriteSightDetailUI.d(this.mAS).stop();
      if (e.cN(b.b(FavoriteSightDetailUI.b(this.mAS))))
      {
        FavoriteSightDetailUI.f(this.mAS);
        AppMethodBeat.o(74412);
        return;
      }
      if (e.cN(b.c(FavoriteSightDetailUI.b(this.mAS)))) {
        FavoriteSightDetailUI.e(this.mAS).setVisibility(0);
      }
      AppMethodBeat.o(74412);
      return;
    }
    if (FavoriteSightDetailUI.g(this.mAS))
    {
      Es();
      AppMethodBeat.o(74412);
      return;
    }
    FavoriteSightDetailUI.d(this.mAS).stop();
    if (FavoriteSightDetailUI.h(this.mAS))
    {
      AppMethodBeat.o(74412);
      return;
    }
    FavoriteSightDetailUI.i(this.mAS);
    al.d(new FavoriteSightDetailUI.2.2(this));
    AppMethodBeat.o(74412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.2
 * JD-Core Version:    0.7.0.1
 */