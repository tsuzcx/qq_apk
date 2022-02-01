package com.tencent.mm.plugin.appbrand.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "", "()V", "APPID", "USERNAME", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$APPID;", "plugin-appbrand-integration_release"})
public abstract class b$a
{
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$APPID;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
  public static final class a
    extends b.a
  {
    final String value;
    
    public a(String paramString)
    {
      super();
      AppMethodBeat.i(228172);
      this.value = paramString;
      AppMethodBeat.o(228172);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(228175);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (!p.j(this.value, paramObject.value)) {}
        }
      }
      else
      {
        AppMethodBeat.o(228175);
        return true;
      }
      AppMethodBeat.o(228175);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(228174);
      String str = this.value;
      if (str != null)
      {
        int i = str.hashCode();
        AppMethodBeat.o(228174);
        return i;
      }
      AppMethodBeat.o(228174);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(228173);
      String str = "APPID(value=" + this.value + ")";
      AppMethodBeat.o(228173);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
  public static final class b
    extends b.a
  {
    final String value;
    
    public b(String paramString)
    {
      super();
      AppMethodBeat.i(228176);
      this.value = paramString;
      AppMethodBeat.o(228176);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(228179);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if (!p.j(this.value, paramObject.value)) {}
        }
      }
      else
      {
        AppMethodBeat.o(228179);
        return true;
      }
      AppMethodBeat.o(228179);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(228178);
      String str = this.value;
      if (str != null)
      {
        int i = str.hashCode();
        AppMethodBeat.o(228178);
        return i;
      }
      AppMethodBeat.o(228178);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(228177);
      String str = "USERNAME(value=" + this.value + ")";
      AppMethodBeat.o(228177);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.b.a
 * JD-Core Version:    0.7.0.1
 */