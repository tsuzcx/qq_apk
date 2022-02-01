package com.tencent.mm.media.j.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMConditionVariable;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/render/util/PreviewRenderSignal;", "", "()V", "TAG", "", "isRendering", "Lcom/tencent/mm/sdk/platformtools/MMConditionVariable;", "markRendering", "", "rendering", "", "waitRenderFinished", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a nFo;
  private static final MMConditionVariable nFp;
  
  static
  {
    AppMethodBeat.i(237738);
    nFo = new a();
    nFp = new MMConditionVariable();
    AppMethodBeat.o(237738);
  }
  
  public static void bqh()
  {
    AppMethodBeat.i(237737);
    synchronized (nFp)
    {
      nFp.block();
      ah localah = ah.aiuX;
      AppMethodBeat.o(237737);
      return;
    }
  }
  
  public static void gt(boolean paramBoolean)
  {
    AppMethodBeat.i(237734);
    MMConditionVariable localMMConditionVariable = nFp;
    if (paramBoolean) {}
    try
    {
      nFp.close();
      for (;;)
      {
        ah localah = ah.aiuX;
        return;
        nFp.open();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.PreviewRenderSignal", (Throwable)localException, "markRendering error", new Object[0]);
      }
    }
    finally
    {
      AppMethodBeat.o(237734);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.j.c.a
 * JD-Core Version:    0.7.0.1
 */