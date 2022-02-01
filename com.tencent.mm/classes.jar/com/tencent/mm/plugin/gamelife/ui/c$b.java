package com.tencent.mm.plugin.gamelife.ui;

import android.widget.AdapterView.AdapterContextMenuInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.br.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/gamelife/ui/GameLifeConversationLongClickListener$onMMMenuItemSelected$1$2$1", "Lcom/tencent/mm/model/MsgInfoStorageLogic$IDeleteMsg;", "finishCallback", "", "isCancel", "", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$b
  implements br.a
{
  c$b(boolean paramBoolean, AdapterView.AdapterContextMenuInfo paramAdapterContextMenuInfo) {}
  
  public final boolean aMJ()
  {
    return false;
  }
  
  public final void aMK()
  {
    AppMethodBeat.i(267852);
    Log.i("GameLife.ConversationOnLongClickListener", "longclick delete msg finish [CONTEXT_MENU_LONG_CLICK_DELETE] ret=" + this.AFR + " position=" + this.AFS.position);
    AppMethodBeat.o(267852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.c.b
 * JD-Core Version:    0.7.0.1
 */