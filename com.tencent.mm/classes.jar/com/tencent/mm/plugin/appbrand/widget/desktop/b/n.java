package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.g.a.b;
import d.v;
import java.util.Arrays;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/QueryCacheConfig;", "", "args", "", "([Ljava/lang/Object;)V", "getArgs", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "toString", "", "plugin-appbrand-integration_release"})
public class n
{
  final Object[] args;
  
  public n(Object... paramVarArgs)
  {
    AppMethodBeat.i(187505);
    this.args = paramVarArgs;
    AppMethodBeat.o(187505);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(187504);
    if ((n)this == paramObject)
    {
      AppMethodBeat.o(187504);
      return true;
    }
    if (paramObject == null)
    {
      paramObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.widget.desktop.helper.QueryCacheConfig");
      AppMethodBeat.o(187504);
      throw paramObject;
    }
    if (!Arrays.equals(this.args, ((n)paramObject).args))
    {
      AppMethodBeat.o(187504);
      return false;
    }
    AppMethodBeat.o(187504);
    return true;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(187503);
    int i = toString().hashCode();
    AppMethodBeat.o(187503);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(187502);
    String str = e.a(this.args, null, null, null, 0, null, (b)a.mAd, 31);
    AppMethodBeat.o(187502);
    return str;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements b<Object, CharSequence>
  {
    public static final a mAd;
    
    static
    {
      AppMethodBeat.i(187501);
      mAd = new a();
      AppMethodBeat.o(187501);
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