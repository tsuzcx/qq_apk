package com.tencent.mm.plugin.appbrand.widget.recent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/recent/QueryCacheConfig;", "", "args", "", "([Ljava/lang/Object;)V", "getArgs", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "toString", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public class l
{
  final Object[] args;
  
  public l(Object... paramVarArgs)
  {
    AppMethodBeat.i(324035);
    this.args = paramVarArgs;
    AppMethodBeat.o(324035);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(324052);
    if (this == paramObject)
    {
      AppMethodBeat.o(324052);
      return true;
    }
    if (paramObject == null)
    {
      paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.widget.recent.QueryCacheConfig");
      AppMethodBeat.o(324052);
      throw paramObject;
    }
    if (!Arrays.equals(this.args, ((l)paramObject).args))
    {
      AppMethodBeat.o(324052);
      return false;
    }
    AppMethodBeat.o(324052);
    return true;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(324045);
    int i = toString().hashCode();
    AppMethodBeat.o(324045);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(324041);
    String str = k.a(this.args, null, null, null, 0, null, (b)a.uQG, 31);
    AppMethodBeat.o(324041);
    return str;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<Object, CharSequence>
  {
    public static final a uQG;
    
    static
    {
      AppMethodBeat.i(323995);
      uQG = new a();
      AppMethodBeat.o(323995);
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