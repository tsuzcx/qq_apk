package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.aw;

public final class b
  extends t
{
  public b()
  {
    super(c.aCX("emoji"));
    AppMethodBeat.i(108544);
    com.tencent.mm.plugin.emoji.b.b.a.ouV = new com.tencent.mm.plugin.emoji.b.b()
    {
      public final as getEmojiDescMgr()
      {
        AppMethodBeat.i(108543);
        as localas = k.getEmojiDescMgr();
        AppMethodBeat.o(108543);
        return localas;
      }
      
      public final d getEmojiMgr()
      {
        AppMethodBeat.i(108541);
        f localf = k.bUZ();
        AppMethodBeat.o(108541);
        return localf;
      }
      
      public final aw getEmojiStorageMgr()
      {
        AppMethodBeat.i(108542);
        aw localaw = k.getEmojiStorageMgr();
        AppMethodBeat.o(108542);
        return localaw;
      }
    };
    AppMethodBeat.o(108544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.b
 * JD-Core Version:    0.7.0.1
 */