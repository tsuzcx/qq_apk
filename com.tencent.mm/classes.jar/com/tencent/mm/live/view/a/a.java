package com.tencent.mm.live.view.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/adapter/CommentData;", "", "identityId", "", "headImageUrl", "content", "", "msgType", "", "time", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;II)V", "getContent", "()Ljava/lang/CharSequence;", "setContent", "(Ljava/lang/CharSequence;)V", "getHeadImageUrl", "()Ljava/lang/String;", "setHeadImageUrl", "(Ljava/lang/String;)V", "getIdentityId", "setIdentityId", "getMsgType", "()I", "setMsgType", "(I)V", "getTime", "setTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
public final class a
{
  public String hXp;
  String hXq;
  public CharSequence hXr;
  public int hXs;
  public int msgType;
  
  public a(String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208648);
    this.hXp = paramString1;
    this.hXq = paramString2;
    this.hXr = paramCharSequence;
    this.msgType = paramInt1;
    this.hXs = paramInt2;
    AppMethodBeat.o(208648);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(208652);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.j(this.hXp, paramObject.hXp)) || (!p.j(this.hXq, paramObject.hXq)) || (!p.j(this.hXr, paramObject.hXr)) || (this.msgType != paramObject.msgType) || (this.hXs != paramObject.hXs)) {}
      }
    }
    else
    {
      AppMethodBeat.o(208652);
      return true;
    }
    AppMethodBeat.o(208652);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(208651);
    Object localObject = this.hXp;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.hXq;
      if (localObject == null) {
        break label104;
      }
    }
    label104:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.hXr;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      int m = this.msgType;
      int n = this.hXs;
      AppMethodBeat.o(208651);
      return (((j + i * 31) * 31 + k) * 31 + m) * 31 + n;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(208650);
    String str = "CommentData(identityId=" + this.hXp + ", headImageUrl=" + this.hXq + ", content=" + this.hXr + ", msgType=" + this.msgType + ", time=" + this.hXs + ")";
    AppMethodBeat.o(208650);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.view.a.a
 * JD-Core Version:    0.7.0.1
 */