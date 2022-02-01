package com.tencent.mm.plugin.gamelife;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.a.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/gamelife/PluginGameLife$initGameLifeSingleChatInfoUI$1", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListAssociateCallback;", "onDone", "", "isAssociate", "", "isOwnBlack", "onFail", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginGameLife$f
  implements b.a
{
  PluginGameLife$f(ProgressDialog paramProgressDialog, c.a parama, Context paramContext) {}
  
  public final void au(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(267707);
    Log.i("GameLife.PluginGameLife", "isBlackListAssociateWithWAGame isAssociate:%b,isOwnBlack:%b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if ((this.IZv != null) && (this.IZv.isShowing())) {
      this.IZv.dismiss();
    }
    c.a locala = this.IZw;
    if (locala != null) {
      locala.au(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(267707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife.f
 * JD-Core Version:    0.7.0.1
 */