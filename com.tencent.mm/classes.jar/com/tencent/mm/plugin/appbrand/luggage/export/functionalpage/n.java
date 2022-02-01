package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/InvokeCallbackContext;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CallbackContext;", "transitiveData", "", "(Ljava/lang/String;)V", "getTransitiveData", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
final class n
  extends a
{
  final String jDU;
  
  public n(String paramString)
  {
    super((byte)0);
    this.jDU = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(50882);
    if (this != paramObject)
    {
      if ((paramObject instanceof n))
      {
        paramObject = (n)paramObject;
        if (!k.g(this.jDU, paramObject.jDU)) {}
      }
    }
    else
    {
      AppMethodBeat.o(50882);
      return true;
    }
    AppMethodBeat.o(50882);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(50881);
    String str = this.jDU;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(50881);
      return i;
    }
    AppMethodBeat.o(50881);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(50880);
    String str = "InvokeCallbackContext(transitiveData=" + this.jDU + ")";
    AppMethodBeat.o(50880);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.n
 * JD-Core Version:    0.7.0.1
 */