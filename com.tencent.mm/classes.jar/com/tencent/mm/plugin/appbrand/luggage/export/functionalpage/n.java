package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/InvokeCallbackContext;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CallbackContext;", "transitiveData", "", "(Ljava/lang/String;)V", "getTransitiveData", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
final class n
  extends a
{
  final String hiO;
  
  public n(String paramString)
  {
    super((byte)0);
    this.hiO = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(134753);
    if (this != paramObject)
    {
      if ((paramObject instanceof n))
      {
        paramObject = (n)paramObject;
        if (!j.e(this.hiO, paramObject.hiO)) {}
      }
    }
    else
    {
      AppMethodBeat.o(134753);
      return true;
    }
    AppMethodBeat.o(134753);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(134752);
    String str = this.hiO;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(134752);
      return i;
    }
    AppMethodBeat.o(134752);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(134751);
    String str = "InvokeCallbackContext(transitiveData=" + this.hiO + ")";
    AppMethodBeat.o(134751);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.n
 * JD-Core Version:    0.7.0.1
 */