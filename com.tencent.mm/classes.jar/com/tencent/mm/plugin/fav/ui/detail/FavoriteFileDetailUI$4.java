package com.tencent.mm.plugin.fav.ui.detail;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.h;

final class FavoriteFileDetailUI$4
  implements e.a
{
  FavoriteFileDetailUI$4(FavoriteFileDetailUI paramFavoriteFileDetailUI) {}
  
  public final void Es() {}
  
  public final int dP(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void dQ(int paramInt1, int paramInt2) {}
  
  public final void mG()
  {
    AppMethodBeat.i(74325);
    ab.d("MicroMsg.FavoriteFileDetailUI", g.Mk() + " onPrepared");
    FavoriteFileDetailUI.p(this.mAf).setLoop(true);
    FavoriteFileDetailUI.p(this.mAf).start();
    AppMethodBeat.o(74325);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74326);
    FavoriteFileDetailUI.p(this.mAf).stop();
    if (FavoriteFileDetailUI.q(this.mAf))
    {
      AppMethodBeat.o(74326);
      return;
    }
    FavoriteFileDetailUI.r(this.mAf);
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74324);
        h.h(FavoriteFileDetailUI.4.this.mAf.getContext(), 2131304519, 2131304528);
        Bitmap localBitmap = l.a(FavoriteFileDetailUI.a(FavoriteFileDetailUI.4.this.mAf), FavoriteFileDetailUI.b(FavoriteFileDetailUI.4.this.mAf));
        ImageView localImageView = (ImageView)FavoriteFileDetailUI.4.this.mAf.findViewById(2131824109);
        if (localImageView != null)
        {
          localImageView.setImageBitmap(localBitmap);
          localImageView.setVisibility(0);
        }
        AppMethodBeat.o(74324);
      }
    });
    AppMethodBeat.o(74326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.4
 * JD-Core Version:    0.7.0.1
 */