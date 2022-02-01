package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "", "()V", "InvokeCallbackContext", "NavigateBackCallbackContext", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$InvokeCallbackContext;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$NavigateBackCallbackContext;", "plugin-appbrand-integration_release"})
public abstract class q$a
{
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$InvokeCallbackContext;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "transitiveData", "", "(Ljava/lang/String;)V", "getTransitiveData", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
  public static final class a
    extends q.a
  {
    final String jXV;
    
    public a(String paramString)
    {
      super();
      this.jXV = paramString;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(189361);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (!p.i(this.jXV, paramObject.jXV)) {}
        }
      }
      else
      {
        AppMethodBeat.o(189361);
        return true;
      }
      AppMethodBeat.o(189361);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(189360);
      String str = this.jXV;
      if (str != null)
      {
        int i = str.hashCode();
        AppMethodBeat.o(189360);
        return i;
      }
      AppMethodBeat.o(189360);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(189359);
      String str = "InvokeCallbackContext(transitiveData=" + this.jXV + ")";
      AppMethodBeat.o(189359);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext$NavigateBackCallbackContext;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/LegacySDKInvokeProcess$CallbackContext;", "()V", "plugin-appbrand-integration_release"})
  public static final class b
    extends q.a
  {
    public static final b lOG;
    
    static
    {
      AppMethodBeat.i(189362);
      lOG = new b();
      AppMethodBeat.o(189362);
    }
    
    private b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.q.a
 * JD-Core Version:    0.7.0.1
 */