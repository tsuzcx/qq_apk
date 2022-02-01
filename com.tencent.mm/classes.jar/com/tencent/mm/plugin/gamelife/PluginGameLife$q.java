package com.tencent.mm.plugin.gamelife;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.a.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/gamelife/PluginGameLife$initGameLifeSingleChatInfoUI$1", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListAssociateCallback;", "onDone", "", "isAssociate", "", "isOwnBlack", "onFail", "plugin-gamelife_release"})
public final class PluginGameLife$q
  implements b.a
{
  PluginGameLife$q(ProgressDialog paramProgressDialog, c.a parama, Context paramContext) {}
  
  public final void R(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(211978);
    ae.i("GameLife.PluginGameLife", "isBlackListAssociateWithWAGame isAssociate:%b,isOwnBlack:%b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if ((this.uIy != null) && (this.uIy.isShowing())) {
      this.uIy.dismiss();
    }
    c.a locala = this.uIz;
    if (locala != null)
    {
      locala.R(paramBoolean1, paramBoolean2);
      AppMethodBeat.o(211978);
      return;
    }
    AppMethodBeat.o(211978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife.q
 * JD-Core Version:    0.7.0.1
 */