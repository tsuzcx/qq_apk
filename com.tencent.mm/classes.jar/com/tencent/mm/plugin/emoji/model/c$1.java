package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.b.b;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bj;

final class c$1
  implements b
{
  c$1(c paramc) {}
  
  public final bf getEmojiDescMgr()
  {
    AppMethodBeat.i(108543);
    bf localbf = p.getEmojiDescMgr();
    AppMethodBeat.o(108543);
    return localbf;
  }
  
  public final d getEmojiMgr()
  {
    AppMethodBeat.i(108541);
    f localf = p.cUO();
    AppMethodBeat.o(108541);
    return localf;
  }
  
  public final bj getEmojiStorageMgr()
  {
    AppMethodBeat.i(108542);
    bj localbj = p.getEmojiStorageMgr();
    AppMethodBeat.o(108542);
    return localbj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.c.1
 * JD-Core Version:    0.7.0.1
 */