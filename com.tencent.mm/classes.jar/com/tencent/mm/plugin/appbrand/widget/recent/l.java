package com.tencent.mm.plugin.appbrand.widget.recent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.a.e;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/recent/QueryCacheConfig;", "", "args", "", "([Ljava/lang/Object;)V", "getArgs", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "toString", "", "plugin-appbrand-integration_release"})
public class l
{
  final Object[] args;
  
  public l(Object... paramVarArgs)
  {
    AppMethodBeat.i(272257);
    this.args = paramVarArgs;
    AppMethodBeat.o(272257);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(272256);
    if ((l)this == paramObject)
    {
      AppMethodBeat.o(272256);
      return true;
    }
    if (paramObject == null)
    {
      paramObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.widget.recent.QueryCacheConfig");
      AppMethodBeat.o(272256);
      throw paramObject;
    }
    if (!Arrays.equals(this.args, ((l)paramObject).args))
    {
      AppMethodBeat.o(272256);
      return false;
    }
    AppMethodBeat.o(272256);
    return true;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(272255);
    int i = toString().hashCode();
    AppMethodBeat.o(272255);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(272254);
    String str = e.a(this.args, null, null, null, 0, null, (b)a.rFu, 31);
    AppMethodBeat.o(272254);
    return str;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements b<Object, CharSequence>
  {
    public static final a rFu;
    
    static
    {
      AppMethodBeat.i(278514);
      rFu = new a();
      AppMethodBeat.o(278514);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.l
 * JD-Core Version:    0.7.0.1
 */