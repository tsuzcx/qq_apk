package com.tencent.mm.mj_template.album_template;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/album_template/MaasImageLoader;", "", "()V", "cover", "Lcom/tencent/mm/loader/DefaultImageLoader;", "getCover", "()Lcom/tencent/mm/loader/DefaultImageLoader;", "cover$delegate", "Lkotlin/Lazy;", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final int Ue;
  private static final j nWA;
  public static final e nWz;
  
  static
  {
    AppMethodBeat.i(240430);
    nWz = new e();
    nWA = k.cm((kotlin.g.a.a)a.nWB);
    Ue = 8;
    AppMethodBeat.o(240430);
  }
  
  public static com.tencent.mm.loader.a bwR()
  {
    AppMethodBeat.i(240426);
    com.tencent.mm.loader.a locala = (com.tencent.mm.loader.a)nWA.getValue();
    AppMethodBeat.o(240426);
    return locala;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/loader/DefaultImageLoader;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<com.tencent.mm.loader.a>
  {
    public static final a nWB;
    
    static
    {
      AppMethodBeat.i(240486);
      nWB = new a();
      AppMethodBeat.o(240486);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.e
 * JD-Core Version:    0.7.0.1
 */