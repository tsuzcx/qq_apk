package com.tencent.mm.live.view.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/view/adapter/CommentData;", "", "identityId", "", "headImageUrl", "content", "", "msgType", "", "time", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;II)V", "getContent", "()Ljava/lang/CharSequence;", "setContent", "(Ljava/lang/CharSequence;)V", "getHeadImageUrl", "()Ljava/lang/String;", "setHeadImageUrl", "(Ljava/lang/String;)V", "getIdentityId", "setIdentityId", "getMsgType", "()I", "setMsgType", "(I)V", "getTime", "setTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
public final class a
{
  public String hbO;
  String hbP;
  public CharSequence hbQ;
  public int hbR;
  public int msgType;
  
  public a(String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(213045);
    this.hbO = paramString1;
    this.hbP = paramString2;
    this.hbQ = paramCharSequence;
    this.msgType = paramInt1;
    this.hbR = paramInt2;
    AppMethodBeat.o(213045);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(213049);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.i(this.hbO, paramObject.hbO)) || (!p.i(this.hbP, paramObject.hbP)) || (!p.i(this.hbQ, paramObject.hbQ)) || (this.msgType != paramObject.msgType) || (this.hbR != paramObject.hbR)) {}
      }
    }
    else
    {
      AppMethodBeat.o(213049);
      return true;
    }
    AppMethodBeat.o(213049);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(213048);
    Object localObject = this.hbO;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.hbP;
      if (localObject == null) {
        break label104;
      }
    }
    label104:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.hbQ;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      int m = this.msgType;
      int n = this.hbR;
      AppMethodBeat.o(213048);
      return (((j + i * 31) * 31 + k) * 31 + m) * 31 + n;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(213047);
    String str = "CommentData(identityId=" + this.hbO + ", headImageUrl=" + this.hbP + ", content=" + this.hbQ + ", msgType=" + this.msgType + ", time=" + this.hbR + ")";
    AppMethodBeat.o(213047);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.view.a.a
 * JD-Core Version:    0.7.0.1
 */