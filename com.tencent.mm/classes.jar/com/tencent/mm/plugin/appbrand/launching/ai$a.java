package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "", "()V", "APPID", "USERNAME", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$APPID;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class ai$a
{
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$APPID;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends ai.a
  {
    final String value;
    
    public a(String paramString)
    {
      super();
      AppMethodBeat.i(320653);
      this.value = paramString;
      AppMethodBeat.o(320653);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(320669);
      if (this == paramObject)
      {
        AppMethodBeat.o(320669);
        return true;
      }
      Class localClass = getClass();
      if (paramObject == null) {}
      for (Object localObject = null; !s.p(localClass, localObject); localObject = paramObject.getClass())
      {
        AppMethodBeat.o(320669);
        return false;
      }
      if (paramObject == null)
      {
        paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.launching.LaunchTimeoutFallbackBackupWxaAttrUtils.KEY.APPID");
        AppMethodBeat.o(320669);
        throw paramObject;
      }
      if (!s.p(this.value, ((a)paramObject).value))
      {
        AppMethodBeat.o(320669);
        return false;
      }
      AppMethodBeat.o(320669);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(320660);
      int i = this.value.hashCode();
      AppMethodBeat.o(320660);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(320675);
      String str = "APPID(value=" + this.value + ')';
      AppMethodBeat.o(320675);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends ai.a
  {
    final String value;
    
    public b(String paramString)
    {
      super();
      AppMethodBeat.i(320652);
      this.value = paramString;
      AppMethodBeat.o(320652);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(320663);
      if (this == paramObject)
      {
        AppMethodBeat.o(320663);
        return true;
      }
      Class localClass = getClass();
      if (paramObject == null) {}
      for (Object localObject = null; !s.p(localClass, localObject); localObject = paramObject.getClass())
      {
        AppMethodBeat.o(320663);
        return false;
      }
      if (paramObject == null)
      {
        paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.launching.LaunchTimeoutFallbackBackupWxaAttrUtils.KEY.USERNAME");
        AppMethodBeat.o(320663);
        throw paramObject;
      }
      if (!s.p(this.value, ((b)paramObject).value))
      {
        AppMethodBeat.o(320663);
        return false;
      }
      AppMethodBeat.o(320663);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(320657);
      int i = this.value.hashCode();
      AppMethodBeat.o(320657);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(320666);
      String str = "USERNAME(value=" + this.value + ')';
      AppMethodBeat.o(320666);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ai.a
 * JD-Core Version:    0.7.0.1
 */