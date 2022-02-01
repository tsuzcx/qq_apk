package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ar.a;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/EmojiSyncFetchList;", "", "customType", "", "(I)V", "TAG", "", "getCustomType", "()I", "start", "", "plugin-emojisdk_release"})
public final class f
{
  final String TAG;
  final int jNY;
  
  public f(int paramInt)
  {
    this.jNY = paramInt;
    this.TAG = "MicroMsg.EmojiSyncFetchList";
  }
  
  public final void start()
  {
    AppMethodBeat.i(237583);
    final ar.a locala2;
    if (this.jNY == 1) {
      locala2 = ar.a.VgO;
    }
    for (final ar.a locala1 = ar.a.VgS;; locala1 = ar.a.VgR)
    {
      new h(this.jNY, (m)new a(this, locala1, locala2));
      AppMethodBeat.o(237583);
      return;
      locala2 = ar.a.VgN;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "", "needInfoList", "", "", "invoke"})
  static final class a
    extends q
    implements m<Boolean, List<? extends String>, x>
  {
    a(f paramf, ar.a parama1, ar.a parama2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.f
 * JD-Core Version:    0.7.0.1
 */