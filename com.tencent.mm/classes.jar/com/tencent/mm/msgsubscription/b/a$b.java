package com.tencent.mm.msgsubscription.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService$UpdateSubscribeStatusTask;", "", "bizUsername", "", "templateId", "uiStatus", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getBizUsername", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "getCallback", "()Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "setCallback", "(Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;)V", "getTemplateId", "getUiStatus", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-comm_release"})
public final class a$b
{
  private final int dTD;
  final String dVu;
  final String ixM;
  ISubscribeMsgService.b jzA;
  
  public a$b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(223239);
    this.dVu = paramString1;
    this.ixM = paramString2;
    this.dTD = paramInt;
    AppMethodBeat.o(223239);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(223242);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.j(this.dVu, paramObject.dVu)) || (!p.j(this.ixM, paramObject.ixM)) || (this.dTD != paramObject.dTD)) {}
      }
    }
    else
    {
      AppMethodBeat.o(223242);
      return true;
    }
    AppMethodBeat.o(223242);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(223241);
    String str = this.dVu;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.ixM;
      if (str != null) {
        j = str.hashCode();
      }
      int k = this.dTD;
      AppMethodBeat.o(223241);
      return (i * 31 + j) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(223240);
    String str = "UpdateSubscribeStatusTask(bizUsername=" + this.dVu + ", templateId=" + this.ixM + ", uiStatus=" + this.dTD + ")";
    AppMethodBeat.o(223240);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.b.a.b
 * JD-Core Version:    0.7.0.1
 */