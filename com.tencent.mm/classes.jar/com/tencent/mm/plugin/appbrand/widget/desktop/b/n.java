package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.g.a.b;
import d.g.b.q;
import d.l;
import d.v;
import java.util.Arrays;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "", "args", "", "([Ljava/lang/Object;)V", "getArgs", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "toString", "", "plugin-appbrand-integration_release"})
public class n
{
  final Object[] args;
  
  public n(Object... paramVarArgs)
  {
    AppMethodBeat.i(189736);
    this.args = paramVarArgs;
    AppMethodBeat.o(189736);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(189735);
    if ((n)this == paramObject)
    {
      AppMethodBeat.o(189735);
      return true;
    }
    if (paramObject == null)
    {
      paramObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.widget.desktop.helper.QueryCacheConfig");
      AppMethodBeat.o(189735);
      throw paramObject;
    }
    if (!Arrays.equals(this.args, ((n)paramObject).args))
    {
      AppMethodBeat.o(189735);
      return false;
    }
    AppMethodBeat.o(189735);
    return true;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(189734);
    int i = toString().hashCode();
    AppMethodBeat.o(189734);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(189733);
    String str = e.a(this.args, null, null, null, 0, null, (b)a.naL, 31);
    AppMethodBeat.o(189733);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements b<Object, CharSequence>
  {
    public static final a naL;
    
    static
    {
      AppMethodBeat.i(189732);
      naL = new a();
      AppMethodBeat.o(189732);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.n
 * JD-Core Version:    0.7.0.1
 */