package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.be;

public final class b
  extends u
{
  public b()
  {
    super(c.aPo("emoji"));
    AppMethodBeat.i(108544);
    com.tencent.mm.plugin.emoji.b.b.a.pIJ = new com.tencent.mm.plugin.emoji.b.b()
    {
      public final ba getEmojiDescMgr()
      {
        AppMethodBeat.i(108543);
        ba localba = k.getEmojiDescMgr();
        AppMethodBeat.o(108543);
        return localba;
      }
      
      public final d getEmojiMgr()
      {
        AppMethodBeat.i(108541);
        f localf = k.cig();
        AppMethodBeat.o(108541);
        return localf;
      }
      
      public final be getEmojiStorageMgr()
      {
        AppMethodBeat.i(108542);
        be localbe = k.getEmojiStorageMgr();
        AppMethodBeat.o(108542);
        return localbe;
      }
    };
    AppMethodBeat.o(108544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.b
 * JD-Core Version:    0.7.0.1
 */