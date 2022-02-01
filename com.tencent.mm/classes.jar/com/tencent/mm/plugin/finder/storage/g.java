package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.conv.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"print", "", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "plugin-finder_release"})
public final class g
{
  public static final String b(d paramd)
  {
    AppMethodBeat.i(252930);
    p.k(paramd, "$this$print");
    paramd = "sessionId=" + paramd.field_sessionId + " placedFlag=" + paramd.field_placedFlag + " unReadCount=" + paramd.field_unReadCount + " status=" + paramd.field_status + " updateTime=" + paramd.field_updateTime + ' ' + "digest=" + paramd.field_digest + " digestType=" + paramd.field_digestType + " lastMsgID=" + paramd.field_lastMsgID + " unReadCount=" + paramd.field_unReadCount + "content=" + paramd.field_content + " isSend=" + paramd.field_isSend + " editingMsg=" + paramd.field_editingMsg + " systemRowId=" + paramd.systemRowid + " type=" + paramd.field_type;
    AppMethodBeat.o(252930);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.g
 * JD-Core Version:    0.7.0.1
 */