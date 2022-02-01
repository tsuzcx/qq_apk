package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bd;

public final class b
  extends t
{
  public b()
  {
    super(c.aNR("emoji"));
    AppMethodBeat.i(108544);
    com.tencent.mm.plugin.emoji.b.b.a.pCf = new com.tencent.mm.plugin.emoji.b.b()
    {
      public final az getEmojiDescMgr()
      {
        AppMethodBeat.i(108543);
        az localaz = k.getEmojiDescMgr();
        AppMethodBeat.o(108543);
        return localaz;
      }
      
      public final d getEmojiMgr()
      {
        AppMethodBeat.i(108541);
        f localf = k.cgQ();
        AppMethodBeat.o(108541);
        return localf;
      }
      
      public final bd getEmojiStorageMgr()
      {
        AppMethodBeat.i(108542);
        bd localbd = k.getEmojiStorageMgr();
        AppMethodBeat.o(108542);
        return localbd;
      }
    };
    AppMethodBeat.o(108544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.b
 * JD-Core Version:    0.7.0.1
 */