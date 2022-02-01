package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationInfo;", "", "talker", "", "msgId", "", "externInfo", "msgType", "", "(Ljava/lang/String;JLjava/lang/String;I)V", "getExternInfo", "()Ljava/lang/String;", "setExternInfo", "(Ljava/lang/String;)V", "getMsgId", "()J", "setMsgId", "(J)V", "getMsgType", "()I", "setMsgType", "(I)V", "getTalker", "setTalker", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-gamelife_release"})
public final class b
{
  public String CIm;
  public long msgId;
  public int msgType;
  public String talker;
  
  public b(String paramString1, long paramLong, String paramString2, int paramInt)
  {
    this.talker = paramString1;
    this.msgId = paramLong;
    this.CIm = paramString2;
    this.msgType = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203415);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.h(this.talker, paramObject.talker)) || (this.msgId != paramObject.msgId) || (!p.h(this.CIm, paramObject.CIm)) || (this.msgType != paramObject.msgType)) {}
      }
    }
    else
    {
      AppMethodBeat.o(203415);
      return true;
    }
    AppMethodBeat.o(203415);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(203411);
    String str = this.talker;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = this.msgId;
      int k = (int)(l ^ l >>> 32);
      str = this.CIm;
      if (str != null) {
        j = str.hashCode();
      }
      int m = this.msgType;
      AppMethodBeat.o(203411);
      return ((i * 31 + k) * 31 + j) * 31 + m;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203409);
    String str = "GameLifeConversationInfo(talker=" + this.talker + ", msgId=" + this.msgId + ", externInfo=" + this.CIm + ", msgType=" + this.msgType + ")";
    AppMethodBeat.o(203409);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.b
 * JD-Core Version:    0.7.0.1
 */