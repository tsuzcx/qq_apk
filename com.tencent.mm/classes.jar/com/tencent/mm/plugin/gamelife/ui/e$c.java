package com.tencent.mm.plugin.gamelife.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.game.api.c.a;
import com.tencent.mm.plugin.game.api.c.b;
import com.tencent.mm.plugin.gamelife.e.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "gameLifeHistoryNode", "Lcom/tencent/mm/plugin/game/api/IGameExternalService$GameLifeHistoryNode;", "kotlin.jvm.PlatformType", "invoke"})
final class e$c
  implements c.a
{
  e$c(e parame) {}
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(212229);
    if (paramb == null)
    {
      ae.i("GameLife.ConversationPresenter", "checkHistoryConversation gameLifeHistoryNode null");
      AppMethodBeat.o(212229);
      return;
    }
    if (paramb.ucI)
    {
      com.tencent.mm.plugin.gamelife.e.a locala = e.e(this.uKJ).ddA();
      int i = paramb.ucJ;
      ae.i("GameLife.ConversationPresenter", "checkHistoryConversation sysrowid: " + locala.systemRowid + " old: " + locala.field_unReadCount + " new: " + i);
      if ((locala.systemRowid > 0L) && (i <= locala.field_unReadCount))
      {
        locala.field_unReadCount = i;
        paramb = e.e(this.uKJ);
        paramb.update(locala.systemRowid, (c)locala, false);
        i = 4;
      }
      for (;;)
      {
        paramb.doNotify("single", i, locala);
        AppMethodBeat.o(212229);
        return;
        locala.field_updateTime = ch.aDc();
        locala.field_unReadCount = i;
        locala.field_sessionId = "@gamelifehistory";
        locala.field_digest = com.tencent.mm.cb.a.az(ak.getContext(), 2131766895);
        paramb = e.e(this.uKJ);
        paramb.replace((c)locala, false);
        if (locala.systemRowid <= 0L) {
          i = 2;
        } else {
          i = 1;
        }
      }
    }
    ae.i("GameLife.ConversationPresenter", "checkHistoryConversation gameLifeNode.hasGameLife false");
    AppMethodBeat.o(212229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.e.c
 * JD-Core Version:    0.7.0.1
 */