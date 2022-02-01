package com.tencent.mm.msgsubscription.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService$UpdateSubscribeStatusTask;", "", "bizUsername", "", "templateId", "uiStatus", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getBizUsername", "()Ljava/lang/String;", "getTemplateId", "getUiStatus", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-comm_release"})
public final class a$b
{
  private final int drk;
  final String dta;
  final String gIj;
  
  public a$b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(149598);
    this.dta = paramString1;
    this.gIj = paramString2;
    this.drk = paramInt;
    AppMethodBeat.o(149598);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(149601);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!k.g(this.dta, paramObject.dta)) || (!k.g(this.gIj, paramObject.gIj)) || (this.drk != paramObject.drk)) {}
      }
    }
    else
    {
      AppMethodBeat.o(149601);
      return true;
    }
    AppMethodBeat.o(149601);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(149600);
    String str = this.dta;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.gIj;
      if (str != null) {
        j = str.hashCode();
      }
      int k = this.drk;
      AppMethodBeat.o(149600);
      return (i * 31 + j) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149599);
    String str = "UpdateSubscribeStatusTask(bizUsername=" + this.dta + ", templateId=" + this.gIj + ", uiStatus=" + this.drk + ")";
    AppMethodBeat.o(149599);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.storage.a.b
 * JD-Core Version:    0.7.0.1
 */