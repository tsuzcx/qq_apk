package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cxm;
import com.tencent.mm.protocal.protobuf.do;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "", "scopeInfo", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "alertPrivacyInfo", "Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;", "(Lcom/tencent/mm/protocal/protobuf/ScopeInfo;Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;)V", "getAlertPrivacyInfo", "()Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;", "getScopeInfo", "()Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "luggage-wechat-full-sdk_release"})
public final class d$b
{
  final cxm kAt;
  final do kAu;
  
  public d$b(cxm paramcxm, do paramdo)
  {
    this.kAt = paramcxm;
    this.kAu = paramdo;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(147904);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.i(this.kAt, paramObject.kAt)) || (!p.i(this.kAu, paramObject.kAu))) {}
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
    Object localObject = this.kAt;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.kAu;
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
    String str = "Info(scopeInfo=" + this.kAt + ", alertPrivacyInfo=" + this.kAu + ")";
    AppMethodBeat.o(147902);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.d.b
 * JD-Core Version:    0.7.0.1
 */