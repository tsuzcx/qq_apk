package com.tencent.mm.plugin.appbrand.launching;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "", "()V", "FallbackIfTimeout", "NoFallback", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$NoFallback;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$FallbackIfTimeout;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class ai$c
{
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$FallbackIfTimeout;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "timeoutMs", "", "(J)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends ai.c
  {
    public final long tbs;
    
    public a(long paramLong)
    {
      super();
      this.tbs = paramLong;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
      } while (this.tbs == paramObject.tbs);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(320620);
      int i = q.a..ExternalSyntheticBackport0.m(this.tbs);
      AppMethodBeat.o(320620);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(320616);
      String str = "FallbackIfTimeout[" + this.tbs + "ms]";
      AppMethodBeat.o(320616);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$NoFallback;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "()V", "toString", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends ai.c
  {
    public static final b tbt;
    
    static
    {
      AppMethodBeat.i(320618);
      tbt = new b();
      AppMethodBeat.o(320618);
    }
    
    private b()
    {
      super();
    }
    
    public final String toString()
    {
      return "NoFallback";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ai.c
 * JD-Core Version:    0.7.0.1
 */