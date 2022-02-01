package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "", "()V", "APPID", "USERNAME", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$APPID;", "plugin-appbrand-integration_release"})
public abstract class av$a
{
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$APPID;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
  public static final class a
    extends av.a
  {
    final String value;
    
    public a(String paramString)
    {
      super();
      AppMethodBeat.i(223559);
      this.value = paramString;
      AppMethodBeat.o(223559);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(223558);
      if ((a)this == paramObject)
      {
        AppMethodBeat.o(223558);
        return true;
      }
      Class localClass2 = getClass();
      if (paramObject != null) {}
      for (Class localClass1 = paramObject.getClass(); (p.i(localClass2, localClass1) ^ true); localClass1 = null)
      {
        AppMethodBeat.o(223558);
        return false;
      }
      if (paramObject == null)
      {
        paramObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.launching.LaunchTimeoutFallbackBackupWxaAttrUtils.KEY.APPID");
        AppMethodBeat.o(223558);
        throw paramObject;
      }
      if ((p.i(this.value, ((a)paramObject).value) ^ true))
      {
        AppMethodBeat.o(223558);
        return false;
      }
      AppMethodBeat.o(223558);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(223557);
      int i = this.value.hashCode();
      AppMethodBeat.o(223557);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(223560);
      String str = "APPID(value=" + this.value + ")";
      AppMethodBeat.o(223560);
      return str;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
  public static final class b
    extends av.a
  {
    final String value;
    
    public b(String paramString)
    {
      super();
      AppMethodBeat.i(223563);
      this.value = paramString;
      AppMethodBeat.o(223563);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(223562);
      if ((b)this == paramObject)
      {
        AppMethodBeat.o(223562);
        return true;
      }
      Class localClass2 = getClass();
      if (paramObject != null) {}
      for (Class localClass1 = paramObject.getClass(); (p.i(localClass2, localClass1) ^ true); localClass1 = null)
      {
        AppMethodBeat.o(223562);
        return false;
      }
      if (paramObject == null)
      {
        paramObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.launching.LaunchTimeoutFallbackBackupWxaAttrUtils.KEY.USERNAME");
        AppMethodBeat.o(223562);
        throw paramObject;
      }
      if ((p.i(this.value, ((b)paramObject).value) ^ true))
      {
        AppMethodBeat.o(223562);
        return false;
      }
      AppMethodBeat.o(223562);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(223561);
      int i = this.value.hashCode();
      AppMethodBeat.o(223561);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(223564);
      String str = "USERNAME(value=" + this.value + ")";
      AppMethodBeat.o(223564);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.av.a
 * JD-Core Version:    0.7.0.1
 */