package com.tencent.mm.live.view.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/view/adapter/CommentData;", "", "identityId", "", "headImageUrl", "content", "", "msgType", "", "time", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;II)V", "getContent", "()Ljava/lang/CharSequence;", "setContent", "(Ljava/lang/CharSequence;)V", "getHeadImageUrl", "()Ljava/lang/String;", "setHeadImageUrl", "(Ljava/lang/String;)V", "getIdentityId", "setIdentityId", "getMsgType", "()I", "setMsgType", "(I)V", "getTime", "setTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
public final class a
{
  String BKj;
  String GgK;
  CharSequence ibX;
  public int msgType;
  public int tGD;
  
  public a(String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203515);
    this.BKj = paramString1;
    this.GgK = paramString2;
    this.ibX = paramCharSequence;
    this.msgType = paramInt1;
    this.tGD = paramInt2;
    AppMethodBeat.o(203515);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203519);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!k.g(this.BKj, paramObject.BKj)) || (!k.g(this.GgK, paramObject.GgK)) || (!k.g(this.ibX, paramObject.ibX)) || (this.msgType != paramObject.msgType) || (this.tGD != paramObject.tGD)) {}
      }
    }
    else
    {
      AppMethodBeat.o(203519);
      return true;
    }
    AppMethodBeat.o(203519);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(203518);
    Object localObject = this.BKj;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.GgK;
      if (localObject == null) {
        break label104;
      }
    }
    label104:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.ibX;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      int m = this.msgType;
      int n = this.tGD;
      AppMethodBeat.o(203518);
      return (((j + i * 31) * 31 + k) * 31 + m) * 31 + n;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203517);
    String str = "CommentData(identityId=" + this.BKj + ", headImageUrl=" + this.GgK + ", content=" + this.ibX + ", msgType=" + this.msgType + ", time=" + this.tGD + ")";
    AppMethodBeat.o(203517);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.view.a.a
 * JD-Core Version:    0.7.0.1
 */