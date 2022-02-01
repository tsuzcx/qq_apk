package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bj;

final class b$1
  implements com.tencent.mm.plugin.emoji.b.b
{
  b$1(b paramb) {}
  
  public final bf getEmojiDescMgr()
  {
    AppMethodBeat.i(108543);
    bf localbf = k.getEmojiDescMgr();
    AppMethodBeat.o(108543);
    return localbf;
  }
  
  public final d getEmojiMgr()
  {
    AppMethodBeat.i(108541);
    f localf = k.cGf();
    AppMethodBeat.o(108541);
    return localf;
  }
  
  public final bj getEmojiStorageMgr()
  {
    AppMethodBeat.i(108542);
    bj localbj = k.getEmojiStorageMgr();
    AppMethodBeat.o(108542);
    return localbj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.b.1
 * JD-Core Version:    0.7.0.1
 */