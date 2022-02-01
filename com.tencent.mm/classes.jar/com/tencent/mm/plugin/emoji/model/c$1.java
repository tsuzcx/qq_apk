package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.c.b;
import com.tencent.mm.plugin.emoji.mgr.f;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;

final class c$1
  implements b
{
  c$1(c paramc) {}
  
  public final bh getEmojiDescMgr()
  {
    AppMethodBeat.i(108543);
    bh localbh = s.getEmojiDescMgr();
    AppMethodBeat.o(108543);
    return localbh;
  }
  
  public final d getEmojiMgr()
  {
    AppMethodBeat.i(108541);
    f localf = s.dAl();
    AppMethodBeat.o(108541);
    return localf;
  }
  
  public final bl getEmojiStorageMgr()
  {
    AppMethodBeat.i(108542);
    bl localbl = s.getEmojiStorageMgr();
    AppMethodBeat.o(108542);
    return localbl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.c.1
 * JD-Core Version:    0.7.0.1
 */