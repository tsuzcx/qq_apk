package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Set;

final class g$1
  implements Runnable
{
  g$1(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(151827);
    if (g.a(this.nlu))
    {
      AppMethodBeat.o(151827);
      return;
    }
    g.b(this.nlu);
    if (g.c(this.nlu) <= g.access$200())
    {
      g.d(this.nlu).clear();
      g.d(this.nlu).addAll(g.e(this.nlu));
      g.e(this.nlu).clear();
      g.f(this.nlu);
      AppMethodBeat.o(151827);
      return;
    }
    ab.i("MicroMsg.GameUploadMediaEngine", "retry count bigger than 5");
    g.g(this.nlu);
    AppMethodBeat.o(151827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.g.1
 * JD-Core Version:    0.7.0.1
 */