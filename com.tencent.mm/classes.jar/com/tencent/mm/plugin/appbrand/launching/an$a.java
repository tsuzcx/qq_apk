package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "", "()V", "APPID", "USERNAME", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$APPID;", "plugin-appbrand-integration_release"})
public abstract class an$a
{
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$APPID;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
  public static final class a
    extends an.a
  {
    final String value;
    
    public a(String paramString)
    {
      super();
      AppMethodBeat.i(228700);
      this.value = paramString;
      AppMethodBeat.o(228700);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(228699);
      if ((a)this == paramObject)
      {
        AppMethodBeat.o(228699);
        return true;
      }
      Class localClass2 = getClass();
      if (paramObject != null) {}
      for (Class localClass1 = paramObject.getClass(); (p.j(localClass2, localClass1) ^ true); localClass1 = null)
      {
        AppMethodBeat.o(228699);
        return false;
      }
      if (paramObject == null)
      {
        paramObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.launching.LaunchTimeoutFallbackBackupWxaAttrUtils.KEY.APPID");
        AppMethodBeat.o(228699);
        throw paramObject;
      }
      if ((p.j(this.value, ((a)paramObject).value) ^ true))
      {
        AppMethodBeat.o(228699);
        return false;
      }
      AppMethodBeat.o(228699);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(228698);
      int i = this.value.hashCode();
      AppMethodBeat.o(228698);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(228701);
      String str = "APPID(value=" + this.value + ")";
      AppMethodBeat.o(228701);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
  public static final class b
    extends an.a
  {
    final String value;
    
    public b(String paramString)
    {
      super();
      AppMethodBeat.i(228704);
      this.value = paramString;
      AppMethodBeat.o(228704);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(228703);
      if ((b)this == paramObject)
      {
        AppMethodBeat.o(228703);
        return true;
      }
      Class localClass2 = getClass();
      if (paramObject != null) {}
      for (Class localClass1 = paramObject.getClass(); (p.j(localClass2, localClass1) ^ true); localClass1 = null)
      {
        AppMethodBeat.o(228703);
        return false;
      }
      if (paramObject == null)
      {
        paramObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.launching.LaunchTimeoutFallbackBackupWxaAttrUtils.KEY.USERNAME");
        AppMethodBeat.o(228703);
        throw paramObject;
      }
      if ((p.j(this.value, ((b)paramObject).value) ^ true))
      {
        AppMethodBeat.o(228703);
        return false;
      }
      AppMethodBeat.o(228703);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(228702);
      int i = this.value.hashCode();
      AppMethodBeat.o(228702);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(228705);
      String str = "USERNAME(value=" + this.value + ")";
      AppMethodBeat.o(228705);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.an.a
 * JD-Core Version:    0.7.0.1
 */