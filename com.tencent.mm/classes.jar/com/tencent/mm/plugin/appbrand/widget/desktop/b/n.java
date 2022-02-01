package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.g.a.b;
import d.g.b.q;
import d.l;
import d.v;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "", "args", "", "([Ljava/lang/Object;)V", "getArgs", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "toString", "", "plugin-appbrand-integration_release"})
public class n
{
  final Object[] args;
  
  public n(Object... paramVarArgs)
  {
    AppMethodBeat.i(224008);
    this.args = paramVarArgs;
    AppMethodBeat.o(224008);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(224007);
    if ((n)this == paramObject)
    {
      AppMethodBeat.o(224007);
      return true;
    }
    if (paramObject == null)
    {
      paramObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.widget.desktop.helper.QueryCacheConfig");
      AppMethodBeat.o(224007);
      throw paramObject;
    }
    if (!Arrays.equals(this.args, ((n)paramObject).args))
    {
      AppMethodBeat.o(224007);
      return false;
    }
    AppMethodBeat.o(224007);
    return true;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(224006);
    int i = toString().hashCode();
    AppMethodBeat.o(224006);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(224005);
    String str = e.a(this.args, null, null, null, 0, null, (b)a.nfT, 31);
    AppMethodBeat.o(224005);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements b<Object, CharSequence>
  {
    public static final a nfT;
    
    static
    {
      AppMethodBeat.i(224004);
      nfT = new a();
      AppMethodBeat.o(224004);
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