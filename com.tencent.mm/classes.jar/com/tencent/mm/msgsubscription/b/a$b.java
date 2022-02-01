package com.tencent.mm.msgsubscription.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService$UpdateSubscribeStatusTask;", "", "bizUsername", "", "templateId", "uiStatus", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getBizUsername", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "getCallback", "()Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "setCallback", "(Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;)V", "getTemplateId", "getUiStatus", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-comm_release"})
public final class a$b
{
  private final int fMY;
  final String fOX;
  final String lnb;
  ISubscribeMsgService.b mpg;
  
  public a$b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(194092);
    this.fOX = paramString1;
    this.lnb = paramString2;
    this.fMY = paramInt;
    AppMethodBeat.o(194092);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(194099);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.h(this.fOX, paramObject.fOX)) || (!p.h(this.lnb, paramObject.lnb)) || (this.fMY != paramObject.fMY)) {}
      }
    }
    else
    {
      AppMethodBeat.o(194099);
      return true;
    }
    AppMethodBeat.o(194099);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(194097);
    String str = this.fOX;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.lnb;
      if (str != null) {
        j = str.hashCode();
      }
      int k = this.fMY;
      AppMethodBeat.o(194097);
      return (i * 31 + j) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(194095);
    String str = "UpdateSubscribeStatusTask(bizUsername=" + this.fOX + ", templateId=" + this.lnb + ", uiStatus=" + this.fMY + ")";
    AppMethodBeat.o(194095);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.b.a.b
 * JD-Core Version:    0.7.0.1
 */