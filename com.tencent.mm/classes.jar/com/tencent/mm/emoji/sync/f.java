package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.at.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiSyncFetchList;", "", "customType", "", "(I)V", "TAG", "", "getCustomType", "()I", "start", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  final String TAG;
  final int mmT;
  
  public f(int paramInt)
  {
    this.mmT = paramInt;
    this.TAG = "MicroMsg.EmojiSyncFetchList";
  }
  
  public final void start()
  {
    AppMethodBeat.i(242565);
    final at.a locala2;
    if (this.mmT == 1) {
      locala2 = at.a.acIe;
    }
    for (at.a locala1 = at.a.acIj;; locala1 = at.a.acIi)
    {
      new h(this.mmT, (m)new a(locala1, locala2, this));
      AppMethodBeat.o(242565);
      return;
      locala2 = at.a.acId;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "", "needInfoList", "", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<Boolean, List<? extends String>, ah>
  {
    a(at.a parama1, at.a parama2, f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.f
 * JD-Core Version:    0.7.0.1
 */