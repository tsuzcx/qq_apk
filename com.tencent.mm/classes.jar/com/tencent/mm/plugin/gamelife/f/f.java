package com.tencent.mm.plugin.gamelife.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"print", "", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "plugin-gamelife_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final String a(a parama)
  {
    AppMethodBeat.i(268112);
    s.u(parama, "<this>");
    parama = "sessionId=" + parama.field_sessionId + " unReadCount=" + parama.field_unReadCount + " updateTime=" + parama.field_updateTime + " digest=" + parama.field_digest + " lastMsgID=" + parama.field_lastMsgID + " unReadCount=" + parama.field_unReadCount + " systemRowid=" + parama.systemRowid + " digestFlag=" + parama.field_digestFlag;
    AppMethodBeat.o(268112);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.f.f
 * JD-Core Version:    0.7.0.1
 */