package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.e.h;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at;

final class b$1
  implements com.tencent.mm.plugin.emoji.b.b
{
  b$1(b paramb) {}
  
  public final aq getEmojiDescMgr()
  {
    AppMethodBeat.i(52996);
    aq localaq = i.getEmojiDescMgr();
    AppMethodBeat.o(52996);
    return localaq;
  }
  
  public final d getEmojiMgr()
  {
    AppMethodBeat.i(52994);
    h localh = i.blp();
    AppMethodBeat.o(52994);
    return localh;
  }
  
  public final at getEmojiStorageMgr()
  {
    AppMethodBeat.i(52995);
    at localat = i.getEmojiStorageMgr();
    AppMethodBeat.o(52995);
    return localat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.b.1
 * JD-Core Version:    0.7.0.1
 */