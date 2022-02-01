package com.tencent.mm.plugin.appbrand.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "", "()V", "APPID", "USERNAME", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$APPID;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b$a
{
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends b.a
  {
    final String value;
    
    public a(String paramString)
    {
      super();
      AppMethodBeat.i(323464);
      this.value = paramString;
      AppMethodBeat.o(323464);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(323476);
      if (this == paramObject)
      {
        AppMethodBeat.o(323476);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(323476);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.value, paramObject.value))
      {
        AppMethodBeat.o(323476);
        return false;
      }
      AppMethodBeat.o(323476);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(323473);
      int i = this.value.hashCode();
      AppMethodBeat.o(323473);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(323468);
      String str = "USERNAME(value=" + this.value + ')';
      AppMethodBeat.o(323468);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.b.a
 * JD-Core Version:    0.7.0.1
 */