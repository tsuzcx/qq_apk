package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.conv.c;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"print", "", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "plugin-finder_release"})
public final class f
{
  public static final String b(c paramc)
  {
    AppMethodBeat.i(251711);
    p.h(paramc, "$this$print");
    paramc = "sessionId=" + paramc.field_sessionId + " placedFlag=" + paramc.field_placedFlag + " unReadCount=" + paramc.field_unReadCount + " status=" + paramc.field_status + " updateTime=" + paramc.field_updateTime + ' ' + "digest=" + paramc.field_digest + " digestType=" + paramc.field_digestType + " lastMsgID=" + paramc.field_lastMsgID + " unReadCount=" + paramc.field_unReadCount + "content=" + paramc.field_content + " isSend=" + paramc.field_isSend + " editingMsg=" + paramc.field_editingMsg + " systemRowId=" + paramc.systemRowid + " type=" + paramc.field_type;
    AppMethodBeat.o(251711);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.f
 * JD-Core Version:    0.7.0.1
 */