package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.conv.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"print", "", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "plugin-finder_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final String a(b paramb)
  {
    AppMethodBeat.i(339197);
    s.u(paramb, "<this>");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sessionId=").append(paramb.field_sessionId).append(" placedFlag=").append(paramb.field_placedFlag).append(" unReadCount=").append(paramb.field_unReadCount).append(" status=").append(paramb.field_status).append(" updateTime=").append(paramb.field_updateTime).append(" digest=").append(paramb.field_digest).append(" digestType=").append(paramb.field_digestType).append(" lastMsgID=").append(paramb.field_lastMsgID).append(" unReadCount=").append(paramb.field_unReadCount).append("content=").append(paramb.field_content).append(" isSend=").append(paramb.field_isSend).append(" editingMsg=");
    localStringBuilder.append(paramb.field_editingMsg).append(" systemRowId=").append(paramb.systemRowid).append(" type=").append(paramb.field_type);
    paramb = localStringBuilder.toString();
    AppMethodBeat.o(339197);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.h
 * JD-Core Version:    0.7.0.1
 */