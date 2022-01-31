package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.vfs.e;

final class FavoriteVideoPlayUI$2$1
  implements n.c
{
  FavoriteVideoPlayUI$2$1(FavoriteVideoPlayUI.2 param2) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(74458);
    if (FavoriteVideoPlayUI.a(this.mBs.mBr))
    {
      if (e.cN(FavoriteVideoPlayUI.b(this.mBs.mBr))) {
        paraml.add(0, 1, 0, this.mBs.mBr.getString(2131299826));
      }
      paraml.add(0, 2, 0, this.mBs.mBr.getString(2131302872));
    }
    AppMethodBeat.o(74458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI.2.1
 * JD-Core Version:    0.7.0.1
 */