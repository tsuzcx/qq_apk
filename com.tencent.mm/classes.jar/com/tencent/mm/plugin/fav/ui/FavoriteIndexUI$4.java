package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.List;

final class FavoriteIndexUI$4
  implements Runnable
{
  FavoriteIndexUI$4(FavoriteIndexUI paramFavoriteIndexUI, List paramList, Dialog paramDialog) {}
  
  public final void run()
  {
    b.bn(this.kbG);
    ai.d(new Runnable()
    {
      public final void run()
      {
        FavoriteIndexUI.4.this.kbH.dismiss();
      }
      
      public final String toString()
      {
        return super.toString() + "|batchDelFavItems";
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.4
 * JD-Core Version:    0.7.0.1
 */