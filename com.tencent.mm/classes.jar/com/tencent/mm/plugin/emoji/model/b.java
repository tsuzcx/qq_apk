package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.az;

public final class b
  extends t
{
  public b()
  {
    super(c.aIo("emoji"));
    AppMethodBeat.i(108544);
    com.tencent.mm.plugin.emoji.b.b.a.oYv = new com.tencent.mm.plugin.emoji.b.b()
    {
      public final av getEmojiDescMgr()
      {
        AppMethodBeat.i(108543);
        av localav = k.getEmojiDescMgr();
        AppMethodBeat.o(108543);
        return localav;
      }
      
      public final d getEmojiMgr()
      {
        AppMethodBeat.i(108541);
        f localf = k.ccm();
        AppMethodBeat.o(108541);
        return localf;
      }
      
      public final az getEmojiStorageMgr()
      {
        AppMethodBeat.i(108542);
        az localaz = k.getEmojiStorageMgr();
        AppMethodBeat.o(108542);
        return localaz;
      }
    };
    AppMethodBeat.o(108544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.b
 * JD-Core Version:    0.7.0.1
 */