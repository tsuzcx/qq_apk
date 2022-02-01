package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.List;

final class FavoriteIndexUI$16
  implements Runnable
{
  FavoriteIndexUI$16(FavoriteIndexUI paramFavoriteIndexUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(107014);
    long l = System.currentTimeMillis();
    List localList = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cpM();
    if (localList != null)
    {
      ac.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem getInvalid favitems , size = %d,start time = %s", new Object[] { Integer.valueOf(localList.size()), Long.valueOf(l) });
      if (localList.size() == 0)
      {
        AppMethodBeat.o(107014);
        return;
      }
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().A((com.tencent.mm.plugin.fav.a.g)localList.get(i));
        i += 1;
      }
      ac.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem  cost time = %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    AppMethodBeat.o(107014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.16
 * JD-Core Version:    0.7.0.1
 */