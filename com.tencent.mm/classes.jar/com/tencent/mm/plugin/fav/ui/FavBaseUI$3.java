package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;

final class FavBaseUI$3
  implements MStorage.IOnStorageChange
{
  long AfV = 0L;
  
  FavBaseUI$3(FavBaseUI paramFavBaseUI) {}
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(106613);
    Log.i("MicroMsg.FavoriteBaseUI", "[onNotifyChange] event=%s", new Object[] { paramString });
    this.AfU.workerHandler.removeCallbacks(FavBaseUI.h(this.AfU));
    if (Util.ticksToNow(this.AfV) > 200L)
    {
      this.AfV = Util.currentTicks();
      this.AfU.workerHandler.post(FavBaseUI.h(this.AfU));
      AppMethodBeat.o(106613);
      return;
    }
    this.AfU.workerHandler.postDelayed(FavBaseUI.h(this.AfU), 200L);
    AppMethodBeat.o(106613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavBaseUI.3
 * JD-Core Version:    0.7.0.1
 */