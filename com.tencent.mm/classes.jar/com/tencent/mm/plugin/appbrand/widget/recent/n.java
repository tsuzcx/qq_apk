package com.tencent.mm.plugin.appbrand.widget.recent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.a.e;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/recent/QueryCacheConfig;", "", "args", "", "([Ljava/lang/Object;)V", "getArgs", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "toString", "", "plugin-appbrand-integration_release"})
public class n
{
  final Object[] args;
  
  public n(Object... paramVarArgs)
  {
    AppMethodBeat.i(229688);
    this.args = paramVarArgs;
    AppMethodBeat.o(229688);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(229687);
    if ((n)this == paramObject)
    {
      AppMethodBeat.o(229687);
      return true;
    }
    if (paramObject == null)
    {
      paramObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.widget.recent.QueryCacheConfig");
      AppMethodBeat.o(229687);
      throw paramObject;
    }
    if (!Arrays.equals(this.args, ((n)paramObject).args))
    {
      AppMethodBeat.o(229687);
      return false;
    }
    AppMethodBeat.o(229687);
    return true;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(229686);
    int i = toString().hashCode();
    AppMethodBeat.o(229686);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(229685);
    String str = e.a(this.args, null, null, null, 0, null, (b)a.oDN, 31);
    AppMethodBeat.o(229685);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements b<Object, CharSequence>
  {
    public static final a oDN;
    
    static
    {
      AppMethodBeat.i(229684);
      oDN = new a();
      AppMethodBeat.o(229684);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.n
 * JD-Core Version:    0.7.0.1
 */