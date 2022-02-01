package com.tencent.mm.plugin.appbrand.ag.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/depend_exo/FinalUrlAccessibleInputStream;", "Ljava/io/FilterInputStream;", "dataSource", "Lcom/tencent/mm/plugin/appbrand/video/depend_exo/FinalUrlAccessibleDataSource;", "realInputStream", "Ljava/io/InputStream;", "(Lcom/tencent/mm/plugin/appbrand/video/depend_exo/FinalUrlAccessibleDataSource;Ljava/io/InputStream;)V", "getFinalUrl", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends FilterInputStream
{
  public static final c.a usq;
  private static final b<String, c> uss;
  public final a usr;
  
  static
  {
    AppMethodBeat.i(318058);
    usq = new c.a((byte)0);
    uss = (b)b.ust;
    AppMethodBeat.o(318058);
  }
  
  private c(a parama, InputStream paramInputStream)
  {
    super(paramInputStream);
    this.usr = parama;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/video/depend_exo/FinalUrlAccessibleInputStream;", "src", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<String, c>
  {
    public static final b ust;
    
    static
    {
      AppMethodBeat.i(318063);
      ust = new b();
      AppMethodBeat.o(318063);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.a.c
 * JD-Core Version:    0.7.0.1
 */