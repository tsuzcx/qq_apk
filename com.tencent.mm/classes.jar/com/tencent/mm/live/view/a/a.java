package com.tencent.mm.live.view.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/view/adapter/CommentData;", "", "identityId", "", "headImageUrl", "content", "", "msgType", "", "time", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;II)V", "getContent", "()Ljava/lang/CharSequence;", "setContent", "(Ljava/lang/CharSequence;)V", "getHeadImageUrl", "()Ljava/lang/String;", "setHeadImageUrl", "(Ljava/lang/String;)V", "getIdentityId", "setIdentityId", "getMsgType", "()I", "setMsgType", "(I)V", "getTime", "setTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
public final class a
{
  public String kLV;
  String kLW;
  public CharSequence kLX;
  public int msgType;
  public int time;
  
  public a(String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193452);
    this.kLV = paramString1;
    this.kLW = paramString2;
    this.kLX = paramCharSequence;
    this.msgType = paramInt1;
    this.time = paramInt2;
    AppMethodBeat.o(193452);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(193457);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.h(this.kLV, paramObject.kLV)) || (!p.h(this.kLW, paramObject.kLW)) || (!p.h(this.kLX, paramObject.kLX)) || (this.msgType != paramObject.msgType) || (this.time != paramObject.time)) {}
      }
    }
    else
    {
      AppMethodBeat.o(193457);
      return true;
    }
    AppMethodBeat.o(193457);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(193456);
    Object localObject = this.kLV;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.kLW;
      if (localObject == null) {
        break label104;
      }
    }
    label104:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.kLX;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      int m = this.msgType;
      int n = this.time;
      AppMethodBeat.o(193456);
      return (((j + i * 31) * 31 + k) * 31 + m) * 31 + n;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(193455);
    String str = "CommentData(identityId=" + this.kLV + ", headImageUrl=" + this.kLW + ", content=" + this.kLX + ", msgType=" + this.msgType + ", time=" + this.time + ")";
    AppMethodBeat.o(193455);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.view.a.a
 * JD-Core Version:    0.7.0.1
 */