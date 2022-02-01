package com.tencent.mm.live.view.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/view/adapter/CommentData;", "", "identityId", "", "headImageUrl", "content", "", "msgType", "", "time", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;II)V", "getContent", "()Ljava/lang/CharSequence;", "setContent", "(Ljava/lang/CharSequence;)V", "getHeadImageUrl", "()Ljava/lang/String;", "setHeadImageUrl", "(Ljava/lang/String;)V", "getIdentityId", "setIdentityId", "getMsgType", "()I", "setMsgType", "(I)V", "getTime", "setTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
public final class a
{
  public String heC;
  String heD;
  public CharSequence heE;
  public int heF;
  public int msgType;
  
  public a(String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216675);
    this.heC = paramString1;
    this.heD = paramString2;
    this.heE = paramCharSequence;
    this.msgType = paramInt1;
    this.heF = paramInt2;
    AppMethodBeat.o(216675);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(216679);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.i(this.heC, paramObject.heC)) || (!p.i(this.heD, paramObject.heD)) || (!p.i(this.heE, paramObject.heE)) || (this.msgType != paramObject.msgType) || (this.heF != paramObject.heF)) {}
      }
    }
    else
    {
      AppMethodBeat.o(216679);
      return true;
    }
    AppMethodBeat.o(216679);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(216678);
    Object localObject = this.heC;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.heD;
      if (localObject == null) {
        break label104;
      }
    }
    label104:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.heE;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      int m = this.msgType;
      int n = this.heF;
      AppMethodBeat.o(216678);
      return (((j + i * 31) * 31 + k) * 31 + m) * 31 + n;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(216677);
    String str = "CommentData(identityId=" + this.heC + ", headImageUrl=" + this.heD + ", content=" + this.heE + ", msgType=" + this.msgType + ", time=" + this.heF + ")";
    AppMethodBeat.o(216677);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.view.a.a
 * JD-Core Version:    0.7.0.1
 */