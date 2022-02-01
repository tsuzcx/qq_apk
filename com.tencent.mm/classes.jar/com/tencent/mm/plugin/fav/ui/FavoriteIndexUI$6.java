package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ar;
import java.util.List;

final class FavoriteIndexUI$6
  implements Runnable
{
  FavoriteIndexUI$6(FavoriteIndexUI paramFavoriteIndexUI, List paramList, String[] paramArrayOfString, Dialog paramDialog) {}
  
  public final void run()
  {
    AppMethodBeat.i(107004);
    FavoriteIndexUI.b(this.rDZ, this.rGQ);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107002);
        FavoriteIndexUI.6.this.rDo.dismiss();
        AppMethodBeat.o(107002);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(107003);
        String str = super.toString() + "|batchAddFavTags";
        AppMethodBeat.o(107003);
        return str;
      }
    });
    AppMethodBeat.o(107004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.6
 * JD-Core Version:    0.7.0.1
 */