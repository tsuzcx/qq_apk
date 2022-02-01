package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "", "()V", "APPID", "USERNAME", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$APPID;", "plugin-appbrand-integration_release"})
public abstract class ah$a
{
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$APPID;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
  public static final class a
    extends ah.a
  {
    final String value;
    
    public a(String paramString)
    {
      super();
      AppMethodBeat.i(270392);
      this.value = paramString;
      AppMethodBeat.o(270392);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(270391);
      if ((a)this == paramObject)
      {
        AppMethodBeat.o(270391);
        return true;
      }
      Class localClass2 = getClass();
      if (paramObject != null) {}
      for (Class localClass1 = paramObject.getClass(); (p.h(localClass2, localClass1) ^ true); localClass1 = null)
      {
        AppMethodBeat.o(270391);
        return false;
      }
      if (paramObject == null)
      {
        paramObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.launching.LaunchTimeoutFallbackBackupWxaAttrUtils.KEY.APPID");
        AppMethodBeat.o(270391);
        throw paramObject;
      }
      if ((p.h(this.value, ((a)paramObject).value) ^ true))
      {
        AppMethodBeat.o(270391);
        return false;
      }
      AppMethodBeat.o(270391);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(270390);
      int i = this.value.hashCode();
      AppMethodBeat.o(270390);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(270393);
      String str = "APPID(value=" + this.value + ")";
      AppMethodBeat.o(270393);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
  public static final class b
    extends ah.a
  {
    final String value;
    
    public b(String paramString)
    {
      super();
      AppMethodBeat.i(245988);
      this.value = paramString;
      AppMethodBeat.o(245988);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(245987);
      if ((b)this == paramObject)
      {
        AppMethodBeat.o(245987);
        return true;
      }
      Class localClass2 = getClass();
      if (paramObject != null) {}
      for (Class localClass1 = paramObject.getClass(); (p.h(localClass2, localClass1) ^ true); localClass1 = null)
      {
        AppMethodBeat.o(245987);
        return false;
      }
      if (paramObject == null)
      {
        paramObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.launching.LaunchTimeoutFallbackBackupWxaAttrUtils.KEY.USERNAME");
        AppMethodBeat.o(245987);
        throw paramObject;
      }
      if ((p.h(this.value, ((b)paramObject).value) ^ true))
      {
        AppMethodBeat.o(245987);
        return false;
      }
      AppMethodBeat.o(245987);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(245986);
      int i = this.value.hashCode();
      AppMethodBeat.o(245986);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(245989);
      String str = "USERNAME(value=" + this.value + ")";
      AppMethodBeat.o(245989);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ah.a
 * JD-Core Version:    0.7.0.1
 */