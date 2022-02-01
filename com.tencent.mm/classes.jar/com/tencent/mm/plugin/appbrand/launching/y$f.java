package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "", "()V", "CACHED", "REMOTE", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE$CACHED;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE$REMOTE;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class y$f
{
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE$CACHED;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "reason", "", "(I)V", "getReason", "()I", "toString", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends y.f
  {
    public static final a tac;
    final int reason;
    
    static
    {
      AppMethodBeat.i(320887);
      tac = new a((byte)0);
      AppMethodBeat.o(320887);
    }
    
    public a(int paramInt)
    {
      super();
      this.reason = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(320892);
      StringBuilder localStringBuilder = new StringBuilder("CACHED(");
      String str;
      switch (this.reason)
      {
      default: 
        str = "";
      }
      for (;;)
      {
        str = str + ')';
        AppMethodBeat.o(320892);
        return str;
        str = "SELF";
        continue;
        str = "SHARED_MODULE";
        continue;
        str = "SHARED_TEMPLATE";
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE$CACHED$Companion;", "", "()V", "SELF", "", "SHARED_MODULE", "SHARED_TEMPLATE", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE$REMOTE;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "()V", "toString", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends y.f
  {
    public static final b tad;
    
    static
    {
      AppMethodBeat.i(320880);
      tad = new b();
      AppMethodBeat.o(320880);
    }
    
    private b()
    {
      super();
    }
    
    public final String toString()
    {
      return "REMOTE";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.y.f
 * JD-Core Version:    0.7.0.1
 */