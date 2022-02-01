package com.tencent.mm.live.view.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/view/adapter/CommentData;", "", "identityId", "", "headImageUrl", "content", "", "msgType", "", "time", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;II)V", "getContent", "()Ljava/lang/CharSequence;", "setContent", "(Ljava/lang/CharSequence;)V", "getHeadImageUrl", "()Ljava/lang/String;", "setHeadImageUrl", "(Ljava/lang/String;)V", "getIdentityId", "setIdentityId", "getMsgType", "()I", "setMsgType", "(I)V", "getTime", "setTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
public final class a
{
  public String gIe;
  String gIf;
  public CharSequence gIg;
  public int gIh;
  public int msgType;
  
  public a(String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190755);
    this.gIe = paramString1;
    this.gIf = paramString2;
    this.gIg = paramCharSequence;
    this.msgType = paramInt1;
    this.gIh = paramInt2;
    AppMethodBeat.o(190755);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(190759);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!k.g(this.gIe, paramObject.gIe)) || (!k.g(this.gIf, paramObject.gIf)) || (!k.g(this.gIg, paramObject.gIg)) || (this.msgType != paramObject.msgType) || (this.gIh != paramObject.gIh)) {}
      }
    }
    else
    {
      AppMethodBeat.o(190759);
      return true;
    }
    AppMethodBeat.o(190759);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(190758);
    Object localObject = this.gIe;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.gIf;
      if (localObject == null) {
        break label104;
      }
    }
    label104:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.gIg;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      int m = this.msgType;
      int n = this.gIh;
      AppMethodBeat.o(190758);
      return (((j + i * 31) * 31 + k) * 31 + m) * 31 + n;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190757);
    String str = "CommentData(identityId=" + this.gIe + ", headImageUrl=" + this.gIf + ", content=" + this.gIg + ", msgType=" + this.msgType + ", time=" + this.gIh + ")";
    AppMethodBeat.o(190757);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.a.a
 * JD-Core Version:    0.7.0.1
 */