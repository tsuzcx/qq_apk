package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/modelvideo/CompositionVideoTranscoderCreator;", "", "()V", "creator", "Lcom/tencent/mm/modelvideo/CompositionVideoTranscoderFactory;", "getCreator", "()Lcom/tencent/mm/modelvideo/CompositionVideoTranscoderFactory;", "setCreator", "(Lcom/tencent/mm/modelvideo/CompositionVideoTranscoderFactory;)V", "create", "Lcom/tencent/mm/modelvideo/CompositionVideoTranscoder;", "plugin-videologic_release"})
public final class d
{
  private static e mfl;
  public static final d mfm;
  
  static
  {
    AppMethodBeat.i(215622);
    mfm = new d();
    AppMethodBeat.o(215622);
  }
  
  public static void a(e parame)
  {
    mfl = parame;
  }
  
  public static final c bqg()
  {
    AppMethodBeat.i(215619);
    Object localObject = mfl;
    if (localObject != null)
    {
      localObject = ((e)localObject).bqh();
      AppMethodBeat.o(215619);
      return localObject;
    }
    localObject = (Throwable)new IllegalStateException("transcoder creator is null");
    AppMethodBeat.o(215619);
    throw ((Throwable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.d
 * JD-Core Version:    0.7.0.1
 */