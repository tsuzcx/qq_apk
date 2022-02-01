package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.conv.c;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"print", "", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "plugin-finder_release"})
public final class e
{
  public static final String b(c paramc)
  {
    AppMethodBeat.i(203653);
    p.h(paramc, "$this$print");
    paramc = "sessionId=" + paramc.field_sessionId + " placedFlag=" + paramc.field_placedFlag + " unReadCount=" + paramc.field_unReadCount + " status=" + paramc.field_status + " updateTime=" + paramc.field_updateTime + ' ' + "digest=" + paramc.field_digest + " digestType=" + paramc.field_digestType + " lastMsgID=" + paramc.field_lastMsgID + " unReadCount=" + paramc.field_unReadCount + "content=" + paramc.field_content + " isSend=" + paramc.field_isSend + " editingMsg=" + paramc.field_editingMsg + " systemRowId=" + paramc.systemRowid + " type=" + paramc.field_type;
    AppMethodBeat.o(203653);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.e
 * JD-Core Version:    0.7.0.1
 */