package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "", "()V", "APPID", "USERNAME", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$APPID;", "plugin-appbrand-integration_release"})
public abstract class av$a
{
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$APPID;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
  public static final class a
    extends av.a
  {
    final String value;
    
    public a(String paramString)
    {
      super();
      AppMethodBeat.i(189301);
      this.value = paramString;
      AppMethodBeat.o(189301);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(189300);
      if ((a)this == paramObject)
      {
        AppMethodBeat.o(189300);
        return true;
      }
      Class localClass2 = getClass();
      if (paramObject != null) {}
      for (Class localClass1 = paramObject.getClass(); (p.i(localClass2, localClass1) ^ true); localClass1 = null)
      {
        AppMethodBeat.o(189300);
        return false;
      }
      if (paramObject == null)
      {
        paramObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.launching.LaunchTimeoutFallbackBackupWxaAttrUtils.KEY.APPID");
        AppMethodBeat.o(189300);
        throw paramObject;
      }
      if ((p.i(this.value, ((a)paramObject).value) ^ true))
      {
        AppMethodBeat.o(189300);
        return false;
      }
      AppMethodBeat.o(189300);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(189299);
      int i = this.value.hashCode();
      AppMethodBeat.o(189299);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(189302);
      String str = "APPID(value=" + this.value + ")";
      AppMethodBeat.o(189302);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
  public static final class b
    extends av.a
  {
    final String value;
    
    public b(String paramString)
    {
      super();
      AppMethodBeat.i(189305);
      this.value = paramString;
      AppMethodBeat.o(189305);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(189304);
      if ((b)this == paramObject)
      {
        AppMethodBeat.o(189304);
        return true;
      }
      Class localClass2 = getClass();
      if (paramObject != null) {}
      for (Class localClass1 = paramObject.getClass(); (p.i(localClass2, localClass1) ^ true); localClass1 = null)
      {
        AppMethodBeat.o(189304);
        return false;
      }
      if (paramObject == null)
      {
        paramObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.launching.LaunchTimeoutFallbackBackupWxaAttrUtils.KEY.USERNAME");
        AppMethodBeat.o(189304);
        throw paramObject;
      }
      if ((p.i(this.value, ((b)paramObject).value) ^ true))
      {
        AppMethodBeat.o(189304);
        return false;
      }
      AppMethodBeat.o(189304);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(189303);
      int i = this.value.hashCode();
      AppMethodBeat.o(189303);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(189306);
      String str = "USERNAME(value=" + this.value + ")";
      AppMethodBeat.o(189306);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.av.a
 * JD-Core Version:    0.7.0.1
 */