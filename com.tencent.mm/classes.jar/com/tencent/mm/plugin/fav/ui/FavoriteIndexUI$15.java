package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class FavoriteIndexUI$15
  implements Runnable
{
  FavoriteIndexUI$15(FavoriteIndexUI paramFavoriteIndexUI) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis();
    List localList = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().aQA();
    if (localList != null)
    {
      y.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem getInvalid favitems , size = %d,start time = %s", new Object[] { Integer.valueOf(localList.size()), Long.valueOf(l) });
      if (localList.size() != 0) {}
    }
    else
    {
      return;
    }
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().z((com.tencent.mm.plugin.fav.a.g)localList.get(i));
      i += 1;
    }
    y.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem  cost time = %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.15
 * JD-Core Version:    0.7.0.1
 */