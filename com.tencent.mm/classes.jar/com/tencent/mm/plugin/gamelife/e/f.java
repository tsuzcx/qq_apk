package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"print", "", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "plugin-gamelife_release"})
public final class f
{
  public static final String a(a parama)
  {
    AppMethodBeat.i(241374);
    p.h(parama, "$this$print");
    parama = "sessionId=" + parama.field_sessionId + " unReadCount=" + parama.field_unReadCount + " updateTime=" + parama.field_updateTime + ' ' + "digest=" + parama.field_digest + " lastMsgID=" + parama.field_lastMsgID + " unReadCount=" + parama.field_unReadCount + " systemRowid=" + parama.systemRowid + " digestFlag=" + parama.field_digestFlag;
    AppMethodBeat.o(241374);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.f
 * JD-Core Version:    0.7.0.1
 */