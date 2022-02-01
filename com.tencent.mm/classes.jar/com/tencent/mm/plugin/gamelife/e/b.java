package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationInfo;", "", "talker", "", "msgId", "", "externInfo", "msgType", "", "(Ljava/lang/String;JLjava/lang/String;I)V", "getExternInfo", "()Ljava/lang/String;", "setExternInfo", "(Ljava/lang/String;)V", "getMsgId", "()J", "setMsgId", "(J)V", "getMsgType", "()I", "setMsgType", "(I)V", "getTalker", "setTalker", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-gamelife_release"})
public final class b
{
  public long msgId;
  public int msgType;
  public String talker;
  public String xEl;
  
  public b(String paramString1, long paramLong, String paramString2, int paramInt)
  {
    this.talker = paramString1;
    this.msgId = paramLong;
    this.xEl = paramString2;
    this.msgType = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(241344);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.j(this.talker, paramObject.talker)) || (this.msgId != paramObject.msgId) || (!p.j(this.xEl, paramObject.xEl)) || (this.msgType != paramObject.msgType)) {}
      }
    }
    else
    {
      AppMethodBeat.o(241344);
      return true;
    }
    AppMethodBeat.o(241344);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(241343);
    String str = this.talker;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = this.msgId;
      int k = (int)(l ^ l >>> 32);
      str = this.xEl;
      if (str != null) {
        j = str.hashCode();
      }
      int m = this.msgType;
      AppMethodBeat.o(241343);
      return ((i * 31 + k) * 31 + j) * 31 + m;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(241342);
    String str = "GameLifeConversationInfo(talker=" + this.talker + ", msgId=" + this.msgId + ", externInfo=" + this.xEl + ", msgType=" + this.msgType + ")";
    AppMethodBeat.o(241342);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.b
 * JD-Core Version:    0.7.0.1
 */