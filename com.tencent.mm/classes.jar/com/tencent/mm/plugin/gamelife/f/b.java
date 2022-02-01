package com.tencent.mm.plugin.gamelife.f;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationInfo;", "", "talker", "", "msgId", "", "externInfo", "msgType", "", "(Ljava/lang/String;JLjava/lang/String;I)V", "getExternInfo", "()Ljava/lang/String;", "setExternInfo", "(Ljava/lang/String;)V", "getMsgId", "()J", "setMsgId", "(J)V", "getMsgType", "()I", "setMsgType", "(I)V", "getTalker", "setTalker", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public String ICw;
  public long msgId;
  public int msgType;
  public String talker;
  
  public b(String paramString1, long paramLong, String paramString2, int paramInt)
  {
    this.talker = paramString1;
    this.msgId = paramLong;
    this.ICw = paramString2;
    this.msgType = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(268170);
    if (this == paramObject)
    {
      AppMethodBeat.o(268170);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(268170);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.talker, paramObject.talker))
    {
      AppMethodBeat.o(268170);
      return false;
    }
    if (this.msgId != paramObject.msgId)
    {
      AppMethodBeat.o(268170);
      return false;
    }
    if (!s.p(this.ICw, paramObject.ICw))
    {
      AppMethodBeat.o(268170);
      return false;
    }
    if (this.msgType != paramObject.msgType)
    {
      AppMethodBeat.o(268170);
      return false;
    }
    AppMethodBeat.o(268170);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(268158);
    int i;
    int k;
    if (this.talker == null)
    {
      i = 0;
      k = q.a..ExternalSyntheticBackport0.m(this.msgId);
      if (this.ICw != null) {
        break label71;
      }
    }
    for (;;)
    {
      int m = this.msgType;
      AppMethodBeat.o(268158);
      return ((i * 31 + k) * 31 + j) * 31 + m;
      i = this.talker.hashCode();
      break;
      label71:
      j = this.ICw.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(268147);
    String str = "GameLifeConversationInfo(talker=" + this.talker + ", msgId=" + this.msgId + ", externInfo=" + this.ICw + ", msgType=" + this.msgType + ')';
    AppMethodBeat.o(268147);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.f.b
 * JD-Core Version:    0.7.0.1
 */