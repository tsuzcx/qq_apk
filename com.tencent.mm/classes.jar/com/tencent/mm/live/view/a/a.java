package com.tencent.mm.live.view.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/view/adapter/CommentData;", "", "identityId", "", "headImageUrl", "content", "", "msgType", "", "time", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;II)V", "getContent", "()Ljava/lang/CharSequence;", "setContent", "(Ljava/lang/CharSequence;)V", "getHeadImageUrl", "()Ljava/lang/String;", "setHeadImageUrl", "(Ljava/lang/String;)V", "getIdentityId", "setIdentityId", "getMsgType", "()I", "setMsgType", "(I)V", "getTime", "setTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public int msgType;
  public String nnR;
  String nnS;
  public CharSequence nnT;
  public int time;
  
  public a(String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(246204);
    this.nnR = paramString1;
    this.nnS = paramString2;
    this.nnT = paramCharSequence;
    this.msgType = paramInt1;
    this.time = paramInt2;
    AppMethodBeat.o(246204);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(246238);
    if (this == paramObject)
    {
      AppMethodBeat.o(246238);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(246238);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.nnR, paramObject.nnR))
    {
      AppMethodBeat.o(246238);
      return false;
    }
    if (!s.p(this.nnS, paramObject.nnS))
    {
      AppMethodBeat.o(246238);
      return false;
    }
    if (!s.p(this.nnT, paramObject.nnT))
    {
      AppMethodBeat.o(246238);
      return false;
    }
    if (this.msgType != paramObject.msgType)
    {
      AppMethodBeat.o(246238);
      return false;
    }
    if (this.time != paramObject.time)
    {
      AppMethodBeat.o(246238);
      return false;
    }
    AppMethodBeat.o(246238);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(246231);
    int i = this.nnR.hashCode();
    int j = this.nnS.hashCode();
    int k = this.nnT.hashCode();
    int m = this.msgType;
    int n = this.time;
    AppMethodBeat.o(246231);
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(246222);
    String str = "CommentData(identityId=" + this.nnR + ", headImageUrl=" + this.nnS + ", content=" + this.nnT + ", msgType=" + this.msgType + ", time=" + this.time + ')';
    AppMethodBeat.o(246222);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.a.a
 * JD-Core Version:    0.7.0.1
 */