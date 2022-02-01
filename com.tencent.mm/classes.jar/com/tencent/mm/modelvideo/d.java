package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelvideo/CompositionVideoTranscoderCreator;", "", "()V", "creator", "Lcom/tencent/mm/modelvideo/CompositionVideoTranscoderFactory;", "getCreator", "()Lcom/tencent/mm/modelvideo/CompositionVideoTranscoderFactory;", "setCreator", "(Lcom/tencent/mm/modelvideo/CompositionVideoTranscoderFactory;)V", "create", "Lcom/tencent/mm/modelvideo/CompositionVideoTranscoder;", "plugin-videologic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d oYe;
  private static e oYf;
  
  static
  {
    AppMethodBeat.i(241176);
    oYe = new d();
    AppMethodBeat.o(241176);
  }
  
  public static void a(e parame)
  {
    oYf = parame;
  }
  
  public static final c bNM()
  {
    AppMethodBeat.i(241173);
    Object localObject = oYf;
    if (localObject == null)
    {
      localObject = new IllegalStateException("transcoder creator is null");
      AppMethodBeat.o(241173);
      throw ((Throwable)localObject);
    }
    localObject = ((e)localObject).bNN();
    AppMethodBeat.o(241173);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.d
 * JD-Core Version:    0.7.0.1
 */