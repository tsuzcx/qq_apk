package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.e;

final class GameRegionSelectUI$2$1
  implements DialogInterface.OnClickListener
{
  GameRegionSelectUI$2$1(GameRegionSelectUI.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(112159);
    e.el(this.nCA.nCz);
    GameRegionSelectUI.a(this.nCA.nCz);
    paramDialogInterface = new Intent();
    GameRegionPreference.a locala = e.eb(this.nCA.nCz);
    if (locala != null)
    {
      paramDialogInterface.putExtra("gameRegionName", e.a(locala));
      this.nCA.nCz.setResult(-1, paramDialogInterface);
    }
    for (;;)
    {
      this.nCA.nCz.finish();
      AppMethodBeat.o(112159);
      return;
      this.nCA.nCz.setResult(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRegionSelectUI.2.1
 * JD-Core Version:    0.7.0.1
 */