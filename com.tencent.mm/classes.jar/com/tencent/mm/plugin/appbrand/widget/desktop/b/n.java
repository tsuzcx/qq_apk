package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.g.a.b;
import d.v;
import java.util.Arrays;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "", "args", "", "([Ljava/lang/Object;)V", "getArgs", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "toString", "", "plugin-appbrand-integration_release"})
public class n
{
  final Object[] args;
  
  public n(Object... paramVarArgs)
  {
    AppMethodBeat.i(196544);
    this.args = paramVarArgs;
    AppMethodBeat.o(196544);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(196543);
    if ((n)this == paramObject)
    {
      AppMethodBeat.o(196543);
      return true;
    }
    if (paramObject == null)
    {
      paramObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.widget.desktop.helper.QueryCacheConfig");
      AppMethodBeat.o(196543);
      throw paramObject;
    }
    if (!Arrays.equals(this.args, ((n)paramObject).args))
    {
      AppMethodBeat.o(196543);
      return false;
    }
    AppMethodBeat.o(196543);
    return true;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(196542);
    int i = toString().hashCode();
    AppMethodBeat.o(196542);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(196541);
    String str = e.a(this.args, null, null, null, 0, null, (b)a.lYb, 31);
    AppMethodBeat.o(196541);
    return str;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements b<Object, CharSequence>
  {
    public static final a lYb;
    
    static
    {
      AppMethodBeat.i(196540);
      lYb = new a();
      AppMethodBeat.o(196540);
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