package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dy;
import com.tencent.mm.protocal.protobuf.eax;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "", "scopeInfo", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "alertPrivacyInfo", "Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;", "(Lcom/tencent/mm/protocal/protobuf/ScopeInfo;Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;)V", "getAlertPrivacyInfo", "()Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;", "getScopeInfo", "()Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "luggage-wechat-full-sdk_release"})
public final class d$b
{
  final eax oEw;
  final dy oEx;
  
  public d$b(eax parameax, dy paramdy)
  {
    this.oEw = parameax;
    this.oEx = paramdy;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(147904);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.h(this.oEw, paramObject.oEw)) || (!p.h(this.oEx, paramObject.oEx))) {}
      }
    }
    else
    {
      AppMethodBeat.o(147904);
      return true;
    }
    AppMethodBeat.o(147904);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(147903);
    Object localObject = this.oEw;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.oEx;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(147903);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(147902);
    String str = "Info(scopeInfo=" + this.oEw + ", alertPrivacyInfo=" + this.oEx + ")";
    AppMethodBeat.o(147902);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.d.b
 * JD-Core Version:    0.7.0.1
 */