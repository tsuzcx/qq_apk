package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.j;
import com.tencent.mm.emoji.a.j.b;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class g
  extends d
{
  public g(EmojiInfo paramEmojiInfo, boolean paramBoolean, d.a parama)
  {
    super(paramEmojiInfo, paramBoolean, parama);
    AppMethodBeat.i(104496);
    new j(paramEmojiInfo, paramBoolean, paramEmojiInfo.field_attachedText, paramEmojiInfo.fZZ(), paramEmojiInfo.field_imitateMd5).fNd = new j.b()
    {
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(104495);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          g.this.A(0, paramAnonymousString);
          AppMethodBeat.o(104495);
          return;
        }
        if (paramAnonymousBoolean)
        {
          g.this.lK(2);
          AppMethodBeat.o(104495);
          return;
        }
        g.this.lK(paramAnonymousInt2);
        AppMethodBeat.o(104495);
      }
    };
    AppMethodBeat.o(104496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.c.g
 * JD-Core Version:    0.7.0.1
 */