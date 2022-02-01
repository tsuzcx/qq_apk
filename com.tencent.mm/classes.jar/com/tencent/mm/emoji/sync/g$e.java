package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$ConfigProvider;", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$IConfigProvider;", "()V", "getSyncMinCount", "", "getSyncNotifyCount", "nextSyncCount", "current", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
final class g$e
  implements g.g
{
  public final int aWu()
  {
    AppMethodBeat.i(242612);
    int i = ((c)h.ax(c.class)).a(c.a.yRH, 300);
    AppMethodBeat.o(242612);
    return i;
  }
  
  public final int aWv()
  {
    return 5;
  }
  
  public final int rP(int paramInt)
  {
    AppMethodBeat.i(242613);
    int i = ((c)h.ax(c.class)).a(c.a.yRI, 120);
    AppMethodBeat.o(242613);
    return i + paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.g.e
 * JD-Core Version:    0.7.0.1
 */